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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'grammar'", "'with'", "','", "'hidden'", "'('", "')'", "'.'", "'generate'", "'as'", "'import'", "'returns'", "':'", "';'", "'terminal'", "'::'", "'|'", "'?'", "'*'", "'+'", "'+='", "'='", "'?='", "'{'", "'current'", "'}'", "'!'", "'->'", "'..'", "'['", "']'"
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:69:1: entryRuleGrammar returns [EObject current=null] : iv_ruleGrammar= ruleGrammar EOF ;
    public final EObject entryRuleGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammar = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:69:49: (iv_ruleGrammar= ruleGrammar EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:70:2: iv_ruleGrammar= ruleGrammar EOF
            {
             currentNode = createCompositeNode(grammarAccess.prGrammar().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:77:1: ruleGrammar returns [EObject current=null] : ( 'grammar' (lv_name_1= ruleGrammarID ) ( 'with' ( ruleGrammarID ) ( ',' ( ruleGrammarID ) )* )? ( (lv_definesHiddenTokens_6= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? (lv_metamodelDeclarations_12= ruleAbstractMetamodelDeclaration )* (lv_rules_13= ruleAbstractRule )+ ) ;
    public final EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        Token lv_definesHiddenTokens_6=null;
        AntlrDatatypeRuleToken lv_name_1 = null;

        EObject lv_metamodelDeclarations_12 = null;

        EObject lv_rules_13 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:82:6: ( ( 'grammar' (lv_name_1= ruleGrammarID ) ( 'with' ( ruleGrammarID ) ( ',' ( ruleGrammarID ) )* )? ( (lv_definesHiddenTokens_6= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? (lv_metamodelDeclarations_12= ruleAbstractMetamodelDeclaration )* (lv_rules_13= ruleAbstractRule )+ ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:83:1: ( 'grammar' (lv_name_1= ruleGrammarID ) ( 'with' ( ruleGrammarID ) ( ',' ( ruleGrammarID ) )* )? ( (lv_definesHiddenTokens_6= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? (lv_metamodelDeclarations_12= ruleAbstractMetamodelDeclaration )* (lv_rules_13= ruleAbstractRule )+ )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:83:1: ( 'grammar' (lv_name_1= ruleGrammarID ) ( 'with' ( ruleGrammarID ) ( ',' ( ruleGrammarID ) )* )? ( (lv_definesHiddenTokens_6= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? (lv_metamodelDeclarations_12= ruleAbstractMetamodelDeclaration )* (lv_rules_13= ruleAbstractRule )+ )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:83:2: 'grammar' (lv_name_1= ruleGrammarID ) ( 'with' ( ruleGrammarID ) ( ',' ( ruleGrammarID ) )* )? ( (lv_definesHiddenTokens_6= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? (lv_metamodelDeclarations_12= ruleAbstractMetamodelDeclaration )* (lv_rules_13= ruleAbstractRule )+
            {
            match(input,11,FOLLOW_11_in_ruleGrammar115); 

                    createLeafNode(grammarAccess.prGrammar().ele0KeywordGrammar(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:87:1: (lv_name_1= ruleGrammarID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:90:6: lv_name_1= ruleGrammarID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele10ParserRuleCallGrammarID(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleGrammarID_in_ruleGrammar149);
            lv_name_1=ruleGrammarID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "GrammarID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:108:2: ( 'with' ( ruleGrammarID ) ( ',' ( ruleGrammarID ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:108:3: 'with' ( ruleGrammarID ) ( ',' ( ruleGrammarID ) )*
                    {
                    match(input,12,FOLLOW_12_in_ruleGrammar163); 

                            createLeafNode(grammarAccess.prGrammar().ele20KeywordWith(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:112:1: ( ruleGrammarID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:115:3: ruleGrammarID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele210CrossReferenceEStringGrammar(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleGrammarID_in_ruleGrammar190);
                    ruleGrammarID();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:130:2: ( ',' ( ruleGrammarID ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:130:3: ',' ( ruleGrammarID )
                    	    {
                    	    match(input,13,FOLLOW_13_in_ruleGrammar203); 

                    	            createLeafNode(grammarAccess.prGrammar().ele220KeywordComma(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:134:1: ( ruleGrammarID )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:137:3: ruleGrammarID
                    	    {

                    	    			if (current==null) {
                    	    	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	            
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele2210CrossReferenceEStringGrammar(), currentNode); 
                    	    	    
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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:152:6: ( (lv_definesHiddenTokens_6= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:152:7: (lv_definesHiddenTokens_6= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')'
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:152:7: (lv_definesHiddenTokens_6= 'hidden' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:154:6: lv_definesHiddenTokens_6= 'hidden'
                    {
                    lv_definesHiddenTokens_6=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleGrammar259); 

                            createLeafNode(grammarAccess.prGrammar().ele300KeywordHidden(), "definesHiddenTokens"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "definesHiddenTokens", true, "hidden", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    match(input,15,FOLLOW_15_in_ruleGrammar281); 

                            createLeafNode(grammarAccess.prGrammar().ele31KeywordLeftParenthesis(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:177:1: ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:177:2: ( RULE_ID ) ( ',' ( RULE_ID ) )*
                            {
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:177:2: ( RULE_ID )
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:180:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar304); 

                            		createLeafNode(grammarAccess.prGrammar().ele3200CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
                            	

                            }

                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:193:2: ( ',' ( RULE_ID ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==13) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:193:3: ',' ( RULE_ID )
                            	    {
                            	    match(input,13,FOLLOW_13_in_ruleGrammar317); 

                            	            createLeafNode(grammarAccess.prGrammar().ele3210KeywordComma(), null); 
                            	        
                            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:197:1: ( RULE_ID )
                            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:200:3: RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar339); 

                            	    		createLeafNode(grammarAccess.prGrammar().ele32110CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
                            	    	

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

                            createLeafNode(grammarAccess.prGrammar().ele33KeywordRightParenthesis(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:217:3: (lv_metamodelDeclarations_12= ruleAbstractMetamodelDeclaration )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18||LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:220:6: lv_metamodelDeclarations_12= ruleAbstractMetamodelDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele40ParserRuleCallAbstractMetamodelDeclaration(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar391);
            	    lv_metamodelDeclarations_12=ruleAbstractMetamodelDeclaration();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:238:3: (lv_rules_13= ruleAbstractRule )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==24) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:241:6: lv_rules_13= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele50ParserRuleCallAbstractRule(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleGrammar430);
            	    lv_rules_13=ruleAbstractRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:266:1: entryRuleGrammarID returns [String current=null] : iv_ruleGrammarID= ruleGrammarID EOF ;
    public final String entryRuleGrammarID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGrammarID = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:266:50: (iv_ruleGrammarID= ruleGrammarID EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:267:2: iv_ruleGrammarID= ruleGrammarID EOF
            {
             currentNode = createCompositeNode(grammarAccess.prGrammarID().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:274:1: ruleGrammarID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleGrammarID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:280:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:281:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:281:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:281:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammarID520); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.prGrammarID().ele0TerminalRuleCallID(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:288:1: (kw= '.' this_ID_2= RULE_ID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:289:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,17,FOLLOW_17_in_ruleGrammarID539); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.prGrammarID().ele10KeywordFullStop(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammarID554); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(grammarAccess.prGrammarID().ele11TerminalRuleCallID(), null); 
            	        

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:309:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:309:54: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:310:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractRule().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:317:1: ruleAbstractRule returns [EObject current=null] : (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_ParserRule_0 = null;

        EObject this_TerminalRule_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:322:6: ( (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:323:1: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:323:1: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            else if ( (LA9_0==24) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("323:1: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:324:5: this_ParserRule_0= ruleParserRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele0ParserRuleCallParserRule(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParserRule_in_ruleAbstractRule656);
                    this_ParserRule_0=ruleParserRule();
                    _fsp--;

                     
                            current = this_ParserRule_0; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prAbstractRule().ele0ParserRuleCallParserRule(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:338:5: this_TerminalRule_1= ruleTerminalRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele1ParserRuleCallTerminalRule(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTerminalRule_in_ruleAbstractRule690);
                    this_TerminalRule_1=ruleTerminalRule();
                    _fsp--;

                     
                            current = this_TerminalRule_1; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prAbstractRule().ele1ParserRuleCallTerminalRule(), null); 
                        

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:357:1: entryRuleAbstractMetamodelDeclaration returns [EObject current=null] : iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF ;
    public final EObject entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractMetamodelDeclaration = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:357:70: (iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:358:2: iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractMetamodelDeclaration().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:365:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) ;
    public final EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel_0 = null;

        EObject this_ReferencedMetamodel_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:370:6: ( (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:371:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:371:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
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
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:372:5: this_GeneratedMetamodel_0= ruleGeneratedMetamodel
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractMetamodelDeclaration().ele0ParserRuleCallGeneratedMetamodel(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration786);
                    this_GeneratedMetamodel_0=ruleGeneratedMetamodel();
                    _fsp--;

                     
                            current = this_GeneratedMetamodel_0; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prAbstractMetamodelDeclaration().ele0ParserRuleCallGeneratedMetamodel(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:386:5: this_ReferencedMetamodel_1= ruleReferencedMetamodel
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractMetamodelDeclaration().ele1ParserRuleCallReferencedMetamodel(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration820);
                    this_ReferencedMetamodel_1=ruleReferencedMetamodel();
                    _fsp--;

                     
                            current = this_ReferencedMetamodel_1; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prAbstractMetamodelDeclaration().ele1ParserRuleCallReferencedMetamodel(), null); 
                        

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:405:1: entryRuleGeneratedMetamodel returns [EObject current=null] : iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF ;
    public final EObject entryRuleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratedMetamodel = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:405:60: (iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:406:2: iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF
            {
             currentNode = createCompositeNode(grammarAccess.prGeneratedMetamodel().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:413:1: ruleGeneratedMetamodel returns [EObject current=null] : ( 'generate' (lv_name_1= RULE_ID ) ( RULE_STRING ) ( 'as' (lv_alias_4= RULE_ID ) )? ) ;
    public final EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_alias_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:418:6: ( ( 'generate' (lv_name_1= RULE_ID ) ( RULE_STRING ) ( 'as' (lv_alias_4= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:419:1: ( 'generate' (lv_name_1= RULE_ID ) ( RULE_STRING ) ( 'as' (lv_alias_4= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:419:1: ( 'generate' (lv_name_1= RULE_ID ) ( RULE_STRING ) ( 'as' (lv_alias_4= RULE_ID ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:419:2: 'generate' (lv_name_1= RULE_ID ) ( RULE_STRING ) ( 'as' (lv_alias_4= RULE_ID ) )?
            {
            match(input,18,FOLLOW_18_in_ruleGeneratedMetamodel903); 

                    createLeafNode(grammarAccess.prGeneratedMetamodel().ele0KeywordGenerate(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:423:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:425:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel925); 

            		createLeafNode(grammarAccess.prGeneratedMetamodel().ele10TerminalRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prGeneratedMetamodel().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:443:2: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:446:3: RULE_STRING
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prGeneratedMetamodel().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel955); 

            		createLeafNode(grammarAccess.prGeneratedMetamodel().ele20CrossReferenceEStringEPackage(), "ePackage"); 
            	

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:459:2: ( 'as' (lv_alias_4= RULE_ID ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:459:3: 'as' (lv_alias_4= RULE_ID )
                    {
                    match(input,19,FOLLOW_19_in_ruleGeneratedMetamodel968); 

                            createLeafNode(grammarAccess.prGeneratedMetamodel().ele30KeywordAs(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:463:1: (lv_alias_4= RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:465:6: lv_alias_4= RULE_ID
                    {
                    lv_alias_4=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel990); 

                    		createLeafNode(grammarAccess.prGeneratedMetamodel().ele310TerminalRuleCallID(), "alias"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prGeneratedMetamodel().getRule().getType().getType());
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:490:1: entryRuleReferencedMetamodel returns [EObject current=null] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final EObject entryRuleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedMetamodel = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:490:61: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:491:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
            {
             currentNode = createCompositeNode(grammarAccess.prReferencedMetamodel().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:498:1: ruleReferencedMetamodel returns [EObject current=null] : ( 'import' ( RULE_STRING ) ( 'as' (lv_alias_3= RULE_ID ) )? ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_alias_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:503:6: ( ( 'import' ( RULE_STRING ) ( 'as' (lv_alias_3= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:504:1: ( 'import' ( RULE_STRING ) ( 'as' (lv_alias_3= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:504:1: ( 'import' ( RULE_STRING ) ( 'as' (lv_alias_3= RULE_ID ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:504:2: 'import' ( RULE_STRING ) ( 'as' (lv_alias_3= RULE_ID ) )?
            {
            match(input,20,FOLLOW_20_in_ruleReferencedMetamodel1077); 

                    createLeafNode(grammarAccess.prReferencedMetamodel().ele0KeywordImport(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:508:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:511:3: RULE_STRING
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prReferencedMetamodel().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1099); 

            		createLeafNode(grammarAccess.prReferencedMetamodel().ele10CrossReferenceEStringEPackage(), "ePackage"); 
            	

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:524:2: ( 'as' (lv_alias_3= RULE_ID ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:524:3: 'as' (lv_alias_3= RULE_ID )
                    {
                    match(input,19,FOLLOW_19_in_ruleReferencedMetamodel1112); 

                            createLeafNode(grammarAccess.prReferencedMetamodel().ele20KeywordAs(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:528:1: (lv_alias_3= RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:530:6: lv_alias_3= RULE_ID
                    {
                    lv_alias_3=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedMetamodel1134); 

                    		createLeafNode(grammarAccess.prReferencedMetamodel().ele210TerminalRuleCallID(), "alias"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prReferencedMetamodel().getRule().getType().getType());
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:555:1: entryRuleParserRule returns [EObject current=null] : iv_ruleParserRule= ruleParserRule EOF ;
    public final EObject entryRuleParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRule = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:555:52: (iv_ruleParserRule= ruleParserRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:556:2: iv_ruleParserRule= ruleParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prParserRule().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:563:1: ruleParserRule returns [EObject current=null] : ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? ':' (lv_alternatives_10= ruleAlternatives ) ';' ) ;
    public final EObject ruleParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        Token lv_definesHiddenTokens_3=null;
        EObject lv_type_2 = null;

        EObject lv_alternatives_10 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:568:6: ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? ':' (lv_alternatives_10= ruleAlternatives ) ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:569:1: ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? ':' (lv_alternatives_10= ruleAlternatives ) ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:569:1: ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? ':' (lv_alternatives_10= ruleAlternatives ) ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:569:2: (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )? ':' (lv_alternatives_10= ruleAlternatives ) ';'
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:569:2: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:571:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1234); 

            		createLeafNode(grammarAccess.prParserRule().ele00TerminalRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prParserRule().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:589:2: ( 'returns' (lv_type_2= ruleTypeRef ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==21) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:589:3: 'returns' (lv_type_2= ruleTypeRef )
                    {
                    match(input,21,FOLLOW_21_in_ruleParserRule1252); 

                            createLeafNode(grammarAccess.prParserRule().ele10KeywordReturns(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:593:1: (lv_type_2= ruleTypeRef )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:596:6: lv_type_2= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prParserRule().ele110ParserRuleCallTypeRef(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleParserRule1286);
                    lv_type_2=ruleTypeRef();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prParserRule().getRule().getType().getType());
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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:614:4: ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:614:5: (lv_definesHiddenTokens_3= 'hidden' ) '(' ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ')'
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:614:5: (lv_definesHiddenTokens_3= 'hidden' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:616:6: lv_definesHiddenTokens_3= 'hidden'
                    {
                    lv_definesHiddenTokens_3=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleParserRule1314); 

                            createLeafNode(grammarAccess.prParserRule().ele200KeywordHidden(), "definesHiddenTokens"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prParserRule().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "definesHiddenTokens", true, "hidden", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    match(input,15,FOLLOW_15_in_ruleParserRule1336); 

                            createLeafNode(grammarAccess.prParserRule().ele21KeywordLeftParenthesis(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:639:1: ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_ID) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:639:2: ( RULE_ID ) ( ',' ( RULE_ID ) )*
                            {
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:639:2: ( RULE_ID )
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:642:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.prParserRule().getRule().getType().getType());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1359); 

                            		createLeafNode(grammarAccess.prParserRule().ele2200CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
                            	

                            }

                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:655:2: ( ',' ( RULE_ID ) )*
                            loop14:
                            do {
                                int alt14=2;
                                int LA14_0 = input.LA(1);

                                if ( (LA14_0==13) ) {
                                    alt14=1;
                                }


                                switch (alt14) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:655:3: ',' ( RULE_ID )
                            	    {
                            	    match(input,13,FOLLOW_13_in_ruleParserRule1372); 

                            	            createLeafNode(grammarAccess.prParserRule().ele2210KeywordComma(), null); 
                            	        
                            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:659:1: ( RULE_ID )
                            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:662:3: RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create(grammarAccess.prParserRule().getRule().getType().getType());
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1394); 

                            	    		createLeafNode(grammarAccess.prParserRule().ele22110CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
                            	    	

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

                            createLeafNode(grammarAccess.prParserRule().ele23KeywordRightParenthesis(), null); 
                        

                    }
                    break;

            }

            match(input,22,FOLLOW_22_in_ruleParserRule1421); 

                    createLeafNode(grammarAccess.prParserRule().ele3KeywordColon(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:683:1: (lv_alternatives_10= ruleAlternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:686:6: lv_alternatives_10= ruleAlternatives
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prParserRule().ele40ParserRuleCallAlternatives(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParserRule1455);
            lv_alternatives_10=ruleAlternatives();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prParserRule().getRule().getType().getType());
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

                    createLeafNode(grammarAccess.prParserRule().ele5KeywordSemicolon(), null); 
                

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


    // $ANTLR start entryRuleTerminalRule
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:715:1: entryRuleTerminalRule returns [EObject current=null] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final EObject entryRuleTerminalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRule = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:715:54: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:716:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1501);
            iv_ruleTerminalRule=ruleTerminalRule();
            _fsp--;

             current =iv_ruleTerminalRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalRule1511); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:723:1: ruleTerminalRule returns [EObject current=null] : ( 'terminal' (lv_name_1= RULE_ID ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ':' (lv_alternatives_5= ruleTerminalAlternatives ) ';' ) ;
    public final EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_type_3 = null;

        EObject lv_alternatives_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:728:6: ( ( 'terminal' (lv_name_1= RULE_ID ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ':' (lv_alternatives_5= ruleTerminalAlternatives ) ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:729:1: ( 'terminal' (lv_name_1= RULE_ID ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ':' (lv_alternatives_5= ruleTerminalAlternatives ) ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:729:1: ( 'terminal' (lv_name_1= RULE_ID ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ':' (lv_alternatives_5= ruleTerminalAlternatives ) ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:729:2: 'terminal' (lv_name_1= RULE_ID ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ':' (lv_alternatives_5= ruleTerminalAlternatives ) ';'
            {
            match(input,24,FOLLOW_24_in_ruleTerminalRule1545); 

                    createLeafNode(grammarAccess.prTerminalRule().ele0KeywordTerminal(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:733:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:735:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTerminalRule1567); 

            		createLeafNode(grammarAccess.prTerminalRule().ele10TerminalRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prTerminalRule().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:753:2: ( 'returns' (lv_type_3= ruleTypeRef ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==21) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:753:3: 'returns' (lv_type_3= ruleTypeRef )
                    {
                    match(input,21,FOLLOW_21_in_ruleTerminalRule1585); 

                            createLeafNode(grammarAccess.prTerminalRule().ele20KeywordReturns(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:757:1: (lv_type_3= ruleTypeRef )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:760:6: lv_type_3= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prTerminalRule().ele210ParserRuleCallTypeRef(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleTerminalRule1619);
                    lv_type_3=ruleTypeRef();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prTerminalRule().getRule().getType().getType());
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

            match(input,22,FOLLOW_22_in_ruleTerminalRule1634); 

                    createLeafNode(grammarAccess.prTerminalRule().ele3KeywordColon(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:782:1: (lv_alternatives_5= ruleTerminalAlternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:785:6: lv_alternatives_5= ruleTerminalAlternatives
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prTerminalRule().ele40ParserRuleCallTerminalAlternatives(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule1668);
            lv_alternatives_5=ruleTerminalAlternatives();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prTerminalRule().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "alternatives", lv_alternatives_5, "TerminalAlternatives", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,23,FOLLOW_23_in_ruleTerminalRule1681); 

                    createLeafNode(grammarAccess.prTerminalRule().ele5KeywordSemicolon(), null); 
                

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


    // $ANTLR start entryRuleTypeRef
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:814:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:814:49: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:815:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTypeRef().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef1714);
            iv_ruleTypeRef=ruleTypeRef();
            _fsp--;

             current =iv_ruleTypeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef1724); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:822:1: ruleTypeRef returns [EObject current=null] : ( ( ( RULE_ID ) '::' )? ( RULE_ID ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:827:6: ( ( ( ( RULE_ID ) '::' )? ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:828:1: ( ( ( RULE_ID ) '::' )? ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:828:1: ( ( ( RULE_ID ) '::' )? ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:828:2: ( ( RULE_ID ) '::' )? ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:828:2: ( ( RULE_ID ) '::' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==25) ) {
                    alt18=1;
                }
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:828:3: ( RULE_ID ) '::'
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:828:3: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:831:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prTypeRef().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef1772); 

                    		createLeafNode(grammarAccess.prTypeRef().ele000CrossReferenceEStringAbstractMetamodelDeclaration(), "metamodel"); 
                    	

                    }

                    match(input,25,FOLLOW_25_in_ruleTypeRef1784); 

                            createLeafNode(grammarAccess.prTypeRef().ele01KeywordColonColon(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:848:3: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:851:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prTypeRef().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef1808); 

            		createLeafNode(grammarAccess.prTypeRef().ele10CrossReferenceEStringEClassifier(), "type"); 
            	

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:871:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:871:54: (iv_ruleAlternatives= ruleAlternatives EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:872:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAlternatives().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAlternatives_in_entryRuleAlternatives1844);
            iv_ruleAlternatives=ruleAlternatives();
            _fsp--;

             current =iv_ruleAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternatives1854); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:879:1: ruleAlternatives returns [EObject current=null] : (this_Group_0= ruleGroup ( () ( '|' (lv_groups_3= ruleGroup ) )+ )? ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_Group_0 = null;

        EObject lv_groups_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:884:6: ( (this_Group_0= ruleGroup ( () ( '|' (lv_groups_3= ruleGroup ) )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:885:1: (this_Group_0= ruleGroup ( () ( '|' (lv_groups_3= ruleGroup ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:885:1: (this_Group_0= ruleGroup ( () ( '|' (lv_groups_3= ruleGroup ) )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:886:5: this_Group_0= ruleGroup ( () ( '|' (lv_groups_3= ruleGroup ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.prAlternatives().ele0ParserRuleCallGroup(), currentNode); 
                
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives1901);
            this_Group_0=ruleGroup();
            _fsp--;

             
                    current = this_Group_0; 
                    currentNode = currentNode.getParent();
                
             
                createLeafNode(grammarAccess.prAlternatives().ele0ParserRuleCallGroup(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:898:1: ( () ( '|' (lv_groups_3= ruleGroup ) )+ )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==26) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:898:2: () ( '|' (lv_groups_3= ruleGroup ) )+
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:898:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:899:5: 
                    {
                     
                            temp=factory.create(grammarAccess.prAlternatives().ele10ActionAlternativesgroups().getTypeName().getType());
                            try {
                            	factory.add(temp, "groups", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.prAlternatives().ele10ActionAlternativesgroups(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:914:2: ( '|' (lv_groups_3= ruleGroup ) )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==26) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:914:3: '|' (lv_groups_3= ruleGroup )
                    	    {
                    	    match(input,26,FOLLOW_26_in_ruleAlternatives1927); 

                    	            createLeafNode(grammarAccess.prAlternatives().ele110KeywordVerticalLine(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:918:1: (lv_groups_3= ruleGroup )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:921:6: lv_groups_3= ruleGroup
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prAlternatives().ele1110ParserRuleCallGroup(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives1961);
                    	    lv_groups_3=ruleGroup();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prAlternatives().getRule().getType().getType());
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
                    	    if ( cnt19 >= 1 ) break loop19;
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
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


    // $ANTLR start entryRuleTerminalAlternatives
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:946:1: entryRuleTerminalAlternatives returns [EObject current=null] : iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF ;
    public final EObject entryRuleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalAlternatives = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:946:62: (iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:947:2: iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalAlternatives().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives2002);
            iv_ruleTerminalAlternatives=ruleTerminalAlternatives();
            _fsp--;

             current =iv_ruleTerminalAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalAlternatives2012); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:954:1: ruleTerminalAlternatives returns [EObject current=null] : (this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' (lv_groups_3= ruleTerminalGroup ) )+ )? ) ;
    public final EObject ruleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalGroup_0 = null;

        EObject lv_groups_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:959:6: ( (this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' (lv_groups_3= ruleTerminalGroup ) )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:960:1: (this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' (lv_groups_3= ruleTerminalGroup ) )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:960:1: (this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' (lv_groups_3= ruleTerminalGroup ) )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:961:5: this_TerminalGroup_0= ruleTerminalGroup ( () ( '|' (lv_groups_3= ruleTerminalGroup ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.prTerminalAlternatives().ele0ParserRuleCallTerminalGroup(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2059);
            this_TerminalGroup_0=ruleTerminalGroup();
            _fsp--;

             
                    current = this_TerminalGroup_0; 
                    currentNode = currentNode.getParent();
                
             
                createLeafNode(grammarAccess.prTerminalAlternatives().ele0ParserRuleCallTerminalGroup(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:973:1: ( () ( '|' (lv_groups_3= ruleTerminalGroup ) )+ )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==26) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:973:2: () ( '|' (lv_groups_3= ruleTerminalGroup ) )+
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:973:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:974:5: 
                    {
                     
                            temp=factory.create(grammarAccess.prTerminalAlternatives().ele10ActionAlternativesgroups().getTypeName().getType());
                            try {
                            	factory.add(temp, "groups", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.prTerminalAlternatives().ele10ActionAlternativesgroups(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:989:2: ( '|' (lv_groups_3= ruleTerminalGroup ) )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==26) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:989:3: '|' (lv_groups_3= ruleTerminalGroup )
                    	    {
                    	    match(input,26,FOLLOW_26_in_ruleTerminalAlternatives2085); 

                    	            createLeafNode(grammarAccess.prTerminalAlternatives().ele110KeywordVerticalLine(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:993:1: (lv_groups_3= ruleTerminalGroup )
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:996:6: lv_groups_3= ruleTerminalGroup
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prTerminalAlternatives().ele1110ParserRuleCallTerminalGroup(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2119);
                    	    lv_groups_3=ruleTerminalGroup();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prTerminalAlternatives().getRule().getType().getType());
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
                    	    if ( cnt21 >= 1 ) break loop21;
                                EarlyExitException eee =
                                    new EarlyExitException(21, input);
                                throw eee;
                        }
                        cnt21++;
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


    // $ANTLR start entryRuleGroup
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1021:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1021:47: (iv_ruleGroup= ruleGroup EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1022:2: iv_ruleGroup= ruleGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.prGroup().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleGroup_in_entryRuleGroup2160);
            iv_ruleGroup=ruleGroup();
            _fsp--;

             current =iv_ruleGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroup2170); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1029:1: ruleGroup returns [EObject current=null] : (this_AbstractToken_0= ruleAbstractToken ( () (lv_abstractTokens_2= ruleAbstractToken )+ )? ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken_0 = null;

        EObject lv_abstractTokens_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1034:6: ( (this_AbstractToken_0= ruleAbstractToken ( () (lv_abstractTokens_2= ruleAbstractToken )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1035:1: (this_AbstractToken_0= ruleAbstractToken ( () (lv_abstractTokens_2= ruleAbstractToken )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1035:1: (this_AbstractToken_0= ruleAbstractToken ( () (lv_abstractTokens_2= ruleAbstractToken )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1036:5: this_AbstractToken_0= ruleAbstractToken ( () (lv_abstractTokens_2= ruleAbstractToken )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.prGroup().ele0ParserRuleCallAbstractToken(), currentNode); 
                
            pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup2217);
            this_AbstractToken_0=ruleAbstractToken();
            _fsp--;

             
                    current = this_AbstractToken_0; 
                    currentNode = currentNode.getParent();
                
             
                createLeafNode(grammarAccess.prGroup().ele0ParserRuleCallAbstractToken(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1048:1: ( () (lv_abstractTokens_2= ruleAbstractToken )+ )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=RULE_ID && LA24_0<=RULE_STRING)||LA24_0==15||LA24_0==33||LA24_0==39) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1048:2: () (lv_abstractTokens_2= ruleAbstractToken )+
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1048:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1049:5: 
                    {
                     
                            temp=factory.create(grammarAccess.prGroup().ele10ActionGroupabstractTokens().getTypeName().getType());
                            try {
                            	factory.add(temp, "abstractTokens", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.prGroup().ele10ActionGroupabstractTokens(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1064:2: (lv_abstractTokens_2= ruleAbstractToken )+
                    int cnt23=0;
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( ((LA23_0>=RULE_ID && LA23_0<=RULE_STRING)||LA23_0==15||LA23_0==33||LA23_0==39) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1067:6: lv_abstractTokens_2= ruleAbstractToken
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prGroup().ele110ParserRuleCallAbstractToken(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup2267);
                    	    lv_abstractTokens_2=ruleAbstractToken();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prGroup().getRule().getType().getType());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "abstractTokens", lv_abstractTokens_2, "AbstractToken", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt23 >= 1 ) break loop23;
                                EarlyExitException eee =
                                    new EarlyExitException(23, input);
                                throw eee;
                        }
                        cnt23++;
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


    // $ANTLR start entryRuleTerminalGroup
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1092:1: entryRuleTerminalGroup returns [EObject current=null] : iv_ruleTerminalGroup= ruleTerminalGroup EOF ;
    public final EObject entryRuleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalGroup = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1092:55: (iv_ruleTerminalGroup= ruleTerminalGroup EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1093:2: iv_ruleTerminalGroup= ruleTerminalGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalGroup().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup2307);
            iv_ruleTerminalGroup=ruleTerminalGroup();
            _fsp--;

             current =iv_ruleTerminalGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalGroup2317); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1100:1: ruleTerminalGroup returns [EObject current=null] : (this_TerminalToken_0= ruleTerminalToken ( () (lv_abstractTokens_2= ruleTerminalToken )+ )? ) ;
    public final EObject ruleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalToken_0 = null;

        EObject lv_abstractTokens_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1105:6: ( (this_TerminalToken_0= ruleTerminalToken ( () (lv_abstractTokens_2= ruleTerminalToken )+ )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1106:1: (this_TerminalToken_0= ruleTerminalToken ( () (lv_abstractTokens_2= ruleTerminalToken )+ )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1106:1: (this_TerminalToken_0= ruleTerminalToken ( () (lv_abstractTokens_2= ruleTerminalToken )+ )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1107:5: this_TerminalToken_0= ruleTerminalToken ( () (lv_abstractTokens_2= ruleTerminalToken )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.prTerminalGroup().ele0ParserRuleCallTerminalToken(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2364);
            this_TerminalToken_0=ruleTerminalToken();
            _fsp--;

             
                    current = this_TerminalToken_0; 
                    currentNode = currentNode.getParent();
                
             
                createLeafNode(grammarAccess.prTerminalGroup().ele0ParserRuleCallTerminalToken(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1119:1: ( () (lv_abstractTokens_2= ruleTerminalToken )+ )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=RULE_ID && LA26_0<=RULE_STRING)||LA26_0==15||LA26_0==17||(LA26_0>=36 && LA26_0<=37)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1119:2: () (lv_abstractTokens_2= ruleTerminalToken )+
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1119:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1120:5: 
                    {
                     
                            temp=factory.create(grammarAccess.prTerminalGroup().ele10ActionGroupabstractTokens().getTypeName().getType());
                            try {
                            	factory.add(temp, "abstractTokens", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.prTerminalGroup().ele10ActionGroupabstractTokens(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1135:2: (lv_abstractTokens_2= ruleTerminalToken )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( ((LA25_0>=RULE_ID && LA25_0<=RULE_STRING)||LA25_0==15||LA25_0==17||(LA25_0>=36 && LA25_0<=37)) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1138:6: lv_abstractTokens_2= ruleTerminalToken
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prTerminalGroup().ele110ParserRuleCallTerminalToken(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2414);
                    	    lv_abstractTokens_2=ruleTerminalToken();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prTerminalGroup().getRule().getType().getType());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "abstractTokens", lv_abstractTokens_2, "TerminalToken", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt25 >= 1 ) break loop25;
                                EarlyExitException eee =
                                    new EarlyExitException(25, input);
                                throw eee;
                        }
                        cnt25++;
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


    // $ANTLR start entryRuleAbstractToken
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1163:1: entryRuleAbstractToken returns [EObject current=null] : iv_ruleAbstractToken= ruleAbstractToken EOF ;
    public final EObject entryRuleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractToken = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1163:55: (iv_ruleAbstractToken= ruleAbstractToken EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1164:2: iv_ruleAbstractToken= ruleAbstractToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken2454);
            iv_ruleAbstractToken=ruleAbstractToken();
            _fsp--;

             current =iv_ruleAbstractToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractToken2464); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1171:1: ruleAbstractToken returns [EObject current=null] : ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction | this_AbstractTerminal_2= ruleAbstractTerminal ) (lv_cardinality_3= ( '?' | '*' | '+' ) )? ) ;
    public final EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_3=null;
        EObject this_Assignment_0 = null;

        EObject this_Action_1 = null;

        EObject this_AbstractTerminal_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1176:6: ( ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction | this_AbstractTerminal_2= ruleAbstractTerminal ) (lv_cardinality_3= ( '?' | '*' | '+' ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1177:1: ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction | this_AbstractTerminal_2= ruleAbstractTerminal ) (lv_cardinality_3= ( '?' | '*' | '+' ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1177:1: ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction | this_AbstractTerminal_2= ruleAbstractTerminal ) (lv_cardinality_3= ( '?' | '*' | '+' ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1177:2: (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction | this_AbstractTerminal_2= ruleAbstractTerminal ) (lv_cardinality_3= ( '?' | '*' | '+' ) )?
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1177:2: (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction | this_AbstractTerminal_2= ruleAbstractTerminal )
            int alt27=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA27_1 = input.LA(2);

                if ( ((LA27_1>=30 && LA27_1<=32)) ) {
                    alt27=1;
                }
                else if ( (LA27_1==EOF||(LA27_1>=RULE_ID && LA27_1<=RULE_STRING)||(LA27_1>=15 && LA27_1<=16)||LA27_1==23||(LA27_1>=26 && LA27_1<=29)||LA27_1==33||LA27_1==39) ) {
                    alt27=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1177:2: (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction | this_AbstractTerminal_2= ruleAbstractTerminal )", 27, 1, input);

                    throw nvae;
                }
                }
                break;
            case 33:
                {
                alt27=2;
                }
                break;
            case RULE_STRING:
            case 15:
            case 39:
                {
                alt27=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1177:2: (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction | this_AbstractTerminal_2= ruleAbstractTerminal )", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1178:5: this_Assignment_0= ruleAssignment
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractToken().ele00ParserRuleCallAssignment(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAssignment_in_ruleAbstractToken2512);
                    this_Assignment_0=ruleAssignment();
                    _fsp--;

                     
                            current = this_Assignment_0; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prAbstractToken().ele00ParserRuleCallAssignment(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1192:5: this_Action_1= ruleAction
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractToken().ele01ParserRuleCallAction(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAction_in_ruleAbstractToken2546);
                    this_Action_1=ruleAction();
                    _fsp--;

                     
                            current = this_Action_1; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prAbstractToken().ele01ParserRuleCallAction(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1206:5: this_AbstractTerminal_2= ruleAbstractTerminal
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractToken().ele02ParserRuleCallAbstractTerminal(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken2580);
                    this_AbstractTerminal_2=ruleAbstractTerminal();
                    _fsp--;

                     
                            current = this_AbstractTerminal_2; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prAbstractToken().ele02ParserRuleCallAbstractTerminal(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1218:2: (lv_cardinality_3= ( '?' | '*' | '+' ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=27 && LA29_0<=29)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1220:6: lv_cardinality_3= ( '?' | '*' | '+' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1220:23: ( '?' | '*' | '+' )
                    int alt28=3;
                    switch ( input.LA(1) ) {
                    case 27:
                        {
                        alt28=1;
                        }
                        break;
                    case 28:
                        {
                        alt28=2;
                        }
                        break;
                    case 29:
                        {
                        alt28=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("1220:23: ( '?' | '*' | '+' )", 28, 0, input);

                        throw nvae;
                    }

                    switch (alt28) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1220:24: '?'
                            {
                            match(input,27,FOLLOW_27_in_ruleAbstractToken2609); 

                                    createLeafNode(grammarAccess.prAbstractToken().ele100KeywordQuestionMark(), "cardinality"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1226:6: '*'
                            {
                            match(input,28,FOLLOW_28_in_ruleAbstractToken2625); 

                                    createLeafNode(grammarAccess.prAbstractToken().ele101KeywordAsterisk(), "cardinality"); 
                                

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1232:6: '+'
                            {
                            match(input,29,FOLLOW_29_in_ruleAbstractToken2641); 

                                    createLeafNode(grammarAccess.prAbstractToken().ele102KeywordPlusSign(), "cardinality"); 
                                

                            }
                            break;

                    }


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prAbstractToken().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "cardinality", /* lv_cardinality_3 */ input.LT(-1), null, lastConsumedNode);
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
    // $ANTLR end ruleAbstractToken


    // $ANTLR start entryRuleTerminalToken
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1259:1: entryRuleTerminalToken returns [EObject current=null] : iv_ruleTerminalToken= ruleTerminalToken EOF ;
    public final EObject entryRuleTerminalToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalToken = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1259:55: (iv_ruleTerminalToken= ruleTerminalToken EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1260:2: iv_ruleTerminalToken= ruleTerminalToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken2690);
            iv_ruleTerminalToken=ruleTerminalToken();
            _fsp--;

             current =iv_ruleTerminalToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalToken2700); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1267:1: ruleTerminalToken returns [EObject current=null] : (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( '?' | '*' | '+' ) )? ) ;
    public final EObject ruleTerminalToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_1=null;
        EObject this_TerminalTokenElement_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1272:6: ( (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( '?' | '*' | '+' ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1273:1: (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( '?' | '*' | '+' ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1273:1: (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( '?' | '*' | '+' ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1274:5: this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( '?' | '*' | '+' ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.prTerminalToken().ele0ParserRuleCallTerminalTokenElement(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken2747);
            this_TerminalTokenElement_0=ruleTerminalTokenElement();
            _fsp--;

             
                    current = this_TerminalTokenElement_0; 
                    currentNode = currentNode.getParent();
                
             
                createLeafNode(grammarAccess.prTerminalToken().ele0ParserRuleCallTerminalTokenElement(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1286:1: (lv_cardinality_1= ( '?' | '*' | '+' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=27 && LA31_0<=29)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1288:6: lv_cardinality_1= ( '?' | '*' | '+' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1288:23: ( '?' | '*' | '+' )
                    int alt30=3;
                    switch ( input.LA(1) ) {
                    case 27:
                        {
                        alt30=1;
                        }
                        break;
                    case 28:
                        {
                        alt30=2;
                        }
                        break;
                    case 29:
                        {
                        alt30=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("1288:23: ( '?' | '*' | '+' )", 30, 0, input);

                        throw nvae;
                    }

                    switch (alt30) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1288:24: '?'
                            {
                            match(input,27,FOLLOW_27_in_ruleTerminalToken2775); 

                                    createLeafNode(grammarAccess.prTerminalToken().ele100KeywordQuestionMark(), "cardinality"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1294:6: '*'
                            {
                            match(input,28,FOLLOW_28_in_ruleTerminalToken2791); 

                                    createLeafNode(grammarAccess.prTerminalToken().ele101KeywordAsterisk(), "cardinality"); 
                                

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1300:6: '+'
                            {
                            match(input,29,FOLLOW_29_in_ruleTerminalToken2807); 

                                    createLeafNode(grammarAccess.prTerminalToken().ele102KeywordPlusSign(), "cardinality"); 
                                

                            }
                            break;

                    }


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prTerminalToken().getRule().getType().getType());
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


    // $ANTLR start entryRuleAssignment
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1327:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1327:52: (iv_ruleAssignment= ruleAssignment EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1328:2: iv_ruleAssignment= ruleAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAssignment().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment2856);
            iv_ruleAssignment=ruleAssignment();
            _fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment2866); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1335:1: ruleAssignment returns [EObject current=null] : ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( '+=' | '=' | '?=' ) ) (lv_terminal_2= ruleAbstractTerminal ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0=null;
        Token lv_operator_1=null;
        EObject lv_terminal_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1340:6: ( ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( '+=' | '=' | '?=' ) ) (lv_terminal_2= ruleAbstractTerminal ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1341:1: ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( '+=' | '=' | '?=' ) ) (lv_terminal_2= ruleAbstractTerminal ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1341:1: ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( '+=' | '=' | '?=' ) ) (lv_terminal_2= ruleAbstractTerminal ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1341:2: (lv_feature_0= RULE_ID ) (lv_operator_1= ( '+=' | '=' | '?=' ) ) (lv_terminal_2= ruleAbstractTerminal )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1341:2: (lv_feature_0= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1343:6: lv_feature_0= RULE_ID
            {
            lv_feature_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignment2913); 

            		createLeafNode(grammarAccess.prAssignment().ele00TerminalRuleCallID(), "feature"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prAssignment().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "feature", lv_feature_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1361:2: (lv_operator_1= ( '+=' | '=' | '?=' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1363:6: lv_operator_1= ( '+=' | '=' | '?=' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1363:20: ( '+=' | '=' | '?=' )
            int alt32=3;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt32=1;
                }
                break;
            case 31:
                {
                alt32=2;
                }
                break;
            case 32:
                {
                alt32=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1363:20: ( '+=' | '=' | '?=' )", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1363:21: '+='
                    {
                    match(input,30,FOLLOW_30_in_ruleAssignment2943); 

                            createLeafNode(grammarAccess.prAssignment().ele100KeywordPlusSignEqualsSign(), "operator"); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1369:6: '='
                    {
                    match(input,31,FOLLOW_31_in_ruleAssignment2959); 

                            createLeafNode(grammarAccess.prAssignment().ele101KeywordEqualsSign(), "operator"); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1375:6: '?='
                    {
                    match(input,32,FOLLOW_32_in_ruleAssignment2975); 

                            createLeafNode(grammarAccess.prAssignment().ele102KeywordQuestionMarkEqualsSign(), "operator"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prAssignment().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "operator", /* lv_operator_1 */ input.LT(-1), null, lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1395:2: (lv_terminal_2= ruleAbstractTerminal )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1398:6: lv_terminal_2= ruleAbstractTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prAssignment().ele20ParserRuleCallAbstractTerminal(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAssignment3024);
            lv_terminal_2=ruleAbstractTerminal();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prAssignment().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "terminal", lv_terminal_2, "AbstractTerminal", currentNode);
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


    // $ANTLR start entryRuleAction
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1423:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1423:48: (iv_ruleAction= ruleAction EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1424:2: iv_ruleAction= ruleAction EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAction().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAction_in_entryRuleAction3061);
            iv_ruleAction=ruleAction();
            _fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAction3071); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1431:1: ruleAction returns [EObject current=null] : ( '{' (lv_typeName_1= ruleTypeRef ) ( '.' (lv_feature_3= RULE_ID ) (lv_operator_4= ( '=' | '+=' ) ) 'current' )? '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_feature_3=null;
        Token lv_operator_4=null;
        EObject lv_typeName_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1436:6: ( ( '{' (lv_typeName_1= ruleTypeRef ) ( '.' (lv_feature_3= RULE_ID ) (lv_operator_4= ( '=' | '+=' ) ) 'current' )? '}' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1437:1: ( '{' (lv_typeName_1= ruleTypeRef ) ( '.' (lv_feature_3= RULE_ID ) (lv_operator_4= ( '=' | '+=' ) ) 'current' )? '}' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1437:1: ( '{' (lv_typeName_1= ruleTypeRef ) ( '.' (lv_feature_3= RULE_ID ) (lv_operator_4= ( '=' | '+=' ) ) 'current' )? '}' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1437:2: '{' (lv_typeName_1= ruleTypeRef ) ( '.' (lv_feature_3= RULE_ID ) (lv_operator_4= ( '=' | '+=' ) ) 'current' )? '}'
            {
            match(input,33,FOLLOW_33_in_ruleAction3105); 

                    createLeafNode(grammarAccess.prAction().ele0KeywordLeftCurlyBracket(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1441:1: (lv_typeName_1= ruleTypeRef )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1444:6: lv_typeName_1= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prAction().ele10ParserRuleCallTypeRef(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAction3139);
            lv_typeName_1=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prAction().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "typeName", lv_typeName_1, "TypeRef", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1462:2: ( '.' (lv_feature_3= RULE_ID ) (lv_operator_4= ( '=' | '+=' ) ) 'current' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==17) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1462:3: '.' (lv_feature_3= RULE_ID ) (lv_operator_4= ( '=' | '+=' ) ) 'current'
                    {
                    match(input,17,FOLLOW_17_in_ruleAction3153); 

                            createLeafNode(grammarAccess.prAction().ele20KeywordFullStop(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1466:1: (lv_feature_3= RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1468:6: lv_feature_3= RULE_ID
                    {
                    lv_feature_3=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAction3175); 

                    		createLeafNode(grammarAccess.prAction().ele210TerminalRuleCallID(), "feature"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prAction().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "feature", lv_feature_3, "ID", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1486:2: (lv_operator_4= ( '=' | '+=' ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1488:6: lv_operator_4= ( '=' | '+=' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1488:20: ( '=' | '+=' )
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==31) ) {
                        alt33=1;
                    }
                    else if ( (LA33_0==30) ) {
                        alt33=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1488:20: ( '=' | '+=' )", 33, 0, input);

                        throw nvae;
                    }
                    switch (alt33) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1488:21: '='
                            {
                            match(input,31,FOLLOW_31_in_ruleAction3205); 

                                    createLeafNode(grammarAccess.prAction().ele2200KeywordEqualsSign(), "operator"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1494:6: '+='
                            {
                            match(input,30,FOLLOW_30_in_ruleAction3221); 

                                    createLeafNode(grammarAccess.prAction().ele2201KeywordPlusSignEqualsSign(), "operator"); 
                                

                            }
                            break;

                    }


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prAction().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "operator", /* lv_operator_4 */ input.LT(-1), null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    match(input,34,FOLLOW_34_in_ruleAction3245); 

                            createLeafNode(grammarAccess.prAction().ele23KeywordCurrent(), null); 
                        

                    }
                    break;

            }

            match(input,35,FOLLOW_35_in_ruleAction3256); 

                    createLeafNode(grammarAccess.prAction().ele3KeywordRightCurlyBracket(), null); 
                

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1529:1: entryRuleAbstractTerminal returns [EObject current=null] : iv_ruleAbstractTerminal= ruleAbstractTerminal EOF ;
    public final EObject entryRuleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTerminal = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1529:58: (iv_ruleAbstractTerminal= ruleAbstractTerminal EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1530:2: iv_ruleAbstractTerminal= ruleAbstractTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractTerminal().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal3289);
            iv_ruleAbstractTerminal=ruleAbstractTerminal();
            _fsp--;

             current =iv_ruleAbstractTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractTerminal3299); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1537:1: ruleAbstractTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement | this_CrossReference_3= ruleCrossReference ) ;
    public final EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedElement_2 = null;

        EObject this_CrossReference_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1542:6: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement | this_CrossReference_3= ruleCrossReference ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1543:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement | this_CrossReference_3= ruleCrossReference )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1543:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement | this_CrossReference_3= ruleCrossReference )
            int alt35=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt35=1;
                }
                break;
            case RULE_ID:
                {
                alt35=2;
                }
                break;
            case 15:
                {
                alt35=3;
                }
                break;
            case 39:
                {
                alt35=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1543:1: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement | this_CrossReference_3= ruleCrossReference )", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1544:5: this_Keyword_0= ruleKeyword
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele0ParserRuleCallKeyword(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleKeyword_in_ruleAbstractTerminal3346);
                    this_Keyword_0=ruleKeyword();
                    _fsp--;

                     
                            current = this_Keyword_0; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prAbstractTerminal().ele0ParserRuleCallKeyword(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1558:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele1ParserRuleCallRuleCall(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRuleCall_in_ruleAbstractTerminal3380);
                    this_RuleCall_1=ruleRuleCall();
                    _fsp--;

                     
                            current = this_RuleCall_1; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prAbstractTerminal().ele1ParserRuleCallRuleCall(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1572:5: this_ParenthesizedElement_2= ruleParenthesizedElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele2ParserRuleCallParenthesizedElement(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal3414);
                    this_ParenthesizedElement_2=ruleParenthesizedElement();
                    _fsp--;

                     
                            current = this_ParenthesizedElement_2; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prAbstractTerminal().ele2ParserRuleCallParenthesizedElement(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1586:5: this_CrossReference_3= ruleCrossReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele3ParserRuleCallCrossReference(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCrossReference_in_ruleAbstractTerminal3448);
                    this_CrossReference_3=ruleCrossReference();
                    _fsp--;

                     
                            current = this_CrossReference_3; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prAbstractTerminal().ele3ParserRuleCallCrossReference(), null); 
                        

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


    // $ANTLR start entryRuleTerminalTokenElement
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1605:1: entryRuleTerminalTokenElement returns [EObject current=null] : iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF ;
    public final EObject entryRuleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalTokenElement = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1605:62: (iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1606:2: iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalTokenElement().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement3487);
            iv_ruleTerminalTokenElement=ruleTerminalTokenElement();
            _fsp--;

             current =iv_ruleTerminalTokenElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalTokenElement3497); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1613:1: ruleTerminalTokenElement returns [EObject current=null] : (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard ) ;
    public final EObject ruleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject this_CharacterRange_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedTerminalElement_2 = null;

        EObject this_AbstractNegatedToken_3 = null;

        EObject this_Wildcard_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1618:6: ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1619:1: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1619:1: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )
            int alt36=5;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt36=1;
                }
                break;
            case RULE_ID:
                {
                alt36=2;
                }
                break;
            case 15:
                {
                alt36=3;
                }
                break;
            case 36:
            case 37:
                {
                alt36=4;
                }
                break;
            case 17:
                {
                alt36=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1619:1: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard )", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1620:5: this_CharacterRange_0= ruleCharacterRange
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele0ParserRuleCallCharacterRange(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement3544);
                    this_CharacterRange_0=ruleCharacterRange();
                    _fsp--;

                     
                            current = this_CharacterRange_0; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prTerminalTokenElement().ele0ParserRuleCallCharacterRange(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1634:5: this_RuleCall_1= ruleRuleCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele1ParserRuleCallRuleCall(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement3578);
                    this_RuleCall_1=ruleRuleCall();
                    _fsp--;

                     
                            current = this_RuleCall_1; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prTerminalTokenElement().ele1ParserRuleCallRuleCall(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1648:5: this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele2ParserRuleCallParenthesizedTerminalElement(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement3612);
                    this_ParenthesizedTerminalElement_2=ruleParenthesizedTerminalElement();
                    _fsp--;

                     
                            current = this_ParenthesizedTerminalElement_2; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prTerminalTokenElement().ele2ParserRuleCallParenthesizedTerminalElement(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1662:5: this_AbstractNegatedToken_3= ruleAbstractNegatedToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele3ParserRuleCallAbstractNegatedToken(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement3646);
                    this_AbstractNegatedToken_3=ruleAbstractNegatedToken();
                    _fsp--;

                     
                            current = this_AbstractNegatedToken_3; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prTerminalTokenElement().ele3ParserRuleCallAbstractNegatedToken(), null); 
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1676:5: this_Wildcard_4= ruleWildcard
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele4ParserRuleCallWildcard(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleWildcard_in_ruleTerminalTokenElement3680);
                    this_Wildcard_4=ruleWildcard();
                    _fsp--;

                     
                            current = this_Wildcard_4; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prTerminalTokenElement().ele4ParserRuleCallWildcard(), null); 
                        

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


    // $ANTLR start entryRuleAbstractNegatedToken
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1695:1: entryRuleAbstractNegatedToken returns [EObject current=null] : iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF ;
    public final EObject entryRuleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractNegatedToken = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1695:62: (iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1696:2: iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractNegatedToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken3719);
            iv_ruleAbstractNegatedToken=ruleAbstractNegatedToken();
            _fsp--;

             current =iv_ruleAbstractNegatedToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractNegatedToken3729); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1703:1: ruleAbstractNegatedToken returns [EObject current=null] : (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) ;
    public final EObject ruleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject this_NegatedToken_0 = null;

        EObject this_UntilToken_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1708:6: ( (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1709:1: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1709:1: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==36) ) {
                alt37=1;
            }
            else if ( (LA37_0==37) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1709:1: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1710:5: this_NegatedToken_0= ruleNegatedToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractNegatedToken().ele0ParserRuleCallNegatedToken(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken3776);
                    this_NegatedToken_0=ruleNegatedToken();
                    _fsp--;

                     
                            current = this_NegatedToken_0; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prAbstractNegatedToken().ele0ParserRuleCallNegatedToken(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1724:5: this_UntilToken_1= ruleUntilToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractNegatedToken().ele1ParserRuleCallUntilToken(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUntilToken_in_ruleAbstractNegatedToken3810);
                    this_UntilToken_1=ruleUntilToken();
                    _fsp--;

                     
                            current = this_UntilToken_1; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prAbstractNegatedToken().ele1ParserRuleCallUntilToken(), null); 
                        

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1743:1: entryRuleNegatedToken returns [EObject current=null] : iv_ruleNegatedToken= ruleNegatedToken EOF ;
    public final EObject entryRuleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegatedToken = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1743:54: (iv_ruleNegatedToken= ruleNegatedToken EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1744:2: iv_ruleNegatedToken= ruleNegatedToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prNegatedToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken3849);
            iv_ruleNegatedToken=ruleNegatedToken();
            _fsp--;

             current =iv_ruleNegatedToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegatedToken3859); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1751:1: ruleNegatedToken returns [EObject current=null] : ( '!' (lv_terminal_1= ruleTerminalTokenElement ) ) ;
    public final EObject ruleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1756:6: ( ( '!' (lv_terminal_1= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1757:1: ( '!' (lv_terminal_1= ruleTerminalTokenElement ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1757:1: ( '!' (lv_terminal_1= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1757:2: '!' (lv_terminal_1= ruleTerminalTokenElement )
            {
            match(input,36,FOLLOW_36_in_ruleNegatedToken3893); 

                    createLeafNode(grammarAccess.prNegatedToken().ele0KeywordExclamationMark(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1761:1: (lv_terminal_1= ruleTerminalTokenElement )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1764:6: lv_terminal_1= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prNegatedToken().ele10ParserRuleCallTerminalTokenElement(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken3927);
            lv_terminal_1=ruleTerminalTokenElement();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prNegatedToken().getRule().getType().getType());
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1789:1: entryRuleUntilToken returns [EObject current=null] : iv_ruleUntilToken= ruleUntilToken EOF ;
    public final EObject entryRuleUntilToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUntilToken = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1789:52: (iv_ruleUntilToken= ruleUntilToken EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1790:2: iv_ruleUntilToken= ruleUntilToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prUntilToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleUntilToken_in_entryRuleUntilToken3964);
            iv_ruleUntilToken=ruleUntilToken();
            _fsp--;

             current =iv_ruleUntilToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUntilToken3974); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1797:1: ruleUntilToken returns [EObject current=null] : ( '->' (lv_terminal_1= ruleTerminalTokenElement ) ) ;
    public final EObject ruleUntilToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1802:6: ( ( '->' (lv_terminal_1= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1803:1: ( '->' (lv_terminal_1= ruleTerminalTokenElement ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1803:1: ( '->' (lv_terminal_1= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1803:2: '->' (lv_terminal_1= ruleTerminalTokenElement )
            {
            match(input,37,FOLLOW_37_in_ruleUntilToken4008); 

                    createLeafNode(grammarAccess.prUntilToken().ele0KeywordHyphenMinusGreaterThanSign(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1807:1: (lv_terminal_1= ruleTerminalTokenElement )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1810:6: lv_terminal_1= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prUntilToken().ele10ParserRuleCallTerminalTokenElement(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleUntilToken4042);
            lv_terminal_1=ruleTerminalTokenElement();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prUntilToken().getRule().getType().getType());
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1835:1: entryRuleWildcard returns [EObject current=null] : iv_ruleWildcard= ruleWildcard EOF ;
    public final EObject entryRuleWildcard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcard = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1835:50: (iv_ruleWildcard= ruleWildcard EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1836:2: iv_ruleWildcard= ruleWildcard EOF
            {
             currentNode = createCompositeNode(grammarAccess.prWildcard().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleWildcard_in_entryRuleWildcard4079);
            iv_ruleWildcard=ruleWildcard();
            _fsp--;

             current =iv_ruleWildcard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWildcard4089); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1843:1: ruleWildcard returns [EObject current=null] : ( () '.' ) ;
    public final EObject ruleWildcard() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1848:6: ( ( () '.' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1849:1: ( () '.' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1849:1: ( () '.' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1849:2: () '.'
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1849:2: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1850:5: 
            {
             
                    temp=factory.create(grammarAccess.prWildcard().ele0ActionWildcardnull().getTypeName().getType());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.prWildcard().ele0ActionWildcardnull(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,17,FOLLOW_17_in_ruleWildcard4132); 

                    createLeafNode(grammarAccess.prWildcard().ele1KeywordFullStop(), null); 
                

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1871:1: entryRuleCharacterRange returns [EObject current=null] : iv_ruleCharacterRange= ruleCharacterRange EOF ;
    public final EObject entryRuleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterRange = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1871:56: (iv_ruleCharacterRange= ruleCharacterRange EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1872:2: iv_ruleCharacterRange= ruleCharacterRange EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCharacterRange().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange4165);
            iv_ruleCharacterRange=ruleCharacterRange();
            _fsp--;

             current =iv_ruleCharacterRange; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCharacterRange4175); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1879:1: ruleCharacterRange returns [EObject current=null] : (this_Keyword_0= ruleKeyword ( () '..' (lv_right_3= ruleKeyword ) )? ) ;
    public final EObject ruleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject lv_right_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1884:6: ( (this_Keyword_0= ruleKeyword ( () '..' (lv_right_3= ruleKeyword ) )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1885:1: (this_Keyword_0= ruleKeyword ( () '..' (lv_right_3= ruleKeyword ) )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1885:1: (this_Keyword_0= ruleKeyword ( () '..' (lv_right_3= ruleKeyword ) )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1886:5: this_Keyword_0= ruleKeyword ( () '..' (lv_right_3= ruleKeyword ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.prCharacterRange().ele0ParserRuleCallKeyword(), currentNode); 
                
            pushFollow(FOLLOW_ruleKeyword_in_ruleCharacterRange4222);
            this_Keyword_0=ruleKeyword();
            _fsp--;

             
                    current = this_Keyword_0; 
                    currentNode = currentNode.getParent();
                
             
                createLeafNode(grammarAccess.prCharacterRange().ele0ParserRuleCallKeyword(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1898:1: ( () '..' (lv_right_3= ruleKeyword ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==38) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1898:2: () '..' (lv_right_3= ruleKeyword )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1898:2: ()
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1899:5: 
                    {
                     
                            temp=factory.create(grammarAccess.prCharacterRange().ele10ActionCharacterRangeleft().getTypeName().getType());
                            try {
                            	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.prCharacterRange().ele10ActionCharacterRangeleft(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    match(input,38,FOLLOW_38_in_ruleCharacterRange4247); 

                            createLeafNode(grammarAccess.prCharacterRange().ele11KeywordFullStopFullStop(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1918:1: (lv_right_3= ruleKeyword )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1921:6: lv_right_3= ruleKeyword
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prCharacterRange().ele120ParserRuleCallKeyword(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleKeyword_in_ruleCharacterRange4281);
                    lv_right_3=ruleKeyword();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prCharacterRange().getRule().getType().getType());
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


    // $ANTLR start entryRuleCrossReference
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1946:1: entryRuleCrossReference returns [EObject current=null] : iv_ruleCrossReference= ruleCrossReference EOF ;
    public final EObject entryRuleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReference = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1946:56: (iv_ruleCrossReference= ruleCrossReference EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1947:2: iv_ruleCrossReference= ruleCrossReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCrossReference().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCrossReference_in_entryRuleCrossReference4320);
            iv_ruleCrossReference=ruleCrossReference();
            _fsp--;

             current =iv_ruleCrossReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReference4330); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1954:1: ruleCrossReference returns [EObject current=null] : ( '[' (lv_type_1= ruleTypeRef ) ( '|' ( RULE_ID ) )? ']' ) ;
    public final EObject ruleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject lv_type_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1959:6: ( ( '[' (lv_type_1= ruleTypeRef ) ( '|' ( RULE_ID ) )? ']' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1960:1: ( '[' (lv_type_1= ruleTypeRef ) ( '|' ( RULE_ID ) )? ']' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1960:1: ( '[' (lv_type_1= ruleTypeRef ) ( '|' ( RULE_ID ) )? ']' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1960:2: '[' (lv_type_1= ruleTypeRef ) ( '|' ( RULE_ID ) )? ']'
            {
            match(input,39,FOLLOW_39_in_ruleCrossReference4364); 

                    createLeafNode(grammarAccess.prCrossReference().ele0KeywordLeftSquareBracket(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1964:1: (lv_type_1= ruleTypeRef )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1967:6: lv_type_1= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prCrossReference().ele10ParserRuleCallTypeRef(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleCrossReference4398);
            lv_type_1=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prCrossReference().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "type", lv_type_1, "TypeRef", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1985:2: ( '|' ( RULE_ID ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==26) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1985:3: '|' ( RULE_ID )
                    {
                    match(input,26,FOLLOW_26_in_ruleCrossReference4412); 

                            createLeafNode(grammarAccess.prCrossReference().ele20KeywordVerticalLine(), null); 
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1989:1: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1992:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prCrossReference().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCrossReference4434); 

                    		createLeafNode(grammarAccess.prCrossReference().ele210CrossReferenceEStringAbstractRule(), "rule"); 
                    	

                    }


                    }
                    break;

            }

            match(input,40,FOLLOW_40_in_ruleCrossReference4448); 

                    createLeafNode(grammarAccess.prCrossReference().ele3KeywordRightSquareBracket(), null); 
                

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


    // $ANTLR start entryRuleParenthesizedElement
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2016:1: entryRuleParenthesizedElement returns [EObject current=null] : iv_ruleParenthesizedElement= ruleParenthesizedElement EOF ;
    public final EObject entryRuleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedElement = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2016:62: (iv_ruleParenthesizedElement= ruleParenthesizedElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2017:2: iv_ruleParenthesizedElement= ruleParenthesizedElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.prParenthesizedElement().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement4481);
            iv_ruleParenthesizedElement=ruleParenthesizedElement();
            _fsp--;

             current =iv_ruleParenthesizedElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedElement4491); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2024:1: ruleParenthesizedElement returns [EObject current=null] : ( '(' this_Alternatives_1= ruleAlternatives ')' ) ;
    public final EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Alternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2029:6: ( ( '(' this_Alternatives_1= ruleAlternatives ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2030:1: ( '(' this_Alternatives_1= ruleAlternatives ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2030:1: ( '(' this_Alternatives_1= ruleAlternatives ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2030:2: '(' this_Alternatives_1= ruleAlternatives ')'
            {
            match(input,15,FOLLOW_15_in_ruleParenthesizedElement4525); 

                    createLeafNode(grammarAccess.prParenthesizedElement().ele0KeywordLeftParenthesis(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.prParenthesizedElement().ele1ParserRuleCallAlternatives(), currentNode); 
                
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesizedElement4547);
            this_Alternatives_1=ruleAlternatives();
            _fsp--;

             
                    current = this_Alternatives_1; 
                    currentNode = currentNode.getParent();
                
             
                createLeafNode(grammarAccess.prParenthesizedElement().ele1ParserRuleCallAlternatives(), null); 
                
            match(input,16,FOLLOW_16_in_ruleParenthesizedElement4562); 

                    createLeafNode(grammarAccess.prParenthesizedElement().ele2KeywordRightParenthesis(), null); 
                

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


    // $ANTLR start entryRuleParenthesizedTerminalElement
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2058:1: entryRuleParenthesizedTerminalElement returns [EObject current=null] : iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF ;
    public final EObject entryRuleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedTerminalElement = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2058:70: (iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2059:2: iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.prParenthesizedTerminalElement().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4595);
            iv_ruleParenthesizedTerminalElement=ruleParenthesizedTerminalElement();
            _fsp--;

             current =iv_ruleParenthesizedTerminalElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4605); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2066:1: ruleParenthesizedTerminalElement returns [EObject current=null] : ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')' ) ;
    public final EObject ruleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalAlternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2071:6: ( ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2072:1: ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2072:1: ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2072:2: '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ')'
            {
            match(input,15,FOLLOW_15_in_ruleParenthesizedTerminalElement4639); 

                    createLeafNode(grammarAccess.prParenthesizedTerminalElement().ele0KeywordLeftParenthesis(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.prParenthesizedTerminalElement().ele1ParserRuleCallTerminalAlternatives(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4661);
            this_TerminalAlternatives_1=ruleTerminalAlternatives();
            _fsp--;

             
                    current = this_TerminalAlternatives_1; 
                    currentNode = currentNode.getParent();
                
             
                createLeafNode(grammarAccess.prParenthesizedTerminalElement().ele1ParserRuleCallTerminalAlternatives(), null); 
                
            match(input,16,FOLLOW_16_in_ruleParenthesizedTerminalElement4676); 

                    createLeafNode(grammarAccess.prParenthesizedTerminalElement().ele2KeywordRightParenthesis(), null); 
                

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


    // $ANTLR start entryRuleKeyword
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2100:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2100:49: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2101:2: iv_ruleKeyword= ruleKeyword EOF
            {
             currentNode = createCompositeNode(grammarAccess.prKeyword().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword4709);
            iv_ruleKeyword=ruleKeyword();
            _fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword4719); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2108:1: ruleKeyword returns [EObject current=null] : (lv_value_0= RULE_STRING ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2113:6: ( (lv_value_0= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2114:1: (lv_value_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2114:1: (lv_value_0= RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2116:6: lv_value_0= RULE_STRING
            {
            lv_value_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword4765); 

            		createLeafNode(grammarAccess.prKeyword().ele0TerminalRuleCallSTRING(), "value"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prKeyword().getRule().getType().getType());
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2141:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2141:50: (iv_ruleRuleCall= ruleRuleCall EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2142:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.prRuleCall().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleRuleCall_in_entryRuleRuleCall4805);
            iv_ruleRuleCall=ruleRuleCall();
            _fsp--;

             current =iv_ruleRuleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleCall4815); 

            }

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2149:1: ruleRuleCall returns [EObject current=null] : ( RULE_ID ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2154:6: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2155:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2155:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2158:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prRuleCall().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall4861); 

            		createLeafNode(grammarAccess.prRuleCall().ele0CrossReferenceEStringAbstractRule(), "rule"); 
            	

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


 

    public static final BitSet FOLLOW_ruleGrammar_in_entryRuleGrammar71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammar81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleGrammar115 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar149 = new BitSet(new long[]{0x0000000001145010L});
    public static final BitSet FOLLOW_12_in_ruleGrammar163 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar190 = new BitSet(new long[]{0x0000000001146010L});
    public static final BitSet FOLLOW_13_in_ruleGrammar203 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar230 = new BitSet(new long[]{0x0000000001146010L});
    public static final BitSet FOLLOW_14_in_ruleGrammar259 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleGrammar281 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar304 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_13_in_ruleGrammar317 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar339 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_16_in_ruleGrammar355 = new BitSet(new long[]{0x0000000001140010L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar391 = new BitSet(new long[]{0x0000000001140010L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleGrammar430 = new BitSet(new long[]{0x0000000001000012L});
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
    public static final BitSet FOLLOW_22_in_ruleParserRule1421 = new BitSet(new long[]{0x0000008200008030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule1455 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleParserRule1468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1501 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule1511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleTerminalRule1545 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTerminalRule1567 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_ruleTerminalRule1585 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleTerminalRule1619 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTerminalRule1634 = new BitSet(new long[]{0x0000003000028030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule1668 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleTerminalRule1681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef1714 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef1724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef1772 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleTypeRef1784 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef1808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives1844 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives1854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives1901 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleAlternatives1927 = new BitSet(new long[]{0x0000008200008030L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives1961 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives2002 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives2012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2059 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleTerminalAlternatives2085 = new BitSet(new long[]{0x0000003000028030L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2119 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup2160 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroup2170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup2217 = new BitSet(new long[]{0x0000008200008032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup2267 = new BitSet(new long[]{0x0000008200008032L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup2307 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup2317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2364 = new BitSet(new long[]{0x0000003000028032L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2414 = new BitSet(new long[]{0x0000003000028032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken2454 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken2464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractToken2512 = new BitSet(new long[]{0x0000000038000002L});
    public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken2546 = new BitSet(new long[]{0x0000000038000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken2580 = new BitSet(new long[]{0x0000000038000002L});
    public static final BitSet FOLLOW_27_in_ruleAbstractToken2609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleAbstractToken2625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleAbstractToken2641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken2690 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken2700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken2747 = new BitSet(new long[]{0x0000000038000002L});
    public static final BitSet FOLLOW_27_in_ruleTerminalToken2775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleTerminalToken2791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleTerminalToken2807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment2856 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment2866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment2913 = new BitSet(new long[]{0x00000001C0000000L});
    public static final BitSet FOLLOW_30_in_ruleAssignment2943 = new BitSet(new long[]{0x0000008000008030L});
    public static final BitSet FOLLOW_31_in_ruleAssignment2959 = new BitSet(new long[]{0x0000008000008030L});
    public static final BitSet FOLLOW_32_in_ruleAssignment2975 = new BitSet(new long[]{0x0000008000008030L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAssignment3024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_entryRuleAction3061 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAction3071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleAction3105 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction3139 = new BitSet(new long[]{0x0000000800020000L});
    public static final BitSet FOLLOW_17_in_ruleAction3153 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAction3175 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_31_in_ruleAction3205 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_30_in_ruleAction3221 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleAction3245 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleAction3256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal3289 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal3299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal3346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal3380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal3414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_ruleAbstractTerminal3448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement3487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement3497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement3544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement3578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement3612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement3646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_ruleTerminalTokenElement3680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken3719 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken3729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken3776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUntilToken_in_ruleAbstractNegatedToken3810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken3849 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken3859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleNegatedToken3893 = new BitSet(new long[]{0x0000003000028030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken3927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUntilToken_in_entryRuleUntilToken3964 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUntilToken3974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleUntilToken4008 = new BitSet(new long[]{0x0000003000028030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleUntilToken4042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard4079 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcard4089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleWildcard4132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange4165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange4175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange4222 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleCharacterRange4247 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange4281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference4320 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference4330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleCrossReference4364 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleCrossReference4398 = new BitSet(new long[]{0x0000010004000000L});
    public static final BitSet FOLLOW_26_in_ruleCrossReference4412 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCrossReference4434 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleCrossReference4448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement4481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement4491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedElement4525 = new BitSet(new long[]{0x0000008200008030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement4547 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParenthesizedElement4562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4595 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedTerminalElement4639 = new BitSet(new long[]{0x0000003000028030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4661 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParenthesizedTerminalElement4676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword4709 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword4719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword4765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall4805 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall4815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall4861 = new BitSet(new long[]{0x0000000000000002L});

}