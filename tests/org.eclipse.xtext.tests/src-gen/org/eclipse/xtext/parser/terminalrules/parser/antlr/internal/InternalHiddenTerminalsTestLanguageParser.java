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
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g"; }



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
       	
       	@Override
       	protected HiddenTerminalsTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:77:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:78:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:79:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel85); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:86:1: ruleModel returns [EObject current=null] : (this_WithoutHiddens_0= ruleWithoutHiddens | this_WithHiddens_1= ruleWithHiddens | this_OverridingHiddens_2= ruleOverridingHiddens | this_InheritingHiddens_3= ruleInheritingHiddens | this_DatatypeHiddens_4= ruleDatatypeHiddens ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_WithoutHiddens_0 = null;

        EObject this_WithHiddens_1 = null;

        EObject this_OverridingHiddens_2 = null;

        EObject this_InheritingHiddens_3 = null;

        EObject this_DatatypeHiddens_4 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:91:6: ( (this_WithoutHiddens_0= ruleWithoutHiddens | this_WithHiddens_1= ruleWithHiddens | this_OverridingHiddens_2= ruleOverridingHiddens | this_InheritingHiddens_3= ruleInheritingHiddens | this_DatatypeHiddens_4= ruleDatatypeHiddens ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:92:1: (this_WithoutHiddens_0= ruleWithoutHiddens | this_WithHiddens_1= ruleWithHiddens | this_OverridingHiddens_2= ruleOverridingHiddens | this_InheritingHiddens_3= ruleInheritingHiddens | this_DatatypeHiddens_4= ruleDatatypeHiddens )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:92:1: (this_WithoutHiddens_0= ruleWithoutHiddens | this_WithHiddens_1= ruleWithHiddens | this_OverridingHiddens_2= ruleOverridingHiddens | this_InheritingHiddens_3= ruleInheritingHiddens | this_DatatypeHiddens_4= ruleDatatypeHiddens )
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
                    new NoViableAltException("92:1: (this_WithoutHiddens_0= ruleWithoutHiddens | this_WithHiddens_1= ruleWithHiddens | this_OverridingHiddens_2= ruleOverridingHiddens | this_InheritingHiddens_3= ruleInheritingHiddens | this_DatatypeHiddens_4= ruleDatatypeHiddens )", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:93:5: this_WithoutHiddens_0= ruleWithoutHiddens
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getWithoutHiddensParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleWithoutHiddens_in_ruleModel132);
                    this_WithoutHiddens_0=ruleWithoutHiddens();
                    _fsp--;

                     
                            current = this_WithoutHiddens_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:103:5: this_WithHiddens_1= ruleWithHiddens
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getWithHiddensParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleWithHiddens_in_ruleModel159);
                    this_WithHiddens_1=ruleWithHiddens();
                    _fsp--;

                     
                            current = this_WithHiddens_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:113:5: this_OverridingHiddens_2= ruleOverridingHiddens
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getOverridingHiddensParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleOverridingHiddens_in_ruleModel186);
                    this_OverridingHiddens_2=ruleOverridingHiddens();
                    _fsp--;

                     
                            current = this_OverridingHiddens_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:123:5: this_InheritingHiddens_3= ruleInheritingHiddens
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getInheritingHiddensParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleInheritingHiddens_in_ruleModel213);
                    this_InheritingHiddens_3=ruleInheritingHiddens();
                    _fsp--;

                     
                            current = this_InheritingHiddens_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:133:5: this_DatatypeHiddens_4= ruleDatatypeHiddens
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getDatatypeHiddensParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDatatypeHiddens_in_ruleModel240);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:149:1: entryRuleWithoutHiddens returns [EObject current=null] : iv_ruleWithoutHiddens= ruleWithoutHiddens EOF ;
    public final EObject entryRuleWithoutHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWithoutHiddens = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:150:2: (iv_ruleWithoutHiddens= ruleWithoutHiddens EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:151:2: iv_ruleWithoutHiddens= ruleWithoutHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWithoutHiddensRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleWithoutHiddens_in_entryRuleWithoutHiddens275);
            iv_ruleWithoutHiddens=ruleWithoutHiddens();
            _fsp--;

             current =iv_ruleWithoutHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWithoutHiddens285); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:158:1: ruleWithoutHiddens returns [EObject current=null] : ( 'without' ( (lv_spaces_1_0= RULE_WS ) ) 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) ) ;
    public final EObject ruleWithoutHiddens() throws RecognitionException {
        EObject current = null;

        Token lv_spaces_1_0=null;
        Token lv_spaces_3_0=null;
        Token lv_valid_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:163:6: ( ( 'without' ( (lv_spaces_1_0= RULE_WS ) ) 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:164:1: ( 'without' ( (lv_spaces_1_0= RULE_WS ) ) 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:164:1: ( 'without' ( (lv_spaces_1_0= RULE_WS ) ) 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:164:3: 'without' ( (lv_spaces_1_0= RULE_WS ) ) 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) )
            {
            match(input,8,FollowSets000.FOLLOW_8_in_ruleWithoutHiddens320); 

                    createLeafNode(grammarAccess.getWithoutHiddensAccess().getWithoutKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:168:1: ( (lv_spaces_1_0= RULE_WS ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:169:1: (lv_spaces_1_0= RULE_WS )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:169:1: (lv_spaces_1_0= RULE_WS )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:170:3: lv_spaces_1_0= RULE_WS
            {
            lv_spaces_1_0=(Token)input.LT(1);
            match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleWithoutHiddens337); 

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

            match(input,9,FollowSets000.FOLLOW_9_in_ruleWithoutHiddens352); 

                    createLeafNode(grammarAccess.getWithoutHiddensAccess().getHiddensKeyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:196:1: ( (lv_spaces_3_0= RULE_WS ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_WS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:197:1: (lv_spaces_3_0= RULE_WS )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:197:1: (lv_spaces_3_0= RULE_WS )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:198:3: lv_spaces_3_0= RULE_WS
                    {
                    lv_spaces_3_0=(Token)input.LT(1);
                    match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleWithoutHiddens369); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:220:3: ( (lv_valid_4_0= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:221:1: (lv_valid_4_0= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:221:1: (lv_valid_4_0= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:222:3: lv_valid_4_0= ';'
            {
            lv_valid_4_0=(Token)input.LT(1);
            match(input,10,FollowSets000.FOLLOW_10_in_ruleWithoutHiddens393); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:249:1: entryRuleWithHiddens returns [EObject current=null] : iv_ruleWithHiddens= ruleWithHiddens EOF ;
    public final EObject entryRuleWithHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWithHiddens = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:253:2: (iv_ruleWithHiddens= ruleWithHiddens EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:254:2: iv_ruleWithHiddens= ruleWithHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWithHiddensRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleWithHiddens_in_entryRuleWithHiddens448);
            iv_ruleWithHiddens=ruleWithHiddens();
            _fsp--;

             current =iv_ruleWithHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWithHiddens458); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end entryRuleWithHiddens


    // $ANTLR start ruleWithHiddens
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:264:1: ruleWithHiddens returns [EObject current=null] : ( 'with' 'hiddens' ( (lv_valid_2_0= ';' ) ) ) ;
    public final EObject ruleWithHiddens() throws RecognitionException {
        EObject current = null;

        Token lv_valid_2_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:270:6: ( ( 'with' 'hiddens' ( (lv_valid_2_0= ';' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:271:1: ( 'with' 'hiddens' ( (lv_valid_2_0= ';' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:271:1: ( 'with' 'hiddens' ( (lv_valid_2_0= ';' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:271:3: 'with' 'hiddens' ( (lv_valid_2_0= ';' ) )
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleWithHiddens497); 

                    createLeafNode(grammarAccess.getWithHiddensAccess().getWithKeyword_0(), null); 
                
            match(input,9,FollowSets000.FOLLOW_9_in_ruleWithHiddens507); 

                    createLeafNode(grammarAccess.getWithHiddensAccess().getHiddensKeyword_1(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:279:1: ( (lv_valid_2_0= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:280:1: (lv_valid_2_0= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:280:1: (lv_valid_2_0= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:281:3: lv_valid_2_0= ';'
            {
            lv_valid_2_0=(Token)input.LT(1);
            match(input,10,FollowSets000.FOLLOW_10_in_ruleWithHiddens525); 

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
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end ruleWithHiddens


    // $ANTLR start entryRuleOverridingHiddens
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:311:1: entryRuleOverridingHiddens returns [EObject current=null] : iv_ruleOverridingHiddens= ruleOverridingHiddens EOF ;
    public final EObject entryRuleOverridingHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridingHiddens = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:315:2: (iv_ruleOverridingHiddens= ruleOverridingHiddens EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:316:2: iv_ruleOverridingHiddens= ruleOverridingHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOverridingHiddensRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOverridingHiddens_in_entryRuleOverridingHiddens584);
            iv_ruleOverridingHiddens=ruleOverridingHiddens();
            _fsp--;

             current =iv_ruleOverridingHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOverridingHiddens594); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end entryRuleOverridingHiddens


    // $ANTLR start ruleOverridingHiddens
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:326:1: ruleOverridingHiddens returns [EObject current=null] : ( 'overriding' 'hiddens' '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) ')' ( (lv_valid_5_0= ';' ) ) ) ;
    public final EObject ruleOverridingHiddens() throws RecognitionException {
        EObject current = null;

        Token lv_valid_5_0=null;
        EObject lv_called_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:332:6: ( ( 'overriding' 'hiddens' '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) ')' ( (lv_valid_5_0= ';' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:333:1: ( 'overriding' 'hiddens' '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) ')' ( (lv_valid_5_0= ';' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:333:1: ( 'overriding' 'hiddens' '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) ')' ( (lv_valid_5_0= ';' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:333:3: 'overriding' 'hiddens' '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) ')' ( (lv_valid_5_0= ';' ) )
            {
            match(input,12,FollowSets000.FOLLOW_12_in_ruleOverridingHiddens633); 

                    createLeafNode(grammarAccess.getOverridingHiddensAccess().getOverridingKeyword_0(), null); 
                
            match(input,9,FollowSets000.FOLLOW_9_in_ruleOverridingHiddens643); 

                    createLeafNode(grammarAccess.getOverridingHiddensAccess().getHiddensKeyword_1(), null); 
                
            match(input,13,FollowSets000.FOLLOW_13_in_ruleOverridingHiddens653); 

                    createLeafNode(grammarAccess.getOverridingHiddensAccess().getLeftParenthesisKeyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:345:1: ( (lv_called_3_0= ruleOverridingHiddensCall ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:346:1: (lv_called_3_0= ruleOverridingHiddensCall )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:346:1: (lv_called_3_0= ruleOverridingHiddensCall )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:347:3: lv_called_3_0= ruleOverridingHiddensCall
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getOverridingHiddensAccess().getCalledOverridingHiddensCallParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOverridingHiddensCall_in_ruleOverridingHiddens674);
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

            match(input,14,FollowSets000.FOLLOW_14_in_ruleOverridingHiddens684); 

                    createLeafNode(grammarAccess.getOverridingHiddensAccess().getRightParenthesisKeyword_4(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:373:1: ( (lv_valid_5_0= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:374:1: (lv_valid_5_0= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:374:1: (lv_valid_5_0= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:375:3: lv_valid_5_0= ';'
            {
            lv_valid_5_0=(Token)input.LT(1);
            match(input,10,FollowSets000.FOLLOW_10_in_ruleOverridingHiddens702); 

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
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end ruleOverridingHiddens


    // $ANTLR start entryRuleOverridingHiddensCall
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:405:1: entryRuleOverridingHiddensCall returns [EObject current=null] : iv_ruleOverridingHiddensCall= ruleOverridingHiddensCall EOF ;
    public final EObject entryRuleOverridingHiddensCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridingHiddensCall = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:409:2: (iv_ruleOverridingHiddensCall= ruleOverridingHiddensCall EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:410:2: iv_ruleOverridingHiddensCall= ruleOverridingHiddensCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOverridingHiddensCallRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOverridingHiddensCall_in_entryRuleOverridingHiddensCall761);
            iv_ruleOverridingHiddensCall=ruleOverridingHiddensCall();
            _fsp--;

             current =iv_ruleOverridingHiddensCall; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOverridingHiddensCall771); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end entryRuleOverridingHiddensCall


    // $ANTLR start ruleOverridingHiddensCall
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:420:1: ruleOverridingHiddensCall returns [EObject current=null] : ( 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) ) ;
    public final EObject ruleOverridingHiddensCall() throws RecognitionException {
        EObject current = null;

        Token lv_spaces_1_0=null;
        Token lv_valid_2_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:426:6: ( ( 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:427:1: ( 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:427:1: ( 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:427:3: 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) )
            {
            match(input,15,FollowSets000.FOLLOW_15_in_ruleOverridingHiddensCall810); 

                    createLeafNode(grammarAccess.getOverridingHiddensCallAccess().getCallKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:431:1: ( (lv_spaces_1_0= RULE_WS ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_WS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:432:1: (lv_spaces_1_0= RULE_WS )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:432:1: (lv_spaces_1_0= RULE_WS )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:433:3: lv_spaces_1_0= RULE_WS
                    {
                    lv_spaces_1_0=(Token)input.LT(1);
                    match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleOverridingHiddensCall827); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:455:3: ( (lv_valid_2_0= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:456:1: (lv_valid_2_0= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:456:1: (lv_valid_2_0= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:457:3: lv_valid_2_0= ';'
            {
            lv_valid_2_0=(Token)input.LT(1);
            match(input,10,FollowSets000.FOLLOW_10_in_ruleOverridingHiddensCall851); 

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
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end ruleOverridingHiddensCall


    // $ANTLR start entryRuleInheritingHiddens
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:487:1: entryRuleInheritingHiddens returns [EObject current=null] : iv_ruleInheritingHiddens= ruleInheritingHiddens EOF ;
    public final EObject entryRuleInheritingHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritingHiddens = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:491:2: (iv_ruleInheritingHiddens= ruleInheritingHiddens EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:492:2: iv_ruleInheritingHiddens= ruleInheritingHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInheritingHiddensRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleInheritingHiddens_in_entryRuleInheritingHiddens910);
            iv_ruleInheritingHiddens=ruleInheritingHiddens();
            _fsp--;

             current =iv_ruleInheritingHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInheritingHiddens920); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end entryRuleInheritingHiddens


    // $ANTLR start ruleInheritingHiddens
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:502:1: ruleInheritingHiddens returns [EObject current=null] : ( 'inheriting' 'hiddens' '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) ')' ( (lv_valid_6_0= ';' ) ) ) ;
    public final EObject ruleInheritingHiddens() throws RecognitionException {
        EObject current = null;

        Token lv_valid_6_0=null;
        EObject lv_called_3_0 = null;

        EObject lv_hidingCalled_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:508:6: ( ( 'inheriting' 'hiddens' '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) ')' ( (lv_valid_6_0= ';' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:509:1: ( 'inheriting' 'hiddens' '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) ')' ( (lv_valid_6_0= ';' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:509:1: ( 'inheriting' 'hiddens' '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) ')' ( (lv_valid_6_0= ';' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:509:3: 'inheriting' 'hiddens' '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) ')' ( (lv_valid_6_0= ';' ) )
            {
            match(input,16,FollowSets000.FOLLOW_16_in_ruleInheritingHiddens959); 

                    createLeafNode(grammarAccess.getInheritingHiddensAccess().getInheritingKeyword_0(), null); 
                
            match(input,9,FollowSets000.FOLLOW_9_in_ruleInheritingHiddens969); 

                    createLeafNode(grammarAccess.getInheritingHiddensAccess().getHiddensKeyword_1(), null); 
                
            match(input,13,FollowSets000.FOLLOW_13_in_ruleInheritingHiddens979); 

                    createLeafNode(grammarAccess.getInheritingHiddensAccess().getLeftParenthesisKeyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:521:1: ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) )
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
                    new NoViableAltException("521:1: ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:521:2: ( (lv_called_3_0= ruleInheritingHiddensCall ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:521:2: ( (lv_called_3_0= ruleInheritingHiddensCall ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:522:1: (lv_called_3_0= ruleInheritingHiddensCall )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:522:1: (lv_called_3_0= ruleInheritingHiddensCall )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:523:3: lv_called_3_0= ruleInheritingHiddensCall
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInheritingHiddensAccess().getCalledInheritingHiddensCallParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleInheritingHiddensCall_in_ruleInheritingHiddens1001);
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:546:6: ( (lv_hidingCalled_4_0= ruleHidingHiddens ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:546:6: ( (lv_hidingCalled_4_0= ruleHidingHiddens ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:547:1: (lv_hidingCalled_4_0= ruleHidingHiddens )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:547:1: (lv_hidingCalled_4_0= ruleHidingHiddens )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:548:3: lv_hidingCalled_4_0= ruleHidingHiddens
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInheritingHiddensAccess().getHidingCalledHidingHiddensParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleHidingHiddens_in_ruleInheritingHiddens1028);
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

            match(input,14,FollowSets000.FOLLOW_14_in_ruleInheritingHiddens1039); 

                    createLeafNode(grammarAccess.getInheritingHiddensAccess().getRightParenthesisKeyword_4(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:574:1: ( (lv_valid_6_0= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:575:1: (lv_valid_6_0= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:575:1: (lv_valid_6_0= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:576:3: lv_valid_6_0= ';'
            {
            lv_valid_6_0=(Token)input.LT(1);
            match(input,10,FollowSets000.FOLLOW_10_in_ruleInheritingHiddens1057); 

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
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end ruleInheritingHiddens


    // $ANTLR start entryRuleDatatypeHiddens
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:606:1: entryRuleDatatypeHiddens returns [EObject current=null] : iv_ruleDatatypeHiddens= ruleDatatypeHiddens EOF ;
    public final EObject entryRuleDatatypeHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatypeHiddens = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:607:2: (iv_ruleDatatypeHiddens= ruleDatatypeHiddens EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:608:2: iv_ruleDatatypeHiddens= ruleDatatypeHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDatatypeHiddensRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeHiddens_in_entryRuleDatatypeHiddens1110);
            iv_ruleDatatypeHiddens=ruleDatatypeHiddens();
            _fsp--;

             current =iv_ruleDatatypeHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypeHiddens1120); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:615:1: ruleDatatypeHiddens returns [EObject current=null] : ( 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) ) ;
    public final EObject ruleDatatypeHiddens() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_valid_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:620:6: ( ( 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:621:1: ( 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:621:1: ( 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:621:3: 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) )
            {
            match(input,17,FollowSets000.FOLLOW_17_in_ruleDatatypeHiddens1155); 

                    createLeafNode(grammarAccess.getDatatypeHiddensAccess().getDatatypeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:625:1: ( (lv_valid_1_0= ruleDatatypeRule ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:626:1: (lv_valid_1_0= ruleDatatypeRule )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:626:1: (lv_valid_1_0= ruleDatatypeRule )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:627:3: lv_valid_1_0= ruleDatatypeRule
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDatatypeHiddensAccess().getValidDatatypeRuleParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeRule_in_ruleDatatypeHiddens1176);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:657:1: entryRuleDatatypeRule returns [String current=null] : iv_ruleDatatypeRule= ruleDatatypeRule EOF ;
    public final String entryRuleDatatypeRule() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatypeRule = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:661:2: (iv_ruleDatatypeRule= ruleDatatypeRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:662:2: iv_ruleDatatypeRule= ruleDatatypeRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDatatypeRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeRule_in_entryRuleDatatypeRule1219);
            iv_ruleDatatypeRule=ruleDatatypeRule();
            _fsp--;

             current =iv_ruleDatatypeRule.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypeRule1230); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end entryRuleDatatypeRule


    // $ANTLR start ruleDatatypeRule
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:672:1: ruleDatatypeRule returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'rule' kw= ';' ) ;
    public final AntlrDatatypeRuleToken ruleDatatypeRule() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:678:6: ( (kw= 'rule' kw= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:679:1: (kw= 'rule' kw= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:679:1: (kw= 'rule' kw= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:680:2: kw= 'rule' kw= ';'
            {
            kw=(Token)input.LT(1);
            match(input,18,FollowSets000.FOLLOW_18_in_ruleDatatypeRule1272); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getDatatypeRuleAccess().getRuleKeyword_0(), null); 
                
            kw=(Token)input.LT(1);
            match(input,10,FollowSets000.FOLLOW_10_in_ruleDatatypeRule1285); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getDatatypeRuleAccess().getSemicolonKeyword_1(), null); 
                

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end ruleDatatypeRule


    // $ANTLR start entryRuleHidingHiddens
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:702:1: entryRuleHidingHiddens returns [EObject current=null] : iv_ruleHidingHiddens= ruleHidingHiddens EOF ;
    public final EObject entryRuleHidingHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHidingHiddens = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:706:2: (iv_ruleHidingHiddens= ruleHidingHiddens EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:707:2: iv_ruleHidingHiddens= ruleHidingHiddens EOF
            {
             currentNode = createCompositeNode(grammarAccess.getHidingHiddensRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleHidingHiddens_in_entryRuleHidingHiddens1335);
            iv_ruleHidingHiddens=ruleHidingHiddens();
            _fsp--;

             current =iv_ruleHidingHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleHidingHiddens1345); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end entryRuleHidingHiddens


    // $ANTLR start ruleHidingHiddens
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:717:1: ruleHidingHiddens returns [EObject current=null] : ( 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) ) ;
    public final EObject ruleHidingHiddens() throws RecognitionException {
        EObject current = null;

        Token lv_space_1_0=null;
        EObject lv_called_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:723:6: ( ( 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:724:1: ( 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:724:1: ( 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:724:3: 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) )
            {
            match(input,19,FollowSets000.FOLLOW_19_in_ruleHidingHiddens1384); 

                    createLeafNode(grammarAccess.getHidingHiddensAccess().getHidingKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:728:1: ( (lv_space_1_0= RULE_WS ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:729:1: (lv_space_1_0= RULE_WS )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:729:1: (lv_space_1_0= RULE_WS )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:730:3: lv_space_1_0= RULE_WS
            {
            lv_space_1_0=(Token)input.LT(1);
            match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleHidingHiddens1401); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:752:2: ( (lv_called_2_0= ruleInheritingHiddensCall ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:753:1: (lv_called_2_0= ruleInheritingHiddensCall )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:753:1: (lv_called_2_0= ruleInheritingHiddensCall )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:754:3: lv_called_2_0= ruleInheritingHiddensCall
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getHidingHiddensAccess().getCalledInheritingHiddensCallParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleInheritingHiddensCall_in_ruleHidingHiddens1427);
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
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end ruleHidingHiddens


    // $ANTLR start entryRuleInheritingHiddensCall
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:787:1: entryRuleInheritingHiddensCall returns [EObject current=null] : iv_ruleInheritingHiddensCall= ruleInheritingHiddensCall EOF ;
    public final EObject entryRuleInheritingHiddensCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritingHiddensCall = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:788:2: (iv_ruleInheritingHiddensCall= ruleInheritingHiddensCall EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:789:2: iv_ruleInheritingHiddensCall= ruleInheritingHiddensCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInheritingHiddensCallRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleInheritingHiddensCall_in_entryRuleInheritingHiddensCall1467);
            iv_ruleInheritingHiddensCall=ruleInheritingHiddensCall();
            _fsp--;

             current =iv_ruleInheritingHiddensCall; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInheritingHiddensCall1477); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:796:1: ruleInheritingHiddensCall returns [EObject current=null] : ( 'call' ( (lv_valid_1_0= ';' ) ) ) ;
    public final EObject ruleInheritingHiddensCall() throws RecognitionException {
        EObject current = null;

        Token lv_valid_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:801:6: ( ( 'call' ( (lv_valid_1_0= ';' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:802:1: ( 'call' ( (lv_valid_1_0= ';' ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:802:1: ( 'call' ( (lv_valid_1_0= ';' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:802:3: 'call' ( (lv_valid_1_0= ';' ) )
            {
            match(input,15,FollowSets000.FOLLOW_15_in_ruleInheritingHiddensCall1512); 

                    createLeafNode(grammarAccess.getInheritingHiddensCallAccess().getCallKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:806:1: ( (lv_valid_1_0= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:807:1: (lv_valid_1_0= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:807:1: (lv_valid_1_0= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalHiddenTerminalsTestLanguage.g:808:3: lv_valid_1_0= ';'
            {
            lv_valid_1_0=(Token)input.LT(1);
            match(input,10,FollowSets000.FOLLOW_10_in_ruleInheritingHiddensCall1530); 

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
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWithoutHiddens_in_ruleModel132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWithHiddens_in_ruleModel159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOverridingHiddens_in_ruleModel186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInheritingHiddens_in_ruleModel213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeHiddens_in_ruleModel240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWithoutHiddens_in_entryRuleWithoutHiddens275 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWithoutHiddens285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_8_in_ruleWithoutHiddens320 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleWithoutHiddens337 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_9_in_ruleWithoutHiddens352 = new BitSet(new long[]{0x0000000000000410L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleWithoutHiddens369 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleWithoutHiddens393 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWithHiddens_in_entryRuleWithHiddens448 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWithHiddens458 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleWithHiddens497 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_9_in_ruleWithHiddens507 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleWithHiddens525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOverridingHiddens_in_entryRuleOverridingHiddens584 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOverridingHiddens594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleOverridingHiddens633 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_9_in_ruleOverridingHiddens643 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleOverridingHiddens653 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleOverridingHiddensCall_in_ruleOverridingHiddens674 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleOverridingHiddens684 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleOverridingHiddens702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOverridingHiddensCall_in_entryRuleOverridingHiddensCall761 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOverridingHiddensCall771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleOverridingHiddensCall810 = new BitSet(new long[]{0x0000000000000410L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleOverridingHiddensCall827 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleOverridingHiddensCall851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInheritingHiddens_in_entryRuleInheritingHiddens910 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInheritingHiddens920 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleInheritingHiddens959 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_9_in_ruleInheritingHiddens969 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleInheritingHiddens979 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_ruleInheritingHiddensCall_in_ruleInheritingHiddens1001 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_ruleHidingHiddens_in_ruleInheritingHiddens1028 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleInheritingHiddens1039 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleInheritingHiddens1057 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeHiddens_in_entryRuleDatatypeHiddens1110 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeHiddens1120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleDatatypeHiddens1155 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleDatatypeRule_in_ruleDatatypeHiddens1176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeRule_in_entryRuleDatatypeRule1219 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeRule1230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleDatatypeRule1272 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleDatatypeRule1285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHidingHiddens_in_entryRuleHidingHiddens1335 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleHidingHiddens1345 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleHidingHiddens1384 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleHidingHiddens1401 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleInheritingHiddensCall_in_ruleHidingHiddens1427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInheritingHiddensCall_in_entryRuleInheritingHiddensCall1467 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInheritingHiddensCall1477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleInheritingHiddensCall1512 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_10_in_ruleInheritingHiddensCall1530 = new BitSet(new long[]{0x0000000000000002L});
    }


}