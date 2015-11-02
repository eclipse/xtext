package org.eclipse.xtext.purexbase.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.purexbase.idea.lang.PureXbaseElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.purexbase.services.PureXbaseGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class PsiInternalPureXbaseParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_HEX", "RULE_INT", "RULE_DECIMAL", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'='", "'+='", "'-='", "'*='", "'/='", "'%='", "'<'", "'>'", "'>='", "'||'", "'&&'", "'=='", "'!='", "'==='", "'!=='", "'instanceof'", "'->'", "'..<'", "'..'", "'=>'", "'<>'", "'?:'", "'+'", "'-'", "'*'", "'**'", "'/'", "'%'", "'!'", "'as'", "'++'", "'--'", "'.'", "'::'", "'?.'", "','", "'('", "')'", "'#'", "'{'", "'}'", "'['", "']'", "'|'", "'if'", "'else'", "'switch'", "':'", "'default'", "'case'", "'for'", "'while'", "'do'", "'var'", "'val'", "'super'", "'new'", "'false'", "'true'", "'null'", "'typeof'", "'throw'", "'return'", "'try'", "'finally'", "'synchronized'", "'catch'", "'?'", "'extends'", "'&'", "'import'", "'static'", "'extension'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=8;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int RULE_HEX=5;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__15=15;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int RULE_INT=6;
    public static final int RULE_DECIMAL=7;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__80=80;
    public static final int T__46=46;
    public static final int T__81=81;
    public static final int T__47=47;
    public static final int T__82=82;
    public static final int T__44=44;
    public static final int T__83=83;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__85=85;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__84=84;
    public static final int T__86=86;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=4;
    public static final int T__32=32;
    public static final int T__71=71;
    public static final int T__33=33;
    public static final int T__72=72;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=11;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;

    // delegates
    // delegators


        public PsiInternalPureXbaseParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalPureXbaseParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalPureXbaseParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalPureXbase.g"; }



    	protected PureXbaseGrammarAccess grammarAccess;

    	protected PureXbaseElementTypeProvider elementTypeProvider;

    	public PsiInternalPureXbaseParser(PsiBuilder builder, TokenStream input, PureXbaseElementTypeProvider elementTypeProvider, PureXbaseGrammarAccess grammarAccess) {
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
    // PsiInternalPureXbase.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalPureXbase.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalPureXbase.g:53:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getModelElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // PsiInternalPureXbase.g:59:1: ruleModel returns [Boolean current=false] : ( ( (lv_importSection_0_0= ruleXImportSection ) )? ( (lv_block_1_0= ruleSpecialBlockExpression ) ) ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_importSection_0_0 = null;

        Boolean lv_block_1_0 = null;


        try {
            // PsiInternalPureXbase.g:60:1: ( ( ( (lv_importSection_0_0= ruleXImportSection ) )? ( (lv_block_1_0= ruleSpecialBlockExpression ) ) ) )
            // PsiInternalPureXbase.g:61:2: ( ( (lv_importSection_0_0= ruleXImportSection ) )? ( (lv_block_1_0= ruleSpecialBlockExpression ) ) )
            {
            // PsiInternalPureXbase.g:61:2: ( ( (lv_importSection_0_0= ruleXImportSection ) )? ( (lv_block_1_0= ruleSpecialBlockExpression ) ) )
            // PsiInternalPureXbase.g:62:3: ( (lv_importSection_0_0= ruleXImportSection ) )? ( (lv_block_1_0= ruleSpecialBlockExpression ) )
            {
            // PsiInternalPureXbase.g:62:3: ( (lv_importSection_0_0= ruleXImportSection ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==84) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // PsiInternalPureXbase.g:63:4: (lv_importSection_0_0= ruleXImportSection )
                    {
                    // PsiInternalPureXbase.g:63:4: (lv_importSection_0_0= ruleXImportSection )
                    // PsiInternalPureXbase.g:64:5: lv_importSection_0_0= ruleXImportSection
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_ImportSectionXImportSectionParserRuleCall_0_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_3);
                    lv_importSection_0_0=ruleXImportSection();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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

            // PsiInternalPureXbase.g:77:3: ( (lv_block_1_0= ruleSpecialBlockExpression ) )
            // PsiInternalPureXbase.g:78:4: (lv_block_1_0= ruleSpecialBlockExpression )
            {
            // PsiInternalPureXbase.g:78:4: (lv_block_1_0= ruleSpecialBlockExpression )
            // PsiInternalPureXbase.g:79:5: lv_block_1_0= ruleSpecialBlockExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getModel_BlockSpecialBlockExpressionParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_block_1_0=ruleSpecialBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


    // $ANTLR start "entryRuleSpecialBlockExpression"
    // PsiInternalPureXbase.g:96:1: entryRuleSpecialBlockExpression returns [Boolean current=false] : iv_ruleSpecialBlockExpression= ruleSpecialBlockExpression EOF ;
    public final Boolean entryRuleSpecialBlockExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSpecialBlockExpression = null;


        try {
            // PsiInternalPureXbase.g:96:64: (iv_ruleSpecialBlockExpression= ruleSpecialBlockExpression EOF )
            // PsiInternalPureXbase.g:97:2: iv_ruleSpecialBlockExpression= ruleSpecialBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getSpecialBlockExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSpecialBlockExpression=ruleSpecialBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSpecialBlockExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleSpecialBlockExpression"


    // $ANTLR start "ruleSpecialBlockExpression"
    // PsiInternalPureXbase.g:103:1: ruleSpecialBlockExpression returns [Boolean current=false] : ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) ;
    public final Boolean ruleSpecialBlockExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean lv_expressions_1_0 = null;


        try {
            // PsiInternalPureXbase.g:104:1: ( ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) )
            // PsiInternalPureXbase.g:105:2: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
            {
            // PsiInternalPureXbase.g:105:2: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
            // PsiInternalPureXbase.g:106:3: () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
            {
            // PsiInternalPureXbase.g:106:3: ()
            // PsiInternalPureXbase.g:107:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getSpecialBlockExpression_XBlockExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalPureXbase.g:113:3: ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=RULE_STRING && LA3_0<=RULE_ID)||LA3_0==20||(LA3_0>=36 && LA3_0<=37)||LA3_0==42||LA3_0==50||(LA3_0>=52 && LA3_0<=53)||LA3_0==55||LA3_0==58||LA3_0==60||(LA3_0>=64 && LA3_0<=77)||LA3_0==79) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalPureXbase.g:114:4: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )?
            	    {
            	    // PsiInternalPureXbase.g:114:4: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) )
            	    // PsiInternalPureXbase.g:115:5: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
            	    {
            	    // PsiInternalPureXbase.g:115:5: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
            	    // PsiInternalPureXbase.g:116:6: lv_expressions_1_0= ruleXExpressionOrVarDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getSpecialBlockExpression_ExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_expressions_1_0=ruleXExpressionOrVarDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }

            	    // PsiInternalPureXbase.g:129:4: (otherlv_2= ';' )?
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==13) ) {
            	        alt2=1;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // PsiInternalPureXbase.g:130:5: otherlv_2= ';'
            	            {
            	            if ( state.backtracking==0 ) {

            	              					markLeaf(elementTypeProvider.getSpecialBlockExpression_SemicolonKeyword_1_1ElementType());
            	              				
            	            }
            	            otherlv_2=(Token)match(input,13,FOLLOW_5); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              					doneLeaf(otherlv_2);
            	              				
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


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
    // $ANTLR end "ruleSpecialBlockExpression"


    // $ANTLR start "entryRuleFeatureCallID"
    // PsiInternalPureXbase.g:143:1: entryRuleFeatureCallID returns [Boolean current=false] : iv_ruleFeatureCallID= ruleFeatureCallID EOF ;
    public final Boolean entryRuleFeatureCallID() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFeatureCallID = null;


        try {
            // PsiInternalPureXbase.g:143:55: (iv_ruleFeatureCallID= ruleFeatureCallID EOF )
            // PsiInternalPureXbase.g:144:2: iv_ruleFeatureCallID= ruleFeatureCallID EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFeatureCallIDElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFeatureCallID=ruleFeatureCallID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureCallID; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFeatureCallID"


    // $ANTLR start "ruleFeatureCallID"
    // PsiInternalPureXbase.g:150:1: ruleFeatureCallID returns [Boolean current=false] : ruleValidID ;
    public final Boolean ruleFeatureCallID() throws RecognitionException {
        Boolean current = false;

        try {
            // PsiInternalPureXbase.g:151:1: ( ruleValidID )
            // PsiInternalPureXbase.g:152:2: ruleValidID
            {
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getFeatureCallID_ValidIDParserRuleCallElementType());
              	
            }
            pushFollow(FOLLOW_2);
            ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		doneComposite();
              	
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
    // $ANTLR end "ruleFeatureCallID"


    // $ANTLR start "entryRuleXExpression"
    // PsiInternalPureXbase.g:162:1: entryRuleXExpression returns [Boolean current=false] : iv_ruleXExpression= ruleXExpression EOF ;
    public final Boolean entryRuleXExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXExpression = null;


        try {
            // PsiInternalPureXbase.g:162:53: (iv_ruleXExpression= ruleXExpression EOF )
            // PsiInternalPureXbase.g:163:2: iv_ruleXExpression= ruleXExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXExpression=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXExpression"


    // $ANTLR start "ruleXExpression"
    // PsiInternalPureXbase.g:169:1: ruleXExpression returns [Boolean current=false] : this_XAssignment_0= ruleXAssignment ;
    public final Boolean ruleXExpression() throws RecognitionException {
        Boolean current = false;

        Boolean this_XAssignment_0 = null;


        try {
            // PsiInternalPureXbase.g:170:1: (this_XAssignment_0= ruleXAssignment )
            // PsiInternalPureXbase.g:171:2: this_XAssignment_0= ruleXAssignment
            {
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getXExpression_XAssignmentParserRuleCallElementType());
              	
            }
            pushFollow(FOLLOW_2);
            this_XAssignment_0=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_XAssignment_0;
              		doneComposite();
              	
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
    // $ANTLR end "ruleXExpression"


    // $ANTLR start "entryRuleXAssignment"
    // PsiInternalPureXbase.g:182:1: entryRuleXAssignment returns [Boolean current=false] : iv_ruleXAssignment= ruleXAssignment EOF ;
    public final Boolean entryRuleXAssignment() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXAssignment = null;


        try {
            // PsiInternalPureXbase.g:182:53: (iv_ruleXAssignment= ruleXAssignment EOF )
            // PsiInternalPureXbase.g:183:2: iv_ruleXAssignment= ruleXAssignment EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXAssignmentElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXAssignment=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXAssignment"


    // $ANTLR start "ruleXAssignment"
    // PsiInternalPureXbase.g:189:1: ruleXAssignment returns [Boolean current=false] : ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) ;
    public final Boolean ruleXAssignment() throws RecognitionException {
        Boolean current = false;

        Boolean lv_value_3_0 = null;

        Boolean this_XOrExpression_4 = null;

        Boolean lv_rightOperand_7_0 = null;


        try {
            // PsiInternalPureXbase.g:190:1: ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) )
            // PsiInternalPureXbase.g:191:2: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            {
            // PsiInternalPureXbase.g:191:2: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==14) ) {
                    alt5=1;
                }
                else if ( (LA5_1==EOF||(LA5_1>=RULE_STRING && LA5_1<=RULE_ID)||LA5_1==13||(LA5_1>=15 && LA5_1<=56)||(LA5_1>=58 && LA5_1<=80)) ) {
                    alt5=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA5_0>=RULE_STRING && LA5_0<=RULE_DECIMAL)||LA5_0==20||(LA5_0>=36 && LA5_0<=37)||LA5_0==42||LA5_0==50||(LA5_0>=52 && LA5_0<=53)||LA5_0==55||LA5_0==58||LA5_0==60||(LA5_0>=64 && LA5_0<=66)||(LA5_0>=69 && LA5_0<=77)||LA5_0==79) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalPureXbase.g:192:3: ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    {
                    // PsiInternalPureXbase.g:192:3: ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    // PsiInternalPureXbase.g:193:4: () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) )
                    {
                    // PsiInternalPureXbase.g:193:4: ()
                    // PsiInternalPureXbase.g:194:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getXAssignment_XAssignmentAction_0_0ElementType());
                      					doneComposite();
                      					associateWithSemanticElement();
                      				
                    }

                    }

                    // PsiInternalPureXbase.g:200:4: ( ( ruleFeatureCallID ) )
                    // PsiInternalPureXbase.g:201:5: ( ruleFeatureCallID )
                    {
                    // PsiInternalPureXbase.g:201:5: ( ruleFeatureCallID )
                    // PsiInternalPureXbase.g:202:6: ruleFeatureCallID
                    {
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXAssignment_FeatureJvmIdentifiableElementCrossReference_0_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_6);
                    ruleFeatureCallID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getXAssignment_OpSingleAssignParserRuleCall_0_2ElementType());
                      			
                    }
                    pushFollow(FOLLOW_3);
                    ruleOpSingleAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneComposite();
                      			
                    }
                    // PsiInternalPureXbase.g:224:4: ( (lv_value_3_0= ruleXAssignment ) )
                    // PsiInternalPureXbase.g:225:5: (lv_value_3_0= ruleXAssignment )
                    {
                    // PsiInternalPureXbase.g:225:5: (lv_value_3_0= ruleXAssignment )
                    // PsiInternalPureXbase.g:226:6: lv_value_3_0= ruleXAssignment
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXAssignment_ValueXAssignmentParserRuleCall_0_3_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleXAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:241:3: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    {
                    // PsiInternalPureXbase.g:241:3: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    // PsiInternalPureXbase.g:242:4: this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getXAssignment_XOrExpressionParserRuleCall_1_0ElementType());
                      			
                    }
                    pushFollow(FOLLOW_7);
                    this_XOrExpression_4=ruleXOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_XOrExpression_4;
                      				doneComposite();
                      			
                    }
                    // PsiInternalPureXbase.g:250:4: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    int alt4=2;
                    alt4 = dfa4.predict(input);
                    switch (alt4) {
                        case 1 :
                            // PsiInternalPureXbase.g:251:5: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            {
                            // PsiInternalPureXbase.g:251:5: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) )
                            // PsiInternalPureXbase.g:252:6: ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) )
                            {
                            // PsiInternalPureXbase.g:262:6: ( () ( ( ruleOpMultiAssign ) ) )
                            // PsiInternalPureXbase.g:263:7: () ( ( ruleOpMultiAssign ) )
                            {
                            // PsiInternalPureXbase.g:263:7: ()
                            // PsiInternalPureXbase.g:264:8: 
                            {
                            if ( state.backtracking==0 ) {

                              								precedeComposite(elementTypeProvider.getXAssignment_XBinaryOperationLeftOperandAction_1_1_0_0_0ElementType());
                              								doneComposite();
                              								associateWithSemanticElement();
                              							
                            }

                            }

                            // PsiInternalPureXbase.g:270:7: ( ( ruleOpMultiAssign ) )
                            // PsiInternalPureXbase.g:271:8: ( ruleOpMultiAssign )
                            {
                            // PsiInternalPureXbase.g:271:8: ( ruleOpMultiAssign )
                            // PsiInternalPureXbase.g:272:9: ruleOpMultiAssign
                            {
                            if ( state.backtracking==0 ) {

                              									if (!current) {
                              										associateWithSemanticElement();
                              										current = true;
                              									}
                              								
                            }
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getXAssignment_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0ElementType());
                              								
                            }
                            pushFollow(FOLLOW_3);
                            ruleOpMultiAssign();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              								
                            }

                            }


                            }


                            }


                            }

                            // PsiInternalPureXbase.g:289:5: ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            // PsiInternalPureXbase.g:290:6: (lv_rightOperand_7_0= ruleXAssignment )
                            {
                            // PsiInternalPureXbase.g:290:6: (lv_rightOperand_7_0= ruleXAssignment )
                            // PsiInternalPureXbase.g:291:7: lv_rightOperand_7_0= ruleXAssignment
                            {
                            if ( state.backtracking==0 ) {

                              							markComposite(elementTypeProvider.getXAssignment_RightOperandXAssignmentParserRuleCall_1_1_1_0ElementType());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_rightOperand_7_0=ruleXAssignment();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneComposite();
                              							if(!current) {
                              								associateWithSemanticElement();
                              								current = true;
                              							}
                              						
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


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
    // $ANTLR end "ruleXAssignment"


    // $ANTLR start "entryRuleOpSingleAssign"
    // PsiInternalPureXbase.g:310:1: entryRuleOpSingleAssign returns [Boolean current=false] : iv_ruleOpSingleAssign= ruleOpSingleAssign EOF ;
    public final Boolean entryRuleOpSingleAssign() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOpSingleAssign = null;


        try {
            // PsiInternalPureXbase.g:310:56: (iv_ruleOpSingleAssign= ruleOpSingleAssign EOF )
            // PsiInternalPureXbase.g:311:2: iv_ruleOpSingleAssign= ruleOpSingleAssign EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpSingleAssignElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpSingleAssign=ruleOpSingleAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpSingleAssign; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpSingleAssign"


    // $ANTLR start "ruleOpSingleAssign"
    // PsiInternalPureXbase.g:317:1: ruleOpSingleAssign returns [Boolean current=false] : kw= '=' ;
    public final Boolean ruleOpSingleAssign() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalPureXbase.g:318:1: (kw= '=' )
            // PsiInternalPureXbase.g:319:2: kw= '='
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getOpSingleAssign_EqualsSignKeywordElementType());
              	
            }
            kw=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		doneLeaf(kw);
              	
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
    // $ANTLR end "ruleOpSingleAssign"


    // $ANTLR start "entryRuleOpMultiAssign"
    // PsiInternalPureXbase.g:329:1: entryRuleOpMultiAssign returns [Boolean current=false] : iv_ruleOpMultiAssign= ruleOpMultiAssign EOF ;
    public final Boolean entryRuleOpMultiAssign() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOpMultiAssign = null;


        try {
            // PsiInternalPureXbase.g:329:55: (iv_ruleOpMultiAssign= ruleOpMultiAssign EOF )
            // PsiInternalPureXbase.g:330:2: iv_ruleOpMultiAssign= ruleOpMultiAssign EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpMultiAssignElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpMultiAssign=ruleOpMultiAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMultiAssign; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpMultiAssign"


    // $ANTLR start "ruleOpMultiAssign"
    // PsiInternalPureXbase.g:336:1: ruleOpMultiAssign returns [Boolean current=false] : (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) ) ;
    public final Boolean ruleOpMultiAssign() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalPureXbase.g:337:1: ( (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) ) )
            // PsiInternalPureXbase.g:338:2: (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) )
            {
            // PsiInternalPureXbase.g:338:2: (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) )
            int alt7=7;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt7=1;
                }
                break;
            case 16:
                {
                alt7=2;
                }
                break;
            case 17:
                {
                alt7=3;
                }
                break;
            case 18:
                {
                alt7=4;
                }
                break;
            case 19:
                {
                alt7=5;
                }
                break;
            case 20:
                {
                alt7=6;
                }
                break;
            case 21:
                {
                alt7=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // PsiInternalPureXbase.g:339:3: kw= '+='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMultiAssign_PlusSignEqualsSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:347:3: kw= '-='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMultiAssign_HyphenMinusEqualsSignKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalPureXbase.g:355:3: kw= '*='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMultiAssign_AsteriskEqualsSignKeyword_2ElementType());
                      		
                    }
                    kw=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalPureXbase.g:363:3: kw= '/='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMultiAssign_SolidusEqualsSignKeyword_3ElementType());
                      		
                    }
                    kw=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 5 :
                    // PsiInternalPureXbase.g:371:3: kw= '%='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMultiAssign_PercentSignEqualsSignKeyword_4ElementType());
                      		
                    }
                    kw=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalPureXbase.g:379:3: (kw= '<' kw= '<' kw= '=' )
                    {
                    // PsiInternalPureXbase.g:379:3: (kw= '<' kw= '<' kw= '=' )
                    // PsiInternalPureXbase.g:380:4: kw= '<' kw= '<' kw= '='
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpMultiAssign_LessThanSignKeyword_5_0ElementType());
                      			
                    }
                    kw=(Token)match(input,20,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpMultiAssign_LessThanSignKeyword_5_1ElementType());
                      			
                    }
                    kw=(Token)match(input,20,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpMultiAssign_EqualsSignKeyword_5_2ElementType());
                      			
                    }
                    kw=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // PsiInternalPureXbase.g:403:3: (kw= '>' (kw= '>' )? kw= '>=' )
                    {
                    // PsiInternalPureXbase.g:403:3: (kw= '>' (kw= '>' )? kw= '>=' )
                    // PsiInternalPureXbase.g:404:4: kw= '>' (kw= '>' )? kw= '>='
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpMultiAssign_GreaterThanSignKeyword_6_0ElementType());
                      			
                    }
                    kw=(Token)match(input,21,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    // PsiInternalPureXbase.g:411:4: (kw= '>' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==21) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // PsiInternalPureXbase.g:412:5: kw= '>'
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getOpMultiAssign_GreaterThanSignKeyword_6_1ElementType());
                              				
                            }
                            kw=(Token)match(input,21,FOLLOW_10); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(kw);
                              				
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpMultiAssign_GreaterThanSignEqualsSignKeyword_6_2ElementType());
                      			
                    }
                    kw=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }

                    }


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
    // $ANTLR end "ruleOpMultiAssign"


    // $ANTLR start "entryRuleXOrExpression"
    // PsiInternalPureXbase.g:432:1: entryRuleXOrExpression returns [Boolean current=false] : iv_ruleXOrExpression= ruleXOrExpression EOF ;
    public final Boolean entryRuleXOrExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXOrExpression = null;


        try {
            // PsiInternalPureXbase.g:432:55: (iv_ruleXOrExpression= ruleXOrExpression EOF )
            // PsiInternalPureXbase.g:433:2: iv_ruleXOrExpression= ruleXOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXOrExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXOrExpression=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXOrExpression"


    // $ANTLR start "ruleXOrExpression"
    // PsiInternalPureXbase.g:439:1: ruleXOrExpression returns [Boolean current=false] : (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
    public final Boolean ruleXOrExpression() throws RecognitionException {
        Boolean current = false;

        Boolean this_XAndExpression_0 = null;

        Boolean lv_rightOperand_3_0 = null;


        try {
            // PsiInternalPureXbase.g:440:1: ( (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
            // PsiInternalPureXbase.g:441:2: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            {
            // PsiInternalPureXbase.g:441:2: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            // PsiInternalPureXbase.g:442:3: this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXOrExpression_XAndExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_11);
            this_XAndExpression_0=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XAndExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalPureXbase.g:450:3: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==23) ) {
                    int LA8_2 = input.LA(2);

                    if ( (synpred2_PsiInternalPureXbase()) ) {
                        alt8=1;
                    }


                }


                switch (alt8) {
            	case 1 :
            	    // PsiInternalPureXbase.g:451:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    {
            	    // PsiInternalPureXbase.g:451:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) )
            	    // PsiInternalPureXbase.g:452:5: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) )
            	    {
            	    // PsiInternalPureXbase.g:462:5: ( () ( ( ruleOpOr ) ) )
            	    // PsiInternalPureXbase.g:463:6: () ( ( ruleOpOr ) )
            	    {
            	    // PsiInternalPureXbase.g:463:6: ()
            	    // PsiInternalPureXbase.g:464:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							precedeComposite(elementTypeProvider.getXOrExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
            	      							doneComposite();
            	      							associateWithSemanticElement();
            	      						
            	    }

            	    }

            	    // PsiInternalPureXbase.g:470:6: ( ( ruleOpOr ) )
            	    // PsiInternalPureXbase.g:471:7: ( ruleOpOr )
            	    {
            	    // PsiInternalPureXbase.g:471:7: ( ruleOpOr )
            	    // PsiInternalPureXbase.g:472:8: ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (!current) {
            	      									associateWithSemanticElement();
            	      									current = true;
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								markComposite(elementTypeProvider.getXOrExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
            	      							
            	    }
            	    pushFollow(FOLLOW_3);
            	    ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								doneComposite();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // PsiInternalPureXbase.g:489:4: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    // PsiInternalPureXbase.g:490:5: (lv_rightOperand_3_0= ruleXAndExpression )
            	    {
            	    // PsiInternalPureXbase.g:490:5: (lv_rightOperand_3_0= ruleXAndExpression )
            	    // PsiInternalPureXbase.g:491:6: lv_rightOperand_3_0= ruleXAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXOrExpression_RightOperandXAndExpressionParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_rightOperand_3_0=ruleXAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // PsiInternalPureXbase.g:509:1: entryRuleOpOr returns [Boolean current=false] : iv_ruleOpOr= ruleOpOr EOF ;
    public final Boolean entryRuleOpOr() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOpOr = null;


        try {
            // PsiInternalPureXbase.g:509:46: (iv_ruleOpOr= ruleOpOr EOF )
            // PsiInternalPureXbase.g:510:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpOrElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpOr"


    // $ANTLR start "ruleOpOr"
    // PsiInternalPureXbase.g:516:1: ruleOpOr returns [Boolean current=false] : kw= '||' ;
    public final Boolean ruleOpOr() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalPureXbase.g:517:1: (kw= '||' )
            // PsiInternalPureXbase.g:518:2: kw= '||'
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getOpOr_VerticalLineVerticalLineKeywordElementType());
              	
            }
            kw=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		doneLeaf(kw);
              	
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
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRuleXAndExpression"
    // PsiInternalPureXbase.g:528:1: entryRuleXAndExpression returns [Boolean current=false] : iv_ruleXAndExpression= ruleXAndExpression EOF ;
    public final Boolean entryRuleXAndExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXAndExpression = null;


        try {
            // PsiInternalPureXbase.g:528:56: (iv_ruleXAndExpression= ruleXAndExpression EOF )
            // PsiInternalPureXbase.g:529:2: iv_ruleXAndExpression= ruleXAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXAndExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXAndExpression=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXAndExpression"


    // $ANTLR start "ruleXAndExpression"
    // PsiInternalPureXbase.g:535:1: ruleXAndExpression returns [Boolean current=false] : (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final Boolean ruleXAndExpression() throws RecognitionException {
        Boolean current = false;

        Boolean this_XEqualityExpression_0 = null;

        Boolean lv_rightOperand_3_0 = null;


        try {
            // PsiInternalPureXbase.g:536:1: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
            // PsiInternalPureXbase.g:537:2: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            {
            // PsiInternalPureXbase.g:537:2: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            // PsiInternalPureXbase.g:538:3: this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXAndExpression_XEqualityExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_12);
            this_XEqualityExpression_0=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XEqualityExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalPureXbase.g:546:3: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==24) ) {
                    int LA9_2 = input.LA(2);

                    if ( (synpred3_PsiInternalPureXbase()) ) {
                        alt9=1;
                    }


                }


                switch (alt9) {
            	case 1 :
            	    // PsiInternalPureXbase.g:547:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    {
            	    // PsiInternalPureXbase.g:547:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) )
            	    // PsiInternalPureXbase.g:548:5: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) )
            	    {
            	    // PsiInternalPureXbase.g:558:5: ( () ( ( ruleOpAnd ) ) )
            	    // PsiInternalPureXbase.g:559:6: () ( ( ruleOpAnd ) )
            	    {
            	    // PsiInternalPureXbase.g:559:6: ()
            	    // PsiInternalPureXbase.g:560:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							precedeComposite(elementTypeProvider.getXAndExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
            	      							doneComposite();
            	      							associateWithSemanticElement();
            	      						
            	    }

            	    }

            	    // PsiInternalPureXbase.g:566:6: ( ( ruleOpAnd ) )
            	    // PsiInternalPureXbase.g:567:7: ( ruleOpAnd )
            	    {
            	    // PsiInternalPureXbase.g:567:7: ( ruleOpAnd )
            	    // PsiInternalPureXbase.g:568:8: ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (!current) {
            	      									associateWithSemanticElement();
            	      									current = true;
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								markComposite(elementTypeProvider.getXAndExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
            	      							
            	    }
            	    pushFollow(FOLLOW_3);
            	    ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								doneComposite();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // PsiInternalPureXbase.g:585:4: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    // PsiInternalPureXbase.g:586:5: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    {
            	    // PsiInternalPureXbase.g:586:5: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    // PsiInternalPureXbase.g:587:6: lv_rightOperand_3_0= ruleXEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXAndExpression_RightOperandXEqualityExpressionParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_12);
            	    lv_rightOperand_3_0=ruleXEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


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
    // $ANTLR end "ruleXAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // PsiInternalPureXbase.g:605:1: entryRuleOpAnd returns [Boolean current=false] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final Boolean entryRuleOpAnd() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOpAnd = null;


        try {
            // PsiInternalPureXbase.g:605:47: (iv_ruleOpAnd= ruleOpAnd EOF )
            // PsiInternalPureXbase.g:606:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpAndElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpAnd"


    // $ANTLR start "ruleOpAnd"
    // PsiInternalPureXbase.g:612:1: ruleOpAnd returns [Boolean current=false] : kw= '&&' ;
    public final Boolean ruleOpAnd() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalPureXbase.g:613:1: (kw= '&&' )
            // PsiInternalPureXbase.g:614:2: kw= '&&'
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getOpAnd_AmpersandAmpersandKeywordElementType());
              	
            }
            kw=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		doneLeaf(kw);
              	
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
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRuleXEqualityExpression"
    // PsiInternalPureXbase.g:624:1: entryRuleXEqualityExpression returns [Boolean current=false] : iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
    public final Boolean entryRuleXEqualityExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXEqualityExpression = null;


        try {
            // PsiInternalPureXbase.g:624:61: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
            // PsiInternalPureXbase.g:625:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXEqualityExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXEqualityExpression"


    // $ANTLR start "ruleXEqualityExpression"
    // PsiInternalPureXbase.g:631:1: ruleXEqualityExpression returns [Boolean current=false] : (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final Boolean ruleXEqualityExpression() throws RecognitionException {
        Boolean current = false;

        Boolean this_XRelationalExpression_0 = null;

        Boolean lv_rightOperand_3_0 = null;


        try {
            // PsiInternalPureXbase.g:632:1: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
            // PsiInternalPureXbase.g:633:2: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            {
            // PsiInternalPureXbase.g:633:2: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            // PsiInternalPureXbase.g:634:3: this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXEqualityExpression_XRelationalExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_13);
            this_XRelationalExpression_0=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XRelationalExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalPureXbase.g:642:3: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            loop10:
            do {
                int alt10=2;
                switch ( input.LA(1) ) {
                case 25:
                    {
                    int LA10_2 = input.LA(2);

                    if ( (synpred4_PsiInternalPureXbase()) ) {
                        alt10=1;
                    }


                    }
                    break;
                case 26:
                    {
                    int LA10_3 = input.LA(2);

                    if ( (synpred4_PsiInternalPureXbase()) ) {
                        alt10=1;
                    }


                    }
                    break;
                case 27:
                    {
                    int LA10_4 = input.LA(2);

                    if ( (synpred4_PsiInternalPureXbase()) ) {
                        alt10=1;
                    }


                    }
                    break;
                case 28:
                    {
                    int LA10_5 = input.LA(2);

                    if ( (synpred4_PsiInternalPureXbase()) ) {
                        alt10=1;
                    }


                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // PsiInternalPureXbase.g:643:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    {
            	    // PsiInternalPureXbase.g:643:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) )
            	    // PsiInternalPureXbase.g:644:5: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) )
            	    {
            	    // PsiInternalPureXbase.g:654:5: ( () ( ( ruleOpEquality ) ) )
            	    // PsiInternalPureXbase.g:655:6: () ( ( ruleOpEquality ) )
            	    {
            	    // PsiInternalPureXbase.g:655:6: ()
            	    // PsiInternalPureXbase.g:656:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							precedeComposite(elementTypeProvider.getXEqualityExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
            	      							doneComposite();
            	      							associateWithSemanticElement();
            	      						
            	    }

            	    }

            	    // PsiInternalPureXbase.g:662:6: ( ( ruleOpEquality ) )
            	    // PsiInternalPureXbase.g:663:7: ( ruleOpEquality )
            	    {
            	    // PsiInternalPureXbase.g:663:7: ( ruleOpEquality )
            	    // PsiInternalPureXbase.g:664:8: ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (!current) {
            	      									associateWithSemanticElement();
            	      									current = true;
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								markComposite(elementTypeProvider.getXEqualityExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
            	      							
            	    }
            	    pushFollow(FOLLOW_3);
            	    ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								doneComposite();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // PsiInternalPureXbase.g:681:4: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    // PsiInternalPureXbase.g:682:5: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    {
            	    // PsiInternalPureXbase.g:682:5: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    // PsiInternalPureXbase.g:683:6: lv_rightOperand_3_0= ruleXRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXEqualityExpression_RightOperandXRelationalExpressionParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_13);
            	    lv_rightOperand_3_0=ruleXRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // PsiInternalPureXbase.g:701:1: entryRuleOpEquality returns [Boolean current=false] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final Boolean entryRuleOpEquality() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOpEquality = null;


        try {
            // PsiInternalPureXbase.g:701:52: (iv_ruleOpEquality= ruleOpEquality EOF )
            // PsiInternalPureXbase.g:702:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpEqualityElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpEquality"


    // $ANTLR start "ruleOpEquality"
    // PsiInternalPureXbase.g:708:1: ruleOpEquality returns [Boolean current=false] : (kw= '==' | kw= '!=' | kw= '===' | kw= '!==' ) ;
    public final Boolean ruleOpEquality() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalPureXbase.g:709:1: ( (kw= '==' | kw= '!=' | kw= '===' | kw= '!==' ) )
            // PsiInternalPureXbase.g:710:2: (kw= '==' | kw= '!=' | kw= '===' | kw= '!==' )
            {
            // PsiInternalPureXbase.g:710:2: (kw= '==' | kw= '!=' | kw= '===' | kw= '!==' )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt11=1;
                }
                break;
            case 26:
                {
                alt11=2;
                }
                break;
            case 27:
                {
                alt11=3;
                }
                break;
            case 28:
                {
                alt11=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // PsiInternalPureXbase.g:711:3: kw= '=='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpEquality_EqualsSignEqualsSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:719:3: kw= '!='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpEquality_ExclamationMarkEqualsSignKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalPureXbase.g:727:3: kw= '==='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpEquality_EqualsSignEqualsSignEqualsSignKeyword_2ElementType());
                      		
                    }
                    kw=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalPureXbase.g:735:3: kw= '!=='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpEquality_ExclamationMarkEqualsSignEqualsSignKeyword_3ElementType());
                      		
                    }
                    kw=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

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
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRuleXRelationalExpression"
    // PsiInternalPureXbase.g:746:1: entryRuleXRelationalExpression returns [Boolean current=false] : iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
    public final Boolean entryRuleXRelationalExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXRelationalExpression = null;


        try {
            // PsiInternalPureXbase.g:746:63: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
            // PsiInternalPureXbase.g:747:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXRelationalExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXRelationalExpression"


    // $ANTLR start "ruleXRelationalExpression"
    // PsiInternalPureXbase.g:753:1: ruleXRelationalExpression returns [Boolean current=false] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final Boolean ruleXRelationalExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean this_XOtherOperatorExpression_0 = null;

        Boolean lv_type_3_0 = null;

        Boolean lv_rightOperand_6_0 = null;


        try {
            // PsiInternalPureXbase.g:754:1: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // PsiInternalPureXbase.g:755:2: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // PsiInternalPureXbase.g:755:2: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // PsiInternalPureXbase.g:756:3: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXRelationalExpression_XOtherOperatorExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_14);
            this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XOtherOperatorExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalPureXbase.g:764:3: ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            loop12:
            do {
                int alt12=3;
                switch ( input.LA(1) ) {
                case 20:
                    {
                    int LA12_2 = input.LA(2);

                    if ( (synpred6_PsiInternalPureXbase()) ) {
                        alt12=2;
                    }


                    }
                    break;
                case 21:
                    {
                    int LA12_3 = input.LA(2);

                    if ( (synpred6_PsiInternalPureXbase()) ) {
                        alt12=2;
                    }


                    }
                    break;
                case 29:
                    {
                    int LA12_4 = input.LA(2);

                    if ( (synpred5_PsiInternalPureXbase()) ) {
                        alt12=1;
                    }


                    }
                    break;
                case 22:
                    {
                    int LA12_5 = input.LA(2);

                    if ( (synpred6_PsiInternalPureXbase()) ) {
                        alt12=2;
                    }


                    }
                    break;

                }

                switch (alt12) {
            	case 1 :
            	    // PsiInternalPureXbase.g:765:4: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
            	    {
            	    // PsiInternalPureXbase.g:765:4: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
            	    // PsiInternalPureXbase.g:766:5: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // PsiInternalPureXbase.g:766:5: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) )
            	    // PsiInternalPureXbase.g:767:6: ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' )
            	    {
            	    // PsiInternalPureXbase.g:773:6: ( () otherlv_2= 'instanceof' )
            	    // PsiInternalPureXbase.g:774:7: () otherlv_2= 'instanceof'
            	    {
            	    // PsiInternalPureXbase.g:774:7: ()
            	    // PsiInternalPureXbase.g:775:8: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      								precedeComposite(elementTypeProvider.getXRelationalExpression_XInstanceOfExpressionExpressionAction_1_0_0_0_0ElementType());
            	      								doneComposite();
            	      								associateWithSemanticElement();
            	      							
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      							markLeaf(elementTypeProvider.getXRelationalExpression_InstanceofKeyword_1_0_0_0_1ElementType());
            	      						
            	    }
            	    otherlv_2=(Token)match(input,29,FOLLOW_15); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							doneLeaf(otherlv_2);
            	      						
            	    }

            	    }


            	    }

            	    // PsiInternalPureXbase.g:790:5: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // PsiInternalPureXbase.g:791:6: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // PsiInternalPureXbase.g:791:6: (lv_type_3_0= ruleJvmTypeReference )
            	    // PsiInternalPureXbase.g:792:7: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {

            	      							markComposite(elementTypeProvider.getXRelationalExpression_TypeJvmTypeReferenceParserRuleCall_1_0_1_0ElementType());
            	      						
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_type_3_0=ruleJvmTypeReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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
            	    break;
            	case 2 :
            	    // PsiInternalPureXbase.g:807:4: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // PsiInternalPureXbase.g:807:4: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    // PsiInternalPureXbase.g:808:5: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // PsiInternalPureXbase.g:808:5: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) )
            	    // PsiInternalPureXbase.g:809:6: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) )
            	    {
            	    // PsiInternalPureXbase.g:819:6: ( () ( ( ruleOpCompare ) ) )
            	    // PsiInternalPureXbase.g:820:7: () ( ( ruleOpCompare ) )
            	    {
            	    // PsiInternalPureXbase.g:820:7: ()
            	    // PsiInternalPureXbase.g:821:8: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      								precedeComposite(elementTypeProvider.getXRelationalExpression_XBinaryOperationLeftOperandAction_1_1_0_0_0ElementType());
            	      								doneComposite();
            	      								associateWithSemanticElement();
            	      							
            	    }

            	    }

            	    // PsiInternalPureXbase.g:827:7: ( ( ruleOpCompare ) )
            	    // PsiInternalPureXbase.g:828:8: ( ruleOpCompare )
            	    {
            	    // PsiInternalPureXbase.g:828:8: ( ruleOpCompare )
            	    // PsiInternalPureXbase.g:829:9: ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      									if (!current) {
            	      										associateWithSemanticElement();
            	      										current = true;
            	      									}
            	      								
            	    }
            	    if ( state.backtracking==0 ) {

            	      									markComposite(elementTypeProvider.getXRelationalExpression_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0ElementType());
            	      								
            	    }
            	    pushFollow(FOLLOW_3);
            	    ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									doneComposite();
            	      								
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // PsiInternalPureXbase.g:846:5: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    // PsiInternalPureXbase.g:847:6: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // PsiInternalPureXbase.g:847:6: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    // PsiInternalPureXbase.g:848:7: lv_rightOperand_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      							markComposite(elementTypeProvider.getXRelationalExpression_RightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0ElementType());
            	      						
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_rightOperand_6_0=ruleXOtherOperatorExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


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
    // $ANTLR end "ruleXRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // PsiInternalPureXbase.g:867:1: entryRuleOpCompare returns [Boolean current=false] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final Boolean entryRuleOpCompare() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOpCompare = null;


        try {
            // PsiInternalPureXbase.g:867:51: (iv_ruleOpCompare= ruleOpCompare EOF )
            // PsiInternalPureXbase.g:868:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpCompareElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpCompare"


    // $ANTLR start "ruleOpCompare"
    // PsiInternalPureXbase.g:874:1: ruleOpCompare returns [Boolean current=false] : (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' ) ;
    public final Boolean ruleOpCompare() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalPureXbase.g:875:1: ( (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' ) )
            // PsiInternalPureXbase.g:876:2: (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' )
            {
            // PsiInternalPureXbase.g:876:2: (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' )
            int alt13=4;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt13=1;
                }
                break;
            case 20:
                {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==14) ) {
                    alt13=2;
                }
                else if ( (LA13_2==EOF||(LA13_2>=RULE_STRING && LA13_2<=RULE_ID)||LA13_2==20||(LA13_2>=36 && LA13_2<=37)||LA13_2==42||LA13_2==50||(LA13_2>=52 && LA13_2<=53)||LA13_2==55||LA13_2==58||LA13_2==60||(LA13_2>=64 && LA13_2<=66)||(LA13_2>=69 && LA13_2<=77)||LA13_2==79) ) {
                    alt13=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;
                }
                }
                break;
            case 21:
                {
                alt13=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // PsiInternalPureXbase.g:877:3: kw= '>='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpCompare_GreaterThanSignEqualsSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:885:3: (kw= '<' kw= '=' )
                    {
                    // PsiInternalPureXbase.g:885:3: (kw= '<' kw= '=' )
                    // PsiInternalPureXbase.g:886:4: kw= '<' kw= '='
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpCompare_LessThanSignKeyword_1_0ElementType());
                      			
                    }
                    kw=(Token)match(input,20,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpCompare_EqualsSignKeyword_1_1ElementType());
                      			
                    }
                    kw=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalPureXbase.g:902:3: kw= '>'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpCompare_GreaterThanSignKeyword_2ElementType());
                      		
                    }
                    kw=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalPureXbase.g:910:3: kw= '<'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpCompare_LessThanSignKeyword_3ElementType());
                      		
                    }
                    kw=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

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
    // $ANTLR end "ruleOpCompare"


    // $ANTLR start "entryRuleXOtherOperatorExpression"
    // PsiInternalPureXbase.g:921:1: entryRuleXOtherOperatorExpression returns [Boolean current=false] : iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
    public final Boolean entryRuleXOtherOperatorExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXOtherOperatorExpression = null;


        try {
            // PsiInternalPureXbase.g:921:66: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
            // PsiInternalPureXbase.g:922:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXOtherOperatorExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXOtherOperatorExpression"


    // $ANTLR start "ruleXOtherOperatorExpression"
    // PsiInternalPureXbase.g:928:1: ruleXOtherOperatorExpression returns [Boolean current=false] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final Boolean ruleXOtherOperatorExpression() throws RecognitionException {
        Boolean current = false;

        Boolean this_XAdditiveExpression_0 = null;

        Boolean lv_rightOperand_3_0 = null;


        try {
            // PsiInternalPureXbase.g:929:1: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
            // PsiInternalPureXbase.g:930:2: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // PsiInternalPureXbase.g:930:2: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            // PsiInternalPureXbase.g:931:3: this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXOtherOperatorExpression_XAdditiveExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_16);
            this_XAdditiveExpression_0=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XAdditiveExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalPureXbase.g:939:3: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            loop14:
            do {
                int alt14=2;
                alt14 = dfa14.predict(input);
                switch (alt14) {
            	case 1 :
            	    // PsiInternalPureXbase.g:940:4: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // PsiInternalPureXbase.g:940:4: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) )
            	    // PsiInternalPureXbase.g:941:5: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) )
            	    {
            	    // PsiInternalPureXbase.g:951:5: ( () ( ( ruleOpOther ) ) )
            	    // PsiInternalPureXbase.g:952:6: () ( ( ruleOpOther ) )
            	    {
            	    // PsiInternalPureXbase.g:952:6: ()
            	    // PsiInternalPureXbase.g:953:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							precedeComposite(elementTypeProvider.getXOtherOperatorExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
            	      							doneComposite();
            	      							associateWithSemanticElement();
            	      						
            	    }

            	    }

            	    // PsiInternalPureXbase.g:959:6: ( ( ruleOpOther ) )
            	    // PsiInternalPureXbase.g:960:7: ( ruleOpOther )
            	    {
            	    // PsiInternalPureXbase.g:960:7: ( ruleOpOther )
            	    // PsiInternalPureXbase.g:961:8: ruleOpOther
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (!current) {
            	      									associateWithSemanticElement();
            	      									current = true;
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								markComposite(elementTypeProvider.getXOtherOperatorExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
            	      							
            	    }
            	    pushFollow(FOLLOW_3);
            	    ruleOpOther();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								doneComposite();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // PsiInternalPureXbase.g:978:4: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    // PsiInternalPureXbase.g:979:5: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    {
            	    // PsiInternalPureXbase.g:979:5: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    // PsiInternalPureXbase.g:980:6: lv_rightOperand_3_0= ruleXAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXOtherOperatorExpression_RightOperandXAdditiveExpressionParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_rightOperand_3_0=ruleXAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


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
    // $ANTLR end "ruleXOtherOperatorExpression"


    // $ANTLR start "entryRuleOpOther"
    // PsiInternalPureXbase.g:998:1: entryRuleOpOther returns [Boolean current=false] : iv_ruleOpOther= ruleOpOther EOF ;
    public final Boolean entryRuleOpOther() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOpOther = null;


        try {
            // PsiInternalPureXbase.g:998:49: (iv_ruleOpOther= ruleOpOther EOF )
            // PsiInternalPureXbase.g:999:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpOtherElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpOther"


    // $ANTLR start "ruleOpOther"
    // PsiInternalPureXbase.g:1005:1: ruleOpOther returns [Boolean current=false] : (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' ) ;
    public final Boolean ruleOpOther() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalPureXbase.g:1006:1: ( (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' ) )
            // PsiInternalPureXbase.g:1007:2: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )
            {
            // PsiInternalPureXbase.g:1007:2: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )
            int alt17=9;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // PsiInternalPureXbase.g:1008:3: kw= '->'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpOther_HyphenMinusGreaterThanSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:1016:3: kw= '..<'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpOther_FullStopFullStopLessThanSignKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalPureXbase.g:1024:3: (kw= '>' kw= '..' )
                    {
                    // PsiInternalPureXbase.g:1024:3: (kw= '>' kw= '..' )
                    // PsiInternalPureXbase.g:1025:4: kw= '>' kw= '..'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpOther_GreaterThanSignKeyword_2_0ElementType());
                      			
                    }
                    kw=(Token)match(input,21,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpOther_FullStopFullStopKeyword_2_1ElementType());
                      			
                    }
                    kw=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // PsiInternalPureXbase.g:1041:3: kw= '..'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpOther_FullStopFullStopKeyword_3ElementType());
                      		
                    }
                    kw=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 5 :
                    // PsiInternalPureXbase.g:1049:3: kw= '=>'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpOther_EqualsSignGreaterThanSignKeyword_4ElementType());
                      		
                    }
                    kw=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalPureXbase.g:1057:3: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) )
                    {
                    // PsiInternalPureXbase.g:1057:3: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) )
                    // PsiInternalPureXbase.g:1058:4: kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpOther_GreaterThanSignKeyword_5_0ElementType());
                      			
                    }
                    kw=(Token)match(input,21,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    // PsiInternalPureXbase.g:1065:4: ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' )
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==21) ) {
                        int LA15_1 = input.LA(2);

                        if ( (LA15_1==21) && (synpred8_PsiInternalPureXbase())) {
                            alt15=1;
                        }
                        else if ( (LA15_1==EOF||(LA15_1>=RULE_STRING && LA15_1<=RULE_ID)||LA15_1==20||(LA15_1>=36 && LA15_1<=37)||LA15_1==42||LA15_1==50||(LA15_1>=52 && LA15_1<=53)||LA15_1==55||LA15_1==58||LA15_1==60||(LA15_1>=64 && LA15_1<=66)||(LA15_1>=69 && LA15_1<=77)||LA15_1==79) ) {
                            alt15=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 15, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;
                    }
                    switch (alt15) {
                        case 1 :
                            // PsiInternalPureXbase.g:1066:5: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
                            {
                            // PsiInternalPureXbase.g:1066:5: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
                            // PsiInternalPureXbase.g:1067:6: ( ( '>' '>' ) )=> (kw= '>' kw= '>' )
                            {
                            // PsiInternalPureXbase.g:1072:6: (kw= '>' kw= '>' )
                            // PsiInternalPureXbase.g:1073:7: kw= '>' kw= '>'
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getOpOther_GreaterThanSignKeyword_5_1_0_0_0ElementType());
                              						
                            }
                            kw=(Token)match(input,21,FOLLOW_18); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(kw);
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getOpOther_GreaterThanSignKeyword_5_1_0_0_1ElementType());
                              						
                            }
                            kw=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(kw);
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalPureXbase.g:1090:5: kw= '>'
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getOpOther_GreaterThanSignKeyword_5_1_1ElementType());
                              				
                            }
                            kw=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(kw);
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 7 :
                    // PsiInternalPureXbase.g:1100:3: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) )
                    {
                    // PsiInternalPureXbase.g:1100:3: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) )
                    // PsiInternalPureXbase.g:1101:4: kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpOther_LessThanSignKeyword_6_0ElementType());
                      			
                    }
                    kw=(Token)match(input,20,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    // PsiInternalPureXbase.g:1108:4: ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' )
                    int alt16=3;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==20) ) {
                        int LA16_1 = input.LA(2);

                        if ( (synpred9_PsiInternalPureXbase()) ) {
                            alt16=1;
                        }
                        else if ( (true) ) {
                            alt16=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 16, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA16_0==33) ) {
                        alt16=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 0, input);

                        throw nvae;
                    }
                    switch (alt16) {
                        case 1 :
                            // PsiInternalPureXbase.g:1109:5: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
                            {
                            // PsiInternalPureXbase.g:1109:5: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
                            // PsiInternalPureXbase.g:1110:6: ( ( '<' '<' ) )=> (kw= '<' kw= '<' )
                            {
                            // PsiInternalPureXbase.g:1115:6: (kw= '<' kw= '<' )
                            // PsiInternalPureXbase.g:1116:7: kw= '<' kw= '<'
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getOpOther_LessThanSignKeyword_6_1_0_0_0ElementType());
                              						
                            }
                            kw=(Token)match(input,20,FOLLOW_8); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(kw);
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getOpOther_LessThanSignKeyword_6_1_0_0_1ElementType());
                              						
                            }
                            kw=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(kw);
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalPureXbase.g:1133:5: kw= '<'
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getOpOther_LessThanSignKeyword_6_1_1ElementType());
                              				
                            }
                            kw=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(kw);
                              				
                            }

                            }
                            break;
                        case 3 :
                            // PsiInternalPureXbase.g:1141:5: kw= '=>'
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getOpOther_EqualsSignGreaterThanSignKeyword_6_1_2ElementType());
                              				
                            }
                            kw=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(kw);
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 8 :
                    // PsiInternalPureXbase.g:1151:3: kw= '<>'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpOther_LessThanSignGreaterThanSignKeyword_7ElementType());
                      		
                    }
                    kw=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 9 :
                    // PsiInternalPureXbase.g:1159:3: kw= '?:'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpOther_QuestionMarkColonKeyword_8ElementType());
                      		
                    }
                    kw=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

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
    // $ANTLR end "ruleOpOther"


    // $ANTLR start "entryRuleXAdditiveExpression"
    // PsiInternalPureXbase.g:1170:1: entryRuleXAdditiveExpression returns [Boolean current=false] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final Boolean entryRuleXAdditiveExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXAdditiveExpression = null;


        try {
            // PsiInternalPureXbase.g:1170:61: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // PsiInternalPureXbase.g:1171:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXAdditiveExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXAdditiveExpression"


    // $ANTLR start "ruleXAdditiveExpression"
    // PsiInternalPureXbase.g:1177:1: ruleXAdditiveExpression returns [Boolean current=false] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final Boolean ruleXAdditiveExpression() throws RecognitionException {
        Boolean current = false;

        Boolean this_XMultiplicativeExpression_0 = null;

        Boolean lv_rightOperand_3_0 = null;


        try {
            // PsiInternalPureXbase.g:1178:1: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // PsiInternalPureXbase.g:1179:2: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // PsiInternalPureXbase.g:1179:2: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // PsiInternalPureXbase.g:1180:3: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXAdditiveExpression_XMultiplicativeExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_20);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XMultiplicativeExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalPureXbase.g:1188:3: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==36) ) {
                    int LA18_2 = input.LA(2);

                    if ( (synpred10_PsiInternalPureXbase()) ) {
                        alt18=1;
                    }


                }
                else if ( (LA18_0==37) ) {
                    int LA18_3 = input.LA(2);

                    if ( (synpred10_PsiInternalPureXbase()) ) {
                        alt18=1;
                    }


                }


                switch (alt18) {
            	case 1 :
            	    // PsiInternalPureXbase.g:1189:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // PsiInternalPureXbase.g:1189:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
            	    // PsiInternalPureXbase.g:1190:5: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
            	    {
            	    // PsiInternalPureXbase.g:1200:5: ( () ( ( ruleOpAdd ) ) )
            	    // PsiInternalPureXbase.g:1201:6: () ( ( ruleOpAdd ) )
            	    {
            	    // PsiInternalPureXbase.g:1201:6: ()
            	    // PsiInternalPureXbase.g:1202:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							precedeComposite(elementTypeProvider.getXAdditiveExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
            	      							doneComposite();
            	      							associateWithSemanticElement();
            	      						
            	    }

            	    }

            	    // PsiInternalPureXbase.g:1208:6: ( ( ruleOpAdd ) )
            	    // PsiInternalPureXbase.g:1209:7: ( ruleOpAdd )
            	    {
            	    // PsiInternalPureXbase.g:1209:7: ( ruleOpAdd )
            	    // PsiInternalPureXbase.g:1210:8: ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (!current) {
            	      									associateWithSemanticElement();
            	      									current = true;
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								markComposite(elementTypeProvider.getXAdditiveExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
            	      							
            	    }
            	    pushFollow(FOLLOW_3);
            	    ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								doneComposite();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // PsiInternalPureXbase.g:1227:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // PsiInternalPureXbase.g:1228:5: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // PsiInternalPureXbase.g:1228:5: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // PsiInternalPureXbase.g:1229:6: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXAdditiveExpression_RightOperandXMultiplicativeExpressionParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_20);
            	    lv_rightOperand_3_0=ruleXMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


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
    // $ANTLR end "ruleXAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // PsiInternalPureXbase.g:1247:1: entryRuleOpAdd returns [Boolean current=false] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final Boolean entryRuleOpAdd() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOpAdd = null;


        try {
            // PsiInternalPureXbase.g:1247:47: (iv_ruleOpAdd= ruleOpAdd EOF )
            // PsiInternalPureXbase.g:1248:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpAddElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpAdd"


    // $ANTLR start "ruleOpAdd"
    // PsiInternalPureXbase.g:1254:1: ruleOpAdd returns [Boolean current=false] : (kw= '+' | kw= '-' ) ;
    public final Boolean ruleOpAdd() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalPureXbase.g:1255:1: ( (kw= '+' | kw= '-' ) )
            // PsiInternalPureXbase.g:1256:2: (kw= '+' | kw= '-' )
            {
            // PsiInternalPureXbase.g:1256:2: (kw= '+' | kw= '-' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==36) ) {
                alt19=1;
            }
            else if ( (LA19_0==37) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // PsiInternalPureXbase.g:1257:3: kw= '+'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpAdd_PlusSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:1265:3: kw= '-'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpAdd_HyphenMinusKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

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
    // $ANTLR end "ruleOpAdd"


    // $ANTLR start "entryRuleXMultiplicativeExpression"
    // PsiInternalPureXbase.g:1276:1: entryRuleXMultiplicativeExpression returns [Boolean current=false] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final Boolean entryRuleXMultiplicativeExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXMultiplicativeExpression = null;


        try {
            // PsiInternalPureXbase.g:1276:67: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // PsiInternalPureXbase.g:1277:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXMultiplicativeExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXMultiplicativeExpression"


    // $ANTLR start "ruleXMultiplicativeExpression"
    // PsiInternalPureXbase.g:1283:1: ruleXMultiplicativeExpression returns [Boolean current=false] : (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final Boolean ruleXMultiplicativeExpression() throws RecognitionException {
        Boolean current = false;

        Boolean this_XUnaryOperation_0 = null;

        Boolean lv_rightOperand_3_0 = null;


        try {
            // PsiInternalPureXbase.g:1284:1: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // PsiInternalPureXbase.g:1285:2: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // PsiInternalPureXbase.g:1285:2: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // PsiInternalPureXbase.g:1286:3: this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXMultiplicativeExpression_XUnaryOperationParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_21);
            this_XUnaryOperation_0=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XUnaryOperation_0;
              			doneComposite();
              		
            }
            // PsiInternalPureXbase.g:1294:3: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            loop20:
            do {
                int alt20=2;
                switch ( input.LA(1) ) {
                case 38:
                    {
                    int LA20_2 = input.LA(2);

                    if ( (synpred11_PsiInternalPureXbase()) ) {
                        alt20=1;
                    }


                    }
                    break;
                case 39:
                    {
                    int LA20_3 = input.LA(2);

                    if ( (synpred11_PsiInternalPureXbase()) ) {
                        alt20=1;
                    }


                    }
                    break;
                case 40:
                    {
                    int LA20_4 = input.LA(2);

                    if ( (synpred11_PsiInternalPureXbase()) ) {
                        alt20=1;
                    }


                    }
                    break;
                case 41:
                    {
                    int LA20_5 = input.LA(2);

                    if ( (synpred11_PsiInternalPureXbase()) ) {
                        alt20=1;
                    }


                    }
                    break;

                }

                switch (alt20) {
            	case 1 :
            	    // PsiInternalPureXbase.g:1295:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // PsiInternalPureXbase.g:1295:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
            	    // PsiInternalPureXbase.g:1296:5: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
            	    {
            	    // PsiInternalPureXbase.g:1306:5: ( () ( ( ruleOpMulti ) ) )
            	    // PsiInternalPureXbase.g:1307:6: () ( ( ruleOpMulti ) )
            	    {
            	    // PsiInternalPureXbase.g:1307:6: ()
            	    // PsiInternalPureXbase.g:1308:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							precedeComposite(elementTypeProvider.getXMultiplicativeExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
            	      							doneComposite();
            	      							associateWithSemanticElement();
            	      						
            	    }

            	    }

            	    // PsiInternalPureXbase.g:1314:6: ( ( ruleOpMulti ) )
            	    // PsiInternalPureXbase.g:1315:7: ( ruleOpMulti )
            	    {
            	    // PsiInternalPureXbase.g:1315:7: ( ruleOpMulti )
            	    // PsiInternalPureXbase.g:1316:8: ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (!current) {
            	      									associateWithSemanticElement();
            	      									current = true;
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								markComposite(elementTypeProvider.getXMultiplicativeExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
            	      							
            	    }
            	    pushFollow(FOLLOW_3);
            	    ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								doneComposite();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // PsiInternalPureXbase.g:1333:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // PsiInternalPureXbase.g:1334:5: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // PsiInternalPureXbase.g:1334:5: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // PsiInternalPureXbase.g:1335:6: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXMultiplicativeExpression_RightOperandXUnaryOperationParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_21);
            	    lv_rightOperand_3_0=ruleXUnaryOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


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
    // $ANTLR end "ruleXMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // PsiInternalPureXbase.g:1353:1: entryRuleOpMulti returns [Boolean current=false] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final Boolean entryRuleOpMulti() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOpMulti = null;


        try {
            // PsiInternalPureXbase.g:1353:49: (iv_ruleOpMulti= ruleOpMulti EOF )
            // PsiInternalPureXbase.g:1354:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpMultiElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpMulti"


    // $ANTLR start "ruleOpMulti"
    // PsiInternalPureXbase.g:1360:1: ruleOpMulti returns [Boolean current=false] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final Boolean ruleOpMulti() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalPureXbase.g:1361:1: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // PsiInternalPureXbase.g:1362:2: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // PsiInternalPureXbase.g:1362:2: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt21=4;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt21=1;
                }
                break;
            case 39:
                {
                alt21=2;
                }
                break;
            case 40:
                {
                alt21=3;
                }
                break;
            case 41:
                {
                alt21=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // PsiInternalPureXbase.g:1363:3: kw= '*'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMulti_AsteriskKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:1371:3: kw= '**'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMulti_AsteriskAsteriskKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalPureXbase.g:1379:3: kw= '/'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMulti_SolidusKeyword_2ElementType());
                      		
                    }
                    kw=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalPureXbase.g:1387:3: kw= '%'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMulti_PercentSignKeyword_3ElementType());
                      		
                    }
                    kw=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

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
    // $ANTLR end "ruleOpMulti"


    // $ANTLR start "entryRuleXUnaryOperation"
    // PsiInternalPureXbase.g:1398:1: entryRuleXUnaryOperation returns [Boolean current=false] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final Boolean entryRuleXUnaryOperation() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXUnaryOperation = null;


        try {
            // PsiInternalPureXbase.g:1398:57: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // PsiInternalPureXbase.g:1399:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXUnaryOperationElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXUnaryOperation"


    // $ANTLR start "ruleXUnaryOperation"
    // PsiInternalPureXbase.g:1405:1: ruleXUnaryOperation returns [Boolean current=false] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) ;
    public final Boolean ruleXUnaryOperation() throws RecognitionException {
        Boolean current = false;

        Boolean lv_operand_2_0 = null;

        Boolean this_XCastedExpression_3 = null;


        try {
            // PsiInternalPureXbase.g:1406:1: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) )
            // PsiInternalPureXbase.g:1407:2: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            {
            // PsiInternalPureXbase.g:1407:2: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=36 && LA22_0<=37)||LA22_0==42) ) {
                alt22=1;
            }
            else if ( ((LA22_0>=RULE_STRING && LA22_0<=RULE_ID)||LA22_0==20||LA22_0==50||(LA22_0>=52 && LA22_0<=53)||LA22_0==55||LA22_0==58||LA22_0==60||(LA22_0>=64 && LA22_0<=66)||(LA22_0>=69 && LA22_0<=77)||LA22_0==79) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // PsiInternalPureXbase.g:1408:3: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) )
                    {
                    // PsiInternalPureXbase.g:1408:3: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) )
                    // PsiInternalPureXbase.g:1409:4: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) )
                    {
                    // PsiInternalPureXbase.g:1409:4: ()
                    // PsiInternalPureXbase.g:1410:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getXUnaryOperation_XUnaryOperationAction_0_0ElementType());
                      					doneComposite();
                      					associateWithSemanticElement();
                      				
                    }

                    }

                    // PsiInternalPureXbase.g:1416:4: ( ( ruleOpUnary ) )
                    // PsiInternalPureXbase.g:1417:5: ( ruleOpUnary )
                    {
                    // PsiInternalPureXbase.g:1417:5: ( ruleOpUnary )
                    // PsiInternalPureXbase.g:1418:6: ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXUnaryOperation_FeatureJvmIdentifiableElementCrossReference_0_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_3);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:1433:4: ( (lv_operand_2_0= ruleXUnaryOperation ) )
                    // PsiInternalPureXbase.g:1434:5: (lv_operand_2_0= ruleXUnaryOperation )
                    {
                    // PsiInternalPureXbase.g:1434:5: (lv_operand_2_0= ruleXUnaryOperation )
                    // PsiInternalPureXbase.g:1435:6: lv_operand_2_0= ruleXUnaryOperation
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXUnaryOperation_OperandXUnaryOperationParserRuleCall_0_2_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_0=ruleXUnaryOperation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:1450:3: this_XCastedExpression_3= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXUnaryOperation_XCastedExpressionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XCastedExpression_3=ruleXCastedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XCastedExpression_3;
                      			doneComposite();
                      		
                    }

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
    // $ANTLR end "ruleXUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // PsiInternalPureXbase.g:1462:1: entryRuleOpUnary returns [Boolean current=false] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final Boolean entryRuleOpUnary() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOpUnary = null;


        try {
            // PsiInternalPureXbase.g:1462:49: (iv_ruleOpUnary= ruleOpUnary EOF )
            // PsiInternalPureXbase.g:1463:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpUnaryElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpUnary"


    // $ANTLR start "ruleOpUnary"
    // PsiInternalPureXbase.g:1469:1: ruleOpUnary returns [Boolean current=false] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final Boolean ruleOpUnary() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalPureXbase.g:1470:1: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // PsiInternalPureXbase.g:1471:2: (kw= '!' | kw= '-' | kw= '+' )
            {
            // PsiInternalPureXbase.g:1471:2: (kw= '!' | kw= '-' | kw= '+' )
            int alt23=3;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt23=1;
                }
                break;
            case 37:
                {
                alt23=2;
                }
                break;
            case 36:
                {
                alt23=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // PsiInternalPureXbase.g:1472:3: kw= '!'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpUnary_ExclamationMarkKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:1480:3: kw= '-'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpUnary_HyphenMinusKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalPureXbase.g:1488:3: kw= '+'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpUnary_PlusSignKeyword_2ElementType());
                      		
                    }
                    kw=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

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
    // $ANTLR end "ruleOpUnary"


    // $ANTLR start "entryRuleXCastedExpression"
    // PsiInternalPureXbase.g:1499:1: entryRuleXCastedExpression returns [Boolean current=false] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final Boolean entryRuleXCastedExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXCastedExpression = null;


        try {
            // PsiInternalPureXbase.g:1499:59: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // PsiInternalPureXbase.g:1500:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXCastedExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXCastedExpression=ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXCastedExpression"


    // $ANTLR start "ruleXCastedExpression"
    // PsiInternalPureXbase.g:1506:1: ruleXCastedExpression returns [Boolean current=false] : (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) ;
    public final Boolean ruleXCastedExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean this_XPostfixOperation_0 = null;

        Boolean lv_type_3_0 = null;


        try {
            // PsiInternalPureXbase.g:1507:1: ( (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) )
            // PsiInternalPureXbase.g:1508:2: (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            {
            // PsiInternalPureXbase.g:1508:2: (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            // PsiInternalPureXbase.g:1509:3: this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXCastedExpression_XPostfixOperationParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_22);
            this_XPostfixOperation_0=ruleXPostfixOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XPostfixOperation_0;
              			doneComposite();
              		
            }
            // PsiInternalPureXbase.g:1517:3: ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==43) ) {
                    int LA24_2 = input.LA(2);

                    if ( (synpred12_PsiInternalPureXbase()) ) {
                        alt24=1;
                    }


                }


                switch (alt24) {
            	case 1 :
            	    // PsiInternalPureXbase.g:1518:4: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // PsiInternalPureXbase.g:1518:4: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) )
            	    // PsiInternalPureXbase.g:1519:5: ( ( () 'as' ) )=> ( () otherlv_2= 'as' )
            	    {
            	    // PsiInternalPureXbase.g:1525:5: ( () otherlv_2= 'as' )
            	    // PsiInternalPureXbase.g:1526:6: () otherlv_2= 'as'
            	    {
            	    // PsiInternalPureXbase.g:1526:6: ()
            	    // PsiInternalPureXbase.g:1527:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							precedeComposite(elementTypeProvider.getXCastedExpression_XCastedExpressionTargetAction_1_0_0_0ElementType());
            	      							doneComposite();
            	      							associateWithSemanticElement();
            	      						
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      						markLeaf(elementTypeProvider.getXCastedExpression_AsKeyword_1_0_0_1ElementType());
            	      					
            	    }
            	    otherlv_2=(Token)match(input,43,FOLLOW_15); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneLeaf(otherlv_2);
            	      					
            	    }

            	    }


            	    }

            	    // PsiInternalPureXbase.g:1542:4: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // PsiInternalPureXbase.g:1543:5: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // PsiInternalPureXbase.g:1543:5: (lv_type_3_0= ruleJvmTypeReference )
            	    // PsiInternalPureXbase.g:1544:6: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXCastedExpression_TypeJvmTypeReferenceParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_22);
            	    lv_type_3_0=ruleJvmTypeReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


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
    // $ANTLR end "ruleXCastedExpression"


    // $ANTLR start "entryRuleXPostfixOperation"
    // PsiInternalPureXbase.g:1562:1: entryRuleXPostfixOperation returns [Boolean current=false] : iv_ruleXPostfixOperation= ruleXPostfixOperation EOF ;
    public final Boolean entryRuleXPostfixOperation() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXPostfixOperation = null;


        try {
            // PsiInternalPureXbase.g:1562:59: (iv_ruleXPostfixOperation= ruleXPostfixOperation EOF )
            // PsiInternalPureXbase.g:1563:2: iv_ruleXPostfixOperation= ruleXPostfixOperation EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXPostfixOperationElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXPostfixOperation=ruleXPostfixOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPostfixOperation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXPostfixOperation"


    // $ANTLR start "ruleXPostfixOperation"
    // PsiInternalPureXbase.g:1569:1: ruleXPostfixOperation returns [Boolean current=false] : (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? ) ;
    public final Boolean ruleXPostfixOperation() throws RecognitionException {
        Boolean current = false;

        Boolean this_XMemberFeatureCall_0 = null;


        try {
            // PsiInternalPureXbase.g:1570:1: ( (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? ) )
            // PsiInternalPureXbase.g:1571:2: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? )
            {
            // PsiInternalPureXbase.g:1571:2: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? )
            // PsiInternalPureXbase.g:1572:3: this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )?
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXPostfixOperation_XMemberFeatureCallParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_23);
            this_XMemberFeatureCall_0=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XMemberFeatureCall_0;
              			doneComposite();
              		
            }
            // PsiInternalPureXbase.g:1580:3: ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==44) ) {
                int LA25_1 = input.LA(2);

                if ( (synpred13_PsiInternalPureXbase()) ) {
                    alt25=1;
                }
            }
            else if ( (LA25_0==45) ) {
                int LA25_2 = input.LA(2);

                if ( (synpred13_PsiInternalPureXbase()) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // PsiInternalPureXbase.g:1581:4: ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) )
                    {
                    // PsiInternalPureXbase.g:1591:4: ( () ( ( ruleOpPostfix ) ) )
                    // PsiInternalPureXbase.g:1592:5: () ( ( ruleOpPostfix ) )
                    {
                    // PsiInternalPureXbase.g:1592:5: ()
                    // PsiInternalPureXbase.g:1593:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						precedeComposite(elementTypeProvider.getXPostfixOperation_XPostfixOperationOperandAction_1_0_0ElementType());
                      						doneComposite();
                      						associateWithSemanticElement();
                      					
                    }

                    }

                    // PsiInternalPureXbase.g:1599:5: ( ( ruleOpPostfix ) )
                    // PsiInternalPureXbase.g:1600:6: ( ruleOpPostfix )
                    {
                    // PsiInternalPureXbase.g:1600:6: ( ruleOpPostfix )
                    // PsiInternalPureXbase.g:1601:7: ruleOpPostfix
                    {
                    if ( state.backtracking==0 ) {

                      							if (!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getXPostfixOperation_FeatureJvmIdentifiableElementCrossReference_1_0_1_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    ruleOpPostfix();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleXPostfixOperation"


    // $ANTLR start "entryRuleOpPostfix"
    // PsiInternalPureXbase.g:1622:1: entryRuleOpPostfix returns [Boolean current=false] : iv_ruleOpPostfix= ruleOpPostfix EOF ;
    public final Boolean entryRuleOpPostfix() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOpPostfix = null;


        try {
            // PsiInternalPureXbase.g:1622:51: (iv_ruleOpPostfix= ruleOpPostfix EOF )
            // PsiInternalPureXbase.g:1623:2: iv_ruleOpPostfix= ruleOpPostfix EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpPostfixElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpPostfix=ruleOpPostfix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpPostfix; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpPostfix"


    // $ANTLR start "ruleOpPostfix"
    // PsiInternalPureXbase.g:1629:1: ruleOpPostfix returns [Boolean current=false] : (kw= '++' | kw= '--' ) ;
    public final Boolean ruleOpPostfix() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalPureXbase.g:1630:1: ( (kw= '++' | kw= '--' ) )
            // PsiInternalPureXbase.g:1631:2: (kw= '++' | kw= '--' )
            {
            // PsiInternalPureXbase.g:1631:2: (kw= '++' | kw= '--' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==44) ) {
                alt26=1;
            }
            else if ( (LA26_0==45) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // PsiInternalPureXbase.g:1632:3: kw= '++'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpPostfix_PlusSignPlusSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:1640:3: kw= '--'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpPostfix_HyphenMinusHyphenMinusKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

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
    // $ANTLR end "ruleOpPostfix"


    // $ANTLR start "entryRuleXMemberFeatureCall"
    // PsiInternalPureXbase.g:1651:1: entryRuleXMemberFeatureCall returns [Boolean current=false] : iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
    public final Boolean entryRuleXMemberFeatureCall() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXMemberFeatureCall = null;


        try {
            // PsiInternalPureXbase.g:1651:60: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
            // PsiInternalPureXbase.g:1652:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXMemberFeatureCallElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXMemberFeatureCall"


    // $ANTLR start "ruleXMemberFeatureCall"
    // PsiInternalPureXbase.g:1658:1: ruleXMemberFeatureCall returns [Boolean current=false] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* ) ;
    public final Boolean ruleXMemberFeatureCall() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Token lv_explicitStatic_3_0=null;
        Token otherlv_8=null;
        Token lv_nullSafe_9_0=null;
        Token lv_explicitStatic_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token lv_explicitOperationCall_17_0=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Boolean this_XPrimaryExpression_0 = null;

        Boolean lv_value_6_0 = null;

        Boolean lv_typeArguments_12_0 = null;

        Boolean lv_typeArguments_14_0 = null;

        Boolean lv_memberCallArguments_18_0 = null;

        Boolean lv_memberCallArguments_19_0 = null;

        Boolean lv_memberCallArguments_21_0 = null;

        Boolean lv_memberCallArguments_23_0 = null;


        try {
            // PsiInternalPureXbase.g:1659:1: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* ) )
            // PsiInternalPureXbase.g:1660:2: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* )
            {
            // PsiInternalPureXbase.g:1660:2: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* )
            // PsiInternalPureXbase.g:1661:3: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXMemberFeatureCall_XPrimaryExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_24);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XPrimaryExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalPureXbase.g:1669:3: ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )*
            loop35:
            do {
                int alt35=3;
                switch ( input.LA(1) ) {
                case 46:
                    {
                    int LA35_2 = input.LA(2);

                    if ( (synpred14_PsiInternalPureXbase()) ) {
                        alt35=1;
                    }
                    else if ( (synpred15_PsiInternalPureXbase()) ) {
                        alt35=2;
                    }


                    }
                    break;
                case 47:
                    {
                    int LA35_3 = input.LA(2);

                    if ( (synpred14_PsiInternalPureXbase()) ) {
                        alt35=1;
                    }
                    else if ( (synpred15_PsiInternalPureXbase()) ) {
                        alt35=2;
                    }


                    }
                    break;
                case 48:
                    {
                    int LA35_4 = input.LA(2);

                    if ( (synpred15_PsiInternalPureXbase()) ) {
                        alt35=2;
                    }


                    }
                    break;

                }

                switch (alt35) {
            	case 1 :
            	    // PsiInternalPureXbase.g:1670:4: ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) )
            	    {
            	    // PsiInternalPureXbase.g:1670:4: ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) )
            	    // PsiInternalPureXbase.g:1671:5: ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) )
            	    {
            	    // PsiInternalPureXbase.g:1671:5: ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
            	    // PsiInternalPureXbase.g:1672:6: ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
            	    {
            	    // PsiInternalPureXbase.g:1692:6: ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
            	    // PsiInternalPureXbase.g:1693:7: () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
            	    {
            	    // PsiInternalPureXbase.g:1693:7: ()
            	    // PsiInternalPureXbase.g:1694:8: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      								precedeComposite(elementTypeProvider.getXMemberFeatureCall_XAssignmentAssignableAction_1_0_0_0_0ElementType());
            	      								doneComposite();
            	      								associateWithSemanticElement();
            	      							
            	    }

            	    }

            	    // PsiInternalPureXbase.g:1700:7: (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) )
            	    int alt27=2;
            	    int LA27_0 = input.LA(1);

            	    if ( (LA27_0==46) ) {
            	        alt27=1;
            	    }
            	    else if ( (LA27_0==47) ) {
            	        alt27=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 27, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt27) {
            	        case 1 :
            	            // PsiInternalPureXbase.g:1701:8: otherlv_2= '.'
            	            {
            	            if ( state.backtracking==0 ) {

            	              								markLeaf(elementTypeProvider.getXMemberFeatureCall_FullStopKeyword_1_0_0_0_1_0ElementType());
            	              							
            	            }
            	            otherlv_2=(Token)match(input,46,FOLLOW_25); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								doneLeaf(otherlv_2);
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // PsiInternalPureXbase.g:1709:8: ( (lv_explicitStatic_3_0= '::' ) )
            	            {
            	            // PsiInternalPureXbase.g:1709:8: ( (lv_explicitStatic_3_0= '::' ) )
            	            // PsiInternalPureXbase.g:1710:9: (lv_explicitStatic_3_0= '::' )
            	            {
            	            // PsiInternalPureXbase.g:1710:9: (lv_explicitStatic_3_0= '::' )
            	            // PsiInternalPureXbase.g:1711:10: lv_explicitStatic_3_0= '::'
            	            {
            	            if ( state.backtracking==0 ) {

            	              										markLeaf(elementTypeProvider.getXMemberFeatureCall_ExplicitStaticColonColonKeyword_1_0_0_0_1_1_0ElementType());
            	              									
            	            }
            	            lv_explicitStatic_3_0=(Token)match(input,47,FOLLOW_25); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              										doneLeaf(lv_explicitStatic_3_0);
            	              									
            	            }
            	            if ( state.backtracking==0 ) {

            	              										if (!current) {
            	              											associateWithSemanticElement();
            	              											current = true;
            	              										}
            	              									
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // PsiInternalPureXbase.g:1727:7: ( ( ruleFeatureCallID ) )
            	    // PsiInternalPureXbase.g:1728:8: ( ruleFeatureCallID )
            	    {
            	    // PsiInternalPureXbase.g:1728:8: ( ruleFeatureCallID )
            	    // PsiInternalPureXbase.g:1729:9: ruleFeatureCallID
            	    {
            	    if ( state.backtracking==0 ) {

            	      									if (!current) {
            	      										associateWithSemanticElement();
            	      										current = true;
            	      									}
            	      								
            	    }
            	    if ( state.backtracking==0 ) {

            	      									markComposite(elementTypeProvider.getXMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0ElementType());
            	      								
            	    }
            	    pushFollow(FOLLOW_6);
            	    ruleFeatureCallID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									doneComposite();
            	      								
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      							markComposite(elementTypeProvider.getXMemberFeatureCall_OpSingleAssignParserRuleCall_1_0_0_0_3ElementType());
            	      						
            	    }
            	    pushFollow(FOLLOW_3);
            	    ruleOpSingleAssign();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							doneComposite();
            	      						
            	    }

            	    }


            	    }

            	    // PsiInternalPureXbase.g:1753:5: ( (lv_value_6_0= ruleXAssignment ) )
            	    // PsiInternalPureXbase.g:1754:6: (lv_value_6_0= ruleXAssignment )
            	    {
            	    // PsiInternalPureXbase.g:1754:6: (lv_value_6_0= ruleXAssignment )
            	    // PsiInternalPureXbase.g:1755:7: lv_value_6_0= ruleXAssignment
            	    {
            	    if ( state.backtracking==0 ) {

            	      							markComposite(elementTypeProvider.getXMemberFeatureCall_ValueXAssignmentParserRuleCall_1_0_1_0ElementType());
            	      						
            	    }
            	    pushFollow(FOLLOW_24);
            	    lv_value_6_0=ruleXAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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
            	    break;
            	case 2 :
            	    // PsiInternalPureXbase.g:1770:4: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? )
            	    {
            	    // PsiInternalPureXbase.g:1770:4: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? )
            	    // PsiInternalPureXbase.g:1771:5: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?
            	    {
            	    // PsiInternalPureXbase.g:1771:5: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) )
            	    // PsiInternalPureXbase.g:1772:6: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) )
            	    {
            	    // PsiInternalPureXbase.g:1792:6: ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) )
            	    // PsiInternalPureXbase.g:1793:7: () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) )
            	    {
            	    // PsiInternalPureXbase.g:1793:7: ()
            	    // PsiInternalPureXbase.g:1794:8: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      								precedeComposite(elementTypeProvider.getXMemberFeatureCall_XMemberFeatureCallMemberCallTargetAction_1_1_0_0_0ElementType());
            	      								doneComposite();
            	      								associateWithSemanticElement();
            	      							
            	    }

            	    }

            	    // PsiInternalPureXbase.g:1800:7: (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) )
            	    int alt28=3;
            	    switch ( input.LA(1) ) {
            	    case 46:
            	        {
            	        alt28=1;
            	        }
            	        break;
            	    case 48:
            	        {
            	        alt28=2;
            	        }
            	        break;
            	    case 47:
            	        {
            	        alt28=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 28, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt28) {
            	        case 1 :
            	            // PsiInternalPureXbase.g:1801:8: otherlv_8= '.'
            	            {
            	            if ( state.backtracking==0 ) {

            	              								markLeaf(elementTypeProvider.getXMemberFeatureCall_FullStopKeyword_1_1_0_0_1_0ElementType());
            	              							
            	            }
            	            otherlv_8=(Token)match(input,46,FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								doneLeaf(otherlv_8);
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // PsiInternalPureXbase.g:1809:8: ( (lv_nullSafe_9_0= '?.' ) )
            	            {
            	            // PsiInternalPureXbase.g:1809:8: ( (lv_nullSafe_9_0= '?.' ) )
            	            // PsiInternalPureXbase.g:1810:9: (lv_nullSafe_9_0= '?.' )
            	            {
            	            // PsiInternalPureXbase.g:1810:9: (lv_nullSafe_9_0= '?.' )
            	            // PsiInternalPureXbase.g:1811:10: lv_nullSafe_9_0= '?.'
            	            {
            	            if ( state.backtracking==0 ) {

            	              										markLeaf(elementTypeProvider.getXMemberFeatureCall_NullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0ElementType());
            	              									
            	            }
            	            lv_nullSafe_9_0=(Token)match(input,48,FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              										doneLeaf(lv_nullSafe_9_0);
            	              									
            	            }
            	            if ( state.backtracking==0 ) {

            	              										if (!current) {
            	              											associateWithSemanticElement();
            	              											current = true;
            	              										}
            	              									
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // PsiInternalPureXbase.g:1827:8: ( (lv_explicitStatic_10_0= '::' ) )
            	            {
            	            // PsiInternalPureXbase.g:1827:8: ( (lv_explicitStatic_10_0= '::' ) )
            	            // PsiInternalPureXbase.g:1828:9: (lv_explicitStatic_10_0= '::' )
            	            {
            	            // PsiInternalPureXbase.g:1828:9: (lv_explicitStatic_10_0= '::' )
            	            // PsiInternalPureXbase.g:1829:10: lv_explicitStatic_10_0= '::'
            	            {
            	            if ( state.backtracking==0 ) {

            	              										markLeaf(elementTypeProvider.getXMemberFeatureCall_ExplicitStaticColonColonKeyword_1_1_0_0_1_2_0ElementType());
            	              									
            	            }
            	            lv_explicitStatic_10_0=(Token)match(input,47,FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              										doneLeaf(lv_explicitStatic_10_0);
            	              									
            	            }
            	            if ( state.backtracking==0 ) {

            	              										if (!current) {
            	              											associateWithSemanticElement();
            	              											current = true;
            	              										}
            	              									
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // PsiInternalPureXbase.g:1847:5: (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )?
            	    int alt30=2;
            	    int LA30_0 = input.LA(1);

            	    if ( (LA30_0==20) ) {
            	        alt30=1;
            	    }
            	    switch (alt30) {
            	        case 1 :
            	            // PsiInternalPureXbase.g:1848:6: otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>'
            	            {
            	            if ( state.backtracking==0 ) {

            	              						markLeaf(elementTypeProvider.getXMemberFeatureCall_LessThanSignKeyword_1_1_1_0ElementType());
            	              					
            	            }
            	            otherlv_11=(Token)match(input,20,FOLLOW_27); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						doneLeaf(otherlv_11);
            	              					
            	            }
            	            // PsiInternalPureXbase.g:1855:6: ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) )
            	            // PsiInternalPureXbase.g:1856:7: (lv_typeArguments_12_0= ruleJvmArgumentTypeReference )
            	            {
            	            // PsiInternalPureXbase.g:1856:7: (lv_typeArguments_12_0= ruleJvmArgumentTypeReference )
            	            // PsiInternalPureXbase.g:1857:8: lv_typeArguments_12_0= ruleJvmArgumentTypeReference
            	            {
            	            if ( state.backtracking==0 ) {

            	              								markComposite(elementTypeProvider.getXMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0ElementType());
            	              							
            	            }
            	            pushFollow(FOLLOW_28);
            	            lv_typeArguments_12_0=ruleJvmArgumentTypeReference();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								doneComposite();
            	              								if(!current) {
            	              									associateWithSemanticElement();
            	              									current = true;
            	              								}
            	              							
            	            }

            	            }


            	            }

            	            // PsiInternalPureXbase.g:1870:6: (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )*
            	            loop29:
            	            do {
            	                int alt29=2;
            	                int LA29_0 = input.LA(1);

            	                if ( (LA29_0==49) ) {
            	                    alt29=1;
            	                }


            	                switch (alt29) {
            	            	case 1 :
            	            	    // PsiInternalPureXbase.g:1871:7: otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) )
            	            	    {
            	            	    if ( state.backtracking==0 ) {

            	            	      							markLeaf(elementTypeProvider.getXMemberFeatureCall_CommaKeyword_1_1_1_2_0ElementType());
            	            	      						
            	            	    }
            	            	    otherlv_13=(Token)match(input,49,FOLLOW_27); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      							doneLeaf(otherlv_13);
            	            	      						
            	            	    }
            	            	    // PsiInternalPureXbase.g:1878:7: ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) )
            	            	    // PsiInternalPureXbase.g:1879:8: (lv_typeArguments_14_0= ruleJvmArgumentTypeReference )
            	            	    {
            	            	    // PsiInternalPureXbase.g:1879:8: (lv_typeArguments_14_0= ruleJvmArgumentTypeReference )
            	            	    // PsiInternalPureXbase.g:1880:9: lv_typeArguments_14_0= ruleJvmArgumentTypeReference
            	            	    {
            	            	    if ( state.backtracking==0 ) {

            	            	      									markComposite(elementTypeProvider.getXMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0ElementType());
            	            	      								
            	            	    }
            	            	    pushFollow(FOLLOW_28);
            	            	    lv_typeArguments_14_0=ruleJvmArgumentTypeReference();

            	            	    state._fsp--;
            	            	    if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      									doneComposite();
            	            	      									if(!current) {
            	            	      										associateWithSemanticElement();
            	            	      										current = true;
            	            	      									}
            	            	      								
            	            	    }

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop29;
            	                }
            	            } while (true);

            	            if ( state.backtracking==0 ) {

            	              						markLeaf(elementTypeProvider.getXMemberFeatureCall_GreaterThanSignKeyword_1_1_1_3ElementType());
            	              					
            	            }
            	            otherlv_15=(Token)match(input,21,FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						doneLeaf(otherlv_15);
            	              					
            	            }

            	            }
            	            break;

            	    }

            	    // PsiInternalPureXbase.g:1902:5: ( ( ruleIdOrSuper ) )
            	    // PsiInternalPureXbase.g:1903:6: ( ruleIdOrSuper )
            	    {
            	    // PsiInternalPureXbase.g:1903:6: ( ruleIdOrSuper )
            	    // PsiInternalPureXbase.g:1904:7: ruleIdOrSuper
            	    {
            	    if ( state.backtracking==0 ) {

            	      							if (!current) {
            	      								associateWithSemanticElement();
            	      								current = true;
            	      							}
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							markComposite(elementTypeProvider.getXMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_1_2_0ElementType());
            	      						
            	    }
            	    pushFollow(FOLLOW_29);
            	    ruleIdOrSuper();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							doneComposite();
            	      						
            	    }

            	    }


            	    }

            	    // PsiInternalPureXbase.g:1919:5: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )?
            	    int alt33=2;
            	    alt33 = dfa33.predict(input);
            	    switch (alt33) {
            	        case 1 :
            	            // PsiInternalPureXbase.g:1920:6: ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')'
            	            {
            	            // PsiInternalPureXbase.g:1920:6: ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) )
            	            // PsiInternalPureXbase.g:1921:7: ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' )
            	            {
            	            // PsiInternalPureXbase.g:1925:7: (lv_explicitOperationCall_17_0= '(' )
            	            // PsiInternalPureXbase.g:1926:8: lv_explicitOperationCall_17_0= '('
            	            {
            	            if ( state.backtracking==0 ) {

            	              								markLeaf(elementTypeProvider.getXMemberFeatureCall_ExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0ElementType());
            	              							
            	            }
            	            lv_explicitOperationCall_17_0=(Token)match(input,50,FOLLOW_30); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								doneLeaf(lv_explicitOperationCall_17_0);
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (!current) {
            	              									associateWithSemanticElement();
            	              									current = true;
            	              								}
            	              							
            	            }

            	            }


            	            }

            	            // PsiInternalPureXbase.g:1941:6: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )?
            	            int alt32=3;
            	            alt32 = dfa32.predict(input);
            	            switch (alt32) {
            	                case 1 :
            	                    // PsiInternalPureXbase.g:1942:7: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) )
            	                    {
            	                    // PsiInternalPureXbase.g:1942:7: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) )
            	                    // PsiInternalPureXbase.g:1943:8: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure )
            	                    {
            	                    // PsiInternalPureXbase.g:1968:8: (lv_memberCallArguments_18_0= ruleXShortClosure )
            	                    // PsiInternalPureXbase.g:1969:9: lv_memberCallArguments_18_0= ruleXShortClosure
            	                    {
            	                    if ( state.backtracking==0 ) {

            	                      									markComposite(elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0ElementType());
            	                      								
            	                    }
            	                    pushFollow(FOLLOW_31);
            	                    lv_memberCallArguments_18_0=ruleXShortClosure();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      									doneComposite();
            	                      									if(!current) {
            	                      										associateWithSemanticElement();
            	                      										current = true;
            	                      									}
            	                      								
            	                    }

            	                    }


            	                    }


            	                    }
            	                    break;
            	                case 2 :
            	                    // PsiInternalPureXbase.g:1983:7: ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* )
            	                    {
            	                    // PsiInternalPureXbase.g:1983:7: ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* )
            	                    // PsiInternalPureXbase.g:1984:8: ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )*
            	                    {
            	                    // PsiInternalPureXbase.g:1984:8: ( (lv_memberCallArguments_19_0= ruleXExpression ) )
            	                    // PsiInternalPureXbase.g:1985:9: (lv_memberCallArguments_19_0= ruleXExpression )
            	                    {
            	                    // PsiInternalPureXbase.g:1985:9: (lv_memberCallArguments_19_0= ruleXExpression )
            	                    // PsiInternalPureXbase.g:1986:10: lv_memberCallArguments_19_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {

            	                      										markComposite(elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0ElementType());
            	                      									
            	                    }
            	                    pushFollow(FOLLOW_32);
            	                    lv_memberCallArguments_19_0=ruleXExpression();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      										doneComposite();
            	                      										if(!current) {
            	                      											associateWithSemanticElement();
            	                      											current = true;
            	                      										}
            	                      									
            	                    }

            	                    }


            	                    }

            	                    // PsiInternalPureXbase.g:1999:8: (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )*
            	                    loop31:
            	                    do {
            	                        int alt31=2;
            	                        int LA31_0 = input.LA(1);

            	                        if ( (LA31_0==49) ) {
            	                            alt31=1;
            	                        }


            	                        switch (alt31) {
            	                    	case 1 :
            	                    	    // PsiInternalPureXbase.g:2000:9: otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) )
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {

            	                    	      									markLeaf(elementTypeProvider.getXMemberFeatureCall_CommaKeyword_1_1_3_1_1_1_0ElementType());
            	                    	      								
            	                    	    }
            	                    	    otherlv_20=(Token)match(input,49,FOLLOW_3); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      									doneLeaf(otherlv_20);
            	                    	      								
            	                    	    }
            	                    	    // PsiInternalPureXbase.g:2007:9: ( (lv_memberCallArguments_21_0= ruleXExpression ) )
            	                    	    // PsiInternalPureXbase.g:2008:10: (lv_memberCallArguments_21_0= ruleXExpression )
            	                    	    {
            	                    	    // PsiInternalPureXbase.g:2008:10: (lv_memberCallArguments_21_0= ruleXExpression )
            	                    	    // PsiInternalPureXbase.g:2009:11: lv_memberCallArguments_21_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {

            	                    	      											markComposite(elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0ElementType());
            	                    	      										
            	                    	    }
            	                    	    pushFollow(FOLLOW_32);
            	                    	    lv_memberCallArguments_21_0=ruleXExpression();

            	                    	    state._fsp--;
            	                    	    if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      											doneComposite();
            	                    	      											if(!current) {
            	                    	      												associateWithSemanticElement();
            	                    	      												current = true;
            	                    	      											}
            	                    	      										
            	                    	    }

            	                    	    }


            	                    	    }


            	                    	    }
            	                    	    break;

            	                    	default :
            	                    	    break loop31;
            	                        }
            	                    } while (true);


            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              						markLeaf(elementTypeProvider.getXMemberFeatureCall_RightParenthesisKeyword_1_1_3_2ElementType());
            	              					
            	            }
            	            otherlv_22=(Token)match(input,51,FOLLOW_33); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						doneLeaf(otherlv_22);
            	              					
            	            }

            	            }
            	            break;

            	    }

            	    // PsiInternalPureXbase.g:2033:5: ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?
            	    int alt34=2;
            	    alt34 = dfa34.predict(input);
            	    switch (alt34) {
            	        case 1 :
            	            // PsiInternalPureXbase.g:2034:6: ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure )
            	            {
            	            // PsiInternalPureXbase.g:2040:6: (lv_memberCallArguments_23_0= ruleXClosure )
            	            // PsiInternalPureXbase.g:2041:7: lv_memberCallArguments_23_0= ruleXClosure
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markComposite(elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXClosureParserRuleCall_1_1_4_0ElementType());
            	              						
            	            }
            	            pushFollow(FOLLOW_24);
            	            lv_memberCallArguments_23_0=ruleXClosure();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

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


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


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
    // $ANTLR end "ruleXMemberFeatureCall"


    // $ANTLR start "entryRuleXPrimaryExpression"
    // PsiInternalPureXbase.g:2060:1: entryRuleXPrimaryExpression returns [Boolean current=false] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final Boolean entryRuleXPrimaryExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXPrimaryExpression = null;


        try {
            // PsiInternalPureXbase.g:2060:60: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // PsiInternalPureXbase.g:2061:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXPrimaryExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXPrimaryExpression"


    // $ANTLR start "ruleXPrimaryExpression"
    // PsiInternalPureXbase.g:2067:1: ruleXPrimaryExpression returns [Boolean current=false] : (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression ) ;
    public final Boolean ruleXPrimaryExpression() throws RecognitionException {
        Boolean current = false;

        Boolean this_XConstructorCall_0 = null;

        Boolean this_XBlockExpression_1 = null;

        Boolean this_XSwitchExpression_2 = null;

        Boolean this_XSynchronizedExpression_3 = null;

        Boolean this_XFeatureCall_4 = null;

        Boolean this_XLiteral_5 = null;

        Boolean this_XIfExpression_6 = null;

        Boolean this_XForLoopExpression_7 = null;

        Boolean this_XBasicForLoopExpression_8 = null;

        Boolean this_XWhileExpression_9 = null;

        Boolean this_XDoWhileExpression_10 = null;

        Boolean this_XThrowExpression_11 = null;

        Boolean this_XReturnExpression_12 = null;

        Boolean this_XTryCatchFinallyExpression_13 = null;

        Boolean this_XParenthesizedExpression_14 = null;


        try {
            // PsiInternalPureXbase.g:2068:1: ( (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression ) )
            // PsiInternalPureXbase.g:2069:2: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression )
            {
            // PsiInternalPureXbase.g:2069:2: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression )
            int alt36=15;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // PsiInternalPureXbase.g:2070:3: this_XConstructorCall_0= ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XConstructorCallParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XConstructorCall_0=ruleXConstructorCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XConstructorCall_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:2079:3: this_XBlockExpression_1= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XBlockExpressionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XBlockExpression_1=ruleXBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XBlockExpression_1;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalPureXbase.g:2088:3: this_XSwitchExpression_2= ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XSwitchExpressionParserRuleCall_2ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XSwitchExpression_2=ruleXSwitchExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XSwitchExpression_2;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalPureXbase.g:2097:3: ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression )
                    {
                    // PsiInternalPureXbase.g:2097:3: ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression )
                    // PsiInternalPureXbase.g:2098:4: ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getXPrimaryExpression_XSynchronizedExpressionParserRuleCall_3ElementType());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_XSynchronizedExpression_3=ruleXSynchronizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_XSynchronizedExpression_3;
                      				doneComposite();
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // PsiInternalPureXbase.g:2115:3: this_XFeatureCall_4= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XFeatureCallParserRuleCall_4ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XFeatureCall_4=ruleXFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XFeatureCall_4;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalPureXbase.g:2124:3: this_XLiteral_5= ruleXLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XLiteralParserRuleCall_5ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XLiteral_5=ruleXLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XLiteral_5;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 7 :
                    // PsiInternalPureXbase.g:2133:3: this_XIfExpression_6= ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XIfExpressionParserRuleCall_6ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XIfExpression_6=ruleXIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XIfExpression_6;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 8 :
                    // PsiInternalPureXbase.g:2142:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression )
                    {
                    // PsiInternalPureXbase.g:2142:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression )
                    // PsiInternalPureXbase.g:2143:4: ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getXPrimaryExpression_XForLoopExpressionParserRuleCall_7ElementType());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_XForLoopExpression_7=ruleXForLoopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_XForLoopExpression_7;
                      				doneComposite();
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // PsiInternalPureXbase.g:2166:3: this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XBasicForLoopExpressionParserRuleCall_8ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XBasicForLoopExpression_8=ruleXBasicForLoopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XBasicForLoopExpression_8;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 10 :
                    // PsiInternalPureXbase.g:2175:3: this_XWhileExpression_9= ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XWhileExpressionParserRuleCall_9ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XWhileExpression_9=ruleXWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XWhileExpression_9;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 11 :
                    // PsiInternalPureXbase.g:2184:3: this_XDoWhileExpression_10= ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XDoWhileExpressionParserRuleCall_10ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XDoWhileExpression_10=ruleXDoWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XDoWhileExpression_10;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 12 :
                    // PsiInternalPureXbase.g:2193:3: this_XThrowExpression_11= ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XThrowExpressionParserRuleCall_11ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XThrowExpression_11=ruleXThrowExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XThrowExpression_11;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 13 :
                    // PsiInternalPureXbase.g:2202:3: this_XReturnExpression_12= ruleXReturnExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XReturnExpressionParserRuleCall_12ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XReturnExpression_12=ruleXReturnExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XReturnExpression_12;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 14 :
                    // PsiInternalPureXbase.g:2211:3: this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XTryCatchFinallyExpressionParserRuleCall_13ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XTryCatchFinallyExpression_13=ruleXTryCatchFinallyExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XTryCatchFinallyExpression_13;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 15 :
                    // PsiInternalPureXbase.g:2220:3: this_XParenthesizedExpression_14= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XParenthesizedExpressionParserRuleCall_14ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XParenthesizedExpression_14=ruleXParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XParenthesizedExpression_14;
                      			doneComposite();
                      		
                    }

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
    // $ANTLR end "ruleXPrimaryExpression"


    // $ANTLR start "entryRuleXLiteral"
    // PsiInternalPureXbase.g:2232:1: entryRuleXLiteral returns [Boolean current=false] : iv_ruleXLiteral= ruleXLiteral EOF ;
    public final Boolean entryRuleXLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXLiteral = null;


        try {
            // PsiInternalPureXbase.g:2232:50: (iv_ruleXLiteral= ruleXLiteral EOF )
            // PsiInternalPureXbase.g:2233:2: iv_ruleXLiteral= ruleXLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXLiteral=ruleXLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXLiteral"


    // $ANTLR start "ruleXLiteral"
    // PsiInternalPureXbase.g:2239:1: ruleXLiteral returns [Boolean current=false] : (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XNumberLiteral_3= ruleXNumberLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral ) ;
    public final Boolean ruleXLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean this_XCollectionLiteral_0 = null;

        Boolean this_XClosure_1 = null;

        Boolean this_XBooleanLiteral_2 = null;

        Boolean this_XNumberLiteral_3 = null;

        Boolean this_XNullLiteral_4 = null;

        Boolean this_XStringLiteral_5 = null;

        Boolean this_XTypeLiteral_6 = null;


        try {
            // PsiInternalPureXbase.g:2240:1: ( (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XNumberLiteral_3= ruleXNumberLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral ) )
            // PsiInternalPureXbase.g:2241:2: (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XNumberLiteral_3= ruleXNumberLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral )
            {
            // PsiInternalPureXbase.g:2241:2: (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XNumberLiteral_3= ruleXNumberLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral )
            int alt37=7;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==52) ) {
                alt37=1;
            }
            else if ( (LA37_0==55) && (synpred21_PsiInternalPureXbase())) {
                alt37=2;
            }
            else if ( ((LA37_0>=71 && LA37_0<=72)) ) {
                alt37=3;
            }
            else if ( ((LA37_0>=RULE_HEX && LA37_0<=RULE_DECIMAL)) ) {
                alt37=4;
            }
            else if ( (LA37_0==73) ) {
                alt37=5;
            }
            else if ( (LA37_0==RULE_STRING) ) {
                alt37=6;
            }
            else if ( (LA37_0==74) ) {
                alt37=7;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // PsiInternalPureXbase.g:2242:3: this_XCollectionLiteral_0= ruleXCollectionLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXLiteral_XCollectionLiteralParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XCollectionLiteral_0=ruleXCollectionLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XCollectionLiteral_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:2251:3: ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure )
                    {
                    // PsiInternalPureXbase.g:2251:3: ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure )
                    // PsiInternalPureXbase.g:2252:4: ( ( () '[' ) )=>this_XClosure_1= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getXLiteral_XClosureParserRuleCall_1ElementType());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_XClosure_1=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_XClosure_1;
                      				doneComposite();
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalPureXbase.g:2268:3: this_XBooleanLiteral_2= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXLiteral_XBooleanLiteralParserRuleCall_2ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XBooleanLiteral_2=ruleXBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XBooleanLiteral_2;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalPureXbase.g:2277:3: this_XNumberLiteral_3= ruleXNumberLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXLiteral_XNumberLiteralParserRuleCall_3ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XNumberLiteral_3=ruleXNumberLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XNumberLiteral_3;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 5 :
                    // PsiInternalPureXbase.g:2286:3: this_XNullLiteral_4= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXLiteral_XNullLiteralParserRuleCall_4ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XNullLiteral_4=ruleXNullLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XNullLiteral_4;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalPureXbase.g:2295:3: this_XStringLiteral_5= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXLiteral_XStringLiteralParserRuleCall_5ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XStringLiteral_5=ruleXStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XStringLiteral_5;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 7 :
                    // PsiInternalPureXbase.g:2304:3: this_XTypeLiteral_6= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXLiteral_XTypeLiteralParserRuleCall_6ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XTypeLiteral_6=ruleXTypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XTypeLiteral_6;
                      			doneComposite();
                      		
                    }

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
    // $ANTLR end "ruleXLiteral"


    // $ANTLR start "entryRuleXCollectionLiteral"
    // PsiInternalPureXbase.g:2316:1: entryRuleXCollectionLiteral returns [Boolean current=false] : iv_ruleXCollectionLiteral= ruleXCollectionLiteral EOF ;
    public final Boolean entryRuleXCollectionLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXCollectionLiteral = null;


        try {
            // PsiInternalPureXbase.g:2316:60: (iv_ruleXCollectionLiteral= ruleXCollectionLiteral EOF )
            // PsiInternalPureXbase.g:2317:2: iv_ruleXCollectionLiteral= ruleXCollectionLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXCollectionLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXCollectionLiteral=ruleXCollectionLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCollectionLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXCollectionLiteral"


    // $ANTLR start "ruleXCollectionLiteral"
    // PsiInternalPureXbase.g:2323:1: ruleXCollectionLiteral returns [Boolean current=false] : (this_XSetLiteral_0= ruleXSetLiteral | this_XListLiteral_1= ruleXListLiteral ) ;
    public final Boolean ruleXCollectionLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean this_XSetLiteral_0 = null;

        Boolean this_XListLiteral_1 = null;


        try {
            // PsiInternalPureXbase.g:2324:1: ( (this_XSetLiteral_0= ruleXSetLiteral | this_XListLiteral_1= ruleXListLiteral ) )
            // PsiInternalPureXbase.g:2325:2: (this_XSetLiteral_0= ruleXSetLiteral | this_XListLiteral_1= ruleXListLiteral )
            {
            // PsiInternalPureXbase.g:2325:2: (this_XSetLiteral_0= ruleXSetLiteral | this_XListLiteral_1= ruleXListLiteral )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==52) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==53) ) {
                    alt38=1;
                }
                else if ( (LA38_1==55) ) {
                    alt38=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // PsiInternalPureXbase.g:2326:3: this_XSetLiteral_0= ruleXSetLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXCollectionLiteral_XSetLiteralParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XSetLiteral_0=ruleXSetLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XSetLiteral_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:2335:3: this_XListLiteral_1= ruleXListLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXCollectionLiteral_XListLiteralParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XListLiteral_1=ruleXListLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XListLiteral_1;
                      			doneComposite();
                      		
                    }

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
    // $ANTLR end "ruleXCollectionLiteral"


    // $ANTLR start "entryRuleXSetLiteral"
    // PsiInternalPureXbase.g:2347:1: entryRuleXSetLiteral returns [Boolean current=false] : iv_ruleXSetLiteral= ruleXSetLiteral EOF ;
    public final Boolean entryRuleXSetLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXSetLiteral = null;


        try {
            // PsiInternalPureXbase.g:2347:53: (iv_ruleXSetLiteral= ruleXSetLiteral EOF )
            // PsiInternalPureXbase.g:2348:2: iv_ruleXSetLiteral= ruleXSetLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXSetLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXSetLiteral=ruleXSetLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSetLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXSetLiteral"


    // $ANTLR start "ruleXSetLiteral"
    // PsiInternalPureXbase.g:2354:1: ruleXSetLiteral returns [Boolean current=false] : ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' ) ;
    public final Boolean ruleXSetLiteral() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_elements_3_0 = null;

        Boolean lv_elements_5_0 = null;


        try {
            // PsiInternalPureXbase.g:2355:1: ( ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' ) )
            // PsiInternalPureXbase.g:2356:2: ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' )
            {
            // PsiInternalPureXbase.g:2356:2: ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' )
            // PsiInternalPureXbase.g:2357:3: () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}'
            {
            // PsiInternalPureXbase.g:2357:3: ()
            // PsiInternalPureXbase.g:2358:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXSetLiteral_XSetLiteralAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXSetLiteral_NumberSignKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,52,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXSetLiteral_LeftCurlyBracketKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,53,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalPureXbase.g:2378:3: ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_STRING && LA40_0<=RULE_ID)||LA40_0==20||(LA40_0>=36 && LA40_0<=37)||LA40_0==42||LA40_0==50||(LA40_0>=52 && LA40_0<=53)||LA40_0==55||LA40_0==58||LA40_0==60||(LA40_0>=64 && LA40_0<=66)||(LA40_0>=69 && LA40_0<=77)||LA40_0==79) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // PsiInternalPureXbase.g:2379:4: ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
                    {
                    // PsiInternalPureXbase.g:2379:4: ( (lv_elements_3_0= ruleXExpression ) )
                    // PsiInternalPureXbase.g:2380:5: (lv_elements_3_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:2380:5: (lv_elements_3_0= ruleXExpression )
                    // PsiInternalPureXbase.g:2381:6: lv_elements_3_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXSetLiteral_ElementsXExpressionParserRuleCall_3_0_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_36);
                    lv_elements_3_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:2394:4: (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==49) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:2395:5: otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getXSetLiteral_CommaKeyword_3_1_0ElementType());
                    	      				
                    	    }
                    	    otherlv_4=(Token)match(input,49,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_4);
                    	      				
                    	    }
                    	    // PsiInternalPureXbase.g:2402:5: ( (lv_elements_5_0= ruleXExpression ) )
                    	    // PsiInternalPureXbase.g:2403:6: (lv_elements_5_0= ruleXExpression )
                    	    {
                    	    // PsiInternalPureXbase.g:2403:6: (lv_elements_5_0= ruleXExpression )
                    	    // PsiInternalPureXbase.g:2404:7: lv_elements_5_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getXSetLiteral_ElementsXExpressionParserRuleCall_3_1_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_36);
                    	    lv_elements_5_0=ruleXExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      							if(!current) {
                    	      								associateWithSemanticElement();
                    	      								current = true;
                    	      							}
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXSetLiteral_RightCurlyBracketKeyword_4ElementType());
              		
            }
            otherlv_6=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_6);
              		
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
    // $ANTLR end "ruleXSetLiteral"


    // $ANTLR start "entryRuleXListLiteral"
    // PsiInternalPureXbase.g:2430:1: entryRuleXListLiteral returns [Boolean current=false] : iv_ruleXListLiteral= ruleXListLiteral EOF ;
    public final Boolean entryRuleXListLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXListLiteral = null;


        try {
            // PsiInternalPureXbase.g:2430:54: (iv_ruleXListLiteral= ruleXListLiteral EOF )
            // PsiInternalPureXbase.g:2431:2: iv_ruleXListLiteral= ruleXListLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXListLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXListLiteral=ruleXListLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXListLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXListLiteral"


    // $ANTLR start "ruleXListLiteral"
    // PsiInternalPureXbase.g:2437:1: ruleXListLiteral returns [Boolean current=false] : ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' ) ;
    public final Boolean ruleXListLiteral() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_elements_3_0 = null;

        Boolean lv_elements_5_0 = null;


        try {
            // PsiInternalPureXbase.g:2438:1: ( ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' ) )
            // PsiInternalPureXbase.g:2439:2: ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' )
            {
            // PsiInternalPureXbase.g:2439:2: ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' )
            // PsiInternalPureXbase.g:2440:3: () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']'
            {
            // PsiInternalPureXbase.g:2440:3: ()
            // PsiInternalPureXbase.g:2441:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXListLiteral_XListLiteralAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXListLiteral_NumberSignKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,52,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXListLiteral_LeftSquareBracketKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,55,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalPureXbase.g:2461:3: ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=RULE_STRING && LA42_0<=RULE_ID)||LA42_0==20||(LA42_0>=36 && LA42_0<=37)||LA42_0==42||LA42_0==50||(LA42_0>=52 && LA42_0<=53)||LA42_0==55||LA42_0==58||LA42_0==60||(LA42_0>=64 && LA42_0<=66)||(LA42_0>=69 && LA42_0<=77)||LA42_0==79) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // PsiInternalPureXbase.g:2462:4: ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
                    {
                    // PsiInternalPureXbase.g:2462:4: ( (lv_elements_3_0= ruleXExpression ) )
                    // PsiInternalPureXbase.g:2463:5: (lv_elements_3_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:2463:5: (lv_elements_3_0= ruleXExpression )
                    // PsiInternalPureXbase.g:2464:6: lv_elements_3_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXListLiteral_ElementsXExpressionParserRuleCall_3_0_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_39);
                    lv_elements_3_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:2477:4: (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==49) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:2478:5: otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getXListLiteral_CommaKeyword_3_1_0ElementType());
                    	      				
                    	    }
                    	    otherlv_4=(Token)match(input,49,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_4);
                    	      				
                    	    }
                    	    // PsiInternalPureXbase.g:2485:5: ( (lv_elements_5_0= ruleXExpression ) )
                    	    // PsiInternalPureXbase.g:2486:6: (lv_elements_5_0= ruleXExpression )
                    	    {
                    	    // PsiInternalPureXbase.g:2486:6: (lv_elements_5_0= ruleXExpression )
                    	    // PsiInternalPureXbase.g:2487:7: lv_elements_5_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getXListLiteral_ElementsXExpressionParserRuleCall_3_1_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_39);
                    	    lv_elements_5_0=ruleXExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      							if(!current) {
                    	      								associateWithSemanticElement();
                    	      								current = true;
                    	      							}
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop41;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXListLiteral_RightSquareBracketKeyword_4ElementType());
              		
            }
            otherlv_6=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_6);
              		
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
    // $ANTLR end "ruleXListLiteral"


    // $ANTLR start "entryRuleXClosure"
    // PsiInternalPureXbase.g:2513:1: entryRuleXClosure returns [Boolean current=false] : iv_ruleXClosure= ruleXClosure EOF ;
    public final Boolean entryRuleXClosure() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXClosure = null;


        try {
            // PsiInternalPureXbase.g:2513:50: (iv_ruleXClosure= ruleXClosure EOF )
            // PsiInternalPureXbase.g:2514:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXClosureElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXClosure"


    // $ANTLR start "ruleXClosure"
    // PsiInternalPureXbase.g:2520:1: ruleXClosure returns [Boolean current=false] : ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) ;
    public final Boolean ruleXClosure() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_explicitSyntax_5_0=null;
        Token otherlv_7=null;
        Boolean lv_declaredFormalParameters_2_0 = null;

        Boolean lv_declaredFormalParameters_4_0 = null;

        Boolean lv_expression_6_0 = null;


        try {
            // PsiInternalPureXbase.g:2521:1: ( ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) )
            // PsiInternalPureXbase.g:2522:2: ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            {
            // PsiInternalPureXbase.g:2522:2: ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            // PsiInternalPureXbase.g:2523:3: ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']'
            {
            // PsiInternalPureXbase.g:2523:3: ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) )
            // PsiInternalPureXbase.g:2524:4: ( ( () '[' ) )=> ( () otherlv_1= '[' )
            {
            // PsiInternalPureXbase.g:2530:4: ( () otherlv_1= '[' )
            // PsiInternalPureXbase.g:2531:5: () otherlv_1= '['
            {
            // PsiInternalPureXbase.g:2531:5: ()
            // PsiInternalPureXbase.g:2532:6: 
            {
            if ( state.backtracking==0 ) {

              						precedeComposite(elementTypeProvider.getXClosure_XClosureAction_0_0_0ElementType());
              						doneComposite();
              						associateWithSemanticElement();
              					
            }

            }

            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXClosure_LeftSquareBracketKeyword_0_0_1ElementType());
              				
            }
            otherlv_1=(Token)match(input,55,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(otherlv_1);
              				
            }

            }


            }

            // PsiInternalPureXbase.g:2547:3: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?
            int alt45=2;
            alt45 = dfa45.predict(input);
            switch (alt45) {
                case 1 :
                    // PsiInternalPureXbase.g:2548:4: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    {
                    // PsiInternalPureXbase.g:2571:4: ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    // PsiInternalPureXbase.g:2572:5: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) )
                    {
                    // PsiInternalPureXbase.g:2572:5: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==RULE_ID||LA44_0==33||LA44_0==50) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // PsiInternalPureXbase.g:2573:6: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            {
                            // PsiInternalPureXbase.g:2573:6: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) )
                            // PsiInternalPureXbase.g:2574:7: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            {
                            // PsiInternalPureXbase.g:2574:7: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            // PsiInternalPureXbase.g:2575:8: lv_declaredFormalParameters_2_0= ruleJvmFormalParameter
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getXClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0ElementType());
                              							
                            }
                            pushFollow(FOLLOW_41);
                            lv_declaredFormalParameters_2_0=ruleJvmFormalParameter();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              								if(!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }

                            }


                            }

                            // PsiInternalPureXbase.g:2588:6: (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            loop43:
                            do {
                                int alt43=2;
                                int LA43_0 = input.LA(1);

                                if ( (LA43_0==49) ) {
                                    alt43=1;
                                }


                                switch (alt43) {
                            	case 1 :
                            	    // PsiInternalPureXbase.g:2589:7: otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      							markLeaf(elementTypeProvider.getXClosure_CommaKeyword_1_0_0_1_0ElementType());
                            	      						
                            	    }
                            	    otherlv_3=(Token)match(input,49,FOLLOW_15); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							doneLeaf(otherlv_3);
                            	      						
                            	    }
                            	    // PsiInternalPureXbase.g:2596:7: ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    // PsiInternalPureXbase.g:2597:8: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    {
                            	    // PsiInternalPureXbase.g:2597:8: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    // PsiInternalPureXbase.g:2598:9: lv_declaredFormalParameters_4_0= ruleJvmFormalParameter
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									markComposite(elementTypeProvider.getXClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0ElementType());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_41);
                            	    lv_declaredFormalParameters_4_0=ruleJvmFormalParameter();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									doneComposite();
                            	      									if(!current) {
                            	      										associateWithSemanticElement();
                            	      										current = true;
                            	      									}
                            	      								
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop43;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // PsiInternalPureXbase.g:2613:5: ( (lv_explicitSyntax_5_0= '|' ) )
                    // PsiInternalPureXbase.g:2614:6: (lv_explicitSyntax_5_0= '|' )
                    {
                    // PsiInternalPureXbase.g:2614:6: (lv_explicitSyntax_5_0= '|' )
                    // PsiInternalPureXbase.g:2615:7: lv_explicitSyntax_5_0= '|'
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getXClosure_ExplicitSyntaxVerticalLineKeyword_1_0_1_0ElementType());
                      						
                    }
                    lv_explicitSyntax_5_0=(Token)match(input,57,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(lv_explicitSyntax_5_0);
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            // PsiInternalPureXbase.g:2632:3: ( (lv_expression_6_0= ruleXExpressionInClosure ) )
            // PsiInternalPureXbase.g:2633:4: (lv_expression_6_0= ruleXExpressionInClosure )
            {
            // PsiInternalPureXbase.g:2633:4: (lv_expression_6_0= ruleXExpressionInClosure )
            // PsiInternalPureXbase.g:2634:5: lv_expression_6_0= ruleXExpressionInClosure
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXClosure_ExpressionXExpressionInClosureParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_42);
            lv_expression_6_0=ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXClosure_RightSquareBracketKeyword_3ElementType());
              		
            }
            otherlv_7=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_7);
              		
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
    // $ANTLR end "ruleXClosure"


    // $ANTLR start "entryRuleXExpressionInClosure"
    // PsiInternalPureXbase.g:2658:1: entryRuleXExpressionInClosure returns [Boolean current=false] : iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF ;
    public final Boolean entryRuleXExpressionInClosure() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXExpressionInClosure = null;


        try {
            // PsiInternalPureXbase.g:2658:62: (iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF )
            // PsiInternalPureXbase.g:2659:2: iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXExpressionInClosureElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXExpressionInClosure=ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInClosure; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXExpressionInClosure"


    // $ANTLR start "ruleXExpressionInClosure"
    // PsiInternalPureXbase.g:2665:1: ruleXExpressionInClosure returns [Boolean current=false] : ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) ;
    public final Boolean ruleXExpressionInClosure() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean lv_expressions_1_0 = null;


        try {
            // PsiInternalPureXbase.g:2666:1: ( ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) )
            // PsiInternalPureXbase.g:2667:2: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
            {
            // PsiInternalPureXbase.g:2667:2: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
            // PsiInternalPureXbase.g:2668:3: () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
            {
            // PsiInternalPureXbase.g:2668:3: ()
            // PsiInternalPureXbase.g:2669:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXExpressionInClosure_XBlockExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalPureXbase.g:2675:3: ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( ((LA47_0>=RULE_STRING && LA47_0<=RULE_ID)||LA47_0==20||(LA47_0>=36 && LA47_0<=37)||LA47_0==42||LA47_0==50||(LA47_0>=52 && LA47_0<=53)||LA47_0==55||LA47_0==58||LA47_0==60||(LA47_0>=64 && LA47_0<=77)||LA47_0==79) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // PsiInternalPureXbase.g:2676:4: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )?
            	    {
            	    // PsiInternalPureXbase.g:2676:4: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) )
            	    // PsiInternalPureXbase.g:2677:5: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
            	    {
            	    // PsiInternalPureXbase.g:2677:5: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
            	    // PsiInternalPureXbase.g:2678:6: lv_expressions_1_0= ruleXExpressionOrVarDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXExpressionInClosure_ExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_expressions_1_0=ruleXExpressionOrVarDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }

            	    // PsiInternalPureXbase.g:2691:4: (otherlv_2= ';' )?
            	    int alt46=2;
            	    int LA46_0 = input.LA(1);

            	    if ( (LA46_0==13) ) {
            	        alt46=1;
            	    }
            	    switch (alt46) {
            	        case 1 :
            	            // PsiInternalPureXbase.g:2692:5: otherlv_2= ';'
            	            {
            	            if ( state.backtracking==0 ) {

            	              					markLeaf(elementTypeProvider.getXExpressionInClosure_SemicolonKeyword_1_1ElementType());
            	              				
            	            }
            	            otherlv_2=(Token)match(input,13,FOLLOW_5); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              					doneLeaf(otherlv_2);
            	              				
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);


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
    // $ANTLR end "ruleXExpressionInClosure"


    // $ANTLR start "entryRuleXShortClosure"
    // PsiInternalPureXbase.g:2705:1: entryRuleXShortClosure returns [Boolean current=false] : iv_ruleXShortClosure= ruleXShortClosure EOF ;
    public final Boolean entryRuleXShortClosure() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXShortClosure = null;


        try {
            // PsiInternalPureXbase.g:2705:55: (iv_ruleXShortClosure= ruleXShortClosure EOF )
            // PsiInternalPureXbase.g:2706:2: iv_ruleXShortClosure= ruleXShortClosure EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXShortClosureElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXShortClosure=ruleXShortClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXShortClosure; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXShortClosure"


    // $ANTLR start "ruleXShortClosure"
    // PsiInternalPureXbase.g:2712:1: ruleXShortClosure returns [Boolean current=false] : ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final Boolean ruleXShortClosure() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Token lv_explicitSyntax_4_0=null;
        Boolean lv_declaredFormalParameters_1_0 = null;

        Boolean lv_declaredFormalParameters_3_0 = null;

        Boolean lv_expression_5_0 = null;


        try {
            // PsiInternalPureXbase.g:2713:1: ( ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // PsiInternalPureXbase.g:2714:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // PsiInternalPureXbase.g:2714:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            // PsiInternalPureXbase.g:2715:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) )
            {
            // PsiInternalPureXbase.g:2715:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) )
            // PsiInternalPureXbase.g:2716:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            {
            // PsiInternalPureXbase.g:2741:4: ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            // PsiInternalPureXbase.g:2742:5: () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) )
            {
            // PsiInternalPureXbase.g:2742:5: ()
            // PsiInternalPureXbase.g:2743:6: 
            {
            if ( state.backtracking==0 ) {

              						precedeComposite(elementTypeProvider.getXShortClosure_XClosureAction_0_0_0ElementType());
              						doneComposite();
              						associateWithSemanticElement();
              					
            }

            }

            // PsiInternalPureXbase.g:2749:5: ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_ID||LA49_0==33||LA49_0==50) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // PsiInternalPureXbase.g:2750:6: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // PsiInternalPureXbase.g:2750:6: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) )
                    // PsiInternalPureXbase.g:2751:7: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // PsiInternalPureXbase.g:2751:7: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    // PsiInternalPureXbase.g:2752:8: lv_declaredFormalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getXShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0ElementType());
                      							
                    }
                    pushFollow(FOLLOW_41);
                    lv_declaredFormalParameters_1_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								doneComposite();
                      								if(!current) {
                      									associateWithSemanticElement();
                      									current = true;
                      								}
                      							
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:2765:6: (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==49) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:2766:7: otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markLeaf(elementTypeProvider.getXShortClosure_CommaKeyword_0_0_1_1_0ElementType());
                    	      						
                    	    }
                    	    otherlv_2=(Token)match(input,49,FOLLOW_15); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							doneLeaf(otherlv_2);
                    	      						
                    	    }
                    	    // PsiInternalPureXbase.g:2773:7: ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // PsiInternalPureXbase.g:2774:8: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // PsiInternalPureXbase.g:2774:8: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    // PsiInternalPureXbase.g:2775:9: lv_declaredFormalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      									markComposite(elementTypeProvider.getXShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0ElementType());
                    	      								
                    	    }
                    	    pushFollow(FOLLOW_41);
                    	    lv_declaredFormalParameters_3_0=ruleJvmFormalParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      									doneComposite();
                    	      									if(!current) {
                    	      										associateWithSemanticElement();
                    	      										current = true;
                    	      									}
                    	      								
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);


                    }
                    break;

            }

            // PsiInternalPureXbase.g:2790:5: ( (lv_explicitSyntax_4_0= '|' ) )
            // PsiInternalPureXbase.g:2791:6: (lv_explicitSyntax_4_0= '|' )
            {
            // PsiInternalPureXbase.g:2791:6: (lv_explicitSyntax_4_0= '|' )
            // PsiInternalPureXbase.g:2792:7: lv_explicitSyntax_4_0= '|'
            {
            if ( state.backtracking==0 ) {

              							markLeaf(elementTypeProvider.getXShortClosure_ExplicitSyntaxVerticalLineKeyword_0_0_2_0ElementType());
              						
            }
            lv_explicitSyntax_4_0=(Token)match(input,57,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              							doneLeaf(lv_explicitSyntax_4_0);
              						
            }
            if ( state.backtracking==0 ) {

              							if (!current) {
              								associateWithSemanticElement();
              								current = true;
              							}
              						
            }

            }


            }


            }


            }

            // PsiInternalPureXbase.g:2809:3: ( (lv_expression_5_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:2810:4: (lv_expression_5_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:2810:4: (lv_expression_5_0= ruleXExpression )
            // PsiInternalPureXbase.g:2811:5: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXShortClosure_ExpressionXExpressionParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXShortClosure"


    // $ANTLR start "entryRuleXParenthesizedExpression"
    // PsiInternalPureXbase.g:2828:1: entryRuleXParenthesizedExpression returns [Boolean current=false] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final Boolean entryRuleXParenthesizedExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXParenthesizedExpression = null;


        try {
            // PsiInternalPureXbase.g:2828:66: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // PsiInternalPureXbase.g:2829:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXParenthesizedExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXParenthesizedExpression"


    // $ANTLR start "ruleXParenthesizedExpression"
    // PsiInternalPureXbase.g:2835:1: ruleXParenthesizedExpression returns [Boolean current=false] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
    public final Boolean ruleXParenthesizedExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean this_XExpression_1 = null;


        try {
            // PsiInternalPureXbase.g:2836:1: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
            // PsiInternalPureXbase.g:2837:2: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            {
            // PsiInternalPureXbase.g:2837:2: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            // PsiInternalPureXbase.g:2838:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXParenthesizedExpression_LeftParenthesisKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,50,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXParenthesizedExpression_XExpressionParserRuleCall_1ElementType());
              		
            }
            pushFollow(FOLLOW_31);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XExpression_1;
              			doneComposite();
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXParenthesizedExpression_RightParenthesisKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
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
    // $ANTLR end "ruleXParenthesizedExpression"


    // $ANTLR start "entryRuleXIfExpression"
    // PsiInternalPureXbase.g:2864:1: entryRuleXIfExpression returns [Boolean current=false] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final Boolean entryRuleXIfExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXIfExpression = null;


        try {
            // PsiInternalPureXbase.g:2864:55: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // PsiInternalPureXbase.g:2865:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXIfExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXIfExpression=ruleXIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXIfExpression"


    // $ANTLR start "ruleXIfExpression"
    // PsiInternalPureXbase.g:2871:1: ruleXIfExpression returns [Boolean current=false] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) ;
    public final Boolean ruleXIfExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_if_3_0 = null;

        Boolean lv_then_5_0 = null;

        Boolean lv_else_7_0 = null;


        try {
            // PsiInternalPureXbase.g:2872:1: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) )
            // PsiInternalPureXbase.g:2873:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            {
            // PsiInternalPureXbase.g:2873:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            // PsiInternalPureXbase.g:2874:3: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            {
            // PsiInternalPureXbase.g:2874:3: ()
            // PsiInternalPureXbase.g:2875:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXIfExpression_XIfExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXIfExpression_IfKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,58,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXIfExpression_LeftParenthesisKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,50,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalPureXbase.g:2895:3: ( (lv_if_3_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:2896:4: (lv_if_3_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:2896:4: (lv_if_3_0= ruleXExpression )
            // PsiInternalPureXbase.g:2897:5: lv_if_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXIfExpression_IfXExpressionParserRuleCall_3_0ElementType());
              				
            }
            pushFollow(FOLLOW_31);
            lv_if_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXIfExpression_RightParenthesisKeyword_4ElementType());
              		
            }
            otherlv_4=(Token)match(input,51,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
            }
            // PsiInternalPureXbase.g:2917:3: ( (lv_then_5_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:2918:4: (lv_then_5_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:2918:4: (lv_then_5_0= ruleXExpression )
            // PsiInternalPureXbase.g:2919:5: lv_then_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXIfExpression_ThenXExpressionParserRuleCall_5_0ElementType());
              				
            }
            pushFollow(FOLLOW_44);
            lv_then_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            // PsiInternalPureXbase.g:2932:3: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==59) ) {
                int LA50_1 = input.LA(2);

                if ( (synpred25_PsiInternalPureXbase()) ) {
                    alt50=1;
                }
            }
            switch (alt50) {
                case 1 :
                    // PsiInternalPureXbase.g:2933:4: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) )
                    {
                    // PsiInternalPureXbase.g:2933:4: ( ( 'else' )=>otherlv_6= 'else' )
                    // PsiInternalPureXbase.g:2934:5: ( 'else' )=>otherlv_6= 'else'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getXIfExpression_ElseKeyword_6_0ElementType());
                      				
                    }
                    otherlv_6=(Token)match(input,59,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_6);
                      				
                    }

                    }

                    // PsiInternalPureXbase.g:2943:4: ( (lv_else_7_0= ruleXExpression ) )
                    // PsiInternalPureXbase.g:2944:5: (lv_else_7_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:2944:5: (lv_else_7_0= ruleXExpression )
                    // PsiInternalPureXbase.g:2945:6: lv_else_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXIfExpression_ElseXExpressionParserRuleCall_6_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_else_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleXIfExpression"


    // $ANTLR start "entryRuleXSwitchExpression"
    // PsiInternalPureXbase.g:2963:1: entryRuleXSwitchExpression returns [Boolean current=false] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final Boolean entryRuleXSwitchExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXSwitchExpression = null;


        try {
            // PsiInternalPureXbase.g:2963:59: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // PsiInternalPureXbase.g:2964:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXSwitchExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXSwitchExpression"


    // $ANTLR start "ruleXSwitchExpression"
    // PsiInternalPureXbase.g:2970:1: ruleXSwitchExpression returns [Boolean current=false] : ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' ) ;
    public final Boolean ruleXSwitchExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Boolean lv_declaredParam_3_0 = null;

        Boolean lv_switch_5_0 = null;

        Boolean lv_declaredParam_7_0 = null;

        Boolean lv_switch_9_0 = null;

        Boolean lv_cases_11_0 = null;

        Boolean lv_default_14_0 = null;


        try {
            // PsiInternalPureXbase.g:2971:1: ( ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' ) )
            // PsiInternalPureXbase.g:2972:2: ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' )
            {
            // PsiInternalPureXbase.g:2972:2: ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' )
            // PsiInternalPureXbase.g:2973:3: () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}'
            {
            // PsiInternalPureXbase.g:2973:3: ()
            // PsiInternalPureXbase.g:2974:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXSwitchExpression_XSwitchExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXSwitchExpression_SwitchKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,60,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalPureXbase.g:2987:3: ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) )
            int alt52=2;
            alt52 = dfa52.predict(input);
            switch (alt52) {
                case 1 :
                    // PsiInternalPureXbase.g:2988:4: ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' )
                    {
                    // PsiInternalPureXbase.g:2988:4: ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' )
                    // PsiInternalPureXbase.g:2989:5: ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')'
                    {
                    // PsiInternalPureXbase.g:2989:5: ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) )
                    // PsiInternalPureXbase.g:2990:6: ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
                    {
                    // PsiInternalPureXbase.g:3000:6: (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
                    // PsiInternalPureXbase.g:3001:7: otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':'
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getXSwitchExpression_LeftParenthesisKeyword_2_0_0_0_0ElementType());
                      						
                    }
                    otherlv_2=(Token)match(input,50,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(otherlv_2);
                      						
                    }
                    // PsiInternalPureXbase.g:3008:7: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
                    // PsiInternalPureXbase.g:3009:8: (lv_declaredParam_3_0= ruleJvmFormalParameter )
                    {
                    // PsiInternalPureXbase.g:3009:8: (lv_declaredParam_3_0= ruleJvmFormalParameter )
                    // PsiInternalPureXbase.g:3010:9: lv_declaredParam_3_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {

                      									markComposite(elementTypeProvider.getXSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0ElementType());
                      								
                    }
                    pushFollow(FOLLOW_46);
                    lv_declaredParam_3_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      									doneComposite();
                      									if(!current) {
                      										associateWithSemanticElement();
                      										current = true;
                      									}
                      								
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getXSwitchExpression_ColonKeyword_2_0_0_0_2ElementType());
                      						
                    }
                    otherlv_4=(Token)match(input,61,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(otherlv_4);
                      						
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:3032:5: ( (lv_switch_5_0= ruleXExpression ) )
                    // PsiInternalPureXbase.g:3033:6: (lv_switch_5_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:3033:6: (lv_switch_5_0= ruleXExpression )
                    // PsiInternalPureXbase.g:3034:7: lv_switch_5_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getXSwitchExpression_SwitchXExpressionParserRuleCall_2_0_1_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_31);
                    lv_switch_5_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getXSwitchExpression_RightParenthesisKeyword_2_0_2ElementType());
                      				
                    }
                    otherlv_6=(Token)match(input,51,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_6);
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:3056:4: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) )
                    {
                    // PsiInternalPureXbase.g:3056:4: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) )
                    // PsiInternalPureXbase.g:3057:5: ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) )
                    {
                    // PsiInternalPureXbase.g:3057:5: ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )?
                    int alt51=2;
                    alt51 = dfa51.predict(input);
                    switch (alt51) {
                        case 1 :
                            // PsiInternalPureXbase.g:3058:6: ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' )
                            {
                            // PsiInternalPureXbase.g:3067:6: ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' )
                            // PsiInternalPureXbase.g:3068:7: ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':'
                            {
                            // PsiInternalPureXbase.g:3068:7: ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) )
                            // PsiInternalPureXbase.g:3069:8: (lv_declaredParam_7_0= ruleJvmFormalParameter )
                            {
                            // PsiInternalPureXbase.g:3069:8: (lv_declaredParam_7_0= ruleJvmFormalParameter )
                            // PsiInternalPureXbase.g:3070:9: lv_declaredParam_7_0= ruleJvmFormalParameter
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getXSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0ElementType());
                              								
                            }
                            pushFollow(FOLLOW_46);
                            lv_declaredParam_7_0=ruleJvmFormalParameter();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              									if(!current) {
                              										associateWithSemanticElement();
                              										current = true;
                              									}
                              								
                            }

                            }


                            }

                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getXSwitchExpression_ColonKeyword_2_1_0_0_1ElementType());
                              						
                            }
                            otherlv_8=(Token)match(input,61,FOLLOW_3); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(otherlv_8);
                              						
                            }

                            }


                            }
                            break;

                    }

                    // PsiInternalPureXbase.g:3092:5: ( (lv_switch_9_0= ruleXExpression ) )
                    // PsiInternalPureXbase.g:3093:6: (lv_switch_9_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:3093:6: (lv_switch_9_0= ruleXExpression )
                    // PsiInternalPureXbase.g:3094:7: lv_switch_9_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getXSwitchExpression_SwitchXExpressionParserRuleCall_2_1_1_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_34);
                    lv_switch_9_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXSwitchExpression_LeftCurlyBracketKeyword_3ElementType());
              		
            }
            otherlv_10=(Token)match(input,53,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_10);
              		
            }
            // PsiInternalPureXbase.g:3116:3: ( (lv_cases_11_0= ruleXCasePart ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_ID||LA53_0==33||(LA53_0>=49 && LA53_0<=50)||LA53_0==61||LA53_0==63) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // PsiInternalPureXbase.g:3117:4: (lv_cases_11_0= ruleXCasePart )
            	    {
            	    // PsiInternalPureXbase.g:3117:4: (lv_cases_11_0= ruleXCasePart )
            	    // PsiInternalPureXbase.g:3118:5: lv_cases_11_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markComposite(elementTypeProvider.getXSwitchExpression_CasesXCasePartParserRuleCall_4_0ElementType());
            	      				
            	    }
            	    pushFollow(FOLLOW_47);
            	    lv_cases_11_0=ruleXCasePart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneComposite();
            	      					if(!current) {
            	      						associateWithSemanticElement();
            	      						current = true;
            	      					}
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            // PsiInternalPureXbase.g:3131:3: (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==62) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // PsiInternalPureXbase.g:3132:4: otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXSwitchExpression_DefaultKeyword_5_0ElementType());
                      			
                    }
                    otherlv_12=(Token)match(input,62,FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_12);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXSwitchExpression_ColonKeyword_5_1ElementType());
                      			
                    }
                    otherlv_13=(Token)match(input,61,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_13);
                      			
                    }
                    // PsiInternalPureXbase.g:3146:4: ( (lv_default_14_0= ruleXExpression ) )
                    // PsiInternalPureXbase.g:3147:5: (lv_default_14_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:3147:5: (lv_default_14_0= ruleXExpression )
                    // PsiInternalPureXbase.g:3148:6: lv_default_14_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXSwitchExpression_DefaultXExpressionParserRuleCall_5_2_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_48);
                    lv_default_14_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXSwitchExpression_RightCurlyBracketKeyword_6ElementType());
              		
            }
            otherlv_15=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_15);
              		
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
    // $ANTLR end "ruleXSwitchExpression"


    // $ANTLR start "entryRuleXCasePart"
    // PsiInternalPureXbase.g:3173:1: entryRuleXCasePart returns [Boolean current=false] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final Boolean entryRuleXCasePart() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXCasePart = null;


        try {
            // PsiInternalPureXbase.g:3173:51: (iv_ruleXCasePart= ruleXCasePart EOF )
            // PsiInternalPureXbase.g:3174:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXCasePartElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXCasePart"


    // $ANTLR start "ruleXCasePart"
    // PsiInternalPureXbase.g:3180:1: ruleXCasePart returns [Boolean current=false] : ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) ) ;
    public final Boolean ruleXCasePart() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_fallThrough_6_0=null;
        Boolean lv_typeGuard_1_0 = null;

        Boolean lv_case_3_0 = null;

        Boolean lv_then_5_0 = null;


        try {
            // PsiInternalPureXbase.g:3181:1: ( ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) ) )
            // PsiInternalPureXbase.g:3182:2: ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) )
            {
            // PsiInternalPureXbase.g:3182:2: ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) )
            // PsiInternalPureXbase.g:3183:3: () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) )
            {
            // PsiInternalPureXbase.g:3183:3: ()
            // PsiInternalPureXbase.g:3184:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXCasePart_XCasePartAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalPureXbase.g:3190:3: ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==RULE_ID||LA55_0==33||LA55_0==50) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // PsiInternalPureXbase.g:3191:4: (lv_typeGuard_1_0= ruleJvmTypeReference )
                    {
                    // PsiInternalPureXbase.g:3191:4: (lv_typeGuard_1_0= ruleJvmTypeReference )
                    // PsiInternalPureXbase.g:3192:5: lv_typeGuard_1_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getXCasePart_TypeGuardJvmTypeReferenceParserRuleCall_1_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_49);
                    lv_typeGuard_1_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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

            // PsiInternalPureXbase.g:3205:3: (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==63) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // PsiInternalPureXbase.g:3206:4: otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXCasePart_CaseKeyword_2_0ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,63,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }
                    // PsiInternalPureXbase.g:3213:4: ( (lv_case_3_0= ruleXExpression ) )
                    // PsiInternalPureXbase.g:3214:5: (lv_case_3_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:3214:5: (lv_case_3_0= ruleXExpression )
                    // PsiInternalPureXbase.g:3215:6: lv_case_3_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXCasePart_CaseXExpressionParserRuleCall_2_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_50);
                    lv_case_3_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalPureXbase.g:3229:3: ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==61) ) {
                alt57=1;
            }
            else if ( (LA57_0==49) ) {
                alt57=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // PsiInternalPureXbase.g:3230:4: (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) )
                    {
                    // PsiInternalPureXbase.g:3230:4: (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) )
                    // PsiInternalPureXbase.g:3231:5: otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getXCasePart_ColonKeyword_3_0_0ElementType());
                      				
                    }
                    otherlv_4=(Token)match(input,61,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_4);
                      				
                    }
                    // PsiInternalPureXbase.g:3238:5: ( (lv_then_5_0= ruleXExpression ) )
                    // PsiInternalPureXbase.g:3239:6: (lv_then_5_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:3239:6: (lv_then_5_0= ruleXExpression )
                    // PsiInternalPureXbase.g:3240:7: lv_then_5_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getXCasePart_ThenXExpressionParserRuleCall_3_0_1_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    lv_then_5_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:3255:4: ( (lv_fallThrough_6_0= ',' ) )
                    {
                    // PsiInternalPureXbase.g:3255:4: ( (lv_fallThrough_6_0= ',' ) )
                    // PsiInternalPureXbase.g:3256:5: (lv_fallThrough_6_0= ',' )
                    {
                    // PsiInternalPureXbase.g:3256:5: (lv_fallThrough_6_0= ',' )
                    // PsiInternalPureXbase.g:3257:6: lv_fallThrough_6_0= ','
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getXCasePart_FallThroughCommaKeyword_3_1_0ElementType());
                      					
                    }
                    lv_fallThrough_6_0=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_fallThrough_6_0);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleXCasePart"


    // $ANTLR start "entryRuleXForLoopExpression"
    // PsiInternalPureXbase.g:3277:1: entryRuleXForLoopExpression returns [Boolean current=false] : iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
    public final Boolean entryRuleXForLoopExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXForLoopExpression = null;


        try {
            // PsiInternalPureXbase.g:3277:60: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
            // PsiInternalPureXbase.g:3278:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXForLoopExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXForLoopExpression"


    // $ANTLR start "ruleXForLoopExpression"
    // PsiInternalPureXbase.g:3284:1: ruleXForLoopExpression returns [Boolean current=false] : ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) ;
    public final Boolean ruleXForLoopExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_declaredParam_3_0 = null;

        Boolean lv_forExpression_5_0 = null;

        Boolean lv_eachExpression_7_0 = null;


        try {
            // PsiInternalPureXbase.g:3285:1: ( ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) )
            // PsiInternalPureXbase.g:3286:2: ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            {
            // PsiInternalPureXbase.g:3286:2: ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            // PsiInternalPureXbase.g:3287:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) )
            {
            // PsiInternalPureXbase.g:3287:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) )
            // PsiInternalPureXbase.g:3288:4: ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
            {
            // PsiInternalPureXbase.g:3301:4: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
            // PsiInternalPureXbase.g:3302:5: () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':'
            {
            // PsiInternalPureXbase.g:3302:5: ()
            // PsiInternalPureXbase.g:3303:6: 
            {
            if ( state.backtracking==0 ) {

              						precedeComposite(elementTypeProvider.getXForLoopExpression_XForLoopExpressionAction_0_0_0ElementType());
              						doneComposite();
              						associateWithSemanticElement();
              					
            }

            }

            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXForLoopExpression_ForKeyword_0_0_1ElementType());
              				
            }
            otherlv_1=(Token)match(input,64,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(otherlv_1);
              				
            }
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXForLoopExpression_LeftParenthesisKeyword_0_0_2ElementType());
              				
            }
            otherlv_2=(Token)match(input,50,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(otherlv_2);
              				
            }
            // PsiInternalPureXbase.g:3323:5: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
            // PsiInternalPureXbase.g:3324:6: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            {
            // PsiInternalPureXbase.g:3324:6: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            // PsiInternalPureXbase.g:3325:7: lv_declaredParam_3_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {

              							markComposite(elementTypeProvider.getXForLoopExpression_DeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0ElementType());
              						
            }
            pushFollow(FOLLOW_46);
            lv_declaredParam_3_0=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              							doneComposite();
              							if(!current) {
              								associateWithSemanticElement();
              								current = true;
              							}
              						
            }

            }


            }

            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXForLoopExpression_ColonKeyword_0_0_4ElementType());
              				
            }
            otherlv_4=(Token)match(input,61,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(otherlv_4);
              				
            }

            }


            }

            // PsiInternalPureXbase.g:3347:3: ( (lv_forExpression_5_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:3348:4: (lv_forExpression_5_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:3348:4: (lv_forExpression_5_0= ruleXExpression )
            // PsiInternalPureXbase.g:3349:5: lv_forExpression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXForLoopExpression_ForExpressionXExpressionParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_31);
            lv_forExpression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXForLoopExpression_RightParenthesisKeyword_2ElementType());
              		
            }
            otherlv_6=(Token)match(input,51,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_6);
              		
            }
            // PsiInternalPureXbase.g:3369:3: ( (lv_eachExpression_7_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:3370:4: (lv_eachExpression_7_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:3370:4: (lv_eachExpression_7_0= ruleXExpression )
            // PsiInternalPureXbase.g:3371:5: lv_eachExpression_7_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXForLoopExpression_EachExpressionXExpressionParserRuleCall_3_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_eachExpression_7_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXForLoopExpression"


    // $ANTLR start "entryRuleXBasicForLoopExpression"
    // PsiInternalPureXbase.g:3388:1: entryRuleXBasicForLoopExpression returns [Boolean current=false] : iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF ;
    public final Boolean entryRuleXBasicForLoopExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXBasicForLoopExpression = null;


        try {
            // PsiInternalPureXbase.g:3388:65: (iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF )
            // PsiInternalPureXbase.g:3389:2: iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXBasicForLoopExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXBasicForLoopExpression=ruleXBasicForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBasicForLoopExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXBasicForLoopExpression"


    // $ANTLR start "ruleXBasicForLoopExpression"
    // PsiInternalPureXbase.g:3395:1: ruleXBasicForLoopExpression returns [Boolean current=false] : ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) ) ;
    public final Boolean ruleXBasicForLoopExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Boolean lv_initExpressions_3_0 = null;

        Boolean lv_initExpressions_5_0 = null;

        Boolean lv_expression_7_0 = null;

        Boolean lv_updateExpressions_9_0 = null;

        Boolean lv_updateExpressions_11_0 = null;

        Boolean lv_eachExpression_13_0 = null;


        try {
            // PsiInternalPureXbase.g:3396:1: ( ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) ) )
            // PsiInternalPureXbase.g:3397:2: ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) )
            {
            // PsiInternalPureXbase.g:3397:2: ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) )
            // PsiInternalPureXbase.g:3398:3: () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) )
            {
            // PsiInternalPureXbase.g:3398:3: ()
            // PsiInternalPureXbase.g:3399:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXBasicForLoopExpression_XBasicForLoopExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXBasicForLoopExpression_ForKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,64,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXBasicForLoopExpression_LeftParenthesisKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,50,FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalPureXbase.g:3419:3: ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( ((LA59_0>=RULE_STRING && LA59_0<=RULE_ID)||LA59_0==20||(LA59_0>=36 && LA59_0<=37)||LA59_0==42||LA59_0==50||(LA59_0>=52 && LA59_0<=53)||LA59_0==55||LA59_0==58||LA59_0==60||(LA59_0>=64 && LA59_0<=77)||LA59_0==79) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // PsiInternalPureXbase.g:3420:4: ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )*
                    {
                    // PsiInternalPureXbase.g:3420:4: ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) )
                    // PsiInternalPureXbase.g:3421:5: (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration )
                    {
                    // PsiInternalPureXbase.g:3421:5: (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration )
                    // PsiInternalPureXbase.g:3422:6: lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_52);
                    lv_initExpressions_3_0=ruleXExpressionOrVarDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:3435:4: (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==49) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:3436:5: otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getXBasicForLoopExpression_CommaKeyword_3_1_0ElementType());
                    	      				
                    	    }
                    	    otherlv_4=(Token)match(input,49,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_4);
                    	      				
                    	    }
                    	    // PsiInternalPureXbase.g:3443:5: ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) )
                    	    // PsiInternalPureXbase.g:3444:6: (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration )
                    	    {
                    	    // PsiInternalPureXbase.g:3444:6: (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration )
                    	    // PsiInternalPureXbase.g:3445:7: lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getXBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_52);
                    	    lv_initExpressions_5_0=ruleXExpressionOrVarDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      							if(!current) {
                    	      								associateWithSemanticElement();
                    	      								current = true;
                    	      							}
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXBasicForLoopExpression_SemicolonKeyword_4ElementType());
              		
            }
            otherlv_6=(Token)match(input,13,FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_6);
              		
            }
            // PsiInternalPureXbase.g:3467:3: ( (lv_expression_7_0= ruleXExpression ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( ((LA60_0>=RULE_STRING && LA60_0<=RULE_ID)||LA60_0==20||(LA60_0>=36 && LA60_0<=37)||LA60_0==42||LA60_0==50||(LA60_0>=52 && LA60_0<=53)||LA60_0==55||LA60_0==58||LA60_0==60||(LA60_0>=64 && LA60_0<=66)||(LA60_0>=69 && LA60_0<=77)||LA60_0==79) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // PsiInternalPureXbase.g:3468:4: (lv_expression_7_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:3468:4: (lv_expression_7_0= ruleXExpression )
                    // PsiInternalPureXbase.g:3469:5: lv_expression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getXBasicForLoopExpression_ExpressionXExpressionParserRuleCall_5_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_53);
                    lv_expression_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXBasicForLoopExpression_SemicolonKeyword_6ElementType());
              		
            }
            otherlv_8=(Token)match(input,13,FOLLOW_54); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_8);
              		
            }
            // PsiInternalPureXbase.g:3489:3: ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( ((LA62_0>=RULE_STRING && LA62_0<=RULE_ID)||LA62_0==20||(LA62_0>=36 && LA62_0<=37)||LA62_0==42||LA62_0==50||(LA62_0>=52 && LA62_0<=53)||LA62_0==55||LA62_0==58||LA62_0==60||(LA62_0>=64 && LA62_0<=66)||(LA62_0>=69 && LA62_0<=77)||LA62_0==79) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // PsiInternalPureXbase.g:3490:4: ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )*
                    {
                    // PsiInternalPureXbase.g:3490:4: ( (lv_updateExpressions_9_0= ruleXExpression ) )
                    // PsiInternalPureXbase.g:3491:5: (lv_updateExpressions_9_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:3491:5: (lv_updateExpressions_9_0= ruleXExpression )
                    // PsiInternalPureXbase.g:3492:6: lv_updateExpressions_9_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_0_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_32);
                    lv_updateExpressions_9_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:3505:4: (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==49) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:3506:5: otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getXBasicForLoopExpression_CommaKeyword_7_1_0ElementType());
                    	      				
                    	    }
                    	    otherlv_10=(Token)match(input,49,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_10);
                    	      				
                    	    }
                    	    // PsiInternalPureXbase.g:3513:5: ( (lv_updateExpressions_11_0= ruleXExpression ) )
                    	    // PsiInternalPureXbase.g:3514:6: (lv_updateExpressions_11_0= ruleXExpression )
                    	    {
                    	    // PsiInternalPureXbase.g:3514:6: (lv_updateExpressions_11_0= ruleXExpression )
                    	    // PsiInternalPureXbase.g:3515:7: lv_updateExpressions_11_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getXBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_1_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_32);
                    	    lv_updateExpressions_11_0=ruleXExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      							if(!current) {
                    	      								associateWithSemanticElement();
                    	      								current = true;
                    	      							}
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop61;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXBasicForLoopExpression_RightParenthesisKeyword_8ElementType());
              		
            }
            otherlv_12=(Token)match(input,51,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_12);
              		
            }
            // PsiInternalPureXbase.g:3537:3: ( (lv_eachExpression_13_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:3538:4: (lv_eachExpression_13_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:3538:4: (lv_eachExpression_13_0= ruleXExpression )
            // PsiInternalPureXbase.g:3539:5: lv_eachExpression_13_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXBasicForLoopExpression_EachExpressionXExpressionParserRuleCall_9_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_eachExpression_13_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXBasicForLoopExpression"


    // $ANTLR start "entryRuleXWhileExpression"
    // PsiInternalPureXbase.g:3556:1: entryRuleXWhileExpression returns [Boolean current=false] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final Boolean entryRuleXWhileExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXWhileExpression = null;


        try {
            // PsiInternalPureXbase.g:3556:58: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // PsiInternalPureXbase.g:3557:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXWhileExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXWhileExpression=ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXWhileExpression"


    // $ANTLR start "ruleXWhileExpression"
    // PsiInternalPureXbase.g:3563:1: ruleXWhileExpression returns [Boolean current=false] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) ;
    public final Boolean ruleXWhileExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_predicate_3_0 = null;

        Boolean lv_body_5_0 = null;


        try {
            // PsiInternalPureXbase.g:3564:1: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) )
            // PsiInternalPureXbase.g:3565:2: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            {
            // PsiInternalPureXbase.g:3565:2: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            // PsiInternalPureXbase.g:3566:3: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) )
            {
            // PsiInternalPureXbase.g:3566:3: ()
            // PsiInternalPureXbase.g:3567:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXWhileExpression_XWhileExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXWhileExpression_WhileKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,65,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXWhileExpression_LeftParenthesisKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,50,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalPureXbase.g:3587:3: ( (lv_predicate_3_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:3588:4: (lv_predicate_3_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:3588:4: (lv_predicate_3_0= ruleXExpression )
            // PsiInternalPureXbase.g:3589:5: lv_predicate_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXWhileExpression_PredicateXExpressionParserRuleCall_3_0ElementType());
              				
            }
            pushFollow(FOLLOW_31);
            lv_predicate_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXWhileExpression_RightParenthesisKeyword_4ElementType());
              		
            }
            otherlv_4=(Token)match(input,51,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
            }
            // PsiInternalPureXbase.g:3609:3: ( (lv_body_5_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:3610:4: (lv_body_5_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:3610:4: (lv_body_5_0= ruleXExpression )
            // PsiInternalPureXbase.g:3611:5: lv_body_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXWhileExpression_BodyXExpressionParserRuleCall_5_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXWhileExpression"


    // $ANTLR start "entryRuleXDoWhileExpression"
    // PsiInternalPureXbase.g:3628:1: entryRuleXDoWhileExpression returns [Boolean current=false] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final Boolean entryRuleXDoWhileExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXDoWhileExpression = null;


        try {
            // PsiInternalPureXbase.g:3628:60: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // PsiInternalPureXbase.g:3629:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXDoWhileExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXDoWhileExpression"


    // $ANTLR start "ruleXDoWhileExpression"
    // PsiInternalPureXbase.g:3635:1: ruleXDoWhileExpression returns [Boolean current=false] : ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) ;
    public final Boolean ruleXDoWhileExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_body_2_0 = null;

        Boolean lv_predicate_5_0 = null;


        try {
            // PsiInternalPureXbase.g:3636:1: ( ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) )
            // PsiInternalPureXbase.g:3637:2: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            {
            // PsiInternalPureXbase.g:3637:2: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            // PsiInternalPureXbase.g:3638:3: () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')'
            {
            // PsiInternalPureXbase.g:3638:3: ()
            // PsiInternalPureXbase.g:3639:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXDoWhileExpression_XDoWhileExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXDoWhileExpression_DoKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,66,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalPureXbase.g:3652:3: ( (lv_body_2_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:3653:4: (lv_body_2_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:3653:4: (lv_body_2_0= ruleXExpression )
            // PsiInternalPureXbase.g:3654:5: lv_body_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXDoWhileExpression_BodyXExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_55);
            lv_body_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXDoWhileExpression_WhileKeyword_3ElementType());
              		
            }
            otherlv_3=(Token)match(input,65,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_3);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXDoWhileExpression_LeftParenthesisKeyword_4ElementType());
              		
            }
            otherlv_4=(Token)match(input,50,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
            }
            // PsiInternalPureXbase.g:3681:3: ( (lv_predicate_5_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:3682:4: (lv_predicate_5_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:3682:4: (lv_predicate_5_0= ruleXExpression )
            // PsiInternalPureXbase.g:3683:5: lv_predicate_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXDoWhileExpression_PredicateXExpressionParserRuleCall_5_0ElementType());
              				
            }
            pushFollow(FOLLOW_31);
            lv_predicate_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXDoWhileExpression_RightParenthesisKeyword_6ElementType());
              		
            }
            otherlv_6=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_6);
              		
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
    // $ANTLR end "ruleXDoWhileExpression"


    // $ANTLR start "entryRuleXBlockExpression"
    // PsiInternalPureXbase.g:3707:1: entryRuleXBlockExpression returns [Boolean current=false] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final Boolean entryRuleXBlockExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXBlockExpression = null;


        try {
            // PsiInternalPureXbase.g:3707:58: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // PsiInternalPureXbase.g:3708:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXBlockExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXBlockExpression=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXBlockExpression"


    // $ANTLR start "ruleXBlockExpression"
    // PsiInternalPureXbase.g:3714:1: ruleXBlockExpression returns [Boolean current=false] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final Boolean ruleXBlockExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Boolean lv_expressions_2_0 = null;


        try {
            // PsiInternalPureXbase.g:3715:1: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // PsiInternalPureXbase.g:3716:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // PsiInternalPureXbase.g:3716:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // PsiInternalPureXbase.g:3717:3: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // PsiInternalPureXbase.g:3717:3: ()
            // PsiInternalPureXbase.g:3718:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXBlockExpression_XBlockExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXBlockExpression_LeftCurlyBracketKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,53,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalPureXbase.g:3731:3: ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( ((LA64_0>=RULE_STRING && LA64_0<=RULE_ID)||LA64_0==20||(LA64_0>=36 && LA64_0<=37)||LA64_0==42||LA64_0==50||(LA64_0>=52 && LA64_0<=53)||LA64_0==55||LA64_0==58||LA64_0==60||(LA64_0>=64 && LA64_0<=77)||LA64_0==79) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // PsiInternalPureXbase.g:3732:4: ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )?
            	    {
            	    // PsiInternalPureXbase.g:3732:4: ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) )
            	    // PsiInternalPureXbase.g:3733:5: (lv_expressions_2_0= ruleXExpressionOrVarDeclaration )
            	    {
            	    // PsiInternalPureXbase.g:3733:5: (lv_expressions_2_0= ruleXExpressionOrVarDeclaration )
            	    // PsiInternalPureXbase.g:3734:6: lv_expressions_2_0= ruleXExpressionOrVarDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXBlockExpression_ExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_56);
            	    lv_expressions_2_0=ruleXExpressionOrVarDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }

            	    // PsiInternalPureXbase.g:3747:4: (otherlv_3= ';' )?
            	    int alt63=2;
            	    int LA63_0 = input.LA(1);

            	    if ( (LA63_0==13) ) {
            	        alt63=1;
            	    }
            	    switch (alt63) {
            	        case 1 :
            	            // PsiInternalPureXbase.g:3748:5: otherlv_3= ';'
            	            {
            	            if ( state.backtracking==0 ) {

            	              					markLeaf(elementTypeProvider.getXBlockExpression_SemicolonKeyword_2_1ElementType());
            	              				
            	            }
            	            otherlv_3=(Token)match(input,13,FOLLOW_35); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              					doneLeaf(otherlv_3);
            	              				
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXBlockExpression_RightCurlyBracketKeyword_3ElementType());
              		
            }
            otherlv_4=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
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
    // $ANTLR end "ruleXBlockExpression"


    // $ANTLR start "entryRuleXExpressionOrVarDeclaration"
    // PsiInternalPureXbase.g:3768:1: entryRuleXExpressionOrVarDeclaration returns [Boolean current=false] : iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF ;
    public final Boolean entryRuleXExpressionOrVarDeclaration() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXExpressionOrVarDeclaration = null;


        try {
            // PsiInternalPureXbase.g:3768:69: (iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF )
            // PsiInternalPureXbase.g:3769:2: iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXExpressionOrVarDeclarationElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXExpressionOrVarDeclaration=ruleXExpressionOrVarDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionOrVarDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXExpressionOrVarDeclaration"


    // $ANTLR start "ruleXExpressionOrVarDeclaration"
    // PsiInternalPureXbase.g:3775:1: ruleXExpressionOrVarDeclaration returns [Boolean current=false] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final Boolean ruleXExpressionOrVarDeclaration() throws RecognitionException {
        Boolean current = false;

        Boolean this_XVariableDeclaration_0 = null;

        Boolean this_XExpression_1 = null;


        try {
            // PsiInternalPureXbase.g:3776:1: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // PsiInternalPureXbase.g:3777:2: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // PsiInternalPureXbase.g:3777:2: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( ((LA65_0>=67 && LA65_0<=68)) ) {
                alt65=1;
            }
            else if ( ((LA65_0>=RULE_STRING && LA65_0<=RULE_ID)||LA65_0==20||(LA65_0>=36 && LA65_0<=37)||LA65_0==42||LA65_0==50||(LA65_0>=52 && LA65_0<=53)||LA65_0==55||LA65_0==58||LA65_0==60||(LA65_0>=64 && LA65_0<=66)||(LA65_0>=69 && LA65_0<=77)||LA65_0==79) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // PsiInternalPureXbase.g:3778:3: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXExpressionOrVarDeclaration_XVariableDeclarationParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XVariableDeclaration_0=ruleXVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XVariableDeclaration_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:3787:3: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXExpressionOrVarDeclaration_XExpressionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XExpression_1=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XExpression_1;
                      			doneComposite();
                      		
                    }

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
    // $ANTLR end "ruleXExpressionOrVarDeclaration"


    // $ANTLR start "entryRuleXVariableDeclaration"
    // PsiInternalPureXbase.g:3799:1: entryRuleXVariableDeclaration returns [Boolean current=false] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final Boolean entryRuleXVariableDeclaration() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXVariableDeclaration = null;


        try {
            // PsiInternalPureXbase.g:3799:62: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // PsiInternalPureXbase.g:3800:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXVariableDeclarationElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXVariableDeclaration"


    // $ANTLR start "ruleXVariableDeclaration"
    // PsiInternalPureXbase.g:3806:1: ruleXVariableDeclaration returns [Boolean current=false] : ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) ;
    public final Boolean ruleXVariableDeclaration() throws RecognitionException {
        Boolean current = false;

        Token lv_writeable_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        Boolean lv_type_3_0 = null;

        Boolean lv_name_4_0 = null;

        Boolean lv_name_5_0 = null;

        Boolean lv_right_7_0 = null;


        try {
            // PsiInternalPureXbase.g:3807:1: ( ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) )
            // PsiInternalPureXbase.g:3808:2: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            {
            // PsiInternalPureXbase.g:3808:2: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            // PsiInternalPureXbase.g:3809:3: () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            {
            // PsiInternalPureXbase.g:3809:3: ()
            // PsiInternalPureXbase.g:3810:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXVariableDeclaration_XVariableDeclarationAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalPureXbase.g:3816:3: ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==67) ) {
                alt66=1;
            }
            else if ( (LA66_0==68) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // PsiInternalPureXbase.g:3817:4: ( (lv_writeable_1_0= 'var' ) )
                    {
                    // PsiInternalPureXbase.g:3817:4: ( (lv_writeable_1_0= 'var' ) )
                    // PsiInternalPureXbase.g:3818:5: (lv_writeable_1_0= 'var' )
                    {
                    // PsiInternalPureXbase.g:3818:5: (lv_writeable_1_0= 'var' )
                    // PsiInternalPureXbase.g:3819:6: lv_writeable_1_0= 'var'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getXVariableDeclaration_WriteableVarKeyword_1_0_0ElementType());
                      					
                    }
                    lv_writeable_1_0=(Token)match(input,67,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_writeable_1_0);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:3835:4: otherlv_2= 'val'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXVariableDeclaration_ValKeyword_1_1ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,68,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalPureXbase.g:3843:3: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==RULE_ID) ) {
                int LA67_1 = input.LA(2);

                if ( (synpred29_PsiInternalPureXbase()) ) {
                    alt67=1;
                }
                else if ( (true) ) {
                    alt67=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 67, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA67_0==50) && (synpred29_PsiInternalPureXbase())) {
                alt67=1;
            }
            else if ( (LA67_0==33) && (synpred29_PsiInternalPureXbase())) {
                alt67=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // PsiInternalPureXbase.g:3844:4: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    {
                    // PsiInternalPureXbase.g:3844:4: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    // PsiInternalPureXbase.g:3845:5: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    {
                    // PsiInternalPureXbase.g:3858:5: ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    // PsiInternalPureXbase.g:3859:6: ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) )
                    {
                    // PsiInternalPureXbase.g:3859:6: ( (lv_type_3_0= ruleJvmTypeReference ) )
                    // PsiInternalPureXbase.g:3860:7: (lv_type_3_0= ruleJvmTypeReference )
                    {
                    // PsiInternalPureXbase.g:3860:7: (lv_type_3_0= ruleJvmTypeReference )
                    // PsiInternalPureXbase.g:3861:8: lv_type_3_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getXVariableDeclaration_TypeJvmTypeReferenceParserRuleCall_2_0_0_0_0ElementType());
                      							
                    }
                    pushFollow(FOLLOW_25);
                    lv_type_3_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								doneComposite();
                      								if(!current) {
                      									associateWithSemanticElement();
                      									current = true;
                      								}
                      							
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:3874:6: ( (lv_name_4_0= ruleValidID ) )
                    // PsiInternalPureXbase.g:3875:7: (lv_name_4_0= ruleValidID )
                    {
                    // PsiInternalPureXbase.g:3875:7: (lv_name_4_0= ruleValidID )
                    // PsiInternalPureXbase.g:3876:8: lv_name_4_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getXVariableDeclaration_NameValidIDParserRuleCall_2_0_0_1_0ElementType());
                      							
                    }
                    pushFollow(FOLLOW_57);
                    lv_name_4_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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


                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:3892:4: ( (lv_name_5_0= ruleValidID ) )
                    {
                    // PsiInternalPureXbase.g:3892:4: ( (lv_name_5_0= ruleValidID ) )
                    // PsiInternalPureXbase.g:3893:5: (lv_name_5_0= ruleValidID )
                    {
                    // PsiInternalPureXbase.g:3893:5: (lv_name_5_0= ruleValidID )
                    // PsiInternalPureXbase.g:3894:6: lv_name_5_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXVariableDeclaration_NameValidIDParserRuleCall_2_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_57);
                    lv_name_5_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalPureXbase.g:3908:3: (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==14) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // PsiInternalPureXbase.g:3909:4: otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXVariableDeclaration_EqualsSignKeyword_3_0ElementType());
                      			
                    }
                    otherlv_6=(Token)match(input,14,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_6);
                      			
                    }
                    // PsiInternalPureXbase.g:3916:4: ( (lv_right_7_0= ruleXExpression ) )
                    // PsiInternalPureXbase.g:3917:5: (lv_right_7_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:3917:5: (lv_right_7_0= ruleXExpression )
                    // PsiInternalPureXbase.g:3918:6: lv_right_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXVariableDeclaration_RightXExpressionParserRuleCall_3_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleXVariableDeclaration"


    // $ANTLR start "entryRuleJvmFormalParameter"
    // PsiInternalPureXbase.g:3936:1: entryRuleJvmFormalParameter returns [Boolean current=false] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final Boolean entryRuleJvmFormalParameter() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJvmFormalParameter = null;


        try {
            // PsiInternalPureXbase.g:3936:60: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // PsiInternalPureXbase.g:3937:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmFormalParameterElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmFormalParameter"


    // $ANTLR start "ruleJvmFormalParameter"
    // PsiInternalPureXbase.g:3943:1: ruleJvmFormalParameter returns [Boolean current=false] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final Boolean ruleJvmFormalParameter() throws RecognitionException {
        Boolean current = false;

        Boolean lv_parameterType_0_0 = null;

        Boolean lv_name_1_0 = null;


        try {
            // PsiInternalPureXbase.g:3944:1: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) )
            // PsiInternalPureXbase.g:3945:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            {
            // PsiInternalPureXbase.g:3945:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            // PsiInternalPureXbase.g:3946:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) )
            {
            // PsiInternalPureXbase.g:3946:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_ID) ) {
                int LA69_1 = input.LA(2);

                if ( (LA69_1==RULE_ID||LA69_1==20||LA69_1==46||LA69_1==55) ) {
                    alt69=1;
                }
            }
            else if ( (LA69_0==33||LA69_0==50) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // PsiInternalPureXbase.g:3947:4: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // PsiInternalPureXbase.g:3947:4: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // PsiInternalPureXbase.g:3948:5: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getJvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_0_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_25);
                    lv_parameterType_0_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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

            // PsiInternalPureXbase.g:3961:3: ( (lv_name_1_0= ruleValidID ) )
            // PsiInternalPureXbase.g:3962:4: (lv_name_1_0= ruleValidID )
            {
            // PsiInternalPureXbase.g:3962:4: (lv_name_1_0= ruleValidID )
            // PsiInternalPureXbase.g:3963:5: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmFormalParameter_NameValidIDParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmFormalParameter"


    // $ANTLR start "entryRuleFullJvmFormalParameter"
    // PsiInternalPureXbase.g:3980:1: entryRuleFullJvmFormalParameter returns [Boolean current=false] : iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF ;
    public final Boolean entryRuleFullJvmFormalParameter() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFullJvmFormalParameter = null;


        try {
            // PsiInternalPureXbase.g:3980:64: (iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF )
            // PsiInternalPureXbase.g:3981:2: iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFullJvmFormalParameterElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFullJvmFormalParameter=ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFullJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFullJvmFormalParameter"


    // $ANTLR start "ruleFullJvmFormalParameter"
    // PsiInternalPureXbase.g:3987:1: ruleFullJvmFormalParameter returns [Boolean current=false] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final Boolean ruleFullJvmFormalParameter() throws RecognitionException {
        Boolean current = false;

        Boolean lv_parameterType_0_0 = null;

        Boolean lv_name_1_0 = null;


        try {
            // PsiInternalPureXbase.g:3988:1: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) )
            // PsiInternalPureXbase.g:3989:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            {
            // PsiInternalPureXbase.g:3989:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            // PsiInternalPureXbase.g:3990:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) )
            {
            // PsiInternalPureXbase.g:3990:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )
            // PsiInternalPureXbase.g:3991:4: (lv_parameterType_0_0= ruleJvmTypeReference )
            {
            // PsiInternalPureXbase.g:3991:4: (lv_parameterType_0_0= ruleJvmTypeReference )
            // PsiInternalPureXbase.g:3992:5: lv_parameterType_0_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getFullJvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FOLLOW_25);
            lv_parameterType_0_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            // PsiInternalPureXbase.g:4005:3: ( (lv_name_1_0= ruleValidID ) )
            // PsiInternalPureXbase.g:4006:4: (lv_name_1_0= ruleValidID )
            {
            // PsiInternalPureXbase.g:4006:4: (lv_name_1_0= ruleValidID )
            // PsiInternalPureXbase.g:4007:5: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getFullJvmFormalParameter_NameValidIDParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFullJvmFormalParameter"


    // $ANTLR start "entryRuleXFeatureCall"
    // PsiInternalPureXbase.g:4024:1: entryRuleXFeatureCall returns [Boolean current=false] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final Boolean entryRuleXFeatureCall() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXFeatureCall = null;


        try {
            // PsiInternalPureXbase.g:4024:54: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // PsiInternalPureXbase.g:4025:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXFeatureCallElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXFeatureCall"


    // $ANTLR start "ruleXFeatureCall"
    // PsiInternalPureXbase.g:4031:1: ruleXFeatureCall returns [Boolean current=false] : ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? ) ;
    public final Boolean ruleXFeatureCall() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_explicitOperationCall_7_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Boolean lv_typeArguments_2_0 = null;

        Boolean lv_typeArguments_4_0 = null;

        Boolean lv_featureCallArguments_8_0 = null;

        Boolean lv_featureCallArguments_9_0 = null;

        Boolean lv_featureCallArguments_11_0 = null;

        Boolean lv_featureCallArguments_13_0 = null;


        try {
            // PsiInternalPureXbase.g:4032:1: ( ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? ) )
            // PsiInternalPureXbase.g:4033:2: ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? )
            {
            // PsiInternalPureXbase.g:4033:2: ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? )
            // PsiInternalPureXbase.g:4034:3: () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?
            {
            // PsiInternalPureXbase.g:4034:3: ()
            // PsiInternalPureXbase.g:4035:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXFeatureCall_XFeatureCallAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalPureXbase.g:4041:3: (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==20) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // PsiInternalPureXbase.g:4042:4: otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXFeatureCall_LessThanSignKeyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,20,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }
                    // PsiInternalPureXbase.g:4049:4: ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) )
                    // PsiInternalPureXbase.g:4050:5: (lv_typeArguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // PsiInternalPureXbase.g:4050:5: (lv_typeArguments_2_0= ruleJvmArgumentTypeReference )
                    // PsiInternalPureXbase.g:4051:6: lv_typeArguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_28);
                    lv_typeArguments_2_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:4064:4: (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==49) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:4065:5: otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getXFeatureCall_CommaKeyword_1_2_0ElementType());
                    	      				
                    	    }
                    	    otherlv_3=(Token)match(input,49,FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_3);
                    	      				
                    	    }
                    	    // PsiInternalPureXbase.g:4072:5: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // PsiInternalPureXbase.g:4073:6: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // PsiInternalPureXbase.g:4073:6: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    	    // PsiInternalPureXbase.g:4074:7: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getXFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_28);
                    	    lv_typeArguments_4_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      							if(!current) {
                    	      								associateWithSemanticElement();
                    	      								current = true;
                    	      							}
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop70;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXFeatureCall_GreaterThanSignKeyword_1_3ElementType());
                      			
                    }
                    otherlv_5=(Token)match(input,21,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_5);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalPureXbase.g:4096:3: ( ( ruleIdOrSuper ) )
            // PsiInternalPureXbase.g:4097:4: ( ruleIdOrSuper )
            {
            // PsiInternalPureXbase.g:4097:4: ( ruleIdOrSuper )
            // PsiInternalPureXbase.g:4098:5: ruleIdOrSuper
            {
            if ( state.backtracking==0 ) {

              					if (!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXFeatureCall_FeatureJvmIdentifiableElementCrossReference_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_58);
            ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // PsiInternalPureXbase.g:4113:3: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )?
            int alt74=2;
            alt74 = dfa74.predict(input);
            switch (alt74) {
                case 1 :
                    // PsiInternalPureXbase.g:4114:4: ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')'
                    {
                    // PsiInternalPureXbase.g:4114:4: ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) )
                    // PsiInternalPureXbase.g:4115:5: ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' )
                    {
                    // PsiInternalPureXbase.g:4119:5: (lv_explicitOperationCall_7_0= '(' )
                    // PsiInternalPureXbase.g:4120:6: lv_explicitOperationCall_7_0= '('
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getXFeatureCall_ExplicitOperationCallLeftParenthesisKeyword_3_0_0ElementType());
                      					
                    }
                    lv_explicitOperationCall_7_0=(Token)match(input,50,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_explicitOperationCall_7_0);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:4135:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )?
                    int alt73=3;
                    alt73 = dfa73.predict(input);
                    switch (alt73) {
                        case 1 :
                            // PsiInternalPureXbase.g:4136:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) )
                            {
                            // PsiInternalPureXbase.g:4136:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) )
                            // PsiInternalPureXbase.g:4137:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure )
                            {
                            // PsiInternalPureXbase.g:4162:6: (lv_featureCallArguments_8_0= ruleXShortClosure )
                            // PsiInternalPureXbase.g:4163:7: lv_featureCallArguments_8_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {

                              							markComposite(elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0ElementType());
                              						
                            }
                            pushFollow(FOLLOW_31);
                            lv_featureCallArguments_8_0=ruleXShortClosure();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneComposite();
                              							if(!current) {
                              								associateWithSemanticElement();
                              								current = true;
                              							}
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalPureXbase.g:4177:5: ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* )
                            {
                            // PsiInternalPureXbase.g:4177:5: ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* )
                            // PsiInternalPureXbase.g:4178:6: ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )*
                            {
                            // PsiInternalPureXbase.g:4178:6: ( (lv_featureCallArguments_9_0= ruleXExpression ) )
                            // PsiInternalPureXbase.g:4179:7: (lv_featureCallArguments_9_0= ruleXExpression )
                            {
                            // PsiInternalPureXbase.g:4179:7: (lv_featureCallArguments_9_0= ruleXExpression )
                            // PsiInternalPureXbase.g:4180:8: lv_featureCallArguments_9_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0ElementType());
                              							
                            }
                            pushFollow(FOLLOW_32);
                            lv_featureCallArguments_9_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              								if(!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }

                            }


                            }

                            // PsiInternalPureXbase.g:4193:6: (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )*
                            loop72:
                            do {
                                int alt72=2;
                                int LA72_0 = input.LA(1);

                                if ( (LA72_0==49) ) {
                                    alt72=1;
                                }


                                switch (alt72) {
                            	case 1 :
                            	    // PsiInternalPureXbase.g:4194:7: otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) )
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      							markLeaf(elementTypeProvider.getXFeatureCall_CommaKeyword_3_1_1_1_0ElementType());
                            	      						
                            	    }
                            	    otherlv_10=(Token)match(input,49,FOLLOW_3); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							doneLeaf(otherlv_10);
                            	      						
                            	    }
                            	    // PsiInternalPureXbase.g:4201:7: ( (lv_featureCallArguments_11_0= ruleXExpression ) )
                            	    // PsiInternalPureXbase.g:4202:8: (lv_featureCallArguments_11_0= ruleXExpression )
                            	    {
                            	    // PsiInternalPureXbase.g:4202:8: (lv_featureCallArguments_11_0= ruleXExpression )
                            	    // PsiInternalPureXbase.g:4203:9: lv_featureCallArguments_11_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									markComposite(elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0ElementType());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_32);
                            	    lv_featureCallArguments_11_0=ruleXExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									doneComposite();
                            	      									if(!current) {
                            	      										associateWithSemanticElement();
                            	      										current = true;
                            	      									}
                            	      								
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop72;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXFeatureCall_RightParenthesisKeyword_3_2ElementType());
                      			
                    }
                    otherlv_12=(Token)match(input,51,FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_12);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalPureXbase.g:4227:3: ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?
            int alt75=2;
            alt75 = dfa75.predict(input);
            switch (alt75) {
                case 1 :
                    // PsiInternalPureXbase.g:4228:4: ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure )
                    {
                    // PsiInternalPureXbase.g:4234:4: (lv_featureCallArguments_13_0= ruleXClosure )
                    // PsiInternalPureXbase.g:4235:5: lv_featureCallArguments_13_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXClosureParserRuleCall_4_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_featureCallArguments_13_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleXFeatureCall"


    // $ANTLR start "entryRuleIdOrSuper"
    // PsiInternalPureXbase.g:4252:1: entryRuleIdOrSuper returns [Boolean current=false] : iv_ruleIdOrSuper= ruleIdOrSuper EOF ;
    public final Boolean entryRuleIdOrSuper() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleIdOrSuper = null;


        try {
            // PsiInternalPureXbase.g:4252:51: (iv_ruleIdOrSuper= ruleIdOrSuper EOF )
            // PsiInternalPureXbase.g:4253:2: iv_ruleIdOrSuper= ruleIdOrSuper EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getIdOrSuperElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIdOrSuper=ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrSuper; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleIdOrSuper"


    // $ANTLR start "ruleIdOrSuper"
    // PsiInternalPureXbase.g:4259:1: ruleIdOrSuper returns [Boolean current=false] : ( ruleFeatureCallID | kw= 'super' ) ;
    public final Boolean ruleIdOrSuper() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalPureXbase.g:4260:1: ( ( ruleFeatureCallID | kw= 'super' ) )
            // PsiInternalPureXbase.g:4261:2: ( ruleFeatureCallID | kw= 'super' )
            {
            // PsiInternalPureXbase.g:4261:2: ( ruleFeatureCallID | kw= 'super' )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_ID) ) {
                alt76=1;
            }
            else if ( (LA76_0==69) ) {
                alt76=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // PsiInternalPureXbase.g:4262:3: ruleFeatureCallID
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getIdOrSuper_FeatureCallIDParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleFeatureCallID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:4270:3: kw= 'super'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getIdOrSuper_SuperKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

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
    // $ANTLR end "ruleIdOrSuper"


    // $ANTLR start "entryRuleXConstructorCall"
    // PsiInternalPureXbase.g:4281:1: entryRuleXConstructorCall returns [Boolean current=false] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final Boolean entryRuleXConstructorCall() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXConstructorCall = null;


        try {
            // PsiInternalPureXbase.g:4281:58: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // PsiInternalPureXbase.g:4282:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXConstructorCallElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXConstructorCall=ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXConstructorCall"


    // $ANTLR start "ruleXConstructorCall"
    // PsiInternalPureXbase.g:4288:1: ruleXConstructorCall returns [Boolean current=false] : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) ;
    public final Boolean ruleXConstructorCall() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_explicitConstructorCall_8_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Boolean lv_typeArguments_4_0 = null;

        Boolean lv_typeArguments_6_0 = null;

        Boolean lv_arguments_9_0 = null;

        Boolean lv_arguments_10_0 = null;

        Boolean lv_arguments_12_0 = null;

        Boolean lv_arguments_14_0 = null;


        try {
            // PsiInternalPureXbase.g:4289:1: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) )
            // PsiInternalPureXbase.g:4290:2: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            {
            // PsiInternalPureXbase.g:4290:2: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            // PsiInternalPureXbase.g:4291:3: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            {
            // PsiInternalPureXbase.g:4291:3: ()
            // PsiInternalPureXbase.g:4292:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXConstructorCall_XConstructorCallAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXConstructorCall_NewKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,70,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalPureXbase.g:4305:3: ( ( ruleQualifiedName ) )
            // PsiInternalPureXbase.g:4306:4: ( ruleQualifiedName )
            {
            // PsiInternalPureXbase.g:4306:4: ( ruleQualifiedName )
            // PsiInternalPureXbase.g:4307:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					if (!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXConstructorCall_ConstructorJvmConstructorCrossReference_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_60);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // PsiInternalPureXbase.g:4322:3: ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
            int alt78=2;
            alt78 = dfa78.predict(input);
            switch (alt78) {
                case 1 :
                    // PsiInternalPureXbase.g:4323:4: ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
                    {
                    // PsiInternalPureXbase.g:4323:4: ( ( '<' )=>otherlv_3= '<' )
                    // PsiInternalPureXbase.g:4324:5: ( '<' )=>otherlv_3= '<'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getXConstructorCall_LessThanSignKeyword_3_0ElementType());
                      				
                    }
                    otherlv_3=(Token)match(input,20,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_3);
                      				
                    }

                    }

                    // PsiInternalPureXbase.g:4333:4: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    // PsiInternalPureXbase.g:4334:5: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    {
                    // PsiInternalPureXbase.g:4334:5: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    // PsiInternalPureXbase.g:4335:6: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_28);
                    lv_typeArguments_4_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:4348:4: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( (LA77_0==49) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:4349:5: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getXConstructorCall_CommaKeyword_3_2_0ElementType());
                    	      				
                    	    }
                    	    otherlv_5=(Token)match(input,49,FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_5);
                    	      				
                    	    }
                    	    // PsiInternalPureXbase.g:4356:5: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    // PsiInternalPureXbase.g:4357:6: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // PsiInternalPureXbase.g:4357:6: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    // PsiInternalPureXbase.g:4358:7: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getXConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_28);
                    	    lv_typeArguments_6_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      							if(!current) {
                    	      								associateWithSemanticElement();
                    	      								current = true;
                    	      							}
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop77;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXConstructorCall_GreaterThanSignKeyword_3_3ElementType());
                      			
                    }
                    otherlv_7=(Token)match(input,21,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_7);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalPureXbase.g:4380:3: ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            int alt81=2;
            alt81 = dfa81.predict(input);
            switch (alt81) {
                case 1 :
                    // PsiInternalPureXbase.g:4381:4: ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
                    {
                    // PsiInternalPureXbase.g:4381:4: ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) )
                    // PsiInternalPureXbase.g:4382:5: ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' )
                    {
                    // PsiInternalPureXbase.g:4386:5: (lv_explicitConstructorCall_8_0= '(' )
                    // PsiInternalPureXbase.g:4387:6: lv_explicitConstructorCall_8_0= '('
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getXConstructorCall_ExplicitConstructorCallLeftParenthesisKeyword_4_0_0ElementType());
                      					
                    }
                    lv_explicitConstructorCall_8_0=(Token)match(input,50,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_explicitConstructorCall_8_0);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:4402:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?
                    int alt80=3;
                    alt80 = dfa80.predict(input);
                    switch (alt80) {
                        case 1 :
                            // PsiInternalPureXbase.g:4403:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                            {
                            // PsiInternalPureXbase.g:4403:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                            // PsiInternalPureXbase.g:4404:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure )
                            {
                            // PsiInternalPureXbase.g:4429:6: (lv_arguments_9_0= ruleXShortClosure )
                            // PsiInternalPureXbase.g:4430:7: lv_arguments_9_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {

                              							markComposite(elementTypeProvider.getXConstructorCall_ArgumentsXShortClosureParserRuleCall_4_1_0_0ElementType());
                              						
                            }
                            pushFollow(FOLLOW_31);
                            lv_arguments_9_0=ruleXShortClosure();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneComposite();
                              							if(!current) {
                              								associateWithSemanticElement();
                              								current = true;
                              							}
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalPureXbase.g:4444:5: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                            {
                            // PsiInternalPureXbase.g:4444:5: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                            // PsiInternalPureXbase.g:4445:6: ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                            {
                            // PsiInternalPureXbase.g:4445:6: ( (lv_arguments_10_0= ruleXExpression ) )
                            // PsiInternalPureXbase.g:4446:7: (lv_arguments_10_0= ruleXExpression )
                            {
                            // PsiInternalPureXbase.g:4446:7: (lv_arguments_10_0= ruleXExpression )
                            // PsiInternalPureXbase.g:4447:8: lv_arguments_10_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getXConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_0_0ElementType());
                              							
                            }
                            pushFollow(FOLLOW_32);
                            lv_arguments_10_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              								if(!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }

                            }


                            }

                            // PsiInternalPureXbase.g:4460:6: (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                            loop79:
                            do {
                                int alt79=2;
                                int LA79_0 = input.LA(1);

                                if ( (LA79_0==49) ) {
                                    alt79=1;
                                }


                                switch (alt79) {
                            	case 1 :
                            	    // PsiInternalPureXbase.g:4461:7: otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) )
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      							markLeaf(elementTypeProvider.getXConstructorCall_CommaKeyword_4_1_1_1_0ElementType());
                            	      						
                            	    }
                            	    otherlv_11=(Token)match(input,49,FOLLOW_3); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							doneLeaf(otherlv_11);
                            	      						
                            	    }
                            	    // PsiInternalPureXbase.g:4468:7: ( (lv_arguments_12_0= ruleXExpression ) )
                            	    // PsiInternalPureXbase.g:4469:8: (lv_arguments_12_0= ruleXExpression )
                            	    {
                            	    // PsiInternalPureXbase.g:4469:8: (lv_arguments_12_0= ruleXExpression )
                            	    // PsiInternalPureXbase.g:4470:9: lv_arguments_12_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									markComposite(elementTypeProvider.getXConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_1_1_0ElementType());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_32);
                            	    lv_arguments_12_0=ruleXExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									doneComposite();
                            	      									if(!current) {
                            	      										associateWithSemanticElement();
                            	      										current = true;
                            	      									}
                            	      								
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop79;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXConstructorCall_RightParenthesisKeyword_4_2ElementType());
                      			
                    }
                    otherlv_13=(Token)match(input,51,FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_13);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalPureXbase.g:4494:3: ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            int alt82=2;
            alt82 = dfa82.predict(input);
            switch (alt82) {
                case 1 :
                    // PsiInternalPureXbase.g:4495:4: ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure )
                    {
                    // PsiInternalPureXbase.g:4501:4: (lv_arguments_14_0= ruleXClosure )
                    // PsiInternalPureXbase.g:4502:5: lv_arguments_14_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getXConstructorCall_ArgumentsXClosureParserRuleCall_5_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_arguments_14_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleXConstructorCall"


    // $ANTLR start "entryRuleXBooleanLiteral"
    // PsiInternalPureXbase.g:4519:1: entryRuleXBooleanLiteral returns [Boolean current=false] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final Boolean entryRuleXBooleanLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXBooleanLiteral = null;


        try {
            // PsiInternalPureXbase.g:4519:57: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // PsiInternalPureXbase.g:4520:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXBooleanLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXBooleanLiteral"


    // $ANTLR start "ruleXBooleanLiteral"
    // PsiInternalPureXbase.g:4526:1: ruleXBooleanLiteral returns [Boolean current=false] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final Boolean ruleXBooleanLiteral() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

        try {
            // PsiInternalPureXbase.g:4527:1: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // PsiInternalPureXbase.g:4528:2: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // PsiInternalPureXbase.g:4528:2: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // PsiInternalPureXbase.g:4529:3: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // PsiInternalPureXbase.g:4529:3: ()
            // PsiInternalPureXbase.g:4530:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXBooleanLiteral_XBooleanLiteralAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalPureXbase.g:4536:3: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==71) ) {
                alt83=1;
            }
            else if ( (LA83_0==72) ) {
                alt83=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }
            switch (alt83) {
                case 1 :
                    // PsiInternalPureXbase.g:4537:4: otherlv_1= 'false'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXBooleanLiteral_FalseKeyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:4545:4: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // PsiInternalPureXbase.g:4545:4: ( (lv_isTrue_2_0= 'true' ) )
                    // PsiInternalPureXbase.g:4546:5: (lv_isTrue_2_0= 'true' )
                    {
                    // PsiInternalPureXbase.g:4546:5: (lv_isTrue_2_0= 'true' )
                    // PsiInternalPureXbase.g:4547:6: lv_isTrue_2_0= 'true'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getXBooleanLiteral_IsTrueTrueKeyword_1_1_0ElementType());
                      					
                    }
                    lv_isTrue_2_0=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_isTrue_2_0);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleXBooleanLiteral"


    // $ANTLR start "entryRuleXNullLiteral"
    // PsiInternalPureXbase.g:4567:1: entryRuleXNullLiteral returns [Boolean current=false] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final Boolean entryRuleXNullLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXNullLiteral = null;


        try {
            // PsiInternalPureXbase.g:4567:54: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // PsiInternalPureXbase.g:4568:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXNullLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXNullLiteral"


    // $ANTLR start "ruleXNullLiteral"
    // PsiInternalPureXbase.g:4574:1: ruleXNullLiteral returns [Boolean current=false] : ( () otherlv_1= 'null' ) ;
    public final Boolean ruleXNullLiteral() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;

        try {
            // PsiInternalPureXbase.g:4575:1: ( ( () otherlv_1= 'null' ) )
            // PsiInternalPureXbase.g:4576:2: ( () otherlv_1= 'null' )
            {
            // PsiInternalPureXbase.g:4576:2: ( () otherlv_1= 'null' )
            // PsiInternalPureXbase.g:4577:3: () otherlv_1= 'null'
            {
            // PsiInternalPureXbase.g:4577:3: ()
            // PsiInternalPureXbase.g:4578:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXNullLiteral_XNullLiteralAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXNullLiteral_NullKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
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
    // $ANTLR end "ruleXNullLiteral"


    // $ANTLR start "entryRuleXNumberLiteral"
    // PsiInternalPureXbase.g:4595:1: entryRuleXNumberLiteral returns [Boolean current=false] : iv_ruleXNumberLiteral= ruleXNumberLiteral EOF ;
    public final Boolean entryRuleXNumberLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXNumberLiteral = null;


        try {
            // PsiInternalPureXbase.g:4595:56: (iv_ruleXNumberLiteral= ruleXNumberLiteral EOF )
            // PsiInternalPureXbase.g:4596:2: iv_ruleXNumberLiteral= ruleXNumberLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXNumberLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXNumberLiteral=ruleXNumberLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNumberLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXNumberLiteral"


    // $ANTLR start "ruleXNumberLiteral"
    // PsiInternalPureXbase.g:4602:1: ruleXNumberLiteral returns [Boolean current=false] : ( () ( (lv_value_1_0= ruleNumber ) ) ) ;
    public final Boolean ruleXNumberLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean lv_value_1_0 = null;


        try {
            // PsiInternalPureXbase.g:4603:1: ( ( () ( (lv_value_1_0= ruleNumber ) ) ) )
            // PsiInternalPureXbase.g:4604:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
            {
            // PsiInternalPureXbase.g:4604:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
            // PsiInternalPureXbase.g:4605:3: () ( (lv_value_1_0= ruleNumber ) )
            {
            // PsiInternalPureXbase.g:4605:3: ()
            // PsiInternalPureXbase.g:4606:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXNumberLiteral_XNumberLiteralAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalPureXbase.g:4612:3: ( (lv_value_1_0= ruleNumber ) )
            // PsiInternalPureXbase.g:4613:4: (lv_value_1_0= ruleNumber )
            {
            // PsiInternalPureXbase.g:4613:4: (lv_value_1_0= ruleNumber )
            // PsiInternalPureXbase.g:4614:5: lv_value_1_0= ruleNumber
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXNumberLiteral_ValueNumberParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXNumberLiteral"


    // $ANTLR start "entryRuleXStringLiteral"
    // PsiInternalPureXbase.g:4631:1: entryRuleXStringLiteral returns [Boolean current=false] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final Boolean entryRuleXStringLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXStringLiteral = null;


        try {
            // PsiInternalPureXbase.g:4631:56: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // PsiInternalPureXbase.g:4632:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXStringLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXStringLiteral"


    // $ANTLR start "ruleXStringLiteral"
    // PsiInternalPureXbase.g:4638:1: ruleXStringLiteral returns [Boolean current=false] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final Boolean ruleXStringLiteral() throws RecognitionException {
        Boolean current = false;

        Token lv_value_1_0=null;

        try {
            // PsiInternalPureXbase.g:4639:1: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // PsiInternalPureXbase.g:4640:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // PsiInternalPureXbase.g:4640:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // PsiInternalPureXbase.g:4641:3: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // PsiInternalPureXbase.g:4641:3: ()
            // PsiInternalPureXbase.g:4642:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXStringLiteral_XStringLiteralAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalPureXbase.g:4648:3: ( (lv_value_1_0= RULE_STRING ) )
            // PsiInternalPureXbase.g:4649:4: (lv_value_1_0= RULE_STRING )
            {
            // PsiInternalPureXbase.g:4649:4: (lv_value_1_0= RULE_STRING )
            // PsiInternalPureXbase.g:4650:5: lv_value_1_0= RULE_STRING
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXStringLiteral_ValueSTRINGTerminalRuleCall_1_0ElementType());
              				
            }
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_value_1_0);
              				
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
    // $ANTLR end "ruleXStringLiteral"


    // $ANTLR start "entryRuleXTypeLiteral"
    // PsiInternalPureXbase.g:4669:1: entryRuleXTypeLiteral returns [Boolean current=false] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final Boolean entryRuleXTypeLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXTypeLiteral = null;


        try {
            // PsiInternalPureXbase.g:4669:54: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // PsiInternalPureXbase.g:4670:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXTypeLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXTypeLiteral"


    // $ANTLR start "ruleXTypeLiteral"
    // PsiInternalPureXbase.g:4676:1: ruleXTypeLiteral returns [Boolean current=false] : ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' ) ;
    public final Boolean ruleXTypeLiteral() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Boolean lv_arrayDimensions_4_0 = null;


        try {
            // PsiInternalPureXbase.g:4677:1: ( ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' ) )
            // PsiInternalPureXbase.g:4678:2: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' )
            {
            // PsiInternalPureXbase.g:4678:2: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' )
            // PsiInternalPureXbase.g:4679:3: () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')'
            {
            // PsiInternalPureXbase.g:4679:3: ()
            // PsiInternalPureXbase.g:4680:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXTypeLiteral_XTypeLiteralAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXTypeLiteral_TypeofKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,74,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXTypeLiteral_LeftParenthesisKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,50,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalPureXbase.g:4700:3: ( ( ruleQualifiedName ) )
            // PsiInternalPureXbase.g:4701:4: ( ruleQualifiedName )
            {
            // PsiInternalPureXbase.g:4701:4: ( ruleQualifiedName )
            // PsiInternalPureXbase.g:4702:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					if (!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXTypeLiteral_TypeJvmTypeCrossReference_3_0ElementType());
              				
            }
            pushFollow(FOLLOW_61);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // PsiInternalPureXbase.g:4717:3: ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==55) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // PsiInternalPureXbase.g:4718:4: (lv_arrayDimensions_4_0= ruleArrayBrackets )
            	    {
            	    // PsiInternalPureXbase.g:4718:4: (lv_arrayDimensions_4_0= ruleArrayBrackets )
            	    // PsiInternalPureXbase.g:4719:5: lv_arrayDimensions_4_0= ruleArrayBrackets
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markComposite(elementTypeProvider.getXTypeLiteral_ArrayDimensionsArrayBracketsParserRuleCall_4_0ElementType());
            	      				
            	    }
            	    pushFollow(FOLLOW_61);
            	    lv_arrayDimensions_4_0=ruleArrayBrackets();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneComposite();
            	      					if(!current) {
            	      						associateWithSemanticElement();
            	      						current = true;
            	      					}
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop84;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXTypeLiteral_RightParenthesisKeyword_5ElementType());
              		
            }
            otherlv_5=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_5);
              		
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
    // $ANTLR end "ruleXTypeLiteral"


    // $ANTLR start "entryRuleXThrowExpression"
    // PsiInternalPureXbase.g:4743:1: entryRuleXThrowExpression returns [Boolean current=false] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final Boolean entryRuleXThrowExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXThrowExpression = null;


        try {
            // PsiInternalPureXbase.g:4743:58: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // PsiInternalPureXbase.g:4744:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXThrowExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXThrowExpression=ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXThrowExpression"


    // $ANTLR start "ruleXThrowExpression"
    // PsiInternalPureXbase.g:4750:1: ruleXThrowExpression returns [Boolean current=false] : ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) ;
    public final Boolean ruleXThrowExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Boolean lv_expression_2_0 = null;


        try {
            // PsiInternalPureXbase.g:4751:1: ( ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) )
            // PsiInternalPureXbase.g:4752:2: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            {
            // PsiInternalPureXbase.g:4752:2: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            // PsiInternalPureXbase.g:4753:3: () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) )
            {
            // PsiInternalPureXbase.g:4753:3: ()
            // PsiInternalPureXbase.g:4754:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXThrowExpression_XThrowExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXThrowExpression_ThrowKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,75,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalPureXbase.g:4767:3: ( (lv_expression_2_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:4768:4: (lv_expression_2_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:4768:4: (lv_expression_2_0= ruleXExpression )
            // PsiInternalPureXbase.g:4769:5: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXThrowExpression_ExpressionXExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXThrowExpression"


    // $ANTLR start "entryRuleXReturnExpression"
    // PsiInternalPureXbase.g:4786:1: entryRuleXReturnExpression returns [Boolean current=false] : iv_ruleXReturnExpression= ruleXReturnExpression EOF ;
    public final Boolean entryRuleXReturnExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXReturnExpression = null;


        try {
            // PsiInternalPureXbase.g:4786:59: (iv_ruleXReturnExpression= ruleXReturnExpression EOF )
            // PsiInternalPureXbase.g:4787:2: iv_ruleXReturnExpression= ruleXReturnExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXReturnExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXReturnExpression=ruleXReturnExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXReturnExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXReturnExpression"


    // $ANTLR start "ruleXReturnExpression"
    // PsiInternalPureXbase.g:4793:1: ruleXReturnExpression returns [Boolean current=false] : ( () otherlv_1= 'return' ( ( '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? ) ;
    public final Boolean ruleXReturnExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Boolean lv_expression_2_0 = null;


        try {
            // PsiInternalPureXbase.g:4794:1: ( ( () otherlv_1= 'return' ( ( '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? ) )
            // PsiInternalPureXbase.g:4795:2: ( () otherlv_1= 'return' ( ( '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? )
            {
            // PsiInternalPureXbase.g:4795:2: ( () otherlv_1= 'return' ( ( '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? )
            // PsiInternalPureXbase.g:4796:3: () otherlv_1= 'return' ( ( '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?
            {
            // PsiInternalPureXbase.g:4796:3: ()
            // PsiInternalPureXbase.g:4797:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXReturnExpression_XReturnExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXReturnExpression_ReturnKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,76,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalPureXbase.g:4810:3: ( ( '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?
            int alt85=2;
            alt85 = dfa85.predict(input);
            switch (alt85) {
                case 1 :
                    // PsiInternalPureXbase.g:4811:4: ( '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:4812:4: (lv_expression_2_0= ruleXExpression )
                    // PsiInternalPureXbase.g:4813:5: lv_expression_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getXReturnExpression_ExpressionXExpressionParserRuleCall_2_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_2_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleXReturnExpression"


    // $ANTLR start "entryRuleXTryCatchFinallyExpression"
    // PsiInternalPureXbase.g:4830:1: entryRuleXTryCatchFinallyExpression returns [Boolean current=false] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final Boolean entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXTryCatchFinallyExpression = null;


        try {
            // PsiInternalPureXbase.g:4830:68: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // PsiInternalPureXbase.g:4831:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXTryCatchFinallyExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXTryCatchFinallyExpression"


    // $ANTLR start "ruleXTryCatchFinallyExpression"
    // PsiInternalPureXbase.g:4837:1: ruleXTryCatchFinallyExpression returns [Boolean current=false] : ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) ;
    public final Boolean ruleXTryCatchFinallyExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_expression_2_0 = null;

        Boolean lv_catchClauses_3_0 = null;

        Boolean lv_finallyExpression_5_0 = null;

        Boolean lv_finallyExpression_7_0 = null;


        try {
            // PsiInternalPureXbase.g:4838:1: ( ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) )
            // PsiInternalPureXbase.g:4839:2: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            {
            // PsiInternalPureXbase.g:4839:2: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            // PsiInternalPureXbase.g:4840:3: () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            {
            // PsiInternalPureXbase.g:4840:3: ()
            // PsiInternalPureXbase.g:4841:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXTryCatchFinallyExpression_XTryCatchFinallyExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXTryCatchFinallyExpression_TryKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,77,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalPureXbase.g:4854:3: ( (lv_expression_2_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:4855:4: (lv_expression_2_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:4855:4: (lv_expression_2_0= ruleXExpression )
            // PsiInternalPureXbase.g:4856:5: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXTryCatchFinallyExpression_ExpressionXExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_62);
            lv_expression_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            // PsiInternalPureXbase.g:4869:3: ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==80) ) {
                alt88=1;
            }
            else if ( (LA88_0==78) ) {
                alt88=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // PsiInternalPureXbase.g:4870:4: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    {
                    // PsiInternalPureXbase.g:4870:4: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    // PsiInternalPureXbase.g:4871:5: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    {
                    // PsiInternalPureXbase.g:4871:5: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+
                    int cnt86=0;
                    loop86:
                    do {
                        int alt86=2;
                        int LA86_0 = input.LA(1);

                        if ( (LA86_0==80) ) {
                            int LA86_2 = input.LA(2);

                            if ( (synpred38_PsiInternalPureXbase()) ) {
                                alt86=1;
                            }


                        }


                        switch (alt86) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:4872:6: ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause )
                    	    {
                    	    // PsiInternalPureXbase.g:4873:6: (lv_catchClauses_3_0= ruleXCatchClause )
                    	    // PsiInternalPureXbase.g:4874:7: lv_catchClauses_3_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getXTryCatchFinallyExpression_CatchClausesXCatchClauseParserRuleCall_3_0_0_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_63);
                    	    lv_catchClauses_3_0=ruleXCatchClause();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      							if(!current) {
                    	      								associateWithSemanticElement();
                    	      								current = true;
                    	      							}
                    	      						
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt86 >= 1 ) break loop86;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(86, input);
                                throw eee;
                        }
                        cnt86++;
                    } while (true);

                    // PsiInternalPureXbase.g:4887:5: ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==78) ) {
                        int LA87_1 = input.LA(2);

                        if ( (synpred39_PsiInternalPureXbase()) ) {
                            alt87=1;
                        }
                    }
                    switch (alt87) {
                        case 1 :
                            // PsiInternalPureXbase.g:4888:6: ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            {
                            // PsiInternalPureXbase.g:4888:6: ( ( 'finally' )=>otherlv_4= 'finally' )
                            // PsiInternalPureXbase.g:4889:7: ( 'finally' )=>otherlv_4= 'finally'
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getXTryCatchFinallyExpression_FinallyKeyword_3_0_1_0ElementType());
                              						
                            }
                            otherlv_4=(Token)match(input,78,FOLLOW_3); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(otherlv_4);
                              						
                            }

                            }

                            // PsiInternalPureXbase.g:4898:6: ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            // PsiInternalPureXbase.g:4899:7: (lv_finallyExpression_5_0= ruleXExpression )
                            {
                            // PsiInternalPureXbase.g:4899:7: (lv_finallyExpression_5_0= ruleXExpression )
                            // PsiInternalPureXbase.g:4900:8: lv_finallyExpression_5_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getXTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_0_1_1_0ElementType());
                              							
                            }
                            pushFollow(FOLLOW_2);
                            lv_finallyExpression_5_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              								if(!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:4916:4: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    {
                    // PsiInternalPureXbase.g:4916:4: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    // PsiInternalPureXbase.g:4917:5: otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getXTryCatchFinallyExpression_FinallyKeyword_3_1_0ElementType());
                      				
                    }
                    otherlv_6=(Token)match(input,78,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_6);
                      				
                    }
                    // PsiInternalPureXbase.g:4924:5: ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    // PsiInternalPureXbase.g:4925:6: (lv_finallyExpression_7_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:4925:6: (lv_finallyExpression_7_0= ruleXExpression )
                    // PsiInternalPureXbase.g:4926:7: lv_finallyExpression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getXTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_1_1_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    lv_finallyExpression_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
                    break;

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
    // $ANTLR end "ruleXTryCatchFinallyExpression"


    // $ANTLR start "entryRuleXSynchronizedExpression"
    // PsiInternalPureXbase.g:4945:1: entryRuleXSynchronizedExpression returns [Boolean current=false] : iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF ;
    public final Boolean entryRuleXSynchronizedExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXSynchronizedExpression = null;


        try {
            // PsiInternalPureXbase.g:4945:65: (iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF )
            // PsiInternalPureXbase.g:4946:2: iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXSynchronizedExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXSynchronizedExpression=ruleXSynchronizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSynchronizedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXSynchronizedExpression"


    // $ANTLR start "ruleXSynchronizedExpression"
    // PsiInternalPureXbase.g:4952:1: ruleXSynchronizedExpression returns [Boolean current=false] : ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final Boolean ruleXSynchronizedExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_param_3_0 = null;

        Boolean lv_expression_5_0 = null;


        try {
            // PsiInternalPureXbase.g:4953:1: ( ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // PsiInternalPureXbase.g:4954:2: ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // PsiInternalPureXbase.g:4954:2: ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) )
            // PsiInternalPureXbase.g:4955:3: ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) )
            {
            // PsiInternalPureXbase.g:4955:3: ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) )
            // PsiInternalPureXbase.g:4956:4: ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' )
            {
            // PsiInternalPureXbase.g:4963:4: ( () otherlv_1= 'synchronized' otherlv_2= '(' )
            // PsiInternalPureXbase.g:4964:5: () otherlv_1= 'synchronized' otherlv_2= '('
            {
            // PsiInternalPureXbase.g:4964:5: ()
            // PsiInternalPureXbase.g:4965:6: 
            {
            if ( state.backtracking==0 ) {

              						precedeComposite(elementTypeProvider.getXSynchronizedExpression_XSynchronizedExpressionAction_0_0_0ElementType());
              						doneComposite();
              						associateWithSemanticElement();
              					
            }

            }

            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXSynchronizedExpression_SynchronizedKeyword_0_0_1ElementType());
              				
            }
            otherlv_1=(Token)match(input,79,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(otherlv_1);
              				
            }
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXSynchronizedExpression_LeftParenthesisKeyword_0_0_2ElementType());
              				
            }
            otherlv_2=(Token)match(input,50,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(otherlv_2);
              				
            }

            }


            }

            // PsiInternalPureXbase.g:4987:3: ( (lv_param_3_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:4988:4: (lv_param_3_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:4988:4: (lv_param_3_0= ruleXExpression )
            // PsiInternalPureXbase.g:4989:5: lv_param_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXSynchronizedExpression_ParamXExpressionParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_31);
            lv_param_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXSynchronizedExpression_RightParenthesisKeyword_2ElementType());
              		
            }
            otherlv_4=(Token)match(input,51,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
            }
            // PsiInternalPureXbase.g:5009:3: ( (lv_expression_5_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:5010:4: (lv_expression_5_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:5010:4: (lv_expression_5_0= ruleXExpression )
            // PsiInternalPureXbase.g:5011:5: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXSynchronizedExpression_ExpressionXExpressionParserRuleCall_3_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXSynchronizedExpression"


    // $ANTLR start "entryRuleXCatchClause"
    // PsiInternalPureXbase.g:5028:1: entryRuleXCatchClause returns [Boolean current=false] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final Boolean entryRuleXCatchClause() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXCatchClause = null;


        try {
            // PsiInternalPureXbase.g:5028:54: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // PsiInternalPureXbase.g:5029:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXCatchClauseElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXCatchClause"


    // $ANTLR start "ruleXCatchClause"
    // PsiInternalPureXbase.g:5035:1: ruleXCatchClause returns [Boolean current=false] : ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final Boolean ruleXCatchClause() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Boolean lv_declaredParam_2_0 = null;

        Boolean lv_expression_4_0 = null;


        try {
            // PsiInternalPureXbase.g:5036:1: ( ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // PsiInternalPureXbase.g:5037:2: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // PsiInternalPureXbase.g:5037:2: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // PsiInternalPureXbase.g:5038:3: ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            // PsiInternalPureXbase.g:5038:3: ( ( 'catch' )=>otherlv_0= 'catch' )
            // PsiInternalPureXbase.g:5039:4: ( 'catch' )=>otherlv_0= 'catch'
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getXCatchClause_CatchKeyword_0ElementType());
              			
            }
            otherlv_0=(Token)match(input,80,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				doneLeaf(otherlv_0);
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXCatchClause_LeftParenthesisKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,50,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalPureXbase.g:5055:3: ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) )
            // PsiInternalPureXbase.g:5056:4: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            {
            // PsiInternalPureXbase.g:5056:4: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            // PsiInternalPureXbase.g:5057:5: lv_declaredParam_2_0= ruleFullJvmFormalParameter
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXCatchClause_DeclaredParamFullJvmFormalParameterParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_31);
            lv_declaredParam_2_0=ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXCatchClause_RightParenthesisKeyword_3ElementType());
              		
            }
            otherlv_3=(Token)match(input,51,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_3);
              		
            }
            // PsiInternalPureXbase.g:5077:3: ( (lv_expression_4_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:5078:4: (lv_expression_4_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:5078:4: (lv_expression_4_0= ruleXExpression )
            // PsiInternalPureXbase.g:5079:5: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXCatchClause_ExpressionXExpressionParserRuleCall_4_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXCatchClause"


    // $ANTLR start "entryRuleQualifiedName"
    // PsiInternalPureXbase.g:5096:1: entryRuleQualifiedName returns [Boolean current=false] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final Boolean entryRuleQualifiedName() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleQualifiedName = null;


        try {
            // PsiInternalPureXbase.g:5096:55: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // PsiInternalPureXbase.g:5097:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getQualifiedNameElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // PsiInternalPureXbase.g:5103:1: ruleQualifiedName returns [Boolean current=false] : ( ruleValidID ( ( ( '.' )=>kw= '.' ) ruleValidID )* ) ;
    public final Boolean ruleQualifiedName() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalPureXbase.g:5104:1: ( ( ruleValidID ( ( ( '.' )=>kw= '.' ) ruleValidID )* ) )
            // PsiInternalPureXbase.g:5105:2: ( ruleValidID ( ( ( '.' )=>kw= '.' ) ruleValidID )* )
            {
            // PsiInternalPureXbase.g:5105:2: ( ruleValidID ( ( ( '.' )=>kw= '.' ) ruleValidID )* )
            // PsiInternalPureXbase.g:5106:3: ruleValidID ( ( ( '.' )=>kw= '.' ) ruleValidID )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getQualifiedName_ValidIDParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_64);
            ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalPureXbase.g:5113:3: ( ( ( '.' )=>kw= '.' ) ruleValidID )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==46) ) {
                    int LA89_2 = input.LA(2);

                    if ( (LA89_2==RULE_ID) ) {
                        int LA89_3 = input.LA(3);

                        if ( (synpred42_PsiInternalPureXbase()) ) {
                            alt89=1;
                        }


                    }


                }


                switch (alt89) {
            	case 1 :
            	    // PsiInternalPureXbase.g:5114:4: ( ( '.' )=>kw= '.' ) ruleValidID
            	    {
            	    // PsiInternalPureXbase.g:5114:4: ( ( '.' )=>kw= '.' )
            	    // PsiInternalPureXbase.g:5115:5: ( '.' )=>kw= '.'
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getQualifiedName_FullStopKeyword_1_0ElementType());
            	      				
            	    }
            	    kw=(Token)match(input,46,FOLLOW_25); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(kw);
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				markComposite(elementTypeProvider.getQualifiedName_ValidIDParserRuleCall_1_1ElementType());
            	      			
            	    }
            	    pushFollow(FOLLOW_64);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneComposite();
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop89;
                }
            } while (true);


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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleNumber"
    // PsiInternalPureXbase.g:5136:1: entryRuleNumber returns [Boolean current=false] : iv_ruleNumber= ruleNumber EOF ;
    public final Boolean entryRuleNumber() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNumber = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // PsiInternalPureXbase.g:5138:2: (iv_ruleNumber= ruleNumber EOF )
            // PsiInternalPureXbase.g:5139:2: iv_ruleNumber= ruleNumber EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getNumberElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNumber=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumber; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // PsiInternalPureXbase.g:5148:1: ruleNumber returns [Boolean current=false] : (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) ) ;
    public final Boolean ruleNumber() throws RecognitionException {
        Boolean current = false;

        Token this_HEX_0=null;
        Token this_INT_1=null;
        Token this_DECIMAL_2=null;
        Token kw=null;
        Token this_INT_4=null;
        Token this_DECIMAL_5=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // PsiInternalPureXbase.g:5151:2: ( (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) ) )
            // PsiInternalPureXbase.g:5152:2: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) )
            {
            // PsiInternalPureXbase.g:5152:2: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==RULE_HEX) ) {
                alt93=1;
            }
            else if ( ((LA93_0>=RULE_INT && LA93_0<=RULE_DECIMAL)) ) {
                alt93=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }
            switch (alt93) {
                case 1 :
                    // PsiInternalPureXbase.g:5153:3: this_HEX_0= RULE_HEX
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getNumber_HEXTerminalRuleCall_0ElementType());
                      		
                    }
                    this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(this_HEX_0);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:5161:3: ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? )
                    {
                    // PsiInternalPureXbase.g:5161:3: ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? )
                    // PsiInternalPureXbase.g:5162:4: (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )?
                    {
                    // PsiInternalPureXbase.g:5162:4: (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL )
                    int alt90=2;
                    int LA90_0 = input.LA(1);

                    if ( (LA90_0==RULE_INT) ) {
                        alt90=1;
                    }
                    else if ( (LA90_0==RULE_DECIMAL) ) {
                        alt90=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 90, 0, input);

                        throw nvae;
                    }
                    switch (alt90) {
                        case 1 :
                            // PsiInternalPureXbase.g:5163:5: this_INT_1= RULE_INT
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getNumber_INTTerminalRuleCall_1_0_0ElementType());
                              				
                            }
                            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_64); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(this_INT_1);
                              				
                            }

                            }
                            break;
                        case 2 :
                            // PsiInternalPureXbase.g:5171:5: this_DECIMAL_2= RULE_DECIMAL
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getNumber_DECIMALTerminalRuleCall_1_0_1ElementType());
                              				
                            }
                            this_DECIMAL_2=(Token)match(input,RULE_DECIMAL,FOLLOW_64); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(this_DECIMAL_2);
                              				
                            }

                            }
                            break;

                    }

                    // PsiInternalPureXbase.g:5179:4: (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )?
                    int alt92=2;
                    int LA92_0 = input.LA(1);

                    if ( (LA92_0==46) ) {
                        int LA92_1 = input.LA(2);

                        if ( ((LA92_1>=RULE_INT && LA92_1<=RULE_DECIMAL)) ) {
                            alt92=1;
                        }
                    }
                    switch (alt92) {
                        case 1 :
                            // PsiInternalPureXbase.g:5180:5: kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL )
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getNumber_FullStopKeyword_1_1_0ElementType());
                              				
                            }
                            kw=(Token)match(input,46,FOLLOW_65); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(kw);
                              				
                            }
                            // PsiInternalPureXbase.g:5187:5: (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL )
                            int alt91=2;
                            int LA91_0 = input.LA(1);

                            if ( (LA91_0==RULE_INT) ) {
                                alt91=1;
                            }
                            else if ( (LA91_0==RULE_DECIMAL) ) {
                                alt91=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 91, 0, input);

                                throw nvae;
                            }
                            switch (alt91) {
                                case 1 :
                                    // PsiInternalPureXbase.g:5188:6: this_INT_4= RULE_INT
                                    {
                                    if ( state.backtracking==0 ) {

                                      						markLeaf(elementTypeProvider.getNumber_INTTerminalRuleCall_1_1_1_0ElementType());
                                      					
                                    }
                                    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      						doneLeaf(this_INT_4);
                                      					
                                    }

                                    }
                                    break;
                                case 2 :
                                    // PsiInternalPureXbase.g:5196:6: this_DECIMAL_5= RULE_DECIMAL
                                    {
                                    if ( state.backtracking==0 ) {

                                      						markLeaf(elementTypeProvider.getNumber_DECIMALTerminalRuleCall_1_1_1_1ElementType());
                                      					
                                    }
                                    this_DECIMAL_5=(Token)match(input,RULE_DECIMAL,FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      						doneLeaf(this_DECIMAL_5);
                                      					
                                    }

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleNumber"


    // $ANTLR start "entryRuleJvmTypeReference"
    // PsiInternalPureXbase.g:5213:1: entryRuleJvmTypeReference returns [Boolean current=false] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final Boolean entryRuleJvmTypeReference() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJvmTypeReference = null;


        try {
            // PsiInternalPureXbase.g:5213:58: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // PsiInternalPureXbase.g:5214:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmTypeReferenceElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmTypeReference"


    // $ANTLR start "ruleJvmTypeReference"
    // PsiInternalPureXbase.g:5220:1: ruleJvmTypeReference returns [Boolean current=false] : ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef ) ;
    public final Boolean ruleJvmTypeReference() throws RecognitionException {
        Boolean current = false;

        Boolean this_JvmParameterizedTypeReference_0 = null;

        Boolean this_XFunctionTypeRef_3 = null;


        try {
            // PsiInternalPureXbase.g:5221:1: ( ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef ) )
            // PsiInternalPureXbase.g:5222:2: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef )
            {
            // PsiInternalPureXbase.g:5222:2: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==RULE_ID) ) {
                alt95=1;
            }
            else if ( (LA95_0==33||LA95_0==50) ) {
                alt95=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // PsiInternalPureXbase.g:5223:3: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    {
                    // PsiInternalPureXbase.g:5223:3: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    // PsiInternalPureXbase.g:5224:4: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getJvmTypeReference_JvmParameterizedTypeReferenceParserRuleCall_0_0ElementType());
                      			
                    }
                    pushFollow(FOLLOW_59);
                    this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_JvmParameterizedTypeReference_0;
                      				doneComposite();
                      			
                    }
                    // PsiInternalPureXbase.g:5232:4: ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    loop94:
                    do {
                        int alt94=2;
                        int LA94_0 = input.LA(1);

                        if ( (LA94_0==55) ) {
                            int LA94_2 = input.LA(2);

                            if ( (LA94_2==56) ) {
                                int LA94_3 = input.LA(3);

                                if ( (synpred43_PsiInternalPureXbase()) ) {
                                    alt94=1;
                                }


                            }


                        }


                        switch (alt94) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:5233:5: ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets )
                    	    {
                    	    // PsiInternalPureXbase.g:5239:5: ( () ruleArrayBrackets )
                    	    // PsiInternalPureXbase.g:5240:6: () ruleArrayBrackets
                    	    {
                    	    // PsiInternalPureXbase.g:5240:6: ()
                    	    // PsiInternalPureXbase.g:5241:7: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							precedeComposite(elementTypeProvider.getJvmTypeReference_JvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0ElementType());
                    	      							doneComposite();
                    	      							associateWithSemanticElement();
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						markComposite(elementTypeProvider.getJvmTypeReference_ArrayBracketsParserRuleCall_0_1_0_1ElementType());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_59);
                    	    ruleArrayBrackets();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						doneComposite();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop94;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:5258:3: this_XFunctionTypeRef_3= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getJvmTypeReference_XFunctionTypeRefParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XFunctionTypeRef_3=ruleXFunctionTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XFunctionTypeRef_3;
                      			doneComposite();
                      		
                    }

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
    // $ANTLR end "ruleJvmTypeReference"


    // $ANTLR start "entryRuleArrayBrackets"
    // PsiInternalPureXbase.g:5270:1: entryRuleArrayBrackets returns [Boolean current=false] : iv_ruleArrayBrackets= ruleArrayBrackets EOF ;
    public final Boolean entryRuleArrayBrackets() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleArrayBrackets = null;


        try {
            // PsiInternalPureXbase.g:5270:55: (iv_ruleArrayBrackets= ruleArrayBrackets EOF )
            // PsiInternalPureXbase.g:5271:2: iv_ruleArrayBrackets= ruleArrayBrackets EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getArrayBracketsElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArrayBrackets=ruleArrayBrackets();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayBrackets; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleArrayBrackets"


    // $ANTLR start "ruleArrayBrackets"
    // PsiInternalPureXbase.g:5277:1: ruleArrayBrackets returns [Boolean current=false] : (kw= '[' kw= ']' ) ;
    public final Boolean ruleArrayBrackets() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalPureXbase.g:5278:1: ( (kw= '[' kw= ']' ) )
            // PsiInternalPureXbase.g:5279:2: (kw= '[' kw= ']' )
            {
            // PsiInternalPureXbase.g:5279:2: (kw= '[' kw= ']' )
            // PsiInternalPureXbase.g:5280:3: kw= '[' kw= ']'
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getArrayBrackets_LeftSquareBracketKeyword_0ElementType());
              		
            }
            kw=(Token)match(input,55,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getArrayBrackets_RightSquareBracketKeyword_1ElementType());
              		
            }
            kw=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw);
              		
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
    // $ANTLR end "ruleArrayBrackets"


    // $ANTLR start "entryRuleXFunctionTypeRef"
    // PsiInternalPureXbase.g:5298:1: entryRuleXFunctionTypeRef returns [Boolean current=false] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final Boolean entryRuleXFunctionTypeRef() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXFunctionTypeRef = null;


        try {
            // PsiInternalPureXbase.g:5298:58: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // PsiInternalPureXbase.g:5299:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXFunctionTypeRefElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXFunctionTypeRef"


    // $ANTLR start "ruleXFunctionTypeRef"
    // PsiInternalPureXbase.g:5305:1: ruleXFunctionTypeRef returns [Boolean current=false] : ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
    public final Boolean ruleXFunctionTypeRef() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Boolean lv_paramTypes_1_0 = null;

        Boolean lv_paramTypes_3_0 = null;

        Boolean lv_returnType_6_0 = null;


        try {
            // PsiInternalPureXbase.g:5306:1: ( ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // PsiInternalPureXbase.g:5307:2: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // PsiInternalPureXbase.g:5307:2: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // PsiInternalPureXbase.g:5308:3: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // PsiInternalPureXbase.g:5308:3: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==50) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // PsiInternalPureXbase.g:5309:4: otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXFunctionTypeRef_LeftParenthesisKeyword_0_0ElementType());
                      			
                    }
                    otherlv_0=(Token)match(input,50,FOLLOW_66); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_0);
                      			
                    }
                    // PsiInternalPureXbase.g:5316:4: ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )?
                    int alt97=2;
                    int LA97_0 = input.LA(1);

                    if ( (LA97_0==RULE_ID||LA97_0==33||LA97_0==50) ) {
                        alt97=1;
                    }
                    switch (alt97) {
                        case 1 :
                            // PsiInternalPureXbase.g:5317:5: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            {
                            // PsiInternalPureXbase.g:5317:5: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                            // PsiInternalPureXbase.g:5318:6: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            {
                            // PsiInternalPureXbase.g:5318:6: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            // PsiInternalPureXbase.g:5319:7: lv_paramTypes_1_0= ruleJvmTypeReference
                            {
                            if ( state.backtracking==0 ) {

                              							markComposite(elementTypeProvider.getXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0ElementType());
                              						
                            }
                            pushFollow(FOLLOW_32);
                            lv_paramTypes_1_0=ruleJvmTypeReference();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneComposite();
                              							if(!current) {
                              								associateWithSemanticElement();
                              								current = true;
                              							}
                              						
                            }

                            }


                            }

                            // PsiInternalPureXbase.g:5332:5: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            loop96:
                            do {
                                int alt96=2;
                                int LA96_0 = input.LA(1);

                                if ( (LA96_0==49) ) {
                                    alt96=1;
                                }


                                switch (alt96) {
                            	case 1 :
                            	    // PsiInternalPureXbase.g:5333:6: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      						markLeaf(elementTypeProvider.getXFunctionTypeRef_CommaKeyword_0_1_1_0ElementType());
                            	      					
                            	    }
                            	    otherlv_2=(Token)match(input,49,FOLLOW_15); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						doneLeaf(otherlv_2);
                            	      					
                            	    }
                            	    // PsiInternalPureXbase.g:5340:6: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    // PsiInternalPureXbase.g:5341:7: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    {
                            	    // PsiInternalPureXbase.g:5341:7: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    // PsiInternalPureXbase.g:5342:8: lv_paramTypes_3_0= ruleJvmTypeReference
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								markComposite(elementTypeProvider.getXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0ElementType());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_32);
                            	    lv_paramTypes_3_0=ruleJvmTypeReference();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      								doneComposite();
                            	      								if(!current) {
                            	      									associateWithSemanticElement();
                            	      									current = true;
                            	      								}
                            	      							
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop96;
                                }
                            } while (true);


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXFunctionTypeRef_RightParenthesisKeyword_0_2ElementType());
                      			
                    }
                    otherlv_4=(Token)match(input,51,FOLLOW_67); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_4);
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXFunctionTypeRef_EqualsSignGreaterThanSignKeyword_1ElementType());
              		
            }
            otherlv_5=(Token)match(input,33,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_5);
              		
            }
            // PsiInternalPureXbase.g:5372:3: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // PsiInternalPureXbase.g:5373:4: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // PsiInternalPureXbase.g:5373:4: (lv_returnType_6_0= ruleJvmTypeReference )
            // PsiInternalPureXbase.g:5374:5: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXFunctionTypeRef_ReturnTypeJvmTypeReferenceParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_returnType_6_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXFunctionTypeRef"


    // $ANTLR start "entryRuleJvmParameterizedTypeReference"
    // PsiInternalPureXbase.g:5391:1: entryRuleJvmParameterizedTypeReference returns [Boolean current=false] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final Boolean entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJvmParameterizedTypeReference = null;


        try {
            // PsiInternalPureXbase.g:5391:71: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // PsiInternalPureXbase.g:5392:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmParameterizedTypeReferenceElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmParameterizedTypeReference"


    // $ANTLR start "ruleJvmParameterizedTypeReference"
    // PsiInternalPureXbase.g:5398:1: ruleJvmParameterizedTypeReference returns [Boolean current=false] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) ;
    public final Boolean ruleJvmParameterizedTypeReference() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Boolean lv_arguments_2_0 = null;

        Boolean lv_arguments_4_0 = null;

        Boolean lv_arguments_10_0 = null;

        Boolean lv_arguments_12_0 = null;


        try {
            // PsiInternalPureXbase.g:5399:1: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) )
            // PsiInternalPureXbase.g:5400:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
            {
            // PsiInternalPureXbase.g:5400:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
            // PsiInternalPureXbase.g:5401:3: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
            {
            // PsiInternalPureXbase.g:5401:3: ( ( ruleQualifiedName ) )
            // PsiInternalPureXbase.g:5402:4: ( ruleQualifiedName )
            {
            // PsiInternalPureXbase.g:5402:4: ( ruleQualifiedName )
            // PsiInternalPureXbase.g:5403:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					if (!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmParameterizedTypeReference_TypeJvmTypeCrossReference_0_0ElementType());
              				
            }
            pushFollow(FOLLOW_68);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // PsiInternalPureXbase.g:5418:3: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
            int alt103=2;
            alt103 = dfa103.predict(input);
            switch (alt103) {
                case 1 :
                    // PsiInternalPureXbase.g:5419:4: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
                    {
                    // PsiInternalPureXbase.g:5419:4: ( ( '<' )=>otherlv_1= '<' )
                    // PsiInternalPureXbase.g:5420:5: ( '<' )=>otherlv_1= '<'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_LessThanSignKeyword_1_0ElementType());
                      				
                    }
                    otherlv_1=(Token)match(input,20,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1);
                      				
                    }

                    }

                    // PsiInternalPureXbase.g:5429:4: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // PsiInternalPureXbase.g:5430:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // PsiInternalPureXbase.g:5430:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // PsiInternalPureXbase.g:5431:6: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_28);
                    lv_arguments_2_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:5444:4: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop99:
                    do {
                        int alt99=2;
                        int LA99_0 = input.LA(1);

                        if ( (LA99_0==49) ) {
                            alt99=1;
                        }


                        switch (alt99) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:5445:5: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_CommaKeyword_1_2_0ElementType());
                    	      				
                    	    }
                    	    otherlv_3=(Token)match(input,49,FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_3);
                    	      				
                    	    }
                    	    // PsiInternalPureXbase.g:5452:5: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // PsiInternalPureXbase.g:5453:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // PsiInternalPureXbase.g:5453:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // PsiInternalPureXbase.g:5454:7: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_28);
                    	    lv_arguments_4_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      							if(!current) {
                    	      								associateWithSemanticElement();
                    	      								current = true;
                    	      							}
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop99;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_GreaterThanSignKeyword_1_3ElementType());
                      			
                    }
                    otherlv_5=(Token)match(input,21,FOLLOW_64); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_5);
                      			
                    }
                    // PsiInternalPureXbase.g:5475:4: ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
                    loop102:
                    do {
                        int alt102=2;
                        int LA102_0 = input.LA(1);

                        if ( (LA102_0==46) ) {
                            int LA102_2 = input.LA(2);

                            if ( (LA102_2==RULE_ID) ) {
                                int LA102_3 = input.LA(3);

                                if ( (synpred45_PsiInternalPureXbase()) ) {
                                    alt102=1;
                                }


                            }


                        }


                        switch (alt102) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:5476:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
                    	    {
                    	    // PsiInternalPureXbase.g:5476:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) )
                    	    // PsiInternalPureXbase.g:5477:6: ( ( () '.' ) )=> ( () otherlv_7= '.' )
                    	    {
                    	    // PsiInternalPureXbase.g:5483:6: ( () otherlv_7= '.' )
                    	    // PsiInternalPureXbase.g:5484:7: () otherlv_7= '.'
                    	    {
                    	    // PsiInternalPureXbase.g:5484:7: ()
                    	    // PsiInternalPureXbase.g:5485:8: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								precedeComposite(elementTypeProvider.getJvmParameterizedTypeReference_JvmInnerTypeReferenceOuterAction_1_4_0_0_0ElementType());
                    	      								doneComposite();
                    	      								associateWithSemanticElement();
                    	      							
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      							markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_FullStopKeyword_1_4_0_0_1ElementType());
                    	      						
                    	    }
                    	    otherlv_7=(Token)match(input,46,FOLLOW_25); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							doneLeaf(otherlv_7);
                    	      						
                    	    }

                    	    }


                    	    }

                    	    // PsiInternalPureXbase.g:5500:5: ( ( ruleValidID ) )
                    	    // PsiInternalPureXbase.g:5501:6: ( ruleValidID )
                    	    {
                    	    // PsiInternalPureXbase.g:5501:6: ( ruleValidID )
                    	    // PsiInternalPureXbase.g:5502:7: ruleValidID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (!current) {
                    	      								associateWithSemanticElement();
                    	      								current = true;
                    	      							}
                    	      						
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmParameterizedTypeReference_TypeJvmTypeCrossReference_1_4_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_69);
                    	    ruleValidID();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      						
                    	    }

                    	    }


                    	    }

                    	    // PsiInternalPureXbase.g:5517:5: ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
                    	    int alt101=2;
                    	    alt101 = dfa101.predict(input);
                    	    switch (alt101) {
                    	        case 1 :
                    	            // PsiInternalPureXbase.g:5518:6: ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>'
                    	            {
                    	            // PsiInternalPureXbase.g:5518:6: ( ( '<' )=>otherlv_9= '<' )
                    	            // PsiInternalPureXbase.g:5519:7: ( '<' )=>otherlv_9= '<'
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              							markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_LessThanSignKeyword_1_4_2_0ElementType());
                    	              						
                    	            }
                    	            otherlv_9=(Token)match(input,20,FOLLOW_27); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              							doneLeaf(otherlv_9);
                    	              						
                    	            }

                    	            }

                    	            // PsiInternalPureXbase.g:5528:6: ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) )
                    	            // PsiInternalPureXbase.g:5529:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
                    	            {
                    	            // PsiInternalPureXbase.g:5529:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
                    	            // PsiInternalPureXbase.g:5530:8: lv_arguments_10_0= ruleJvmArgumentTypeReference
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0ElementType());
                    	              							
                    	            }
                    	            pushFollow(FOLLOW_28);
                    	            lv_arguments_10_0=ruleJvmArgumentTypeReference();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								doneComposite();
                    	              								if(!current) {
                    	              									associateWithSemanticElement();
                    	              									current = true;
                    	              								}
                    	              							
                    	            }

                    	            }


                    	            }

                    	            // PsiInternalPureXbase.g:5543:6: (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )*
                    	            loop100:
                    	            do {
                    	                int alt100=2;
                    	                int LA100_0 = input.LA(1);

                    	                if ( (LA100_0==49) ) {
                    	                    alt100=1;
                    	                }


                    	                switch (alt100) {
                    	            	case 1 :
                    	            	    // PsiInternalPureXbase.g:5544:7: otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
                    	            	    {
                    	            	    if ( state.backtracking==0 ) {

                    	            	      							markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_CommaKeyword_1_4_2_2_0ElementType());
                    	            	      						
                    	            	    }
                    	            	    otherlv_11=(Token)match(input,49,FOLLOW_27); if (state.failed) return current;
                    	            	    if ( state.backtracking==0 ) {

                    	            	      							doneLeaf(otherlv_11);
                    	            	      						
                    	            	    }
                    	            	    // PsiInternalPureXbase.g:5551:7: ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
                    	            	    // PsiInternalPureXbase.g:5552:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
                    	            	    {
                    	            	    // PsiInternalPureXbase.g:5552:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
                    	            	    // PsiInternalPureXbase.g:5553:9: lv_arguments_12_0= ruleJvmArgumentTypeReference
                    	            	    {
                    	            	    if ( state.backtracking==0 ) {

                    	            	      									markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0ElementType());
                    	            	      								
                    	            	    }
                    	            	    pushFollow(FOLLOW_28);
                    	            	    lv_arguments_12_0=ruleJvmArgumentTypeReference();

                    	            	    state._fsp--;
                    	            	    if (state.failed) return current;
                    	            	    if ( state.backtracking==0 ) {

                    	            	      									doneComposite();
                    	            	      									if(!current) {
                    	            	      										associateWithSemanticElement();
                    	            	      										current = true;
                    	            	      									}
                    	            	      								
                    	            	    }

                    	            	    }


                    	            	    }


                    	            	    }
                    	            	    break;

                    	            	default :
                    	            	    break loop100;
                    	                }
                    	            } while (true);

                    	            if ( state.backtracking==0 ) {

                    	              						markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_GreaterThanSignKeyword_1_4_2_3ElementType());
                    	              					
                    	            }
                    	            otherlv_13=(Token)match(input,21,FOLLOW_64); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              						doneLeaf(otherlv_13);
                    	              					
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop102;
                        }
                    } while (true);


                    }
                    break;

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
    // $ANTLR end "ruleJvmParameterizedTypeReference"


    // $ANTLR start "entryRuleJvmArgumentTypeReference"
    // PsiInternalPureXbase.g:5581:1: entryRuleJvmArgumentTypeReference returns [Boolean current=false] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final Boolean entryRuleJvmArgumentTypeReference() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJvmArgumentTypeReference = null;


        try {
            // PsiInternalPureXbase.g:5581:66: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // PsiInternalPureXbase.g:5582:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmArgumentTypeReferenceElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmArgumentTypeReference"


    // $ANTLR start "ruleJvmArgumentTypeReference"
    // PsiInternalPureXbase.g:5588:1: ruleJvmArgumentTypeReference returns [Boolean current=false] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final Boolean ruleJvmArgumentTypeReference() throws RecognitionException {
        Boolean current = false;

        Boolean this_JvmTypeReference_0 = null;

        Boolean this_JvmWildcardTypeReference_1 = null;


        try {
            // PsiInternalPureXbase.g:5589:1: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // PsiInternalPureXbase.g:5590:2: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // PsiInternalPureXbase.g:5590:2: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==RULE_ID||LA104_0==33||LA104_0==50) ) {
                alt104=1;
            }
            else if ( (LA104_0==81) ) {
                alt104=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }
            switch (alt104) {
                case 1 :
                    // PsiInternalPureXbase.g:5591:3: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getJvmArgumentTypeReference_JvmTypeReferenceParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_JvmTypeReference_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_JvmTypeReference_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:5600:3: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getJvmArgumentTypeReference_JvmWildcardTypeReferenceParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_JvmWildcardTypeReference_1=ruleJvmWildcardTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_JvmWildcardTypeReference_1;
                      			doneComposite();
                      		
                    }

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
    // $ANTLR end "ruleJvmArgumentTypeReference"


    // $ANTLR start "entryRuleJvmWildcardTypeReference"
    // PsiInternalPureXbase.g:5612:1: entryRuleJvmWildcardTypeReference returns [Boolean current=false] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final Boolean entryRuleJvmWildcardTypeReference() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJvmWildcardTypeReference = null;


        try {
            // PsiInternalPureXbase.g:5612:66: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // PsiInternalPureXbase.g:5613:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmWildcardTypeReferenceElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmWildcardTypeReference"


    // $ANTLR start "ruleJvmWildcardTypeReference"
    // PsiInternalPureXbase.g:5619:1: ruleJvmWildcardTypeReference returns [Boolean current=false] : ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) ;
    public final Boolean ruleJvmWildcardTypeReference() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Boolean lv_constraints_2_0 = null;

        Boolean lv_constraints_3_0 = null;

        Boolean lv_constraints_4_0 = null;

        Boolean lv_constraints_5_0 = null;


        try {
            // PsiInternalPureXbase.g:5620:1: ( ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) )
            // PsiInternalPureXbase.g:5621:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
            {
            // PsiInternalPureXbase.g:5621:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
            // PsiInternalPureXbase.g:5622:3: () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
            {
            // PsiInternalPureXbase.g:5622:3: ()
            // PsiInternalPureXbase.g:5623:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getJvmWildcardTypeReference_JvmWildcardTypeReferenceAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getJvmWildcardTypeReference_QuestionMarkKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,81,FOLLOW_70); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalPureXbase.g:5636:3: ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
            int alt107=3;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==82) ) {
                alt107=1;
            }
            else if ( (LA107_0==69) ) {
                alt107=2;
            }
            switch (alt107) {
                case 1 :
                    // PsiInternalPureXbase.g:5637:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
                    {
                    // PsiInternalPureXbase.g:5637:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
                    // PsiInternalPureXbase.g:5638:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
                    {
                    // PsiInternalPureXbase.g:5638:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // PsiInternalPureXbase.g:5639:6: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // PsiInternalPureXbase.g:5639:6: (lv_constraints_2_0= ruleJvmUpperBound )
                    // PsiInternalPureXbase.g:5640:7: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmUpperBoundParserRuleCall_2_0_0_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_71);
                    lv_constraints_2_0=ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:5653:5: ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
                    loop105:
                    do {
                        int alt105=2;
                        int LA105_0 = input.LA(1);

                        if ( (LA105_0==83) ) {
                            alt105=1;
                        }


                        switch (alt105) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:5654:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
                    	    {
                    	    // PsiInternalPureXbase.g:5654:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
                    	    // PsiInternalPureXbase.g:5655:7: lv_constraints_3_0= ruleJvmUpperBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_71);
                    	    lv_constraints_3_0=ruleJvmUpperBoundAnded();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      							if(!current) {
                    	      								associateWithSemanticElement();
                    	      								current = true;
                    	      							}
                    	      						
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop105;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:5670:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
                    {
                    // PsiInternalPureXbase.g:5670:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
                    // PsiInternalPureXbase.g:5671:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
                    {
                    // PsiInternalPureXbase.g:5671:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) )
                    // PsiInternalPureXbase.g:5672:6: (lv_constraints_4_0= ruleJvmLowerBound )
                    {
                    // PsiInternalPureXbase.g:5672:6: (lv_constraints_4_0= ruleJvmLowerBound )
                    // PsiInternalPureXbase.g:5673:7: lv_constraints_4_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmLowerBoundParserRuleCall_2_1_0_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_71);
                    lv_constraints_4_0=ruleJvmLowerBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:5686:5: ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
                    loop106:
                    do {
                        int alt106=2;
                        int LA106_0 = input.LA(1);

                        if ( (LA106_0==83) ) {
                            alt106=1;
                        }


                        switch (alt106) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:5687:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
                    	    {
                    	    // PsiInternalPureXbase.g:5687:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
                    	    // PsiInternalPureXbase.g:5688:7: lv_constraints_5_0= ruleJvmLowerBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_71);
                    	    lv_constraints_5_0=ruleJvmLowerBoundAnded();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      							if(!current) {
                    	      								associateWithSemanticElement();
                    	      								current = true;
                    	      							}
                    	      						
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop106;
                        }
                    } while (true);


                    }


                    }
                    break;

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
    // $ANTLR end "ruleJvmWildcardTypeReference"


    // $ANTLR start "entryRuleJvmUpperBound"
    // PsiInternalPureXbase.g:5707:1: entryRuleJvmUpperBound returns [Boolean current=false] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final Boolean entryRuleJvmUpperBound() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJvmUpperBound = null;


        try {
            // PsiInternalPureXbase.g:5707:55: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // PsiInternalPureXbase.g:5708:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmUpperBoundElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmUpperBound"


    // $ANTLR start "ruleJvmUpperBound"
    // PsiInternalPureXbase.g:5714:1: ruleJvmUpperBound returns [Boolean current=false] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final Boolean ruleJvmUpperBound() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_typeReference_1_0 = null;


        try {
            // PsiInternalPureXbase.g:5715:1: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // PsiInternalPureXbase.g:5716:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // PsiInternalPureXbase.g:5716:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // PsiInternalPureXbase.g:5717:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getJvmUpperBound_ExtendsKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,82,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalPureXbase.g:5724:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // PsiInternalPureXbase.g:5725:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // PsiInternalPureXbase.g:5725:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // PsiInternalPureXbase.g:5726:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmUpperBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmUpperBound"


    // $ANTLR start "entryRuleJvmUpperBoundAnded"
    // PsiInternalPureXbase.g:5743:1: entryRuleJvmUpperBoundAnded returns [Boolean current=false] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final Boolean entryRuleJvmUpperBoundAnded() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJvmUpperBoundAnded = null;


        try {
            // PsiInternalPureXbase.g:5743:60: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // PsiInternalPureXbase.g:5744:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmUpperBoundAndedElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmUpperBoundAnded"


    // $ANTLR start "ruleJvmUpperBoundAnded"
    // PsiInternalPureXbase.g:5750:1: ruleJvmUpperBoundAnded returns [Boolean current=false] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final Boolean ruleJvmUpperBoundAnded() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_typeReference_1_0 = null;


        try {
            // PsiInternalPureXbase.g:5751:1: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // PsiInternalPureXbase.g:5752:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // PsiInternalPureXbase.g:5752:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // PsiInternalPureXbase.g:5753:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getJvmUpperBoundAnded_AmpersandKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,83,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalPureXbase.g:5760:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // PsiInternalPureXbase.g:5761:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // PsiInternalPureXbase.g:5761:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // PsiInternalPureXbase.g:5762:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmUpperBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmUpperBoundAnded"


    // $ANTLR start "entryRuleJvmLowerBound"
    // PsiInternalPureXbase.g:5779:1: entryRuleJvmLowerBound returns [Boolean current=false] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final Boolean entryRuleJvmLowerBound() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJvmLowerBound = null;


        try {
            // PsiInternalPureXbase.g:5779:55: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // PsiInternalPureXbase.g:5780:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmLowerBoundElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmLowerBound"


    // $ANTLR start "ruleJvmLowerBound"
    // PsiInternalPureXbase.g:5786:1: ruleJvmLowerBound returns [Boolean current=false] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final Boolean ruleJvmLowerBound() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_typeReference_1_0 = null;


        try {
            // PsiInternalPureXbase.g:5787:1: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // PsiInternalPureXbase.g:5788:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // PsiInternalPureXbase.g:5788:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // PsiInternalPureXbase.g:5789:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getJvmLowerBound_SuperKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,69,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalPureXbase.g:5796:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // PsiInternalPureXbase.g:5797:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // PsiInternalPureXbase.g:5797:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // PsiInternalPureXbase.g:5798:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmLowerBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmLowerBound"


    // $ANTLR start "entryRuleJvmLowerBoundAnded"
    // PsiInternalPureXbase.g:5815:1: entryRuleJvmLowerBoundAnded returns [Boolean current=false] : iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF ;
    public final Boolean entryRuleJvmLowerBoundAnded() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJvmLowerBoundAnded = null;


        try {
            // PsiInternalPureXbase.g:5815:60: (iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF )
            // PsiInternalPureXbase.g:5816:2: iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmLowerBoundAndedElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmLowerBoundAnded=ruleJvmLowerBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBoundAnded; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmLowerBoundAnded"


    // $ANTLR start "ruleJvmLowerBoundAnded"
    // PsiInternalPureXbase.g:5822:1: ruleJvmLowerBoundAnded returns [Boolean current=false] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final Boolean ruleJvmLowerBoundAnded() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_typeReference_1_0 = null;


        try {
            // PsiInternalPureXbase.g:5823:1: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // PsiInternalPureXbase.g:5824:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // PsiInternalPureXbase.g:5824:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // PsiInternalPureXbase.g:5825:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getJvmLowerBoundAnded_AmpersandKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,83,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalPureXbase.g:5832:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // PsiInternalPureXbase.g:5833:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // PsiInternalPureXbase.g:5833:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // PsiInternalPureXbase.g:5834:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmLowerBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmLowerBoundAnded"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // PsiInternalPureXbase.g:5851:1: entryRuleQualifiedNameWithWildcard returns [Boolean current=false] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final Boolean entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleQualifiedNameWithWildcard = null;


        try {
            // PsiInternalPureXbase.g:5851:67: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // PsiInternalPureXbase.g:5852:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getQualifiedNameWithWildcardElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildcard; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // PsiInternalPureXbase.g:5858:1: ruleQualifiedNameWithWildcard returns [Boolean current=false] : ( ruleQualifiedName kw= '.' kw= '*' ) ;
    public final Boolean ruleQualifiedNameWithWildcard() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalPureXbase.g:5859:1: ( ( ruleQualifiedName kw= '.' kw= '*' ) )
            // PsiInternalPureXbase.g:5860:2: ( ruleQualifiedName kw= '.' kw= '*' )
            {
            // PsiInternalPureXbase.g:5860:2: ( ruleQualifiedName kw= '.' kw= '*' )
            // PsiInternalPureXbase.g:5861:3: ruleQualifiedName kw= '.' kw= '*'
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getQualifiedNameWithWildcard_QualifiedNameParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_72);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getQualifiedNameWithWildcard_FullStopKeyword_1ElementType());
              		
            }
            kw=(Token)match(input,46,FOLLOW_73); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getQualifiedNameWithWildcard_AsteriskKeyword_2ElementType());
              		
            }
            kw=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw);
              		
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
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "entryRuleValidID"
    // PsiInternalPureXbase.g:5886:1: entryRuleValidID returns [Boolean current=false] : iv_ruleValidID= ruleValidID EOF ;
    public final Boolean entryRuleValidID() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleValidID = null;


        try {
            // PsiInternalPureXbase.g:5886:49: (iv_ruleValidID= ruleValidID EOF )
            // PsiInternalPureXbase.g:5887:2: iv_ruleValidID= ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getValidIDElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleValidID=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // PsiInternalPureXbase.g:5893:1: ruleValidID returns [Boolean current=false] : this_ID_0= RULE_ID ;
    public final Boolean ruleValidID() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;

        try {
            // PsiInternalPureXbase.g:5894:1: (this_ID_0= RULE_ID )
            // PsiInternalPureXbase.g:5895:2: this_ID_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getValidID_IDTerminalRuleCallElementType());
              	
            }
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		doneLeaf(this_ID_0);
              	
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
    // $ANTLR end "ruleValidID"


    // $ANTLR start "entryRuleXImportSection"
    // PsiInternalPureXbase.g:5905:1: entryRuleXImportSection returns [Boolean current=false] : iv_ruleXImportSection= ruleXImportSection EOF ;
    public final Boolean entryRuleXImportSection() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXImportSection = null;


        try {
            // PsiInternalPureXbase.g:5905:56: (iv_ruleXImportSection= ruleXImportSection EOF )
            // PsiInternalPureXbase.g:5906:2: iv_ruleXImportSection= ruleXImportSection EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXImportSectionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXImportSection=ruleXImportSection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXImportSection; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXImportSection"


    // $ANTLR start "ruleXImportSection"
    // PsiInternalPureXbase.g:5912:1: ruleXImportSection returns [Boolean current=false] : ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+ ;
    public final Boolean ruleXImportSection() throws RecognitionException {
        Boolean current = false;

        Boolean lv_importDeclarations_0_0 = null;


        try {
            // PsiInternalPureXbase.g:5913:1: ( ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+ )
            // PsiInternalPureXbase.g:5914:2: ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+
            {
            // PsiInternalPureXbase.g:5914:2: ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+
            int cnt108=0;
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( (LA108_0==84) ) {
                    alt108=1;
                }


                switch (alt108) {
            	case 1 :
            	    // PsiInternalPureXbase.g:5915:3: (lv_importDeclarations_0_0= ruleXImportDeclaration )
            	    {
            	    // PsiInternalPureXbase.g:5915:3: (lv_importDeclarations_0_0= ruleXImportDeclaration )
            	    // PsiInternalPureXbase.g:5916:4: lv_importDeclarations_0_0= ruleXImportDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markComposite(elementTypeProvider.getXImportSection_ImportDeclarationsXImportDeclarationParserRuleCall_0ElementType());
            	      			
            	    }
            	    pushFollow(FOLLOW_74);
            	    lv_importDeclarations_0_0=ruleXImportDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneComposite();
            	      				if(!current) {
            	      					associateWithSemanticElement();
            	      					current = true;
            	      				}
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt108 >= 1 ) break loop108;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(108, input);
                        throw eee;
                }
                cnt108++;
            } while (true);


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
    // $ANTLR end "ruleXImportSection"


    // $ANTLR start "entryRuleXImportDeclaration"
    // PsiInternalPureXbase.g:5932:1: entryRuleXImportDeclaration returns [Boolean current=false] : iv_ruleXImportDeclaration= ruleXImportDeclaration EOF ;
    public final Boolean entryRuleXImportDeclaration() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXImportDeclaration = null;


        try {
            // PsiInternalPureXbase.g:5932:60: (iv_ruleXImportDeclaration= ruleXImportDeclaration EOF )
            // PsiInternalPureXbase.g:5933:2: iv_ruleXImportDeclaration= ruleXImportDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXImportDeclarationElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXImportDeclaration=ruleXImportDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXImportDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXImportDeclaration"


    // $ANTLR start "ruleXImportDeclaration"
    // PsiInternalPureXbase.g:5939:1: ruleXImportDeclaration returns [Boolean current=false] : (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) ;
    public final Boolean ruleXImportDeclaration() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_static_1_0=null;
        Token lv_extension_2_0=null;
        Token lv_wildcard_4_0=null;
        Token otherlv_8=null;
        Boolean lv_memberName_5_0 = null;

        Boolean lv_importedNamespace_7_0 = null;


        try {
            // PsiInternalPureXbase.g:5940:1: ( (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) )
            // PsiInternalPureXbase.g:5941:2: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
            {
            // PsiInternalPureXbase.g:5941:2: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
            // PsiInternalPureXbase.g:5942:3: otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )?
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXImportDeclaration_ImportKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,84,FOLLOW_75); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalPureXbase.g:5949:3: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )
            int alt111=3;
            alt111 = dfa111.predict(input);
            switch (alt111) {
                case 1 :
                    // PsiInternalPureXbase.g:5950:4: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
                    {
                    // PsiInternalPureXbase.g:5950:4: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
                    // PsiInternalPureXbase.g:5951:5: ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
                    {
                    // PsiInternalPureXbase.g:5951:5: ( (lv_static_1_0= 'static' ) )
                    // PsiInternalPureXbase.g:5952:6: (lv_static_1_0= 'static' )
                    {
                    // PsiInternalPureXbase.g:5952:6: (lv_static_1_0= 'static' )
                    // PsiInternalPureXbase.g:5953:7: lv_static_1_0= 'static'
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getXImportDeclaration_StaticStaticKeyword_1_0_0_0ElementType());
                      						
                    }
                    lv_static_1_0=(Token)match(input,85,FOLLOW_76); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(lv_static_1_0);
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:5968:5: ( (lv_extension_2_0= 'extension' ) )?
                    int alt109=2;
                    int LA109_0 = input.LA(1);

                    if ( (LA109_0==86) ) {
                        alt109=1;
                    }
                    switch (alt109) {
                        case 1 :
                            // PsiInternalPureXbase.g:5969:6: (lv_extension_2_0= 'extension' )
                            {
                            // PsiInternalPureXbase.g:5969:6: (lv_extension_2_0= 'extension' )
                            // PsiInternalPureXbase.g:5970:7: lv_extension_2_0= 'extension'
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getXImportDeclaration_ExtensionExtensionKeyword_1_0_1_0ElementType());
                              						
                            }
                            lv_extension_2_0=(Token)match(input,86,FOLLOW_76); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(lv_extension_2_0);
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (!current) {
                              								associateWithSemanticElement();
                              								current = true;
                              							}
                              						
                            }

                            }


                            }
                            break;

                    }

                    // PsiInternalPureXbase.g:5985:5: ( ( ruleQualifiedNameInStaticImport ) )
                    // PsiInternalPureXbase.g:5986:6: ( ruleQualifiedNameInStaticImport )
                    {
                    // PsiInternalPureXbase.g:5986:6: ( ruleQualifiedNameInStaticImport )
                    // PsiInternalPureXbase.g:5987:7: ruleQualifiedNameInStaticImport
                    {
                    if ( state.backtracking==0 ) {

                      							if (!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_77);
                    ruleQualifiedNameInStaticImport();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:6002:5: ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
                    int alt110=2;
                    int LA110_0 = input.LA(1);

                    if ( (LA110_0==38) ) {
                        alt110=1;
                    }
                    else if ( (LA110_0==RULE_ID) ) {
                        alt110=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 110, 0, input);

                        throw nvae;
                    }
                    switch (alt110) {
                        case 1 :
                            // PsiInternalPureXbase.g:6003:6: ( (lv_wildcard_4_0= '*' ) )
                            {
                            // PsiInternalPureXbase.g:6003:6: ( (lv_wildcard_4_0= '*' ) )
                            // PsiInternalPureXbase.g:6004:7: (lv_wildcard_4_0= '*' )
                            {
                            // PsiInternalPureXbase.g:6004:7: (lv_wildcard_4_0= '*' )
                            // PsiInternalPureXbase.g:6005:8: lv_wildcard_4_0= '*'
                            {
                            if ( state.backtracking==0 ) {

                              								markLeaf(elementTypeProvider.getXImportDeclaration_WildcardAsteriskKeyword_1_0_3_0_0ElementType());
                              							
                            }
                            lv_wildcard_4_0=(Token)match(input,38,FOLLOW_78); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								doneLeaf(lv_wildcard_4_0);
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalPureXbase.g:6021:6: ( (lv_memberName_5_0= ruleValidID ) )
                            {
                            // PsiInternalPureXbase.g:6021:6: ( (lv_memberName_5_0= ruleValidID ) )
                            // PsiInternalPureXbase.g:6022:7: (lv_memberName_5_0= ruleValidID )
                            {
                            // PsiInternalPureXbase.g:6022:7: (lv_memberName_5_0= ruleValidID )
                            // PsiInternalPureXbase.g:6023:8: lv_memberName_5_0= ruleValidID
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getXImportDeclaration_MemberNameValidIDParserRuleCall_1_0_3_1_0ElementType());
                              							
                            }
                            pushFollow(FOLLOW_78);
                            lv_memberName_5_0=ruleValidID();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              								if(!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:6039:4: ( ( ruleQualifiedName ) )
                    {
                    // PsiInternalPureXbase.g:6039:4: ( ( ruleQualifiedName ) )
                    // PsiInternalPureXbase.g:6040:5: ( ruleQualifiedName )
                    {
                    // PsiInternalPureXbase.g:6040:5: ( ruleQualifiedName )
                    // PsiInternalPureXbase.g:6041:6: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_78);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalPureXbase.g:6057:4: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
                    {
                    // PsiInternalPureXbase.g:6057:4: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
                    // PsiInternalPureXbase.g:6058:5: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
                    {
                    // PsiInternalPureXbase.g:6058:5: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
                    // PsiInternalPureXbase.g:6059:6: lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXImportDeclaration_ImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_78);
                    lv_importedNamespace_7_0=ruleQualifiedNameWithWildcard();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalPureXbase.g:6073:3: (otherlv_8= ';' )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==13) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // PsiInternalPureXbase.g:6074:4: otherlv_8= ';'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXImportDeclaration_SemicolonKeyword_2ElementType());
                      			
                    }
                    otherlv_8=(Token)match(input,13,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_8);
                      			
                    }

                    }
                    break;

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
    // $ANTLR end "ruleXImportDeclaration"


    // $ANTLR start "entryRuleQualifiedNameInStaticImport"
    // PsiInternalPureXbase.g:6086:1: entryRuleQualifiedNameInStaticImport returns [Boolean current=false] : iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF ;
    public final Boolean entryRuleQualifiedNameInStaticImport() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleQualifiedNameInStaticImport = null;


        try {
            // PsiInternalPureXbase.g:6086:69: (iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF )
            // PsiInternalPureXbase.g:6087:2: iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getQualifiedNameInStaticImportElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedNameInStaticImport=ruleQualifiedNameInStaticImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameInStaticImport; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleQualifiedNameInStaticImport"


    // $ANTLR start "ruleQualifiedNameInStaticImport"
    // PsiInternalPureXbase.g:6093:1: ruleQualifiedNameInStaticImport returns [Boolean current=false] : ( ruleValidID kw= '.' )+ ;
    public final Boolean ruleQualifiedNameInStaticImport() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalPureXbase.g:6094:1: ( ( ruleValidID kw= '.' )+ )
            // PsiInternalPureXbase.g:6095:2: ( ruleValidID kw= '.' )+
            {
            // PsiInternalPureXbase.g:6095:2: ( ruleValidID kw= '.' )+
            int cnt113=0;
            loop113:
            do {
                int alt113=2;
                int LA113_0 = input.LA(1);

                if ( (LA113_0==RULE_ID) ) {
                    int LA113_2 = input.LA(2);

                    if ( (LA113_2==46) ) {
                        alt113=1;
                    }


                }


                switch (alt113) {
            	case 1 :
            	    // PsiInternalPureXbase.g:6096:3: ruleValidID kw= '.'
            	    {
            	    if ( state.backtracking==0 ) {

            	      			markComposite(elementTypeProvider.getQualifiedNameInStaticImport_ValidIDParserRuleCall_0ElementType());
            	      		
            	    }
            	    pushFollow(FOLLOW_72);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			doneComposite();
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			markLeaf(elementTypeProvider.getQualifiedNameInStaticImport_FullStopKeyword_1ElementType());
            	      		
            	    }
            	    kw=(Token)match(input,46,FOLLOW_79); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			doneLeaf(kw);
            	      		
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt113 >= 1 ) break loop113;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(113, input);
                        throw eee;
                }
                cnt113++;
            } while (true);


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
    // $ANTLR end "ruleQualifiedNameInStaticImport"

    // $ANTLR start synpred1_PsiInternalPureXbase
    public final void synpred1_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:252:6: ( ( () ( ( ruleOpMultiAssign ) ) ) )
        // PsiInternalPureXbase.g:252:7: ( () ( ( ruleOpMultiAssign ) ) )
        {
        // PsiInternalPureXbase.g:252:7: ( () ( ( ruleOpMultiAssign ) ) )
        // PsiInternalPureXbase.g:253:7: () ( ( ruleOpMultiAssign ) )
        {
        // PsiInternalPureXbase.g:253:7: ()
        // PsiInternalPureXbase.g:254:7: 
        {
        }

        // PsiInternalPureXbase.g:255:7: ( ( ruleOpMultiAssign ) )
        // PsiInternalPureXbase.g:256:8: ( ruleOpMultiAssign )
        {
        // PsiInternalPureXbase.g:256:8: ( ruleOpMultiAssign )
        // PsiInternalPureXbase.g:257:9: ruleOpMultiAssign
        {
        pushFollow(FOLLOW_2);
        ruleOpMultiAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_PsiInternalPureXbase

    // $ANTLR start synpred2_PsiInternalPureXbase
    public final void synpred2_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:452:5: ( ( () ( ( ruleOpOr ) ) ) )
        // PsiInternalPureXbase.g:452:6: ( () ( ( ruleOpOr ) ) )
        {
        // PsiInternalPureXbase.g:452:6: ( () ( ( ruleOpOr ) ) )
        // PsiInternalPureXbase.g:453:6: () ( ( ruleOpOr ) )
        {
        // PsiInternalPureXbase.g:453:6: ()
        // PsiInternalPureXbase.g:454:6: 
        {
        }

        // PsiInternalPureXbase.g:455:6: ( ( ruleOpOr ) )
        // PsiInternalPureXbase.g:456:7: ( ruleOpOr )
        {
        // PsiInternalPureXbase.g:456:7: ( ruleOpOr )
        // PsiInternalPureXbase.g:457:8: ruleOpOr
        {
        pushFollow(FOLLOW_2);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_PsiInternalPureXbase

    // $ANTLR start synpred3_PsiInternalPureXbase
    public final void synpred3_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:548:5: ( ( () ( ( ruleOpAnd ) ) ) )
        // PsiInternalPureXbase.g:548:6: ( () ( ( ruleOpAnd ) ) )
        {
        // PsiInternalPureXbase.g:548:6: ( () ( ( ruleOpAnd ) ) )
        // PsiInternalPureXbase.g:549:6: () ( ( ruleOpAnd ) )
        {
        // PsiInternalPureXbase.g:549:6: ()
        // PsiInternalPureXbase.g:550:6: 
        {
        }

        // PsiInternalPureXbase.g:551:6: ( ( ruleOpAnd ) )
        // PsiInternalPureXbase.g:552:7: ( ruleOpAnd )
        {
        // PsiInternalPureXbase.g:552:7: ( ruleOpAnd )
        // PsiInternalPureXbase.g:553:8: ruleOpAnd
        {
        pushFollow(FOLLOW_2);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_PsiInternalPureXbase

    // $ANTLR start synpred4_PsiInternalPureXbase
    public final void synpred4_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:644:5: ( ( () ( ( ruleOpEquality ) ) ) )
        // PsiInternalPureXbase.g:644:6: ( () ( ( ruleOpEquality ) ) )
        {
        // PsiInternalPureXbase.g:644:6: ( () ( ( ruleOpEquality ) ) )
        // PsiInternalPureXbase.g:645:6: () ( ( ruleOpEquality ) )
        {
        // PsiInternalPureXbase.g:645:6: ()
        // PsiInternalPureXbase.g:646:6: 
        {
        }

        // PsiInternalPureXbase.g:647:6: ( ( ruleOpEquality ) )
        // PsiInternalPureXbase.g:648:7: ( ruleOpEquality )
        {
        // PsiInternalPureXbase.g:648:7: ( ruleOpEquality )
        // PsiInternalPureXbase.g:649:8: ruleOpEquality
        {
        pushFollow(FOLLOW_2);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4_PsiInternalPureXbase

    // $ANTLR start synpred5_PsiInternalPureXbase
    public final void synpred5_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:767:6: ( ( () 'instanceof' ) )
        // PsiInternalPureXbase.g:767:7: ( () 'instanceof' )
        {
        // PsiInternalPureXbase.g:767:7: ( () 'instanceof' )
        // PsiInternalPureXbase.g:768:7: () 'instanceof'
        {
        // PsiInternalPureXbase.g:768:7: ()
        // PsiInternalPureXbase.g:769:7: 
        {
        }

        match(input,29,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_PsiInternalPureXbase

    // $ANTLR start synpred6_PsiInternalPureXbase
    public final void synpred6_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:809:6: ( ( () ( ( ruleOpCompare ) ) ) )
        // PsiInternalPureXbase.g:809:7: ( () ( ( ruleOpCompare ) ) )
        {
        // PsiInternalPureXbase.g:809:7: ( () ( ( ruleOpCompare ) ) )
        // PsiInternalPureXbase.g:810:7: () ( ( ruleOpCompare ) )
        {
        // PsiInternalPureXbase.g:810:7: ()
        // PsiInternalPureXbase.g:811:7: 
        {
        }

        // PsiInternalPureXbase.g:812:7: ( ( ruleOpCompare ) )
        // PsiInternalPureXbase.g:813:8: ( ruleOpCompare )
        {
        // PsiInternalPureXbase.g:813:8: ( ruleOpCompare )
        // PsiInternalPureXbase.g:814:9: ruleOpCompare
        {
        pushFollow(FOLLOW_2);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred6_PsiInternalPureXbase

    // $ANTLR start synpred7_PsiInternalPureXbase
    public final void synpred7_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:941:5: ( ( () ( ( ruleOpOther ) ) ) )
        // PsiInternalPureXbase.g:941:6: ( () ( ( ruleOpOther ) ) )
        {
        // PsiInternalPureXbase.g:941:6: ( () ( ( ruleOpOther ) ) )
        // PsiInternalPureXbase.g:942:6: () ( ( ruleOpOther ) )
        {
        // PsiInternalPureXbase.g:942:6: ()
        // PsiInternalPureXbase.g:943:6: 
        {
        }

        // PsiInternalPureXbase.g:944:6: ( ( ruleOpOther ) )
        // PsiInternalPureXbase.g:945:7: ( ruleOpOther )
        {
        // PsiInternalPureXbase.g:945:7: ( ruleOpOther )
        // PsiInternalPureXbase.g:946:8: ruleOpOther
        {
        pushFollow(FOLLOW_2);
        ruleOpOther();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred7_PsiInternalPureXbase

    // $ANTLR start synpred8_PsiInternalPureXbase
    public final void synpred8_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:1067:6: ( ( '>' '>' ) )
        // PsiInternalPureXbase.g:1067:7: ( '>' '>' )
        {
        // PsiInternalPureXbase.g:1067:7: ( '>' '>' )
        // PsiInternalPureXbase.g:1068:7: '>' '>'
        {
        match(input,21,FOLLOW_18); if (state.failed) return ;
        match(input,21,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_PsiInternalPureXbase

    // $ANTLR start synpred9_PsiInternalPureXbase
    public final void synpred9_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:1110:6: ( ( '<' '<' ) )
        // PsiInternalPureXbase.g:1110:7: ( '<' '<' )
        {
        // PsiInternalPureXbase.g:1110:7: ( '<' '<' )
        // PsiInternalPureXbase.g:1111:7: '<' '<'
        {
        match(input,20,FOLLOW_8); if (state.failed) return ;
        match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred9_PsiInternalPureXbase

    // $ANTLR start synpred10_PsiInternalPureXbase
    public final void synpred10_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:1190:5: ( ( () ( ( ruleOpAdd ) ) ) )
        // PsiInternalPureXbase.g:1190:6: ( () ( ( ruleOpAdd ) ) )
        {
        // PsiInternalPureXbase.g:1190:6: ( () ( ( ruleOpAdd ) ) )
        // PsiInternalPureXbase.g:1191:6: () ( ( ruleOpAdd ) )
        {
        // PsiInternalPureXbase.g:1191:6: ()
        // PsiInternalPureXbase.g:1192:6: 
        {
        }

        // PsiInternalPureXbase.g:1193:6: ( ( ruleOpAdd ) )
        // PsiInternalPureXbase.g:1194:7: ( ruleOpAdd )
        {
        // PsiInternalPureXbase.g:1194:7: ( ruleOpAdd )
        // PsiInternalPureXbase.g:1195:8: ruleOpAdd
        {
        pushFollow(FOLLOW_2);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred10_PsiInternalPureXbase

    // $ANTLR start synpred11_PsiInternalPureXbase
    public final void synpred11_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:1296:5: ( ( () ( ( ruleOpMulti ) ) ) )
        // PsiInternalPureXbase.g:1296:6: ( () ( ( ruleOpMulti ) ) )
        {
        // PsiInternalPureXbase.g:1296:6: ( () ( ( ruleOpMulti ) ) )
        // PsiInternalPureXbase.g:1297:6: () ( ( ruleOpMulti ) )
        {
        // PsiInternalPureXbase.g:1297:6: ()
        // PsiInternalPureXbase.g:1298:6: 
        {
        }

        // PsiInternalPureXbase.g:1299:6: ( ( ruleOpMulti ) )
        // PsiInternalPureXbase.g:1300:7: ( ruleOpMulti )
        {
        // PsiInternalPureXbase.g:1300:7: ( ruleOpMulti )
        // PsiInternalPureXbase.g:1301:8: ruleOpMulti
        {
        pushFollow(FOLLOW_2);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred11_PsiInternalPureXbase

    // $ANTLR start synpred12_PsiInternalPureXbase
    public final void synpred12_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:1519:5: ( ( () 'as' ) )
        // PsiInternalPureXbase.g:1519:6: ( () 'as' )
        {
        // PsiInternalPureXbase.g:1519:6: ( () 'as' )
        // PsiInternalPureXbase.g:1520:6: () 'as'
        {
        // PsiInternalPureXbase.g:1520:6: ()
        // PsiInternalPureXbase.g:1521:6: 
        {
        }

        match(input,43,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred12_PsiInternalPureXbase

    // $ANTLR start synpred13_PsiInternalPureXbase
    public final void synpred13_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:1581:4: ( ( () ( ( ruleOpPostfix ) ) ) )
        // PsiInternalPureXbase.g:1581:5: ( () ( ( ruleOpPostfix ) ) )
        {
        // PsiInternalPureXbase.g:1581:5: ( () ( ( ruleOpPostfix ) ) )
        // PsiInternalPureXbase.g:1582:5: () ( ( ruleOpPostfix ) )
        {
        // PsiInternalPureXbase.g:1582:5: ()
        // PsiInternalPureXbase.g:1583:5: 
        {
        }

        // PsiInternalPureXbase.g:1584:5: ( ( ruleOpPostfix ) )
        // PsiInternalPureXbase.g:1585:6: ( ruleOpPostfix )
        {
        // PsiInternalPureXbase.g:1585:6: ( ruleOpPostfix )
        // PsiInternalPureXbase.g:1586:7: ruleOpPostfix
        {
        pushFollow(FOLLOW_2);
        ruleOpPostfix();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred13_PsiInternalPureXbase

    // $ANTLR start synpred14_PsiInternalPureXbase
    public final void synpred14_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:1672:6: ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
        // PsiInternalPureXbase.g:1672:7: ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
        {
        // PsiInternalPureXbase.g:1672:7: ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
        // PsiInternalPureXbase.g:1673:7: () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
        {
        // PsiInternalPureXbase.g:1673:7: ()
        // PsiInternalPureXbase.g:1674:7: 
        {
        }

        // PsiInternalPureXbase.g:1675:7: ( '.' | ( ( '::' ) ) )
        int alt114=2;
        int LA114_0 = input.LA(1);

        if ( (LA114_0==46) ) {
            alt114=1;
        }
        else if ( (LA114_0==47) ) {
            alt114=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 114, 0, input);

            throw nvae;
        }
        switch (alt114) {
            case 1 :
                // PsiInternalPureXbase.g:1676:8: '.'
                {
                match(input,46,FOLLOW_25); if (state.failed) return ;

                }
                break;
            case 2 :
                // PsiInternalPureXbase.g:1678:8: ( ( '::' ) )
                {
                // PsiInternalPureXbase.g:1678:8: ( ( '::' ) )
                // PsiInternalPureXbase.g:1679:9: ( '::' )
                {
                // PsiInternalPureXbase.g:1679:9: ( '::' )
                // PsiInternalPureXbase.g:1680:10: '::'
                {
                match(input,47,FOLLOW_25); if (state.failed) return ;

                }


                }


                }
                break;

        }

        // PsiInternalPureXbase.g:1684:7: ( ( ruleFeatureCallID ) )
        // PsiInternalPureXbase.g:1685:8: ( ruleFeatureCallID )
        {
        // PsiInternalPureXbase.g:1685:8: ( ruleFeatureCallID )
        // PsiInternalPureXbase.g:1686:9: ruleFeatureCallID
        {
        pushFollow(FOLLOW_6);
        ruleFeatureCallID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        pushFollow(FOLLOW_2);
        ruleOpSingleAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred14_PsiInternalPureXbase

    // $ANTLR start synpred15_PsiInternalPureXbase
    public final void synpred15_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:1772:6: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )
        // PsiInternalPureXbase.g:1772:7: ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) )
        {
        // PsiInternalPureXbase.g:1772:7: ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) )
        // PsiInternalPureXbase.g:1773:7: () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) )
        {
        // PsiInternalPureXbase.g:1773:7: ()
        // PsiInternalPureXbase.g:1774:7: 
        {
        }

        // PsiInternalPureXbase.g:1775:7: ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) )
        int alt115=3;
        switch ( input.LA(1) ) {
        case 46:
            {
            alt115=1;
            }
            break;
        case 48:
            {
            alt115=2;
            }
            break;
        case 47:
            {
            alt115=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 115, 0, input);

            throw nvae;
        }

        switch (alt115) {
            case 1 :
                // PsiInternalPureXbase.g:1776:8: '.'
                {
                match(input,46,FOLLOW_2); if (state.failed) return ;

                }
                break;
            case 2 :
                // PsiInternalPureXbase.g:1778:8: ( ( '?.' ) )
                {
                // PsiInternalPureXbase.g:1778:8: ( ( '?.' ) )
                // PsiInternalPureXbase.g:1779:9: ( '?.' )
                {
                // PsiInternalPureXbase.g:1779:9: ( '?.' )
                // PsiInternalPureXbase.g:1780:10: '?.'
                {
                match(input,48,FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;
            case 3 :
                // PsiInternalPureXbase.g:1784:8: ( ( '::' ) )
                {
                // PsiInternalPureXbase.g:1784:8: ( ( '::' ) )
                // PsiInternalPureXbase.g:1785:9: ( '::' )
                {
                // PsiInternalPureXbase.g:1785:9: ( '::' )
                // PsiInternalPureXbase.g:1786:10: '::'
                {
                match(input,47,FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred15_PsiInternalPureXbase

    // $ANTLR start synpred16_PsiInternalPureXbase
    public final void synpred16_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:1921:7: ( ( '(' ) )
        // PsiInternalPureXbase.g:1921:8: ( '(' )
        {
        // PsiInternalPureXbase.g:1921:8: ( '(' )
        // PsiInternalPureXbase.g:1922:8: '('
        {
        match(input,50,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred16_PsiInternalPureXbase

    // $ANTLR start synpred17_PsiInternalPureXbase
    public final void synpred17_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:1943:8: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // PsiInternalPureXbase.g:1943:9: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // PsiInternalPureXbase.g:1943:9: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // PsiInternalPureXbase.g:1944:9: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // PsiInternalPureXbase.g:1944:9: ()
        // PsiInternalPureXbase.g:1945:9: 
        {
        }

        // PsiInternalPureXbase.g:1946:9: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt117=2;
        int LA117_0 = input.LA(1);

        if ( (LA117_0==RULE_ID||LA117_0==33||LA117_0==50) ) {
            alt117=1;
        }
        switch (alt117) {
            case 1 :
                // PsiInternalPureXbase.g:1947:10: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // PsiInternalPureXbase.g:1947:10: ( ( ruleJvmFormalParameter ) )
                // PsiInternalPureXbase.g:1948:11: ( ruleJvmFormalParameter )
                {
                // PsiInternalPureXbase.g:1948:11: ( ruleJvmFormalParameter )
                // PsiInternalPureXbase.g:1949:12: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_41);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // PsiInternalPureXbase.g:1952:10: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop116:
                do {
                    int alt116=2;
                    int LA116_0 = input.LA(1);

                    if ( (LA116_0==49) ) {
                        alt116=1;
                    }


                    switch (alt116) {
                	case 1 :
                	    // PsiInternalPureXbase.g:1953:11: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,49,FOLLOW_15); if (state.failed) return ;
                	    // PsiInternalPureXbase.g:1954:11: ( ( ruleJvmFormalParameter ) )
                	    // PsiInternalPureXbase.g:1955:12: ( ruleJvmFormalParameter )
                	    {
                	    // PsiInternalPureXbase.g:1955:12: ( ruleJvmFormalParameter )
                	    // PsiInternalPureXbase.g:1956:13: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_41);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop116;
                    }
                } while (true);


                }
                break;

        }

        // PsiInternalPureXbase.g:1961:9: ( ( '|' ) )
        // PsiInternalPureXbase.g:1962:10: ( '|' )
        {
        // PsiInternalPureXbase.g:1962:10: ( '|' )
        // PsiInternalPureXbase.g:1963:11: '|'
        {
        match(input,57,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred17_PsiInternalPureXbase

    // $ANTLR start synpred18_PsiInternalPureXbase
    public final void synpred18_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:2034:6: ( ( () '[' ) )
        // PsiInternalPureXbase.g:2034:7: ( () '[' )
        {
        // PsiInternalPureXbase.g:2034:7: ( () '[' )
        // PsiInternalPureXbase.g:2035:7: () '['
        {
        // PsiInternalPureXbase.g:2035:7: ()
        // PsiInternalPureXbase.g:2036:7: 
        {
        }

        match(input,55,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred18_PsiInternalPureXbase

    // $ANTLR start synpred19_PsiInternalPureXbase
    public final void synpred19_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:2098:4: ( ( () 'synchronized' '(' ) )
        // PsiInternalPureXbase.g:2098:5: ( () 'synchronized' '(' )
        {
        // PsiInternalPureXbase.g:2098:5: ( () 'synchronized' '(' )
        // PsiInternalPureXbase.g:2099:5: () 'synchronized' '('
        {
        // PsiInternalPureXbase.g:2099:5: ()
        // PsiInternalPureXbase.g:2100:5: 
        {
        }

        match(input,79,FOLLOW_43); if (state.failed) return ;
        match(input,50,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred19_PsiInternalPureXbase

    // $ANTLR start synpred20_PsiInternalPureXbase
    public final void synpred20_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:2143:4: ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )
        // PsiInternalPureXbase.g:2143:5: ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' )
        {
        // PsiInternalPureXbase.g:2143:5: ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' )
        // PsiInternalPureXbase.g:2144:5: () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':'
        {
        // PsiInternalPureXbase.g:2144:5: ()
        // PsiInternalPureXbase.g:2145:5: 
        {
        }

        match(input,64,FOLLOW_43); if (state.failed) return ;
        match(input,50,FOLLOW_15); if (state.failed) return ;
        // PsiInternalPureXbase.g:2148:5: ( ( ruleJvmFormalParameter ) )
        // PsiInternalPureXbase.g:2149:6: ( ruleJvmFormalParameter )
        {
        // PsiInternalPureXbase.g:2149:6: ( ruleJvmFormalParameter )
        // PsiInternalPureXbase.g:2150:7: ruleJvmFormalParameter
        {
        pushFollow(FOLLOW_46);
        ruleJvmFormalParameter();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,61,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred20_PsiInternalPureXbase

    // $ANTLR start synpred21_PsiInternalPureXbase
    public final void synpred21_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:2252:4: ( ( () '[' ) )
        // PsiInternalPureXbase.g:2252:5: ( () '[' )
        {
        // PsiInternalPureXbase.g:2252:5: ( () '[' )
        // PsiInternalPureXbase.g:2253:5: () '['
        {
        // PsiInternalPureXbase.g:2253:5: ()
        // PsiInternalPureXbase.g:2254:5: 
        {
        }

        match(input,55,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred21_PsiInternalPureXbase

    // $ANTLR start synpred23_PsiInternalPureXbase
    public final void synpred23_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:2548:4: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // PsiInternalPureXbase.g:2548:5: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // PsiInternalPureXbase.g:2548:5: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // PsiInternalPureXbase.g:2549:5: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // PsiInternalPureXbase.g:2549:5: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt119=2;
        int LA119_0 = input.LA(1);

        if ( (LA119_0==RULE_ID||LA119_0==33||LA119_0==50) ) {
            alt119=1;
        }
        switch (alt119) {
            case 1 :
                // PsiInternalPureXbase.g:2550:6: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // PsiInternalPureXbase.g:2550:6: ( ( ruleJvmFormalParameter ) )
                // PsiInternalPureXbase.g:2551:7: ( ruleJvmFormalParameter )
                {
                // PsiInternalPureXbase.g:2551:7: ( ruleJvmFormalParameter )
                // PsiInternalPureXbase.g:2552:8: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_41);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // PsiInternalPureXbase.g:2555:6: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop118:
                do {
                    int alt118=2;
                    int LA118_0 = input.LA(1);

                    if ( (LA118_0==49) ) {
                        alt118=1;
                    }


                    switch (alt118) {
                	case 1 :
                	    // PsiInternalPureXbase.g:2556:7: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,49,FOLLOW_15); if (state.failed) return ;
                	    // PsiInternalPureXbase.g:2557:7: ( ( ruleJvmFormalParameter ) )
                	    // PsiInternalPureXbase.g:2558:8: ( ruleJvmFormalParameter )
                	    {
                	    // PsiInternalPureXbase.g:2558:8: ( ruleJvmFormalParameter )
                	    // PsiInternalPureXbase.g:2559:9: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_41);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop118;
                    }
                } while (true);


                }
                break;

        }

        // PsiInternalPureXbase.g:2564:5: ( ( '|' ) )
        // PsiInternalPureXbase.g:2565:6: ( '|' )
        {
        // PsiInternalPureXbase.g:2565:6: ( '|' )
        // PsiInternalPureXbase.g:2566:7: '|'
        {
        match(input,57,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred23_PsiInternalPureXbase

    // $ANTLR start synpred25_PsiInternalPureXbase
    public final void synpred25_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:2934:5: ( 'else' )
        // PsiInternalPureXbase.g:2934:6: 'else'
        {
        match(input,59,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_PsiInternalPureXbase

    // $ANTLR start synpred26_PsiInternalPureXbase
    public final void synpred26_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:2990:6: ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )
        // PsiInternalPureXbase.g:2990:7: ( '(' ( ( ruleJvmFormalParameter ) ) ':' )
        {
        // PsiInternalPureXbase.g:2990:7: ( '(' ( ( ruleJvmFormalParameter ) ) ':' )
        // PsiInternalPureXbase.g:2991:7: '(' ( ( ruleJvmFormalParameter ) ) ':'
        {
        match(input,50,FOLLOW_15); if (state.failed) return ;
        // PsiInternalPureXbase.g:2992:7: ( ( ruleJvmFormalParameter ) )
        // PsiInternalPureXbase.g:2993:8: ( ruleJvmFormalParameter )
        {
        // PsiInternalPureXbase.g:2993:8: ( ruleJvmFormalParameter )
        // PsiInternalPureXbase.g:2994:9: ruleJvmFormalParameter
        {
        pushFollow(FOLLOW_46);
        ruleJvmFormalParameter();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,61,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred26_PsiInternalPureXbase

    // $ANTLR start synpred27_PsiInternalPureXbase
    public final void synpred27_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:3058:6: ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )
        // PsiInternalPureXbase.g:3058:7: ( ( ( ruleJvmFormalParameter ) ) ':' )
        {
        // PsiInternalPureXbase.g:3058:7: ( ( ( ruleJvmFormalParameter ) ) ':' )
        // PsiInternalPureXbase.g:3059:7: ( ( ruleJvmFormalParameter ) ) ':'
        {
        // PsiInternalPureXbase.g:3059:7: ( ( ruleJvmFormalParameter ) )
        // PsiInternalPureXbase.g:3060:8: ( ruleJvmFormalParameter )
        {
        // PsiInternalPureXbase.g:3060:8: ( ruleJvmFormalParameter )
        // PsiInternalPureXbase.g:3061:9: ruleJvmFormalParameter
        {
        pushFollow(FOLLOW_46);
        ruleJvmFormalParameter();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,61,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred27_PsiInternalPureXbase

    // $ANTLR start synpred29_PsiInternalPureXbase
    public final void synpred29_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:3845:5: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )
        // PsiInternalPureXbase.g:3845:6: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        {
        // PsiInternalPureXbase.g:3845:6: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        // PsiInternalPureXbase.g:3846:6: ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) )
        {
        // PsiInternalPureXbase.g:3846:6: ( ( ruleJvmTypeReference ) )
        // PsiInternalPureXbase.g:3847:7: ( ruleJvmTypeReference )
        {
        // PsiInternalPureXbase.g:3847:7: ( ruleJvmTypeReference )
        // PsiInternalPureXbase.g:3848:8: ruleJvmTypeReference
        {
        pushFollow(FOLLOW_25);
        ruleJvmTypeReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // PsiInternalPureXbase.g:3851:6: ( ( ruleValidID ) )
        // PsiInternalPureXbase.g:3852:7: ( ruleValidID )
        {
        // PsiInternalPureXbase.g:3852:7: ( ruleValidID )
        // PsiInternalPureXbase.g:3853:8: ruleValidID
        {
        pushFollow(FOLLOW_2);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred29_PsiInternalPureXbase

    // $ANTLR start synpred30_PsiInternalPureXbase
    public final void synpred30_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:4115:5: ( ( '(' ) )
        // PsiInternalPureXbase.g:4115:6: ( '(' )
        {
        // PsiInternalPureXbase.g:4115:6: ( '(' )
        // PsiInternalPureXbase.g:4116:6: '('
        {
        match(input,50,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred30_PsiInternalPureXbase

    // $ANTLR start synpred31_PsiInternalPureXbase
    public final void synpred31_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:4137:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // PsiInternalPureXbase.g:4137:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // PsiInternalPureXbase.g:4137:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // PsiInternalPureXbase.g:4138:7: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // PsiInternalPureXbase.g:4138:7: ()
        // PsiInternalPureXbase.g:4139:7: 
        {
        }

        // PsiInternalPureXbase.g:4140:7: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt123=2;
        int LA123_0 = input.LA(1);

        if ( (LA123_0==RULE_ID||LA123_0==33||LA123_0==50) ) {
            alt123=1;
        }
        switch (alt123) {
            case 1 :
                // PsiInternalPureXbase.g:4141:8: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // PsiInternalPureXbase.g:4141:8: ( ( ruleJvmFormalParameter ) )
                // PsiInternalPureXbase.g:4142:9: ( ruleJvmFormalParameter )
                {
                // PsiInternalPureXbase.g:4142:9: ( ruleJvmFormalParameter )
                // PsiInternalPureXbase.g:4143:10: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_41);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // PsiInternalPureXbase.g:4146:8: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop122:
                do {
                    int alt122=2;
                    int LA122_0 = input.LA(1);

                    if ( (LA122_0==49) ) {
                        alt122=1;
                    }


                    switch (alt122) {
                	case 1 :
                	    // PsiInternalPureXbase.g:4147:9: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,49,FOLLOW_15); if (state.failed) return ;
                	    // PsiInternalPureXbase.g:4148:9: ( ( ruleJvmFormalParameter ) )
                	    // PsiInternalPureXbase.g:4149:10: ( ruleJvmFormalParameter )
                	    {
                	    // PsiInternalPureXbase.g:4149:10: ( ruleJvmFormalParameter )
                	    // PsiInternalPureXbase.g:4150:11: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_41);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop122;
                    }
                } while (true);


                }
                break;

        }

        // PsiInternalPureXbase.g:4155:7: ( ( '|' ) )
        // PsiInternalPureXbase.g:4156:8: ( '|' )
        {
        // PsiInternalPureXbase.g:4156:8: ( '|' )
        // PsiInternalPureXbase.g:4157:9: '|'
        {
        match(input,57,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred31_PsiInternalPureXbase

    // $ANTLR start synpred32_PsiInternalPureXbase
    public final void synpred32_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:4228:4: ( ( () '[' ) )
        // PsiInternalPureXbase.g:4228:5: ( () '[' )
        {
        // PsiInternalPureXbase.g:4228:5: ( () '[' )
        // PsiInternalPureXbase.g:4229:5: () '['
        {
        // PsiInternalPureXbase.g:4229:5: ()
        // PsiInternalPureXbase.g:4230:5: 
        {
        }

        match(input,55,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred32_PsiInternalPureXbase

    // $ANTLR start synpred33_PsiInternalPureXbase
    public final void synpred33_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:4324:5: ( '<' )
        // PsiInternalPureXbase.g:4324:6: '<'
        {
        match(input,20,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_PsiInternalPureXbase

    // $ANTLR start synpred34_PsiInternalPureXbase
    public final void synpred34_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:4382:5: ( ( '(' ) )
        // PsiInternalPureXbase.g:4382:6: ( '(' )
        {
        // PsiInternalPureXbase.g:4382:6: ( '(' )
        // PsiInternalPureXbase.g:4383:6: '('
        {
        match(input,50,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred34_PsiInternalPureXbase

    // $ANTLR start synpred35_PsiInternalPureXbase
    public final void synpred35_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:4404:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // PsiInternalPureXbase.g:4404:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // PsiInternalPureXbase.g:4404:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // PsiInternalPureXbase.g:4405:7: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // PsiInternalPureXbase.g:4405:7: ()
        // PsiInternalPureXbase.g:4406:7: 
        {
        }

        // PsiInternalPureXbase.g:4407:7: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt125=2;
        int LA125_0 = input.LA(1);

        if ( (LA125_0==RULE_ID||LA125_0==33||LA125_0==50) ) {
            alt125=1;
        }
        switch (alt125) {
            case 1 :
                // PsiInternalPureXbase.g:4408:8: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // PsiInternalPureXbase.g:4408:8: ( ( ruleJvmFormalParameter ) )
                // PsiInternalPureXbase.g:4409:9: ( ruleJvmFormalParameter )
                {
                // PsiInternalPureXbase.g:4409:9: ( ruleJvmFormalParameter )
                // PsiInternalPureXbase.g:4410:10: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_41);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // PsiInternalPureXbase.g:4413:8: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop124:
                do {
                    int alt124=2;
                    int LA124_0 = input.LA(1);

                    if ( (LA124_0==49) ) {
                        alt124=1;
                    }


                    switch (alt124) {
                	case 1 :
                	    // PsiInternalPureXbase.g:4414:9: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,49,FOLLOW_15); if (state.failed) return ;
                	    // PsiInternalPureXbase.g:4415:9: ( ( ruleJvmFormalParameter ) )
                	    // PsiInternalPureXbase.g:4416:10: ( ruleJvmFormalParameter )
                	    {
                	    // PsiInternalPureXbase.g:4416:10: ( ruleJvmFormalParameter )
                	    // PsiInternalPureXbase.g:4417:11: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_41);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop124;
                    }
                } while (true);


                }
                break;

        }

        // PsiInternalPureXbase.g:4422:7: ( ( '|' ) )
        // PsiInternalPureXbase.g:4423:8: ( '|' )
        {
        // PsiInternalPureXbase.g:4423:8: ( '|' )
        // PsiInternalPureXbase.g:4424:9: '|'
        {
        match(input,57,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred35_PsiInternalPureXbase

    // $ANTLR start synpred36_PsiInternalPureXbase
    public final void synpred36_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:4495:4: ( ( () '[' ) )
        // PsiInternalPureXbase.g:4495:5: ( () '[' )
        {
        // PsiInternalPureXbase.g:4495:5: ( () '[' )
        // PsiInternalPureXbase.g:4496:5: () '['
        {
        // PsiInternalPureXbase.g:4496:5: ()
        // PsiInternalPureXbase.g:4497:5: 
        {
        }

        match(input,55,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred36_PsiInternalPureXbase

    // $ANTLR start synpred37_PsiInternalPureXbase
    public final void synpred37_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:4811:4: ( '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )
        // PsiInternalPureXbase.g:
        {
        if ( (input.LA(1)>=RULE_STRING && input.LA(1)<=RULE_ID)||input.LA(1)==20||(input.LA(1)>=36 && input.LA(1)<=37)||input.LA(1)==42||input.LA(1)==50||(input.LA(1)>=52 && input.LA(1)<=53)||input.LA(1)==55||input.LA(1)==58||input.LA(1)==60||(input.LA(1)>=64 && input.LA(1)<=66)||(input.LA(1)>=69 && input.LA(1)<=77)||input.LA(1)==79 ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }
    }
    // $ANTLR end synpred37_PsiInternalPureXbase

    // $ANTLR start synpred38_PsiInternalPureXbase
    public final void synpred38_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:4872:6: ( 'catch' )
        // PsiInternalPureXbase.g:4872:7: 'catch'
        {
        match(input,80,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_PsiInternalPureXbase

    // $ANTLR start synpred39_PsiInternalPureXbase
    public final void synpred39_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:4889:7: ( 'finally' )
        // PsiInternalPureXbase.g:4889:8: 'finally'
        {
        match(input,78,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_PsiInternalPureXbase

    // $ANTLR start synpred42_PsiInternalPureXbase
    public final void synpred42_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:5115:5: ( '.' )
        // PsiInternalPureXbase.g:5115:6: '.'
        {
        match(input,46,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_PsiInternalPureXbase

    // $ANTLR start synpred43_PsiInternalPureXbase
    public final void synpred43_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:5233:5: ( ( () ruleArrayBrackets ) )
        // PsiInternalPureXbase.g:5233:6: ( () ruleArrayBrackets )
        {
        // PsiInternalPureXbase.g:5233:6: ( () ruleArrayBrackets )
        // PsiInternalPureXbase.g:5234:6: () ruleArrayBrackets
        {
        // PsiInternalPureXbase.g:5234:6: ()
        // PsiInternalPureXbase.g:5235:6: 
        {
        }

        pushFollow(FOLLOW_2);
        ruleArrayBrackets();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred43_PsiInternalPureXbase

    // $ANTLR start synpred44_PsiInternalPureXbase
    public final void synpred44_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:5420:5: ( '<' )
        // PsiInternalPureXbase.g:5420:6: '<'
        {
        match(input,20,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_PsiInternalPureXbase

    // $ANTLR start synpred45_PsiInternalPureXbase
    public final void synpred45_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:5477:6: ( ( () '.' ) )
        // PsiInternalPureXbase.g:5477:7: ( () '.' )
        {
        // PsiInternalPureXbase.g:5477:7: ( () '.' )
        // PsiInternalPureXbase.g:5478:7: () '.'
        {
        // PsiInternalPureXbase.g:5478:7: ()
        // PsiInternalPureXbase.g:5479:7: 
        {
        }

        match(input,46,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred45_PsiInternalPureXbase

    // $ANTLR start synpred46_PsiInternalPureXbase
    public final void synpred46_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:5519:7: ( '<' )
        // PsiInternalPureXbase.g:5519:8: '<'
        {
        match(input,20,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_PsiInternalPureXbase

    // Delegated rules

    public final boolean synpred16_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_PsiInternalPureXbase() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_PsiInternalPureXbase_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA45 dfa45 = new DFA45(this);
    protected DFA52 dfa52 = new DFA52(this);
    protected DFA51 dfa51 = new DFA51(this);
    protected DFA74 dfa74 = new DFA74(this);
    protected DFA73 dfa73 = new DFA73(this);
    protected DFA75 dfa75 = new DFA75(this);
    protected DFA78 dfa78 = new DFA78(this);
    protected DFA81 dfa81 = new DFA81(this);
    protected DFA80 dfa80 = new DFA80(this);
    protected DFA82 dfa82 = new DFA82(this);
    protected DFA85 dfa85 = new DFA85(this);
    protected DFA103 dfa103 = new DFA103(this);
    protected DFA101 dfa101 = new DFA101(this);
    protected DFA111 dfa111 = new DFA111(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\10\11\uffff";
    static final String dfa_3s = "\1\4\7\0\2\uffff";
    static final String dfa_4s = "\1\120\7\0\2\uffff";
    static final String dfa_5s = "\10\uffff\1\2\1\1";
    static final String dfa_6s = "\1\uffff\1\3\1\6\1\1\1\5\1\2\1\0\1\4\2\uffff}>";
    static final String[] dfa_7s = {
            "\5\10\4\uffff\1\10\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\43\10\1\uffff\27\10",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "250:4: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_6 = input.LA(1);

                         
                        int index4_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_PsiInternalPureXbase()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index4_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA4_3 = input.LA(1);

                         
                        int index4_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_PsiInternalPureXbase()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index4_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA4_5 = input.LA(1);

                         
                        int index4_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_PsiInternalPureXbase()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index4_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA4_1 = input.LA(1);

                         
                        int index4_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_PsiInternalPureXbase()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index4_1);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA4_7 = input.LA(1);

                         
                        int index4_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_PsiInternalPureXbase()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index4_7);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA4_4 = input.LA(1);

                         
                        int index4_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_PsiInternalPureXbase()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index4_4);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA4_2 = input.LA(1);

                         
                        int index4_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_PsiInternalPureXbase()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index4_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 4, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\13\uffff";
    static final String dfa_9s = "\1\1\12\uffff";
    static final String dfa_10s = "\1\4\1\uffff\10\0\1\uffff";
    static final String dfa_11s = "\1\120\1\uffff\10\0\1\uffff";
    static final String dfa_12s = "\1\uffff\1\2\10\uffff\1\1";
    static final String dfa_13s = "\2\uffff\1\4\1\3\1\6\1\1\1\7\1\0\1\5\1\2\1\uffff}>";
    static final String[] dfa_14s = {
            "\5\1\4\uffff\1\1\1\uffff\5\1\1\2\1\3\10\1\1\4\1\5\1\6\1\7\1\10\1\11\25\1\1\uffff\27\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "()* loopback of 939:3: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_7 = input.LA(1);

                         
                        int index14_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_7);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_5 = input.LA(1);

                         
                        int index14_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_5);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_9 = input.LA(1);

                         
                        int index14_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_9);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA14_3 = input.LA(1);

                         
                        int index14_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA14_2 = input.LA(1);

                         
                        int index14_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_2);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA14_8 = input.LA(1);

                         
                        int index14_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_8);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA14_4 = input.LA(1);

                         
                        int index14_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_4);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA14_6 = input.LA(1);

                         
                        int index14_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_15s = "\1\24\2\uffff\1\25\7\uffff";
    static final String dfa_16s = "\1\43\2\uffff\1\40\7\uffff";
    static final String dfa_17s = "\1\uffff\1\1\1\2\1\uffff\1\4\1\5\1\7\1\10\1\11\1\3\1\6";
    static final String dfa_18s = "\13\uffff}>";
    static final String[] dfa_19s = {
            "\1\6\1\3\10\uffff\1\1\1\2\1\4\1\5\1\7\1\10",
            "",
            "",
            "\1\12\12\uffff\1\11",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "1007:2: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )";
        }
    }
    static final String dfa_20s = "\112\uffff";
    static final String dfa_21s = "\1\2\111\uffff";
    static final String dfa_22s = "\1\4\1\0\110\uffff";
    static final String dfa_23s = "\1\120\1\0\110\uffff";
    static final String dfa_24s = "\2\uffff\1\2\106\uffff\1\1";
    static final String dfa_25s = "\1\uffff\1\0\110\uffff}>";
    static final String[] dfa_26s = {
            "\5\2\4\uffff\1\2\1\uffff\43\2\1\1\6\2\1\uffff\27\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[][] dfa_26 = unpackEncodedStringArray(dfa_26s);

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "1919:5: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA33_1 = input.LA(1);

                         
                        int index33_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index33_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 33, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_27s = "\40\uffff";
    static final String dfa_28s = "\1\4\2\0\35\uffff";
    static final String dfa_29s = "\1\117\2\0\35\uffff";
    static final String dfa_30s = "\3\uffff\2\1\1\2\31\uffff\1\3";
    static final String dfa_31s = "\1\0\1\1\1\2\35\uffff}>";
    static final String[] dfa_32s = {
            "\4\5\1\1\13\uffff\1\5\14\uffff\1\3\2\uffff\2\5\4\uffff\1\5\7\uffff\1\2\1\37\2\5\1\uffff\1\5\1\uffff\1\4\1\5\1\uffff\1\5\3\uffff\3\5\2\uffff\11\5\1\uffff\1\5",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final char[] dfa_28 = DFA.unpackEncodedStringToUnsignedChars(dfa_28s);
    static final char[] dfa_29 = DFA.unpackEncodedStringToUnsignedChars(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final short[] dfa_31 = DFA.unpackEncodedString(dfa_31s);
    static final short[][] dfa_32 = unpackEncodedStringArray(dfa_32s);

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = dfa_27;
            this.eof = dfa_27;
            this.min = dfa_28;
            this.max = dfa_29;
            this.accept = dfa_30;
            this.special = dfa_31;
            this.transition = dfa_32;
        }
        public String getDescription() {
            return "1941:6: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_0 = input.LA(1);

                         
                        int index32_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_0==RULE_ID) ) {s = 1;}

                        else if ( (LA32_0==50) ) {s = 2;}

                        else if ( (LA32_0==33) && (synpred17_PsiInternalPureXbase())) {s = 3;}

                        else if ( (LA32_0==57) && (synpred17_PsiInternalPureXbase())) {s = 4;}

                        else if ( ((LA32_0>=RULE_STRING && LA32_0<=RULE_DECIMAL)||LA32_0==20||(LA32_0>=36 && LA32_0<=37)||LA32_0==42||(LA32_0>=52 && LA32_0<=53)||LA32_0==55||LA32_0==58||LA32_0==60||(LA32_0>=64 && LA32_0<=66)||(LA32_0>=69 && LA32_0<=77)||LA32_0==79) ) {s = 5;}

                        else if ( (LA32_0==51) ) {s = 31;}

                         
                        input.seek(index32_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA32_1 = input.LA(1);

                         
                        int index32_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_PsiInternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index32_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA32_2 = input.LA(1);

                         
                        int index32_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_PsiInternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index32_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 32, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String[] dfa_33s = {
            "\5\2\4\uffff\1\2\1\uffff\50\2\1\1\1\2\1\uffff\27\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[][] dfa_33 = unpackEncodedStringArray(dfa_33s);

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_33;
        }
        public String getDescription() {
            return "2033:5: ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA34_1 = input.LA(1);

                         
                        int index34_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index34_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 34, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_34s = "\34\uffff";
    static final String dfa_35s = "\1\4\22\uffff\1\0\10\uffff";
    static final String dfa_36s = "\1\117\22\uffff\1\0\10\uffff";
    static final String dfa_37s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\2\uffff\1\6\11\uffff\1\7\1\uffff\1\12\1\13\1\14\1\15\1\16\1\17\1\10\1\11";
    static final String dfa_38s = "\1\0\22\uffff\1\1\10\uffff}>";
    static final String[] dfa_39s = {
            "\4\10\1\5\13\uffff\1\5\35\uffff\1\31\1\uffff\1\10\1\2\1\uffff\1\10\2\uffff\1\22\1\uffff\1\3\3\uffff\1\23\1\24\1\25\2\uffff\1\5\1\1\4\10\1\26\1\27\1\30\1\uffff\1\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_34 = DFA.unpackEncodedString(dfa_34s);
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final char[] dfa_36 = DFA.unpackEncodedStringToUnsignedChars(dfa_36s);
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final short[] dfa_38 = DFA.unpackEncodedString(dfa_38s);
    static final short[][] dfa_39 = unpackEncodedStringArray(dfa_39s);

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = dfa_34;
            this.eof = dfa_34;
            this.min = dfa_35;
            this.max = dfa_36;
            this.accept = dfa_37;
            this.special = dfa_38;
            this.transition = dfa_39;
        }
        public String getDescription() {
            return "2069:2: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA36_0 = input.LA(1);

                         
                        int index36_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA36_0==70) ) {s = 1;}

                        else if ( (LA36_0==53) ) {s = 2;}

                        else if ( (LA36_0==60) ) {s = 3;}

                        else if ( (LA36_0==79) && (synpred19_PsiInternalPureXbase())) {s = 4;}

                        else if ( (LA36_0==RULE_ID||LA36_0==20||LA36_0==69) ) {s = 5;}

                        else if ( ((LA36_0>=RULE_STRING && LA36_0<=RULE_DECIMAL)||LA36_0==52||LA36_0==55||(LA36_0>=71 && LA36_0<=74)) ) {s = 8;}

                        else if ( (LA36_0==58) ) {s = 18;}

                        else if ( (LA36_0==64) ) {s = 19;}

                        else if ( (LA36_0==65) ) {s = 20;}

                        else if ( (LA36_0==66) ) {s = 21;}

                        else if ( (LA36_0==75) ) {s = 22;}

                        else if ( (LA36_0==76) ) {s = 23;}

                        else if ( (LA36_0==77) ) {s = 24;}

                        else if ( (LA36_0==50) ) {s = 25;}

                         
                        input.seek(index36_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA36_19 = input.LA(1);

                         
                        int index36_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_PsiInternalPureXbase()) ) {s = 26;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index36_19);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 36, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_40s = "\42\uffff";
    static final String dfa_41s = "\1\4\2\0\37\uffff";
    static final String dfa_42s = "\1\117\2\0\37\uffff";
    static final String dfa_43s = "\3\uffff\2\1\1\2\34\uffff";
    static final String dfa_44s = "\1\0\1\1\1\2\37\uffff}>";
    static final String[] dfa_45s = {
            "\4\5\1\1\13\uffff\1\5\14\uffff\1\3\2\uffff\2\5\4\uffff\1\5\7\uffff\1\2\1\uffff\2\5\1\uffff\2\5\1\4\1\5\1\uffff\1\5\3\uffff\16\5\1\uffff\1\5",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_40 = DFA.unpackEncodedString(dfa_40s);
    static final char[] dfa_41 = DFA.unpackEncodedStringToUnsignedChars(dfa_41s);
    static final char[] dfa_42 = DFA.unpackEncodedStringToUnsignedChars(dfa_42s);
    static final short[] dfa_43 = DFA.unpackEncodedString(dfa_43s);
    static final short[] dfa_44 = DFA.unpackEncodedString(dfa_44s);
    static final short[][] dfa_45 = unpackEncodedStringArray(dfa_45s);

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = dfa_40;
            this.eof = dfa_40;
            this.min = dfa_41;
            this.max = dfa_42;
            this.accept = dfa_43;
            this.special = dfa_44;
            this.transition = dfa_45;
        }
        public String getDescription() {
            return "2547:3: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA45_0 = input.LA(1);

                         
                        int index45_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA45_0==RULE_ID) ) {s = 1;}

                        else if ( (LA45_0==50) ) {s = 2;}

                        else if ( (LA45_0==33) && (synpred23_PsiInternalPureXbase())) {s = 3;}

                        else if ( (LA45_0==57) && (synpred23_PsiInternalPureXbase())) {s = 4;}

                        else if ( ((LA45_0>=RULE_STRING && LA45_0<=RULE_DECIMAL)||LA45_0==20||(LA45_0>=36 && LA45_0<=37)||LA45_0==42||(LA45_0>=52 && LA45_0<=53)||(LA45_0>=55 && LA45_0<=56)||LA45_0==58||LA45_0==60||(LA45_0>=64 && LA45_0<=77)||LA45_0==79) ) {s = 5;}

                         
                        input.seek(index45_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA45_1 = input.LA(1);

                         
                        int index45_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_PsiInternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index45_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA45_2 = input.LA(1);

                         
                        int index45_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_PsiInternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index45_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 45, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_46s = "\37\uffff";
    static final String dfa_47s = "\1\4\1\0\35\uffff";
    static final String dfa_48s = "\1\117\1\0\35\uffff";
    static final String dfa_49s = "\2\uffff\1\2\33\uffff\1\1";
    static final String dfa_50s = "\1\uffff\1\0\35\uffff}>";
    static final String[] dfa_51s = {
            "\5\2\13\uffff\1\2\14\uffff\1\2\2\uffff\2\2\4\uffff\1\2\7\uffff\1\1\1\uffff\2\2\1\uffff\1\2\2\uffff\1\2\1\uffff\1\2\3\uffff\3\2\2\uffff\11\2\1\uffff\1\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_46 = DFA.unpackEncodedString(dfa_46s);
    static final char[] dfa_47 = DFA.unpackEncodedStringToUnsignedChars(dfa_47s);
    static final char[] dfa_48 = DFA.unpackEncodedStringToUnsignedChars(dfa_48s);
    static final short[] dfa_49 = DFA.unpackEncodedString(dfa_49s);
    static final short[] dfa_50 = DFA.unpackEncodedString(dfa_50s);
    static final short[][] dfa_51 = unpackEncodedStringArray(dfa_51s);

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = dfa_46;
            this.eof = dfa_46;
            this.min = dfa_47;
            this.max = dfa_48;
            this.accept = dfa_49;
            this.special = dfa_50;
            this.transition = dfa_51;
        }
        public String getDescription() {
            return "2987:3: ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA52_1 = input.LA(1);

                         
                        int index52_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_PsiInternalPureXbase()) ) {s = 30;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index52_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 52, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_52s = "\36\uffff";
    static final String dfa_53s = "\1\4\2\0\33\uffff";
    static final String dfa_54s = "\1\117\2\0\33\uffff";
    static final String dfa_55s = "\3\uffff\1\1\1\2\31\uffff";
    static final String dfa_56s = "\1\0\1\1\1\2\33\uffff}>";
    static final String[] dfa_57s = {
            "\4\4\1\1\13\uffff\1\4\14\uffff\1\3\2\uffff\2\4\4\uffff\1\4\7\uffff\1\2\1\uffff\2\4\1\uffff\1\4\2\uffff\1\4\1\uffff\1\4\3\uffff\3\4\2\uffff\11\4\1\uffff\1\4",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_52 = DFA.unpackEncodedString(dfa_52s);
    static final char[] dfa_53 = DFA.unpackEncodedStringToUnsignedChars(dfa_53s);
    static final char[] dfa_54 = DFA.unpackEncodedStringToUnsignedChars(dfa_54s);
    static final short[] dfa_55 = DFA.unpackEncodedString(dfa_55s);
    static final short[] dfa_56 = DFA.unpackEncodedString(dfa_56s);
    static final short[][] dfa_57 = unpackEncodedStringArray(dfa_57s);

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = dfa_52;
            this.eof = dfa_52;
            this.min = dfa_53;
            this.max = dfa_54;
            this.accept = dfa_55;
            this.special = dfa_56;
            this.transition = dfa_57;
        }
        public String getDescription() {
            return "3057:5: ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA51_0 = input.LA(1);

                         
                        int index51_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_0==RULE_ID) ) {s = 1;}

                        else if ( (LA51_0==50) ) {s = 2;}

                        else if ( (LA51_0==33) && (synpred27_PsiInternalPureXbase())) {s = 3;}

                        else if ( ((LA51_0>=RULE_STRING && LA51_0<=RULE_DECIMAL)||LA51_0==20||(LA51_0>=36 && LA51_0<=37)||LA51_0==42||(LA51_0>=52 && LA51_0<=53)||LA51_0==55||LA51_0==58||LA51_0==60||(LA51_0>=64 && LA51_0<=66)||(LA51_0>=69 && LA51_0<=77)||LA51_0==79) ) {s = 4;}

                         
                        input.seek(index51_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA51_1 = input.LA(1);

                         
                        int index51_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_PsiInternalPureXbase()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index51_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA51_2 = input.LA(1);

                         
                        int index51_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_PsiInternalPureXbase()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index51_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 51, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA74 extends DFA {

        public DFA74(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 74;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "4113:3: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA74_1 = input.LA(1);

                         
                        int index74_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index74_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 74, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA73 extends DFA {

        public DFA73(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 73;
            this.eot = dfa_27;
            this.eof = dfa_27;
            this.min = dfa_28;
            this.max = dfa_29;
            this.accept = dfa_30;
            this.special = dfa_31;
            this.transition = dfa_32;
        }
        public String getDescription() {
            return "4135:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA73_0 = input.LA(1);

                         
                        int index73_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA73_0==RULE_ID) ) {s = 1;}

                        else if ( (LA73_0==50) ) {s = 2;}

                        else if ( (LA73_0==33) && (synpred31_PsiInternalPureXbase())) {s = 3;}

                        else if ( (LA73_0==57) && (synpred31_PsiInternalPureXbase())) {s = 4;}

                        else if ( ((LA73_0>=RULE_STRING && LA73_0<=RULE_DECIMAL)||LA73_0==20||(LA73_0>=36 && LA73_0<=37)||LA73_0==42||(LA73_0>=52 && LA73_0<=53)||LA73_0==55||LA73_0==58||LA73_0==60||(LA73_0>=64 && LA73_0<=66)||(LA73_0>=69 && LA73_0<=77)||LA73_0==79) ) {s = 5;}

                        else if ( (LA73_0==51) ) {s = 31;}

                         
                        input.seek(index73_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA73_1 = input.LA(1);

                         
                        int index73_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_PsiInternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index73_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA73_2 = input.LA(1);

                         
                        int index73_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_PsiInternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index73_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 73, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA75 extends DFA {

        public DFA75(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 75;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_33;
        }
        public String getDescription() {
            return "4227:3: ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA75_1 = input.LA(1);

                         
                        int index75_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index75_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 75, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String[] dfa_58s = {
            "\5\2\4\uffff\1\2\1\uffff\5\2\1\1\44\2\1\uffff\27\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[][] dfa_58 = unpackEncodedStringArray(dfa_58s);

    class DFA78 extends DFA {

        public DFA78(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 78;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_58;
        }
        public String getDescription() {
            return "4322:3: ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA78_1 = input.LA(1);

                         
                        int index78_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index78_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 78, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA81 extends DFA {

        public DFA81(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 81;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "4380:3: ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA81_1 = input.LA(1);

                         
                        int index81_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index81_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 81, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA80 extends DFA {

        public DFA80(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 80;
            this.eot = dfa_27;
            this.eof = dfa_27;
            this.min = dfa_28;
            this.max = dfa_29;
            this.accept = dfa_30;
            this.special = dfa_31;
            this.transition = dfa_32;
        }
        public String getDescription() {
            return "4402:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA80_0 = input.LA(1);

                         
                        int index80_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA80_0==RULE_ID) ) {s = 1;}

                        else if ( (LA80_0==50) ) {s = 2;}

                        else if ( (LA80_0==33) && (synpred35_PsiInternalPureXbase())) {s = 3;}

                        else if ( (LA80_0==57) && (synpred35_PsiInternalPureXbase())) {s = 4;}

                        else if ( ((LA80_0>=RULE_STRING && LA80_0<=RULE_DECIMAL)||LA80_0==20||(LA80_0>=36 && LA80_0<=37)||LA80_0==42||(LA80_0>=52 && LA80_0<=53)||LA80_0==55||LA80_0==58||LA80_0==60||(LA80_0>=64 && LA80_0<=66)||(LA80_0>=69 && LA80_0<=77)||LA80_0==79) ) {s = 5;}

                        else if ( (LA80_0==51) ) {s = 31;}

                         
                        input.seek(index80_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA80_1 = input.LA(1);

                         
                        int index80_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_PsiInternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index80_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA80_2 = input.LA(1);

                         
                        int index80_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_PsiInternalPureXbase()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index80_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 80, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA82 extends DFA {

        public DFA82(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 82;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_33;
        }
        public String getDescription() {
            return "4494:3: ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA82_1 = input.LA(1);

                         
                        int index82_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index82_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 82, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_59s = "\1\35\111\uffff";
    static final String dfa_60s = "\1\4\34\0\55\uffff";
    static final String dfa_61s = "\1\120\34\0\55\uffff";
    static final String dfa_62s = "\35\uffff\1\2\53\uffff\1\1";
    static final String dfa_63s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\55\uffff}>";
    static final String[] dfa_64s = {
            "\1\23\1\17\1\20\1\21\1\1\4\uffff\1\35\1\uffff\5\35\1\11\17\35\1\4\1\3\4\35\1\2\7\35\1\34\1\35\1\13\1\6\1\35\1\14\1\35\1\uffff\1\25\1\35\1\7\3\35\1\26\1\27\1\30\2\35\1\12\1\5\1\15\1\16\1\22\1\24\1\31\1\32\1\33\1\35\1\10\1\35",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[] dfa_59 = DFA.unpackEncodedString(dfa_59s);
    static final char[] dfa_60 = DFA.unpackEncodedStringToUnsignedChars(dfa_60s);
    static final char[] dfa_61 = DFA.unpackEncodedStringToUnsignedChars(dfa_61s);
    static final short[] dfa_62 = DFA.unpackEncodedString(dfa_62s);
    static final short[] dfa_63 = DFA.unpackEncodedString(dfa_63s);
    static final short[][] dfa_64 = unpackEncodedStringArray(dfa_64s);

    class DFA85 extends DFA {

        public DFA85(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 85;
            this.eot = dfa_20;
            this.eof = dfa_59;
            this.min = dfa_60;
            this.max = dfa_61;
            this.accept = dfa_62;
            this.special = dfa_63;
            this.transition = dfa_64;
        }
        public String getDescription() {
            return "4810:3: ( ( '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA85_1 = input.LA(1);

                         
                        int index85_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA85_2 = input.LA(1);

                         
                        int index85_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA85_3 = input.LA(1);

                         
                        int index85_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA85_4 = input.LA(1);

                         
                        int index85_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA85_5 = input.LA(1);

                         
                        int index85_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA85_6 = input.LA(1);

                         
                        int index85_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA85_7 = input.LA(1);

                         
                        int index85_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA85_8 = input.LA(1);

                         
                        int index85_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA85_9 = input.LA(1);

                         
                        int index85_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA85_10 = input.LA(1);

                         
                        int index85_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA85_11 = input.LA(1);

                         
                        int index85_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA85_12 = input.LA(1);

                         
                        int index85_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA85_13 = input.LA(1);

                         
                        int index85_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA85_14 = input.LA(1);

                         
                        int index85_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA85_15 = input.LA(1);

                         
                        int index85_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA85_16 = input.LA(1);

                         
                        int index85_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA85_17 = input.LA(1);

                         
                        int index85_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA85_18 = input.LA(1);

                         
                        int index85_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA85_19 = input.LA(1);

                         
                        int index85_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA85_20 = input.LA(1);

                         
                        int index85_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA85_21 = input.LA(1);

                         
                        int index85_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA85_22 = input.LA(1);

                         
                        int index85_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA85_23 = input.LA(1);

                         
                        int index85_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA85_24 = input.LA(1);

                         
                        int index85_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA85_25 = input.LA(1);

                         
                        int index85_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA85_26 = input.LA(1);

                         
                        int index85_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_26);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA85_27 = input.LA(1);

                         
                        int index85_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_27);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA85_28 = input.LA(1);

                         
                        int index85_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalPureXbase()) ) {s = 73;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index85_28);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 85, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_65s = "\113\uffff";
    static final String dfa_66s = "\1\2\112\uffff";
    static final String dfa_67s = "\1\4\1\0\111\uffff";
    static final String dfa_68s = "\1\123\1\0\111\uffff";
    static final String dfa_69s = "\2\uffff\1\2\107\uffff\1\1";
    static final String dfa_70s = "\1\uffff\1\0\111\uffff}>";
    static final String[] dfa_71s = {
            "\5\2\4\uffff\1\2\1\uffff\5\2\1\1\44\2\1\uffff\27\2\2\uffff\1\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_65 = DFA.unpackEncodedString(dfa_65s);
    static final short[] dfa_66 = DFA.unpackEncodedString(dfa_66s);
    static final char[] dfa_67 = DFA.unpackEncodedStringToUnsignedChars(dfa_67s);
    static final char[] dfa_68 = DFA.unpackEncodedStringToUnsignedChars(dfa_68s);
    static final short[] dfa_69 = DFA.unpackEncodedString(dfa_69s);
    static final short[] dfa_70 = DFA.unpackEncodedString(dfa_70s);
    static final short[][] dfa_71 = unpackEncodedStringArray(dfa_71s);

    class DFA103 extends DFA {

        public DFA103(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 103;
            this.eot = dfa_65;
            this.eof = dfa_66;
            this.min = dfa_67;
            this.max = dfa_68;
            this.accept = dfa_69;
            this.special = dfa_70;
            this.transition = dfa_71;
        }
        public String getDescription() {
            return "5418:3: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA103_1 = input.LA(1);

                         
                        int index103_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred44_PsiInternalPureXbase()) ) {s = 74;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index103_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 103, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA101 extends DFA {

        public DFA101(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 101;
            this.eot = dfa_65;
            this.eof = dfa_66;
            this.min = dfa_67;
            this.max = dfa_68;
            this.accept = dfa_69;
            this.special = dfa_70;
            this.transition = dfa_71;
        }
        public String getDescription() {
            return "5517:5: ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA101_1 = input.LA(1);

                         
                        int index101_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred46_PsiInternalPureXbase()) ) {s = 74;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index101_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 101, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_72s = "\7\uffff";
    static final String dfa_73s = "\2\uffff\1\4\3\uffff\1\4";
    static final String dfa_74s = "\1\10\1\uffff\1\4\1\10\2\uffff\1\4";
    static final String dfa_75s = "\1\125\1\uffff\1\124\1\46\2\uffff\1\124";
    static final String dfa_76s = "\1\uffff\1\1\2\uffff\1\2\1\3\1\uffff";
    static final String dfa_77s = "\7\uffff}>";
    static final String[] dfa_78s = {
            "\1\2\114\uffff\1\1",
            "",
            "\5\4\4\uffff\1\4\6\uffff\1\4\17\uffff\2\4\4\uffff\1\4\3\uffff\1\3\3\uffff\1\4\1\uffff\2\4\1\uffff\1\4\2\uffff\1\4\1\uffff\1\4\3\uffff\16\4\1\uffff\1\4\4\uffff\1\4",
            "\1\6\35\uffff\1\5",
            "",
            "",
            "\5\4\4\uffff\1\4\6\uffff\1\4\17\uffff\2\4\4\uffff\1\4\3\uffff\1\3\3\uffff\1\4\1\uffff\2\4\1\uffff\1\4\2\uffff\1\4\1\uffff\1\4\3\uffff\16\4\1\uffff\1\4\4\uffff\1\4"
    };

    static final short[] dfa_72 = DFA.unpackEncodedString(dfa_72s);
    static final short[] dfa_73 = DFA.unpackEncodedString(dfa_73s);
    static final char[] dfa_74 = DFA.unpackEncodedStringToUnsignedChars(dfa_74s);
    static final char[] dfa_75 = DFA.unpackEncodedStringToUnsignedChars(dfa_75s);
    static final short[] dfa_76 = DFA.unpackEncodedString(dfa_76s);
    static final short[] dfa_77 = DFA.unpackEncodedString(dfa_77s);
    static final short[][] dfa_78 = unpackEncodedStringArray(dfa_78s);

    class DFA111 extends DFA {

        public DFA111(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 111;
            this.eot = dfa_72;
            this.eof = dfa_73;
            this.min = dfa_74;
            this.max = dfa_75;
            this.accept = dfa_76;
            this.special = dfa_77;
            this.transition = dfa_78;
        }
        public String getDescription() {
            return "5949:3: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x14B40430001001F0L,0x000000000000BFFFL});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x14B40430001021F2L,0x000000000000BFFFL});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x14B40430001001F2L,0x000000000000BFFFL});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000003F8002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000000001E000002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000020700002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0004000200000100L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000FC0300002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x000003C000000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000300000000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0001C00000000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000100100L,0x0000000000000020L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0004000200000100L,0x0000000000020000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0002000000200000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0085C00000000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x16BC0432001001F0L,0x000000000000BFFFL});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x000A000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0081C00000000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x14F40430001001F0L,0x000000000000BFFFL});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0042000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x15B40430001001F0L,0x000000000000BFFFL});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0102000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x17B40432001001F0L,0x000000000000BFFFL});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0202000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x14B40432001001F0L,0x000000000000BFFFL});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0xE046000200000100L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0xA002000000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x2002000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x14B40430001021F0L,0x000000000000BFFFL});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0002000000002000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x14BC0430001001F0L,0x000000000000BFFFL});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x14F40430001021F0L,0x000000000000BFFFL});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0084000000000002L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0084000000100002L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0088000000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000014000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000002L,0x0000000000014000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x000C000200000100L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000400000100002L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040020L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000100L,0x0000000000200000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000100L,0x0000000000400000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000004000000100L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000102L});

}