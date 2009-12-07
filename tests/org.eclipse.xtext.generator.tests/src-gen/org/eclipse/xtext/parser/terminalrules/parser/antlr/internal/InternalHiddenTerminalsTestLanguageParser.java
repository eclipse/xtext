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
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g"; }



     	private HiddenTerminalsTestLanguageGrammarAccess grammarAccess;
     	
        public InternalHiddenTerminalsTestLanguageParser(TokenStream input, IAstFactory factory, HiddenTerminalsTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:72:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel73);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel83); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:80:1: ruleModel returns [EObject current=null] : (this_WithoutHiddens_0= ruleWithoutHiddens | this_WithHiddens_1= ruleWithHiddens | this_OverridingHiddens_2= ruleOverridingHiddens | this_InheritingHiddens_3= ruleInheritingHiddens | this_DatatypeHiddens_4= ruleDatatypeHiddens ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_WithoutHiddens_0 = null;

        EObject this_WithHiddens_1 = null;

        EObject this_OverridingHiddens_2 = null;

        EObject this_InheritingHiddens_3 = null;

        EObject this_DatatypeHiddens_4 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:85:6: ( (this_WithoutHiddens_0= ruleWithoutHiddens | this_WithHiddens_1= ruleWithHiddens | this_OverridingHiddens_2= ruleOverridingHiddens | this_InheritingHiddens_3= ruleInheritingHiddens | this_DatatypeHiddens_4= ruleDatatypeHiddens ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:86:1: (this_WithoutHiddens_0= ruleWithoutHiddens | this_WithHiddens_1= ruleWithHiddens | this_OverridingHiddens_2= ruleOverridingHiddens | this_InheritingHiddens_3= ruleInheritingHiddens | this_DatatypeHiddens_4= ruleDatatypeHiddens )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:86:1: (this_WithoutHiddens_0= ruleWithoutHiddens | this_WithHiddens_1= ruleWithHiddens | this_OverridingHiddens_2= ruleOverridingHiddens | this_InheritingHiddens_3= ruleInheritingHiddens | this_DatatypeHiddens_4= ruleDatatypeHiddens )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 8:
                {
                alt1=1;
                }
                break;
            case 11:
                {
                alt1=2;
                }
                break;
            case 12:
                {
                alt1=3;
                }
                break;
            case 16:
                {
                alt1=4;
                }
                break;
            case 17:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("86:1: (this_WithoutHiddens_0= ruleWithoutHiddens | this_WithHiddens_1= ruleWithHiddens | this_OverridingHiddens_2= ruleOverridingHiddens | this_InheritingHiddens_3= ruleInheritingHiddens | this_DatatypeHiddens_4= ruleDatatypeHiddens )", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:87:5: this_WithoutHiddens_0= ruleWithoutHiddens
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getWithoutHiddensParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleWithoutHiddens_in_ruleModel130);
                    this_WithoutHiddens_0=ruleWithoutHiddens();
                    _fsp--;

                     
                            current = this_WithoutHiddens_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:97:5: this_WithHiddens_1= ruleWithHiddens
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getWithHiddensParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleWithHiddens_in_ruleModel157);
                    this_WithHiddens_1=ruleWithHiddens();
                    _fsp--;

                     
                            current = this_WithHiddens_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:107:5: this_OverridingHiddens_2= ruleOverridingHiddens
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getOverridingHiddensParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleOverridingHiddens_in_ruleModel184);
                    this_OverridingHiddens_2=ruleOverridingHiddens();
                    _fsp--;

                     
                            current = this_OverridingHiddens_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:117:5: this_InheritingHiddens_3= ruleInheritingHiddens
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getInheritingHiddensParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleInheritingHiddens_in_ruleModel211);
                    this_InheritingHiddens_3=ruleInheritingHiddens();
                    _fsp--;

                     
                            current = this_InheritingHiddens_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:127:5: this_DatatypeHiddens_4= ruleDatatypeHiddens
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getDatatypeHiddensParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDatatypeHiddens_in_ruleModel238);
                    this_DatatypeHiddens_4=ruleDatatypeHiddens();
                    _fsp--;

                     
                            current = this_DatatypeHiddens_4; 
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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleWithoutHiddens
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:142:1: entryRuleWithoutHiddens returns [EObject current=null] : iv_ruleWithoutHiddens= ruleWithoutHiddens EOF ;
    public final EObject entryRuleWithoutHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWithoutHiddens = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:142:56: (iv_ruleWithoutHiddens= ruleWithoutHiddens EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:143:2: iv_ruleWithoutHiddens= ruleWithoutHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWithoutHiddensRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleWithoutHiddens_in_entryRuleWithoutHiddens270);
            iv_ruleWithoutHiddens=ruleWithoutHiddens();
            _fsp--;

             current =iv_ruleWithoutHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWithoutHiddens280); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:150:1: ruleWithoutHiddens returns [EObject current=null] : ( 'without' ( (lv_spaces_1_0= RULE_WS ) ) 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) ) ;
    public final EObject ruleWithoutHiddens() throws RecognitionException {
        EObject current = null;

        Token lv_spaces_1_0=null;
        Token lv_spaces_3_0=null;
        Token lv_valid_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:155:6: ( ( 'without' ( (lv_spaces_1_0= RULE_WS ) ) 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:156:1: ( 'without' ( (lv_spaces_1_0= RULE_WS ) ) 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:156:1: ( 'without' ( (lv_spaces_1_0= RULE_WS ) ) 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:156:3: 'without' ( (lv_spaces_1_0= RULE_WS ) ) 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) )
            {
            match(input,8,FollowSets000.FOLLOW_8_in_ruleWithoutHiddens315); 

                    createLeafNode(grammarAccess.getWithoutHiddensAccess().getWithoutKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:160:1: ( (lv_spaces_1_0= RULE_WS ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:161:1: (lv_spaces_1_0= RULE_WS )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:161:1: (lv_spaces_1_0= RULE_WS )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:162:3: lv_spaces_1_0= RULE_WS
            {
            lv_spaces_1_0=(Token)input.LT(1);
            match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleWithoutHiddens332); 

            			createLeafNode(grammarAccess.getWithoutHiddensAccess().getSpacesWSTerminalRuleCall_1_0(), "spaces"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getWithoutHiddensRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"spaces",
            	        		lv_spaces_1_0, 
            	        		"WS", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,9,FollowSets000.FOLLOW_9_in_ruleWithoutHiddens347); 

                    createLeafNode(grammarAccess.getWithoutHiddensAccess().getHiddensKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:188:1: ( (lv_spaces_3_0= RULE_WS ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_WS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:189:1: (lv_spaces_3_0= RULE_WS )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:189:1: (lv_spaces_3_0= RULE_WS )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:190:3: lv_spaces_3_0= RULE_WS
                    {
                    lv_spaces_3_0=(Token)input.LT(1);
                    match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleWithoutHiddens364); 

                    			createLeafNode(grammarAccess.getWithoutHiddensAccess().getSpacesWSTerminalRuleCall_3_0(), "spaces"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getWithoutHiddensRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"spaces",
                    	        		lv_spaces_3_0, 
                    	        		"WS", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:212:3: ( (lv_valid_4_0= ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:213:1: (lv_valid_4_0= ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:213:1: (lv_valid_4_0= ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:214:3: lv_valid_4_0= ';'
            {
            lv_valid_4_0=(Token)input.LT(1);
            match(input,10,FollowSets000.FOLLOW_10_in_ruleWithoutHiddens388); 

                    createLeafNode(grammarAccess.getWithoutHiddensAccess().getValidSemicolonKeyword_4_0(), "valid"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getWithoutHiddensRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "valid", true, ";", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // $ANTLR end ruleWithoutHiddens


    // $ANTLR start entryRuleWithHiddens
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:240:1: entryRuleWithHiddens returns [EObject current=null] : iv_ruleWithHiddens= ruleWithHiddens EOF ;
    public final EObject entryRuleWithHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWithHiddens = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:240:53: (iv_ruleWithHiddens= ruleWithHiddens EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:241:2: iv_ruleWithHiddens= ruleWithHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWithHiddensRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleWithHiddens_in_entryRuleWithHiddens434);
            iv_ruleWithHiddens=ruleWithHiddens();
            _fsp--;

             current =iv_ruleWithHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWithHiddens444); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:248:1: ruleWithHiddens returns [EObject current=null] : ( 'with' 'hiddens' ( (lv_valid_2_0= ';' ) ) ) ;
    public final EObject ruleWithHiddens() throws RecognitionException {
        EObject current = null;

        Token lv_valid_2_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:255:6: ( ( 'with' 'hiddens' ( (lv_valid_2_0= ';' ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:256:1: ( 'with' 'hiddens' ( (lv_valid_2_0= ';' ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:256:1: ( 'with' 'hiddens' ( (lv_valid_2_0= ';' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:256:3: 'with' 'hiddens' ( (lv_valid_2_0= ';' ) )
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleWithHiddens479); 

                    createLeafNode(grammarAccess.getWithHiddensAccess().getWithKeyword_0(), null); 
                
            match(input,9,FollowSets000.FOLLOW_9_in_ruleWithHiddens489); 

                    createLeafNode(grammarAccess.getWithHiddensAccess().getHiddensKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:264:1: ( (lv_valid_2_0= ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:265:1: (lv_valid_2_0= ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:265:1: (lv_valid_2_0= ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:266:3: lv_valid_2_0= ';'
            {
            lv_valid_2_0=(Token)input.LT(1);
            match(input,10,FollowSets000.FOLLOW_10_in_ruleWithHiddens507); 

                    createLeafNode(grammarAccess.getWithHiddensAccess().getValidSemicolonKeyword_2_0(), "valid"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getWithHiddensRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "valid", true, ";", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:292:1: entryRuleOverridingHiddens returns [EObject current=null] : iv_ruleOverridingHiddens= ruleOverridingHiddens EOF ;
    public final EObject entryRuleOverridingHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridingHiddens = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:292:59: (iv_ruleOverridingHiddens= ruleOverridingHiddens EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:293:2: iv_ruleOverridingHiddens= ruleOverridingHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOverridingHiddensRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOverridingHiddens_in_entryRuleOverridingHiddens553);
            iv_ruleOverridingHiddens=ruleOverridingHiddens();
            _fsp--;

             current =iv_ruleOverridingHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOverridingHiddens563); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:300:1: ruleOverridingHiddens returns [EObject current=null] : ( 'overriding' 'hiddens' '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) ')' ( (lv_valid_5_0= ';' ) ) ) ;
    public final EObject ruleOverridingHiddens() throws RecognitionException {
        EObject current = null;

        Token lv_valid_5_0=null;
        EObject lv_called_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:307:6: ( ( 'overriding' 'hiddens' '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) ')' ( (lv_valid_5_0= ';' ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:308:1: ( 'overriding' 'hiddens' '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) ')' ( (lv_valid_5_0= ';' ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:308:1: ( 'overriding' 'hiddens' '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) ')' ( (lv_valid_5_0= ';' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:308:3: 'overriding' 'hiddens' '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) ')' ( (lv_valid_5_0= ';' ) )
            {
            match(input,12,FollowSets000.FOLLOW_12_in_ruleOverridingHiddens598); 

                    createLeafNode(grammarAccess.getOverridingHiddensAccess().getOverridingKeyword_0(), null); 
                
            match(input,9,FollowSets000.FOLLOW_9_in_ruleOverridingHiddens608); 

                    createLeafNode(grammarAccess.getOverridingHiddensAccess().getHiddensKeyword_1(), null); 
                
            match(input,13,FollowSets000.FOLLOW_13_in_ruleOverridingHiddens618); 

                    createLeafNode(grammarAccess.getOverridingHiddensAccess().getLeftParenthesisKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:320:1: ( (lv_called_3_0= ruleOverridingHiddensCall ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:321:1: (lv_called_3_0= ruleOverridingHiddensCall )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:321:1: (lv_called_3_0= ruleOverridingHiddensCall )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:322:3: lv_called_3_0= ruleOverridingHiddensCall
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getOverridingHiddensAccess().getCalledOverridingHiddensCallParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOverridingHiddensCall_in_ruleOverridingHiddens639);
            lv_called_3_0=ruleOverridingHiddensCall();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOverridingHiddensRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"called",
            	        		lv_called_3_0, 
            	        		"OverridingHiddensCall", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,14,FollowSets000.FOLLOW_14_in_ruleOverridingHiddens649); 

                    createLeafNode(grammarAccess.getOverridingHiddensAccess().getRightParenthesisKeyword_4(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:348:1: ( (lv_valid_5_0= ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:349:1: (lv_valid_5_0= ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:349:1: (lv_valid_5_0= ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:350:3: lv_valid_5_0= ';'
            {
            lv_valid_5_0=(Token)input.LT(1);
            match(input,10,FollowSets000.FOLLOW_10_in_ruleOverridingHiddens667); 

                    createLeafNode(grammarAccess.getOverridingHiddensAccess().getValidSemicolonKeyword_5_0(), "valid"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOverridingHiddensRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "valid", true, ";", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:376:1: entryRuleOverridingHiddensCall returns [EObject current=null] : iv_ruleOverridingHiddensCall= ruleOverridingHiddensCall EOF ;
    public final EObject entryRuleOverridingHiddensCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridingHiddensCall = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:376:63: (iv_ruleOverridingHiddensCall= ruleOverridingHiddensCall EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:377:2: iv_ruleOverridingHiddensCall= ruleOverridingHiddensCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOverridingHiddensCallRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOverridingHiddensCall_in_entryRuleOverridingHiddensCall713);
            iv_ruleOverridingHiddensCall=ruleOverridingHiddensCall();
            _fsp--;

             current =iv_ruleOverridingHiddensCall; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOverridingHiddensCall723); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:384:1: ruleOverridingHiddensCall returns [EObject current=null] : ( 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) ) ;
    public final EObject ruleOverridingHiddensCall() throws RecognitionException {
        EObject current = null;

        Token lv_spaces_1_0=null;
        Token lv_valid_2_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:391:6: ( ( 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:392:1: ( 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:392:1: ( 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:392:3: 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) )
            {
            match(input,15,FollowSets000.FOLLOW_15_in_ruleOverridingHiddensCall758); 

                    createLeafNode(grammarAccess.getOverridingHiddensCallAccess().getCallKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:396:1: ( (lv_spaces_1_0= RULE_WS ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_WS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:397:1: (lv_spaces_1_0= RULE_WS )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:397:1: (lv_spaces_1_0= RULE_WS )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:398:3: lv_spaces_1_0= RULE_WS
                    {
                    lv_spaces_1_0=(Token)input.LT(1);
                    match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleOverridingHiddensCall775); 

                    			createLeafNode(grammarAccess.getOverridingHiddensCallAccess().getSpacesWSTerminalRuleCall_1_0(), "spaces"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getOverridingHiddensCallRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"spaces",
                    	        		lv_spaces_1_0, 
                    	        		"WS", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:420:3: ( (lv_valid_2_0= ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:421:1: (lv_valid_2_0= ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:421:1: (lv_valid_2_0= ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:422:3: lv_valid_2_0= ';'
            {
            lv_valid_2_0=(Token)input.LT(1);
            match(input,10,FollowSets000.FOLLOW_10_in_ruleOverridingHiddensCall799); 

                    createLeafNode(grammarAccess.getOverridingHiddensCallAccess().getValidSemicolonKeyword_2_0(), "valid"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOverridingHiddensCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "valid", true, ";", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:448:1: entryRuleInheritingHiddens returns [EObject current=null] : iv_ruleInheritingHiddens= ruleInheritingHiddens EOF ;
    public final EObject entryRuleInheritingHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritingHiddens = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:448:59: (iv_ruleInheritingHiddens= ruleInheritingHiddens EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:449:2: iv_ruleInheritingHiddens= ruleInheritingHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInheritingHiddensRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleInheritingHiddens_in_entryRuleInheritingHiddens845);
            iv_ruleInheritingHiddens=ruleInheritingHiddens();
            _fsp--;

             current =iv_ruleInheritingHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInheritingHiddens855); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:456:1: ruleInheritingHiddens returns [EObject current=null] : ( 'inheriting' 'hiddens' '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) ')' ( (lv_valid_6_0= ';' ) ) ) ;
    public final EObject ruleInheritingHiddens() throws RecognitionException {
        EObject current = null;

        Token lv_valid_6_0=null;
        EObject lv_called_3_0 = null;

        EObject lv_hidingCalled_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:463:6: ( ( 'inheriting' 'hiddens' '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) ')' ( (lv_valid_6_0= ';' ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:464:1: ( 'inheriting' 'hiddens' '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) ')' ( (lv_valid_6_0= ';' ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:464:1: ( 'inheriting' 'hiddens' '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) ')' ( (lv_valid_6_0= ';' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:464:3: 'inheriting' 'hiddens' '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) ')' ( (lv_valid_6_0= ';' ) )
            {
            match(input,16,FollowSets000.FOLLOW_16_in_ruleInheritingHiddens890); 

                    createLeafNode(grammarAccess.getInheritingHiddensAccess().getInheritingKeyword_0(), null); 
                
            match(input,9,FollowSets000.FOLLOW_9_in_ruleInheritingHiddens900); 

                    createLeafNode(grammarAccess.getInheritingHiddensAccess().getHiddensKeyword_1(), null); 
                
            match(input,13,FollowSets000.FOLLOW_13_in_ruleInheritingHiddens910); 

                    createLeafNode(grammarAccess.getInheritingHiddensAccess().getLeftParenthesisKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:476:1: ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            else if ( (LA4_0==19) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("476:1: ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:476:2: ( (lv_called_3_0= ruleInheritingHiddensCall ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:476:2: ( (lv_called_3_0= ruleInheritingHiddensCall ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:477:1: (lv_called_3_0= ruleInheritingHiddensCall )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:477:1: (lv_called_3_0= ruleInheritingHiddensCall )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:478:3: lv_called_3_0= ruleInheritingHiddensCall
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInheritingHiddensAccess().getCalledInheritingHiddensCallParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleInheritingHiddensCall_in_ruleInheritingHiddens932);
                    lv_called_3_0=ruleInheritingHiddensCall();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getInheritingHiddensRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"called",
                    	        		lv_called_3_0, 
                    	        		"InheritingHiddensCall", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:501:6: ( (lv_hidingCalled_4_0= ruleHidingHiddens ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:501:6: ( (lv_hidingCalled_4_0= ruleHidingHiddens ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:502:1: (lv_hidingCalled_4_0= ruleHidingHiddens )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:502:1: (lv_hidingCalled_4_0= ruleHidingHiddens )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:503:3: lv_hidingCalled_4_0= ruleHidingHiddens
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInheritingHiddensAccess().getHidingCalledHidingHiddensParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleHidingHiddens_in_ruleInheritingHiddens959);
                    lv_hidingCalled_4_0=ruleHidingHiddens();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getInheritingHiddensRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"hidingCalled",
                    	        		lv_hidingCalled_4_0, 
                    	        		"HidingHiddens", 
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

            match(input,14,FollowSets000.FOLLOW_14_in_ruleInheritingHiddens970); 

                    createLeafNode(grammarAccess.getInheritingHiddensAccess().getRightParenthesisKeyword_4(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:529:1: ( (lv_valid_6_0= ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:530:1: (lv_valid_6_0= ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:530:1: (lv_valid_6_0= ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:531:3: lv_valid_6_0= ';'
            {
            lv_valid_6_0=(Token)input.LT(1);
            match(input,10,FollowSets000.FOLLOW_10_in_ruleInheritingHiddens988); 

                    createLeafNode(grammarAccess.getInheritingHiddensAccess().getValidSemicolonKeyword_5_0(), "valid"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getInheritingHiddensRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "valid", true, ";", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:557:1: entryRuleDatatypeHiddens returns [EObject current=null] : iv_ruleDatatypeHiddens= ruleDatatypeHiddens EOF ;
    public final EObject entryRuleDatatypeHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatypeHiddens = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:557:57: (iv_ruleDatatypeHiddens= ruleDatatypeHiddens EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:558:2: iv_ruleDatatypeHiddens= ruleDatatypeHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDatatypeHiddensRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeHiddens_in_entryRuleDatatypeHiddens1034);
            iv_ruleDatatypeHiddens=ruleDatatypeHiddens();
            _fsp--;

             current =iv_ruleDatatypeHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypeHiddens1044); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:565:1: ruleDatatypeHiddens returns [EObject current=null] : ( 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) ) ;
    public final EObject ruleDatatypeHiddens() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_valid_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:570:6: ( ( 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:571:1: ( 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:571:1: ( 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:571:3: 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) )
            {
            match(input,17,FollowSets000.FOLLOW_17_in_ruleDatatypeHiddens1079); 

                    createLeafNode(grammarAccess.getDatatypeHiddensAccess().getDatatypeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:575:1: ( (lv_valid_1_0= ruleDatatypeRule ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:576:1: (lv_valid_1_0= ruleDatatypeRule )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:576:1: (lv_valid_1_0= ruleDatatypeRule )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:577:3: lv_valid_1_0= ruleDatatypeRule
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDatatypeHiddensAccess().getValidDatatypeRuleParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeRule_in_ruleDatatypeHiddens1100);
            lv_valid_1_0=ruleDatatypeRule();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDatatypeHiddensRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"valid",
            	        		true, 
            	        		"DatatypeRule", 
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
    // $ANTLR end ruleDatatypeHiddens


    // $ANTLR start entryRuleDatatypeRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:606:1: entryRuleDatatypeRule returns [String current=null] : iv_ruleDatatypeRule= ruleDatatypeRule EOF ;
    public final String entryRuleDatatypeRule() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatypeRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:606:53: (iv_ruleDatatypeRule= ruleDatatypeRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:607:2: iv_ruleDatatypeRule= ruleDatatypeRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDatatypeRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeRule_in_entryRuleDatatypeRule1134);
            iv_ruleDatatypeRule=ruleDatatypeRule();
            _fsp--;

             current =iv_ruleDatatypeRule.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypeRule1145); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:614:1: ruleDatatypeRule returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'rule' kw= ';' ) ;
    public final AntlrDatatypeRuleToken ruleDatatypeRule() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:621:6: ( (kw= 'rule' kw= ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:622:1: (kw= 'rule' kw= ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:622:1: (kw= 'rule' kw= ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:623:2: kw= 'rule' kw= ';'
            {
            kw=(Token)input.LT(1);
            match(input,18,FollowSets000.FOLLOW_18_in_ruleDatatypeRule1183); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getDatatypeRuleAccess().getRuleKeyword_0(), null); 
                
            kw=(Token)input.LT(1);
            match(input,10,FollowSets000.FOLLOW_10_in_ruleDatatypeRule1196); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getDatatypeRuleAccess().getSemicolonKeyword_1(), null); 
                

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:642:1: entryRuleHidingHiddens returns [EObject current=null] : iv_ruleHidingHiddens= ruleHidingHiddens EOF ;
    public final EObject entryRuleHidingHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHidingHiddens = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:642:55: (iv_ruleHidingHiddens= ruleHidingHiddens EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:643:2: iv_ruleHidingHiddens= ruleHidingHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.getHidingHiddensRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleHidingHiddens_in_entryRuleHidingHiddens1234);
            iv_ruleHidingHiddens=ruleHidingHiddens();
            _fsp--;

             current =iv_ruleHidingHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleHidingHiddens1244); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:650:1: ruleHidingHiddens returns [EObject current=null] : ( 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) ) ;
    public final EObject ruleHidingHiddens() throws RecognitionException {
        EObject current = null;

        Token lv_space_1_0=null;
        EObject lv_called_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:657:6: ( ( 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:658:1: ( 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:658:1: ( 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:658:3: 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) )
            {
            match(input,19,FollowSets000.FOLLOW_19_in_ruleHidingHiddens1279); 

                    createLeafNode(grammarAccess.getHidingHiddensAccess().getHidingKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:662:1: ( (lv_space_1_0= RULE_WS ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:663:1: (lv_space_1_0= RULE_WS )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:663:1: (lv_space_1_0= RULE_WS )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:664:3: lv_space_1_0= RULE_WS
            {
            lv_space_1_0=(Token)input.LT(1);
            match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleHidingHiddens1296); 

            			createLeafNode(grammarAccess.getHidingHiddensAccess().getSpaceWSTerminalRuleCall_1_0(), "space"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getHidingHiddensRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"space",
            	        		lv_space_1_0, 
            	        		"WS", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:686:2: ( (lv_called_2_0= ruleInheritingHiddensCall ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:687:1: (lv_called_2_0= ruleInheritingHiddensCall )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:687:1: (lv_called_2_0= ruleInheritingHiddensCall )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:688:3: lv_called_2_0= ruleInheritingHiddensCall
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getHidingHiddensAccess().getCalledInheritingHiddensCallParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleInheritingHiddensCall_in_ruleHidingHiddens1322);
            lv_called_2_0=ruleInheritingHiddensCall();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getHidingHiddensRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"called",
            	        		lv_called_2_0, 
            	        		"InheritingHiddensCall", 
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:717:1: entryRuleInheritingHiddensCall returns [EObject current=null] : iv_ruleInheritingHiddensCall= ruleInheritingHiddensCall EOF ;
    public final EObject entryRuleInheritingHiddensCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritingHiddensCall = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:717:63: (iv_ruleInheritingHiddensCall= ruleInheritingHiddensCall EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:718:2: iv_ruleInheritingHiddensCall= ruleInheritingHiddensCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInheritingHiddensCallRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleInheritingHiddensCall_in_entryRuleInheritingHiddensCall1355);
            iv_ruleInheritingHiddensCall=ruleInheritingHiddensCall();
            _fsp--;

             current =iv_ruleInheritingHiddensCall; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInheritingHiddensCall1365); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:725:1: ruleInheritingHiddensCall returns [EObject current=null] : ( 'call' ( (lv_valid_1_0= ';' ) ) ) ;
    public final EObject ruleInheritingHiddensCall() throws RecognitionException {
        EObject current = null;

        Token lv_valid_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:730:6: ( ( 'call' ( (lv_valid_1_0= ';' ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:731:1: ( 'call' ( (lv_valid_1_0= ';' ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:731:1: ( 'call' ( (lv_valid_1_0= ';' ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:731:3: 'call' ( (lv_valid_1_0= ';' ) )
            {
            match(input,15,FollowSets000.FOLLOW_15_in_ruleInheritingHiddensCall1400); 

                    createLeafNode(grammarAccess.getInheritingHiddensCallAccess().getCallKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:735:1: ( (lv_valid_1_0= ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:736:1: (lv_valid_1_0= ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:736:1: (lv_valid_1_0= ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:737:3: lv_valid_1_0= ';'
            {
            lv_valid_1_0=(Token)input.LT(1);
            match(input,10,FollowSets000.FOLLOW_10_in_ruleInheritingHiddensCall1418); 

                    createLeafNode(grammarAccess.getInheritingHiddensCallAccess().getValidSemicolonKeyword_1_0(), "valid"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getInheritingHiddensCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "valid", true, ";", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // $ANTLR end ruleInheritingHiddensCall


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWithoutHiddens_in_ruleModel130 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWithHiddens_in_ruleModel157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOverridingHiddens_in_ruleModel184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInheritingHiddens_in_ruleModel211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeHiddens_in_ruleModel238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWithoutHiddens_in_entryRuleWithoutHiddens270 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWithoutHiddens280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_8_in_ruleWithoutHiddens315 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleWithoutHiddens332 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_9_in_ruleWithoutHiddens347 = new BitSet(new long[]{0x0000000000000410L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleWithoutHiddens364 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleWithoutHiddens388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWithHiddens_in_entryRuleWithHiddens434 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWithHiddens444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleWithHiddens479 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_9_in_ruleWithHiddens489 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleWithHiddens507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOverridingHiddens_in_entryRuleOverridingHiddens553 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOverridingHiddens563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleOverridingHiddens598 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_9_in_ruleOverridingHiddens608 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleOverridingHiddens618 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleOverridingHiddensCall_in_ruleOverridingHiddens639 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleOverridingHiddens649 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleOverridingHiddens667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOverridingHiddensCall_in_entryRuleOverridingHiddensCall713 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOverridingHiddensCall723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleOverridingHiddensCall758 = new BitSet(new long[]{0x0000000000000410L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleOverridingHiddensCall775 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleOverridingHiddensCall799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInheritingHiddens_in_entryRuleInheritingHiddens845 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInheritingHiddens855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleInheritingHiddens890 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_9_in_ruleInheritingHiddens900 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleInheritingHiddens910 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_ruleInheritingHiddensCall_in_ruleInheritingHiddens932 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_ruleHidingHiddens_in_ruleInheritingHiddens959 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleInheritingHiddens970 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleInheritingHiddens988 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeHiddens_in_entryRuleDatatypeHiddens1034 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeHiddens1044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleDatatypeHiddens1079 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleDatatypeRule_in_ruleDatatypeHiddens1100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeRule_in_entryRuleDatatypeRule1134 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeRule1145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleDatatypeRule1183 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleDatatypeRule1196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHidingHiddens_in_entryRuleHidingHiddens1234 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleHidingHiddens1244 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleHidingHiddens1279 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleHidingHiddens1296 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleInheritingHiddensCall_in_ruleHidingHiddens1322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInheritingHiddensCall_in_entryRuleInheritingHiddensCall1355 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInheritingHiddensCall1365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleInheritingHiddensCall1400 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleInheritingHiddensCall1418 = new BitSet(new long[]{0x0000000000000002L});
    }


}