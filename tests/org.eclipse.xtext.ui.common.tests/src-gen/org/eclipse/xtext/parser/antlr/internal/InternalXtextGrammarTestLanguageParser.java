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
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextGrammarTestLanguageParser extends AbstractInternalAntlrParser {
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

        public InternalXtextGrammarTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g"; }


     
     	private XtextGrammarTestLanguageGrammarAccess grammarAccess;
     	
        public InternalXtextGrammarTestLanguageParser(TokenStream input, IAstFactory factory, XtextGrammarTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Grammar";	
       	} 



    // $ANTLR start entryRuleGrammar
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:72:1: entryRuleGrammar returns [EObject current=null] : iv_ruleGrammar= ruleGrammar EOF ;
    public final EObject entryRuleGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammar = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:72:49: (iv_ruleGrammar= ruleGrammar EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:73:2: iv_ruleGrammar= ruleGrammar EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGrammarRule(), currentNode); 
            pushFollow(FOLLOW_ruleGrammar_in_entryRuleGrammar73);
            iv_ruleGrammar=ruleGrammar();
            _fsp--;

             current =iv_ruleGrammar; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGrammar83); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:80:1: ruleGrammar returns [EObject current=null] : ( 'grammar' (lv_name_1= ruleGrammarID ) ( 'with' ( ruleGrammarID ) ( ',' ( ruleGrammarID ) )* )? ( (lv_definesHiddenTokens_6= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? (lv_metamodelDeclarations_12= ruleAbstractMetamodelDeclaration )* (lv_rules_13= ruleAbstractRule )+ ) ;
    public final EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        Token lv_definesHiddenTokens_6=null;
        AntlrDatatypeRuleToken lv_name_1 = null;

        EObject lv_metamodelDeclarations_12 = null;

        EObject lv_rules_13 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:85:6: ( ( 'grammar' (lv_name_1= ruleGrammarID ) ( 'with' ( ruleGrammarID ) ( ',' ( ruleGrammarID ) )* )? ( (lv_definesHiddenTokens_6= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? (lv_metamodelDeclarations_12= ruleAbstractMetamodelDeclaration )* (lv_rules_13= ruleAbstractRule )+ ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:86:1: ( 'grammar' (lv_name_1= ruleGrammarID ) ( 'with' ( ruleGrammarID ) ( ',' ( ruleGrammarID ) )* )? ( (lv_definesHiddenTokens_6= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? (lv_metamodelDeclarations_12= ruleAbstractMetamodelDeclaration )* (lv_rules_13= ruleAbstractRule )+ )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:86:1: ( 'grammar' (lv_name_1= ruleGrammarID ) ( 'with' ( ruleGrammarID ) ( ',' ( ruleGrammarID ) )* )? ( (lv_definesHiddenTokens_6= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? (lv_metamodelDeclarations_12= ruleAbstractMetamodelDeclaration )* (lv_rules_13= ruleAbstractRule )+ )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:86:2: 'grammar' (lv_name_1= ruleGrammarID ) ( 'with' ( ruleGrammarID ) ( ',' ( ruleGrammarID ) )* )? ( (lv_definesHiddenTokens_6= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? (lv_metamodelDeclarations_12= ruleAbstractMetamodelDeclaration )* (lv_rules_13= ruleAbstractRule )+
            {
            match(input,11,FOLLOW_11_in_ruleGrammar117); 

                    createLeafNode(grammarAccess.getGrammarAccess().getGrammarKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:90:1: (lv_name_1= ruleGrammarID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:93:6: lv_name_1= ruleGrammarID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleGrammarID_in_ruleGrammar151);
            lv_name_1=ruleGrammarID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "GrammarID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:111:2: ( 'with' ( ruleGrammarID ) ( ',' ( ruleGrammarID ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:111:3: 'with' ( ruleGrammarID ) ( ',' ( ruleGrammarID ) )*
                    {
                    match(input,12,FOLLOW_12_in_ruleGrammar165); 

                            createLeafNode(grammarAccess.getGrammarAccess().getWithKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:115:1: ( ruleGrammarID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:118:3: ruleGrammarID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleGrammarID_in_ruleGrammar192);
                    ruleGrammarID();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    
                     lastConsumedDatatypeToken = null; 

                    }

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:134:2: ( ',' ( ruleGrammarID ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:134:3: ',' ( ruleGrammarID )
                    	    {
                    	    match(input,13,FOLLOW_13_in_ruleGrammar209); 

                    	            createLeafNode(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:138:1: ( ruleGrammarID )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:141:3: ruleGrammarID
                    	    {

                    	    			if (current==null) {
                    	    	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	            
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleGrammarID_in_ruleGrammar236);
                    	    ruleGrammarID();
                    	    _fsp--;

                    	     
                    	    	        currentNode = currentNode.getParent();
                    	    	    
                    	     lastConsumedDatatypeToken = null; 

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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:157:6: ( (lv_definesHiddenTokens_6= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:157:7: (lv_definesHiddenTokens_6= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')'
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:157:7: (lv_definesHiddenTokens_6= 'hidden' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:159:6: lv_definesHiddenTokens_6= 'hidden'
                    {
                    lv_definesHiddenTokens_6=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleGrammar269); 

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

                    match(input,15,FOLLOW_15_in_ruleGrammar291); 

                            createLeafNode(grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:182:1: ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:182:2: ( RULE_ID ) ( ',' ( RULE_ID ) )*
                            {
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:182:2: ( RULE_ID )
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:185:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar314); 

                            		createLeafNode(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0(), "hiddenTokens"); 
                            	
                             lastConsumedDatatypeToken = null; 

                            }

                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:199:2: ( ',' ( RULE_ID ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==13) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:199:3: ',' ( RULE_ID )
                            	    {
                            	    match(input,13,FOLLOW_13_in_ruleGrammar331); 

                            	            createLeafNode(grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0(), null); 
                            	        
                            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:203:1: ( RULE_ID )
                            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:206:3: RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar353); 

                            	    		createLeafNode(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0(), "hiddenTokens"); 
                            	    	
                            	     lastConsumedDatatypeToken = null; 

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

                    match(input,16,FOLLOW_16_in_ruleGrammar373); 

                            createLeafNode(grammarAccess.getGrammarAccess().getRightParenthesisKeyword_3_3(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:224:3: (lv_metamodelDeclarations_12= ruleAbstractMetamodelDeclaration )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18||LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:227:6: lv_metamodelDeclarations_12= ruleAbstractMetamodelDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar409);
            	    lv_metamodelDeclarations_12=ruleAbstractMetamodelDeclaration();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "metamodelDeclarations", lv_metamodelDeclarations_12, "AbstractMetamodelDeclaration", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:245:3: (lv_rules_13= ruleAbstractRule )+
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
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:248:6: lv_rules_13= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleGrammar448);
            	    lv_rules_13=ruleAbstractRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "rules", lv_rules_13, "AbstractRule", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:273:1: entryRuleGrammarID returns [String current=null] : iv_ruleGrammarID= ruleGrammarID EOF ;
    public final String entryRuleGrammarID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGrammarID = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:273:50: (iv_ruleGrammarID= ruleGrammarID EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:274:2: iv_ruleGrammarID= ruleGrammarID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGrammarIDRule(), currentNode); 
            pushFollow(FOLLOW_ruleGrammarID_in_entryRuleGrammarID487);
            iv_ruleGrammarID=ruleGrammarID();
            _fsp--;

             current =iv_ruleGrammarID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGrammarID498); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:281:1: ruleGrammarID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleGrammarID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:287:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:288:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:288:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:288:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammarID538); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:295:1: (kw= '.' this_ID_2= RULE_ID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:296:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,17,FOLLOW_17_in_ruleGrammarID557); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammarID572); 

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
            	    lastConsumedDatatypeToken = current;
                
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:316:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:316:54: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:317:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule617);
            iv_ruleAbstractRule=ruleAbstractRule();
            _fsp--;

             current =iv_ruleAbstractRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRule627); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:324:1: ruleAbstractRule returns [EObject current=null] : (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_ParserRule_0 = null;

        EObject this_TerminalRule_1 = null;

        EObject this_EnumRule_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:329:6: ( (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:330:1: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:330:1: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )
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
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:331:5: this_ParserRule_0= ruleParserRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParserRule_in_ruleAbstractRule674);
                    this_ParserRule_0=ruleParserRule();
                    _fsp--;

                     
                            current = this_ParserRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:341:5: this_TerminalRule_1= ruleTerminalRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTerminalRule_in_ruleAbstractRule701);
                    this_TerminalRule_1=ruleTerminalRule();
                    _fsp--;

                     
                            current = this_TerminalRule_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:351:5: this_EnumRule_2= ruleEnumRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEnumRule_in_ruleAbstractRule728);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:366:1: entryRuleAbstractMetamodelDeclaration returns [EObject current=null] : iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF ;
    public final EObject entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractMetamodelDeclaration = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:366:70: (iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:367:2: iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractMetamodelDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration760);
            iv_ruleAbstractMetamodelDeclaration=ruleAbstractMetamodelDeclaration();
            _fsp--;

             current =iv_ruleAbstractMetamodelDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration770); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:374:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) ;
    public final EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel_0 = null;

        EObject this_ReferencedMetamodel_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:379:6: ( (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:380:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:380:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
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
                    new NoViableAltException("380:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:381:5: this_GeneratedMetamodel_0= ruleGeneratedMetamodel
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration817);
                    this_GeneratedMetamodel_0=ruleGeneratedMetamodel();
                    _fsp--;

                     
                            current = this_GeneratedMetamodel_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:391:5: this_ReferencedMetamodel_1= ruleReferencedMetamodel
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration844);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:406:1: entryRuleGeneratedMetamodel returns [EObject current=null] : iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF ;
    public final EObject entryRuleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratedMetamodel = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:406:60: (iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:407:2: iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGeneratedMetamodelRule(), currentNode); 
            pushFollow(FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel876);
            iv_ruleGeneratedMetamodel=ruleGeneratedMetamodel();
            _fsp--;

             current =iv_ruleGeneratedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGeneratedMetamodel886); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:414:1: ruleGeneratedMetamodel returns [EObject current=null] : ( 'generate' (lv_name_1= RULE_ID ) ( RULE_STRING ) ( 'as' (lv_alias_4= RULE_ID ) )? ) ;
    public final EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_alias_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:419:6: ( ( 'generate' (lv_name_1= RULE_ID ) ( RULE_STRING ) ( 'as' (lv_alias_4= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:420:1: ( 'generate' (lv_name_1= RULE_ID ) ( RULE_STRING ) ( 'as' (lv_alias_4= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:420:1: ( 'generate' (lv_name_1= RULE_ID ) ( RULE_STRING ) ( 'as' (lv_alias_4= RULE_ID ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:420:2: 'generate' (lv_name_1= RULE_ID ) ( RULE_STRING ) ( 'as' (lv_alias_4= RULE_ID ) )?
            {
            match(input,18,FOLLOW_18_in_ruleGeneratedMetamodel920); 

                    createLeafNode(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:424:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:426:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel942); 

            		createLeafNode(grammarAccess.getGeneratedMetamodelAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getGeneratedMetamodelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:444:2: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:447:3: RULE_STRING
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getGeneratedMetamodelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel972); 

            		createLeafNode(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0(), "ePackage"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:461:2: ( 'as' (lv_alias_4= RULE_ID ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:461:3: 'as' (lv_alias_4= RULE_ID )
                    {
                    match(input,19,FOLLOW_19_in_ruleGeneratedMetamodel989); 

                            createLeafNode(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:465:1: (lv_alias_4= RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:467:6: lv_alias_4= RULE_ID
                    {
                    lv_alias_4=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel1011); 

                    		createLeafNode(grammarAccess.getGeneratedMetamodelAccess().getAliasIDTerminalRuleCall_3_1_0(), "alias"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getGeneratedMetamodelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "alias", lv_alias_4, "ID", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:492:1: entryRuleReferencedMetamodel returns [EObject current=null] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final EObject entryRuleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedMetamodel = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:492:61: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:493:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferencedMetamodelRule(), currentNode); 
            pushFollow(FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel1054);
            iv_ruleReferencedMetamodel=ruleReferencedMetamodel();
            _fsp--;

             current =iv_ruleReferencedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencedMetamodel1064); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:500:1: ruleReferencedMetamodel returns [EObject current=null] : ( 'import' ( RULE_STRING ) ( 'as' (lv_alias_3= RULE_ID ) )? ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_alias_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:505:6: ( ( 'import' ( RULE_STRING ) ( 'as' (lv_alias_3= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:506:1: ( 'import' ( RULE_STRING ) ( 'as' (lv_alias_3= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:506:1: ( 'import' ( RULE_STRING ) ( 'as' (lv_alias_3= RULE_ID ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:506:2: 'import' ( RULE_STRING ) ( 'as' (lv_alias_3= RULE_ID ) )?
            {
            match(input,20,FOLLOW_20_in_ruleReferencedMetamodel1098); 

                    createLeafNode(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:510:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:513:3: RULE_STRING
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferencedMetamodelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1120); 

            		createLeafNode(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0(), "ePackage"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:527:2: ( 'as' (lv_alias_3= RULE_ID ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:527:3: 'as' (lv_alias_3= RULE_ID )
                    {
                    match(input,19,FOLLOW_19_in_ruleReferencedMetamodel1137); 

                            createLeafNode(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:531:1: (lv_alias_3= RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:533:6: lv_alias_3= RULE_ID
                    {
                    lv_alias_3=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedMetamodel1159); 

                    		createLeafNode(grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_2_1_0(), "alias"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getReferencedMetamodelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "alias", lv_alias_3, "ID", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:558:1: entryRuleParserRule returns [EObject current=null] : iv_ruleParserRule= ruleParserRule EOF ;
    public final EObject entryRuleParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRule = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:558:52: (iv_ruleParserRule= ruleParserRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:559:2: iv_ruleParserRule= ruleParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParserRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleParserRule_in_entryRuleParserRule1202);
            iv_ruleParserRule=ruleParserRule();
            _fsp--;

             current =iv_ruleParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParserRule1212); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:566:1: ruleParserRule returns [EObject current=null] : ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? ':' (lv_alternatives_10= ruleAlternatives ) ';' ) ;
    public final EObject ruleParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        Token lv_definesHiddenTokens_3=null;
        EObject lv_type_2 = null;

        EObject lv_alternatives_10 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:571:6: ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? ':' (lv_alternatives_10= ruleAlternatives ) ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:572:1: ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? ':' (lv_alternatives_10= ruleAlternatives ) ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:572:1: ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? ':' (lv_alternatives_10= ruleAlternatives ) ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:572:2: (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? ':' (lv_alternatives_10= ruleAlternatives ) ';'
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:572:2: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:574:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1259); 

            		createLeafNode(grammarAccess.getParserRuleAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getParserRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:592:2: ( 'returns' (lv_type_2= ruleTypeRef ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==21) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:592:3: 'returns' (lv_type_2= ruleTypeRef )
                    {
                    match(input,21,FOLLOW_21_in_ruleParserRule1277); 

                            createLeafNode(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:596:1: (lv_type_2= ruleTypeRef )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:599:6: lv_type_2= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleParserRule1311);
                    lv_type_2=ruleTypeRef();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getParserRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "type", lv_type_2, "TypeRef", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:617:4: ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:617:5: (lv_definesHiddenTokens_3= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')'
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:617:5: (lv_definesHiddenTokens_3= 'hidden' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:619:6: lv_definesHiddenTokens_3= 'hidden'
                    {
                    lv_definesHiddenTokens_3=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleParserRule1339); 

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

                    match(input,15,FOLLOW_15_in_ruleParserRule1361); 

                            createLeafNode(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:642:1: ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_ID) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:642:2: ( RULE_ID ) ( ',' ( RULE_ID ) )*
                            {
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:642:2: ( RULE_ID )
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:645:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.getParserRuleRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1384); 

                            		createLeafNode(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0(), "hiddenTokens"); 
                            	
                             lastConsumedDatatypeToken = null; 

                            }

                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:659:2: ( ',' ( RULE_ID ) )*
                            loop14:
                            do {
                                int alt14=2;
                                int LA14_0 = input.LA(1);

                                if ( (LA14_0==13) ) {
                                    alt14=1;
                                }


                                switch (alt14) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:659:3: ',' ( RULE_ID )
                            	    {
                            	    match(input,13,FOLLOW_13_in_ruleParserRule1401); 

                            	            createLeafNode(grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0(), null); 
                            	        
                            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:663:1: ( RULE_ID )
                            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:666:3: RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create(grammarAccess.getParserRuleRule().getType().getClassifier());
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1423); 

                            	    		createLeafNode(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0(), "hiddenTokens"); 
                            	    	
                            	     lastConsumedDatatypeToken = null; 

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

                    match(input,16,FOLLOW_16_in_ruleParserRule1443); 

                            createLeafNode(grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_2_3(), null); 
                        

                    }
                    break;

            }

            match(input,22,FOLLOW_22_in_ruleParserRule1454); 

                    createLeafNode(grammarAccess.getParserRuleAccess().getColonKeyword_3(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:688:1: (lv_alternatives_10= ruleAlternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:691:6: lv_alternatives_10= ruleAlternatives
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParserRule1488);
            lv_alternatives_10=ruleAlternatives();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getParserRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "alternatives", lv_alternatives_10, "Alternatives", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,23,FOLLOW_23_in_ruleParserRule1501); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:720:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:720:49: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:721:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRefRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef1534);
            iv_ruleTypeRef=ruleTypeRef();
            _fsp--;

             current =iv_ruleTypeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef1544); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:728:1: ruleTypeRef returns [EObject current=null] : ( ( ( RULE_ID ) '::' )? ( RULE_ID ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:733:6: ( ( ( ( RULE_ID ) '::' )? ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:734:1: ( ( ( RULE_ID ) '::' )? ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:734:1: ( ( ( RULE_ID ) '::' )? ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:734:2: ( ( RULE_ID ) '::' )? ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:734:2: ( ( RULE_ID ) '::' )?
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
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:734:3: ( RULE_ID ) '::'
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:734:3: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:737:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef1592); 

                    		createLeafNode(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0(), "metamodel"); 
                    	
                     lastConsumedDatatypeToken = null; 

                    }

                    match(input,24,FOLLOW_24_in_ruleTypeRef1608); 

                            createLeafNode(grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:755:3: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:758:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getTypeRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef1632); 

            		createLeafNode(grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0(), "classifier"); 
            	
             lastConsumedDatatypeToken = null; 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:779:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:779:54: (iv_ruleAlternatives= ruleAlternatives EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:780:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAlternativesRule(), currentNode); 
            pushFollow(FOLLOW_ruleAlternatives_in_entryRuleAlternatives1672);
            iv_ruleAlternatives=ruleAlternatives();
            _fsp--;

             current =iv_ruleAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternatives1682); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:787:1: ruleAlternatives returns [EObject current=null] : (this_Group_0= ruleGroup ( () ( '|' (lv_groups_3= ruleGroup ) )+ )? ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_Group_0 = null;

        EObject lv_groups_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:792:6: ( (this_Group_0= ruleGroup ( () ( '|' (lv_groups_3= ruleGroup ) )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:793:1: (this_Group_0= ruleGroup ( () ( '|' (lv_groups_3= ruleGroup ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:793:1: (this_Group_0= ruleGroup ( () ( '|' (lv_groups_3= ruleGroup ) )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:794:5: this_Group_0= ruleGroup ( () ( '|' (lv_groups_3= ruleGroup ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAlternativesAccess().getGroupParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives1729);
            this_Group_0=ruleGroup();
            _fsp--;

             
                    current = this_Group_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:802:1: ( () ( '|' (lv_groups_3= ruleGroup ) )+ )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==25) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:802:2: () ( '|' (lv_groups_3= ruleGroup ) )+
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:802:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:803:5: 
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

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:818:2: ( '|' (lv_groups_3= ruleGroup ) )+
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:818:3: '|' (lv_groups_3= ruleGroup )
                    	    {
                    	    match(input,25,FOLLOW_25_in_ruleAlternatives1748); 

                    	            createLeafNode(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:822:1: (lv_groups_3= ruleGroup )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:825:6: lv_groups_3= ruleGroup
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAlternativesAccess().getGroupsGroupParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives1782);
                    	    lv_groups_3=ruleGroup();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAlternativesRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "groups", lv_groups_3, "Group", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:850:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:850:47: (iv_ruleGroup= ruleGroup EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:851:2: iv_ruleGroup= ruleGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGroupRule(), currentNode); 
            pushFollow(FOLLOW_ruleGroup_in_entryRuleGroup1823);
            iv_ruleGroup=ruleGroup();
            _fsp--;

             current =iv_ruleGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroup1833); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:858:1: ruleGroup returns [EObject current=null] : (this_AbstractToken_0= ruleAbstractToken ( () (lv_tokens_2= ruleAbstractToken )+ )? ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken_0 = null;

        EObject lv_tokens_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:863:6: ( (this_AbstractToken_0= ruleAbstractToken ( () (lv_tokens_2= ruleAbstractToken )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:864:1: (this_AbstractToken_0= ruleAbstractToken ( () (lv_tokens_2= ruleAbstractToken )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:864:1: (this_AbstractToken_0= ruleAbstractToken ( () (lv_tokens_2= ruleAbstractToken )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:865:5: this_AbstractToken_0= ruleAbstractToken ( () (lv_tokens_2= ruleAbstractToken )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup1880);
            this_AbstractToken_0=ruleAbstractToken();
            _fsp--;

             
                    current = this_AbstractToken_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:873:1: ( () (lv_tokens_2= ruleAbstractToken )+ )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_STRING)||LA21_0==15||LA21_0==29) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:873:2: () (lv_tokens_2= ruleAbstractToken )+
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:873:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:874:5: 
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

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:889:2: (lv_tokens_2= ruleAbstractToken )+
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:892:6: lv_tokens_2= ruleAbstractToken
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getGroupAccess().getTokensAbstractTokenParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup1923);
                    	    lv_tokens_2=ruleAbstractToken();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getGroupRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "tokens", lv_tokens_2, "AbstractToken", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:917:1: entryRuleAbstractToken returns [EObject current=null] : iv_ruleAbstractToken= ruleAbstractToken EOF ;
    public final EObject entryRuleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractToken = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:917:55: (iv_ruleAbstractToken= ruleAbstractToken EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:918:2: iv_ruleAbstractToken= ruleAbstractToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractTokenRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken1963);
            iv_ruleAbstractToken=ruleAbstractToken();
            _fsp--;

             current =iv_ruleAbstractToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractToken1973); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:925:1: ruleAbstractToken returns [EObject current=null] : (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction ) ;
    public final EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractTokenWithCardinality_0 = null;

        EObject this_Action_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:930:6: ( (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:931:1: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:931:1: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )
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
                    new NoViableAltException("931:1: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:932:5: this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractTokenWithCardinality_in_ruleAbstractToken2020);
                    this_AbstractTokenWithCardinality_0=ruleAbstractTokenWithCardinality();
                    _fsp--;

                     
                            current = this_AbstractTokenWithCardinality_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:942:5: this_Action_1= ruleAction
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAction_in_ruleAbstractToken2047);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:957:1: entryRuleAbstractTokenWithCardinality returns [EObject current=null] : iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF ;
    public final EObject entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTokenWithCardinality = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:957:70: (iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:958:2: iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractTokenWithCardinalityRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality2079);
            iv_ruleAbstractTokenWithCardinality=ruleAbstractTokenWithCardinality();
            _fsp--;

             current =iv_ruleAbstractTokenWithCardinality; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality2089); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:965:1: ruleAbstractTokenWithCardinality returns [EObject current=null] : ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) (lv_cardinality_2= ( '?' | '*' | '+' ) )? ) ;
    public final EObject ruleAbstractTokenWithCardinality() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_2=null;
        EObject this_Assignment_0 = null;

        EObject this_AbstractTerminal_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:970:6: ( ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) (lv_cardinality_2= ( '?' | '*' | '+' ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:971:1: ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) (lv_cardinality_2= ( '?' | '*' | '+' ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:971:1: ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) (lv_cardinality_2= ( '?' | '*' | '+' ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:971:2: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) (lv_cardinality_2= ( '?' | '*' | '+' ) )?
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:971:2: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal )
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
                        new NoViableAltException("971:2: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal )", 23, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA23_0==RULE_STRING||LA23_0==15) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("971:2: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal )", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:972:5: this_Assignment_0= ruleAssignment
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAssignment_in_ruleAbstractTokenWithCardinality2137);
                    this_Assignment_0=ruleAssignment();
                    _fsp--;

                     
                            current = this_Assignment_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:982:5: this_AbstractTerminal_1= ruleAbstractTerminal
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAbstractTokenWithCardinality2164);
                    this_AbstractTerminal_1=ruleAbstractTerminal();
                    _fsp--;

                     
                            current = this_AbstractTerminal_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:990:2: (lv_cardinality_2= ( '?' | '*' | '+' ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=26 && LA25_0<=28)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:992:6: lv_cardinality_2= ( '?' | '*' | '+' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:992:23: ( '?' | '*' | '+' )
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
                            new NoViableAltException("992:23: ( '?' | '*' | '+' )", 24, 0, input);

                        throw nvae;
                    }

                    switch (alt24) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:992:24: '?'
                            {
                            match(input,26,FOLLOW_26_in_ruleAbstractTokenWithCardinality2186); 

                                    createLeafNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0(), "cardinality"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:998:6: '*'
                            {
                            match(input,27,FOLLOW_27_in_ruleAbstractTokenWithCardinality2202); 

                                    createLeafNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1(), "cardinality"); 
                                

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1004:6: '+'
                            {
                            match(input,28,FOLLOW_28_in_ruleAbstractTokenWithCardinality2218); 

                                    createLeafNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityPlusSignKeyword_1_0_2(), "cardinality"); 
                                

                            }
                            break;

                    }


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAbstractTokenWithCardinalityRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "cardinality", /* lv_cardinality_2 */ input.LT(-1), null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1031:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1031:48: (iv_ruleAction= ruleAction EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1032:2: iv_ruleAction= ruleAction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAction_in_entryRuleAction2267);
            iv_ruleAction=ruleAction();
            _fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAction2277); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1039:1: ruleAction returns [EObject current=null] : ( '{' (lv_type_1= ruleTypeRef ) ( '.' (lv_feature_3= RULE_ID ) (lv_operator_4= ( '=' | '+=' ) ) 'current' )? '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_feature_3=null;
        Token lv_operator_4=null;
        EObject lv_type_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1044:6: ( ( '{' (lv_type_1= ruleTypeRef ) ( '.' (lv_feature_3= RULE_ID ) (lv_operator_4= ( '=' | '+=' ) ) 'current' )? '}' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1045:1: ( '{' (lv_type_1= ruleTypeRef ) ( '.' (lv_feature_3= RULE_ID ) (lv_operator_4= ( '=' | '+=' ) ) 'current' )? '}' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1045:1: ( '{' (lv_type_1= ruleTypeRef ) ( '.' (lv_feature_3= RULE_ID ) (lv_operator_4= ( '=' | '+=' ) ) 'current' )? '}' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1045:2: '{' (lv_type_1= ruleTypeRef ) ( '.' (lv_feature_3= RULE_ID ) (lv_operator_4= ( '=' | '+=' ) ) 'current' )? '}'
            {
            match(input,29,FOLLOW_29_in_ruleAction2311); 

                    createLeafNode(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1049:1: (lv_type_1= ruleTypeRef )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1052:6: lv_type_1= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAction2345);
            lv_type_1=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getActionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "type", lv_type_1, "TypeRef", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1070:2: ( '.' (lv_feature_3= RULE_ID ) (lv_operator_4= ( '=' | '+=' ) ) 'current' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==17) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1070:3: '.' (lv_feature_3= RULE_ID ) (lv_operator_4= ( '=' | '+=' ) ) 'current'
                    {
                    match(input,17,FOLLOW_17_in_ruleAction2359); 

                            createLeafNode(grammarAccess.getActionAccess().getFullStopKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1074:1: (lv_feature_3= RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1076:6: lv_feature_3= RULE_ID
                    {
                    lv_feature_3=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAction2381); 

                    		createLeafNode(grammarAccess.getActionAccess().getFeatureIDTerminalRuleCall_2_1_0(), "feature"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getActionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "feature", lv_feature_3, "ID", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1094:2: (lv_operator_4= ( '=' | '+=' ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1096:6: lv_operator_4= ( '=' | '+=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1096:20: ( '=' | '+=' )
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
                            new NoViableAltException("1096:20: ( '=' | '+=' )", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1096:21: '='
                            {
                            match(input,30,FOLLOW_30_in_ruleAction2411); 

                                    createLeafNode(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0(), "operator"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1102:6: '+='
                            {
                            match(input,31,FOLLOW_31_in_ruleAction2427); 

                                    createLeafNode(grammarAccess.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1(), "operator"); 
                                

                            }
                            break;

                    }


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getActionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "operator", /* lv_operator_4 */ input.LT(-1), null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    match(input,32,FOLLOW_32_in_ruleAction2451); 

                            createLeafNode(grammarAccess.getActionAccess().getCurrentKeyword_2_3(), null); 
                        

                    }
                    break;

            }

            match(input,33,FOLLOW_33_in_ruleAction2462); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1137:1: entryRuleAbstractTerminal returns [EObject current=null] : iv_ruleAbstractTerminal= ruleAbstractTerminal EOF ;
    public final EObject entryRuleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTerminal = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1137:58: (iv_ruleAbstractTerminal= ruleAbstractTerminal EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1138:2: iv_ruleAbstractTerminal= ruleAbstractTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractTerminalRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal2495);
            iv_ruleAbstractTerminal=ruleAbstractTerminal();
            _fsp--;

             current =iv_ruleAbstractTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractTerminal2505); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1145:1: ruleAbstractTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement ) ;
    public final EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedElement_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1150:6: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1151:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1151:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement )
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
                    new NoViableAltException("1151:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement )", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1152:5: this_Keyword_0= ruleKeyword
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleKeyword_in_ruleAbstractTerminal2552);
                    this_Keyword_0=ruleKeyword();
                    _fsp--;

                     
                            current = this_Keyword_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1162:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRuleCall_in_ruleAbstractTerminal2579);
                    this_RuleCall_1=ruleRuleCall();
                    _fsp--;

                     
                            current = this_RuleCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1172:5: this_ParenthesizedElement_2= ruleParenthesizedElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal2606);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1187:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1187:49: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1188:2: iv_ruleKeyword= ruleKeyword EOF
            {
             currentNode = createCompositeNode(grammarAccess.getKeywordRule(), currentNode); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword2638);
            iv_ruleKeyword=ruleKeyword();
            _fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword2648); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1195:1: ruleKeyword returns [EObject current=null] : (lv_value_0= RULE_STRING ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1200:6: ( (lv_value_0= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1201:1: (lv_value_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1201:1: (lv_value_0= RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1203:6: lv_value_0= RULE_STRING
            {
            lv_value_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword2694); 

            		createLeafNode(grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0(), "value"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getKeywordRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_0, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1228:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1228:50: (iv_ruleRuleCall= ruleRuleCall EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1229:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleRuleCall_in_entryRuleRuleCall2734);
            iv_ruleRuleCall=ruleRuleCall();
            _fsp--;

             current =iv_ruleRuleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleCall2744); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1236:1: ruleRuleCall returns [EObject current=null] : ( RULE_ID ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1241:6: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1242:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1242:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1245:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getRuleCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall2790); 

            		createLeafNode(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0(), "rule"); 
            	
             lastConsumedDatatypeToken = null; 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1266:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1266:52: (iv_ruleAssignment= ruleAssignment EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1267:2: iv_ruleAssignment= ruleAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignmentRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment2829);
            iv_ruleAssignment=ruleAssignment();
            _fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment2839); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1274:1: ruleAssignment returns [EObject current=null] : ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( '+=' | '=' | '?=' ) ) (lv_terminal_2= ruleAssignableTerminal ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0=null;
        Token lv_operator_1=null;
        EObject lv_terminal_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1279:6: ( ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( '+=' | '=' | '?=' ) ) (lv_terminal_2= ruleAssignableTerminal ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1280:1: ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( '+=' | '=' | '?=' ) ) (lv_terminal_2= ruleAssignableTerminal ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1280:1: ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( '+=' | '=' | '?=' ) ) (lv_terminal_2= ruleAssignableTerminal ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1280:2: (lv_feature_0= RULE_ID ) (lv_operator_1= ( '+=' | '=' | '?=' ) ) (lv_terminal_2= ruleAssignableTerminal )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1280:2: (lv_feature_0= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1282:6: lv_feature_0= RULE_ID
            {
            lv_feature_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignment2886); 

            		createLeafNode(grammarAccess.getAssignmentAccess().getFeatureIDTerminalRuleCall_0_0(), "feature"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "feature", lv_feature_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1300:2: (lv_operator_1= ( '+=' | '=' | '?=' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1302:6: lv_operator_1= ( '+=' | '=' | '?=' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1302:20: ( '+=' | '=' | '?=' )
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
                    new NoViableAltException("1302:20: ( '+=' | '=' | '?=' )", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1302:21: '+='
                    {
                    match(input,31,FOLLOW_31_in_ruleAssignment2916); 

                            createLeafNode(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0(), "operator"); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1308:6: '='
                    {
                    match(input,30,FOLLOW_30_in_ruleAssignment2932); 

                            createLeafNode(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1(), "operator"); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1314:6: '?='
                    {
                    match(input,34,FOLLOW_34_in_ruleAssignment2948); 

                            createLeafNode(grammarAccess.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_1_0_2(), "operator"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "operator", /* lv_operator_1 */ input.LT(-1), null, lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1334:2: (lv_terminal_2= ruleAssignableTerminal )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1337:6: lv_terminal_2= ruleAssignableTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAssignableTerminal_in_ruleAssignment2997);
            lv_terminal_2=ruleAssignableTerminal();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "terminal", lv_terminal_2, "AssignableTerminal", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1362:1: entryRuleAssignableTerminal returns [EObject current=null] : iv_ruleAssignableTerminal= ruleAssignableTerminal EOF ;
    public final EObject entryRuleAssignableTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignableTerminal = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1362:60: (iv_ruleAssignableTerminal= ruleAssignableTerminal EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1363:2: iv_ruleAssignableTerminal= ruleAssignableTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignableTerminalRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal3034);
            iv_ruleAssignableTerminal=ruleAssignableTerminal();
            _fsp--;

             current =iv_ruleAssignableTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignableTerminal3044); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1370:1: ruleAssignableTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference ) ;
    public final EObject ruleAssignableTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedAssignableElement_2 = null;

        EObject this_CrossReference_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1375:6: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1376:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1376:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )
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
                    new NoViableAltException("1376:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1377:5: this_Keyword_0= ruleKeyword
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleKeyword_in_ruleAssignableTerminal3091);
                    this_Keyword_0=ruleKeyword();
                    _fsp--;

                     
                            current = this_Keyword_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1387:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRuleCall_in_ruleAssignableTerminal3118);
                    this_RuleCall_1=ruleRuleCall();
                    _fsp--;

                     
                            current = this_RuleCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1397:5: this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedAssignableElement_in_ruleAssignableTerminal3145);
                    this_ParenthesizedAssignableElement_2=ruleParenthesizedAssignableElement();
                    _fsp--;

                     
                            current = this_ParenthesizedAssignableElement_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1407:5: this_CrossReference_3= ruleCrossReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCrossReference_in_ruleAssignableTerminal3172);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1422:1: entryRuleParenthesizedAssignableElement returns [EObject current=null] : iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF ;
    public final EObject entryRuleParenthesizedAssignableElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedAssignableElement = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1422:72: (iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1423:2: iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedAssignableElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement3204);
            iv_ruleParenthesizedAssignableElement=ruleParenthesizedAssignableElement();
            _fsp--;

             current =iv_ruleParenthesizedAssignableElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement3214); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1430:1: ruleParenthesizedAssignableElement returns [EObject current=null] : ( '(' this_AssignableAlternatives_1= ruleAssignableAlternatives ')' ) ;
    public final EObject ruleParenthesizedAssignableElement() throws RecognitionException {
        EObject current = null;

        EObject this_AssignableAlternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1435:6: ( ( '(' this_AssignableAlternatives_1= ruleAssignableAlternatives ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1436:1: ( '(' this_AssignableAlternatives_1= ruleAssignableAlternatives ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1436:1: ( '(' this_AssignableAlternatives_1= ruleAssignableAlternatives ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1436:2: '(' this_AssignableAlternatives_1= ruleAssignableAlternatives ')'
            {
            match(input,15,FOLLOW_15_in_ruleParenthesizedAssignableElement3248); 

                    createLeafNode(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleAssignableAlternatives_in_ruleParenthesizedAssignableElement3270);
            this_AssignableAlternatives_1=ruleAssignableAlternatives();
            _fsp--;

             
                    current = this_AssignableAlternatives_1; 
                    currentNode = currentNode.getParent();
                
            match(input,16,FOLLOW_16_in_ruleParenthesizedAssignableElement3278); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1460:1: entryRuleAssignableAlternatives returns [EObject current=null] : iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF ;
    public final EObject entryRuleAssignableAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignableAlternatives = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1460:64: (iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1461:2: iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignableAlternativesRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives3311);
            iv_ruleAssignableAlternatives=ruleAssignableAlternatives();
            _fsp--;

             current =iv_ruleAssignableAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignableAlternatives3321); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1468:1: ruleAssignableAlternatives returns [EObject current=null] : (this_AssignableTerminal_0= ruleAssignableTerminal ( () ( '|' (lv_groups_3= ruleAssignableTerminal ) )+ )? ) ;
    public final EObject ruleAssignableAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_AssignableTerminal_0 = null;

        EObject lv_groups_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1473:6: ( (this_AssignableTerminal_0= ruleAssignableTerminal ( () ( '|' (lv_groups_3= ruleAssignableTerminal ) )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1474:1: (this_AssignableTerminal_0= ruleAssignableTerminal ( () ( '|' (lv_groups_3= ruleAssignableTerminal ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1474:1: (this_AssignableTerminal_0= ruleAssignableTerminal ( () ( '|' (lv_groups_3= ruleAssignableTerminal ) )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1475:5: this_AssignableTerminal_0= ruleAssignableTerminal ( () ( '|' (lv_groups_3= ruleAssignableTerminal ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3368);
            this_AssignableTerminal_0=ruleAssignableTerminal();
            _fsp--;

             
                    current = this_AssignableTerminal_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1483:1: ( () ( '|' (lv_groups_3= ruleAssignableTerminal ) )+ )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==25) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1483:2: () ( '|' (lv_groups_3= ruleAssignableTerminal ) )+
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1483:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1484:5: 
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

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1499:2: ( '|' (lv_groups_3= ruleAssignableTerminal ) )+
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1499:3: '|' (lv_groups_3= ruleAssignableTerminal )
                    	    {
                    	    match(input,25,FOLLOW_25_in_ruleAssignableAlternatives3387); 

                    	            createLeafNode(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1503:1: (lv_groups_3= ruleAssignableTerminal )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1506:6: lv_groups_3= ruleAssignableTerminal
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAssignableAlternativesAccess().getGroupsAssignableTerminalParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3421);
                    	    lv_groups_3=ruleAssignableTerminal();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAssignableAlternativesRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "groups", lv_groups_3, "AssignableTerminal", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1531:1: entryRuleCrossReference returns [EObject current=null] : iv_ruleCrossReference= ruleCrossReference EOF ;
    public final EObject entryRuleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReference = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1531:56: (iv_ruleCrossReference= ruleCrossReference EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1532:2: iv_ruleCrossReference= ruleCrossReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCrossReferenceRule(), currentNode); 
            pushFollow(FOLLOW_ruleCrossReference_in_entryRuleCrossReference3462);
            iv_ruleCrossReference=ruleCrossReference();
            _fsp--;

             current =iv_ruleCrossReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReference3472); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1539:1: ruleCrossReference returns [EObject current=null] : ( '[' (lv_type_1= ruleTypeRef ) ( '|' (lv_terminal_3= ruleCrossReferenceableTerminal ) )? ']' ) ;
    public final EObject ruleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject lv_type_1 = null;

        EObject lv_terminal_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1544:6: ( ( '[' (lv_type_1= ruleTypeRef ) ( '|' (lv_terminal_3= ruleCrossReferenceableTerminal ) )? ']' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1545:1: ( '[' (lv_type_1= ruleTypeRef ) ( '|' (lv_terminal_3= ruleCrossReferenceableTerminal ) )? ']' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1545:1: ( '[' (lv_type_1= ruleTypeRef ) ( '|' (lv_terminal_3= ruleCrossReferenceableTerminal ) )? ']' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1545:2: '[' (lv_type_1= ruleTypeRef ) ( '|' (lv_terminal_3= ruleCrossReferenceableTerminal ) )? ']'
            {
            match(input,35,FOLLOW_35_in_ruleCrossReference3506); 

                    createLeafNode(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1549:1: (lv_type_1= ruleTypeRef )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1552:6: lv_type_1= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleCrossReference3540);
            lv_type_1=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCrossReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "type", lv_type_1, "TypeRef", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1570:2: ( '|' (lv_terminal_3= ruleCrossReferenceableTerminal ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==25) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1570:3: '|' (lv_terminal_3= ruleCrossReferenceableTerminal )
                    {
                    match(input,25,FOLLOW_25_in_ruleCrossReference3554); 

                            createLeafNode(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1574:1: (lv_terminal_3= ruleCrossReferenceableTerminal )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1577:6: lv_terminal_3= ruleCrossReferenceableTerminal
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReference3588);
                    lv_terminal_3=ruleCrossReferenceableTerminal();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCrossReferenceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "terminal", lv_terminal_3, "CrossReferenceableTerminal", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,36,FOLLOW_36_in_ruleCrossReference3603); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1606:1: entryRuleCrossReferenceableTerminal returns [EObject current=null] : iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF ;
    public final EObject entryRuleCrossReferenceableTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReferenceableTerminal = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1606:68: (iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1607:2: iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCrossReferenceableTerminalRule(), currentNode); 
            pushFollow(FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal3636);
            iv_ruleCrossReferenceableTerminal=ruleCrossReferenceableTerminal();
            _fsp--;

             current =iv_ruleCrossReferenceableTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal3646); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1614:1: ruleCrossReferenceableTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement ) ;
    public final EObject ruleCrossReferenceableTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedCrossReferenceableElement_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1619:6: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1620:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1620:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement )
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
                    new NoViableAltException("1620:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement )", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1621:5: this_Keyword_0= ruleKeyword
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleKeyword_in_ruleCrossReferenceableTerminal3693);
                    this_Keyword_0=ruleKeyword();
                    _fsp--;

                     
                            current = this_Keyword_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1631:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRuleCall_in_ruleCrossReferenceableTerminal3720);
                    this_RuleCall_1=ruleRuleCall();
                    _fsp--;

                     
                            current = this_RuleCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1641:5: this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCrossReferenceableTerminalAccess().getParenthesizedCrossReferenceableElementParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedCrossReferenceableElement_in_ruleCrossReferenceableTerminal3747);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1656:1: entryRuleParenthesizedCrossReferenceableElement returns [EObject current=null] : iv_ruleParenthesizedCrossReferenceableElement= ruleParenthesizedCrossReferenceableElement EOF ;
    public final EObject entryRuleParenthesizedCrossReferenceableElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedCrossReferenceableElement = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1656:80: (iv_ruleParenthesizedCrossReferenceableElement= ruleParenthesizedCrossReferenceableElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1657:2: iv_ruleParenthesizedCrossReferenceableElement= ruleParenthesizedCrossReferenceableElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedCrossReferenceableElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedCrossReferenceableElement_in_entryRuleParenthesizedCrossReferenceableElement3779);
            iv_ruleParenthesizedCrossReferenceableElement=ruleParenthesizedCrossReferenceableElement();
            _fsp--;

             current =iv_ruleParenthesizedCrossReferenceableElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedCrossReferenceableElement3789); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1664:1: ruleParenthesizedCrossReferenceableElement returns [EObject current=null] : ( '(' this_CrossReferenceableAlternatives_1= ruleCrossReferenceableAlternatives ')' ) ;
    public final EObject ruleParenthesizedCrossReferenceableElement() throws RecognitionException {
        EObject current = null;

        EObject this_CrossReferenceableAlternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1669:6: ( ( '(' this_CrossReferenceableAlternatives_1= ruleCrossReferenceableAlternatives ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1670:1: ( '(' this_CrossReferenceableAlternatives_1= ruleCrossReferenceableAlternatives ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1670:1: ( '(' this_CrossReferenceableAlternatives_1= ruleCrossReferenceableAlternatives ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1670:2: '(' this_CrossReferenceableAlternatives_1= ruleCrossReferenceableAlternatives ')'
            {
            match(input,15,FOLLOW_15_in_ruleParenthesizedCrossReferenceableElement3823); 

                    createLeafNode(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getCrossReferenceableAlternativesParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleCrossReferenceableAlternatives_in_ruleParenthesizedCrossReferenceableElement3845);
            this_CrossReferenceableAlternatives_1=ruleCrossReferenceableAlternatives();
            _fsp--;

             
                    current = this_CrossReferenceableAlternatives_1; 
                    currentNode = currentNode.getParent();
                
            match(input,16,FOLLOW_16_in_ruleParenthesizedCrossReferenceableElement3853); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1694:1: entryRuleCrossReferenceableAlternatives returns [EObject current=null] : iv_ruleCrossReferenceableAlternatives= ruleCrossReferenceableAlternatives EOF ;
    public final EObject entryRuleCrossReferenceableAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReferenceableAlternatives = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1694:72: (iv_ruleCrossReferenceableAlternatives= ruleCrossReferenceableAlternatives EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1695:2: iv_ruleCrossReferenceableAlternatives= ruleCrossReferenceableAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCrossReferenceableAlternativesRule(), currentNode); 
            pushFollow(FOLLOW_ruleCrossReferenceableAlternatives_in_entryRuleCrossReferenceableAlternatives3886);
            iv_ruleCrossReferenceableAlternatives=ruleCrossReferenceableAlternatives();
            _fsp--;

             current =iv_ruleCrossReferenceableAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReferenceableAlternatives3896); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1702:1: ruleCrossReferenceableAlternatives returns [EObject current=null] : (this_CrossReferenceableTerminal_0= ruleCrossReferenceableTerminal ( () ( '|' (lv_groups_3= ruleCrossReferenceableTerminal ) )+ )? ) ;
    public final EObject ruleCrossReferenceableAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_CrossReferenceableTerminal_0 = null;

        EObject lv_groups_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1707:6: ( (this_CrossReferenceableTerminal_0= ruleCrossReferenceableTerminal ( () ( '|' (lv_groups_3= ruleCrossReferenceableTerminal ) )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1708:1: (this_CrossReferenceableTerminal_0= ruleCrossReferenceableTerminal ( () ( '|' (lv_groups_3= ruleCrossReferenceableTerminal ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1708:1: (this_CrossReferenceableTerminal_0= ruleCrossReferenceableTerminal ( () ( '|' (lv_groups_3= ruleCrossReferenceableTerminal ) )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1709:5: this_CrossReferenceableTerminal_0= ruleCrossReferenceableTerminal ( () ( '|' (lv_groups_3= ruleCrossReferenceableTerminal ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getCrossReferenceableAlternativesAccess().getCrossReferenceableTerminalParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReferenceableAlternatives3943);
            this_CrossReferenceableTerminal_0=ruleCrossReferenceableTerminal();
            _fsp--;

             
                    current = this_CrossReferenceableTerminal_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1717:1: ( () ( '|' (lv_groups_3= ruleCrossReferenceableTerminal ) )+ )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==25) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1717:2: () ( '|' (lv_groups_3= ruleCrossReferenceableTerminal ) )+
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1717:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1718:5: 
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

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1733:2: ( '|' (lv_groups_3= ruleCrossReferenceableTerminal ) )+
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1733:3: '|' (lv_groups_3= ruleCrossReferenceableTerminal )
                    	    {
                    	    match(input,25,FOLLOW_25_in_ruleCrossReferenceableAlternatives3962); 

                    	            createLeafNode(grammarAccess.getCrossReferenceableAlternativesAccess().getVerticalLineKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1737:1: (lv_groups_3= ruleCrossReferenceableTerminal )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1740:6: lv_groups_3= ruleCrossReferenceableTerminal
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getCrossReferenceableAlternativesAccess().getGroupsCrossReferenceableTerminalParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReferenceableAlternatives3996);
                    	    lv_groups_3=ruleCrossReferenceableTerminal();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getCrossReferenceableAlternativesRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "groups", lv_groups_3, "CrossReferenceableTerminal", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1765:1: entryRuleParenthesizedElement returns [EObject current=null] : iv_ruleParenthesizedElement= ruleParenthesizedElement EOF ;
    public final EObject entryRuleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedElement = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1765:62: (iv_ruleParenthesizedElement= ruleParenthesizedElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1766:2: iv_ruleParenthesizedElement= ruleParenthesizedElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement4037);
            iv_ruleParenthesizedElement=ruleParenthesizedElement();
            _fsp--;

             current =iv_ruleParenthesizedElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedElement4047); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1773:1: ruleParenthesizedElement returns [EObject current=null] : ( '(' this_Alternatives_1= ruleAlternatives ')' ) ;
    public final EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Alternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1778:6: ( ( '(' this_Alternatives_1= ruleAlternatives ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1779:1: ( '(' this_Alternatives_1= ruleAlternatives ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1779:1: ( '(' this_Alternatives_1= ruleAlternatives ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1779:2: '(' this_Alternatives_1= ruleAlternatives ')'
            {
            match(input,15,FOLLOW_15_in_ruleParenthesizedElement4081); 

                    createLeafNode(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesizedElement4103);
            this_Alternatives_1=ruleAlternatives();
            _fsp--;

             
                    current = this_Alternatives_1; 
                    currentNode = currentNode.getParent();
                
            match(input,16,FOLLOW_16_in_ruleParenthesizedElement4111); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1803:1: entryRuleTerminalRule returns [EObject current=null] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final EObject entryRuleTerminalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRule = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1803:54: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1804:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule4144);
            iv_ruleTerminalRule=ruleTerminalRule();
            _fsp--;

             current =iv_ruleTerminalRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalRule4154); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1811:1: ruleTerminalRule returns [EObject current=null] : ( 'terminal' (lv_name_1= RULE_ID ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ':' (lv_alternatives_5= ruleTerminalAlternatives ) ';' ) ;
    public final EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_type_3 = null;

        EObject lv_alternatives_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1816:6: ( ( 'terminal' (lv_name_1= RULE_ID ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ':' (lv_alternatives_5= ruleTerminalAlternatives ) ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1817:1: ( 'terminal' (lv_name_1= RULE_ID ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ':' (lv_alternatives_5= ruleTerminalAlternatives ) ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1817:1: ( 'terminal' (lv_name_1= RULE_ID ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ':' (lv_alternatives_5= ruleTerminalAlternatives ) ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1817:2: 'terminal' (lv_name_1= RULE_ID ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ':' (lv_alternatives_5= ruleTerminalAlternatives ) ';'
            {
            match(input,37,FOLLOW_37_in_ruleTerminalRule4188); 

                    createLeafNode(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1821:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1823:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTerminalRule4210); 

            		createLeafNode(grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTerminalRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1841:2: ( 'returns' (lv_type_3= ruleTypeRef ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==21) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1841:3: 'returns' (lv_type_3= ruleTypeRef )
                    {
                    match(input,21,FOLLOW_21_in_ruleTerminalRule4228); 

                            createLeafNode(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1845:1: (lv_type_3= ruleTypeRef )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1848:6: lv_type_3= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleTerminalRule4262);
                    lv_type_3=ruleTypeRef();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTerminalRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "type", lv_type_3, "TypeRef", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,22,FOLLOW_22_in_ruleTerminalRule4277); 

                    createLeafNode(grammarAccess.getTerminalRuleAccess().getColonKeyword_3(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1870:1: (lv_alternatives_5= ruleTerminalAlternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1873:6: lv_alternatives_5= ruleTerminalAlternatives
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule4311);
            lv_alternatives_5=ruleTerminalAlternatives();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTerminalRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "alternatives", lv_alternatives_5, "TerminalAlternatives", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,23,FOLLOW_23_in_ruleTerminalRule4324); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1902:1: entryRuleTerminalAlternatives returns [EObject current=null] : iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF ;
    public final EObject entryRuleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalAlternatives = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1902:62: (iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1903:2: iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalAlternativesRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives4357);
            iv_ruleTerminalAlternatives=ruleTerminalAlternatives();
            _fsp--;

             current =iv_ruleTerminalAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalAlternatives4367); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1910:1: ruleTerminalAlternatives returns [EObject current=null] : (this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' (lv_groups_3= ruleTerminalGroup ) )+ )? ) ;
    public final EObject ruleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalGroup_0 = null;

        EObject lv_groups_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1915:6: ( (this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' (lv_groups_3= ruleTerminalGroup ) )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1916:1: (this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' (lv_groups_3= ruleTerminalGroup ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1916:1: (this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' (lv_groups_3= ruleTerminalGroup ) )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1917:5: this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' (lv_groups_3= ruleTerminalGroup ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4414);
            this_TerminalGroup_0=ruleTerminalGroup();
            _fsp--;

             
                    current = this_TerminalGroup_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1925:1: ( () ( '|' (lv_groups_3= ruleTerminalGroup ) )+ )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==25) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1925:2: () ( '|' (lv_groups_3= ruleTerminalGroup ) )+
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1925:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1926:5: 
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

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1941:2: ( '|' (lv_groups_3= ruleTerminalGroup ) )+
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1941:3: '|' (lv_groups_3= ruleTerminalGroup )
                    	    {
                    	    match(input,25,FOLLOW_25_in_ruleTerminalAlternatives4433); 

                    	            createLeafNode(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1945:1: (lv_groups_3= ruleTerminalGroup )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1948:6: lv_groups_3= ruleTerminalGroup
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getTerminalAlternativesAccess().getGroupsTerminalGroupParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4467);
                    	    lv_groups_3=ruleTerminalGroup();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getTerminalAlternativesRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "groups", lv_groups_3, "TerminalGroup", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1973:1: entryRuleTerminalGroup returns [EObject current=null] : iv_ruleTerminalGroup= ruleTerminalGroup EOF ;
    public final EObject entryRuleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalGroup = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1973:55: (iv_ruleTerminalGroup= ruleTerminalGroup EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1974:2: iv_ruleTerminalGroup= ruleTerminalGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalGroupRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup4508);
            iv_ruleTerminalGroup=ruleTerminalGroup();
            _fsp--;

             current =iv_ruleTerminalGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalGroup4518); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1981:1: ruleTerminalGroup returns [EObject current=null] : (this_TerminalToken_0= ruleTerminalToken ( () (lv_tokens_2= ruleTerminalToken )+ )? ) ;
    public final EObject ruleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalToken_0 = null;

        EObject lv_tokens_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1986:6: ( (this_TerminalToken_0= ruleTerminalToken ( () (lv_tokens_2= ruleTerminalToken )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1987:1: (this_TerminalToken_0= ruleTerminalToken ( () (lv_tokens_2= ruleTerminalToken )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1987:1: (this_TerminalToken_0= ruleTerminalToken ( () (lv_tokens_2= ruleTerminalToken )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1988:5: this_TerminalToken_0= ruleTerminalToken ( () (lv_tokens_2= ruleTerminalToken )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4565);
            this_TerminalToken_0=ruleTerminalToken();
            _fsp--;

             
                    current = this_TerminalToken_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1996:1: ( () (lv_tokens_2= ruleTerminalToken )+ )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=RULE_ID && LA41_0<=RULE_STRING)||LA41_0==15||LA41_0==17||(LA41_0>=38 && LA41_0<=39)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1996:2: () (lv_tokens_2= ruleTerminalToken )+
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1996:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1997:5: 
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

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2012:2: (lv_tokens_2= ruleTerminalToken )+
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2015:6: lv_tokens_2= ruleTerminalToken
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getTerminalGroupAccess().getTokensTerminalTokenParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4608);
                    	    lv_tokens_2=ruleTerminalToken();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getTerminalGroupRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "tokens", lv_tokens_2, "TerminalToken", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2040:1: entryRuleTerminalToken returns [EObject current=null] : iv_ruleTerminalToken= ruleTerminalToken EOF ;
    public final EObject entryRuleTerminalToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalToken = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2040:55: (iv_ruleTerminalToken= ruleTerminalToken EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2041:2: iv_ruleTerminalToken= ruleTerminalToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalTokenRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken4648);
            iv_ruleTerminalToken=ruleTerminalToken();
            _fsp--;

             current =iv_ruleTerminalToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalToken4658); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2048:1: ruleTerminalToken returns [EObject current=null] : (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( '?' | '*' | '+' ) )? ) ;
    public final EObject ruleTerminalToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_1=null;
        EObject this_TerminalTokenElement_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2053:6: ( (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( '?' | '*' | '+' ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2054:1: (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( '?' | '*' | '+' ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2054:1: (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( '?' | '*' | '+' ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2055:5: this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( '?' | '*' | '+' ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken4705);
            this_TerminalTokenElement_0=ruleTerminalTokenElement();
            _fsp--;

             
                    current = this_TerminalTokenElement_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2063:1: (lv_cardinality_1= ( '?' | '*' | '+' ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=26 && LA43_0<=28)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2065:6: lv_cardinality_1= ( '?' | '*' | '+' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2065:23: ( '?' | '*' | '+' )
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
                            new NoViableAltException("2065:23: ( '?' | '*' | '+' )", 42, 0, input);

                        throw nvae;
                    }

                    switch (alt42) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2065:24: '?'
                            {
                            match(input,26,FOLLOW_26_in_ruleTerminalToken4726); 

                                    createLeafNode(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0(), "cardinality"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2071:6: '*'
                            {
                            match(input,27,FOLLOW_27_in_ruleTerminalToken4742); 

                                    createLeafNode(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1(), "cardinality"); 
                                

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2077:6: '+'
                            {
                            match(input,28,FOLLOW_28_in_ruleTerminalToken4758); 

                                    createLeafNode(grammarAccess.getTerminalTokenAccess().getCardinalityPlusSignKeyword_1_0_2(), "cardinality"); 
                                

                            }
                            break;

                    }


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTerminalTokenRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "cardinality", /* lv_cardinality_1 */ input.LT(-1), null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2104:1: entryRuleTerminalTokenElement returns [EObject current=null] : iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF ;
    public final EObject entryRuleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalTokenElement = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2104:62: (iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2105:2: iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalTokenElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement4807);
            iv_ruleTerminalTokenElement=ruleTerminalTokenElement();
            _fsp--;

             current =iv_ruleTerminalTokenElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalTokenElement4817); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2112:1: ruleTerminalTokenElement returns [EObject current=null] : (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard ) ;
    public final EObject ruleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject this_CharacterRange_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedTerminalElement_2 = null;

        EObject this_AbstractNegatedToken_3 = null;

        EObject this_Wildcard_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2117:6: ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2118:1: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2118:1: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )
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
                    new NoViableAltException("2118:1: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2119:5: this_CharacterRange_0= ruleCharacterRange
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement4864);
                    this_CharacterRange_0=ruleCharacterRange();
                    _fsp--;

                     
                            current = this_CharacterRange_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2129:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement4891);
                    this_RuleCall_1=ruleRuleCall();
                    _fsp--;

                     
                            current = this_RuleCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2139:5: this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement4918);
                    this_ParenthesizedTerminalElement_2=ruleParenthesizedTerminalElement();
                    _fsp--;

                     
                            current = this_ParenthesizedTerminalElement_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2149:5: this_AbstractNegatedToken_3= ruleAbstractNegatedToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement4945);
                    this_AbstractNegatedToken_3=ruleAbstractNegatedToken();
                    _fsp--;

                     
                            current = this_AbstractNegatedToken_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2159:5: this_Wildcard_4= ruleWildcard
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleWildcard_in_ruleTerminalTokenElement4972);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2174:1: entryRuleParenthesizedTerminalElement returns [EObject current=null] : iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF ;
    public final EObject entryRuleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedTerminalElement = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2174:70: (iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2175:2: iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedTerminalElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement5004);
            iv_ruleParenthesizedTerminalElement=ruleParenthesizedTerminalElement();
            _fsp--;

             current =iv_ruleParenthesizedTerminalElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement5014); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2182:1: ruleParenthesizedTerminalElement returns [EObject current=null] : ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')' ) ;
    public final EObject ruleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalAlternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2187:6: ( ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2188:1: ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2188:1: ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2188:2: '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')'
            {
            match(input,15,FOLLOW_15_in_ruleParenthesizedTerminalElement5048); 

                    createLeafNode(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement5070);
            this_TerminalAlternatives_1=ruleTerminalAlternatives();
            _fsp--;

             
                    current = this_TerminalAlternatives_1; 
                    currentNode = currentNode.getParent();
                
            match(input,16,FOLLOW_16_in_ruleParenthesizedTerminalElement5078); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2212:1: entryRuleAbstractNegatedToken returns [EObject current=null] : iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF ;
    public final EObject entryRuleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractNegatedToken = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2212:62: (iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2213:2: iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractNegatedTokenRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken5111);
            iv_ruleAbstractNegatedToken=ruleAbstractNegatedToken();
            _fsp--;

             current =iv_ruleAbstractNegatedToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractNegatedToken5121); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2220:1: ruleAbstractNegatedToken returns [EObject current=null] : (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) ;
    public final EObject ruleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject this_NegatedToken_0 = null;

        EObject this_UntilToken_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2225:6: ( (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2226:1: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2226:1: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
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
                    new NoViableAltException("2226:1: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2227:5: this_NegatedToken_0= ruleNegatedToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken5168);
                    this_NegatedToken_0=ruleNegatedToken();
                    _fsp--;

                     
                            current = this_NegatedToken_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2237:5: this_UntilToken_1= ruleUntilToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUntilToken_in_ruleAbstractNegatedToken5195);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2252:1: entryRuleNegatedToken returns [EObject current=null] : iv_ruleNegatedToken= ruleNegatedToken EOF ;
    public final EObject entryRuleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegatedToken = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2252:54: (iv_ruleNegatedToken= ruleNegatedToken EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2253:2: iv_ruleNegatedToken= ruleNegatedToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNegatedTokenRule(), currentNode); 
            pushFollow(FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken5227);
            iv_ruleNegatedToken=ruleNegatedToken();
            _fsp--;

             current =iv_ruleNegatedToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegatedToken5237); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2260:1: ruleNegatedToken returns [EObject current=null] : ( '!' (lv_terminal_1= ruleTerminalTokenElement ) ) ;
    public final EObject ruleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2265:6: ( ( '!' (lv_terminal_1= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2266:1: ( '!' (lv_terminal_1= ruleTerminalTokenElement ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2266:1: ( '!' (lv_terminal_1= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2266:2: '!' (lv_terminal_1= ruleTerminalTokenElement )
            {
            match(input,38,FOLLOW_38_in_ruleNegatedToken5271); 

                    createLeafNode(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2270:1: (lv_terminal_1= ruleTerminalTokenElement )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2273:6: lv_terminal_1= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken5305);
            lv_terminal_1=ruleTerminalTokenElement();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNegatedTokenRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "terminal", lv_terminal_1, "TerminalTokenElement", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2298:1: entryRuleUntilToken returns [EObject current=null] : iv_ruleUntilToken= ruleUntilToken EOF ;
    public final EObject entryRuleUntilToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUntilToken = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2298:52: (iv_ruleUntilToken= ruleUntilToken EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2299:2: iv_ruleUntilToken= ruleUntilToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUntilTokenRule(), currentNode); 
            pushFollow(FOLLOW_ruleUntilToken_in_entryRuleUntilToken5342);
            iv_ruleUntilToken=ruleUntilToken();
            _fsp--;

             current =iv_ruleUntilToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUntilToken5352); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2306:1: ruleUntilToken returns [EObject current=null] : ( '->' (lv_terminal_1= ruleTerminalTokenElement ) ) ;
    public final EObject ruleUntilToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2311:6: ( ( '->' (lv_terminal_1= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2312:1: ( '->' (lv_terminal_1= ruleTerminalTokenElement ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2312:1: ( '->' (lv_terminal_1= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2312:2: '->' (lv_terminal_1= ruleTerminalTokenElement )
            {
            match(input,39,FOLLOW_39_in_ruleUntilToken5386); 

                    createLeafNode(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2316:1: (lv_terminal_1= ruleTerminalTokenElement )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2319:6: lv_terminal_1= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleUntilToken5420);
            lv_terminal_1=ruleTerminalTokenElement();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUntilTokenRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "terminal", lv_terminal_1, "TerminalTokenElement", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2344:1: entryRuleWildcard returns [EObject current=null] : iv_ruleWildcard= ruleWildcard EOF ;
    public final EObject entryRuleWildcard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcard = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2344:50: (iv_ruleWildcard= ruleWildcard EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2345:2: iv_ruleWildcard= ruleWildcard EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWildcardRule(), currentNode); 
            pushFollow(FOLLOW_ruleWildcard_in_entryRuleWildcard5457);
            iv_ruleWildcard=ruleWildcard();
            _fsp--;

             current =iv_ruleWildcard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWildcard5467); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2352:1: ruleWildcard returns [EObject current=null] : ( () '.' ) ;
    public final EObject ruleWildcard() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2357:6: ( ( () '.' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2358:1: ( () '.' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2358:1: ( () '.' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2358:2: () '.'
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2358:2: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2359:5: 
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

            match(input,17,FOLLOW_17_in_ruleWildcard5510); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2380:1: entryRuleCharacterRange returns [EObject current=null] : iv_ruleCharacterRange= ruleCharacterRange EOF ;
    public final EObject entryRuleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterRange = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2380:56: (iv_ruleCharacterRange= ruleCharacterRange EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2381:2: iv_ruleCharacterRange= ruleCharacterRange EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCharacterRangeRule(), currentNode); 
            pushFollow(FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange5543);
            iv_ruleCharacterRange=ruleCharacterRange();
            _fsp--;

             current =iv_ruleCharacterRange; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCharacterRange5553); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2388:1: ruleCharacterRange returns [EObject current=null] : (this_Keyword_0= ruleKeyword ( () '..' (lv_right_3= ruleKeyword ) )? ) ;
    public final EObject ruleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject lv_right_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2393:6: ( (this_Keyword_0= ruleKeyword ( () '..' (lv_right_3= ruleKeyword ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2394:1: (this_Keyword_0= ruleKeyword ( () '..' (lv_right_3= ruleKeyword ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2394:1: (this_Keyword_0= ruleKeyword ( () '..' (lv_right_3= ruleKeyword ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2395:5: this_Keyword_0= ruleKeyword ( () '..' (lv_right_3= ruleKeyword ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleKeyword_in_ruleCharacterRange5600);
            this_Keyword_0=ruleKeyword();
            _fsp--;

             
                    current = this_Keyword_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2403:1: ( () '..' (lv_right_3= ruleKeyword ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==40) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2403:2: () '..' (lv_right_3= ruleKeyword )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2403:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2404:5: 
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

                    match(input,40,FOLLOW_40_in_ruleCharacterRange5618); 

                            createLeafNode(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2423:1: (lv_right_3= ruleKeyword )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2426:6: lv_right_3= ruleKeyword
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleKeyword_in_ruleCharacterRange5652);
                    lv_right_3=ruleKeyword();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCharacterRangeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "right", lv_right_3, "Keyword", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2451:1: entryRuleEnumRule returns [EObject current=null] : iv_ruleEnumRule= ruleEnumRule EOF ;
    public final EObject entryRuleEnumRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumRule = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2451:50: (iv_ruleEnumRule= ruleEnumRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2452:2: iv_ruleEnumRule= ruleEnumRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleEnumRule_in_entryRuleEnumRule5691);
            iv_ruleEnumRule=ruleEnumRule();
            _fsp--;

             current =iv_ruleEnumRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumRule5701); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2459:1: ruleEnumRule returns [EObject current=null] : ( 'enum' (lv_name_1= RULE_ID ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ':' (lv_alternatives_5= ruleEnumLiterals ) ';' ) ;
    public final EObject ruleEnumRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_type_3 = null;

        EObject lv_alternatives_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2464:6: ( ( 'enum' (lv_name_1= RULE_ID ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ':' (lv_alternatives_5= ruleEnumLiterals ) ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2465:1: ( 'enum' (lv_name_1= RULE_ID ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ':' (lv_alternatives_5= ruleEnumLiterals ) ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2465:1: ( 'enum' (lv_name_1= RULE_ID ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ':' (lv_alternatives_5= ruleEnumLiterals ) ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2465:2: 'enum' (lv_name_1= RULE_ID ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ':' (lv_alternatives_5= ruleEnumLiterals ) ';'
            {
            match(input,41,FOLLOW_41_in_ruleEnumRule5735); 

                    createLeafNode(grammarAccess.getEnumRuleAccess().getEnumKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2469:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2471:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnumRule5757); 

            		createLeafNode(grammarAccess.getEnumRuleAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEnumRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2489:2: ( 'returns' (lv_type_3= ruleTypeRef ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==21) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2489:3: 'returns' (lv_type_3= ruleTypeRef )
                    {
                    match(input,21,FOLLOW_21_in_ruleEnumRule5775); 

                            createLeafNode(grammarAccess.getEnumRuleAccess().getReturnsKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2493:1: (lv_type_3= ruleTypeRef )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2496:6: lv_type_3= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleEnumRule5809);
                    lv_type_3=ruleTypeRef();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEnumRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "type", lv_type_3, "TypeRef", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,22,FOLLOW_22_in_ruleEnumRule5824); 

                    createLeafNode(grammarAccess.getEnumRuleAccess().getColonKeyword_3(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2518:1: (lv_alternatives_5= ruleEnumLiterals )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2521:6: lv_alternatives_5= ruleEnumLiterals
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEnumLiterals_in_ruleEnumRule5858);
            lv_alternatives_5=ruleEnumLiterals();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEnumRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "alternatives", lv_alternatives_5, "EnumLiterals", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,23,FOLLOW_23_in_ruleEnumRule5871); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2550:1: entryRuleEnumLiterals returns [EObject current=null] : iv_ruleEnumLiterals= ruleEnumLiterals EOF ;
    public final EObject entryRuleEnumLiterals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiterals = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2550:54: (iv_ruleEnumLiterals= ruleEnumLiterals EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2551:2: iv_ruleEnumLiterals= ruleEnumLiterals EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumLiteralsRule(), currentNode); 
            pushFollow(FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals5904);
            iv_ruleEnumLiterals=ruleEnumLiterals();
            _fsp--;

             current =iv_ruleEnumLiterals; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumLiterals5914); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2558:1: ruleEnumLiterals returns [EObject current=null] : (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () ( '|' (lv_groups_3= ruleEnumLiteralDeclaration ) )+ )? ) ;
    public final EObject ruleEnumLiterals() throws RecognitionException {
        EObject current = null;

        EObject this_EnumLiteralDeclaration_0 = null;

        EObject lv_groups_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2563:6: ( (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () ( '|' (lv_groups_3= ruleEnumLiteralDeclaration ) )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2564:1: (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () ( '|' (lv_groups_3= ruleEnumLiteralDeclaration ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2564:1: (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () ( '|' (lv_groups_3= ruleEnumLiteralDeclaration ) )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2565:5: this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () ( '|' (lv_groups_3= ruleEnumLiteralDeclaration ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals5961);
            this_EnumLiteralDeclaration_0=ruleEnumLiteralDeclaration();
            _fsp--;

             
                    current = this_EnumLiteralDeclaration_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2573:1: ( () ( '|' (lv_groups_3= ruleEnumLiteralDeclaration ) )+ )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==25) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2573:2: () ( '|' (lv_groups_3= ruleEnumLiteralDeclaration ) )+
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2573:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2574:5: 
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

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2589:2: ( '|' (lv_groups_3= ruleEnumLiteralDeclaration ) )+
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
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2589:3: '|' (lv_groups_3= ruleEnumLiteralDeclaration )
                    	    {
                    	    match(input,25,FOLLOW_25_in_ruleEnumLiterals5980); 

                    	            createLeafNode(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2593:1: (lv_groups_3= ruleEnumLiteralDeclaration )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2596:6: lv_groups_3= ruleEnumLiteralDeclaration
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEnumLiteralsAccess().getGroupsEnumLiteralDeclarationParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals6014);
                    	    lv_groups_3=ruleEnumLiteralDeclaration();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getEnumLiteralsRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "groups", lv_groups_3, "EnumLiteralDeclaration", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2621:1: entryRuleEnumLiteralDeclaration returns [EObject current=null] : iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF ;
    public final EObject entryRuleEnumLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteralDeclaration = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2621:64: (iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2622:2: iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumLiteralDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration6055);
            iv_ruleEnumLiteralDeclaration=ruleEnumLiteralDeclaration();
            _fsp--;

             current =iv_ruleEnumLiteralDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration6065); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2629:1: ruleEnumLiteralDeclaration returns [EObject current=null] : ( ( RULE_ID ) ( '=' (lv_literal_2= ruleKeyword ) )? ) ;
    public final EObject ruleEnumLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        EObject lv_literal_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2634:6: ( ( ( RULE_ID ) ( '=' (lv_literal_2= ruleKeyword ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2635:1: ( ( RULE_ID ) ( '=' (lv_literal_2= ruleKeyword ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2635:1: ( ( RULE_ID ) ( '=' (lv_literal_2= ruleKeyword ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2635:2: ( RULE_ID ) ( '=' (lv_literal_2= ruleKeyword ) )?
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2635:2: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2638:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getEnumLiteralDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnumLiteralDeclaration6112); 

            		createLeafNode(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0(), "enumLiteral"); 
            	
             lastConsumedDatatypeToken = null; 

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2652:2: ( '=' (lv_literal_2= ruleKeyword ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==30) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2652:3: '=' (lv_literal_2= ruleKeyword )
                    {
                    match(input,30,FOLLOW_30_in_ruleEnumLiteralDeclaration6129); 

                            createLeafNode(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2656:1: (lv_literal_2= ruleKeyword )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2659:6: lv_literal_2= ruleKeyword
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleKeyword_in_ruleEnumLiteralDeclaration6163);
                    lv_literal_2=ruleKeyword();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEnumLiteralDeclarationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "literal", lv_literal_2, "Keyword", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

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


 

    public static final BitSet FOLLOW_ruleGrammar_in_entryRuleGrammar73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammar83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleGrammar117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar151 = new BitSet(new long[]{0x0000022000145010L});
    public static final BitSet FOLLOW_12_in_ruleGrammar165 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar192 = new BitSet(new long[]{0x0000022000146010L});
    public static final BitSet FOLLOW_13_in_ruleGrammar209 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar236 = new BitSet(new long[]{0x0000022000146010L});
    public static final BitSet FOLLOW_14_in_ruleGrammar269 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleGrammar291 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar314 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_13_in_ruleGrammar331 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar353 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_16_in_ruleGrammar373 = new BitSet(new long[]{0x0000022000140010L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar409 = new BitSet(new long[]{0x0000022000140010L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleGrammar448 = new BitSet(new long[]{0x0000022000000012L});
    public static final BitSet FOLLOW_ruleGrammarID_in_entryRuleGrammarID487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammarID498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarID538 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleGrammarID557 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarID572 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule617 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleAbstractRule674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_ruleAbstractRule701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumRule_in_ruleAbstractRule728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration760 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel876 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGeneratedMetamodel886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleGeneratedMetamodel920 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel942 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel972 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleGeneratedMetamodel989 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel1011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel1054 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel1064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleReferencedMetamodel1098 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1120 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleReferencedMetamodel1137 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_entryRuleParserRule1202 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParserRule1212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1259 = new BitSet(new long[]{0x0000000000604000L});
    public static final BitSet FOLLOW_21_in_ruleParserRule1277 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule1311 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_14_in_ruleParserRule1339 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleParserRule1361 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1384 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_13_in_ruleParserRule1401 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1423 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_16_in_ruleParserRule1443 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleParserRule1454 = new BitSet(new long[]{0x0000000020008030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule1488 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleParserRule1501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef1534 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef1544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef1592 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleTypeRef1608 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef1632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives1672 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives1729 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleAlternatives1748 = new BitSet(new long[]{0x0000000020008030L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives1782 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup1823 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroup1833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup1880 = new BitSet(new long[]{0x0000000020008032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup1923 = new BitSet(new long[]{0x0000000020008032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken1963 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken1973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_ruleAbstractToken2020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken2047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality2079 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality2089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractTokenWithCardinality2137 = new BitSet(new long[]{0x000000001C000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractTokenWithCardinality2164 = new BitSet(new long[]{0x000000001C000002L});
    public static final BitSet FOLLOW_26_in_ruleAbstractTokenWithCardinality2186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleAbstractTokenWithCardinality2202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleAbstractTokenWithCardinality2218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_entryRuleAction2267 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAction2277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleAction2311 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction2345 = new BitSet(new long[]{0x0000000200020000L});
    public static final BitSet FOLLOW_17_in_ruleAction2359 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAction2381 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30_in_ruleAction2411 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_31_in_ruleAction2427 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleAction2451 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleAction2462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal2495 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal2505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal2552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal2579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal2606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword2638 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword2648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword2694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall2734 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall2744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall2790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment2829 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment2839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment2886 = new BitSet(new long[]{0x00000004C0000000L});
    public static final BitSet FOLLOW_31_in_ruleAssignment2916 = new BitSet(new long[]{0x0000000800008030L});
    public static final BitSet FOLLOW_30_in_ruleAssignment2932 = new BitSet(new long[]{0x0000000800008030L});
    public static final BitSet FOLLOW_34_in_ruleAssignment2948 = new BitSet(new long[]{0x0000000800008030L});
    public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignment2997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal3034 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignableTerminal3044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleAssignableTerminal3091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleAssignableTerminal3118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_ruleAssignableTerminal3145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_ruleAssignableTerminal3172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement3204 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement3214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedAssignableElement3248 = new BitSet(new long[]{0x0000000800008030L});
    public static final BitSet FOLLOW_ruleAssignableAlternatives_in_ruleParenthesizedAssignableElement3270 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParenthesizedAssignableElement3278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives3311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignableAlternatives3321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3368 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleAssignableAlternatives3387 = new BitSet(new long[]{0x0000000800008030L});
    public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3421 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference3462 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference3472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleCrossReference3506 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleCrossReference3540 = new BitSet(new long[]{0x0000001002000000L});
    public static final BitSet FOLLOW_25_in_ruleCrossReference3554 = new BitSet(new long[]{0x0000000000008030L});
    public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReference3588 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleCrossReference3603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal3636 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal3646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCrossReferenceableTerminal3693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleCrossReferenceableTerminal3720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedCrossReferenceableElement_in_ruleCrossReferenceableTerminal3747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedCrossReferenceableElement_in_entryRuleParenthesizedCrossReferenceableElement3779 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedCrossReferenceableElement3789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedCrossReferenceableElement3823 = new BitSet(new long[]{0x0000000000008030L});
    public static final BitSet FOLLOW_ruleCrossReferenceableAlternatives_in_ruleParenthesizedCrossReferenceableElement3845 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParenthesizedCrossReferenceableElement3853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReferenceableAlternatives_in_entryRuleCrossReferenceableAlternatives3886 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReferenceableAlternatives3896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReferenceableAlternatives3943 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleCrossReferenceableAlternatives3962 = new BitSet(new long[]{0x0000000000008030L});
    public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReferenceableAlternatives3996 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement4037 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement4047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedElement4081 = new BitSet(new long[]{0x0000000020008030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement4103 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParenthesizedElement4111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule4144 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule4154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleTerminalRule4188 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTerminalRule4210 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_ruleTerminalRule4228 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleTerminalRule4262 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTerminalRule4277 = new BitSet(new long[]{0x000000C000028030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule4311 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleTerminalRule4324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives4357 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives4367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4414 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleTerminalAlternatives4433 = new BitSet(new long[]{0x000000C000028030L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4467 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup4508 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup4518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4565 = new BitSet(new long[]{0x000000C000028032L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4608 = new BitSet(new long[]{0x000000C000028032L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken4648 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken4658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken4705 = new BitSet(new long[]{0x000000001C000002L});
    public static final BitSet FOLLOW_26_in_ruleTerminalToken4726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleTerminalToken4742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleTerminalToken4758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement4807 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement4817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement4864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement4891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement4918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement4945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_ruleTerminalTokenElement4972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement5004 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement5014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedTerminalElement5048 = new BitSet(new long[]{0x000000C000028030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement5070 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParenthesizedTerminalElement5078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken5111 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken5121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken5168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUntilToken_in_ruleAbstractNegatedToken5195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken5227 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken5237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleNegatedToken5271 = new BitSet(new long[]{0x000000C000028030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken5305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUntilToken_in_entryRuleUntilToken5342 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUntilToken5352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleUntilToken5386 = new BitSet(new long[]{0x000000C000028030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleUntilToken5420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard5457 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcard5467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleWildcard5510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange5543 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange5553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange5600 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleCharacterRange5618 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange5652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumRule_in_entryRuleEnumRule5691 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumRule5701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleEnumRule5735 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnumRule5757 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_ruleEnumRule5775 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleEnumRule5809 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleEnumRule5824 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleEnumLiterals_in_ruleEnumRule5858 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleEnumRule5871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals5904 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiterals5914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals5961 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleEnumLiterals5980 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals6014 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration6055 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration6065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnumLiteralDeclaration6112 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_ruleEnumLiteralDeclaration6129 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleEnumLiteralDeclaration6163 = new BitSet(new long[]{0x0000000000000002L});

}