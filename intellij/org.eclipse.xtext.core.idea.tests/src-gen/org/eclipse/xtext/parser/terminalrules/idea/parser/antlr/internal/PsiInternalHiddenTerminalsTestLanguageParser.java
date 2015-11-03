package org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.terminalrules.services.HiddenTerminalsTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalHiddenTerminalsTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'without'", "'hiddens'", "';'", "'with'", "'overriding'", "'('", "')'", "'call'", "'inheriting'", "'datatype'", "'rule'", "'hiding'"
    };
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=7;
    public static final int T__10=10;
    public static final int RULE_WS=4;
    public static final int RULE_SL_COMMENT=6;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int RULE_ML_COMMENT=5;

    // delegates
    // delegators


        public PsiInternalHiddenTerminalsTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalHiddenTerminalsTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalHiddenTerminalsTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalHiddenTerminalsTestLanguage.g"; }



    	protected HiddenTerminalsTestLanguageGrammarAccess grammarAccess;

    	protected HiddenTerminalsTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalHiddenTerminalsTestLanguageParser(PsiBuilder builder, TokenStream input, HiddenTerminalsTestLanguageElementTypeProvider elementTypeProvider, HiddenTerminalsTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Model";
    	}




    // $ANTLR start "entryRuleModel"
    // PsiInternalHiddenTerminalsTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalHiddenTerminalsTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalHiddenTerminalsTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : (this_WithoutHiddens_0= ruleWithoutHiddens | this_WithHiddens_1= ruleWithHiddens | this_OverridingHiddens_2= ruleOverridingHiddens | this_InheritingHiddens_3= ruleInheritingHiddens | this_DatatypeHiddens_4= ruleDatatypeHiddens ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean this_WithoutHiddens_0 = null;

        Boolean this_WithHiddens_1 = null;

        Boolean this_OverridingHiddens_2 = null;

        Boolean this_InheritingHiddens_3 = null;

        Boolean this_DatatypeHiddens_4 = null;


        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:60:1: ( (this_WithoutHiddens_0= ruleWithoutHiddens | this_WithHiddens_1= ruleWithHiddens | this_OverridingHiddens_2= ruleOverridingHiddens | this_InheritingHiddens_3= ruleInheritingHiddens | this_DatatypeHiddens_4= ruleDatatypeHiddens ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:61:2: (this_WithoutHiddens_0= ruleWithoutHiddens | this_WithHiddens_1= ruleWithHiddens | this_OverridingHiddens_2= ruleOverridingHiddens | this_InheritingHiddens_3= ruleInheritingHiddens | this_DatatypeHiddens_4= ruleDatatypeHiddens )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:61:2: (this_WithoutHiddens_0= ruleWithoutHiddens | this_WithHiddens_1= ruleWithHiddens | this_OverridingHiddens_2= ruleOverridingHiddens | this_InheritingHiddens_3= ruleInheritingHiddens | this_DatatypeHiddens_4= ruleDatatypeHiddens )
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
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // PsiInternalHiddenTerminalsTestLanguage.g:62:3: this_WithoutHiddens_0= ruleWithoutHiddens
                    {

                    			markComposite(elementTypeProvider.getModel_WithoutHiddensParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_WithoutHiddens_0=ruleWithoutHiddens();

                    state._fsp--;


                    			current = this_WithoutHiddens_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalHiddenTerminalsTestLanguage.g:71:3: this_WithHiddens_1= ruleWithHiddens
                    {

                    			markComposite(elementTypeProvider.getModel_WithHiddensParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_WithHiddens_1=ruleWithHiddens();

                    state._fsp--;


                    			current = this_WithHiddens_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalHiddenTerminalsTestLanguage.g:80:3: this_OverridingHiddens_2= ruleOverridingHiddens
                    {

                    			markComposite(elementTypeProvider.getModel_OverridingHiddensParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_OverridingHiddens_2=ruleOverridingHiddens();

                    state._fsp--;


                    			current = this_OverridingHiddens_2;
                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalHiddenTerminalsTestLanguage.g:89:3: this_InheritingHiddens_3= ruleInheritingHiddens
                    {

                    			markComposite(elementTypeProvider.getModel_InheritingHiddensParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_InheritingHiddens_3=ruleInheritingHiddens();

                    state._fsp--;


                    			current = this_InheritingHiddens_3;
                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalHiddenTerminalsTestLanguage.g:98:3: this_DatatypeHiddens_4= ruleDatatypeHiddens
                    {

                    			markComposite(elementTypeProvider.getModel_DatatypeHiddensParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_DatatypeHiddens_4=ruleDatatypeHiddens();

                    state._fsp--;


                    			current = this_DatatypeHiddens_4;
                    			doneComposite();
                    		

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleWithoutHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:110:1: entryRuleWithoutHiddens returns [Boolean current=false] : iv_ruleWithoutHiddens= ruleWithoutHiddens EOF ;
    public final Boolean entryRuleWithoutHiddens() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleWithoutHiddens = null;


        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:110:56: (iv_ruleWithoutHiddens= ruleWithoutHiddens EOF )
            // PsiInternalHiddenTerminalsTestLanguage.g:111:2: iv_ruleWithoutHiddens= ruleWithoutHiddens EOF
            {
             markComposite(elementTypeProvider.getWithoutHiddensElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWithoutHiddens=ruleWithoutHiddens();

            state._fsp--;

             current =iv_ruleWithoutHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWithoutHiddens"


    // $ANTLR start "ruleWithoutHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:117:1: ruleWithoutHiddens returns [Boolean current=false] : (otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) ) ;
    public final Boolean ruleWithoutHiddens() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_spaces_1_0=null;
        Token otherlv_2=null;
        Token lv_spaces_3_0=null;
        Token lv_valid_4_0=null;

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:118:1: ( (otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:119:2: (otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:119:2: (otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:120:3: otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) )
            {

            			markLeaf(elementTypeProvider.getWithoutHiddens_WithoutKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,8,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTerminalsTestLanguage.g:127:3: ( (lv_spaces_1_0= RULE_WS ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:128:4: (lv_spaces_1_0= RULE_WS )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:128:4: (lv_spaces_1_0= RULE_WS )
            // PsiInternalHiddenTerminalsTestLanguage.g:129:5: lv_spaces_1_0= RULE_WS
            {

            					markLeaf(elementTypeProvider.getWithoutHiddens_SpacesWSTerminalRuleCall_1_0ElementType());
            				
            lv_spaces_1_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_4); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_spaces_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getWithoutHiddens_HiddensKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,9,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalHiddenTerminalsTestLanguage.g:151:3: ( (lv_spaces_3_0= RULE_WS ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_WS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalHiddenTerminalsTestLanguage.g:152:4: (lv_spaces_3_0= RULE_WS )
                    {
                    // PsiInternalHiddenTerminalsTestLanguage.g:152:4: (lv_spaces_3_0= RULE_WS )
                    // PsiInternalHiddenTerminalsTestLanguage.g:153:5: lv_spaces_3_0= RULE_WS
                    {

                    					markLeaf(elementTypeProvider.getWithoutHiddens_SpacesWSTerminalRuleCall_3_0ElementType());
                    				
                    lv_spaces_3_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_6); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_spaces_3_0);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalHiddenTerminalsTestLanguage.g:168:3: ( (lv_valid_4_0= ';' ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:169:4: (lv_valid_4_0= ';' )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:169:4: (lv_valid_4_0= ';' )
            // PsiInternalHiddenTerminalsTestLanguage.g:170:5: lv_valid_4_0= ';'
            {

            					markLeaf(elementTypeProvider.getWithoutHiddens_ValidSemicolonKeyword_4_0ElementType());
            				
            lv_valid_4_0=(Token)match(input,10,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_valid_4_0);
            				

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWithoutHiddens"


    // $ANTLR start "entryRuleWithHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:189:1: entryRuleWithHiddens returns [Boolean current=false] : iv_ruleWithHiddens= ruleWithHiddens EOF ;
    public final Boolean entryRuleWithHiddens() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleWithHiddens = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:191:2: (iv_ruleWithHiddens= ruleWithHiddens EOF )
            // PsiInternalHiddenTerminalsTestLanguage.g:192:2: iv_ruleWithHiddens= ruleWithHiddens EOF
            {
             markComposite(elementTypeProvider.getWithHiddensElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWithHiddens=ruleWithHiddens();

            state._fsp--;

             current =iv_ruleWithHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleWithHiddens"


    // $ANTLR start "ruleWithHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:201:1: ruleWithHiddens returns [Boolean current=false] : (otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) ) ) ;
    public final Boolean ruleWithHiddens() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_valid_2_0=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:204:2: ( (otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:205:2: (otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) ) )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:205:2: (otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:206:3: otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) )
            {

            			markLeaf(elementTypeProvider.getWithHiddens_WithKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getWithHiddens_HiddensKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,9,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalHiddenTerminalsTestLanguage.g:220:3: ( (lv_valid_2_0= ';' ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:221:4: (lv_valid_2_0= ';' )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:221:4: (lv_valid_2_0= ';' )
            // PsiInternalHiddenTerminalsTestLanguage.g:222:5: lv_valid_2_0= ';'
            {

            					markLeaf(elementTypeProvider.getWithHiddens_ValidSemicolonKeyword_2_0ElementType());
            				
            lv_valid_2_0=(Token)match(input,10,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_valid_2_0);
            				

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleWithHiddens"


    // $ANTLR start "entryRuleOverridingHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:244:1: entryRuleOverridingHiddens returns [Boolean current=false] : iv_ruleOverridingHiddens= ruleOverridingHiddens EOF ;
    public final Boolean entryRuleOverridingHiddens() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOverridingHiddens = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:246:2: (iv_ruleOverridingHiddens= ruleOverridingHiddens EOF )
            // PsiInternalHiddenTerminalsTestLanguage.g:247:2: iv_ruleOverridingHiddens= ruleOverridingHiddens EOF
            {
             markComposite(elementTypeProvider.getOverridingHiddensElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOverridingHiddens=ruleOverridingHiddens();

            state._fsp--;

             current =iv_ruleOverridingHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleOverridingHiddens"


    // $ANTLR start "ruleOverridingHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:256:1: ruleOverridingHiddens returns [Boolean current=false] : (otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) ) ) ;
    public final Boolean ruleOverridingHiddens() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_valid_5_0=null;
        Boolean lv_called_3_0 = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:259:2: ( (otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:260:2: (otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) ) )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:260:2: (otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:261:3: otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) )
            {

            			markLeaf(elementTypeProvider.getOverridingHiddens_OverridingKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getOverridingHiddens_HiddensKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,9,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_1);
            		

            			markLeaf(elementTypeProvider.getOverridingHiddens_LeftParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalHiddenTerminalsTestLanguage.g:282:3: ( (lv_called_3_0= ruleOverridingHiddensCall ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:283:4: (lv_called_3_0= ruleOverridingHiddensCall )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:283:4: (lv_called_3_0= ruleOverridingHiddensCall )
            // PsiInternalHiddenTerminalsTestLanguage.g:284:5: lv_called_3_0= ruleOverridingHiddensCall
            {

            					markComposite(elementTypeProvider.getOverridingHiddens_CalledOverridingHiddensCallParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_9);
            lv_called_3_0=ruleOverridingHiddensCall();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            			markLeaf(elementTypeProvider.getOverridingHiddens_RightParenthesisKeyword_4ElementType());
            		
            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalHiddenTerminalsTestLanguage.g:304:3: ( (lv_valid_5_0= ';' ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:305:4: (lv_valid_5_0= ';' )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:305:4: (lv_valid_5_0= ';' )
            // PsiInternalHiddenTerminalsTestLanguage.g:306:5: lv_valid_5_0= ';'
            {

            					markLeaf(elementTypeProvider.getOverridingHiddens_ValidSemicolonKeyword_5_0ElementType());
            				
            lv_valid_5_0=(Token)match(input,10,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_valid_5_0);
            				

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleOverridingHiddens"


    // $ANTLR start "entryRuleOverridingHiddensCall"
    // PsiInternalHiddenTerminalsTestLanguage.g:328:1: entryRuleOverridingHiddensCall returns [Boolean current=false] : iv_ruleOverridingHiddensCall= ruleOverridingHiddensCall EOF ;
    public final Boolean entryRuleOverridingHiddensCall() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOverridingHiddensCall = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:330:2: (iv_ruleOverridingHiddensCall= ruleOverridingHiddensCall EOF )
            // PsiInternalHiddenTerminalsTestLanguage.g:331:2: iv_ruleOverridingHiddensCall= ruleOverridingHiddensCall EOF
            {
             markComposite(elementTypeProvider.getOverridingHiddensCallElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOverridingHiddensCall=ruleOverridingHiddensCall();

            state._fsp--;

             current =iv_ruleOverridingHiddensCall; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleOverridingHiddensCall"


    // $ANTLR start "ruleOverridingHiddensCall"
    // PsiInternalHiddenTerminalsTestLanguage.g:340:1: ruleOverridingHiddensCall returns [Boolean current=false] : (otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) ) ;
    public final Boolean ruleOverridingHiddensCall() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_spaces_1_0=null;
        Token lv_valid_2_0=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:343:2: ( (otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:344:2: (otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:344:2: (otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:345:3: otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) )
            {

            			markLeaf(elementTypeProvider.getOverridingHiddensCall_CallKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTerminalsTestLanguage.g:352:3: ( (lv_spaces_1_0= RULE_WS ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_WS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalHiddenTerminalsTestLanguage.g:353:4: (lv_spaces_1_0= RULE_WS )
                    {
                    // PsiInternalHiddenTerminalsTestLanguage.g:353:4: (lv_spaces_1_0= RULE_WS )
                    // PsiInternalHiddenTerminalsTestLanguage.g:354:5: lv_spaces_1_0= RULE_WS
                    {

                    					markLeaf(elementTypeProvider.getOverridingHiddensCall_SpacesWSTerminalRuleCall_1_0ElementType());
                    				
                    lv_spaces_1_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_6); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_spaces_1_0);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalHiddenTerminalsTestLanguage.g:369:3: ( (lv_valid_2_0= ';' ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:370:4: (lv_valid_2_0= ';' )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:370:4: (lv_valid_2_0= ';' )
            // PsiInternalHiddenTerminalsTestLanguage.g:371:5: lv_valid_2_0= ';'
            {

            					markLeaf(elementTypeProvider.getOverridingHiddensCall_ValidSemicolonKeyword_2_0ElementType());
            				
            lv_valid_2_0=(Token)match(input,10,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_valid_2_0);
            				

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleOverridingHiddensCall"


    // $ANTLR start "entryRuleInheritingHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:393:1: entryRuleInheritingHiddens returns [Boolean current=false] : iv_ruleInheritingHiddens= ruleInheritingHiddens EOF ;
    public final Boolean entryRuleInheritingHiddens() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleInheritingHiddens = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:395:2: (iv_ruleInheritingHiddens= ruleInheritingHiddens EOF )
            // PsiInternalHiddenTerminalsTestLanguage.g:396:2: iv_ruleInheritingHiddens= ruleInheritingHiddens EOF
            {
             markComposite(elementTypeProvider.getInheritingHiddensElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInheritingHiddens=ruleInheritingHiddens();

            state._fsp--;

             current =iv_ruleInheritingHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleInheritingHiddens"


    // $ANTLR start "ruleInheritingHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:405:1: ruleInheritingHiddens returns [Boolean current=false] : (otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) ) ) ;
    public final Boolean ruleInheritingHiddens() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token lv_valid_6_0=null;
        Boolean lv_called_3_0 = null;

        Boolean lv_hidingCalled_4_0 = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:408:2: ( (otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:409:2: (otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) ) )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:409:2: (otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:410:3: otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) )
            {

            			markLeaf(elementTypeProvider.getInheritingHiddens_InheritingKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getInheritingHiddens_HiddensKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,9,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_1);
            		

            			markLeaf(elementTypeProvider.getInheritingHiddens_LeftParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalHiddenTerminalsTestLanguage.g:431:3: ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) )
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
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalHiddenTerminalsTestLanguage.g:432:4: ( (lv_called_3_0= ruleInheritingHiddensCall ) )
                    {
                    // PsiInternalHiddenTerminalsTestLanguage.g:432:4: ( (lv_called_3_0= ruleInheritingHiddensCall ) )
                    // PsiInternalHiddenTerminalsTestLanguage.g:433:5: (lv_called_3_0= ruleInheritingHiddensCall )
                    {
                    // PsiInternalHiddenTerminalsTestLanguage.g:433:5: (lv_called_3_0= ruleInheritingHiddensCall )
                    // PsiInternalHiddenTerminalsTestLanguage.g:434:6: lv_called_3_0= ruleInheritingHiddensCall
                    {

                    						markComposite(elementTypeProvider.getInheritingHiddens_CalledInheritingHiddensCallParserRuleCall_3_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_called_3_0=ruleInheritingHiddensCall();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalHiddenTerminalsTestLanguage.g:448:4: ( (lv_hidingCalled_4_0= ruleHidingHiddens ) )
                    {
                    // PsiInternalHiddenTerminalsTestLanguage.g:448:4: ( (lv_hidingCalled_4_0= ruleHidingHiddens ) )
                    // PsiInternalHiddenTerminalsTestLanguage.g:449:5: (lv_hidingCalled_4_0= ruleHidingHiddens )
                    {
                    // PsiInternalHiddenTerminalsTestLanguage.g:449:5: (lv_hidingCalled_4_0= ruleHidingHiddens )
                    // PsiInternalHiddenTerminalsTestLanguage.g:450:6: lv_hidingCalled_4_0= ruleHidingHiddens
                    {

                    						markComposite(elementTypeProvider.getInheritingHiddens_HidingCalledHidingHiddensParserRuleCall_3_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_hidingCalled_4_0=ruleHidingHiddens();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getInheritingHiddens_RightParenthesisKeyword_4ElementType());
            		
            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_5);
            		
            // PsiInternalHiddenTerminalsTestLanguage.g:471:3: ( (lv_valid_6_0= ';' ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:472:4: (lv_valid_6_0= ';' )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:472:4: (lv_valid_6_0= ';' )
            // PsiInternalHiddenTerminalsTestLanguage.g:473:5: lv_valid_6_0= ';'
            {

            					markLeaf(elementTypeProvider.getInheritingHiddens_ValidSemicolonKeyword_5_0ElementType());
            				
            lv_valid_6_0=(Token)match(input,10,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_valid_6_0);
            				

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleInheritingHiddens"


    // $ANTLR start "entryRuleDatatypeHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:495:1: entryRuleDatatypeHiddens returns [Boolean current=false] : iv_ruleDatatypeHiddens= ruleDatatypeHiddens EOF ;
    public final Boolean entryRuleDatatypeHiddens() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDatatypeHiddens = null;


        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:495:57: (iv_ruleDatatypeHiddens= ruleDatatypeHiddens EOF )
            // PsiInternalHiddenTerminalsTestLanguage.g:496:2: iv_ruleDatatypeHiddens= ruleDatatypeHiddens EOF
            {
             markComposite(elementTypeProvider.getDatatypeHiddensElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatatypeHiddens=ruleDatatypeHiddens();

            state._fsp--;

             current =iv_ruleDatatypeHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDatatypeHiddens"


    // $ANTLR start "ruleDatatypeHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:502:1: ruleDatatypeHiddens returns [Boolean current=false] : (otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) ) ;
    public final Boolean ruleDatatypeHiddens() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_valid_1_0 = null;


        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:503:1: ( (otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:504:2: (otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:504:2: (otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:505:3: otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) )
            {

            			markLeaf(elementTypeProvider.getDatatypeHiddens_DatatypeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_11); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTerminalsTestLanguage.g:512:3: ( (lv_valid_1_0= ruleDatatypeRule ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:513:4: (lv_valid_1_0= ruleDatatypeRule )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:513:4: (lv_valid_1_0= ruleDatatypeRule )
            // PsiInternalHiddenTerminalsTestLanguage.g:514:5: lv_valid_1_0= ruleDatatypeRule
            {

            					markComposite(elementTypeProvider.getDatatypeHiddens_ValidDatatypeRuleParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_valid_1_0=ruleDatatypeRule();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDatatypeHiddens"


    // $ANTLR start "entryRuleDatatypeRule"
    // PsiInternalHiddenTerminalsTestLanguage.g:531:1: entryRuleDatatypeRule returns [Boolean current=false] : iv_ruleDatatypeRule= ruleDatatypeRule EOF ;
    public final Boolean entryRuleDatatypeRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDatatypeRule = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:533:2: (iv_ruleDatatypeRule= ruleDatatypeRule EOF )
            // PsiInternalHiddenTerminalsTestLanguage.g:534:2: iv_ruleDatatypeRule= ruleDatatypeRule EOF
            {
             markComposite(elementTypeProvider.getDatatypeRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatatypeRule=ruleDatatypeRule();

            state._fsp--;

             current =iv_ruleDatatypeRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleDatatypeRule"


    // $ANTLR start "ruleDatatypeRule"
    // PsiInternalHiddenTerminalsTestLanguage.g:543:1: ruleDatatypeRule returns [Boolean current=false] : (kw= 'rule' kw= ';' ) ;
    public final Boolean ruleDatatypeRule() throws RecognitionException {
        Boolean current = false;

        Token kw=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:546:2: ( (kw= 'rule' kw= ';' ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:547:2: (kw= 'rule' kw= ';' )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:547:2: (kw= 'rule' kw= ';' )
            // PsiInternalHiddenTerminalsTestLanguage.g:548:3: kw= 'rule' kw= ';'
            {

            			markLeaf(elementTypeProvider.getDatatypeRule_RuleKeyword_0ElementType());
            		
            kw=(Token)match(input,18,FollowSets000.FOLLOW_6); 

            			doneLeaf(kw);
            		

            			markLeaf(elementTypeProvider.getDatatypeRule_SemicolonKeyword_1ElementType());
            		
            kw=(Token)match(input,10,FollowSets000.FOLLOW_2); 

            			doneLeaf(kw);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleDatatypeRule"


    // $ANTLR start "entryRuleHidingHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:569:1: entryRuleHidingHiddens returns [Boolean current=false] : iv_ruleHidingHiddens= ruleHidingHiddens EOF ;
    public final Boolean entryRuleHidingHiddens() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleHidingHiddens = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:571:2: (iv_ruleHidingHiddens= ruleHidingHiddens EOF )
            // PsiInternalHiddenTerminalsTestLanguage.g:572:2: iv_ruleHidingHiddens= ruleHidingHiddens EOF
            {
             markComposite(elementTypeProvider.getHidingHiddensElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleHidingHiddens=ruleHidingHiddens();

            state._fsp--;

             current =iv_ruleHidingHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleHidingHiddens"


    // $ANTLR start "ruleHidingHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:581:1: ruleHidingHiddens returns [Boolean current=false] : (otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) ) ;
    public final Boolean ruleHidingHiddens() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_space_1_0=null;
        Boolean lv_called_2_0 = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:584:2: ( (otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:585:2: (otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:585:2: (otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:586:3: otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) )
            {

            			markLeaf(elementTypeProvider.getHidingHiddens_HidingKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTerminalsTestLanguage.g:593:3: ( (lv_space_1_0= RULE_WS ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:594:4: (lv_space_1_0= RULE_WS )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:594:4: (lv_space_1_0= RULE_WS )
            // PsiInternalHiddenTerminalsTestLanguage.g:595:5: lv_space_1_0= RULE_WS
            {

            					markLeaf(elementTypeProvider.getHidingHiddens_SpaceWSTerminalRuleCall_1_0ElementType());
            				
            lv_space_1_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_8); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_space_1_0);
            				

            }


            }

            // PsiInternalHiddenTerminalsTestLanguage.g:610:3: ( (lv_called_2_0= ruleInheritingHiddensCall ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:611:4: (lv_called_2_0= ruleInheritingHiddensCall )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:611:4: (lv_called_2_0= ruleInheritingHiddensCall )
            // PsiInternalHiddenTerminalsTestLanguage.g:612:5: lv_called_2_0= ruleInheritingHiddensCall
            {

            					markComposite(elementTypeProvider.getHidingHiddens_CalledInheritingHiddensCallParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_called_2_0=ruleInheritingHiddensCall();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleHidingHiddens"


    // $ANTLR start "entryRuleInheritingHiddensCall"
    // PsiInternalHiddenTerminalsTestLanguage.g:632:1: entryRuleInheritingHiddensCall returns [Boolean current=false] : iv_ruleInheritingHiddensCall= ruleInheritingHiddensCall EOF ;
    public final Boolean entryRuleInheritingHiddensCall() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleInheritingHiddensCall = null;


        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:632:63: (iv_ruleInheritingHiddensCall= ruleInheritingHiddensCall EOF )
            // PsiInternalHiddenTerminalsTestLanguage.g:633:2: iv_ruleInheritingHiddensCall= ruleInheritingHiddensCall EOF
            {
             markComposite(elementTypeProvider.getInheritingHiddensCallElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInheritingHiddensCall=ruleInheritingHiddensCall();

            state._fsp--;

             current =iv_ruleInheritingHiddensCall; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInheritingHiddensCall"


    // $ANTLR start "ruleInheritingHiddensCall"
    // PsiInternalHiddenTerminalsTestLanguage.g:639:1: ruleInheritingHiddensCall returns [Boolean current=false] : (otherlv_0= 'call' ( (lv_valid_1_0= ';' ) ) ) ;
    public final Boolean ruleInheritingHiddensCall() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_valid_1_0=null;

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:640:1: ( (otherlv_0= 'call' ( (lv_valid_1_0= ';' ) ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:641:2: (otherlv_0= 'call' ( (lv_valid_1_0= ';' ) ) )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:641:2: (otherlv_0= 'call' ( (lv_valid_1_0= ';' ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:642:3: otherlv_0= 'call' ( (lv_valid_1_0= ';' ) )
            {

            			markLeaf(elementTypeProvider.getInheritingHiddensCall_CallKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTerminalsTestLanguage.g:649:3: ( (lv_valid_1_0= ';' ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:650:4: (lv_valid_1_0= ';' )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:650:4: (lv_valid_1_0= ';' )
            // PsiInternalHiddenTerminalsTestLanguage.g:651:5: lv_valid_1_0= ';'
            {

            					markLeaf(elementTypeProvider.getInheritingHiddensCall_ValidSemicolonKeyword_1_0ElementType());
            				
            lv_valid_1_0=(Token)match(input,10,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_valid_1_0);
            				

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInheritingHiddensCall"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000410L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    }


}