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
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextTerminalsTestLanguageParser extends AbstractInternalAntlrParser {
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

        public InternalXtextTerminalsTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g"; }


     
     	private XtextTerminalsTestLanguageGrammarAccess grammarAccess;
     	
        public InternalXtextTerminalsTestLanguageParser(TokenStream input, IAstFactory factory, XtextTerminalsTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Grammar";	
       	} 



    // $ANTLR start entryRuleGrammar
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:72:1: entryRuleGrammar returns [EObject current=null] : iv_ruleGrammar= ruleGrammar EOF ;
    public final EObject entryRuleGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammar = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:72:49: (iv_ruleGrammar= ruleGrammar EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:73:2: iv_ruleGrammar= ruleGrammar EOF
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:80:1: ruleGrammar returns [EObject current=null] : ( 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) ( 'with' ( ( ruleGrammarID ) ) ( ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ ) ;
    public final EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        Token lv_definesHiddenTokens_6_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_metamodelDeclarations_12_0 = null;

        EObject lv_rules_13_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:85:6: ( ( 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) ( 'with' ( ( ruleGrammarID ) ) ( ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:86:1: ( 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) ( 'with' ( ( ruleGrammarID ) ) ( ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:86:1: ( 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) ( 'with' ( ( ruleGrammarID ) ) ( ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+ )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:86:2: 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) ( 'with' ( ( ruleGrammarID ) ) ( ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( (lv_rules_13_0= ruleAbstractRule ) )+
            {
            match(input,11,FOLLOW_11_in_ruleGrammar117); 

                    createLeafNode(grammarAccess.getGrammarAccess().getGrammarKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:90:1: ( (lv_name_1_0= ruleGrammarID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:91:1: (lv_name_1_0= ruleGrammarID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:91:1: (lv_name_1_0= ruleGrammarID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:92:3: lv_name_1_0= ruleGrammarID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleGrammarID_in_ruleGrammar138);
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:114:2: ( 'with' ( ( ruleGrammarID ) ) ( ',' ( ( ruleGrammarID ) ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:114:3: 'with' ( ( ruleGrammarID ) ) ( ',' ( ( ruleGrammarID ) ) )*
                    {
                    match(input,12,FOLLOW_12_in_ruleGrammar148); 

                            createLeafNode(grammarAccess.getGrammarAccess().getWithKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:118:1: ( ( ruleGrammarID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:119:1: ( ruleGrammarID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:119:1: ( ruleGrammarID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:120:3: ruleGrammarID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleGrammarID_in_ruleGrammar171);
                    ruleGrammarID();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:134:2: ( ',' ( ( ruleGrammarID ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:134:3: ',' ( ( ruleGrammarID ) )
                    	    {
                    	    match(input,13,FOLLOW_13_in_ruleGrammar181); 

                    	            createLeafNode(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:138:1: ( ( ruleGrammarID ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:139:1: ( ruleGrammarID )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:139:1: ( ruleGrammarID )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:140:3: ruleGrammarID
                    	    {

                    	    			if (current==null) {
                    	    	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	            
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleGrammarID_in_ruleGrammar204);
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:154:6: ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:154:7: ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')'
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:154:7: ( (lv_definesHiddenTokens_6_0= 'hidden' ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:155:1: (lv_definesHiddenTokens_6_0= 'hidden' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:155:1: (lv_definesHiddenTokens_6_0= 'hidden' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:156:3: lv_definesHiddenTokens_6_0= 'hidden'
                    {
                    lv_definesHiddenTokens_6_0=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleGrammar226); 

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

                    match(input,15,FOLLOW_15_in_ruleGrammar248); 

                            createLeafNode(grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:179:1: ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:179:2: ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )*
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:179:2: ( ( RULE_ID ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:180:1: ( RULE_ID )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:180:1: ( RULE_ID )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:181:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar267); 

                            		createLeafNode(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0(), "hiddenTokens"); 
                            	

                            }


                            }

                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:193:2: ( ',' ( ( RULE_ID ) ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==13) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:193:3: ',' ( ( RULE_ID ) )
                            	    {
                            	    match(input,13,FOLLOW_13_in_ruleGrammar277); 

                            	            createLeafNode(grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0(), null); 
                            	        
                            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:197:1: ( ( RULE_ID ) )
                            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:198:1: ( RULE_ID )
                            	    {
                            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:198:1: ( RULE_ID )
                            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:199:3: RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar295); 

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

                    match(input,16,FOLLOW_16_in_ruleGrammar308); 

                            createLeafNode(grammarAccess.getGrammarAccess().getRightParenthesisKeyword_3_3(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:215:3: ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18||LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:216:1: (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:216:1: (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:217:3: lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar331);
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:239:3: ( (lv_rules_13_0= ruleAbstractRule ) )+
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:240:1: (lv_rules_13_0= ruleAbstractRule )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:240:1: (lv_rules_13_0= ruleAbstractRule )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:241:3: lv_rules_13_0= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleGrammar353);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:270:1: entryRuleGrammarID returns [String current=null] : iv_ruleGrammarID= ruleGrammarID EOF ;
    public final String entryRuleGrammarID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGrammarID = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:270:50: (iv_ruleGrammarID= ruleGrammarID EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:271:2: iv_ruleGrammarID= ruleGrammarID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGrammarIDRule(), currentNode); 
            pushFollow(FOLLOW_ruleGrammarID_in_entryRuleGrammarID388);
            iv_ruleGrammarID=ruleGrammarID();
            _fsp--;

             current =iv_ruleGrammarID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGrammarID399); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:278:1: ruleGrammarID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleGrammarID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:283:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:284:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:284:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:284:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammarID439); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:291:1: (kw= '.' this_ID_2= RULE_ID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:292:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,17,FOLLOW_17_in_ruleGrammarID458); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammarID473); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:312:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:312:54: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:313:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule518);
            iv_ruleAbstractRule=ruleAbstractRule();
            _fsp--;

             current =iv_ruleAbstractRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRule528); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:320:1: ruleAbstractRule returns [EObject current=null] : (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_ParserRule_0 = null;

        EObject this_TerminalRule_1 = null;

        EObject this_EnumRule_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:325:6: ( (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:326:1: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:326:1: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )
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
                    new NoViableAltException("326:1: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:327:5: this_ParserRule_0= ruleParserRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParserRule_in_ruleAbstractRule575);
                    this_ParserRule_0=ruleParserRule();
                    _fsp--;

                     
                            current = this_ParserRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:337:5: this_TerminalRule_1= ruleTerminalRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTerminalRule_in_ruleAbstractRule602);
                    this_TerminalRule_1=ruleTerminalRule();
                    _fsp--;

                     
                            current = this_TerminalRule_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:347:5: this_EnumRule_2= ruleEnumRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEnumRule_in_ruleAbstractRule629);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:362:1: entryRuleAbstractMetamodelDeclaration returns [EObject current=null] : iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF ;
    public final EObject entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractMetamodelDeclaration = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:362:70: (iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:363:2: iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractMetamodelDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration661);
            iv_ruleAbstractMetamodelDeclaration=ruleAbstractMetamodelDeclaration();
            _fsp--;

             current =iv_ruleAbstractMetamodelDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration671); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:370:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) ;
    public final EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel_0 = null;

        EObject this_ReferencedMetamodel_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:375:6: ( (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:376:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:376:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
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
                    new NoViableAltException("376:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:377:5: this_GeneratedMetamodel_0= ruleGeneratedMetamodel
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration718);
                    this_GeneratedMetamodel_0=ruleGeneratedMetamodel();
                    _fsp--;

                     
                            current = this_GeneratedMetamodel_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:387:5: this_ReferencedMetamodel_1= ruleReferencedMetamodel
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration745);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:402:1: entryRuleGeneratedMetamodel returns [EObject current=null] : iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF ;
    public final EObject entryRuleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratedMetamodel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:402:60: (iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:403:2: iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGeneratedMetamodelRule(), currentNode); 
            pushFollow(FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel777);
            iv_ruleGeneratedMetamodel=ruleGeneratedMetamodel();
            _fsp--;

             current =iv_ruleGeneratedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGeneratedMetamodel787); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:410:1: ruleGeneratedMetamodel returns [EObject current=null] : ( 'generate' ( (lv_name_1_0= RULE_ID ) ) ( ( RULE_STRING ) ) ( 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ) ;
    public final EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_alias_4_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:415:6: ( ( 'generate' ( (lv_name_1_0= RULE_ID ) ) ( ( RULE_STRING ) ) ( 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:416:1: ( 'generate' ( (lv_name_1_0= RULE_ID ) ) ( ( RULE_STRING ) ) ( 'as' ( (lv_alias_4_0= RULE_ID ) ) )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:416:1: ( 'generate' ( (lv_name_1_0= RULE_ID ) ) ( ( RULE_STRING ) ) ( 'as' ( (lv_alias_4_0= RULE_ID ) ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:416:2: 'generate' ( (lv_name_1_0= RULE_ID ) ) ( ( RULE_STRING ) ) ( 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            {
            match(input,18,FOLLOW_18_in_ruleGeneratedMetamodel821); 

                    createLeafNode(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:420:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:421:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:421:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:422:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel838); 

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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:444:2: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:445:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:445:1: ( RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:446:3: RULE_STRING
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getGeneratedMetamodelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel861); 

            		createLeafNode(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0(), "ePackage"); 
            	

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:458:2: ( 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:458:3: 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {
                    match(input,19,FOLLOW_19_in_ruleGeneratedMetamodel871); 

                            createLeafNode(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:462:1: ( (lv_alias_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:463:1: (lv_alias_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:463:1: (lv_alias_4_0= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:464:3: lv_alias_4_0= RULE_ID
                    {
                    lv_alias_4_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel888); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:493:1: entryRuleReferencedMetamodel returns [EObject current=null] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final EObject entryRuleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedMetamodel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:493:61: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:494:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferencedMetamodelRule(), currentNode); 
            pushFollow(FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel928);
            iv_ruleReferencedMetamodel=ruleReferencedMetamodel();
            _fsp--;

             current =iv_ruleReferencedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencedMetamodel938); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:501:1: ruleReferencedMetamodel returns [EObject current=null] : ( 'import' ( ( RULE_STRING ) ) ( 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_alias_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:506:6: ( ( 'import' ( ( RULE_STRING ) ) ( 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:507:1: ( 'import' ( ( RULE_STRING ) ) ( 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:507:1: ( 'import' ( ( RULE_STRING ) ) ( 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:507:2: 'import' ( ( RULE_STRING ) ) ( 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            {
            match(input,20,FOLLOW_20_in_ruleReferencedMetamodel972); 

                    createLeafNode(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:511:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:512:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:512:1: ( RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:513:3: RULE_STRING
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferencedMetamodelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReferencedMetamodel990); 

            		createLeafNode(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0(), "ePackage"); 
            	

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:525:2: ( 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:525:3: 'as' ( (lv_alias_3_0= RULE_ID ) )
                    {
                    match(input,19,FOLLOW_19_in_ruleReferencedMetamodel1000); 

                            createLeafNode(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:529:1: ( (lv_alias_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:530:1: (lv_alias_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:530:1: (lv_alias_3_0= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:531:3: lv_alias_3_0= RULE_ID
                    {
                    lv_alias_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedMetamodel1017); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:560:1: entryRuleParserRule returns [EObject current=null] : iv_ruleParserRule= ruleParserRule EOF ;
    public final EObject entryRuleParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:560:52: (iv_ruleParserRule= ruleParserRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:561:2: iv_ruleParserRule= ruleParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParserRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleParserRule_in_entryRuleParserRule1057);
            iv_ruleParserRule=ruleParserRule();
            _fsp--;

             current =iv_ruleParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParserRule1067); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:568:1: ruleParserRule returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )? ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) ';' ) ;
    public final EObject ruleParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_definesHiddenTokens_3_0=null;
        EObject lv_type_2_0 = null;

        EObject lv_alternatives_10_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:573:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )? ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:574:1: ( ( (lv_name_0_0= RULE_ID ) ) ( 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )? ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:574:1: ( ( (lv_name_0_0= RULE_ID ) ) ( 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )? ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:574:2: ( (lv_name_0_0= RULE_ID ) ) ( 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )? ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )? ':' ( (lv_alternatives_10_0= ruleAlternatives ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:574:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:575:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:575:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:576:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1109); 

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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:598:2: ( 'returns' ( (lv_type_2_0= ruleTypeRef ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==21) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:598:3: 'returns' ( (lv_type_2_0= ruleTypeRef ) )
                    {
                    match(input,21,FOLLOW_21_in_ruleParserRule1124); 

                            createLeafNode(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:602:1: ( (lv_type_2_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:603:1: (lv_type_2_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:603:1: (lv_type_2_0= ruleTypeRef )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:604:3: lv_type_2_0= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleParserRule1145);
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:626:4: ( ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:626:5: ( (lv_definesHiddenTokens_3_0= 'hidden' ) ) '(' ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ')'
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:626:5: ( (lv_definesHiddenTokens_3_0= 'hidden' ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:627:1: (lv_definesHiddenTokens_3_0= 'hidden' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:627:1: (lv_definesHiddenTokens_3_0= 'hidden' )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:628:3: lv_definesHiddenTokens_3_0= 'hidden'
                    {
                    lv_definesHiddenTokens_3_0=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleParserRule1165); 

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

                    match(input,15,FOLLOW_15_in_ruleParserRule1187); 

                            createLeafNode(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:651:1: ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_ID) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:651:2: ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )*
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:651:2: ( ( RULE_ID ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:652:1: ( RULE_ID )
                            {
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:652:1: ( RULE_ID )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:653:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.getParserRuleRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1206); 

                            		createLeafNode(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0(), "hiddenTokens"); 
                            	

                            }


                            }

                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:665:2: ( ',' ( ( RULE_ID ) ) )*
                            loop14:
                            do {
                                int alt14=2;
                                int LA14_0 = input.LA(1);

                                if ( (LA14_0==13) ) {
                                    alt14=1;
                                }


                                switch (alt14) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:665:3: ',' ( ( RULE_ID ) )
                            	    {
                            	    match(input,13,FOLLOW_13_in_ruleParserRule1216); 

                            	            createLeafNode(grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0(), null); 
                            	        
                            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:669:1: ( ( RULE_ID ) )
                            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:670:1: ( RULE_ID )
                            	    {
                            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:670:1: ( RULE_ID )
                            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:671:3: RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create(grammarAccess.getParserRuleRule().getType().getClassifier());
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1234); 

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

                    match(input,16,FOLLOW_16_in_ruleParserRule1247); 

                            createLeafNode(grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_2_3(), null); 
                        

                    }
                    break;

            }

            match(input,22,FOLLOW_22_in_ruleParserRule1258); 

                    createLeafNode(grammarAccess.getParserRuleAccess().getColonKeyword_3(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:691:1: ( (lv_alternatives_10_0= ruleAlternatives ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:692:1: (lv_alternatives_10_0= ruleAlternatives )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:692:1: (lv_alternatives_10_0= ruleAlternatives )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:693:3: lv_alternatives_10_0= ruleAlternatives
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParserRule1279);
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

            match(input,23,FOLLOW_23_in_ruleParserRule1288); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:726:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:726:49: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:727:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRefRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef1321);
            iv_ruleTypeRef=ruleTypeRef();
            _fsp--;

             current =iv_ruleTypeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef1331); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:734:1: ruleTypeRef returns [EObject current=null] : ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:739:6: ( ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:740:1: ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:740:1: ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:740:2: ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:740:2: ( ( ( RULE_ID ) ) '::' )?
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:740:3: ( ( RULE_ID ) ) '::'
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:740:3: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:741:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:741:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:742:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef1375); 

                    		createLeafNode(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0(), "metamodel"); 
                    	

                    }


                    }

                    match(input,24,FOLLOW_24_in_ruleTypeRef1384); 

                            createLeafNode(grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:758:3: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:759:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:759:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:760:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getTypeRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef1404); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:779:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:779:54: (iv_ruleAlternatives= ruleAlternatives EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:780:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAlternativesRule(), currentNode); 
            pushFollow(FOLLOW_ruleAlternatives_in_entryRuleAlternatives1437);
            iv_ruleAlternatives=ruleAlternatives();
            _fsp--;

             current =iv_ruleAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternatives1447); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:787:1: ruleAlternatives returns [EObject current=null] : (this_Group_0= ruleGroup ( () ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_Group_0 = null;

        EObject lv_groups_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:792:6: ( (this_Group_0= ruleGroup ( () ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:793:1: (this_Group_0= ruleGroup ( () ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:793:1: (this_Group_0= ruleGroup ( () ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:794:5: this_Group_0= ruleGroup ( () ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAlternativesAccess().getGroupParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives1494);
            this_Group_0=ruleGroup();
            _fsp--;

             
                    current = this_Group_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:802:1: ( () ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+ )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==25) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:802:2: () ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:802:2: ()
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:803:5: 
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

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:818:2: ( '|' ( (lv_groups_3_0= ruleGroup ) ) )+
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
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:818:3: '|' ( (lv_groups_3_0= ruleGroup ) )
                    	    {
                    	    match(input,25,FOLLOW_25_in_ruleAlternatives1513); 

                    	            createLeafNode(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:822:1: ( (lv_groups_3_0= ruleGroup ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:823:1: (lv_groups_3_0= ruleGroup )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:823:1: (lv_groups_3_0= ruleGroup )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:824:3: lv_groups_3_0= ruleGroup
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAlternativesAccess().getGroupsGroupParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives1534);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:853:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:853:47: (iv_ruleGroup= ruleGroup EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:854:2: iv_ruleGroup= ruleGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGroupRule(), currentNode); 
            pushFollow(FOLLOW_ruleGroup_in_entryRuleGroup1571);
            iv_ruleGroup=ruleGroup();
            _fsp--;

             current =iv_ruleGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroup1581); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:861:1: ruleGroup returns [EObject current=null] : (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )? ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken_0 = null;

        EObject lv_tokens_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:866:6: ( (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:867:1: (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:867:1: (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:868:5: this_AbstractToken_0= ruleAbstractToken ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup1628);
            this_AbstractToken_0=ruleAbstractToken();
            _fsp--;

             
                    current = this_AbstractToken_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:876:1: ( () ( (lv_tokens_2_0= ruleAbstractToken ) )+ )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_STRING)||LA21_0==15||LA21_0==29) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:876:2: () ( (lv_tokens_2_0= ruleAbstractToken ) )+
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:876:2: ()
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:877:5: 
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

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:892:2: ( (lv_tokens_2_0= ruleAbstractToken ) )+
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
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:893:1: (lv_tokens_2_0= ruleAbstractToken )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:893:1: (lv_tokens_2_0= ruleAbstractToken )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:894:3: lv_tokens_2_0= ruleAbstractToken
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getGroupAccess().getTokensAbstractTokenParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup1658);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:923:1: entryRuleAbstractToken returns [EObject current=null] : iv_ruleAbstractToken= ruleAbstractToken EOF ;
    public final EObject entryRuleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractToken = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:923:55: (iv_ruleAbstractToken= ruleAbstractToken EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:924:2: iv_ruleAbstractToken= ruleAbstractToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractTokenRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken1694);
            iv_ruleAbstractToken=ruleAbstractToken();
            _fsp--;

             current =iv_ruleAbstractToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractToken1704); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:931:1: ruleAbstractToken returns [EObject current=null] : (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction ) ;
    public final EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractTokenWithCardinality_0 = null;

        EObject this_Action_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:936:6: ( (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:937:1: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:937:1: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )
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
                    new NoViableAltException("937:1: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:938:5: this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractTokenWithCardinality_in_ruleAbstractToken1751);
                    this_AbstractTokenWithCardinality_0=ruleAbstractTokenWithCardinality();
                    _fsp--;

                     
                            current = this_AbstractTokenWithCardinality_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:948:5: this_Action_1= ruleAction
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAction_in_ruleAbstractToken1778);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:963:1: entryRuleAbstractTokenWithCardinality returns [EObject current=null] : iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF ;
    public final EObject entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTokenWithCardinality = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:963:70: (iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:964:2: iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractTokenWithCardinalityRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality1810);
            iv_ruleAbstractTokenWithCardinality=ruleAbstractTokenWithCardinality();
            _fsp--;

             current =iv_ruleAbstractTokenWithCardinality; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality1820); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:971:1: ruleAbstractTokenWithCardinality returns [EObject current=null] : ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? ) ;
    public final EObject ruleAbstractTokenWithCardinality() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_2_1=null;
        Token lv_cardinality_2_2=null;
        Token lv_cardinality_2_3=null;
        EObject this_Assignment_0 = null;

        EObject this_AbstractTerminal_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:976:6: ( ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:977:1: ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:977:1: ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:977:2: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:977:2: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal )
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
                        new NoViableAltException("977:2: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal )", 23, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA23_0==RULE_STRING||LA23_0==15) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("977:2: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal )", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:978:5: this_Assignment_0= ruleAssignment
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAssignment_in_ruleAbstractTokenWithCardinality1868);
                    this_Assignment_0=ruleAssignment();
                    _fsp--;

                     
                            current = this_Assignment_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:988:5: this_AbstractTerminal_1= ruleAbstractTerminal
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAbstractTokenWithCardinality1895);
                    this_AbstractTerminal_1=ruleAbstractTerminal();
                    _fsp--;

                     
                            current = this_AbstractTerminal_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:996:2: ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=26 && LA25_0<=28)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:997:1: ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:997:1: ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:998:1: (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:998:1: (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' )
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
                            new NoViableAltException("998:1: (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' )", 24, 0, input);

                        throw nvae;
                    }

                    switch (alt24) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:999:3: lv_cardinality_2_1= '?'
                            {
                            lv_cardinality_2_1=(Token)input.LT(1);
                            match(input,26,FOLLOW_26_in_ruleAbstractTokenWithCardinality1914); 

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
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1017:8: lv_cardinality_2_2= '*'
                            {
                            lv_cardinality_2_2=(Token)input.LT(1);
                            match(input,27,FOLLOW_27_in_ruleAbstractTokenWithCardinality1942); 

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
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1035:8: lv_cardinality_2_3= '+'
                            {
                            lv_cardinality_2_3=(Token)input.LT(1);
                            match(input,28,FOLLOW_28_in_ruleAbstractTokenWithCardinality1970); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1063:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1063:48: (iv_ruleAction= ruleAction EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1064:2: iv_ruleAction= ruleAction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAction_in_entryRuleAction2020);
            iv_ruleAction=ruleAction();
            _fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAction2030); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1071:1: ruleAction returns [EObject current=null] : ( '{' ( (lv_type_1_0= ruleTypeRef ) ) ( '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) 'current' )? '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_feature_3_0=null;
        Token lv_operator_4_1=null;
        Token lv_operator_4_2=null;
        EObject lv_type_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1076:6: ( ( '{' ( (lv_type_1_0= ruleTypeRef ) ) ( '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) 'current' )? '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1077:1: ( '{' ( (lv_type_1_0= ruleTypeRef ) ) ( '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) 'current' )? '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1077:1: ( '{' ( (lv_type_1_0= ruleTypeRef ) ) ( '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) 'current' )? '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1077:2: '{' ( (lv_type_1_0= ruleTypeRef ) ) ( '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) 'current' )? '}'
            {
            match(input,29,FOLLOW_29_in_ruleAction2064); 

                    createLeafNode(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1081:1: ( (lv_type_1_0= ruleTypeRef ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1082:1: (lv_type_1_0= ruleTypeRef )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1082:1: (lv_type_1_0= ruleTypeRef )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1083:3: lv_type_1_0= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAction2085);
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1105:2: ( '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) 'current' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==17) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1105:3: '.' ( (lv_feature_3_0= RULE_ID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) 'current'
                    {
                    match(input,17,FOLLOW_17_in_ruleAction2095); 

                            createLeafNode(grammarAccess.getActionAccess().getFullStopKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1109:1: ( (lv_feature_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1110:1: (lv_feature_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1110:1: (lv_feature_3_0= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1111:3: lv_feature_3_0= RULE_ID
                    {
                    lv_feature_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAction2112); 

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

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1133:2: ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1134:1: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1134:1: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1135:1: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1135:1: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
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
                            new NoViableAltException("1135:1: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1136:3: lv_operator_4_1= '='
                            {
                            lv_operator_4_1=(Token)input.LT(1);
                            match(input,30,FOLLOW_30_in_ruleAction2136); 

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
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1154:8: lv_operator_4_2= '+='
                            {
                            lv_operator_4_2=(Token)input.LT(1);
                            match(input,31,FOLLOW_31_in_ruleAction2164); 

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

                    match(input,32,FOLLOW_32_in_ruleAction2189); 

                            createLeafNode(grammarAccess.getActionAccess().getCurrentKeyword_2_3(), null); 
                        

                    }
                    break;

            }

            match(input,33,FOLLOW_33_in_ruleAction2200); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1190:1: entryRuleAbstractTerminal returns [EObject current=null] : iv_ruleAbstractTerminal= ruleAbstractTerminal EOF ;
    public final EObject entryRuleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTerminal = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1190:58: (iv_ruleAbstractTerminal= ruleAbstractTerminal EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1191:2: iv_ruleAbstractTerminal= ruleAbstractTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractTerminalRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal2233);
            iv_ruleAbstractTerminal=ruleAbstractTerminal();
            _fsp--;

             current =iv_ruleAbstractTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractTerminal2243); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1198:1: ruleAbstractTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement ) ;
    public final EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedElement_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1203:6: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1204:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1204:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement )
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
                    new NoViableAltException("1204:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement )", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1205:5: this_Keyword_0= ruleKeyword
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleKeyword_in_ruleAbstractTerminal2290);
                    this_Keyword_0=ruleKeyword();
                    _fsp--;

                     
                            current = this_Keyword_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1215:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRuleCall_in_ruleAbstractTerminal2317);
                    this_RuleCall_1=ruleRuleCall();
                    _fsp--;

                     
                            current = this_RuleCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1225:5: this_ParenthesizedElement_2= ruleParenthesizedElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal2344);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1240:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1240:49: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1241:2: iv_ruleKeyword= ruleKeyword EOF
            {
             currentNode = createCompositeNode(grammarAccess.getKeywordRule(), currentNode); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword2376);
            iv_ruleKeyword=ruleKeyword();
            _fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword2386); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1248:1: ruleKeyword returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1253:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1254:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1254:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1255:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1255:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1256:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword2427); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1285:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1285:50: (iv_ruleRuleCall= ruleRuleCall EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1286:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleRuleCall_in_entryRuleRuleCall2464);
            iv_ruleRuleCall=ruleRuleCall();
            _fsp--;

             current =iv_ruleRuleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleCall2474); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1293:1: ruleRuleCall returns [EObject current=null] : ( ( RULE_ID ) ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1298:6: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1299:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1299:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1300:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1300:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1301:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getRuleCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall2516); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1320:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1320:52: (iv_ruleAssignment= ruleAssignment EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1321:2: iv_ruleAssignment= ruleAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignmentRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment2548);
            iv_ruleAssignment=ruleAssignment();
            _fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment2558); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1328:1: ruleAssignment returns [EObject current=null] : ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0_0=null;
        Token lv_operator_1_1=null;
        Token lv_operator_1_2=null;
        Token lv_operator_1_3=null;
        EObject lv_terminal_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1333:6: ( ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1334:1: ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1334:1: ( ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1334:2: ( (lv_feature_0_0= RULE_ID ) ) ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) ) ( (lv_terminal_2_0= ruleAssignableTerminal ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1334:2: ( (lv_feature_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1335:1: (lv_feature_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1335:1: (lv_feature_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1336:3: lv_feature_0_0= RULE_ID
            {
            lv_feature_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignment2600); 

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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1358:2: ( ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1359:1: ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1359:1: ( (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1360:1: (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1360:1: (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' )
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
                    new NoViableAltException("1360:1: (lv_operator_1_1= '+=' | lv_operator_1_2= '=' | lv_operator_1_3= '?=' )", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1361:3: lv_operator_1_1= '+='
                    {
                    lv_operator_1_1=(Token)input.LT(1);
                    match(input,31,FOLLOW_31_in_ruleAssignment2624); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1379:8: lv_operator_1_2= '='
                    {
                    lv_operator_1_2=(Token)input.LT(1);
                    match(input,30,FOLLOW_30_in_ruleAssignment2652); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1397:8: lv_operator_1_3= '?='
                    {
                    lv_operator_1_3=(Token)input.LT(1);
                    match(input,34,FOLLOW_34_in_ruleAssignment2680); 

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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1418:2: ( (lv_terminal_2_0= ruleAssignableTerminal ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1419:1: (lv_terminal_2_0= ruleAssignableTerminal )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1419:1: (lv_terminal_2_0= ruleAssignableTerminal )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1420:3: lv_terminal_2_0= ruleAssignableTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAssignableTerminal_in_ruleAssignment2717);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1449:1: entryRuleAssignableTerminal returns [EObject current=null] : iv_ruleAssignableTerminal= ruleAssignableTerminal EOF ;
    public final EObject entryRuleAssignableTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignableTerminal = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1449:60: (iv_ruleAssignableTerminal= ruleAssignableTerminal EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1450:2: iv_ruleAssignableTerminal= ruleAssignableTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignableTerminalRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal2750);
            iv_ruleAssignableTerminal=ruleAssignableTerminal();
            _fsp--;

             current =iv_ruleAssignableTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignableTerminal2760); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1457:1: ruleAssignableTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference ) ;
    public final EObject ruleAssignableTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedAssignableElement_2 = null;

        EObject this_CrossReference_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1462:6: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1463:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1463:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )
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
                    new NoViableAltException("1463:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1464:5: this_Keyword_0= ruleKeyword
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleKeyword_in_ruleAssignableTerminal2807);
                    this_Keyword_0=ruleKeyword();
                    _fsp--;

                     
                            current = this_Keyword_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1474:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRuleCall_in_ruleAssignableTerminal2834);
                    this_RuleCall_1=ruleRuleCall();
                    _fsp--;

                     
                            current = this_RuleCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1484:5: this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedAssignableElement_in_ruleAssignableTerminal2861);
                    this_ParenthesizedAssignableElement_2=ruleParenthesizedAssignableElement();
                    _fsp--;

                     
                            current = this_ParenthesizedAssignableElement_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1494:5: this_CrossReference_3= ruleCrossReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCrossReference_in_ruleAssignableTerminal2888);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1509:1: entryRuleParenthesizedAssignableElement returns [EObject current=null] : iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF ;
    public final EObject entryRuleParenthesizedAssignableElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedAssignableElement = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1509:72: (iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1510:2: iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedAssignableElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement2920);
            iv_ruleParenthesizedAssignableElement=ruleParenthesizedAssignableElement();
            _fsp--;

             current =iv_ruleParenthesizedAssignableElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement2930); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1517:1: ruleParenthesizedAssignableElement returns [EObject current=null] : ( '(' this_AssignableAlternatives_1= ruleAssignableAlternatives ')' ) ;
    public final EObject ruleParenthesizedAssignableElement() throws RecognitionException {
        EObject current = null;

        EObject this_AssignableAlternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1522:6: ( ( '(' this_AssignableAlternatives_1= ruleAssignableAlternatives ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1523:1: ( '(' this_AssignableAlternatives_1= ruleAssignableAlternatives ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1523:1: ( '(' this_AssignableAlternatives_1= ruleAssignableAlternatives ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1523:2: '(' this_AssignableAlternatives_1= ruleAssignableAlternatives ')'
            {
            match(input,15,FOLLOW_15_in_ruleParenthesizedAssignableElement2964); 

                    createLeafNode(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleAssignableAlternatives_in_ruleParenthesizedAssignableElement2986);
            this_AssignableAlternatives_1=ruleAssignableAlternatives();
            _fsp--;

             
                    current = this_AssignableAlternatives_1; 
                    currentNode = currentNode.getParent();
                
            match(input,16,FOLLOW_16_in_ruleParenthesizedAssignableElement2994); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1547:1: entryRuleAssignableAlternatives returns [EObject current=null] : iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF ;
    public final EObject entryRuleAssignableAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignableAlternatives = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1547:64: (iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1548:2: iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignableAlternativesRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives3027);
            iv_ruleAssignableAlternatives=ruleAssignableAlternatives();
            _fsp--;

             current =iv_ruleAssignableAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignableAlternatives3037); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1555:1: ruleAssignableAlternatives returns [EObject current=null] : (this_AssignableTerminal_0= ruleAssignableTerminal ( () ( '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )? ) ;
    public final EObject ruleAssignableAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_AssignableTerminal_0 = null;

        EObject lv_groups_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1560:6: ( (this_AssignableTerminal_0= ruleAssignableTerminal ( () ( '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1561:1: (this_AssignableTerminal_0= ruleAssignableTerminal ( () ( '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1561:1: (this_AssignableTerminal_0= ruleAssignableTerminal ( () ( '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1562:5: this_AssignableTerminal_0= ruleAssignableTerminal ( () ( '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3084);
            this_AssignableTerminal_0=ruleAssignableTerminal();
            _fsp--;

             
                    current = this_AssignableTerminal_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1570:1: ( () ( '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+ )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==25) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1570:2: () ( '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1570:2: ()
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1571:5: 
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

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1586:2: ( '|' ( (lv_groups_3_0= ruleAssignableTerminal ) ) )+
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
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1586:3: '|' ( (lv_groups_3_0= ruleAssignableTerminal ) )
                    	    {
                    	    match(input,25,FOLLOW_25_in_ruleAssignableAlternatives3103); 

                    	            createLeafNode(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1590:1: ( (lv_groups_3_0= ruleAssignableTerminal ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1591:1: (lv_groups_3_0= ruleAssignableTerminal )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1591:1: (lv_groups_3_0= ruleAssignableTerminal )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1592:3: lv_groups_3_0= ruleAssignableTerminal
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAssignableAlternativesAccess().getGroupsAssignableTerminalParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3124);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1621:1: entryRuleCrossReference returns [EObject current=null] : iv_ruleCrossReference= ruleCrossReference EOF ;
    public final EObject entryRuleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReference = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1621:56: (iv_ruleCrossReference= ruleCrossReference EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1622:2: iv_ruleCrossReference= ruleCrossReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCrossReferenceRule(), currentNode); 
            pushFollow(FOLLOW_ruleCrossReference_in_entryRuleCrossReference3161);
            iv_ruleCrossReference=ruleCrossReference();
            _fsp--;

             current =iv_ruleCrossReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReference3171); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1629:1: ruleCrossReference returns [EObject current=null] : ( '[' ( (lv_type_1_0= ruleTypeRef ) ) ( '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? ']' ) ;
    public final EObject ruleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject lv_type_1_0 = null;

        EObject lv_terminal_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1634:6: ( ( '[' ( (lv_type_1_0= ruleTypeRef ) ) ( '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? ']' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1635:1: ( '[' ( (lv_type_1_0= ruleTypeRef ) ) ( '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? ']' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1635:1: ( '[' ( (lv_type_1_0= ruleTypeRef ) ) ( '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? ']' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1635:2: '[' ( (lv_type_1_0= ruleTypeRef ) ) ( '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? ']'
            {
            match(input,35,FOLLOW_35_in_ruleCrossReference3205); 

                    createLeafNode(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1639:1: ( (lv_type_1_0= ruleTypeRef ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1640:1: (lv_type_1_0= ruleTypeRef )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1640:1: (lv_type_1_0= ruleTypeRef )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1641:3: lv_type_1_0= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleCrossReference3226);
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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1663:2: ( '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==25) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1663:3: '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    {
                    match(input,25,FOLLOW_25_in_ruleCrossReference3236); 

                            createLeafNode(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1667:1: ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1668:1: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1668:1: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1669:3: lv_terminal_3_0= ruleCrossReferenceableTerminal
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReference3257);
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

            match(input,36,FOLLOW_36_in_ruleCrossReference3268); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1702:1: entryRuleCrossReferenceableTerminal returns [EObject current=null] : iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF ;
    public final EObject entryRuleCrossReferenceableTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReferenceableTerminal = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1702:68: (iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1703:2: iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCrossReferenceableTerminalRule(), currentNode); 
            pushFollow(FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal3301);
            iv_ruleCrossReferenceableTerminal=ruleCrossReferenceableTerminal();
            _fsp--;

             current =iv_ruleCrossReferenceableTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal3311); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1710:1: ruleCrossReferenceableTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement ) ;
    public final EObject ruleCrossReferenceableTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedCrossReferenceableElement_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1715:6: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1716:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1716:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement )
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
                    new NoViableAltException("1716:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement )", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1717:5: this_Keyword_0= ruleKeyword
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleKeyword_in_ruleCrossReferenceableTerminal3358);
                    this_Keyword_0=ruleKeyword();
                    _fsp--;

                     
                            current = this_Keyword_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1727:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRuleCall_in_ruleCrossReferenceableTerminal3385);
                    this_RuleCall_1=ruleRuleCall();
                    _fsp--;

                     
                            current = this_RuleCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1737:5: this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCrossReferenceableTerminalAccess().getParenthesizedCrossReferenceableElementParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedCrossReferenceableElement_in_ruleCrossReferenceableTerminal3412);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1752:1: entryRuleParenthesizedCrossReferenceableElement returns [EObject current=null] : iv_ruleParenthesizedCrossReferenceableElement= ruleParenthesizedCrossReferenceableElement EOF ;
    public final EObject entryRuleParenthesizedCrossReferenceableElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedCrossReferenceableElement = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1752:80: (iv_ruleParenthesizedCrossReferenceableElement= ruleParenthesizedCrossReferenceableElement EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1753:2: iv_ruleParenthesizedCrossReferenceableElement= ruleParenthesizedCrossReferenceableElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedCrossReferenceableElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedCrossReferenceableElement_in_entryRuleParenthesizedCrossReferenceableElement3444);
            iv_ruleParenthesizedCrossReferenceableElement=ruleParenthesizedCrossReferenceableElement();
            _fsp--;

             current =iv_ruleParenthesizedCrossReferenceableElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedCrossReferenceableElement3454); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1760:1: ruleParenthesizedCrossReferenceableElement returns [EObject current=null] : ( '(' this_CrossReferenceableAlternatives_1= ruleCrossReferenceableAlternatives ')' ) ;
    public final EObject ruleParenthesizedCrossReferenceableElement() throws RecognitionException {
        EObject current = null;

        EObject this_CrossReferenceableAlternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1765:6: ( ( '(' this_CrossReferenceableAlternatives_1= ruleCrossReferenceableAlternatives ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1766:1: ( '(' this_CrossReferenceableAlternatives_1= ruleCrossReferenceableAlternatives ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1766:1: ( '(' this_CrossReferenceableAlternatives_1= ruleCrossReferenceableAlternatives ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1766:2: '(' this_CrossReferenceableAlternatives_1= ruleCrossReferenceableAlternatives ')'
            {
            match(input,15,FOLLOW_15_in_ruleParenthesizedCrossReferenceableElement3488); 

                    createLeafNode(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getCrossReferenceableAlternativesParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleCrossReferenceableAlternatives_in_ruleParenthesizedCrossReferenceableElement3510);
            this_CrossReferenceableAlternatives_1=ruleCrossReferenceableAlternatives();
            _fsp--;

             
                    current = this_CrossReferenceableAlternatives_1; 
                    currentNode = currentNode.getParent();
                
            match(input,16,FOLLOW_16_in_ruleParenthesizedCrossReferenceableElement3518); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1790:1: entryRuleCrossReferenceableAlternatives returns [EObject current=null] : iv_ruleCrossReferenceableAlternatives= ruleCrossReferenceableAlternatives EOF ;
    public final EObject entryRuleCrossReferenceableAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReferenceableAlternatives = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1790:72: (iv_ruleCrossReferenceableAlternatives= ruleCrossReferenceableAlternatives EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1791:2: iv_ruleCrossReferenceableAlternatives= ruleCrossReferenceableAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCrossReferenceableAlternativesRule(), currentNode); 
            pushFollow(FOLLOW_ruleCrossReferenceableAlternatives_in_entryRuleCrossReferenceableAlternatives3551);
            iv_ruleCrossReferenceableAlternatives=ruleCrossReferenceableAlternatives();
            _fsp--;

             current =iv_ruleCrossReferenceableAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReferenceableAlternatives3561); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1798:1: ruleCrossReferenceableAlternatives returns [EObject current=null] : (this_CrossReferenceableTerminal_0= ruleCrossReferenceableTerminal ( () ( '|' ( (lv_groups_3_0= ruleCrossReferenceableTerminal ) ) )+ )? ) ;
    public final EObject ruleCrossReferenceableAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_CrossReferenceableTerminal_0 = null;

        EObject lv_groups_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1803:6: ( (this_CrossReferenceableTerminal_0= ruleCrossReferenceableTerminal ( () ( '|' ( (lv_groups_3_0= ruleCrossReferenceableTerminal ) ) )+ )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1804:1: (this_CrossReferenceableTerminal_0= ruleCrossReferenceableTerminal ( () ( '|' ( (lv_groups_3_0= ruleCrossReferenceableTerminal ) ) )+ )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1804:1: (this_CrossReferenceableTerminal_0= ruleCrossReferenceableTerminal ( () ( '|' ( (lv_groups_3_0= ruleCrossReferenceableTerminal ) ) )+ )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1805:5: this_CrossReferenceableTerminal_0= ruleCrossReferenceableTerminal ( () ( '|' ( (lv_groups_3_0= ruleCrossReferenceableTerminal ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getCrossReferenceableAlternativesAccess().getCrossReferenceableTerminalParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReferenceableAlternatives3608);
            this_CrossReferenceableTerminal_0=ruleCrossReferenceableTerminal();
            _fsp--;

             
                    current = this_CrossReferenceableTerminal_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1813:1: ( () ( '|' ( (lv_groups_3_0= ruleCrossReferenceableTerminal ) ) )+ )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==25) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1813:2: () ( '|' ( (lv_groups_3_0= ruleCrossReferenceableTerminal ) ) )+
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1813:2: ()
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1814:5: 
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

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1829:2: ( '|' ( (lv_groups_3_0= ruleCrossReferenceableTerminal ) ) )+
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
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1829:3: '|' ( (lv_groups_3_0= ruleCrossReferenceableTerminal ) )
                    	    {
                    	    match(input,25,FOLLOW_25_in_ruleCrossReferenceableAlternatives3627); 

                    	            createLeafNode(grammarAccess.getCrossReferenceableAlternativesAccess().getVerticalLineKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1833:1: ( (lv_groups_3_0= ruleCrossReferenceableTerminal ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1834:1: (lv_groups_3_0= ruleCrossReferenceableTerminal )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1834:1: (lv_groups_3_0= ruleCrossReferenceableTerminal )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1835:3: lv_groups_3_0= ruleCrossReferenceableTerminal
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getCrossReferenceableAlternativesAccess().getGroupsCrossReferenceableTerminalParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReferenceableAlternatives3648);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1864:1: entryRuleParenthesizedElement returns [EObject current=null] : iv_ruleParenthesizedElement= ruleParenthesizedElement EOF ;
    public final EObject entryRuleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedElement = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1864:62: (iv_ruleParenthesizedElement= ruleParenthesizedElement EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1865:2: iv_ruleParenthesizedElement= ruleParenthesizedElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement3685);
            iv_ruleParenthesizedElement=ruleParenthesizedElement();
            _fsp--;

             current =iv_ruleParenthesizedElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedElement3695); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1872:1: ruleParenthesizedElement returns [EObject current=null] : ( '(' this_Alternatives_1= ruleAlternatives ')' ) ;
    public final EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Alternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1877:6: ( ( '(' this_Alternatives_1= ruleAlternatives ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1878:1: ( '(' this_Alternatives_1= ruleAlternatives ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1878:1: ( '(' this_Alternatives_1= ruleAlternatives ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1878:2: '(' this_Alternatives_1= ruleAlternatives ')'
            {
            match(input,15,FOLLOW_15_in_ruleParenthesizedElement3729); 

                    createLeafNode(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesizedElement3751);
            this_Alternatives_1=ruleAlternatives();
            _fsp--;

             
                    current = this_Alternatives_1; 
                    currentNode = currentNode.getParent();
                
            match(input,16,FOLLOW_16_in_ruleParenthesizedElement3759); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1902:1: entryRuleTerminalRule returns [EObject current=null] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final EObject entryRuleTerminalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1902:54: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1903:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule3792);
            iv_ruleTerminalRule=ruleTerminalRule();
            _fsp--;

             current =iv_ruleTerminalRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalRule3802); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1910:1: ruleTerminalRule returns [EObject current=null] : ( 'terminal' ( (lv_name_1_0= RULE_ID ) ) ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) ';' ) ;
    public final EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_3_0 = null;

        EObject lv_alternatives_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1915:6: ( ( 'terminal' ( (lv_name_1_0= RULE_ID ) ) ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1916:1: ( 'terminal' ( (lv_name_1_0= RULE_ID ) ) ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1916:1: ( 'terminal' ( (lv_name_1_0= RULE_ID ) ) ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1916:2: 'terminal' ( (lv_name_1_0= RULE_ID ) ) ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? ':' ( (lv_alternatives_5_0= ruleTerminalAlternatives ) ) ';'
            {
            match(input,37,FOLLOW_37_in_ruleTerminalRule3836); 

                    createLeafNode(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1920:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1921:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1921:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1922:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTerminalRule3853); 

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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1944:2: ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==21) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1944:3: 'returns' ( (lv_type_3_0= ruleTypeRef ) )
                    {
                    match(input,21,FOLLOW_21_in_ruleTerminalRule3868); 

                            createLeafNode(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1948:1: ( (lv_type_3_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1949:1: (lv_type_3_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1949:1: (lv_type_3_0= ruleTypeRef )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1950:3: lv_type_3_0= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleTerminalRule3889);
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

            match(input,22,FOLLOW_22_in_ruleTerminalRule3900); 

                    createLeafNode(grammarAccess.getTerminalRuleAccess().getColonKeyword_3(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1976:1: ( (lv_alternatives_5_0= ruleTerminalAlternatives ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1977:1: (lv_alternatives_5_0= ruleTerminalAlternatives )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1977:1: (lv_alternatives_5_0= ruleTerminalAlternatives )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1978:3: lv_alternatives_5_0= ruleTerminalAlternatives
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule3921);
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

            match(input,23,FOLLOW_23_in_ruleTerminalRule3930); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2011:1: entryRuleTerminalAlternatives returns [EObject current=null] : iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF ;
    public final EObject entryRuleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalAlternatives = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2011:62: (iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2012:2: iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalAlternativesRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives3963);
            iv_ruleTerminalAlternatives=ruleTerminalAlternatives();
            _fsp--;

             current =iv_ruleTerminalAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalAlternatives3973); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2019:1: ruleTerminalAlternatives returns [EObject current=null] : (this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )? ) ;
    public final EObject ruleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalGroup_0 = null;

        EObject lv_groups_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2024:6: ( (this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2025:1: (this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2025:1: (this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2026:5: this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4020);
            this_TerminalGroup_0=ruleTerminalGroup();
            _fsp--;

             
                    current = this_TerminalGroup_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2034:1: ( () ( '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+ )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==25) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2034:2: () ( '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2034:2: ()
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2035:5: 
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

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2050:2: ( '|' ( (lv_groups_3_0= ruleTerminalGroup ) ) )+
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
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2050:3: '|' ( (lv_groups_3_0= ruleTerminalGroup ) )
                    	    {
                    	    match(input,25,FOLLOW_25_in_ruleTerminalAlternatives4039); 

                    	            createLeafNode(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2054:1: ( (lv_groups_3_0= ruleTerminalGroup ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2055:1: (lv_groups_3_0= ruleTerminalGroup )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2055:1: (lv_groups_3_0= ruleTerminalGroup )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2056:3: lv_groups_3_0= ruleTerminalGroup
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getTerminalAlternativesAccess().getGroupsTerminalGroupParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4060);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2085:1: entryRuleTerminalGroup returns [EObject current=null] : iv_ruleTerminalGroup= ruleTerminalGroup EOF ;
    public final EObject entryRuleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalGroup = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2085:55: (iv_ruleTerminalGroup= ruleTerminalGroup EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2086:2: iv_ruleTerminalGroup= ruleTerminalGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalGroupRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup4097);
            iv_ruleTerminalGroup=ruleTerminalGroup();
            _fsp--;

             current =iv_ruleTerminalGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalGroup4107); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2093:1: ruleTerminalGroup returns [EObject current=null] : (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )? ) ;
    public final EObject ruleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalToken_0 = null;

        EObject lv_tokens_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2098:6: ( (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2099:1: (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2099:1: (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2100:5: this_TerminalToken_0= ruleTerminalToken ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4154);
            this_TerminalToken_0=ruleTerminalToken();
            _fsp--;

             
                    current = this_TerminalToken_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2108:1: ( () ( (lv_tokens_2_0= ruleTerminalToken ) )+ )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=RULE_ID && LA41_0<=RULE_STRING)||LA41_0==15||LA41_0==17||(LA41_0>=38 && LA41_0<=39)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2108:2: () ( (lv_tokens_2_0= ruleTerminalToken ) )+
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2108:2: ()
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2109:5: 
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

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2124:2: ( (lv_tokens_2_0= ruleTerminalToken ) )+
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
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2125:1: (lv_tokens_2_0= ruleTerminalToken )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2125:1: (lv_tokens_2_0= ruleTerminalToken )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2126:3: lv_tokens_2_0= ruleTerminalToken
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getTerminalGroupAccess().getTokensTerminalTokenParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4184);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2155:1: entryRuleTerminalToken returns [EObject current=null] : iv_ruleTerminalToken= ruleTerminalToken EOF ;
    public final EObject entryRuleTerminalToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalToken = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2155:55: (iv_ruleTerminalToken= ruleTerminalToken EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2156:2: iv_ruleTerminalToken= ruleTerminalToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalTokenRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken4220);
            iv_ruleTerminalToken=ruleTerminalToken();
            _fsp--;

             current =iv_ruleTerminalToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalToken4230); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2163:1: ruleTerminalToken returns [EObject current=null] : (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? ) ;
    public final EObject ruleTerminalToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_1_1=null;
        Token lv_cardinality_1_2=null;
        Token lv_cardinality_1_3=null;
        EObject this_TerminalTokenElement_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2168:6: ( (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2169:1: (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2169:1: (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2170:5: this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken4277);
            this_TerminalTokenElement_0=ruleTerminalTokenElement();
            _fsp--;

             
                    current = this_TerminalTokenElement_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2178:1: ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=26 && LA43_0<=28)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2179:1: ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2179:1: ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2180:1: (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2180:1: (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' )
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
                            new NoViableAltException("2180:1: (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' )", 42, 0, input);

                        throw nvae;
                    }

                    switch (alt42) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2181:3: lv_cardinality_1_1= '?'
                            {
                            lv_cardinality_1_1=(Token)input.LT(1);
                            match(input,26,FOLLOW_26_in_ruleTerminalToken4295); 

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
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2199:8: lv_cardinality_1_2= '*'
                            {
                            lv_cardinality_1_2=(Token)input.LT(1);
                            match(input,27,FOLLOW_27_in_ruleTerminalToken4323); 

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
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2217:8: lv_cardinality_1_3= '+'
                            {
                            lv_cardinality_1_3=(Token)input.LT(1);
                            match(input,28,FOLLOW_28_in_ruleTerminalToken4351); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2245:1: entryRuleTerminalTokenElement returns [EObject current=null] : iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF ;
    public final EObject entryRuleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalTokenElement = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2245:62: (iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2246:2: iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalTokenElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement4401);
            iv_ruleTerminalTokenElement=ruleTerminalTokenElement();
            _fsp--;

             current =iv_ruleTerminalTokenElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalTokenElement4411); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2253:1: ruleTerminalTokenElement returns [EObject current=null] : (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard ) ;
    public final EObject ruleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject this_CharacterRange_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedTerminalElement_2 = null;

        EObject this_AbstractNegatedToken_3 = null;

        EObject this_Wildcard_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2258:6: ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2259:1: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2259:1: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )
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
                    new NoViableAltException("2259:1: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2260:5: this_CharacterRange_0= ruleCharacterRange
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement4458);
                    this_CharacterRange_0=ruleCharacterRange();
                    _fsp--;

                     
                            current = this_CharacterRange_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2270:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement4485);
                    this_RuleCall_1=ruleRuleCall();
                    _fsp--;

                     
                            current = this_RuleCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2280:5: this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement4512);
                    this_ParenthesizedTerminalElement_2=ruleParenthesizedTerminalElement();
                    _fsp--;

                     
                            current = this_ParenthesizedTerminalElement_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2290:5: this_AbstractNegatedToken_3= ruleAbstractNegatedToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement4539);
                    this_AbstractNegatedToken_3=ruleAbstractNegatedToken();
                    _fsp--;

                     
                            current = this_AbstractNegatedToken_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2300:5: this_Wildcard_4= ruleWildcard
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleWildcard_in_ruleTerminalTokenElement4566);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2315:1: entryRuleParenthesizedTerminalElement returns [EObject current=null] : iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF ;
    public final EObject entryRuleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedTerminalElement = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2315:70: (iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2316:2: iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedTerminalElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4598);
            iv_ruleParenthesizedTerminalElement=ruleParenthesizedTerminalElement();
            _fsp--;

             current =iv_ruleParenthesizedTerminalElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4608); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2323:1: ruleParenthesizedTerminalElement returns [EObject current=null] : ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')' ) ;
    public final EObject ruleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalAlternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2328:6: ( ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2329:1: ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2329:1: ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2329:2: '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')'
            {
            match(input,15,FOLLOW_15_in_ruleParenthesizedTerminalElement4642); 

                    createLeafNode(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4664);
            this_TerminalAlternatives_1=ruleTerminalAlternatives();
            _fsp--;

             
                    current = this_TerminalAlternatives_1; 
                    currentNode = currentNode.getParent();
                
            match(input,16,FOLLOW_16_in_ruleParenthesizedTerminalElement4672); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2353:1: entryRuleAbstractNegatedToken returns [EObject current=null] : iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF ;
    public final EObject entryRuleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractNegatedToken = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2353:62: (iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2354:2: iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractNegatedTokenRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken4705);
            iv_ruleAbstractNegatedToken=ruleAbstractNegatedToken();
            _fsp--;

             current =iv_ruleAbstractNegatedToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractNegatedToken4715); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2361:1: ruleAbstractNegatedToken returns [EObject current=null] : (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) ;
    public final EObject ruleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject this_NegatedToken_0 = null;

        EObject this_UntilToken_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2366:6: ( (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2367:1: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2367:1: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
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
                    new NoViableAltException("2367:1: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2368:5: this_NegatedToken_0= ruleNegatedToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken4762);
                    this_NegatedToken_0=ruleNegatedToken();
                    _fsp--;

                     
                            current = this_NegatedToken_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2378:5: this_UntilToken_1= ruleUntilToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUntilToken_in_ruleAbstractNegatedToken4789);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2393:1: entryRuleNegatedToken returns [EObject current=null] : iv_ruleNegatedToken= ruleNegatedToken EOF ;
    public final EObject entryRuleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegatedToken = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2393:54: (iv_ruleNegatedToken= ruleNegatedToken EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2394:2: iv_ruleNegatedToken= ruleNegatedToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNegatedTokenRule(), currentNode); 
            pushFollow(FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken4821);
            iv_ruleNegatedToken=ruleNegatedToken();
            _fsp--;

             current =iv_ruleNegatedToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegatedToken4831); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2401:1: ruleNegatedToken returns [EObject current=null] : ( '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final EObject ruleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2406:6: ( ( '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2407:1: ( '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2407:1: ( '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2407:2: '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {
            match(input,38,FOLLOW_38_in_ruleNegatedToken4865); 

                    createLeafNode(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2411:1: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2412:1: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2412:1: (lv_terminal_1_0= ruleTerminalTokenElement )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2413:3: lv_terminal_1_0= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken4886);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2442:1: entryRuleUntilToken returns [EObject current=null] : iv_ruleUntilToken= ruleUntilToken EOF ;
    public final EObject entryRuleUntilToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUntilToken = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2442:52: (iv_ruleUntilToken= ruleUntilToken EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2443:2: iv_ruleUntilToken= ruleUntilToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUntilTokenRule(), currentNode); 
            pushFollow(FOLLOW_ruleUntilToken_in_entryRuleUntilToken4919);
            iv_ruleUntilToken=ruleUntilToken();
            _fsp--;

             current =iv_ruleUntilToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUntilToken4929); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2450:1: ruleUntilToken returns [EObject current=null] : ( '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final EObject ruleUntilToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2455:6: ( ( '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2456:1: ( '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2456:1: ( '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2456:2: '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {
            match(input,39,FOLLOW_39_in_ruleUntilToken4963); 

                    createLeafNode(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2460:1: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2461:1: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2461:1: (lv_terminal_1_0= ruleTerminalTokenElement )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2462:3: lv_terminal_1_0= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleUntilToken4984);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2491:1: entryRuleWildcard returns [EObject current=null] : iv_ruleWildcard= ruleWildcard EOF ;
    public final EObject entryRuleWildcard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcard = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2491:50: (iv_ruleWildcard= ruleWildcard EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2492:2: iv_ruleWildcard= ruleWildcard EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWildcardRule(), currentNode); 
            pushFollow(FOLLOW_ruleWildcard_in_entryRuleWildcard5017);
            iv_ruleWildcard=ruleWildcard();
            _fsp--;

             current =iv_ruleWildcard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWildcard5027); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2499:1: ruleWildcard returns [EObject current=null] : ( () '.' ) ;
    public final EObject ruleWildcard() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2504:6: ( ( () '.' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2505:1: ( () '.' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2505:1: ( () '.' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2505:2: () '.'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2505:2: ()
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2506:5: 
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

            match(input,17,FOLLOW_17_in_ruleWildcard5070); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2527:1: entryRuleCharacterRange returns [EObject current=null] : iv_ruleCharacterRange= ruleCharacterRange EOF ;
    public final EObject entryRuleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterRange = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2527:56: (iv_ruleCharacterRange= ruleCharacterRange EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2528:2: iv_ruleCharacterRange= ruleCharacterRange EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCharacterRangeRule(), currentNode); 
            pushFollow(FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange5103);
            iv_ruleCharacterRange=ruleCharacterRange();
            _fsp--;

             current =iv_ruleCharacterRange; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCharacterRange5113); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2535:1: ruleCharacterRange returns [EObject current=null] : (this_Keyword_0= ruleKeyword ( () '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) ;
    public final EObject ruleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject lv_right_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2540:6: ( (this_Keyword_0= ruleKeyword ( () '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2541:1: (this_Keyword_0= ruleKeyword ( () '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2541:1: (this_Keyword_0= ruleKeyword ( () '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2542:5: this_Keyword_0= ruleKeyword ( () '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleKeyword_in_ruleCharacterRange5160);
            this_Keyword_0=ruleKeyword();
            _fsp--;

             
                    current = this_Keyword_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2550:1: ( () '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==40) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2550:2: () '..' ( (lv_right_3_0= ruleKeyword ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2550:2: ()
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2551:5: 
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

                    match(input,40,FOLLOW_40_in_ruleCharacterRange5178); 

                            createLeafNode(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2570:1: ( (lv_right_3_0= ruleKeyword ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2571:1: (lv_right_3_0= ruleKeyword )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2571:1: (lv_right_3_0= ruleKeyword )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2572:3: lv_right_3_0= ruleKeyword
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleKeyword_in_ruleCharacterRange5199);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2601:1: entryRuleEnumRule returns [EObject current=null] : iv_ruleEnumRule= ruleEnumRule EOF ;
    public final EObject entryRuleEnumRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2601:50: (iv_ruleEnumRule= ruleEnumRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2602:2: iv_ruleEnumRule= ruleEnumRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleEnumRule_in_entryRuleEnumRule5234);
            iv_ruleEnumRule=ruleEnumRule();
            _fsp--;

             current =iv_ruleEnumRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumRule5244); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2609:1: ruleEnumRule returns [EObject current=null] : ( 'enum' ( (lv_name_1_0= RULE_ID ) ) ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) ';' ) ;
    public final EObject ruleEnumRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_3_0 = null;

        EObject lv_alternatives_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2614:6: ( ( 'enum' ( (lv_name_1_0= RULE_ID ) ) ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2615:1: ( 'enum' ( (lv_name_1_0= RULE_ID ) ) ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2615:1: ( 'enum' ( (lv_name_1_0= RULE_ID ) ) ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2615:2: 'enum' ( (lv_name_1_0= RULE_ID ) ) ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )? ':' ( (lv_alternatives_5_0= ruleEnumLiterals ) ) ';'
            {
            match(input,41,FOLLOW_41_in_ruleEnumRule5278); 

                    createLeafNode(grammarAccess.getEnumRuleAccess().getEnumKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2619:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2620:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2620:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2621:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnumRule5295); 

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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2643:2: ( 'returns' ( (lv_type_3_0= ruleTypeRef ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==21) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2643:3: 'returns' ( (lv_type_3_0= ruleTypeRef ) )
                    {
                    match(input,21,FOLLOW_21_in_ruleEnumRule5310); 

                            createLeafNode(grammarAccess.getEnumRuleAccess().getReturnsKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2647:1: ( (lv_type_3_0= ruleTypeRef ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2648:1: (lv_type_3_0= ruleTypeRef )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2648:1: (lv_type_3_0= ruleTypeRef )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2649:3: lv_type_3_0= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleEnumRule5331);
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

            match(input,22,FOLLOW_22_in_ruleEnumRule5342); 

                    createLeafNode(grammarAccess.getEnumRuleAccess().getColonKeyword_3(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2675:1: ( (lv_alternatives_5_0= ruleEnumLiterals ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2676:1: (lv_alternatives_5_0= ruleEnumLiterals )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2676:1: (lv_alternatives_5_0= ruleEnumLiterals )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2677:3: lv_alternatives_5_0= ruleEnumLiterals
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEnumLiterals_in_ruleEnumRule5363);
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

            match(input,23,FOLLOW_23_in_ruleEnumRule5372); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2710:1: entryRuleEnumLiterals returns [EObject current=null] : iv_ruleEnumLiterals= ruleEnumLiterals EOF ;
    public final EObject entryRuleEnumLiterals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiterals = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2710:54: (iv_ruleEnumLiterals= ruleEnumLiterals EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2711:2: iv_ruleEnumLiterals= ruleEnumLiterals EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumLiteralsRule(), currentNode); 
            pushFollow(FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals5405);
            iv_ruleEnumLiterals=ruleEnumLiterals();
            _fsp--;

             current =iv_ruleEnumLiterals; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumLiterals5415); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2718:1: ruleEnumLiterals returns [EObject current=null] : (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () ( '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) ;
    public final EObject ruleEnumLiterals() throws RecognitionException {
        EObject current = null;

        EObject this_EnumLiteralDeclaration_0 = null;

        EObject lv_groups_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2723:6: ( (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () ( '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2724:1: (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () ( '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2724:1: (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () ( '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2725:5: this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () ( '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals5462);
            this_EnumLiteralDeclaration_0=ruleEnumLiteralDeclaration();
            _fsp--;

             
                    current = this_EnumLiteralDeclaration_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2733:1: ( () ( '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==25) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2733:2: () ( '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2733:2: ()
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2734:5: 
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

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2749:2: ( '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) ) )+
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
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2749:3: '|' ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) )
                    	    {
                    	    match(input,25,FOLLOW_25_in_ruleEnumLiterals5481); 

                    	            createLeafNode(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2753:1: ( (lv_groups_3_0= ruleEnumLiteralDeclaration ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2754:1: (lv_groups_3_0= ruleEnumLiteralDeclaration )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2754:1: (lv_groups_3_0= ruleEnumLiteralDeclaration )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2755:3: lv_groups_3_0= ruleEnumLiteralDeclaration
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEnumLiteralsAccess().getGroupsEnumLiteralDeclarationParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals5502);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2784:1: entryRuleEnumLiteralDeclaration returns [EObject current=null] : iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF ;
    public final EObject entryRuleEnumLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteralDeclaration = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2784:64: (iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2785:2: iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumLiteralDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration5539);
            iv_ruleEnumLiteralDeclaration=ruleEnumLiteralDeclaration();
            _fsp--;

             current =iv_ruleEnumLiteralDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration5549); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2792:1: ruleEnumLiteralDeclaration returns [EObject current=null] : ( ( ( RULE_ID ) ) ( '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) ;
    public final EObject ruleEnumLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        EObject lv_literal_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2797:6: ( ( ( ( RULE_ID ) ) ( '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2798:1: ( ( ( RULE_ID ) ) ( '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2798:1: ( ( ( RULE_ID ) ) ( '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2798:2: ( ( RULE_ID ) ) ( '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2798:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2799:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2799:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2800:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getEnumLiteralDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnumLiteralDeclaration5592); 

            		createLeafNode(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0(), "enumLiteral"); 
            	

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2812:2: ( '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==30) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2812:3: '=' ( (lv_literal_2_0= ruleKeyword ) )
                    {
                    match(input,30,FOLLOW_30_in_ruleEnumLiteralDeclaration5602); 

                            createLeafNode(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2816:1: ( (lv_literal_2_0= ruleKeyword ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2817:1: (lv_literal_2_0= ruleKeyword )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2817:1: (lv_literal_2_0= ruleKeyword )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2818:3: lv_literal_2_0= ruleKeyword
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleKeyword_in_ruleEnumLiteralDeclaration5623);
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


 

    public static final BitSet FOLLOW_ruleGrammar_in_entryRuleGrammar73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammar83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleGrammar117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar138 = new BitSet(new long[]{0x0000022000145010L});
    public static final BitSet FOLLOW_12_in_ruleGrammar148 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar171 = new BitSet(new long[]{0x0000022000146010L});
    public static final BitSet FOLLOW_13_in_ruleGrammar181 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar204 = new BitSet(new long[]{0x0000022000146010L});
    public static final BitSet FOLLOW_14_in_ruleGrammar226 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleGrammar248 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar267 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_13_in_ruleGrammar277 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar295 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_16_in_ruleGrammar308 = new BitSet(new long[]{0x0000022000140010L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar331 = new BitSet(new long[]{0x0000022000140010L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleGrammar353 = new BitSet(new long[]{0x0000022000000012L});
    public static final BitSet FOLLOW_ruleGrammarID_in_entryRuleGrammarID388 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammarID399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarID439 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleGrammarID458 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarID473 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleAbstractRule575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_ruleAbstractRule602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumRule_in_ruleAbstractRule629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel777 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGeneratedMetamodel787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleGeneratedMetamodel821 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel838 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel861 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleGeneratedMetamodel871 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel928 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleReferencedMetamodel972 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel990 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleReferencedMetamodel1000 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel1017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_entryRuleParserRule1057 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParserRule1067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1109 = new BitSet(new long[]{0x0000000000604000L});
    public static final BitSet FOLLOW_21_in_ruleParserRule1124 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule1145 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_14_in_ruleParserRule1165 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleParserRule1187 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1206 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_13_in_ruleParserRule1216 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1234 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_16_in_ruleParserRule1247 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleParserRule1258 = new BitSet(new long[]{0x0000000020008030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule1279 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleParserRule1288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef1321 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef1331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef1375 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleTypeRef1384 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef1404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives1437 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives1447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives1494 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleAlternatives1513 = new BitSet(new long[]{0x0000000020008030L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives1534 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup1571 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroup1581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup1628 = new BitSet(new long[]{0x0000000020008032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup1658 = new BitSet(new long[]{0x0000000020008032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken1694 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken1704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_ruleAbstractToken1751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken1778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality1810 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality1820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractTokenWithCardinality1868 = new BitSet(new long[]{0x000000001C000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractTokenWithCardinality1895 = new BitSet(new long[]{0x000000001C000002L});
    public static final BitSet FOLLOW_26_in_ruleAbstractTokenWithCardinality1914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleAbstractTokenWithCardinality1942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleAbstractTokenWithCardinality1970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_entryRuleAction2020 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAction2030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleAction2064 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction2085 = new BitSet(new long[]{0x0000000200020000L});
    public static final BitSet FOLLOW_17_in_ruleAction2095 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAction2112 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30_in_ruleAction2136 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_31_in_ruleAction2164 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleAction2189 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleAction2200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal2233 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal2243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal2290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal2317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal2344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword2376 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword2386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword2427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall2464 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall2474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall2516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment2548 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment2558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment2600 = new BitSet(new long[]{0x00000004C0000000L});
    public static final BitSet FOLLOW_31_in_ruleAssignment2624 = new BitSet(new long[]{0x0000000800008030L});
    public static final BitSet FOLLOW_30_in_ruleAssignment2652 = new BitSet(new long[]{0x0000000800008030L});
    public static final BitSet FOLLOW_34_in_ruleAssignment2680 = new BitSet(new long[]{0x0000000800008030L});
    public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignment2717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal2750 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignableTerminal2760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleAssignableTerminal2807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleAssignableTerminal2834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_ruleAssignableTerminal2861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_ruleAssignableTerminal2888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement2920 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement2930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedAssignableElement2964 = new BitSet(new long[]{0x0000000800008030L});
    public static final BitSet FOLLOW_ruleAssignableAlternatives_in_ruleParenthesizedAssignableElement2986 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParenthesizedAssignableElement2994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives3027 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignableAlternatives3037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3084 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleAssignableAlternatives3103 = new BitSet(new long[]{0x0000000800008030L});
    public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3124 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference3161 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference3171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleCrossReference3205 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleCrossReference3226 = new BitSet(new long[]{0x0000001002000000L});
    public static final BitSet FOLLOW_25_in_ruleCrossReference3236 = new BitSet(new long[]{0x0000000000008030L});
    public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReference3257 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleCrossReference3268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal3301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal3311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCrossReferenceableTerminal3358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleCrossReferenceableTerminal3385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedCrossReferenceableElement_in_ruleCrossReferenceableTerminal3412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedCrossReferenceableElement_in_entryRuleParenthesizedCrossReferenceableElement3444 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedCrossReferenceableElement3454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedCrossReferenceableElement3488 = new BitSet(new long[]{0x0000000000008030L});
    public static final BitSet FOLLOW_ruleCrossReferenceableAlternatives_in_ruleParenthesizedCrossReferenceableElement3510 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParenthesizedCrossReferenceableElement3518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReferenceableAlternatives_in_entryRuleCrossReferenceableAlternatives3551 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReferenceableAlternatives3561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReferenceableAlternatives3608 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleCrossReferenceableAlternatives3627 = new BitSet(new long[]{0x0000000000008030L});
    public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReferenceableAlternatives3648 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement3685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement3695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedElement3729 = new BitSet(new long[]{0x0000000020008030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement3751 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParenthesizedElement3759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule3792 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule3802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleTerminalRule3836 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTerminalRule3853 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_ruleTerminalRule3868 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleTerminalRule3889 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTerminalRule3900 = new BitSet(new long[]{0x000000C000028030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule3921 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleTerminalRule3930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives3963 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives3973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4020 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleTerminalAlternatives4039 = new BitSet(new long[]{0x000000C000028030L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4060 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup4097 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup4107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4154 = new BitSet(new long[]{0x000000C000028032L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4184 = new BitSet(new long[]{0x000000C000028032L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken4220 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken4230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken4277 = new BitSet(new long[]{0x000000001C000002L});
    public static final BitSet FOLLOW_26_in_ruleTerminalToken4295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleTerminalToken4323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleTerminalToken4351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement4401 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement4411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement4458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement4485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement4512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement4539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_ruleTerminalTokenElement4566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4598 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedTerminalElement4642 = new BitSet(new long[]{0x000000C000028030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4664 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParenthesizedTerminalElement4672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken4705 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken4715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken4762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUntilToken_in_ruleAbstractNegatedToken4789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken4821 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken4831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleNegatedToken4865 = new BitSet(new long[]{0x000000C000028030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken4886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUntilToken_in_entryRuleUntilToken4919 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUntilToken4929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleUntilToken4963 = new BitSet(new long[]{0x000000C000028030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleUntilToken4984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard5017 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcard5027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleWildcard5070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange5103 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange5113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange5160 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleCharacterRange5178 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange5199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumRule_in_entryRuleEnumRule5234 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumRule5244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleEnumRule5278 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnumRule5295 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_ruleEnumRule5310 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleEnumRule5331 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleEnumRule5342 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleEnumLiterals_in_ruleEnumRule5363 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleEnumRule5372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumLiterals_in_entryRuleEnumLiterals5405 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiterals5415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals5462 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleEnumLiterals5481 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_ruleEnumLiterals5502 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleEnumLiteralDeclaration_in_entryRuleEnumLiteralDeclaration5539 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumLiteralDeclaration5549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnumLiteralDeclaration5592 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_ruleEnumLiteralDeclaration5602 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleEnumLiteralDeclaration5623 = new BitSet(new long[]{0x0000000000000002L});

}