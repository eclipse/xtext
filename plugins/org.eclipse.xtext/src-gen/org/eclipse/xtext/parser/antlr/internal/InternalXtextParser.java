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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'abstract'", "'grammar'", "'extends'", "'hidden'", "'('", "','", "')'", "'.'", "'generate'", "'as'", "'import'", "'native'", "'lexer'", "'returns'", "':'", "';'", "'terminal'", "'::'", "'|'", "'?'", "'*'", "'+'", "'+='", "'='", "'?='", "'{'", "'current'", "'}'", "'!'", "'->'", "'..'", "'['", "']'"
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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:78:1: ruleGrammar returns [EObject current=null] : ( ( ( ( ( ( (lv_abstract_0= 'abstract' )? 'grammar' ) (lv_name_2= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) (lv_metamodelDeclarations_11= ruleAbstractMetamodelDeclaration )* ) (lv_rules_12= ruleAbstractRule )+ ) ;
    public final EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_0=null;
        Token lv_definesHiddenTokens_5=null;
        AntlrDatatypeRuleToken lv_name_2 = null;

        EObject lv_metamodelDeclarations_11 = null;

        EObject lv_rules_12 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:83:6: ( ( ( ( ( ( ( (lv_abstract_0= 'abstract' )? 'grammar' ) (lv_name_2= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) (lv_metamodelDeclarations_11= ruleAbstractMetamodelDeclaration )* ) (lv_rules_12= ruleAbstractRule )+ ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:1: ( ( ( ( ( ( (lv_abstract_0= 'abstract' )? 'grammar' ) (lv_name_2= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) (lv_metamodelDeclarations_11= ruleAbstractMetamodelDeclaration )* ) (lv_rules_12= ruleAbstractRule )+ )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:1: ( ( ( ( ( ( (lv_abstract_0= 'abstract' )? 'grammar' ) (lv_name_2= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) (lv_metamodelDeclarations_11= ruleAbstractMetamodelDeclaration )* ) (lv_rules_12= ruleAbstractRule )+ )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:2: ( ( ( ( ( (lv_abstract_0= 'abstract' )? 'grammar' ) (lv_name_2= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) (lv_metamodelDeclarations_11= ruleAbstractMetamodelDeclaration )* ) (lv_rules_12= ruleAbstractRule )+
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:2: ( ( ( ( ( (lv_abstract_0= 'abstract' )? 'grammar' ) (lv_name_2= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) (lv_metamodelDeclarations_11= ruleAbstractMetamodelDeclaration )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:3: ( ( ( ( (lv_abstract_0= 'abstract' )? 'grammar' ) (lv_name_2= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) (lv_metamodelDeclarations_11= ruleAbstractMetamodelDeclaration )*
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:3: ( ( ( ( (lv_abstract_0= 'abstract' )? 'grammar' ) (lv_name_2= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:4: ( ( ( (lv_abstract_0= 'abstract' )? 'grammar' ) (lv_name_2= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? ) ( ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:4: ( ( ( (lv_abstract_0= 'abstract' )? 'grammar' ) (lv_name_2= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:5: ( ( (lv_abstract_0= 'abstract' )? 'grammar' ) (lv_name_2= ruleGrammarID ) ) ( 'extends' ( ruleGrammarID ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:5: ( ( (lv_abstract_0= 'abstract' )? 'grammar' ) (lv_name_2= ruleGrammarID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:6: ( (lv_abstract_0= 'abstract' )? 'grammar' ) (lv_name_2= ruleGrammarID )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:6: ( (lv_abstract_0= 'abstract' )? 'grammar' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:7: (lv_abstract_0= 'abstract' )? 'grammar'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:84:7: (lv_abstract_0= 'abstract' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:86:6: lv_abstract_0= 'abstract'
                    {
                    lv_abstract_0=(Token)input.LT(1);
                    match(input,11,FOLLOW_11_in_ruleGrammar133); 

                            createLeafNode(grammarAccess.prGrammar().ele0000000KeywordAbstract(), "abstract"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "abstract", true, "abstract", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }

            match(input,12,FOLLOW_12_in_ruleGrammar156); 

                    createLeafNode(grammarAccess.prGrammar().ele000001KeywordGrammar(), null); 
                

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:109:2: (lv_name_2= ruleGrammarID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:112:6: lv_name_2= ruleGrammarID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele000010ParserRuleCallGrammarID(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleGrammarID_in_ruleGrammar191);
            lv_name_2=ruleGrammarID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "GrammarID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:130:3: ( 'extends' ( ruleGrammarID ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:130:4: 'extends' ( ruleGrammarID )
                    {
                    match(input,13,FOLLOW_13_in_ruleGrammar206); 

                            createLeafNode(grammarAccess.prGrammar().ele00010KeywordExtends(), null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:134:1: ( ruleGrammarID )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:137:3: ruleGrammarID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele000110CrossReferenceEStringGrammar(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleGrammarID_in_ruleGrammar233);
                    ruleGrammarID();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:152:5: ( ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:152:6: ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')'
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:152:6: ( ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:152:7: ( (lv_definesHiddenTokens_5= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )?
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:152:7: ( (lv_definesHiddenTokens_5= 'hidden' ) '(' )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:152:8: (lv_definesHiddenTokens_5= 'hidden' ) '('
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:152:8: (lv_definesHiddenTokens_5= 'hidden' )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:154:6: lv_definesHiddenTokens_5= 'hidden'
                    {
                    lv_definesHiddenTokens_5=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleGrammar263); 

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

                    match(input,15,FOLLOW_15_in_ruleGrammar285); 

                            createLeafNode(grammarAccess.prGrammar().ele001001KeywordLeftParenthesis(), null); 
                        

                    }

                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:177:2: ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:177:3: ( RULE_ID ) ( ',' ( RULE_ID ) )*
                            {
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:177:3: ( RULE_ID )
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:180:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar309); 

                            		createLeafNode(grammarAccess.prGrammar().ele0010100CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
                            	

                            }

                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:193:2: ( ',' ( RULE_ID ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==16) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:193:3: ',' ( RULE_ID )
                            	    {
                            	    match(input,16,FOLLOW_16_in_ruleGrammar322); 

                            	            createLeafNode(grammarAccess.prGrammar().ele0010110KeywordComma(), null); 
                            	        
                            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:197:1: ( RULE_ID )
                            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:200:3: RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar344); 

                            	    		createLeafNode(grammarAccess.prGrammar().ele00101110CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
                            	    	

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


                    }

                    match(input,17,FOLLOW_17_in_ruleGrammar361); 

                            createLeafNode(grammarAccess.prGrammar().ele0011KeywordRightParenthesis(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:217:4: (lv_metamodelDeclarations_11= ruleAbstractMetamodelDeclaration )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19||LA6_0==21) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:220:6: lv_metamodelDeclarations_11= ruleAbstractMetamodelDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele010ParserRuleCallAbstractMetamodelDeclaration(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar398);
            	    lv_metamodelDeclarations_11=ruleAbstractMetamodelDeclaration();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "metamodelDeclarations", lv_metamodelDeclarations_11, "AbstractMetamodelDeclaration", currentNode);
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


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:238:4: (lv_rules_12= ruleAbstractRule )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||(LA7_0>=22 && LA7_0<=23)||LA7_0==27) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:241:6: lv_rules_12= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prGrammar().ele10ParserRuleCallAbstractRule(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleGrammar438);
            	    lv_rules_12=ruleAbstractRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prGrammar().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "rules", lv_rules_12, "AbstractRule", currentNode);
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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:268:1: entryRuleGrammarID returns [String current=null] : iv_ruleGrammarID= ruleGrammarID EOF ;
    public final String entryRuleGrammarID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGrammarID = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:268:50: (iv_ruleGrammarID= ruleGrammarID EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:269:2: iv_ruleGrammarID= ruleGrammarID EOF
            {
             currentNode = createCompositeNode(grammarAccess.prGrammarID().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleGrammarID_in_entryRuleGrammarID479);
            iv_ruleGrammarID=ruleGrammarID();
            _fsp--;

             current =iv_ruleGrammarID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGrammarID490); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:276:1: ruleGrammarID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleGrammarID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:282:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:283:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:283:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:283:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammarID530); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.prGrammarID().ele0LexerRuleCallID(), null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:290:1: (kw= '.' this_ID_2= RULE_ID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==18) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:291:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,18,FOLLOW_18_in_ruleGrammarID549); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.prGrammarID().ele10KeywordFullStop(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammarID564); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(grammarAccess.prGrammarID().ele11LexerRuleCallID(), null); 
            	        

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:313:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:313:54: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:314:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule611);
            iv_ruleAbstractRule=ruleAbstractRule();
            _fsp--;

             current =iv_ruleAbstractRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRule621); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:321:1: ruleAbstractRule returns [EObject current=null] : ( (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule ) | this_TerminalRule_2= ruleTerminalRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_LexerRule_0 = null;

        EObject this_ParserRule_1 = null;

        EObject this_TerminalRule_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:326:6: ( ( (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule ) | this_TerminalRule_2= ruleTerminalRule ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:327:1: ( (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule ) | this_TerminalRule_2= ruleTerminalRule )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:327:1: ( (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule ) | this_TerminalRule_2= ruleTerminalRule )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID||(LA10_0>=22 && LA10_0<=23)) ) {
                alt10=1;
            }
            else if ( (LA10_0==27) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("327:1: ( (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule ) | this_TerminalRule_2= ruleTerminalRule )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:327:2: (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:327:2: (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule )
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( ((LA9_0>=22 && LA9_0<=23)) ) {
                        alt9=1;
                    }
                    else if ( (LA9_0==RULE_ID) ) {
                        alt9=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("327:2: (this_LexerRule_0= ruleLexerRule | this_ParserRule_1= ruleParserRule )", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:328:5: this_LexerRule_0= ruleLexerRule
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele00ParserRuleCallLexerRule(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleLexerRule_in_ruleAbstractRule669);
                            this_LexerRule_0=ruleLexerRule();
                            _fsp--;

                             
                                    current = this_LexerRule_0; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:338:5: this_ParserRule_1= ruleParserRule
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele01ParserRuleCallParserRule(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleParserRule_in_ruleAbstractRule696);
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
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:348:5: this_TerminalRule_2= ruleTerminalRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele1ParserRuleCallTerminalRule(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTerminalRule_in_ruleAbstractRule724);
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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:365:1: entryRuleAbstractMetamodelDeclaration returns [EObject current=null] : iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF ;
    public final EObject entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractMetamodelDeclaration = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:365:70: (iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:366:2: iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractMetamodelDeclaration().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration758);
            iv_ruleAbstractMetamodelDeclaration=ruleAbstractMetamodelDeclaration();
            _fsp--;

             current =iv_ruleAbstractMetamodelDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration768); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:373:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) ;
    public final EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel_0 = null;

        EObject this_ReferencedMetamodel_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:378:6: ( (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:379:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:379:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            else if ( (LA11_0==21) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("379:1: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:380:5: this_GeneratedMetamodel_0= ruleGeneratedMetamodel
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractMetamodelDeclaration().ele0ParserRuleCallGeneratedMetamodel(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration815);
                    this_GeneratedMetamodel_0=ruleGeneratedMetamodel();
                    _fsp--;

                     
                            current = this_GeneratedMetamodel_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:390:5: this_ReferencedMetamodel_1= ruleReferencedMetamodel
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractMetamodelDeclaration().ele1ParserRuleCallReferencedMetamodel(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration842);
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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:407:1: entryRuleGeneratedMetamodel returns [EObject current=null] : iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF ;
    public final EObject entryRuleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratedMetamodel = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:407:60: (iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:408:2: iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF
            {
             currentNode = createCompositeNode(grammarAccess.prGeneratedMetamodel().getRule(), currentNode); 
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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:415:1: ruleGeneratedMetamodel returns [EObject current=null] : ( ( ( 'generate' (lv_name_1= RULE_ID ) ) ( RULE_STRING ) ) ( 'as' (lv_alias_4= RULE_ID ) )? ) ;
    public final EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_alias_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:420:6: ( ( ( ( 'generate' (lv_name_1= RULE_ID ) ) ( RULE_STRING ) ) ( 'as' (lv_alias_4= RULE_ID ) )? ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:421:1: ( ( ( 'generate' (lv_name_1= RULE_ID ) ) ( RULE_STRING ) ) ( 'as' (lv_alias_4= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:421:1: ( ( ( 'generate' (lv_name_1= RULE_ID ) ) ( RULE_STRING ) ) ( 'as' (lv_alias_4= RULE_ID ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:421:2: ( ( 'generate' (lv_name_1= RULE_ID ) ) ( RULE_STRING ) ) ( 'as' (lv_alias_4= RULE_ID ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:421:2: ( ( 'generate' (lv_name_1= RULE_ID ) ) ( RULE_STRING ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:421:3: ( 'generate' (lv_name_1= RULE_ID ) ) ( RULE_STRING )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:421:3: ( 'generate' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:421:4: 'generate' (lv_name_1= RULE_ID )
            {
            match(input,19,FOLLOW_19_in_ruleGeneratedMetamodel922); 

                    createLeafNode(grammarAccess.prGeneratedMetamodel().ele000KeywordGenerate(), null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:425:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:427:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel944); 

            		createLeafNode(grammarAccess.prGeneratedMetamodel().ele0010LexerRuleCallID(), "name"); 
            	

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

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:445:3: ( RULE_STRING )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:448:3: RULE_STRING
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prGeneratedMetamodel().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel975); 

            		createLeafNode(grammarAccess.prGeneratedMetamodel().ele010CrossReferenceEStringEPackage(), "ePackage"); 
            	

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:461:3: ( 'as' (lv_alias_4= RULE_ID ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:461:4: 'as' (lv_alias_4= RULE_ID )
                    {
                    match(input,20,FOLLOW_20_in_ruleGeneratedMetamodel989); 

                            createLeafNode(grammarAccess.prGeneratedMetamodel().ele10KeywordAs(), null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:465:1: (lv_alias_4= RULE_ID )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:467:6: lv_alias_4= RULE_ID
                    {
                    lv_alias_4=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel1011); 

                    		createLeafNode(grammarAccess.prGeneratedMetamodel().ele110LexerRuleCallID(), "alias"); 
                    	

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:494:1: entryRuleReferencedMetamodel returns [EObject current=null] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final EObject entryRuleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedMetamodel = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:494:61: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:495:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
            {
             currentNode = createCompositeNode(grammarAccess.prReferencedMetamodel().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel1056);
            iv_ruleReferencedMetamodel=ruleReferencedMetamodel();
            _fsp--;

             current =iv_ruleReferencedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencedMetamodel1066); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:502:1: ruleReferencedMetamodel returns [EObject current=null] : ( ( 'import' ( RULE_STRING ) ) ( 'as' (lv_alias_3= RULE_ID ) )? ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_alias_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:507:6: ( ( ( 'import' ( RULE_STRING ) ) ( 'as' (lv_alias_3= RULE_ID ) )? ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:508:1: ( ( 'import' ( RULE_STRING ) ) ( 'as' (lv_alias_3= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:508:1: ( ( 'import' ( RULE_STRING ) ) ( 'as' (lv_alias_3= RULE_ID ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:508:2: ( 'import' ( RULE_STRING ) ) ( 'as' (lv_alias_3= RULE_ID ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:508:2: ( 'import' ( RULE_STRING ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:508:3: 'import' ( RULE_STRING )
            {
            match(input,21,FOLLOW_21_in_ruleReferencedMetamodel1101); 

                    createLeafNode(grammarAccess.prReferencedMetamodel().ele00KeywordImport(), null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:512:1: ( RULE_STRING )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:515:3: RULE_STRING
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prReferencedMetamodel().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1123); 

            		createLeafNode(grammarAccess.prReferencedMetamodel().ele010CrossReferenceEStringEPackage(), "ePackage"); 
            	

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:528:3: ( 'as' (lv_alias_3= RULE_ID ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==20) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:528:4: 'as' (lv_alias_3= RULE_ID )
                    {
                    match(input,20,FOLLOW_20_in_ruleReferencedMetamodel1137); 

                            createLeafNode(grammarAccess.prReferencedMetamodel().ele10KeywordAs(), null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:532:1: (lv_alias_3= RULE_ID )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:534:6: lv_alias_3= RULE_ID
                    {
                    lv_alias_3=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedMetamodel1159); 

                    		createLeafNode(grammarAccess.prReferencedMetamodel().ele110LexerRuleCallID(), "alias"); 
                    	

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:561:1: entryRuleLexerRule returns [EObject current=null] : iv_ruleLexerRule= ruleLexerRule EOF ;
    public final EObject entryRuleLexerRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexerRule = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:561:51: (iv_ruleLexerRule= ruleLexerRule EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:562:2: iv_ruleLexerRule= ruleLexerRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prLexerRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleLexerRule_in_entryRuleLexerRule1204);
            iv_ruleLexerRule=ruleLexerRule();
            _fsp--;

             current =iv_ruleLexerRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexerRule1214); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:569:1: ruleLexerRule returns [EObject current=null] : ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' ) (lv_body_6= RULE_STRING ) ) ';' ) ;
    public final EObject ruleLexerRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        Token lv_body_6=null;
        EObject lv_type_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:574:6: ( ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' ) (lv_body_6= RULE_STRING ) ) ';' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:575:1: ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' ) (lv_body_6= RULE_STRING ) ) ';' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:575:1: ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' ) (lv_body_6= RULE_STRING ) ) ';' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:575:2: ( ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' ) (lv_body_6= RULE_STRING ) ) ';'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:575:2: ( ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' ) (lv_body_6= RULE_STRING ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:575:3: ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' ) (lv_body_6= RULE_STRING )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:575:3: ( ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:575:4: ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? ) ':'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:575:4: ( ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:575:5: ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) ) ( 'returns' (lv_type_4= ruleTypeRef ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:575:5: ( ( 'native' | 'lexer' ) (lv_name_2= RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:575:6: ( 'native' | 'lexer' ) (lv_name_2= RULE_ID )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:575:6: ( 'native' | 'lexer' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            else if ( (LA14_0==23) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("575:6: ( 'native' | 'lexer' )", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:575:7: 'native'
                    {
                    match(input,22,FOLLOW_22_in_ruleLexerRule1253); 

                            createLeafNode(grammarAccess.prLexerRule().ele000000KeywordNative(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:580:6: 'lexer'
                    {
                    match(input,23,FOLLOW_23_in_ruleLexerRule1268); 

                            createLeafNode(grammarAccess.prLexerRule().ele000001KeywordLexer(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:584:2: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:586:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexerRule1291); 

            		createLeafNode(grammarAccess.prLexerRule().ele000010LexerRuleCallID(), "name"); 
            	

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

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:604:3: ( 'returns' (lv_type_4= ruleTypeRef ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:604:4: 'returns' (lv_type_4= ruleTypeRef )
                    {
                    match(input,24,FOLLOW_24_in_ruleLexerRule1310); 

                            createLeafNode(grammarAccess.prLexerRule().ele00010KeywordReturns(), null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:608:1: (lv_type_4= ruleTypeRef )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:611:6: lv_type_4= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prLexerRule().ele000110ParserRuleCallTypeRef(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleLexerRule1344);
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

            match(input,25,FOLLOW_25_in_ruleLexerRule1360); 

                    createLeafNode(grammarAccess.prLexerRule().ele001KeywordColon(), null); 
                

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:633:2: (lv_body_6= RULE_STRING )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:635:6: lv_body_6= RULE_STRING
            {
            lv_body_6=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLexerRule1383); 

            		createLeafNode(grammarAccess.prLexerRule().ele010LexerRuleCallSTRING(), "body"); 
            	

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

            match(input,26,FOLLOW_26_in_ruleLexerRule1401); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:666:1: entryRuleParserRule returns [EObject current=null] : iv_ruleParserRule= ruleParserRule EOF ;
    public final EObject entryRuleParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRule = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:666:52: (iv_ruleParserRule= ruleParserRule EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:667:2: iv_ruleParserRule= ruleParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleParserRule_in_entryRuleParserRule1436);
            iv_ruleParserRule=ruleParserRule();
            _fsp--;

             current =iv_ruleParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParserRule1446); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:674:1: ruleParserRule returns [EObject current=null] : ( ( ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' ) (lv_alternatives_10= ruleAlternatives ) ) ';' ) ;
    public final EObject ruleParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        Token lv_definesHiddenTokens_3=null;
        EObject lv_type_2 = null;

        EObject lv_alternatives_10 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:679:6: ( ( ( ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' ) (lv_alternatives_10= ruleAlternatives ) ) ';' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:680:1: ( ( ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' ) (lv_alternatives_10= ruleAlternatives ) ) ';' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:680:1: ( ( ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' ) (lv_alternatives_10= ruleAlternatives ) ) ';' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:680:2: ( ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' ) (lv_alternatives_10= ruleAlternatives ) ) ';'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:680:2: ( ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' ) (lv_alternatives_10= ruleAlternatives ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:680:3: ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' ) (lv_alternatives_10= ruleAlternatives )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:680:3: ( ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:680:4: ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? ) ':'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:680:4: ( ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:680:5: ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:680:5: ( (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:680:6: (lv_name_0= RULE_ID ) ( 'returns' (lv_type_2= ruleTypeRef ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:680:6: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:682:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1497); 

            		createLeafNode(grammarAccess.prParserRule().ele000000LexerRuleCallID(), "name"); 
            	

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

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:700:2: ( 'returns' (lv_type_2= ruleTypeRef ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:700:3: 'returns' (lv_type_2= ruleTypeRef )
                    {
                    match(input,24,FOLLOW_24_in_ruleParserRule1515); 

                            createLeafNode(grammarAccess.prParserRule().ele000010KeywordReturns(), null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:704:1: (lv_type_2= ruleTypeRef )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:707:6: lv_type_2= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prParserRule().ele0000110ParserRuleCallTypeRef(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleParserRule1549);
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

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:725:5: ( ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==14) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:725:6: ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? ) ')'
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:725:6: ( ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )? )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:725:7: ( (lv_definesHiddenTokens_3= 'hidden' ) '(' ) ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )?
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:725:7: ( (lv_definesHiddenTokens_3= 'hidden' ) '(' )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:725:8: (lv_definesHiddenTokens_3= 'hidden' ) '('
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:725:8: (lv_definesHiddenTokens_3= 'hidden' )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:727:6: lv_definesHiddenTokens_3= 'hidden'
                    {
                    lv_definesHiddenTokens_3=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleParserRule1580); 

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

                    match(input,15,FOLLOW_15_in_ruleParserRule1602); 

                            createLeafNode(grammarAccess.prParserRule().ele0001001KeywordLeftParenthesis(), null); 
                        

                    }

                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:750:2: ( ( RULE_ID ) ( ',' ( RULE_ID ) )* )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==RULE_ID) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:750:3: ( RULE_ID ) ( ',' ( RULE_ID ) )*
                            {
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:750:3: ( RULE_ID )
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:753:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.prParserRule().getRule().getType().getType());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1626); 

                            		createLeafNode(grammarAccess.prParserRule().ele00010100CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
                            	

                            }

                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:766:2: ( ',' ( RULE_ID ) )*
                            loop17:
                            do {
                                int alt17=2;
                                int LA17_0 = input.LA(1);

                                if ( (LA17_0==16) ) {
                                    alt17=1;
                                }


                                switch (alt17) {
                            	case 1 :
                            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:766:3: ',' ( RULE_ID )
                            	    {
                            	    match(input,16,FOLLOW_16_in_ruleParserRule1639); 

                            	            createLeafNode(grammarAccess.prParserRule().ele00010110KeywordComma(), null); 
                            	        
                            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:770:1: ( RULE_ID )
                            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:773:3: RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create(grammarAccess.prParserRule().getRule().getType().getType());
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1661); 

                            	    		createLeafNode(grammarAccess.prParserRule().ele000101110CrossReferenceEStringAbstractRule(), "hiddenTokens"); 
                            	    	

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop17;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }

                    match(input,17,FOLLOW_17_in_ruleParserRule1678); 

                            createLeafNode(grammarAccess.prParserRule().ele00011KeywordRightParenthesis(), null); 
                        

                    }
                    break;

            }


            }

            match(input,25,FOLLOW_25_in_ruleParserRule1690); 

                    createLeafNode(grammarAccess.prParserRule().ele001KeywordColon(), null); 
                

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:794:2: (lv_alternatives_10= ruleAlternatives )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:797:6: lv_alternatives_10= ruleAlternatives
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prParserRule().ele010ParserRuleCallAlternatives(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParserRule1725);
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

            match(input,26,FOLLOW_26_in_ruleParserRule1739); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:828:1: entryRuleTerminalRule returns [EObject current=null] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final EObject entryRuleTerminalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRule = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:828:54: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:829:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1774);
            iv_ruleTerminalRule=ruleTerminalRule();
            _fsp--;

             current =iv_ruleTerminalRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalRule1784); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:836:1: ruleTerminalRule returns [EObject current=null] : ( ( ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' ) (lv_alternatives_5= ruleTerminalAlternatives ) ) ';' ) ;
    public final EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token lv_terminal_0=null;
        Token lv_name_1=null;
        EObject lv_type_3 = null;

        EObject lv_alternatives_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:841:6: ( ( ( ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' ) (lv_alternatives_5= ruleTerminalAlternatives ) ) ';' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:842:1: ( ( ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' ) (lv_alternatives_5= ruleTerminalAlternatives ) ) ';' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:842:1: ( ( ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' ) (lv_alternatives_5= ruleTerminalAlternatives ) ) ';' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:842:2: ( ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' ) (lv_alternatives_5= ruleTerminalAlternatives ) ) ';'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:842:2: ( ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' ) (lv_alternatives_5= ruleTerminalAlternatives ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:842:3: ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' ) (lv_alternatives_5= ruleTerminalAlternatives )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:842:3: ( ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:842:4: ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? ) ':'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:842:4: ( ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:842:5: ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) ) ( 'returns' (lv_type_3= ruleTypeRef ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:842:5: ( (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:842:6: (lv_terminal_0= 'terminal' ) (lv_name_1= RULE_ID )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:842:6: (lv_terminal_0= 'terminal' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:844:6: lv_terminal_0= 'terminal'
            {
            lv_terminal_0=(Token)input.LT(1);
            match(input,27,FOLLOW_27_in_ruleTerminalRule1834); 

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

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:863:2: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:865:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTerminalRule1869); 

            		createLeafNode(grammarAccess.prTerminalRule().ele000010LexerRuleCallID(), "name"); 
            	

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

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:883:3: ( 'returns' (lv_type_3= ruleTypeRef ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==24) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:883:4: 'returns' (lv_type_3= ruleTypeRef )
                    {
                    match(input,24,FOLLOW_24_in_ruleTerminalRule1888); 

                            createLeafNode(grammarAccess.prTerminalRule().ele00010KeywordReturns(), null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:887:1: (lv_type_3= ruleTypeRef )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:890:6: lv_type_3= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prTerminalRule().ele000110ParserRuleCallTypeRef(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleTerminalRule1922);
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

            match(input,25,FOLLOW_25_in_ruleTerminalRule1938); 

                    createLeafNode(grammarAccess.prTerminalRule().ele001KeywordColon(), null); 
                

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:912:2: (lv_alternatives_5= ruleTerminalAlternatives )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:915:6: lv_alternatives_5= ruleTerminalAlternatives
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prTerminalRule().ele010ParserRuleCallTerminalAlternatives(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule1973);
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

            match(input,26,FOLLOW_26_in_ruleTerminalRule1987); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:946:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:946:49: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:947:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTypeRef().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef2022);
            iv_ruleTypeRef=ruleTypeRef();
            _fsp--;

             current =iv_ruleTypeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef2032); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:954:1: ruleTypeRef returns [EObject current=null] : ( ( ( RULE_ID ) '::' )? ( RULE_ID ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:959:6: ( ( ( ( RULE_ID ) '::' )? ( RULE_ID ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:960:1: ( ( ( RULE_ID ) '::' )? ( RULE_ID ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:960:1: ( ( ( RULE_ID ) '::' )? ( RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:960:2: ( ( RULE_ID ) '::' )? ( RULE_ID )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:960:2: ( ( RULE_ID ) '::' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==28) ) {
                    alt21=1;
                }
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:960:3: ( RULE_ID ) '::'
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:960:3: ( RULE_ID )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:963:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prTypeRef().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef2080); 

                    		createLeafNode(grammarAccess.prTypeRef().ele000CrossReferenceEStringAbstractMetamodelDeclaration(), "metamodel"); 
                    	

                    }

                    match(input,28,FOLLOW_28_in_ruleTypeRef2092); 

                            createLeafNode(grammarAccess.prTypeRef().ele01KeywordColonColon(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:980:3: ( RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:983:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prTypeRef().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef2116); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1005:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1005:54: (iv_ruleAlternatives= ruleAlternatives EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1006:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAlternatives().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAlternatives_in_entryRuleAlternatives2154);
            iv_ruleAlternatives=ruleAlternatives();
            _fsp--;

             current =iv_ruleAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternatives2164); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1013:1: ruleAlternatives returns [EObject current=null] : (this_Group_0= ruleGroup ( ( () '|' ) (lv_groups_3= ruleGroup ) )* ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_Group_0 = null;

        EObject lv_groups_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1018:6: ( (this_Group_0= ruleGroup ( ( () '|' ) (lv_groups_3= ruleGroup ) )* ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1019:1: (this_Group_0= ruleGroup ( ( () '|' ) (lv_groups_3= ruleGroup ) )* )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1019:1: (this_Group_0= ruleGroup ( ( () '|' ) (lv_groups_3= ruleGroup ) )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1020:5: this_Group_0= ruleGroup ( ( () '|' ) (lv_groups_3= ruleGroup ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.prAlternatives().ele0ParserRuleCallGroup(), currentNode); 
                
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives2211);
            this_Group_0=ruleGroup();
            _fsp--;

             
                    current = this_Group_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1028:1: ( ( () '|' ) (lv_groups_3= ruleGroup ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==29) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1028:2: ( () '|' ) (lv_groups_3= ruleGroup )
            	    {
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1028:2: ( () '|' )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1028:3: () '|'
            	    {
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1028:3: ()
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1029:5: 
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

            	    match(input,29,FOLLOW_29_in_ruleAlternatives2230); 

            	            createLeafNode(grammarAccess.prAlternatives().ele101KeywordVerticalLine(), null); 
            	        

            	    }

            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1048:2: (lv_groups_3= ruleGroup )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1051:6: lv_groups_3= ruleGroup
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prAlternatives().ele110ParserRuleCallGroup(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives2265);
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
    // $ANTLR end ruleAlternatives


    // $ANTLR start entryRuleTerminalAlternatives
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1078:1: entryRuleTerminalAlternatives returns [EObject current=null] : iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF ;
    public final EObject entryRuleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalAlternatives = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1078:62: (iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1079:2: iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalAlternatives().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives2306);
            iv_ruleTerminalAlternatives=ruleTerminalAlternatives();
            _fsp--;

             current =iv_ruleTerminalAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalAlternatives2316); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1086:1: ruleTerminalAlternatives returns [EObject current=null] : (this_TerminalGroup_0= ruleTerminalGroup ( ( () '|' ) (lv_groups_3= ruleTerminalGroup ) )* ) ;
    public final EObject ruleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalGroup_0 = null;

        EObject lv_groups_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1091:6: ( (this_TerminalGroup_0= ruleTerminalGroup ( ( () '|' ) (lv_groups_3= ruleTerminalGroup ) )* ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1092:1: (this_TerminalGroup_0= ruleTerminalGroup ( ( () '|' ) (lv_groups_3= ruleTerminalGroup ) )* )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1092:1: (this_TerminalGroup_0= ruleTerminalGroup ( ( () '|' ) (lv_groups_3= ruleTerminalGroup ) )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1093:5: this_TerminalGroup_0= ruleTerminalGroup ( ( () '|' ) (lv_groups_3= ruleTerminalGroup ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.prTerminalAlternatives().ele0ParserRuleCallTerminalGroup(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2363);
            this_TerminalGroup_0=ruleTerminalGroup();
            _fsp--;

             
                    current = this_TerminalGroup_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1101:1: ( ( () '|' ) (lv_groups_3= ruleTerminalGroup ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==29) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1101:2: ( () '|' ) (lv_groups_3= ruleTerminalGroup )
            	    {
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1101:2: ( () '|' )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1101:3: () '|'
            	    {
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1101:3: ()
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1102:5: 
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

            	    match(input,29,FOLLOW_29_in_ruleTerminalAlternatives2382); 

            	            createLeafNode(grammarAccess.prTerminalAlternatives().ele101KeywordVerticalLine(), null); 
            	        

            	    }

            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1121:2: (lv_groups_3= ruleTerminalGroup )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1124:6: lv_groups_3= ruleTerminalGroup
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prTerminalAlternatives().ele110ParserRuleCallTerminalGroup(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2417);
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
    // $ANTLR end ruleTerminalAlternatives


    // $ANTLR start entryRuleGroup
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1151:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1151:47: (iv_ruleGroup= ruleGroup EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1152:2: iv_ruleGroup= ruleGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.prGroup().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleGroup_in_entryRuleGroup2458);
            iv_ruleGroup=ruleGroup();
            _fsp--;

             current =iv_ruleGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroup2468); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1159:1: ruleGroup returns [EObject current=null] : (this_AbstractToken_0= ruleAbstractToken ( () (lv_abstractTokens_2= ruleAbstractToken ) )* ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken_0 = null;

        EObject lv_abstractTokens_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1164:6: ( (this_AbstractToken_0= ruleAbstractToken ( () (lv_abstractTokens_2= ruleAbstractToken ) )* ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1165:1: (this_AbstractToken_0= ruleAbstractToken ( () (lv_abstractTokens_2= ruleAbstractToken ) )* )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1165:1: (this_AbstractToken_0= ruleAbstractToken ( () (lv_abstractTokens_2= ruleAbstractToken ) )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1166:5: this_AbstractToken_0= ruleAbstractToken ( () (lv_abstractTokens_2= ruleAbstractToken ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.prGroup().ele0ParserRuleCallAbstractToken(), currentNode); 
                
            pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup2515);
            this_AbstractToken_0=ruleAbstractToken();
            _fsp--;

             
                    current = this_AbstractToken_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1174:1: ( () (lv_abstractTokens_2= ruleAbstractToken ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=RULE_ID && LA24_0<=RULE_STRING)||LA24_0==15||LA24_0==36||LA24_0==42) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1174:2: () (lv_abstractTokens_2= ruleAbstractToken )
            	    {
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1174:2: ()
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1175:5: 
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

            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1190:2: (lv_abstractTokens_2= ruleAbstractToken )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1193:6: lv_abstractTokens_2= ruleAbstractToken
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prGroup().ele110ParserRuleCallAbstractToken(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup2558);
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
    // $ANTLR end ruleGroup


    // $ANTLR start entryRuleTerminalGroup
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1220:1: entryRuleTerminalGroup returns [EObject current=null] : iv_ruleTerminalGroup= ruleTerminalGroup EOF ;
    public final EObject entryRuleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalGroup = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1220:55: (iv_ruleTerminalGroup= ruleTerminalGroup EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1221:2: iv_ruleTerminalGroup= ruleTerminalGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalGroup().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup2599);
            iv_ruleTerminalGroup=ruleTerminalGroup();
            _fsp--;

             current =iv_ruleTerminalGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalGroup2609); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1228:1: ruleTerminalGroup returns [EObject current=null] : (this_TerminalToken_0= ruleTerminalToken ( () (lv_abstractTokens_2= ruleTerminalToken ) )* ) ;
    public final EObject ruleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalToken_0 = null;

        EObject lv_abstractTokens_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1233:6: ( (this_TerminalToken_0= ruleTerminalToken ( () (lv_abstractTokens_2= ruleTerminalToken ) )* ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1234:1: (this_TerminalToken_0= ruleTerminalToken ( () (lv_abstractTokens_2= ruleTerminalToken ) )* )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1234:1: (this_TerminalToken_0= ruleTerminalToken ( () (lv_abstractTokens_2= ruleTerminalToken ) )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1235:5: this_TerminalToken_0= ruleTerminalToken ( () (lv_abstractTokens_2= ruleTerminalToken ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.prTerminalGroup().ele0ParserRuleCallTerminalToken(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2656);
            this_TerminalToken_0=ruleTerminalToken();
            _fsp--;

             
                    current = this_TerminalToken_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1243:1: ( () (lv_abstractTokens_2= ruleTerminalToken ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=RULE_ID && LA25_0<=RULE_STRING)||LA25_0==15||LA25_0==18||(LA25_0>=39 && LA25_0<=40)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1243:2: () (lv_abstractTokens_2= ruleTerminalToken )
            	    {
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1243:2: ()
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1244:5: 
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

            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1259:2: (lv_abstractTokens_2= ruleTerminalToken )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1262:6: lv_abstractTokens_2= ruleTerminalToken
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prTerminalGroup().ele110ParserRuleCallTerminalToken(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2699);
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
            	    break loop25;
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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1289:1: entryRuleAbstractToken returns [EObject current=null] : iv_ruleAbstractToken= ruleAbstractToken EOF ;
    public final EObject entryRuleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractToken = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1289:55: (iv_ruleAbstractToken= ruleAbstractToken EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1290:2: iv_ruleAbstractToken= ruleAbstractToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken2740);
            iv_ruleAbstractToken=ruleAbstractToken();
            _fsp--;

             current =iv_ruleAbstractToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractToken2750); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1297:1: ruleAbstractToken returns [EObject current=null] : ( ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal ) (lv_cardinality_3= ( ( '?' | '*' ) | '+' ) )? ) ;
    public final EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_3=null;
        EObject this_Assignment_0 = null;

        EObject this_Action_1 = null;

        EObject this_AbstractTerminal_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1302:6: ( ( ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal ) (lv_cardinality_3= ( ( '?' | '*' ) | '+' ) )? ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1303:1: ( ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal ) (lv_cardinality_3= ( ( '?' | '*' ) | '+' ) )? )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1303:1: ( ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal ) (lv_cardinality_3= ( ( '?' | '*' ) | '+' ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1303:2: ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal ) (lv_cardinality_3= ( ( '?' | '*' ) | '+' ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1303:2: ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal )
            int alt27=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA27_1 = input.LA(2);

                if ( ((LA27_1>=33 && LA27_1<=35)) ) {
                    alt27=1;
                }
                else if ( (LA27_1==EOF||(LA27_1>=RULE_ID && LA27_1<=RULE_STRING)||LA27_1==15||LA27_1==17||LA27_1==26||(LA27_1>=29 && LA27_1<=32)||LA27_1==36||LA27_1==42) ) {
                    alt27=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1303:2: ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal )", 27, 1, input);

                    throw nvae;
                }
                }
                break;
            case 36:
                {
                alt27=1;
                }
                break;
            case RULE_STRING:
            case 15:
            case 42:
                {
                alt27=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1303:2: ( (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction ) | this_AbstractTerminal_2= ruleAbstractTerminal )", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1303:3: (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1303:3: (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==RULE_ID) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==36) ) {
                        alt26=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1303:3: (this_Assignment_0= ruleAssignment | this_Action_1= ruleAction )", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1304:5: this_Assignment_0= ruleAssignment
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prAbstractToken().ele000ParserRuleCallAssignment(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleAssignment_in_ruleAbstractToken2799);
                            this_Assignment_0=ruleAssignment();
                            _fsp--;

                             
                                    current = this_Assignment_0; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1314:5: this_Action_1= ruleAction
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prAbstractToken().ele001ParserRuleCallAction(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleAction_in_ruleAbstractToken2826);
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
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1324:5: this_AbstractTerminal_2= ruleAbstractTerminal
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractToken().ele01ParserRuleCallAbstractTerminal(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken2854);
                    this_AbstractTerminal_2=ruleAbstractTerminal();
                    _fsp--;

                     
                            current = this_AbstractTerminal_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1332:2: (lv_cardinality_3= ( ( '?' | '*' ) | '+' ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=30 && LA30_0<=32)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1334:6: lv_cardinality_3= ( ( '?' | '*' ) | '+' )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1334:23: ( ( '?' | '*' ) | '+' )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( ((LA29_0>=30 && LA29_0<=31)) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==32) ) {
                        alt29=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1334:23: ( ( '?' | '*' ) | '+' )", 29, 0, input);

                        throw nvae;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1334:24: ( '?' | '*' )
                            {
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1334:24: ( '?' | '*' )
                            int alt28=2;
                            int LA28_0 = input.LA(1);

                            if ( (LA28_0==30) ) {
                                alt28=1;
                            }
                            else if ( (LA28_0==31) ) {
                                alt28=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1334:24: ( '?' | '*' )", 28, 0, input);

                                throw nvae;
                            }
                            switch (alt28) {
                                case 1 :
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1334:25: '?'
                                    {
                                    match(input,30,FOLLOW_30_in_ruleAbstractToken2877); 

                                            createLeafNode(grammarAccess.prAbstractToken().ele1000KeywordQuestionMark(), "cardinality"); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1340:6: '*'
                                    {
                                    match(input,31,FOLLOW_31_in_ruleAbstractToken2893); 

                                            createLeafNode(grammarAccess.prAbstractToken().ele1001KeywordAsterisk(), "cardinality"); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1347:6: '+'
                            {
                            match(input,32,FOLLOW_32_in_ruleAbstractToken2911); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1376:1: entryRuleTerminalToken returns [EObject current=null] : iv_ruleTerminalToken= ruleTerminalToken EOF ;
    public final EObject entryRuleTerminalToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalToken = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1376:55: (iv_ruleTerminalToken= ruleTerminalToken EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1377:2: iv_ruleTerminalToken= ruleTerminalToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken2962);
            iv_ruleTerminalToken=ruleTerminalToken();
            _fsp--;

             current =iv_ruleTerminalToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalToken2972); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1384:1: ruleTerminalToken returns [EObject current=null] : (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( ( '?' | '*' ) | '+' ) )? ) ;
    public final EObject ruleTerminalToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_1=null;
        EObject this_TerminalTokenElement_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1389:6: ( (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( ( '?' | '*' ) | '+' ) )? ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1390:1: (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( ( '?' | '*' ) | '+' ) )? )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1390:1: (this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( ( '?' | '*' ) | '+' ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1391:5: this_TerminalTokenElement_0= ruleTerminalTokenElement (lv_cardinality_1= ( ( '?' | '*' ) | '+' ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.prTerminalToken().ele0ParserRuleCallTerminalTokenElement(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken3019);
            this_TerminalTokenElement_0=ruleTerminalTokenElement();
            _fsp--;

             
                    current = this_TerminalTokenElement_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1399:1: (lv_cardinality_1= ( ( '?' | '*' ) | '+' ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=30 && LA33_0<=32)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1401:6: lv_cardinality_1= ( ( '?' | '*' ) | '+' )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1401:23: ( ( '?' | '*' ) | '+' )
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( ((LA32_0>=30 && LA32_0<=31)) ) {
                        alt32=1;
                    }
                    else if ( (LA32_0==32) ) {
                        alt32=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1401:23: ( ( '?' | '*' ) | '+' )", 32, 0, input);

                        throw nvae;
                    }
                    switch (alt32) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1401:24: ( '?' | '*' )
                            {
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1401:24: ( '?' | '*' )
                            int alt31=2;
                            int LA31_0 = input.LA(1);

                            if ( (LA31_0==30) ) {
                                alt31=1;
                            }
                            else if ( (LA31_0==31) ) {
                                alt31=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1401:24: ( '?' | '*' )", 31, 0, input);

                                throw nvae;
                            }
                            switch (alt31) {
                                case 1 :
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1401:25: '?'
                                    {
                                    match(input,30,FOLLOW_30_in_ruleTerminalToken3041); 

                                            createLeafNode(grammarAccess.prTerminalToken().ele1000KeywordQuestionMark(), "cardinality"); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1407:6: '*'
                                    {
                                    match(input,31,FOLLOW_31_in_ruleTerminalToken3057); 

                                            createLeafNode(grammarAccess.prTerminalToken().ele1001KeywordAsterisk(), "cardinality"); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1414:6: '+'
                            {
                            match(input,32,FOLLOW_32_in_ruleTerminalToken3075); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1443:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1443:52: (iv_ruleAssignment= ruleAssignment EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1444:2: iv_ruleAssignment= ruleAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAssignment().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment3126);
            iv_ruleAssignment=ruleAssignment();
            _fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment3136); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1451:1: ruleAssignment returns [EObject current=null] : ( ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal_2= ruleAbstractTerminal ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature_0=null;
        Token lv_operator_1=null;
        EObject lv_terminal_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1456:6: ( ( ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal_2= ruleAbstractTerminal ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1457:1: ( ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal_2= ruleAbstractTerminal ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1457:1: ( ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal_2= ruleAbstractTerminal ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1457:2: ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal_2= ruleAbstractTerminal )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1457:2: ( (lv_feature_0= RULE_ID ) (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1457:3: (lv_feature_0= RULE_ID ) (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1457:3: (lv_feature_0= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1459:6: lv_feature_0= RULE_ID
            {
            lv_feature_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignment3184); 

            		createLeafNode(grammarAccess.prAssignment().ele000LexerRuleCallID(), "feature"); 
            	

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

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1477:2: (lv_operator_1= ( ( '+=' | '=' ) | '?=' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1479:6: lv_operator_1= ( ( '+=' | '=' ) | '?=' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1479:20: ( ( '+=' | '=' ) | '?=' )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=33 && LA35_0<=34)) ) {
                alt35=1;
            }
            else if ( (LA35_0==35) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1479:20: ( ( '+=' | '=' ) | '?=' )", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1479:21: ( '+=' | '=' )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1479:21: ( '+=' | '=' )
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==33) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==34) ) {
                        alt34=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1479:21: ( '+=' | '=' )", 34, 0, input);

                        throw nvae;
                    }
                    switch (alt34) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1479:22: '+='
                            {
                            match(input,33,FOLLOW_33_in_ruleAssignment3215); 

                                    createLeafNode(grammarAccess.prAssignment().ele01000KeywordPlusSignEqualsSign(), "operator"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1485:6: '='
                            {
                            match(input,34,FOLLOW_34_in_ruleAssignment3231); 

                                    createLeafNode(grammarAccess.prAssignment().ele01001KeywordEqualsSign(), "operator"); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1492:6: '?='
                    {
                    match(input,35,FOLLOW_35_in_ruleAssignment3249); 

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

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1512:3: (lv_terminal_2= ruleAbstractTerminal )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1515:6: lv_terminal_2= ruleAbstractTerminal
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prAssignment().ele10ParserRuleCallAbstractTerminal(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAssignment3299);
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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1542:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1542:48: (iv_ruleAction= ruleAction EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1543:2: iv_ruleAction= ruleAction EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAction().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAction_in_entryRuleAction3338);
            iv_ruleAction=ruleAction();
            _fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAction3348); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1550:1: ruleAction returns [EObject current=null] : ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) ) 'current' ) '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_feature_5=null;
        Token lv_operator_6=null;
        EObject lv_typeName_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1555:6: ( ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) ) 'current' ) '}' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1556:1: ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) ) 'current' ) '}' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1556:1: ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) ) 'current' ) '}' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1556:2: ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) ) 'current' ) '}'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1556:2: ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) ) 'current' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1556:3: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) ) 'current'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1556:3: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1556:4: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) ) (lv_operator_6= ( '=' | '+=' ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1556:4: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1556:5: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' ) (lv_feature_5= RULE_ID )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1556:5: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1556:6: ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) ) '.'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1556:6: ( ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1556:7: ( '{' ( 'current' '=' )? ) (lv_typeName_3= ruleTypeRef )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1556:7: ( '{' ( 'current' '=' )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1556:8: '{' ( 'current' '=' )?
            {
            match(input,36,FOLLOW_36_in_ruleAction3388); 

                    createLeafNode(grammarAccess.prAction().ele0000000KeywordLeftCurlyBracket(), null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1560:1: ( 'current' '=' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==37) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1560:2: 'current' '='
                    {
                    match(input,37,FOLLOW_37_in_ruleAction3398); 

                            createLeafNode(grammarAccess.prAction().ele00000010KeywordCurrent(), null); 
                        
                    match(input,34,FOLLOW_34_in_ruleAction3407); 

                            createLeafNode(grammarAccess.prAction().ele00000011KeywordEqualsSign(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1568:4: (lv_typeName_3= ruleTypeRef )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1571:6: lv_typeName_3= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prAction().ele0000010ParserRuleCallTypeRef(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAction3444);
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

            match(input,18,FOLLOW_18_in_ruleAction3458); 

                    createLeafNode(grammarAccess.prAction().ele00001KeywordFullStop(), null); 
                

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1593:2: (lv_feature_5= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1595:6: lv_feature_5= RULE_ID
            {
            lv_feature_5=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAction3481); 

            		createLeafNode(grammarAccess.prAction().ele00010LexerRuleCallID(), "feature"); 
            	

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

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1613:3: (lv_operator_6= ( '=' | '+=' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1615:6: lv_operator_6= ( '=' | '+=' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1615:20: ( '=' | '+=' )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==34) ) {
                alt37=1;
            }
            else if ( (LA37_0==33) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1615:20: ( '=' | '+=' )", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1615:21: '='
                    {
                    match(input,34,FOLLOW_34_in_ruleAction3512); 

                            createLeafNode(grammarAccess.prAction().ele00100KeywordEqualsSign(), "operator"); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1621:6: '+='
                    {
                    match(input,33,FOLLOW_33_in_ruleAction3528); 

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

            match(input,37,FOLLOW_37_in_ruleAction3553); 

                    createLeafNode(grammarAccess.prAction().ele01KeywordCurrent(), null); 
                

            }

            match(input,38,FOLLOW_38_in_ruleAction3563); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1658:1: entryRuleAbstractTerminal returns [EObject current=null] : iv_ruleAbstractTerminal= ruleAbstractTerminal EOF ;
    public final EObject entryRuleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTerminal = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1658:58: (iv_ruleAbstractTerminal= ruleAbstractTerminal EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1659:2: iv_ruleAbstractTerminal= ruleAbstractTerminal EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractTerminal().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal3598);
            iv_ruleAbstractTerminal=ruleAbstractTerminal();
            _fsp--;

             current =iv_ruleAbstractTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractTerminal3608); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1666:1: ruleAbstractTerminal returns [EObject current=null] : ( ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement ) | this_CrossReference_3= ruleCrossReference ) ;
    public final EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedElement_2 = null;

        EObject this_CrossReference_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1671:6: ( ( ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement ) | this_CrossReference_3= ruleCrossReference ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1672:1: ( ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement ) | this_CrossReference_3= ruleCrossReference )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1672:1: ( ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement ) | this_CrossReference_3= ruleCrossReference )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_ID && LA40_0<=RULE_STRING)||LA40_0==15) ) {
                alt40=1;
            }
            else if ( (LA40_0==42) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1672:1: ( ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement ) | this_CrossReference_3= ruleCrossReference )", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1672:2: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1672:2: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( ((LA39_0>=RULE_ID && LA39_0<=RULE_STRING)) ) {
                        alt39=1;
                    }
                    else if ( (LA39_0==15) ) {
                        alt39=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1672:2: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedElement_2= ruleParenthesizedElement )", 39, 0, input);

                        throw nvae;
                    }
                    switch (alt39) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1672:3: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )
                            {
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1672:3: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )
                            int alt38=2;
                            int LA38_0 = input.LA(1);

                            if ( (LA38_0==RULE_STRING) ) {
                                alt38=1;
                            }
                            else if ( (LA38_0==RULE_ID) ) {
                                alt38=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1672:3: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )", 38, 0, input);

                                throw nvae;
                            }
                            switch (alt38) {
                                case 1 :
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1673:5: this_Keyword_0= ruleKeyword
                                    {
                                     
                                            currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele000ParserRuleCallKeyword(), currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleKeyword_in_ruleAbstractTerminal3657);
                                    this_Keyword_0=ruleKeyword();
                                    _fsp--;

                                     
                                            current = this_Keyword_0; 
                                            currentNode = currentNode.getParent();
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1683:5: this_RuleCall_1= ruleRuleCall
                                    {
                                     
                                            currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele001ParserRuleCallRuleCall(), currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleRuleCall_in_ruleAbstractTerminal3684);
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
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1693:5: this_ParenthesizedElement_2= ruleParenthesizedElement
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele01ParserRuleCallParenthesizedElement(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal3712);
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
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1703:5: this_CrossReference_3= ruleCrossReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractTerminal().ele1ParserRuleCallCrossReference(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCrossReference_in_ruleAbstractTerminal3740);
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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1720:1: entryRuleTerminalTokenElement returns [EObject current=null] : iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF ;
    public final EObject entryRuleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalTokenElement = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1720:62: (iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1721:2: iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerminalTokenElement().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement3774);
            iv_ruleTerminalTokenElement=ruleTerminalTokenElement();
            _fsp--;

             current =iv_ruleTerminalTokenElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalTokenElement3784); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1728:1: ruleTerminalTokenElement returns [EObject current=null] : ( ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken ) | this_Wildcard_4= ruleWildcard ) ;
    public final EObject ruleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject this_CharacterRange_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedTerminalElement_2 = null;

        EObject this_AbstractNegatedToken_3 = null;

        EObject this_Wildcard_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1733:6: ( ( ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken ) | this_Wildcard_4= ruleWildcard ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1734:1: ( ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken ) | this_Wildcard_4= ruleWildcard )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1734:1: ( ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken ) | this_Wildcard_4= ruleWildcard )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=RULE_ID && LA44_0<=RULE_STRING)||LA44_0==15||(LA44_0>=39 && LA44_0<=40)) ) {
                alt44=1;
            }
            else if ( (LA44_0==18) ) {
                alt44=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1734:1: ( ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken ) | this_Wildcard_4= ruleWildcard )", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1734:2: ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1734:2: ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken )
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( ((LA43_0>=RULE_ID && LA43_0<=RULE_STRING)||LA43_0==15) ) {
                        alt43=1;
                    }
                    else if ( ((LA43_0>=39 && LA43_0<=40)) ) {
                        alt43=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1734:2: ( ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken_3= ruleAbstractNegatedToken )", 43, 0, input);

                        throw nvae;
                    }
                    switch (alt43) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1734:3: ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement )
                            {
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1734:3: ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement )
                            int alt42=2;
                            int LA42_0 = input.LA(1);

                            if ( ((LA42_0>=RULE_ID && LA42_0<=RULE_STRING)) ) {
                                alt42=1;
                            }
                            else if ( (LA42_0==15) ) {
                                alt42=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1734:3: ( (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall ) | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement )", 42, 0, input);

                                throw nvae;
                            }
                            switch (alt42) {
                                case 1 :
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1734:4: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall )
                                    {
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1734:4: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall )
                                    int alt41=2;
                                    int LA41_0 = input.LA(1);

                                    if ( (LA41_0==RULE_STRING) ) {
                                        alt41=1;
                                    }
                                    else if ( (LA41_0==RULE_ID) ) {
                                        alt41=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("1734:4: (this_CharacterRange_0= ruleCharacterRange | this_RuleCall_1= ruleRuleCall )", 41, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt41) {
                                        case 1 :
                                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1735:5: this_CharacterRange_0= ruleCharacterRange
                                            {
                                             
                                                    currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele0000ParserRuleCallCharacterRange(), currentNode); 
                                                
                                            pushFollow(FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement3834);
                                            this_CharacterRange_0=ruleCharacterRange();
                                            _fsp--;

                                             
                                                    current = this_CharacterRange_0; 
                                                    currentNode = currentNode.getParent();
                                                

                                            }
                                            break;
                                        case 2 :
                                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1745:5: this_RuleCall_1= ruleRuleCall
                                            {
                                             
                                                    currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele0001ParserRuleCallRuleCall(), currentNode); 
                                                
                                            pushFollow(FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement3861);
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
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1755:5: this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement
                                    {
                                     
                                            currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele001ParserRuleCallParenthesizedTerminalElement(), currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement3889);
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
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1765:5: this_AbstractNegatedToken_3= ruleAbstractNegatedToken
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele01ParserRuleCallAbstractNegatedToken(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement3917);
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
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1775:5: this_Wildcard_4= ruleWildcard
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prTerminalTokenElement().ele1ParserRuleCallWildcard(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleWildcard_in_ruleTerminalTokenElement3945);
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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1792:1: entryRuleAbstractNegatedToken returns [EObject current=null] : iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF ;
    public final EObject entryRuleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractNegatedToken = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1792:62: (iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1793:2: iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractNegatedToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken3979);
            iv_ruleAbstractNegatedToken=ruleAbstractNegatedToken();
            _fsp--;

             current =iv_ruleAbstractNegatedToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractNegatedToken3989); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1800:1: ruleAbstractNegatedToken returns [EObject current=null] : (this_NegatedToken_0= ruleNegatedToken | this_UpToToken_1= ruleUpToToken ) ;
    public final EObject ruleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject this_NegatedToken_0 = null;

        EObject this_UpToToken_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1805:6: ( (this_NegatedToken_0= ruleNegatedToken | this_UpToToken_1= ruleUpToToken ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1806:1: (this_NegatedToken_0= ruleNegatedToken | this_UpToToken_1= ruleUpToToken )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1806:1: (this_NegatedToken_0= ruleNegatedToken | this_UpToToken_1= ruleUpToToken )
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
                    new NoViableAltException("1806:1: (this_NegatedToken_0= ruleNegatedToken | this_UpToToken_1= ruleUpToToken )", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1807:5: this_NegatedToken_0= ruleNegatedToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractNegatedToken().ele0ParserRuleCallNegatedToken(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken4036);
                    this_NegatedToken_0=ruleNegatedToken();
                    _fsp--;

                     
                            current = this_NegatedToken_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1817:5: this_UpToToken_1= ruleUpToToken
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractNegatedToken().ele1ParserRuleCallUpToToken(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUpToToken_in_ruleAbstractNegatedToken4063);
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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1834:1: entryRuleNegatedToken returns [EObject current=null] : iv_ruleNegatedToken= ruleNegatedToken EOF ;
    public final EObject entryRuleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegatedToken = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1834:54: (iv_ruleNegatedToken= ruleNegatedToken EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1835:2: iv_ruleNegatedToken= ruleNegatedToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prNegatedToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken4097);
            iv_ruleNegatedToken=ruleNegatedToken();
            _fsp--;

             current =iv_ruleNegatedToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegatedToken4107); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1842:1: ruleNegatedToken returns [EObject current=null] : ( '!' (lv_terminal_1= ruleTerminalTokenElement ) ) ;
    public final EObject ruleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1847:6: ( ( '!' (lv_terminal_1= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1848:1: ( '!' (lv_terminal_1= ruleTerminalTokenElement ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1848:1: ( '!' (lv_terminal_1= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1848:2: '!' (lv_terminal_1= ruleTerminalTokenElement )
            {
            match(input,39,FOLLOW_39_in_ruleNegatedToken4141); 

                    createLeafNode(grammarAccess.prNegatedToken().ele0KeywordExclamationMark(), null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1852:1: (lv_terminal_1= ruleTerminalTokenElement )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1855:6: lv_terminal_1= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prNegatedToken().ele10ParserRuleCallTerminalTokenElement(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken4175);
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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1882:1: entryRuleUpToToken returns [EObject current=null] : iv_ruleUpToToken= ruleUpToToken EOF ;
    public final EObject entryRuleUpToToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpToToken = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1882:51: (iv_ruleUpToToken= ruleUpToToken EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1883:2: iv_ruleUpToToken= ruleUpToToken EOF
            {
             currentNode = createCompositeNode(grammarAccess.prUpToToken().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleUpToToken_in_entryRuleUpToToken4214);
            iv_ruleUpToToken=ruleUpToToken();
            _fsp--;

             current =iv_ruleUpToToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUpToToken4224); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1890:1: ruleUpToToken returns [EObject current=null] : ( '->' (lv_terminal_1= ruleTerminalTokenElement ) ) ;
    public final EObject ruleUpToToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1895:6: ( ( '->' (lv_terminal_1= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1896:1: ( '->' (lv_terminal_1= ruleTerminalTokenElement ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1896:1: ( '->' (lv_terminal_1= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1896:2: '->' (lv_terminal_1= ruleTerminalTokenElement )
            {
            match(input,40,FOLLOW_40_in_ruleUpToToken4258); 

                    createLeafNode(grammarAccess.prUpToToken().ele0KeywordHyphenMinusGreaterThanSign(), null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1900:1: (lv_terminal_1= ruleTerminalTokenElement )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1903:6: lv_terminal_1= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prUpToToken().ele10ParserRuleCallTerminalTokenElement(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleUpToToken4292);
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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1930:1: entryRuleWildcard returns [EObject current=null] : iv_ruleWildcard= ruleWildcard EOF ;
    public final EObject entryRuleWildcard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcard = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1930:50: (iv_ruleWildcard= ruleWildcard EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1931:2: iv_ruleWildcard= ruleWildcard EOF
            {
             currentNode = createCompositeNode(grammarAccess.prWildcard().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleWildcard_in_entryRuleWildcard4331);
            iv_ruleWildcard=ruleWildcard();
            _fsp--;

             current =iv_ruleWildcard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWildcard4341); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1938:1: ruleWildcard returns [EObject current=null] : (lv_isWildcard_0= '.' ) ;
    public final EObject ruleWildcard() throws RecognitionException {
        EObject current = null;

        Token lv_isWildcard_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1943:6: ( (lv_isWildcard_0= '.' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1944:1: (lv_isWildcard_0= '.' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1944:1: (lv_isWildcard_0= '.' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1946:6: lv_isWildcard_0= '.'
            {
            lv_isWildcard_0=(Token)input.LT(1);
            match(input,18,FOLLOW_18_in_ruleWildcard4386); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1974:1: entryRuleCharacterRange returns [EObject current=null] : iv_ruleCharacterRange= ruleCharacterRange EOF ;
    public final EObject entryRuleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterRange = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1974:56: (iv_ruleCharacterRange= ruleCharacterRange EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1975:2: iv_ruleCharacterRange= ruleCharacterRange EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCharacterRange().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange4433);
            iv_ruleCharacterRange=ruleCharacterRange();
            _fsp--;

             current =iv_ruleCharacterRange; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCharacterRange4443); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1982:1: ruleCharacterRange returns [EObject current=null] : (this_Keyword_0= ruleKeyword ( ( () '..' ) (lv_right_3= ruleKeyword ) )? ) ;
    public final EObject ruleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject lv_right_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1987:6: ( (this_Keyword_0= ruleKeyword ( ( () '..' ) (lv_right_3= ruleKeyword ) )? ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1988:1: (this_Keyword_0= ruleKeyword ( ( () '..' ) (lv_right_3= ruleKeyword ) )? )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1988:1: (this_Keyword_0= ruleKeyword ( ( () '..' ) (lv_right_3= ruleKeyword ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1989:5: this_Keyword_0= ruleKeyword ( ( () '..' ) (lv_right_3= ruleKeyword ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.prCharacterRange().ele0ParserRuleCallKeyword(), currentNode); 
                
            pushFollow(FOLLOW_ruleKeyword_in_ruleCharacterRange4490);
            this_Keyword_0=ruleKeyword();
            _fsp--;

             
                    current = this_Keyword_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1997:1: ( ( () '..' ) (lv_right_3= ruleKeyword ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==41) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1997:2: ( () '..' ) (lv_right_3= ruleKeyword )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1997:2: ( () '..' )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1997:3: () '..'
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1997:3: ()
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1998:5: 
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

                    match(input,41,FOLLOW_41_in_ruleCharacterRange4509); 

                            createLeafNode(grammarAccess.prCharacterRange().ele101KeywordFullStopFullStop(), null); 
                        

                    }

                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2017:2: (lv_right_3= ruleKeyword )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2020:6: lv_right_3= ruleKeyword
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prCharacterRange().ele110ParserRuleCallKeyword(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleKeyword_in_ruleCharacterRange4544);
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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2047:1: entryRuleCrossReference returns [EObject current=null] : iv_ruleCrossReference= ruleCrossReference EOF ;
    public final EObject entryRuleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReference = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2047:56: (iv_ruleCrossReference= ruleCrossReference EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2048:2: iv_ruleCrossReference= ruleCrossReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCrossReference().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCrossReference_in_entryRuleCrossReference4585);
            iv_ruleCrossReference=ruleCrossReference();
            _fsp--;

             current =iv_ruleCrossReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReference4595); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2055:1: ruleCrossReference returns [EObject current=null] : ( ( ( '[' (lv_type_1= ruleTypeRef ) ) ( '|' ( RULE_ID ) )? ) ']' ) ;
    public final EObject ruleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject lv_type_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2060:6: ( ( ( ( '[' (lv_type_1= ruleTypeRef ) ) ( '|' ( RULE_ID ) )? ) ']' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2061:1: ( ( ( '[' (lv_type_1= ruleTypeRef ) ) ( '|' ( RULE_ID ) )? ) ']' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2061:1: ( ( ( '[' (lv_type_1= ruleTypeRef ) ) ( '|' ( RULE_ID ) )? ) ']' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2061:2: ( ( '[' (lv_type_1= ruleTypeRef ) ) ( '|' ( RULE_ID ) )? ) ']'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2061:2: ( ( '[' (lv_type_1= ruleTypeRef ) ) ( '|' ( RULE_ID ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2061:3: ( '[' (lv_type_1= ruleTypeRef ) ) ( '|' ( RULE_ID ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2061:3: ( '[' (lv_type_1= ruleTypeRef ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2061:4: '[' (lv_type_1= ruleTypeRef )
            {
            match(input,42,FOLLOW_42_in_ruleCrossReference4631); 

                    createLeafNode(grammarAccess.prCrossReference().ele000KeywordLeftSquareBracket(), null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2065:1: (lv_type_1= ruleTypeRef )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2068:6: lv_type_1= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prCrossReference().ele0010ParserRuleCallTypeRef(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleCrossReference4665);
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

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2086:3: ( '|' ( RULE_ID ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==29) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2086:4: '|' ( RULE_ID )
                    {
                    match(input,29,FOLLOW_29_in_ruleCrossReference4680); 

                            createLeafNode(grammarAccess.prCrossReference().ele010KeywordVerticalLine(), null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2090:1: ( RULE_ID )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2093:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.prCrossReference().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCrossReference4702); 

                    		createLeafNode(grammarAccess.prCrossReference().ele0110CrossReferenceEStringAbstractRule(), "rule"); 
                    	

                    }


                    }
                    break;

            }


            }

            match(input,43,FOLLOW_43_in_ruleCrossReference4717); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2119:1: entryRuleParenthesizedElement returns [EObject current=null] : iv_ruleParenthesizedElement= ruleParenthesizedElement EOF ;
    public final EObject entryRuleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedElement = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2119:62: (iv_ruleParenthesizedElement= ruleParenthesizedElement EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2120:2: iv_ruleParenthesizedElement= ruleParenthesizedElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.prParenthesizedElement().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement4752);
            iv_ruleParenthesizedElement=ruleParenthesizedElement();
            _fsp--;

             current =iv_ruleParenthesizedElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedElement4762); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2127:1: ruleParenthesizedElement returns [EObject current=null] : ( ( '(' this_Alternatives_1= ruleAlternatives ) ')' ) ;
    public final EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Alternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2132:6: ( ( ( '(' this_Alternatives_1= ruleAlternatives ) ')' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2133:1: ( ( '(' this_Alternatives_1= ruleAlternatives ) ')' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2133:1: ( ( '(' this_Alternatives_1= ruleAlternatives ) ')' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2133:2: ( '(' this_Alternatives_1= ruleAlternatives ) ')'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2133:2: ( '(' this_Alternatives_1= ruleAlternatives )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2133:3: '(' this_Alternatives_1= ruleAlternatives
            {
            match(input,15,FOLLOW_15_in_ruleParenthesizedElement4797); 

                    createLeafNode(grammarAccess.prParenthesizedElement().ele00KeywordLeftParenthesis(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.prParenthesizedElement().ele01ParserRuleCallAlternatives(), currentNode); 
                
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesizedElement4819);
            this_Alternatives_1=ruleAlternatives();
            _fsp--;

             
                    current = this_Alternatives_1; 
                    currentNode = currentNode.getParent();
                

            }

            match(input,17,FOLLOW_17_in_ruleParenthesizedElement4828); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2159:1: entryRuleParenthesizedTerminalElement returns [EObject current=null] : iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF ;
    public final EObject entryRuleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedTerminalElement = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2159:70: (iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2160:2: iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.prParenthesizedTerminalElement().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4863);
            iv_ruleParenthesizedTerminalElement=ruleParenthesizedTerminalElement();
            _fsp--;

             current =iv_ruleParenthesizedTerminalElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4873); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2167:1: ruleParenthesizedTerminalElement returns [EObject current=null] : ( ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ) ')' ) ;
    public final EObject ruleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalAlternatives_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2172:6: ( ( ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ) ')' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2173:1: ( ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ) ')' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2173:1: ( ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ) ')' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2173:2: ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives ) ')'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2173:2: ( '(' this_TerminalAlternatives_1= ruleTerminalAlternatives )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2173:3: '(' this_TerminalAlternatives_1= ruleTerminalAlternatives
            {
            match(input,15,FOLLOW_15_in_ruleParenthesizedTerminalElement4908); 

                    createLeafNode(grammarAccess.prParenthesizedTerminalElement().ele00KeywordLeftParenthesis(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.prParenthesizedTerminalElement().ele01ParserRuleCallTerminalAlternatives(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4930);
            this_TerminalAlternatives_1=ruleTerminalAlternatives();
            _fsp--;

             
                    current = this_TerminalAlternatives_1; 
                    currentNode = currentNode.getParent();
                

            }

            match(input,17,FOLLOW_17_in_ruleParenthesizedTerminalElement4939); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2199:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2199:49: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2200:2: iv_ruleKeyword= ruleKeyword EOF
            {
             currentNode = createCompositeNode(grammarAccess.prKeyword().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword4974);
            iv_ruleKeyword=ruleKeyword();
            _fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword4984); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2207:1: ruleKeyword returns [EObject current=null] : (lv_value_0= RULE_STRING ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2212:6: ( (lv_value_0= RULE_STRING ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2213:1: (lv_value_0= RULE_STRING )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2213:1: (lv_value_0= RULE_STRING )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2215:6: lv_value_0= RULE_STRING
            {
            lv_value_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword5030); 

            		createLeafNode(grammarAccess.prKeyword().ele0LexerRuleCallSTRING(), "value"); 
            	

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2242:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2242:50: (iv_ruleRuleCall= ruleRuleCall EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2243:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.prRuleCall().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleRuleCall_in_entryRuleRuleCall5072);
            iv_ruleRuleCall=ruleRuleCall();
            _fsp--;

             current =iv_ruleRuleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleCall5082); 

            }

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2250:1: ruleRuleCall returns [EObject current=null] : ( RULE_ID ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2255:6: ( ( RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2256:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2256:1: ( RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2259:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prRuleCall().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall5128); 

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
    public static final BitSet FOLLOW_11_in_ruleGrammar133 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleGrammar156 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar191 = new BitSet(new long[]{0x0000000008E86010L});
    public static final BitSet FOLLOW_13_in_ruleGrammar206 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGrammarID_in_ruleGrammar233 = new BitSet(new long[]{0x0000000008E84010L});
    public static final BitSet FOLLOW_14_in_ruleGrammar263 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleGrammar285 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar309 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleGrammar322 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar344 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_ruleGrammar361 = new BitSet(new long[]{0x0000000008E80010L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar398 = new BitSet(new long[]{0x0000000008E80010L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleGrammar438 = new BitSet(new long[]{0x0000000008C00012L});
    public static final BitSet FOLLOW_ruleGrammarID_in_entryRuleGrammarID479 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammarID490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarID530 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleGrammarID549 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammarID564 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule611 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexerRule_in_ruleAbstractRule669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleAbstractRule696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_ruleAbstractRule724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration758 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel876 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGeneratedMetamodel886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleGeneratedMetamodel922 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel944 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel975 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleGeneratedMetamodel989 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel1011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel1056 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleReferencedMetamodel1101 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1123 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleReferencedMetamodel1137 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexerRule_in_entryRuleLexerRule1204 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexerRule1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleLexerRule1253 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_23_in_ruleLexerRule1268 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexerRule1291 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleLexerRule1310 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleLexerRule1344 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleLexerRule1360 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLexerRule1383 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleLexerRule1401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_entryRuleParserRule1436 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParserRule1446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1497 = new BitSet(new long[]{0x0000000003004000L});
    public static final BitSet FOLLOW_24_in_ruleParserRule1515 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule1549 = new BitSet(new long[]{0x0000000002004000L});
    public static final BitSet FOLLOW_14_in_ruleParserRule1580 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleParserRule1602 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1626 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleParserRule1639 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1661 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_ruleParserRule1678 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleParserRule1690 = new BitSet(new long[]{0x0000041000008030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule1725 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleParserRule1739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1774 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule1784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleTerminalRule1834 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTerminalRule1869 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleTerminalRule1888 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleTerminalRule1922 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleTerminalRule1938 = new BitSet(new long[]{0x0000018000048030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule1973 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleTerminalRule1987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef2022 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef2032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef2080 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleTypeRef2092 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef2116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives2154 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives2164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives2211 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleAlternatives2230 = new BitSet(new long[]{0x0000041000008030L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives2265 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives2306 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives2316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2363 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleTerminalAlternatives2382 = new BitSet(new long[]{0x0000018000048030L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2417 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup2458 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroup2468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup2515 = new BitSet(new long[]{0x0000041000008032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup2558 = new BitSet(new long[]{0x0000041000008032L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup2599 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup2609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2656 = new BitSet(new long[]{0x0000018000048032L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2699 = new BitSet(new long[]{0x0000018000048032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken2740 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken2750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractToken2799 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken2826 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken2854 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_30_in_ruleAbstractToken2877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleAbstractToken2893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleAbstractToken2911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken2962 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken2972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken3019 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_30_in_ruleTerminalToken3041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleTerminalToken3057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleTerminalToken3075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment3126 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment3136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment3184 = new BitSet(new long[]{0x0000000E00000000L});
    public static final BitSet FOLLOW_33_in_ruleAssignment3215 = new BitSet(new long[]{0x0000040000008030L});
    public static final BitSet FOLLOW_34_in_ruleAssignment3231 = new BitSet(new long[]{0x0000040000008030L});
    public static final BitSet FOLLOW_35_in_ruleAssignment3249 = new BitSet(new long[]{0x0000040000008030L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAssignment3299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_entryRuleAction3338 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAction3348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleAction3388 = new BitSet(new long[]{0x0000002000000010L});
    public static final BitSet FOLLOW_37_in_ruleAction3398 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleAction3407 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction3444 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleAction3458 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAction3481 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleAction3512 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_33_in_ruleAction3528 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleAction3553 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleAction3563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal3598 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal3608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal3657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal3684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal3712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_ruleAbstractTerminal3740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement3774 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement3784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement3834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement3861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement3889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement3917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_ruleTerminalTokenElement3945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken3979 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken3989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken4036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpToToken_in_ruleAbstractNegatedToken4063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken4097 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken4107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleNegatedToken4141 = new BitSet(new long[]{0x0000018000048030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken4175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpToToken_in_entryRuleUpToToken4214 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUpToToken4224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleUpToToken4258 = new BitSet(new long[]{0x0000018000048030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleUpToToken4292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard4331 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcard4341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleWildcard4386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange4433 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange4443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange4490 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleCharacterRange4509 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange4544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference4585 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference4595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleCrossReference4631 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleCrossReference4665 = new BitSet(new long[]{0x0000080020000000L});
    public static final BitSet FOLLOW_29_in_ruleCrossReference4680 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCrossReference4702 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleCrossReference4717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement4752 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement4762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedElement4797 = new BitSet(new long[]{0x0000041000008030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement4819 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleParenthesizedElement4828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4863 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedTerminalElement4908 = new BitSet(new long[]{0x0000018000048030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4930 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleParenthesizedTerminalElement4939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword4974 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword4984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword5030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall5072 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall5082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall5128 = new BitSet(new long[]{0x0000000000000002L});

}