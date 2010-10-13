package org.eclipse.xtext.example.arithmetics.parser.antlr.internal; 

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
import org.eclipse.xtext.example.arithmetics.services.ArithmeticsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalArithmeticsParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_NUMBER", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'module'", "'import'", "'.'", "'*'", "'def'", "'('", "','", "')'", "':'", "';'", "'+'", "'-'", "'/'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int T__12=12;
    public static final int RULE_ID=4;
    public static final int T__23=23;
    public static final int RULE_NUMBER=5;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=7;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__22=22;
    public static final int RULE_WS=10;
    public static final int T__17=17;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int T__16=16;
    public static final int T__24=24;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalArithmeticsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalArithmeticsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalArithmeticsParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g"; }



     	private ArithmeticsGrammarAccess grammarAccess;
     	
        public InternalArithmeticsParser(TokenStream input, IAstFactory factory, ArithmeticsGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Module";	
       	}
       	
       	@Override
       	protected ArithmeticsGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModule"
    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:71:1: entryRuleModule returns [EObject current=null] : iv_ruleModule= ruleModule EOF ;
    public final EObject entryRuleModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModule = null;


        try {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:72:2: (iv_ruleModule= ruleModule EOF )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:73:2: iv_ruleModule= ruleModule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleModule_in_entryRuleModule75);
            iv_ruleModule=ruleModule();

            state._fsp--;

             current =iv_ruleModule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModule85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModule"


    // $ANTLR start "ruleModule"
    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:80:1: ruleModule returns [EObject current=null] : (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_statements_3_0= ruleStatement ) )* ) ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_imports_2_0 = null;

        EObject lv_statements_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:85:6: ( (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_statements_3_0= ruleStatement ) )* ) )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:86:1: (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_statements_3_0= ruleStatement ) )* )
            {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:86:1: (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_statements_3_0= ruleStatement ) )* )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:86:3: otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_statements_3_0= ruleStatement ) )*
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleModule122); 

                	createLeafNode(otherlv_0, grammarAccess.getModuleAccess().getModuleKeyword_0(), null);
                
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:90:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:91:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:91:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:92:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModule139); 

            			createLeafNode(lv_name_1_0, grammarAccess.getModuleAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModuleRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:114:2: ( (lv_imports_2_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:115:1: (lv_imports_2_0= ruleImport )
            	    {
            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:115:1: (lv_imports_2_0= ruleImport )
            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:116:3: lv_imports_2_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModuleAccess().getImportsImportParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleModule165);
            	    lv_imports_2_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModuleRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"imports",
            	    	        		lv_imports_2_0, 
            	    	        		"Import", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:138:3: ( (lv_statements_3_0= ruleStatement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=RULE_ID && LA2_0<=RULE_NUMBER)||(LA2_0>=16 && LA2_0<=17)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:139:1: (lv_statements_3_0= ruleStatement )
            	    {
            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:139:1: (lv_statements_3_0= ruleStatement )
            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:140:3: lv_statements_3_0= ruleStatement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModuleAccess().getStatementsStatementParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleStatement_in_ruleModule187);
            	    lv_statements_3_0=ruleStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModuleRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"statements",
            	    	        		lv_statements_3_0, 
            	    	        		"Statement", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:170:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:171:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:172:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport224);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport234); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:179:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportName ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:184:6: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportName ) ) ) )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:185:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportName ) ) )
            {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:185:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportName ) ) )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:185:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportName ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleImport271); 

                	createLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0(), null);
                
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:189:1: ( (lv_importedNamespace_1_0= ruleImportName ) )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:190:1: (lv_importedNamespace_1_0= ruleImportName )
            {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:190:1: (lv_importedNamespace_1_0= ruleImportName )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:191:3: lv_importedNamespace_1_0= ruleImportName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleImportName_in_ruleImport292);
            lv_importedNamespace_1_0=ruleImportName();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"importedNamespace",
            	        		lv_importedNamespace_1_0, 
            	        		"ImportName", 
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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleImportName"
    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:221:1: entryRuleImportName returns [String current=null] : iv_ruleImportName= ruleImportName EOF ;
    public final String entryRuleImportName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportName = null;


        try {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:222:2: (iv_ruleImportName= ruleImportName EOF )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:223:2: iv_ruleImportName= ruleImportName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleImportName_in_entryRuleImportName329);
            iv_ruleImportName=ruleImportName();

            state._fsp--;

             current =iv_ruleImportName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportName340); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImportName"


    // $ANTLR start "ruleImportName"
    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:230:1: ruleImportName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' kw= '*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:235:6: ( (this_ID_0= RULE_ID (kw= '.' kw= '*' )? ) )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:236:1: (this_ID_0= RULE_ID (kw= '.' kw= '*' )? )
            {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:236:1: (this_ID_0= RULE_ID (kw= '.' kw= '*' )? )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:236:6: this_ID_0= RULE_ID (kw= '.' kw= '*' )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleImportName380); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(this_ID_0, grammarAccess.getImportNameAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:243:1: (kw= '.' kw= '*' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:244:2: kw= '.' kw= '*'
                    {
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleImportName399); 

                            current.merge(kw);
                            createLeafNode(kw, grammarAccess.getImportNameAccess().getFullStopKeyword_1_0(), null); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleImportName412); 

                            current.merge(kw);
                            createLeafNode(kw, grammarAccess.getImportNameAccess().getAsteriskKeyword_1_1(), null); 
                        

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
    // $ANTLR end "ruleImportName"


    // $ANTLR start "entryRuleStatement"
    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:263:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:264:2: (iv_ruleStatement= ruleStatement EOF )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:265:2: iv_ruleStatement= ruleStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleStatement_in_entryRuleStatement454);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatement464); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:272:1: ruleStatement returns [EObject current=null] : (this_Definition_0= ruleDefinition | this_Evaluation_1= ruleEvaluation ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Definition_0 = null;

        EObject this_Evaluation_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:277:6: ( (this_Definition_0= ruleDefinition | this_Evaluation_1= ruleEvaluation ) )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:278:1: (this_Definition_0= ruleDefinition | this_Evaluation_1= ruleEvaluation )
            {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:278:1: (this_Definition_0= ruleDefinition | this_Evaluation_1= ruleEvaluation )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            else if ( ((LA4_0>=RULE_ID && LA4_0<=RULE_NUMBER)||LA4_0==17) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:279:5: this_Definition_0= ruleDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getDefinitionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDefinition_in_ruleStatement511);
                    this_Definition_0=ruleDefinition();

                    state._fsp--;

                     
                            current = this_Definition_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:289:5: this_Evaluation_1= ruleEvaluation
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getEvaluationParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEvaluation_in_ruleStatement538);
                    this_Evaluation_1=ruleEvaluation();

                    state._fsp--;

                     
                            current = this_Evaluation_1; 
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
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleDefinition"
    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:305:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:306:2: (iv_ruleDefinition= ruleDefinition EOF )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:307:2: iv_ruleDefinition= ruleDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleDefinition_in_entryRuleDefinition573);
            iv_ruleDefinition=ruleDefinition();

            state._fsp--;

             current =iv_ruleDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefinition583); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefinition"


    // $ANTLR start "ruleDefinition"
    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:314:1: ruleDefinition returns [EObject current=null] : (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_args_3_0= ruleDeclaredParameter ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDeclaredParameter ) ) )* otherlv_6= ')' )? otherlv_7= ':' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_args_3_0 = null;

        EObject lv_args_5_0 = null;

        EObject lv_expr_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:319:6: ( (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_args_3_0= ruleDeclaredParameter ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDeclaredParameter ) ) )* otherlv_6= ')' )? otherlv_7= ':' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:320:1: (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_args_3_0= ruleDeclaredParameter ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDeclaredParameter ) ) )* otherlv_6= ')' )? otherlv_7= ':' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' )
            {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:320:1: (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_args_3_0= ruleDeclaredParameter ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDeclaredParameter ) ) )* otherlv_6= ')' )? otherlv_7= ':' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:320:3: otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_args_3_0= ruleDeclaredParameter ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDeclaredParameter ) ) )* otherlv_6= ')' )? otherlv_7= ':' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleDefinition620); 

                	createLeafNode(otherlv_0, grammarAccess.getDefinitionAccess().getDefKeyword_0(), null);
                
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:324:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:325:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:325:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:326:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition637); 

            			createLeafNode(lv_name_1_0, grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDefinitionRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:348:2: (otherlv_2= '(' ( (lv_args_3_0= ruleDeclaredParameter ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDeclaredParameter ) ) )* otherlv_6= ')' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:348:4: otherlv_2= '(' ( (lv_args_3_0= ruleDeclaredParameter ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDeclaredParameter ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleDefinition655); 

                        	createLeafNode(otherlv_2, grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_2_0(), null);
                        
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:352:1: ( (lv_args_3_0= ruleDeclaredParameter ) )
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:353:1: (lv_args_3_0= ruleDeclaredParameter )
                    {
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:353:1: (lv_args_3_0= ruleDeclaredParameter )
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:354:3: lv_args_3_0= ruleDeclaredParameter
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDefinitionAccess().getArgsDeclaredParameterParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDeclaredParameter_in_ruleDefinition676);
                    lv_args_3_0=ruleDeclaredParameter();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getDefinitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"args",
                    	        		lv_args_3_0, 
                    	        		"DeclaredParameter", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:376:2: (otherlv_4= ',' ( (lv_args_5_0= ruleDeclaredParameter ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==18) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:376:4: otherlv_4= ',' ( (lv_args_5_0= ruleDeclaredParameter ) )
                    	    {
                    	    otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleDefinition689); 

                    	        	createLeafNode(otherlv_4, grammarAccess.getDefinitionAccess().getCommaKeyword_2_2_0(), null);
                    	        
                    	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:380:1: ( (lv_args_5_0= ruleDeclaredParameter ) )
                    	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:381:1: (lv_args_5_0= ruleDeclaredParameter )
                    	    {
                    	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:381:1: (lv_args_5_0= ruleDeclaredParameter )
                    	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:382:3: lv_args_5_0= ruleDeclaredParameter
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getDefinitionAccess().getArgsDeclaredParameterParserRuleCall_2_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleDeclaredParameter_in_ruleDefinition710);
                    	    lv_args_5_0=ruleDeclaredParameter();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getDefinitionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"args",
                    	    	        		lv_args_5_0, 
                    	    	        		"DeclaredParameter", 
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
                    	    break loop5;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,19,FOLLOW_19_in_ruleDefinition724); 

                        	createLeafNode(otherlv_6, grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_2_3(), null);
                        

                    }
                    break;

            }

            otherlv_7=(Token)match(input,20,FOLLOW_20_in_ruleDefinition738); 

                	createLeafNode(otherlv_7, grammarAccess.getDefinitionAccess().getColonKeyword_3(), null);
                
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:412:1: ( (lv_expr_8_0= ruleExpression ) )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:413:1: (lv_expr_8_0= ruleExpression )
            {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:413:1: (lv_expr_8_0= ruleExpression )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:414:3: lv_expr_8_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDefinitionAccess().getExprExpressionParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleDefinition759);
            lv_expr_8_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expr",
            	        		lv_expr_8_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            otherlv_9=(Token)match(input,21,FOLLOW_21_in_ruleDefinition771); 

                	createLeafNode(otherlv_9, grammarAccess.getDefinitionAccess().getSemicolonKeyword_5(), null);
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefinition"


    // $ANTLR start "entryRuleDeclaredParameter"
    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:448:1: entryRuleDeclaredParameter returns [EObject current=null] : iv_ruleDeclaredParameter= ruleDeclaredParameter EOF ;
    public final EObject entryRuleDeclaredParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaredParameter = null;


        try {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:449:2: (iv_ruleDeclaredParameter= ruleDeclaredParameter EOF )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:450:2: iv_ruleDeclaredParameter= ruleDeclaredParameter EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDeclaredParameterRule(), currentNode); 
            pushFollow(FOLLOW_ruleDeclaredParameter_in_entryRuleDeclaredParameter807);
            iv_ruleDeclaredParameter=ruleDeclaredParameter();

            state._fsp--;

             current =iv_ruleDeclaredParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclaredParameter817); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclaredParameter"


    // $ANTLR start "ruleDeclaredParameter"
    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:457:1: ruleDeclaredParameter returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleDeclaredParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:462:6: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:463:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:463:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:464:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:464:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:465:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclaredParameter858); 

            			createLeafNode(lv_name_0_0, grammarAccess.getDeclaredParameterAccess().getNameIDTerminalRuleCall_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDeclaredParameterRule().getType().getClassifier());
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


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclaredParameter"


    // $ANTLR start "entryRuleEvaluation"
    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:497:1: entryRuleEvaluation returns [EObject current=null] : iv_ruleEvaluation= ruleEvaluation EOF ;
    public final EObject entryRuleEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvaluation = null;


        try {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:498:2: (iv_ruleEvaluation= ruleEvaluation EOF )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:499:2: iv_ruleEvaluation= ruleEvaluation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEvaluationRule(), currentNode); 
            pushFollow(FOLLOW_ruleEvaluation_in_entryRuleEvaluation900);
            iv_ruleEvaluation=ruleEvaluation();

            state._fsp--;

             current =iv_ruleEvaluation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvaluation910); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvaluation"


    // $ANTLR start "ruleEvaluation"
    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:506:1: ruleEvaluation returns [EObject current=null] : ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' ) ;
    public final EObject ruleEvaluation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:511:6: ( ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' ) )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:512:1: ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' )
            {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:512:1: ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:512:2: ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';'
            {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:512:2: ( (lv_expression_0_0= ruleExpression ) )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:513:1: (lv_expression_0_0= ruleExpression )
            {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:513:1: (lv_expression_0_0= ruleExpression )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:514:3: lv_expression_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEvaluationAccess().getExpressionExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleEvaluation956);
            lv_expression_0_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEvaluationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expression",
            	        		lv_expression_0_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleEvaluation968); 

                	createLeafNode(otherlv_1, grammarAccess.getEvaluationAccess().getSemicolonKeyword_1(), null);
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvaluation"


    // $ANTLR start "entryRuleExpression"
    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:548:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:549:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:550:2: iv_ruleExpression= ruleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression1004);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression1014); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:557:1: ruleExpression returns [EObject current=null] : this_Addition_0= ruleAddition ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Addition_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:562:6: (this_Addition_0= ruleAddition )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:564:5: this_Addition_0= ruleAddition
            {
             
                    currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getAdditionParserRuleCall(), currentNode); 
                
            pushFollow(FOLLOW_ruleAddition_in_ruleExpression1060);
            this_Addition_0=ruleAddition();

            state._fsp--;

             
                    current = this_Addition_0; 
                    currentNode = currentNode.getParent();
                

            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAddition"
    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:580:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:581:2: (iv_ruleAddition= ruleAddition EOF )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:582:2: iv_ruleAddition= ruleAddition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAdditionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAddition_in_entryRuleAddition1094);
            iv_ruleAddition=ruleAddition();

            state._fsp--;

             current =iv_ruleAddition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddition1104); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddition"


    // $ANTLR start "ruleAddition"
    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:589:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:594:6: ( (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:595:1: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:595:1: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:596:5: this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition1151);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;

             
                    current = this_Multiplication_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:604:1: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=22 && LA8_0<=23)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:604:2: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:604:2: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt7=2;
            	    int LA7_0 = input.LA(1);

            	    if ( (LA7_0==22) ) {
            	        alt7=1;
            	    }
            	    else if ( (LA7_0==23) ) {
            	        alt7=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 7, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt7) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:604:3: ( () otherlv_2= '+' )
            	            {
            	            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:604:3: ( () otherlv_2= '+' )
            	            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:604:4: () otherlv_2= '+'
            	            {
            	            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:604:4: ()
            	            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:605:5: 
            	            {
            	             
            	                    temp=factory.create(grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0().getType().getClassifier());
            	                    try {
            	                    	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	                    } catch(ValueConverterException vce) {
            	                    	handleValueConverterException(vce);
            	                    }
            	                    current = temp; 
            	                    temp = null;
            	                    CompositeNode newNode = createCompositeNode(grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0(), currentNode.getParent());
            	                newNode.getChildren().add(currentNode);
            	                moveLookaheadInfo(currentNode, newNode);
            	                currentNode = newNode; 
            	                    associateNodeWithAstElement(currentNode, current); 
            	                

            	            }

            	            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleAddition1174); 

            	                	createLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1(), null);
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:625:6: ( () otherlv_4= '-' )
            	            {
            	            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:625:6: ( () otherlv_4= '-' )
            	            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:625:7: () otherlv_4= '-'
            	            {
            	            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:625:7: ()
            	            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:626:5: 
            	            {
            	             
            	                    temp=factory.create(grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0().getType().getClassifier());
            	                    try {
            	                    	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	                    } catch(ValueConverterException vce) {
            	                    	handleValueConverterException(vce);
            	                    }
            	                    current = temp; 
            	                    temp = null;
            	                    CompositeNode newNode = createCompositeNode(grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0(), currentNode.getParent());
            	                newNode.getChildren().add(currentNode);
            	                moveLookaheadInfo(currentNode, newNode);
            	                currentNode = newNode; 
            	                    associateNodeWithAstElement(currentNode, current); 
            	                

            	            }

            	            otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleAddition1203); 

            	                	createLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1(), null);
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:645:3: ( (lv_right_5_0= ruleMultiplication ) )
            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:646:1: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:646:1: (lv_right_5_0= ruleMultiplication )
            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:647:3: lv_right_5_0= ruleMultiplication
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition1226);
            	    lv_right_5_0=ruleMultiplication();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getAdditionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"right",
            	    	        		lv_right_5_0, 
            	    	        		"Multiplication", 
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
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:677:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:678:2: (iv_ruleMultiplication= ruleMultiplication EOF )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:679:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplicationRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiplication_in_entryRuleMultiplication1264);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;

             current =iv_ruleMultiplication; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplication1274); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplication"


    // $ANTLR start "ruleMultiplication"
    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:686:1: ruleMultiplication returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_right_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:691:6: ( (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:692:1: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:692:1: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:693:5: this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getMultiplicationAccess().getPrimaryExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_rulePrimaryExpression_in_ruleMultiplication1321);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;

             
                    current = this_PrimaryExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:701:1: ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==15||LA10_0==24) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:701:2: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:701:2: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) )
            	    int alt9=2;
            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==15) ) {
            	        alt9=1;
            	    }
            	    else if ( (LA9_0==24) ) {
            	        alt9=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 9, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt9) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:701:3: ( () otherlv_2= '*' )
            	            {
            	            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:701:3: ( () otherlv_2= '*' )
            	            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:701:4: () otherlv_2= '*'
            	            {
            	            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:701:4: ()
            	            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:702:5: 
            	            {
            	             
            	                    temp=factory.create(grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0().getType().getClassifier());
            	                    try {
            	                    	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	                    } catch(ValueConverterException vce) {
            	                    	handleValueConverterException(vce);
            	                    }
            	                    current = temp; 
            	                    temp = null;
            	                    CompositeNode newNode = createCompositeNode(grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0(), currentNode.getParent());
            	                newNode.getChildren().add(currentNode);
            	                moveLookaheadInfo(currentNode, newNode);
            	                currentNode = newNode; 
            	                    associateNodeWithAstElement(currentNode, current); 
            	                

            	            }

            	            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleMultiplication1344); 

            	                	createLeafNode(otherlv_2, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1(), null);
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:722:6: ( () otherlv_4= '/' )
            	            {
            	            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:722:6: ( () otherlv_4= '/' )
            	            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:722:7: () otherlv_4= '/'
            	            {
            	            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:722:7: ()
            	            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:723:5: 
            	            {
            	             
            	                    temp=factory.create(grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0().getType().getClassifier());
            	                    try {
            	                    	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	                    } catch(ValueConverterException vce) {
            	                    	handleValueConverterException(vce);
            	                    }
            	                    current = temp; 
            	                    temp = null;
            	                    CompositeNode newNode = createCompositeNode(grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0(), currentNode.getParent());
            	                newNode.getChildren().add(currentNode);
            	                moveLookaheadInfo(currentNode, newNode);
            	                currentNode = newNode; 
            	                    associateNodeWithAstElement(currentNode, current); 
            	                

            	            }

            	            otherlv_4=(Token)match(input,24,FOLLOW_24_in_ruleMultiplication1373); 

            	                	createLeafNode(otherlv_4, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1(), null);
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:742:3: ( (lv_right_5_0= rulePrimaryExpression ) )
            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:743:1: (lv_right_5_0= rulePrimaryExpression )
            	    {
            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:743:1: (lv_right_5_0= rulePrimaryExpression )
            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:744:3: lv_right_5_0= rulePrimaryExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMultiplicationAccess().getRightPrimaryExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleMultiplication1396);
            	    lv_right_5_0=rulePrimaryExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMultiplicationRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"right",
            	    	        		lv_right_5_0, 
            	    	        		"PrimaryExpression", 
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
            	    break loop10;
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
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRulePrimaryExpression"
    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:774:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:775:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:776:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1434);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression1444); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:783:1: rulePrimaryExpression returns [EObject current=null] : ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= RULE_NUMBER ) ) ) | ( () ( (otherlv_6= RULE_ID ) ) (otherlv_7= '(' ( (lv_args_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_args_10_0= ruleExpression ) ) )* otherlv_11= ')' )? ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_value_4_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject this_Expression_1 = null;

        EObject lv_args_8_0 = null;

        EObject lv_args_10_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:788:6: ( ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= RULE_NUMBER ) ) ) | ( () ( (otherlv_6= RULE_ID ) ) (otherlv_7= '(' ( (lv_args_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_args_10_0= ruleExpression ) ) )* otherlv_11= ')' )? ) ) )
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:789:1: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= RULE_NUMBER ) ) ) | ( () ( (otherlv_6= RULE_ID ) ) (otherlv_7= '(' ( (lv_args_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_args_10_0= ruleExpression ) ) )* otherlv_11= ')' )? ) )
            {
            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:789:1: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= RULE_NUMBER ) ) ) | ( () ( (otherlv_6= RULE_ID ) ) (otherlv_7= '(' ( (lv_args_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_args_10_0= ruleExpression ) ) )* otherlv_11= ')' )? ) )
            int alt13=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt13=1;
                }
                break;
            case RULE_NUMBER:
                {
                alt13=2;
                }
                break;
            case RULE_ID:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:789:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    {
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:789:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:789:4: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,17,FOLLOW_17_in_rulePrimaryExpression1482); 

                        	createLeafNode(otherlv_0, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0(), null);
                        
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_0_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExpression_in_rulePrimaryExpression1504);
                    this_Expression_1=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_1; 
                            currentNode = currentNode.getParent();
                        
                    otherlv_2=(Token)match(input,19,FOLLOW_19_in_rulePrimaryExpression1515); 

                        	createLeafNode(otherlv_2, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_2(), null);
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:807:6: ( () ( (lv_value_4_0= RULE_NUMBER ) ) )
                    {
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:807:6: ( () ( (lv_value_4_0= RULE_NUMBER ) ) )
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:807:7: () ( (lv_value_4_0= RULE_NUMBER ) )
                    {
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:807:7: ()
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:808:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getPrimaryExpressionAccess().getNumberLiteralAction_1_0().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNumberLiteralAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:818:2: ( (lv_value_4_0= RULE_NUMBER ) )
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:819:1: (lv_value_4_0= RULE_NUMBER )
                    {
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:819:1: (lv_value_4_0= RULE_NUMBER )
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:820:3: lv_value_4_0= RULE_NUMBER
                    {
                    lv_value_4_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_rulePrimaryExpression1549); 

                    			createLeafNode(lv_value_4_0, grammarAccess.getPrimaryExpressionAccess().getValueNUMBERTerminalRuleCall_1_1_0(), "value"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPrimaryExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"value",
                    	        		lv_value_4_0, 
                    	        		"NUMBER", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:843:6: ( () ( (otherlv_6= RULE_ID ) ) (otherlv_7= '(' ( (lv_args_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_args_10_0= ruleExpression ) ) )* otherlv_11= ')' )? )
                    {
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:843:6: ( () ( (otherlv_6= RULE_ID ) ) (otherlv_7= '(' ( (lv_args_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_args_10_0= ruleExpression ) ) )* otherlv_11= ')' )? )
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:843:7: () ( (otherlv_6= RULE_ID ) ) (otherlv_7= '(' ( (lv_args_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_args_10_0= ruleExpression ) ) )* otherlv_11= ')' )?
                    {
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:843:7: ()
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:844:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getPrimaryExpressionAccess().getFunctionCallAction_2_0().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFunctionCallAction_2_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:854:2: ( (otherlv_6= RULE_ID ) )
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:855:1: (otherlv_6= RULE_ID )
                    {
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:855:1: (otherlv_6= RULE_ID )
                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:856:3: otherlv_6= RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getPrimaryExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePrimaryExpression1591); 

                    		createLeafNode(otherlv_6, grammarAccess.getPrimaryExpressionAccess().getFuncAbstractDefinitionCrossReference_2_1_0(), "func"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:868:2: (otherlv_7= '(' ( (lv_args_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_args_10_0= ruleExpression ) ) )* otherlv_11= ')' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==17) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:868:4: otherlv_7= '(' ( (lv_args_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_args_10_0= ruleExpression ) ) )* otherlv_11= ')'
                            {
                            otherlv_7=(Token)match(input,17,FOLLOW_17_in_rulePrimaryExpression1604); 

                                	createLeafNode(otherlv_7, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_2_2_0(), null);
                                
                            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:872:1: ( (lv_args_8_0= ruleExpression ) )
                            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:873:1: (lv_args_8_0= ruleExpression )
                            {
                            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:873:1: (lv_args_8_0= ruleExpression )
                            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:874:3: lv_args_8_0= ruleExpression
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getArgsExpressionParserRuleCall_2_2_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleExpression_in_rulePrimaryExpression1625);
                            lv_args_8_0=ruleExpression();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getPrimaryExpressionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		add(
                            	       			current, 
                            	       			"args",
                            	        		lv_args_8_0, 
                            	        		"Expression", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }

                            // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:896:2: (otherlv_9= ',' ( (lv_args_10_0= ruleExpression ) ) )*
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( (LA11_0==18) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:896:4: otherlv_9= ',' ( (lv_args_10_0= ruleExpression ) )
                            	    {
                            	    otherlv_9=(Token)match(input,18,FOLLOW_18_in_rulePrimaryExpression1638); 

                            	        	createLeafNode(otherlv_9, grammarAccess.getPrimaryExpressionAccess().getCommaKeyword_2_2_2_0(), null);
                            	        
                            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:900:1: ( (lv_args_10_0= ruleExpression ) )
                            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:901:1: (lv_args_10_0= ruleExpression )
                            	    {
                            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:901:1: (lv_args_10_0= ruleExpression )
                            	    // ../org.eclipse.xtext.example.arithmetics/src-gen/org/eclipse/xtext/example/arithmetics/parser/antlr/internal/InternalArithmetics.g:902:3: lv_args_10_0= ruleExpression
                            	    {
                            	     
                            	    	        currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getArgsExpressionParserRuleCall_2_2_2_1_0(), currentNode); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleExpression_in_rulePrimaryExpression1659);
                            	    lv_args_10_0=ruleExpression();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = factory.create(grammarAccess.getPrimaryExpressionRule().getType().getClassifier());
                            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	    	        }
                            	    	        try {
                            	    	       		add(
                            	    	       			current, 
                            	    	       			"args",
                            	    	        		lv_args_10_0, 
                            	    	        		"Expression", 
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
                            	    break loop11;
                                }
                            } while (true);

                            otherlv_11=(Token)match(input,19,FOLLOW_19_in_rulePrimaryExpression1673); 

                                	createLeafNode(otherlv_11, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_2_2_3(), null);
                                

                            }
                            break;

                    }


                    }


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
    // $ANTLR end "rulePrimaryExpression"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModule_in_entryRuleModule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleModule122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModule139 = new BitSet(new long[]{0x0000000000032032L});
    public static final BitSet FOLLOW_ruleImport_in_ruleModule165 = new BitSet(new long[]{0x0000000000032032L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleModule187 = new BitSet(new long[]{0x0000000000030032L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport224 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleImport271 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleImportName_in_ruleImport292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportName_in_entryRuleImportName329 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportName340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleImportName380 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleImportName399 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleImportName412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement454 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleStatement511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvaluation_in_ruleStatement538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition573 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinition583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleDefinition620 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition637 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_17_in_ruleDefinition655 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_ruleDefinition676 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_ruleDefinition689 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_ruleDefinition710 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_19_in_ruleDefinition724 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleDefinition738 = new BitSet(new long[]{0x0000000000030030L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDefinition759 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleDefinition771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_entryRuleDeclaredParameter807 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclaredParameter817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclaredParameter858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvaluation_in_entryRuleEvaluation900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvaluation910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleEvaluation956 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleEvaluation968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression1004 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression1014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleExpression1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition1094 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition1104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition1151 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_22_in_ruleAddition1174 = new BitSet(new long[]{0x0000000000030030L});
    public static final BitSet FOLLOW_23_in_ruleAddition1203 = new BitSet(new long[]{0x0000000000030030L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition1226 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication1264 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication1274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleMultiplication1321 = new BitSet(new long[]{0x0000000001008002L});
    public static final BitSet FOLLOW_15_in_ruleMultiplication1344 = new BitSet(new long[]{0x0000000000030030L});
    public static final BitSet FOLLOW_24_in_ruleMultiplication1373 = new BitSet(new long[]{0x0000000000030030L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleMultiplication1396 = new BitSet(new long[]{0x0000000001008002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1434 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression1444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rulePrimaryExpression1482 = new BitSet(new long[]{0x0000000000030030L});
    public static final BitSet FOLLOW_ruleExpression_in_rulePrimaryExpression1504 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_rulePrimaryExpression1515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_rulePrimaryExpression1549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePrimaryExpression1591 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_rulePrimaryExpression1604 = new BitSet(new long[]{0x0000000000030030L});
    public static final BitSet FOLLOW_ruleExpression_in_rulePrimaryExpression1625 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_rulePrimaryExpression1638 = new BitSet(new long[]{0x0000000000030030L});
    public static final BitSet FOLLOW_ruleExpression_in_rulePrimaryExpression1659 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_19_in_rulePrimaryExpression1673 = new BitSet(new long[]{0x0000000000000002L});

}