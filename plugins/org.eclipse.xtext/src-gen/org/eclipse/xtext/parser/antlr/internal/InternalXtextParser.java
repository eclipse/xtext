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

public class InternalXtextParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'grammar'", "'extends'", "'hidden'", "'('", "','", "')'", "'.'", "'generate'", "'as'", "'import'", "'native'", "'lexer'", "'returns'", "':'", "';'", "'terminal'", "'::'", "'|'", "'?'", "'*'", "'+'", "'+='", "'='", "'?='", "'{'", "'current'", "'}'", "'!'", "'->'", "'..'", "'['", "']'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalXtextParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g"; }


     
     	private XtextGrammarAccess grammarAccess;
     	
        public InternalXtextParser(TokenStream input, IAstFactory factory, XtextGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/antlr/internal/InternalXtext.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Grammar";	
       	} 



    // $ANTLR start entryRuleGrammar
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:70:1: entryRuleGrammar returns [EObject current=null] : iv_ruleGrammar= ruleGrammar EOF ;
    public final EObject entryRuleGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammar = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:70:49: (iv_ruleGrammar= ruleGrammar EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:71:2: iv_ruleGrammar= ruleGrammar EOF
            {
             currentNode = createCompositeNode(grammarAccess.prGrammar().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleGrammar_in_entryRuleGrammar72);
            iv_ruleGrammar=ruleGrammar();
            _fsp--;

             current =iv_ruleGrammar; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGrammar82); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:78:1: ruleGrammar returns [EObject current=null] : ( ( ( ( ( 'grammar' (lv_name_1= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_4= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) (lv_metamodelDeclarations_10= ruleAbstractMetamodelDeclaration )* ) (lv_rules_11= ruleAbstractRule )+ ) ;
    public final EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        Token lv_definesHiddenTokens_4=null;
        AntlrDatatypeRuleToken lv_name_1 = null;

        EObject lv_metamodelDeclarations_10 = null;

        EObject lv_rules_11 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:83:6: ( ( ( ( ( ( 'grammar' (lv_name_1= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_4= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) (lv_metamodelDeclarations_10= ruleAbstractMetamodelDeclaration )* ) (lv_rules_11= ruleAbstractRule )+ ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:1: ( ( ( ( ( 'grammar' (lv_name_1= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_4= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) (lv_metamodelDeclarations_10= ruleAbstractMetamodelDeclaration )* ) (lv_rules_11= ruleAbstractRule )+ )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:1: ( ( ( ( ( 'grammar' (lv_name_1= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_4= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) (lv_metamodelDeclarations_10= ruleAbstractMetamodelDeclaration )* ) (lv_rules_11= ruleAbstractRule )+ )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:2: ( ( ( ( 'grammar' (lv_name_1= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_4= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) (lv_metamodelDeclarations_10= ruleAbstractMetamodelDeclaration )* ) (lv_rules_11= ruleAbstractRule )+
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:2: ( ( ( ( 'grammar' (lv_name_1= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_4= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) (lv_metamodelDeclarations_10= ruleAbstractMetamodelDeclaration )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:3: ( ( ( 'grammar' (lv_name_1= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_4= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) (lv_metamodelDeclarations_10= ruleAbstractMetamodelDeclaration )*
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:3: ( ( ( 'grammar' (lv_name_1= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_4= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:4: ( ( 'grammar' (lv_name_1= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_4= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:4: ( ( 'grammar' (lv_name_1= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:5: ( 'grammar' (lv_name_1= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:5: ( 'grammar' (lv_name_1= ruleGrammarID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:6: 'grammar' (lv_name_1= ruleGrammarID )
            {
            match(input,11,FOLLOW_11_in_ruleGrammar120); 

                    createLeafNode(grammarAccess.prGrammar().ele00000KeywordGrammar(), null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:88:1: (lv_name_1= ruleGrammarID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:91:6: lv_name_1= ruleGrammarID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele000010ParserRuleCallGrammarID(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleGrammarID_in_ruleGrammar154);
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


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:109:3: ( 'extends' ( ruleGrammarID ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:109:4: 'extends' ( ruleGrammarID )
                    {
                    match(input,12,FOLLOW_12_in_ruleGrammar169); 

                            createLeafNode(grammarAccess.prGrammar().ele00010KeywordExtends(), null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:113:1: ( ruleGrammarID )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:116:3: ruleGrammarID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele000110CrossReferenceEStringGrammar(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleGrammarID_in_ruleGrammar196);
                    ruleGrammarID();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:131:5: ( ( ( (lv_definesHiddenTokens_4= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:131:6: ( ( (lv_definesHiddenTokens_4= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')'
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:131:6: ( ( (lv_definesHiddenTokens_4= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:131:7: ( (lv_definesHiddenTokens_4= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )?
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:131:7: ( (lv_definesHiddenTokens_4= 'hidden' ) '(' )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:131:8: (lv_definesHiddenTokens_4= 'hidden' ) '('
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:131:8: (lv_definesHiddenTokens_4= 'hidden' )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:133:6: lv_definesHiddenTokens_4= 'hidden'
                    {
                    lv_definesHiddenTokens_4=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_ruleGrammar226); 

                            createLeafNode(grammarAccess.prGrammar().ele0010000KeywordHidden(), "definesHiddenTokens"); 
                        

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

                    match(input,14,FOLLOW_14_in_ruleGrammar248); 

                            createLeafNode(grammarAccess.prGrammar().ele001001KeywordLeftParenthesis(), null); 
                        

                    }

                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:156:2: ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==RULE_ID) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:156:3: ( RULE_ID ) ( ',' ( RULE_ID ) )*
                            {
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:156:3: ( RULE_ID )
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:159:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar272); 

                            		createLeafNode(grammarAccess.prGrammar().ele0010100CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
                            	

                            }

                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:172:2: ( ',' ( RULE_ID ) )*
                            loop2:
                            do {
                                int alt2=2;
                                int LA2_0 = input.LA(1);

                                if ( (LA2_0==15) ) {
                                    alt2=1;
                                }


                                switch (alt2) {
                            	case 1 :
                            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:172:3: ',' ( RULE_ID )
                            	    {
                            	    match(input,15,FOLLOW_15_in_ruleGrammar285); 

                            	            createLeafNode(grammarAccess.prGrammar().ele0010110KeywordComma(), null); 
                            	        
                            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:176:1: ( RULE_ID )
                            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:179:3: RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar307); 

                            	    		createLeafNode(grammarAccess.prGrammar().ele00101110CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
                            	    	

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop2;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }

                    match(input,16,FOLLOW_16_in_ruleGrammar324); 

                            createLeafNode(grammarAccess.prGrammar().ele0011KeywordRightParenthesis(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:196:4: (lv_metamodelDeclarations_10= ruleAbstractMetamodelDeclaration )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18||LA5_0==20) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:199:6: lv_metamodelDeclarations_10= ruleAbstractMetamodelDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele010ParserRuleCallAbstractMetamodelDeclaration(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar361);
            	    lv_metamodelDeclarations_10=ruleAbstractMetamodelDeclaration();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "metamodelDeclarations", lv_metamodelDeclarations_10, "AbstractMetamodelDeclaration", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:217:4: (lv_rules_11= ruleAbstractRule )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID||(LA6_0>=21 && LA6_0<=22)||LA6_0==26) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:220:6: lv_rules_11= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele10ParserRuleCallAbstractRule(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleGrammar401);
            	    lv_rules_11=ruleAbstractRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "rules", lv_rules_11, "AbstractRule", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:247:1: entryRuleGrammarID returns [String current=null] : iv_ruleGrammarID= ruleGrammarID EOF ;
    public final String entryRuleGrammarID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGrammarID = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:247:50: (iv_ruleGrammarID= ruleGrammarID EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:248:2: iv_ruleGrammarID= ruleGrammarID EOF
            {
             currentNode = createCompositeNode(grammarAccess.prGrammarID().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleGrammarID_in_entryRuleGrammarID442);
            iv_ruleGrammarID=ruleGrammarID();
            _fsp--;

             current =iv_ruleGrammarID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGrammarID453); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:255:1: ruleGrammarID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleGrammarID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:261:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:262:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:262:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:262:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammarID493); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.prGrammarID().ele0ParserRuleCallID(), null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:269:1: (kw= '.' this_ID_2= RULE_ID )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==17) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:270:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,17,FOLLOW_17_in_ruleGrammarID512); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.prGrammarID().ele10KeywordFullStop(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammarID527); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(grammarAccess.prGrammarID().ele11ParserRuleCallID(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop7;
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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:292:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:292:54: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:293:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule574);
            iv_ruleAbstractRule=ruleAbstractRule();
            _fsp--;

             current =iv_ruleAbstractRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRule584); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:300:1: ruleAbstractRule returns [EObject current=null] : ( (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule ) | this_TerminalRule_2= ruleTerminalRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_LexerRule_0 = null;

        EObject this_ParserRule_1 = null;

        EObject this_TerminalRule_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:305:6: ( ( (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule ) | this_TerminalRule_2= ruleTerminalRule ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:306:1: ( (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule ) | this_TerminalRule_2= ruleTerminalRule )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:306:1: ( (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule ) | this_TerminalRule_2= ruleTerminalRule )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID||(LA9_0>=21 && LA9_0<=22)) ) {
                alt9=1;
            }
            else if ( (LA9_0==26) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("306:1: ( (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule ) | this_TerminalRule_2= ruleTerminalRule )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:306:2: (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:306:2: (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( ((LA8_0>=21 && LA8_0<=22)) ) {
                        alt8=1;
                    }
                    else if ( (LA8_0==RULE_ID) ) {
                        alt8=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("306:2: (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule )", 8, 0, input);

                        throw nvae;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:307:5: this_LexerRule_0= ruleLexerRule
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele00ParserRuleCallLexerRule(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleLexerRule_in_ruleAbstractRule632);
                            this_LexerRule_0=ruleLexerRule();
                            _fsp--;

                             
                                    current = this_LexerRule_0; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:317:5: this_ParserRule_1= ruleParserRule
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele01ParserRuleCallParserRule(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleParserRule_in_ruleAbstractRule659);
                            this_ParserRule_1=ruleParserRule();
                            _fsp--;

                             
                                    current = this_ParserRule_1; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:327:5: this_TerminalRule_2= ruleTerminalRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele1ParserRuleCallTerminalRule(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTerminalRule_in_ruleAbstractRule687);
                    this_TerminalRule_2=ruleTerminalRule();
                    _fsp--;

                     
                            current = this_TerminalRule_2; 
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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:344:1: entryRuleAbstractMetamodelDeclaration returns [EObject current=null] : iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF ;
    public final EObject entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractMetamodelDeclaration = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:344:70: (iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:345:2: iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractMetamodelDeclaration().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration721);
            iv_ruleAbstractMetamodelDeclaration=ruleAbstractMetamodelDeclaration();
            _fsp--;

             current =iv_ruleAbstractMetamodelDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration731); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:352:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) ;
    public final EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel_0 = null;

        EObject this_ReferencedMetamodel_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:357:6: ( (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:358:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:358:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
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
                    new NoViableAltException("358:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:359:5: this_GeneratedMetamodel_0= ruleGeneratedMetamodel
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractMetamodelDeclaration().ele0ParserRuleCallGeneratedMetamodel(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration778);
                    this_GeneratedMetamodel_0=ruleGeneratedMetamodel();
                    _fsp--;

                     
                            current = this_GeneratedMetamodel_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:369:5: this_ReferencedMetamodel_1= ruleReferencedMetamodel
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractMetamodelDeclaration().ele1ParserRuleCallReferencedMetamodel(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration805);
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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:386:1: entryRuleGeneratedMetamodel returns [EObject current=null] : iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF ;
    public final EObject entryRuleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratedMetamodel = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:386:60: (iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:387:2: iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF
            {
             currentNode = createCompositeNode(grammarAccess.prGeneratedMetamodel().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel839);
            iv_ruleGeneratedMetamodel=ruleGeneratedMetamodel();
            _fsp--;

             current =iv_ruleGeneratedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGeneratedMetamodel849); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:394:1: ruleGeneratedMetamodel returns [EObject current=null] : ( ( ( 'generate' (lv_name_1= RULE_ID ) ) ( RULE_STRING ) ) ( 'as' (lv_alias_4= RULE_ID ) )? ) ;
    public final EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_alias_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:399:6: ( ( ( ( 'generate' (lv_name_1= RULE_ID ) ) ( RULE_STRING ) ) ( 'as' (lv_alias_4= RULE_ID ) )? ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:400:1: ( ( ( 'generate' (lv_name_1= RULE_ID ) ) ( RULE_STRING ) ) ( 'as' (lv_alias_4= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:400:1: ( ( ( 'generate' (lv_name_1= RULE_ID ) ) ( RULE_STRING ) ) ( 'as' (lv_alias_4= RULE_ID ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:400:2: ( ( 'generate' (lv_name_1= RULE_ID ) ) ( RULE_STRING ) ) ( 'as' (lv_alias_4= RULE_ID ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:400:2: ( ( 'generate' (lv_name_1= RULE_ID ) ) ( RULE_STRING ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:400:3: ( 'generate' (lv_name_1= RULE_ID ) ) ( RULE_STRING )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:400:3: ( 'generate' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:400:4: 'generate' (lv_name_1= RULE_ID )
            {
            match(input,18,FOLLOW_18_in_ruleGeneratedMetamodel885); 

                    createLeafNode(grammarAccess.prGeneratedMetamodel().ele000KeywordGenerate(), null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:404:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:406:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel906); 

            		createLeafNode(grammarAccess.prGeneratedMetamodel().ele0010ParserRuleCallID(), "name"); 
            	

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


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:423:3: ( RULE_STRING )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:426:3: RULE_STRING
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prGeneratedMetamodel().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel936); 

            		createLeafNode(grammarAccess.prGeneratedMetamodel().ele010CrossReferenceEStringEPackage(), "ePackage"); 
            	

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:439:3: ( 'as' (lv_alias_4= RULE_ID ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:439:4: 'as' (lv_alias_4= RULE_ID )
                    {
                    match(input,19,FOLLOW_19_in_ruleGeneratedMetamodel950); 

                            createLeafNode(grammarAccess.prGeneratedMetamodel().ele10KeywordAs(), null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:443:1: (lv_alias_4= RULE_ID )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:445:6: lv_alias_4= RULE_ID
                    {
                    lv_alias_4=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel971); 

                    		createLeafNode(grammarAccess.prGeneratedMetamodel().ele110ParserRuleCallID(), "alias"); 
                    	

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:471:1: entryRuleReferencedMetamodel returns [EObject current=null] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final EObject entryRuleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedMetamodel = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:471:61: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:472:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
            {
             currentNode = createCompositeNode(grammarAccess.prReferencedMetamodel().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel1015);
            iv_ruleReferencedMetamodel=ruleReferencedMetamodel();
            _fsp--;

             current =iv_ruleReferencedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencedMetamodel1025); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:479:1: ruleReferencedMetamodel returns [EObject current=null] : ( ( 'import' ( RULE_STRING ) ) ( 'as' (lv_alias_3= RULE_ID ) )? ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_alias_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:484:6: ( ( ( 'import' ( RULE_STRING ) ) ( 'as' (lv_alias_3= RULE_ID ) )? ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:485:1: ( ( 'import' ( RULE_STRING ) ) ( 'as' (lv_alias_3= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:485:1: ( ( 'import' ( RULE_STRING ) ) ( 'as' (lv_alias_3= RULE_ID ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:485:2: ( 'import' ( RULE_STRING ) ) ( 'as' (lv_alias_3= RULE_ID ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:485:2: ( 'import' ( RULE_STRING ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:485:3: 'import' ( RULE_STRING )
            {
            match(input,20,FOLLOW_20_in_ruleReferencedMetamodel1060); 

                    createLeafNode(grammarAccess.prReferencedMetamodel().ele00KeywordImport(), null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:489:1: ( RULE_STRING )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:492:3: RULE_STRING
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prReferencedMetamodel().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1082); 

            		createLeafNode(grammarAccess.prReferencedMetamodel().ele010CrossReferenceEStringEPackage(), "ePackage"); 
            	

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:505:3: ( 'as' (lv_alias_3= RULE_ID ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:505:4: 'as' (lv_alias_3= RULE_ID )
                    {
                    match(input,19,FOLLOW_19_in_ruleReferencedMetamodel1096); 

                            createLeafNode(grammarAccess.prReferencedMetamodel().ele10KeywordAs(), null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:509:1: (lv_alias_3= RULE_ID )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:511:6: lv_alias_3= RULE_ID
                    {
                    lv_alias_3=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedMetamodel1117); 

                    		createLeafNode(grammarAccess.prReferencedMetamodel().ele110ParserRuleCallID(), "alias"); 
                    	

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


    // $ANTLR start entryRuleLexerRule
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:537:1: entryRuleLexerRule returns [EObject current=null] : iv_ruleLexerRule= ruleLexerRule EOF ;
    public final EObject entryRuleLexerRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexerRule = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:537:51: (iv_ruleLexerRule= ruleLexerRule EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:538:2: iv_ruleLexerRule= ruleLexerRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prLexerRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleLexerRule_in_entryRuleLexerRule1161);
            iv_ruleLexerRule=ruleLexerRule();
            _fsp--;

             current =iv_ruleLexerRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexerRule1171); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLexerRule


    // $ANTLR start ruleLexerRule
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:545:1: ruleLexerRule returns [EObject current=null] : ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' ) (lv_body_6= RULE_STRING ) ) ';' ) ;
    public final EObject ruleLexerRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        Token lv_body_6=null;
        EObject lv_type_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:550:6: ( ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' ) (lv_body_6= RULE_STRING ) ) ';' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:551:1: ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' ) (lv_body_6= RULE_STRING ) ) ';' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:551:1: ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' ) (lv_body_6= RULE_STRING ) ) ';' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:551:2: ( ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' ) (lv_body_6= RULE_STRING ) ) ';'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:551:2: ( ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' ) (lv_body_6= RULE_STRING ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:551:3: ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' ) (lv_body_6= RULE_STRING )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:551:3: ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:551:4: ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:551:4: ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:551:5: ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:551:5: ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:551:6: ( 'native' | 'lexer' ) (lv_name_2= RULE_ID )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:551:6: ( 'native' | 'lexer' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==21) ) {
                alt13=1;
            }
            else if ( (LA13_0==22) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("551:6: ( 'native' | 'lexer' )", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:551:7: 'native'
                    {
                    match(input,21,FOLLOW_21_in_ruleLexerRule1210); 

                            createLeafNode(grammarAccess.prLexerRule().ele000000KeywordNative(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:556:6: 'lexer'
                    {
                    match(input,22,FOLLOW_22_in_ruleLexerRule1225); 

                            createLeafNode(grammarAccess.prLexerRule().ele000001KeywordLexer(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:560:2: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:562:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexerRule1247); 

            		createLeafNode(grammarAccess.prLexerRule().ele000010ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prLexerRule().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:579:3: ( 'returns' (lv_type_4= ruleTypeRef ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==23) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:579:4: 'returns' (lv_type_4= ruleTypeRef )
                    {
                    match(input,23,FOLLOW_23_in_ruleLexerRule1265); 

                            createLeafNode(grammarAccess.prLexerRule().ele00010KeywordReturns(), null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:583:1: (lv_type_4= ruleTypeRef )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:586:6: lv_type_4= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prLexerRule().ele000110ParserRuleCallTypeRef(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleLexerRule1299);
                    lv_type_4=ruleTypeRef();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prLexerRule().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "type", lv_type_4, "TypeRef", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }

            match(input,24,FOLLOW_24_in_ruleLexerRule1315); 

                    createLeafNode(grammarAccess.prLexerRule().ele001KeywordColon(), null); 
                

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:608:2: (lv_body_6= RULE_STRING )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:610:6: lv_body_6= RULE_STRING
            {
            lv_body_6=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLexerRule1337); 

            		createLeafNode(grammarAccess.prLexerRule().ele010ParserRuleCallSTRING(), "body"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prLexerRule().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "body", lv_body_6, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,25,FOLLOW_25_in_ruleLexerRule1354); 

                    createLeafNode(grammarAccess.prLexerRule().ele1KeywordSemicolon(), null); 
                

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
    // $ANTLR end ruleLexerRule


    // $ANTLR start entryRuleParserRule
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:640:1: entryRuleParserRule returns [EObject current=null] : iv_ruleParserRule= ruleParserRule EOF ;
    public final EObject entryRuleParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRule = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:640:52: (iv_ruleParserRule= ruleParserRule EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:641:2: iv_ruleParserRule= ruleParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleParserRule_in_entryRuleParserRule1389);
            iv_ruleParserRule=ruleParserRule();
            _fsp--;

             current =iv_ruleParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParserRule1399); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:648:1: ruleParserRule returns [EObject current=null] : ( ( ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' ) (lv_alternatives_10= ruleAlternatives ) ) ';' ) ;
    public final EObject ruleParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        Token lv_definesHiddenTokens_3=null;
        EObject lv_type_2 = null;

        EObject lv_alternatives_10 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:653:6: ( ( ( ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' ) (lv_alternatives_10= ruleAlternatives ) ) ';' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:654:1: ( ( ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' ) (lv_alternatives_10= ruleAlternatives ) ) ';' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:654:1: ( ( ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' ) (lv_alternatives_10= ruleAlternatives ) ) ';' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:654:2: ( ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' ) (lv_alternatives_10= ruleAlternatives ) ) ';'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:654:2: ( ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' ) (lv_alternatives_10= ruleAlternatives ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:654:3: ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' ) (lv_alternatives_10= ruleAlternatives )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:654:3: ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:654:4: ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:654:4: ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:654:5: ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:654:5: ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:654:6: (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:654:6: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:656:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1449); 

            		createLeafNode(grammarAccess.prParserRule().ele000000ParserRuleCallID(), "name"); 
            	

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

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:673:2: ( 'returns' (lv_type_2= ruleTypeRef ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==23) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:673:3: 'returns' (lv_type_2= ruleTypeRef )
                    {
                    match(input,23,FOLLOW_23_in_ruleParserRule1466); 

                            createLeafNode(grammarAccess.prParserRule().ele000010KeywordReturns(), null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:677:1: (lv_type_2= ruleTypeRef )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:680:6: lv_type_2= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prParserRule().ele0000110ParserRuleCallTypeRef(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleParserRule1500);
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


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:698:5: ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==13) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:698:6: ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')'
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:698:6: ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:698:7: ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )?
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:698:7: ( (lv_definesHiddenTokens_3= 'hidden' ) '(' )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:698:8: (lv_definesHiddenTokens_3= 'hidden' ) '('
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:698:8: (lv_definesHiddenTokens_3= 'hidden' )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:700:6: lv_definesHiddenTokens_3= 'hidden'
                    {
                    lv_definesHiddenTokens_3=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_ruleParserRule1531); 

                            createLeafNode(grammarAccess.prParserRule().ele00010000KeywordHidden(), "definesHiddenTokens"); 
                        

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

                    match(input,14,FOLLOW_14_in_ruleParserRule1553); 

                            createLeafNode(grammarAccess.prParserRule().ele0001001KeywordLeftParenthesis(), null); 
                        

                    }

                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:723:2: ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==RULE_ID) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:723:3: ( RULE_ID ) ( ',' ( RULE_ID ) )*
                            {
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:723:3: ( RULE_ID )
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:726:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.prParserRule().getRule().getType().getType());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1577); 

                            		createLeafNode(grammarAccess.prParserRule().ele00010100CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
                            	

                            }

                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:739:2: ( ',' ( RULE_ID ) )*
                            loop16:
                            do {
                                int alt16=2;
                                int LA16_0 = input.LA(1);

                                if ( (LA16_0==15) ) {
                                    alt16=1;
                                }


                                switch (alt16) {
                            	case 1 :
                            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:739:3: ',' ( RULE_ID )
                            	    {
                            	    match(input,15,FOLLOW_15_in_ruleParserRule1590); 

                            	            createLeafNode(grammarAccess.prParserRule().ele00010110KeywordComma(), null); 
                            	        
                            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:743:1: ( RULE_ID )
                            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:746:3: RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create(grammarAccess.prParserRule().getRule().getType().getType());
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1612); 

                            	    		createLeafNode(grammarAccess.prParserRule().ele000101110CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
                            	    	

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop16;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }

                    match(input,16,FOLLOW_16_in_ruleParserRule1629); 

                            createLeafNode(grammarAccess.prParserRule().ele00011KeywordRightParenthesis(), null); 
                        

                    }
                    break;

            }


            }

            match(input,24,FOLLOW_24_in_ruleParserRule1641); 

                    createLeafNode(grammarAccess.prParserRule().ele001KeywordColon(), null); 
                

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:767:2: (lv_alternatives_10= ruleAlternatives )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:770:6: lv_alternatives_10= ruleAlternatives
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prParserRule().ele010ParserRuleCallAlternatives(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParserRule1676);
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


            }

            match(input,25,FOLLOW_25_in_ruleParserRule1690); 

                    createLeafNode(grammarAccess.prParserRule().ele1KeywordSemicolon(), null); 
                

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:801:1: entryRuleTerminalRule returns [EObject current=null] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final EObject entryRuleTerminalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRule = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:801:54: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:802:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1725);
            iv_ruleTerminalRule=ruleTerminalRule();
            _fsp--;

             current =iv_ruleTerminalRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalRule1735); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:809:1: ruleTerminalRule returns [EObject current=null] : ( ( ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' ) (lv_alternatives_5= ruleTerminalAlternatives ) ) ';' ) ;
    public final EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token lv_terminal_0=null;
        Token lv_name_1=null;
        EObject lv_type_3 = null;

        EObject lv_alternatives_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:814:6: ( ( ( ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' ) (lv_alternatives_5= ruleTerminalAlternatives ) ) ';' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:815:1: ( ( ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' ) (lv_alternatives_5= ruleTerminalAlternatives ) ) ';' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:815:1: ( ( ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' ) (lv_alternatives_5= ruleTerminalAlternatives ) ) ';' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:815:2: ( ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' ) (lv_alternatives_5= ruleTerminalAlternatives ) ) ';'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:815:2: ( ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' ) (lv_alternatives_5= ruleTerminalAlternatives ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:815:3: ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' ) (lv_alternatives_5= ruleTerminalAlternatives )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:815:3: ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:815:4: ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:815:4: ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:815:5: ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:815:5: ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:815:6: (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:815:6: (lv_terminal_0= 'terminal' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:817:6: lv_terminal_0= 'terminal'
            {
            lv_terminal_0=(Token)input.LT(1);
            match(input,26,FOLLOW_26_in_ruleTerminalRule1785); 

                    createLeafNode(grammarAccess.prTerminalRule().ele000000KeywordTerminal(), "terminal"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prTerminalRule().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "terminal", true, "terminal", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:836:2: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:838:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTerminalRule1819); 

            		createLeafNode(grammarAccess.prTerminalRule().ele000010ParserRuleCallID(), "name"); 
            	

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


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:855:3: ( 'returns' (lv_type_3= ruleTypeRef ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==23) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:855:4: 'returns' (lv_type_3= ruleTypeRef )
                    {
                    match(input,23,FOLLOW_23_in_ruleTerminalRule1837); 

                            createLeafNode(grammarAccess.prTerminalRule().ele00010KeywordReturns(), null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:859:1: (lv_type_3= ruleTypeRef )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:862:6: lv_type_3= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prTerminalRule().ele000110ParserRuleCallTypeRef(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleTerminalRule1871);
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


            }

            match(input,24,FOLLOW_24_in_ruleTerminalRule1887); 

                    createLeafNode(grammarAccess.prTerminalRule().ele001KeywordColon(), null); 
                

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:884:2: (lv_alternatives_5= ruleTerminalAlternatives )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:887:6: lv_alternatives_5= ruleTerminalAlternatives
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prTerminalRule().ele010ParserRuleCallTerminalAlternatives(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule1922);
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


            }

            match(input,25,FOLLOW_25_in_ruleTerminalRule1936); 

                    createLeafNode(grammarAccess.prTerminalRule().ele1KeywordSemicolon(), null); 
                

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:918:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:918:49: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:919:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTypeRef().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef1971);
            iv_ruleTypeRef=ruleTypeRef();
            _fsp--;

             current =iv_ruleTypeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef1981); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:926:1: ruleTypeRef returns [EObject current=null] : ( ( ( RULE_ID ) '::' )? ( RULE_ID ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:931:6: ( ( ( ( RULE_ID ) '::' )? ( RULE_ID ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:932:1: ( ( ( RULE_ID ) '::' )? ( RULE_ID ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:932:1: ( ( ( RULE_ID ) '::' )? ( RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:932:2: ( ( RULE_ID ) '::' )? ( RULE_ID )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:932:2: ( ( RULE_ID ) '::' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==27) ) {
                    alt20=1;
                }
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:932:3: ( RULE_ID ) '::'
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:932:3: ( RULE_ID )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:935:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prTypeRef().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef2029); 

                    		createLeafNode(grammarAccess.prTypeRef().ele000CrossReferenceEStringAbstractMetamodelDeclaration(), "metamodel"); 
                    	

                    }

                    match(input,27,FOLLOW_27_in_ruleTypeRef2041); 

                            createLeafNode(grammarAccess.prTypeRef().ele01KeywordColonColon(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:952:3: ( RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:955:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prTypeRef().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef2065); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:977:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:977:54: (iv_ruleAlternatives= ruleAlternatives EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:978:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAlternatives().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAlternatives_in_entryRuleAlternatives2103);
            iv_ruleAlternatives=ruleAlternatives();
            _fsp--;

             current =iv_ruleAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternatives2113); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:985:1: ruleAlternatives returns [EObject current=null] : (this_Group_0= ruleGroup ( ( () '|' ) (lv_groups_3= ruleGroup ) )* ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_Group_0 = null;

        EObject lv_groups_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:990:6: ( (this_Group_0= ruleGroup ( ( () '|' ) (lv_groups_3= ruleGroup ) )* ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:991:1: (this_Group_0= ruleGroup ( ( () '|' ) (lv_groups_3= ruleGroup ) )* )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:991:1: (this_Group_0= ruleGroup ( ( () '|' ) (lv_groups_3= ruleGroup ) )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:992:5: this_Group_0= ruleGroup ( ( () '|' ) (lv_groups_3= ruleGroup ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.prAlternatives().ele0ParserRuleCallGroup(), currentNode); 
                
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives2160);
            this_Group_0=ruleGroup();
            _fsp--;

             
                    current = this_Group_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1000:1: ( ( () '|' ) (lv_groups_3= ruleGroup ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==28) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1000:2: ( () '|' ) (lv_groups_3= ruleGroup )
            	    {
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1000:2: ( () '|' )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1000:3: () '|'
            	    {
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1000:3: ()
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1001:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.prAlternatives().ele100ActionAlternativesgroups().getTypeName().getType());
            	            try {
            	            	factory.add(temp, "groups", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.prAlternatives().ele100ActionAlternativesgroups(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    match(input,28,FOLLOW_28_in_ruleAlternatives2179); 

            	            createLeafNode(grammarAccess.prAlternatives().ele101KeywordVerticalLine(), null); 
            	        

            	    }

            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1020:2: (lv_groups_3= ruleGroup )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1023:6: lv_groups_3= ruleGroup
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prAlternatives().ele110ParserRuleCallGroup(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives2214);
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
            	    break loop21;
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
    // $ANTLR end ruleAlternatives


    // $ANTLR start entryRuleTerminalAlternatives
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1050:1: entryRuleTerminalAlternatives returns [EObject current=null] : iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF ;
    public final EObject entryRuleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalAlternatives = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1050:62: (iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1051:2: iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalAlternatives().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives2255);
            iv_ruleTerminalAlternatives=ruleTerminalAlternatives();
            _fsp--;

             current =iv_ruleTerminalAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalAlternatives2265); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1058:1: ruleTerminalAlternatives returns [EObject current=null] : (this_TerminalGroup_0= ruleTerminalGroup ( ( () '|' ) (lv_groups_3= ruleTerminalGroup ) )* ) ;
    public final EObject ruleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalGroup_0 = null;

        EObject lv_groups_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1063:6: ( (this_TerminalGroup_0= ruleTerminalGroup ( ( () '|' ) (lv_groups_3= ruleTerminalGroup ) )* ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1064:1: (this_TerminalGroup_0= ruleTerminalGroup ( ( () '|' ) (lv_groups_3= ruleTerminalGroup ) )* )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1064:1: (this_TerminalGroup_0= ruleTerminalGroup ( ( () '|' ) (lv_groups_3= ruleTerminalGroup ) )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1065:5: this_TerminalGroup_0= ruleTerminalGroup ( ( () '|' ) (lv_groups_3= ruleTerminalGroup ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.prTerminalAlternatives().ele0ParserRuleCallTerminalGroup(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2312);
            this_TerminalGroup_0=ruleTerminalGroup();
            _fsp--;

             
                    current = this_TerminalGroup_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1073:1: ( ( () '|' ) (lv_groups_3= ruleTerminalGroup ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==28) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1073:2: ( () '|' ) (lv_groups_3= ruleTerminalGroup )
            	    {
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1073:2: ( () '|' )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1073:3: () '|'
            	    {
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1073:3: ()
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1074:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.prTerminalAlternatives().ele100ActionAlternativesgroups().getTypeName().getType());
            	            try {
            	            	factory.add(temp, "groups", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.prTerminalAlternatives().ele100ActionAlternativesgroups(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    match(input,28,FOLLOW_28_in_ruleTerminalAlternatives2331); 

            	            createLeafNode(grammarAccess.prTerminalAlternatives().ele101KeywordVerticalLine(), null); 
            	        

            	    }

            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1093:2: (lv_groups_3= ruleTerminalGroup )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1096:6: lv_groups_3= ruleTerminalGroup
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prTerminalAlternatives().ele110ParserRuleCallTerminalGroup(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2366);
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
            	    break loop22;
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
    // $ANTLR end ruleTerminalAlternatives


    // $ANTLR start entryRuleGroup
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1123:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1123:47: (iv_ruleGroup= ruleGroup EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1124:2: iv_ruleGroup= ruleGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.prGroup().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleGroup_in_entryRuleGroup2407);
            iv_ruleGroup=ruleGroup();
            _fsp--;

             current =iv_ruleGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroup2417); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1131:1: ruleGroup returns [EObject current=null] : (this_AbstractToken_0= ruleAbstractToken ( () (lv_abstractTokens_2= ruleAbstractToken ) )* ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken_0 = null;

        EObject lv_abstractTokens_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1136:6: ( (this_AbstractToken_0= ruleAbstractToken ( () (lv_abstractTokens_2= ruleAbstractToken ) )* ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1137:1: (this_AbstractToken_0= ruleAbstractToken ( () (lv_abstractTokens_2= ruleAbstractToken ) )* )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1137:1: (this_AbstractToken_0= ruleAbstractToken ( () (lv_abstractTokens_2= ruleAbstractToken ) )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1138:5: this_AbstractToken_0= ruleAbstractToken ( () (lv_abstractTokens_2= ruleAbstractToken ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.prGroup().ele0ParserRuleCallAbstractToken(), currentNode); 
                
            pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup2464);
            this_AbstractToken_0=ruleAbstractToken();
            _fsp--;

             
                    current = this_AbstractToken_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1146:1: ( () (lv_abstractTokens_2= ruleAbstractToken ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=RULE_ID && LA23_0<=RULE_STRING)||LA23_0==14||LA23_0==35||LA23_0==41) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1146:2: () (lv_abstractTokens_2= ruleAbstractToken )
            	    {
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1146:2: ()
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1147:5: 
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

            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1162:2: (lv_abstractTokens_2= ruleAbstractToken )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1165:6: lv_abstractTokens_2= ruleAbstractToken
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prGroup().ele110ParserRuleCallAbstractToken(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup2507);
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


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // $ANTLR end ruleGroup


    // $ANTLR start entryRuleTerminalGroup
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1192:1: entryRuleTerminalGroup returns [EObject current=null] : iv_ruleTerminalGroup= ruleTerminalGroup EOF ;
    public final EObject entryRuleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalGroup = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1192:55: (iv_ruleTerminalGroup= ruleTerminalGroup EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1193:2: iv_ruleTerminalGroup= ruleTerminalGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalGroup().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup2548);
            iv_ruleTerminalGroup=ruleTerminalGroup();
            _fsp--;

             current =iv_ruleTerminalGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalGroup2558); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1200:1: ruleTerminalGroup returns [EObject current=null] : (this_TerminalToken_0= ruleTerminalToken ( () (lv_abstractTokens_2= ruleTerminalToken ) )* ) ;
    public final EObject ruleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalToken_0 = null;

        EObject lv_abstractTokens_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1205:6: ( (this_TerminalToken_0= ruleTerminalToken ( () (lv_abstractTokens_2= ruleTerminalToken ) )* ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1206:1: (this_TerminalToken_0= ruleTerminalToken ( () (lv_abstractTokens_2= ruleTerminalToken ) )* )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1206:1: (this_TerminalToken_0= ruleTerminalToken ( () (lv_abstractTokens_2= ruleTerminalToken ) )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1207:5: this_TerminalToken_0= ruleTerminalToken ( () (lv_abstractTokens_2= ruleTerminalToken ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.prTerminalGroup().ele0ParserRuleCallTerminalToken(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2605);
            this_TerminalToken_0=ruleTerminalToken();
            _fsp--;

             
                    current = this_TerminalToken_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1215:1: ( () (lv_abstractTokens_2= ruleTerminalToken ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=RULE_ID && LA24_0<=RULE_STRING)||LA24_0==14||LA24_0==17||(LA24_0>=38 && LA24_0<=39)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1215:2: () (lv_abstractTokens_2= ruleTerminalToken )
            	    {
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1215:2: ()
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1216:5: 
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

            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1231:2: (lv_abstractTokens_2= ruleTerminalToken )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1234:6: lv_abstractTokens_2= ruleTerminalToken
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prTerminalGroup().ele110ParserRuleCallTerminalToken(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2648);
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


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // $ANTLR end ruleTerminalGroup


    // $ANTLR start entryRuleAbstractToken
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1261:1: entryRuleAbstractToken returns [EObject current=null] : iv_ruleAbstractToken= ruleAbstractToken EOF ;
    public final EObject entryRuleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractToken = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1261:55: (iv_ruleAbstractToken= ruleAbstractToken EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1262:2: iv_ruleAbstractToken= ruleAbstractToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken2689);
            iv_ruleAbstractToken=ruleAbstractToken();
            _fsp--;

             current =iv_ruleAbstractToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractToken2699); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1269:1: ruleAbstractToken returns [EObject current=null] : ( ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal ) (lv_cardinality_3= ( ( '?' | '*' ) | '+' ) )? ) ;
    public final EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_3=null;
        EObject this_Assignment_0 = null;

        EObject this_Action_1 = null;

        EObject this_AbstractTerminal_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1274:6: ( ( ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal ) (lv_cardinality_3= ( ( '?' | '*' ) | '+' ) )? ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1275:1: ( ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal ) (lv_cardinality_3= ( ( '?' | '*' ) | '+' ) )? )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1275:1: ( ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal ) (lv_cardinality_3= ( ( '?' | '*' ) | '+' ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1275:2: ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal ) (lv_cardinality_3= ( ( '?' | '*' ) | '+' ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1275:2: ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal )
            int alt26=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA26_1 = input.LA(2);

                if ( ((LA26_1>=32 && LA26_1<=34)) ) {
                    alt26=1;
                }
                else if ( (LA26_1==EOF||(LA26_1>=RULE_ID && LA26_1<=RULE_STRING)||LA26_1==14||LA26_1==16||LA26_1==25||(LA26_1>=28 && LA26_1<=31)||LA26_1==35||LA26_1==41) ) {
                    alt26=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1275:2: ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal )", 26, 1, input);

                    throw nvae;
                }
                }
                break;
            case 35:
                {
                alt26=1;
                }
                break;
            case RULE_STRING:
            case 14:
            case 41:
                {
                alt26=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1275:2: ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal )", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1275:3: (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1275:3: (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction )
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==RULE_ID) ) {
                        alt25=1;
                    }
                    else if ( (LA25_0==35) ) {
                        alt25=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1275:3: (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction )", 25, 0, input);

                        throw nvae;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1276:5: this_Assignment_0= ruleAssignment
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prAbstractToken().ele000ParserRuleCallAssignment(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleAssignment_in_ruleAbstractToken2748);
                            this_Assignment_0=ruleAssignment();
                            _fsp--;

                             
                                    current = this_Assignment_0; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1286:5: this_Action_1= ruleAction
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prAbstractToken().ele001ParserRuleCallAction(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleAction_in_ruleAbstractToken2775);
                            this_Action_1=ruleAction();
                            _fsp--;

                             
                                    current = this_Action_1; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1296:5: this_AbstractTerminal_2= ruleAbstractTerminal
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractToken().ele01ParserRuleCallAbstractTerminal(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken2803);
                    this_AbstractTerminal_2=ruleAbstractTerminal();
                    _fsp--;

                     
                            current = this_AbstractTerminal_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1304:2: (lv_cardinality_3= ( ( '?' | '*' ) | '+' ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=29 && LA29_0<=31)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1306:6: lv_cardinality_3= ( ( '?' | '*' ) | '+' )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1306:23: ( ( '?' | '*' ) | '+' )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( ((LA28_0>=29 && LA28_0<=30)) ) {
                        alt28=1;
                    }
                    else if ( (LA28_0==31) ) {
                        alt28=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1306:23: ( ( '?' | '*' ) | '+' )", 28, 0, input);

                        throw nvae;
                    }
                    switch (alt28) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1306:24: ( '?' | '*' )
                            {
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1306:24: ( '?' | '*' )
                            int alt27=2;
                            int LA27_0 = input.LA(1);

                            if ( (LA27_0==29) ) {
                                alt27=1;
                            }
                            else if ( (LA27_0==30) ) {
                                alt27=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1306:24: ( '?' | '*' )", 27, 0, input);

                                throw nvae;
                            }
                            switch (alt27) {
                                case 1 :
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1306:25: '?'
                                    {
                                    match(input,29,FOLLOW_29_in_ruleAbstractToken2826); 

                                            createLeafNode(grammarAccess.prAbstractToken().ele1000KeywordQuestionMark(), "cardinality"); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1312:6: '*'
                                    {
                                    match(input,30,FOLLOW_30_in_ruleAbstractToken2842); 

                                            createLeafNode(grammarAccess.prAbstractToken().ele1001KeywordAsterisk(), "cardinality"); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1319:6: '+'
                            {
                            match(input,31,FOLLOW_31_in_ruleAbstractToken2860); 

                                    createLeafNode(grammarAccess.prAbstractToken().ele101KeywordPlusSign(), "cardinality"); 
                                

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1348:1: entryRuleTerminalToken returns [EObject current=null] : iv_ruleTerminalToken= ruleTerminalToken EOF ;
    public final EObject entryRuleTerminalToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalToken = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1348:55: (iv_ruleTerminalToken= ruleTerminalToken EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1349:2: iv_ruleTerminalToken= ruleTerminalToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken2911);
            iv_ruleTerminalToken=ruleTerminalToken();
            _fsp--;

             current =iv_ruleTerminalToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalToken2921); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1356:1: ruleTerminalToken returns [EObject current=null] : (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( ( '?' | '*' ) | '+' ) )? ) ;
    public final EObject ruleTerminalToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_1=null;
        EObject this_TerminalTokenElement_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1361:6: ( (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( ( '?' | '*' ) | '+' ) )? ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1362:1: (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( ( '?' | '*' ) | '+' ) )? )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1362:1: (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( ( '?' | '*' ) | '+' ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1363:5: this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( ( '?' | '*' ) | '+' ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.prTerminalToken().ele0ParserRuleCallTerminalTokenElement(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken2968);
            this_TerminalTokenElement_0=ruleTerminalTokenElement();
            _fsp--;

             
                    current = this_TerminalTokenElement_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1371:1: (lv_cardinality_1= ( ( '?' | '*' ) | '+' ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=29 && LA32_0<=31)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1373:6: lv_cardinality_1= ( ( '?' | '*' ) | '+' )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1373:23: ( ( '?' | '*' ) | '+' )
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( ((LA31_0>=29 && LA31_0<=30)) ) {
                        alt31=1;
                    }
                    else if ( (LA31_0==31) ) {
                        alt31=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1373:23: ( ( '?' | '*' ) | '+' )", 31, 0, input);

                        throw nvae;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1373:24: ( '?' | '*' )
                            {
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1373:24: ( '?' | '*' )
                            int alt30=2;
                            int LA30_0 = input.LA(1);

                            if ( (LA30_0==29) ) {
                                alt30=1;
                            }
                            else if ( (LA30_0==30) ) {
                                alt30=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1373:24: ( '?' | '*' )", 30, 0, input);

                                throw nvae;
                            }
                            switch (alt30) {
                                case 1 :
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1373:25: '?'
                                    {
                                    match(input,29,FOLLOW_29_in_ruleTerminalToken2990); 

                                            createLeafNode(grammarAccess.prTerminalToken().ele1000KeywordQuestionMark(), "cardinality"); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1379:6: '*'
                                    {
                                    match(input,30,FOLLOW_30_in_ruleTerminalToken3006); 

                                            createLeafNode(grammarAccess.prTerminalToken().ele1001KeywordAsterisk(), "cardinality"); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1386:6: '+'
                            {
                            match(input,31,FOLLOW_31_in_ruleTerminalToken3024); 

                                    createLeafNode(grammarAccess.prTerminalToken().ele101KeywordPlusSign(), "cardinality"); 
                                

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1415:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1415:52: (iv_ruleAssignment= ruleAssignment EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1416:2: iv_ruleAssignment= ruleAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAssignment().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment3075);
            iv_ruleAssignment=ruleAssignment();
            _fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment3085); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1423:1: ruleAssignment returns [EObject current=null] : ( ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal_2= ruleAbstractTerminal ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0=null;
        Token lv_operator_1=null;
        EObject lv_terminal_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1428:6: ( ( ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal_2= ruleAbstractTerminal ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1429:1: ( ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal_2= ruleAbstractTerminal ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1429:1: ( ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal_2= ruleAbstractTerminal ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1429:2: ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal_2= ruleAbstractTerminal )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1429:2: ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1429:3: (lv_feature_0= RULE_ID ) (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1429:3: (lv_feature_0= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1431:6: lv_feature_0= RULE_ID
            {
            lv_feature_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignment3132); 

            		createLeafNode(grammarAccess.prAssignment().ele000ParserRuleCallID(), "feature"); 
            	

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

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1448:2: (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1450:6: lv_operator_1= ( ( '+=' | '=' ) | '?=' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1450:20: ( ( '+=' | '=' ) | '?=' )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=32 && LA34_0<=33)) ) {
                alt34=1;
            }
            else if ( (LA34_0==34) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1450:20: ( ( '+=' | '=' ) | '?=' )", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1450:21: ( '+=' | '=' )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1450:21: ( '+=' | '=' )
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==32) ) {
                        alt33=1;
                    }
                    else if ( (LA33_0==33) ) {
                        alt33=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1450:21: ( '+=' | '=' )", 33, 0, input);

                        throw nvae;
                    }
                    switch (alt33) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1450:22: '+='
                            {
                            match(input,32,FOLLOW_32_in_ruleAssignment3162); 

                                    createLeafNode(grammarAccess.prAssignment().ele01000KeywordPlusSignEqualsSign(), "operator"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1456:6: '='
                            {
                            match(input,33,FOLLOW_33_in_ruleAssignment3178); 

                                    createLeafNode(grammarAccess.prAssignment().ele01001KeywordEqualsSign(), "operator"); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1463:6: '?='
                    {
                    match(input,34,FOLLOW_34_in_ruleAssignment3196); 

                            createLeafNode(grammarAccess.prAssignment().ele0101KeywordQuestionMarkEqualsSign(), "operator"); 
                        

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


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1483:3: (lv_terminal_2= ruleAbstractTerminal )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1486:6: lv_terminal_2= ruleAbstractTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prAssignment().ele10ParserRuleCallAbstractTerminal(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAssignment3246);
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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1513:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1513:48: (iv_ruleAction= ruleAction EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1514:2: iv_ruleAction= ruleAction EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAction().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAction_in_entryRuleAction3285);
            iv_ruleAction=ruleAction();
            _fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAction3295); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1521:1: ruleAction returns [EObject current=null] : ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) ) 'current' ) '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_feature_5=null;
        Token lv_operator_6=null;
        EObject lv_typeName_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1526:6: ( ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) ) 'current' ) '}' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1527:1: ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) ) 'current' ) '}' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1527:1: ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) ) 'current' ) '}' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1527:2: ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) ) 'current' ) '}'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1527:2: ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) ) 'current' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1527:3: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) ) 'current'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1527:3: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1527:4: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1527:4: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1527:5: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1527:5: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1527:6: ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1527:6: ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1527:7: ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1527:7: ( '{' ( 'current' '=' )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1527:8: '{' ( 'current' '=' )?
            {
            match(input,35,FOLLOW_35_in_ruleAction3335); 

                    createLeafNode(grammarAccess.prAction().ele0000000KeywordLeftCurlyBracket(), null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1531:1: ( 'current' '=' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==36) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1531:2: 'current' '='
                    {
                    match(input,36,FOLLOW_36_in_ruleAction3345); 

                            createLeafNode(grammarAccess.prAction().ele00000010KeywordCurrent(), null); 
                        
                    match(input,33,FOLLOW_33_in_ruleAction3354); 

                            createLeafNode(grammarAccess.prAction().ele00000011KeywordEqualsSign(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1539:4: (lv_typeName_3= ruleTypeRef )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1542:6: lv_typeName_3= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prAction().ele0000010ParserRuleCallTypeRef(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAction3391);
            lv_typeName_3=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prAction().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "typeName", lv_typeName_3, "TypeRef", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleAction3405); 

                    createLeafNode(grammarAccess.prAction().ele00001KeywordFullStop(), null); 
                

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1564:2: (lv_feature_5= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1566:6: lv_feature_5= RULE_ID
            {
            lv_feature_5=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAction3427); 

            		createLeafNode(grammarAccess.prAction().ele00010ParserRuleCallID(), "feature"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prAction().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "feature", lv_feature_5, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1583:3: (lv_operator_6= ( '=' | '+=' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1585:6: lv_operator_6= ( '=' | '+=' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1585:20: ( '=' | '+=' )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==33) ) {
                alt36=1;
            }
            else if ( (LA36_0==32) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1585:20: ( '=' | '+=' )", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1585:21: '='
                    {
                    match(input,33,FOLLOW_33_in_ruleAction3457); 

                            createLeafNode(grammarAccess.prAction().ele00100KeywordEqualsSign(), "operator"); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1591:6: '+='
                    {
                    match(input,32,FOLLOW_32_in_ruleAction3473); 

                            createLeafNode(grammarAccess.prAction().ele00101KeywordPlusSignEqualsSign(), "operator"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prAction().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "operator", /* lv_operator_6 */ input.LT(-1), null, lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,36,FOLLOW_36_in_ruleAction3498); 

                    createLeafNode(grammarAccess.prAction().ele01KeywordCurrent(), null); 
                

            }

            match(input,37,FOLLOW_37_in_ruleAction3508); 

                    createLeafNode(grammarAccess.prAction().ele1KeywordRightCurlyBracket(), null); 
                

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1628:1: entryRuleAbstractTerminal returns [EObject current=null] : iv_ruleAbstractTerminal= ruleAbstractTerminal EOF ;
    public final EObject entryRuleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTerminal = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1628:58: (iv_ruleAbstractTerminal= ruleAbstractTerminal EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1629:2: iv_ruleAbstractTerminal= ruleAbstractTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractTerminal().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal3543);
            iv_ruleAbstractTerminal=ruleAbstractTerminal();
            _fsp--;

             current =iv_ruleAbstractTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractTerminal3553); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1636:1: ruleAbstractTerminal returns [EObject current=null] : ( ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement ) | this_CrossReference_3= ruleCrossReference ) ;
    public final EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedElement_2 = null;

        EObject this_CrossReference_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1641:6: ( ( ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement ) | this_CrossReference_3= ruleCrossReference ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1642:1: ( ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement ) | this_CrossReference_3= ruleCrossReference )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1642:1: ( ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement ) | this_CrossReference_3= ruleCrossReference )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=RULE_ID && LA39_0<=RULE_STRING)||LA39_0==14) ) {
                alt39=1;
            }
            else if ( (LA39_0==41) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1642:1: ( ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement ) | this_CrossReference_3= ruleCrossReference )", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1642:2: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1642:2: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement )
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( ((LA38_0>=RULE_ID && LA38_0<=RULE_STRING)) ) {
                        alt38=1;
                    }
                    else if ( (LA38_0==14) ) {
                        alt38=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1642:2: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement )", 38, 0, input);

                        throw nvae;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1642:3: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )
                            {
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1642:3: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )
                            int alt37=2;
                            int LA37_0 = input.LA(1);

                            if ( (LA37_0==RULE_STRING) ) {
                                alt37=1;
                            }
                            else if ( (LA37_0==RULE_ID) ) {
                                alt37=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1642:3: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )", 37, 0, input);

                                throw nvae;
                            }
                            switch (alt37) {
                                case 1 :
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1643:5: this_Keyword_0= ruleKeyword
                                    {
                                     
                                            currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele000ParserRuleCallKeyword(), currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleKeyword_in_ruleAbstractTerminal3602);
                                    this_Keyword_0=ruleKeyword();
                                    _fsp--;

                                     
                                            current = this_Keyword_0; 
                                            currentNode = currentNode.getParent();
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1653:5: this_RuleCall_1= ruleRuleCall
                                    {
                                     
                                            currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele001ParserRuleCallRuleCall(), currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleRuleCall_in_ruleAbstractTerminal3629);
                                    this_RuleCall_1=ruleRuleCall();
                                    _fsp--;

                                     
                                            current = this_RuleCall_1; 
                                            currentNode = currentNode.getParent();
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1663:5: this_ParenthesizedElement_2= ruleParenthesizedElement
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele01ParserRuleCallParenthesizedElement(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal3657);
                            this_ParenthesizedElement_2=ruleParenthesizedElement();
                            _fsp--;

                             
                                    current = this_ParenthesizedElement_2; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1673:5: this_CrossReference_3= ruleCrossReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele1ParserRuleCallCrossReference(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCrossReference_in_ruleAbstractTerminal3685);
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
    // $ANTLR end ruleAbstractTerminal


    // $ANTLR start entryRuleTerminalTokenElement
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1690:1: entryRuleTerminalTokenElement returns [EObject current=null] : iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF ;
    public final EObject entryRuleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalTokenElement = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1690:62: (iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1691:2: iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalTokenElement().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement3719);
            iv_ruleTerminalTokenElement=ruleTerminalTokenElement();
            _fsp--;

             current =iv_ruleTerminalTokenElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalTokenElement3729); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1698:1: ruleTerminalTokenElement returns [EObject current=null] : ( ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken ) | this_Wildcard_4= ruleWildcard ) ;
    public final EObject ruleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject this_CharacterRange_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedTerminalElement_2 = null;

        EObject this_AbstractNegatedToken_3 = null;

        EObject this_Wildcard_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1703:6: ( ( ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken ) | this_Wildcard_4= ruleWildcard ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1704:1: ( ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken ) | this_Wildcard_4= ruleWildcard )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1704:1: ( ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken ) | this_Wildcard_4= ruleWildcard )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=RULE_ID && LA43_0<=RULE_STRING)||LA43_0==14||(LA43_0>=38 && LA43_0<=39)) ) {
                alt43=1;
            }
            else if ( (LA43_0==17) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1704:1: ( ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken ) | this_Wildcard_4= ruleWildcard )", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1704:2: ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1704:2: ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken )
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( ((LA42_0>=RULE_ID && LA42_0<=RULE_STRING)||LA42_0==14) ) {
                        alt42=1;
                    }
                    else if ( ((LA42_0>=38 && LA42_0<=39)) ) {
                        alt42=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1704:2: ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken )", 42, 0, input);

                        throw nvae;
                    }
                    switch (alt42) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1704:3: ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement )
                            {
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1704:3: ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement )
                            int alt41=2;
                            int LA41_0 = input.LA(1);

                            if ( ((LA41_0>=RULE_ID && LA41_0<=RULE_STRING)) ) {
                                alt41=1;
                            }
                            else if ( (LA41_0==14) ) {
                                alt41=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1704:3: ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement )", 41, 0, input);

                                throw nvae;
                            }
                            switch (alt41) {
                                case 1 :
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1704:4: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall )
                                    {
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1704:4: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall )
                                    int alt40=2;
                                    int LA40_0 = input.LA(1);

                                    if ( (LA40_0==RULE_STRING) ) {
                                        alt40=1;
                                    }
                                    else if ( (LA40_0==RULE_ID) ) {
                                        alt40=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("1704:4: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall )", 40, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt40) {
                                        case 1 :
                                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1705:5: this_CharacterRange_0= ruleCharacterRange
                                            {
                                             
                                                    currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele0000ParserRuleCallCharacterRange(), currentNode); 
                                                
                                            pushFollow(FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement3779);
                                            this_CharacterRange_0=ruleCharacterRange();
                                            _fsp--;

                                             
                                                    current = this_CharacterRange_0; 
                                                    currentNode = currentNode.getParent();
                                                

                                            }
                                            break;
                                        case 2 :
                                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1715:5: this_RuleCall_1= ruleRuleCall
                                            {
                                             
                                                    currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele0001ParserRuleCallRuleCall(), currentNode); 
                                                
                                            pushFollow(FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement3806);
                                            this_RuleCall_1=ruleRuleCall();
                                            _fsp--;

                                             
                                                    current = this_RuleCall_1; 
                                                    currentNode = currentNode.getParent();
                                                

                                            }
                                            break;

                                    }


                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1725:5: this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement
                                    {
                                     
                                            currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele001ParserRuleCallParenthesizedTerminalElement(), currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement3834);
                                    this_ParenthesizedTerminalElement_2=ruleParenthesizedTerminalElement();
                                    _fsp--;

                                     
                                            current = this_ParenthesizedTerminalElement_2; 
                                            currentNode = currentNode.getParent();
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1735:5: this_AbstractNegatedToken_3= ruleAbstractNegatedToken
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele01ParserRuleCallAbstractNegatedToken(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement3862);
                            this_AbstractNegatedToken_3=ruleAbstractNegatedToken();
                            _fsp--;

                             
                                    current = this_AbstractNegatedToken_3; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1745:5: this_Wildcard_4= ruleWildcard
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele1ParserRuleCallWildcard(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleWildcard_in_ruleTerminalTokenElement3890);
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


    // $ANTLR start entryRuleAbstractNegatedToken
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1762:1: entryRuleAbstractNegatedToken returns [EObject current=null] : iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF ;
    public final EObject entryRuleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractNegatedToken = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1762:62: (iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1763:2: iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractNegatedToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken3924);
            iv_ruleAbstractNegatedToken=ruleAbstractNegatedToken();
            _fsp--;

             current =iv_ruleAbstractNegatedToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractNegatedToken3934); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1770:1: ruleAbstractNegatedToken returns [EObject current=null] : (this_NegatedToken_0= ruleNegatedToken | this_UpToToken_1= ruleUpToToken ) ;
    public final EObject ruleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject this_NegatedToken_0 = null;

        EObject this_UpToToken_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1775:6: ( (this_NegatedToken_0= ruleNegatedToken | this_UpToToken_1= ruleUpToToken ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1776:1: (this_NegatedToken_0= ruleNegatedToken | this_UpToToken_1= ruleUpToToken )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1776:1: (this_NegatedToken_0= ruleNegatedToken | this_UpToToken_1= ruleUpToToken )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==38) ) {
                alt44=1;
            }
            else if ( (LA44_0==39) ) {
                alt44=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1776:1: (this_NegatedToken_0= ruleNegatedToken | this_UpToToken_1= ruleUpToToken )", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1777:5: this_NegatedToken_0= ruleNegatedToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractNegatedToken().ele0ParserRuleCallNegatedToken(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken3981);
                    this_NegatedToken_0=ruleNegatedToken();
                    _fsp--;

                     
                            current = this_NegatedToken_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1787:5: this_UpToToken_1= ruleUpToToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractNegatedToken().ele1ParserRuleCallUpToToken(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUpToToken_in_ruleAbstractNegatedToken4008);
                    this_UpToToken_1=ruleUpToToken();
                    _fsp--;

                     
                            current = this_UpToToken_1; 
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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1804:1: entryRuleNegatedToken returns [EObject current=null] : iv_ruleNegatedToken= ruleNegatedToken EOF ;
    public final EObject entryRuleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegatedToken = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1804:54: (iv_ruleNegatedToken= ruleNegatedToken EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1805:2: iv_ruleNegatedToken= ruleNegatedToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prNegatedToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken4042);
            iv_ruleNegatedToken=ruleNegatedToken();
            _fsp--;

             current =iv_ruleNegatedToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegatedToken4052); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1812:1: ruleNegatedToken returns [EObject current=null] : ( '!' (lv_terminal_1= ruleTerminalTokenElement ) ) ;
    public final EObject ruleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1817:6: ( ( '!' (lv_terminal_1= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1818:1: ( '!' (lv_terminal_1= ruleTerminalTokenElement ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1818:1: ( '!' (lv_terminal_1= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1818:2: '!' (lv_terminal_1= ruleTerminalTokenElement )
            {
            match(input,38,FOLLOW_38_in_ruleNegatedToken4086); 

                    createLeafNode(grammarAccess.prNegatedToken().ele0KeywordExclamationMark(), null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1822:1: (lv_terminal_1= ruleTerminalTokenElement )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1825:6: lv_terminal_1= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prNegatedToken().ele10ParserRuleCallTerminalTokenElement(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken4120);
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


    // $ANTLR start entryRuleUpToToken
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1852:1: entryRuleUpToToken returns [EObject current=null] : iv_ruleUpToToken= ruleUpToToken EOF ;
    public final EObject entryRuleUpToToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpToToken = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1852:51: (iv_ruleUpToToken= ruleUpToToken EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1853:2: iv_ruleUpToToken= ruleUpToToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prUpToToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleUpToToken_in_entryRuleUpToToken4159);
            iv_ruleUpToToken=ruleUpToToken();
            _fsp--;

             current =iv_ruleUpToToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUpToToken4169); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleUpToToken


    // $ANTLR start ruleUpToToken
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1860:1: ruleUpToToken returns [EObject current=null] : ( '->' (lv_terminal_1= ruleTerminalTokenElement ) ) ;
    public final EObject ruleUpToToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1865:6: ( ( '->' (lv_terminal_1= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1866:1: ( '->' (lv_terminal_1= ruleTerminalTokenElement ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1866:1: ( '->' (lv_terminal_1= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1866:2: '->' (lv_terminal_1= ruleTerminalTokenElement )
            {
            match(input,39,FOLLOW_39_in_ruleUpToToken4203); 

                    createLeafNode(grammarAccess.prUpToToken().ele0KeywordHyphenMinusGreaterThanSign(), null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1870:1: (lv_terminal_1= ruleTerminalTokenElement )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1873:6: lv_terminal_1= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prUpToToken().ele10ParserRuleCallTerminalTokenElement(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleUpToToken4237);
            lv_terminal_1=ruleTerminalTokenElement();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prUpToToken().getRule().getType().getType());
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
    // $ANTLR end ruleUpToToken


    // $ANTLR start entryRuleWildcard
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1900:1: entryRuleWildcard returns [EObject current=null] : iv_ruleWildcard= ruleWildcard EOF ;
    public final EObject entryRuleWildcard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcard = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1900:50: (iv_ruleWildcard= ruleWildcard EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1901:2: iv_ruleWildcard= ruleWildcard EOF
            {
             currentNode = createCompositeNode(grammarAccess.prWildcard().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleWildcard_in_entryRuleWildcard4276);
            iv_ruleWildcard=ruleWildcard();
            _fsp--;

             current =iv_ruleWildcard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWildcard4286); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1908:1: ruleWildcard returns [EObject current=null] : (lv_isWildcard_0= '.' ) ;
    public final EObject ruleWildcard() throws RecognitionException {
        EObject current = null;

        Token lv_isWildcard_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1913:6: ( (lv_isWildcard_0= '.' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1914:1: (lv_isWildcard_0= '.' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1914:1: (lv_isWildcard_0= '.' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1916:6: lv_isWildcard_0= '.'
            {
            lv_isWildcard_0=(Token)input.LT(1);
            match(input,17,FOLLOW_17_in_ruleWildcard4331); 

                    createLeafNode(grammarAccess.prWildcard().ele0KeywordFullStop(), "isWildcard"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prWildcard().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "isWildcard", true, ".", lastConsumedNode);
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
    // $ANTLR end ruleWildcard


    // $ANTLR start entryRuleCharacterRange
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1944:1: entryRuleCharacterRange returns [EObject current=null] : iv_ruleCharacterRange= ruleCharacterRange EOF ;
    public final EObject entryRuleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterRange = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1944:56: (iv_ruleCharacterRange= ruleCharacterRange EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1945:2: iv_ruleCharacterRange= ruleCharacterRange EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCharacterRange().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange4378);
            iv_ruleCharacterRange=ruleCharacterRange();
            _fsp--;

             current =iv_ruleCharacterRange; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCharacterRange4388); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1952:1: ruleCharacterRange returns [EObject current=null] : (this_Keyword_0= ruleKeyword ( ( () '..' ) (lv_right_3= ruleKeyword ) )? ) ;
    public final EObject ruleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject lv_right_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1957:6: ( (this_Keyword_0= ruleKeyword ( ( () '..' ) (lv_right_3= ruleKeyword ) )? ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1958:1: (this_Keyword_0= ruleKeyword ( ( () '..' ) (lv_right_3= ruleKeyword ) )? )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1958:1: (this_Keyword_0= ruleKeyword ( ( () '..' ) (lv_right_3= ruleKeyword ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1959:5: this_Keyword_0= ruleKeyword ( ( () '..' ) (lv_right_3= ruleKeyword ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.prCharacterRange().ele0ParserRuleCallKeyword(), currentNode); 
                
            pushFollow(FOLLOW_ruleKeyword_in_ruleCharacterRange4435);
            this_Keyword_0=ruleKeyword();
            _fsp--;

             
                    current = this_Keyword_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1967:1: ( ( () '..' ) (lv_right_3= ruleKeyword ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==40) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1967:2: ( () '..' ) (lv_right_3= ruleKeyword )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1967:2: ( () '..' )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1967:3: () '..'
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1967:3: ()
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1968:5: 
                    {
                     
                            temp=factory.create(grammarAccess.prCharacterRange().ele100ActionCharacterRangeleft().getTypeName().getType());
                            try {
                            	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.prCharacterRange().ele100ActionCharacterRangeleft(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    match(input,40,FOLLOW_40_in_ruleCharacterRange4454); 

                            createLeafNode(grammarAccess.prCharacterRange().ele101KeywordFullStopFullStop(), null); 
                        

                    }

                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1987:2: (lv_right_3= ruleKeyword )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1990:6: lv_right_3= ruleKeyword
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prCharacterRange().ele110ParserRuleCallKeyword(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleKeyword_in_ruleCharacterRange4489);
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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2017:1: entryRuleCrossReference returns [EObject current=null] : iv_ruleCrossReference= ruleCrossReference EOF ;
    public final EObject entryRuleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReference = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2017:56: (iv_ruleCrossReference= ruleCrossReference EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2018:2: iv_ruleCrossReference= ruleCrossReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCrossReference().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCrossReference_in_entryRuleCrossReference4530);
            iv_ruleCrossReference=ruleCrossReference();
            _fsp--;

             current =iv_ruleCrossReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReference4540); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2025:1: ruleCrossReference returns [EObject current=null] : ( ( ( '[' (lv_type_1= ruleTypeRef ) ) ( '|' ( RULE_ID ) )? ) ']' ) ;
    public final EObject ruleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject lv_type_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2030:6: ( ( ( ( '[' (lv_type_1= ruleTypeRef ) ) ( '|' ( RULE_ID ) )? ) ']' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2031:1: ( ( ( '[' (lv_type_1= ruleTypeRef ) ) ( '|' ( RULE_ID ) )? ) ']' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2031:1: ( ( ( '[' (lv_type_1= ruleTypeRef ) ) ( '|' ( RULE_ID ) )? ) ']' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2031:2: ( ( '[' (lv_type_1= ruleTypeRef ) ) ( '|' ( RULE_ID ) )? ) ']'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2031:2: ( ( '[' (lv_type_1= ruleTypeRef ) ) ( '|' ( RULE_ID ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2031:3: ( '[' (lv_type_1= ruleTypeRef ) ) ( '|' ( RULE_ID ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2031:3: ( '[' (lv_type_1= ruleTypeRef ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2031:4: '[' (lv_type_1= ruleTypeRef )
            {
            match(input,41,FOLLOW_41_in_ruleCrossReference4576); 

                    createLeafNode(grammarAccess.prCrossReference().ele000KeywordLeftSquareBracket(), null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2035:1: (lv_type_1= ruleTypeRef )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2038:6: lv_type_1= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prCrossReference().ele0010ParserRuleCallTypeRef(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleCrossReference4610);
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


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2056:3: ( '|' ( RULE_ID ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==28) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2056:4: '|' ( RULE_ID )
                    {
                    match(input,28,FOLLOW_28_in_ruleCrossReference4625); 

                            createLeafNode(grammarAccess.prCrossReference().ele010KeywordVerticalLine(), null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2060:1: ( RULE_ID )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2063:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prCrossReference().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCrossReference4647); 

                    		createLeafNode(grammarAccess.prCrossReference().ele0110CrossReferenceEStringAbstractRule(), "rule"); 
                    	

                    }


                    }
                    break;

            }


            }

            match(input,42,FOLLOW_42_in_ruleCrossReference4662); 

                    createLeafNode(grammarAccess.prCrossReference().ele1KeywordRightSquareBracket(), null); 
                

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2089:1: entryRuleParenthesizedElement returns [EObject current=null] : iv_ruleParenthesizedElement= ruleParenthesizedElement EOF ;
    public final EObject entryRuleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedElement = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2089:62: (iv_ruleParenthesizedElement= ruleParenthesizedElement EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2090:2: iv_ruleParenthesizedElement= ruleParenthesizedElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.prParenthesizedElement().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement4697);
            iv_ruleParenthesizedElement=ruleParenthesizedElement();
            _fsp--;

             current =iv_ruleParenthesizedElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedElement4707); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2097:1: ruleParenthesizedElement returns [EObject current=null] : ( ( '(' this_Alternatives_1= ruleAlternatives ) ')' ) ;
    public final EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Alternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2102:6: ( ( ( '(' this_Alternatives_1= ruleAlternatives ) ')' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2103:1: ( ( '(' this_Alternatives_1= ruleAlternatives ) ')' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2103:1: ( ( '(' this_Alternatives_1= ruleAlternatives ) ')' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2103:2: ( '(' this_Alternatives_1= ruleAlternatives ) ')'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2103:2: ( '(' this_Alternatives_1= ruleAlternatives )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2103:3: '(' this_Alternatives_1= ruleAlternatives
            {
            match(input,14,FOLLOW_14_in_ruleParenthesizedElement4742); 

                    createLeafNode(grammarAccess.prParenthesizedElement().ele00KeywordLeftParenthesis(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.prParenthesizedElement().ele01ParserRuleCallAlternatives(), currentNode); 
                
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesizedElement4764);
            this_Alternatives_1=ruleAlternatives();
            _fsp--;

             
                    current = this_Alternatives_1; 
                    currentNode = currentNode.getParent();
                

            }

            match(input,16,FOLLOW_16_in_ruleParenthesizedElement4773); 

                    createLeafNode(grammarAccess.prParenthesizedElement().ele1KeywordRightParenthesis(), null); 
                

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2129:1: entryRuleParenthesizedTerminalElement returns [EObject current=null] : iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF ;
    public final EObject entryRuleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedTerminalElement = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2129:70: (iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2130:2: iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.prParenthesizedTerminalElement().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4808);
            iv_ruleParenthesizedTerminalElement=ruleParenthesizedTerminalElement();
            _fsp--;

             current =iv_ruleParenthesizedTerminalElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4818); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2137:1: ruleParenthesizedTerminalElement returns [EObject current=null] : ( ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ) ')' ) ;
    public final EObject ruleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalAlternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2142:6: ( ( ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ) ')' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2143:1: ( ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ) ')' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2143:1: ( ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ) ')' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2143:2: ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ) ')'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2143:2: ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2143:3: '(' this_TerminalAlternatives_1= ruleTerminalAlternatives
            {
            match(input,14,FOLLOW_14_in_ruleParenthesizedTerminalElement4853); 

                    createLeafNode(grammarAccess.prParenthesizedTerminalElement().ele00KeywordLeftParenthesis(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.prParenthesizedTerminalElement().ele01ParserRuleCallTerminalAlternatives(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4875);
            this_TerminalAlternatives_1=ruleTerminalAlternatives();
            _fsp--;

             
                    current = this_TerminalAlternatives_1; 
                    currentNode = currentNode.getParent();
                

            }

            match(input,16,FOLLOW_16_in_ruleParenthesizedTerminalElement4884); 

                    createLeafNode(grammarAccess.prParenthesizedTerminalElement().ele1KeywordRightParenthesis(), null); 
                

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2169:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2169:49: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2170:2: iv_ruleKeyword= ruleKeyword EOF
            {
             currentNode = createCompositeNode(grammarAccess.prKeyword().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword4919);
            iv_ruleKeyword=ruleKeyword();
            _fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword4929); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2177:1: ruleKeyword returns [EObject current=null] : (lv_value_0= RULE_STRING ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2182:6: ( (lv_value_0= RULE_STRING ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2183:1: (lv_value_0= RULE_STRING )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2183:1: (lv_value_0= RULE_STRING )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2185:6: lv_value_0= RULE_STRING
            {
            lv_value_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword4974); 

            		createLeafNode(grammarAccess.prKeyword().ele0ParserRuleCallSTRING(), "value"); 
            	

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2211:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2211:50: (iv_ruleRuleCall= ruleRuleCall EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2212:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.prRuleCall().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleRuleCall_in_entryRuleRuleCall5015);
            iv_ruleRuleCall=ruleRuleCall();
            _fsp--;

             current =iv_ruleRuleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleCall5025); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2219:1: ruleRuleCall returns [EObject current=null] : ( RULE_ID ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2224:6: ( ( RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2225:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2225:1: ( RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2228:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prRuleCall().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall5071); 

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


 

    public static final BitSet FOLLOW_ruleGrammar_in_entryRuleGrammar72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammar82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleGrammar120 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar154 = new BitSet(new long[]{0x0000000004743010L});
    public static final BitSet FOLLOW_12_in_ruleGrammar169 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar196 = new BitSet(new long[]{0x0000000004742010L});
    public static final BitSet FOLLOW_13_in_ruleGrammar226 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleGrammar248 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar272 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleGrammar285 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar307 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_ruleGrammar324 = new BitSet(new long[]{0x0000000004740010L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar361 = new BitSet(new long[]{0x0000000004740010L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleGrammar401 = new BitSet(new long[]{0x0000000004600012L});
    public static final BitSet FOLLOW_ruleGrammarID_in_entryRuleGrammarID442 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammarID453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarID493 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleGrammarID512 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarID527 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule574 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexerRule_in_ruleAbstractRule632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleAbstractRule659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_ruleAbstractRule687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel839 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGeneratedMetamodel849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleGeneratedMetamodel885 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel906 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel936 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleGeneratedMetamodel950 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel1015 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleReferencedMetamodel1060 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1082 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleReferencedMetamodel1096 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel1117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexerRule_in_entryRuleLexerRule1161 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexerRule1171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleLexerRule1210 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_22_in_ruleLexerRule1225 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexerRule1247 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleLexerRule1265 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleLexerRule1299 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleLexerRule1315 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLexerRule1337 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleLexerRule1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_entryRuleParserRule1389 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParserRule1399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1449 = new BitSet(new long[]{0x0000000001802000L});
    public static final BitSet FOLLOW_23_in_ruleParserRule1466 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule1500 = new BitSet(new long[]{0x0000000001002000L});
    public static final BitSet FOLLOW_13_in_ruleParserRule1531 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleParserRule1553 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1577 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleParserRule1590 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1612 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_ruleParserRule1629 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleParserRule1641 = new BitSet(new long[]{0x0000020800004030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule1676 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleParserRule1690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1725 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule1735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleTerminalRule1785 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTerminalRule1819 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleTerminalRule1837 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleTerminalRule1871 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleTerminalRule1887 = new BitSet(new long[]{0x000000C000024030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule1922 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleTerminalRule1936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef1971 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef1981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef2029 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleTypeRef2041 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef2065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives2103 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives2113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives2160 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleAlternatives2179 = new BitSet(new long[]{0x0000020800004030L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives2214 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives2255 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives2265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2312 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleTerminalAlternatives2331 = new BitSet(new long[]{0x000000C000024030L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2366 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup2407 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroup2417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup2464 = new BitSet(new long[]{0x0000020800004032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup2507 = new BitSet(new long[]{0x0000020800004032L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup2548 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup2558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2605 = new BitSet(new long[]{0x000000C000024032L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2648 = new BitSet(new long[]{0x000000C000024032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken2689 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken2699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractToken2748 = new BitSet(new long[]{0x00000000E0000002L});
    public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken2775 = new BitSet(new long[]{0x00000000E0000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken2803 = new BitSet(new long[]{0x00000000E0000002L});
    public static final BitSet FOLLOW_29_in_ruleAbstractToken2826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleAbstractToken2842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleAbstractToken2860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken2911 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken2921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken2968 = new BitSet(new long[]{0x00000000E0000002L});
    public static final BitSet FOLLOW_29_in_ruleTerminalToken2990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleTerminalToken3006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleTerminalToken3024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment3075 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment3085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment3132 = new BitSet(new long[]{0x0000000700000000L});
    public static final BitSet FOLLOW_32_in_ruleAssignment3162 = new BitSet(new long[]{0x0000020000004030L});
    public static final BitSet FOLLOW_33_in_ruleAssignment3178 = new BitSet(new long[]{0x0000020000004030L});
    public static final BitSet FOLLOW_34_in_ruleAssignment3196 = new BitSet(new long[]{0x0000020000004030L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAssignment3246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_entryRuleAction3285 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAction3295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleAction3335 = new BitSet(new long[]{0x0000001000000010L});
    public static final BitSet FOLLOW_36_in_ruleAction3345 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleAction3354 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction3391 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleAction3405 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAction3427 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_33_in_ruleAction3457 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_32_in_ruleAction3473 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleAction3498 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleAction3508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal3543 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal3553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal3602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal3629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal3657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_ruleAbstractTerminal3685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement3719 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement3729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement3779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement3806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement3834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement3862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_ruleTerminalTokenElement3890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken3924 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken3934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken3981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpToToken_in_ruleAbstractNegatedToken4008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken4042 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken4052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleNegatedToken4086 = new BitSet(new long[]{0x000000C000024030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken4120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpToToken_in_entryRuleUpToToken4159 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUpToToken4169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleUpToToken4203 = new BitSet(new long[]{0x000000C000024030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleUpToToken4237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard4276 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcard4286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleWildcard4331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange4378 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange4388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange4435 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleCharacterRange4454 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange4489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference4530 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference4540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleCrossReference4576 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleCrossReference4610 = new BitSet(new long[]{0x0000040010000000L});
    public static final BitSet FOLLOW_28_in_ruleCrossReference4625 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCrossReference4647 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleCrossReference4662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement4697 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement4707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleParenthesizedElement4742 = new BitSet(new long[]{0x0000020800004030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement4764 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParenthesizedElement4773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4808 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleParenthesizedTerminalElement4853 = new BitSet(new long[]{0x000000C000024030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4875 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParenthesizedTerminalElement4884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword4919 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword4929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword4974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall5015 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall5025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall5071 = new BitSet(new long[]{0x0000000000000002L});

}