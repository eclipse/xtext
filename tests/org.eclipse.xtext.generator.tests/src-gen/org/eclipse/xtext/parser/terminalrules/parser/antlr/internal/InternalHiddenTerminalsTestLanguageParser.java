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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalHiddenTerminalsTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'without'", "'hiddens'", "';'", "'with'", "'overriding'", "'('", "')'", "'call'", "'inheriting'", "'hiding'"
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
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g"; }


     
        public InternalHiddenTerminalsTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:68:47: (iv_ruleModel= ruleModel EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( ( (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens ) | this_OverridingHiddens= ruleOverridingHiddens ) | this_InheritingHiddens= ruleInheritingHiddens ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_WithoutHiddens = null;

        EObject this_WithHiddens = null;

        EObject this_OverridingHiddens = null;

        EObject this_InheritingHiddens = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:80:6: ( ( ( (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens ) | this_OverridingHiddens= ruleOverridingHiddens ) | this_InheritingHiddens= ruleInheritingHiddens ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:81:1: ( ( (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens ) | this_OverridingHiddens= ruleOverridingHiddens ) | this_InheritingHiddens= ruleInheritingHiddens )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:81:1: ( ( (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens ) | this_OverridingHiddens= ruleOverridingHiddens ) | this_InheritingHiddens= ruleInheritingHiddens )
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
                    new NoViableAltException("81:1: ( ( (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens ) | this_OverridingHiddens= ruleOverridingHiddens ) | this_InheritingHiddens= ruleInheritingHiddens )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:81:2: ( (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens ) | this_OverridingHiddens= ruleOverridingHiddens )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:81:2: ( (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens ) | this_OverridingHiddens= ruleOverridingHiddens )
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
                            new NoViableAltException("81:2: ( (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens ) | this_OverridingHiddens= ruleOverridingHiddens )", 2, 0, input);

                        throw nvae;
                    }
                    switch (alt2) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:81:3: (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens )
                            {
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:81:3: (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens )
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
                                    new NoViableAltException("81:3: (this_WithoutHiddens= ruleWithoutHiddens | this_WithHiddens= ruleWithHiddens )", 1, 0, input);

                                throw nvae;
                            }
                            switch (alt1) {
                                case 1 :
                                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:82:5: this_WithoutHiddens= ruleWithoutHiddens
                                    {
                                     
                                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@groups.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleWithoutHiddens_in_ruleModel131);
                                    this_WithoutHiddens=ruleWithoutHiddens();
                                    _fsp--;

                                     
                                            current = this_WithoutHiddens; 
                                            currentNode = currentNode.getParent();
                                        

                                    }
                                    break;
                                case 2 :
                                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:92:5: this_WithHiddens= ruleWithHiddens
                                    {
                                     
                                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleWithHiddens_in_ruleModel158);
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
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:102:5: this_OverridingHiddens= ruleOverridingHiddens
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleOverridingHiddens_in_ruleModel186);
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
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:112:5: this_InheritingHiddens= ruleInheritingHiddens
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleInheritingHiddens_in_ruleModel214);
                    this_InheritingHiddens=ruleInheritingHiddens();
                    _fsp--;

                     
                            current = this_InheritingHiddens; 
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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:129:1: entryRuleWithoutHiddens returns [EObject current=null] : iv_ruleWithoutHiddens= ruleWithoutHiddens EOF ;
    public final EObject entryRuleWithoutHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWithoutHiddens = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:129:56: (iv_ruleWithoutHiddens= ruleWithoutHiddens EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:130:2: iv_ruleWithoutHiddens= ruleWithoutHiddens EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleWithoutHiddens_in_entryRuleWithoutHiddens248);
            iv_ruleWithoutHiddens=ruleWithoutHiddens();
            _fsp--;

             current =iv_ruleWithoutHiddens; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWithoutHiddens258); 

            }

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:137:1: ruleWithoutHiddens returns [EObject current=null] : ( ( ( ( 'without' (lv_spaces= RULE_WS ) ) 'hiddens' ) (lv_spaces= RULE_WS )? ) (lv_valid= ';' ) ) ;
    public final EObject ruleWithoutHiddens() throws RecognitionException {
        EObject current = null;

        Token lv_spaces=null;
        Token lv_valid=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:141:6: ( ( ( ( ( 'without' (lv_spaces= RULE_WS ) ) 'hiddens' ) (lv_spaces= RULE_WS )? ) (lv_valid= ';' ) ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:142:1: ( ( ( ( 'without' (lv_spaces= RULE_WS ) ) 'hiddens' ) (lv_spaces= RULE_WS )? ) (lv_valid= ';' ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:142:1: ( ( ( ( 'without' (lv_spaces= RULE_WS ) ) 'hiddens' ) (lv_spaces= RULE_WS )? ) (lv_valid= ';' ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:142:2: ( ( ( 'without' (lv_spaces= RULE_WS ) ) 'hiddens' ) (lv_spaces= RULE_WS )? ) (lv_valid= ';' )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:142:2: ( ( ( 'without' (lv_spaces= RULE_WS ) ) 'hiddens' ) (lv_spaces= RULE_WS )? )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:142:3: ( ( 'without' (lv_spaces= RULE_WS ) ) 'hiddens' ) (lv_spaces= RULE_WS )?
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:142:3: ( ( 'without' (lv_spaces= RULE_WS ) ) 'hiddens' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:142:4: ( 'without' (lv_spaces= RULE_WS ) ) 'hiddens'
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:142:4: ( 'without' (lv_spaces= RULE_WS ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:142:5: 'without' (lv_spaces= RULE_WS )
            {
            match(input,8,FOLLOW_8_in_ruleWithoutHiddens295); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:146:1: (lv_spaces= RULE_WS )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:148:6: lv_spaces= RULE_WS
            {
            lv_spaces=(Token)input.LT(1);
            match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleWithoutHiddens316); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "spaces"); 
                

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

            match(input,9,FOLLOW_9_in_ruleWithoutHiddens337); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:170:2: (lv_spaces= RULE_WS )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_WS) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:172:6: lv_spaces= RULE_WS
                    {
                    lv_spaces=(Token)input.LT(1);
                    match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleWithoutHiddens359); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "spaces"); 
                        

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

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:190:4: (lv_valid= ';' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:192:6: lv_valid= ';'
            {
            lv_valid=(Token)input.LT(1);
            match(input,10,FOLLOW_10_in_ruleWithoutHiddens393); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "valid"); 
                

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:219:1: entryRuleWithHiddens returns [EObject current=null] : iv_ruleWithHiddens= ruleWithHiddens EOF ;
    public final EObject entryRuleWithHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWithHiddens = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:219:53: (iv_ruleWithHiddens= ruleWithHiddens EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:220:2: iv_ruleWithHiddens= ruleWithHiddens EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleWithHiddens_in_entryRuleWithHiddens440);
            iv_ruleWithHiddens=ruleWithHiddens();
            _fsp--;

             current =iv_ruleWithHiddens; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWithHiddens450); 

            }

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:227:1: ruleWithHiddens returns [EObject current=null] : ( ( 'with' 'hiddens' ) (lv_valid= ';' ) ) ;
    public final EObject ruleWithHiddens() throws RecognitionException {
        EObject current = null;

        Token lv_valid=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
            
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:233:6: ( ( ( 'with' 'hiddens' ) (lv_valid= ';' ) ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:234:1: ( ( 'with' 'hiddens' ) (lv_valid= ';' ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:234:1: ( ( 'with' 'hiddens' ) (lv_valid= ';' ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:234:2: ( 'with' 'hiddens' ) (lv_valid= ';' )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:234:2: ( 'with' 'hiddens' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:234:3: 'with' 'hiddens'
            {
            match(input,11,FOLLOW_11_in_ruleWithHiddens485); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,9,FOLLOW_9_in_ruleWithHiddens494); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:242:2: (lv_valid= ';' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:244:6: lv_valid= ';'
            {
            lv_valid=(Token)input.LT(1);
            match(input,10,FOLLOW_10_in_ruleWithHiddens516); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "valid"); 
                

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:271:1: entryRuleOverridingHiddens returns [EObject current=null] : iv_ruleOverridingHiddens= ruleOverridingHiddens EOF ;
    public final EObject entryRuleOverridingHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridingHiddens = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:271:59: (iv_ruleOverridingHiddens= ruleOverridingHiddens EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:272:2: iv_ruleOverridingHiddens= ruleOverridingHiddens EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleOverridingHiddens_in_entryRuleOverridingHiddens563);
            iv_ruleOverridingHiddens=ruleOverridingHiddens();
            _fsp--;

             current =iv_ruleOverridingHiddens; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOverridingHiddens573); 

            }

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:279:1: ruleOverridingHiddens returns [EObject current=null] : ( ( ( ( ( 'overriding' 'hiddens' ) '(' ) (lv_called= ruleOverridingHiddensCall ) ) ')' ) (lv_valid= ';' ) ) ;
    public final EObject ruleOverridingHiddens() throws RecognitionException {
        EObject current = null;

        Token lv_valid=null;
        EObject lv_called = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
            
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:285:6: ( ( ( ( ( ( 'overriding' 'hiddens' ) '(' ) (lv_called= ruleOverridingHiddensCall ) ) ')' ) (lv_valid= ';' ) ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:286:1: ( ( ( ( ( 'overriding' 'hiddens' ) '(' ) (lv_called= ruleOverridingHiddensCall ) ) ')' ) (lv_valid= ';' ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:286:1: ( ( ( ( ( 'overriding' 'hiddens' ) '(' ) (lv_called= ruleOverridingHiddensCall ) ) ')' ) (lv_valid= ';' ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:286:2: ( ( ( ( 'overriding' 'hiddens' ) '(' ) (lv_called= ruleOverridingHiddensCall ) ) ')' ) (lv_valid= ';' )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:286:2: ( ( ( ( 'overriding' 'hiddens' ) '(' ) (lv_called= ruleOverridingHiddensCall ) ) ')' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:286:3: ( ( ( 'overriding' 'hiddens' ) '(' ) (lv_called= ruleOverridingHiddensCall ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:286:3: ( ( ( 'overriding' 'hiddens' ) '(' ) (lv_called= ruleOverridingHiddensCall ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:286:4: ( ( 'overriding' 'hiddens' ) '(' ) (lv_called= ruleOverridingHiddensCall )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:286:4: ( ( 'overriding' 'hiddens' ) '(' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:286:5: ( 'overriding' 'hiddens' ) '('
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:286:5: ( 'overriding' 'hiddens' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:286:6: 'overriding' 'hiddens'
            {
            match(input,12,FOLLOW_12_in_ruleOverridingHiddens611); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,9,FOLLOW_9_in_ruleOverridingHiddens620); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,13,FOLLOW_13_in_ruleOverridingHiddens630); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:298:2: (lv_called= ruleOverridingHiddensCall )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:301:6: lv_called= ruleOverridingHiddensCall
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleOverridingHiddensCall_in_ruleOverridingHiddens665);
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

            match(input,14,FOLLOW_14_in_ruleOverridingHiddens679); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:323:2: (lv_valid= ';' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:325:6: lv_valid= ';'
            {
            lv_valid=(Token)input.LT(1);
            match(input,10,FOLLOW_10_in_ruleOverridingHiddens701); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "valid"); 
                

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:352:1: entryRuleOverridingHiddensCall returns [EObject current=null] : iv_ruleOverridingHiddensCall= ruleOverridingHiddensCall EOF ;
    public final EObject entryRuleOverridingHiddensCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridingHiddensCall = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:352:63: (iv_ruleOverridingHiddensCall= ruleOverridingHiddensCall EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:353:2: iv_ruleOverridingHiddensCall= ruleOverridingHiddensCall EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleOverridingHiddensCall_in_entryRuleOverridingHiddensCall748);
            iv_ruleOverridingHiddensCall=ruleOverridingHiddensCall();
            _fsp--;

             current =iv_ruleOverridingHiddensCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOverridingHiddensCall758); 

            }

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:360:1: ruleOverridingHiddensCall returns [EObject current=null] : ( ( 'call' (lv_spaces= RULE_WS )? ) (lv_valid= ';' ) ) ;
    public final EObject ruleOverridingHiddensCall() throws RecognitionException {
        EObject current = null;

        Token lv_spaces=null;
        Token lv_valid=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:366:6: ( ( ( 'call' (lv_spaces= RULE_WS )? ) (lv_valid= ';' ) ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:367:1: ( ( 'call' (lv_spaces= RULE_WS )? ) (lv_valid= ';' ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:367:1: ( ( 'call' (lv_spaces= RULE_WS )? ) (lv_valid= ';' ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:367:2: ( 'call' (lv_spaces= RULE_WS )? ) (lv_valid= ';' )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:367:2: ( 'call' (lv_spaces= RULE_WS )? )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:367:3: 'call' (lv_spaces= RULE_WS )?
            {
            match(input,15,FOLLOW_15_in_ruleOverridingHiddensCall793); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:371:1: (lv_spaces= RULE_WS )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_WS) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:373:6: lv_spaces= RULE_WS
                    {
                    lv_spaces=(Token)input.LT(1);
                    match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleOverridingHiddensCall814); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "spaces"); 
                        

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

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:391:4: (lv_valid= ';' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:393:6: lv_valid= ';'
            {
            lv_valid=(Token)input.LT(1);
            match(input,10,FOLLOW_10_in_ruleOverridingHiddensCall848); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "valid"); 
                

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:420:1: entryRuleInheritingHiddens returns [EObject current=null] : iv_ruleInheritingHiddens= ruleInheritingHiddens EOF ;
    public final EObject entryRuleInheritingHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritingHiddens = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:420:59: (iv_ruleInheritingHiddens= ruleInheritingHiddens EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:421:2: iv_ruleInheritingHiddens= ruleInheritingHiddens EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleInheritingHiddens_in_entryRuleInheritingHiddens895);
            iv_ruleInheritingHiddens=ruleInheritingHiddens();
            _fsp--;

             current =iv_ruleInheritingHiddens; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInheritingHiddens905); 

            }

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:428:1: ruleInheritingHiddens returns [EObject current=null] : ( ( ( ( ( 'inheriting' 'hiddens' ) '(' ) ( (lv_called= ruleInheritingHiddensCall ) | (lv_hidingCalled= ruleHidingHiddens ) ) ) ')' ) (lv_valid= ';' ) ) ;
    public final EObject ruleInheritingHiddens() throws RecognitionException {
        EObject current = null;

        Token lv_valid=null;
        EObject lv_called = null;

        EObject lv_hidingCalled = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
            
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:434:6: ( ( ( ( ( ( 'inheriting' 'hiddens' ) '(' ) ( (lv_called= ruleInheritingHiddensCall ) | (lv_hidingCalled= ruleHidingHiddens ) ) ) ')' ) (lv_valid= ';' ) ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:435:1: ( ( ( ( ( 'inheriting' 'hiddens' ) '(' ) ( (lv_called= ruleInheritingHiddensCall ) | (lv_hidingCalled= ruleHidingHiddens ) ) ) ')' ) (lv_valid= ';' ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:435:1: ( ( ( ( ( 'inheriting' 'hiddens' ) '(' ) ( (lv_called= ruleInheritingHiddensCall ) | (lv_hidingCalled= ruleHidingHiddens ) ) ) ')' ) (lv_valid= ';' ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:435:2: ( ( ( ( 'inheriting' 'hiddens' ) '(' ) ( (lv_called= ruleInheritingHiddensCall ) | (lv_hidingCalled= ruleHidingHiddens ) ) ) ')' ) (lv_valid= ';' )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:435:2: ( ( ( ( 'inheriting' 'hiddens' ) '(' ) ( (lv_called= ruleInheritingHiddensCall ) | (lv_hidingCalled= ruleHidingHiddens ) ) ) ')' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:435:3: ( ( ( 'inheriting' 'hiddens' ) '(' ) ( (lv_called= ruleInheritingHiddensCall ) | (lv_hidingCalled= ruleHidingHiddens ) ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:435:3: ( ( ( 'inheriting' 'hiddens' ) '(' ) ( (lv_called= ruleInheritingHiddensCall ) | (lv_hidingCalled= ruleHidingHiddens ) ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:435:4: ( ( 'inheriting' 'hiddens' ) '(' ) ( (lv_called= ruleInheritingHiddensCall ) | (lv_hidingCalled= ruleHidingHiddens ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:435:4: ( ( 'inheriting' 'hiddens' ) '(' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:435:5: ( 'inheriting' 'hiddens' ) '('
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:435:5: ( 'inheriting' 'hiddens' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:435:6: 'inheriting' 'hiddens'
            {
            match(input,16,FOLLOW_16_in_ruleInheritingHiddens943); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,9,FOLLOW_9_in_ruleInheritingHiddens952); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,13,FOLLOW_13_in_ruleInheritingHiddens962); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:447:2: ( (lv_called= ruleInheritingHiddensCall ) | (lv_hidingCalled= ruleHidingHiddens ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            else if ( (LA6_0==17) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("447:2: ( (lv_called= ruleInheritingHiddensCall ) | (lv_hidingCalled= ruleHidingHiddens ) )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:447:3: (lv_called= ruleInheritingHiddensCall )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:447:3: (lv_called= ruleInheritingHiddensCall )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:450:6: lv_called= ruleInheritingHiddensCall
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleInheritingHiddensCall_in_ruleInheritingHiddens998);
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
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:469:6: (lv_hidingCalled= ruleHidingHiddens )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:469:6: (lv_hidingCalled= ruleHidingHiddens )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:472:6: lv_hidingCalled= ruleHidingHiddens
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleHidingHiddens_in_ruleInheritingHiddens1042);
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

            match(input,14,FOLLOW_14_in_ruleInheritingHiddens1057); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:494:2: (lv_valid= ';' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:496:6: lv_valid= ';'
            {
            lv_valid=(Token)input.LT(1);
            match(input,10,FOLLOW_10_in_ruleInheritingHiddens1079); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "valid"); 
                

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


    // $ANTLR start entryRuleHidingHiddens
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:523:1: entryRuleHidingHiddens returns [EObject current=null] : iv_ruleHidingHiddens= ruleHidingHiddens EOF ;
    public final EObject entryRuleHidingHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHidingHiddens = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:523:55: (iv_ruleHidingHiddens= ruleHidingHiddens EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:524:2: iv_ruleHidingHiddens= ruleHidingHiddens EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleHidingHiddens_in_entryRuleHidingHiddens1126);
            iv_ruleHidingHiddens=ruleHidingHiddens();
            _fsp--;

             current =iv_ruleHidingHiddens; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHidingHiddens1136); 

            }

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:531:1: ruleHidingHiddens returns [EObject current=null] : ( ( 'hiding' (lv_space= RULE_WS ) ) (lv_called= ruleInheritingHiddensCall ) ) ;
    public final EObject ruleHidingHiddens() throws RecognitionException {
        EObject current = null;

        Token lv_space=null;
        EObject lv_called = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:537:6: ( ( ( 'hiding' (lv_space= RULE_WS ) ) (lv_called= ruleInheritingHiddensCall ) ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:538:1: ( ( 'hiding' (lv_space= RULE_WS ) ) (lv_called= ruleInheritingHiddensCall ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:538:1: ( ( 'hiding' (lv_space= RULE_WS ) ) (lv_called= ruleInheritingHiddensCall ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:538:2: ( 'hiding' (lv_space= RULE_WS ) ) (lv_called= ruleInheritingHiddensCall )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:538:2: ( 'hiding' (lv_space= RULE_WS ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:538:3: 'hiding' (lv_space= RULE_WS )
            {
            match(input,17,FOLLOW_17_in_ruleHidingHiddens1171); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:542:1: (lv_space= RULE_WS )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:544:6: lv_space= RULE_WS
            {
            lv_space=(Token)input.LT(1);
            match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleHidingHiddens1192); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "space"); 
                

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

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:562:3: (lv_called= ruleInheritingHiddensCall )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:565:6: lv_called= ruleInheritingHiddensCall
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleInheritingHiddensCall_in_ruleHidingHiddens1238);
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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:592:1: entryRuleInheritingHiddensCall returns [EObject current=null] : iv_ruleInheritingHiddensCall= ruleInheritingHiddensCall EOF ;
    public final EObject entryRuleInheritingHiddensCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritingHiddensCall = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:592:63: (iv_ruleInheritingHiddensCall= ruleInheritingHiddensCall EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:593:2: iv_ruleInheritingHiddensCall= ruleInheritingHiddensCall EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.7" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleInheritingHiddensCall_in_entryRuleInheritingHiddensCall1277);
            iv_ruleInheritingHiddensCall=ruleInheritingHiddensCall();
            _fsp--;

             current =iv_ruleInheritingHiddensCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInheritingHiddensCall1287); 

            }

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:600:1: ruleInheritingHiddensCall returns [EObject current=null] : ( 'call' (lv_valid= ';' ) ) ;
    public final EObject ruleInheritingHiddensCall() throws RecognitionException {
        EObject current = null;

        Token lv_valid=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:604:6: ( ( 'call' (lv_valid= ';' ) ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:605:1: ( 'call' (lv_valid= ';' ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:605:1: ( 'call' (lv_valid= ';' ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:605:2: 'call' (lv_valid= ';' )
            {
            match(input,15,FOLLOW_15_in_ruleInheritingHiddensCall1321); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:609:1: (lv_valid= ';' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:611:6: lv_valid= ';'
            {
            lv_valid=(Token)input.LT(1);
            match(input,10,FOLLOW_10_in_ruleInheritingHiddensCall1342); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "valid"); 
                

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
    public static final BitSet FOLLOW_ruleWithoutHiddens_in_ruleModel131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWithHiddens_in_ruleModel158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOverridingHiddens_in_ruleModel186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInheritingHiddens_in_ruleModel214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWithoutHiddens_in_entryRuleWithoutHiddens248 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWithoutHiddens258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_8_in_ruleWithoutHiddens295 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleWithoutHiddens316 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleWithoutHiddens337 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleWithoutHiddens359 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleWithoutHiddens393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWithHiddens_in_entryRuleWithHiddens440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWithHiddens450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleWithHiddens485 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleWithHiddens494 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleWithHiddens516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOverridingHiddens_in_entryRuleOverridingHiddens563 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOverridingHiddens573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleOverridingHiddens611 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleOverridingHiddens620 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleOverridingHiddens630 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ruleOverridingHiddensCall_in_ruleOverridingHiddens665 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleOverridingHiddens679 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleOverridingHiddens701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOverridingHiddensCall_in_entryRuleOverridingHiddensCall748 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOverridingHiddensCall758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleOverridingHiddensCall793 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleOverridingHiddensCall814 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleOverridingHiddensCall848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInheritingHiddens_in_entryRuleInheritingHiddens895 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInheritingHiddens905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleInheritingHiddens943 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleInheritingHiddens952 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleInheritingHiddens962 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_ruleInheritingHiddensCall_in_ruleInheritingHiddens998 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleHidingHiddens_in_ruleInheritingHiddens1042 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleInheritingHiddens1057 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleInheritingHiddens1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHidingHiddens_in_entryRuleHidingHiddens1126 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHidingHiddens1136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleHidingHiddens1171 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleHidingHiddens1192 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ruleInheritingHiddensCall_in_ruleHidingHiddens1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInheritingHiddensCall_in_entryRuleInheritingHiddensCall1277 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInheritingHiddensCall1287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleInheritingHiddensCall1321 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleInheritingHiddensCall1342 = new BitSet(new long[]{0x0000000000000002L});

}