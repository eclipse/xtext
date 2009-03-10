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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'grammar'", "'with'", "','", "'hidden'", "'('", "')'", "'.'", "'generate'", "'as'", "'import'", "'returns'", "':'", "';'", "'::'", "'|'", "'?'", "'*'", "'+'", "'{'", "'='", "'+='", "'current'", "'}'", "'?='", "'['", "']'", "'terminal'", "'!'", "'->'", "'..'"
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
    public String getGrammarFileName() { return "../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g"; }


     
     	private XtextGrammarTestLanguageGrammarAccess grammarAccess;
     	
        public InternalXtextGrammarTestLanguageParser(TokenStream input, IAstFactory factory, XtextGrammarTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:69:1: entryRuleGrammar returns [EObject current=null] : iv_ruleGrammar= ruleGrammar EOF ;
    public final EObject entryRuleGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammar = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:69:49: (iv_ruleGrammar= ruleGrammar EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:70:2: iv_ruleGrammar= ruleGrammar EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGrammarRule(), currentNode); 
            pushFollow(FOLLOW_ruleGrammar_in_entryRuleGrammar71);
            iv_ruleGrammar=ruleGrammar();
            _fsp--;

             current =iv_ruleGrammar; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGrammar81); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:77:1: ruleGrammar returns [EObject current=null] : ( 'grammar' (lv_name_1= ruleGrammarID ) ( 'with' ( ruleGrammarID ) ( ',' ( ruleGrammarID ) )* )? ( (lv_definesHiddenTokens_6= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? (lv_metamodelDeclarations_12= ruleAbstractMetamodelDeclaration )* (lv_rules_13= ruleAbstractRule )+ ) ;
    public final EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        Token lv_definesHiddenTokens_6=null;
        AntlrDatatypeRuleToken lv_name_1 = null;

        EObject lv_metamodelDeclarations_12 = null;

        EObject lv_rules_13 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:82:6: ( ( 'grammar' (lv_name_1= ruleGrammarID ) ( 'with' ( ruleGrammarID ) ( ',' ( ruleGrammarID ) )* )? ( (lv_definesHiddenTokens_6= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? (lv_metamodelDeclarations_12= ruleAbstractMetamodelDeclaration )* (lv_rules_13= ruleAbstractRule )+ ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:83:1: ( 'grammar' (lv_name_1= ruleGrammarID ) ( 'with' ( ruleGrammarID ) ( ',' ( ruleGrammarID ) )* )? ( (lv_definesHiddenTokens_6= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? (lv_metamodelDeclarations_12= ruleAbstractMetamodelDeclaration )* (lv_rules_13= ruleAbstractRule )+ )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:83:1: ( 'grammar' (lv_name_1= ruleGrammarID ) ( 'with' ( ruleGrammarID ) ( ',' ( ruleGrammarID ) )* )? ( (lv_definesHiddenTokens_6= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? (lv_metamodelDeclarations_12= ruleAbstractMetamodelDeclaration )* (lv_rules_13= ruleAbstractRule )+ )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:83:2: 'grammar' (lv_name_1= ruleGrammarID ) ( 'with' ( ruleGrammarID ) ( ',' ( ruleGrammarID ) )* )? ( (lv_definesHiddenTokens_6= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? (lv_metamodelDeclarations_12= ruleAbstractMetamodelDeclaration )* (lv_rules_13= ruleAbstractRule )+
            {
            match(input,11,FOLLOW_11_in_ruleGrammar115); 

                    createLeafNode(grammarAccess.getGrammarAccess().getGrammarKeyword_0(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:87:1: (lv_name_1= ruleGrammarID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:90:6: lv_name_1= ruleGrammarID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleGrammarID_in_ruleGrammar149);
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

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:108:2: ( 'with' ( ruleGrammarID ) ( ',' ( ruleGrammarID ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:108:3: 'with' ( ruleGrammarID ) ( ',' ( ruleGrammarID ) )*
                    {
                    match(input,12,FOLLOW_12_in_ruleGrammar163); 

                            createLeafNode(grammarAccess.getGrammarAccess().getWithKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:112:1: ( ruleGrammarID )
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:115:3: ruleGrammarID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleGrammarID_in_ruleGrammar190);
                    ruleGrammarID();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:130:2: ( ',' ( ruleGrammarID ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:130:3: ',' ( ruleGrammarID )
                    	    {
                    	    match(input,13,FOLLOW_13_in_ruleGrammar203); 

                    	            createLeafNode(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:134:1: ( ruleGrammarID )
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:137:3: ruleGrammarID
                    	    {

                    	    			if (current==null) {
                    	    	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	            
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleGrammarID_in_ruleGrammar230);
                    	    ruleGrammarID();
                    	    _fsp--;

                    	     
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:152:6: ( (lv_definesHiddenTokens_6= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:152:7: (lv_definesHiddenTokens_6= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')'
                    {
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:152:7: (lv_definesHiddenTokens_6= 'hidden' )
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:154:6: lv_definesHiddenTokens_6= 'hidden'
                    {
                    lv_definesHiddenTokens_6=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleGrammar259); 

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

                    match(input,15,FOLLOW_15_in_ruleGrammar281); 

                            createLeafNode(grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1(), null); 
                        
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:177:1: ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:177:2: ( RULE_ID ) ( ',' ( RULE_ID ) )*
                            {
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:177:2: ( RULE_ID )
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:180:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar304); 

                            		createLeafNode(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0(), "hiddenTokens"); 
                            	

                            }

                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:193:2: ( ',' ( RULE_ID ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==13) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:193:3: ',' ( RULE_ID )
                            	    {
                            	    match(input,13,FOLLOW_13_in_ruleGrammar317); 

                            	            createLeafNode(grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0(), null); 
                            	        
                            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:197:1: ( RULE_ID )
                            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:200:3: RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create(grammarAccess.getGrammarRule().getType().getClassifier());
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar339); 

                            	    		createLeafNode(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0(), "hiddenTokens"); 
                            	    	

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

                    match(input,16,FOLLOW_16_in_ruleGrammar355); 

                            createLeafNode(grammarAccess.getGrammarAccess().getRightParenthesisKeyword_3_3(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:217:3: (lv_metamodelDeclarations_12= ruleAbstractMetamodelDeclaration )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18||LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:220:6: lv_metamodelDeclarations_12= ruleAbstractMetamodelDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar391);
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

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:238:3: (lv_rules_13= ruleAbstractRule )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==37) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:241:6: lv_rules_13= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleGrammar430);
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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:266:1: entryRuleGrammarID returns [String current=null] : iv_ruleGrammarID= ruleGrammarID EOF ;
    public final String entryRuleGrammarID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGrammarID = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:266:50: (iv_ruleGrammarID= ruleGrammarID EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:267:2: iv_ruleGrammarID= ruleGrammarID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGrammarIDRule(), currentNode); 
            pushFollow(FOLLOW_ruleGrammarID_in_entryRuleGrammarID469);
            iv_ruleGrammarID=ruleGrammarID();
            _fsp--;

             current =iv_ruleGrammarID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGrammarID480); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:274:1: ruleGrammarID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleGrammarID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:280:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:281:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:281:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:281:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammarID520); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:288:1: (kw= '.' this_ID_2= RULE_ID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:289:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,17,FOLLOW_17_in_ruleGrammarID539); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammarID554); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:309:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:309:54: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:310:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule599);
            iv_ruleAbstractRule=ruleAbstractRule();
            _fsp--;

             current =iv_ruleAbstractRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRule609); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:317:1: ruleAbstractRule returns [EObject current=null] : (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_ParserRule_0 = null;

        EObject this_TerminalRule_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:322:6: ( (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:323:1: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:323:1: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            else if ( (LA9_0==37) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("323:1: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:324:5: this_ParserRule_0= ruleParserRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParserRule_in_ruleAbstractRule656);
                    this_ParserRule_0=ruleParserRule();
                    _fsp--;

                     
                            current = this_ParserRule_0; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:338:5: this_TerminalRule_1= ruleTerminalRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTerminalRule_in_ruleAbstractRule690);
                    this_TerminalRule_1=ruleTerminalRule();
                    _fsp--;

                     
                            current = this_TerminalRule_1; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1(), null); 
                        

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:357:1: entryRuleAbstractMetamodelDeclaration returns [EObject current=null] : iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF ;
    public final EObject entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractMetamodelDeclaration = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:357:70: (iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:358:2: iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractMetamodelDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration729);
            iv_ruleAbstractMetamodelDeclaration=ruleAbstractMetamodelDeclaration();
            _fsp--;

             current =iv_ruleAbstractMetamodelDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration739); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:365:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) ;
    public final EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel_0 = null;

        EObject this_ReferencedMetamodel_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:370:6: ( (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:371:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:371:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
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
                    new NoViableAltException("371:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:372:5: this_GeneratedMetamodel_0= ruleGeneratedMetamodel
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration786);
                    this_GeneratedMetamodel_0=ruleGeneratedMetamodel();
                    _fsp--;

                     
                            current = this_GeneratedMetamodel_0; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:386:5: this_ReferencedMetamodel_1= ruleReferencedMetamodel
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration820);
                    this_ReferencedMetamodel_1=ruleReferencedMetamodel();
                    _fsp--;

                     
                            current = this_ReferencedMetamodel_1; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1(), null); 
                        

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:405:1: entryRuleGeneratedMetamodel returns [EObject current=null] : iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF ;
    public final EObject entryRuleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratedMetamodel = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:405:60: (iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:406:2: iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGeneratedMetamodelRule(), currentNode); 
            pushFollow(FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel859);
            iv_ruleGeneratedMetamodel=ruleGeneratedMetamodel();
            _fsp--;

             current =iv_ruleGeneratedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGeneratedMetamodel869); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:413:1: ruleGeneratedMetamodel returns [EObject current=null] : ( 'generate' (lv_name_1= RULE_ID ) ( RULE_STRING ) ( 'as' (lv_alias_4= RULE_ID ) )? ) ;
    public final EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_alias_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:418:6: ( ( 'generate' (lv_name_1= RULE_ID ) ( RULE_STRING ) ( 'as' (lv_alias_4= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:419:1: ( 'generate' (lv_name_1= RULE_ID ) ( RULE_STRING ) ( 'as' (lv_alias_4= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:419:1: ( 'generate' (lv_name_1= RULE_ID ) ( RULE_STRING ) ( 'as' (lv_alias_4= RULE_ID ) )? )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:419:2: 'generate' (lv_name_1= RULE_ID ) ( RULE_STRING ) ( 'as' (lv_alias_4= RULE_ID ) )?
            {
            match(input,18,FOLLOW_18_in_ruleGeneratedMetamodel903); 

                    createLeafNode(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:423:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:425:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel925); 

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

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:443:2: ( RULE_STRING )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:446:3: RULE_STRING
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getGeneratedMetamodelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel955); 

            		createLeafNode(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0(), "ePackage"); 
            	

            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:459:2: ( 'as' (lv_alias_4= RULE_ID ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:459:3: 'as' (lv_alias_4= RULE_ID )
                    {
                    match(input,19,FOLLOW_19_in_ruleGeneratedMetamodel968); 

                            createLeafNode(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:463:1: (lv_alias_4= RULE_ID )
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:465:6: lv_alias_4= RULE_ID
                    {
                    lv_alias_4=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel990); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:490:1: entryRuleReferencedMetamodel returns [EObject current=null] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final EObject entryRuleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedMetamodel = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:490:61: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:491:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferencedMetamodelRule(), currentNode); 
            pushFollow(FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel1033);
            iv_ruleReferencedMetamodel=ruleReferencedMetamodel();
            _fsp--;

             current =iv_ruleReferencedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencedMetamodel1043); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:498:1: ruleReferencedMetamodel returns [EObject current=null] : ( 'import' ( RULE_STRING ) ( 'as' (lv_alias_3= RULE_ID ) )? ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_alias_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:503:6: ( ( 'import' ( RULE_STRING ) ( 'as' (lv_alias_3= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:504:1: ( 'import' ( RULE_STRING ) ( 'as' (lv_alias_3= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:504:1: ( 'import' ( RULE_STRING ) ( 'as' (lv_alias_3= RULE_ID ) )? )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:504:2: 'import' ( RULE_STRING ) ( 'as' (lv_alias_3= RULE_ID ) )?
            {
            match(input,20,FOLLOW_20_in_ruleReferencedMetamodel1077); 

                    createLeafNode(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:508:1: ( RULE_STRING )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:511:3: RULE_STRING
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferencedMetamodelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1099); 

            		createLeafNode(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0(), "ePackage"); 
            	

            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:524:2: ( 'as' (lv_alias_3= RULE_ID ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:524:3: 'as' (lv_alias_3= RULE_ID )
                    {
                    match(input,19,FOLLOW_19_in_ruleReferencedMetamodel1112); 

                            createLeafNode(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:528:1: (lv_alias_3= RULE_ID )
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:530:6: lv_alias_3= RULE_ID
                    {
                    lv_alias_3=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedMetamodel1134); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:555:1: entryRuleParserRule returns [EObject current=null] : iv_ruleParserRule= ruleParserRule EOF ;
    public final EObject entryRuleParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRule = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:555:52: (iv_ruleParserRule= ruleParserRule EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:556:2: iv_ruleParserRule= ruleParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParserRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleParserRule_in_entryRuleParserRule1177);
            iv_ruleParserRule=ruleParserRule();
            _fsp--;

             current =iv_ruleParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParserRule1187); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:563:1: ruleParserRule returns [EObject current=null] : ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? ':' (lv_alternatives_10= ruleAlternatives ) ';' ) ;
    public final EObject ruleParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        Token lv_definesHiddenTokens_3=null;
        EObject lv_type_2 = null;

        EObject lv_alternatives_10 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:568:6: ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? ':' (lv_alternatives_10= ruleAlternatives ) ';' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:569:1: ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? ':' (lv_alternatives_10= ruleAlternatives ) ';' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:569:1: ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? ':' (lv_alternatives_10= ruleAlternatives ) ';' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:569:2: (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? ':' (lv_alternatives_10= ruleAlternatives ) ';'
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:569:2: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:571:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1234); 

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

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:589:2: ( 'returns' (lv_type_2= ruleTypeRef ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==21) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:589:3: 'returns' (lv_type_2= ruleTypeRef )
                    {
                    match(input,21,FOLLOW_21_in_ruleParserRule1252); 

                            createLeafNode(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:593:1: (lv_type_2= ruleTypeRef )
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:596:6: lv_type_2= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleParserRule1286);
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

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:614:4: ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:614:5: (lv_definesHiddenTokens_3= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')'
                    {
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:614:5: (lv_definesHiddenTokens_3= 'hidden' )
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:616:6: lv_definesHiddenTokens_3= 'hidden'
                    {
                    lv_definesHiddenTokens_3=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleParserRule1314); 

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

                    match(input,15,FOLLOW_15_in_ruleParserRule1336); 

                            createLeafNode(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1(), null); 
                        
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:639:1: ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_ID) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:639:2: ( RULE_ID ) ( ',' ( RULE_ID ) )*
                            {
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:639:2: ( RULE_ID )
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:642:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.getParserRuleRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1359); 

                            		createLeafNode(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0(), "hiddenTokens"); 
                            	

                            }

                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:655:2: ( ',' ( RULE_ID ) )*
                            loop14:
                            do {
                                int alt14=2;
                                int LA14_0 = input.LA(1);

                                if ( (LA14_0==13) ) {
                                    alt14=1;
                                }


                                switch (alt14) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:655:3: ',' ( RULE_ID )
                            	    {
                            	    match(input,13,FOLLOW_13_in_ruleParserRule1372); 

                            	            createLeafNode(grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0(), null); 
                            	        
                            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:659:1: ( RULE_ID )
                            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:662:3: RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create(grammarAccess.getParserRuleRule().getType().getClassifier());
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1394); 

                            	    		createLeafNode(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0(), "hiddenTokens"); 
                            	    	

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

                    match(input,16,FOLLOW_16_in_ruleParserRule1410); 

                            createLeafNode(grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_2_3(), null); 
                        

                    }
                    break;

            }

            match(input,22,FOLLOW_22_in_ruleParserRule1421); 

                    createLeafNode(grammarAccess.getParserRuleAccess().getColonKeyword_3(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:683:1: (lv_alternatives_10= ruleAlternatives )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:686:6: lv_alternatives_10= ruleAlternatives
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParserRule1455);
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

            match(input,23,FOLLOW_23_in_ruleParserRule1468); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:715:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:715:49: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:716:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRefRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef1501);
            iv_ruleTypeRef=ruleTypeRef();
            _fsp--;

             current =iv_ruleTypeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef1511); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:723:1: ruleTypeRef returns [EObject current=null] : ( ( ( RULE_ID ) '::' )? ( RULE_ID ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:728:6: ( ( ( ( RULE_ID ) '::' )? ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:729:1: ( ( ( RULE_ID ) '::' )? ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:729:1: ( ( ( RULE_ID ) '::' )? ( RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:729:2: ( ( RULE_ID ) '::' )? ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:729:2: ( ( RULE_ID ) '::' )?
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
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:729:3: ( RULE_ID ) '::'
                    {
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:729:3: ( RULE_ID )
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:732:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRefRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef1559); 

                    		createLeafNode(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0(), "metamodel"); 
                    	

                    }

                    match(input,24,FOLLOW_24_in_ruleTypeRef1571); 

                            createLeafNode(grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:749:3: ( RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:752:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getTypeRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef1595); 

            		createLeafNode(grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0(), "classifier"); 
            	

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:772:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:772:54: (iv_ruleAlternatives= ruleAlternatives EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:773:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAlternativesRule(), currentNode); 
            pushFollow(FOLLOW_ruleAlternatives_in_entryRuleAlternatives1631);
            iv_ruleAlternatives=ruleAlternatives();
            _fsp--;

             current =iv_ruleAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternatives1641); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:780:1: ruleAlternatives returns [EObject current=null] : (this_Group_0= ruleGroup ( () ( '|' (lv_groups_3= ruleGroup ) )+ )? ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_Group_0 = null;

        EObject lv_groups_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:785:6: ( (this_Group_0= ruleGroup ( () ( '|' (lv_groups_3= ruleGroup ) )+ )? ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:786:1: (this_Group_0= ruleGroup ( () ( '|' (lv_groups_3= ruleGroup ) )+ )? )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:786:1: (this_Group_0= ruleGroup ( () ( '|' (lv_groups_3= ruleGroup ) )+ )? )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:787:5: this_Group_0= ruleGroup ( () ( '|' (lv_groups_3= ruleGroup ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAlternativesAccess().getGroupParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives1688);
            this_Group_0=ruleGroup();
            _fsp--;

             
                    current = this_Group_0; 
                    currentNode = currentNode.getParent();
                
             
                createLeafNode(grammarAccess.getAlternativesAccess().getGroupParserRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:799:1: ( () ( '|' (lv_groups_3= ruleGroup ) )+ )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==25) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:799:2: () ( '|' (lv_groups_3= ruleGroup ) )+
                    {
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:799:2: ()
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:800:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getAlternativesAccess().getAlternativesgroupsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "groups", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getAlternativesAccess().getAlternativesgroupsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:815:2: ( '|' (lv_groups_3= ruleGroup ) )+
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
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:815:3: '|' (lv_groups_3= ruleGroup )
                    	    {
                    	    match(input,25,FOLLOW_25_in_ruleAlternatives1714); 

                    	            createLeafNode(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:819:1: (lv_groups_3= ruleGroup )
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:822:6: lv_groups_3= ruleGroup
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAlternativesAccess().getGroupsGroupParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives1748);
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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:847:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:847:47: (iv_ruleGroup= ruleGroup EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:848:2: iv_ruleGroup= ruleGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGroupRule(), currentNode); 
            pushFollow(FOLLOW_ruleGroup_in_entryRuleGroup1789);
            iv_ruleGroup=ruleGroup();
            _fsp--;

             current =iv_ruleGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroup1799); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:855:1: ruleGroup returns [EObject current=null] : (this_AbstractToken_0= ruleAbstractToken ( () (lv_tokens_2= ruleAbstractToken )+ )? ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken_0 = null;

        EObject lv_tokens_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:860:6: ( (this_AbstractToken_0= ruleAbstractToken ( () (lv_tokens_2= ruleAbstractToken )+ )? ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:861:1: (this_AbstractToken_0= ruleAbstractToken ( () (lv_tokens_2= ruleAbstractToken )+ )? )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:861:1: (this_AbstractToken_0= ruleAbstractToken ( () (lv_tokens_2= ruleAbstractToken )+ )? )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:862:5: this_AbstractToken_0= ruleAbstractToken ( () (lv_tokens_2= ruleAbstractToken )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup1846);
            this_AbstractToken_0=ruleAbstractToken();
            _fsp--;

             
                    current = this_AbstractToken_0; 
                    currentNode = currentNode.getParent();
                
             
                createLeafNode(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:874:1: ( () (lv_tokens_2= ruleAbstractToken )+ )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_STRING)||LA21_0==15||LA21_0==29) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:874:2: () (lv_tokens_2= ruleAbstractToken )+
                    {
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:874:2: ()
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:875:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getGroupAccess().getGrouptokensAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "tokens", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getGroupAccess().getGrouptokensAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:890:2: (lv_tokens_2= ruleAbstractToken )+
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
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:893:6: lv_tokens_2= ruleAbstractToken
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getGroupAccess().getTokensAbstractTokenParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup1896);
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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:918:1: entryRuleAbstractToken returns [EObject current=null] : iv_ruleAbstractToken= ruleAbstractToken EOF ;
    public final EObject entryRuleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractToken = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:918:55: (iv_ruleAbstractToken= ruleAbstractToken EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:919:2: iv_ruleAbstractToken= ruleAbstractToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractTokenRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken1936);
            iv_ruleAbstractToken=ruleAbstractToken();
            _fsp--;

             current =iv_ruleAbstractToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractToken1946); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:926:1: ruleAbstractToken returns [EObject current=null] : (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction ) ;
    public final EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractTokenWithCardinality_0 = null;

        EObject this_Action_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:931:6: ( (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:932:1: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:932:1: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )
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
                    new NoViableAltException("932:1: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction )", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:933:5: this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractTokenWithCardinality_in_ruleAbstractToken1993);
                    this_AbstractTokenWithCardinality_0=ruleAbstractTokenWithCardinality();
                    _fsp--;

                     
                            current = this_AbstractTokenWithCardinality_0; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:947:5: this_Action_1= ruleAction
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAction_in_ruleAbstractToken2027);
                    this_Action_1=ruleAction();
                    _fsp--;

                     
                            current = this_Action_1; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1(), null); 
                        

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:966:1: entryRuleAbstractTokenWithCardinality returns [EObject current=null] : iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF ;
    public final EObject entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTokenWithCardinality = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:966:70: (iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:967:2: iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractTokenWithCardinalityRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality2066);
            iv_ruleAbstractTokenWithCardinality=ruleAbstractTokenWithCardinality();
            _fsp--;

             current =iv_ruleAbstractTokenWithCardinality; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality2076); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:974:1: ruleAbstractTokenWithCardinality returns [EObject current=null] : ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) (lv_cardinality_2= ( '?' | '*' | '+' ) )? ) ;
    public final EObject ruleAbstractTokenWithCardinality() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_2=null;
        EObject this_Assignment_0 = null;

        EObject this_AbstractTerminal_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:979:6: ( ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) (lv_cardinality_2= ( '?' | '*' | '+' ) )? ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:980:1: ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) (lv_cardinality_2= ( '?' | '*' | '+' ) )? )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:980:1: ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) (lv_cardinality_2= ( '?' | '*' | '+' ) )? )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:980:2: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) (lv_cardinality_2= ( '?' | '*' | '+' ) )?
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:980:2: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal )
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
                        new NoViableAltException("980:2: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal )", 23, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA23_0==RULE_STRING||LA23_0==15) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("980:2: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal )", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:981:5: this_Assignment_0= ruleAssignment
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAssignment_in_ruleAbstractTokenWithCardinality2124);
                    this_Assignment_0=ruleAssignment();
                    _fsp--;

                     
                            current = this_Assignment_0; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:995:5: this_AbstractTerminal_1= ruleAbstractTerminal
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAbstractTokenWithCardinality2158);
                    this_AbstractTerminal_1=ruleAbstractTerminal();
                    _fsp--;

                     
                            current = this_AbstractTerminal_1; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1007:2: (lv_cardinality_2= ( '?' | '*' | '+' ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=26 && LA25_0<=28)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1009:6: lv_cardinality_2= ( '?' | '*' | '+' )
                    {
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1009:23: ( '?' | '*' | '+' )
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
                            new NoViableAltException("1009:23: ( '?' | '*' | '+' )", 24, 0, input);

                        throw nvae;
                    }

                    switch (alt24) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1009:24: '?'
                            {
                            match(input,26,FOLLOW_26_in_ruleAbstractTokenWithCardinality2187); 

                                    createLeafNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0(), "cardinality"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1015:6: '*'
                            {
                            match(input,27,FOLLOW_27_in_ruleAbstractTokenWithCardinality2203); 

                                    createLeafNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1(), "cardinality"); 
                                

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1021:6: '+'
                            {
                            match(input,28,FOLLOW_28_in_ruleAbstractTokenWithCardinality2219); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1048:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1048:48: (iv_ruleAction= ruleAction EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1049:2: iv_ruleAction= ruleAction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAction_in_entryRuleAction2268);
            iv_ruleAction=ruleAction();
            _fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAction2278); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1056:1: ruleAction returns [EObject current=null] : ( '{' (lv_type_1= ruleTypeRef ) ( '.' (lv_feature_3= RULE_ID ) (lv_operator_4= ( '=' | '+=' ) ) 'current' )? '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_feature_3=null;
        Token lv_operator_4=null;
        EObject lv_type_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1061:6: ( ( '{' (lv_type_1= ruleTypeRef ) ( '.' (lv_feature_3= RULE_ID ) (lv_operator_4= ( '=' | '+=' ) ) 'current' )? '}' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1062:1: ( '{' (lv_type_1= ruleTypeRef ) ( '.' (lv_feature_3= RULE_ID ) (lv_operator_4= ( '=' | '+=' ) ) 'current' )? '}' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1062:1: ( '{' (lv_type_1= ruleTypeRef ) ( '.' (lv_feature_3= RULE_ID ) (lv_operator_4= ( '=' | '+=' ) ) 'current' )? '}' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1062:2: '{' (lv_type_1= ruleTypeRef ) ( '.' (lv_feature_3= RULE_ID ) (lv_operator_4= ( '=' | '+=' ) ) 'current' )? '}'
            {
            match(input,29,FOLLOW_29_in_ruleAction2312); 

                    createLeafNode(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1066:1: (lv_type_1= ruleTypeRef )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1069:6: lv_type_1= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAction2346);
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

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1087:2: ( '.' (lv_feature_3= RULE_ID ) (lv_operator_4= ( '=' | '+=' ) ) 'current' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==17) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1087:3: '.' (lv_feature_3= RULE_ID ) (lv_operator_4= ( '=' | '+=' ) ) 'current'
                    {
                    match(input,17,FOLLOW_17_in_ruleAction2360); 

                            createLeafNode(grammarAccess.getActionAccess().getFullStopKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1091:1: (lv_feature_3= RULE_ID )
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1093:6: lv_feature_3= RULE_ID
                    {
                    lv_feature_3=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAction2382); 

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

                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1111:2: (lv_operator_4= ( '=' | '+=' ) )
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1113:6: lv_operator_4= ( '=' | '+=' )
                    {
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1113:20: ( '=' | '+=' )
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
                            new NoViableAltException("1113:20: ( '=' | '+=' )", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1113:21: '='
                            {
                            match(input,30,FOLLOW_30_in_ruleAction2412); 

                                    createLeafNode(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0(), "operator"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1119:6: '+='
                            {
                            match(input,31,FOLLOW_31_in_ruleAction2428); 

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

                    match(input,32,FOLLOW_32_in_ruleAction2452); 

                            createLeafNode(grammarAccess.getActionAccess().getCurrentKeyword_2_3(), null); 
                        

                    }
                    break;

            }

            match(input,33,FOLLOW_33_in_ruleAction2463); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1154:1: entryRuleAbstractTerminal returns [EObject current=null] : iv_ruleAbstractTerminal= ruleAbstractTerminal EOF ;
    public final EObject entryRuleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTerminal = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1154:58: (iv_ruleAbstractTerminal= ruleAbstractTerminal EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1155:2: iv_ruleAbstractTerminal= ruleAbstractTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractTerminalRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal2496);
            iv_ruleAbstractTerminal=ruleAbstractTerminal();
            _fsp--;

             current =iv_ruleAbstractTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractTerminal2506); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1162:1: ruleAbstractTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement ) ;
    public final EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedElement_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1167:6: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1168:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1168:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement )
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
                    new NoViableAltException("1168:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement )", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1169:5: this_Keyword_0= ruleKeyword
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleKeyword_in_ruleAbstractTerminal2553);
                    this_Keyword_0=ruleKeyword();
                    _fsp--;

                     
                            current = this_Keyword_0; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1183:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRuleCall_in_ruleAbstractTerminal2587);
                    this_RuleCall_1=ruleRuleCall();
                    _fsp--;

                     
                            current = this_RuleCall_1; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1197:5: this_ParenthesizedElement_2= ruleParenthesizedElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal2621);
                    this_ParenthesizedElement_2=ruleParenthesizedElement();
                    _fsp--;

                     
                            current = this_ParenthesizedElement_2; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2(), null); 
                        

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1216:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1216:49: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1217:2: iv_ruleKeyword= ruleKeyword EOF
            {
             currentNode = createCompositeNode(grammarAccess.getKeywordRule(), currentNode); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword2660);
            iv_ruleKeyword=ruleKeyword();
            _fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword2670); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1224:1: ruleKeyword returns [EObject current=null] : (lv_value_0= RULE_STRING ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1229:6: ( (lv_value_0= RULE_STRING ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1230:1: (lv_value_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1230:1: (lv_value_0= RULE_STRING )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1232:6: lv_value_0= RULE_STRING
            {
            lv_value_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword2716); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1257:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1257:50: (iv_ruleRuleCall= ruleRuleCall EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1258:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleRuleCall_in_entryRuleRuleCall2756);
            iv_ruleRuleCall=ruleRuleCall();
            _fsp--;

             current =iv_ruleRuleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleCall2766); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1265:1: ruleRuleCall returns [EObject current=null] : ( RULE_ID ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1270:6: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1271:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1271:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1274:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getRuleCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall2812); 

            		createLeafNode(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0(), "rule"); 
            	

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1294:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1294:52: (iv_ruleAssignment= ruleAssignment EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1295:2: iv_ruleAssignment= ruleAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignmentRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment2847);
            iv_ruleAssignment=ruleAssignment();
            _fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment2857); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1302:1: ruleAssignment returns [EObject current=null] : ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( '+=' | '=' | '?=' ) ) (lv_terminal_2= ruleAssignableTerminal ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0=null;
        Token lv_operator_1=null;
        EObject lv_terminal_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1307:6: ( ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( '+=' | '=' | '?=' ) ) (lv_terminal_2= ruleAssignableTerminal ) ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1308:1: ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( '+=' | '=' | '?=' ) ) (lv_terminal_2= ruleAssignableTerminal ) )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1308:1: ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( '+=' | '=' | '?=' ) ) (lv_terminal_2= ruleAssignableTerminal ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1308:2: (lv_feature_0= RULE_ID ) (lv_operator_1= ( '+=' | '=' | '?=' ) ) (lv_terminal_2= ruleAssignableTerminal )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1308:2: (lv_feature_0= RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1310:6: lv_feature_0= RULE_ID
            {
            lv_feature_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignment2904); 

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

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1328:2: (lv_operator_1= ( '+=' | '=' | '?=' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1330:6: lv_operator_1= ( '+=' | '=' | '?=' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1330:20: ( '+=' | '=' | '?=' )
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
                    new NoViableAltException("1330:20: ( '+=' | '=' | '?=' )", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1330:21: '+='
                    {
                    match(input,31,FOLLOW_31_in_ruleAssignment2934); 

                            createLeafNode(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_1_0_0(), "operator"); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1336:6: '='
                    {
                    match(input,30,FOLLOW_30_in_ruleAssignment2950); 

                            createLeafNode(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_1_0_1(), "operator"); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1342:6: '?='
                    {
                    match(input,34,FOLLOW_34_in_ruleAssignment2966); 

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

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1362:2: (lv_terminal_2= ruleAssignableTerminal )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1365:6: lv_terminal_2= ruleAssignableTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAssignableTerminal_in_ruleAssignment3015);
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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1390:1: entryRuleAssignableTerminal returns [EObject current=null] : iv_ruleAssignableTerminal= ruleAssignableTerminal EOF ;
    public final EObject entryRuleAssignableTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignableTerminal = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1390:60: (iv_ruleAssignableTerminal= ruleAssignableTerminal EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1391:2: iv_ruleAssignableTerminal= ruleAssignableTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignableTerminalRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal3052);
            iv_ruleAssignableTerminal=ruleAssignableTerminal();
            _fsp--;

             current =iv_ruleAssignableTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignableTerminal3062); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1398:1: ruleAssignableTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference ) ;
    public final EObject ruleAssignableTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedAssignableElement_2 = null;

        EObject this_CrossReference_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1403:6: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1404:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1404:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )
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
                    new NoViableAltException("1404:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1405:5: this_Keyword_0= ruleKeyword
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleKeyword_in_ruleAssignableTerminal3109);
                    this_Keyword_0=ruleKeyword();
                    _fsp--;

                     
                            current = this_Keyword_0; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1419:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRuleCall_in_ruleAssignableTerminal3143);
                    this_RuleCall_1=ruleRuleCall();
                    _fsp--;

                     
                            current = this_RuleCall_1; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1433:5: this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedAssignableElement_in_ruleAssignableTerminal3177);
                    this_ParenthesizedAssignableElement_2=ruleParenthesizedAssignableElement();
                    _fsp--;

                     
                            current = this_ParenthesizedAssignableElement_2; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1447:5: this_CrossReference_3= ruleCrossReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCrossReference_in_ruleAssignableTerminal3211);
                    this_CrossReference_3=ruleCrossReference();
                    _fsp--;

                     
                            current = this_CrossReference_3; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3(), null); 
                        

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1466:1: entryRuleParenthesizedAssignableElement returns [EObject current=null] : iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF ;
    public final EObject entryRuleParenthesizedAssignableElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedAssignableElement = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1466:72: (iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1467:2: iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedAssignableElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement3250);
            iv_ruleParenthesizedAssignableElement=ruleParenthesizedAssignableElement();
            _fsp--;

             current =iv_ruleParenthesizedAssignableElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement3260); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1474:1: ruleParenthesizedAssignableElement returns [EObject current=null] : ( '(' this_AssignableAlternatives_1= ruleAssignableAlternatives ')' ) ;
    public final EObject ruleParenthesizedAssignableElement() throws RecognitionException {
        EObject current = null;

        EObject this_AssignableAlternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1479:6: ( ( '(' this_AssignableAlternatives_1= ruleAssignableAlternatives ')' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1480:1: ( '(' this_AssignableAlternatives_1= ruleAssignableAlternatives ')' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1480:1: ( '(' this_AssignableAlternatives_1= ruleAssignableAlternatives ')' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1480:2: '(' this_AssignableAlternatives_1= ruleAssignableAlternatives ')'
            {
            match(input,15,FOLLOW_15_in_ruleParenthesizedAssignableElement3294); 

                    createLeafNode(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleAssignableAlternatives_in_ruleParenthesizedAssignableElement3316);
            this_AssignableAlternatives_1=ruleAssignableAlternatives();
            _fsp--;

             
                    current = this_AssignableAlternatives_1; 
                    currentNode = currentNode.getParent();
                
             
                createLeafNode(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1(), null); 
                
            match(input,16,FOLLOW_16_in_ruleParenthesizedAssignableElement3331); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1508:1: entryRuleAssignableAlternatives returns [EObject current=null] : iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF ;
    public final EObject entryRuleAssignableAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignableAlternatives = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1508:64: (iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1509:2: iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignableAlternativesRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives3364);
            iv_ruleAssignableAlternatives=ruleAssignableAlternatives();
            _fsp--;

             current =iv_ruleAssignableAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignableAlternatives3374); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1516:1: ruleAssignableAlternatives returns [EObject current=null] : (this_AssignableTerminal_0= ruleAssignableTerminal ( () ( '|' (lv_groups_3= ruleAssignableTerminal ) )+ )? ) ;
    public final EObject ruleAssignableAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_AssignableTerminal_0 = null;

        EObject lv_groups_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1521:6: ( (this_AssignableTerminal_0= ruleAssignableTerminal ( () ( '|' (lv_groups_3= ruleAssignableTerminal ) )+ )? ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1522:1: (this_AssignableTerminal_0= ruleAssignableTerminal ( () ( '|' (lv_groups_3= ruleAssignableTerminal ) )+ )? )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1522:1: (this_AssignableTerminal_0= ruleAssignableTerminal ( () ( '|' (lv_groups_3= ruleAssignableTerminal ) )+ )? )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1523:5: this_AssignableTerminal_0= ruleAssignableTerminal ( () ( '|' (lv_groups_3= ruleAssignableTerminal ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3421);
            this_AssignableTerminal_0=ruleAssignableTerminal();
            _fsp--;

             
                    current = this_AssignableTerminal_0; 
                    currentNode = currentNode.getParent();
                
             
                createLeafNode(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1535:1: ( () ( '|' (lv_groups_3= ruleAssignableTerminal ) )+ )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==25) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1535:2: () ( '|' (lv_groups_3= ruleAssignableTerminal ) )+
                    {
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1535:2: ()
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1536:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getAssignableAlternativesAccess().getAlternativesgroupsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "groups", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getAssignableAlternativesAccess().getAlternativesgroupsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1551:2: ( '|' (lv_groups_3= ruleAssignableTerminal ) )+
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
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1551:3: '|' (lv_groups_3= ruleAssignableTerminal )
                    	    {
                    	    match(input,25,FOLLOW_25_in_ruleAssignableAlternatives3447); 

                    	            createLeafNode(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1555:1: (lv_groups_3= ruleAssignableTerminal )
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1558:6: lv_groups_3= ruleAssignableTerminal
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAssignableAlternativesAccess().getGroupsAssignableTerminalParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3481);
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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1583:1: entryRuleCrossReference returns [EObject current=null] : iv_ruleCrossReference= ruleCrossReference EOF ;
    public final EObject entryRuleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReference = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1583:56: (iv_ruleCrossReference= ruleCrossReference EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1584:2: iv_ruleCrossReference= ruleCrossReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCrossReferenceRule(), currentNode); 
            pushFollow(FOLLOW_ruleCrossReference_in_entryRuleCrossReference3522);
            iv_ruleCrossReference=ruleCrossReference();
            _fsp--;

             current =iv_ruleCrossReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReference3532); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1591:1: ruleCrossReference returns [EObject current=null] : ( '[' (lv_type_1= ruleTypeRef ) ( '|' (lv_terminal_3= ruleCrossReferenceableTerminal ) )? ']' ) ;
    public final EObject ruleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject lv_type_1 = null;

        EObject lv_terminal_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1596:6: ( ( '[' (lv_type_1= ruleTypeRef ) ( '|' (lv_terminal_3= ruleCrossReferenceableTerminal ) )? ']' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1597:1: ( '[' (lv_type_1= ruleTypeRef ) ( '|' (lv_terminal_3= ruleCrossReferenceableTerminal ) )? ']' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1597:1: ( '[' (lv_type_1= ruleTypeRef ) ( '|' (lv_terminal_3= ruleCrossReferenceableTerminal ) )? ']' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1597:2: '[' (lv_type_1= ruleTypeRef ) ( '|' (lv_terminal_3= ruleCrossReferenceableTerminal ) )? ']'
            {
            match(input,35,FOLLOW_35_in_ruleCrossReference3566); 

                    createLeafNode(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1601:1: (lv_type_1= ruleTypeRef )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1604:6: lv_type_1= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleCrossReference3600);
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

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1622:2: ( '|' (lv_terminal_3= ruleCrossReferenceableTerminal ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==25) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1622:3: '|' (lv_terminal_3= ruleCrossReferenceableTerminal )
                    {
                    match(input,25,FOLLOW_25_in_ruleCrossReference3614); 

                            createLeafNode(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1626:1: (lv_terminal_3= ruleCrossReferenceableTerminal )
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1629:6: lv_terminal_3= ruleCrossReferenceableTerminal
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReference3648);
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

            match(input,36,FOLLOW_36_in_ruleCrossReference3663); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1658:1: entryRuleCrossReferenceableTerminal returns [EObject current=null] : iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF ;
    public final EObject entryRuleCrossReferenceableTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReferenceableTerminal = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1658:68: (iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1659:2: iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCrossReferenceableTerminalRule(), currentNode); 
            pushFollow(FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal3696);
            iv_ruleCrossReferenceableTerminal=ruleCrossReferenceableTerminal();
            _fsp--;

             current =iv_ruleCrossReferenceableTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal3706); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1666:1: ruleCrossReferenceableTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement ) ;
    public final EObject ruleCrossReferenceableTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedCrossReferenceableElement_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1671:6: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1672:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1672:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement )
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
                    new NoViableAltException("1672:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement )", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1673:5: this_Keyword_0= ruleKeyword
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleKeyword_in_ruleCrossReferenceableTerminal3753);
                    this_Keyword_0=ruleKeyword();
                    _fsp--;

                     
                            current = this_Keyword_0; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1687:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRuleCall_in_ruleCrossReferenceableTerminal3787);
                    this_RuleCall_1=ruleRuleCall();
                    _fsp--;

                     
                            current = this_RuleCall_1; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1701:5: this_ParenthesizedCrossReferenceableElement_2= ruleParenthesizedCrossReferenceableElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCrossReferenceableTerminalAccess().getParenthesizedCrossReferenceableElementParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedCrossReferenceableElement_in_ruleCrossReferenceableTerminal3821);
                    this_ParenthesizedCrossReferenceableElement_2=ruleParenthesizedCrossReferenceableElement();
                    _fsp--;

                     
                            current = this_ParenthesizedCrossReferenceableElement_2; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getCrossReferenceableTerminalAccess().getParenthesizedCrossReferenceableElementParserRuleCall_2(), null); 
                        

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1720:1: entryRuleParenthesizedCrossReferenceableElement returns [EObject current=null] : iv_ruleParenthesizedCrossReferenceableElement= ruleParenthesizedCrossReferenceableElement EOF ;
    public final EObject entryRuleParenthesizedCrossReferenceableElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedCrossReferenceableElement = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1720:80: (iv_ruleParenthesizedCrossReferenceableElement= ruleParenthesizedCrossReferenceableElement EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1721:2: iv_ruleParenthesizedCrossReferenceableElement= ruleParenthesizedCrossReferenceableElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedCrossReferenceableElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedCrossReferenceableElement_in_entryRuleParenthesizedCrossReferenceableElement3860);
            iv_ruleParenthesizedCrossReferenceableElement=ruleParenthesizedCrossReferenceableElement();
            _fsp--;

             current =iv_ruleParenthesizedCrossReferenceableElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedCrossReferenceableElement3870); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1728:1: ruleParenthesizedCrossReferenceableElement returns [EObject current=null] : ( '(' this_CrossReferenceableAlternatives_1= ruleCrossReferenceableAlternatives ')' ) ;
    public final EObject ruleParenthesizedCrossReferenceableElement() throws RecognitionException {
        EObject current = null;

        EObject this_CrossReferenceableAlternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1733:6: ( ( '(' this_CrossReferenceableAlternatives_1= ruleCrossReferenceableAlternatives ')' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1734:1: ( '(' this_CrossReferenceableAlternatives_1= ruleCrossReferenceableAlternatives ')' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1734:1: ( '(' this_CrossReferenceableAlternatives_1= ruleCrossReferenceableAlternatives ')' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1734:2: '(' this_CrossReferenceableAlternatives_1= ruleCrossReferenceableAlternatives ')'
            {
            match(input,15,FOLLOW_15_in_ruleParenthesizedCrossReferenceableElement3904); 

                    createLeafNode(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getCrossReferenceableAlternativesParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleCrossReferenceableAlternatives_in_ruleParenthesizedCrossReferenceableElement3926);
            this_CrossReferenceableAlternatives_1=ruleCrossReferenceableAlternatives();
            _fsp--;

             
                    current = this_CrossReferenceableAlternatives_1; 
                    currentNode = currentNode.getParent();
                
             
                createLeafNode(grammarAccess.getParenthesizedCrossReferenceableElementAccess().getCrossReferenceableAlternativesParserRuleCall_1(), null); 
                
            match(input,16,FOLLOW_16_in_ruleParenthesizedCrossReferenceableElement3941); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1762:1: entryRuleCrossReferenceableAlternatives returns [EObject current=null] : iv_ruleCrossReferenceableAlternatives= ruleCrossReferenceableAlternatives EOF ;
    public final EObject entryRuleCrossReferenceableAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReferenceableAlternatives = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1762:72: (iv_ruleCrossReferenceableAlternatives= ruleCrossReferenceableAlternatives EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1763:2: iv_ruleCrossReferenceableAlternatives= ruleCrossReferenceableAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCrossReferenceableAlternativesRule(), currentNode); 
            pushFollow(FOLLOW_ruleCrossReferenceableAlternatives_in_entryRuleCrossReferenceableAlternatives3974);
            iv_ruleCrossReferenceableAlternatives=ruleCrossReferenceableAlternatives();
            _fsp--;

             current =iv_ruleCrossReferenceableAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReferenceableAlternatives3984); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1770:1: ruleCrossReferenceableAlternatives returns [EObject current=null] : (this_CrossReferenceableTerminal_0= ruleCrossReferenceableTerminal ( () ( '|' (lv_groups_3= ruleCrossReferenceableTerminal ) )+ )? ) ;
    public final EObject ruleCrossReferenceableAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_CrossReferenceableTerminal_0 = null;

        EObject lv_groups_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1775:6: ( (this_CrossReferenceableTerminal_0= ruleCrossReferenceableTerminal ( () ( '|' (lv_groups_3= ruleCrossReferenceableTerminal ) )+ )? ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1776:1: (this_CrossReferenceableTerminal_0= ruleCrossReferenceableTerminal ( () ( '|' (lv_groups_3= ruleCrossReferenceableTerminal ) )+ )? )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1776:1: (this_CrossReferenceableTerminal_0= ruleCrossReferenceableTerminal ( () ( '|' (lv_groups_3= ruleCrossReferenceableTerminal ) )+ )? )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1777:5: this_CrossReferenceableTerminal_0= ruleCrossReferenceableTerminal ( () ( '|' (lv_groups_3= ruleCrossReferenceableTerminal ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getCrossReferenceableAlternativesAccess().getCrossReferenceableTerminalParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReferenceableAlternatives4031);
            this_CrossReferenceableTerminal_0=ruleCrossReferenceableTerminal();
            _fsp--;

             
                    current = this_CrossReferenceableTerminal_0; 
                    currentNode = currentNode.getParent();
                
             
                createLeafNode(grammarAccess.getCrossReferenceableAlternativesAccess().getCrossReferenceableTerminalParserRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1789:1: ( () ( '|' (lv_groups_3= ruleCrossReferenceableTerminal ) )+ )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==25) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1789:2: () ( '|' (lv_groups_3= ruleCrossReferenceableTerminal ) )+
                    {
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1789:2: ()
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1790:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getCrossReferenceableAlternativesAccess().getAlternativesgroupsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "groups", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getCrossReferenceableAlternativesAccess().getAlternativesgroupsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1805:2: ( '|' (lv_groups_3= ruleCrossReferenceableTerminal ) )+
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
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1805:3: '|' (lv_groups_3= ruleCrossReferenceableTerminal )
                    	    {
                    	    match(input,25,FOLLOW_25_in_ruleCrossReferenceableAlternatives4057); 

                    	            createLeafNode(grammarAccess.getCrossReferenceableAlternativesAccess().getVerticalLineKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1809:1: (lv_groups_3= ruleCrossReferenceableTerminal )
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1812:6: lv_groups_3= ruleCrossReferenceableTerminal
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getCrossReferenceableAlternativesAccess().getGroupsCrossReferenceableTerminalParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReferenceableAlternatives4091);
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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1837:1: entryRuleParenthesizedElement returns [EObject current=null] : iv_ruleParenthesizedElement= ruleParenthesizedElement EOF ;
    public final EObject entryRuleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedElement = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1837:62: (iv_ruleParenthesizedElement= ruleParenthesizedElement EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1838:2: iv_ruleParenthesizedElement= ruleParenthesizedElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement4132);
            iv_ruleParenthesizedElement=ruleParenthesizedElement();
            _fsp--;

             current =iv_ruleParenthesizedElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedElement4142); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1845:1: ruleParenthesizedElement returns [EObject current=null] : ( '(' this_Alternatives_1= ruleAlternatives ')' ) ;
    public final EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Alternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1850:6: ( ( '(' this_Alternatives_1= ruleAlternatives ')' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1851:1: ( '(' this_Alternatives_1= ruleAlternatives ')' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1851:1: ( '(' this_Alternatives_1= ruleAlternatives ')' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1851:2: '(' this_Alternatives_1= ruleAlternatives ')'
            {
            match(input,15,FOLLOW_15_in_ruleParenthesizedElement4176); 

                    createLeafNode(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesizedElement4198);
            this_Alternatives_1=ruleAlternatives();
            _fsp--;

             
                    current = this_Alternatives_1; 
                    currentNode = currentNode.getParent();
                
             
                createLeafNode(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1(), null); 
                
            match(input,16,FOLLOW_16_in_ruleParenthesizedElement4213); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1879:1: entryRuleTerminalRule returns [EObject current=null] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final EObject entryRuleTerminalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRule = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1879:54: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1880:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule4246);
            iv_ruleTerminalRule=ruleTerminalRule();
            _fsp--;

             current =iv_ruleTerminalRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalRule4256); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1887:1: ruleTerminalRule returns [EObject current=null] : ( 'terminal' (lv_name_1= RULE_ID ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ':' (lv_alternatives_5= ruleTerminalAlternatives ) ';' ) ;
    public final EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_type_3 = null;

        EObject lv_alternatives_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1892:6: ( ( 'terminal' (lv_name_1= RULE_ID ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ':' (lv_alternatives_5= ruleTerminalAlternatives ) ';' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1893:1: ( 'terminal' (lv_name_1= RULE_ID ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ':' (lv_alternatives_5= ruleTerminalAlternatives ) ';' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1893:1: ( 'terminal' (lv_name_1= RULE_ID ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ':' (lv_alternatives_5= ruleTerminalAlternatives ) ';' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1893:2: 'terminal' (lv_name_1= RULE_ID ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ':' (lv_alternatives_5= ruleTerminalAlternatives ) ';'
            {
            match(input,37,FOLLOW_37_in_ruleTerminalRule4290); 

                    createLeafNode(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1897:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1899:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTerminalRule4312); 

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

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1917:2: ( 'returns' (lv_type_3= ruleTypeRef ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==21) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1917:3: 'returns' (lv_type_3= ruleTypeRef )
                    {
                    match(input,21,FOLLOW_21_in_ruleTerminalRule4330); 

                            createLeafNode(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1921:1: (lv_type_3= ruleTypeRef )
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1924:6: lv_type_3= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleTerminalRule4364);
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

            match(input,22,FOLLOW_22_in_ruleTerminalRule4379); 

                    createLeafNode(grammarAccess.getTerminalRuleAccess().getColonKeyword_3(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1946:1: (lv_alternatives_5= ruleTerminalAlternatives )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1949:6: lv_alternatives_5= ruleTerminalAlternatives
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule4413);
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

            match(input,23,FOLLOW_23_in_ruleTerminalRule4426); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1978:1: entryRuleTerminalAlternatives returns [EObject current=null] : iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF ;
    public final EObject entryRuleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalAlternatives = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1978:62: (iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1979:2: iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalAlternativesRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives4459);
            iv_ruleTerminalAlternatives=ruleTerminalAlternatives();
            _fsp--;

             current =iv_ruleTerminalAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalAlternatives4469); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1986:1: ruleTerminalAlternatives returns [EObject current=null] : (this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' (lv_groups_3= ruleTerminalGroup ) )+ )? ) ;
    public final EObject ruleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalGroup_0 = null;

        EObject lv_groups_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1991:6: ( (this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' (lv_groups_3= ruleTerminalGroup ) )+ )? ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1992:1: (this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' (lv_groups_3= ruleTerminalGroup ) )+ )? )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1992:1: (this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' (lv_groups_3= ruleTerminalGroup ) )+ )? )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1993:5: this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' (lv_groups_3= ruleTerminalGroup ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4516);
            this_TerminalGroup_0=ruleTerminalGroup();
            _fsp--;

             
                    current = this_TerminalGroup_0; 
                    currentNode = currentNode.getParent();
                
             
                createLeafNode(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2005:1: ( () ( '|' (lv_groups_3= ruleTerminalGroup ) )+ )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==25) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2005:2: () ( '|' (lv_groups_3= ruleTerminalGroup ) )+
                    {
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2005:2: ()
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2006:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getTerminalAlternativesAccess().getAlternativesgroupsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "groups", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getTerminalAlternativesAccess().getAlternativesgroupsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2021:2: ( '|' (lv_groups_3= ruleTerminalGroup ) )+
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
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2021:3: '|' (lv_groups_3= ruleTerminalGroup )
                    	    {
                    	    match(input,25,FOLLOW_25_in_ruleTerminalAlternatives4542); 

                    	            createLeafNode(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2025:1: (lv_groups_3= ruleTerminalGroup )
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2028:6: lv_groups_3= ruleTerminalGroup
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getTerminalAlternativesAccess().getGroupsTerminalGroupParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4576);
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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2053:1: entryRuleTerminalGroup returns [EObject current=null] : iv_ruleTerminalGroup= ruleTerminalGroup EOF ;
    public final EObject entryRuleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalGroup = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2053:55: (iv_ruleTerminalGroup= ruleTerminalGroup EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2054:2: iv_ruleTerminalGroup= ruleTerminalGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalGroupRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup4617);
            iv_ruleTerminalGroup=ruleTerminalGroup();
            _fsp--;

             current =iv_ruleTerminalGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalGroup4627); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2061:1: ruleTerminalGroup returns [EObject current=null] : (this_TerminalToken_0= ruleTerminalToken ( () (lv_tokens_2= ruleTerminalToken )+ )? ) ;
    public final EObject ruleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalToken_0 = null;

        EObject lv_tokens_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2066:6: ( (this_TerminalToken_0= ruleTerminalToken ( () (lv_tokens_2= ruleTerminalToken )+ )? ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2067:1: (this_TerminalToken_0= ruleTerminalToken ( () (lv_tokens_2= ruleTerminalToken )+ )? )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2067:1: (this_TerminalToken_0= ruleTerminalToken ( () (lv_tokens_2= ruleTerminalToken )+ )? )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2068:5: this_TerminalToken_0= ruleTerminalToken ( () (lv_tokens_2= ruleTerminalToken )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4674);
            this_TerminalToken_0=ruleTerminalToken();
            _fsp--;

             
                    current = this_TerminalToken_0; 
                    currentNode = currentNode.getParent();
                
             
                createLeafNode(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2080:1: ( () (lv_tokens_2= ruleTerminalToken )+ )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=RULE_ID && LA41_0<=RULE_STRING)||LA41_0==15||LA41_0==17||(LA41_0>=38 && LA41_0<=39)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2080:2: () (lv_tokens_2= ruleTerminalToken )+
                    {
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2080:2: ()
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2081:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getTerminalGroupAccess().getGrouptokensAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "tokens", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getTerminalGroupAccess().getGrouptokensAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2096:2: (lv_tokens_2= ruleTerminalToken )+
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
                    	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2099:6: lv_tokens_2= ruleTerminalToken
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getTerminalGroupAccess().getTokensTerminalTokenParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4724);
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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2124:1: entryRuleTerminalToken returns [EObject current=null] : iv_ruleTerminalToken= ruleTerminalToken EOF ;
    public final EObject entryRuleTerminalToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalToken = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2124:55: (iv_ruleTerminalToken= ruleTerminalToken EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2125:2: iv_ruleTerminalToken= ruleTerminalToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalTokenRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken4764);
            iv_ruleTerminalToken=ruleTerminalToken();
            _fsp--;

             current =iv_ruleTerminalToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalToken4774); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2132:1: ruleTerminalToken returns [EObject current=null] : (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( '?' | '*' | '+' ) )? ) ;
    public final EObject ruleTerminalToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_1=null;
        EObject this_TerminalTokenElement_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2137:6: ( (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( '?' | '*' | '+' ) )? ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2138:1: (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( '?' | '*' | '+' ) )? )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2138:1: (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( '?' | '*' | '+' ) )? )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2139:5: this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( '?' | '*' | '+' ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken4821);
            this_TerminalTokenElement_0=ruleTerminalTokenElement();
            _fsp--;

             
                    current = this_TerminalTokenElement_0; 
                    currentNode = currentNode.getParent();
                
             
                createLeafNode(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2151:1: (lv_cardinality_1= ( '?' | '*' | '+' ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=26 && LA43_0<=28)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2153:6: lv_cardinality_1= ( '?' | '*' | '+' )
                    {
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2153:23: ( '?' | '*' | '+' )
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
                            new NoViableAltException("2153:23: ( '?' | '*' | '+' )", 42, 0, input);

                        throw nvae;
                    }

                    switch (alt42) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2153:24: '?'
                            {
                            match(input,26,FOLLOW_26_in_ruleTerminalToken4849); 

                                    createLeafNode(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0(), "cardinality"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2159:6: '*'
                            {
                            match(input,27,FOLLOW_27_in_ruleTerminalToken4865); 

                                    createLeafNode(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1(), "cardinality"); 
                                

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2165:6: '+'
                            {
                            match(input,28,FOLLOW_28_in_ruleTerminalToken4881); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2192:1: entryRuleTerminalTokenElement returns [EObject current=null] : iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF ;
    public final EObject entryRuleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalTokenElement = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2192:62: (iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2193:2: iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTerminalTokenElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement4930);
            iv_ruleTerminalTokenElement=ruleTerminalTokenElement();
            _fsp--;

             current =iv_ruleTerminalTokenElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalTokenElement4940); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2200:1: ruleTerminalTokenElement returns [EObject current=null] : (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard ) ;
    public final EObject ruleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject this_CharacterRange_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedTerminalElement_2 = null;

        EObject this_AbstractNegatedToken_3 = null;

        EObject this_Wildcard_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2205:6: ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2206:1: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2206:1: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )
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
                    new NoViableAltException("2206:1: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2207:5: this_CharacterRange_0= ruleCharacterRange
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement4987);
                    this_CharacterRange_0=ruleCharacterRange();
                    _fsp--;

                     
                            current = this_CharacterRange_0; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2221:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement5021);
                    this_RuleCall_1=ruleRuleCall();
                    _fsp--;

                     
                            current = this_RuleCall_1; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getTerminalTokenElementAccess().getRuleCallParserRuleCall_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2235:5: this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement5055);
                    this_ParenthesizedTerminalElement_2=ruleParenthesizedTerminalElement();
                    _fsp--;

                     
                            current = this_ParenthesizedTerminalElement_2; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2249:5: this_AbstractNegatedToken_3= ruleAbstractNegatedToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement5089);
                    this_AbstractNegatedToken_3=ruleAbstractNegatedToken();
                    _fsp--;

                     
                            current = this_AbstractNegatedToken_3; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3(), null); 
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2263:5: this_Wildcard_4= ruleWildcard
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleWildcard_in_ruleTerminalTokenElement5123);
                    this_Wildcard_4=ruleWildcard();
                    _fsp--;

                     
                            current = this_Wildcard_4; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4(), null); 
                        

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2282:1: entryRuleParenthesizedTerminalElement returns [EObject current=null] : iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF ;
    public final EObject entryRuleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedTerminalElement = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2282:70: (iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2283:2: iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedTerminalElementRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement5162);
            iv_ruleParenthesizedTerminalElement=ruleParenthesizedTerminalElement();
            _fsp--;

             current =iv_ruleParenthesizedTerminalElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement5172); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2290:1: ruleParenthesizedTerminalElement returns [EObject current=null] : ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')' ) ;
    public final EObject ruleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalAlternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2295:6: ( ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2296:1: ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2296:1: ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2296:2: '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')'
            {
            match(input,15,FOLLOW_15_in_ruleParenthesizedTerminalElement5206); 

                    createLeafNode(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement5228);
            this_TerminalAlternatives_1=ruleTerminalAlternatives();
            _fsp--;

             
                    current = this_TerminalAlternatives_1; 
                    currentNode = currentNode.getParent();
                
             
                createLeafNode(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1(), null); 
                
            match(input,16,FOLLOW_16_in_ruleParenthesizedTerminalElement5243); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2324:1: entryRuleAbstractNegatedToken returns [EObject current=null] : iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF ;
    public final EObject entryRuleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractNegatedToken = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2324:62: (iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2325:2: iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractNegatedTokenRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken5276);
            iv_ruleAbstractNegatedToken=ruleAbstractNegatedToken();
            _fsp--;

             current =iv_ruleAbstractNegatedToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractNegatedToken5286); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2332:1: ruleAbstractNegatedToken returns [EObject current=null] : (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) ;
    public final EObject ruleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject this_NegatedToken_0 = null;

        EObject this_UntilToken_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2337:6: ( (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2338:1: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2338:1: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
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
                    new NoViableAltException("2338:1: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2339:5: this_NegatedToken_0= ruleNegatedToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken5333);
                    this_NegatedToken_0=ruleNegatedToken();
                    _fsp--;

                     
                            current = this_NegatedToken_0; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2353:5: this_UntilToken_1= ruleUntilToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUntilToken_in_ruleAbstractNegatedToken5367);
                    this_UntilToken_1=ruleUntilToken();
                    _fsp--;

                     
                            current = this_UntilToken_1; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1(), null); 
                        

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2372:1: entryRuleNegatedToken returns [EObject current=null] : iv_ruleNegatedToken= ruleNegatedToken EOF ;
    public final EObject entryRuleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegatedToken = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2372:54: (iv_ruleNegatedToken= ruleNegatedToken EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2373:2: iv_ruleNegatedToken= ruleNegatedToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNegatedTokenRule(), currentNode); 
            pushFollow(FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken5406);
            iv_ruleNegatedToken=ruleNegatedToken();
            _fsp--;

             current =iv_ruleNegatedToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegatedToken5416); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2380:1: ruleNegatedToken returns [EObject current=null] : ( '!' (lv_terminal_1= ruleTerminalTokenElement ) ) ;
    public final EObject ruleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2385:6: ( ( '!' (lv_terminal_1= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2386:1: ( '!' (lv_terminal_1= ruleTerminalTokenElement ) )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2386:1: ( '!' (lv_terminal_1= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2386:2: '!' (lv_terminal_1= ruleTerminalTokenElement )
            {
            match(input,38,FOLLOW_38_in_ruleNegatedToken5450); 

                    createLeafNode(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2390:1: (lv_terminal_1= ruleTerminalTokenElement )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2393:6: lv_terminal_1= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken5484);
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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2418:1: entryRuleUntilToken returns [EObject current=null] : iv_ruleUntilToken= ruleUntilToken EOF ;
    public final EObject entryRuleUntilToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUntilToken = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2418:52: (iv_ruleUntilToken= ruleUntilToken EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2419:2: iv_ruleUntilToken= ruleUntilToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUntilTokenRule(), currentNode); 
            pushFollow(FOLLOW_ruleUntilToken_in_entryRuleUntilToken5521);
            iv_ruleUntilToken=ruleUntilToken();
            _fsp--;

             current =iv_ruleUntilToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUntilToken5531); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2426:1: ruleUntilToken returns [EObject current=null] : ( '->' (lv_terminal_1= ruleTerminalTokenElement ) ) ;
    public final EObject ruleUntilToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2431:6: ( ( '->' (lv_terminal_1= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2432:1: ( '->' (lv_terminal_1= ruleTerminalTokenElement ) )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2432:1: ( '->' (lv_terminal_1= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2432:2: '->' (lv_terminal_1= ruleTerminalTokenElement )
            {
            match(input,39,FOLLOW_39_in_ruleUntilToken5565); 

                    createLeafNode(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2436:1: (lv_terminal_1= ruleTerminalTokenElement )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2439:6: lv_terminal_1= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleUntilToken5599);
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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2464:1: entryRuleWildcard returns [EObject current=null] : iv_ruleWildcard= ruleWildcard EOF ;
    public final EObject entryRuleWildcard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcard = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2464:50: (iv_ruleWildcard= ruleWildcard EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2465:2: iv_ruleWildcard= ruleWildcard EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWildcardRule(), currentNode); 
            pushFollow(FOLLOW_ruleWildcard_in_entryRuleWildcard5636);
            iv_ruleWildcard=ruleWildcard();
            _fsp--;

             current =iv_ruleWildcard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWildcard5646); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2472:1: ruleWildcard returns [EObject current=null] : ( () '.' ) ;
    public final EObject ruleWildcard() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2477:6: ( ( () '.' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2478:1: ( () '.' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2478:1: ( () '.' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2478:2: () '.'
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2478:2: ()
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2479:5: 
            {
             
                    temp=factory.create(grammarAccess.getWildcardAccess().getWildcardnullAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getWildcardAccess().getWildcardnullAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,17,FOLLOW_17_in_ruleWildcard5689); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2500:1: entryRuleCharacterRange returns [EObject current=null] : iv_ruleCharacterRange= ruleCharacterRange EOF ;
    public final EObject entryRuleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterRange = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2500:56: (iv_ruleCharacterRange= ruleCharacterRange EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2501:2: iv_ruleCharacterRange= ruleCharacterRange EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCharacterRangeRule(), currentNode); 
            pushFollow(FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange5722);
            iv_ruleCharacterRange=ruleCharacterRange();
            _fsp--;

             current =iv_ruleCharacterRange; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCharacterRange5732); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2508:1: ruleCharacterRange returns [EObject current=null] : (this_Keyword_0= ruleKeyword ( () '..' (lv_right_3= ruleKeyword ) )? ) ;
    public final EObject ruleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject lv_right_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2513:6: ( (this_Keyword_0= ruleKeyword ( () '..' (lv_right_3= ruleKeyword ) )? ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2514:1: (this_Keyword_0= ruleKeyword ( () '..' (lv_right_3= ruleKeyword ) )? )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2514:1: (this_Keyword_0= ruleKeyword ( () '..' (lv_right_3= ruleKeyword ) )? )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2515:5: this_Keyword_0= ruleKeyword ( () '..' (lv_right_3= ruleKeyword ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleKeyword_in_ruleCharacterRange5779);
            this_Keyword_0=ruleKeyword();
            _fsp--;

             
                    current = this_Keyword_0; 
                    currentNode = currentNode.getParent();
                
             
                createLeafNode(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2527:1: ( () '..' (lv_right_3= ruleKeyword ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==40) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2527:2: () '..' (lv_right_3= ruleKeyword )
                    {
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2527:2: ()
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2528:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getCharacterRangeAccess().getCharacterRangeleftAction_1_0().getType().getClassifier());
                            try {
                            	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getCharacterRangeAccess().getCharacterRangeleftAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    match(input,40,FOLLOW_40_in_ruleCharacterRange5804); 

                            createLeafNode(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1(), null); 
                        
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2547:1: (lv_right_3= ruleKeyword )
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2550:6: lv_right_3= ruleKeyword
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleKeyword_in_ruleCharacterRange5838);
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


 

    public static final BitSet FOLLOW_ruleGrammar_in_entryRuleGrammar71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammar81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleGrammar115 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar149 = new BitSet(new long[]{0x0000002000145010L});
    public static final BitSet FOLLOW_12_in_ruleGrammar163 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar190 = new BitSet(new long[]{0x0000002000146010L});
    public static final BitSet FOLLOW_13_in_ruleGrammar203 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar230 = new BitSet(new long[]{0x0000002000146010L});
    public static final BitSet FOLLOW_14_in_ruleGrammar259 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleGrammar281 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar304 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_13_in_ruleGrammar317 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar339 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_16_in_ruleGrammar355 = new BitSet(new long[]{0x0000002000140010L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar391 = new BitSet(new long[]{0x0000002000140010L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleGrammar430 = new BitSet(new long[]{0x0000002000000012L});
    public static final BitSet FOLLOW_ruleGrammarID_in_entryRuleGrammarID469 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammarID480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarID520 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleGrammarID539 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarID554 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule599 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleAbstractRule656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_ruleAbstractRule690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration729 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel859 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGeneratedMetamodel869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleGeneratedMetamodel903 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel925 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel955 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleGeneratedMetamodel968 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel1033 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleReferencedMetamodel1077 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1099 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleReferencedMetamodel1112 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel1134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_entryRuleParserRule1177 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParserRule1187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1234 = new BitSet(new long[]{0x0000000000604000L});
    public static final BitSet FOLLOW_21_in_ruleParserRule1252 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule1286 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_14_in_ruleParserRule1314 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleParserRule1336 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1359 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_13_in_ruleParserRule1372 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1394 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_16_in_ruleParserRule1410 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleParserRule1421 = new BitSet(new long[]{0x0000000020008030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule1455 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleParserRule1468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef1501 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef1511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef1559 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleTypeRef1571 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives1631 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives1641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives1688 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleAlternatives1714 = new BitSet(new long[]{0x0000000020008030L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives1748 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup1789 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroup1799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup1846 = new BitSet(new long[]{0x0000000020008032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup1896 = new BitSet(new long[]{0x0000000020008032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken1936 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken1946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_ruleAbstractToken1993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken2027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTokenWithCardinality_in_entryRuleAbstractTokenWithCardinality2066 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTokenWithCardinality2076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractTokenWithCardinality2124 = new BitSet(new long[]{0x000000001C000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractTokenWithCardinality2158 = new BitSet(new long[]{0x000000001C000002L});
    public static final BitSet FOLLOW_26_in_ruleAbstractTokenWithCardinality2187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleAbstractTokenWithCardinality2203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleAbstractTokenWithCardinality2219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_entryRuleAction2268 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAction2278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleAction2312 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction2346 = new BitSet(new long[]{0x0000000200020000L});
    public static final BitSet FOLLOW_17_in_ruleAction2360 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAction2382 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30_in_ruleAction2412 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_31_in_ruleAction2428 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleAction2452 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleAction2463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal2496 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal2506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal2553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal2587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal2621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword2660 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword2670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword2716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall2756 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall2766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall2812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment2847 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment2857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment2904 = new BitSet(new long[]{0x00000004C0000000L});
    public static final BitSet FOLLOW_31_in_ruleAssignment2934 = new BitSet(new long[]{0x0000000800008030L});
    public static final BitSet FOLLOW_30_in_ruleAssignment2950 = new BitSet(new long[]{0x0000000800008030L});
    public static final BitSet FOLLOW_34_in_ruleAssignment2966 = new BitSet(new long[]{0x0000000800008030L});
    public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignment3015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignableTerminal_in_entryRuleAssignableTerminal3052 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignableTerminal3062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleAssignableTerminal3109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleAssignableTerminal3143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_ruleAssignableTerminal3177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_ruleAssignableTerminal3211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedAssignableElement_in_entryRuleParenthesizedAssignableElement3250 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedAssignableElement3260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedAssignableElement3294 = new BitSet(new long[]{0x0000000800008030L});
    public static final BitSet FOLLOW_ruleAssignableAlternatives_in_ruleParenthesizedAssignableElement3316 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParenthesizedAssignableElement3331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignableAlternatives_in_entryRuleAssignableAlternatives3364 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignableAlternatives3374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3421 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleAssignableAlternatives3447 = new BitSet(new long[]{0x0000000800008030L});
    public static final BitSet FOLLOW_ruleAssignableTerminal_in_ruleAssignableAlternatives3481 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference3522 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference3532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleCrossReference3566 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleCrossReference3600 = new BitSet(new long[]{0x0000001002000000L});
    public static final BitSet FOLLOW_25_in_ruleCrossReference3614 = new BitSet(new long[]{0x0000000000008030L});
    public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReference3648 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleCrossReference3663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_entryRuleCrossReferenceableTerminal3696 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReferenceableTerminal3706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCrossReferenceableTerminal3753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleCrossReferenceableTerminal3787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedCrossReferenceableElement_in_ruleCrossReferenceableTerminal3821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedCrossReferenceableElement_in_entryRuleParenthesizedCrossReferenceableElement3860 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedCrossReferenceableElement3870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedCrossReferenceableElement3904 = new BitSet(new long[]{0x0000000000008030L});
    public static final BitSet FOLLOW_ruleCrossReferenceableAlternatives_in_ruleParenthesizedCrossReferenceableElement3926 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParenthesizedCrossReferenceableElement3941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReferenceableAlternatives_in_entryRuleCrossReferenceableAlternatives3974 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReferenceableAlternatives3984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReferenceableAlternatives4031 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleCrossReferenceableAlternatives4057 = new BitSet(new long[]{0x0000000000008030L});
    public static final BitSet FOLLOW_ruleCrossReferenceableTerminal_in_ruleCrossReferenceableAlternatives4091 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement4132 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement4142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedElement4176 = new BitSet(new long[]{0x0000000020008030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement4198 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParenthesizedElement4213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule4246 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule4256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleTerminalRule4290 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTerminalRule4312 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_ruleTerminalRule4330 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleTerminalRule4364 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTerminalRule4379 = new BitSet(new long[]{0x000000C000028030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule4413 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleTerminalRule4426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives4459 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives4469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4516 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleTerminalAlternatives4542 = new BitSet(new long[]{0x000000C000028030L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives4576 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup4617 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup4627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4674 = new BitSet(new long[]{0x000000C000028032L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup4724 = new BitSet(new long[]{0x000000C000028032L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken4764 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken4774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken4821 = new BitSet(new long[]{0x000000001C000002L});
    public static final BitSet FOLLOW_26_in_ruleTerminalToken4849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleTerminalToken4865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleTerminalToken4881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement4930 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement4940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement4987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement5021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement5055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement5089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_ruleTerminalTokenElement5123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement5162 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement5172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedTerminalElement5206 = new BitSet(new long[]{0x000000C000028030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement5228 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParenthesizedTerminalElement5243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken5276 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken5286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken5333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUntilToken_in_ruleAbstractNegatedToken5367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken5406 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken5416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleNegatedToken5450 = new BitSet(new long[]{0x000000C000028030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken5484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUntilToken_in_entryRuleUntilToken5521 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUntilToken5531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleUntilToken5565 = new BitSet(new long[]{0x000000C000028030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleUntilToken5599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard5636 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcard5646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleWildcard5689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange5722 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange5732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange5779 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleCharacterRange5804 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange5838 = new BitSet(new long[]{0x0000000000000002L});

}