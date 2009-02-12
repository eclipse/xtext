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
import org.eclipse.xtext.parser.terminalrules.services.HiddenTerminalsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalHiddenTerminalsTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'without'", "'hiddens'", "';'", "'with'", "'overriding'", "'('", "')'", "'call'", "'inheriting'", "'datatype'", "'rule'", "'hiding'"
    };
    public static final int RULE_ML_COMMENT=5;
    public static final int RULE_WS=4;
    public static final int EOF=-1;
    public static final int RULE_ANY_OTHER=7;
    public static final int RULE_SL_COMMENT=6;

        public InternalHiddenTerminalsTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g"; }


     
     	private HiddenTerminalsTestLanguageGrammarAccess grammarAccess;
     	
        public InternalHiddenTerminalsTestLanguageParser(TokenStream input, IAstFactory factory, HiddenTerminalsTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalHiddenTerminalsTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:70:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:70:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:71:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.prModel().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel72);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel82); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:78:1: ruleModel returns [EObject current=null] : ( ( ( (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens ) | this_OverridingHiddens= ruleOverridingHiddens ) | this_InheritingHiddens= ruleInheritingHiddens ) | this_DatatypeHiddens= ruleDatatypeHiddens ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_WithoutHiddens = null;

        EObject this_WithHiddens = null;

        EObject this_OverridingHiddens = null;

        EObject this_InheritingHiddens = null;

        EObject this_DatatypeHiddens = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:82:6: ( ( ( ( (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens ) | this_OverridingHiddens= ruleOverridingHiddens ) | this_InheritingHiddens= ruleInheritingHiddens ) | this_DatatypeHiddens= ruleDatatypeHiddens ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:83:1: ( ( ( (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens ) | this_OverridingHiddens= ruleOverridingHiddens ) | this_InheritingHiddens= ruleInheritingHiddens ) | this_DatatypeHiddens= ruleDatatypeHiddens )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:83:1: ( ( ( (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens ) | this_OverridingHiddens= ruleOverridingHiddens ) | this_InheritingHiddens= ruleInheritingHiddens ) | this_DatatypeHiddens= ruleDatatypeHiddens )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==8||(LA4_0>=11 && LA4_0<=12)||LA4_0==16) ) {
                alt4=1;
            }
            else if ( (LA4_0==17) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("83:1: ( ( ( (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens ) | this_OverridingHiddens= ruleOverridingHiddens ) | this_InheritingHiddens= ruleInheritingHiddens ) | this_DatatypeHiddens= ruleDatatypeHiddens )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:83:2: ( ( (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens ) | this_OverridingHiddens= ruleOverridingHiddens ) | this_InheritingHiddens= ruleInheritingHiddens )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:83:2: ( ( (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens ) | this_OverridingHiddens= ruleOverridingHiddens ) | this_InheritingHiddens= ruleInheritingHiddens )
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==8||(LA3_0>=11 && LA3_0<=12)) ) {
                        alt3=1;
                    }
                    else if ( (LA3_0==16) ) {
                        alt3=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("83:2: ( ( (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens ) | this_OverridingHiddens= ruleOverridingHiddens ) | this_InheritingHiddens= ruleInheritingHiddens )", 3, 0, input);

                        throw nvae;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:83:3: ( (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens ) | this_OverridingHiddens= ruleOverridingHiddens )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:83:3: ( (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens ) | this_OverridingHiddens= ruleOverridingHiddens )
                            int alt2=2;
                            int LA2_0 = input.LA(1);

                            if ( (LA2_0==8||LA2_0==11) ) {
                                alt2=1;
                            }
                            else if ( (LA2_0==12) ) {
                                alt2=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("83:3: ( (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens ) | this_OverridingHiddens= ruleOverridingHiddens )", 2, 0, input);

                                throw nvae;
                            }
                            switch (alt2) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:83:4: (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:83:4: (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens )
                                    int alt1=2;
                                    int LA1_0 = input.LA(1);

                                    if ( (LA1_0==8) ) {
                                        alt1=1;
                                    }
                                    else if ( (LA1_0==11) ) {
                                        alt1=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("83:4: (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens )", 1, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt1) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:84:5: this_WithoutHiddens= ruleWithoutHiddens
                                            {
                                             
                                                    currentNode=createCompositeNode(grammarAccess.prModel().ele0000ParserRuleCallWithoutHiddens(), currentNode); 
                                                
                                            pushFollow(FOLLOW_ruleWithoutHiddens_in_ruleModel132);
                                            this_WithoutHiddens=ruleWithoutHiddens();
                                            _fsp--;

                                             
                                                    current = this_WithoutHiddens; 
                                                    currentNode = currentNode.getParent();
                                                

                                            }
                                            break;
                                        case 2 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:94:5: this_WithHiddens= ruleWithHiddens
                                            {
                                             
                                                    currentNode=createCompositeNode(grammarAccess.prModel().ele0001ParserRuleCallWithHiddens(), currentNode); 
                                                
                                            pushFollow(FOLLOW_ruleWithHiddens_in_ruleModel159);
                                            this_WithHiddens=ruleWithHiddens();
                                            _fsp--;

                                             
                                                    current = this_WithHiddens; 
                                                    currentNode = currentNode.getParent();
                                                

                                            }
                                            break;

                                    }


                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:104:5: this_OverridingHiddens= ruleOverridingHiddens
                                    {
                                     
                                            currentNode=createCompositeNode(grammarAccess.prModel().ele001ParserRuleCallOverridingHiddens(), currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleOverridingHiddens_in_ruleModel187);
                                    this_OverridingHiddens=ruleOverridingHiddens();
                                    _fsp--;

                                     
                                            current = this_OverridingHiddens; 
                                            currentNode = currentNode.getParent();
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:114:5: this_InheritingHiddens= ruleInheritingHiddens
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prModel().ele01ParserRuleCallInheritingHiddens(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleInheritingHiddens_in_ruleModel215);
                            this_InheritingHiddens=ruleInheritingHiddens();
                            _fsp--;

                             
                                    current = this_InheritingHiddens; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:124:5: this_DatatypeHiddens= ruleDatatypeHiddens
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prModel().ele1ParserRuleCallDatatypeHiddens(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDatatypeHiddens_in_ruleModel243);
                    this_DatatypeHiddens=ruleDatatypeHiddens();
                    _fsp--;

                     
                            current = this_DatatypeHiddens; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleWithoutHiddens
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:141:1: entryRuleWithoutHiddens returns [EObject current=null] : iv_ruleWithoutHiddens= ruleWithoutHiddens EOF ;
    public final EObject entryRuleWithoutHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWithoutHiddens = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:141:56: (iv_ruleWithoutHiddens= ruleWithoutHiddens EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:142:2: iv_ruleWithoutHiddens= ruleWithoutHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.prWithoutHiddens().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleWithoutHiddens_in_entryRuleWithoutHiddens277);
            iv_ruleWithoutHiddens=ruleWithoutHiddens();
            _fsp--;

             current =iv_ruleWithoutHiddens; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWithoutHiddens287); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleWithoutHiddens


    // $ANTLR start ruleWithoutHiddens
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:149:1: ruleWithoutHiddens returns [EObject current=null] : ( ( ( ( 'without' (lv_spaces= RULE_WS ) ) 'hiddens' ) (lv_spaces= RULE_WS )? ) (lv_valid= ';' ) ) ;
    public final EObject ruleWithoutHiddens() throws RecognitionException {
        EObject current = null;

        Token lv_spaces=null;
        Token lv_valid=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:153:6: ( ( ( ( ( 'without' (lv_spaces= RULE_WS ) ) 'hiddens' ) (lv_spaces= RULE_WS )? ) (lv_valid= ';' ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:154:1: ( ( ( ( 'without' (lv_spaces= RULE_WS ) ) 'hiddens' ) (lv_spaces= RULE_WS )? ) (lv_valid= ';' ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:154:1: ( ( ( ( 'without' (lv_spaces= RULE_WS ) ) 'hiddens' ) (lv_spaces= RULE_WS )? ) (lv_valid= ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:154:2: ( ( ( 'without' (lv_spaces= RULE_WS ) ) 'hiddens' ) (lv_spaces= RULE_WS )? ) (lv_valid= ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:154:2: ( ( ( 'without' (lv_spaces= RULE_WS ) ) 'hiddens' ) (lv_spaces= RULE_WS )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:154:3: ( ( 'without' (lv_spaces= RULE_WS ) ) 'hiddens' ) (lv_spaces= RULE_WS )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:154:3: ( ( 'without' (lv_spaces= RULE_WS ) ) 'hiddens' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:154:4: ( 'without' (lv_spaces= RULE_WS ) ) 'hiddens'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:154:4: ( 'without' (lv_spaces= RULE_WS ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:154:5: 'without' (lv_spaces= RULE_WS )
            {
            match(input,8,FOLLOW_8_in_ruleWithoutHiddens324); 

                    createLeafNode(grammarAccess.prWithoutHiddens().ele0000KeywordWithout(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:158:1: (lv_spaces= RULE_WS )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:160:6: lv_spaces= RULE_WS
            {
            lv_spaces=(Token)input.LT(1);
            match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleWithoutHiddens345); 
             
                createLeafNode(grammarAccess.prWithoutHiddens().ele00010ParserRuleCallWS(), "spaces"); 
                

            	        if (current==null) {
            	            current = factory.create("WithoutHiddens");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.add(current, "spaces", lv_spaces, "WS", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,9,FOLLOW_9_in_ruleWithoutHiddens366); 

                    createLeafNode(grammarAccess.prWithoutHiddens().ele001KeywordHiddens(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:182:2: (lv_spaces= RULE_WS )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_WS) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:184:6: lv_spaces= RULE_WS
                    {
                    lv_spaces=(Token)input.LT(1);
                    match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleWithoutHiddens388); 
                     
                        createLeafNode(grammarAccess.prWithoutHiddens().ele010ParserRuleCallWS(), "spaces"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("WithoutHiddens");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.add(current, "spaces", lv_spaces, "WS", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:202:4: (lv_valid= ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:204:6: lv_valid= ';'
            {
            lv_valid=(Token)input.LT(1);
            match(input,10,FOLLOW_10_in_ruleWithoutHiddens422); 

                    createLeafNode(grammarAccess.prWithoutHiddens().ele10KeywordSemicolon(), "valid"); 
                

            	        if (current==null) {
            	            current = factory.create("WithoutHiddens");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "valid", true, ";", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleWithoutHiddens


    // $ANTLR start entryRuleWithHiddens
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:231:1: entryRuleWithHiddens returns [EObject current=null] : iv_ruleWithHiddens= ruleWithHiddens EOF ;
    public final EObject entryRuleWithHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWithHiddens = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:231:53: (iv_ruleWithHiddens= ruleWithHiddens EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:232:2: iv_ruleWithHiddens= ruleWithHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.prWithHiddens().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleWithHiddens_in_entryRuleWithHiddens469);
            iv_ruleWithHiddens=ruleWithHiddens();
            _fsp--;

             current =iv_ruleWithHiddens; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWithHiddens479); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleWithHiddens


    // $ANTLR start ruleWithHiddens
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:239:1: ruleWithHiddens returns [EObject current=null] : ( ( 'with' 'hiddens' ) (lv_valid= ';' ) ) ;
    public final EObject ruleWithHiddens() throws RecognitionException {
        EObject current = null;

        Token lv_valid=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:245:6: ( ( ( 'with' 'hiddens' ) (lv_valid= ';' ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:246:1: ( ( 'with' 'hiddens' ) (lv_valid= ';' ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:246:1: ( ( 'with' 'hiddens' ) (lv_valid= ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:246:2: ( 'with' 'hiddens' ) (lv_valid= ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:246:2: ( 'with' 'hiddens' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:246:3: 'with' 'hiddens'
            {
            match(input,11,FOLLOW_11_in_ruleWithHiddens514); 

                    createLeafNode(grammarAccess.prWithHiddens().ele00KeywordWith(), null); 
                
            match(input,9,FOLLOW_9_in_ruleWithHiddens523); 

                    createLeafNode(grammarAccess.prWithHiddens().ele01KeywordHiddens(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:254:2: (lv_valid= ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:256:6: lv_valid= ';'
            {
            lv_valid=(Token)input.LT(1);
            match(input,10,FOLLOW_10_in_ruleWithHiddens545); 

                    createLeafNode(grammarAccess.prWithHiddens().ele10KeywordSemicolon(), "valid"); 
                

            	        if (current==null) {
            	            current = factory.create("WithHiddens");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "valid", true, ";", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
            		myHiddenTokenState.restore();
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleWithHiddens


    // $ANTLR start entryRuleOverridingHiddens
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:283:1: entryRuleOverridingHiddens returns [EObject current=null] : iv_ruleOverridingHiddens= ruleOverridingHiddens EOF ;
    public final EObject entryRuleOverridingHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridingHiddens = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:283:59: (iv_ruleOverridingHiddens= ruleOverridingHiddens EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:284:2: iv_ruleOverridingHiddens= ruleOverridingHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.prOverridingHiddens().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleOverridingHiddens_in_entryRuleOverridingHiddens592);
            iv_ruleOverridingHiddens=ruleOverridingHiddens();
            _fsp--;

             current =iv_ruleOverridingHiddens; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOverridingHiddens602); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleOverridingHiddens


    // $ANTLR start ruleOverridingHiddens
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:291:1: ruleOverridingHiddens returns [EObject current=null] : ( ( ( ( ( 'overriding' 'hiddens' ) '(' ) (lv_called= ruleOverridingHiddensCall ) ) ')' ) (lv_valid= ';' ) ) ;
    public final EObject ruleOverridingHiddens() throws RecognitionException {
        EObject current = null;

        Token lv_valid=null;
        EObject lv_called = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:297:6: ( ( ( ( ( ( 'overriding' 'hiddens' ) '(' ) (lv_called= ruleOverridingHiddensCall ) ) ')' ) (lv_valid= ';' ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:298:1: ( ( ( ( ( 'overriding' 'hiddens' ) '(' ) (lv_called= ruleOverridingHiddensCall ) ) ')' ) (lv_valid= ';' ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:298:1: ( ( ( ( ( 'overriding' 'hiddens' ) '(' ) (lv_called= ruleOverridingHiddensCall ) ) ')' ) (lv_valid= ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:298:2: ( ( ( ( 'overriding' 'hiddens' ) '(' ) (lv_called= ruleOverridingHiddensCall ) ) ')' ) (lv_valid= ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:298:2: ( ( ( ( 'overriding' 'hiddens' ) '(' ) (lv_called= ruleOverridingHiddensCall ) ) ')' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:298:3: ( ( ( 'overriding' 'hiddens' ) '(' ) (lv_called= ruleOverridingHiddensCall ) ) ')'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:298:3: ( ( ( 'overriding' 'hiddens' ) '(' ) (lv_called= ruleOverridingHiddensCall ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:298:4: ( ( 'overriding' 'hiddens' ) '(' ) (lv_called= ruleOverridingHiddensCall )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:298:4: ( ( 'overriding' 'hiddens' ) '(' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:298:5: ( 'overriding' 'hiddens' ) '('
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:298:5: ( 'overriding' 'hiddens' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:298:6: 'overriding' 'hiddens'
            {
            match(input,12,FOLLOW_12_in_ruleOverridingHiddens640); 

                    createLeafNode(grammarAccess.prOverridingHiddens().ele00000KeywordOverriding(), null); 
                
            match(input,9,FOLLOW_9_in_ruleOverridingHiddens649); 

                    createLeafNode(grammarAccess.prOverridingHiddens().ele00001KeywordHiddens(), null); 
                

            }

            match(input,13,FOLLOW_13_in_ruleOverridingHiddens659); 

                    createLeafNode(grammarAccess.prOverridingHiddens().ele0001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:310:2: (lv_called= ruleOverridingHiddensCall )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:313:6: lv_called= ruleOverridingHiddensCall
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prOverridingHiddens().ele0010ParserRuleCallOverridingHiddensCall(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleOverridingHiddensCall_in_ruleOverridingHiddens694);
            lv_called=ruleOverridingHiddensCall();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("OverridingHiddens");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "called", lv_called, "OverridingHiddensCall", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,14,FOLLOW_14_in_ruleOverridingHiddens708); 

                    createLeafNode(grammarAccess.prOverridingHiddens().ele01KeywordRightParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:335:2: (lv_valid= ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:337:6: lv_valid= ';'
            {
            lv_valid=(Token)input.LT(1);
            match(input,10,FOLLOW_10_in_ruleOverridingHiddens730); 

                    createLeafNode(grammarAccess.prOverridingHiddens().ele10KeywordSemicolon(), "valid"); 
                

            	        if (current==null) {
            	            current = factory.create("OverridingHiddens");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "valid", true, ";", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
            		myHiddenTokenState.restore();
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleOverridingHiddens


    // $ANTLR start entryRuleOverridingHiddensCall
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:364:1: entryRuleOverridingHiddensCall returns [EObject current=null] : iv_ruleOverridingHiddensCall= ruleOverridingHiddensCall EOF ;
    public final EObject entryRuleOverridingHiddensCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridingHiddensCall = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:364:63: (iv_ruleOverridingHiddensCall= ruleOverridingHiddensCall EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:365:2: iv_ruleOverridingHiddensCall= ruleOverridingHiddensCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.prOverridingHiddensCall().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleOverridingHiddensCall_in_entryRuleOverridingHiddensCall777);
            iv_ruleOverridingHiddensCall=ruleOverridingHiddensCall();
            _fsp--;

             current =iv_ruleOverridingHiddensCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOverridingHiddensCall787); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleOverridingHiddensCall


    // $ANTLR start ruleOverridingHiddensCall
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:372:1: ruleOverridingHiddensCall returns [EObject current=null] : ( ( 'call' (lv_spaces= RULE_WS )? ) (lv_valid= ';' ) ) ;
    public final EObject ruleOverridingHiddensCall() throws RecognitionException {
        EObject current = null;

        Token lv_spaces=null;
        Token lv_valid=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:378:6: ( ( ( 'call' (lv_spaces= RULE_WS )? ) (lv_valid= ';' ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:379:1: ( ( 'call' (lv_spaces= RULE_WS )? ) (lv_valid= ';' ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:379:1: ( ( 'call' (lv_spaces= RULE_WS )? ) (lv_valid= ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:379:2: ( 'call' (lv_spaces= RULE_WS )? ) (lv_valid= ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:379:2: ( 'call' (lv_spaces= RULE_WS )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:379:3: 'call' (lv_spaces= RULE_WS )?
            {
            match(input,15,FOLLOW_15_in_ruleOverridingHiddensCall822); 

                    createLeafNode(grammarAccess.prOverridingHiddensCall().ele00KeywordCall(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:383:1: (lv_spaces= RULE_WS )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_WS) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:385:6: lv_spaces= RULE_WS
                    {
                    lv_spaces=(Token)input.LT(1);
                    match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleOverridingHiddensCall843); 
                     
                        createLeafNode(grammarAccess.prOverridingHiddensCall().ele010ParserRuleCallWS(), "spaces"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("OverridingHiddensCall");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.add(current, "spaces", lv_spaces, "WS", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:403:4: (lv_valid= ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:405:6: lv_valid= ';'
            {
            lv_valid=(Token)input.LT(1);
            match(input,10,FOLLOW_10_in_ruleOverridingHiddensCall877); 

                    createLeafNode(grammarAccess.prOverridingHiddensCall().ele10KeywordSemicolon(), "valid"); 
                

            	        if (current==null) {
            	            current = factory.create("OverridingHiddensCall");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "valid", true, ";", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
            		myHiddenTokenState.restore();
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleOverridingHiddensCall


    // $ANTLR start entryRuleInheritingHiddens
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:432:1: entryRuleInheritingHiddens returns [EObject current=null] : iv_ruleInheritingHiddens= ruleInheritingHiddens EOF ;
    public final EObject entryRuleInheritingHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritingHiddens = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:432:59: (iv_ruleInheritingHiddens= ruleInheritingHiddens EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:433:2: iv_ruleInheritingHiddens= ruleInheritingHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.prInheritingHiddens().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleInheritingHiddens_in_entryRuleInheritingHiddens924);
            iv_ruleInheritingHiddens=ruleInheritingHiddens();
            _fsp--;

             current =iv_ruleInheritingHiddens; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInheritingHiddens934); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleInheritingHiddens


    // $ANTLR start ruleInheritingHiddens
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:440:1: ruleInheritingHiddens returns [EObject current=null] : ( ( ( ( ( 'inheriting' 'hiddens' ) '(' ) ( (lv_called= ruleInheritingHiddensCall ) | (lv_hidingCalled= ruleHidingHiddens ) ) ) ')' ) (lv_valid= ';' ) ) ;
    public final EObject ruleInheritingHiddens() throws RecognitionException {
        EObject current = null;

        Token lv_valid=null;
        EObject lv_called = null;

        EObject lv_hidingCalled = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:446:6: ( ( ( ( ( ( 'inheriting' 'hiddens' ) '(' ) ( (lv_called= ruleInheritingHiddensCall ) | (lv_hidingCalled= ruleHidingHiddens ) ) ) ')' ) (lv_valid= ';' ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:447:1: ( ( ( ( ( 'inheriting' 'hiddens' ) '(' ) ( (lv_called= ruleInheritingHiddensCall ) | (lv_hidingCalled= ruleHidingHiddens ) ) ) ')' ) (lv_valid= ';' ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:447:1: ( ( ( ( ( 'inheriting' 'hiddens' ) '(' ) ( (lv_called= ruleInheritingHiddensCall ) | (lv_hidingCalled= ruleHidingHiddens ) ) ) ')' ) (lv_valid= ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:447:2: ( ( ( ( 'inheriting' 'hiddens' ) '(' ) ( (lv_called= ruleInheritingHiddensCall ) | (lv_hidingCalled= ruleHidingHiddens ) ) ) ')' ) (lv_valid= ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:447:2: ( ( ( ( 'inheriting' 'hiddens' ) '(' ) ( (lv_called= ruleInheritingHiddensCall ) | (lv_hidingCalled= ruleHidingHiddens ) ) ) ')' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:447:3: ( ( ( 'inheriting' 'hiddens' ) '(' ) ( (lv_called= ruleInheritingHiddensCall ) | (lv_hidingCalled= ruleHidingHiddens ) ) ) ')'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:447:3: ( ( ( 'inheriting' 'hiddens' ) '(' ) ( (lv_called= ruleInheritingHiddensCall ) | (lv_hidingCalled= ruleHidingHiddens ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:447:4: ( ( 'inheriting' 'hiddens' ) '(' ) ( (lv_called= ruleInheritingHiddensCall ) | (lv_hidingCalled= ruleHidingHiddens ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:447:4: ( ( 'inheriting' 'hiddens' ) '(' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:447:5: ( 'inheriting' 'hiddens' ) '('
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:447:5: ( 'inheriting' 'hiddens' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:447:6: 'inheriting' 'hiddens'
            {
            match(input,16,FOLLOW_16_in_ruleInheritingHiddens972); 

                    createLeafNode(grammarAccess.prInheritingHiddens().ele00000KeywordInheriting(), null); 
                
            match(input,9,FOLLOW_9_in_ruleInheritingHiddens981); 

                    createLeafNode(grammarAccess.prInheritingHiddens().ele00001KeywordHiddens(), null); 
                

            }

            match(input,13,FOLLOW_13_in_ruleInheritingHiddens991); 

                    createLeafNode(grammarAccess.prInheritingHiddens().ele0001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:459:2: ( (lv_called= ruleInheritingHiddensCall ) | (lv_hidingCalled= ruleHidingHiddens ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                alt7=1;
            }
            else if ( (LA7_0==19) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("459:2: ( (lv_called= ruleInheritingHiddensCall ) | (lv_hidingCalled= ruleHidingHiddens ) )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:459:3: (lv_called= ruleInheritingHiddensCall )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:459:3: (lv_called= ruleInheritingHiddensCall )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:462:6: lv_called= ruleInheritingHiddensCall
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prInheritingHiddens().ele00100ParserRuleCallInheritingHiddensCall(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleInheritingHiddensCall_in_ruleInheritingHiddens1027);
                    lv_called=ruleInheritingHiddensCall();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("InheritingHiddens");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "called", lv_called, "InheritingHiddensCall", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:481:6: (lv_hidingCalled= ruleHidingHiddens )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:481:6: (lv_hidingCalled= ruleHidingHiddens )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:484:6: lv_hidingCalled= ruleHidingHiddens
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prInheritingHiddens().ele00110ParserRuleCallHidingHiddens(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleHidingHiddens_in_ruleInheritingHiddens1071);
                    lv_hidingCalled=ruleHidingHiddens();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("InheritingHiddens");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "hidingCalled", lv_hidingCalled, "HidingHiddens", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }

            match(input,14,FOLLOW_14_in_ruleInheritingHiddens1086); 

                    createLeafNode(grammarAccess.prInheritingHiddens().ele01KeywordRightParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:506:2: (lv_valid= ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:508:6: lv_valid= ';'
            {
            lv_valid=(Token)input.LT(1);
            match(input,10,FOLLOW_10_in_ruleInheritingHiddens1108); 

                    createLeafNode(grammarAccess.prInheritingHiddens().ele10KeywordSemicolon(), "valid"); 
                

            	        if (current==null) {
            	            current = factory.create("InheritingHiddens");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "valid", true, ";", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
            		myHiddenTokenState.restore();
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleInheritingHiddens


    // $ANTLR start entryRuleDatatypeHiddens
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:535:1: entryRuleDatatypeHiddens returns [EObject current=null] : iv_ruleDatatypeHiddens= ruleDatatypeHiddens EOF ;
    public final EObject entryRuleDatatypeHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatypeHiddens = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:535:57: (iv_ruleDatatypeHiddens= ruleDatatypeHiddens EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:536:2: iv_ruleDatatypeHiddens= ruleDatatypeHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.prDatatypeHiddens().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleDatatypeHiddens_in_entryRuleDatatypeHiddens1155);
            iv_ruleDatatypeHiddens=ruleDatatypeHiddens();
            _fsp--;

             current =iv_ruleDatatypeHiddens; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDatatypeHiddens1165); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDatatypeHiddens


    // $ANTLR start ruleDatatypeHiddens
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:543:1: ruleDatatypeHiddens returns [EObject current=null] : ( 'datatype' (lv_valid= ruleDatatypeRule ) ) ;
    public final EObject ruleDatatypeHiddens() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_valid = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:547:6: ( ( 'datatype' (lv_valid= ruleDatatypeRule ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:548:1: ( 'datatype' (lv_valid= ruleDatatypeRule ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:548:1: ( 'datatype' (lv_valid= ruleDatatypeRule ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:548:2: 'datatype' (lv_valid= ruleDatatypeRule )
            {
            match(input,17,FOLLOW_17_in_ruleDatatypeHiddens1199); 

                    createLeafNode(grammarAccess.prDatatypeHiddens().ele0KeywordDatatype(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:552:1: (lv_valid= ruleDatatypeRule )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:555:6: lv_valid= ruleDatatypeRule
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prDatatypeHiddens().ele10ParserRuleCallDatatypeRule(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleDatatypeRule_in_ruleDatatypeHiddens1233);
            lv_valid=ruleDatatypeRule();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("DatatypeHiddens");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "valid", true, "DatatypeRule", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }

             resetLookahead(); 
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleDatatypeHiddens


    // $ANTLR start entryRuleDatatypeRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:582:1: entryRuleDatatypeRule returns [String current=null] : iv_ruleDatatypeRule= ruleDatatypeRule EOF ;
    public final String entryRuleDatatypeRule() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatypeRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:582:53: (iv_ruleDatatypeRule= ruleDatatypeRule EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:583:2: iv_ruleDatatypeRule= ruleDatatypeRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prDatatypeRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleDatatypeRule_in_entryRuleDatatypeRule1273);
            iv_ruleDatatypeRule=ruleDatatypeRule();
            _fsp--;

             current =iv_ruleDatatypeRule.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDatatypeRule1284); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDatatypeRule


    // $ANTLR start ruleDatatypeRule
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:590:1: ruleDatatypeRule returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'rule' kw= ';' ) ;
    public final AntlrDatatypeRuleToken ruleDatatypeRule() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:596:6: ( (kw= 'rule' kw= ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:597:1: (kw= 'rule' kw= ';' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:597:1: (kw= 'rule' kw= ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:598:2: kw= 'rule' kw= ';'
            {
            kw=(Token)input.LT(1);
            match(input,18,FOLLOW_18_in_ruleDatatypeRule1322); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.prDatatypeRule().ele0KeywordRule(), null); 
                
            kw=(Token)input.LT(1);
            match(input,10,FOLLOW_10_in_ruleDatatypeRule1335); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.prDatatypeRule().ele1KeywordSemicolon(), null); 
                

            }


            }

             resetLookahead(); 
            		myHiddenTokenState.restore();
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleDatatypeRule


    // $ANTLR start entryRuleHidingHiddens
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:619:1: entryRuleHidingHiddens returns [EObject current=null] : iv_ruleHidingHiddens= ruleHidingHiddens EOF ;
    public final EObject entryRuleHidingHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHidingHiddens = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:619:55: (iv_ruleHidingHiddens= ruleHidingHiddens EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:620:2: iv_ruleHidingHiddens= ruleHidingHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.prHidingHiddens().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleHidingHiddens_in_entryRuleHidingHiddens1375);
            iv_ruleHidingHiddens=ruleHidingHiddens();
            _fsp--;

             current =iv_ruleHidingHiddens; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHidingHiddens1385); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleHidingHiddens


    // $ANTLR start ruleHidingHiddens
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:627:1: ruleHidingHiddens returns [EObject current=null] : ( ( 'hiding' (lv_space= RULE_WS ) ) (lv_called= ruleInheritingHiddensCall ) ) ;
    public final EObject ruleHidingHiddens() throws RecognitionException {
        EObject current = null;

        Token lv_space=null;
        EObject lv_called = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:633:6: ( ( ( 'hiding' (lv_space= RULE_WS ) ) (lv_called= ruleInheritingHiddensCall ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:634:1: ( ( 'hiding' (lv_space= RULE_WS ) ) (lv_called= ruleInheritingHiddensCall ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:634:1: ( ( 'hiding' (lv_space= RULE_WS ) ) (lv_called= ruleInheritingHiddensCall ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:634:2: ( 'hiding' (lv_space= RULE_WS ) ) (lv_called= ruleInheritingHiddensCall )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:634:2: ( 'hiding' (lv_space= RULE_WS ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:634:3: 'hiding' (lv_space= RULE_WS )
            {
            match(input,19,FOLLOW_19_in_ruleHidingHiddens1420); 

                    createLeafNode(grammarAccess.prHidingHiddens().ele00KeywordHiding(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:638:1: (lv_space= RULE_WS )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:640:6: lv_space= RULE_WS
            {
            lv_space=(Token)input.LT(1);
            match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleHidingHiddens1441); 
             
                createLeafNode(grammarAccess.prHidingHiddens().ele010ParserRuleCallWS(), "space"); 
                

            	        if (current==null) {
            	            current = factory.create("HidingHiddens");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "space", lv_space, "WS", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:658:3: (lv_called= ruleInheritingHiddensCall )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:661:6: lv_called= ruleInheritingHiddensCall
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prHidingHiddens().ele10ParserRuleCallInheritingHiddensCall(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleInheritingHiddensCall_in_ruleHidingHiddens1487);
            lv_called=ruleInheritingHiddensCall();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("HidingHiddens");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "called", lv_called, "InheritingHiddensCall", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }

             resetLookahead(); 
            		myHiddenTokenState.restore();
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleHidingHiddens


    // $ANTLR start entryRuleInheritingHiddensCall
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:688:1: entryRuleInheritingHiddensCall returns [EObject current=null] : iv_ruleInheritingHiddensCall= ruleInheritingHiddensCall EOF ;
    public final EObject entryRuleInheritingHiddensCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritingHiddensCall = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:688:63: (iv_ruleInheritingHiddensCall= ruleInheritingHiddensCall EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:689:2: iv_ruleInheritingHiddensCall= ruleInheritingHiddensCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.prInheritingHiddensCall().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleInheritingHiddensCall_in_entryRuleInheritingHiddensCall1526);
            iv_ruleInheritingHiddensCall=ruleInheritingHiddensCall();
            _fsp--;

             current =iv_ruleInheritingHiddensCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInheritingHiddensCall1536); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleInheritingHiddensCall


    // $ANTLR start ruleInheritingHiddensCall
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:696:1: ruleInheritingHiddensCall returns [EObject current=null] : ( 'call' (lv_valid= ';' ) ) ;
    public final EObject ruleInheritingHiddensCall() throws RecognitionException {
        EObject current = null;

        Token lv_valid=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:700:6: ( ( 'call' (lv_valid= ';' ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:701:1: ( 'call' (lv_valid= ';' ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:701:1: ( 'call' (lv_valid= ';' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:701:2: 'call' (lv_valid= ';' )
            {
            match(input,15,FOLLOW_15_in_ruleInheritingHiddensCall1570); 

                    createLeafNode(grammarAccess.prInheritingHiddensCall().ele0KeywordCall(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:705:1: (lv_valid= ';' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:707:6: lv_valid= ';'
            {
            lv_valid=(Token)input.LT(1);
            match(input,10,FOLLOW_10_in_ruleInheritingHiddensCall1591); 

                    createLeafNode(grammarAccess.prInheritingHiddensCall().ele10KeywordSemicolon(), "valid"); 
                

            	        if (current==null) {
            	            current = factory.create("InheritingHiddensCall");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "valid", true, ";", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleInheritingHiddensCall


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWithoutHiddens_in_ruleModel132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWithHiddens_in_ruleModel159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOverridingHiddens_in_ruleModel187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInheritingHiddens_in_ruleModel215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatypeHiddens_in_ruleModel243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWithoutHiddens_in_entryRuleWithoutHiddens277 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWithoutHiddens287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_8_in_ruleWithoutHiddens324 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleWithoutHiddens345 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleWithoutHiddens366 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleWithoutHiddens388 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleWithoutHiddens422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWithHiddens_in_entryRuleWithHiddens469 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWithHiddens479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleWithHiddens514 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleWithHiddens523 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleWithHiddens545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOverridingHiddens_in_entryRuleOverridingHiddens592 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOverridingHiddens602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleOverridingHiddens640 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleOverridingHiddens649 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleOverridingHiddens659 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ruleOverridingHiddensCall_in_ruleOverridingHiddens694 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleOverridingHiddens708 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleOverridingHiddens730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOverridingHiddensCall_in_entryRuleOverridingHiddensCall777 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOverridingHiddensCall787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleOverridingHiddensCall822 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleOverridingHiddensCall843 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleOverridingHiddensCall877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInheritingHiddens_in_entryRuleInheritingHiddens924 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInheritingHiddens934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleInheritingHiddens972 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleInheritingHiddens981 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleInheritingHiddens991 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_ruleInheritingHiddensCall_in_ruleInheritingHiddens1027 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleHidingHiddens_in_ruleInheritingHiddens1071 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleInheritingHiddens1086 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleInheritingHiddens1108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatypeHiddens_in_entryRuleDatatypeHiddens1155 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeHiddens1165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleDatatypeHiddens1199 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ruleDatatypeRule_in_ruleDatatypeHiddens1233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatypeRule_in_entryRuleDatatypeRule1273 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeRule1284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleDatatypeRule1322 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleDatatypeRule1335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHidingHiddens_in_entryRuleHidingHiddens1375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHidingHiddens1385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleHidingHiddens1420 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleHidingHiddens1441 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ruleInheritingHiddensCall_in_ruleHidingHiddens1487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInheritingHiddensCall_in_entryRuleInheritingHiddensCall1526 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInheritingHiddensCall1536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleInheritingHiddensCall1570 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleInheritingHiddensCall1591 = new BitSet(new long[]{0x0000000000000002L});

}