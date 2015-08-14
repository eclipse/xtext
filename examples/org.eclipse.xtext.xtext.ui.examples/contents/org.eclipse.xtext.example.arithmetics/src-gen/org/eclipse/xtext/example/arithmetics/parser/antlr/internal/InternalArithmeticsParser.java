package org.eclipse.xtext.example.arithmetics.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
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
    public static final int RULE_ID=4;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__19=19;
    public static final int RULE_STRING=7;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int RULE_NUMBER=5;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public InternalArithmeticsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalArithmeticsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalArithmeticsParser.tokenNames; }
    public String getGrammarFileName() { return "InternalArithmetics.g"; }



     	private ArithmeticsGrammarAccess grammarAccess;
     	
        public InternalArithmeticsParser(TokenStream input, ArithmeticsGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
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
    // InternalArithmetics.g:67:1: entryRuleModule returns [EObject current=null] : iv_ruleModule= ruleModule EOF ;
    public final EObject entryRuleModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModule = null;


        try {
            // InternalArithmetics.g:68:2: (iv_ruleModule= ruleModule EOF )
            // InternalArithmetics.g:69:2: iv_ruleModule= ruleModule EOF
            {
             newCompositeNode(grammarAccess.getModuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModule=ruleModule();

            state._fsp--;

             current =iv_ruleModule; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalArithmetics.g:76:1: ruleModule returns [EObject current=null] : (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_statements_3_0= ruleStatement ) )* ) ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_imports_2_0 = null;

        EObject lv_statements_3_0 = null;


         enterRule(); 
            
        try {
            // InternalArithmetics.g:79:28: ( (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_statements_3_0= ruleStatement ) )* ) )
            // InternalArithmetics.g:80:1: (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_statements_3_0= ruleStatement ) )* )
            {
            // InternalArithmetics.g:80:1: (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_statements_3_0= ruleStatement ) )* )
            // InternalArithmetics.g:80:3: otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_statements_3_0= ruleStatement ) )*
            {
            otherlv_0=(Token)match(input,12,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getModuleAccess().getModuleKeyword_0());
                
            // InternalArithmetics.g:84:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalArithmetics.g:85:1: (lv_name_1_0= RULE_ID )
            {
            // InternalArithmetics.g:85:1: (lv_name_1_0= RULE_ID )
            // InternalArithmetics.g:86:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            			newLeafNode(lv_name_1_0, grammarAccess.getModuleAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getModuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalArithmetics.g:102:2: ( (lv_imports_2_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalArithmetics.g:103:1: (lv_imports_2_0= ruleImport )
            	    {
            	    // InternalArithmetics.g:103:1: (lv_imports_2_0= ruleImport )
            	    // InternalArithmetics.g:104:3: lv_imports_2_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModuleAccess().getImportsImportParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_4);
            	    lv_imports_2_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModuleRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"imports",
            	            		lv_imports_2_0, 
            	            		"org.eclipse.xtext.example.arithmetics.Arithmetics.Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalArithmetics.g:120:3: ( (lv_statements_3_0= ruleStatement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=RULE_ID && LA2_0<=RULE_NUMBER)||(LA2_0>=16 && LA2_0<=17)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalArithmetics.g:121:1: (lv_statements_3_0= ruleStatement )
            	    {
            	    // InternalArithmetics.g:121:1: (lv_statements_3_0= ruleStatement )
            	    // InternalArithmetics.g:122:3: lv_statements_3_0= ruleStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModuleAccess().getStatementsStatementParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_5);
            	    lv_statements_3_0=ruleStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModuleRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"statements",
            	            		lv_statements_3_0, 
            	            		"org.eclipse.xtext.example.arithmetics.Arithmetics.Statement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleImport"
    // InternalArithmetics.g:146:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalArithmetics.g:147:2: (iv_ruleImport= ruleImport EOF )
            // InternalArithmetics.g:148:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalArithmetics.g:155:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportName ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // InternalArithmetics.g:158:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportName ) ) ) )
            // InternalArithmetics.g:159:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportName ) ) )
            {
            // InternalArithmetics.g:159:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportName ) ) )
            // InternalArithmetics.g:159:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportName ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // InternalArithmetics.g:163:1: ( (lv_importedNamespace_1_0= ruleImportName ) )
            // InternalArithmetics.g:164:1: (lv_importedNamespace_1_0= ruleImportName )
            {
            // InternalArithmetics.g:164:1: (lv_importedNamespace_1_0= ruleImportName )
            // InternalArithmetics.g:165:3: lv_importedNamespace_1_0= ruleImportName
            {
             
            	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_importedNamespace_1_0=ruleImportName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getImportRule());
            	        }
                   		set(
                   			current, 
                   			"importedNamespace",
                    		lv_importedNamespace_1_0, 
                    		"org.eclipse.xtext.example.arithmetics.Arithmetics.ImportName");
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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleImportName"
    // InternalArithmetics.g:189:1: entryRuleImportName returns [String current=null] : iv_ruleImportName= ruleImportName EOF ;
    public final String entryRuleImportName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportName = null;


        try {
            // InternalArithmetics.g:190:2: (iv_ruleImportName= ruleImportName EOF )
            // InternalArithmetics.g:191:2: iv_ruleImportName= ruleImportName EOF
            {
             newCompositeNode(grammarAccess.getImportNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImportName=ruleImportName();

            state._fsp--;

             current =iv_ruleImportName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalArithmetics.g:198:1: ruleImportName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' kw= '*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // InternalArithmetics.g:201:28: ( (this_ID_0= RULE_ID (kw= '.' kw= '*' )? ) )
            // InternalArithmetics.g:202:1: (this_ID_0= RULE_ID (kw= '.' kw= '*' )? )
            {
            // InternalArithmetics.g:202:1: (this_ID_0= RULE_ID (kw= '.' kw= '*' )? )
            // InternalArithmetics.g:202:6: this_ID_0= RULE_ID (kw= '.' kw= '*' )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getImportNameAccess().getIDTerminalRuleCall_0()); 
                
            // InternalArithmetics.g:209:1: (kw= '.' kw= '*' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalArithmetics.g:210:2: kw= '.' kw= '*'
                    {
                    kw=(Token)match(input,14,FOLLOW_7); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getImportNameAccess().getFullStopKeyword_1_0()); 
                        
                    kw=(Token)match(input,15,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getImportNameAccess().getAsteriskKeyword_1_1()); 
                        

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
    // $ANTLR end "ruleImportName"


    // $ANTLR start "entryRuleStatement"
    // InternalArithmetics.g:229:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalArithmetics.g:230:2: (iv_ruleStatement= ruleStatement EOF )
            // InternalArithmetics.g:231:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalArithmetics.g:238:1: ruleStatement returns [EObject current=null] : (this_Definition_0= ruleDefinition | this_Evaluation_1= ruleEvaluation ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Definition_0 = null;

        EObject this_Evaluation_1 = null;


         enterRule(); 
            
        try {
            // InternalArithmetics.g:241:28: ( (this_Definition_0= ruleDefinition | this_Evaluation_1= ruleEvaluation ) )
            // InternalArithmetics.g:242:1: (this_Definition_0= ruleDefinition | this_Evaluation_1= ruleEvaluation )
            {
            // InternalArithmetics.g:242:1: (this_Definition_0= ruleDefinition | this_Evaluation_1= ruleEvaluation )
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
                    // InternalArithmetics.g:243:5: this_Definition_0= ruleDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getDefinitionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Definition_0=ruleDefinition();

                    state._fsp--;

                     
                            current = this_Definition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalArithmetics.g:253:5: this_Evaluation_1= ruleEvaluation
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getEvaluationParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Evaluation_1=ruleEvaluation();

                    state._fsp--;

                     
                            current = this_Evaluation_1; 
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
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleDefinition"
    // InternalArithmetics.g:269:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // InternalArithmetics.g:270:2: (iv_ruleDefinition= ruleDefinition EOF )
            // InternalArithmetics.g:271:2: iv_ruleDefinition= ruleDefinition EOF
            {
             newCompositeNode(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefinition=ruleDefinition();

            state._fsp--;

             current =iv_ruleDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalArithmetics.g:278:1: ruleDefinition returns [EObject current=null] : (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_args_3_0= ruleDeclaredParameter ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDeclaredParameter ) ) )* otherlv_6= ')' )? otherlv_7= ':' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' ) ;
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


         enterRule(); 
            
        try {
            // InternalArithmetics.g:281:28: ( (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_args_3_0= ruleDeclaredParameter ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDeclaredParameter ) ) )* otherlv_6= ')' )? otherlv_7= ':' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
            // InternalArithmetics.g:282:1: (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_args_3_0= ruleDeclaredParameter ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDeclaredParameter ) ) )* otherlv_6= ')' )? otherlv_7= ':' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' )
            {
            // InternalArithmetics.g:282:1: (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_args_3_0= ruleDeclaredParameter ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDeclaredParameter ) ) )* otherlv_6= ')' )? otherlv_7= ':' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' )
            // InternalArithmetics.g:282:3: otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_args_3_0= ruleDeclaredParameter ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDeclaredParameter ) ) )* otherlv_6= ')' )? otherlv_7= ':' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getDefinitionAccess().getDefKeyword_0());
                
            // InternalArithmetics.g:286:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalArithmetics.g:287:1: (lv_name_1_0= RULE_ID )
            {
            // InternalArithmetics.g:287:1: (lv_name_1_0= RULE_ID )
            // InternalArithmetics.g:288:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            			newLeafNode(lv_name_1_0, grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDefinitionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalArithmetics.g:304:2: (otherlv_2= '(' ( (lv_args_3_0= ruleDeclaredParameter ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDeclaredParameter ) ) )* otherlv_6= ')' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalArithmetics.g:304:4: otherlv_2= '(' ( (lv_args_3_0= ruleDeclaredParameter ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDeclaredParameter ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_3); 

                        	newLeafNode(otherlv_2, grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_2_0());
                        
                    // InternalArithmetics.g:308:1: ( (lv_args_3_0= ruleDeclaredParameter ) )
                    // InternalArithmetics.g:309:1: (lv_args_3_0= ruleDeclaredParameter )
                    {
                    // InternalArithmetics.g:309:1: (lv_args_3_0= ruleDeclaredParameter )
                    // InternalArithmetics.g:310:3: lv_args_3_0= ruleDeclaredParameter
                    {
                     
                    	        newCompositeNode(grammarAccess.getDefinitionAccess().getArgsDeclaredParameterParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_9);
                    lv_args_3_0=ruleDeclaredParameter();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
                    	        }
                           		add(
                           			current, 
                           			"args",
                            		lv_args_3_0, 
                            		"org.eclipse.xtext.example.arithmetics.Arithmetics.DeclaredParameter");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalArithmetics.g:326:2: (otherlv_4= ',' ( (lv_args_5_0= ruleDeclaredParameter ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==18) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalArithmetics.g:326:4: otherlv_4= ',' ( (lv_args_5_0= ruleDeclaredParameter ) )
                    	    {
                    	    otherlv_4=(Token)match(input,18,FOLLOW_3); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getDefinitionAccess().getCommaKeyword_2_2_0());
                    	        
                    	    // InternalArithmetics.g:330:1: ( (lv_args_5_0= ruleDeclaredParameter ) )
                    	    // InternalArithmetics.g:331:1: (lv_args_5_0= ruleDeclaredParameter )
                    	    {
                    	    // InternalArithmetics.g:331:1: (lv_args_5_0= ruleDeclaredParameter )
                    	    // InternalArithmetics.g:332:3: lv_args_5_0= ruleDeclaredParameter
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getDefinitionAccess().getArgsDeclaredParameterParserRuleCall_2_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_9);
                    	    lv_args_5_0=ruleDeclaredParameter();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"args",
                    	            		lv_args_5_0, 
                    	            		"org.eclipse.xtext.example.arithmetics.Arithmetics.DeclaredParameter");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,19,FOLLOW_10); 

                        	newLeafNode(otherlv_6, grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_2_3());
                        

                    }
                    break;

            }

            otherlv_7=(Token)match(input,20,FOLLOW_11); 

                	newLeafNode(otherlv_7, grammarAccess.getDefinitionAccess().getColonKeyword_3());
                
            // InternalArithmetics.g:356:1: ( (lv_expr_8_0= ruleExpression ) )
            // InternalArithmetics.g:357:1: (lv_expr_8_0= ruleExpression )
            {
            // InternalArithmetics.g:357:1: (lv_expr_8_0= ruleExpression )
            // InternalArithmetics.g:358:3: lv_expr_8_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getDefinitionAccess().getExprExpressionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_12);
            lv_expr_8_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"expr",
                    		lv_expr_8_0, 
                    		"org.eclipse.xtext.example.arithmetics.Arithmetics.Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_9=(Token)match(input,21,FOLLOW_2); 

                	newLeafNode(otherlv_9, grammarAccess.getDefinitionAccess().getSemicolonKeyword_5());
                

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
    // $ANTLR end "ruleDefinition"


    // $ANTLR start "entryRuleDeclaredParameter"
    // InternalArithmetics.g:386:1: entryRuleDeclaredParameter returns [EObject current=null] : iv_ruleDeclaredParameter= ruleDeclaredParameter EOF ;
    public final EObject entryRuleDeclaredParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaredParameter = null;


        try {
            // InternalArithmetics.g:387:2: (iv_ruleDeclaredParameter= ruleDeclaredParameter EOF )
            // InternalArithmetics.g:388:2: iv_ruleDeclaredParameter= ruleDeclaredParameter EOF
            {
             newCompositeNode(grammarAccess.getDeclaredParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeclaredParameter=ruleDeclaredParameter();

            state._fsp--;

             current =iv_ruleDeclaredParameter; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalArithmetics.g:395:1: ruleDeclaredParameter returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleDeclaredParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // InternalArithmetics.g:398:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalArithmetics.g:399:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalArithmetics.g:399:1: ( (lv_name_0_0= RULE_ID ) )
            // InternalArithmetics.g:400:1: (lv_name_0_0= RULE_ID )
            {
            // InternalArithmetics.g:400:1: (lv_name_0_0= RULE_ID )
            // InternalArithmetics.g:401:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            			newLeafNode(lv_name_0_0, grammarAccess.getDeclaredParameterAccess().getNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDeclaredParameterRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // $ANTLR end "ruleDeclaredParameter"


    // $ANTLR start "entryRuleEvaluation"
    // InternalArithmetics.g:427:1: entryRuleEvaluation returns [EObject current=null] : iv_ruleEvaluation= ruleEvaluation EOF ;
    public final EObject entryRuleEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvaluation = null;


        try {
            // InternalArithmetics.g:428:2: (iv_ruleEvaluation= ruleEvaluation EOF )
            // InternalArithmetics.g:429:2: iv_ruleEvaluation= ruleEvaluation EOF
            {
             newCompositeNode(grammarAccess.getEvaluationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEvaluation=ruleEvaluation();

            state._fsp--;

             current =iv_ruleEvaluation; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalArithmetics.g:436:1: ruleEvaluation returns [EObject current=null] : ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' ) ;
    public final EObject ruleEvaluation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_0_0 = null;


         enterRule(); 
            
        try {
            // InternalArithmetics.g:439:28: ( ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' ) )
            // InternalArithmetics.g:440:1: ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' )
            {
            // InternalArithmetics.g:440:1: ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' )
            // InternalArithmetics.g:440:2: ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';'
            {
            // InternalArithmetics.g:440:2: ( (lv_expression_0_0= ruleExpression ) )
            // InternalArithmetics.g:441:1: (lv_expression_0_0= ruleExpression )
            {
            // InternalArithmetics.g:441:1: (lv_expression_0_0= ruleExpression )
            // InternalArithmetics.g:442:3: lv_expression_0_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getEvaluationAccess().getExpressionExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_12);
            lv_expression_0_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEvaluationRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_0_0, 
                    		"org.eclipse.xtext.example.arithmetics.Arithmetics.Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_2); 

                	newLeafNode(otherlv_1, grammarAccess.getEvaluationAccess().getSemicolonKeyword_1());
                

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
    // $ANTLR end "ruleEvaluation"


    // $ANTLR start "entryRuleExpression"
    // InternalArithmetics.g:470:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalArithmetics.g:471:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalArithmetics.g:472:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalArithmetics.g:479:1: ruleExpression returns [EObject current=null] : this_Addition_0= ruleAddition ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Addition_0 = null;


         enterRule(); 
            
        try {
            // InternalArithmetics.g:482:28: (this_Addition_0= ruleAddition )
            // InternalArithmetics.g:484:5: this_Addition_0= ruleAddition
            {
             
                    newCompositeNode(grammarAccess.getExpressionAccess().getAdditionParserRuleCall()); 
                
            pushFollow(FOLLOW_2);
            this_Addition_0=ruleAddition();

            state._fsp--;

             
                    current = this_Addition_0; 
                    afterParserOrEnumRuleCall();
                

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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAddition"
    // InternalArithmetics.g:500:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalArithmetics.g:501:2: (iv_ruleAddition= ruleAddition EOF )
            // InternalArithmetics.g:502:2: iv_ruleAddition= ruleAddition EOF
            {
             newCompositeNode(grammarAccess.getAdditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAddition=ruleAddition();

            state._fsp--;

             current =iv_ruleAddition; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalArithmetics.g:509:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // InternalArithmetics.g:512:28: ( (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // InternalArithmetics.g:513:1: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // InternalArithmetics.g:513:1: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // InternalArithmetics.g:514:5: this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
                
            pushFollow(FOLLOW_13);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;

             
                    current = this_Multiplication_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalArithmetics.g:522:1: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=22 && LA8_0<=23)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalArithmetics.g:522:2: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // InternalArithmetics.g:522:2: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
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
            	            // InternalArithmetics.g:522:3: ( () otherlv_2= '+' )
            	            {
            	            // InternalArithmetics.g:522:3: ( () otherlv_2= '+' )
            	            // InternalArithmetics.g:522:4: () otherlv_2= '+'
            	            {
            	            // InternalArithmetics.g:522:4: ()
            	            // InternalArithmetics.g:523:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,22,FOLLOW_11); 

            	                	newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalArithmetics.g:533:6: ( () otherlv_4= '-' )
            	            {
            	            // InternalArithmetics.g:533:6: ( () otherlv_4= '-' )
            	            // InternalArithmetics.g:533:7: () otherlv_4= '-'
            	            {
            	            // InternalArithmetics.g:533:7: ()
            	            // InternalArithmetics.g:534:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,23,FOLLOW_11); 

            	                	newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // InternalArithmetics.g:543:3: ( (lv_right_5_0= ruleMultiplication ) )
            	    // InternalArithmetics.g:544:1: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // InternalArithmetics.g:544:1: (lv_right_5_0= ruleMultiplication )
            	    // InternalArithmetics.g:545:3: lv_right_5_0= ruleMultiplication
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_13);
            	    lv_right_5_0=ruleMultiplication();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAdditionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_5_0, 
            	            		"org.eclipse.xtext.example.arithmetics.Arithmetics.Multiplication");
            	    	        afterParserOrEnumRuleCall();
            	    	    

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
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // InternalArithmetics.g:569:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalArithmetics.g:570:2: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalArithmetics.g:571:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
             newCompositeNode(grammarAccess.getMultiplicationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;

             current =iv_ruleMultiplication; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalArithmetics.g:578:1: ruleMultiplication returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // InternalArithmetics.g:581:28: ( (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* ) )
            // InternalArithmetics.g:582:1: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* )
            {
            // InternalArithmetics.g:582:1: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* )
            // InternalArithmetics.g:583:5: this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getMultiplicationAccess().getPrimaryExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_14);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;

             
                    current = this_PrimaryExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalArithmetics.g:591:1: ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==15||LA10_0==24) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalArithmetics.g:591:2: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) )
            	    {
            	    // InternalArithmetics.g:591:2: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) )
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
            	            // InternalArithmetics.g:591:3: ( () otherlv_2= '*' )
            	            {
            	            // InternalArithmetics.g:591:3: ( () otherlv_2= '*' )
            	            // InternalArithmetics.g:591:4: () otherlv_2= '*'
            	            {
            	            // InternalArithmetics.g:591:4: ()
            	            // InternalArithmetics.g:592:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,15,FOLLOW_11); 

            	                	newLeafNode(otherlv_2, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalArithmetics.g:602:6: ( () otherlv_4= '/' )
            	            {
            	            // InternalArithmetics.g:602:6: ( () otherlv_4= '/' )
            	            // InternalArithmetics.g:602:7: () otherlv_4= '/'
            	            {
            	            // InternalArithmetics.g:602:7: ()
            	            // InternalArithmetics.g:603:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,24,FOLLOW_11); 

            	                	newLeafNode(otherlv_4, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // InternalArithmetics.g:612:3: ( (lv_right_5_0= rulePrimaryExpression ) )
            	    // InternalArithmetics.g:613:1: (lv_right_5_0= rulePrimaryExpression )
            	    {
            	    // InternalArithmetics.g:613:1: (lv_right_5_0= rulePrimaryExpression )
            	    // InternalArithmetics.g:614:3: lv_right_5_0= rulePrimaryExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightPrimaryExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_14);
            	    lv_right_5_0=rulePrimaryExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMultiplicationRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_5_0, 
            	            		"org.eclipse.xtext.example.arithmetics.Arithmetics.PrimaryExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

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
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalArithmetics.g:638:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalArithmetics.g:639:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalArithmetics.g:640:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalArithmetics.g:647:1: rulePrimaryExpression returns [EObject current=null] : ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= RULE_NUMBER ) ) ) | ( () ( (otherlv_6= RULE_ID ) ) (otherlv_7= '(' ( (lv_args_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_args_10_0= ruleExpression ) ) )* otherlv_11= ')' )? ) ) ;
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


         enterRule(); 
            
        try {
            // InternalArithmetics.g:650:28: ( ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= RULE_NUMBER ) ) ) | ( () ( (otherlv_6= RULE_ID ) ) (otherlv_7= '(' ( (lv_args_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_args_10_0= ruleExpression ) ) )* otherlv_11= ')' )? ) ) )
            // InternalArithmetics.g:651:1: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= RULE_NUMBER ) ) ) | ( () ( (otherlv_6= RULE_ID ) ) (otherlv_7= '(' ( (lv_args_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_args_10_0= ruleExpression ) ) )* otherlv_11= ')' )? ) )
            {
            // InternalArithmetics.g:651:1: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= RULE_NUMBER ) ) ) | ( () ( (otherlv_6= RULE_ID ) ) (otherlv_7= '(' ( (lv_args_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_args_10_0= ruleExpression ) ) )* otherlv_11= ')' )? ) )
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
                    // InternalArithmetics.g:651:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    {
                    // InternalArithmetics.g:651:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    // InternalArithmetics.g:651:4: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,17,FOLLOW_11); 

                        	newLeafNode(otherlv_0, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0());
                        
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_0_1()); 
                        
                    pushFollow(FOLLOW_15);
                    this_Expression_1=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_1; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_2=(Token)match(input,19,FOLLOW_2); 

                        	newLeafNode(otherlv_2, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalArithmetics.g:669:6: ( () ( (lv_value_4_0= RULE_NUMBER ) ) )
                    {
                    // InternalArithmetics.g:669:6: ( () ( (lv_value_4_0= RULE_NUMBER ) ) )
                    // InternalArithmetics.g:669:7: () ( (lv_value_4_0= RULE_NUMBER ) )
                    {
                    // InternalArithmetics.g:669:7: ()
                    // InternalArithmetics.g:670:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrimaryExpressionAccess().getNumberLiteralAction_1_0(),
                                current);
                        

                    }

                    // InternalArithmetics.g:675:2: ( (lv_value_4_0= RULE_NUMBER ) )
                    // InternalArithmetics.g:676:1: (lv_value_4_0= RULE_NUMBER )
                    {
                    // InternalArithmetics.g:676:1: (lv_value_4_0= RULE_NUMBER )
                    // InternalArithmetics.g:677:3: lv_value_4_0= RULE_NUMBER
                    {
                    lv_value_4_0=(Token)match(input,RULE_NUMBER,FOLLOW_2); 

                    			newLeafNode(lv_value_4_0, grammarAccess.getPrimaryExpressionAccess().getValueNUMBERTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_4_0, 
                            		"org.eclipse.xtext.example.arithmetics.Arithmetics.NUMBER");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalArithmetics.g:694:6: ( () ( (otherlv_6= RULE_ID ) ) (otherlv_7= '(' ( (lv_args_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_args_10_0= ruleExpression ) ) )* otherlv_11= ')' )? )
                    {
                    // InternalArithmetics.g:694:6: ( () ( (otherlv_6= RULE_ID ) ) (otherlv_7= '(' ( (lv_args_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_args_10_0= ruleExpression ) ) )* otherlv_11= ')' )? )
                    // InternalArithmetics.g:694:7: () ( (otherlv_6= RULE_ID ) ) (otherlv_7= '(' ( (lv_args_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_args_10_0= ruleExpression ) ) )* otherlv_11= ')' )?
                    {
                    // InternalArithmetics.g:694:7: ()
                    // InternalArithmetics.g:695:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrimaryExpressionAccess().getFunctionCallAction_2_0(),
                                current);
                        

                    }

                    // InternalArithmetics.g:700:2: ( (otherlv_6= RULE_ID ) )
                    // InternalArithmetics.g:701:1: (otherlv_6= RULE_ID )
                    {
                    // InternalArithmetics.g:701:1: (otherlv_6= RULE_ID )
                    // InternalArithmetics.g:702:3: otherlv_6= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                    	        }
                            
                    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_16); 

                    		newLeafNode(otherlv_6, grammarAccess.getPrimaryExpressionAccess().getFuncAbstractDefinitionCrossReference_2_1_0()); 
                    	

                    }


                    }

                    // InternalArithmetics.g:713:2: (otherlv_7= '(' ( (lv_args_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_args_10_0= ruleExpression ) ) )* otherlv_11= ')' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==17) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalArithmetics.g:713:4: otherlv_7= '(' ( (lv_args_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_args_10_0= ruleExpression ) ) )* otherlv_11= ')'
                            {
                            otherlv_7=(Token)match(input,17,FOLLOW_11); 

                                	newLeafNode(otherlv_7, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_2_2_0());
                                
                            // InternalArithmetics.g:717:1: ( (lv_args_8_0= ruleExpression ) )
                            // InternalArithmetics.g:718:1: (lv_args_8_0= ruleExpression )
                            {
                            // InternalArithmetics.g:718:1: (lv_args_8_0= ruleExpression )
                            // InternalArithmetics.g:719:3: lv_args_8_0= ruleExpression
                            {
                             
                            	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getArgsExpressionParserRuleCall_2_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_9);
                            lv_args_8_0=ruleExpression();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"args",
                                    		lv_args_8_0, 
                                    		"org.eclipse.xtext.example.arithmetics.Arithmetics.Expression");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // InternalArithmetics.g:735:2: (otherlv_9= ',' ( (lv_args_10_0= ruleExpression ) ) )*
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( (LA11_0==18) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // InternalArithmetics.g:735:4: otherlv_9= ',' ( (lv_args_10_0= ruleExpression ) )
                            	    {
                            	    otherlv_9=(Token)match(input,18,FOLLOW_11); 

                            	        	newLeafNode(otherlv_9, grammarAccess.getPrimaryExpressionAccess().getCommaKeyword_2_2_2_0());
                            	        
                            	    // InternalArithmetics.g:739:1: ( (lv_args_10_0= ruleExpression ) )
                            	    // InternalArithmetics.g:740:1: (lv_args_10_0= ruleExpression )
                            	    {
                            	    // InternalArithmetics.g:740:1: (lv_args_10_0= ruleExpression )
                            	    // InternalArithmetics.g:741:3: lv_args_10_0= ruleExpression
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getArgsExpressionParserRuleCall_2_2_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_9);
                            	    lv_args_10_0=ruleExpression();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"args",
                            	            		lv_args_10_0, 
                            	            		"org.eclipse.xtext.example.arithmetics.Arithmetics.Expression");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop11;
                                }
                            } while (true);

                            otherlv_11=(Token)match(input,19,FOLLOW_2); 

                                	newLeafNode(otherlv_11, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_2_2_3());
                                

                            }
                            break;

                    }


                    }


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
    // $ANTLR end "rulePrimaryExpression"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000032032L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000030032L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000030030L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001008002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000020002L});

}