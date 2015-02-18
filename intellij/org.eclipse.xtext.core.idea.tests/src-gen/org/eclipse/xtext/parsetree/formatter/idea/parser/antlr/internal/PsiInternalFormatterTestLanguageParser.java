package org.eclipse.xtext.parsetree.formatter.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.formatter.idea.lang.FormatterTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:50:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:50:14: ( ruleRoot EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:51:2: ruleRoot EOF
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
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleRoot83); 

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
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleTestLinewrap_in_ruleRoot101);
                    ruleTestLinewrap();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:77:4: ruleTestIndentation
                    {

                    				markComposite(elementTypeProvider.getRoot_TestIndentationParserRuleCall_1_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleTestIndentation_in_ruleRoot125);
                    ruleTestIndentation();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:85:4: ruleTestLinewrapMinMax
                    {

                    				markComposite(elementTypeProvider.getRoot_TestLinewrapMinMaxParserRuleCall_1_2ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleTestLinewrapMinMax_in_ruleRoot149);
                    ruleTestLinewrapMinMax();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:93:4: ruleWrappingDataTypeTest
                    {

                    				markComposite(elementTypeProvider.getRoot_WrappingDataTypeTestParserRuleCall_1_3ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleWrappingDataTypeTest_in_ruleRoot173);
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
            pushFollow(FollowSets000.FOLLOW_ruleLine_in_entryRuleLine198);
            ruleLine();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLine204); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:114:1: ruleLine : ( ( ruleDecl | ruleAssign | ruleMeth | ruleFqnObj | ruleFqnRef | ruleEnumeration | ( ruleSuppressedHidden otherlv_7= 'post' ) | ruleSpace | ruleDatatypes ) otherlv_10= ';' ) ;
    public final void ruleLine() throws RecognitionException {
        Token otherlv_7=null;
        Token otherlv_10=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:114:9: ( ( ( ruleDecl | ruleAssign | ruleMeth | ruleFqnObj | ruleFqnRef | ruleEnumeration | ( ruleSuppressedHidden otherlv_7= 'post' ) | ruleSpace | ruleDatatypes ) otherlv_10= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:115:2: ( ( ruleDecl | ruleAssign | ruleMeth | ruleFqnObj | ruleFqnRef | ruleEnumeration | ( ruleSuppressedHidden otherlv_7= 'post' ) | ruleSpace | ruleDatatypes ) otherlv_10= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:115:2: ( ( ruleDecl | ruleAssign | ruleMeth | ruleFqnObj | ruleFqnRef | ruleEnumeration | ( ruleSuppressedHidden otherlv_7= 'post' ) | ruleSpace | ruleDatatypes ) otherlv_10= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:116:3: ( ruleDecl | ruleAssign | ruleMeth | ruleFqnObj | ruleFqnRef | ruleEnumeration | ( ruleSuppressedHidden otherlv_7= 'post' ) | ruleSpace | ruleDatatypes ) otherlv_10= ';'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:116:3: ( ruleDecl | ruleAssign | ruleMeth | ruleFqnObj | ruleFqnRef | ruleEnumeration | ( ruleSuppressedHidden otherlv_7= 'post' ) | ruleSpace | ruleDatatypes )
            int alt2=9;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:117:4: ruleDecl
                    {

                    				markComposite(elementTypeProvider.getLine_DeclParserRuleCall_0_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleDecl_in_ruleLine231);
                    ruleDecl();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:125:4: ruleAssign
                    {

                    				markComposite(elementTypeProvider.getLine_AssignParserRuleCall_0_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleAssign_in_ruleLine255);
                    ruleAssign();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:133:4: ruleMeth
                    {

                    				markComposite(elementTypeProvider.getLine_MethParserRuleCall_0_2ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleMeth_in_ruleLine279);
                    ruleMeth();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:141:4: ruleFqnObj
                    {

                    				markComposite(elementTypeProvider.getLine_FqnObjParserRuleCall_0_3ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleFqnObj_in_ruleLine303);
                    ruleFqnObj();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:149:4: ruleFqnRef
                    {

                    				markComposite(elementTypeProvider.getLine_FqnRefParserRuleCall_0_4ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleFqnRef_in_ruleLine327);
                    ruleFqnRef();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 6 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:157:4: ruleEnumeration
                    {

                    				markComposite(elementTypeProvider.getLine_EnumerationParserRuleCall_0_5ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleEnumeration_in_ruleLine351);
                    ruleEnumeration();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 7 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:165:4: ( ruleSuppressedHidden otherlv_7= 'post' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:165:4: ( ruleSuppressedHidden otherlv_7= 'post' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:166:5: ruleSuppressedHidden otherlv_7= 'post'
                    {

                    					markComposite(elementTypeProvider.getLine_SuppressedHiddenParserRuleCall_0_6_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleSuppressedHidden_in_ruleLine382);
                    ruleSuppressedHidden();

                    state._fsp--;


                    					doneComposite();
                    				

                    					markLeaf();
                    				
                    otherlv_7=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleLine402); 

                    					doneLeaf(otherlv_7, elementTypeProvider.getLine_PostKeyword_0_6_1ElementType());
                    				

                    }


                    }
                    break;
                case 8 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:182:4: ruleSpace
                    {

                    				markComposite(elementTypeProvider.getLine_SpaceParserRuleCall_0_7ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleSpace_in_ruleLine432);
                    ruleSpace();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 9 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:190:4: ruleDatatypes
                    {

                    				markComposite(elementTypeProvider.getLine_DatatypesParserRuleCall_0_8ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleDatatypes_in_ruleLine456);
                    ruleDatatypes();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleLine475); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:209:1: entryRuleDecl : ruleDecl EOF ;
    public final void entryRuleDecl() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:209:14: ( ruleDecl EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:210:2: ruleDecl EOF
            {
             markComposite(elementTypeProvider.getDeclElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDecl_in_entryRuleDecl495);
            ruleDecl();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDecl501); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:218:1: ruleDecl : ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleDecl() throws RecognitionException {
        Token lv_type_0_0=null;
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:218:9: ( ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:219:2: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:219:2: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:220:3: ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:220:3: ( (lv_type_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:221:4: (lv_type_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:221:4: (lv_type_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:222:5: lv_type_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_type_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDecl537); 

            					doneLeaf(lv_type_0_0, elementTypeProvider.getDecl_TypeIDTerminalRuleCall_0_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:231:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:232:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:232:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:233:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDecl575); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:246:1: entryRuleAssign : ruleAssign EOF ;
    public final void entryRuleAssign() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:246:16: ( ruleAssign EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:247:2: ruleAssign EOF
            {
             markComposite(elementTypeProvider.getAssignElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssign_in_entryRuleAssign606);
            ruleAssign();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssign612); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:255:1: ruleAssign : ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) otherlv_2= '[' ( ( (lv_val_3_0= RULE_INT ) ) (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )* )? otherlv_6= ']' ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:255:11: ( ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) otherlv_2= '[' ( ( (lv_val_3_0= RULE_INT ) ) (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )* )? otherlv_6= ']' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:256:2: ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) otherlv_2= '[' ( ( (lv_val_3_0= RULE_INT ) ) (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )* )? otherlv_6= ']' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:256:2: ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) otherlv_2= '[' ( ( (lv_val_3_0= RULE_INT ) ) (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )* )? otherlv_6= ']' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:257:3: ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) otherlv_2= '[' ( ( (lv_val_3_0= RULE_INT ) ) (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )* )? otherlv_6= ']'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:257:3: ( (lv_var_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:258:4: (lv_var_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:258:4: (lv_var_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:259:5: lv_var_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_var_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssign648); 

            					doneLeaf(lv_var_0_0, elementTypeProvider.getAssign_VarIDTerminalRuleCall_0_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:268:3: ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:269:4: ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:269:4: ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:270:5: (lv_op_1_1= '=' | lv_op_1_2= '+=' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:270:5: (lv_op_1_1= '=' | lv_op_1_2= '+=' )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:271:6: lv_op_1_1= '='
                    {

                    						markLeaf();
                    					
                    lv_op_1_1=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAssign694); 

                    						doneLeaf(lv_op_1_1, elementTypeProvider.getAssign_OpEqualsSignKeyword_1_0_0ElementType());
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:279:6: lv_op_1_2= '+='
                    {

                    						markLeaf();
                    					
                    lv_op_1_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleAssign728); 

                    						doneLeaf(lv_op_1_2, elementTypeProvider.getAssign_OpPlusSignEqualsSignKeyword_1_0_1ElementType());
                    					

                    }
                    break;

            }


            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleAssign760); 

            			doneLeaf(otherlv_2, elementTypeProvider.getAssign_LeftSquareBracketKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:296:3: ( ( (lv_val_3_0= RULE_INT ) ) (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:297:4: ( (lv_val_3_0= RULE_INT ) ) (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:297:4: ( (lv_val_3_0= RULE_INT ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:298:5: (lv_val_3_0= RULE_INT )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:298:5: (lv_val_3_0= RULE_INT )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:299:6: lv_val_3_0= RULE_INT
                    {

                    						markLeaf();
                    					
                    lv_val_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleAssign795); 

                    						doneLeaf(lv_val_3_0, elementTypeProvider.getAssign_ValINTTerminalRuleCall_3_0_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:308:4: (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==17) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:309:5: otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) )
                    	    {

                    	    					markLeaf();
                    	    				
                    	    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAssign832); 

                    	    					doneLeaf(otherlv_4, elementTypeProvider.getAssign_CommaKeyword_3_1_0ElementType());
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:316:5: ( (lv_val_5_0= RULE_INT ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:317:6: (lv_val_5_0= RULE_INT )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:317:6: (lv_val_5_0= RULE_INT )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:318:7: lv_val_5_0= RULE_INT
                    	    {

                    	    							markLeaf();
                    	    						
                    	    lv_val_5_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleAssign869); 

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
            		
            otherlv_6=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAssign911); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:340:1: entryRuleMeth : ruleMeth EOF ;
    public final void entryRuleMeth() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:340:14: ( ruleMeth EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:341:2: ruleMeth EOF
            {
             markComposite(elementTypeProvider.getMethElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMeth_in_entryRuleMeth931);
            ruleMeth();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMeth937); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:349:1: ruleMeth : (otherlv_0= 'void' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ')' ) ;
    public final void ruleMeth() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:349:9: ( (otherlv_0= 'void' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ')' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:350:2: (otherlv_0= 'void' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ')' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:350:2: (otherlv_0= 'void' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ')' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:351:3: otherlv_0= 'void' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ')'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleMeth960); 

            			doneLeaf(otherlv_0, elementTypeProvider.getMeth_VoidKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:358:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:359:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:359:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:360:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMeth987); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getMeth_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleMeth1012); 

            			doneLeaf(otherlv_2, elementTypeProvider.getMeth_LeftParenthesisKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:376:3: ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:377:4: ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:377:4: ( (lv_param_3_0= ruleParam ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:378:5: (lv_param_3_0= ruleParam )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:378:5: (lv_param_3_0= ruleParam )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:379:6: lv_param_3_0= ruleParam
                    {

                    						markComposite(elementTypeProvider.getMeth_ParamParamParserRuleCall_3_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleParam_in_ruleMeth1047);
                    ruleParam();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:388:4: (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==17) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:389:5: otherlv_4= ',' ( (lv_param_5_0= ruleParam ) )
                    	    {

                    	    					markLeaf();
                    	    				
                    	    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMeth1084); 

                    	    					doneLeaf(otherlv_4, elementTypeProvider.getMeth_CommaKeyword_3_1_0ElementType());
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:396:5: ( (lv_param_5_0= ruleParam ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:397:6: (lv_param_5_0= ruleParam )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:397:6: (lv_param_5_0= ruleParam )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:398:7: lv_param_5_0= ruleParam
                    	    {

                    	    							markComposite(elementTypeProvider.getMeth_ParamParamParserRuleCall_3_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleParam_in_ruleMeth1121);
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
            		
            otherlv_6=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleMeth1163); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:420:1: entryRuleParam : ruleParam EOF ;
    public final void entryRuleParam() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:420:15: ( ruleParam EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:421:2: ruleParam EOF
            {
             markComposite(elementTypeProvider.getParamElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParam_in_entryRuleParam1183);
            ruleParam();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParam1189); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:429:1: ruleParam : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= RULE_ID ) ) ) ;
    public final void ruleParam() throws RecognitionException {
        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_type_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:429:10: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:430:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:430:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:431:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:431:3: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:432:4: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:432:4: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:433:5: lv_name_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParam1225); 

            					doneLeaf(lv_name_0_0, elementTypeProvider.getParam_NameIDTerminalRuleCall_0_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleParam1250); 

            			doneLeaf(otherlv_1, elementTypeProvider.getParam_ColonKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:449:3: ( (lv_type_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:450:4: (lv_type_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:450:4: (lv_type_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:451:5: lv_type_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_type_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParam1277); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:464:1: entryRuleSpace : ruleSpace EOF ;
    public final void entryRuleSpace() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:464:15: ( ruleSpace EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:465:2: ruleSpace EOF
            {
             markComposite(elementTypeProvider.getSpaceElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpace_in_entryRuleSpace1308);
            ruleSpace();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpace1314); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:473:1: ruleSpace : (otherlv_0= 'space' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final void ruleSpace() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:473:10: ( (otherlv_0= 'space' ( (lv_val_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:474:2: (otherlv_0= 'space' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:474:2: (otherlv_0= 'space' ( (lv_val_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:475:3: otherlv_0= 'space' ( (lv_val_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleSpace1337); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSpace_SpaceKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:482:3: ( (lv_val_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:483:4: (lv_val_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:483:4: (lv_val_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:484:5: lv_val_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSpace1364); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:497:1: entryRuleTestLinewrap : ruleTestLinewrap EOF ;
    public final void entryRuleTestLinewrap() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:497:22: ( ruleTestLinewrap EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:498:2: ruleTestLinewrap EOF
            {
             markComposite(elementTypeProvider.getTestLinewrapElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTestLinewrap_in_entryRuleTestLinewrap1395);
            ruleTestLinewrap();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestLinewrap1401); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:506:1: ruleTestLinewrap : ( () otherlv_1= 'linewrap' ( (lv_items_2_0= ruleLine ) )* ) ;
    public final void ruleTestLinewrap() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:506:17: ( ( () otherlv_1= 'linewrap' ( (lv_items_2_0= ruleLine ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:507:2: ( () otherlv_1= 'linewrap' ( (lv_items_2_0= ruleLine ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:507:2: ( () otherlv_1= 'linewrap' ( (lv_items_2_0= ruleLine ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:508:3: () otherlv_1= 'linewrap' ( (lv_items_2_0= ruleLine ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:508:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:509:4: 
            {

            				precedeComposite(elementTypeProvider.getTestLinewrap_TestLinewrapAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleTestLinewrap1437); 

            			doneLeaf(otherlv_1, elementTypeProvider.getTestLinewrap_LinewrapKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:521:3: ( (lv_items_2_0= ruleLine ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID||LA8_0==19||LA8_0==23||LA8_0==29||(LA8_0>=31 && LA8_0<=33)||LA8_0==37) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:522:4: (lv_items_2_0= ruleLine )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:522:4: (lv_items_2_0= ruleLine )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:523:5: lv_items_2_0= ruleLine
            	    {

            	    					markComposite(elementTypeProvider.getTestLinewrap_ItemsLineParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleLine_in_ruleTestLinewrap1464);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:536:1: entryRuleTestLinewrapMinMax : ruleTestLinewrapMinMax EOF ;
    public final void entryRuleTestLinewrapMinMax() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:536:28: ( ruleTestLinewrapMinMax EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:537:2: ruleTestLinewrapMinMax EOF
            {
             markComposite(elementTypeProvider.getTestLinewrapMinMaxElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTestLinewrapMinMax_in_entryRuleTestLinewrapMinMax1496);
            ruleTestLinewrapMinMax();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestLinewrapMinMax1502); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:545:1: ruleTestLinewrapMinMax : ( () otherlv_1= 'wrapminmax' ( (lv_items_2_0= ruleLine ) )* ) ;
    public final void ruleTestLinewrapMinMax() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:545:23: ( ( () otherlv_1= 'wrapminmax' ( (lv_items_2_0= ruleLine ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:546:2: ( () otherlv_1= 'wrapminmax' ( (lv_items_2_0= ruleLine ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:546:2: ( () otherlv_1= 'wrapminmax' ( (lv_items_2_0= ruleLine ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:547:3: () otherlv_1= 'wrapminmax' ( (lv_items_2_0= ruleLine ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:547:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:548:4: 
            {

            				precedeComposite(elementTypeProvider.getTestLinewrapMinMax_TestLinewrapMinMaxAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleTestLinewrapMinMax1538); 

            			doneLeaf(otherlv_1, elementTypeProvider.getTestLinewrapMinMax_WrapminmaxKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:560:3: ( (lv_items_2_0= ruleLine ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID||LA9_0==19||LA9_0==23||LA9_0==29||(LA9_0>=31 && LA9_0<=33)||LA9_0==37) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:561:4: (lv_items_2_0= ruleLine )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:561:4: (lv_items_2_0= ruleLine )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:562:5: lv_items_2_0= ruleLine
            	    {

            	    					markComposite(elementTypeProvider.getTestLinewrapMinMax_ItemsLineParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleLine_in_ruleTestLinewrapMinMax1565);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:575:1: entryRuleTestIndentation : ruleTestIndentation EOF ;
    public final void entryRuleTestIndentation() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:575:25: ( ruleTestIndentation EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:576:2: ruleTestIndentation EOF
            {
             markComposite(elementTypeProvider.getTestIndentationElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTestIndentation_in_entryRuleTestIndentation1597);
            ruleTestIndentation();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestIndentation1603); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:584:1: ruleTestIndentation : ( () otherlv_1= 'indentation' otherlv_2= '{' ( ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? ) ;
    public final void ruleTestIndentation() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_semi_5_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:584:20: ( ( () otherlv_1= 'indentation' otherlv_2= '{' ( ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:585:2: ( () otherlv_1= 'indentation' otherlv_2= '{' ( ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:585:2: ( () otherlv_1= 'indentation' otherlv_2= '{' ( ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:586:3: () otherlv_1= 'indentation' otherlv_2= '{' ( ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:586:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:587:4: 
            {

            				precedeComposite(elementTypeProvider.getTestIndentation_TestIndentationAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleTestIndentation1639); 

            			doneLeaf(otherlv_1, elementTypeProvider.getTestIndentation_IndentationKeyword_1ElementType());
            		

            			markLeaf();
            		
            otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleTestIndentation1653); 

            			doneLeaf(otherlv_2, elementTypeProvider.getTestIndentation_LeftCurlyBracketKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:606:3: ( ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID||LA11_0==19||LA11_0==23||LA11_0==26||LA11_0==29||(LA11_0>=31 && LA11_0<=33)||LA11_0==37) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:607:4: ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:607:4: ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:608:5: (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:608:5: (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation )
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
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:609:6: lv_items_3_1= ruleLine
            	            {

            	            						markComposite(elementTypeProvider.getTestIndentation_ItemsLineParserRuleCall_3_0_0ElementType());
            	            					
            	            pushFollow(FollowSets000.FOLLOW_ruleLine_in_ruleTestIndentation1688);
            	            ruleLine();

            	            state._fsp--;


            	            						doneComposite();
            	            					

            	            }
            	            break;
            	        case 2 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:617:6: lv_items_3_2= ruleTestIndentation
            	            {

            	            						markComposite(elementTypeProvider.getTestIndentation_ItemsTestIndentationParserRuleCall_3_0_1ElementType());
            	            					
            	            pushFollow(FollowSets000.FOLLOW_ruleTestIndentation_in_ruleTestIndentation1722);
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
            		
            otherlv_4=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleTestIndentation1755); 

            			doneLeaf(otherlv_4, elementTypeProvider.getTestIndentation_RightCurlyBracketKeyword_4ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:634:3: ( (lv_semi_5_0= ';' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==13) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:635:4: (lv_semi_5_0= ';' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:635:4: (lv_semi_5_0= ';' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:636:5: lv_semi_5_0= ';'
                    {

                    					markLeaf();
                    				
                    lv_semi_5_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleTestIndentation1782); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:649:1: entryRuleFqnObj : ruleFqnObj EOF ;
    public final void entryRuleFqnObj() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:649:16: ( ruleFqnObj EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:650:2: ruleFqnObj EOF
            {
             markComposite(elementTypeProvider.getFqnObjElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleFqnObj_in_entryRuleFqnObj1814);
            ruleFqnObj();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFqnObj1820); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:658:1: ruleFqnObj : (otherlv_0= 'fqn' ( (lv_name_1_0= ruleFQN ) ) ) ;
    public final void ruleFqnObj() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:658:11: ( (otherlv_0= 'fqn' ( (lv_name_1_0= ruleFQN ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:659:2: (otherlv_0= 'fqn' ( (lv_name_1_0= ruleFQN ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:659:2: (otherlv_0= 'fqn' ( (lv_name_1_0= ruleFQN ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:660:3: otherlv_0= 'fqn' ( (lv_name_1_0= ruleFQN ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleFqnObj1843); 

            			doneLeaf(otherlv_0, elementTypeProvider.getFqnObj_FqnKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:667:3: ( (lv_name_1_0= ruleFQN ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:668:4: (lv_name_1_0= ruleFQN )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:668:4: (lv_name_1_0= ruleFQN )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:669:5: lv_name_1_0= ruleFQN
            {

            					markComposite(elementTypeProvider.getFqnObj_NameFQNParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleFqnObj1870);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:682:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:682:13: ( ruleFQN EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:683:2: ruleFQN EOF
            {
             markComposite(elementTypeProvider.getFQNElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN1901);
            ruleFQN();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN1907); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:691:1: ruleFQN : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final void ruleFQN() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:691:8: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:692:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:692:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:693:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf();
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN1930); 

            			doneLeaf(this_ID_0, elementTypeProvider.getFQN_IDTerminalRuleCall_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:700:3: (kw= '.' this_ID_2= RULE_ID )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==30) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:701:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf();
            	    			
            	    kw=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleFQN1950); 

            	    				doneLeaf(kw, elementTypeProvider.getFQN_FullStopKeyword_1_0ElementType());
            	    			

            	    				markLeaf();
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN1967); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:720:1: entryRuleFqnRef : ruleFqnRef EOF ;
    public final void entryRuleFqnRef() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:720:16: ( ruleFqnRef EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:721:2: ruleFqnRef EOF
            {
             markComposite(elementTypeProvider.getFqnRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleFqnRef_in_entryRuleFqnRef1993);
            ruleFqnRef();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFqnRef1999); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:729:1: ruleFqnRef : (otherlv_0= 'fqnref' ( ( ruleFQN ) ) ) ;
    public final void ruleFqnRef() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:729:11: ( (otherlv_0= 'fqnref' ( ( ruleFQN ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:730:2: (otherlv_0= 'fqnref' ( ( ruleFQN ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:730:2: (otherlv_0= 'fqnref' ( ( ruleFQN ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:731:3: otherlv_0= 'fqnref' ( ( ruleFQN ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleFqnRef2022); 

            			doneLeaf(otherlv_0, elementTypeProvider.getFqnRef_FqnrefKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:738:3: ( ( ruleFQN ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:739:4: ( ruleFQN )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:739:4: ( ruleFQN )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:740:5: ruleFQN
            {

            					markComposite(elementTypeProvider.getFqnRef_RefFqnObjCrossReference_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleFqnRef2047);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:753:1: entryRuleEnumeration : ruleEnumeration EOF ;
    public final void entryRuleEnumeration() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:753:21: ( ruleEnumeration EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:754:2: ruleEnumeration EOF
            {
             markComposite(elementTypeProvider.getEnumerationElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumeration_in_entryRuleEnumeration2078);
            ruleEnumeration();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumeration2084); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:762:1: ruleEnumeration : (otherlv_0= 'enum' ( (lv_val_1_0= ruleEnum1 ) )+ (otherlv_2= ',' ( (lv_val_3_0= ruleEnum1 ) ) )* ) ;
    public final void ruleEnumeration() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:762:16: ( (otherlv_0= 'enum' ( (lv_val_1_0= ruleEnum1 ) )+ (otherlv_2= ',' ( (lv_val_3_0= ruleEnum1 ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:763:2: (otherlv_0= 'enum' ( (lv_val_1_0= ruleEnum1 ) )+ (otherlv_2= ',' ( (lv_val_3_0= ruleEnum1 ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:763:2: (otherlv_0= 'enum' ( (lv_val_1_0= ruleEnum1 ) )+ (otherlv_2= ',' ( (lv_val_3_0= ruleEnum1 ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:764:3: otherlv_0= 'enum' ( (lv_val_1_0= ruleEnum1 ) )+ (otherlv_2= ',' ( (lv_val_3_0= ruleEnum1 ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleEnumeration2107); 

            			doneLeaf(otherlv_0, elementTypeProvider.getEnumeration_EnumKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:771:3: ( (lv_val_1_0= ruleEnum1 ) )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:772:4: (lv_val_1_0= ruleEnum1 )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:772:4: (lv_val_1_0= ruleEnum1 )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:773:5: lv_val_1_0= ruleEnum1
            	    {

            	    					markComposite(elementTypeProvider.getEnumeration_ValEnum1EnumRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleEnum1_in_ruleEnumeration2134);
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

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:782:3: (otherlv_2= ',' ( (lv_val_3_0= ruleEnum1 ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==17) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:783:4: otherlv_2= ',' ( (lv_val_3_0= ruleEnum1 ) )
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleEnumeration2166); 

            	    				doneLeaf(otherlv_2, elementTypeProvider.getEnumeration_CommaKeyword_2_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:790:4: ( (lv_val_3_0= ruleEnum1 ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:791:5: (lv_val_3_0= ruleEnum1 )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:791:5: (lv_val_3_0= ruleEnum1 )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:792:6: lv_val_3_0= ruleEnum1
            	    {

            	    						markComposite(elementTypeProvider.getEnumeration_ValEnum1EnumRuleCall_2_1_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_ruleEnum1_in_ruleEnumeration2198);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:806:1: entryRuleSuppressedHidden : ruleSuppressedHidden EOF ;
    public final void entryRuleSuppressedHidden() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:806:26: ( ruleSuppressedHidden EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:807:2: ruleSuppressedHidden EOF
            {
             markComposite(elementTypeProvider.getSuppressedHiddenElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSuppressedHidden_in_entryRuleSuppressedHidden2237);
            ruleSuppressedHidden();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSuppressedHidden2243); 

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
    // $ANTLR end "entryRuleSuppressedHidden"


    // $ANTLR start "ruleSuppressedHidden"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:815:1: ruleSuppressedHidden : ( () otherlv_1= '`' ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )? otherlv_5= '`' ) ;
    public final void ruleSuppressedHidden() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:815:21: ( ( () otherlv_1= '`' ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )? otherlv_5= '`' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:816:2: ( () otherlv_1= '`' ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )? otherlv_5= '`' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:816:2: ( () otherlv_1= '`' ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )? otherlv_5= '`' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:817:3: () otherlv_1= '`' ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )? otherlv_5= '`'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:817:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:818:4: 
            {

            				precedeComposite(elementTypeProvider.getSuppressedHidden_SuppressedHiddenAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleSuppressedHidden2279); 

            			doneLeaf(otherlv_1, elementTypeProvider.getSuppressedHidden_GraveAccentKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:830:3: ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID||LA17_0==35) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:831:4: ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:831:4: ( (lv_vals_2_0= ruleSuppressedHiddenSub ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:832:5: (lv_vals_2_0= ruleSuppressedHiddenSub )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:832:5: (lv_vals_2_0= ruleSuppressedHiddenSub )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:833:6: lv_vals_2_0= ruleSuppressedHiddenSub
                    {

                    						markComposite(elementTypeProvider.getSuppressedHidden_ValsSuppressedHiddenSubParserRuleCall_2_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleSuppressedHiddenSub_in_ruleSuppressedHidden2314);
                    ruleSuppressedHiddenSub();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:842:4: (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==34) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:843:5: otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) )
                    	    {

                    	    					markLeaf();
                    	    				
                    	    otherlv_3=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleSuppressedHidden2351); 

                    	    					doneLeaf(otherlv_3, elementTypeProvider.getSuppressedHidden_PercentSignKeyword_2_1_0ElementType());
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:850:5: ( (lv_vals_4_0= ruleSuppressedHiddenSub ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:851:6: (lv_vals_4_0= ruleSuppressedHiddenSub )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:851:6: (lv_vals_4_0= ruleSuppressedHiddenSub )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:852:7: lv_vals_4_0= ruleSuppressedHiddenSub
                    	    {

                    	    							markComposite(elementTypeProvider.getSuppressedHidden_ValsSuppressedHiddenSubParserRuleCall_2_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleSuppressedHiddenSub_in_ruleSuppressedHidden2388);
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
            		
            otherlv_5=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleSuppressedHidden2430); 

            			doneLeaf(otherlv_5, elementTypeProvider.getSuppressedHidden_GraveAccentKeyword_3ElementType());
            		

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
    // $ANTLR end "ruleSuppressedHidden"


    // $ANTLR start "entryRuleSuppressedHiddenSub"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:874:1: entryRuleSuppressedHiddenSub : ruleSuppressedHiddenSub EOF ;
    public final void entryRuleSuppressedHiddenSub() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:874:29: ( ruleSuppressedHiddenSub EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:875:2: ruleSuppressedHiddenSub EOF
            {
             markComposite(elementTypeProvider.getSuppressedHiddenSubElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSuppressedHiddenSub_in_entryRuleSuppressedHiddenSub2450);
            ruleSuppressedHiddenSub();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSuppressedHiddenSub2456); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:883:1: ruleSuppressedHiddenSub : ( ruleSuppressedHiddenSubSub | ruleSuppressedHiddenSubID ) ;
    public final void ruleSuppressedHiddenSub() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:883:24: ( ( ruleSuppressedHiddenSubSub | ruleSuppressedHiddenSubID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:884:2: ( ruleSuppressedHiddenSubSub | ruleSuppressedHiddenSubID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:884:2: ( ruleSuppressedHiddenSubSub | ruleSuppressedHiddenSubID )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:885:3: ruleSuppressedHiddenSubSub
                    {

                    			markComposite(elementTypeProvider.getSuppressedHiddenSub_SuppressedHiddenSubSubParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleSuppressedHiddenSubSub_in_ruleSuppressedHiddenSub2477);
                    ruleSuppressedHiddenSubSub();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:893:3: ruleSuppressedHiddenSubID
                    {

                    			markComposite(elementTypeProvider.getSuppressedHiddenSub_SuppressedHiddenSubIDParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleSuppressedHiddenSubID_in_ruleSuppressedHiddenSub2497);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:904:1: entryRuleSuppressedHiddenSubSub : ruleSuppressedHiddenSubSub EOF ;
    public final void entryRuleSuppressedHiddenSubSub() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:904:32: ( ruleSuppressedHiddenSubSub EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:905:2: ruleSuppressedHiddenSubSub EOF
            {
             markComposite(elementTypeProvider.getSuppressedHiddenSubSubElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSuppressedHiddenSubSub_in_entryRuleSuppressedHiddenSubSub2517);
            ruleSuppressedHiddenSubSub();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSuppressedHiddenSubSub2523); 

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
    // $ANTLR end "entryRuleSuppressedHiddenSubSub"


    // $ANTLR start "ruleSuppressedHiddenSubSub"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:913:1: ruleSuppressedHiddenSubSub : (otherlv_0= '<' ( (lv_idval_1_0= RULE_ID ) ) otherlv_2= '>' ) ;
    public final void ruleSuppressedHiddenSubSub() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_idval_1_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:913:27: ( (otherlv_0= '<' ( (lv_idval_1_0= RULE_ID ) ) otherlv_2= '>' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:914:2: (otherlv_0= '<' ( (lv_idval_1_0= RULE_ID ) ) otherlv_2= '>' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:914:2: (otherlv_0= '<' ( (lv_idval_1_0= RULE_ID ) ) otherlv_2= '>' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:915:3: otherlv_0= '<' ( (lv_idval_1_0= RULE_ID ) ) otherlv_2= '>'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleSuppressedHiddenSubSub2546); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSuppressedHiddenSubSub_LessThanSignKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:922:3: ( (lv_idval_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:923:4: (lv_idval_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:923:4: (lv_idval_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:924:5: lv_idval_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_idval_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSuppressedHiddenSubSub2573); 

            					doneLeaf(lv_idval_1_0, elementTypeProvider.getSuppressedHiddenSubSub_IdvalIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleSuppressedHiddenSubSub2598); 

            			doneLeaf(otherlv_2, elementTypeProvider.getSuppressedHiddenSubSub_GreaterThanSignKeyword_2ElementType());
            		

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
    // $ANTLR end "ruleSuppressedHiddenSubSub"


    // $ANTLR start "entryRuleSuppressedHiddenSubID"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:944:1: entryRuleSuppressedHiddenSubID : ruleSuppressedHiddenSubID EOF ;
    public final void entryRuleSuppressedHiddenSubID() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:944:31: ( ruleSuppressedHiddenSubID EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:945:2: ruleSuppressedHiddenSubID EOF
            {
             markComposite(elementTypeProvider.getSuppressedHiddenSubIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSuppressedHiddenSubID_in_entryRuleSuppressedHiddenSubID2618);
            ruleSuppressedHiddenSubID();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSuppressedHiddenSubID2624); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:953:1: ruleSuppressedHiddenSubID : ( (lv_idval_0_0= RULE_ID ) ) ;
    public final void ruleSuppressedHiddenSubID() throws RecognitionException {
        Token lv_idval_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:953:26: ( ( (lv_idval_0_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:954:2: ( (lv_idval_0_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:954:2: ( (lv_idval_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:955:3: (lv_idval_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:955:3: (lv_idval_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:956:4: lv_idval_0_0= RULE_ID
            {

            				markLeaf();
            			
            lv_idval_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSuppressedHiddenSubID2653); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:968:1: entryRuleDatatype1 : ruleDatatype1 EOF ;
    public final void entryRuleDatatype1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:968:19: ( ruleDatatype1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:969:2: ruleDatatype1 EOF
            {
             markComposite(elementTypeProvider.getDatatype1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatype1_in_entryRuleDatatype12678);
            ruleDatatype1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatype12684); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:977:1: ruleDatatype1 : ruleFQN ;
    public final void ruleDatatype1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:977:14: ( ruleFQN )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:978:2: ruleFQN
            {

            		markComposite(elementTypeProvider.getDatatype1_FQNParserRuleCallElementType());
            	
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleDatatype12700);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:988:1: entryRuleDatatype2 : ruleDatatype2 EOF ;
    public final void entryRuleDatatype2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:988:19: ( ruleDatatype2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:989:2: ruleDatatype2 EOF
            {
             markComposite(elementTypeProvider.getDatatype2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatype2_in_entryRuleDatatype22716);
            ruleDatatype2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatype22722); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:997:1: ruleDatatype2 : ruleFQN ;
    public final void ruleDatatype2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:997:14: ( ruleFQN )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:998:2: ruleFQN
            {

            		markComposite(elementTypeProvider.getDatatype2_FQNParserRuleCallElementType());
            	
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleDatatype22738);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1008:1: entryRuleDatatype3 : ruleDatatype3 EOF ;
    public final void entryRuleDatatype3() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1008:19: ( ruleDatatype3 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1009:2: ruleDatatype3 EOF
            {
             markComposite(elementTypeProvider.getDatatype3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatype3_in_entryRuleDatatype32754);
            ruleDatatype3();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatype32760); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1017:1: ruleDatatype3 : ruleFQN ;
    public final void ruleDatatype3() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1017:14: ( ruleFQN )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1018:2: ruleFQN
            {

            		markComposite(elementTypeProvider.getDatatype3_FQNParserRuleCallElementType());
            	
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleDatatype32776);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1028:1: entryRuleDatatypes : ruleDatatypes EOF ;
    public final void entryRuleDatatypes() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1028:19: ( ruleDatatypes EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1029:2: ruleDatatypes EOF
            {
             markComposite(elementTypeProvider.getDatatypesElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypes_in_entryRuleDatatypes2792);
            ruleDatatypes();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypes2798); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1037:1: ruleDatatypes : (otherlv_0= 'datatypes' ( (lv_val1_1_0= ruleDatatype1 ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= ruleDatatype2 ) ) ( (lv_val3_4_0= ruleDatatype3 ) ) otherlv_5= 'kw3' ) ;
    public final void ruleDatatypes() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1037:14: ( (otherlv_0= 'datatypes' ( (lv_val1_1_0= ruleDatatype1 ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= ruleDatatype2 ) ) ( (lv_val3_4_0= ruleDatatype3 ) ) otherlv_5= 'kw3' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1038:2: (otherlv_0= 'datatypes' ( (lv_val1_1_0= ruleDatatype1 ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= ruleDatatype2 ) ) ( (lv_val3_4_0= ruleDatatype3 ) ) otherlv_5= 'kw3' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1038:2: (otherlv_0= 'datatypes' ( (lv_val1_1_0= ruleDatatype1 ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= ruleDatatype2 ) ) ( (lv_val3_4_0= ruleDatatype3 ) ) otherlv_5= 'kw3' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1039:3: otherlv_0= 'datatypes' ( (lv_val1_1_0= ruleDatatype1 ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= ruleDatatype2 ) ) ( (lv_val3_4_0= ruleDatatype3 ) ) otherlv_5= 'kw3'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleDatatypes2821); 

            			doneLeaf(otherlv_0, elementTypeProvider.getDatatypes_DatatypesKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1046:3: ( (lv_val1_1_0= ruleDatatype1 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1047:4: (lv_val1_1_0= ruleDatatype1 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1047:4: (lv_val1_1_0= ruleDatatype1 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1048:5: lv_val1_1_0= ruleDatatype1
            {

            					markComposite(elementTypeProvider.getDatatypes_Val1Datatype1ParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleDatatype1_in_ruleDatatypes2848);
            ruleDatatype1();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleDatatypes2873); 

            			doneLeaf(otherlv_2, elementTypeProvider.getDatatypes_Kw1Keyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1064:3: ( (lv_val2_3_0= ruleDatatype2 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1065:4: (lv_val2_3_0= ruleDatatype2 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1065:4: (lv_val2_3_0= ruleDatatype2 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1066:5: lv_val2_3_0= ruleDatatype2
            {

            					markComposite(elementTypeProvider.getDatatypes_Val2Datatype2ParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleDatatype2_in_ruleDatatypes2900);
            ruleDatatype2();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1075:3: ( (lv_val3_4_0= ruleDatatype3 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1076:4: (lv_val3_4_0= ruleDatatype3 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1076:4: (lv_val3_4_0= ruleDatatype3 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1077:5: lv_val3_4_0= ruleDatatype3
            {

            					markComposite(elementTypeProvider.getDatatypes_Val3Datatype3ParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleDatatype3_in_ruleDatatypes2938);
            ruleDatatype3();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf();
            		
            otherlv_5=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleDatatypes2963); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1097:1: entryRuleWrappingDataTypeTest : ruleWrappingDataTypeTest EOF ;
    public final void entryRuleWrappingDataTypeTest() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1097:30: ( ruleWrappingDataTypeTest EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1098:2: ruleWrappingDataTypeTest EOF
            {
             markComposite(elementTypeProvider.getWrappingDataTypeTestElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleWrappingDataTypeTest_in_entryRuleWrappingDataTypeTest2983);
            ruleWrappingDataTypeTest();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWrappingDataTypeTest2989); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1106:1: ruleWrappingDataTypeTest : (otherlv_0= 'wrappingdt' ( (lv_datatype_1_0= ruleWrappingDataType ) ) otherlv_2= 'kw1' ) ;
    public final void ruleWrappingDataTypeTest() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1106:25: ( (otherlv_0= 'wrappingdt' ( (lv_datatype_1_0= ruleWrappingDataType ) ) otherlv_2= 'kw1' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1107:2: (otherlv_0= 'wrappingdt' ( (lv_datatype_1_0= ruleWrappingDataType ) ) otherlv_2= 'kw1' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1107:2: (otherlv_0= 'wrappingdt' ( (lv_datatype_1_0= ruleWrappingDataType ) ) otherlv_2= 'kw1' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1108:3: otherlv_0= 'wrappingdt' ( (lv_datatype_1_0= ruleWrappingDataType ) ) otherlv_2= 'kw1'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleWrappingDataTypeTest3012); 

            			doneLeaf(otherlv_0, elementTypeProvider.getWrappingDataTypeTest_WrappingdtKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1115:3: ( (lv_datatype_1_0= ruleWrappingDataType ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1116:4: (lv_datatype_1_0= ruleWrappingDataType )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1116:4: (lv_datatype_1_0= ruleWrappingDataType )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1117:5: lv_datatype_1_0= ruleWrappingDataType
            {

            					markComposite(elementTypeProvider.getWrappingDataTypeTest_DatatypeWrappingDataTypeParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleWrappingDataType_in_ruleWrappingDataTypeTest3039);
            ruleWrappingDataType();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleWrappingDataTypeTest3064); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1137:1: entryRuleWrappingDataType : ruleWrappingDataType EOF ;
    public final void entryRuleWrappingDataType() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1137:26: ( ruleWrappingDataType EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1138:2: ruleWrappingDataType EOF
            {
             markComposite(elementTypeProvider.getWrappingDataTypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleWrappingDataType_in_entryRuleWrappingDataType3084);
            ruleWrappingDataType();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWrappingDataType3090); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1146:1: ruleWrappingDataType : (this_ID_0= RULE_ID )+ ;
    public final void ruleWrappingDataType() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1146:21: ( (this_ID_0= RULE_ID )+ )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1147:2: (this_ID_0= RULE_ID )+
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1147:2: (this_ID_0= RULE_ID )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1148:3: this_ID_0= RULE_ID
            	    {

            	    			markLeaf();
            	    		
            	    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleWrappingDataType3113); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1159:1: ruleEnum1 : ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) | (enumLiteral_2= 'lit3' ) ) ;
    public final void ruleEnum1() throws RecognitionException {
        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1159:10: ( ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) | (enumLiteral_2= 'lit3' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1160:2: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) | (enumLiteral_2= 'lit3' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1160:2: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) | (enumLiteral_2= 'lit3' ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1161:3: (enumLiteral_0= 'lit1' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1161:3: (enumLiteral_0= 'lit1' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1162:4: enumLiteral_0= 'lit1'
                    {

                    				markLeaf();
                    			
                    enumLiteral_0=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleEnum13147); 

                    				doneLeaf(enumLiteral_0, elementTypeProvider.getEnum1_Lit1EnumLiteralDeclaration_0ElementType());
                    			

                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1171:3: (enumLiteral_1= 'lit2' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1171:3: (enumLiteral_1= 'lit2' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1172:4: enumLiteral_1= 'lit2'
                    {

                    				markLeaf();
                    			
                    enumLiteral_1=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleEnum13180); 

                    				doneLeaf(enumLiteral_1, elementTypeProvider.getEnum1_Lit2EnumLiteralDeclaration_1ElementType());
                    			

                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1181:3: (enumLiteral_2= 'lit3' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1181:3: (enumLiteral_2= 'lit3' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalFormatterTestLanguage.g:1182:4: enumLiteral_2= 'lit3'
                    {

                    				markLeaf();
                    			
                    enumLiteral_2=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleEnum13213); 

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
            return "116:3: ( ruleDecl | ruleAssign | ruleMeth | ruleFqnObj | ruleFqnRef | ruleEnumeration | ( ruleSuppressedHidden otherlv_7= 'post' ) | ruleSpace | ruleDatatypes )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleRoot83 = new BitSet(new long[]{0x0000010007000000L});
        public static final BitSet FOLLOW_ruleTestLinewrap_in_ruleRoot101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestIndentation_in_ruleRoot125 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestLinewrapMinMax_in_ruleRoot149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWrappingDataTypeTest_in_ruleRoot173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLine_in_entryRuleLine198 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLine204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDecl_in_ruleLine231 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleAssign_in_ruleLine255 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleMeth_in_ruleLine279 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleFqnObj_in_ruleLine303 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleFqnRef_in_ruleLine327 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleEnumeration_in_ruleLine351 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleSuppressedHidden_in_ruleLine382 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleLine402 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleSpace_in_ruleLine432 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleDatatypes_in_ruleLine456 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleLine475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDecl_in_entryRuleDecl495 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDecl501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDecl537 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDecl575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssign_in_entryRuleAssign606 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssign612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssign648 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleAssign694 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_15_in_ruleAssign728 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleAssign760 = new BitSet(new long[]{0x0000000000040020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleAssign795 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_17_in_ruleAssign832 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleAssign869 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_18_in_ruleAssign911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMeth_in_entryRuleMeth931 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMeth937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleMeth960 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMeth987 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleMeth1012 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_ruleParam_in_ruleMeth1047 = new BitSet(new long[]{0x0000000000220000L});
        public static final BitSet FOLLOW_17_in_ruleMeth1084 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleParam_in_ruleMeth1121 = new BitSet(new long[]{0x0000000000220000L});
        public static final BitSet FOLLOW_21_in_ruleMeth1163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParam_in_entryRuleParam1183 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParam1189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParam1225 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleParam1250 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParam1277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpace_in_entryRuleSpace1308 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpace1314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleSpace1337 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSpace1364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestLinewrap_in_entryRuleTestLinewrap1395 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestLinewrap1401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleTestLinewrap1437 = new BitSet(new long[]{0x00000023A0880012L});
        public static final BitSet FOLLOW_ruleLine_in_ruleTestLinewrap1464 = new BitSet(new long[]{0x00000023A0880012L});
        public static final BitSet FOLLOW_ruleTestLinewrapMinMax_in_entryRuleTestLinewrapMinMax1496 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestLinewrapMinMax1502 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleTestLinewrapMinMax1538 = new BitSet(new long[]{0x00000023A0880012L});
        public static final BitSet FOLLOW_ruleLine_in_ruleTestLinewrapMinMax1565 = new BitSet(new long[]{0x00000023A0880012L});
        public static final BitSet FOLLOW_ruleTestIndentation_in_entryRuleTestIndentation1597 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestIndentation1603 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleTestIndentation1639 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleTestIndentation1653 = new BitSet(new long[]{0x00000023B4880010L});
        public static final BitSet FOLLOW_ruleLine_in_ruleTestIndentation1688 = new BitSet(new long[]{0x00000023B4880010L});
        public static final BitSet FOLLOW_ruleTestIndentation_in_ruleTestIndentation1722 = new BitSet(new long[]{0x00000023B4880010L});
        public static final BitSet FOLLOW_28_in_ruleTestIndentation1755 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleTestIndentation1782 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFqnObj_in_entryRuleFqnObj1814 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFqnObj1820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleFqnObj1843 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleFqnObj1870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN1901 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN1907 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN1930 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_ruleFQN1950 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN1967 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_ruleFqnRef_in_entryRuleFqnRef1993 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFqnRef1999 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleFqnRef2022 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleFqnRef2047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumeration_in_entryRuleEnumeration2078 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumeration2084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleEnumeration2107 = new BitSet(new long[]{0x00000E0000000000L});
        public static final BitSet FOLLOW_ruleEnum1_in_ruleEnumeration2134 = new BitSet(new long[]{0x00000E0000020002L});
        public static final BitSet FOLLOW_17_in_ruleEnumeration2166 = new BitSet(new long[]{0x00000E0000000000L});
        public static final BitSet FOLLOW_ruleEnum1_in_ruleEnumeration2198 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_ruleSuppressedHidden_in_entryRuleSuppressedHidden2237 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSuppressedHidden2243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleSuppressedHidden2279 = new BitSet(new long[]{0x0000000A00000010L});
        public static final BitSet FOLLOW_ruleSuppressedHiddenSub_in_ruleSuppressedHidden2314 = new BitSet(new long[]{0x0000000600000000L});
        public static final BitSet FOLLOW_34_in_ruleSuppressedHidden2351 = new BitSet(new long[]{0x0000000800000010L});
        public static final BitSet FOLLOW_ruleSuppressedHiddenSub_in_ruleSuppressedHidden2388 = new BitSet(new long[]{0x0000000600000000L});
        public static final BitSet FOLLOW_33_in_ruleSuppressedHidden2430 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSuppressedHiddenSub_in_entryRuleSuppressedHiddenSub2450 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSuppressedHiddenSub2456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSuppressedHiddenSubSub_in_ruleSuppressedHiddenSub2477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSuppressedHiddenSubID_in_ruleSuppressedHiddenSub2497 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSuppressedHiddenSubSub_in_entryRuleSuppressedHiddenSubSub2517 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSuppressedHiddenSubSub2523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleSuppressedHiddenSubSub2546 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSuppressedHiddenSubSub2573 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_36_in_ruleSuppressedHiddenSubSub2598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSuppressedHiddenSubID_in_entryRuleSuppressedHiddenSubID2618 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSuppressedHiddenSubID2624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSuppressedHiddenSubID2653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype1_in_entryRuleDatatype12678 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatype12684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleDatatype12700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype2_in_entryRuleDatatype22716 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatype22722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleDatatype22738 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype3_in_entryRuleDatatype32754 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatype32760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleDatatype32776 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypes_in_entryRuleDatatypes2792 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypes2798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleDatatypes2821 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDatatype1_in_ruleDatatypes2848 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_38_in_ruleDatatypes2873 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDatatype2_in_ruleDatatypes2900 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDatatype3_in_ruleDatatypes2938 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_39_in_ruleDatatypes2963 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWrappingDataTypeTest_in_entryRuleWrappingDataTypeTest2983 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWrappingDataTypeTest2989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleWrappingDataTypeTest3012 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleWrappingDataType_in_ruleWrappingDataTypeTest3039 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_38_in_ruleWrappingDataTypeTest3064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWrappingDataType_in_entryRuleWrappingDataType3084 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWrappingDataType3090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleWrappingDataType3113 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_41_in_ruleEnum13147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleEnum13180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleEnum13213 = new BitSet(new long[]{0x0000000000000002L});
    }


}