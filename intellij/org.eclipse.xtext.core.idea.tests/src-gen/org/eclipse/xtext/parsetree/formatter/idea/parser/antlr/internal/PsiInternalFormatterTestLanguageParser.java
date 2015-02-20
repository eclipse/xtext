package org.eclipse.xtext.parsetree.formatter.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.formatter.idea.lang.FormatterTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalFormatterTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'test'", "'post'", "';'", "'='", "'+='", "'['", "','", "']'", "'void'", "'('", "')'", "':'", "'space'", "'linewrap'", "'wrapminmax'", "'indentation'", "'{'", "'}'", "'fqn'", "'.'", "'fqnref'", "'enum'", "'`'", "'%'", "'<'", "'>'", "'datatypes'", "'kw1'", "'kw3'", "'wrappingdt'", "'lit1'", "'lit2'", "'lit3'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=6;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public PsiInternalFormatterTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalFormatterTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalFormatterTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g"; }



    	protected FormatterTestLanguageGrammarAccess grammarAccess;

    	protected FormatterTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalFormatterTestLanguageParser(PsiBuilder builder, TokenStream input, FormatterTestLanguageElementTypeProvider elementTypeProvider, FormatterTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Root";
    	}




    // $ANTLR start "entryRuleRoot"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:52:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:52:14: ( ruleRoot EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:53:2: ruleRoot EOF
            {
             markComposite(elementTypeProvider.getRootElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRoot_in_entryRuleRoot54);
            ruleRoot();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoot60); 

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
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:59:1: ruleRoot : (otherlv_0= 'test' ( ruleTestLinewrap | ruleTestIndentation | ruleTestLinewrapMinMax | ruleWrappingDataTypeTest ) ) ;
    public final void ruleRoot() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:59:9: ( (otherlv_0= 'test' ( ruleTestLinewrap | ruleTestIndentation | ruleTestLinewrapMinMax | ruleWrappingDataTypeTest ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:60:2: (otherlv_0= 'test' ( ruleTestLinewrap | ruleTestIndentation | ruleTestLinewrapMinMax | ruleWrappingDataTypeTest ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:60:2: (otherlv_0= 'test' ( ruleTestLinewrap | ruleTestIndentation | ruleTestLinewrapMinMax | ruleWrappingDataTypeTest ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:61:3: otherlv_0= 'test' ( ruleTestLinewrap | ruleTestIndentation | ruleTestLinewrapMinMax | ruleWrappingDataTypeTest )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleRoot79); 

            			doneLeaf(otherlv_0, elementTypeProvider.getRoot_TestKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:68:3: ( ruleTestLinewrap | ruleTestIndentation | ruleTestLinewrapMinMax | ruleWrappingDataTypeTest )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt1=1;
                }
                break;
            case 26:
                {
                alt1=2;
                }
                break;
            case 25:
                {
                alt1=3;
                }
                break;
            case 40:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:69:4: ruleTestLinewrap
                    {

                    				markComposite(elementTypeProvider.getRoot_TestLinewrapParserRuleCall_1_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleTestLinewrap_in_ruleRoot97);
                    ruleTestLinewrap();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:77:4: ruleTestIndentation
                    {

                    				markComposite(elementTypeProvider.getRoot_TestIndentationParserRuleCall_1_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleTestIndentation_in_ruleRoot121);
                    ruleTestIndentation();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:85:4: ruleTestLinewrapMinMax
                    {

                    				markComposite(elementTypeProvider.getRoot_TestLinewrapMinMaxParserRuleCall_1_2ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleTestLinewrapMinMax_in_ruleRoot145);
                    ruleTestLinewrapMinMax();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:93:4: ruleWrappingDataTypeTest
                    {

                    				markComposite(elementTypeProvider.getRoot_WrappingDataTypeTestParserRuleCall_1_3ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleWrappingDataTypeTest_in_ruleRoot169);
                    ruleWrappingDataTypeTest();

                    state._fsp--;


                    				doneComposite();
                    			

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
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleLine"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:105:1: entryRuleLine : ruleLine EOF ;
    public final void entryRuleLine() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:105:14: ( ruleLine EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:106:2: ruleLine EOF
            {
             markComposite(elementTypeProvider.getLineElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleLine_in_entryRuleLine194);
            ruleLine();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLine200); 

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
    // $ANTLR end "entryRuleLine"


    // $ANTLR start "ruleLine"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:112:1: ruleLine : ( ( ruleDecl | ruleAssign | ruleMeth | ruleFqnObj | ruleFqnRef | ruleEnumeration | ( ruleSuppressedHidden otherlv_7= 'post' ) | ruleSpace | ruleDatatypes ) otherlv_10= ';' ) ;
    public final void ruleLine() throws RecognitionException {
        Token otherlv_7=null;
        Token otherlv_10=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:112:9: ( ( ( ruleDecl | ruleAssign | ruleMeth | ruleFqnObj | ruleFqnRef | ruleEnumeration | ( ruleSuppressedHidden otherlv_7= 'post' ) | ruleSpace | ruleDatatypes ) otherlv_10= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:113:2: ( ( ruleDecl | ruleAssign | ruleMeth | ruleFqnObj | ruleFqnRef | ruleEnumeration | ( ruleSuppressedHidden otherlv_7= 'post' ) | ruleSpace | ruleDatatypes ) otherlv_10= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:113:2: ( ( ruleDecl | ruleAssign | ruleMeth | ruleFqnObj | ruleFqnRef | ruleEnumeration | ( ruleSuppressedHidden otherlv_7= 'post' ) | ruleSpace | ruleDatatypes ) otherlv_10= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:114:3: ( ruleDecl | ruleAssign | ruleMeth | ruleFqnObj | ruleFqnRef | ruleEnumeration | ( ruleSuppressedHidden otherlv_7= 'post' ) | ruleSpace | ruleDatatypes ) otherlv_10= ';'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:114:3: ( ruleDecl | ruleAssign | ruleMeth | ruleFqnObj | ruleFqnRef | ruleEnumeration | ( ruleSuppressedHidden otherlv_7= 'post' ) | ruleSpace | ruleDatatypes )
            int alt2=9;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:115:4: ruleDecl
                    {

                    				markComposite(elementTypeProvider.getLine_DeclParserRuleCall_0_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleDecl_in_ruleLine223);
                    ruleDecl();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:123:4: ruleAssign
                    {

                    				markComposite(elementTypeProvider.getLine_AssignParserRuleCall_0_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleAssign_in_ruleLine247);
                    ruleAssign();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:131:4: ruleMeth
                    {

                    				markComposite(elementTypeProvider.getLine_MethParserRuleCall_0_2ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleMeth_in_ruleLine271);
                    ruleMeth();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:139:4: ruleFqnObj
                    {

                    				markComposite(elementTypeProvider.getLine_FqnObjParserRuleCall_0_3ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleFqnObj_in_ruleLine295);
                    ruleFqnObj();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:147:4: ruleFqnRef
                    {

                    				markComposite(elementTypeProvider.getLine_FqnRefParserRuleCall_0_4ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleFqnRef_in_ruleLine319);
                    ruleFqnRef();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 6 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:155:4: ruleEnumeration
                    {

                    				markComposite(elementTypeProvider.getLine_EnumerationParserRuleCall_0_5ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleEnumeration_in_ruleLine343);
                    ruleEnumeration();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 7 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:163:4: ( ruleSuppressedHidden otherlv_7= 'post' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:163:4: ( ruleSuppressedHidden otherlv_7= 'post' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:164:5: ruleSuppressedHidden otherlv_7= 'post'
                    {

                    					markComposite(elementTypeProvider.getLine_SuppressedHiddenParserRuleCall_0_6_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleSuppressedHidden_in_ruleLine374);
                    ruleSuppressedHidden();

                    state._fsp--;


                    					doneComposite();
                    				

                    					markLeaf();
                    				
                    otherlv_7=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleLine394); 

                    					doneLeaf(otherlv_7, elementTypeProvider.getLine_PostKeyword_0_6_1ElementType());
                    				

                    }


                    }
                    break;
                case 8 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:180:4: ruleSpace
                    {

                    				markComposite(elementTypeProvider.getLine_SpaceParserRuleCall_0_7ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleSpace_in_ruleLine424);
                    ruleSpace();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 9 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:188:4: ruleDatatypes
                    {

                    				markComposite(elementTypeProvider.getLine_DatatypesParserRuleCall_0_8ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleDatatypes_in_ruleLine448);
                    ruleDatatypes();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleLine467); 

            			doneLeaf(otherlv_10, elementTypeProvider.getLine_SemicolonKeyword_1ElementType());
            		

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
    // $ANTLR end "ruleLine"


    // $ANTLR start "entryRuleDecl"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:207:1: entryRuleDecl : ruleDecl EOF ;
    public final void entryRuleDecl() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:207:14: ( ruleDecl EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:208:2: ruleDecl EOF
            {
             markComposite(elementTypeProvider.getDeclElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDecl_in_entryRuleDecl487);
            ruleDecl();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDecl493); 

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
    // $ANTLR end "entryRuleDecl"


    // $ANTLR start "ruleDecl"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:214:1: ruleDecl : ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleDecl() throws RecognitionException {
        Token lv_type_0_0=null;
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:214:9: ( ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:215:2: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:215:2: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:216:3: ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:216:3: ( (lv_type_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:217:4: (lv_type_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:217:4: (lv_type_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:218:5: lv_type_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_type_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDecl525); 

            					doneLeaf(lv_type_0_0, elementTypeProvider.getDecl_TypeIDTerminalRuleCall_0_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:227:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:228:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:228:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:229:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDecl563); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getDecl_NameIDTerminalRuleCall_1_0ElementType());
            				

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
    // $ANTLR end "ruleDecl"


    // $ANTLR start "entryRuleAssign"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:242:1: entryRuleAssign : ruleAssign EOF ;
    public final void entryRuleAssign() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:242:16: ( ruleAssign EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:243:2: ruleAssign EOF
            {
             markComposite(elementTypeProvider.getAssignElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssign_in_entryRuleAssign594);
            ruleAssign();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssign600); 

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
    // $ANTLR end "entryRuleAssign"


    // $ANTLR start "ruleAssign"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:249:1: ruleAssign : ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) otherlv_2= '[' ( ( (lv_val_3_0= RULE_INT ) ) (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )* )? otherlv_6= ']' ) ;
    public final void ruleAssign() throws RecognitionException {
        Token lv_var_0_0=null;
        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token otherlv_2=null;
        Token lv_val_3_0=null;
        Token otherlv_4=null;
        Token lv_val_5_0=null;
        Token otherlv_6=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:249:11: ( ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) otherlv_2= '[' ( ( (lv_val_3_0= RULE_INT ) ) (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )* )? otherlv_6= ']' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:250:2: ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) otherlv_2= '[' ( ( (lv_val_3_0= RULE_INT ) ) (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )* )? otherlv_6= ']' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:250:2: ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) otherlv_2= '[' ( ( (lv_val_3_0= RULE_INT ) ) (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )* )? otherlv_6= ']' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:251:3: ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) otherlv_2= '[' ( ( (lv_val_3_0= RULE_INT ) ) (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )* )? otherlv_6= ']'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:251:3: ( (lv_var_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:252:4: (lv_var_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:252:4: (lv_var_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:253:5: lv_var_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_var_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssign632); 

            					doneLeaf(lv_var_0_0, elementTypeProvider.getAssign_VarIDTerminalRuleCall_0_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:262:3: ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:263:4: ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:263:4: ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:264:5: (lv_op_1_1= '=' | lv_op_1_2= '+=' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:264:5: (lv_op_1_1= '=' | lv_op_1_2= '+=' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            else if ( (LA3_0==15) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:265:6: lv_op_1_1= '='
                    {

                    						markLeaf();
                    					
                    lv_op_1_1=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAssign678); 

                    						doneLeaf(lv_op_1_1, elementTypeProvider.getAssign_OpEqualsSignKeyword_1_0_0ElementType());
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:273:6: lv_op_1_2= '+='
                    {

                    						markLeaf();
                    					
                    lv_op_1_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleAssign712); 

                    						doneLeaf(lv_op_1_2, elementTypeProvider.getAssign_OpPlusSignEqualsSignKeyword_1_0_1ElementType());
                    					

                    }
                    break;

            }


            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleAssign744); 

            			doneLeaf(otherlv_2, elementTypeProvider.getAssign_LeftSquareBracketKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:290:3: ( ( (lv_val_3_0= RULE_INT ) ) (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:291:4: ( (lv_val_3_0= RULE_INT ) ) (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:291:4: ( (lv_val_3_0= RULE_INT ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:292:5: (lv_val_3_0= RULE_INT )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:292:5: (lv_val_3_0= RULE_INT )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:293:6: lv_val_3_0= RULE_INT
                    {

                    						markLeaf();
                    					
                    lv_val_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleAssign779); 

                    						doneLeaf(lv_val_3_0, elementTypeProvider.getAssign_ValINTTerminalRuleCall_3_0_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:302:4: (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==17) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:303:5: otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) )
                    	    {

                    	    					markLeaf();
                    	    				
                    	    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAssign816); 

                    	    					doneLeaf(otherlv_4, elementTypeProvider.getAssign_CommaKeyword_3_1_0ElementType());
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:310:5: ( (lv_val_5_0= RULE_INT ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:311:6: (lv_val_5_0= RULE_INT )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:311:6: (lv_val_5_0= RULE_INT )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:312:7: lv_val_5_0= RULE_INT
                    	    {

                    	    							markLeaf();
                    	    						
                    	    lv_val_5_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleAssign853); 

                    	    							doneLeaf(lv_val_5_0, elementTypeProvider.getAssign_ValINTTerminalRuleCall_3_1_1_0ElementType());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_6=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAssign895); 

            			doneLeaf(otherlv_6, elementTypeProvider.getAssign_RightSquareBracketKeyword_4ElementType());
            		

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
    // $ANTLR end "ruleAssign"


    // $ANTLR start "entryRuleMeth"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:334:1: entryRuleMeth : ruleMeth EOF ;
    public final void entryRuleMeth() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:334:14: ( ruleMeth EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:335:2: ruleMeth EOF
            {
             markComposite(elementTypeProvider.getMethElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMeth_in_entryRuleMeth915);
            ruleMeth();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMeth921); 

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
    // $ANTLR end "entryRuleMeth"


    // $ANTLR start "ruleMeth"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:341:1: ruleMeth : (otherlv_0= 'void' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ')' ) ;
    public final void ruleMeth() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:341:9: ( (otherlv_0= 'void' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ')' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:342:2: (otherlv_0= 'void' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ')' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:342:2: (otherlv_0= 'void' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ')' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:343:3: otherlv_0= 'void' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ')'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleMeth940); 

            			doneLeaf(otherlv_0, elementTypeProvider.getMeth_VoidKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:350:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:351:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:351:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:352:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMeth967); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getMeth_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleMeth992); 

            			doneLeaf(otherlv_2, elementTypeProvider.getMeth_LeftParenthesisKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:368:3: ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:369:4: ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:369:4: ( (lv_param_3_0= ruleParam ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:370:5: (lv_param_3_0= ruleParam )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:370:5: (lv_param_3_0= ruleParam )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:371:6: lv_param_3_0= ruleParam
                    {

                    						markComposite(elementTypeProvider.getMeth_ParamParamParserRuleCall_3_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleParam_in_ruleMeth1027);
                    ruleParam();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:380:4: (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==17) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:381:5: otherlv_4= ',' ( (lv_param_5_0= ruleParam ) )
                    	    {

                    	    					markLeaf();
                    	    				
                    	    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMeth1064); 

                    	    					doneLeaf(otherlv_4, elementTypeProvider.getMeth_CommaKeyword_3_1_0ElementType());
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:388:5: ( (lv_param_5_0= ruleParam ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:389:6: (lv_param_5_0= ruleParam )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:389:6: (lv_param_5_0= ruleParam )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:390:7: lv_param_5_0= ruleParam
                    	    {

                    	    							markComposite(elementTypeProvider.getMeth_ParamParamParserRuleCall_3_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleParam_in_ruleMeth1101);
                    	    ruleParam();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_6=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleMeth1143); 

            			doneLeaf(otherlv_6, elementTypeProvider.getMeth_RightParenthesisKeyword_4ElementType());
            		

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
    // $ANTLR end "ruleMeth"


    // $ANTLR start "entryRuleParam"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:412:1: entryRuleParam : ruleParam EOF ;
    public final void entryRuleParam() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:412:15: ( ruleParam EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:413:2: ruleParam EOF
            {
             markComposite(elementTypeProvider.getParamElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParam_in_entryRuleParam1163);
            ruleParam();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParam1169); 

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
    // $ANTLR end "entryRuleParam"


    // $ANTLR start "ruleParam"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:419:1: ruleParam : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= RULE_ID ) ) ) ;
    public final void ruleParam() throws RecognitionException {
        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_type_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:419:10: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:420:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:420:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:421:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:421:3: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:422:4: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:422:4: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:423:5: lv_name_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParam1201); 

            					doneLeaf(lv_name_0_0, elementTypeProvider.getParam_NameIDTerminalRuleCall_0_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleParam1226); 

            			doneLeaf(otherlv_1, elementTypeProvider.getParam_ColonKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:439:3: ( (lv_type_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:440:4: (lv_type_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:440:4: (lv_type_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:441:5: lv_type_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_type_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParam1253); 

            					doneLeaf(lv_type_2_0, elementTypeProvider.getParam_TypeIDTerminalRuleCall_2_0ElementType());
            				

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
    // $ANTLR end "ruleParam"


    // $ANTLR start "entryRuleSpace"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:454:1: entryRuleSpace : ruleSpace EOF ;
    public final void entryRuleSpace() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:454:15: ( ruleSpace EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:455:2: ruleSpace EOF
            {
             markComposite(elementTypeProvider.getSpaceElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpace_in_entryRuleSpace1284);
            ruleSpace();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpace1290); 

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
    // $ANTLR end "entryRuleSpace"


    // $ANTLR start "ruleSpace"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:461:1: ruleSpace : (otherlv_0= 'space' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final void ruleSpace() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:461:10: ( (otherlv_0= 'space' ( (lv_val_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:462:2: (otherlv_0= 'space' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:462:2: (otherlv_0= 'space' ( (lv_val_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:463:3: otherlv_0= 'space' ( (lv_val_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleSpace1309); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSpace_SpaceKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:470:3: ( (lv_val_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:471:4: (lv_val_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:471:4: (lv_val_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:472:5: lv_val_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSpace1336); 

            					doneLeaf(lv_val_1_0, elementTypeProvider.getSpace_ValIDTerminalRuleCall_1_0ElementType());
            				

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
    // $ANTLR end "ruleSpace"


    // $ANTLR start "entryRuleTestLinewrap"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:485:1: entryRuleTestLinewrap : ruleTestLinewrap EOF ;
    public final void entryRuleTestLinewrap() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:485:22: ( ruleTestLinewrap EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:486:2: ruleTestLinewrap EOF
            {
             markComposite(elementTypeProvider.getTestLinewrapElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTestLinewrap_in_entryRuleTestLinewrap1367);
            ruleTestLinewrap();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestLinewrap1373); 

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
    // $ANTLR end "entryRuleTestLinewrap"


    // $ANTLR start "ruleTestLinewrap"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:492:1: ruleTestLinewrap : ( () otherlv_1= 'linewrap' ( (lv_items_2_0= ruleLine ) )* ) ;
    public final void ruleTestLinewrap() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:492:17: ( ( () otherlv_1= 'linewrap' ( (lv_items_2_0= ruleLine ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:493:2: ( () otherlv_1= 'linewrap' ( (lv_items_2_0= ruleLine ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:493:2: ( () otherlv_1= 'linewrap' ( (lv_items_2_0= ruleLine ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:494:3: () otherlv_1= 'linewrap' ( (lv_items_2_0= ruleLine ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:494:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:495:4: 
            {

            				precedeComposite(elementTypeProvider.getTestLinewrap_TestLinewrapAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleTestLinewrap1405); 

            			doneLeaf(otherlv_1, elementTypeProvider.getTestLinewrap_LinewrapKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:507:3: ( (lv_items_2_0= ruleLine ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID||LA8_0==19||LA8_0==23||LA8_0==29||(LA8_0>=31 && LA8_0<=33)||LA8_0==37) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:508:4: (lv_items_2_0= ruleLine )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:508:4: (lv_items_2_0= ruleLine )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:509:5: lv_items_2_0= ruleLine
            	    {

            	    					markComposite(elementTypeProvider.getTestLinewrap_ItemsLineParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleLine_in_ruleTestLinewrap1432);
            	    ruleLine();

            	    state._fsp--;


            	    					doneComposite();
            	    				

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
    // $ANTLR end "ruleTestLinewrap"


    // $ANTLR start "entryRuleTestLinewrapMinMax"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:522:1: entryRuleTestLinewrapMinMax : ruleTestLinewrapMinMax EOF ;
    public final void entryRuleTestLinewrapMinMax() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:522:28: ( ruleTestLinewrapMinMax EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:523:2: ruleTestLinewrapMinMax EOF
            {
             markComposite(elementTypeProvider.getTestLinewrapMinMaxElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTestLinewrapMinMax_in_entryRuleTestLinewrapMinMax1464);
            ruleTestLinewrapMinMax();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestLinewrapMinMax1470); 

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
    // $ANTLR end "entryRuleTestLinewrapMinMax"


    // $ANTLR start "ruleTestLinewrapMinMax"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:529:1: ruleTestLinewrapMinMax : ( () otherlv_1= 'wrapminmax' ( (lv_items_2_0= ruleLine ) )* ) ;
    public final void ruleTestLinewrapMinMax() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:529:23: ( ( () otherlv_1= 'wrapminmax' ( (lv_items_2_0= ruleLine ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:530:2: ( () otherlv_1= 'wrapminmax' ( (lv_items_2_0= ruleLine ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:530:2: ( () otherlv_1= 'wrapminmax' ( (lv_items_2_0= ruleLine ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:531:3: () otherlv_1= 'wrapminmax' ( (lv_items_2_0= ruleLine ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:531:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:532:4: 
            {

            				precedeComposite(elementTypeProvider.getTestLinewrapMinMax_TestLinewrapMinMaxAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleTestLinewrapMinMax1502); 

            			doneLeaf(otherlv_1, elementTypeProvider.getTestLinewrapMinMax_WrapminmaxKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:544:3: ( (lv_items_2_0= ruleLine ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID||LA9_0==19||LA9_0==23||LA9_0==29||(LA9_0>=31 && LA9_0<=33)||LA9_0==37) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:545:4: (lv_items_2_0= ruleLine )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:545:4: (lv_items_2_0= ruleLine )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:546:5: lv_items_2_0= ruleLine
            	    {

            	    					markComposite(elementTypeProvider.getTestLinewrapMinMax_ItemsLineParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleLine_in_ruleTestLinewrapMinMax1529);
            	    ruleLine();

            	    state._fsp--;


            	    					doneComposite();
            	    				

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
    // $ANTLR end "ruleTestLinewrapMinMax"


    // $ANTLR start "entryRuleTestIndentation"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:559:1: entryRuleTestIndentation : ruleTestIndentation EOF ;
    public final void entryRuleTestIndentation() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:559:25: ( ruleTestIndentation EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:560:2: ruleTestIndentation EOF
            {
             markComposite(elementTypeProvider.getTestIndentationElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTestIndentation_in_entryRuleTestIndentation1561);
            ruleTestIndentation();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestIndentation1567); 

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
    // $ANTLR end "entryRuleTestIndentation"


    // $ANTLR start "ruleTestIndentation"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:566:1: ruleTestIndentation : ( () otherlv_1= 'indentation' otherlv_2= '{' ( ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? ) ;
    public final void ruleTestIndentation() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_semi_5_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:566:20: ( ( () otherlv_1= 'indentation' otherlv_2= '{' ( ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:567:2: ( () otherlv_1= 'indentation' otherlv_2= '{' ( ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:567:2: ( () otherlv_1= 'indentation' otherlv_2= '{' ( ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:568:3: () otherlv_1= 'indentation' otherlv_2= '{' ( ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:568:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:569:4: 
            {

            				precedeComposite(elementTypeProvider.getTestIndentation_TestIndentationAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleTestIndentation1599); 

            			doneLeaf(otherlv_1, elementTypeProvider.getTestIndentation_IndentationKeyword_1ElementType());
            		

            			markLeaf();
            		
            otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleTestIndentation1613); 

            			doneLeaf(otherlv_2, elementTypeProvider.getTestIndentation_LeftCurlyBracketKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:588:3: ( ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID||LA11_0==19||LA11_0==23||LA11_0==26||LA11_0==29||(LA11_0>=31 && LA11_0<=33)||LA11_0==37) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:589:4: ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:589:4: ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:590:5: (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:590:5: (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation )
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( (LA10_0==RULE_ID||LA10_0==19||LA10_0==23||LA10_0==29||(LA10_0>=31 && LA10_0<=33)||LA10_0==37) ) {
            	        alt10=1;
            	    }
            	    else if ( (LA10_0==26) ) {
            	        alt10=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:591:6: lv_items_3_1= ruleLine
            	            {

            	            						markComposite(elementTypeProvider.getTestIndentation_ItemsLineParserRuleCall_3_0_0ElementType());
            	            					
            	            pushFollow(FollowSets000.FOLLOW_ruleLine_in_ruleTestIndentation1648);
            	            ruleLine();

            	            state._fsp--;


            	            						doneComposite();
            	            					

            	            }
            	            break;
            	        case 2 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:599:6: lv_items_3_2= ruleTestIndentation
            	            {

            	            						markComposite(elementTypeProvider.getTestIndentation_ItemsTestIndentationParserRuleCall_3_0_1ElementType());
            	            					
            	            pushFollow(FollowSets000.FOLLOW_ruleTestIndentation_in_ruleTestIndentation1682);
            	            ruleTestIndentation();

            	            state._fsp--;


            	            						doneComposite();
            	            					

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            			markLeaf();
            		
            otherlv_4=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleTestIndentation1715); 

            			doneLeaf(otherlv_4, elementTypeProvider.getTestIndentation_RightCurlyBracketKeyword_4ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:616:3: ( (lv_semi_5_0= ';' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==13) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:617:4: (lv_semi_5_0= ';' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:617:4: (lv_semi_5_0= ';' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:618:5: lv_semi_5_0= ';'
                    {

                    					markLeaf();
                    				
                    lv_semi_5_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleTestIndentation1742); 

                    					doneLeaf(lv_semi_5_0, elementTypeProvider.getTestIndentation_SemiSemicolonKeyword_5_0ElementType());
                    				

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
    // $ANTLR end "ruleTestIndentation"


    // $ANTLR start "entryRuleFqnObj"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:631:1: entryRuleFqnObj : ruleFqnObj EOF ;
    public final void entryRuleFqnObj() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:631:16: ( ruleFqnObj EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:632:2: ruleFqnObj EOF
            {
             markComposite(elementTypeProvider.getFqnObjElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleFqnObj_in_entryRuleFqnObj1774);
            ruleFqnObj();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFqnObj1780); 

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
    // $ANTLR end "entryRuleFqnObj"


    // $ANTLR start "ruleFqnObj"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:638:1: ruleFqnObj : (otherlv_0= 'fqn' ( (lv_name_1_0= ruleFQN ) ) ) ;
    public final void ruleFqnObj() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:638:11: ( (otherlv_0= 'fqn' ( (lv_name_1_0= ruleFQN ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:639:2: (otherlv_0= 'fqn' ( (lv_name_1_0= ruleFQN ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:639:2: (otherlv_0= 'fqn' ( (lv_name_1_0= ruleFQN ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:640:3: otherlv_0= 'fqn' ( (lv_name_1_0= ruleFQN ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleFqnObj1799); 

            			doneLeaf(otherlv_0, elementTypeProvider.getFqnObj_FqnKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:647:3: ( (lv_name_1_0= ruleFQN ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:648:4: (lv_name_1_0= ruleFQN )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:648:4: (lv_name_1_0= ruleFQN )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:649:5: lv_name_1_0= ruleFQN
            {

            					markComposite(elementTypeProvider.getFqnObj_NameFQNParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleFqnObj1826);
            ruleFQN();

            state._fsp--;


            					doneComposite();
            				

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
    // $ANTLR end "ruleFqnObj"


    // $ANTLR start "entryRuleFQN"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:662:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:662:13: ( ruleFQN EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:663:2: ruleFQN EOF
            {
             markComposite(elementTypeProvider.getFQNElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN1857);
            ruleFQN();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN1863); 

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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:669:1: ruleFQN : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final void ruleFQN() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:669:8: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:670:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:670:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:671:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf();
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN1882); 

            			doneLeaf(this_ID_0, elementTypeProvider.getFQN_IDTerminalRuleCall_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:678:3: (kw= '.' this_ID_2= RULE_ID )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==30) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:679:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf();
            	    			
            	    kw=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleFQN1902); 

            	    				doneLeaf(kw, elementTypeProvider.getFQN_FullStopKeyword_1_0ElementType());
            	    			

            	    				markLeaf();
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN1919); 

            	    				doneLeaf(this_ID_2, elementTypeProvider.getFQN_IDTerminalRuleCall_1_1ElementType());
            	    			

            	    }
            	    break;

            	default :
            	    break loop13;
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
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleFqnRef"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:698:1: entryRuleFqnRef : ruleFqnRef EOF ;
    public final void entryRuleFqnRef() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:698:16: ( ruleFqnRef EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:699:2: ruleFqnRef EOF
            {
             markComposite(elementTypeProvider.getFqnRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleFqnRef_in_entryRuleFqnRef1945);
            ruleFqnRef();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFqnRef1951); 

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
    // $ANTLR end "entryRuleFqnRef"


    // $ANTLR start "ruleFqnRef"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:705:1: ruleFqnRef : (otherlv_0= 'fqnref' ( ( ruleFQN ) ) ) ;
    public final void ruleFqnRef() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:705:11: ( (otherlv_0= 'fqnref' ( ( ruleFQN ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:706:2: (otherlv_0= 'fqnref' ( ( ruleFQN ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:706:2: (otherlv_0= 'fqnref' ( ( ruleFQN ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:707:3: otherlv_0= 'fqnref' ( ( ruleFQN ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleFqnRef1970); 

            			doneLeaf(otherlv_0, elementTypeProvider.getFqnRef_FqnrefKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:714:3: ( ( ruleFQN ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:715:4: ( ruleFQN )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:715:4: ( ruleFQN )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:716:5: ruleFQN
            {

            					markComposite(elementTypeProvider.getFqnRef_RefFqnObjCrossReference_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleFqnRef1995);
            ruleFQN();

            state._fsp--;


            					doneComposite();
            				

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
    // $ANTLR end "ruleFqnRef"


    // $ANTLR start "entryRuleEnumeration"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:729:1: entryRuleEnumeration : ruleEnumeration EOF ;
    public final void entryRuleEnumeration() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:729:21: ( ruleEnumeration EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:730:2: ruleEnumeration EOF
            {
             markComposite(elementTypeProvider.getEnumerationElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumeration_in_entryRuleEnumeration2026);
            ruleEnumeration();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumeration2032); 

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
    // $ANTLR end "entryRuleEnumeration"


    // $ANTLR start "ruleEnumeration"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:736:1: ruleEnumeration : (otherlv_0= 'enum' ( (lv_val_1_0= ruleEnum1 ) )+ (otherlv_2= ',' ( (lv_val_3_0= ruleEnum1 ) ) )* ) ;
    public final void ruleEnumeration() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:736:16: ( (otherlv_0= 'enum' ( (lv_val_1_0= ruleEnum1 ) )+ (otherlv_2= ',' ( (lv_val_3_0= ruleEnum1 ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:737:2: (otherlv_0= 'enum' ( (lv_val_1_0= ruleEnum1 ) )+ (otherlv_2= ',' ( (lv_val_3_0= ruleEnum1 ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:737:2: (otherlv_0= 'enum' ( (lv_val_1_0= ruleEnum1 ) )+ (otherlv_2= ',' ( (lv_val_3_0= ruleEnum1 ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:738:3: otherlv_0= 'enum' ( (lv_val_1_0= ruleEnum1 ) )+ (otherlv_2= ',' ( (lv_val_3_0= ruleEnum1 ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleEnumeration2051); 

            			doneLeaf(otherlv_0, elementTypeProvider.getEnumeration_EnumKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:745:3: ( (lv_val_1_0= ruleEnum1 ) )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=41 && LA14_0<=43)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:746:4: (lv_val_1_0= ruleEnum1 )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:746:4: (lv_val_1_0= ruleEnum1 )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:747:5: lv_val_1_0= ruleEnum1
            	    {

            	    					markComposite(elementTypeProvider.getEnumeration_ValEnum1EnumRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleEnum1_in_ruleEnumeration2078);
            	    ruleEnum1();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:756:3: (otherlv_2= ',' ( (lv_val_3_0= ruleEnum1 ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==17) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:757:4: otherlv_2= ',' ( (lv_val_3_0= ruleEnum1 ) )
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleEnumeration2110); 

            	    				doneLeaf(otherlv_2, elementTypeProvider.getEnumeration_CommaKeyword_2_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:764:4: ( (lv_val_3_0= ruleEnum1 ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:765:5: (lv_val_3_0= ruleEnum1 )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:765:5: (lv_val_3_0= ruleEnum1 )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:766:6: lv_val_3_0= ruleEnum1
            	    {

            	    						markComposite(elementTypeProvider.getEnumeration_ValEnum1EnumRuleCall_2_1_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_ruleEnum1_in_ruleEnumeration2142);
            	    ruleEnum1();

            	    state._fsp--;


            	    						doneComposite();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // $ANTLR end "ruleEnumeration"


    // $ANTLR start "entryRuleSuppressedHidden"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:780:1: entryRuleSuppressedHidden : ruleSuppressedHidden EOF ;
    public final void entryRuleSuppressedHidden() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:782:2: ( ruleSuppressedHidden EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:783:2: ruleSuppressedHidden EOF
            {
             markComposite(elementTypeProvider.getSuppressedHiddenElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSuppressedHidden_in_entryRuleSuppressedHidden2185);
            ruleSuppressedHidden();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSuppressedHidden2191); 

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
    // $ANTLR end "entryRuleSuppressedHidden"


    // $ANTLR start "ruleSuppressedHidden"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:792:1: ruleSuppressedHidden : ( () otherlv_1= '`' ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )? otherlv_5= '`' ) ;
    public final void ruleSuppressedHidden() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:794:2: ( ( () otherlv_1= '`' ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )? otherlv_5= '`' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:795:2: ( () otherlv_1= '`' ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )? otherlv_5= '`' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:795:2: ( () otherlv_1= '`' ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )? otherlv_5= '`' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:796:3: () otherlv_1= '`' ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )? otherlv_5= '`'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:796:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:797:4: 
            {

            				precedeComposite(elementTypeProvider.getSuppressedHidden_SuppressedHiddenAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleSuppressedHidden2231); 

            			doneLeaf(otherlv_1, elementTypeProvider.getSuppressedHidden_GraveAccentKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:809:3: ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID||LA17_0==35) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:810:4: ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:810:4: ( (lv_vals_2_0= ruleSuppressedHiddenSub ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:811:5: (lv_vals_2_0= ruleSuppressedHiddenSub )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:811:5: (lv_vals_2_0= ruleSuppressedHiddenSub )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:812:6: lv_vals_2_0= ruleSuppressedHiddenSub
                    {

                    						markComposite(elementTypeProvider.getSuppressedHidden_ValsSuppressedHiddenSubParserRuleCall_2_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleSuppressedHiddenSub_in_ruleSuppressedHidden2266);
                    ruleSuppressedHiddenSub();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:821:4: (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==34) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:822:5: otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) )
                    	    {

                    	    					markLeaf();
                    	    				
                    	    otherlv_3=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleSuppressedHidden2303); 

                    	    					doneLeaf(otherlv_3, elementTypeProvider.getSuppressedHidden_PercentSignKeyword_2_1_0ElementType());
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:829:5: ( (lv_vals_4_0= ruleSuppressedHiddenSub ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:830:6: (lv_vals_4_0= ruleSuppressedHiddenSub )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:830:6: (lv_vals_4_0= ruleSuppressedHiddenSub )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:831:7: lv_vals_4_0= ruleSuppressedHiddenSub
                    	    {

                    	    							markComposite(elementTypeProvider.getSuppressedHidden_ValsSuppressedHiddenSubParserRuleCall_2_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleSuppressedHiddenSub_in_ruleSuppressedHidden2340);
                    	    ruleSuppressedHiddenSub();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_5=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleSuppressedHidden2382); 

            			doneLeaf(otherlv_5, elementTypeProvider.getSuppressedHidden_GraveAccentKeyword_3ElementType());
            		

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
    // $ANTLR end "ruleSuppressedHidden"


    // $ANTLR start "entryRuleSuppressedHiddenSub"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:856:1: entryRuleSuppressedHiddenSub : ruleSuppressedHiddenSub EOF ;
    public final void entryRuleSuppressedHiddenSub() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:856:29: ( ruleSuppressedHiddenSub EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:857:2: ruleSuppressedHiddenSub EOF
            {
             markComposite(elementTypeProvider.getSuppressedHiddenSubElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSuppressedHiddenSub_in_entryRuleSuppressedHiddenSub2406);
            ruleSuppressedHiddenSub();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSuppressedHiddenSub2412); 

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
    // $ANTLR end "entryRuleSuppressedHiddenSub"


    // $ANTLR start "ruleSuppressedHiddenSub"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:863:1: ruleSuppressedHiddenSub : ( ruleSuppressedHiddenSubSub | ruleSuppressedHiddenSubID ) ;
    public final void ruleSuppressedHiddenSub() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:863:24: ( ( ruleSuppressedHiddenSubSub | ruleSuppressedHiddenSubID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:864:2: ( ruleSuppressedHiddenSubSub | ruleSuppressedHiddenSubID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:864:2: ( ruleSuppressedHiddenSubSub | ruleSuppressedHiddenSubID )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==35) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_ID) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:865:3: ruleSuppressedHiddenSubSub
                    {

                    			markComposite(elementTypeProvider.getSuppressedHiddenSub_SuppressedHiddenSubSubParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleSuppressedHiddenSubSub_in_ruleSuppressedHiddenSub2429);
                    ruleSuppressedHiddenSubSub();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:873:3: ruleSuppressedHiddenSubID
                    {

                    			markComposite(elementTypeProvider.getSuppressedHiddenSub_SuppressedHiddenSubIDParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleSuppressedHiddenSubID_in_ruleSuppressedHiddenSub2449);
                    ruleSuppressedHiddenSubID();

                    state._fsp--;


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
        return ;
    }
    // $ANTLR end "ruleSuppressedHiddenSub"


    // $ANTLR start "entryRuleSuppressedHiddenSubSub"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:884:1: entryRuleSuppressedHiddenSubSub : ruleSuppressedHiddenSubSub EOF ;
    public final void entryRuleSuppressedHiddenSubSub() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:886:2: ( ruleSuppressedHiddenSubSub EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:887:2: ruleSuppressedHiddenSubSub EOF
            {
             markComposite(elementTypeProvider.getSuppressedHiddenSubSubElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSuppressedHiddenSubSub_in_entryRuleSuppressedHiddenSubSub2473);
            ruleSuppressedHiddenSubSub();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSuppressedHiddenSubSub2479); 

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
    // $ANTLR end "entryRuleSuppressedHiddenSubSub"


    // $ANTLR start "ruleSuppressedHiddenSubSub"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:896:1: ruleSuppressedHiddenSubSub : (otherlv_0= '<' ( (lv_idval_1_0= RULE_ID ) ) otherlv_2= '>' ) ;
    public final void ruleSuppressedHiddenSubSub() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_idval_1_0=null;
        Token otherlv_2=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:898:2: ( (otherlv_0= '<' ( (lv_idval_1_0= RULE_ID ) ) otherlv_2= '>' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:899:2: (otherlv_0= '<' ( (lv_idval_1_0= RULE_ID ) ) otherlv_2= '>' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:899:2: (otherlv_0= '<' ( (lv_idval_1_0= RULE_ID ) ) otherlv_2= '>' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:900:3: otherlv_0= '<' ( (lv_idval_1_0= RULE_ID ) ) otherlv_2= '>'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleSuppressedHiddenSubSub2506); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSuppressedHiddenSubSub_LessThanSignKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:907:3: ( (lv_idval_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:908:4: (lv_idval_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:908:4: (lv_idval_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:909:5: lv_idval_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_idval_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSuppressedHiddenSubSub2533); 

            					doneLeaf(lv_idval_1_0, elementTypeProvider.getSuppressedHiddenSubSub_IdvalIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleSuppressedHiddenSubSub2558); 

            			doneLeaf(otherlv_2, elementTypeProvider.getSuppressedHiddenSubSub_GreaterThanSignKeyword_2ElementType());
            		

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
    // $ANTLR end "ruleSuppressedHiddenSubSub"


    // $ANTLR start "entryRuleSuppressedHiddenSubID"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:932:1: entryRuleSuppressedHiddenSubID : ruleSuppressedHiddenSubID EOF ;
    public final void entryRuleSuppressedHiddenSubID() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:932:31: ( ruleSuppressedHiddenSubID EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:933:2: ruleSuppressedHiddenSubID EOF
            {
             markComposite(elementTypeProvider.getSuppressedHiddenSubIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSuppressedHiddenSubID_in_entryRuleSuppressedHiddenSubID2582);
            ruleSuppressedHiddenSubID();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSuppressedHiddenSubID2588); 

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
    // $ANTLR end "entryRuleSuppressedHiddenSubID"


    // $ANTLR start "ruleSuppressedHiddenSubID"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:939:1: ruleSuppressedHiddenSubID : ( (lv_idval_0_0= RULE_ID ) ) ;
    public final void ruleSuppressedHiddenSubID() throws RecognitionException {
        Token lv_idval_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:939:26: ( ( (lv_idval_0_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:940:2: ( (lv_idval_0_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:940:2: ( (lv_idval_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:941:3: (lv_idval_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:941:3: (lv_idval_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:942:4: lv_idval_0_0= RULE_ID
            {

            				markLeaf();
            			
            lv_idval_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSuppressedHiddenSubID2613); 

            				doneLeaf(lv_idval_0_0, elementTypeProvider.getSuppressedHiddenSubID_IdvalIDTerminalRuleCall_0ElementType());
            			

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
    // $ANTLR end "ruleSuppressedHiddenSubID"


    // $ANTLR start "entryRuleDatatype1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:954:1: entryRuleDatatype1 : ruleDatatype1 EOF ;
    public final void entryRuleDatatype1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:954:19: ( ruleDatatype1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:955:2: ruleDatatype1 EOF
            {
             markComposite(elementTypeProvider.getDatatype1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatype1_in_entryRuleDatatype12638);
            ruleDatatype1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatype12644); 

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
    // $ANTLR end "entryRuleDatatype1"


    // $ANTLR start "ruleDatatype1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:961:1: ruleDatatype1 : ruleFQN ;
    public final void ruleDatatype1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:961:14: ( ruleFQN )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:962:2: ruleFQN
            {

            		markComposite(elementTypeProvider.getDatatype1_FQNParserRuleCallElementType());
            	
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleDatatype12656);
            ruleFQN();

            state._fsp--;


            		doneComposite();
            	

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
    // $ANTLR end "ruleDatatype1"


    // $ANTLR start "entryRuleDatatype2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:972:1: entryRuleDatatype2 : ruleDatatype2 EOF ;
    public final void entryRuleDatatype2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:972:19: ( ruleDatatype2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:973:2: ruleDatatype2 EOF
            {
             markComposite(elementTypeProvider.getDatatype2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatype2_in_entryRuleDatatype22672);
            ruleDatatype2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatype22678); 

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
    // $ANTLR end "entryRuleDatatype2"


    // $ANTLR start "ruleDatatype2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:979:1: ruleDatatype2 : ruleFQN ;
    public final void ruleDatatype2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:979:14: ( ruleFQN )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:980:2: ruleFQN
            {

            		markComposite(elementTypeProvider.getDatatype2_FQNParserRuleCallElementType());
            	
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleDatatype22690);
            ruleFQN();

            state._fsp--;


            		doneComposite();
            	

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
    // $ANTLR end "ruleDatatype2"


    // $ANTLR start "entryRuleDatatype3"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:990:1: entryRuleDatatype3 : ruleDatatype3 EOF ;
    public final void entryRuleDatatype3() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:990:19: ( ruleDatatype3 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:991:2: ruleDatatype3 EOF
            {
             markComposite(elementTypeProvider.getDatatype3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatype3_in_entryRuleDatatype32706);
            ruleDatatype3();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatype32712); 

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
    // $ANTLR end "entryRuleDatatype3"


    // $ANTLR start "ruleDatatype3"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:997:1: ruleDatatype3 : ruleFQN ;
    public final void ruleDatatype3() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:997:14: ( ruleFQN )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:998:2: ruleFQN
            {

            		markComposite(elementTypeProvider.getDatatype3_FQNParserRuleCallElementType());
            	
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleDatatype32724);
            ruleFQN();

            state._fsp--;


            		doneComposite();
            	

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
    // $ANTLR end "ruleDatatype3"


    // $ANTLR start "entryRuleDatatypes"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1008:1: entryRuleDatatypes : ruleDatatypes EOF ;
    public final void entryRuleDatatypes() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1008:19: ( ruleDatatypes EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1009:2: ruleDatatypes EOF
            {
             markComposite(elementTypeProvider.getDatatypesElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypes_in_entryRuleDatatypes2740);
            ruleDatatypes();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypes2746); 

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
    // $ANTLR end "entryRuleDatatypes"


    // $ANTLR start "ruleDatatypes"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1015:1: ruleDatatypes : (otherlv_0= 'datatypes' ( (lv_val1_1_0= ruleDatatype1 ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= ruleDatatype2 ) ) ( (lv_val3_4_0= ruleDatatype3 ) ) otherlv_5= 'kw3' ) ;
    public final void ruleDatatypes() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1015:14: ( (otherlv_0= 'datatypes' ( (lv_val1_1_0= ruleDatatype1 ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= ruleDatatype2 ) ) ( (lv_val3_4_0= ruleDatatype3 ) ) otherlv_5= 'kw3' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1016:2: (otherlv_0= 'datatypes' ( (lv_val1_1_0= ruleDatatype1 ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= ruleDatatype2 ) ) ( (lv_val3_4_0= ruleDatatype3 ) ) otherlv_5= 'kw3' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1016:2: (otherlv_0= 'datatypes' ( (lv_val1_1_0= ruleDatatype1 ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= ruleDatatype2 ) ) ( (lv_val3_4_0= ruleDatatype3 ) ) otherlv_5= 'kw3' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1017:3: otherlv_0= 'datatypes' ( (lv_val1_1_0= ruleDatatype1 ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= ruleDatatype2 ) ) ( (lv_val3_4_0= ruleDatatype3 ) ) otherlv_5= 'kw3'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleDatatypes2765); 

            			doneLeaf(otherlv_0, elementTypeProvider.getDatatypes_DatatypesKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1024:3: ( (lv_val1_1_0= ruleDatatype1 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1025:4: (lv_val1_1_0= ruleDatatype1 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1025:4: (lv_val1_1_0= ruleDatatype1 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1026:5: lv_val1_1_0= ruleDatatype1
            {

            					markComposite(elementTypeProvider.getDatatypes_Val1Datatype1ParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleDatatype1_in_ruleDatatypes2792);
            ruleDatatype1();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleDatatypes2817); 

            			doneLeaf(otherlv_2, elementTypeProvider.getDatatypes_Kw1Keyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1042:3: ( (lv_val2_3_0= ruleDatatype2 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1043:4: (lv_val2_3_0= ruleDatatype2 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1043:4: (lv_val2_3_0= ruleDatatype2 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1044:5: lv_val2_3_0= ruleDatatype2
            {

            					markComposite(elementTypeProvider.getDatatypes_Val2Datatype2ParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleDatatype2_in_ruleDatatypes2844);
            ruleDatatype2();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1053:3: ( (lv_val3_4_0= ruleDatatype3 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1054:4: (lv_val3_4_0= ruleDatatype3 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1054:4: (lv_val3_4_0= ruleDatatype3 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1055:5: lv_val3_4_0= ruleDatatype3
            {

            					markComposite(elementTypeProvider.getDatatypes_Val3Datatype3ParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleDatatype3_in_ruleDatatypes2882);
            ruleDatatype3();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf();
            		
            otherlv_5=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleDatatypes2907); 

            			doneLeaf(otherlv_5, elementTypeProvider.getDatatypes_Kw3Keyword_5ElementType());
            		

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
    // $ANTLR end "ruleDatatypes"


    // $ANTLR start "entryRuleWrappingDataTypeTest"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1075:1: entryRuleWrappingDataTypeTest : ruleWrappingDataTypeTest EOF ;
    public final void entryRuleWrappingDataTypeTest() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1075:30: ( ruleWrappingDataTypeTest EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1076:2: ruleWrappingDataTypeTest EOF
            {
             markComposite(elementTypeProvider.getWrappingDataTypeTestElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleWrappingDataTypeTest_in_entryRuleWrappingDataTypeTest2927);
            ruleWrappingDataTypeTest();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWrappingDataTypeTest2933); 

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
    // $ANTLR end "entryRuleWrappingDataTypeTest"


    // $ANTLR start "ruleWrappingDataTypeTest"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1082:1: ruleWrappingDataTypeTest : (otherlv_0= 'wrappingdt' ( (lv_datatype_1_0= ruleWrappingDataType ) ) otherlv_2= 'kw1' ) ;
    public final void ruleWrappingDataTypeTest() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1082:25: ( (otherlv_0= 'wrappingdt' ( (lv_datatype_1_0= ruleWrappingDataType ) ) otherlv_2= 'kw1' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1083:2: (otherlv_0= 'wrappingdt' ( (lv_datatype_1_0= ruleWrappingDataType ) ) otherlv_2= 'kw1' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1083:2: (otherlv_0= 'wrappingdt' ( (lv_datatype_1_0= ruleWrappingDataType ) ) otherlv_2= 'kw1' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1084:3: otherlv_0= 'wrappingdt' ( (lv_datatype_1_0= ruleWrappingDataType ) ) otherlv_2= 'kw1'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleWrappingDataTypeTest2952); 

            			doneLeaf(otherlv_0, elementTypeProvider.getWrappingDataTypeTest_WrappingdtKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1091:3: ( (lv_datatype_1_0= ruleWrappingDataType ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1092:4: (lv_datatype_1_0= ruleWrappingDataType )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1092:4: (lv_datatype_1_0= ruleWrappingDataType )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1093:5: lv_datatype_1_0= ruleWrappingDataType
            {

            					markComposite(elementTypeProvider.getWrappingDataTypeTest_DatatypeWrappingDataTypeParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleWrappingDataType_in_ruleWrappingDataTypeTest2979);
            ruleWrappingDataType();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleWrappingDataTypeTest3004); 

            			doneLeaf(otherlv_2, elementTypeProvider.getWrappingDataTypeTest_Kw1Keyword_2ElementType());
            		

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
    // $ANTLR end "ruleWrappingDataTypeTest"


    // $ANTLR start "entryRuleWrappingDataType"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1113:1: entryRuleWrappingDataType : ruleWrappingDataType EOF ;
    public final void entryRuleWrappingDataType() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1113:26: ( ruleWrappingDataType EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1114:2: ruleWrappingDataType EOF
            {
             markComposite(elementTypeProvider.getWrappingDataTypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleWrappingDataType_in_entryRuleWrappingDataType3024);
            ruleWrappingDataType();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWrappingDataType3030); 

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
    // $ANTLR end "entryRuleWrappingDataType"


    // $ANTLR start "ruleWrappingDataType"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1120:1: ruleWrappingDataType : (this_ID_0= RULE_ID )+ ;
    public final void ruleWrappingDataType() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1120:21: ( (this_ID_0= RULE_ID )+ )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1121:2: (this_ID_0= RULE_ID )+
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1121:2: (this_ID_0= RULE_ID )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1122:3: this_ID_0= RULE_ID
            	    {

            	    			markLeaf();
            	    		
            	    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleWrappingDataType3049); 

            	    			doneLeaf(this_ID_0, elementTypeProvider.getWrappingDataType_IDTerminalRuleCallElementType());
            	    		

            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
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
    // $ANTLR end "ruleWrappingDataType"


    // $ANTLR start "ruleEnum1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1133:1: ruleEnum1 : ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) | (enumLiteral_2= 'lit3' ) ) ;
    public final void ruleEnum1() throws RecognitionException {
        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1133:10: ( ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) | (enumLiteral_2= 'lit3' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1134:2: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) | (enumLiteral_2= 'lit3' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1134:2: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) | (enumLiteral_2= 'lit3' ) )
            int alt20=3;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt20=1;
                }
                break;
            case 42:
                {
                alt20=2;
                }
                break;
            case 43:
                {
                alt20=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1135:3: (enumLiteral_0= 'lit1' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1135:3: (enumLiteral_0= 'lit1' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1136:4: enumLiteral_0= 'lit1'
                    {

                    				markLeaf();
                    			
                    enumLiteral_0=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleEnum13083); 

                    				doneLeaf(enumLiteral_0, elementTypeProvider.getEnum1_Lit1EnumLiteralDeclaration_0ElementType());
                    			

                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1145:3: (enumLiteral_1= 'lit2' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1145:3: (enumLiteral_1= 'lit2' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1146:4: enumLiteral_1= 'lit2'
                    {

                    				markLeaf();
                    			
                    enumLiteral_1=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleEnum13116); 

                    				doneLeaf(enumLiteral_1, elementTypeProvider.getEnum1_Lit2EnumLiteralDeclaration_1ElementType());
                    			

                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1155:3: (enumLiteral_2= 'lit3' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1155:3: (enumLiteral_2= 'lit3' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1156:4: enumLiteral_2= 'lit3'
                    {

                    				markLeaf();
                    			
                    enumLiteral_2=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleEnum13149); 

                    				doneLeaf(enumLiteral_2, elementTypeProvider.getEnum1_Lit3EnumLiteralDeclaration_2ElementType());
                    			

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
    // $ANTLR end "ruleEnum1"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    static final String DFA2_eotS =
        "\13\uffff";
    static final String DFA2_eofS =
        "\13\uffff";
    static final String DFA2_minS =
        "\2\4\11\uffff";
    static final String DFA2_maxS =
        "\1\45\1\17\11\uffff";
    static final String DFA2_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\1\1\2";
    static final String DFA2_specialS =
        "\13\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\1\16\uffff\1\2\3\uffff\1\7\5\uffff\1\3\1\uffff\1\4\1\5\1\6\3\uffff\1\10",
            "\1\11\11\uffff\2\12",
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

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "114:3: ( ruleDecl | ruleAssign | ruleMeth | ruleFqnObj | ruleFqnRef | ruleEnumeration | ( ruleSuppressedHidden otherlv_7= 'post' ) | ruleSpace | ruleDatatypes )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleRoot79 = new BitSet(new long[]{0x0000010007000000L});
        public static final BitSet FOLLOW_ruleTestLinewrap_in_ruleRoot97 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestIndentation_in_ruleRoot121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestLinewrapMinMax_in_ruleRoot145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWrappingDataTypeTest_in_ruleRoot169 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLine_in_entryRuleLine194 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLine200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDecl_in_ruleLine223 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleAssign_in_ruleLine247 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleMeth_in_ruleLine271 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleFqnObj_in_ruleLine295 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleFqnRef_in_ruleLine319 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleEnumeration_in_ruleLine343 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleSuppressedHidden_in_ruleLine374 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleLine394 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleSpace_in_ruleLine424 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleDatatypes_in_ruleLine448 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleLine467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDecl_in_entryRuleDecl487 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDecl493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDecl525 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDecl563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssign_in_entryRuleAssign594 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssign600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssign632 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleAssign678 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_15_in_ruleAssign712 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleAssign744 = new BitSet(new long[]{0x0000000000040020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleAssign779 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_17_in_ruleAssign816 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleAssign853 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_18_in_ruleAssign895 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMeth_in_entryRuleMeth915 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMeth921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleMeth940 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMeth967 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleMeth992 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_ruleParam_in_ruleMeth1027 = new BitSet(new long[]{0x0000000000220000L});
        public static final BitSet FOLLOW_17_in_ruleMeth1064 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleParam_in_ruleMeth1101 = new BitSet(new long[]{0x0000000000220000L});
        public static final BitSet FOLLOW_21_in_ruleMeth1143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParam_in_entryRuleParam1163 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParam1169 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParam1201 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleParam1226 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParam1253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpace_in_entryRuleSpace1284 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpace1290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleSpace1309 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSpace1336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestLinewrap_in_entryRuleTestLinewrap1367 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestLinewrap1373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleTestLinewrap1405 = new BitSet(new long[]{0x00000023A0880012L});
        public static final BitSet FOLLOW_ruleLine_in_ruleTestLinewrap1432 = new BitSet(new long[]{0x00000023A0880012L});
        public static final BitSet FOLLOW_ruleTestLinewrapMinMax_in_entryRuleTestLinewrapMinMax1464 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestLinewrapMinMax1470 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleTestLinewrapMinMax1502 = new BitSet(new long[]{0x00000023A0880012L});
        public static final BitSet FOLLOW_ruleLine_in_ruleTestLinewrapMinMax1529 = new BitSet(new long[]{0x00000023A0880012L});
        public static final BitSet FOLLOW_ruleTestIndentation_in_entryRuleTestIndentation1561 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestIndentation1567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleTestIndentation1599 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleTestIndentation1613 = new BitSet(new long[]{0x00000023B4880010L});
        public static final BitSet FOLLOW_ruleLine_in_ruleTestIndentation1648 = new BitSet(new long[]{0x00000023B4880010L});
        public static final BitSet FOLLOW_ruleTestIndentation_in_ruleTestIndentation1682 = new BitSet(new long[]{0x00000023B4880010L});
        public static final BitSet FOLLOW_28_in_ruleTestIndentation1715 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleTestIndentation1742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFqnObj_in_entryRuleFqnObj1774 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFqnObj1780 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleFqnObj1799 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleFqnObj1826 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN1857 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN1863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN1882 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_ruleFQN1902 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN1919 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_ruleFqnRef_in_entryRuleFqnRef1945 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFqnRef1951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleFqnRef1970 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleFqnRef1995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumeration_in_entryRuleEnumeration2026 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumeration2032 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleEnumeration2051 = new BitSet(new long[]{0x00000E0000000000L});
        public static final BitSet FOLLOW_ruleEnum1_in_ruleEnumeration2078 = new BitSet(new long[]{0x00000E0000020002L});
        public static final BitSet FOLLOW_17_in_ruleEnumeration2110 = new BitSet(new long[]{0x00000E0000000000L});
        public static final BitSet FOLLOW_ruleEnum1_in_ruleEnumeration2142 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_ruleSuppressedHidden_in_entryRuleSuppressedHidden2185 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSuppressedHidden2191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleSuppressedHidden2231 = new BitSet(new long[]{0x0000000A00000010L});
        public static final BitSet FOLLOW_ruleSuppressedHiddenSub_in_ruleSuppressedHidden2266 = new BitSet(new long[]{0x0000000600000000L});
        public static final BitSet FOLLOW_34_in_ruleSuppressedHidden2303 = new BitSet(new long[]{0x0000000800000010L});
        public static final BitSet FOLLOW_ruleSuppressedHiddenSub_in_ruleSuppressedHidden2340 = new BitSet(new long[]{0x0000000600000000L});
        public static final BitSet FOLLOW_33_in_ruleSuppressedHidden2382 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSuppressedHiddenSub_in_entryRuleSuppressedHiddenSub2406 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSuppressedHiddenSub2412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSuppressedHiddenSubSub_in_ruleSuppressedHiddenSub2429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSuppressedHiddenSubID_in_ruleSuppressedHiddenSub2449 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSuppressedHiddenSubSub_in_entryRuleSuppressedHiddenSubSub2473 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSuppressedHiddenSubSub2479 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleSuppressedHiddenSubSub2506 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSuppressedHiddenSubSub2533 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_36_in_ruleSuppressedHiddenSubSub2558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSuppressedHiddenSubID_in_entryRuleSuppressedHiddenSubID2582 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSuppressedHiddenSubID2588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSuppressedHiddenSubID2613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype1_in_entryRuleDatatype12638 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatype12644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleDatatype12656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype2_in_entryRuleDatatype22672 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatype22678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleDatatype22690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype3_in_entryRuleDatatype32706 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatype32712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleDatatype32724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypes_in_entryRuleDatatypes2740 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypes2746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleDatatypes2765 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDatatype1_in_ruleDatatypes2792 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_38_in_ruleDatatypes2817 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDatatype2_in_ruleDatatypes2844 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDatatype3_in_ruleDatatypes2882 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_39_in_ruleDatatypes2907 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWrappingDataTypeTest_in_entryRuleWrappingDataTypeTest2927 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWrappingDataTypeTest2933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleWrappingDataTypeTest2952 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleWrappingDataType_in_ruleWrappingDataTypeTest2979 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_38_in_ruleWrappingDataTypeTest3004 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWrappingDataType_in_entryRuleWrappingDataType3024 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWrappingDataType3030 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleWrappingDataType3049 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_41_in_ruleEnum13083 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleEnum13116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleEnum13149 = new BitSet(new long[]{0x0000000000000002L});
    }


}