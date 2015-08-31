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
    // PsiInternalPureXbase.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:52:15: ( ruleModel EOF )
            // PsiInternalPureXbase.g:53:2: ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getModelElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalPureXbase.g:58:1: ruleModel : ( ( (lv_importSection_0_0= ruleXImportSection ) )? ( (lv_block_1_0= ruleSpecialBlockExpression ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:58:10: ( ( ( (lv_importSection_0_0= ruleXImportSection ) )? ( (lv_block_1_0= ruleSpecialBlockExpression ) ) ) )
            // PsiInternalPureXbase.g:59:2: ( ( (lv_importSection_0_0= ruleXImportSection ) )? ( (lv_block_1_0= ruleSpecialBlockExpression ) ) )
            {
            // PsiInternalPureXbase.g:59:2: ( ( (lv_importSection_0_0= ruleXImportSection ) )? ( (lv_block_1_0= ruleSpecialBlockExpression ) ) )
            // PsiInternalPureXbase.g:60:3: ( (lv_importSection_0_0= ruleXImportSection ) )? ( (lv_block_1_0= ruleSpecialBlockExpression ) )
            {
            // PsiInternalPureXbase.g:60:3: ( (lv_importSection_0_0= ruleXImportSection ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==84) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // PsiInternalPureXbase.g:61:4: (lv_importSection_0_0= ruleXImportSection )
                    {
                    // PsiInternalPureXbase.g:61:4: (lv_importSection_0_0= ruleXImportSection )
                    // PsiInternalPureXbase.g:62:5: lv_importSection_0_0= ruleXImportSection
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getModel_ImportSectionXImportSectionParserRuleCall_0_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_3);
                    ruleXImportSection();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalPureXbase.g:71:3: ( (lv_block_1_0= ruleSpecialBlockExpression ) )
            // PsiInternalPureXbase.g:72:4: (lv_block_1_0= ruleSpecialBlockExpression )
            {
            // PsiInternalPureXbase.g:72:4: (lv_block_1_0= ruleSpecialBlockExpression )
            // PsiInternalPureXbase.g:73:5: lv_block_1_0= ruleSpecialBlockExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getModel_BlockSpecialBlockExpressionParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            ruleSpecialBlockExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
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
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleSpecialBlockExpression"
    // PsiInternalPureXbase.g:86:1: entryRuleSpecialBlockExpression : ruleSpecialBlockExpression EOF ;
    public final void entryRuleSpecialBlockExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:86:32: ( ruleSpecialBlockExpression EOF )
            // PsiInternalPureXbase.g:87:2: ruleSpecialBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getSpecialBlockExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleSpecialBlockExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSpecialBlockExpression"


    // $ANTLR start "ruleSpecialBlockExpression"
    // PsiInternalPureXbase.g:92:1: ruleSpecialBlockExpression : ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) ;
    public final void ruleSpecialBlockExpression() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // PsiInternalPureXbase.g:92:27: ( ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) )
            // PsiInternalPureXbase.g:93:2: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
            {
            // PsiInternalPureXbase.g:93:2: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
            // PsiInternalPureXbase.g:94:3: () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
            {
            // PsiInternalPureXbase.g:94:3: ()
            // PsiInternalPureXbase.g:95:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getSpecialBlockExpression_XBlockExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalPureXbase.g:100:3: ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=RULE_STRING && LA3_0<=RULE_ID)||LA3_0==20||(LA3_0>=36 && LA3_0<=37)||LA3_0==42||LA3_0==50||(LA3_0>=52 && LA3_0<=53)||LA3_0==55||LA3_0==58||LA3_0==60||(LA3_0>=64 && LA3_0<=77)||LA3_0==79) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalPureXbase.g:101:4: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )?
            	    {
            	    // PsiInternalPureXbase.g:101:4: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) )
            	    // PsiInternalPureXbase.g:102:5: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
            	    {
            	    // PsiInternalPureXbase.g:102:5: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
            	    // PsiInternalPureXbase.g:103:6: lv_expressions_1_0= ruleXExpressionOrVarDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getSpecialBlockExpression_ExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_4);
            	    ruleXExpressionOrVarDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
            	    }

            	    }


            	    }

            	    // PsiInternalPureXbase.g:112:4: (otherlv_2= ';' )?
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==13) ) {
            	        alt2=1;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // PsiInternalPureXbase.g:113:5: otherlv_2= ';'
            	            {
            	            if ( state.backtracking==0 ) {

            	              					markLeaf(elementTypeProvider.getSpecialBlockExpression_SemicolonKeyword_1_1ElementType());
            	              				
            	            }
            	            otherlv_2=(Token)match(input,13,FOLLOW_5); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleSpecialBlockExpression"


    // $ANTLR start "entryRuleFeatureCallID"
    // PsiInternalPureXbase.g:126:1: entryRuleFeatureCallID : ruleFeatureCallID EOF ;
    public final void entryRuleFeatureCallID() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:126:23: ( ruleFeatureCallID EOF )
            // PsiInternalPureXbase.g:127:2: ruleFeatureCallID EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFeatureCallIDElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleFeatureCallID();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFeatureCallID"


    // $ANTLR start "ruleFeatureCallID"
    // PsiInternalPureXbase.g:132:1: ruleFeatureCallID : ruleValidID ;
    public final void ruleFeatureCallID() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:132:18: ( ruleValidID )
            // PsiInternalPureXbase.g:133:2: ruleValidID
            {
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getFeatureCallID_ValidIDParserRuleCallElementType());
              	
            }
            pushFollow(FOLLOW_2);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleFeatureCallID"


    // $ANTLR start "entryRuleXExpression"
    // PsiInternalPureXbase.g:143:1: entryRuleXExpression : ruleXExpression EOF ;
    public final void entryRuleXExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:143:21: ( ruleXExpression EOF )
            // PsiInternalPureXbase.g:144:2: ruleXExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXExpression"


    // $ANTLR start "ruleXExpression"
    // PsiInternalPureXbase.g:149:1: ruleXExpression : ruleXAssignment ;
    public final void ruleXExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:149:16: ( ruleXAssignment )
            // PsiInternalPureXbase.g:150:2: ruleXAssignment
            {
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getXExpression_XAssignmentParserRuleCallElementType());
              	
            }
            pushFollow(FOLLOW_2);
            ruleXAssignment();

            state._fsp--;
            if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleXExpression"


    // $ANTLR start "entryRuleXAssignment"
    // PsiInternalPureXbase.g:160:1: entryRuleXAssignment : ruleXAssignment EOF ;
    public final void entryRuleXAssignment() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:160:21: ( ruleXAssignment EOF )
            // PsiInternalPureXbase.g:161:2: ruleXAssignment EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXAssignmentElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXAssignment();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXAssignment"


    // $ANTLR start "ruleXAssignment"
    // PsiInternalPureXbase.g:166:1: ruleXAssignment : ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | ( ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) ;
    public final void ruleXAssignment() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:166:16: ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | ( ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) )
            // PsiInternalPureXbase.g:167:2: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | ( ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            {
            // PsiInternalPureXbase.g:167:2: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | ( ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
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
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA5_0>=RULE_STRING && LA5_0<=RULE_DECIMAL)||LA5_0==20||(LA5_0>=36 && LA5_0<=37)||LA5_0==42||LA5_0==50||(LA5_0>=52 && LA5_0<=53)||LA5_0==55||LA5_0==58||LA5_0==60||(LA5_0>=64 && LA5_0<=66)||(LA5_0>=69 && LA5_0<=77)||LA5_0==79) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalPureXbase.g:168:3: ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    {
                    // PsiInternalPureXbase.g:168:3: ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    // PsiInternalPureXbase.g:169:4: () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) )
                    {
                    // PsiInternalPureXbase.g:169:4: ()
                    // PsiInternalPureXbase.g:170:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getXAssignment_XAssignmentAction_0_0ElementType());
                      					doneComposite();
                      				
                    }

                    }

                    // PsiInternalPureXbase.g:175:4: ( ( ruleFeatureCallID ) )
                    // PsiInternalPureXbase.g:176:5: ( ruleFeatureCallID )
                    {
                    // PsiInternalPureXbase.g:176:5: ( ruleFeatureCallID )
                    // PsiInternalPureXbase.g:177:6: ruleFeatureCallID
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXAssignment_FeatureJvmIdentifiableElementCrossReference_0_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_6);
                    ruleFeatureCallID();

                    state._fsp--;
                    if (state.failed) return ;
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
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneComposite();
                      			
                    }
                    // PsiInternalPureXbase.g:193:4: ( (lv_value_3_0= ruleXAssignment ) )
                    // PsiInternalPureXbase.g:194:5: (lv_value_3_0= ruleXAssignment )
                    {
                    // PsiInternalPureXbase.g:194:5: (lv_value_3_0= ruleXAssignment )
                    // PsiInternalPureXbase.g:195:6: lv_value_3_0= ruleXAssignment
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXAssignment_ValueXAssignmentParserRuleCall_0_3_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    ruleXAssignment();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:206:3: ( ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    {
                    // PsiInternalPureXbase.g:206:3: ( ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    // PsiInternalPureXbase.g:207:4: ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getXAssignment_XOrExpressionParserRuleCall_1_0ElementType());
                      			
                    }
                    pushFollow(FOLLOW_7);
                    ruleXOrExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneComposite();
                      			
                    }
                    // PsiInternalPureXbase.g:214:4: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    int alt4=2;
                    alt4 = dfa4.predict(input);
                    switch (alt4) {
                        case 1 :
                            // PsiInternalPureXbase.g:215:5: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            {
                            // PsiInternalPureXbase.g:215:5: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) )
                            // PsiInternalPureXbase.g:216:6: ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) )
                            {
                            // PsiInternalPureXbase.g:226:6: ( () ( ( ruleOpMultiAssign ) ) )
                            // PsiInternalPureXbase.g:227:7: () ( ( ruleOpMultiAssign ) )
                            {
                            // PsiInternalPureXbase.g:227:7: ()
                            // PsiInternalPureXbase.g:228:8: 
                            {
                            if ( state.backtracking==0 ) {

                              								precedeComposite(elementTypeProvider.getXAssignment_XBinaryOperationLeftOperandAction_1_1_0_0_0ElementType());
                              								doneComposite();
                              							
                            }

                            }

                            // PsiInternalPureXbase.g:233:7: ( ( ruleOpMultiAssign ) )
                            // PsiInternalPureXbase.g:234:8: ( ruleOpMultiAssign )
                            {
                            // PsiInternalPureXbase.g:234:8: ( ruleOpMultiAssign )
                            // PsiInternalPureXbase.g:235:9: ruleOpMultiAssign
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getXAssignment_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0ElementType());
                              								
                            }
                            pushFollow(FOLLOW_3);
                            ruleOpMultiAssign();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              								
                            }

                            }


                            }


                            }


                            }

                            // PsiInternalPureXbase.g:246:5: ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            // PsiInternalPureXbase.g:247:6: (lv_rightOperand_7_0= ruleXAssignment )
                            {
                            // PsiInternalPureXbase.g:247:6: (lv_rightOperand_7_0= ruleXAssignment )
                            // PsiInternalPureXbase.g:248:7: lv_rightOperand_7_0= ruleXAssignment
                            {
                            if ( state.backtracking==0 ) {

                              							markComposite(elementTypeProvider.getXAssignment_RightOperandXAssignmentParserRuleCall_1_1_1_0ElementType());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            ruleXAssignment();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneComposite();
                              						
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
        return ;
    }
    // $ANTLR end "ruleXAssignment"


    // $ANTLR start "entryRuleOpSingleAssign"
    // PsiInternalPureXbase.g:263:1: entryRuleOpSingleAssign : ruleOpSingleAssign EOF ;
    public final void entryRuleOpSingleAssign() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:263:24: ( ruleOpSingleAssign EOF )
            // PsiInternalPureXbase.g:264:2: ruleOpSingleAssign EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpSingleAssignElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpSingleAssign();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOpSingleAssign"


    // $ANTLR start "ruleOpSingleAssign"
    // PsiInternalPureXbase.g:269:1: ruleOpSingleAssign : kw= '=' ;
    public final void ruleOpSingleAssign() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalPureXbase.g:269:19: (kw= '=' )
            // PsiInternalPureXbase.g:270:2: kw= '='
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getOpSingleAssign_EqualsSignKeywordElementType());
              	
            }
            kw=(Token)match(input,14,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleOpSingleAssign"


    // $ANTLR start "entryRuleOpMultiAssign"
    // PsiInternalPureXbase.g:280:1: entryRuleOpMultiAssign : ruleOpMultiAssign EOF ;
    public final void entryRuleOpMultiAssign() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:280:23: ( ruleOpMultiAssign EOF )
            // PsiInternalPureXbase.g:281:2: ruleOpMultiAssign EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpMultiAssignElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpMultiAssign();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOpMultiAssign"


    // $ANTLR start "ruleOpMultiAssign"
    // PsiInternalPureXbase.g:286:1: ruleOpMultiAssign : (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) ) ;
    public final void ruleOpMultiAssign() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalPureXbase.g:286:18: ( (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) ) )
            // PsiInternalPureXbase.g:287:2: (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) )
            {
            // PsiInternalPureXbase.g:287:2: (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) )
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // PsiInternalPureXbase.g:288:3: kw= '+='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMultiAssign_PlusSignEqualsSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,15,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:296:3: kw= '-='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMultiAssign_HyphenMinusEqualsSignKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,16,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalPureXbase.g:304:3: kw= '*='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMultiAssign_AsteriskEqualsSignKeyword_2ElementType());
                      		
                    }
                    kw=(Token)match(input,17,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalPureXbase.g:312:3: kw= '/='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMultiAssign_SolidusEqualsSignKeyword_3ElementType());
                      		
                    }
                    kw=(Token)match(input,18,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 5 :
                    // PsiInternalPureXbase.g:320:3: kw= '%='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMultiAssign_PercentSignEqualsSignKeyword_4ElementType());
                      		
                    }
                    kw=(Token)match(input,19,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalPureXbase.g:328:3: (kw= '<' kw= '<' kw= '=' )
                    {
                    // PsiInternalPureXbase.g:328:3: (kw= '<' kw= '<' kw= '=' )
                    // PsiInternalPureXbase.g:329:4: kw= '<' kw= '<' kw= '='
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpMultiAssign_LessThanSignKeyword_5_0ElementType());
                      			
                    }
                    kw=(Token)match(input,20,FOLLOW_8); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpMultiAssign_LessThanSignKeyword_5_1ElementType());
                      			
                    }
                    kw=(Token)match(input,20,FOLLOW_6); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpMultiAssign_EqualsSignKeyword_5_2ElementType());
                      			
                    }
                    kw=(Token)match(input,14,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // PsiInternalPureXbase.g:352:3: (kw= '>' (kw= '>' )? kw= '>=' )
                    {
                    // PsiInternalPureXbase.g:352:3: (kw= '>' (kw= '>' )? kw= '>=' )
                    // PsiInternalPureXbase.g:353:4: kw= '>' (kw= '>' )? kw= '>='
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpMultiAssign_GreaterThanSignKeyword_6_0ElementType());
                      			
                    }
                    kw=(Token)match(input,21,FOLLOW_9); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    // PsiInternalPureXbase.g:360:4: (kw= '>' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==21) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // PsiInternalPureXbase.g:361:5: kw= '>'
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getOpMultiAssign_GreaterThanSignKeyword_6_1ElementType());
                              				
                            }
                            kw=(Token)match(input,21,FOLLOW_10); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(kw);
                              				
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpMultiAssign_GreaterThanSignEqualsSignKeyword_6_2ElementType());
                      			
                    }
                    kw=(Token)match(input,22,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleOpMultiAssign"


    // $ANTLR start "entryRuleXOrExpression"
    // PsiInternalPureXbase.g:381:1: entryRuleXOrExpression : ruleXOrExpression EOF ;
    public final void entryRuleXOrExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:381:23: ( ruleXOrExpression EOF )
            // PsiInternalPureXbase.g:382:2: ruleXOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXOrExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXOrExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXOrExpression"


    // $ANTLR start "ruleXOrExpression"
    // PsiInternalPureXbase.g:387:1: ruleXOrExpression : ( ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
    public final void ruleXOrExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:387:18: ( ( ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
            // PsiInternalPureXbase.g:388:2: ( ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            {
            // PsiInternalPureXbase.g:388:2: ( ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            // PsiInternalPureXbase.g:389:3: ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXOrExpression_XAndExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_11);
            ruleXAndExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalPureXbase.g:396:3: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
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
            	    // PsiInternalPureXbase.g:397:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    {
            	    // PsiInternalPureXbase.g:397:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) )
            	    // PsiInternalPureXbase.g:398:5: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) )
            	    {
            	    // PsiInternalPureXbase.g:408:5: ( () ( ( ruleOpOr ) ) )
            	    // PsiInternalPureXbase.g:409:6: () ( ( ruleOpOr ) )
            	    {
            	    // PsiInternalPureXbase.g:409:6: ()
            	    // PsiInternalPureXbase.g:410:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							precedeComposite(elementTypeProvider.getXOrExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
            	      							doneComposite();
            	      						
            	    }

            	    }

            	    // PsiInternalPureXbase.g:415:6: ( ( ruleOpOr ) )
            	    // PsiInternalPureXbase.g:416:7: ( ruleOpOr )
            	    {
            	    // PsiInternalPureXbase.g:416:7: ( ruleOpOr )
            	    // PsiInternalPureXbase.g:417:8: ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      								markComposite(elementTypeProvider.getXOrExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
            	      							
            	    }
            	    pushFollow(FOLLOW_3);
            	    ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      								doneComposite();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // PsiInternalPureXbase.g:428:4: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    // PsiInternalPureXbase.g:429:5: (lv_rightOperand_3_0= ruleXAndExpression )
            	    {
            	    // PsiInternalPureXbase.g:429:5: (lv_rightOperand_3_0= ruleXAndExpression )
            	    // PsiInternalPureXbase.g:430:6: lv_rightOperand_3_0= ruleXAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXOrExpression_RightOperandXAndExpressionParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_11);
            	    ruleXAndExpression();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
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
        return ;
    }
    // $ANTLR end "ruleXOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // PsiInternalPureXbase.g:444:1: entryRuleOpOr : ruleOpOr EOF ;
    public final void entryRuleOpOr() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:444:14: ( ruleOpOr EOF )
            // PsiInternalPureXbase.g:445:2: ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpOrElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpOr();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOpOr"


    // $ANTLR start "ruleOpOr"
    // PsiInternalPureXbase.g:450:1: ruleOpOr : kw= '||' ;
    public final void ruleOpOr() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalPureXbase.g:450:9: (kw= '||' )
            // PsiInternalPureXbase.g:451:2: kw= '||'
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getOpOr_VerticalLineVerticalLineKeywordElementType());
              	
            }
            kw=(Token)match(input,23,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRuleXAndExpression"
    // PsiInternalPureXbase.g:461:1: entryRuleXAndExpression : ruleXAndExpression EOF ;
    public final void entryRuleXAndExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:461:24: ( ruleXAndExpression EOF )
            // PsiInternalPureXbase.g:462:2: ruleXAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXAndExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXAndExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXAndExpression"


    // $ANTLR start "ruleXAndExpression"
    // PsiInternalPureXbase.g:467:1: ruleXAndExpression : ( ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final void ruleXAndExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:467:19: ( ( ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
            // PsiInternalPureXbase.g:468:2: ( ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            {
            // PsiInternalPureXbase.g:468:2: ( ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            // PsiInternalPureXbase.g:469:3: ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXAndExpression_XEqualityExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_12);
            ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalPureXbase.g:476:3: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
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
            	    // PsiInternalPureXbase.g:477:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    {
            	    // PsiInternalPureXbase.g:477:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) )
            	    // PsiInternalPureXbase.g:478:5: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) )
            	    {
            	    // PsiInternalPureXbase.g:488:5: ( () ( ( ruleOpAnd ) ) )
            	    // PsiInternalPureXbase.g:489:6: () ( ( ruleOpAnd ) )
            	    {
            	    // PsiInternalPureXbase.g:489:6: ()
            	    // PsiInternalPureXbase.g:490:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							precedeComposite(elementTypeProvider.getXAndExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
            	      							doneComposite();
            	      						
            	    }

            	    }

            	    // PsiInternalPureXbase.g:495:6: ( ( ruleOpAnd ) )
            	    // PsiInternalPureXbase.g:496:7: ( ruleOpAnd )
            	    {
            	    // PsiInternalPureXbase.g:496:7: ( ruleOpAnd )
            	    // PsiInternalPureXbase.g:497:8: ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      								markComposite(elementTypeProvider.getXAndExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
            	      							
            	    }
            	    pushFollow(FOLLOW_3);
            	    ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      								doneComposite();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // PsiInternalPureXbase.g:508:4: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    // PsiInternalPureXbase.g:509:5: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    {
            	    // PsiInternalPureXbase.g:509:5: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    // PsiInternalPureXbase.g:510:6: lv_rightOperand_3_0= ruleXEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXAndExpression_RightOperandXEqualityExpressionParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_12);
            	    ruleXEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
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
        return ;
    }
    // $ANTLR end "ruleXAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // PsiInternalPureXbase.g:524:1: entryRuleOpAnd : ruleOpAnd EOF ;
    public final void entryRuleOpAnd() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:524:15: ( ruleOpAnd EOF )
            // PsiInternalPureXbase.g:525:2: ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpAndElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpAnd();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOpAnd"


    // $ANTLR start "ruleOpAnd"
    // PsiInternalPureXbase.g:530:1: ruleOpAnd : kw= '&&' ;
    public final void ruleOpAnd() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalPureXbase.g:530:10: (kw= '&&' )
            // PsiInternalPureXbase.g:531:2: kw= '&&'
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getOpAnd_AmpersandAmpersandKeywordElementType());
              	
            }
            kw=(Token)match(input,24,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRuleXEqualityExpression"
    // PsiInternalPureXbase.g:541:1: entryRuleXEqualityExpression : ruleXEqualityExpression EOF ;
    public final void entryRuleXEqualityExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:541:29: ( ruleXEqualityExpression EOF )
            // PsiInternalPureXbase.g:542:2: ruleXEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXEqualityExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXEqualityExpression"


    // $ANTLR start "ruleXEqualityExpression"
    // PsiInternalPureXbase.g:547:1: ruleXEqualityExpression : ( ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final void ruleXEqualityExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:547:24: ( ( ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
            // PsiInternalPureXbase.g:548:2: ( ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            {
            // PsiInternalPureXbase.g:548:2: ( ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            // PsiInternalPureXbase.g:549:3: ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXEqualityExpression_XRelationalExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_13);
            ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalPureXbase.g:556:3: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
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
            	    // PsiInternalPureXbase.g:557:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    {
            	    // PsiInternalPureXbase.g:557:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) )
            	    // PsiInternalPureXbase.g:558:5: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) )
            	    {
            	    // PsiInternalPureXbase.g:568:5: ( () ( ( ruleOpEquality ) ) )
            	    // PsiInternalPureXbase.g:569:6: () ( ( ruleOpEquality ) )
            	    {
            	    // PsiInternalPureXbase.g:569:6: ()
            	    // PsiInternalPureXbase.g:570:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							precedeComposite(elementTypeProvider.getXEqualityExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
            	      							doneComposite();
            	      						
            	    }

            	    }

            	    // PsiInternalPureXbase.g:575:6: ( ( ruleOpEquality ) )
            	    // PsiInternalPureXbase.g:576:7: ( ruleOpEquality )
            	    {
            	    // PsiInternalPureXbase.g:576:7: ( ruleOpEquality )
            	    // PsiInternalPureXbase.g:577:8: ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      								markComposite(elementTypeProvider.getXEqualityExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
            	      							
            	    }
            	    pushFollow(FOLLOW_3);
            	    ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      								doneComposite();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // PsiInternalPureXbase.g:588:4: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    // PsiInternalPureXbase.g:589:5: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    {
            	    // PsiInternalPureXbase.g:589:5: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    // PsiInternalPureXbase.g:590:6: lv_rightOperand_3_0= ruleXRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXEqualityExpression_RightOperandXRelationalExpressionParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_13);
            	    ruleXRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
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
        return ;
    }
    // $ANTLR end "ruleXEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // PsiInternalPureXbase.g:604:1: entryRuleOpEquality : ruleOpEquality EOF ;
    public final void entryRuleOpEquality() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:604:20: ( ruleOpEquality EOF )
            // PsiInternalPureXbase.g:605:2: ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpEqualityElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpEquality();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOpEquality"


    // $ANTLR start "ruleOpEquality"
    // PsiInternalPureXbase.g:610:1: ruleOpEquality : (kw= '==' | kw= '!=' | kw= '===' | kw= '!==' ) ;
    public final void ruleOpEquality() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalPureXbase.g:610:15: ( (kw= '==' | kw= '!=' | kw= '===' | kw= '!==' ) )
            // PsiInternalPureXbase.g:611:2: (kw= '==' | kw= '!=' | kw= '===' | kw= '!==' )
            {
            // PsiInternalPureXbase.g:611:2: (kw= '==' | kw= '!=' | kw= '===' | kw= '!==' )
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // PsiInternalPureXbase.g:612:3: kw= '=='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpEquality_EqualsSignEqualsSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,25,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:620:3: kw= '!='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpEquality_ExclamationMarkEqualsSignKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,26,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalPureXbase.g:628:3: kw= '==='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpEquality_EqualsSignEqualsSignEqualsSignKeyword_2ElementType());
                      		
                    }
                    kw=(Token)match(input,27,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalPureXbase.g:636:3: kw= '!=='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpEquality_ExclamationMarkEqualsSignEqualsSignKeyword_3ElementType());
                      		
                    }
                    kw=(Token)match(input,28,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRuleXRelationalExpression"
    // PsiInternalPureXbase.g:647:1: entryRuleXRelationalExpression : ruleXRelationalExpression EOF ;
    public final void entryRuleXRelationalExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:647:31: ( ruleXRelationalExpression EOF )
            // PsiInternalPureXbase.g:648:2: ruleXRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXRelationalExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXRelationalExpression"


    // $ANTLR start "ruleXRelationalExpression"
    // PsiInternalPureXbase.g:653:1: ruleXRelationalExpression : ( ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final void ruleXRelationalExpression() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // PsiInternalPureXbase.g:653:26: ( ( ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // PsiInternalPureXbase.g:654:2: ( ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // PsiInternalPureXbase.g:654:2: ( ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // PsiInternalPureXbase.g:655:3: ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXRelationalExpression_XOtherOperatorExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_14);
            ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalPureXbase.g:662:3: ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
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
            	    // PsiInternalPureXbase.g:663:4: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
            	    {
            	    // PsiInternalPureXbase.g:663:4: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
            	    // PsiInternalPureXbase.g:664:5: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // PsiInternalPureXbase.g:664:5: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) )
            	    // PsiInternalPureXbase.g:665:6: ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' )
            	    {
            	    // PsiInternalPureXbase.g:671:6: ( () otherlv_2= 'instanceof' )
            	    // PsiInternalPureXbase.g:672:7: () otherlv_2= 'instanceof'
            	    {
            	    // PsiInternalPureXbase.g:672:7: ()
            	    // PsiInternalPureXbase.g:673:8: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      								precedeComposite(elementTypeProvider.getXRelationalExpression_XInstanceOfExpressionExpressionAction_1_0_0_0_0ElementType());
            	      								doneComposite();
            	      							
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      							markLeaf(elementTypeProvider.getXRelationalExpression_InstanceofKeyword_1_0_0_0_1ElementType());
            	      						
            	    }
            	    otherlv_2=(Token)match(input,29,FOLLOW_15); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      							doneLeaf(otherlv_2);
            	      						
            	    }

            	    }


            	    }

            	    // PsiInternalPureXbase.g:687:5: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // PsiInternalPureXbase.g:688:6: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // PsiInternalPureXbase.g:688:6: (lv_type_3_0= ruleJvmTypeReference )
            	    // PsiInternalPureXbase.g:689:7: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {

            	      							markComposite(elementTypeProvider.getXRelationalExpression_TypeJvmTypeReferenceParserRuleCall_1_0_1_0ElementType());
            	      						
            	    }
            	    pushFollow(FOLLOW_14);
            	    ruleJvmTypeReference();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      							doneComposite();
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalPureXbase.g:700:4: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // PsiInternalPureXbase.g:700:4: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    // PsiInternalPureXbase.g:701:5: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // PsiInternalPureXbase.g:701:5: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) )
            	    // PsiInternalPureXbase.g:702:6: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) )
            	    {
            	    // PsiInternalPureXbase.g:712:6: ( () ( ( ruleOpCompare ) ) )
            	    // PsiInternalPureXbase.g:713:7: () ( ( ruleOpCompare ) )
            	    {
            	    // PsiInternalPureXbase.g:713:7: ()
            	    // PsiInternalPureXbase.g:714:8: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      								precedeComposite(elementTypeProvider.getXRelationalExpression_XBinaryOperationLeftOperandAction_1_1_0_0_0ElementType());
            	      								doneComposite();
            	      							
            	    }

            	    }

            	    // PsiInternalPureXbase.g:719:7: ( ( ruleOpCompare ) )
            	    // PsiInternalPureXbase.g:720:8: ( ruleOpCompare )
            	    {
            	    // PsiInternalPureXbase.g:720:8: ( ruleOpCompare )
            	    // PsiInternalPureXbase.g:721:9: ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      									markComposite(elementTypeProvider.getXRelationalExpression_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0ElementType());
            	      								
            	    }
            	    pushFollow(FOLLOW_3);
            	    ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      									doneComposite();
            	      								
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // PsiInternalPureXbase.g:732:5: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    // PsiInternalPureXbase.g:733:6: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // PsiInternalPureXbase.g:733:6: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    // PsiInternalPureXbase.g:734:7: lv_rightOperand_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      							markComposite(elementTypeProvider.getXRelationalExpression_RightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0ElementType());
            	      						
            	    }
            	    pushFollow(FOLLOW_14);
            	    ruleXOtherOperatorExpression();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      							doneComposite();
            	      						
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
        return ;
    }
    // $ANTLR end "ruleXRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // PsiInternalPureXbase.g:749:1: entryRuleOpCompare : ruleOpCompare EOF ;
    public final void entryRuleOpCompare() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:749:19: ( ruleOpCompare EOF )
            // PsiInternalPureXbase.g:750:2: ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpCompareElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpCompare();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOpCompare"


    // $ANTLR start "ruleOpCompare"
    // PsiInternalPureXbase.g:755:1: ruleOpCompare : (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' ) ;
    public final void ruleOpCompare() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalPureXbase.g:755:14: ( (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' ) )
            // PsiInternalPureXbase.g:756:2: (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' )
            {
            // PsiInternalPureXbase.g:756:2: (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' )
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
                    if (state.backtracking>0) {state.failed=true; return ;}
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // PsiInternalPureXbase.g:757:3: kw= '>='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpCompare_GreaterThanSignEqualsSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,22,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:765:3: (kw= '<' kw= '=' )
                    {
                    // PsiInternalPureXbase.g:765:3: (kw= '<' kw= '=' )
                    // PsiInternalPureXbase.g:766:4: kw= '<' kw= '='
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpCompare_LessThanSignKeyword_1_0ElementType());
                      			
                    }
                    kw=(Token)match(input,20,FOLLOW_6); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpCompare_EqualsSignKeyword_1_1ElementType());
                      			
                    }
                    kw=(Token)match(input,14,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalPureXbase.g:782:3: kw= '>'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpCompare_GreaterThanSignKeyword_2ElementType());
                      		
                    }
                    kw=(Token)match(input,21,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalPureXbase.g:790:3: kw= '<'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpCompare_LessThanSignKeyword_3ElementType());
                      		
                    }
                    kw=(Token)match(input,20,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleOpCompare"


    // $ANTLR start "entryRuleXOtherOperatorExpression"
    // PsiInternalPureXbase.g:801:1: entryRuleXOtherOperatorExpression : ruleXOtherOperatorExpression EOF ;
    public final void entryRuleXOtherOperatorExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:801:34: ( ruleXOtherOperatorExpression EOF )
            // PsiInternalPureXbase.g:802:2: ruleXOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXOtherOperatorExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXOtherOperatorExpression"


    // $ANTLR start "ruleXOtherOperatorExpression"
    // PsiInternalPureXbase.g:807:1: ruleXOtherOperatorExpression : ( ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final void ruleXOtherOperatorExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:807:29: ( ( ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
            // PsiInternalPureXbase.g:808:2: ( ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // PsiInternalPureXbase.g:808:2: ( ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            // PsiInternalPureXbase.g:809:3: ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXOtherOperatorExpression_XAdditiveExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_16);
            ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalPureXbase.g:816:3: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            loop14:
            do {
                int alt14=2;
                alt14 = dfa14.predict(input);
                switch (alt14) {
            	case 1 :
            	    // PsiInternalPureXbase.g:817:4: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // PsiInternalPureXbase.g:817:4: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) )
            	    // PsiInternalPureXbase.g:818:5: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) )
            	    {
            	    // PsiInternalPureXbase.g:828:5: ( () ( ( ruleOpOther ) ) )
            	    // PsiInternalPureXbase.g:829:6: () ( ( ruleOpOther ) )
            	    {
            	    // PsiInternalPureXbase.g:829:6: ()
            	    // PsiInternalPureXbase.g:830:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							precedeComposite(elementTypeProvider.getXOtherOperatorExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
            	      							doneComposite();
            	      						
            	    }

            	    }

            	    // PsiInternalPureXbase.g:835:6: ( ( ruleOpOther ) )
            	    // PsiInternalPureXbase.g:836:7: ( ruleOpOther )
            	    {
            	    // PsiInternalPureXbase.g:836:7: ( ruleOpOther )
            	    // PsiInternalPureXbase.g:837:8: ruleOpOther
            	    {
            	    if ( state.backtracking==0 ) {

            	      								markComposite(elementTypeProvider.getXOtherOperatorExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
            	      							
            	    }
            	    pushFollow(FOLLOW_3);
            	    ruleOpOther();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      								doneComposite();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // PsiInternalPureXbase.g:848:4: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    // PsiInternalPureXbase.g:849:5: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    {
            	    // PsiInternalPureXbase.g:849:5: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    // PsiInternalPureXbase.g:850:6: lv_rightOperand_3_0= ruleXAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXOtherOperatorExpression_RightOperandXAdditiveExpressionParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
            	    ruleXAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
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
        return ;
    }
    // $ANTLR end "ruleXOtherOperatorExpression"


    // $ANTLR start "entryRuleOpOther"
    // PsiInternalPureXbase.g:864:1: entryRuleOpOther : ruleOpOther EOF ;
    public final void entryRuleOpOther() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:864:17: ( ruleOpOther EOF )
            // PsiInternalPureXbase.g:865:2: ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpOtherElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpOther();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOpOther"


    // $ANTLR start "ruleOpOther"
    // PsiInternalPureXbase.g:870:1: ruleOpOther : (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' ) ;
    public final void ruleOpOther() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalPureXbase.g:870:12: ( (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' ) )
            // PsiInternalPureXbase.g:871:2: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )
            {
            // PsiInternalPureXbase.g:871:2: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )
            int alt17=9;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // PsiInternalPureXbase.g:872:3: kw= '->'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpOther_HyphenMinusGreaterThanSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:880:3: kw= '..<'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpOther_FullStopFullStopLessThanSignKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,31,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalPureXbase.g:888:3: (kw= '>' kw= '..' )
                    {
                    // PsiInternalPureXbase.g:888:3: (kw= '>' kw= '..' )
                    // PsiInternalPureXbase.g:889:4: kw= '>' kw= '..'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpOther_GreaterThanSignKeyword_2_0ElementType());
                      			
                    }
                    kw=(Token)match(input,21,FOLLOW_17); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpOther_FullStopFullStopKeyword_2_1ElementType());
                      			
                    }
                    kw=(Token)match(input,32,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // PsiInternalPureXbase.g:905:3: kw= '..'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpOther_FullStopFullStopKeyword_3ElementType());
                      		
                    }
                    kw=(Token)match(input,32,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 5 :
                    // PsiInternalPureXbase.g:913:3: kw= '=>'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpOther_EqualsSignGreaterThanSignKeyword_4ElementType());
                      		
                    }
                    kw=(Token)match(input,33,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalPureXbase.g:921:3: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) )
                    {
                    // PsiInternalPureXbase.g:921:3: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) )
                    // PsiInternalPureXbase.g:922:4: kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpOther_GreaterThanSignKeyword_5_0ElementType());
                      			
                    }
                    kw=(Token)match(input,21,FOLLOW_18); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    // PsiInternalPureXbase.g:929:4: ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' )
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==21) ) {
                        int LA15_1 = input.LA(2);

                        if ( (LA15_1==EOF||(LA15_1>=RULE_STRING && LA15_1<=RULE_ID)||LA15_1==20||(LA15_1>=36 && LA15_1<=37)||LA15_1==42||LA15_1==50||(LA15_1>=52 && LA15_1<=53)||LA15_1==55||LA15_1==58||LA15_1==60||(LA15_1>=64 && LA15_1<=66)||(LA15_1>=69 && LA15_1<=77)||LA15_1==79) ) {
                            alt15=2;
                        }
                        else if ( (LA15_1==21) && (synpred8_PsiInternalPureXbase())) {
                            alt15=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 15, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;
                    }
                    switch (alt15) {
                        case 1 :
                            // PsiInternalPureXbase.g:930:5: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
                            {
                            // PsiInternalPureXbase.g:930:5: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
                            // PsiInternalPureXbase.g:931:6: ( ( '>' '>' ) )=> (kw= '>' kw= '>' )
                            {
                            // PsiInternalPureXbase.g:936:6: (kw= '>' kw= '>' )
                            // PsiInternalPureXbase.g:937:7: kw= '>' kw= '>'
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getOpOther_GreaterThanSignKeyword_5_1_0_0_0ElementType());
                              						
                            }
                            kw=(Token)match(input,21,FOLLOW_18); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(kw);
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getOpOther_GreaterThanSignKeyword_5_1_0_0_1ElementType());
                              						
                            }
                            kw=(Token)match(input,21,FOLLOW_2); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(kw);
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalPureXbase.g:954:5: kw= '>'
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getOpOther_GreaterThanSignKeyword_5_1_1ElementType());
                              				
                            }
                            kw=(Token)match(input,21,FOLLOW_2); if (state.failed) return ;
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
                    // PsiInternalPureXbase.g:964:3: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) )
                    {
                    // PsiInternalPureXbase.g:964:3: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) )
                    // PsiInternalPureXbase.g:965:4: kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpOther_LessThanSignKeyword_6_0ElementType());
                      			
                    }
                    kw=(Token)match(input,20,FOLLOW_19); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    // PsiInternalPureXbase.g:972:4: ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' )
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
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 16, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA16_0==33) ) {
                        alt16=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 0, input);

                        throw nvae;
                    }
                    switch (alt16) {
                        case 1 :
                            // PsiInternalPureXbase.g:973:5: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
                            {
                            // PsiInternalPureXbase.g:973:5: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
                            // PsiInternalPureXbase.g:974:6: ( ( '<' '<' ) )=> (kw= '<' kw= '<' )
                            {
                            // PsiInternalPureXbase.g:979:6: (kw= '<' kw= '<' )
                            // PsiInternalPureXbase.g:980:7: kw= '<' kw= '<'
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getOpOther_LessThanSignKeyword_6_1_0_0_0ElementType());
                              						
                            }
                            kw=(Token)match(input,20,FOLLOW_8); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(kw);
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getOpOther_LessThanSignKeyword_6_1_0_0_1ElementType());
                              						
                            }
                            kw=(Token)match(input,20,FOLLOW_2); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(kw);
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalPureXbase.g:997:5: kw= '<'
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getOpOther_LessThanSignKeyword_6_1_1ElementType());
                              				
                            }
                            kw=(Token)match(input,20,FOLLOW_2); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(kw);
                              				
                            }

                            }
                            break;
                        case 3 :
                            // PsiInternalPureXbase.g:1005:5: kw= '=>'
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getOpOther_EqualsSignGreaterThanSignKeyword_6_1_2ElementType());
                              				
                            }
                            kw=(Token)match(input,33,FOLLOW_2); if (state.failed) return ;
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
                    // PsiInternalPureXbase.g:1015:3: kw= '<>'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpOther_LessThanSignGreaterThanSignKeyword_7ElementType());
                      		
                    }
                    kw=(Token)match(input,34,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 9 :
                    // PsiInternalPureXbase.g:1023:3: kw= '?:'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpOther_QuestionMarkColonKeyword_8ElementType());
                      		
                    }
                    kw=(Token)match(input,35,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleOpOther"


    // $ANTLR start "entryRuleXAdditiveExpression"
    // PsiInternalPureXbase.g:1034:1: entryRuleXAdditiveExpression : ruleXAdditiveExpression EOF ;
    public final void entryRuleXAdditiveExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:1034:29: ( ruleXAdditiveExpression EOF )
            // PsiInternalPureXbase.g:1035:2: ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXAdditiveExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXAdditiveExpression"


    // $ANTLR start "ruleXAdditiveExpression"
    // PsiInternalPureXbase.g:1040:1: ruleXAdditiveExpression : ( ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final void ruleXAdditiveExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:1040:24: ( ( ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // PsiInternalPureXbase.g:1041:2: ( ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // PsiInternalPureXbase.g:1041:2: ( ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // PsiInternalPureXbase.g:1042:3: ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXAdditiveExpression_XMultiplicativeExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_20);
            ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalPureXbase.g:1049:3: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
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
            	    // PsiInternalPureXbase.g:1050:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // PsiInternalPureXbase.g:1050:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
            	    // PsiInternalPureXbase.g:1051:5: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
            	    {
            	    // PsiInternalPureXbase.g:1061:5: ( () ( ( ruleOpAdd ) ) )
            	    // PsiInternalPureXbase.g:1062:6: () ( ( ruleOpAdd ) )
            	    {
            	    // PsiInternalPureXbase.g:1062:6: ()
            	    // PsiInternalPureXbase.g:1063:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							precedeComposite(elementTypeProvider.getXAdditiveExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
            	      							doneComposite();
            	      						
            	    }

            	    }

            	    // PsiInternalPureXbase.g:1068:6: ( ( ruleOpAdd ) )
            	    // PsiInternalPureXbase.g:1069:7: ( ruleOpAdd )
            	    {
            	    // PsiInternalPureXbase.g:1069:7: ( ruleOpAdd )
            	    // PsiInternalPureXbase.g:1070:8: ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      								markComposite(elementTypeProvider.getXAdditiveExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
            	      							
            	    }
            	    pushFollow(FOLLOW_3);
            	    ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      								doneComposite();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // PsiInternalPureXbase.g:1081:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // PsiInternalPureXbase.g:1082:5: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // PsiInternalPureXbase.g:1082:5: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // PsiInternalPureXbase.g:1083:6: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXAdditiveExpression_RightOperandXMultiplicativeExpressionParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_20);
            	    ruleXMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
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
        return ;
    }
    // $ANTLR end "ruleXAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // PsiInternalPureXbase.g:1097:1: entryRuleOpAdd : ruleOpAdd EOF ;
    public final void entryRuleOpAdd() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:1097:15: ( ruleOpAdd EOF )
            // PsiInternalPureXbase.g:1098:2: ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpAddElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpAdd();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOpAdd"


    // $ANTLR start "ruleOpAdd"
    // PsiInternalPureXbase.g:1103:1: ruleOpAdd : (kw= '+' | kw= '-' ) ;
    public final void ruleOpAdd() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalPureXbase.g:1103:10: ( (kw= '+' | kw= '-' ) )
            // PsiInternalPureXbase.g:1104:2: (kw= '+' | kw= '-' )
            {
            // PsiInternalPureXbase.g:1104:2: (kw= '+' | kw= '-' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==36) ) {
                alt19=1;
            }
            else if ( (LA19_0==37) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // PsiInternalPureXbase.g:1105:3: kw= '+'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpAdd_PlusSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,36,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:1113:3: kw= '-'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpAdd_HyphenMinusKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,37,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleOpAdd"


    // $ANTLR start "entryRuleXMultiplicativeExpression"
    // PsiInternalPureXbase.g:1124:1: entryRuleXMultiplicativeExpression : ruleXMultiplicativeExpression EOF ;
    public final void entryRuleXMultiplicativeExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:1124:35: ( ruleXMultiplicativeExpression EOF )
            // PsiInternalPureXbase.g:1125:2: ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXMultiplicativeExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXMultiplicativeExpression"


    // $ANTLR start "ruleXMultiplicativeExpression"
    // PsiInternalPureXbase.g:1130:1: ruleXMultiplicativeExpression : ( ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final void ruleXMultiplicativeExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:1130:30: ( ( ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // PsiInternalPureXbase.g:1131:2: ( ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // PsiInternalPureXbase.g:1131:2: ( ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // PsiInternalPureXbase.g:1132:3: ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXMultiplicativeExpression_XUnaryOperationParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_21);
            ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalPureXbase.g:1139:3: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
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
            	    // PsiInternalPureXbase.g:1140:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // PsiInternalPureXbase.g:1140:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
            	    // PsiInternalPureXbase.g:1141:5: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
            	    {
            	    // PsiInternalPureXbase.g:1151:5: ( () ( ( ruleOpMulti ) ) )
            	    // PsiInternalPureXbase.g:1152:6: () ( ( ruleOpMulti ) )
            	    {
            	    // PsiInternalPureXbase.g:1152:6: ()
            	    // PsiInternalPureXbase.g:1153:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							precedeComposite(elementTypeProvider.getXMultiplicativeExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
            	      							doneComposite();
            	      						
            	    }

            	    }

            	    // PsiInternalPureXbase.g:1158:6: ( ( ruleOpMulti ) )
            	    // PsiInternalPureXbase.g:1159:7: ( ruleOpMulti )
            	    {
            	    // PsiInternalPureXbase.g:1159:7: ( ruleOpMulti )
            	    // PsiInternalPureXbase.g:1160:8: ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      								markComposite(elementTypeProvider.getXMultiplicativeExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
            	      							
            	    }
            	    pushFollow(FOLLOW_3);
            	    ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      								doneComposite();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // PsiInternalPureXbase.g:1171:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // PsiInternalPureXbase.g:1172:5: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // PsiInternalPureXbase.g:1172:5: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // PsiInternalPureXbase.g:1173:6: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXMultiplicativeExpression_RightOperandXUnaryOperationParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_21);
            	    ruleXUnaryOperation();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
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
        return ;
    }
    // $ANTLR end "ruleXMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // PsiInternalPureXbase.g:1187:1: entryRuleOpMulti : ruleOpMulti EOF ;
    public final void entryRuleOpMulti() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:1187:17: ( ruleOpMulti EOF )
            // PsiInternalPureXbase.g:1188:2: ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpMultiElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpMulti();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOpMulti"


    // $ANTLR start "ruleOpMulti"
    // PsiInternalPureXbase.g:1193:1: ruleOpMulti : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final void ruleOpMulti() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalPureXbase.g:1193:12: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // PsiInternalPureXbase.g:1194:2: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // PsiInternalPureXbase.g:1194:2: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // PsiInternalPureXbase.g:1195:3: kw= '*'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMulti_AsteriskKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,38,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:1203:3: kw= '**'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMulti_AsteriskAsteriskKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,39,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalPureXbase.g:1211:3: kw= '/'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMulti_SolidusKeyword_2ElementType());
                      		
                    }
                    kw=(Token)match(input,40,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalPureXbase.g:1219:3: kw= '%'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMulti_PercentSignKeyword_3ElementType());
                      		
                    }
                    kw=(Token)match(input,41,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleOpMulti"


    // $ANTLR start "entryRuleXUnaryOperation"
    // PsiInternalPureXbase.g:1230:1: entryRuleXUnaryOperation : ruleXUnaryOperation EOF ;
    public final void entryRuleXUnaryOperation() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:1230:25: ( ruleXUnaryOperation EOF )
            // PsiInternalPureXbase.g:1231:2: ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXUnaryOperationElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXUnaryOperation"


    // $ANTLR start "ruleXUnaryOperation"
    // PsiInternalPureXbase.g:1236:1: ruleXUnaryOperation : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | ruleXCastedExpression ) ;
    public final void ruleXUnaryOperation() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:1236:20: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | ruleXCastedExpression ) )
            // PsiInternalPureXbase.g:1237:2: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | ruleXCastedExpression )
            {
            // PsiInternalPureXbase.g:1237:2: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | ruleXCastedExpression )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=36 && LA22_0<=37)||LA22_0==42) ) {
                alt22=1;
            }
            else if ( ((LA22_0>=RULE_STRING && LA22_0<=RULE_ID)||LA22_0==20||LA22_0==50||(LA22_0>=52 && LA22_0<=53)||LA22_0==55||LA22_0==58||LA22_0==60||(LA22_0>=64 && LA22_0<=66)||(LA22_0>=69 && LA22_0<=77)||LA22_0==79) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // PsiInternalPureXbase.g:1238:3: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) )
                    {
                    // PsiInternalPureXbase.g:1238:3: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) )
                    // PsiInternalPureXbase.g:1239:4: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) )
                    {
                    // PsiInternalPureXbase.g:1239:4: ()
                    // PsiInternalPureXbase.g:1240:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getXUnaryOperation_XUnaryOperationAction_0_0ElementType());
                      					doneComposite();
                      				
                    }

                    }

                    // PsiInternalPureXbase.g:1245:4: ( ( ruleOpUnary ) )
                    // PsiInternalPureXbase.g:1246:5: ( ruleOpUnary )
                    {
                    // PsiInternalPureXbase.g:1246:5: ( ruleOpUnary )
                    // PsiInternalPureXbase.g:1247:6: ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXUnaryOperation_FeatureJvmIdentifiableElementCrossReference_0_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_3);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:1256:4: ( (lv_operand_2_0= ruleXUnaryOperation ) )
                    // PsiInternalPureXbase.g:1257:5: (lv_operand_2_0= ruleXUnaryOperation )
                    {
                    // PsiInternalPureXbase.g:1257:5: (lv_operand_2_0= ruleXUnaryOperation )
                    // PsiInternalPureXbase.g:1258:6: lv_operand_2_0= ruleXUnaryOperation
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXUnaryOperation_OperandXUnaryOperationParserRuleCall_0_2_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    ruleXUnaryOperation();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:1269:3: ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXUnaryOperation_XCastedExpressionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXCastedExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

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
        return ;
    }
    // $ANTLR end "ruleXUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // PsiInternalPureXbase.g:1280:1: entryRuleOpUnary : ruleOpUnary EOF ;
    public final void entryRuleOpUnary() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:1280:17: ( ruleOpUnary EOF )
            // PsiInternalPureXbase.g:1281:2: ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpUnaryElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpUnary();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOpUnary"


    // $ANTLR start "ruleOpUnary"
    // PsiInternalPureXbase.g:1286:1: ruleOpUnary : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final void ruleOpUnary() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalPureXbase.g:1286:12: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // PsiInternalPureXbase.g:1287:2: (kw= '!' | kw= '-' | kw= '+' )
            {
            // PsiInternalPureXbase.g:1287:2: (kw= '!' | kw= '-' | kw= '+' )
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // PsiInternalPureXbase.g:1288:3: kw= '!'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpUnary_ExclamationMarkKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,42,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:1296:3: kw= '-'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpUnary_HyphenMinusKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,37,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalPureXbase.g:1304:3: kw= '+'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpUnary_PlusSignKeyword_2ElementType());
                      		
                    }
                    kw=(Token)match(input,36,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleOpUnary"


    // $ANTLR start "entryRuleXCastedExpression"
    // PsiInternalPureXbase.g:1315:1: entryRuleXCastedExpression : ruleXCastedExpression EOF ;
    public final void entryRuleXCastedExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:1315:27: ( ruleXCastedExpression EOF )
            // PsiInternalPureXbase.g:1316:2: ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXCastedExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXCastedExpression"


    // $ANTLR start "ruleXCastedExpression"
    // PsiInternalPureXbase.g:1321:1: ruleXCastedExpression : ( ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) ;
    public final void ruleXCastedExpression() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // PsiInternalPureXbase.g:1321:22: ( ( ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) )
            // PsiInternalPureXbase.g:1322:2: ( ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            {
            // PsiInternalPureXbase.g:1322:2: ( ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            // PsiInternalPureXbase.g:1323:3: ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXCastedExpression_XPostfixOperationParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_22);
            ruleXPostfixOperation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalPureXbase.g:1330:3: ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
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
            	    // PsiInternalPureXbase.g:1331:4: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // PsiInternalPureXbase.g:1331:4: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) )
            	    // PsiInternalPureXbase.g:1332:5: ( ( () 'as' ) )=> ( () otherlv_2= 'as' )
            	    {
            	    // PsiInternalPureXbase.g:1338:5: ( () otherlv_2= 'as' )
            	    // PsiInternalPureXbase.g:1339:6: () otherlv_2= 'as'
            	    {
            	    // PsiInternalPureXbase.g:1339:6: ()
            	    // PsiInternalPureXbase.g:1340:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							precedeComposite(elementTypeProvider.getXCastedExpression_XCastedExpressionTargetAction_1_0_0_0ElementType());
            	      							doneComposite();
            	      						
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      						markLeaf(elementTypeProvider.getXCastedExpression_AsKeyword_1_0_0_1ElementType());
            	      					
            	    }
            	    otherlv_2=(Token)match(input,43,FOLLOW_15); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneLeaf(otherlv_2);
            	      					
            	    }

            	    }


            	    }

            	    // PsiInternalPureXbase.g:1354:4: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // PsiInternalPureXbase.g:1355:5: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // PsiInternalPureXbase.g:1355:5: (lv_type_3_0= ruleJvmTypeReference )
            	    // PsiInternalPureXbase.g:1356:6: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXCastedExpression_TypeJvmTypeReferenceParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_22);
            	    ruleJvmTypeReference();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
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
        return ;
    }
    // $ANTLR end "ruleXCastedExpression"


    // $ANTLR start "entryRuleXPostfixOperation"
    // PsiInternalPureXbase.g:1370:1: entryRuleXPostfixOperation : ruleXPostfixOperation EOF ;
    public final void entryRuleXPostfixOperation() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:1370:27: ( ruleXPostfixOperation EOF )
            // PsiInternalPureXbase.g:1371:2: ruleXPostfixOperation EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXPostfixOperationElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXPostfixOperation();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXPostfixOperation"


    // $ANTLR start "ruleXPostfixOperation"
    // PsiInternalPureXbase.g:1376:1: ruleXPostfixOperation : ( ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? ) ;
    public final void ruleXPostfixOperation() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:1376:22: ( ( ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? ) )
            // PsiInternalPureXbase.g:1377:2: ( ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? )
            {
            // PsiInternalPureXbase.g:1377:2: ( ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? )
            // PsiInternalPureXbase.g:1378:3: ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )?
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXPostfixOperation_XMemberFeatureCallParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_23);
            ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalPureXbase.g:1385:3: ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )?
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
                    // PsiInternalPureXbase.g:1386:4: ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) )
                    {
                    // PsiInternalPureXbase.g:1396:4: ( () ( ( ruleOpPostfix ) ) )
                    // PsiInternalPureXbase.g:1397:5: () ( ( ruleOpPostfix ) )
                    {
                    // PsiInternalPureXbase.g:1397:5: ()
                    // PsiInternalPureXbase.g:1398:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						precedeComposite(elementTypeProvider.getXPostfixOperation_XPostfixOperationOperandAction_1_0_0ElementType());
                      						doneComposite();
                      					
                    }

                    }

                    // PsiInternalPureXbase.g:1403:5: ( ( ruleOpPostfix ) )
                    // PsiInternalPureXbase.g:1404:6: ( ruleOpPostfix )
                    {
                    // PsiInternalPureXbase.g:1404:6: ( ruleOpPostfix )
                    // PsiInternalPureXbase.g:1405:7: ruleOpPostfix
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getXPostfixOperation_FeatureJvmIdentifiableElementCrossReference_1_0_1_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    ruleOpPostfix();

                    state._fsp--;
                    if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleXPostfixOperation"


    // $ANTLR start "entryRuleOpPostfix"
    // PsiInternalPureXbase.g:1420:1: entryRuleOpPostfix : ruleOpPostfix EOF ;
    public final void entryRuleOpPostfix() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:1420:19: ( ruleOpPostfix EOF )
            // PsiInternalPureXbase.g:1421:2: ruleOpPostfix EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpPostfixElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleOpPostfix();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOpPostfix"


    // $ANTLR start "ruleOpPostfix"
    // PsiInternalPureXbase.g:1426:1: ruleOpPostfix : (kw= '++' | kw= '--' ) ;
    public final void ruleOpPostfix() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalPureXbase.g:1426:14: ( (kw= '++' | kw= '--' ) )
            // PsiInternalPureXbase.g:1427:2: (kw= '++' | kw= '--' )
            {
            // PsiInternalPureXbase.g:1427:2: (kw= '++' | kw= '--' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==44) ) {
                alt26=1;
            }
            else if ( (LA26_0==45) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // PsiInternalPureXbase.g:1428:3: kw= '++'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpPostfix_PlusSignPlusSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,44,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:1436:3: kw= '--'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpPostfix_HyphenMinusHyphenMinusKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,45,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleOpPostfix"


    // $ANTLR start "entryRuleXMemberFeatureCall"
    // PsiInternalPureXbase.g:1447:1: entryRuleXMemberFeatureCall : ruleXMemberFeatureCall EOF ;
    public final void entryRuleXMemberFeatureCall() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:1447:28: ( ruleXMemberFeatureCall EOF )
            // PsiInternalPureXbase.g:1448:2: ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXMemberFeatureCallElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXMemberFeatureCall"


    // $ANTLR start "ruleXMemberFeatureCall"
    // PsiInternalPureXbase.g:1453:1: ruleXMemberFeatureCall : ( ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* ) ;
    public final void ruleXMemberFeatureCall() throws RecognitionException {
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

        try {
            // PsiInternalPureXbase.g:1453:23: ( ( ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* ) )
            // PsiInternalPureXbase.g:1454:2: ( ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* )
            {
            // PsiInternalPureXbase.g:1454:2: ( ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* )
            // PsiInternalPureXbase.g:1455:3: ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXMemberFeatureCall_XPrimaryExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_24);
            ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalPureXbase.g:1462:3: ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )*
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
            	    // PsiInternalPureXbase.g:1463:4: ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) )
            	    {
            	    // PsiInternalPureXbase.g:1463:4: ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) )
            	    // PsiInternalPureXbase.g:1464:5: ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) )
            	    {
            	    // PsiInternalPureXbase.g:1464:5: ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
            	    // PsiInternalPureXbase.g:1465:6: ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
            	    {
            	    // PsiInternalPureXbase.g:1485:6: ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
            	    // PsiInternalPureXbase.g:1486:7: () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
            	    {
            	    // PsiInternalPureXbase.g:1486:7: ()
            	    // PsiInternalPureXbase.g:1487:8: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      								precedeComposite(elementTypeProvider.getXMemberFeatureCall_XAssignmentAssignableAction_1_0_0_0_0ElementType());
            	      								doneComposite();
            	      							
            	    }

            	    }

            	    // PsiInternalPureXbase.g:1492:7: (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) )
            	    int alt27=2;
            	    int LA27_0 = input.LA(1);

            	    if ( (LA27_0==46) ) {
            	        alt27=1;
            	    }
            	    else if ( (LA27_0==47) ) {
            	        alt27=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 27, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt27) {
            	        case 1 :
            	            // PsiInternalPureXbase.g:1493:8: otherlv_2= '.'
            	            {
            	            if ( state.backtracking==0 ) {

            	              								markLeaf(elementTypeProvider.getXMemberFeatureCall_FullStopKeyword_1_0_0_0_1_0ElementType());
            	              							
            	            }
            	            otherlv_2=(Token)match(input,46,FOLLOW_25); if (state.failed) return ;
            	            if ( state.backtracking==0 ) {

            	              								doneLeaf(otherlv_2);
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // PsiInternalPureXbase.g:1501:8: ( (lv_explicitStatic_3_0= '::' ) )
            	            {
            	            // PsiInternalPureXbase.g:1501:8: ( (lv_explicitStatic_3_0= '::' ) )
            	            // PsiInternalPureXbase.g:1502:9: (lv_explicitStatic_3_0= '::' )
            	            {
            	            // PsiInternalPureXbase.g:1502:9: (lv_explicitStatic_3_0= '::' )
            	            // PsiInternalPureXbase.g:1503:10: lv_explicitStatic_3_0= '::'
            	            {
            	            if ( state.backtracking==0 ) {

            	              										markLeaf(elementTypeProvider.getXMemberFeatureCall_ExplicitStaticColonColonKeyword_1_0_0_0_1_1_0ElementType());
            	              									
            	            }
            	            lv_explicitStatic_3_0=(Token)match(input,47,FOLLOW_25); if (state.failed) return ;
            	            if ( state.backtracking==0 ) {

            	              										doneLeaf(lv_explicitStatic_3_0);
            	              									
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // PsiInternalPureXbase.g:1513:7: ( ( ruleFeatureCallID ) )
            	    // PsiInternalPureXbase.g:1514:8: ( ruleFeatureCallID )
            	    {
            	    // PsiInternalPureXbase.g:1514:8: ( ruleFeatureCallID )
            	    // PsiInternalPureXbase.g:1515:9: ruleFeatureCallID
            	    {
            	    if ( state.backtracking==0 ) {

            	      									markComposite(elementTypeProvider.getXMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0ElementType());
            	      								
            	    }
            	    pushFollow(FOLLOW_6);
            	    ruleFeatureCallID();

            	    state._fsp--;
            	    if (state.failed) return ;
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
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      							doneComposite();
            	      						
            	    }

            	    }


            	    }

            	    // PsiInternalPureXbase.g:1533:5: ( (lv_value_6_0= ruleXAssignment ) )
            	    // PsiInternalPureXbase.g:1534:6: (lv_value_6_0= ruleXAssignment )
            	    {
            	    // PsiInternalPureXbase.g:1534:6: (lv_value_6_0= ruleXAssignment )
            	    // PsiInternalPureXbase.g:1535:7: lv_value_6_0= ruleXAssignment
            	    {
            	    if ( state.backtracking==0 ) {

            	      							markComposite(elementTypeProvider.getXMemberFeatureCall_ValueXAssignmentParserRuleCall_1_0_1_0ElementType());
            	      						
            	    }
            	    pushFollow(FOLLOW_24);
            	    ruleXAssignment();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      							doneComposite();
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalPureXbase.g:1546:4: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? )
            	    {
            	    // PsiInternalPureXbase.g:1546:4: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? )
            	    // PsiInternalPureXbase.g:1547:5: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?
            	    {
            	    // PsiInternalPureXbase.g:1547:5: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) )
            	    // PsiInternalPureXbase.g:1548:6: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) )
            	    {
            	    // PsiInternalPureXbase.g:1568:6: ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) )
            	    // PsiInternalPureXbase.g:1569:7: () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) )
            	    {
            	    // PsiInternalPureXbase.g:1569:7: ()
            	    // PsiInternalPureXbase.g:1570:8: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      								precedeComposite(elementTypeProvider.getXMemberFeatureCall_XMemberFeatureCallMemberCallTargetAction_1_1_0_0_0ElementType());
            	      								doneComposite();
            	      							
            	    }

            	    }

            	    // PsiInternalPureXbase.g:1575:7: (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) )
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
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 28, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt28) {
            	        case 1 :
            	            // PsiInternalPureXbase.g:1576:8: otherlv_8= '.'
            	            {
            	            if ( state.backtracking==0 ) {

            	              								markLeaf(elementTypeProvider.getXMemberFeatureCall_FullStopKeyword_1_1_0_0_1_0ElementType());
            	              							
            	            }
            	            otherlv_8=(Token)match(input,46,FOLLOW_26); if (state.failed) return ;
            	            if ( state.backtracking==0 ) {

            	              								doneLeaf(otherlv_8);
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // PsiInternalPureXbase.g:1584:8: ( (lv_nullSafe_9_0= '?.' ) )
            	            {
            	            // PsiInternalPureXbase.g:1584:8: ( (lv_nullSafe_9_0= '?.' ) )
            	            // PsiInternalPureXbase.g:1585:9: (lv_nullSafe_9_0= '?.' )
            	            {
            	            // PsiInternalPureXbase.g:1585:9: (lv_nullSafe_9_0= '?.' )
            	            // PsiInternalPureXbase.g:1586:10: lv_nullSafe_9_0= '?.'
            	            {
            	            if ( state.backtracking==0 ) {

            	              										markLeaf(elementTypeProvider.getXMemberFeatureCall_NullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0ElementType());
            	              									
            	            }
            	            lv_nullSafe_9_0=(Token)match(input,48,FOLLOW_26); if (state.failed) return ;
            	            if ( state.backtracking==0 ) {

            	              										doneLeaf(lv_nullSafe_9_0);
            	              									
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // PsiInternalPureXbase.g:1596:8: ( (lv_explicitStatic_10_0= '::' ) )
            	            {
            	            // PsiInternalPureXbase.g:1596:8: ( (lv_explicitStatic_10_0= '::' ) )
            	            // PsiInternalPureXbase.g:1597:9: (lv_explicitStatic_10_0= '::' )
            	            {
            	            // PsiInternalPureXbase.g:1597:9: (lv_explicitStatic_10_0= '::' )
            	            // PsiInternalPureXbase.g:1598:10: lv_explicitStatic_10_0= '::'
            	            {
            	            if ( state.backtracking==0 ) {

            	              										markLeaf(elementTypeProvider.getXMemberFeatureCall_ExplicitStaticColonColonKeyword_1_1_0_0_1_2_0ElementType());
            	              									
            	            }
            	            lv_explicitStatic_10_0=(Token)match(input,47,FOLLOW_26); if (state.failed) return ;
            	            if ( state.backtracking==0 ) {

            	              										doneLeaf(lv_explicitStatic_10_0);
            	              									
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // PsiInternalPureXbase.g:1610:5: (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )?
            	    int alt30=2;
            	    int LA30_0 = input.LA(1);

            	    if ( (LA30_0==20) ) {
            	        alt30=1;
            	    }
            	    switch (alt30) {
            	        case 1 :
            	            // PsiInternalPureXbase.g:1611:6: otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>'
            	            {
            	            if ( state.backtracking==0 ) {

            	              						markLeaf(elementTypeProvider.getXMemberFeatureCall_LessThanSignKeyword_1_1_1_0ElementType());
            	              					
            	            }
            	            otherlv_11=(Token)match(input,20,FOLLOW_27); if (state.failed) return ;
            	            if ( state.backtracking==0 ) {

            	              						doneLeaf(otherlv_11);
            	              					
            	            }
            	            // PsiInternalPureXbase.g:1618:6: ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) )
            	            // PsiInternalPureXbase.g:1619:7: (lv_typeArguments_12_0= ruleJvmArgumentTypeReference )
            	            {
            	            // PsiInternalPureXbase.g:1619:7: (lv_typeArguments_12_0= ruleJvmArgumentTypeReference )
            	            // PsiInternalPureXbase.g:1620:8: lv_typeArguments_12_0= ruleJvmArgumentTypeReference
            	            {
            	            if ( state.backtracking==0 ) {

            	              								markComposite(elementTypeProvider.getXMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0ElementType());
            	              							
            	            }
            	            pushFollow(FOLLOW_28);
            	            ruleJvmArgumentTypeReference();

            	            state._fsp--;
            	            if (state.failed) return ;
            	            if ( state.backtracking==0 ) {

            	              								doneComposite();
            	              							
            	            }

            	            }


            	            }

            	            // PsiInternalPureXbase.g:1629:6: (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )*
            	            loop29:
            	            do {
            	                int alt29=2;
            	                int LA29_0 = input.LA(1);

            	                if ( (LA29_0==49) ) {
            	                    alt29=1;
            	                }


            	                switch (alt29) {
            	            	case 1 :
            	            	    // PsiInternalPureXbase.g:1630:7: otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) )
            	            	    {
            	            	    if ( state.backtracking==0 ) {

            	            	      							markLeaf(elementTypeProvider.getXMemberFeatureCall_CommaKeyword_1_1_1_2_0ElementType());
            	            	      						
            	            	    }
            	            	    otherlv_13=(Token)match(input,49,FOLLOW_27); if (state.failed) return ;
            	            	    if ( state.backtracking==0 ) {

            	            	      							doneLeaf(otherlv_13);
            	            	      						
            	            	    }
            	            	    // PsiInternalPureXbase.g:1637:7: ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) )
            	            	    // PsiInternalPureXbase.g:1638:8: (lv_typeArguments_14_0= ruleJvmArgumentTypeReference )
            	            	    {
            	            	    // PsiInternalPureXbase.g:1638:8: (lv_typeArguments_14_0= ruleJvmArgumentTypeReference )
            	            	    // PsiInternalPureXbase.g:1639:9: lv_typeArguments_14_0= ruleJvmArgumentTypeReference
            	            	    {
            	            	    if ( state.backtracking==0 ) {

            	            	      									markComposite(elementTypeProvider.getXMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0ElementType());
            	            	      								
            	            	    }
            	            	    pushFollow(FOLLOW_28);
            	            	    ruleJvmArgumentTypeReference();

            	            	    state._fsp--;
            	            	    if (state.failed) return ;
            	            	    if ( state.backtracking==0 ) {

            	            	      									doneComposite();
            	            	      								
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
            	            otherlv_15=(Token)match(input,21,FOLLOW_26); if (state.failed) return ;
            	            if ( state.backtracking==0 ) {

            	              						doneLeaf(otherlv_15);
            	              					
            	            }

            	            }
            	            break;

            	    }

            	    // PsiInternalPureXbase.g:1657:5: ( ( ruleIdOrSuper ) )
            	    // PsiInternalPureXbase.g:1658:6: ( ruleIdOrSuper )
            	    {
            	    // PsiInternalPureXbase.g:1658:6: ( ruleIdOrSuper )
            	    // PsiInternalPureXbase.g:1659:7: ruleIdOrSuper
            	    {
            	    if ( state.backtracking==0 ) {

            	      							markComposite(elementTypeProvider.getXMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_1_2_0ElementType());
            	      						
            	    }
            	    pushFollow(FOLLOW_29);
            	    ruleIdOrSuper();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      							doneComposite();
            	      						
            	    }

            	    }


            	    }

            	    // PsiInternalPureXbase.g:1668:5: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )?
            	    int alt33=2;
            	    alt33 = dfa33.predict(input);
            	    switch (alt33) {
            	        case 1 :
            	            // PsiInternalPureXbase.g:1669:6: ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')'
            	            {
            	            // PsiInternalPureXbase.g:1669:6: ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) )
            	            // PsiInternalPureXbase.g:1670:7: ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' )
            	            {
            	            // PsiInternalPureXbase.g:1674:7: (lv_explicitOperationCall_17_0= '(' )
            	            // PsiInternalPureXbase.g:1675:8: lv_explicitOperationCall_17_0= '('
            	            {
            	            if ( state.backtracking==0 ) {

            	              								markLeaf(elementTypeProvider.getXMemberFeatureCall_ExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0ElementType());
            	              							
            	            }
            	            lv_explicitOperationCall_17_0=(Token)match(input,50,FOLLOW_30); if (state.failed) return ;
            	            if ( state.backtracking==0 ) {

            	              								doneLeaf(lv_explicitOperationCall_17_0);
            	              							
            	            }

            	            }


            	            }

            	            // PsiInternalPureXbase.g:1684:6: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )?
            	            int alt32=3;
            	            alt32 = dfa32.predict(input);
            	            switch (alt32) {
            	                case 1 :
            	                    // PsiInternalPureXbase.g:1685:7: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) )
            	                    {
            	                    // PsiInternalPureXbase.g:1685:7: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) )
            	                    // PsiInternalPureXbase.g:1686:8: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure )
            	                    {
            	                    // PsiInternalPureXbase.g:1711:8: (lv_memberCallArguments_18_0= ruleXShortClosure )
            	                    // PsiInternalPureXbase.g:1712:9: lv_memberCallArguments_18_0= ruleXShortClosure
            	                    {
            	                    if ( state.backtracking==0 ) {

            	                      									markComposite(elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0ElementType());
            	                      								
            	                    }
            	                    pushFollow(FOLLOW_31);
            	                    ruleXShortClosure();

            	                    state._fsp--;
            	                    if (state.failed) return ;
            	                    if ( state.backtracking==0 ) {

            	                      									doneComposite();
            	                      								
            	                    }

            	                    }


            	                    }


            	                    }
            	                    break;
            	                case 2 :
            	                    // PsiInternalPureXbase.g:1722:7: ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* )
            	                    {
            	                    // PsiInternalPureXbase.g:1722:7: ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* )
            	                    // PsiInternalPureXbase.g:1723:8: ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )*
            	                    {
            	                    // PsiInternalPureXbase.g:1723:8: ( (lv_memberCallArguments_19_0= ruleXExpression ) )
            	                    // PsiInternalPureXbase.g:1724:9: (lv_memberCallArguments_19_0= ruleXExpression )
            	                    {
            	                    // PsiInternalPureXbase.g:1724:9: (lv_memberCallArguments_19_0= ruleXExpression )
            	                    // PsiInternalPureXbase.g:1725:10: lv_memberCallArguments_19_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {

            	                      										markComposite(elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0ElementType());
            	                      									
            	                    }
            	                    pushFollow(FOLLOW_32);
            	                    ruleXExpression();

            	                    state._fsp--;
            	                    if (state.failed) return ;
            	                    if ( state.backtracking==0 ) {

            	                      										doneComposite();
            	                      									
            	                    }

            	                    }


            	                    }

            	                    // PsiInternalPureXbase.g:1734:8: (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )*
            	                    loop31:
            	                    do {
            	                        int alt31=2;
            	                        int LA31_0 = input.LA(1);

            	                        if ( (LA31_0==49) ) {
            	                            alt31=1;
            	                        }


            	                        switch (alt31) {
            	                    	case 1 :
            	                    	    // PsiInternalPureXbase.g:1735:9: otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) )
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {

            	                    	      									markLeaf(elementTypeProvider.getXMemberFeatureCall_CommaKeyword_1_1_3_1_1_1_0ElementType());
            	                    	      								
            	                    	    }
            	                    	    otherlv_20=(Token)match(input,49,FOLLOW_3); if (state.failed) return ;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      									doneLeaf(otherlv_20);
            	                    	      								
            	                    	    }
            	                    	    // PsiInternalPureXbase.g:1742:9: ( (lv_memberCallArguments_21_0= ruleXExpression ) )
            	                    	    // PsiInternalPureXbase.g:1743:10: (lv_memberCallArguments_21_0= ruleXExpression )
            	                    	    {
            	                    	    // PsiInternalPureXbase.g:1743:10: (lv_memberCallArguments_21_0= ruleXExpression )
            	                    	    // PsiInternalPureXbase.g:1744:11: lv_memberCallArguments_21_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {

            	                    	      											markComposite(elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0ElementType());
            	                    	      										
            	                    	    }
            	                    	    pushFollow(FOLLOW_32);
            	                    	    ruleXExpression();

            	                    	    state._fsp--;
            	                    	    if (state.failed) return ;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      											doneComposite();
            	                    	      										
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
            	            otherlv_22=(Token)match(input,51,FOLLOW_33); if (state.failed) return ;
            	            if ( state.backtracking==0 ) {

            	              						doneLeaf(otherlv_22);
            	              					
            	            }

            	            }
            	            break;

            	    }

            	    // PsiInternalPureXbase.g:1764:5: ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?
            	    int alt34=2;
            	    alt34 = dfa34.predict(input);
            	    switch (alt34) {
            	        case 1 :
            	            // PsiInternalPureXbase.g:1765:6: ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure )
            	            {
            	            // PsiInternalPureXbase.g:1771:6: (lv_memberCallArguments_23_0= ruleXClosure )
            	            // PsiInternalPureXbase.g:1772:7: lv_memberCallArguments_23_0= ruleXClosure
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markComposite(elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXClosureParserRuleCall_1_1_4_0ElementType());
            	              						
            	            }
            	            pushFollow(FOLLOW_24);
            	            ruleXClosure();

            	            state._fsp--;
            	            if (state.failed) return ;
            	            if ( state.backtracking==0 ) {

            	              							doneComposite();
            	              						
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
        return ;
    }
    // $ANTLR end "ruleXMemberFeatureCall"


    // $ANTLR start "entryRuleXPrimaryExpression"
    // PsiInternalPureXbase.g:1787:1: entryRuleXPrimaryExpression : ruleXPrimaryExpression EOF ;
    public final void entryRuleXPrimaryExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:1787:28: ( ruleXPrimaryExpression EOF )
            // PsiInternalPureXbase.g:1788:2: ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXPrimaryExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXPrimaryExpression"


    // $ANTLR start "ruleXPrimaryExpression"
    // PsiInternalPureXbase.g:1793:1: ruleXPrimaryExpression : ( ruleXConstructorCall | ruleXBlockExpression | ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=> ruleXSynchronizedExpression ) | ruleXFeatureCall | ruleXLiteral | ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ruleXForLoopExpression ) | ruleXBasicForLoopExpression | ruleXWhileExpression | ruleXDoWhileExpression | ruleXThrowExpression | ruleXReturnExpression | ruleXTryCatchFinallyExpression | ruleXParenthesizedExpression ) ;
    public final void ruleXPrimaryExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:1793:23: ( ( ruleXConstructorCall | ruleXBlockExpression | ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=> ruleXSynchronizedExpression ) | ruleXFeatureCall | ruleXLiteral | ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ruleXForLoopExpression ) | ruleXBasicForLoopExpression | ruleXWhileExpression | ruleXDoWhileExpression | ruleXThrowExpression | ruleXReturnExpression | ruleXTryCatchFinallyExpression | ruleXParenthesizedExpression ) )
            // PsiInternalPureXbase.g:1794:2: ( ruleXConstructorCall | ruleXBlockExpression | ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=> ruleXSynchronizedExpression ) | ruleXFeatureCall | ruleXLiteral | ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ruleXForLoopExpression ) | ruleXBasicForLoopExpression | ruleXWhileExpression | ruleXDoWhileExpression | ruleXThrowExpression | ruleXReturnExpression | ruleXTryCatchFinallyExpression | ruleXParenthesizedExpression )
            {
            // PsiInternalPureXbase.g:1794:2: ( ruleXConstructorCall | ruleXBlockExpression | ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=> ruleXSynchronizedExpression ) | ruleXFeatureCall | ruleXLiteral | ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ruleXForLoopExpression ) | ruleXBasicForLoopExpression | ruleXWhileExpression | ruleXDoWhileExpression | ruleXThrowExpression | ruleXReturnExpression | ruleXTryCatchFinallyExpression | ruleXParenthesizedExpression )
            int alt36=15;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // PsiInternalPureXbase.g:1795:3: ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XConstructorCallParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXConstructorCall();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:1803:3: ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XBlockExpressionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXBlockExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalPureXbase.g:1811:3: ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XSwitchExpressionParserRuleCall_2ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXSwitchExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalPureXbase.g:1819:3: ( ( ( () 'synchronized' '(' ) )=> ruleXSynchronizedExpression )
                    {
                    // PsiInternalPureXbase.g:1819:3: ( ( ( () 'synchronized' '(' ) )=> ruleXSynchronizedExpression )
                    // PsiInternalPureXbase.g:1820:4: ( ( () 'synchronized' '(' ) )=> ruleXSynchronizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getXPrimaryExpression_XSynchronizedExpressionParserRuleCall_3ElementType());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    ruleXSynchronizedExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneComposite();
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // PsiInternalPureXbase.g:1836:3: ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XFeatureCallParserRuleCall_4ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXFeatureCall();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalPureXbase.g:1844:3: ruleXLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XLiteralParserRuleCall_5ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 7 :
                    // PsiInternalPureXbase.g:1852:3: ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XIfExpressionParserRuleCall_6ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXIfExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 8 :
                    // PsiInternalPureXbase.g:1860:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ruleXForLoopExpression )
                    {
                    // PsiInternalPureXbase.g:1860:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ruleXForLoopExpression )
                    // PsiInternalPureXbase.g:1861:4: ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getXPrimaryExpression_XForLoopExpressionParserRuleCall_7ElementType());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    ruleXForLoopExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneComposite();
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // PsiInternalPureXbase.g:1883:3: ruleXBasicForLoopExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XBasicForLoopExpressionParserRuleCall_8ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXBasicForLoopExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 10 :
                    // PsiInternalPureXbase.g:1891:3: ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XWhileExpressionParserRuleCall_9ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXWhileExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 11 :
                    // PsiInternalPureXbase.g:1899:3: ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XDoWhileExpressionParserRuleCall_10ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXDoWhileExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 12 :
                    // PsiInternalPureXbase.g:1907:3: ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XThrowExpressionParserRuleCall_11ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXThrowExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 13 :
                    // PsiInternalPureXbase.g:1915:3: ruleXReturnExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XReturnExpressionParserRuleCall_12ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXReturnExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 14 :
                    // PsiInternalPureXbase.g:1923:3: ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XTryCatchFinallyExpressionParserRuleCall_13ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXTryCatchFinallyExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 15 :
                    // PsiInternalPureXbase.g:1931:3: ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XParenthesizedExpressionParserRuleCall_14ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

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
        return ;
    }
    // $ANTLR end "ruleXPrimaryExpression"


    // $ANTLR start "entryRuleXLiteral"
    // PsiInternalPureXbase.g:1942:1: entryRuleXLiteral : ruleXLiteral EOF ;
    public final void entryRuleXLiteral() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:1942:18: ( ruleXLiteral EOF )
            // PsiInternalPureXbase.g:1943:2: ruleXLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXLiteral();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXLiteral"


    // $ANTLR start "ruleXLiteral"
    // PsiInternalPureXbase.g:1948:1: ruleXLiteral : ( ruleXCollectionLiteral | ( ( ( () '[' ) )=> ruleXClosure ) | ruleXBooleanLiteral | ruleXNumberLiteral | ruleXNullLiteral | ruleXStringLiteral | ruleXTypeLiteral ) ;
    public final void ruleXLiteral() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:1948:13: ( ( ruleXCollectionLiteral | ( ( ( () '[' ) )=> ruleXClosure ) | ruleXBooleanLiteral | ruleXNumberLiteral | ruleXNullLiteral | ruleXStringLiteral | ruleXTypeLiteral ) )
            // PsiInternalPureXbase.g:1949:2: ( ruleXCollectionLiteral | ( ( ( () '[' ) )=> ruleXClosure ) | ruleXBooleanLiteral | ruleXNumberLiteral | ruleXNullLiteral | ruleXStringLiteral | ruleXTypeLiteral )
            {
            // PsiInternalPureXbase.g:1949:2: ( ruleXCollectionLiteral | ( ( ( () '[' ) )=> ruleXClosure ) | ruleXBooleanLiteral | ruleXNumberLiteral | ruleXNullLiteral | ruleXStringLiteral | ruleXTypeLiteral )
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // PsiInternalPureXbase.g:1950:3: ruleXCollectionLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXLiteral_XCollectionLiteralParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXCollectionLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:1958:3: ( ( ( () '[' ) )=> ruleXClosure )
                    {
                    // PsiInternalPureXbase.g:1958:3: ( ( ( () '[' ) )=> ruleXClosure )
                    // PsiInternalPureXbase.g:1959:4: ( ( () '[' ) )=> ruleXClosure
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getXLiteral_XClosureParserRuleCall_1ElementType());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    ruleXClosure();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneComposite();
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalPureXbase.g:1974:3: ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXLiteral_XBooleanLiteralParserRuleCall_2ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalPureXbase.g:1982:3: ruleXNumberLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXLiteral_XNumberLiteralParserRuleCall_3ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXNumberLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 5 :
                    // PsiInternalPureXbase.g:1990:3: ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXLiteral_XNullLiteralParserRuleCall_4ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXNullLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalPureXbase.g:1998:3: ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXLiteral_XStringLiteralParserRuleCall_5ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXStringLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 7 :
                    // PsiInternalPureXbase.g:2006:3: ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXLiteral_XTypeLiteralParserRuleCall_6ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXTypeLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

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
        return ;
    }
    // $ANTLR end "ruleXLiteral"


    // $ANTLR start "entryRuleXCollectionLiteral"
    // PsiInternalPureXbase.g:2017:1: entryRuleXCollectionLiteral : ruleXCollectionLiteral EOF ;
    public final void entryRuleXCollectionLiteral() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:2017:28: ( ruleXCollectionLiteral EOF )
            // PsiInternalPureXbase.g:2018:2: ruleXCollectionLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXCollectionLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXCollectionLiteral();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXCollectionLiteral"


    // $ANTLR start "ruleXCollectionLiteral"
    // PsiInternalPureXbase.g:2023:1: ruleXCollectionLiteral : ( ruleXSetLiteral | ruleXListLiteral ) ;
    public final void ruleXCollectionLiteral() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:2023:23: ( ( ruleXSetLiteral | ruleXListLiteral ) )
            // PsiInternalPureXbase.g:2024:2: ( ruleXSetLiteral | ruleXListLiteral )
            {
            // PsiInternalPureXbase.g:2024:2: ( ruleXSetLiteral | ruleXListLiteral )
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
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // PsiInternalPureXbase.g:2025:3: ruleXSetLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXCollectionLiteral_XSetLiteralParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXSetLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:2033:3: ruleXListLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXCollectionLiteral_XListLiteralParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXListLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

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
        return ;
    }
    // $ANTLR end "ruleXCollectionLiteral"


    // $ANTLR start "entryRuleXSetLiteral"
    // PsiInternalPureXbase.g:2044:1: entryRuleXSetLiteral : ruleXSetLiteral EOF ;
    public final void entryRuleXSetLiteral() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:2044:21: ( ruleXSetLiteral EOF )
            // PsiInternalPureXbase.g:2045:2: ruleXSetLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXSetLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXSetLiteral();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXSetLiteral"


    // $ANTLR start "ruleXSetLiteral"
    // PsiInternalPureXbase.g:2050:1: ruleXSetLiteral : ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' ) ;
    public final void ruleXSetLiteral() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

        try {
            // PsiInternalPureXbase.g:2050:16: ( ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' ) )
            // PsiInternalPureXbase.g:2051:2: ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' )
            {
            // PsiInternalPureXbase.g:2051:2: ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' )
            // PsiInternalPureXbase.g:2052:3: () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}'
            {
            // PsiInternalPureXbase.g:2052:3: ()
            // PsiInternalPureXbase.g:2053:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXSetLiteral_XSetLiteralAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXSetLiteral_NumberSignKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,52,FOLLOW_34); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXSetLiteral_LeftCurlyBracketKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,53,FOLLOW_35); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalPureXbase.g:2072:3: ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_STRING && LA40_0<=RULE_ID)||LA40_0==20||(LA40_0>=36 && LA40_0<=37)||LA40_0==42||LA40_0==50||(LA40_0>=52 && LA40_0<=53)||LA40_0==55||LA40_0==58||LA40_0==60||(LA40_0>=64 && LA40_0<=66)||(LA40_0>=69 && LA40_0<=77)||LA40_0==79) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // PsiInternalPureXbase.g:2073:4: ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
                    {
                    // PsiInternalPureXbase.g:2073:4: ( (lv_elements_3_0= ruleXExpression ) )
                    // PsiInternalPureXbase.g:2074:5: (lv_elements_3_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:2074:5: (lv_elements_3_0= ruleXExpression )
                    // PsiInternalPureXbase.g:2075:6: lv_elements_3_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXSetLiteral_ElementsXExpressionParserRuleCall_3_0_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_36);
                    ruleXExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:2084:4: (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==49) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:2085:5: otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getXSetLiteral_CommaKeyword_3_1_0ElementType());
                    	      				
                    	    }
                    	    otherlv_4=(Token)match(input,49,FOLLOW_3); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_4);
                    	      				
                    	    }
                    	    // PsiInternalPureXbase.g:2092:5: ( (lv_elements_5_0= ruleXExpression ) )
                    	    // PsiInternalPureXbase.g:2093:6: (lv_elements_5_0= ruleXExpression )
                    	    {
                    	    // PsiInternalPureXbase.g:2093:6: (lv_elements_5_0= ruleXExpression )
                    	    // PsiInternalPureXbase.g:2094:7: lv_elements_5_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getXSetLiteral_ElementsXExpressionParserRuleCall_3_1_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_36);
                    	    ruleXExpression();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      						
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
            otherlv_6=(Token)match(input,54,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleXSetLiteral"


    // $ANTLR start "entryRuleXListLiteral"
    // PsiInternalPureXbase.g:2116:1: entryRuleXListLiteral : ruleXListLiteral EOF ;
    public final void entryRuleXListLiteral() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:2116:22: ( ruleXListLiteral EOF )
            // PsiInternalPureXbase.g:2117:2: ruleXListLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXListLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXListLiteral();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXListLiteral"


    // $ANTLR start "ruleXListLiteral"
    // PsiInternalPureXbase.g:2122:1: ruleXListLiteral : ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' ) ;
    public final void ruleXListLiteral() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

        try {
            // PsiInternalPureXbase.g:2122:17: ( ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' ) )
            // PsiInternalPureXbase.g:2123:2: ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' )
            {
            // PsiInternalPureXbase.g:2123:2: ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' )
            // PsiInternalPureXbase.g:2124:3: () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']'
            {
            // PsiInternalPureXbase.g:2124:3: ()
            // PsiInternalPureXbase.g:2125:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXListLiteral_XListLiteralAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXListLiteral_NumberSignKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,52,FOLLOW_37); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXListLiteral_LeftSquareBracketKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,55,FOLLOW_38); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalPureXbase.g:2144:3: ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=RULE_STRING && LA42_0<=RULE_ID)||LA42_0==20||(LA42_0>=36 && LA42_0<=37)||LA42_0==42||LA42_0==50||(LA42_0>=52 && LA42_0<=53)||LA42_0==55||LA42_0==58||LA42_0==60||(LA42_0>=64 && LA42_0<=66)||(LA42_0>=69 && LA42_0<=77)||LA42_0==79) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // PsiInternalPureXbase.g:2145:4: ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
                    {
                    // PsiInternalPureXbase.g:2145:4: ( (lv_elements_3_0= ruleXExpression ) )
                    // PsiInternalPureXbase.g:2146:5: (lv_elements_3_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:2146:5: (lv_elements_3_0= ruleXExpression )
                    // PsiInternalPureXbase.g:2147:6: lv_elements_3_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXListLiteral_ElementsXExpressionParserRuleCall_3_0_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_39);
                    ruleXExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:2156:4: (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==49) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:2157:5: otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getXListLiteral_CommaKeyword_3_1_0ElementType());
                    	      				
                    	    }
                    	    otherlv_4=(Token)match(input,49,FOLLOW_3); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_4);
                    	      				
                    	    }
                    	    // PsiInternalPureXbase.g:2164:5: ( (lv_elements_5_0= ruleXExpression ) )
                    	    // PsiInternalPureXbase.g:2165:6: (lv_elements_5_0= ruleXExpression )
                    	    {
                    	    // PsiInternalPureXbase.g:2165:6: (lv_elements_5_0= ruleXExpression )
                    	    // PsiInternalPureXbase.g:2166:7: lv_elements_5_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getXListLiteral_ElementsXExpressionParserRuleCall_3_1_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_39);
                    	    ruleXExpression();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      						
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
            otherlv_6=(Token)match(input,56,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleXListLiteral"


    // $ANTLR start "entryRuleXClosure"
    // PsiInternalPureXbase.g:2188:1: entryRuleXClosure : ruleXClosure EOF ;
    public final void entryRuleXClosure() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:2188:18: ( ruleXClosure EOF )
            // PsiInternalPureXbase.g:2189:2: ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXClosureElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXClosure();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXClosure"


    // $ANTLR start "ruleXClosure"
    // PsiInternalPureXbase.g:2194:1: ruleXClosure : ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) ;
    public final void ruleXClosure() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_explicitSyntax_5_0=null;
        Token otherlv_7=null;

        try {
            // PsiInternalPureXbase.g:2194:13: ( ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) )
            // PsiInternalPureXbase.g:2195:2: ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            {
            // PsiInternalPureXbase.g:2195:2: ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            // PsiInternalPureXbase.g:2196:3: ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']'
            {
            // PsiInternalPureXbase.g:2196:3: ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) )
            // PsiInternalPureXbase.g:2197:4: ( ( () '[' ) )=> ( () otherlv_1= '[' )
            {
            // PsiInternalPureXbase.g:2203:4: ( () otherlv_1= '[' )
            // PsiInternalPureXbase.g:2204:5: () otherlv_1= '['
            {
            // PsiInternalPureXbase.g:2204:5: ()
            // PsiInternalPureXbase.g:2205:6: 
            {
            if ( state.backtracking==0 ) {

              						precedeComposite(elementTypeProvider.getXClosure_XClosureAction_0_0_0ElementType());
              						doneComposite();
              					
            }

            }

            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXClosure_LeftSquareBracketKeyword_0_0_1ElementType());
              				
            }
            otherlv_1=(Token)match(input,55,FOLLOW_40); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(otherlv_1);
              				
            }

            }


            }

            // PsiInternalPureXbase.g:2219:3: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?
            int alt45=2;
            alt45 = dfa45.predict(input);
            switch (alt45) {
                case 1 :
                    // PsiInternalPureXbase.g:2220:4: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    {
                    // PsiInternalPureXbase.g:2243:4: ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    // PsiInternalPureXbase.g:2244:5: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) )
                    {
                    // PsiInternalPureXbase.g:2244:5: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==RULE_ID||LA44_0==33||LA44_0==50) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // PsiInternalPureXbase.g:2245:6: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            {
                            // PsiInternalPureXbase.g:2245:6: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) )
                            // PsiInternalPureXbase.g:2246:7: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            {
                            // PsiInternalPureXbase.g:2246:7: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            // PsiInternalPureXbase.g:2247:8: lv_declaredFormalParameters_2_0= ruleJvmFormalParameter
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getXClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0ElementType());
                              							
                            }
                            pushFollow(FOLLOW_41);
                            ruleJvmFormalParameter();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              							
                            }

                            }


                            }

                            // PsiInternalPureXbase.g:2256:6: (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            loop43:
                            do {
                                int alt43=2;
                                int LA43_0 = input.LA(1);

                                if ( (LA43_0==49) ) {
                                    alt43=1;
                                }


                                switch (alt43) {
                            	case 1 :
                            	    // PsiInternalPureXbase.g:2257:7: otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      							markLeaf(elementTypeProvider.getXClosure_CommaKeyword_1_0_0_1_0ElementType());
                            	      						
                            	    }
                            	    otherlv_3=(Token)match(input,49,FOLLOW_15); if (state.failed) return ;
                            	    if ( state.backtracking==0 ) {

                            	      							doneLeaf(otherlv_3);
                            	      						
                            	    }
                            	    // PsiInternalPureXbase.g:2264:7: ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    // PsiInternalPureXbase.g:2265:8: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    {
                            	    // PsiInternalPureXbase.g:2265:8: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    // PsiInternalPureXbase.g:2266:9: lv_declaredFormalParameters_4_0= ruleJvmFormalParameter
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									markComposite(elementTypeProvider.getXClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0ElementType());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_41);
                            	    ruleJvmFormalParameter();

                            	    state._fsp--;
                            	    if (state.failed) return ;
                            	    if ( state.backtracking==0 ) {

                            	      									doneComposite();
                            	      								
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

                    // PsiInternalPureXbase.g:2277:5: ( (lv_explicitSyntax_5_0= '|' ) )
                    // PsiInternalPureXbase.g:2278:6: (lv_explicitSyntax_5_0= '|' )
                    {
                    // PsiInternalPureXbase.g:2278:6: (lv_explicitSyntax_5_0= '|' )
                    // PsiInternalPureXbase.g:2279:7: lv_explicitSyntax_5_0= '|'
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getXClosure_ExplicitSyntaxVerticalLineKeyword_1_0_1_0ElementType());
                      						
                    }
                    lv_explicitSyntax_5_0=(Token)match(input,57,FOLLOW_38); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(lv_explicitSyntax_5_0);
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            // PsiInternalPureXbase.g:2290:3: ( (lv_expression_6_0= ruleXExpressionInClosure ) )
            // PsiInternalPureXbase.g:2291:4: (lv_expression_6_0= ruleXExpressionInClosure )
            {
            // PsiInternalPureXbase.g:2291:4: (lv_expression_6_0= ruleXExpressionInClosure )
            // PsiInternalPureXbase.g:2292:5: lv_expression_6_0= ruleXExpressionInClosure
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXClosure_ExpressionXExpressionInClosureParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_42);
            ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXClosure_RightSquareBracketKeyword_3ElementType());
              		
            }
            otherlv_7=(Token)match(input,56,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleXClosure"


    // $ANTLR start "entryRuleXExpressionInClosure"
    // PsiInternalPureXbase.g:2312:1: entryRuleXExpressionInClosure : ruleXExpressionInClosure EOF ;
    public final void entryRuleXExpressionInClosure() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:2312:30: ( ruleXExpressionInClosure EOF )
            // PsiInternalPureXbase.g:2313:2: ruleXExpressionInClosure EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXExpressionInClosureElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXExpressionInClosure"


    // $ANTLR start "ruleXExpressionInClosure"
    // PsiInternalPureXbase.g:2318:1: ruleXExpressionInClosure : ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) ;
    public final void ruleXExpressionInClosure() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // PsiInternalPureXbase.g:2318:25: ( ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) )
            // PsiInternalPureXbase.g:2319:2: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
            {
            // PsiInternalPureXbase.g:2319:2: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
            // PsiInternalPureXbase.g:2320:3: () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
            {
            // PsiInternalPureXbase.g:2320:3: ()
            // PsiInternalPureXbase.g:2321:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXExpressionInClosure_XBlockExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalPureXbase.g:2326:3: ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( ((LA47_0>=RULE_STRING && LA47_0<=RULE_ID)||LA47_0==20||(LA47_0>=36 && LA47_0<=37)||LA47_0==42||LA47_0==50||(LA47_0>=52 && LA47_0<=53)||LA47_0==55||LA47_0==58||LA47_0==60||(LA47_0>=64 && LA47_0<=77)||LA47_0==79) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // PsiInternalPureXbase.g:2327:4: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )?
            	    {
            	    // PsiInternalPureXbase.g:2327:4: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) )
            	    // PsiInternalPureXbase.g:2328:5: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
            	    {
            	    // PsiInternalPureXbase.g:2328:5: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
            	    // PsiInternalPureXbase.g:2329:6: lv_expressions_1_0= ruleXExpressionOrVarDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXExpressionInClosure_ExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_4);
            	    ruleXExpressionOrVarDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
            	    }

            	    }


            	    }

            	    // PsiInternalPureXbase.g:2338:4: (otherlv_2= ';' )?
            	    int alt46=2;
            	    int LA46_0 = input.LA(1);

            	    if ( (LA46_0==13) ) {
            	        alt46=1;
            	    }
            	    switch (alt46) {
            	        case 1 :
            	            // PsiInternalPureXbase.g:2339:5: otherlv_2= ';'
            	            {
            	            if ( state.backtracking==0 ) {

            	              					markLeaf(elementTypeProvider.getXExpressionInClosure_SemicolonKeyword_1_1ElementType());
            	              				
            	            }
            	            otherlv_2=(Token)match(input,13,FOLLOW_5); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleXExpressionInClosure"


    // $ANTLR start "entryRuleXShortClosure"
    // PsiInternalPureXbase.g:2352:1: entryRuleXShortClosure : ruleXShortClosure EOF ;
    public final void entryRuleXShortClosure() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:2352:23: ( ruleXShortClosure EOF )
            // PsiInternalPureXbase.g:2353:2: ruleXShortClosure EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXShortClosureElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXShortClosure();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXShortClosure"


    // $ANTLR start "ruleXShortClosure"
    // PsiInternalPureXbase.g:2358:1: ruleXShortClosure : ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final void ruleXShortClosure() throws RecognitionException {
        Token otherlv_2=null;
        Token lv_explicitSyntax_4_0=null;

        try {
            // PsiInternalPureXbase.g:2358:18: ( ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // PsiInternalPureXbase.g:2359:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // PsiInternalPureXbase.g:2359:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            // PsiInternalPureXbase.g:2360:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) )
            {
            // PsiInternalPureXbase.g:2360:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) )
            // PsiInternalPureXbase.g:2361:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            {
            // PsiInternalPureXbase.g:2386:4: ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            // PsiInternalPureXbase.g:2387:5: () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) )
            {
            // PsiInternalPureXbase.g:2387:5: ()
            // PsiInternalPureXbase.g:2388:6: 
            {
            if ( state.backtracking==0 ) {

              						precedeComposite(elementTypeProvider.getXShortClosure_XClosureAction_0_0_0ElementType());
              						doneComposite();
              					
            }

            }

            // PsiInternalPureXbase.g:2393:5: ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_ID||LA49_0==33||LA49_0==50) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // PsiInternalPureXbase.g:2394:6: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // PsiInternalPureXbase.g:2394:6: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) )
                    // PsiInternalPureXbase.g:2395:7: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // PsiInternalPureXbase.g:2395:7: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    // PsiInternalPureXbase.g:2396:8: lv_declaredFormalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getXShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0ElementType());
                      							
                    }
                    pushFollow(FOLLOW_41);
                    ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      								doneComposite();
                      							
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:2405:6: (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==49) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:2406:7: otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markLeaf(elementTypeProvider.getXShortClosure_CommaKeyword_0_0_1_1_0ElementType());
                    	      						
                    	    }
                    	    otherlv_2=(Token)match(input,49,FOLLOW_15); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneLeaf(otherlv_2);
                    	      						
                    	    }
                    	    // PsiInternalPureXbase.g:2413:7: ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // PsiInternalPureXbase.g:2414:8: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // PsiInternalPureXbase.g:2414:8: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    // PsiInternalPureXbase.g:2415:9: lv_declaredFormalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      									markComposite(elementTypeProvider.getXShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0ElementType());
                    	      								
                    	    }
                    	    pushFollow(FOLLOW_41);
                    	    ruleJvmFormalParameter();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      									doneComposite();
                    	      								
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

            // PsiInternalPureXbase.g:2426:5: ( (lv_explicitSyntax_4_0= '|' ) )
            // PsiInternalPureXbase.g:2427:6: (lv_explicitSyntax_4_0= '|' )
            {
            // PsiInternalPureXbase.g:2427:6: (lv_explicitSyntax_4_0= '|' )
            // PsiInternalPureXbase.g:2428:7: lv_explicitSyntax_4_0= '|'
            {
            if ( state.backtracking==0 ) {

              							markLeaf(elementTypeProvider.getXShortClosure_ExplicitSyntaxVerticalLineKeyword_0_0_2_0ElementType());
              						
            }
            lv_explicitSyntax_4_0=(Token)match(input,57,FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              							doneLeaf(lv_explicitSyntax_4_0);
              						
            }

            }


            }


            }


            }

            // PsiInternalPureXbase.g:2439:3: ( (lv_expression_5_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:2440:4: (lv_expression_5_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:2440:4: (lv_expression_5_0= ruleXExpression )
            // PsiInternalPureXbase.g:2441:5: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXShortClosure_ExpressionXExpressionParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            ruleXExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
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
        return ;
    }
    // $ANTLR end "ruleXShortClosure"


    // $ANTLR start "entryRuleXParenthesizedExpression"
    // PsiInternalPureXbase.g:2454:1: entryRuleXParenthesizedExpression : ruleXParenthesizedExpression EOF ;
    public final void entryRuleXParenthesizedExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:2454:34: ( ruleXParenthesizedExpression EOF )
            // PsiInternalPureXbase.g:2455:2: ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXParenthesizedExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXParenthesizedExpression"


    // $ANTLR start "ruleXParenthesizedExpression"
    // PsiInternalPureXbase.g:2460:1: ruleXParenthesizedExpression : (otherlv_0= '(' ruleXExpression otherlv_2= ')' ) ;
    public final void ruleXParenthesizedExpression() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalPureXbase.g:2460:29: ( (otherlv_0= '(' ruleXExpression otherlv_2= ')' ) )
            // PsiInternalPureXbase.g:2461:2: (otherlv_0= '(' ruleXExpression otherlv_2= ')' )
            {
            // PsiInternalPureXbase.g:2461:2: (otherlv_0= '(' ruleXExpression otherlv_2= ')' )
            // PsiInternalPureXbase.g:2462:3: otherlv_0= '(' ruleXExpression otherlv_2= ')'
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXParenthesizedExpression_LeftParenthesisKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,50,FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXParenthesizedExpression_XExpressionParserRuleCall_1ElementType());
              		
            }
            pushFollow(FOLLOW_31);
            ruleXExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXParenthesizedExpression_RightParenthesisKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,51,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleXParenthesizedExpression"


    // $ANTLR start "entryRuleXIfExpression"
    // PsiInternalPureXbase.g:2487:1: entryRuleXIfExpression : ruleXIfExpression EOF ;
    public final void entryRuleXIfExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:2487:23: ( ruleXIfExpression EOF )
            // PsiInternalPureXbase.g:2488:2: ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXIfExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXIfExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXIfExpression"


    // $ANTLR start "ruleXIfExpression"
    // PsiInternalPureXbase.g:2493:1: ruleXIfExpression : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) ;
    public final void ruleXIfExpression() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

        try {
            // PsiInternalPureXbase.g:2493:18: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) )
            // PsiInternalPureXbase.g:2494:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            {
            // PsiInternalPureXbase.g:2494:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            // PsiInternalPureXbase.g:2495:3: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            {
            // PsiInternalPureXbase.g:2495:3: ()
            // PsiInternalPureXbase.g:2496:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXIfExpression_XIfExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXIfExpression_IfKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,58,FOLLOW_43); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXIfExpression_LeftParenthesisKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,50,FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalPureXbase.g:2515:3: ( (lv_if_3_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:2516:4: (lv_if_3_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:2516:4: (lv_if_3_0= ruleXExpression )
            // PsiInternalPureXbase.g:2517:5: lv_if_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXIfExpression_IfXExpressionParserRuleCall_3_0ElementType());
              				
            }
            pushFollow(FOLLOW_31);
            ruleXExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXIfExpression_RightParenthesisKeyword_4ElementType());
              		
            }
            otherlv_4=(Token)match(input,51,FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
            }
            // PsiInternalPureXbase.g:2533:3: ( (lv_then_5_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:2534:4: (lv_then_5_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:2534:4: (lv_then_5_0= ruleXExpression )
            // PsiInternalPureXbase.g:2535:5: lv_then_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXIfExpression_ThenXExpressionParserRuleCall_5_0ElementType());
              				
            }
            pushFollow(FOLLOW_44);
            ruleXExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // PsiInternalPureXbase.g:2544:3: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
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
                    // PsiInternalPureXbase.g:2545:4: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) )
                    {
                    // PsiInternalPureXbase.g:2545:4: ( ( 'else' )=>otherlv_6= 'else' )
                    // PsiInternalPureXbase.g:2546:5: ( 'else' )=>otherlv_6= 'else'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getXIfExpression_ElseKeyword_6_0ElementType());
                      				
                    }
                    otherlv_6=(Token)match(input,59,FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_6);
                      				
                    }

                    }

                    // PsiInternalPureXbase.g:2555:4: ( (lv_else_7_0= ruleXExpression ) )
                    // PsiInternalPureXbase.g:2556:5: (lv_else_7_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:2556:5: (lv_else_7_0= ruleXExpression )
                    // PsiInternalPureXbase.g:2557:6: lv_else_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXIfExpression_ElseXExpressionParserRuleCall_6_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    ruleXExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
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
        return ;
    }
    // $ANTLR end "ruleXIfExpression"


    // $ANTLR start "entryRuleXSwitchExpression"
    // PsiInternalPureXbase.g:2571:1: entryRuleXSwitchExpression : ruleXSwitchExpression EOF ;
    public final void entryRuleXSwitchExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:2571:27: ( ruleXSwitchExpression EOF )
            // PsiInternalPureXbase.g:2572:2: ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXSwitchExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXSwitchExpression"


    // $ANTLR start "ruleXSwitchExpression"
    // PsiInternalPureXbase.g:2577:1: ruleXSwitchExpression : ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' ) ;
    public final void ruleXSwitchExpression() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;

        try {
            // PsiInternalPureXbase.g:2577:22: ( ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' ) )
            // PsiInternalPureXbase.g:2578:2: ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' )
            {
            // PsiInternalPureXbase.g:2578:2: ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' )
            // PsiInternalPureXbase.g:2579:3: () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}'
            {
            // PsiInternalPureXbase.g:2579:3: ()
            // PsiInternalPureXbase.g:2580:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXSwitchExpression_XSwitchExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXSwitchExpression_SwitchKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,60,FOLLOW_45); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalPureXbase.g:2592:3: ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) )
            int alt52=2;
            alt52 = dfa52.predict(input);
            switch (alt52) {
                case 1 :
                    // PsiInternalPureXbase.g:2593:4: ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' )
                    {
                    // PsiInternalPureXbase.g:2593:4: ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' )
                    // PsiInternalPureXbase.g:2594:5: ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')'
                    {
                    // PsiInternalPureXbase.g:2594:5: ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) )
                    // PsiInternalPureXbase.g:2595:6: ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
                    {
                    // PsiInternalPureXbase.g:2605:6: (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
                    // PsiInternalPureXbase.g:2606:7: otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':'
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getXSwitchExpression_LeftParenthesisKeyword_2_0_0_0_0ElementType());
                      						
                    }
                    otherlv_2=(Token)match(input,50,FOLLOW_15); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(otherlv_2);
                      						
                    }
                    // PsiInternalPureXbase.g:2613:7: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
                    // PsiInternalPureXbase.g:2614:8: (lv_declaredParam_3_0= ruleJvmFormalParameter )
                    {
                    // PsiInternalPureXbase.g:2614:8: (lv_declaredParam_3_0= ruleJvmFormalParameter )
                    // PsiInternalPureXbase.g:2615:9: lv_declaredParam_3_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {

                      									markComposite(elementTypeProvider.getXSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0ElementType());
                      								
                    }
                    pushFollow(FOLLOW_46);
                    ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      									doneComposite();
                      								
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getXSwitchExpression_ColonKeyword_2_0_0_0_2ElementType());
                      						
                    }
                    otherlv_4=(Token)match(input,61,FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(otherlv_4);
                      						
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:2633:5: ( (lv_switch_5_0= ruleXExpression ) )
                    // PsiInternalPureXbase.g:2634:6: (lv_switch_5_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:2634:6: (lv_switch_5_0= ruleXExpression )
                    // PsiInternalPureXbase.g:2635:7: lv_switch_5_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getXSwitchExpression_SwitchXExpressionParserRuleCall_2_0_1_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_31);
                    ruleXExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getXSwitchExpression_RightParenthesisKeyword_2_0_2ElementType());
                      				
                    }
                    otherlv_6=(Token)match(input,51,FOLLOW_34); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_6);
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:2653:4: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) )
                    {
                    // PsiInternalPureXbase.g:2653:4: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) )
                    // PsiInternalPureXbase.g:2654:5: ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) )
                    {
                    // PsiInternalPureXbase.g:2654:5: ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )?
                    int alt51=2;
                    alt51 = dfa51.predict(input);
                    switch (alt51) {
                        case 1 :
                            // PsiInternalPureXbase.g:2655:6: ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' )
                            {
                            // PsiInternalPureXbase.g:2664:6: ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' )
                            // PsiInternalPureXbase.g:2665:7: ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':'
                            {
                            // PsiInternalPureXbase.g:2665:7: ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) )
                            // PsiInternalPureXbase.g:2666:8: (lv_declaredParam_7_0= ruleJvmFormalParameter )
                            {
                            // PsiInternalPureXbase.g:2666:8: (lv_declaredParam_7_0= ruleJvmFormalParameter )
                            // PsiInternalPureXbase.g:2667:9: lv_declaredParam_7_0= ruleJvmFormalParameter
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getXSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0ElementType());
                              								
                            }
                            pushFollow(FOLLOW_46);
                            ruleJvmFormalParameter();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              								
                            }

                            }


                            }

                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getXSwitchExpression_ColonKeyword_2_1_0_0_1ElementType());
                              						
                            }
                            otherlv_8=(Token)match(input,61,FOLLOW_3); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(otherlv_8);
                              						
                            }

                            }


                            }
                            break;

                    }

                    // PsiInternalPureXbase.g:2685:5: ( (lv_switch_9_0= ruleXExpression ) )
                    // PsiInternalPureXbase.g:2686:6: (lv_switch_9_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:2686:6: (lv_switch_9_0= ruleXExpression )
                    // PsiInternalPureXbase.g:2687:7: lv_switch_9_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getXSwitchExpression_SwitchXExpressionParserRuleCall_2_1_1_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_34);
                    ruleXExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
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
            otherlv_10=(Token)match(input,53,FOLLOW_47); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_10);
              		
            }
            // PsiInternalPureXbase.g:2705:3: ( (lv_cases_11_0= ruleXCasePart ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_ID||LA53_0==33||(LA53_0>=49 && LA53_0<=50)||LA53_0==61||LA53_0==63) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // PsiInternalPureXbase.g:2706:4: (lv_cases_11_0= ruleXCasePart )
            	    {
            	    // PsiInternalPureXbase.g:2706:4: (lv_cases_11_0= ruleXCasePart )
            	    // PsiInternalPureXbase.g:2707:5: lv_cases_11_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markComposite(elementTypeProvider.getXSwitchExpression_CasesXCasePartParserRuleCall_4_0ElementType());
            	      				
            	    }
            	    pushFollow(FOLLOW_47);
            	    ruleXCasePart();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneComposite();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            // PsiInternalPureXbase.g:2716:3: (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==62) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // PsiInternalPureXbase.g:2717:4: otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXSwitchExpression_DefaultKeyword_5_0ElementType());
                      			
                    }
                    otherlv_12=(Token)match(input,62,FOLLOW_46); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_12);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXSwitchExpression_ColonKeyword_5_1ElementType());
                      			
                    }
                    otherlv_13=(Token)match(input,61,FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_13);
                      			
                    }
                    // PsiInternalPureXbase.g:2731:4: ( (lv_default_14_0= ruleXExpression ) )
                    // PsiInternalPureXbase.g:2732:5: (lv_default_14_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:2732:5: (lv_default_14_0= ruleXExpression )
                    // PsiInternalPureXbase.g:2733:6: lv_default_14_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXSwitchExpression_DefaultXExpressionParserRuleCall_5_2_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_48);
                    ruleXExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXSwitchExpression_RightCurlyBracketKeyword_6ElementType());
              		
            }
            otherlv_15=(Token)match(input,54,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleXSwitchExpression"


    // $ANTLR start "entryRuleXCasePart"
    // PsiInternalPureXbase.g:2754:1: entryRuleXCasePart : ruleXCasePart EOF ;
    public final void entryRuleXCasePart() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:2754:19: ( ruleXCasePart EOF )
            // PsiInternalPureXbase.g:2755:2: ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXCasePartElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXCasePart();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXCasePart"


    // $ANTLR start "ruleXCasePart"
    // PsiInternalPureXbase.g:2760:1: ruleXCasePart : ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) ) ;
    public final void ruleXCasePart() throws RecognitionException {
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_fallThrough_6_0=null;

        try {
            // PsiInternalPureXbase.g:2760:14: ( ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) ) )
            // PsiInternalPureXbase.g:2761:2: ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) )
            {
            // PsiInternalPureXbase.g:2761:2: ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) )
            // PsiInternalPureXbase.g:2762:3: () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) )
            {
            // PsiInternalPureXbase.g:2762:3: ()
            // PsiInternalPureXbase.g:2763:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXCasePart_XCasePartAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalPureXbase.g:2768:3: ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==RULE_ID||LA55_0==33||LA55_0==50) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // PsiInternalPureXbase.g:2769:4: (lv_typeGuard_1_0= ruleJvmTypeReference )
                    {
                    // PsiInternalPureXbase.g:2769:4: (lv_typeGuard_1_0= ruleJvmTypeReference )
                    // PsiInternalPureXbase.g:2770:5: lv_typeGuard_1_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getXCasePart_TypeGuardJvmTypeReferenceParserRuleCall_1_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_49);
                    ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalPureXbase.g:2779:3: (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==63) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // PsiInternalPureXbase.g:2780:4: otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXCasePart_CaseKeyword_2_0ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,63,FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }
                    // PsiInternalPureXbase.g:2787:4: ( (lv_case_3_0= ruleXExpression ) )
                    // PsiInternalPureXbase.g:2788:5: (lv_case_3_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:2788:5: (lv_case_3_0= ruleXExpression )
                    // PsiInternalPureXbase.g:2789:6: lv_case_3_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXCasePart_CaseXExpressionParserRuleCall_2_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_50);
                    ruleXExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalPureXbase.g:2799:3: ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==61) ) {
                alt57=1;
            }
            else if ( (LA57_0==49) ) {
                alt57=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // PsiInternalPureXbase.g:2800:4: (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) )
                    {
                    // PsiInternalPureXbase.g:2800:4: (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) )
                    // PsiInternalPureXbase.g:2801:5: otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getXCasePart_ColonKeyword_3_0_0ElementType());
                      				
                    }
                    otherlv_4=(Token)match(input,61,FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_4);
                      				
                    }
                    // PsiInternalPureXbase.g:2808:5: ( (lv_then_5_0= ruleXExpression ) )
                    // PsiInternalPureXbase.g:2809:6: (lv_then_5_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:2809:6: (lv_then_5_0= ruleXExpression )
                    // PsiInternalPureXbase.g:2810:7: lv_then_5_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getXCasePart_ThenXExpressionParserRuleCall_3_0_1_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    ruleXExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:2821:4: ( (lv_fallThrough_6_0= ',' ) )
                    {
                    // PsiInternalPureXbase.g:2821:4: ( (lv_fallThrough_6_0= ',' ) )
                    // PsiInternalPureXbase.g:2822:5: (lv_fallThrough_6_0= ',' )
                    {
                    // PsiInternalPureXbase.g:2822:5: (lv_fallThrough_6_0= ',' )
                    // PsiInternalPureXbase.g:2823:6: lv_fallThrough_6_0= ','
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getXCasePart_FallThroughCommaKeyword_3_1_0ElementType());
                      					
                    }
                    lv_fallThrough_6_0=(Token)match(input,49,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_fallThrough_6_0);
                      					
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
        return ;
    }
    // $ANTLR end "ruleXCasePart"


    // $ANTLR start "entryRuleXForLoopExpression"
    // PsiInternalPureXbase.g:2837:1: entryRuleXForLoopExpression : ruleXForLoopExpression EOF ;
    public final void entryRuleXForLoopExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:2837:28: ( ruleXForLoopExpression EOF )
            // PsiInternalPureXbase.g:2838:2: ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXForLoopExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXForLoopExpression"


    // $ANTLR start "ruleXForLoopExpression"
    // PsiInternalPureXbase.g:2843:1: ruleXForLoopExpression : ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) ;
    public final void ruleXForLoopExpression() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

        try {
            // PsiInternalPureXbase.g:2843:23: ( ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) )
            // PsiInternalPureXbase.g:2844:2: ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            {
            // PsiInternalPureXbase.g:2844:2: ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            // PsiInternalPureXbase.g:2845:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) )
            {
            // PsiInternalPureXbase.g:2845:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) )
            // PsiInternalPureXbase.g:2846:4: ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
            {
            // PsiInternalPureXbase.g:2859:4: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
            // PsiInternalPureXbase.g:2860:5: () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':'
            {
            // PsiInternalPureXbase.g:2860:5: ()
            // PsiInternalPureXbase.g:2861:6: 
            {
            if ( state.backtracking==0 ) {

              						precedeComposite(elementTypeProvider.getXForLoopExpression_XForLoopExpressionAction_0_0_0ElementType());
              						doneComposite();
              					
            }

            }

            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXForLoopExpression_ForKeyword_0_0_1ElementType());
              				
            }
            otherlv_1=(Token)match(input,64,FOLLOW_43); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(otherlv_1);
              				
            }
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXForLoopExpression_LeftParenthesisKeyword_0_0_2ElementType());
              				
            }
            otherlv_2=(Token)match(input,50,FOLLOW_15); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(otherlv_2);
              				
            }
            // PsiInternalPureXbase.g:2880:5: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
            // PsiInternalPureXbase.g:2881:6: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            {
            // PsiInternalPureXbase.g:2881:6: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            // PsiInternalPureXbase.g:2882:7: lv_declaredParam_3_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {

              							markComposite(elementTypeProvider.getXForLoopExpression_DeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0ElementType());
              						
            }
            pushFollow(FOLLOW_46);
            ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              							doneComposite();
              						
            }

            }


            }

            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXForLoopExpression_ColonKeyword_0_0_4ElementType());
              				
            }
            otherlv_4=(Token)match(input,61,FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(otherlv_4);
              				
            }

            }


            }

            // PsiInternalPureXbase.g:2900:3: ( (lv_forExpression_5_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:2901:4: (lv_forExpression_5_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:2901:4: (lv_forExpression_5_0= ruleXExpression )
            // PsiInternalPureXbase.g:2902:5: lv_forExpression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXForLoopExpression_ForExpressionXExpressionParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_31);
            ruleXExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXForLoopExpression_RightParenthesisKeyword_2ElementType());
              		
            }
            otherlv_6=(Token)match(input,51,FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_6);
              		
            }
            // PsiInternalPureXbase.g:2918:3: ( (lv_eachExpression_7_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:2919:4: (lv_eachExpression_7_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:2919:4: (lv_eachExpression_7_0= ruleXExpression )
            // PsiInternalPureXbase.g:2920:5: lv_eachExpression_7_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXForLoopExpression_EachExpressionXExpressionParserRuleCall_3_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            ruleXExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
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
        return ;
    }
    // $ANTLR end "ruleXForLoopExpression"


    // $ANTLR start "entryRuleXBasicForLoopExpression"
    // PsiInternalPureXbase.g:2933:1: entryRuleXBasicForLoopExpression : ruleXBasicForLoopExpression EOF ;
    public final void entryRuleXBasicForLoopExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:2933:33: ( ruleXBasicForLoopExpression EOF )
            // PsiInternalPureXbase.g:2934:2: ruleXBasicForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXBasicForLoopExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXBasicForLoopExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXBasicForLoopExpression"


    // $ANTLR start "ruleXBasicForLoopExpression"
    // PsiInternalPureXbase.g:2939:1: ruleXBasicForLoopExpression : ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) ) ;
    public final void ruleXBasicForLoopExpression() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;

        try {
            // PsiInternalPureXbase.g:2939:28: ( ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) ) )
            // PsiInternalPureXbase.g:2940:2: ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) )
            {
            // PsiInternalPureXbase.g:2940:2: ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) )
            // PsiInternalPureXbase.g:2941:3: () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) )
            {
            // PsiInternalPureXbase.g:2941:3: ()
            // PsiInternalPureXbase.g:2942:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXBasicForLoopExpression_XBasicForLoopExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXBasicForLoopExpression_ForKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,64,FOLLOW_43); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXBasicForLoopExpression_LeftParenthesisKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,50,FOLLOW_51); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalPureXbase.g:2961:3: ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( ((LA59_0>=RULE_STRING && LA59_0<=RULE_ID)||LA59_0==20||(LA59_0>=36 && LA59_0<=37)||LA59_0==42||LA59_0==50||(LA59_0>=52 && LA59_0<=53)||LA59_0==55||LA59_0==58||LA59_0==60||(LA59_0>=64 && LA59_0<=77)||LA59_0==79) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // PsiInternalPureXbase.g:2962:4: ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )*
                    {
                    // PsiInternalPureXbase.g:2962:4: ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) )
                    // PsiInternalPureXbase.g:2963:5: (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration )
                    {
                    // PsiInternalPureXbase.g:2963:5: (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration )
                    // PsiInternalPureXbase.g:2964:6: lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_52);
                    ruleXExpressionOrVarDeclaration();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:2973:4: (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==49) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:2974:5: otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getXBasicForLoopExpression_CommaKeyword_3_1_0ElementType());
                    	      				
                    	    }
                    	    otherlv_4=(Token)match(input,49,FOLLOW_3); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_4);
                    	      				
                    	    }
                    	    // PsiInternalPureXbase.g:2981:5: ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) )
                    	    // PsiInternalPureXbase.g:2982:6: (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration )
                    	    {
                    	    // PsiInternalPureXbase.g:2982:6: (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration )
                    	    // PsiInternalPureXbase.g:2983:7: lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getXBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_52);
                    	    ruleXExpressionOrVarDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      						
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
            otherlv_6=(Token)match(input,13,FOLLOW_51); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_6);
              		
            }
            // PsiInternalPureXbase.g:3001:3: ( (lv_expression_7_0= ruleXExpression ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( ((LA60_0>=RULE_STRING && LA60_0<=RULE_ID)||LA60_0==20||(LA60_0>=36 && LA60_0<=37)||LA60_0==42||LA60_0==50||(LA60_0>=52 && LA60_0<=53)||LA60_0==55||LA60_0==58||LA60_0==60||(LA60_0>=64 && LA60_0<=66)||(LA60_0>=69 && LA60_0<=77)||LA60_0==79) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // PsiInternalPureXbase.g:3002:4: (lv_expression_7_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:3002:4: (lv_expression_7_0= ruleXExpression )
                    // PsiInternalPureXbase.g:3003:5: lv_expression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getXBasicForLoopExpression_ExpressionXExpressionParserRuleCall_5_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_53);
                    ruleXExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXBasicForLoopExpression_SemicolonKeyword_6ElementType());
              		
            }
            otherlv_8=(Token)match(input,13,FOLLOW_54); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_8);
              		
            }
            // PsiInternalPureXbase.g:3019:3: ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( ((LA62_0>=RULE_STRING && LA62_0<=RULE_ID)||LA62_0==20||(LA62_0>=36 && LA62_0<=37)||LA62_0==42||LA62_0==50||(LA62_0>=52 && LA62_0<=53)||LA62_0==55||LA62_0==58||LA62_0==60||(LA62_0>=64 && LA62_0<=66)||(LA62_0>=69 && LA62_0<=77)||LA62_0==79) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // PsiInternalPureXbase.g:3020:4: ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )*
                    {
                    // PsiInternalPureXbase.g:3020:4: ( (lv_updateExpressions_9_0= ruleXExpression ) )
                    // PsiInternalPureXbase.g:3021:5: (lv_updateExpressions_9_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:3021:5: (lv_updateExpressions_9_0= ruleXExpression )
                    // PsiInternalPureXbase.g:3022:6: lv_updateExpressions_9_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_0_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_32);
                    ruleXExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:3031:4: (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==49) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:3032:5: otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getXBasicForLoopExpression_CommaKeyword_7_1_0ElementType());
                    	      				
                    	    }
                    	    otherlv_10=(Token)match(input,49,FOLLOW_3); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_10);
                    	      				
                    	    }
                    	    // PsiInternalPureXbase.g:3039:5: ( (lv_updateExpressions_11_0= ruleXExpression ) )
                    	    // PsiInternalPureXbase.g:3040:6: (lv_updateExpressions_11_0= ruleXExpression )
                    	    {
                    	    // PsiInternalPureXbase.g:3040:6: (lv_updateExpressions_11_0= ruleXExpression )
                    	    // PsiInternalPureXbase.g:3041:7: lv_updateExpressions_11_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getXBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_1_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_32);
                    	    ruleXExpression();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      						
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
            otherlv_12=(Token)match(input,51,FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_12);
              		
            }
            // PsiInternalPureXbase.g:3059:3: ( (lv_eachExpression_13_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:3060:4: (lv_eachExpression_13_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:3060:4: (lv_eachExpression_13_0= ruleXExpression )
            // PsiInternalPureXbase.g:3061:5: lv_eachExpression_13_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXBasicForLoopExpression_EachExpressionXExpressionParserRuleCall_9_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            ruleXExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
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
        return ;
    }
    // $ANTLR end "ruleXBasicForLoopExpression"


    // $ANTLR start "entryRuleXWhileExpression"
    // PsiInternalPureXbase.g:3074:1: entryRuleXWhileExpression : ruleXWhileExpression EOF ;
    public final void entryRuleXWhileExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:3074:26: ( ruleXWhileExpression EOF )
            // PsiInternalPureXbase.g:3075:2: ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXWhileExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXWhileExpression"


    // $ANTLR start "ruleXWhileExpression"
    // PsiInternalPureXbase.g:3080:1: ruleXWhileExpression : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) ;
    public final void ruleXWhileExpression() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // PsiInternalPureXbase.g:3080:21: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) )
            // PsiInternalPureXbase.g:3081:2: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            {
            // PsiInternalPureXbase.g:3081:2: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            // PsiInternalPureXbase.g:3082:3: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) )
            {
            // PsiInternalPureXbase.g:3082:3: ()
            // PsiInternalPureXbase.g:3083:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXWhileExpression_XWhileExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXWhileExpression_WhileKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,65,FOLLOW_43); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXWhileExpression_LeftParenthesisKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,50,FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalPureXbase.g:3102:3: ( (lv_predicate_3_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:3103:4: (lv_predicate_3_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:3103:4: (lv_predicate_3_0= ruleXExpression )
            // PsiInternalPureXbase.g:3104:5: lv_predicate_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXWhileExpression_PredicateXExpressionParserRuleCall_3_0ElementType());
              				
            }
            pushFollow(FOLLOW_31);
            ruleXExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXWhileExpression_RightParenthesisKeyword_4ElementType());
              		
            }
            otherlv_4=(Token)match(input,51,FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
            }
            // PsiInternalPureXbase.g:3120:3: ( (lv_body_5_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:3121:4: (lv_body_5_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:3121:4: (lv_body_5_0= ruleXExpression )
            // PsiInternalPureXbase.g:3122:5: lv_body_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXWhileExpression_BodyXExpressionParserRuleCall_5_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            ruleXExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
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
        return ;
    }
    // $ANTLR end "ruleXWhileExpression"


    // $ANTLR start "entryRuleXDoWhileExpression"
    // PsiInternalPureXbase.g:3135:1: entryRuleXDoWhileExpression : ruleXDoWhileExpression EOF ;
    public final void entryRuleXDoWhileExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:3135:28: ( ruleXDoWhileExpression EOF )
            // PsiInternalPureXbase.g:3136:2: ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXDoWhileExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXDoWhileExpression"


    // $ANTLR start "ruleXDoWhileExpression"
    // PsiInternalPureXbase.g:3141:1: ruleXDoWhileExpression : ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) ;
    public final void ruleXDoWhileExpression() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

        try {
            // PsiInternalPureXbase.g:3141:23: ( ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) )
            // PsiInternalPureXbase.g:3142:2: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            {
            // PsiInternalPureXbase.g:3142:2: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            // PsiInternalPureXbase.g:3143:3: () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')'
            {
            // PsiInternalPureXbase.g:3143:3: ()
            // PsiInternalPureXbase.g:3144:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXDoWhileExpression_XDoWhileExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXDoWhileExpression_DoKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,66,FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalPureXbase.g:3156:3: ( (lv_body_2_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:3157:4: (lv_body_2_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:3157:4: (lv_body_2_0= ruleXExpression )
            // PsiInternalPureXbase.g:3158:5: lv_body_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXDoWhileExpression_BodyXExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_55);
            ruleXExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXDoWhileExpression_WhileKeyword_3ElementType());
              		
            }
            otherlv_3=(Token)match(input,65,FOLLOW_43); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_3);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXDoWhileExpression_LeftParenthesisKeyword_4ElementType());
              		
            }
            otherlv_4=(Token)match(input,50,FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
            }
            // PsiInternalPureXbase.g:3181:3: ( (lv_predicate_5_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:3182:4: (lv_predicate_5_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:3182:4: (lv_predicate_5_0= ruleXExpression )
            // PsiInternalPureXbase.g:3183:5: lv_predicate_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXDoWhileExpression_PredicateXExpressionParserRuleCall_5_0ElementType());
              				
            }
            pushFollow(FOLLOW_31);
            ruleXExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXDoWhileExpression_RightParenthesisKeyword_6ElementType());
              		
            }
            otherlv_6=(Token)match(input,51,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleXDoWhileExpression"


    // $ANTLR start "entryRuleXBlockExpression"
    // PsiInternalPureXbase.g:3203:1: entryRuleXBlockExpression : ruleXBlockExpression EOF ;
    public final void entryRuleXBlockExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:3203:26: ( ruleXBlockExpression EOF )
            // PsiInternalPureXbase.g:3204:2: ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXBlockExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXBlockExpression"


    // $ANTLR start "ruleXBlockExpression"
    // PsiInternalPureXbase.g:3209:1: ruleXBlockExpression : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final void ruleXBlockExpression() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

        try {
            // PsiInternalPureXbase.g:3209:21: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // PsiInternalPureXbase.g:3210:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // PsiInternalPureXbase.g:3210:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // PsiInternalPureXbase.g:3211:3: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // PsiInternalPureXbase.g:3211:3: ()
            // PsiInternalPureXbase.g:3212:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXBlockExpression_XBlockExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXBlockExpression_LeftCurlyBracketKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,53,FOLLOW_35); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalPureXbase.g:3224:3: ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( ((LA64_0>=RULE_STRING && LA64_0<=RULE_ID)||LA64_0==20||(LA64_0>=36 && LA64_0<=37)||LA64_0==42||LA64_0==50||(LA64_0>=52 && LA64_0<=53)||LA64_0==55||LA64_0==58||LA64_0==60||(LA64_0>=64 && LA64_0<=77)||LA64_0==79) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // PsiInternalPureXbase.g:3225:4: ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )?
            	    {
            	    // PsiInternalPureXbase.g:3225:4: ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) )
            	    // PsiInternalPureXbase.g:3226:5: (lv_expressions_2_0= ruleXExpressionOrVarDeclaration )
            	    {
            	    // PsiInternalPureXbase.g:3226:5: (lv_expressions_2_0= ruleXExpressionOrVarDeclaration )
            	    // PsiInternalPureXbase.g:3227:6: lv_expressions_2_0= ruleXExpressionOrVarDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXBlockExpression_ExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_56);
            	    ruleXExpressionOrVarDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
            	    }

            	    }


            	    }

            	    // PsiInternalPureXbase.g:3236:4: (otherlv_3= ';' )?
            	    int alt63=2;
            	    int LA63_0 = input.LA(1);

            	    if ( (LA63_0==13) ) {
            	        alt63=1;
            	    }
            	    switch (alt63) {
            	        case 1 :
            	            // PsiInternalPureXbase.g:3237:5: otherlv_3= ';'
            	            {
            	            if ( state.backtracking==0 ) {

            	              					markLeaf(elementTypeProvider.getXBlockExpression_SemicolonKeyword_2_1ElementType());
            	              				
            	            }
            	            otherlv_3=(Token)match(input,13,FOLLOW_35); if (state.failed) return ;
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
            otherlv_4=(Token)match(input,54,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleXBlockExpression"


    // $ANTLR start "entryRuleXExpressionOrVarDeclaration"
    // PsiInternalPureXbase.g:3257:1: entryRuleXExpressionOrVarDeclaration : ruleXExpressionOrVarDeclaration EOF ;
    public final void entryRuleXExpressionOrVarDeclaration() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:3257:37: ( ruleXExpressionOrVarDeclaration EOF )
            // PsiInternalPureXbase.g:3258:2: ruleXExpressionOrVarDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXExpressionOrVarDeclarationElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXExpressionOrVarDeclaration();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXExpressionOrVarDeclaration"


    // $ANTLR start "ruleXExpressionOrVarDeclaration"
    // PsiInternalPureXbase.g:3263:1: ruleXExpressionOrVarDeclaration : ( ruleXVariableDeclaration | ruleXExpression ) ;
    public final void ruleXExpressionOrVarDeclaration() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:3263:32: ( ( ruleXVariableDeclaration | ruleXExpression ) )
            // PsiInternalPureXbase.g:3264:2: ( ruleXVariableDeclaration | ruleXExpression )
            {
            // PsiInternalPureXbase.g:3264:2: ( ruleXVariableDeclaration | ruleXExpression )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( ((LA65_0>=67 && LA65_0<=68)) ) {
                alt65=1;
            }
            else if ( ((LA65_0>=RULE_STRING && LA65_0<=RULE_ID)||LA65_0==20||(LA65_0>=36 && LA65_0<=37)||LA65_0==42||LA65_0==50||(LA65_0>=52 && LA65_0<=53)||LA65_0==55||LA65_0==58||LA65_0==60||(LA65_0>=64 && LA65_0<=66)||(LA65_0>=69 && LA65_0<=77)||LA65_0==79) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // PsiInternalPureXbase.g:3265:3: ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXExpressionOrVarDeclaration_XVariableDeclarationParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:3273:3: ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXExpressionOrVarDeclaration_XExpressionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

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
        return ;
    }
    // $ANTLR end "ruleXExpressionOrVarDeclaration"


    // $ANTLR start "entryRuleXVariableDeclaration"
    // PsiInternalPureXbase.g:3284:1: entryRuleXVariableDeclaration : ruleXVariableDeclaration EOF ;
    public final void entryRuleXVariableDeclaration() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:3284:30: ( ruleXVariableDeclaration EOF )
            // PsiInternalPureXbase.g:3285:2: ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXVariableDeclarationElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXVariableDeclaration"


    // $ANTLR start "ruleXVariableDeclaration"
    // PsiInternalPureXbase.g:3290:1: ruleXVariableDeclaration : ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) ;
    public final void ruleXVariableDeclaration() throws RecognitionException {
        Token lv_writeable_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;

        try {
            // PsiInternalPureXbase.g:3290:25: ( ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) )
            // PsiInternalPureXbase.g:3291:2: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            {
            // PsiInternalPureXbase.g:3291:2: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            // PsiInternalPureXbase.g:3292:3: () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            {
            // PsiInternalPureXbase.g:3292:3: ()
            // PsiInternalPureXbase.g:3293:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXVariableDeclaration_XVariableDeclarationAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalPureXbase.g:3298:3: ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==67) ) {
                alt66=1;
            }
            else if ( (LA66_0==68) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // PsiInternalPureXbase.g:3299:4: ( (lv_writeable_1_0= 'var' ) )
                    {
                    // PsiInternalPureXbase.g:3299:4: ( (lv_writeable_1_0= 'var' ) )
                    // PsiInternalPureXbase.g:3300:5: (lv_writeable_1_0= 'var' )
                    {
                    // PsiInternalPureXbase.g:3300:5: (lv_writeable_1_0= 'var' )
                    // PsiInternalPureXbase.g:3301:6: lv_writeable_1_0= 'var'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getXVariableDeclaration_WriteableVarKeyword_1_0_0ElementType());
                      					
                    }
                    lv_writeable_1_0=(Token)match(input,67,FOLLOW_15); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_writeable_1_0);
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:3311:4: otherlv_2= 'val'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXVariableDeclaration_ValKeyword_1_1ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,68,FOLLOW_15); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalPureXbase.g:3319:3: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) )
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
                    if (state.backtracking>0) {state.failed=true; return ;}
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // PsiInternalPureXbase.g:3320:4: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    {
                    // PsiInternalPureXbase.g:3320:4: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    // PsiInternalPureXbase.g:3321:5: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    {
                    // PsiInternalPureXbase.g:3334:5: ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    // PsiInternalPureXbase.g:3335:6: ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) )
                    {
                    // PsiInternalPureXbase.g:3335:6: ( (lv_type_3_0= ruleJvmTypeReference ) )
                    // PsiInternalPureXbase.g:3336:7: (lv_type_3_0= ruleJvmTypeReference )
                    {
                    // PsiInternalPureXbase.g:3336:7: (lv_type_3_0= ruleJvmTypeReference )
                    // PsiInternalPureXbase.g:3337:8: lv_type_3_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getXVariableDeclaration_TypeJvmTypeReferenceParserRuleCall_2_0_0_0_0ElementType());
                      							
                    }
                    pushFollow(FOLLOW_25);
                    ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      								doneComposite();
                      							
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:3346:6: ( (lv_name_4_0= ruleValidID ) )
                    // PsiInternalPureXbase.g:3347:7: (lv_name_4_0= ruleValidID )
                    {
                    // PsiInternalPureXbase.g:3347:7: (lv_name_4_0= ruleValidID )
                    // PsiInternalPureXbase.g:3348:8: lv_name_4_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getXVariableDeclaration_NameValidIDParserRuleCall_2_0_0_1_0ElementType());
                      							
                    }
                    pushFollow(FOLLOW_57);
                    ruleValidID();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      								doneComposite();
                      							
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:3360:4: ( (lv_name_5_0= ruleValidID ) )
                    {
                    // PsiInternalPureXbase.g:3360:4: ( (lv_name_5_0= ruleValidID ) )
                    // PsiInternalPureXbase.g:3361:5: (lv_name_5_0= ruleValidID )
                    {
                    // PsiInternalPureXbase.g:3361:5: (lv_name_5_0= ruleValidID )
                    // PsiInternalPureXbase.g:3362:6: lv_name_5_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXVariableDeclaration_NameValidIDParserRuleCall_2_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_57);
                    ruleValidID();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalPureXbase.g:3372:3: (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==14) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // PsiInternalPureXbase.g:3373:4: otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXVariableDeclaration_EqualsSignKeyword_3_0ElementType());
                      			
                    }
                    otherlv_6=(Token)match(input,14,FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_6);
                      			
                    }
                    // PsiInternalPureXbase.g:3380:4: ( (lv_right_7_0= ruleXExpression ) )
                    // PsiInternalPureXbase.g:3381:5: (lv_right_7_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:3381:5: (lv_right_7_0= ruleXExpression )
                    // PsiInternalPureXbase.g:3382:6: lv_right_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXVariableDeclaration_RightXExpressionParserRuleCall_3_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    ruleXExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
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
        return ;
    }
    // $ANTLR end "ruleXVariableDeclaration"


    // $ANTLR start "entryRuleJvmFormalParameter"
    // PsiInternalPureXbase.g:3396:1: entryRuleJvmFormalParameter : ruleJvmFormalParameter EOF ;
    public final void entryRuleJvmFormalParameter() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:3396:28: ( ruleJvmFormalParameter EOF )
            // PsiInternalPureXbase.g:3397:2: ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmFormalParameterElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJvmFormalParameter"


    // $ANTLR start "ruleJvmFormalParameter"
    // PsiInternalPureXbase.g:3402:1: ruleJvmFormalParameter : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final void ruleJvmFormalParameter() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:3402:23: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) )
            // PsiInternalPureXbase.g:3403:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            {
            // PsiInternalPureXbase.g:3403:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            // PsiInternalPureXbase.g:3404:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) )
            {
            // PsiInternalPureXbase.g:3404:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
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
                    // PsiInternalPureXbase.g:3405:4: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // PsiInternalPureXbase.g:3405:4: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // PsiInternalPureXbase.g:3406:5: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getJvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_0_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_25);
                    ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalPureXbase.g:3415:3: ( (lv_name_1_0= ruleValidID ) )
            // PsiInternalPureXbase.g:3416:4: (lv_name_1_0= ruleValidID )
            {
            // PsiInternalPureXbase.g:3416:4: (lv_name_1_0= ruleValidID )
            // PsiInternalPureXbase.g:3417:5: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmFormalParameter_NameValidIDParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
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
        return ;
    }
    // $ANTLR end "ruleJvmFormalParameter"


    // $ANTLR start "entryRuleFullJvmFormalParameter"
    // PsiInternalPureXbase.g:3430:1: entryRuleFullJvmFormalParameter : ruleFullJvmFormalParameter EOF ;
    public final void entryRuleFullJvmFormalParameter() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:3430:32: ( ruleFullJvmFormalParameter EOF )
            // PsiInternalPureXbase.g:3431:2: ruleFullJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFullJvmFormalParameterElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFullJvmFormalParameter"


    // $ANTLR start "ruleFullJvmFormalParameter"
    // PsiInternalPureXbase.g:3436:1: ruleFullJvmFormalParameter : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final void ruleFullJvmFormalParameter() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:3436:27: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) )
            // PsiInternalPureXbase.g:3437:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            {
            // PsiInternalPureXbase.g:3437:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            // PsiInternalPureXbase.g:3438:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) )
            {
            // PsiInternalPureXbase.g:3438:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )
            // PsiInternalPureXbase.g:3439:4: (lv_parameterType_0_0= ruleJvmTypeReference )
            {
            // PsiInternalPureXbase.g:3439:4: (lv_parameterType_0_0= ruleJvmTypeReference )
            // PsiInternalPureXbase.g:3440:5: lv_parameterType_0_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getFullJvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FOLLOW_25);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // PsiInternalPureXbase.g:3449:3: ( (lv_name_1_0= ruleValidID ) )
            // PsiInternalPureXbase.g:3450:4: (lv_name_1_0= ruleValidID )
            {
            // PsiInternalPureXbase.g:3450:4: (lv_name_1_0= ruleValidID )
            // PsiInternalPureXbase.g:3451:5: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getFullJvmFormalParameter_NameValidIDParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
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
        return ;
    }
    // $ANTLR end "ruleFullJvmFormalParameter"


    // $ANTLR start "entryRuleXFeatureCall"
    // PsiInternalPureXbase.g:3464:1: entryRuleXFeatureCall : ruleXFeatureCall EOF ;
    public final void entryRuleXFeatureCall() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:3464:22: ( ruleXFeatureCall EOF )
            // PsiInternalPureXbase.g:3465:2: ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXFeatureCallElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXFeatureCall"


    // $ANTLR start "ruleXFeatureCall"
    // PsiInternalPureXbase.g:3470:1: ruleXFeatureCall : ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? ) ;
    public final void ruleXFeatureCall() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_explicitOperationCall_7_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;

        try {
            // PsiInternalPureXbase.g:3470:17: ( ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? ) )
            // PsiInternalPureXbase.g:3471:2: ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? )
            {
            // PsiInternalPureXbase.g:3471:2: ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? )
            // PsiInternalPureXbase.g:3472:3: () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?
            {
            // PsiInternalPureXbase.g:3472:3: ()
            // PsiInternalPureXbase.g:3473:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXFeatureCall_XFeatureCallAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalPureXbase.g:3478:3: (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==20) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // PsiInternalPureXbase.g:3479:4: otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXFeatureCall_LessThanSignKeyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,20,FOLLOW_27); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }
                    // PsiInternalPureXbase.g:3486:4: ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) )
                    // PsiInternalPureXbase.g:3487:5: (lv_typeArguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // PsiInternalPureXbase.g:3487:5: (lv_typeArguments_2_0= ruleJvmArgumentTypeReference )
                    // PsiInternalPureXbase.g:3488:6: lv_typeArguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_28);
                    ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:3497:4: (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==49) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:3498:5: otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getXFeatureCall_CommaKeyword_1_2_0ElementType());
                    	      				
                    	    }
                    	    otherlv_3=(Token)match(input,49,FOLLOW_27); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_3);
                    	      				
                    	    }
                    	    // PsiInternalPureXbase.g:3505:5: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // PsiInternalPureXbase.g:3506:6: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // PsiInternalPureXbase.g:3506:6: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    	    // PsiInternalPureXbase.g:3507:7: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getXFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_28);
                    	    ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      						
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
                    otherlv_5=(Token)match(input,21,FOLLOW_26); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_5);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalPureXbase.g:3525:3: ( ( ruleIdOrSuper ) )
            // PsiInternalPureXbase.g:3526:4: ( ruleIdOrSuper )
            {
            // PsiInternalPureXbase.g:3526:4: ( ruleIdOrSuper )
            // PsiInternalPureXbase.g:3527:5: ruleIdOrSuper
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXFeatureCall_FeatureJvmIdentifiableElementCrossReference_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_58);
            ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // PsiInternalPureXbase.g:3536:3: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )?
            int alt74=2;
            alt74 = dfa74.predict(input);
            switch (alt74) {
                case 1 :
                    // PsiInternalPureXbase.g:3537:4: ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')'
                    {
                    // PsiInternalPureXbase.g:3537:4: ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) )
                    // PsiInternalPureXbase.g:3538:5: ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' )
                    {
                    // PsiInternalPureXbase.g:3542:5: (lv_explicitOperationCall_7_0= '(' )
                    // PsiInternalPureXbase.g:3543:6: lv_explicitOperationCall_7_0= '('
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getXFeatureCall_ExplicitOperationCallLeftParenthesisKeyword_3_0_0ElementType());
                      					
                    }
                    lv_explicitOperationCall_7_0=(Token)match(input,50,FOLLOW_30); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_explicitOperationCall_7_0);
                      					
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:3552:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )?
                    int alt73=3;
                    alt73 = dfa73.predict(input);
                    switch (alt73) {
                        case 1 :
                            // PsiInternalPureXbase.g:3553:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) )
                            {
                            // PsiInternalPureXbase.g:3553:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) )
                            // PsiInternalPureXbase.g:3554:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure )
                            {
                            // PsiInternalPureXbase.g:3579:6: (lv_featureCallArguments_8_0= ruleXShortClosure )
                            // PsiInternalPureXbase.g:3580:7: lv_featureCallArguments_8_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {

                              							markComposite(elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0ElementType());
                              						
                            }
                            pushFollow(FOLLOW_31);
                            ruleXShortClosure();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneComposite();
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalPureXbase.g:3590:5: ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* )
                            {
                            // PsiInternalPureXbase.g:3590:5: ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* )
                            // PsiInternalPureXbase.g:3591:6: ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )*
                            {
                            // PsiInternalPureXbase.g:3591:6: ( (lv_featureCallArguments_9_0= ruleXExpression ) )
                            // PsiInternalPureXbase.g:3592:7: (lv_featureCallArguments_9_0= ruleXExpression )
                            {
                            // PsiInternalPureXbase.g:3592:7: (lv_featureCallArguments_9_0= ruleXExpression )
                            // PsiInternalPureXbase.g:3593:8: lv_featureCallArguments_9_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0ElementType());
                              							
                            }
                            pushFollow(FOLLOW_32);
                            ruleXExpression();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              							
                            }

                            }


                            }

                            // PsiInternalPureXbase.g:3602:6: (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )*
                            loop72:
                            do {
                                int alt72=2;
                                int LA72_0 = input.LA(1);

                                if ( (LA72_0==49) ) {
                                    alt72=1;
                                }


                                switch (alt72) {
                            	case 1 :
                            	    // PsiInternalPureXbase.g:3603:7: otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) )
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      							markLeaf(elementTypeProvider.getXFeatureCall_CommaKeyword_3_1_1_1_0ElementType());
                            	      						
                            	    }
                            	    otherlv_10=(Token)match(input,49,FOLLOW_3); if (state.failed) return ;
                            	    if ( state.backtracking==0 ) {

                            	      							doneLeaf(otherlv_10);
                            	      						
                            	    }
                            	    // PsiInternalPureXbase.g:3610:7: ( (lv_featureCallArguments_11_0= ruleXExpression ) )
                            	    // PsiInternalPureXbase.g:3611:8: (lv_featureCallArguments_11_0= ruleXExpression )
                            	    {
                            	    // PsiInternalPureXbase.g:3611:8: (lv_featureCallArguments_11_0= ruleXExpression )
                            	    // PsiInternalPureXbase.g:3612:9: lv_featureCallArguments_11_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									markComposite(elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0ElementType());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_32);
                            	    ruleXExpression();

                            	    state._fsp--;
                            	    if (state.failed) return ;
                            	    if ( state.backtracking==0 ) {

                            	      									doneComposite();
                            	      								
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
                    otherlv_12=(Token)match(input,51,FOLLOW_59); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_12);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalPureXbase.g:3632:3: ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?
            int alt75=2;
            alt75 = dfa75.predict(input);
            switch (alt75) {
                case 1 :
                    // PsiInternalPureXbase.g:3633:4: ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure )
                    {
                    // PsiInternalPureXbase.g:3639:4: (lv_featureCallArguments_13_0= ruleXClosure )
                    // PsiInternalPureXbase.g:3640:5: lv_featureCallArguments_13_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXClosureParserRuleCall_4_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    ruleXClosure();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
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
        return ;
    }
    // $ANTLR end "ruleXFeatureCall"


    // $ANTLR start "entryRuleIdOrSuper"
    // PsiInternalPureXbase.g:3653:1: entryRuleIdOrSuper : ruleIdOrSuper EOF ;
    public final void entryRuleIdOrSuper() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:3653:19: ( ruleIdOrSuper EOF )
            // PsiInternalPureXbase.g:3654:2: ruleIdOrSuper EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getIdOrSuperElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIdOrSuper"


    // $ANTLR start "ruleIdOrSuper"
    // PsiInternalPureXbase.g:3659:1: ruleIdOrSuper : ( ruleFeatureCallID | kw= 'super' ) ;
    public final void ruleIdOrSuper() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalPureXbase.g:3659:14: ( ( ruleFeatureCallID | kw= 'super' ) )
            // PsiInternalPureXbase.g:3660:2: ( ruleFeatureCallID | kw= 'super' )
            {
            // PsiInternalPureXbase.g:3660:2: ( ruleFeatureCallID | kw= 'super' )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_ID) ) {
                alt76=1;
            }
            else if ( (LA76_0==69) ) {
                alt76=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // PsiInternalPureXbase.g:3661:3: ruleFeatureCallID
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getIdOrSuper_FeatureCallIDParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleFeatureCallID();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:3669:3: kw= 'super'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getIdOrSuper_SuperKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,69,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleIdOrSuper"


    // $ANTLR start "entryRuleXConstructorCall"
    // PsiInternalPureXbase.g:3680:1: entryRuleXConstructorCall : ruleXConstructorCall EOF ;
    public final void entryRuleXConstructorCall() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:3680:26: ( ruleXConstructorCall EOF )
            // PsiInternalPureXbase.g:3681:2: ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXConstructorCallElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXConstructorCall"


    // $ANTLR start "ruleXConstructorCall"
    // PsiInternalPureXbase.g:3686:1: ruleXConstructorCall : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) ;
    public final void ruleXConstructorCall() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_explicitConstructorCall_8_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;

        try {
            // PsiInternalPureXbase.g:3686:21: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) )
            // PsiInternalPureXbase.g:3687:2: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            {
            // PsiInternalPureXbase.g:3687:2: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            // PsiInternalPureXbase.g:3688:3: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            {
            // PsiInternalPureXbase.g:3688:3: ()
            // PsiInternalPureXbase.g:3689:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXConstructorCall_XConstructorCallAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXConstructorCall_NewKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,70,FOLLOW_25); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalPureXbase.g:3701:3: ( ( ruleQualifiedName ) )
            // PsiInternalPureXbase.g:3702:4: ( ruleQualifiedName )
            {
            // PsiInternalPureXbase.g:3702:4: ( ruleQualifiedName )
            // PsiInternalPureXbase.g:3703:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXConstructorCall_ConstructorJvmConstructorCrossReference_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_60);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // PsiInternalPureXbase.g:3712:3: ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
            int alt78=2;
            alt78 = dfa78.predict(input);
            switch (alt78) {
                case 1 :
                    // PsiInternalPureXbase.g:3713:4: ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
                    {
                    // PsiInternalPureXbase.g:3713:4: ( ( '<' )=>otherlv_3= '<' )
                    // PsiInternalPureXbase.g:3714:5: ( '<' )=>otherlv_3= '<'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getXConstructorCall_LessThanSignKeyword_3_0ElementType());
                      				
                    }
                    otherlv_3=(Token)match(input,20,FOLLOW_27); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_3);
                      				
                    }

                    }

                    // PsiInternalPureXbase.g:3723:4: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    // PsiInternalPureXbase.g:3724:5: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    {
                    // PsiInternalPureXbase.g:3724:5: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    // PsiInternalPureXbase.g:3725:6: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_28);
                    ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:3734:4: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( (LA77_0==49) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:3735:5: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getXConstructorCall_CommaKeyword_3_2_0ElementType());
                    	      				
                    	    }
                    	    otherlv_5=(Token)match(input,49,FOLLOW_27); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_5);
                    	      				
                    	    }
                    	    // PsiInternalPureXbase.g:3742:5: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    // PsiInternalPureXbase.g:3743:6: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // PsiInternalPureXbase.g:3743:6: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    // PsiInternalPureXbase.g:3744:7: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getXConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_28);
                    	    ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      						
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
                    otherlv_7=(Token)match(input,21,FOLLOW_58); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_7);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalPureXbase.g:3762:3: ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            int alt81=2;
            alt81 = dfa81.predict(input);
            switch (alt81) {
                case 1 :
                    // PsiInternalPureXbase.g:3763:4: ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
                    {
                    // PsiInternalPureXbase.g:3763:4: ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) )
                    // PsiInternalPureXbase.g:3764:5: ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' )
                    {
                    // PsiInternalPureXbase.g:3768:5: (lv_explicitConstructorCall_8_0= '(' )
                    // PsiInternalPureXbase.g:3769:6: lv_explicitConstructorCall_8_0= '('
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getXConstructorCall_ExplicitConstructorCallLeftParenthesisKeyword_4_0_0ElementType());
                      					
                    }
                    lv_explicitConstructorCall_8_0=(Token)match(input,50,FOLLOW_30); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_explicitConstructorCall_8_0);
                      					
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:3778:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?
                    int alt80=3;
                    alt80 = dfa80.predict(input);
                    switch (alt80) {
                        case 1 :
                            // PsiInternalPureXbase.g:3779:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                            {
                            // PsiInternalPureXbase.g:3779:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                            // PsiInternalPureXbase.g:3780:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure )
                            {
                            // PsiInternalPureXbase.g:3805:6: (lv_arguments_9_0= ruleXShortClosure )
                            // PsiInternalPureXbase.g:3806:7: lv_arguments_9_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {

                              							markComposite(elementTypeProvider.getXConstructorCall_ArgumentsXShortClosureParserRuleCall_4_1_0_0ElementType());
                              						
                            }
                            pushFollow(FOLLOW_31);
                            ruleXShortClosure();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneComposite();
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalPureXbase.g:3816:5: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                            {
                            // PsiInternalPureXbase.g:3816:5: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                            // PsiInternalPureXbase.g:3817:6: ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                            {
                            // PsiInternalPureXbase.g:3817:6: ( (lv_arguments_10_0= ruleXExpression ) )
                            // PsiInternalPureXbase.g:3818:7: (lv_arguments_10_0= ruleXExpression )
                            {
                            // PsiInternalPureXbase.g:3818:7: (lv_arguments_10_0= ruleXExpression )
                            // PsiInternalPureXbase.g:3819:8: lv_arguments_10_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getXConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_0_0ElementType());
                              							
                            }
                            pushFollow(FOLLOW_32);
                            ruleXExpression();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              							
                            }

                            }


                            }

                            // PsiInternalPureXbase.g:3828:6: (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                            loop79:
                            do {
                                int alt79=2;
                                int LA79_0 = input.LA(1);

                                if ( (LA79_0==49) ) {
                                    alt79=1;
                                }


                                switch (alt79) {
                            	case 1 :
                            	    // PsiInternalPureXbase.g:3829:7: otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) )
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      							markLeaf(elementTypeProvider.getXConstructorCall_CommaKeyword_4_1_1_1_0ElementType());
                            	      						
                            	    }
                            	    otherlv_11=(Token)match(input,49,FOLLOW_3); if (state.failed) return ;
                            	    if ( state.backtracking==0 ) {

                            	      							doneLeaf(otherlv_11);
                            	      						
                            	    }
                            	    // PsiInternalPureXbase.g:3836:7: ( (lv_arguments_12_0= ruleXExpression ) )
                            	    // PsiInternalPureXbase.g:3837:8: (lv_arguments_12_0= ruleXExpression )
                            	    {
                            	    // PsiInternalPureXbase.g:3837:8: (lv_arguments_12_0= ruleXExpression )
                            	    // PsiInternalPureXbase.g:3838:9: lv_arguments_12_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									markComposite(elementTypeProvider.getXConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_1_1_0ElementType());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_32);
                            	    ruleXExpression();

                            	    state._fsp--;
                            	    if (state.failed) return ;
                            	    if ( state.backtracking==0 ) {

                            	      									doneComposite();
                            	      								
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
                    otherlv_13=(Token)match(input,51,FOLLOW_59); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_13);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalPureXbase.g:3858:3: ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            int alt82=2;
            alt82 = dfa82.predict(input);
            switch (alt82) {
                case 1 :
                    // PsiInternalPureXbase.g:3859:4: ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure )
                    {
                    // PsiInternalPureXbase.g:3865:4: (lv_arguments_14_0= ruleXClosure )
                    // PsiInternalPureXbase.g:3866:5: lv_arguments_14_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getXConstructorCall_ArgumentsXClosureParserRuleCall_5_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    ruleXClosure();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
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
        return ;
    }
    // $ANTLR end "ruleXConstructorCall"


    // $ANTLR start "entryRuleXBooleanLiteral"
    // PsiInternalPureXbase.g:3879:1: entryRuleXBooleanLiteral : ruleXBooleanLiteral EOF ;
    public final void entryRuleXBooleanLiteral() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:3879:25: ( ruleXBooleanLiteral EOF )
            // PsiInternalPureXbase.g:3880:2: ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXBooleanLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXBooleanLiteral"


    // $ANTLR start "ruleXBooleanLiteral"
    // PsiInternalPureXbase.g:3885:1: ruleXBooleanLiteral : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final void ruleXBooleanLiteral() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

        try {
            // PsiInternalPureXbase.g:3885:20: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // PsiInternalPureXbase.g:3886:2: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // PsiInternalPureXbase.g:3886:2: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // PsiInternalPureXbase.g:3887:3: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // PsiInternalPureXbase.g:3887:3: ()
            // PsiInternalPureXbase.g:3888:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXBooleanLiteral_XBooleanLiteralAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalPureXbase.g:3893:3: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==71) ) {
                alt83=1;
            }
            else if ( (LA83_0==72) ) {
                alt83=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }
            switch (alt83) {
                case 1 :
                    // PsiInternalPureXbase.g:3894:4: otherlv_1= 'false'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXBooleanLiteral_FalseKeyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,71,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:3902:4: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // PsiInternalPureXbase.g:3902:4: ( (lv_isTrue_2_0= 'true' ) )
                    // PsiInternalPureXbase.g:3903:5: (lv_isTrue_2_0= 'true' )
                    {
                    // PsiInternalPureXbase.g:3903:5: (lv_isTrue_2_0= 'true' )
                    // PsiInternalPureXbase.g:3904:6: lv_isTrue_2_0= 'true'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getXBooleanLiteral_IsTrueTrueKeyword_1_1_0ElementType());
                      					
                    }
                    lv_isTrue_2_0=(Token)match(input,72,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_isTrue_2_0);
                      					
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
        return ;
    }
    // $ANTLR end "ruleXBooleanLiteral"


    // $ANTLR start "entryRuleXNullLiteral"
    // PsiInternalPureXbase.g:3918:1: entryRuleXNullLiteral : ruleXNullLiteral EOF ;
    public final void entryRuleXNullLiteral() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:3918:22: ( ruleXNullLiteral EOF )
            // PsiInternalPureXbase.g:3919:2: ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXNullLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXNullLiteral"


    // $ANTLR start "ruleXNullLiteral"
    // PsiInternalPureXbase.g:3924:1: ruleXNullLiteral : ( () otherlv_1= 'null' ) ;
    public final void ruleXNullLiteral() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // PsiInternalPureXbase.g:3924:17: ( ( () otherlv_1= 'null' ) )
            // PsiInternalPureXbase.g:3925:2: ( () otherlv_1= 'null' )
            {
            // PsiInternalPureXbase.g:3925:2: ( () otherlv_1= 'null' )
            // PsiInternalPureXbase.g:3926:3: () otherlv_1= 'null'
            {
            // PsiInternalPureXbase.g:3926:3: ()
            // PsiInternalPureXbase.g:3927:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXNullLiteral_XNullLiteralAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXNullLiteral_NullKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,73,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleXNullLiteral"


    // $ANTLR start "entryRuleXNumberLiteral"
    // PsiInternalPureXbase.g:3943:1: entryRuleXNumberLiteral : ruleXNumberLiteral EOF ;
    public final void entryRuleXNumberLiteral() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:3943:24: ( ruleXNumberLiteral EOF )
            // PsiInternalPureXbase.g:3944:2: ruleXNumberLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXNumberLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXNumberLiteral();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXNumberLiteral"


    // $ANTLR start "ruleXNumberLiteral"
    // PsiInternalPureXbase.g:3949:1: ruleXNumberLiteral : ( () ( (lv_value_1_0= ruleNumber ) ) ) ;
    public final void ruleXNumberLiteral() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:3949:19: ( ( () ( (lv_value_1_0= ruleNumber ) ) ) )
            // PsiInternalPureXbase.g:3950:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
            {
            // PsiInternalPureXbase.g:3950:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
            // PsiInternalPureXbase.g:3951:3: () ( (lv_value_1_0= ruleNumber ) )
            {
            // PsiInternalPureXbase.g:3951:3: ()
            // PsiInternalPureXbase.g:3952:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXNumberLiteral_XNumberLiteralAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalPureXbase.g:3957:3: ( (lv_value_1_0= ruleNumber ) )
            // PsiInternalPureXbase.g:3958:4: (lv_value_1_0= ruleNumber )
            {
            // PsiInternalPureXbase.g:3958:4: (lv_value_1_0= ruleNumber )
            // PsiInternalPureXbase.g:3959:5: lv_value_1_0= ruleNumber
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXNumberLiteral_ValueNumberParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            ruleNumber();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
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
        return ;
    }
    // $ANTLR end "ruleXNumberLiteral"


    // $ANTLR start "entryRuleXStringLiteral"
    // PsiInternalPureXbase.g:3972:1: entryRuleXStringLiteral : ruleXStringLiteral EOF ;
    public final void entryRuleXStringLiteral() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:3972:24: ( ruleXStringLiteral EOF )
            // PsiInternalPureXbase.g:3973:2: ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXStringLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXStringLiteral"


    // $ANTLR start "ruleXStringLiteral"
    // PsiInternalPureXbase.g:3978:1: ruleXStringLiteral : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final void ruleXStringLiteral() throws RecognitionException {
        Token lv_value_1_0=null;

        try {
            // PsiInternalPureXbase.g:3978:19: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // PsiInternalPureXbase.g:3979:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // PsiInternalPureXbase.g:3979:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // PsiInternalPureXbase.g:3980:3: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // PsiInternalPureXbase.g:3980:3: ()
            // PsiInternalPureXbase.g:3981:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXStringLiteral_XStringLiteralAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalPureXbase.g:3986:3: ( (lv_value_1_0= RULE_STRING ) )
            // PsiInternalPureXbase.g:3987:4: (lv_value_1_0= RULE_STRING )
            {
            // PsiInternalPureXbase.g:3987:4: (lv_value_1_0= RULE_STRING )
            // PsiInternalPureXbase.g:3988:5: lv_value_1_0= RULE_STRING
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXStringLiteral_ValueSTRINGTerminalRuleCall_1_0ElementType());
              				
            }
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleXStringLiteral"


    // $ANTLR start "entryRuleXTypeLiteral"
    // PsiInternalPureXbase.g:4001:1: entryRuleXTypeLiteral : ruleXTypeLiteral EOF ;
    public final void entryRuleXTypeLiteral() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:4001:22: ( ruleXTypeLiteral EOF )
            // PsiInternalPureXbase.g:4002:2: ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXTypeLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXTypeLiteral"


    // $ANTLR start "ruleXTypeLiteral"
    // PsiInternalPureXbase.g:4007:1: ruleXTypeLiteral : ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' ) ;
    public final void ruleXTypeLiteral() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;

        try {
            // PsiInternalPureXbase.g:4007:17: ( ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' ) )
            // PsiInternalPureXbase.g:4008:2: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' )
            {
            // PsiInternalPureXbase.g:4008:2: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' )
            // PsiInternalPureXbase.g:4009:3: () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')'
            {
            // PsiInternalPureXbase.g:4009:3: ()
            // PsiInternalPureXbase.g:4010:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXTypeLiteral_XTypeLiteralAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXTypeLiteral_TypeofKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,74,FOLLOW_43); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXTypeLiteral_LeftParenthesisKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,50,FOLLOW_25); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalPureXbase.g:4029:3: ( ( ruleQualifiedName ) )
            // PsiInternalPureXbase.g:4030:4: ( ruleQualifiedName )
            {
            // PsiInternalPureXbase.g:4030:4: ( ruleQualifiedName )
            // PsiInternalPureXbase.g:4031:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXTypeLiteral_TypeJvmTypeCrossReference_3_0ElementType());
              				
            }
            pushFollow(FOLLOW_61);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // PsiInternalPureXbase.g:4040:3: ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==55) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // PsiInternalPureXbase.g:4041:4: (lv_arrayDimensions_4_0= ruleArrayBrackets )
            	    {
            	    // PsiInternalPureXbase.g:4041:4: (lv_arrayDimensions_4_0= ruleArrayBrackets )
            	    // PsiInternalPureXbase.g:4042:5: lv_arrayDimensions_4_0= ruleArrayBrackets
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markComposite(elementTypeProvider.getXTypeLiteral_ArrayDimensionsArrayBracketsParserRuleCall_4_0ElementType());
            	      				
            	    }
            	    pushFollow(FOLLOW_61);
            	    ruleArrayBrackets();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneComposite();
            	      				
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
            otherlv_5=(Token)match(input,51,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleXTypeLiteral"


    // $ANTLR start "entryRuleXThrowExpression"
    // PsiInternalPureXbase.g:4062:1: entryRuleXThrowExpression : ruleXThrowExpression EOF ;
    public final void entryRuleXThrowExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:4062:26: ( ruleXThrowExpression EOF )
            // PsiInternalPureXbase.g:4063:2: ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXThrowExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXThrowExpression"


    // $ANTLR start "ruleXThrowExpression"
    // PsiInternalPureXbase.g:4068:1: ruleXThrowExpression : ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) ;
    public final void ruleXThrowExpression() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // PsiInternalPureXbase.g:4068:21: ( ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) )
            // PsiInternalPureXbase.g:4069:2: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            {
            // PsiInternalPureXbase.g:4069:2: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            // PsiInternalPureXbase.g:4070:3: () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) )
            {
            // PsiInternalPureXbase.g:4070:3: ()
            // PsiInternalPureXbase.g:4071:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXThrowExpression_XThrowExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXThrowExpression_ThrowKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,75,FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalPureXbase.g:4083:3: ( (lv_expression_2_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:4084:4: (lv_expression_2_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:4084:4: (lv_expression_2_0= ruleXExpression )
            // PsiInternalPureXbase.g:4085:5: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXThrowExpression_ExpressionXExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            ruleXExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
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
        return ;
    }
    // $ANTLR end "ruleXThrowExpression"


    // $ANTLR start "entryRuleXReturnExpression"
    // PsiInternalPureXbase.g:4098:1: entryRuleXReturnExpression : ruleXReturnExpression EOF ;
    public final void entryRuleXReturnExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:4098:27: ( ruleXReturnExpression EOF )
            // PsiInternalPureXbase.g:4099:2: ruleXReturnExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXReturnExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXReturnExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXReturnExpression"


    // $ANTLR start "ruleXReturnExpression"
    // PsiInternalPureXbase.g:4104:1: ruleXReturnExpression : ( () otherlv_1= 'return' ( ( '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? ) ;
    public final void ruleXReturnExpression() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // PsiInternalPureXbase.g:4104:22: ( ( () otherlv_1= 'return' ( ( '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? ) )
            // PsiInternalPureXbase.g:4105:2: ( () otherlv_1= 'return' ( ( '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? )
            {
            // PsiInternalPureXbase.g:4105:2: ( () otherlv_1= 'return' ( ( '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? )
            // PsiInternalPureXbase.g:4106:3: () otherlv_1= 'return' ( ( '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?
            {
            // PsiInternalPureXbase.g:4106:3: ()
            // PsiInternalPureXbase.g:4107:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXReturnExpression_XReturnExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXReturnExpression_ReturnKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,76,FOLLOW_5); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalPureXbase.g:4119:3: ( ( '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?
            int alt85=2;
            alt85 = dfa85.predict(input);
            switch (alt85) {
                case 1 :
                    // PsiInternalPureXbase.g:4120:4: ( '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:4121:4: (lv_expression_2_0= ruleXExpression )
                    // PsiInternalPureXbase.g:4122:5: lv_expression_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getXReturnExpression_ExpressionXExpressionParserRuleCall_2_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    ruleXExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
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
        return ;
    }
    // $ANTLR end "ruleXReturnExpression"


    // $ANTLR start "entryRuleXTryCatchFinallyExpression"
    // PsiInternalPureXbase.g:4135:1: entryRuleXTryCatchFinallyExpression : ruleXTryCatchFinallyExpression EOF ;
    public final void entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:4135:36: ( ruleXTryCatchFinallyExpression EOF )
            // PsiInternalPureXbase.g:4136:2: ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXTryCatchFinallyExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXTryCatchFinallyExpression"


    // $ANTLR start "ruleXTryCatchFinallyExpression"
    // PsiInternalPureXbase.g:4141:1: ruleXTryCatchFinallyExpression : ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) ;
    public final void ruleXTryCatchFinallyExpression() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

        try {
            // PsiInternalPureXbase.g:4141:31: ( ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) )
            // PsiInternalPureXbase.g:4142:2: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            {
            // PsiInternalPureXbase.g:4142:2: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            // PsiInternalPureXbase.g:4143:3: () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            {
            // PsiInternalPureXbase.g:4143:3: ()
            // PsiInternalPureXbase.g:4144:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXTryCatchFinallyExpression_XTryCatchFinallyExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXTryCatchFinallyExpression_TryKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,77,FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalPureXbase.g:4156:3: ( (lv_expression_2_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:4157:4: (lv_expression_2_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:4157:4: (lv_expression_2_0= ruleXExpression )
            // PsiInternalPureXbase.g:4158:5: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXTryCatchFinallyExpression_ExpressionXExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_62);
            ruleXExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // PsiInternalPureXbase.g:4167:3: ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==80) ) {
                alt88=1;
            }
            else if ( (LA88_0==78) ) {
                alt88=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // PsiInternalPureXbase.g:4168:4: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    {
                    // PsiInternalPureXbase.g:4168:4: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    // PsiInternalPureXbase.g:4169:5: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    {
                    // PsiInternalPureXbase.g:4169:5: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+
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
                    	    // PsiInternalPureXbase.g:4170:6: ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause )
                    	    {
                    	    // PsiInternalPureXbase.g:4171:6: (lv_catchClauses_3_0= ruleXCatchClause )
                    	    // PsiInternalPureXbase.g:4172:7: lv_catchClauses_3_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getXTryCatchFinallyExpression_CatchClausesXCatchClauseParserRuleCall_3_0_0_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_63);
                    	    ruleXCatchClause();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      						
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt86 >= 1 ) break loop86;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(86, input);
                                throw eee;
                        }
                        cnt86++;
                    } while (true);

                    // PsiInternalPureXbase.g:4181:5: ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
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
                            // PsiInternalPureXbase.g:4182:6: ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            {
                            // PsiInternalPureXbase.g:4182:6: ( ( 'finally' )=>otherlv_4= 'finally' )
                            // PsiInternalPureXbase.g:4183:7: ( 'finally' )=>otherlv_4= 'finally'
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getXTryCatchFinallyExpression_FinallyKeyword_3_0_1_0ElementType());
                              						
                            }
                            otherlv_4=(Token)match(input,78,FOLLOW_3); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(otherlv_4);
                              						
                            }

                            }

                            // PsiInternalPureXbase.g:4192:6: ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            // PsiInternalPureXbase.g:4193:7: (lv_finallyExpression_5_0= ruleXExpression )
                            {
                            // PsiInternalPureXbase.g:4193:7: (lv_finallyExpression_5_0= ruleXExpression )
                            // PsiInternalPureXbase.g:4194:8: lv_finallyExpression_5_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getXTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_0_1_1_0ElementType());
                              							
                            }
                            pushFollow(FOLLOW_2);
                            ruleXExpression();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              							
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
                    // PsiInternalPureXbase.g:4206:4: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    {
                    // PsiInternalPureXbase.g:4206:4: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    // PsiInternalPureXbase.g:4207:5: otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getXTryCatchFinallyExpression_FinallyKeyword_3_1_0ElementType());
                      				
                    }
                    otherlv_6=(Token)match(input,78,FOLLOW_3); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_6);
                      				
                    }
                    // PsiInternalPureXbase.g:4214:5: ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    // PsiInternalPureXbase.g:4215:6: (lv_finallyExpression_7_0= ruleXExpression )
                    {
                    // PsiInternalPureXbase.g:4215:6: (lv_finallyExpression_7_0= ruleXExpression )
                    // PsiInternalPureXbase.g:4216:7: lv_finallyExpression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getXTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_1_1_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    ruleXExpression();

                    state._fsp--;
                    if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleXTryCatchFinallyExpression"


    // $ANTLR start "entryRuleXSynchronizedExpression"
    // PsiInternalPureXbase.g:4231:1: entryRuleXSynchronizedExpression : ruleXSynchronizedExpression EOF ;
    public final void entryRuleXSynchronizedExpression() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:4231:33: ( ruleXSynchronizedExpression EOF )
            // PsiInternalPureXbase.g:4232:2: ruleXSynchronizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXSynchronizedExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXSynchronizedExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXSynchronizedExpression"


    // $ANTLR start "ruleXSynchronizedExpression"
    // PsiInternalPureXbase.g:4237:1: ruleXSynchronizedExpression : ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final void ruleXSynchronizedExpression() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // PsiInternalPureXbase.g:4237:28: ( ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // PsiInternalPureXbase.g:4238:2: ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // PsiInternalPureXbase.g:4238:2: ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) )
            // PsiInternalPureXbase.g:4239:3: ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) )
            {
            // PsiInternalPureXbase.g:4239:3: ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) )
            // PsiInternalPureXbase.g:4240:4: ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' )
            {
            // PsiInternalPureXbase.g:4247:4: ( () otherlv_1= 'synchronized' otherlv_2= '(' )
            // PsiInternalPureXbase.g:4248:5: () otherlv_1= 'synchronized' otherlv_2= '('
            {
            // PsiInternalPureXbase.g:4248:5: ()
            // PsiInternalPureXbase.g:4249:6: 
            {
            if ( state.backtracking==0 ) {

              						precedeComposite(elementTypeProvider.getXSynchronizedExpression_XSynchronizedExpressionAction_0_0_0ElementType());
              						doneComposite();
              					
            }

            }

            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXSynchronizedExpression_SynchronizedKeyword_0_0_1ElementType());
              				
            }
            otherlv_1=(Token)match(input,79,FOLLOW_43); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(otherlv_1);
              				
            }
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXSynchronizedExpression_LeftParenthesisKeyword_0_0_2ElementType());
              				
            }
            otherlv_2=(Token)match(input,50,FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(otherlv_2);
              				
            }

            }


            }

            // PsiInternalPureXbase.g:4270:3: ( (lv_param_3_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:4271:4: (lv_param_3_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:4271:4: (lv_param_3_0= ruleXExpression )
            // PsiInternalPureXbase.g:4272:5: lv_param_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXSynchronizedExpression_ParamXExpressionParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_31);
            ruleXExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXSynchronizedExpression_RightParenthesisKeyword_2ElementType());
              		
            }
            otherlv_4=(Token)match(input,51,FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
            }
            // PsiInternalPureXbase.g:4288:3: ( (lv_expression_5_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:4289:4: (lv_expression_5_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:4289:4: (lv_expression_5_0= ruleXExpression )
            // PsiInternalPureXbase.g:4290:5: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXSynchronizedExpression_ExpressionXExpressionParserRuleCall_3_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            ruleXExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
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
        return ;
    }
    // $ANTLR end "ruleXSynchronizedExpression"


    // $ANTLR start "entryRuleXCatchClause"
    // PsiInternalPureXbase.g:4303:1: entryRuleXCatchClause : ruleXCatchClause EOF ;
    public final void entryRuleXCatchClause() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:4303:22: ( ruleXCatchClause EOF )
            // PsiInternalPureXbase.g:4304:2: ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXCatchClauseElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXCatchClause();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXCatchClause"


    // $ANTLR start "ruleXCatchClause"
    // PsiInternalPureXbase.g:4309:1: ruleXCatchClause : ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final void ruleXCatchClause() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

        try {
            // PsiInternalPureXbase.g:4309:17: ( ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // PsiInternalPureXbase.g:4310:2: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // PsiInternalPureXbase.g:4310:2: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // PsiInternalPureXbase.g:4311:3: ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            // PsiInternalPureXbase.g:4311:3: ( ( 'catch' )=>otherlv_0= 'catch' )
            // PsiInternalPureXbase.g:4312:4: ( 'catch' )=>otherlv_0= 'catch'
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getXCatchClause_CatchKeyword_0ElementType());
              			
            }
            otherlv_0=(Token)match(input,80,FOLLOW_43); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              				doneLeaf(otherlv_0);
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXCatchClause_LeftParenthesisKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,50,FOLLOW_15); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalPureXbase.g:4328:3: ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) )
            // PsiInternalPureXbase.g:4329:4: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            {
            // PsiInternalPureXbase.g:4329:4: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            // PsiInternalPureXbase.g:4330:5: lv_declaredParam_2_0= ruleFullJvmFormalParameter
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXCatchClause_DeclaredParamFullJvmFormalParameterParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_31);
            ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXCatchClause_RightParenthesisKeyword_3ElementType());
              		
            }
            otherlv_3=(Token)match(input,51,FOLLOW_3); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_3);
              		
            }
            // PsiInternalPureXbase.g:4346:3: ( (lv_expression_4_0= ruleXExpression ) )
            // PsiInternalPureXbase.g:4347:4: (lv_expression_4_0= ruleXExpression )
            {
            // PsiInternalPureXbase.g:4347:4: (lv_expression_4_0= ruleXExpression )
            // PsiInternalPureXbase.g:4348:5: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXCatchClause_ExpressionXExpressionParserRuleCall_4_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            ruleXExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
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
        return ;
    }
    // $ANTLR end "ruleXCatchClause"


    // $ANTLR start "entryRuleQualifiedName"
    // PsiInternalPureXbase.g:4361:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:4361:23: ( ruleQualifiedName EOF )
            // PsiInternalPureXbase.g:4362:2: ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getQualifiedNameElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // PsiInternalPureXbase.g:4367:1: ruleQualifiedName : ( ruleValidID ( ( ( '.' )=>kw= '.' ) ruleValidID )* ) ;
    public final void ruleQualifiedName() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalPureXbase.g:4367:18: ( ( ruleValidID ( ( ( '.' )=>kw= '.' ) ruleValidID )* ) )
            // PsiInternalPureXbase.g:4368:2: ( ruleValidID ( ( ( '.' )=>kw= '.' ) ruleValidID )* )
            {
            // PsiInternalPureXbase.g:4368:2: ( ruleValidID ( ( ( '.' )=>kw= '.' ) ruleValidID )* )
            // PsiInternalPureXbase.g:4369:3: ruleValidID ( ( ( '.' )=>kw= '.' ) ruleValidID )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getQualifiedName_ValidIDParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_64);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalPureXbase.g:4376:3: ( ( ( '.' )=>kw= '.' ) ruleValidID )*
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
            	    // PsiInternalPureXbase.g:4377:4: ( ( '.' )=>kw= '.' ) ruleValidID
            	    {
            	    // PsiInternalPureXbase.g:4377:4: ( ( '.' )=>kw= '.' )
            	    // PsiInternalPureXbase.g:4378:5: ( '.' )=>kw= '.'
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getQualifiedName_FullStopKeyword_1_0ElementType());
            	      				
            	    }
            	    kw=(Token)match(input,46,FOLLOW_25); if (state.failed) return ;
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
            	    if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleNumber"
    // PsiInternalPureXbase.g:4399:1: entryRuleNumber : ruleNumber EOF ;
    public final void entryRuleNumber() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // PsiInternalPureXbase.g:4401:2: ( ruleNumber EOF )
            // PsiInternalPureXbase.g:4402:2: ruleNumber EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getNumberElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleNumber();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // PsiInternalPureXbase.g:4410:1: ruleNumber : (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) ) ;
    public final void ruleNumber() throws RecognitionException {
        Token this_HEX_0=null;
        Token this_INT_1=null;
        Token this_DECIMAL_2=null;
        Token kw=null;
        Token this_INT_4=null;
        Token this_DECIMAL_5=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // PsiInternalPureXbase.g:4412:2: ( (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) ) )
            // PsiInternalPureXbase.g:4413:2: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) )
            {
            // PsiInternalPureXbase.g:4413:2: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==RULE_HEX) ) {
                alt93=1;
            }
            else if ( ((LA93_0>=RULE_INT && LA93_0<=RULE_DECIMAL)) ) {
                alt93=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }
            switch (alt93) {
                case 1 :
                    // PsiInternalPureXbase.g:4414:3: this_HEX_0= RULE_HEX
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getNumber_HEXTerminalRuleCall_0ElementType());
                      		
                    }
                    this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(this_HEX_0);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:4422:3: ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? )
                    {
                    // PsiInternalPureXbase.g:4422:3: ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? )
                    // PsiInternalPureXbase.g:4423:4: (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )?
                    {
                    // PsiInternalPureXbase.g:4423:4: (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL )
                    int alt90=2;
                    int LA90_0 = input.LA(1);

                    if ( (LA90_0==RULE_INT) ) {
                        alt90=1;
                    }
                    else if ( (LA90_0==RULE_DECIMAL) ) {
                        alt90=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 90, 0, input);

                        throw nvae;
                    }
                    switch (alt90) {
                        case 1 :
                            // PsiInternalPureXbase.g:4424:5: this_INT_1= RULE_INT
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getNumber_INTTerminalRuleCall_1_0_0ElementType());
                              				
                            }
                            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_64); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(this_INT_1);
                              				
                            }

                            }
                            break;
                        case 2 :
                            // PsiInternalPureXbase.g:4432:5: this_DECIMAL_2= RULE_DECIMAL
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getNumber_DECIMALTerminalRuleCall_1_0_1ElementType());
                              				
                            }
                            this_DECIMAL_2=(Token)match(input,RULE_DECIMAL,FOLLOW_64); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(this_DECIMAL_2);
                              				
                            }

                            }
                            break;

                    }

                    // PsiInternalPureXbase.g:4440:4: (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )?
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
                            // PsiInternalPureXbase.g:4441:5: kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL )
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getNumber_FullStopKeyword_1_1_0ElementType());
                              				
                            }
                            kw=(Token)match(input,46,FOLLOW_65); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(kw);
                              				
                            }
                            // PsiInternalPureXbase.g:4448:5: (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL )
                            int alt91=2;
                            int LA91_0 = input.LA(1);

                            if ( (LA91_0==RULE_INT) ) {
                                alt91=1;
                            }
                            else if ( (LA91_0==RULE_DECIMAL) ) {
                                alt91=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 91, 0, input);

                                throw nvae;
                            }
                            switch (alt91) {
                                case 1 :
                                    // PsiInternalPureXbase.g:4449:6: this_INT_4= RULE_INT
                                    {
                                    if ( state.backtracking==0 ) {

                                      						markLeaf(elementTypeProvider.getNumber_INTTerminalRuleCall_1_1_1_0ElementType());
                                      					
                                    }
                                    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
                                    if ( state.backtracking==0 ) {

                                      						doneLeaf(this_INT_4);
                                      					
                                    }

                                    }
                                    break;
                                case 2 :
                                    // PsiInternalPureXbase.g:4457:6: this_DECIMAL_5= RULE_DECIMAL
                                    {
                                    if ( state.backtracking==0 ) {

                                      						markLeaf(elementTypeProvider.getNumber_DECIMALTerminalRuleCall_1_1_1_1ElementType());
                                      					
                                    }
                                    this_DECIMAL_5=(Token)match(input,RULE_DECIMAL,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleNumber"


    // $ANTLR start "entryRuleJvmTypeReference"
    // PsiInternalPureXbase.g:4474:1: entryRuleJvmTypeReference : ruleJvmTypeReference EOF ;
    public final void entryRuleJvmTypeReference() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:4474:26: ( ruleJvmTypeReference EOF )
            // PsiInternalPureXbase.g:4475:2: ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmTypeReferenceElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJvmTypeReference"


    // $ANTLR start "ruleJvmTypeReference"
    // PsiInternalPureXbase.g:4480:1: ruleJvmTypeReference : ( ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | ruleXFunctionTypeRef ) ;
    public final void ruleJvmTypeReference() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:4480:21: ( ( ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | ruleXFunctionTypeRef ) )
            // PsiInternalPureXbase.g:4481:2: ( ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | ruleXFunctionTypeRef )
            {
            // PsiInternalPureXbase.g:4481:2: ( ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | ruleXFunctionTypeRef )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==RULE_ID) ) {
                alt95=1;
            }
            else if ( (LA95_0==33||LA95_0==50) ) {
                alt95=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // PsiInternalPureXbase.g:4482:3: ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    {
                    // PsiInternalPureXbase.g:4482:3: ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    // PsiInternalPureXbase.g:4483:4: ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getJvmTypeReference_JvmParameterizedTypeReferenceParserRuleCall_0_0ElementType());
                      			
                    }
                    pushFollow(FOLLOW_59);
                    ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneComposite();
                      			
                    }
                    // PsiInternalPureXbase.g:4490:4: ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
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
                    	    // PsiInternalPureXbase.g:4491:5: ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets )
                    	    {
                    	    // PsiInternalPureXbase.g:4497:5: ( () ruleArrayBrackets )
                    	    // PsiInternalPureXbase.g:4498:6: () ruleArrayBrackets
                    	    {
                    	    // PsiInternalPureXbase.g:4498:6: ()
                    	    // PsiInternalPureXbase.g:4499:7: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							precedeComposite(elementTypeProvider.getJvmTypeReference_JvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0ElementType());
                    	      							doneComposite();
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						markComposite(elementTypeProvider.getJvmTypeReference_ArrayBracketsParserRuleCall_0_1_0_1ElementType());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_59);
                    	    ruleArrayBrackets();

                    	    state._fsp--;
                    	    if (state.failed) return ;
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
                    // PsiInternalPureXbase.g:4515:3: ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getJvmTypeReference_XFunctionTypeRefParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleXFunctionTypeRef();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

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
        return ;
    }
    // $ANTLR end "ruleJvmTypeReference"


    // $ANTLR start "entryRuleArrayBrackets"
    // PsiInternalPureXbase.g:4526:1: entryRuleArrayBrackets : ruleArrayBrackets EOF ;
    public final void entryRuleArrayBrackets() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:4526:23: ( ruleArrayBrackets EOF )
            // PsiInternalPureXbase.g:4527:2: ruleArrayBrackets EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getArrayBracketsElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleArrayBrackets();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleArrayBrackets"


    // $ANTLR start "ruleArrayBrackets"
    // PsiInternalPureXbase.g:4532:1: ruleArrayBrackets : (kw= '[' kw= ']' ) ;
    public final void ruleArrayBrackets() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalPureXbase.g:4532:18: ( (kw= '[' kw= ']' ) )
            // PsiInternalPureXbase.g:4533:2: (kw= '[' kw= ']' )
            {
            // PsiInternalPureXbase.g:4533:2: (kw= '[' kw= ']' )
            // PsiInternalPureXbase.g:4534:3: kw= '[' kw= ']'
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getArrayBrackets_LeftSquareBracketKeyword_0ElementType());
              		
            }
            kw=(Token)match(input,55,FOLLOW_42); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getArrayBrackets_RightSquareBracketKeyword_1ElementType());
              		
            }
            kw=(Token)match(input,56,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleArrayBrackets"


    // $ANTLR start "entryRuleXFunctionTypeRef"
    // PsiInternalPureXbase.g:4552:1: entryRuleXFunctionTypeRef : ruleXFunctionTypeRef EOF ;
    public final void entryRuleXFunctionTypeRef() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:4552:26: ( ruleXFunctionTypeRef EOF )
            // PsiInternalPureXbase.g:4553:2: ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXFunctionTypeRefElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXFunctionTypeRef"


    // $ANTLR start "ruleXFunctionTypeRef"
    // PsiInternalPureXbase.g:4558:1: ruleXFunctionTypeRef : ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleXFunctionTypeRef() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

        try {
            // PsiInternalPureXbase.g:4558:21: ( ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // PsiInternalPureXbase.g:4559:2: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // PsiInternalPureXbase.g:4559:2: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // PsiInternalPureXbase.g:4560:3: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // PsiInternalPureXbase.g:4560:3: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==50) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // PsiInternalPureXbase.g:4561:4: otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXFunctionTypeRef_LeftParenthesisKeyword_0_0ElementType());
                      			
                    }
                    otherlv_0=(Token)match(input,50,FOLLOW_66); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_0);
                      			
                    }
                    // PsiInternalPureXbase.g:4568:4: ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )?
                    int alt97=2;
                    int LA97_0 = input.LA(1);

                    if ( (LA97_0==RULE_ID||LA97_0==33||LA97_0==50) ) {
                        alt97=1;
                    }
                    switch (alt97) {
                        case 1 :
                            // PsiInternalPureXbase.g:4569:5: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            {
                            // PsiInternalPureXbase.g:4569:5: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                            // PsiInternalPureXbase.g:4570:6: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            {
                            // PsiInternalPureXbase.g:4570:6: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            // PsiInternalPureXbase.g:4571:7: lv_paramTypes_1_0= ruleJvmTypeReference
                            {
                            if ( state.backtracking==0 ) {

                              							markComposite(elementTypeProvider.getXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0ElementType());
                              						
                            }
                            pushFollow(FOLLOW_32);
                            ruleJvmTypeReference();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneComposite();
                              						
                            }

                            }


                            }

                            // PsiInternalPureXbase.g:4580:5: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            loop96:
                            do {
                                int alt96=2;
                                int LA96_0 = input.LA(1);

                                if ( (LA96_0==49) ) {
                                    alt96=1;
                                }


                                switch (alt96) {
                            	case 1 :
                            	    // PsiInternalPureXbase.g:4581:6: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      						markLeaf(elementTypeProvider.getXFunctionTypeRef_CommaKeyword_0_1_1_0ElementType());
                            	      					
                            	    }
                            	    otherlv_2=(Token)match(input,49,FOLLOW_15); if (state.failed) return ;
                            	    if ( state.backtracking==0 ) {

                            	      						doneLeaf(otherlv_2);
                            	      					
                            	    }
                            	    // PsiInternalPureXbase.g:4588:6: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    // PsiInternalPureXbase.g:4589:7: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    {
                            	    // PsiInternalPureXbase.g:4589:7: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    // PsiInternalPureXbase.g:4590:8: lv_paramTypes_3_0= ruleJvmTypeReference
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								markComposite(elementTypeProvider.getXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0ElementType());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_32);
                            	    ruleJvmTypeReference();

                            	    state._fsp--;
                            	    if (state.failed) return ;
                            	    if ( state.backtracking==0 ) {

                            	      								doneComposite();
                            	      							
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
                    otherlv_4=(Token)match(input,51,FOLLOW_67); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_4);
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXFunctionTypeRef_EqualsSignGreaterThanSignKeyword_1ElementType());
              		
            }
            otherlv_5=(Token)match(input,33,FOLLOW_15); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_5);
              		
            }
            // PsiInternalPureXbase.g:4616:3: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // PsiInternalPureXbase.g:4617:4: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // PsiInternalPureXbase.g:4617:4: (lv_returnType_6_0= ruleJvmTypeReference )
            // PsiInternalPureXbase.g:4618:5: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXFunctionTypeRef_ReturnTypeJvmTypeReferenceParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
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
        return ;
    }
    // $ANTLR end "ruleXFunctionTypeRef"


    // $ANTLR start "entryRuleJvmParameterizedTypeReference"
    // PsiInternalPureXbase.g:4631:1: entryRuleJvmParameterizedTypeReference : ruleJvmParameterizedTypeReference EOF ;
    public final void entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:4631:39: ( ruleJvmParameterizedTypeReference EOF )
            // PsiInternalPureXbase.g:4632:2: ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmParameterizedTypeReferenceElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJvmParameterizedTypeReference"


    // $ANTLR start "ruleJvmParameterizedTypeReference"
    // PsiInternalPureXbase.g:4637:1: ruleJvmParameterizedTypeReference : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) ;
    public final void ruleJvmParameterizedTypeReference() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;

        try {
            // PsiInternalPureXbase.g:4637:34: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) )
            // PsiInternalPureXbase.g:4638:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
            {
            // PsiInternalPureXbase.g:4638:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
            // PsiInternalPureXbase.g:4639:3: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
            {
            // PsiInternalPureXbase.g:4639:3: ( ( ruleQualifiedName ) )
            // PsiInternalPureXbase.g:4640:4: ( ruleQualifiedName )
            {
            // PsiInternalPureXbase.g:4640:4: ( ruleQualifiedName )
            // PsiInternalPureXbase.g:4641:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmParameterizedTypeReference_TypeJvmTypeCrossReference_0_0ElementType());
              				
            }
            pushFollow(FOLLOW_68);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // PsiInternalPureXbase.g:4650:3: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
            int alt103=2;
            alt103 = dfa103.predict(input);
            switch (alt103) {
                case 1 :
                    // PsiInternalPureXbase.g:4651:4: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
                    {
                    // PsiInternalPureXbase.g:4651:4: ( ( '<' )=>otherlv_1= '<' )
                    // PsiInternalPureXbase.g:4652:5: ( '<' )=>otherlv_1= '<'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_LessThanSignKeyword_1_0ElementType());
                      				
                    }
                    otherlv_1=(Token)match(input,20,FOLLOW_27); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1);
                      				
                    }

                    }

                    // PsiInternalPureXbase.g:4661:4: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // PsiInternalPureXbase.g:4662:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // PsiInternalPureXbase.g:4662:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // PsiInternalPureXbase.g:4663:6: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_28);
                    ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:4672:4: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop99:
                    do {
                        int alt99=2;
                        int LA99_0 = input.LA(1);

                        if ( (LA99_0==49) ) {
                            alt99=1;
                        }


                        switch (alt99) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:4673:5: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_CommaKeyword_1_2_0ElementType());
                    	      				
                    	    }
                    	    otherlv_3=(Token)match(input,49,FOLLOW_27); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_3);
                    	      				
                    	    }
                    	    // PsiInternalPureXbase.g:4680:5: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // PsiInternalPureXbase.g:4681:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // PsiInternalPureXbase.g:4681:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // PsiInternalPureXbase.g:4682:7: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_28);
                    	    ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      						
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
                    otherlv_5=(Token)match(input,21,FOLLOW_64); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_5);
                      			
                    }
                    // PsiInternalPureXbase.g:4699:4: ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
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
                    	    // PsiInternalPureXbase.g:4700:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
                    	    {
                    	    // PsiInternalPureXbase.g:4700:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) )
                    	    // PsiInternalPureXbase.g:4701:6: ( ( () '.' ) )=> ( () otherlv_7= '.' )
                    	    {
                    	    // PsiInternalPureXbase.g:4707:6: ( () otherlv_7= '.' )
                    	    // PsiInternalPureXbase.g:4708:7: () otherlv_7= '.'
                    	    {
                    	    // PsiInternalPureXbase.g:4708:7: ()
                    	    // PsiInternalPureXbase.g:4709:8: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								precedeComposite(elementTypeProvider.getJvmParameterizedTypeReference_JvmInnerTypeReferenceOuterAction_1_4_0_0_0ElementType());
                    	      								doneComposite();
                    	      							
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      							markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_FullStopKeyword_1_4_0_0_1ElementType());
                    	      						
                    	    }
                    	    otherlv_7=(Token)match(input,46,FOLLOW_25); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneLeaf(otherlv_7);
                    	      						
                    	    }

                    	    }


                    	    }

                    	    // PsiInternalPureXbase.g:4723:5: ( ( ruleValidID ) )
                    	    // PsiInternalPureXbase.g:4724:6: ( ruleValidID )
                    	    {
                    	    // PsiInternalPureXbase.g:4724:6: ( ruleValidID )
                    	    // PsiInternalPureXbase.g:4725:7: ruleValidID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmParameterizedTypeReference_TypeJvmTypeCrossReference_1_4_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_69);
                    	    ruleValidID();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      						
                    	    }

                    	    }


                    	    }

                    	    // PsiInternalPureXbase.g:4734:5: ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
                    	    int alt101=2;
                    	    alt101 = dfa101.predict(input);
                    	    switch (alt101) {
                    	        case 1 :
                    	            // PsiInternalPureXbase.g:4735:6: ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>'
                    	            {
                    	            // PsiInternalPureXbase.g:4735:6: ( ( '<' )=>otherlv_9= '<' )
                    	            // PsiInternalPureXbase.g:4736:7: ( '<' )=>otherlv_9= '<'
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              							markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_LessThanSignKeyword_1_4_2_0ElementType());
                    	              						
                    	            }
                    	            otherlv_9=(Token)match(input,20,FOLLOW_27); if (state.failed) return ;
                    	            if ( state.backtracking==0 ) {

                    	              							doneLeaf(otherlv_9);
                    	              						
                    	            }

                    	            }

                    	            // PsiInternalPureXbase.g:4745:6: ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) )
                    	            // PsiInternalPureXbase.g:4746:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
                    	            {
                    	            // PsiInternalPureXbase.g:4746:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
                    	            // PsiInternalPureXbase.g:4747:8: lv_arguments_10_0= ruleJvmArgumentTypeReference
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0ElementType());
                    	              							
                    	            }
                    	            pushFollow(FOLLOW_28);
                    	            ruleJvmArgumentTypeReference();

                    	            state._fsp--;
                    	            if (state.failed) return ;
                    	            if ( state.backtracking==0 ) {

                    	              								doneComposite();
                    	              							
                    	            }

                    	            }


                    	            }

                    	            // PsiInternalPureXbase.g:4756:6: (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )*
                    	            loop100:
                    	            do {
                    	                int alt100=2;
                    	                int LA100_0 = input.LA(1);

                    	                if ( (LA100_0==49) ) {
                    	                    alt100=1;
                    	                }


                    	                switch (alt100) {
                    	            	case 1 :
                    	            	    // PsiInternalPureXbase.g:4757:7: otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
                    	            	    {
                    	            	    if ( state.backtracking==0 ) {

                    	            	      							markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_CommaKeyword_1_4_2_2_0ElementType());
                    	            	      						
                    	            	    }
                    	            	    otherlv_11=(Token)match(input,49,FOLLOW_27); if (state.failed) return ;
                    	            	    if ( state.backtracking==0 ) {

                    	            	      							doneLeaf(otherlv_11);
                    	            	      						
                    	            	    }
                    	            	    // PsiInternalPureXbase.g:4764:7: ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
                    	            	    // PsiInternalPureXbase.g:4765:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
                    	            	    {
                    	            	    // PsiInternalPureXbase.g:4765:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
                    	            	    // PsiInternalPureXbase.g:4766:9: lv_arguments_12_0= ruleJvmArgumentTypeReference
                    	            	    {
                    	            	    if ( state.backtracking==0 ) {

                    	            	      									markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0ElementType());
                    	            	      								
                    	            	    }
                    	            	    pushFollow(FOLLOW_28);
                    	            	    ruleJvmArgumentTypeReference();

                    	            	    state._fsp--;
                    	            	    if (state.failed) return ;
                    	            	    if ( state.backtracking==0 ) {

                    	            	      									doneComposite();
                    	            	      								
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
                    	            otherlv_13=(Token)match(input,21,FOLLOW_64); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleJvmParameterizedTypeReference"


    // $ANTLR start "entryRuleJvmArgumentTypeReference"
    // PsiInternalPureXbase.g:4790:1: entryRuleJvmArgumentTypeReference : ruleJvmArgumentTypeReference EOF ;
    public final void entryRuleJvmArgumentTypeReference() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:4790:34: ( ruleJvmArgumentTypeReference EOF )
            // PsiInternalPureXbase.g:4791:2: ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmArgumentTypeReferenceElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJvmArgumentTypeReference"


    // $ANTLR start "ruleJvmArgumentTypeReference"
    // PsiInternalPureXbase.g:4796:1: ruleJvmArgumentTypeReference : ( ruleJvmTypeReference | ruleJvmWildcardTypeReference ) ;
    public final void ruleJvmArgumentTypeReference() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:4796:29: ( ( ruleJvmTypeReference | ruleJvmWildcardTypeReference ) )
            // PsiInternalPureXbase.g:4797:2: ( ruleJvmTypeReference | ruleJvmWildcardTypeReference )
            {
            // PsiInternalPureXbase.g:4797:2: ( ruleJvmTypeReference | ruleJvmWildcardTypeReference )
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==RULE_ID||LA104_0==33||LA104_0==50) ) {
                alt104=1;
            }
            else if ( (LA104_0==81) ) {
                alt104=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }
            switch (alt104) {
                case 1 :
                    // PsiInternalPureXbase.g:4798:3: ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getJvmArgumentTypeReference_JvmTypeReferenceParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalPureXbase.g:4806:3: ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getJvmArgumentTypeReference_JvmWildcardTypeReferenceParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleJvmWildcardTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

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
        return ;
    }
    // $ANTLR end "ruleJvmArgumentTypeReference"


    // $ANTLR start "entryRuleJvmWildcardTypeReference"
    // PsiInternalPureXbase.g:4817:1: entryRuleJvmWildcardTypeReference : ruleJvmWildcardTypeReference EOF ;
    public final void entryRuleJvmWildcardTypeReference() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:4817:34: ( ruleJvmWildcardTypeReference EOF )
            // PsiInternalPureXbase.g:4818:2: ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmWildcardTypeReferenceElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJvmWildcardTypeReference"


    // $ANTLR start "ruleJvmWildcardTypeReference"
    // PsiInternalPureXbase.g:4823:1: ruleJvmWildcardTypeReference : ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) ;
    public final void ruleJvmWildcardTypeReference() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // PsiInternalPureXbase.g:4823:29: ( ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) )
            // PsiInternalPureXbase.g:4824:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
            {
            // PsiInternalPureXbase.g:4824:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
            // PsiInternalPureXbase.g:4825:3: () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
            {
            // PsiInternalPureXbase.g:4825:3: ()
            // PsiInternalPureXbase.g:4826:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getJvmWildcardTypeReference_JvmWildcardTypeReferenceAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getJvmWildcardTypeReference_QuestionMarkKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,81,FOLLOW_70); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalPureXbase.g:4838:3: ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
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
                    // PsiInternalPureXbase.g:4839:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
                    {
                    // PsiInternalPureXbase.g:4839:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
                    // PsiInternalPureXbase.g:4840:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
                    {
                    // PsiInternalPureXbase.g:4840:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // PsiInternalPureXbase.g:4841:6: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // PsiInternalPureXbase.g:4841:6: (lv_constraints_2_0= ruleJvmUpperBound )
                    // PsiInternalPureXbase.g:4842:7: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmUpperBoundParserRuleCall_2_0_0_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_71);
                    ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:4851:5: ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
                    loop105:
                    do {
                        int alt105=2;
                        int LA105_0 = input.LA(1);

                        if ( (LA105_0==83) ) {
                            alt105=1;
                        }


                        switch (alt105) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:4852:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
                    	    {
                    	    // PsiInternalPureXbase.g:4852:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
                    	    // PsiInternalPureXbase.g:4853:7: lv_constraints_3_0= ruleJvmUpperBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_71);
                    	    ruleJvmUpperBoundAnded();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      						
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
                    // PsiInternalPureXbase.g:4864:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
                    {
                    // PsiInternalPureXbase.g:4864:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
                    // PsiInternalPureXbase.g:4865:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
                    {
                    // PsiInternalPureXbase.g:4865:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) )
                    // PsiInternalPureXbase.g:4866:6: (lv_constraints_4_0= ruleJvmLowerBound )
                    {
                    // PsiInternalPureXbase.g:4866:6: (lv_constraints_4_0= ruleJvmLowerBound )
                    // PsiInternalPureXbase.g:4867:7: lv_constraints_4_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmLowerBoundParserRuleCall_2_1_0_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_71);
                    ruleJvmLowerBound();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:4876:5: ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
                    loop106:
                    do {
                        int alt106=2;
                        int LA106_0 = input.LA(1);

                        if ( (LA106_0==83) ) {
                            alt106=1;
                        }


                        switch (alt106) {
                    	case 1 :
                    	    // PsiInternalPureXbase.g:4877:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
                    	    {
                    	    // PsiInternalPureXbase.g:4877:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
                    	    // PsiInternalPureXbase.g:4878:7: lv_constraints_5_0= ruleJvmLowerBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_71);
                    	    ruleJvmLowerBoundAnded();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      						
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
        return ;
    }
    // $ANTLR end "ruleJvmWildcardTypeReference"


    // $ANTLR start "entryRuleJvmUpperBound"
    // PsiInternalPureXbase.g:4893:1: entryRuleJvmUpperBound : ruleJvmUpperBound EOF ;
    public final void entryRuleJvmUpperBound() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:4893:23: ( ruleJvmUpperBound EOF )
            // PsiInternalPureXbase.g:4894:2: ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmUpperBoundElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJvmUpperBound"


    // $ANTLR start "ruleJvmUpperBound"
    // PsiInternalPureXbase.g:4899:1: ruleJvmUpperBound : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleJvmUpperBound() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalPureXbase.g:4899:18: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // PsiInternalPureXbase.g:4900:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // PsiInternalPureXbase.g:4900:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // PsiInternalPureXbase.g:4901:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getJvmUpperBound_ExtendsKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,82,FOLLOW_15); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalPureXbase.g:4908:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // PsiInternalPureXbase.g:4909:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // PsiInternalPureXbase.g:4909:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // PsiInternalPureXbase.g:4910:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmUpperBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
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
        return ;
    }
    // $ANTLR end "ruleJvmUpperBound"


    // $ANTLR start "entryRuleJvmUpperBoundAnded"
    // PsiInternalPureXbase.g:4923:1: entryRuleJvmUpperBoundAnded : ruleJvmUpperBoundAnded EOF ;
    public final void entryRuleJvmUpperBoundAnded() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:4923:28: ( ruleJvmUpperBoundAnded EOF )
            // PsiInternalPureXbase.g:4924:2: ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmUpperBoundAndedElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJvmUpperBoundAnded"


    // $ANTLR start "ruleJvmUpperBoundAnded"
    // PsiInternalPureXbase.g:4929:1: ruleJvmUpperBoundAnded : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleJvmUpperBoundAnded() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalPureXbase.g:4929:23: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // PsiInternalPureXbase.g:4930:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // PsiInternalPureXbase.g:4930:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // PsiInternalPureXbase.g:4931:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getJvmUpperBoundAnded_AmpersandKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,83,FOLLOW_15); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalPureXbase.g:4938:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // PsiInternalPureXbase.g:4939:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // PsiInternalPureXbase.g:4939:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // PsiInternalPureXbase.g:4940:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmUpperBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
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
        return ;
    }
    // $ANTLR end "ruleJvmUpperBoundAnded"


    // $ANTLR start "entryRuleJvmLowerBound"
    // PsiInternalPureXbase.g:4953:1: entryRuleJvmLowerBound : ruleJvmLowerBound EOF ;
    public final void entryRuleJvmLowerBound() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:4953:23: ( ruleJvmLowerBound EOF )
            // PsiInternalPureXbase.g:4954:2: ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmLowerBoundElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJvmLowerBound"


    // $ANTLR start "ruleJvmLowerBound"
    // PsiInternalPureXbase.g:4959:1: ruleJvmLowerBound : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleJvmLowerBound() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalPureXbase.g:4959:18: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // PsiInternalPureXbase.g:4960:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // PsiInternalPureXbase.g:4960:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // PsiInternalPureXbase.g:4961:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getJvmLowerBound_SuperKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,69,FOLLOW_15); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalPureXbase.g:4968:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // PsiInternalPureXbase.g:4969:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // PsiInternalPureXbase.g:4969:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // PsiInternalPureXbase.g:4970:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmLowerBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
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
        return ;
    }
    // $ANTLR end "ruleJvmLowerBound"


    // $ANTLR start "entryRuleJvmLowerBoundAnded"
    // PsiInternalPureXbase.g:4983:1: entryRuleJvmLowerBoundAnded : ruleJvmLowerBoundAnded EOF ;
    public final void entryRuleJvmLowerBoundAnded() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:4983:28: ( ruleJvmLowerBoundAnded EOF )
            // PsiInternalPureXbase.g:4984:2: ruleJvmLowerBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmLowerBoundAndedElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleJvmLowerBoundAnded();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJvmLowerBoundAnded"


    // $ANTLR start "ruleJvmLowerBoundAnded"
    // PsiInternalPureXbase.g:4989:1: ruleJvmLowerBoundAnded : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleJvmLowerBoundAnded() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalPureXbase.g:4989:23: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // PsiInternalPureXbase.g:4990:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // PsiInternalPureXbase.g:4990:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // PsiInternalPureXbase.g:4991:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getJvmLowerBoundAnded_AmpersandKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,83,FOLLOW_15); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalPureXbase.g:4998:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // PsiInternalPureXbase.g:4999:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // PsiInternalPureXbase.g:4999:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // PsiInternalPureXbase.g:5000:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmLowerBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
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
        return ;
    }
    // $ANTLR end "ruleJvmLowerBoundAnded"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // PsiInternalPureXbase.g:5013:1: entryRuleQualifiedNameWithWildcard : ruleQualifiedNameWithWildcard EOF ;
    public final void entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:5013:35: ( ruleQualifiedNameWithWildcard EOF )
            // PsiInternalPureXbase.g:5014:2: ruleQualifiedNameWithWildcard EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getQualifiedNameWithWildcardElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleQualifiedNameWithWildcard();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // PsiInternalPureXbase.g:5019:1: ruleQualifiedNameWithWildcard : ( ruleQualifiedName kw= '.' kw= '*' ) ;
    public final void ruleQualifiedNameWithWildcard() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalPureXbase.g:5019:30: ( ( ruleQualifiedName kw= '.' kw= '*' ) )
            // PsiInternalPureXbase.g:5020:2: ( ruleQualifiedName kw= '.' kw= '*' )
            {
            // PsiInternalPureXbase.g:5020:2: ( ruleQualifiedName kw= '.' kw= '*' )
            // PsiInternalPureXbase.g:5021:3: ruleQualifiedName kw= '.' kw= '*'
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getQualifiedNameWithWildcard_QualifiedNameParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_72);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getQualifiedNameWithWildcard_FullStopKeyword_1ElementType());
              		
            }
            kw=(Token)match(input,46,FOLLOW_73); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getQualifiedNameWithWildcard_AsteriskKeyword_2ElementType());
              		
            }
            kw=(Token)match(input,38,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "entryRuleValidID"
    // PsiInternalPureXbase.g:5046:1: entryRuleValidID : ruleValidID EOF ;
    public final void entryRuleValidID() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:5046:17: ( ruleValidID EOF )
            // PsiInternalPureXbase.g:5047:2: ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getValidIDElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // PsiInternalPureXbase.g:5052:1: ruleValidID : this_ID_0= RULE_ID ;
    public final void ruleValidID() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // PsiInternalPureXbase.g:5052:12: (this_ID_0= RULE_ID )
            // PsiInternalPureXbase.g:5053:2: this_ID_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getValidID_IDTerminalRuleCallElementType());
              	
            }
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleValidID"


    // $ANTLR start "entryRuleXImportSection"
    // PsiInternalPureXbase.g:5063:1: entryRuleXImportSection : ruleXImportSection EOF ;
    public final void entryRuleXImportSection() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:5063:24: ( ruleXImportSection EOF )
            // PsiInternalPureXbase.g:5064:2: ruleXImportSection EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXImportSectionElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXImportSection();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXImportSection"


    // $ANTLR start "ruleXImportSection"
    // PsiInternalPureXbase.g:5069:1: ruleXImportSection : ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+ ;
    public final void ruleXImportSection() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:5069:19: ( ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+ )
            // PsiInternalPureXbase.g:5070:2: ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+
            {
            // PsiInternalPureXbase.g:5070:2: ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+
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
            	    // PsiInternalPureXbase.g:5071:3: (lv_importDeclarations_0_0= ruleXImportDeclaration )
            	    {
            	    // PsiInternalPureXbase.g:5071:3: (lv_importDeclarations_0_0= ruleXImportDeclaration )
            	    // PsiInternalPureXbase.g:5072:4: lv_importDeclarations_0_0= ruleXImportDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markComposite(elementTypeProvider.getXImportSection_ImportDeclarationsXImportDeclarationParserRuleCall_0ElementType());
            	      			
            	    }
            	    pushFollow(FOLLOW_74);
            	    ruleXImportDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneComposite();
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt108 >= 1 ) break loop108;
            	    if (state.backtracking>0) {state.failed=true; return ;}
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
        return ;
    }
    // $ANTLR end "ruleXImportSection"


    // $ANTLR start "entryRuleXImportDeclaration"
    // PsiInternalPureXbase.g:5084:1: entryRuleXImportDeclaration : ruleXImportDeclaration EOF ;
    public final void entryRuleXImportDeclaration() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:5084:28: ( ruleXImportDeclaration EOF )
            // PsiInternalPureXbase.g:5085:2: ruleXImportDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXImportDeclarationElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleXImportDeclaration();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXImportDeclaration"


    // $ANTLR start "ruleXImportDeclaration"
    // PsiInternalPureXbase.g:5090:1: ruleXImportDeclaration : (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) ;
    public final void ruleXImportDeclaration() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_static_1_0=null;
        Token lv_extension_2_0=null;
        Token lv_wildcard_4_0=null;
        Token otherlv_8=null;

        try {
            // PsiInternalPureXbase.g:5090:23: ( (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) )
            // PsiInternalPureXbase.g:5091:2: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
            {
            // PsiInternalPureXbase.g:5091:2: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
            // PsiInternalPureXbase.g:5092:3: otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )?
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXImportDeclaration_ImportKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,84,FOLLOW_75); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalPureXbase.g:5099:3: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )
            int alt111=3;
            alt111 = dfa111.predict(input);
            switch (alt111) {
                case 1 :
                    // PsiInternalPureXbase.g:5100:4: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
                    {
                    // PsiInternalPureXbase.g:5100:4: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
                    // PsiInternalPureXbase.g:5101:5: ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
                    {
                    // PsiInternalPureXbase.g:5101:5: ( (lv_static_1_0= 'static' ) )
                    // PsiInternalPureXbase.g:5102:6: (lv_static_1_0= 'static' )
                    {
                    // PsiInternalPureXbase.g:5102:6: (lv_static_1_0= 'static' )
                    // PsiInternalPureXbase.g:5103:7: lv_static_1_0= 'static'
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getXImportDeclaration_StaticStaticKeyword_1_0_0_0ElementType());
                      						
                    }
                    lv_static_1_0=(Token)match(input,85,FOLLOW_76); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(lv_static_1_0);
                      						
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:5112:5: ( (lv_extension_2_0= 'extension' ) )?
                    int alt109=2;
                    int LA109_0 = input.LA(1);

                    if ( (LA109_0==86) ) {
                        alt109=1;
                    }
                    switch (alt109) {
                        case 1 :
                            // PsiInternalPureXbase.g:5113:6: (lv_extension_2_0= 'extension' )
                            {
                            // PsiInternalPureXbase.g:5113:6: (lv_extension_2_0= 'extension' )
                            // PsiInternalPureXbase.g:5114:7: lv_extension_2_0= 'extension'
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getXImportDeclaration_ExtensionExtensionKeyword_1_0_1_0ElementType());
                              						
                            }
                            lv_extension_2_0=(Token)match(input,86,FOLLOW_76); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(lv_extension_2_0);
                              						
                            }

                            }


                            }
                            break;

                    }

                    // PsiInternalPureXbase.g:5123:5: ( ( ruleQualifiedNameInStaticImport ) )
                    // PsiInternalPureXbase.g:5124:6: ( ruleQualifiedNameInStaticImport )
                    {
                    // PsiInternalPureXbase.g:5124:6: ( ruleQualifiedNameInStaticImport )
                    // PsiInternalPureXbase.g:5125:7: ruleQualifiedNameInStaticImport
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_77);
                    ruleQualifiedNameInStaticImport();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }

                    // PsiInternalPureXbase.g:5134:5: ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
                    int alt110=2;
                    int LA110_0 = input.LA(1);

                    if ( (LA110_0==38) ) {
                        alt110=1;
                    }
                    else if ( (LA110_0==RULE_ID) ) {
                        alt110=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 110, 0, input);

                        throw nvae;
                    }
                    switch (alt110) {
                        case 1 :
                            // PsiInternalPureXbase.g:5135:6: ( (lv_wildcard_4_0= '*' ) )
                            {
                            // PsiInternalPureXbase.g:5135:6: ( (lv_wildcard_4_0= '*' ) )
                            // PsiInternalPureXbase.g:5136:7: (lv_wildcard_4_0= '*' )
                            {
                            // PsiInternalPureXbase.g:5136:7: (lv_wildcard_4_0= '*' )
                            // PsiInternalPureXbase.g:5137:8: lv_wildcard_4_0= '*'
                            {
                            if ( state.backtracking==0 ) {

                              								markLeaf(elementTypeProvider.getXImportDeclaration_WildcardAsteriskKeyword_1_0_3_0_0ElementType());
                              							
                            }
                            lv_wildcard_4_0=(Token)match(input,38,FOLLOW_78); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              								doneLeaf(lv_wildcard_4_0);
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalPureXbase.g:5147:6: ( (lv_memberName_5_0= ruleValidID ) )
                            {
                            // PsiInternalPureXbase.g:5147:6: ( (lv_memberName_5_0= ruleValidID ) )
                            // PsiInternalPureXbase.g:5148:7: (lv_memberName_5_0= ruleValidID )
                            {
                            // PsiInternalPureXbase.g:5148:7: (lv_memberName_5_0= ruleValidID )
                            // PsiInternalPureXbase.g:5149:8: lv_memberName_5_0= ruleValidID
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getXImportDeclaration_MemberNameValidIDParserRuleCall_1_0_3_1_0ElementType());
                              							
                            }
                            pushFollow(FOLLOW_78);
                            ruleValidID();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              							
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
                    // PsiInternalPureXbase.g:5161:4: ( ( ruleQualifiedName ) )
                    {
                    // PsiInternalPureXbase.g:5161:4: ( ( ruleQualifiedName ) )
                    // PsiInternalPureXbase.g:5162:5: ( ruleQualifiedName )
                    {
                    // PsiInternalPureXbase.g:5162:5: ( ruleQualifiedName )
                    // PsiInternalPureXbase.g:5163:6: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_78);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalPureXbase.g:5173:4: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
                    {
                    // PsiInternalPureXbase.g:5173:4: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
                    // PsiInternalPureXbase.g:5174:5: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
                    {
                    // PsiInternalPureXbase.g:5174:5: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
                    // PsiInternalPureXbase.g:5175:6: lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXImportDeclaration_ImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_78);
                    ruleQualifiedNameWithWildcard();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalPureXbase.g:5185:3: (otherlv_8= ';' )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==13) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // PsiInternalPureXbase.g:5186:4: otherlv_8= ';'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXImportDeclaration_SemicolonKeyword_2ElementType());
                      			
                    }
                    otherlv_8=(Token)match(input,13,FOLLOW_2); if (state.failed) return ;
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
        return ;
    }
    // $ANTLR end "ruleXImportDeclaration"


    // $ANTLR start "entryRuleQualifiedNameInStaticImport"
    // PsiInternalPureXbase.g:5198:1: entryRuleQualifiedNameInStaticImport : ruleQualifiedNameInStaticImport EOF ;
    public final void entryRuleQualifiedNameInStaticImport() throws RecognitionException {
        try {
            // PsiInternalPureXbase.g:5198:37: ( ruleQualifiedNameInStaticImport EOF )
            // PsiInternalPureXbase.g:5199:2: ruleQualifiedNameInStaticImport EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getQualifiedNameInStaticImportElementType()); 
            }
            pushFollow(FOLLOW_1);
            ruleQualifiedNameInStaticImport();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedNameInStaticImport"


    // $ANTLR start "ruleQualifiedNameInStaticImport"
    // PsiInternalPureXbase.g:5204:1: ruleQualifiedNameInStaticImport : ( ruleValidID kw= '.' )+ ;
    public final void ruleQualifiedNameInStaticImport() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalPureXbase.g:5204:32: ( ( ruleValidID kw= '.' )+ )
            // PsiInternalPureXbase.g:5205:2: ( ruleValidID kw= '.' )+
            {
            // PsiInternalPureXbase.g:5205:2: ( ruleValidID kw= '.' )+
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
            	    // PsiInternalPureXbase.g:5206:3: ruleValidID kw= '.'
            	    {
            	    if ( state.backtracking==0 ) {

            	      			markComposite(elementTypeProvider.getQualifiedNameInStaticImport_ValidIDParserRuleCall_0ElementType());
            	      		
            	    }
            	    pushFollow(FOLLOW_72);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      			doneComposite();
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			markLeaf(elementTypeProvider.getQualifiedNameInStaticImport_FullStopKeyword_1ElementType());
            	      		
            	    }
            	    kw=(Token)match(input,46,FOLLOW_79); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      			doneLeaf(kw);
            	      		
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt113 >= 1 ) break loop113;
            	    if (state.backtracking>0) {state.failed=true; return ;}
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
        return ;
    }
    // $ANTLR end "ruleQualifiedNameInStaticImport"

    // $ANTLR start synpred1_PsiInternalPureXbase
    public final void synpred1_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:216:6: ( ( () ( ( ruleOpMultiAssign ) ) ) )
        // PsiInternalPureXbase.g:216:7: ( () ( ( ruleOpMultiAssign ) ) )
        {
        // PsiInternalPureXbase.g:216:7: ( () ( ( ruleOpMultiAssign ) ) )
        // PsiInternalPureXbase.g:217:7: () ( ( ruleOpMultiAssign ) )
        {
        // PsiInternalPureXbase.g:217:7: ()
        // PsiInternalPureXbase.g:218:7: 
        {
        }

        // PsiInternalPureXbase.g:219:7: ( ( ruleOpMultiAssign ) )
        // PsiInternalPureXbase.g:220:8: ( ruleOpMultiAssign )
        {
        // PsiInternalPureXbase.g:220:8: ( ruleOpMultiAssign )
        // PsiInternalPureXbase.g:221:9: ruleOpMultiAssign
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
        // PsiInternalPureXbase.g:398:5: ( ( () ( ( ruleOpOr ) ) ) )
        // PsiInternalPureXbase.g:398:6: ( () ( ( ruleOpOr ) ) )
        {
        // PsiInternalPureXbase.g:398:6: ( () ( ( ruleOpOr ) ) )
        // PsiInternalPureXbase.g:399:6: () ( ( ruleOpOr ) )
        {
        // PsiInternalPureXbase.g:399:6: ()
        // PsiInternalPureXbase.g:400:6: 
        {
        }

        // PsiInternalPureXbase.g:401:6: ( ( ruleOpOr ) )
        // PsiInternalPureXbase.g:402:7: ( ruleOpOr )
        {
        // PsiInternalPureXbase.g:402:7: ( ruleOpOr )
        // PsiInternalPureXbase.g:403:8: ruleOpOr
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
        // PsiInternalPureXbase.g:478:5: ( ( () ( ( ruleOpAnd ) ) ) )
        // PsiInternalPureXbase.g:478:6: ( () ( ( ruleOpAnd ) ) )
        {
        // PsiInternalPureXbase.g:478:6: ( () ( ( ruleOpAnd ) ) )
        // PsiInternalPureXbase.g:479:6: () ( ( ruleOpAnd ) )
        {
        // PsiInternalPureXbase.g:479:6: ()
        // PsiInternalPureXbase.g:480:6: 
        {
        }

        // PsiInternalPureXbase.g:481:6: ( ( ruleOpAnd ) )
        // PsiInternalPureXbase.g:482:7: ( ruleOpAnd )
        {
        // PsiInternalPureXbase.g:482:7: ( ruleOpAnd )
        // PsiInternalPureXbase.g:483:8: ruleOpAnd
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
        // PsiInternalPureXbase.g:558:5: ( ( () ( ( ruleOpEquality ) ) ) )
        // PsiInternalPureXbase.g:558:6: ( () ( ( ruleOpEquality ) ) )
        {
        // PsiInternalPureXbase.g:558:6: ( () ( ( ruleOpEquality ) ) )
        // PsiInternalPureXbase.g:559:6: () ( ( ruleOpEquality ) )
        {
        // PsiInternalPureXbase.g:559:6: ()
        // PsiInternalPureXbase.g:560:6: 
        {
        }

        // PsiInternalPureXbase.g:561:6: ( ( ruleOpEquality ) )
        // PsiInternalPureXbase.g:562:7: ( ruleOpEquality )
        {
        // PsiInternalPureXbase.g:562:7: ( ruleOpEquality )
        // PsiInternalPureXbase.g:563:8: ruleOpEquality
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
        // PsiInternalPureXbase.g:665:6: ( ( () 'instanceof' ) )
        // PsiInternalPureXbase.g:665:7: ( () 'instanceof' )
        {
        // PsiInternalPureXbase.g:665:7: ( () 'instanceof' )
        // PsiInternalPureXbase.g:666:7: () 'instanceof'
        {
        // PsiInternalPureXbase.g:666:7: ()
        // PsiInternalPureXbase.g:667:7: 
        {
        }

        match(input,29,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_PsiInternalPureXbase

    // $ANTLR start synpred6_PsiInternalPureXbase
    public final void synpred6_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:702:6: ( ( () ( ( ruleOpCompare ) ) ) )
        // PsiInternalPureXbase.g:702:7: ( () ( ( ruleOpCompare ) ) )
        {
        // PsiInternalPureXbase.g:702:7: ( () ( ( ruleOpCompare ) ) )
        // PsiInternalPureXbase.g:703:7: () ( ( ruleOpCompare ) )
        {
        // PsiInternalPureXbase.g:703:7: ()
        // PsiInternalPureXbase.g:704:7: 
        {
        }

        // PsiInternalPureXbase.g:705:7: ( ( ruleOpCompare ) )
        // PsiInternalPureXbase.g:706:8: ( ruleOpCompare )
        {
        // PsiInternalPureXbase.g:706:8: ( ruleOpCompare )
        // PsiInternalPureXbase.g:707:9: ruleOpCompare
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
        // PsiInternalPureXbase.g:818:5: ( ( () ( ( ruleOpOther ) ) ) )
        // PsiInternalPureXbase.g:818:6: ( () ( ( ruleOpOther ) ) )
        {
        // PsiInternalPureXbase.g:818:6: ( () ( ( ruleOpOther ) ) )
        // PsiInternalPureXbase.g:819:6: () ( ( ruleOpOther ) )
        {
        // PsiInternalPureXbase.g:819:6: ()
        // PsiInternalPureXbase.g:820:6: 
        {
        }

        // PsiInternalPureXbase.g:821:6: ( ( ruleOpOther ) )
        // PsiInternalPureXbase.g:822:7: ( ruleOpOther )
        {
        // PsiInternalPureXbase.g:822:7: ( ruleOpOther )
        // PsiInternalPureXbase.g:823:8: ruleOpOther
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
        // PsiInternalPureXbase.g:931:6: ( ( '>' '>' ) )
        // PsiInternalPureXbase.g:931:7: ( '>' '>' )
        {
        // PsiInternalPureXbase.g:931:7: ( '>' '>' )
        // PsiInternalPureXbase.g:932:7: '>' '>'
        {
        match(input,21,FOLLOW_18); if (state.failed) return ;
        match(input,21,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_PsiInternalPureXbase

    // $ANTLR start synpred9_PsiInternalPureXbase
    public final void synpred9_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:974:6: ( ( '<' '<' ) )
        // PsiInternalPureXbase.g:974:7: ( '<' '<' )
        {
        // PsiInternalPureXbase.g:974:7: ( '<' '<' )
        // PsiInternalPureXbase.g:975:7: '<' '<'
        {
        match(input,20,FOLLOW_8); if (state.failed) return ;
        match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred9_PsiInternalPureXbase

    // $ANTLR start synpred10_PsiInternalPureXbase
    public final void synpred10_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:1051:5: ( ( () ( ( ruleOpAdd ) ) ) )
        // PsiInternalPureXbase.g:1051:6: ( () ( ( ruleOpAdd ) ) )
        {
        // PsiInternalPureXbase.g:1051:6: ( () ( ( ruleOpAdd ) ) )
        // PsiInternalPureXbase.g:1052:6: () ( ( ruleOpAdd ) )
        {
        // PsiInternalPureXbase.g:1052:6: ()
        // PsiInternalPureXbase.g:1053:6: 
        {
        }

        // PsiInternalPureXbase.g:1054:6: ( ( ruleOpAdd ) )
        // PsiInternalPureXbase.g:1055:7: ( ruleOpAdd )
        {
        // PsiInternalPureXbase.g:1055:7: ( ruleOpAdd )
        // PsiInternalPureXbase.g:1056:8: ruleOpAdd
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
        // PsiInternalPureXbase.g:1141:5: ( ( () ( ( ruleOpMulti ) ) ) )
        // PsiInternalPureXbase.g:1141:6: ( () ( ( ruleOpMulti ) ) )
        {
        // PsiInternalPureXbase.g:1141:6: ( () ( ( ruleOpMulti ) ) )
        // PsiInternalPureXbase.g:1142:6: () ( ( ruleOpMulti ) )
        {
        // PsiInternalPureXbase.g:1142:6: ()
        // PsiInternalPureXbase.g:1143:6: 
        {
        }

        // PsiInternalPureXbase.g:1144:6: ( ( ruleOpMulti ) )
        // PsiInternalPureXbase.g:1145:7: ( ruleOpMulti )
        {
        // PsiInternalPureXbase.g:1145:7: ( ruleOpMulti )
        // PsiInternalPureXbase.g:1146:8: ruleOpMulti
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
        // PsiInternalPureXbase.g:1332:5: ( ( () 'as' ) )
        // PsiInternalPureXbase.g:1332:6: ( () 'as' )
        {
        // PsiInternalPureXbase.g:1332:6: ( () 'as' )
        // PsiInternalPureXbase.g:1333:6: () 'as'
        {
        // PsiInternalPureXbase.g:1333:6: ()
        // PsiInternalPureXbase.g:1334:6: 
        {
        }

        match(input,43,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred12_PsiInternalPureXbase

    // $ANTLR start synpred13_PsiInternalPureXbase
    public final void synpred13_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:1386:4: ( ( () ( ( ruleOpPostfix ) ) ) )
        // PsiInternalPureXbase.g:1386:5: ( () ( ( ruleOpPostfix ) ) )
        {
        // PsiInternalPureXbase.g:1386:5: ( () ( ( ruleOpPostfix ) ) )
        // PsiInternalPureXbase.g:1387:5: () ( ( ruleOpPostfix ) )
        {
        // PsiInternalPureXbase.g:1387:5: ()
        // PsiInternalPureXbase.g:1388:5: 
        {
        }

        // PsiInternalPureXbase.g:1389:5: ( ( ruleOpPostfix ) )
        // PsiInternalPureXbase.g:1390:6: ( ruleOpPostfix )
        {
        // PsiInternalPureXbase.g:1390:6: ( ruleOpPostfix )
        // PsiInternalPureXbase.g:1391:7: ruleOpPostfix
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
        // PsiInternalPureXbase.g:1465:6: ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
        // PsiInternalPureXbase.g:1465:7: ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
        {
        // PsiInternalPureXbase.g:1465:7: ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
        // PsiInternalPureXbase.g:1466:7: () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
        {
        // PsiInternalPureXbase.g:1466:7: ()
        // PsiInternalPureXbase.g:1467:7: 
        {
        }

        // PsiInternalPureXbase.g:1468:7: ( '.' | ( ( '::' ) ) )
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
                // PsiInternalPureXbase.g:1469:8: '.'
                {
                match(input,46,FOLLOW_25); if (state.failed) return ;

                }
                break;
            case 2 :
                // PsiInternalPureXbase.g:1471:8: ( ( '::' ) )
                {
                // PsiInternalPureXbase.g:1471:8: ( ( '::' ) )
                // PsiInternalPureXbase.g:1472:9: ( '::' )
                {
                // PsiInternalPureXbase.g:1472:9: ( '::' )
                // PsiInternalPureXbase.g:1473:10: '::'
                {
                match(input,47,FOLLOW_25); if (state.failed) return ;

                }


                }


                }
                break;

        }

        // PsiInternalPureXbase.g:1477:7: ( ( ruleFeatureCallID ) )
        // PsiInternalPureXbase.g:1478:8: ( ruleFeatureCallID )
        {
        // PsiInternalPureXbase.g:1478:8: ( ruleFeatureCallID )
        // PsiInternalPureXbase.g:1479:9: ruleFeatureCallID
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
        // PsiInternalPureXbase.g:1548:6: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )
        // PsiInternalPureXbase.g:1548:7: ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) )
        {
        // PsiInternalPureXbase.g:1548:7: ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) )
        // PsiInternalPureXbase.g:1549:7: () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) )
        {
        // PsiInternalPureXbase.g:1549:7: ()
        // PsiInternalPureXbase.g:1550:7: 
        {
        }

        // PsiInternalPureXbase.g:1551:7: ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) )
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
                // PsiInternalPureXbase.g:1552:8: '.'
                {
                match(input,46,FOLLOW_2); if (state.failed) return ;

                }
                break;
            case 2 :
                // PsiInternalPureXbase.g:1554:8: ( ( '?.' ) )
                {
                // PsiInternalPureXbase.g:1554:8: ( ( '?.' ) )
                // PsiInternalPureXbase.g:1555:9: ( '?.' )
                {
                // PsiInternalPureXbase.g:1555:9: ( '?.' )
                // PsiInternalPureXbase.g:1556:10: '?.'
                {
                match(input,48,FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;
            case 3 :
                // PsiInternalPureXbase.g:1560:8: ( ( '::' ) )
                {
                // PsiInternalPureXbase.g:1560:8: ( ( '::' ) )
                // PsiInternalPureXbase.g:1561:9: ( '::' )
                {
                // PsiInternalPureXbase.g:1561:9: ( '::' )
                // PsiInternalPureXbase.g:1562:10: '::'
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
        // PsiInternalPureXbase.g:1670:7: ( ( '(' ) )
        // PsiInternalPureXbase.g:1670:8: ( '(' )
        {
        // PsiInternalPureXbase.g:1670:8: ( '(' )
        // PsiInternalPureXbase.g:1671:8: '('
        {
        match(input,50,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred16_PsiInternalPureXbase

    // $ANTLR start synpred17_PsiInternalPureXbase
    public final void synpred17_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:1686:8: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // PsiInternalPureXbase.g:1686:9: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // PsiInternalPureXbase.g:1686:9: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // PsiInternalPureXbase.g:1687:9: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // PsiInternalPureXbase.g:1687:9: ()
        // PsiInternalPureXbase.g:1688:9: 
        {
        }

        // PsiInternalPureXbase.g:1689:9: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt117=2;
        int LA117_0 = input.LA(1);

        if ( (LA117_0==RULE_ID||LA117_0==33||LA117_0==50) ) {
            alt117=1;
        }
        switch (alt117) {
            case 1 :
                // PsiInternalPureXbase.g:1690:10: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // PsiInternalPureXbase.g:1690:10: ( ( ruleJvmFormalParameter ) )
                // PsiInternalPureXbase.g:1691:11: ( ruleJvmFormalParameter )
                {
                // PsiInternalPureXbase.g:1691:11: ( ruleJvmFormalParameter )
                // PsiInternalPureXbase.g:1692:12: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_41);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // PsiInternalPureXbase.g:1695:10: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop116:
                do {
                    int alt116=2;
                    int LA116_0 = input.LA(1);

                    if ( (LA116_0==49) ) {
                        alt116=1;
                    }


                    switch (alt116) {
                	case 1 :
                	    // PsiInternalPureXbase.g:1696:11: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,49,FOLLOW_15); if (state.failed) return ;
                	    // PsiInternalPureXbase.g:1697:11: ( ( ruleJvmFormalParameter ) )
                	    // PsiInternalPureXbase.g:1698:12: ( ruleJvmFormalParameter )
                	    {
                	    // PsiInternalPureXbase.g:1698:12: ( ruleJvmFormalParameter )
                	    // PsiInternalPureXbase.g:1699:13: ruleJvmFormalParameter
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

        // PsiInternalPureXbase.g:1704:9: ( ( '|' ) )
        // PsiInternalPureXbase.g:1705:10: ( '|' )
        {
        // PsiInternalPureXbase.g:1705:10: ( '|' )
        // PsiInternalPureXbase.g:1706:11: '|'
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
        // PsiInternalPureXbase.g:1765:6: ( ( () '[' ) )
        // PsiInternalPureXbase.g:1765:7: ( () '[' )
        {
        // PsiInternalPureXbase.g:1765:7: ( () '[' )
        // PsiInternalPureXbase.g:1766:7: () '['
        {
        // PsiInternalPureXbase.g:1766:7: ()
        // PsiInternalPureXbase.g:1767:7: 
        {
        }

        match(input,55,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred18_PsiInternalPureXbase

    // $ANTLR start synpred19_PsiInternalPureXbase
    public final void synpred19_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:1820:4: ( ( () 'synchronized' '(' ) )
        // PsiInternalPureXbase.g:1820:5: ( () 'synchronized' '(' )
        {
        // PsiInternalPureXbase.g:1820:5: ( () 'synchronized' '(' )
        // PsiInternalPureXbase.g:1821:5: () 'synchronized' '('
        {
        // PsiInternalPureXbase.g:1821:5: ()
        // PsiInternalPureXbase.g:1822:5: 
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
        // PsiInternalPureXbase.g:1861:4: ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )
        // PsiInternalPureXbase.g:1861:5: ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' )
        {
        // PsiInternalPureXbase.g:1861:5: ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' )
        // PsiInternalPureXbase.g:1862:5: () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':'
        {
        // PsiInternalPureXbase.g:1862:5: ()
        // PsiInternalPureXbase.g:1863:5: 
        {
        }

        match(input,64,FOLLOW_43); if (state.failed) return ;
        match(input,50,FOLLOW_15); if (state.failed) return ;
        // PsiInternalPureXbase.g:1866:5: ( ( ruleJvmFormalParameter ) )
        // PsiInternalPureXbase.g:1867:6: ( ruleJvmFormalParameter )
        {
        // PsiInternalPureXbase.g:1867:6: ( ruleJvmFormalParameter )
        // PsiInternalPureXbase.g:1868:7: ruleJvmFormalParameter
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
        // PsiInternalPureXbase.g:1959:4: ( ( () '[' ) )
        // PsiInternalPureXbase.g:1959:5: ( () '[' )
        {
        // PsiInternalPureXbase.g:1959:5: ( () '[' )
        // PsiInternalPureXbase.g:1960:5: () '['
        {
        // PsiInternalPureXbase.g:1960:5: ()
        // PsiInternalPureXbase.g:1961:5: 
        {
        }

        match(input,55,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred21_PsiInternalPureXbase

    // $ANTLR start synpred23_PsiInternalPureXbase
    public final void synpred23_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:2220:4: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // PsiInternalPureXbase.g:2220:5: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // PsiInternalPureXbase.g:2220:5: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // PsiInternalPureXbase.g:2221:5: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // PsiInternalPureXbase.g:2221:5: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt119=2;
        int LA119_0 = input.LA(1);

        if ( (LA119_0==RULE_ID||LA119_0==33||LA119_0==50) ) {
            alt119=1;
        }
        switch (alt119) {
            case 1 :
                // PsiInternalPureXbase.g:2222:6: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // PsiInternalPureXbase.g:2222:6: ( ( ruleJvmFormalParameter ) )
                // PsiInternalPureXbase.g:2223:7: ( ruleJvmFormalParameter )
                {
                // PsiInternalPureXbase.g:2223:7: ( ruleJvmFormalParameter )
                // PsiInternalPureXbase.g:2224:8: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_41);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // PsiInternalPureXbase.g:2227:6: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop118:
                do {
                    int alt118=2;
                    int LA118_0 = input.LA(1);

                    if ( (LA118_0==49) ) {
                        alt118=1;
                    }


                    switch (alt118) {
                	case 1 :
                	    // PsiInternalPureXbase.g:2228:7: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,49,FOLLOW_15); if (state.failed) return ;
                	    // PsiInternalPureXbase.g:2229:7: ( ( ruleJvmFormalParameter ) )
                	    // PsiInternalPureXbase.g:2230:8: ( ruleJvmFormalParameter )
                	    {
                	    // PsiInternalPureXbase.g:2230:8: ( ruleJvmFormalParameter )
                	    // PsiInternalPureXbase.g:2231:9: ruleJvmFormalParameter
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

        // PsiInternalPureXbase.g:2236:5: ( ( '|' ) )
        // PsiInternalPureXbase.g:2237:6: ( '|' )
        {
        // PsiInternalPureXbase.g:2237:6: ( '|' )
        // PsiInternalPureXbase.g:2238:7: '|'
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
        // PsiInternalPureXbase.g:2546:5: ( 'else' )
        // PsiInternalPureXbase.g:2546:6: 'else'
        {
        match(input,59,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_PsiInternalPureXbase

    // $ANTLR start synpred26_PsiInternalPureXbase
    public final void synpred26_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:2595:6: ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )
        // PsiInternalPureXbase.g:2595:7: ( '(' ( ( ruleJvmFormalParameter ) ) ':' )
        {
        // PsiInternalPureXbase.g:2595:7: ( '(' ( ( ruleJvmFormalParameter ) ) ':' )
        // PsiInternalPureXbase.g:2596:7: '(' ( ( ruleJvmFormalParameter ) ) ':'
        {
        match(input,50,FOLLOW_15); if (state.failed) return ;
        // PsiInternalPureXbase.g:2597:7: ( ( ruleJvmFormalParameter ) )
        // PsiInternalPureXbase.g:2598:8: ( ruleJvmFormalParameter )
        {
        // PsiInternalPureXbase.g:2598:8: ( ruleJvmFormalParameter )
        // PsiInternalPureXbase.g:2599:9: ruleJvmFormalParameter
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
        // PsiInternalPureXbase.g:2655:6: ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )
        // PsiInternalPureXbase.g:2655:7: ( ( ( ruleJvmFormalParameter ) ) ':' )
        {
        // PsiInternalPureXbase.g:2655:7: ( ( ( ruleJvmFormalParameter ) ) ':' )
        // PsiInternalPureXbase.g:2656:7: ( ( ruleJvmFormalParameter ) ) ':'
        {
        // PsiInternalPureXbase.g:2656:7: ( ( ruleJvmFormalParameter ) )
        // PsiInternalPureXbase.g:2657:8: ( ruleJvmFormalParameter )
        {
        // PsiInternalPureXbase.g:2657:8: ( ruleJvmFormalParameter )
        // PsiInternalPureXbase.g:2658:9: ruleJvmFormalParameter
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
        // PsiInternalPureXbase.g:3321:5: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )
        // PsiInternalPureXbase.g:3321:6: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        {
        // PsiInternalPureXbase.g:3321:6: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        // PsiInternalPureXbase.g:3322:6: ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) )
        {
        // PsiInternalPureXbase.g:3322:6: ( ( ruleJvmTypeReference ) )
        // PsiInternalPureXbase.g:3323:7: ( ruleJvmTypeReference )
        {
        // PsiInternalPureXbase.g:3323:7: ( ruleJvmTypeReference )
        // PsiInternalPureXbase.g:3324:8: ruleJvmTypeReference
        {
        pushFollow(FOLLOW_25);
        ruleJvmTypeReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // PsiInternalPureXbase.g:3327:6: ( ( ruleValidID ) )
        // PsiInternalPureXbase.g:3328:7: ( ruleValidID )
        {
        // PsiInternalPureXbase.g:3328:7: ( ruleValidID )
        // PsiInternalPureXbase.g:3329:8: ruleValidID
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
        // PsiInternalPureXbase.g:3538:5: ( ( '(' ) )
        // PsiInternalPureXbase.g:3538:6: ( '(' )
        {
        // PsiInternalPureXbase.g:3538:6: ( '(' )
        // PsiInternalPureXbase.g:3539:6: '('
        {
        match(input,50,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred30_PsiInternalPureXbase

    // $ANTLR start synpred31_PsiInternalPureXbase
    public final void synpred31_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:3554:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // PsiInternalPureXbase.g:3554:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // PsiInternalPureXbase.g:3554:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // PsiInternalPureXbase.g:3555:7: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // PsiInternalPureXbase.g:3555:7: ()
        // PsiInternalPureXbase.g:3556:7: 
        {
        }

        // PsiInternalPureXbase.g:3557:7: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt123=2;
        int LA123_0 = input.LA(1);

        if ( (LA123_0==RULE_ID||LA123_0==33||LA123_0==50) ) {
            alt123=1;
        }
        switch (alt123) {
            case 1 :
                // PsiInternalPureXbase.g:3558:8: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // PsiInternalPureXbase.g:3558:8: ( ( ruleJvmFormalParameter ) )
                // PsiInternalPureXbase.g:3559:9: ( ruleJvmFormalParameter )
                {
                // PsiInternalPureXbase.g:3559:9: ( ruleJvmFormalParameter )
                // PsiInternalPureXbase.g:3560:10: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_41);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // PsiInternalPureXbase.g:3563:8: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop122:
                do {
                    int alt122=2;
                    int LA122_0 = input.LA(1);

                    if ( (LA122_0==49) ) {
                        alt122=1;
                    }


                    switch (alt122) {
                	case 1 :
                	    // PsiInternalPureXbase.g:3564:9: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,49,FOLLOW_15); if (state.failed) return ;
                	    // PsiInternalPureXbase.g:3565:9: ( ( ruleJvmFormalParameter ) )
                	    // PsiInternalPureXbase.g:3566:10: ( ruleJvmFormalParameter )
                	    {
                	    // PsiInternalPureXbase.g:3566:10: ( ruleJvmFormalParameter )
                	    // PsiInternalPureXbase.g:3567:11: ruleJvmFormalParameter
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

        // PsiInternalPureXbase.g:3572:7: ( ( '|' ) )
        // PsiInternalPureXbase.g:3573:8: ( '|' )
        {
        // PsiInternalPureXbase.g:3573:8: ( '|' )
        // PsiInternalPureXbase.g:3574:9: '|'
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
        // PsiInternalPureXbase.g:3633:4: ( ( () '[' ) )
        // PsiInternalPureXbase.g:3633:5: ( () '[' )
        {
        // PsiInternalPureXbase.g:3633:5: ( () '[' )
        // PsiInternalPureXbase.g:3634:5: () '['
        {
        // PsiInternalPureXbase.g:3634:5: ()
        // PsiInternalPureXbase.g:3635:5: 
        {
        }

        match(input,55,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred32_PsiInternalPureXbase

    // $ANTLR start synpred33_PsiInternalPureXbase
    public final void synpred33_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:3714:5: ( '<' )
        // PsiInternalPureXbase.g:3714:6: '<'
        {
        match(input,20,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_PsiInternalPureXbase

    // $ANTLR start synpred34_PsiInternalPureXbase
    public final void synpred34_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:3764:5: ( ( '(' ) )
        // PsiInternalPureXbase.g:3764:6: ( '(' )
        {
        // PsiInternalPureXbase.g:3764:6: ( '(' )
        // PsiInternalPureXbase.g:3765:6: '('
        {
        match(input,50,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred34_PsiInternalPureXbase

    // $ANTLR start synpred35_PsiInternalPureXbase
    public final void synpred35_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:3780:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // PsiInternalPureXbase.g:3780:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // PsiInternalPureXbase.g:3780:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // PsiInternalPureXbase.g:3781:7: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // PsiInternalPureXbase.g:3781:7: ()
        // PsiInternalPureXbase.g:3782:7: 
        {
        }

        // PsiInternalPureXbase.g:3783:7: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt125=2;
        int LA125_0 = input.LA(1);

        if ( (LA125_0==RULE_ID||LA125_0==33||LA125_0==50) ) {
            alt125=1;
        }
        switch (alt125) {
            case 1 :
                // PsiInternalPureXbase.g:3784:8: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // PsiInternalPureXbase.g:3784:8: ( ( ruleJvmFormalParameter ) )
                // PsiInternalPureXbase.g:3785:9: ( ruleJvmFormalParameter )
                {
                // PsiInternalPureXbase.g:3785:9: ( ruleJvmFormalParameter )
                // PsiInternalPureXbase.g:3786:10: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_41);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // PsiInternalPureXbase.g:3789:8: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop124:
                do {
                    int alt124=2;
                    int LA124_0 = input.LA(1);

                    if ( (LA124_0==49) ) {
                        alt124=1;
                    }


                    switch (alt124) {
                	case 1 :
                	    // PsiInternalPureXbase.g:3790:9: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,49,FOLLOW_15); if (state.failed) return ;
                	    // PsiInternalPureXbase.g:3791:9: ( ( ruleJvmFormalParameter ) )
                	    // PsiInternalPureXbase.g:3792:10: ( ruleJvmFormalParameter )
                	    {
                	    // PsiInternalPureXbase.g:3792:10: ( ruleJvmFormalParameter )
                	    // PsiInternalPureXbase.g:3793:11: ruleJvmFormalParameter
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

        // PsiInternalPureXbase.g:3798:7: ( ( '|' ) )
        // PsiInternalPureXbase.g:3799:8: ( '|' )
        {
        // PsiInternalPureXbase.g:3799:8: ( '|' )
        // PsiInternalPureXbase.g:3800:9: '|'
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
        // PsiInternalPureXbase.g:3859:4: ( ( () '[' ) )
        // PsiInternalPureXbase.g:3859:5: ( () '[' )
        {
        // PsiInternalPureXbase.g:3859:5: ( () '[' )
        // PsiInternalPureXbase.g:3860:5: () '['
        {
        // PsiInternalPureXbase.g:3860:5: ()
        // PsiInternalPureXbase.g:3861:5: 
        {
        }

        match(input,55,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred36_PsiInternalPureXbase

    // $ANTLR start synpred37_PsiInternalPureXbase
    public final void synpred37_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:4120:4: ( '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )
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
        // PsiInternalPureXbase.g:4170:6: ( 'catch' )
        // PsiInternalPureXbase.g:4170:7: 'catch'
        {
        match(input,80,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_PsiInternalPureXbase

    // $ANTLR start synpred39_PsiInternalPureXbase
    public final void synpred39_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:4183:7: ( 'finally' )
        // PsiInternalPureXbase.g:4183:8: 'finally'
        {
        match(input,78,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_PsiInternalPureXbase

    // $ANTLR start synpred42_PsiInternalPureXbase
    public final void synpred42_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:4378:5: ( '.' )
        // PsiInternalPureXbase.g:4378:6: '.'
        {
        match(input,46,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_PsiInternalPureXbase

    // $ANTLR start synpred43_PsiInternalPureXbase
    public final void synpred43_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:4491:5: ( ( () ruleArrayBrackets ) )
        // PsiInternalPureXbase.g:4491:6: ( () ruleArrayBrackets )
        {
        // PsiInternalPureXbase.g:4491:6: ( () ruleArrayBrackets )
        // PsiInternalPureXbase.g:4492:6: () ruleArrayBrackets
        {
        // PsiInternalPureXbase.g:4492:6: ()
        // PsiInternalPureXbase.g:4493:6: 
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
        // PsiInternalPureXbase.g:4652:5: ( '<' )
        // PsiInternalPureXbase.g:4652:6: '<'
        {
        match(input,20,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_PsiInternalPureXbase

    // $ANTLR start synpred45_PsiInternalPureXbase
    public final void synpred45_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:4701:6: ( ( () '.' ) )
        // PsiInternalPureXbase.g:4701:7: ( () '.' )
        {
        // PsiInternalPureXbase.g:4701:7: ( () '.' )
        // PsiInternalPureXbase.g:4702:7: () '.'
        {
        // PsiInternalPureXbase.g:4702:7: ()
        // PsiInternalPureXbase.g:4703:7: 
        {
        }

        match(input,46,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred45_PsiInternalPureXbase

    // $ANTLR start synpred46_PsiInternalPureXbase
    public final void synpred46_PsiInternalPureXbase_fragment() throws RecognitionException {   
        // PsiInternalPureXbase.g:4736:7: ( '<' )
        // PsiInternalPureXbase.g:4736:8: '<'
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
    static final String DFA4_eotS =
        "\12\uffff";
    static final String DFA4_eofS =
        "\1\10\11\uffff";
    static final String DFA4_minS =
        "\1\4\7\0\2\uffff";
    static final String DFA4_maxS =
        "\1\120\7\0\2\uffff";
    static final String DFA4_acceptS =
        "\10\uffff\1\2\1\1";
    static final String DFA4_specialS =
        "\1\uffff\1\2\1\6\1\3\1\4\1\1\1\5\1\0\2\uffff}>";
    static final String[] DFA4_transitionS = {
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

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "214:4: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_7 = input.LA(1);

                         
                        int index4_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_PsiInternalPureXbase()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index4_7);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA4_5 = input.LA(1);

                         
                        int index4_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_PsiInternalPureXbase()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index4_5);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA4_1 = input.LA(1);

                         
                        int index4_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_PsiInternalPureXbase()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index4_1);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA4_3 = input.LA(1);

                         
                        int index4_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_PsiInternalPureXbase()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index4_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA4_4 = input.LA(1);

                         
                        int index4_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_PsiInternalPureXbase()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index4_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA4_6 = input.LA(1);

                         
                        int index4_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_PsiInternalPureXbase()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index4_6);
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
    static final String DFA14_eotS =
        "\13\uffff";
    static final String DFA14_eofS =
        "\1\1\12\uffff";
    static final String DFA14_minS =
        "\1\4\1\uffff\10\0\1\uffff";
    static final String DFA14_maxS =
        "\1\120\1\uffff\10\0\1\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\2\10\uffff\1\1";
    static final String DFA14_specialS =
        "\2\uffff\1\2\1\1\1\0\1\7\1\4\1\3\1\5\1\6\1\uffff}>";
    static final String[] DFA14_transitionS = {
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

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "()* loopback of 816:3: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_4 = input.LA(1);

                         
                        int index14_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_4);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_3 = input.LA(1);

                         
                        int index14_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_2 = input.LA(1);

                         
                        int index14_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA14_7 = input.LA(1);

                         
                        int index14_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_7);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA14_6 = input.LA(1);

                         
                        int index14_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_6);
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
                        int LA14_9 = input.LA(1);

                         
                        int index14_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_9);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA14_5 = input.LA(1);

                         
                        int index14_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalPureXbase()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_5);
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
    static final String DFA17_eotS =
        "\13\uffff";
    static final String DFA17_eofS =
        "\13\uffff";
    static final String DFA17_minS =
        "\1\24\2\uffff\1\25\7\uffff";
    static final String DFA17_maxS =
        "\1\43\2\uffff\1\40\7\uffff";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\4\1\5\1\7\1\10\1\11\1\6\1\3";
    static final String DFA17_specialS =
        "\13\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\6\1\3\10\uffff\1\1\1\2\1\4\1\5\1\7\1\10",
            "",
            "",
            "\1\11\12\uffff\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "871:2: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )";
        }
    }
    static final String DFA33_eotS =
        "\112\uffff";
    static final String DFA33_eofS =
        "\1\2\111\uffff";
    static final String DFA33_minS =
        "\1\4\1\0\110\uffff";
    static final String DFA33_maxS =
        "\1\120\1\0\110\uffff";
    static final String DFA33_acceptS =
        "\2\uffff\1\2\106\uffff\1\1";
    static final String DFA33_specialS =
        "\1\uffff\1\0\110\uffff}>";
    static final String[] DFA33_transitionS = {
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

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "1668:5: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )?";
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
    static final String DFA32_eotS =
        "\40\uffff";
    static final String DFA32_eofS =
        "\40\uffff";
    static final String DFA32_minS =
        "\1\4\2\0\35\uffff";
    static final String DFA32_maxS =
        "\1\117\2\0\35\uffff";
    static final String DFA32_acceptS =
        "\3\uffff\2\1\1\2\31\uffff\1\3";
    static final String DFA32_specialS =
        "\1\0\1\1\1\2\35\uffff}>";
    static final String[] DFA32_transitionS = {
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

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "1684:6: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )?";
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
    static final String DFA34_eotS =
        "\112\uffff";
    static final String DFA34_eofS =
        "\1\2\111\uffff";
    static final String DFA34_minS =
        "\1\4\1\0\110\uffff";
    static final String DFA34_maxS =
        "\1\120\1\0\110\uffff";
    static final String DFA34_acceptS =
        "\2\uffff\1\2\106\uffff\1\1";
    static final String DFA34_specialS =
        "\1\uffff\1\0\110\uffff}>";
    static final String[] DFA34_transitionS = {
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

    static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
    static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
    static final char[] DFA34_min = DFA.unpackEncodedStringToUnsignedChars(DFA34_minS);
    static final char[] DFA34_max = DFA.unpackEncodedStringToUnsignedChars(DFA34_maxS);
    static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
    static final short[] DFA34_special = DFA.unpackEncodedString(DFA34_specialS);
    static final short[][] DFA34_transition;

    static {
        int numStates = DFA34_transitionS.length;
        DFA34_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = DFA34_eot;
            this.eof = DFA34_eof;
            this.min = DFA34_min;
            this.max = DFA34_max;
            this.accept = DFA34_accept;
            this.special = DFA34_special;
            this.transition = DFA34_transition;
        }
        public String getDescription() {
            return "1764:5: ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?";
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
    static final String DFA36_eotS =
        "\34\uffff";
    static final String DFA36_eofS =
        "\34\uffff";
    static final String DFA36_minS =
        "\1\4\22\uffff\1\0\10\uffff";
    static final String DFA36_maxS =
        "\1\117\22\uffff\1\0\10\uffff";
    static final String DFA36_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\2\uffff\1\6\11\uffff\1\7\1\uffff\1\12\1\13\1\14\1\15\1\16\1\17\1\10\1\11";
    static final String DFA36_specialS =
        "\1\0\22\uffff\1\1\10\uffff}>";
    static final String[] DFA36_transitionS = {
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

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "1794:2: ( ruleXConstructorCall | ruleXBlockExpression | ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=> ruleXSynchronizedExpression ) | ruleXFeatureCall | ruleXLiteral | ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ruleXForLoopExpression ) | ruleXBasicForLoopExpression | ruleXWhileExpression | ruleXDoWhileExpression | ruleXThrowExpression | ruleXReturnExpression | ruleXTryCatchFinallyExpression | ruleXParenthesizedExpression )";
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
    static final String DFA45_eotS =
        "\42\uffff";
    static final String DFA45_eofS =
        "\42\uffff";
    static final String DFA45_minS =
        "\1\4\2\0\37\uffff";
    static final String DFA45_maxS =
        "\1\117\2\0\37\uffff";
    static final String DFA45_acceptS =
        "\3\uffff\2\1\1\2\34\uffff";
    static final String DFA45_specialS =
        "\1\0\1\1\1\2\37\uffff}>";
    static final String[] DFA45_transitionS = {
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

    static final short[] DFA45_eot = DFA.unpackEncodedString(DFA45_eotS);
    static final short[] DFA45_eof = DFA.unpackEncodedString(DFA45_eofS);
    static final char[] DFA45_min = DFA.unpackEncodedStringToUnsignedChars(DFA45_minS);
    static final char[] DFA45_max = DFA.unpackEncodedStringToUnsignedChars(DFA45_maxS);
    static final short[] DFA45_accept = DFA.unpackEncodedString(DFA45_acceptS);
    static final short[] DFA45_special = DFA.unpackEncodedString(DFA45_specialS);
    static final short[][] DFA45_transition;

    static {
        int numStates = DFA45_transitionS.length;
        DFA45_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA45_transition[i] = DFA.unpackEncodedString(DFA45_transitionS[i]);
        }
    }

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = DFA45_eot;
            this.eof = DFA45_eof;
            this.min = DFA45_min;
            this.max = DFA45_max;
            this.accept = DFA45_accept;
            this.special = DFA45_special;
            this.transition = DFA45_transition;
        }
        public String getDescription() {
            return "2219:3: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?";
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
    static final String DFA52_eotS =
        "\37\uffff";
    static final String DFA52_eofS =
        "\37\uffff";
    static final String DFA52_minS =
        "\1\4\1\0\35\uffff";
    static final String DFA52_maxS =
        "\1\117\1\0\35\uffff";
    static final String DFA52_acceptS =
        "\2\uffff\1\2\33\uffff\1\1";
    static final String DFA52_specialS =
        "\1\uffff\1\0\35\uffff}>";
    static final String[] DFA52_transitionS = {
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

    static final short[] DFA52_eot = DFA.unpackEncodedString(DFA52_eotS);
    static final short[] DFA52_eof = DFA.unpackEncodedString(DFA52_eofS);
    static final char[] DFA52_min = DFA.unpackEncodedStringToUnsignedChars(DFA52_minS);
    static final char[] DFA52_max = DFA.unpackEncodedStringToUnsignedChars(DFA52_maxS);
    static final short[] DFA52_accept = DFA.unpackEncodedString(DFA52_acceptS);
    static final short[] DFA52_special = DFA.unpackEncodedString(DFA52_specialS);
    static final short[][] DFA52_transition;

    static {
        int numStates = DFA52_transitionS.length;
        DFA52_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA52_transition[i] = DFA.unpackEncodedString(DFA52_transitionS[i]);
        }
    }

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = DFA52_eot;
            this.eof = DFA52_eof;
            this.min = DFA52_min;
            this.max = DFA52_max;
            this.accept = DFA52_accept;
            this.special = DFA52_special;
            this.transition = DFA52_transition;
        }
        public String getDescription() {
            return "2592:3: ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) )";
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
    static final String DFA51_eotS =
        "\36\uffff";
    static final String DFA51_eofS =
        "\36\uffff";
    static final String DFA51_minS =
        "\1\4\2\0\33\uffff";
    static final String DFA51_maxS =
        "\1\117\2\0\33\uffff";
    static final String DFA51_acceptS =
        "\3\uffff\1\1\1\2\31\uffff";
    static final String DFA51_specialS =
        "\1\0\1\1\1\2\33\uffff}>";
    static final String[] DFA51_transitionS = {
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

    static final short[] DFA51_eot = DFA.unpackEncodedString(DFA51_eotS);
    static final short[] DFA51_eof = DFA.unpackEncodedString(DFA51_eofS);
    static final char[] DFA51_min = DFA.unpackEncodedStringToUnsignedChars(DFA51_minS);
    static final char[] DFA51_max = DFA.unpackEncodedStringToUnsignedChars(DFA51_maxS);
    static final short[] DFA51_accept = DFA.unpackEncodedString(DFA51_acceptS);
    static final short[] DFA51_special = DFA.unpackEncodedString(DFA51_specialS);
    static final short[][] DFA51_transition;

    static {
        int numStates = DFA51_transitionS.length;
        DFA51_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA51_transition[i] = DFA.unpackEncodedString(DFA51_transitionS[i]);
        }
    }

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = DFA51_eot;
            this.eof = DFA51_eof;
            this.min = DFA51_min;
            this.max = DFA51_max;
            this.accept = DFA51_accept;
            this.special = DFA51_special;
            this.transition = DFA51_transition;
        }
        public String getDescription() {
            return "2654:5: ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )?";
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
    static final String DFA74_eotS =
        "\112\uffff";
    static final String DFA74_eofS =
        "\1\2\111\uffff";
    static final String DFA74_minS =
        "\1\4\1\0\110\uffff";
    static final String DFA74_maxS =
        "\1\120\1\0\110\uffff";
    static final String DFA74_acceptS =
        "\2\uffff\1\2\106\uffff\1\1";
    static final String DFA74_specialS =
        "\1\uffff\1\0\110\uffff}>";
    static final String[] DFA74_transitionS = {
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

    static final short[] DFA74_eot = DFA.unpackEncodedString(DFA74_eotS);
    static final short[] DFA74_eof = DFA.unpackEncodedString(DFA74_eofS);
    static final char[] DFA74_min = DFA.unpackEncodedStringToUnsignedChars(DFA74_minS);
    static final char[] DFA74_max = DFA.unpackEncodedStringToUnsignedChars(DFA74_maxS);
    static final short[] DFA74_accept = DFA.unpackEncodedString(DFA74_acceptS);
    static final short[] DFA74_special = DFA.unpackEncodedString(DFA74_specialS);
    static final short[][] DFA74_transition;

    static {
        int numStates = DFA74_transitionS.length;
        DFA74_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA74_transition[i] = DFA.unpackEncodedString(DFA74_transitionS[i]);
        }
    }

    class DFA74 extends DFA {

        public DFA74(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 74;
            this.eot = DFA74_eot;
            this.eof = DFA74_eof;
            this.min = DFA74_min;
            this.max = DFA74_max;
            this.accept = DFA74_accept;
            this.special = DFA74_special;
            this.transition = DFA74_transition;
        }
        public String getDescription() {
            return "3536:3: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )?";
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
    static final String DFA73_eotS =
        "\40\uffff";
    static final String DFA73_eofS =
        "\40\uffff";
    static final String DFA73_minS =
        "\1\4\2\0\35\uffff";
    static final String DFA73_maxS =
        "\1\117\2\0\35\uffff";
    static final String DFA73_acceptS =
        "\3\uffff\2\1\1\2\31\uffff\1\3";
    static final String DFA73_specialS =
        "\1\0\1\1\1\2\35\uffff}>";
    static final String[] DFA73_transitionS = {
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

    static final short[] DFA73_eot = DFA.unpackEncodedString(DFA73_eotS);
    static final short[] DFA73_eof = DFA.unpackEncodedString(DFA73_eofS);
    static final char[] DFA73_min = DFA.unpackEncodedStringToUnsignedChars(DFA73_minS);
    static final char[] DFA73_max = DFA.unpackEncodedStringToUnsignedChars(DFA73_maxS);
    static final short[] DFA73_accept = DFA.unpackEncodedString(DFA73_acceptS);
    static final short[] DFA73_special = DFA.unpackEncodedString(DFA73_specialS);
    static final short[][] DFA73_transition;

    static {
        int numStates = DFA73_transitionS.length;
        DFA73_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA73_transition[i] = DFA.unpackEncodedString(DFA73_transitionS[i]);
        }
    }

    class DFA73 extends DFA {

        public DFA73(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 73;
            this.eot = DFA73_eot;
            this.eof = DFA73_eof;
            this.min = DFA73_min;
            this.max = DFA73_max;
            this.accept = DFA73_accept;
            this.special = DFA73_special;
            this.transition = DFA73_transition;
        }
        public String getDescription() {
            return "3552:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )?";
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
    static final String DFA75_eotS =
        "\112\uffff";
    static final String DFA75_eofS =
        "\1\2\111\uffff";
    static final String DFA75_minS =
        "\1\4\1\0\110\uffff";
    static final String DFA75_maxS =
        "\1\120\1\0\110\uffff";
    static final String DFA75_acceptS =
        "\2\uffff\1\2\106\uffff\1\1";
    static final String DFA75_specialS =
        "\1\uffff\1\0\110\uffff}>";
    static final String[] DFA75_transitionS = {
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

    static final short[] DFA75_eot = DFA.unpackEncodedString(DFA75_eotS);
    static final short[] DFA75_eof = DFA.unpackEncodedString(DFA75_eofS);
    static final char[] DFA75_min = DFA.unpackEncodedStringToUnsignedChars(DFA75_minS);
    static final char[] DFA75_max = DFA.unpackEncodedStringToUnsignedChars(DFA75_maxS);
    static final short[] DFA75_accept = DFA.unpackEncodedString(DFA75_acceptS);
    static final short[] DFA75_special = DFA.unpackEncodedString(DFA75_specialS);
    static final short[][] DFA75_transition;

    static {
        int numStates = DFA75_transitionS.length;
        DFA75_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA75_transition[i] = DFA.unpackEncodedString(DFA75_transitionS[i]);
        }
    }

    class DFA75 extends DFA {

        public DFA75(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 75;
            this.eot = DFA75_eot;
            this.eof = DFA75_eof;
            this.min = DFA75_min;
            this.max = DFA75_max;
            this.accept = DFA75_accept;
            this.special = DFA75_special;
            this.transition = DFA75_transition;
        }
        public String getDescription() {
            return "3632:3: ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?";
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
    static final String DFA78_eotS =
        "\112\uffff";
    static final String DFA78_eofS =
        "\1\2\111\uffff";
    static final String DFA78_minS =
        "\1\4\1\0\110\uffff";
    static final String DFA78_maxS =
        "\1\120\1\0\110\uffff";
    static final String DFA78_acceptS =
        "\2\uffff\1\2\106\uffff\1\1";
    static final String DFA78_specialS =
        "\1\uffff\1\0\110\uffff}>";
    static final String[] DFA78_transitionS = {
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

    static final short[] DFA78_eot = DFA.unpackEncodedString(DFA78_eotS);
    static final short[] DFA78_eof = DFA.unpackEncodedString(DFA78_eofS);
    static final char[] DFA78_min = DFA.unpackEncodedStringToUnsignedChars(DFA78_minS);
    static final char[] DFA78_max = DFA.unpackEncodedStringToUnsignedChars(DFA78_maxS);
    static final short[] DFA78_accept = DFA.unpackEncodedString(DFA78_acceptS);
    static final short[] DFA78_special = DFA.unpackEncodedString(DFA78_specialS);
    static final short[][] DFA78_transition;

    static {
        int numStates = DFA78_transitionS.length;
        DFA78_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA78_transition[i] = DFA.unpackEncodedString(DFA78_transitionS[i]);
        }
    }

    class DFA78 extends DFA {

        public DFA78(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 78;
            this.eot = DFA78_eot;
            this.eof = DFA78_eof;
            this.min = DFA78_min;
            this.max = DFA78_max;
            this.accept = DFA78_accept;
            this.special = DFA78_special;
            this.transition = DFA78_transition;
        }
        public String getDescription() {
            return "3712:3: ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?";
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
    static final String DFA81_eotS =
        "\112\uffff";
    static final String DFA81_eofS =
        "\1\2\111\uffff";
    static final String DFA81_minS =
        "\1\4\1\0\110\uffff";
    static final String DFA81_maxS =
        "\1\120\1\0\110\uffff";
    static final String DFA81_acceptS =
        "\2\uffff\1\2\106\uffff\1\1";
    static final String DFA81_specialS =
        "\1\uffff\1\0\110\uffff}>";
    static final String[] DFA81_transitionS = {
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

    static final short[] DFA81_eot = DFA.unpackEncodedString(DFA81_eotS);
    static final short[] DFA81_eof = DFA.unpackEncodedString(DFA81_eofS);
    static final char[] DFA81_min = DFA.unpackEncodedStringToUnsignedChars(DFA81_minS);
    static final char[] DFA81_max = DFA.unpackEncodedStringToUnsignedChars(DFA81_maxS);
    static final short[] DFA81_accept = DFA.unpackEncodedString(DFA81_acceptS);
    static final short[] DFA81_special = DFA.unpackEncodedString(DFA81_specialS);
    static final short[][] DFA81_transition;

    static {
        int numStates = DFA81_transitionS.length;
        DFA81_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA81_transition[i] = DFA.unpackEncodedString(DFA81_transitionS[i]);
        }
    }

    class DFA81 extends DFA {

        public DFA81(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 81;
            this.eot = DFA81_eot;
            this.eof = DFA81_eof;
            this.min = DFA81_min;
            this.max = DFA81_max;
            this.accept = DFA81_accept;
            this.special = DFA81_special;
            this.transition = DFA81_transition;
        }
        public String getDescription() {
            return "3762:3: ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?";
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
    static final String DFA80_eotS =
        "\40\uffff";
    static final String DFA80_eofS =
        "\40\uffff";
    static final String DFA80_minS =
        "\1\4\2\0\35\uffff";
    static final String DFA80_maxS =
        "\1\117\2\0\35\uffff";
    static final String DFA80_acceptS =
        "\3\uffff\2\1\1\2\31\uffff\1\3";
    static final String DFA80_specialS =
        "\1\0\1\1\1\2\35\uffff}>";
    static final String[] DFA80_transitionS = {
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

    static final short[] DFA80_eot = DFA.unpackEncodedString(DFA80_eotS);
    static final short[] DFA80_eof = DFA.unpackEncodedString(DFA80_eofS);
    static final char[] DFA80_min = DFA.unpackEncodedStringToUnsignedChars(DFA80_minS);
    static final char[] DFA80_max = DFA.unpackEncodedStringToUnsignedChars(DFA80_maxS);
    static final short[] DFA80_accept = DFA.unpackEncodedString(DFA80_acceptS);
    static final short[] DFA80_special = DFA.unpackEncodedString(DFA80_specialS);
    static final short[][] DFA80_transition;

    static {
        int numStates = DFA80_transitionS.length;
        DFA80_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA80_transition[i] = DFA.unpackEncodedString(DFA80_transitionS[i]);
        }
    }

    class DFA80 extends DFA {

        public DFA80(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 80;
            this.eot = DFA80_eot;
            this.eof = DFA80_eof;
            this.min = DFA80_min;
            this.max = DFA80_max;
            this.accept = DFA80_accept;
            this.special = DFA80_special;
            this.transition = DFA80_transition;
        }
        public String getDescription() {
            return "3778:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?";
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
    static final String DFA82_eotS =
        "\112\uffff";
    static final String DFA82_eofS =
        "\1\2\111\uffff";
    static final String DFA82_minS =
        "\1\4\1\0\110\uffff";
    static final String DFA82_maxS =
        "\1\120\1\0\110\uffff";
    static final String DFA82_acceptS =
        "\2\uffff\1\2\106\uffff\1\1";
    static final String DFA82_specialS =
        "\1\uffff\1\0\110\uffff}>";
    static final String[] DFA82_transitionS = {
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

    static final short[] DFA82_eot = DFA.unpackEncodedString(DFA82_eotS);
    static final short[] DFA82_eof = DFA.unpackEncodedString(DFA82_eofS);
    static final char[] DFA82_min = DFA.unpackEncodedStringToUnsignedChars(DFA82_minS);
    static final char[] DFA82_max = DFA.unpackEncodedStringToUnsignedChars(DFA82_maxS);
    static final short[] DFA82_accept = DFA.unpackEncodedString(DFA82_acceptS);
    static final short[] DFA82_special = DFA.unpackEncodedString(DFA82_specialS);
    static final short[][] DFA82_transition;

    static {
        int numStates = DFA82_transitionS.length;
        DFA82_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA82_transition[i] = DFA.unpackEncodedString(DFA82_transitionS[i]);
        }
    }

    class DFA82 extends DFA {

        public DFA82(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 82;
            this.eot = DFA82_eot;
            this.eof = DFA82_eof;
            this.min = DFA82_min;
            this.max = DFA82_max;
            this.accept = DFA82_accept;
            this.special = DFA82_special;
            this.transition = DFA82_transition;
        }
        public String getDescription() {
            return "3858:3: ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?";
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
    static final String DFA85_eotS =
        "\112\uffff";
    static final String DFA85_eofS =
        "\1\35\111\uffff";
    static final String DFA85_minS =
        "\1\4\34\0\55\uffff";
    static final String DFA85_maxS =
        "\1\120\34\0\55\uffff";
    static final String DFA85_acceptS =
        "\35\uffff\1\2\53\uffff\1\1";
    static final String DFA85_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\55\uffff}>";
    static final String[] DFA85_transitionS = {
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

    static final short[] DFA85_eot = DFA.unpackEncodedString(DFA85_eotS);
    static final short[] DFA85_eof = DFA.unpackEncodedString(DFA85_eofS);
    static final char[] DFA85_min = DFA.unpackEncodedStringToUnsignedChars(DFA85_minS);
    static final char[] DFA85_max = DFA.unpackEncodedStringToUnsignedChars(DFA85_maxS);
    static final short[] DFA85_accept = DFA.unpackEncodedString(DFA85_acceptS);
    static final short[] DFA85_special = DFA.unpackEncodedString(DFA85_specialS);
    static final short[][] DFA85_transition;

    static {
        int numStates = DFA85_transitionS.length;
        DFA85_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA85_transition[i] = DFA.unpackEncodedString(DFA85_transitionS[i]);
        }
    }

    class DFA85 extends DFA {

        public DFA85(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 85;
            this.eot = DFA85_eot;
            this.eof = DFA85_eof;
            this.min = DFA85_min;
            this.max = DFA85_max;
            this.accept = DFA85_accept;
            this.special = DFA85_special;
            this.transition = DFA85_transition;
        }
        public String getDescription() {
            return "4119:3: ( ( '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?";
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
    static final String DFA103_eotS =
        "\113\uffff";
    static final String DFA103_eofS =
        "\1\2\112\uffff";
    static final String DFA103_minS =
        "\1\4\1\0\111\uffff";
    static final String DFA103_maxS =
        "\1\123\1\0\111\uffff";
    static final String DFA103_acceptS =
        "\2\uffff\1\2\107\uffff\1\1";
    static final String DFA103_specialS =
        "\1\uffff\1\0\111\uffff}>";
    static final String[] DFA103_transitionS = {
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

    static final short[] DFA103_eot = DFA.unpackEncodedString(DFA103_eotS);
    static final short[] DFA103_eof = DFA.unpackEncodedString(DFA103_eofS);
    static final char[] DFA103_min = DFA.unpackEncodedStringToUnsignedChars(DFA103_minS);
    static final char[] DFA103_max = DFA.unpackEncodedStringToUnsignedChars(DFA103_maxS);
    static final short[] DFA103_accept = DFA.unpackEncodedString(DFA103_acceptS);
    static final short[] DFA103_special = DFA.unpackEncodedString(DFA103_specialS);
    static final short[][] DFA103_transition;

    static {
        int numStates = DFA103_transitionS.length;
        DFA103_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA103_transition[i] = DFA.unpackEncodedString(DFA103_transitionS[i]);
        }
    }

    class DFA103 extends DFA {

        public DFA103(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 103;
            this.eot = DFA103_eot;
            this.eof = DFA103_eof;
            this.min = DFA103_min;
            this.max = DFA103_max;
            this.accept = DFA103_accept;
            this.special = DFA103_special;
            this.transition = DFA103_transition;
        }
        public String getDescription() {
            return "4650:3: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?";
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
    static final String DFA101_eotS =
        "\113\uffff";
    static final String DFA101_eofS =
        "\1\2\112\uffff";
    static final String DFA101_minS =
        "\1\4\1\0\111\uffff";
    static final String DFA101_maxS =
        "\1\123\1\0\111\uffff";
    static final String DFA101_acceptS =
        "\2\uffff\1\2\107\uffff\1\1";
    static final String DFA101_specialS =
        "\1\uffff\1\0\111\uffff}>";
    static final String[] DFA101_transitionS = {
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

    static final short[] DFA101_eot = DFA.unpackEncodedString(DFA101_eotS);
    static final short[] DFA101_eof = DFA.unpackEncodedString(DFA101_eofS);
    static final char[] DFA101_min = DFA.unpackEncodedStringToUnsignedChars(DFA101_minS);
    static final char[] DFA101_max = DFA.unpackEncodedStringToUnsignedChars(DFA101_maxS);
    static final short[] DFA101_accept = DFA.unpackEncodedString(DFA101_acceptS);
    static final short[] DFA101_special = DFA.unpackEncodedString(DFA101_specialS);
    static final short[][] DFA101_transition;

    static {
        int numStates = DFA101_transitionS.length;
        DFA101_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA101_transition[i] = DFA.unpackEncodedString(DFA101_transitionS[i]);
        }
    }

    class DFA101 extends DFA {

        public DFA101(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 101;
            this.eot = DFA101_eot;
            this.eof = DFA101_eof;
            this.min = DFA101_min;
            this.max = DFA101_max;
            this.accept = DFA101_accept;
            this.special = DFA101_special;
            this.transition = DFA101_transition;
        }
        public String getDescription() {
            return "4734:5: ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?";
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
    static final String DFA111_eotS =
        "\7\uffff";
    static final String DFA111_eofS =
        "\2\uffff\1\4\2\uffff\1\4\1\uffff";
    static final String DFA111_minS =
        "\1\10\1\uffff\1\4\1\10\1\uffff\1\4\1\uffff";
    static final String DFA111_maxS =
        "\1\125\1\uffff\1\124\1\46\1\uffff\1\124\1\uffff";
    static final String DFA111_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\1\uffff\1\3";
    static final String DFA111_specialS =
        "\7\uffff}>";
    static final String[] DFA111_transitionS = {
            "\1\2\114\uffff\1\1",
            "",
            "\5\4\4\uffff\1\4\6\uffff\1\4\17\uffff\2\4\4\uffff\1\4\3\uffff\1\3\3\uffff\1\4\1\uffff\2\4\1\uffff\1\4\2\uffff\1\4\1\uffff\1\4\3\uffff\16\4\1\uffff\1\4\4\uffff\1\4",
            "\1\5\35\uffff\1\6",
            "",
            "\5\4\4\uffff\1\4\6\uffff\1\4\17\uffff\2\4\4\uffff\1\4\3\uffff\1\3\3\uffff\1\4\1\uffff\2\4\1\uffff\1\4\2\uffff\1\4\1\uffff\1\4\3\uffff\16\4\1\uffff\1\4\4\uffff\1\4",
            ""
    };

    static final short[] DFA111_eot = DFA.unpackEncodedString(DFA111_eotS);
    static final short[] DFA111_eof = DFA.unpackEncodedString(DFA111_eofS);
    static final char[] DFA111_min = DFA.unpackEncodedStringToUnsignedChars(DFA111_minS);
    static final char[] DFA111_max = DFA.unpackEncodedStringToUnsignedChars(DFA111_maxS);
    static final short[] DFA111_accept = DFA.unpackEncodedString(DFA111_acceptS);
    static final short[] DFA111_special = DFA.unpackEncodedString(DFA111_specialS);
    static final short[][] DFA111_transition;

    static {
        int numStates = DFA111_transitionS.length;
        DFA111_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA111_transition[i] = DFA.unpackEncodedString(DFA111_transitionS[i]);
        }
    }

    class DFA111 extends DFA {

        public DFA111(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 111;
            this.eot = DFA111_eot;
            this.eof = DFA111_eof;
            this.min = DFA111_min;
            this.max = DFA111_max;
            this.accept = DFA111_accept;
            this.special = DFA111_special;
            this.transition = DFA111_transition;
        }
        public String getDescription() {
            return "5099:3: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )";
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