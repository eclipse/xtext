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
    public String getGrammarFileName() { return "PsiInternalFormatterTestLanguage.g"; }



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
    // PsiInternalFormatterTestLanguage.g:52:1: entryRuleRoot returns [Boolean current=false] : iv_ruleRoot= ruleRoot EOF ;
    public final Boolean entryRuleRoot() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRoot = null;


        try {
            // PsiInternalFormatterTestLanguage.g:52:46: (iv_ruleRoot= ruleRoot EOF )
            // PsiInternalFormatterTestLanguage.g:53:2: iv_ruleRoot= ruleRoot EOF
            {
             markComposite(elementTypeProvider.getRootElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRoot=ruleRoot();

            state._fsp--;

             current =iv_ruleRoot; 
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
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // PsiInternalFormatterTestLanguage.g:59:1: ruleRoot returns [Boolean current=false] : (otherlv_0= 'test' (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation | this_TestLinewrapMinMax_3= ruleTestLinewrapMinMax | this_WrappingDataTypeTest_4= ruleWrappingDataTypeTest ) ) ;
    public final Boolean ruleRoot() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean this_TestLinewrap_1 = null;

        Boolean this_TestIndentation_2 = null;

        Boolean this_TestLinewrapMinMax_3 = null;

        Boolean this_WrappingDataTypeTest_4 = null;


        try {
            // PsiInternalFormatterTestLanguage.g:60:1: ( (otherlv_0= 'test' (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation | this_TestLinewrapMinMax_3= ruleTestLinewrapMinMax | this_WrappingDataTypeTest_4= ruleWrappingDataTypeTest ) ) )
            // PsiInternalFormatterTestLanguage.g:61:2: (otherlv_0= 'test' (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation | this_TestLinewrapMinMax_3= ruleTestLinewrapMinMax | this_WrappingDataTypeTest_4= ruleWrappingDataTypeTest ) )
            {
            // PsiInternalFormatterTestLanguage.g:61:2: (otherlv_0= 'test' (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation | this_TestLinewrapMinMax_3= ruleTestLinewrapMinMax | this_WrappingDataTypeTest_4= ruleWrappingDataTypeTest ) )
            // PsiInternalFormatterTestLanguage.g:62:3: otherlv_0= 'test' (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation | this_TestLinewrapMinMax_3= ruleTestLinewrapMinMax | this_WrappingDataTypeTest_4= ruleWrappingDataTypeTest )
            {

            			markLeaf(elementTypeProvider.getRoot_TestKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalFormatterTestLanguage.g:69:3: (this_TestLinewrap_1= ruleTestLinewrap | this_TestIndentation_2= ruleTestIndentation | this_TestLinewrapMinMax_3= ruleTestLinewrapMinMax | this_WrappingDataTypeTest_4= ruleWrappingDataTypeTest )
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
                    // PsiInternalFormatterTestLanguage.g:70:4: this_TestLinewrap_1= ruleTestLinewrap
                    {

                    				markComposite(elementTypeProvider.getRoot_TestLinewrapParserRuleCall_1_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TestLinewrap_1=ruleTestLinewrap();

                    state._fsp--;


                    				current = this_TestLinewrap_1;
                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalFormatterTestLanguage.g:79:4: this_TestIndentation_2= ruleTestIndentation
                    {

                    				markComposite(elementTypeProvider.getRoot_TestIndentationParserRuleCall_1_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TestIndentation_2=ruleTestIndentation();

                    state._fsp--;


                    				current = this_TestIndentation_2;
                    				doneComposite();
                    			

                    }
                    break;
                case 3 :
                    // PsiInternalFormatterTestLanguage.g:88:4: this_TestLinewrapMinMax_3= ruleTestLinewrapMinMax
                    {

                    				markComposite(elementTypeProvider.getRoot_TestLinewrapMinMaxParserRuleCall_1_2ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TestLinewrapMinMax_3=ruleTestLinewrapMinMax();

                    state._fsp--;


                    				current = this_TestLinewrapMinMax_3;
                    				doneComposite();
                    			

                    }
                    break;
                case 4 :
                    // PsiInternalFormatterTestLanguage.g:97:4: this_WrappingDataTypeTest_4= ruleWrappingDataTypeTest
                    {

                    				markComposite(elementTypeProvider.getRoot_WrappingDataTypeTestParserRuleCall_1_3ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_WrappingDataTypeTest_4=ruleWrappingDataTypeTest();

                    state._fsp--;


                    				current = this_WrappingDataTypeTest_4;
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
        return current;
    }
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleLine"
    // PsiInternalFormatterTestLanguage.g:110:1: entryRuleLine returns [Boolean current=false] : iv_ruleLine= ruleLine EOF ;
    public final Boolean entryRuleLine() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleLine = null;


        try {
            // PsiInternalFormatterTestLanguage.g:110:46: (iv_ruleLine= ruleLine EOF )
            // PsiInternalFormatterTestLanguage.g:111:2: iv_ruleLine= ruleLine EOF
            {
             markComposite(elementTypeProvider.getLineElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLine=ruleLine();

            state._fsp--;

             current =iv_ruleLine; 
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
    // $ANTLR end "entryRuleLine"


    // $ANTLR start "ruleLine"
    // PsiInternalFormatterTestLanguage.g:117:1: ruleLine returns [Boolean current=false] : ( (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef | this_Enumeration_5= ruleEnumeration | (this_SuppressedHidden_6= ruleSuppressedHidden otherlv_7= 'post' ) | this_Space_8= ruleSpace | this_Datatypes_9= ruleDatatypes ) otherlv_10= ';' ) ;
    public final Boolean ruleLine() throws RecognitionException {
        Boolean current = false;

        Token otherlv_7=null;
        Token otherlv_10=null;
        Boolean this_Decl_0 = null;

        Boolean this_Assign_1 = null;

        Boolean this_Meth_2 = null;

        Boolean this_FqnObj_3 = null;

        Boolean this_FqnRef_4 = null;

        Boolean this_Enumeration_5 = null;

        Boolean this_SuppressedHidden_6 = null;

        Boolean this_Space_8 = null;

        Boolean this_Datatypes_9 = null;


        try {
            // PsiInternalFormatterTestLanguage.g:118:1: ( ( (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef | this_Enumeration_5= ruleEnumeration | (this_SuppressedHidden_6= ruleSuppressedHidden otherlv_7= 'post' ) | this_Space_8= ruleSpace | this_Datatypes_9= ruleDatatypes ) otherlv_10= ';' ) )
            // PsiInternalFormatterTestLanguage.g:119:2: ( (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef | this_Enumeration_5= ruleEnumeration | (this_SuppressedHidden_6= ruleSuppressedHidden otherlv_7= 'post' ) | this_Space_8= ruleSpace | this_Datatypes_9= ruleDatatypes ) otherlv_10= ';' )
            {
            // PsiInternalFormatterTestLanguage.g:119:2: ( (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef | this_Enumeration_5= ruleEnumeration | (this_SuppressedHidden_6= ruleSuppressedHidden otherlv_7= 'post' ) | this_Space_8= ruleSpace | this_Datatypes_9= ruleDatatypes ) otherlv_10= ';' )
            // PsiInternalFormatterTestLanguage.g:120:3: (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef | this_Enumeration_5= ruleEnumeration | (this_SuppressedHidden_6= ruleSuppressedHidden otherlv_7= 'post' ) | this_Space_8= ruleSpace | this_Datatypes_9= ruleDatatypes ) otherlv_10= ';'
            {
            // PsiInternalFormatterTestLanguage.g:120:3: (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef | this_Enumeration_5= ruleEnumeration | (this_SuppressedHidden_6= ruleSuppressedHidden otherlv_7= 'post' ) | this_Space_8= ruleSpace | this_Datatypes_9= ruleDatatypes )
            int alt2=9;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // PsiInternalFormatterTestLanguage.g:121:4: this_Decl_0= ruleDecl
                    {

                    				markComposite(elementTypeProvider.getLine_DeclParserRuleCall_0_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_4);
                    this_Decl_0=ruleDecl();

                    state._fsp--;


                    				current = this_Decl_0;
                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalFormatterTestLanguage.g:130:4: this_Assign_1= ruleAssign
                    {

                    				markComposite(elementTypeProvider.getLine_AssignParserRuleCall_0_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_4);
                    this_Assign_1=ruleAssign();

                    state._fsp--;


                    				current = this_Assign_1;
                    				doneComposite();
                    			

                    }
                    break;
                case 3 :
                    // PsiInternalFormatterTestLanguage.g:139:4: this_Meth_2= ruleMeth
                    {

                    				markComposite(elementTypeProvider.getLine_MethParserRuleCall_0_2ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_4);
                    this_Meth_2=ruleMeth();

                    state._fsp--;


                    				current = this_Meth_2;
                    				doneComposite();
                    			

                    }
                    break;
                case 4 :
                    // PsiInternalFormatterTestLanguage.g:148:4: this_FqnObj_3= ruleFqnObj
                    {

                    				markComposite(elementTypeProvider.getLine_FqnObjParserRuleCall_0_3ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_4);
                    this_FqnObj_3=ruleFqnObj();

                    state._fsp--;


                    				current = this_FqnObj_3;
                    				doneComposite();
                    			

                    }
                    break;
                case 5 :
                    // PsiInternalFormatterTestLanguage.g:157:4: this_FqnRef_4= ruleFqnRef
                    {

                    				markComposite(elementTypeProvider.getLine_FqnRefParserRuleCall_0_4ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_4);
                    this_FqnRef_4=ruleFqnRef();

                    state._fsp--;


                    				current = this_FqnRef_4;
                    				doneComposite();
                    			

                    }
                    break;
                case 6 :
                    // PsiInternalFormatterTestLanguage.g:166:4: this_Enumeration_5= ruleEnumeration
                    {

                    				markComposite(elementTypeProvider.getLine_EnumerationParserRuleCall_0_5ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_4);
                    this_Enumeration_5=ruleEnumeration();

                    state._fsp--;


                    				current = this_Enumeration_5;
                    				doneComposite();
                    			

                    }
                    break;
                case 7 :
                    // PsiInternalFormatterTestLanguage.g:175:4: (this_SuppressedHidden_6= ruleSuppressedHidden otherlv_7= 'post' )
                    {
                    // PsiInternalFormatterTestLanguage.g:175:4: (this_SuppressedHidden_6= ruleSuppressedHidden otherlv_7= 'post' )
                    // PsiInternalFormatterTestLanguage.g:176:5: this_SuppressedHidden_6= ruleSuppressedHidden otherlv_7= 'post'
                    {

                    					markComposite(elementTypeProvider.getLine_SuppressedHiddenParserRuleCall_0_6_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_5);
                    this_SuppressedHidden_6=ruleSuppressedHidden();

                    state._fsp--;


                    					current = this_SuppressedHidden_6;
                    					doneComposite();
                    				

                    					markLeaf(elementTypeProvider.getLine_PostKeyword_0_6_1ElementType());
                    				
                    otherlv_7=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                    					doneLeaf(otherlv_7);
                    				

                    }


                    }
                    break;
                case 8 :
                    // PsiInternalFormatterTestLanguage.g:193:4: this_Space_8= ruleSpace
                    {

                    				markComposite(elementTypeProvider.getLine_SpaceParserRuleCall_0_7ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_4);
                    this_Space_8=ruleSpace();

                    state._fsp--;


                    				current = this_Space_8;
                    				doneComposite();
                    			

                    }
                    break;
                case 9 :
                    // PsiInternalFormatterTestLanguage.g:202:4: this_Datatypes_9= ruleDatatypes
                    {

                    				markComposite(elementTypeProvider.getLine_DatatypesParserRuleCall_0_8ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_4);
                    this_Datatypes_9=ruleDatatypes();

                    state._fsp--;


                    				current = this_Datatypes_9;
                    				doneComposite();
                    			

                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getLine_SemicolonKeyword_1ElementType());
            		
            otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_10);
            		

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
    // $ANTLR end "ruleLine"


    // $ANTLR start "entryRuleDecl"
    // PsiInternalFormatterTestLanguage.g:222:1: entryRuleDecl returns [Boolean current=false] : iv_ruleDecl= ruleDecl EOF ;
    public final Boolean entryRuleDecl() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDecl = null;


        try {
            // PsiInternalFormatterTestLanguage.g:222:46: (iv_ruleDecl= ruleDecl EOF )
            // PsiInternalFormatterTestLanguage.g:223:2: iv_ruleDecl= ruleDecl EOF
            {
             markComposite(elementTypeProvider.getDeclElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDecl=ruleDecl();

            state._fsp--;

             current =iv_ruleDecl; 
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
    // $ANTLR end "entryRuleDecl"


    // $ANTLR start "ruleDecl"
    // PsiInternalFormatterTestLanguage.g:229:1: ruleDecl returns [Boolean current=false] : ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleDecl() throws RecognitionException {
        Boolean current = false;

        Token lv_type_0_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalFormatterTestLanguage.g:230:1: ( ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalFormatterTestLanguage.g:231:2: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalFormatterTestLanguage.g:231:2: ( ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalFormatterTestLanguage.g:232:3: ( (lv_type_0_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // PsiInternalFormatterTestLanguage.g:232:3: ( (lv_type_0_0= RULE_ID ) )
            // PsiInternalFormatterTestLanguage.g:233:4: (lv_type_0_0= RULE_ID )
            {
            // PsiInternalFormatterTestLanguage.g:233:4: (lv_type_0_0= RULE_ID )
            // PsiInternalFormatterTestLanguage.g:234:5: lv_type_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getDecl_TypeIDTerminalRuleCall_0_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_type_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            					doneLeaf(lv_type_0_0);
            				

            }


            }

            // PsiInternalFormatterTestLanguage.g:249:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalFormatterTestLanguage.g:250:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalFormatterTestLanguage.g:250:4: (lv_name_1_0= RULE_ID )
            // PsiInternalFormatterTestLanguage.g:251:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getDecl_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_name_1_0);
            				

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
    // $ANTLR end "ruleDecl"


    // $ANTLR start "entryRuleAssign"
    // PsiInternalFormatterTestLanguage.g:270:1: entryRuleAssign returns [Boolean current=false] : iv_ruleAssign= ruleAssign EOF ;
    public final Boolean entryRuleAssign() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAssign = null;


        try {
            // PsiInternalFormatterTestLanguage.g:270:48: (iv_ruleAssign= ruleAssign EOF )
            // PsiInternalFormatterTestLanguage.g:271:2: iv_ruleAssign= ruleAssign EOF
            {
             markComposite(elementTypeProvider.getAssignElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssign=ruleAssign();

            state._fsp--;

             current =iv_ruleAssign; 
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
    // $ANTLR end "entryRuleAssign"


    // $ANTLR start "ruleAssign"
    // PsiInternalFormatterTestLanguage.g:277:1: ruleAssign returns [Boolean current=false] : ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) otherlv_2= '[' ( ( (lv_val_3_0= RULE_INT ) ) (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )* )? otherlv_6= ']' ) ;
    public final Boolean ruleAssign() throws RecognitionException {
        Boolean current = false;

        Token lv_var_0_0=null;
        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token otherlv_2=null;
        Token lv_val_3_0=null;
        Token otherlv_4=null;
        Token lv_val_5_0=null;
        Token otherlv_6=null;

        try {
            // PsiInternalFormatterTestLanguage.g:278:1: ( ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) otherlv_2= '[' ( ( (lv_val_3_0= RULE_INT ) ) (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )* )? otherlv_6= ']' ) )
            // PsiInternalFormatterTestLanguage.g:279:2: ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) otherlv_2= '[' ( ( (lv_val_3_0= RULE_INT ) ) (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )* )? otherlv_6= ']' )
            {
            // PsiInternalFormatterTestLanguage.g:279:2: ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) otherlv_2= '[' ( ( (lv_val_3_0= RULE_INT ) ) (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )* )? otherlv_6= ']' )
            // PsiInternalFormatterTestLanguage.g:280:3: ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) ) otherlv_2= '[' ( ( (lv_val_3_0= RULE_INT ) ) (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )* )? otherlv_6= ']'
            {
            // PsiInternalFormatterTestLanguage.g:280:3: ( (lv_var_0_0= RULE_ID ) )
            // PsiInternalFormatterTestLanguage.g:281:4: (lv_var_0_0= RULE_ID )
            {
            // PsiInternalFormatterTestLanguage.g:281:4: (lv_var_0_0= RULE_ID )
            // PsiInternalFormatterTestLanguage.g:282:5: lv_var_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAssign_VarIDTerminalRuleCall_0_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_var_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            					doneLeaf(lv_var_0_0);
            				

            }


            }

            // PsiInternalFormatterTestLanguage.g:297:3: ( ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) ) )
            // PsiInternalFormatterTestLanguage.g:298:4: ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) )
            {
            // PsiInternalFormatterTestLanguage.g:298:4: ( (lv_op_1_1= '=' | lv_op_1_2= '+=' ) )
            // PsiInternalFormatterTestLanguage.g:299:5: (lv_op_1_1= '=' | lv_op_1_2= '+=' )
            {
            // PsiInternalFormatterTestLanguage.g:299:5: (lv_op_1_1= '=' | lv_op_1_2= '+=' )
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
                    // PsiInternalFormatterTestLanguage.g:300:6: lv_op_1_1= '='
                    {

                    						markLeaf(elementTypeProvider.getAssign_OpEqualsSignKeyword_1_0_0ElementType());
                    					
                    lv_op_1_1=(Token)match(input,14,FollowSets000.FOLLOW_8); 

                    						doneLeaf(lv_op_1_1);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalFormatterTestLanguage.g:314:6: lv_op_1_2= '+='
                    {

                    						markLeaf(elementTypeProvider.getAssign_OpPlusSignEqualsSignKeyword_1_0_1ElementType());
                    					
                    lv_op_1_2=(Token)match(input,15,FollowSets000.FOLLOW_8); 

                    						doneLeaf(lv_op_1_2);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;

            }


            }


            }


            			markLeaf(elementTypeProvider.getAssign_LeftSquareBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalFormatterTestLanguage.g:337:3: ( ( (lv_val_3_0= RULE_INT ) ) (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalFormatterTestLanguage.g:338:4: ( (lv_val_3_0= RULE_INT ) ) (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )*
                    {
                    // PsiInternalFormatterTestLanguage.g:338:4: ( (lv_val_3_0= RULE_INT ) )
                    // PsiInternalFormatterTestLanguage.g:339:5: (lv_val_3_0= RULE_INT )
                    {
                    // PsiInternalFormatterTestLanguage.g:339:5: (lv_val_3_0= RULE_INT )
                    // PsiInternalFormatterTestLanguage.g:340:6: lv_val_3_0= RULE_INT
                    {

                    						markLeaf(elementTypeProvider.getAssign_ValINTTerminalRuleCall_3_0_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_val_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_10); 

                    						doneLeaf(lv_val_3_0);
                    					

                    }


                    }

                    // PsiInternalFormatterTestLanguage.g:355:4: (otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==17) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // PsiInternalFormatterTestLanguage.g:356:5: otherlv_4= ',' ( (lv_val_5_0= RULE_INT ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getAssign_CommaKeyword_3_1_0ElementType());
                    	    				
                    	    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_11); 

                    	    					doneLeaf(otherlv_4);
                    	    				
                    	    // PsiInternalFormatterTestLanguage.g:363:5: ( (lv_val_5_0= RULE_INT ) )
                    	    // PsiInternalFormatterTestLanguage.g:364:6: (lv_val_5_0= RULE_INT )
                    	    {
                    	    // PsiInternalFormatterTestLanguage.g:364:6: (lv_val_5_0= RULE_INT )
                    	    // PsiInternalFormatterTestLanguage.g:365:7: lv_val_5_0= RULE_INT
                    	    {

                    	    							markLeaf(elementTypeProvider.getAssign_ValINTTerminalRuleCall_3_1_1_0ElementType());
                    	    						

                    	    							if(!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						
                    	    lv_val_5_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_10); 

                    	    							doneLeaf(lv_val_5_0);
                    	    						

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


            			markLeaf(elementTypeProvider.getAssign_RightSquareBracketKeyword_4ElementType());
            		
            otherlv_6=(Token)match(input,18,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_6);
            		

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
    // $ANTLR end "ruleAssign"


    // $ANTLR start "entryRuleMeth"
    // PsiInternalFormatterTestLanguage.g:393:1: entryRuleMeth returns [Boolean current=false] : iv_ruleMeth= ruleMeth EOF ;
    public final Boolean entryRuleMeth() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMeth = null;


        try {
            // PsiInternalFormatterTestLanguage.g:393:46: (iv_ruleMeth= ruleMeth EOF )
            // PsiInternalFormatterTestLanguage.g:394:2: iv_ruleMeth= ruleMeth EOF
            {
             markComposite(elementTypeProvider.getMethElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMeth=ruleMeth();

            state._fsp--;

             current =iv_ruleMeth; 
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
    // $ANTLR end "entryRuleMeth"


    // $ANTLR start "ruleMeth"
    // PsiInternalFormatterTestLanguage.g:400:1: ruleMeth returns [Boolean current=false] : (otherlv_0= 'void' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ')' ) ;
    public final Boolean ruleMeth() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_param_3_0 = null;

        Boolean lv_param_5_0 = null;


        try {
            // PsiInternalFormatterTestLanguage.g:401:1: ( (otherlv_0= 'void' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ')' ) )
            // PsiInternalFormatterTestLanguage.g:402:2: (otherlv_0= 'void' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ')' )
            {
            // PsiInternalFormatterTestLanguage.g:402:2: (otherlv_0= 'void' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ')' )
            // PsiInternalFormatterTestLanguage.g:403:3: otherlv_0= 'void' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )? otherlv_6= ')'
            {

            			markLeaf(elementTypeProvider.getMeth_VoidKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalFormatterTestLanguage.g:410:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalFormatterTestLanguage.g:411:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalFormatterTestLanguage.g:411:4: (lv_name_1_0= RULE_ID )
            // PsiInternalFormatterTestLanguage.g:412:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getMeth_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getMeth_LeftParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_13); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalFormatterTestLanguage.g:434:3: ( ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // PsiInternalFormatterTestLanguage.g:435:4: ( (lv_param_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )*
                    {
                    // PsiInternalFormatterTestLanguage.g:435:4: ( (lv_param_3_0= ruleParam ) )
                    // PsiInternalFormatterTestLanguage.g:436:5: (lv_param_3_0= ruleParam )
                    {
                    // PsiInternalFormatterTestLanguage.g:436:5: (lv_param_3_0= ruleParam )
                    // PsiInternalFormatterTestLanguage.g:437:6: lv_param_3_0= ruleParam
                    {

                    						markComposite(elementTypeProvider.getMeth_ParamParamParserRuleCall_3_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_14);
                    lv_param_3_0=ruleParam();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }

                    // PsiInternalFormatterTestLanguage.g:450:4: (otherlv_4= ',' ( (lv_param_5_0= ruleParam ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==17) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // PsiInternalFormatterTestLanguage.g:451:5: otherlv_4= ',' ( (lv_param_5_0= ruleParam ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getMeth_CommaKeyword_3_1_0ElementType());
                    	    				
                    	    otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_6); 

                    	    					doneLeaf(otherlv_4);
                    	    				
                    	    // PsiInternalFormatterTestLanguage.g:458:5: ( (lv_param_5_0= ruleParam ) )
                    	    // PsiInternalFormatterTestLanguage.g:459:6: (lv_param_5_0= ruleParam )
                    	    {
                    	    // PsiInternalFormatterTestLanguage.g:459:6: (lv_param_5_0= ruleParam )
                    	    // PsiInternalFormatterTestLanguage.g:460:7: lv_param_5_0= ruleParam
                    	    {

                    	    							markComposite(elementTypeProvider.getMeth_ParamParamParserRuleCall_3_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_14);
                    	    lv_param_5_0=ruleParam();

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

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getMeth_RightParenthesisKeyword_4ElementType());
            		
            otherlv_6=(Token)match(input,21,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_6);
            		

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
    // $ANTLR end "ruleMeth"


    // $ANTLR start "entryRuleParam"
    // PsiInternalFormatterTestLanguage.g:486:1: entryRuleParam returns [Boolean current=false] : iv_ruleParam= ruleParam EOF ;
    public final Boolean entryRuleParam() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParam = null;


        try {
            // PsiInternalFormatterTestLanguage.g:486:47: (iv_ruleParam= ruleParam EOF )
            // PsiInternalFormatterTestLanguage.g:487:2: iv_ruleParam= ruleParam EOF
            {
             markComposite(elementTypeProvider.getParamElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParam=ruleParam();

            state._fsp--;

             current =iv_ruleParam; 
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
    // $ANTLR end "entryRuleParam"


    // $ANTLR start "ruleParam"
    // PsiInternalFormatterTestLanguage.g:493:1: ruleParam returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= RULE_ID ) ) ) ;
    public final Boolean ruleParam() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_type_2_0=null;

        try {
            // PsiInternalFormatterTestLanguage.g:494:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= RULE_ID ) ) ) )
            // PsiInternalFormatterTestLanguage.g:495:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= RULE_ID ) ) )
            {
            // PsiInternalFormatterTestLanguage.g:495:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= RULE_ID ) ) )
            // PsiInternalFormatterTestLanguage.g:496:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= RULE_ID ) )
            {
            // PsiInternalFormatterTestLanguage.g:496:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalFormatterTestLanguage.g:497:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalFormatterTestLanguage.g:497:4: (lv_name_0_0= RULE_ID )
            // PsiInternalFormatterTestLanguage.g:498:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getParam_NameIDTerminalRuleCall_0_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); 

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getParam_ColonKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalFormatterTestLanguage.g:520:3: ( (lv_type_2_0= RULE_ID ) )
            // PsiInternalFormatterTestLanguage.g:521:4: (lv_type_2_0= RULE_ID )
            {
            // PsiInternalFormatterTestLanguage.g:521:4: (lv_type_2_0= RULE_ID )
            // PsiInternalFormatterTestLanguage.g:522:5: lv_type_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getParam_TypeIDTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_type_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_type_2_0);
            				

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
    // $ANTLR end "ruleParam"


    // $ANTLR start "entryRuleSpace"
    // PsiInternalFormatterTestLanguage.g:541:1: entryRuleSpace returns [Boolean current=false] : iv_ruleSpace= ruleSpace EOF ;
    public final Boolean entryRuleSpace() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSpace = null;


        try {
            // PsiInternalFormatterTestLanguage.g:541:47: (iv_ruleSpace= ruleSpace EOF )
            // PsiInternalFormatterTestLanguage.g:542:2: iv_ruleSpace= ruleSpace EOF
            {
             markComposite(elementTypeProvider.getSpaceElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSpace=ruleSpace();

            state._fsp--;

             current =iv_ruleSpace; 
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
    // $ANTLR end "entryRuleSpace"


    // $ANTLR start "ruleSpace"
    // PsiInternalFormatterTestLanguage.g:548:1: ruleSpace returns [Boolean current=false] : (otherlv_0= 'space' ( (lv_val_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleSpace() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_val_1_0=null;

        try {
            // PsiInternalFormatterTestLanguage.g:549:1: ( (otherlv_0= 'space' ( (lv_val_1_0= RULE_ID ) ) ) )
            // PsiInternalFormatterTestLanguage.g:550:2: (otherlv_0= 'space' ( (lv_val_1_0= RULE_ID ) ) )
            {
            // PsiInternalFormatterTestLanguage.g:550:2: (otherlv_0= 'space' ( (lv_val_1_0= RULE_ID ) ) )
            // PsiInternalFormatterTestLanguage.g:551:3: otherlv_0= 'space' ( (lv_val_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getSpace_SpaceKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalFormatterTestLanguage.g:558:3: ( (lv_val_1_0= RULE_ID ) )
            // PsiInternalFormatterTestLanguage.g:559:4: (lv_val_1_0= RULE_ID )
            {
            // PsiInternalFormatterTestLanguage.g:559:4: (lv_val_1_0= RULE_ID )
            // PsiInternalFormatterTestLanguage.g:560:5: lv_val_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSpace_ValIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_val_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_val_1_0);
            				

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
    // $ANTLR end "ruleSpace"


    // $ANTLR start "entryRuleTestLinewrap"
    // PsiInternalFormatterTestLanguage.g:579:1: entryRuleTestLinewrap returns [Boolean current=false] : iv_ruleTestLinewrap= ruleTestLinewrap EOF ;
    public final Boolean entryRuleTestLinewrap() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTestLinewrap = null;


        try {
            // PsiInternalFormatterTestLanguage.g:579:54: (iv_ruleTestLinewrap= ruleTestLinewrap EOF )
            // PsiInternalFormatterTestLanguage.g:580:2: iv_ruleTestLinewrap= ruleTestLinewrap EOF
            {
             markComposite(elementTypeProvider.getTestLinewrapElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTestLinewrap=ruleTestLinewrap();

            state._fsp--;

             current =iv_ruleTestLinewrap; 
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
    // $ANTLR end "entryRuleTestLinewrap"


    // $ANTLR start "ruleTestLinewrap"
    // PsiInternalFormatterTestLanguage.g:586:1: ruleTestLinewrap returns [Boolean current=false] : ( () otherlv_1= 'linewrap' ( (lv_items_2_0= ruleLine ) )* ) ;
    public final Boolean ruleTestLinewrap() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Boolean lv_items_2_0 = null;


        try {
            // PsiInternalFormatterTestLanguage.g:587:1: ( ( () otherlv_1= 'linewrap' ( (lv_items_2_0= ruleLine ) )* ) )
            // PsiInternalFormatterTestLanguage.g:588:2: ( () otherlv_1= 'linewrap' ( (lv_items_2_0= ruleLine ) )* )
            {
            // PsiInternalFormatterTestLanguage.g:588:2: ( () otherlv_1= 'linewrap' ( (lv_items_2_0= ruleLine ) )* )
            // PsiInternalFormatterTestLanguage.g:589:3: () otherlv_1= 'linewrap' ( (lv_items_2_0= ruleLine ) )*
            {
            // PsiInternalFormatterTestLanguage.g:589:3: ()
            // PsiInternalFormatterTestLanguage.g:590:4: 
            {

            				precedeComposite(elementTypeProvider.getTestLinewrap_TestLinewrapAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getTestLinewrap_LinewrapKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_16); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalFormatterTestLanguage.g:603:3: ( (lv_items_2_0= ruleLine ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID||LA8_0==19||LA8_0==23||LA8_0==29||(LA8_0>=31 && LA8_0<=33)||LA8_0==37) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // PsiInternalFormatterTestLanguage.g:604:4: (lv_items_2_0= ruleLine )
            	    {
            	    // PsiInternalFormatterTestLanguage.g:604:4: (lv_items_2_0= ruleLine )
            	    // PsiInternalFormatterTestLanguage.g:605:5: lv_items_2_0= ruleLine
            	    {

            	    					markComposite(elementTypeProvider.getTestLinewrap_ItemsLineParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_16);
            	    lv_items_2_0=ruleLine();

            	    state._fsp--;


            	    					doneComposite();
            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
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
    // $ANTLR end "ruleTestLinewrap"


    // $ANTLR start "entryRuleTestLinewrapMinMax"
    // PsiInternalFormatterTestLanguage.g:622:1: entryRuleTestLinewrapMinMax returns [Boolean current=false] : iv_ruleTestLinewrapMinMax= ruleTestLinewrapMinMax EOF ;
    public final Boolean entryRuleTestLinewrapMinMax() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTestLinewrapMinMax = null;


        try {
            // PsiInternalFormatterTestLanguage.g:622:60: (iv_ruleTestLinewrapMinMax= ruleTestLinewrapMinMax EOF )
            // PsiInternalFormatterTestLanguage.g:623:2: iv_ruleTestLinewrapMinMax= ruleTestLinewrapMinMax EOF
            {
             markComposite(elementTypeProvider.getTestLinewrapMinMaxElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTestLinewrapMinMax=ruleTestLinewrapMinMax();

            state._fsp--;

             current =iv_ruleTestLinewrapMinMax; 
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
    // $ANTLR end "entryRuleTestLinewrapMinMax"


    // $ANTLR start "ruleTestLinewrapMinMax"
    // PsiInternalFormatterTestLanguage.g:629:1: ruleTestLinewrapMinMax returns [Boolean current=false] : ( () otherlv_1= 'wrapminmax' ( (lv_items_2_0= ruleLine ) )* ) ;
    public final Boolean ruleTestLinewrapMinMax() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Boolean lv_items_2_0 = null;


        try {
            // PsiInternalFormatterTestLanguage.g:630:1: ( ( () otherlv_1= 'wrapminmax' ( (lv_items_2_0= ruleLine ) )* ) )
            // PsiInternalFormatterTestLanguage.g:631:2: ( () otherlv_1= 'wrapminmax' ( (lv_items_2_0= ruleLine ) )* )
            {
            // PsiInternalFormatterTestLanguage.g:631:2: ( () otherlv_1= 'wrapminmax' ( (lv_items_2_0= ruleLine ) )* )
            // PsiInternalFormatterTestLanguage.g:632:3: () otherlv_1= 'wrapminmax' ( (lv_items_2_0= ruleLine ) )*
            {
            // PsiInternalFormatterTestLanguage.g:632:3: ()
            // PsiInternalFormatterTestLanguage.g:633:4: 
            {

            				precedeComposite(elementTypeProvider.getTestLinewrapMinMax_TestLinewrapMinMaxAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getTestLinewrapMinMax_WrapminmaxKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,25,FollowSets000.FOLLOW_16); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalFormatterTestLanguage.g:646:3: ( (lv_items_2_0= ruleLine ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID||LA9_0==19||LA9_0==23||LA9_0==29||(LA9_0>=31 && LA9_0<=33)||LA9_0==37) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // PsiInternalFormatterTestLanguage.g:647:4: (lv_items_2_0= ruleLine )
            	    {
            	    // PsiInternalFormatterTestLanguage.g:647:4: (lv_items_2_0= ruleLine )
            	    // PsiInternalFormatterTestLanguage.g:648:5: lv_items_2_0= ruleLine
            	    {

            	    					markComposite(elementTypeProvider.getTestLinewrapMinMax_ItemsLineParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_16);
            	    lv_items_2_0=ruleLine();

            	    state._fsp--;


            	    					doneComposite();
            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
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
    // $ANTLR end "ruleTestLinewrapMinMax"


    // $ANTLR start "entryRuleTestIndentation"
    // PsiInternalFormatterTestLanguage.g:665:1: entryRuleTestIndentation returns [Boolean current=false] : iv_ruleTestIndentation= ruleTestIndentation EOF ;
    public final Boolean entryRuleTestIndentation() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTestIndentation = null;


        try {
            // PsiInternalFormatterTestLanguage.g:665:57: (iv_ruleTestIndentation= ruleTestIndentation EOF )
            // PsiInternalFormatterTestLanguage.g:666:2: iv_ruleTestIndentation= ruleTestIndentation EOF
            {
             markComposite(elementTypeProvider.getTestIndentationElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTestIndentation=ruleTestIndentation();

            state._fsp--;

             current =iv_ruleTestIndentation; 
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
    // $ANTLR end "entryRuleTestIndentation"


    // $ANTLR start "ruleTestIndentation"
    // PsiInternalFormatterTestLanguage.g:672:1: ruleTestIndentation returns [Boolean current=false] : ( () otherlv_1= 'indentation' otherlv_2= '{' ( ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? ) ;
    public final Boolean ruleTestIndentation() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_semi_5_0=null;
        Boolean lv_items_3_1 = null;

        Boolean lv_items_3_2 = null;


        try {
            // PsiInternalFormatterTestLanguage.g:673:1: ( ( () otherlv_1= 'indentation' otherlv_2= '{' ( ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? ) )
            // PsiInternalFormatterTestLanguage.g:674:2: ( () otherlv_1= 'indentation' otherlv_2= '{' ( ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? )
            {
            // PsiInternalFormatterTestLanguage.g:674:2: ( () otherlv_1= 'indentation' otherlv_2= '{' ( ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? )
            // PsiInternalFormatterTestLanguage.g:675:3: () otherlv_1= 'indentation' otherlv_2= '{' ( ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )?
            {
            // PsiInternalFormatterTestLanguage.g:675:3: ()
            // PsiInternalFormatterTestLanguage.g:676:4: 
            {

            				precedeComposite(elementTypeProvider.getTestIndentation_TestIndentationAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getTestIndentation_IndentationKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_17); 

            			doneLeaf(otherlv_1);
            		

            			markLeaf(elementTypeProvider.getTestIndentation_LeftCurlyBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_18); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalFormatterTestLanguage.g:696:3: ( ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID||LA11_0==19||LA11_0==23||LA11_0==26||LA11_0==29||(LA11_0>=31 && LA11_0<=33)||LA11_0==37) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // PsiInternalFormatterTestLanguage.g:697:4: ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) )
            	    {
            	    // PsiInternalFormatterTestLanguage.g:697:4: ( (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation ) )
            	    // PsiInternalFormatterTestLanguage.g:698:5: (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation )
            	    {
            	    // PsiInternalFormatterTestLanguage.g:698:5: (lv_items_3_1= ruleLine | lv_items_3_2= ruleTestIndentation )
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
            	            // PsiInternalFormatterTestLanguage.g:699:6: lv_items_3_1= ruleLine
            	            {

            	            						markComposite(elementTypeProvider.getTestIndentation_ItemsLineParserRuleCall_3_0_0ElementType());
            	            					
            	            pushFollow(FollowSets000.FOLLOW_18);
            	            lv_items_3_1=ruleLine();

            	            state._fsp--;


            	            						doneComposite();
            	            						if(!current) {
            	            							associateWithSemanticElement();
            	            							current = true;
            	            						}
            	            					

            	            }
            	            break;
            	        case 2 :
            	            // PsiInternalFormatterTestLanguage.g:711:6: lv_items_3_2= ruleTestIndentation
            	            {

            	            						markComposite(elementTypeProvider.getTestIndentation_ItemsTestIndentationParserRuleCall_3_0_1ElementType());
            	            					
            	            pushFollow(FollowSets000.FOLLOW_18);
            	            lv_items_3_2=ruleTestIndentation();

            	            state._fsp--;


            	            						doneComposite();
            	            						if(!current) {
            	            							associateWithSemanticElement();
            	            							current = true;
            	            						}
            	            					

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


            			markLeaf(elementTypeProvider.getTestIndentation_RightCurlyBracketKeyword_4ElementType());
            		
            otherlv_4=(Token)match(input,28,FollowSets000.FOLLOW_19); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalFormatterTestLanguage.g:732:3: ( (lv_semi_5_0= ';' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==13) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // PsiInternalFormatterTestLanguage.g:733:4: (lv_semi_5_0= ';' )
                    {
                    // PsiInternalFormatterTestLanguage.g:733:4: (lv_semi_5_0= ';' )
                    // PsiInternalFormatterTestLanguage.g:734:5: lv_semi_5_0= ';'
                    {

                    					markLeaf(elementTypeProvider.getTestIndentation_SemiSemicolonKeyword_5_0ElementType());
                    				
                    lv_semi_5_0=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_semi_5_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
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
    // $ANTLR end "ruleTestIndentation"


    // $ANTLR start "entryRuleFqnObj"
    // PsiInternalFormatterTestLanguage.g:753:1: entryRuleFqnObj returns [Boolean current=false] : iv_ruleFqnObj= ruleFqnObj EOF ;
    public final Boolean entryRuleFqnObj() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFqnObj = null;


        try {
            // PsiInternalFormatterTestLanguage.g:753:48: (iv_ruleFqnObj= ruleFqnObj EOF )
            // PsiInternalFormatterTestLanguage.g:754:2: iv_ruleFqnObj= ruleFqnObj EOF
            {
             markComposite(elementTypeProvider.getFqnObjElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFqnObj=ruleFqnObj();

            state._fsp--;

             current =iv_ruleFqnObj; 
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
    // $ANTLR end "entryRuleFqnObj"


    // $ANTLR start "ruleFqnObj"
    // PsiInternalFormatterTestLanguage.g:760:1: ruleFqnObj returns [Boolean current=false] : (otherlv_0= 'fqn' ( (lv_name_1_0= ruleFQN ) ) ) ;
    public final Boolean ruleFqnObj() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_name_1_0 = null;


        try {
            // PsiInternalFormatterTestLanguage.g:761:1: ( (otherlv_0= 'fqn' ( (lv_name_1_0= ruleFQN ) ) ) )
            // PsiInternalFormatterTestLanguage.g:762:2: (otherlv_0= 'fqn' ( (lv_name_1_0= ruleFQN ) ) )
            {
            // PsiInternalFormatterTestLanguage.g:762:2: (otherlv_0= 'fqn' ( (lv_name_1_0= ruleFQN ) ) )
            // PsiInternalFormatterTestLanguage.g:763:3: otherlv_0= 'fqn' ( (lv_name_1_0= ruleFQN ) )
            {

            			markLeaf(elementTypeProvider.getFqnObj_FqnKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalFormatterTestLanguage.g:770:3: ( (lv_name_1_0= ruleFQN ) )
            // PsiInternalFormatterTestLanguage.g:771:4: (lv_name_1_0= ruleFQN )
            {
            // PsiInternalFormatterTestLanguage.g:771:4: (lv_name_1_0= ruleFQN )
            // PsiInternalFormatterTestLanguage.g:772:5: lv_name_1_0= ruleFQN
            {

            					markComposite(elementTypeProvider.getFqnObj_NameFQNParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_name_1_0=ruleFQN();

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
    // $ANTLR end "ruleFqnObj"


    // $ANTLR start "entryRuleFQN"
    // PsiInternalFormatterTestLanguage.g:789:1: entryRuleFQN returns [Boolean current=false] : iv_ruleFQN= ruleFQN EOF ;
    public final Boolean entryRuleFQN() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFQN = null;


        try {
            // PsiInternalFormatterTestLanguage.g:789:45: (iv_ruleFQN= ruleFQN EOF )
            // PsiInternalFormatterTestLanguage.g:790:2: iv_ruleFQN= ruleFQN EOF
            {
             markComposite(elementTypeProvider.getFQNElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN; 
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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // PsiInternalFormatterTestLanguage.g:796:1: ruleFQN returns [Boolean current=false] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final Boolean ruleFQN() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // PsiInternalFormatterTestLanguage.g:797:1: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // PsiInternalFormatterTestLanguage.g:798:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // PsiInternalFormatterTestLanguage.g:798:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // PsiInternalFormatterTestLanguage.g:799:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf(elementTypeProvider.getFQN_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_20); 

            			doneLeaf(this_ID_0);
            		
            // PsiInternalFormatterTestLanguage.g:806:3: (kw= '.' this_ID_2= RULE_ID )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==30) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // PsiInternalFormatterTestLanguage.g:807:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf(elementTypeProvider.getFQN_FullStopKeyword_1_0ElementType());
            	    			
            	    kw=(Token)match(input,30,FollowSets000.FOLLOW_6); 

            	    				doneLeaf(kw);
            	    			

            	    				markLeaf(elementTypeProvider.getFQN_IDTerminalRuleCall_1_1ElementType());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_20); 

            	    				doneLeaf(this_ID_2);
            	    			

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
        return current;
    }
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleFqnRef"
    // PsiInternalFormatterTestLanguage.g:826:1: entryRuleFqnRef returns [Boolean current=false] : iv_ruleFqnRef= ruleFqnRef EOF ;
    public final Boolean entryRuleFqnRef() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFqnRef = null;


        try {
            // PsiInternalFormatterTestLanguage.g:826:48: (iv_ruleFqnRef= ruleFqnRef EOF )
            // PsiInternalFormatterTestLanguage.g:827:2: iv_ruleFqnRef= ruleFqnRef EOF
            {
             markComposite(elementTypeProvider.getFqnRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFqnRef=ruleFqnRef();

            state._fsp--;

             current =iv_ruleFqnRef; 
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
    // $ANTLR end "entryRuleFqnRef"


    // $ANTLR start "ruleFqnRef"
    // PsiInternalFormatterTestLanguage.g:833:1: ruleFqnRef returns [Boolean current=false] : (otherlv_0= 'fqnref' ( ( ruleFQN ) ) ) ;
    public final Boolean ruleFqnRef() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;

        try {
            // PsiInternalFormatterTestLanguage.g:834:1: ( (otherlv_0= 'fqnref' ( ( ruleFQN ) ) ) )
            // PsiInternalFormatterTestLanguage.g:835:2: (otherlv_0= 'fqnref' ( ( ruleFQN ) ) )
            {
            // PsiInternalFormatterTestLanguage.g:835:2: (otherlv_0= 'fqnref' ( ( ruleFQN ) ) )
            // PsiInternalFormatterTestLanguage.g:836:3: otherlv_0= 'fqnref' ( ( ruleFQN ) )
            {

            			markLeaf(elementTypeProvider.getFqnRef_FqnrefKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalFormatterTestLanguage.g:843:3: ( ( ruleFQN ) )
            // PsiInternalFormatterTestLanguage.g:844:4: ( ruleFQN )
            {
            // PsiInternalFormatterTestLanguage.g:844:4: ( ruleFQN )
            // PsiInternalFormatterTestLanguage.g:845:5: ruleFQN
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markComposite(elementTypeProvider.getFqnRef_RefFqnObjCrossReference_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
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
        return current;
    }
    // $ANTLR end "ruleFqnRef"


    // $ANTLR start "entryRuleEnumeration"
    // PsiInternalFormatterTestLanguage.g:864:1: entryRuleEnumeration returns [Boolean current=false] : iv_ruleEnumeration= ruleEnumeration EOF ;
    public final Boolean entryRuleEnumeration() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEnumeration = null;


        try {
            // PsiInternalFormatterTestLanguage.g:864:53: (iv_ruleEnumeration= ruleEnumeration EOF )
            // PsiInternalFormatterTestLanguage.g:865:2: iv_ruleEnumeration= ruleEnumeration EOF
            {
             markComposite(elementTypeProvider.getEnumerationElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEnumeration=ruleEnumeration();

            state._fsp--;

             current =iv_ruleEnumeration; 
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
    // $ANTLR end "entryRuleEnumeration"


    // $ANTLR start "ruleEnumeration"
    // PsiInternalFormatterTestLanguage.g:871:1: ruleEnumeration returns [Boolean current=false] : (otherlv_0= 'enum' ( (lv_val_1_0= ruleEnum1 ) )+ (otherlv_2= ',' ( (lv_val_3_0= ruleEnum1 ) ) )* ) ;
    public final Boolean ruleEnumeration() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean lv_val_1_0 = null;

        Boolean lv_val_3_0 = null;


        try {
            // PsiInternalFormatterTestLanguage.g:872:1: ( (otherlv_0= 'enum' ( (lv_val_1_0= ruleEnum1 ) )+ (otherlv_2= ',' ( (lv_val_3_0= ruleEnum1 ) ) )* ) )
            // PsiInternalFormatterTestLanguage.g:873:2: (otherlv_0= 'enum' ( (lv_val_1_0= ruleEnum1 ) )+ (otherlv_2= ',' ( (lv_val_3_0= ruleEnum1 ) ) )* )
            {
            // PsiInternalFormatterTestLanguage.g:873:2: (otherlv_0= 'enum' ( (lv_val_1_0= ruleEnum1 ) )+ (otherlv_2= ',' ( (lv_val_3_0= ruleEnum1 ) ) )* )
            // PsiInternalFormatterTestLanguage.g:874:3: otherlv_0= 'enum' ( (lv_val_1_0= ruleEnum1 ) )+ (otherlv_2= ',' ( (lv_val_3_0= ruleEnum1 ) ) )*
            {

            			markLeaf(elementTypeProvider.getEnumeration_EnumKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,32,FollowSets000.FOLLOW_21); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalFormatterTestLanguage.g:881:3: ( (lv_val_1_0= ruleEnum1 ) )+
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
            	    // PsiInternalFormatterTestLanguage.g:882:4: (lv_val_1_0= ruleEnum1 )
            	    {
            	    // PsiInternalFormatterTestLanguage.g:882:4: (lv_val_1_0= ruleEnum1 )
            	    // PsiInternalFormatterTestLanguage.g:883:5: lv_val_1_0= ruleEnum1
            	    {

            	    					markComposite(elementTypeProvider.getEnumeration_ValEnum1EnumRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_22);
            	    lv_val_1_0=ruleEnum1();

            	    state._fsp--;


            	    					doneComposite();
            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				

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

            // PsiInternalFormatterTestLanguage.g:896:3: (otherlv_2= ',' ( (lv_val_3_0= ruleEnum1 ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==17) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // PsiInternalFormatterTestLanguage.g:897:4: otherlv_2= ',' ( (lv_val_3_0= ruleEnum1 ) )
            	    {

            	    				markLeaf(elementTypeProvider.getEnumeration_CommaKeyword_2_0ElementType());
            	    			
            	    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_21); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalFormatterTestLanguage.g:904:4: ( (lv_val_3_0= ruleEnum1 ) )
            	    // PsiInternalFormatterTestLanguage.g:905:5: (lv_val_3_0= ruleEnum1 )
            	    {
            	    // PsiInternalFormatterTestLanguage.g:905:5: (lv_val_3_0= ruleEnum1 )
            	    // PsiInternalFormatterTestLanguage.g:906:6: lv_val_3_0= ruleEnum1
            	    {

            	    						markComposite(elementTypeProvider.getEnumeration_ValEnum1EnumRuleCall_2_1_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_23);
            	    lv_val_3_0=ruleEnum1();

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
        return current;
    }
    // $ANTLR end "ruleEnumeration"


    // $ANTLR start "entryRuleSuppressedHidden"
    // PsiInternalFormatterTestLanguage.g:924:1: entryRuleSuppressedHidden returns [Boolean current=false] : iv_ruleSuppressedHidden= ruleSuppressedHidden EOF ;
    public final Boolean entryRuleSuppressedHidden() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSuppressedHidden = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // PsiInternalFormatterTestLanguage.g:926:2: (iv_ruleSuppressedHidden= ruleSuppressedHidden EOF )
            // PsiInternalFormatterTestLanguage.g:927:2: iv_ruleSuppressedHidden= ruleSuppressedHidden EOF
            {
             markComposite(elementTypeProvider.getSuppressedHiddenElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSuppressedHidden=ruleSuppressedHidden();

            state._fsp--;

             current =iv_ruleSuppressedHidden; 
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
    // $ANTLR end "entryRuleSuppressedHidden"


    // $ANTLR start "ruleSuppressedHidden"
    // PsiInternalFormatterTestLanguage.g:936:1: ruleSuppressedHidden returns [Boolean current=false] : ( () otherlv_1= '`' ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )? otherlv_5= '`' ) ;
    public final Boolean ruleSuppressedHidden() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Boolean lv_vals_2_0 = null;

        Boolean lv_vals_4_0 = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // PsiInternalFormatterTestLanguage.g:939:2: ( ( () otherlv_1= '`' ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )? otherlv_5= '`' ) )
            // PsiInternalFormatterTestLanguage.g:940:2: ( () otherlv_1= '`' ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )? otherlv_5= '`' )
            {
            // PsiInternalFormatterTestLanguage.g:940:2: ( () otherlv_1= '`' ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )? otherlv_5= '`' )
            // PsiInternalFormatterTestLanguage.g:941:3: () otherlv_1= '`' ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )? otherlv_5= '`'
            {
            // PsiInternalFormatterTestLanguage.g:941:3: ()
            // PsiInternalFormatterTestLanguage.g:942:4: 
            {

            				precedeComposite(elementTypeProvider.getSuppressedHidden_SuppressedHiddenAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getSuppressedHidden_GraveAccentKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_24); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalFormatterTestLanguage.g:955:3: ( ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID||LA17_0==35) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // PsiInternalFormatterTestLanguage.g:956:4: ( (lv_vals_2_0= ruleSuppressedHiddenSub ) ) (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )*
                    {
                    // PsiInternalFormatterTestLanguage.g:956:4: ( (lv_vals_2_0= ruleSuppressedHiddenSub ) )
                    // PsiInternalFormatterTestLanguage.g:957:5: (lv_vals_2_0= ruleSuppressedHiddenSub )
                    {
                    // PsiInternalFormatterTestLanguage.g:957:5: (lv_vals_2_0= ruleSuppressedHiddenSub )
                    // PsiInternalFormatterTestLanguage.g:958:6: lv_vals_2_0= ruleSuppressedHiddenSub
                    {

                    						markComposite(elementTypeProvider.getSuppressedHidden_ValsSuppressedHiddenSubParserRuleCall_2_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_25);
                    lv_vals_2_0=ruleSuppressedHiddenSub();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }

                    // PsiInternalFormatterTestLanguage.g:971:4: (otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==34) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // PsiInternalFormatterTestLanguage.g:972:5: otherlv_3= '%' ( (lv_vals_4_0= ruleSuppressedHiddenSub ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getSuppressedHidden_PercentSignKeyword_2_1_0ElementType());
                    	    				
                    	    otherlv_3=(Token)match(input,34,FollowSets000.FOLLOW_26); 

                    	    					doneLeaf(otherlv_3);
                    	    				
                    	    // PsiInternalFormatterTestLanguage.g:979:5: ( (lv_vals_4_0= ruleSuppressedHiddenSub ) )
                    	    // PsiInternalFormatterTestLanguage.g:980:6: (lv_vals_4_0= ruleSuppressedHiddenSub )
                    	    {
                    	    // PsiInternalFormatterTestLanguage.g:980:6: (lv_vals_4_0= ruleSuppressedHiddenSub )
                    	    // PsiInternalFormatterTestLanguage.g:981:7: lv_vals_4_0= ruleSuppressedHiddenSub
                    	    {

                    	    							markComposite(elementTypeProvider.getSuppressedHidden_ValsSuppressedHiddenSubParserRuleCall_2_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_25);
                    	    lv_vals_4_0=ruleSuppressedHiddenSub();

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

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getSuppressedHidden_GraveAccentKeyword_3ElementType());
            		
            otherlv_5=(Token)match(input,33,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_5);
            		

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
    // $ANTLR end "ruleSuppressedHidden"


    // $ANTLR start "entryRuleSuppressedHiddenSub"
    // PsiInternalFormatterTestLanguage.g:1010:1: entryRuleSuppressedHiddenSub returns [Boolean current=false] : iv_ruleSuppressedHiddenSub= ruleSuppressedHiddenSub EOF ;
    public final Boolean entryRuleSuppressedHiddenSub() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSuppressedHiddenSub = null;


        try {
            // PsiInternalFormatterTestLanguage.g:1010:61: (iv_ruleSuppressedHiddenSub= ruleSuppressedHiddenSub EOF )
            // PsiInternalFormatterTestLanguage.g:1011:2: iv_ruleSuppressedHiddenSub= ruleSuppressedHiddenSub EOF
            {
             markComposite(elementTypeProvider.getSuppressedHiddenSubElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSuppressedHiddenSub=ruleSuppressedHiddenSub();

            state._fsp--;

             current =iv_ruleSuppressedHiddenSub; 
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
    // $ANTLR end "entryRuleSuppressedHiddenSub"


    // $ANTLR start "ruleSuppressedHiddenSub"
    // PsiInternalFormatterTestLanguage.g:1017:1: ruleSuppressedHiddenSub returns [Boolean current=false] : (this_SuppressedHiddenSubSub_0= ruleSuppressedHiddenSubSub | this_SuppressedHiddenSubID_1= ruleSuppressedHiddenSubID ) ;
    public final Boolean ruleSuppressedHiddenSub() throws RecognitionException {
        Boolean current = false;

        Boolean this_SuppressedHiddenSubSub_0 = null;

        Boolean this_SuppressedHiddenSubID_1 = null;


        try {
            // PsiInternalFormatterTestLanguage.g:1018:1: ( (this_SuppressedHiddenSubSub_0= ruleSuppressedHiddenSubSub | this_SuppressedHiddenSubID_1= ruleSuppressedHiddenSubID ) )
            // PsiInternalFormatterTestLanguage.g:1019:2: (this_SuppressedHiddenSubSub_0= ruleSuppressedHiddenSubSub | this_SuppressedHiddenSubID_1= ruleSuppressedHiddenSubID )
            {
            // PsiInternalFormatterTestLanguage.g:1019:2: (this_SuppressedHiddenSubSub_0= ruleSuppressedHiddenSubSub | this_SuppressedHiddenSubID_1= ruleSuppressedHiddenSubID )
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
                    // PsiInternalFormatterTestLanguage.g:1020:3: this_SuppressedHiddenSubSub_0= ruleSuppressedHiddenSubSub
                    {

                    			markComposite(elementTypeProvider.getSuppressedHiddenSub_SuppressedHiddenSubSubParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SuppressedHiddenSubSub_0=ruleSuppressedHiddenSubSub();

                    state._fsp--;


                    			current = this_SuppressedHiddenSubSub_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalFormatterTestLanguage.g:1029:3: this_SuppressedHiddenSubID_1= ruleSuppressedHiddenSubID
                    {

                    			markComposite(elementTypeProvider.getSuppressedHiddenSub_SuppressedHiddenSubIDParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SuppressedHiddenSubID_1=ruleSuppressedHiddenSubID();

                    state._fsp--;


                    			current = this_SuppressedHiddenSubID_1;
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
    // $ANTLR end "ruleSuppressedHiddenSub"


    // $ANTLR start "entryRuleSuppressedHiddenSubSub"
    // PsiInternalFormatterTestLanguage.g:1041:1: entryRuleSuppressedHiddenSubSub returns [Boolean current=false] : iv_ruleSuppressedHiddenSubSub= ruleSuppressedHiddenSubSub EOF ;
    public final Boolean entryRuleSuppressedHiddenSubSub() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSuppressedHiddenSubSub = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // PsiInternalFormatterTestLanguage.g:1043:2: (iv_ruleSuppressedHiddenSubSub= ruleSuppressedHiddenSubSub EOF )
            // PsiInternalFormatterTestLanguage.g:1044:2: iv_ruleSuppressedHiddenSubSub= ruleSuppressedHiddenSubSub EOF
            {
             markComposite(elementTypeProvider.getSuppressedHiddenSubSubElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSuppressedHiddenSubSub=ruleSuppressedHiddenSubSub();

            state._fsp--;

             current =iv_ruleSuppressedHiddenSubSub; 
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
    // $ANTLR end "entryRuleSuppressedHiddenSubSub"


    // $ANTLR start "ruleSuppressedHiddenSubSub"
    // PsiInternalFormatterTestLanguage.g:1053:1: ruleSuppressedHiddenSubSub returns [Boolean current=false] : (otherlv_0= '<' ( (lv_idval_1_0= RULE_ID ) ) otherlv_2= '>' ) ;
    public final Boolean ruleSuppressedHiddenSubSub() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_idval_1_0=null;
        Token otherlv_2=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // PsiInternalFormatterTestLanguage.g:1056:2: ( (otherlv_0= '<' ( (lv_idval_1_0= RULE_ID ) ) otherlv_2= '>' ) )
            // PsiInternalFormatterTestLanguage.g:1057:2: (otherlv_0= '<' ( (lv_idval_1_0= RULE_ID ) ) otherlv_2= '>' )
            {
            // PsiInternalFormatterTestLanguage.g:1057:2: (otherlv_0= '<' ( (lv_idval_1_0= RULE_ID ) ) otherlv_2= '>' )
            // PsiInternalFormatterTestLanguage.g:1058:3: otherlv_0= '<' ( (lv_idval_1_0= RULE_ID ) ) otherlv_2= '>'
            {

            			markLeaf(elementTypeProvider.getSuppressedHiddenSubSub_LessThanSignKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalFormatterTestLanguage.g:1065:3: ( (lv_idval_1_0= RULE_ID ) )
            // PsiInternalFormatterTestLanguage.g:1066:4: (lv_idval_1_0= RULE_ID )
            {
            // PsiInternalFormatterTestLanguage.g:1066:4: (lv_idval_1_0= RULE_ID )
            // PsiInternalFormatterTestLanguage.g:1067:5: lv_idval_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSuppressedHiddenSubSub_IdvalIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_idval_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_27); 

            					doneLeaf(lv_idval_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getSuppressedHiddenSubSub_GreaterThanSignKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,36,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_2);
            		

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
    // $ANTLR end "ruleSuppressedHiddenSubSub"


    // $ANTLR start "entryRuleSuppressedHiddenSubID"
    // PsiInternalFormatterTestLanguage.g:1096:1: entryRuleSuppressedHiddenSubID returns [Boolean current=false] : iv_ruleSuppressedHiddenSubID= ruleSuppressedHiddenSubID EOF ;
    public final Boolean entryRuleSuppressedHiddenSubID() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSuppressedHiddenSubID = null;


        try {
            // PsiInternalFormatterTestLanguage.g:1096:63: (iv_ruleSuppressedHiddenSubID= ruleSuppressedHiddenSubID EOF )
            // PsiInternalFormatterTestLanguage.g:1097:2: iv_ruleSuppressedHiddenSubID= ruleSuppressedHiddenSubID EOF
            {
             markComposite(elementTypeProvider.getSuppressedHiddenSubIDElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSuppressedHiddenSubID=ruleSuppressedHiddenSubID();

            state._fsp--;

             current =iv_ruleSuppressedHiddenSubID; 
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
    // $ANTLR end "entryRuleSuppressedHiddenSubID"


    // $ANTLR start "ruleSuppressedHiddenSubID"
    // PsiInternalFormatterTestLanguage.g:1103:1: ruleSuppressedHiddenSubID returns [Boolean current=false] : ( (lv_idval_0_0= RULE_ID ) ) ;
    public final Boolean ruleSuppressedHiddenSubID() throws RecognitionException {
        Boolean current = false;

        Token lv_idval_0_0=null;

        try {
            // PsiInternalFormatterTestLanguage.g:1104:1: ( ( (lv_idval_0_0= RULE_ID ) ) )
            // PsiInternalFormatterTestLanguage.g:1105:2: ( (lv_idval_0_0= RULE_ID ) )
            {
            // PsiInternalFormatterTestLanguage.g:1105:2: ( (lv_idval_0_0= RULE_ID ) )
            // PsiInternalFormatterTestLanguage.g:1106:3: (lv_idval_0_0= RULE_ID )
            {
            // PsiInternalFormatterTestLanguage.g:1106:3: (lv_idval_0_0= RULE_ID )
            // PsiInternalFormatterTestLanguage.g:1107:4: lv_idval_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getSuppressedHiddenSubID_IdvalIDTerminalRuleCall_0ElementType());
            			

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			
            lv_idval_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				doneLeaf(lv_idval_0_0);
            			

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
    // $ANTLR end "ruleSuppressedHiddenSubID"


    // $ANTLR start "entryRuleDatatype1"
    // PsiInternalFormatterTestLanguage.g:1125:1: entryRuleDatatype1 returns [Boolean current=false] : iv_ruleDatatype1= ruleDatatype1 EOF ;
    public final Boolean entryRuleDatatype1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDatatype1 = null;


        try {
            // PsiInternalFormatterTestLanguage.g:1125:51: (iv_ruleDatatype1= ruleDatatype1 EOF )
            // PsiInternalFormatterTestLanguage.g:1126:2: iv_ruleDatatype1= ruleDatatype1 EOF
            {
             markComposite(elementTypeProvider.getDatatype1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatatype1=ruleDatatype1();

            state._fsp--;

             current =iv_ruleDatatype1; 
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
    // $ANTLR end "entryRuleDatatype1"


    // $ANTLR start "ruleDatatype1"
    // PsiInternalFormatterTestLanguage.g:1132:1: ruleDatatype1 returns [Boolean current=false] : ruleFQN ;
    public final Boolean ruleDatatype1() throws RecognitionException {
        Boolean current = false;

        try {
            // PsiInternalFormatterTestLanguage.g:1133:1: ( ruleFQN )
            // PsiInternalFormatterTestLanguage.g:1134:2: ruleFQN
            {

            		markComposite(elementTypeProvider.getDatatype1_FQNParserRuleCallElementType());
            	
            pushFollow(FollowSets000.FOLLOW_2);
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
        return current;
    }
    // $ANTLR end "ruleDatatype1"


    // $ANTLR start "entryRuleDatatype2"
    // PsiInternalFormatterTestLanguage.g:1144:1: entryRuleDatatype2 returns [Boolean current=false] : iv_ruleDatatype2= ruleDatatype2 EOF ;
    public final Boolean entryRuleDatatype2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDatatype2 = null;


        try {
            // PsiInternalFormatterTestLanguage.g:1144:51: (iv_ruleDatatype2= ruleDatatype2 EOF )
            // PsiInternalFormatterTestLanguage.g:1145:2: iv_ruleDatatype2= ruleDatatype2 EOF
            {
             markComposite(elementTypeProvider.getDatatype2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatatype2=ruleDatatype2();

            state._fsp--;

             current =iv_ruleDatatype2; 
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
    // $ANTLR end "entryRuleDatatype2"


    // $ANTLR start "ruleDatatype2"
    // PsiInternalFormatterTestLanguage.g:1151:1: ruleDatatype2 returns [Boolean current=false] : ruleFQN ;
    public final Boolean ruleDatatype2() throws RecognitionException {
        Boolean current = false;

        try {
            // PsiInternalFormatterTestLanguage.g:1152:1: ( ruleFQN )
            // PsiInternalFormatterTestLanguage.g:1153:2: ruleFQN
            {

            		markComposite(elementTypeProvider.getDatatype2_FQNParserRuleCallElementType());
            	
            pushFollow(FollowSets000.FOLLOW_2);
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
        return current;
    }
    // $ANTLR end "ruleDatatype2"


    // $ANTLR start "entryRuleDatatype3"
    // PsiInternalFormatterTestLanguage.g:1163:1: entryRuleDatatype3 returns [Boolean current=false] : iv_ruleDatatype3= ruleDatatype3 EOF ;
    public final Boolean entryRuleDatatype3() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDatatype3 = null;


        try {
            // PsiInternalFormatterTestLanguage.g:1163:51: (iv_ruleDatatype3= ruleDatatype3 EOF )
            // PsiInternalFormatterTestLanguage.g:1164:2: iv_ruleDatatype3= ruleDatatype3 EOF
            {
             markComposite(elementTypeProvider.getDatatype3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatatype3=ruleDatatype3();

            state._fsp--;

             current =iv_ruleDatatype3; 
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
    // $ANTLR end "entryRuleDatatype3"


    // $ANTLR start "ruleDatatype3"
    // PsiInternalFormatterTestLanguage.g:1170:1: ruleDatatype3 returns [Boolean current=false] : ruleFQN ;
    public final Boolean ruleDatatype3() throws RecognitionException {
        Boolean current = false;

        try {
            // PsiInternalFormatterTestLanguage.g:1171:1: ( ruleFQN )
            // PsiInternalFormatterTestLanguage.g:1172:2: ruleFQN
            {

            		markComposite(elementTypeProvider.getDatatype3_FQNParserRuleCallElementType());
            	
            pushFollow(FollowSets000.FOLLOW_2);
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
        return current;
    }
    // $ANTLR end "ruleDatatype3"


    // $ANTLR start "entryRuleDatatypes"
    // PsiInternalFormatterTestLanguage.g:1182:1: entryRuleDatatypes returns [Boolean current=false] : iv_ruleDatatypes= ruleDatatypes EOF ;
    public final Boolean entryRuleDatatypes() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDatatypes = null;


        try {
            // PsiInternalFormatterTestLanguage.g:1182:51: (iv_ruleDatatypes= ruleDatatypes EOF )
            // PsiInternalFormatterTestLanguage.g:1183:2: iv_ruleDatatypes= ruleDatatypes EOF
            {
             markComposite(elementTypeProvider.getDatatypesElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatatypes=ruleDatatypes();

            state._fsp--;

             current =iv_ruleDatatypes; 
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
    // $ANTLR end "entryRuleDatatypes"


    // $ANTLR start "ruleDatatypes"
    // PsiInternalFormatterTestLanguage.g:1189:1: ruleDatatypes returns [Boolean current=false] : (otherlv_0= 'datatypes' ( (lv_val1_1_0= ruleDatatype1 ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= ruleDatatype2 ) ) ( (lv_val3_4_0= ruleDatatype3 ) ) otherlv_5= 'kw3' ) ;
    public final Boolean ruleDatatypes() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Boolean lv_val1_1_0 = null;

        Boolean lv_val2_3_0 = null;

        Boolean lv_val3_4_0 = null;


        try {
            // PsiInternalFormatterTestLanguage.g:1190:1: ( (otherlv_0= 'datatypes' ( (lv_val1_1_0= ruleDatatype1 ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= ruleDatatype2 ) ) ( (lv_val3_4_0= ruleDatatype3 ) ) otherlv_5= 'kw3' ) )
            // PsiInternalFormatterTestLanguage.g:1191:2: (otherlv_0= 'datatypes' ( (lv_val1_1_0= ruleDatatype1 ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= ruleDatatype2 ) ) ( (lv_val3_4_0= ruleDatatype3 ) ) otherlv_5= 'kw3' )
            {
            // PsiInternalFormatterTestLanguage.g:1191:2: (otherlv_0= 'datatypes' ( (lv_val1_1_0= ruleDatatype1 ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= ruleDatatype2 ) ) ( (lv_val3_4_0= ruleDatatype3 ) ) otherlv_5= 'kw3' )
            // PsiInternalFormatterTestLanguage.g:1192:3: otherlv_0= 'datatypes' ( (lv_val1_1_0= ruleDatatype1 ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= ruleDatatype2 ) ) ( (lv_val3_4_0= ruleDatatype3 ) ) otherlv_5= 'kw3'
            {

            			markLeaf(elementTypeProvider.getDatatypes_DatatypesKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalFormatterTestLanguage.g:1199:3: ( (lv_val1_1_0= ruleDatatype1 ) )
            // PsiInternalFormatterTestLanguage.g:1200:4: (lv_val1_1_0= ruleDatatype1 )
            {
            // PsiInternalFormatterTestLanguage.g:1200:4: (lv_val1_1_0= ruleDatatype1 )
            // PsiInternalFormatterTestLanguage.g:1201:5: lv_val1_1_0= ruleDatatype1
            {

            					markComposite(elementTypeProvider.getDatatypes_Val1Datatype1ParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_28);
            lv_val1_1_0=ruleDatatype1();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            			markLeaf(elementTypeProvider.getDatatypes_Kw1Keyword_2ElementType());
            		
            otherlv_2=(Token)match(input,38,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalFormatterTestLanguage.g:1221:3: ( (lv_val2_3_0= ruleDatatype2 ) )
            // PsiInternalFormatterTestLanguage.g:1222:4: (lv_val2_3_0= ruleDatatype2 )
            {
            // PsiInternalFormatterTestLanguage.g:1222:4: (lv_val2_3_0= ruleDatatype2 )
            // PsiInternalFormatterTestLanguage.g:1223:5: lv_val2_3_0= ruleDatatype2
            {

            					markComposite(elementTypeProvider.getDatatypes_Val2Datatype2ParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_6);
            lv_val2_3_0=ruleDatatype2();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalFormatterTestLanguage.g:1236:3: ( (lv_val3_4_0= ruleDatatype3 ) )
            // PsiInternalFormatterTestLanguage.g:1237:4: (lv_val3_4_0= ruleDatatype3 )
            {
            // PsiInternalFormatterTestLanguage.g:1237:4: (lv_val3_4_0= ruleDatatype3 )
            // PsiInternalFormatterTestLanguage.g:1238:5: lv_val3_4_0= ruleDatatype3
            {

            					markComposite(elementTypeProvider.getDatatypes_Val3Datatype3ParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_29);
            lv_val3_4_0=ruleDatatype3();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            			markLeaf(elementTypeProvider.getDatatypes_Kw3Keyword_5ElementType());
            		
            otherlv_5=(Token)match(input,39,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_5);
            		

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
    // $ANTLR end "ruleDatatypes"


    // $ANTLR start "entryRuleWrappingDataTypeTest"
    // PsiInternalFormatterTestLanguage.g:1262:1: entryRuleWrappingDataTypeTest returns [Boolean current=false] : iv_ruleWrappingDataTypeTest= ruleWrappingDataTypeTest EOF ;
    public final Boolean entryRuleWrappingDataTypeTest() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleWrappingDataTypeTest = null;


        try {
            // PsiInternalFormatterTestLanguage.g:1262:62: (iv_ruleWrappingDataTypeTest= ruleWrappingDataTypeTest EOF )
            // PsiInternalFormatterTestLanguage.g:1263:2: iv_ruleWrappingDataTypeTest= ruleWrappingDataTypeTest EOF
            {
             markComposite(elementTypeProvider.getWrappingDataTypeTestElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWrappingDataTypeTest=ruleWrappingDataTypeTest();

            state._fsp--;

             current =iv_ruleWrappingDataTypeTest; 
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
    // $ANTLR end "entryRuleWrappingDataTypeTest"


    // $ANTLR start "ruleWrappingDataTypeTest"
    // PsiInternalFormatterTestLanguage.g:1269:1: ruleWrappingDataTypeTest returns [Boolean current=false] : (otherlv_0= 'wrappingdt' ( (lv_datatype_1_0= ruleWrappingDataType ) ) otherlv_2= 'kw1' ) ;
    public final Boolean ruleWrappingDataTypeTest() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean lv_datatype_1_0 = null;


        try {
            // PsiInternalFormatterTestLanguage.g:1270:1: ( (otherlv_0= 'wrappingdt' ( (lv_datatype_1_0= ruleWrappingDataType ) ) otherlv_2= 'kw1' ) )
            // PsiInternalFormatterTestLanguage.g:1271:2: (otherlv_0= 'wrappingdt' ( (lv_datatype_1_0= ruleWrappingDataType ) ) otherlv_2= 'kw1' )
            {
            // PsiInternalFormatterTestLanguage.g:1271:2: (otherlv_0= 'wrappingdt' ( (lv_datatype_1_0= ruleWrappingDataType ) ) otherlv_2= 'kw1' )
            // PsiInternalFormatterTestLanguage.g:1272:3: otherlv_0= 'wrappingdt' ( (lv_datatype_1_0= ruleWrappingDataType ) ) otherlv_2= 'kw1'
            {

            			markLeaf(elementTypeProvider.getWrappingDataTypeTest_WrappingdtKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalFormatterTestLanguage.g:1279:3: ( (lv_datatype_1_0= ruleWrappingDataType ) )
            // PsiInternalFormatterTestLanguage.g:1280:4: (lv_datatype_1_0= ruleWrappingDataType )
            {
            // PsiInternalFormatterTestLanguage.g:1280:4: (lv_datatype_1_0= ruleWrappingDataType )
            // PsiInternalFormatterTestLanguage.g:1281:5: lv_datatype_1_0= ruleWrappingDataType
            {

            					markComposite(elementTypeProvider.getWrappingDataTypeTest_DatatypeWrappingDataTypeParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_28);
            lv_datatype_1_0=ruleWrappingDataType();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            			markLeaf(elementTypeProvider.getWrappingDataTypeTest_Kw1Keyword_2ElementType());
            		
            otherlv_2=(Token)match(input,38,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_2);
            		

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
    // $ANTLR end "ruleWrappingDataTypeTest"


    // $ANTLR start "entryRuleWrappingDataType"
    // PsiInternalFormatterTestLanguage.g:1305:1: entryRuleWrappingDataType returns [Boolean current=false] : iv_ruleWrappingDataType= ruleWrappingDataType EOF ;
    public final Boolean entryRuleWrappingDataType() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleWrappingDataType = null;


        try {
            // PsiInternalFormatterTestLanguage.g:1305:58: (iv_ruleWrappingDataType= ruleWrappingDataType EOF )
            // PsiInternalFormatterTestLanguage.g:1306:2: iv_ruleWrappingDataType= ruleWrappingDataType EOF
            {
             markComposite(elementTypeProvider.getWrappingDataTypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWrappingDataType=ruleWrappingDataType();

            state._fsp--;

             current =iv_ruleWrappingDataType; 
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
    // $ANTLR end "entryRuleWrappingDataType"


    // $ANTLR start "ruleWrappingDataType"
    // PsiInternalFormatterTestLanguage.g:1312:1: ruleWrappingDataType returns [Boolean current=false] : (this_ID_0= RULE_ID )+ ;
    public final Boolean ruleWrappingDataType() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;

        try {
            // PsiInternalFormatterTestLanguage.g:1313:1: ( (this_ID_0= RULE_ID )+ )
            // PsiInternalFormatterTestLanguage.g:1314:2: (this_ID_0= RULE_ID )+
            {
            // PsiInternalFormatterTestLanguage.g:1314:2: (this_ID_0= RULE_ID )+
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
            	    // PsiInternalFormatterTestLanguage.g:1315:3: this_ID_0= RULE_ID
            	    {

            	    			markLeaf(elementTypeProvider.getWrappingDataType_IDTerminalRuleCallElementType());
            	    		
            	    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_30); 

            	    			doneLeaf(this_ID_0);
            	    		

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
        return current;
    }
    // $ANTLR end "ruleWrappingDataType"


    // $ANTLR start "ruleEnum1"
    // PsiInternalFormatterTestLanguage.g:1326:1: ruleEnum1 returns [Boolean current=false] : ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) | (enumLiteral_2= 'lit3' ) ) ;
    public final Boolean ruleEnum1() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

        try {
            // PsiInternalFormatterTestLanguage.g:1327:1: ( ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) | (enumLiteral_2= 'lit3' ) ) )
            // PsiInternalFormatterTestLanguage.g:1328:2: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) | (enumLiteral_2= 'lit3' ) )
            {
            // PsiInternalFormatterTestLanguage.g:1328:2: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) | (enumLiteral_2= 'lit3' ) )
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
                    // PsiInternalFormatterTestLanguage.g:1329:3: (enumLiteral_0= 'lit1' )
                    {
                    // PsiInternalFormatterTestLanguage.g:1329:3: (enumLiteral_0= 'lit1' )
                    // PsiInternalFormatterTestLanguage.g:1330:4: enumLiteral_0= 'lit1'
                    {

                    				markLeaf(elementTypeProvider.getEnum1_Lit1EnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,41,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalFormatterTestLanguage.g:1339:3: (enumLiteral_1= 'lit2' )
                    {
                    // PsiInternalFormatterTestLanguage.g:1339:3: (enumLiteral_1= 'lit2' )
                    // PsiInternalFormatterTestLanguage.g:1340:4: enumLiteral_1= 'lit2'
                    {

                    				markLeaf(elementTypeProvider.getEnum1_Lit2EnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,42,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_1);
                    			

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalFormatterTestLanguage.g:1349:3: (enumLiteral_2= 'lit3' )
                    {
                    // PsiInternalFormatterTestLanguage.g:1349:3: (enumLiteral_2= 'lit3' )
                    // PsiInternalFormatterTestLanguage.g:1350:4: enumLiteral_2= 'lit3'
                    {

                    				markLeaf(elementTypeProvider.getEnum1_Lit3EnumLiteralDeclaration_2ElementType());
                    			
                    enumLiteral_2=(Token)match(input,43,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_2);
                    			

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
    // $ANTLR end "ruleEnum1"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\2\4\11\uffff";
    static final String dfa_3s = "\1\45\1\17\11\uffff";
    static final String dfa_4s = "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\2\1\1";
    static final String dfa_5s = "\13\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\16\uffff\1\2\3\uffff\1\7\5\uffff\1\3\1\uffff\1\4\1\5\1\6\3\uffff\1\10",
            "\1\12\11\uffff\2\11",
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

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "120:3: (this_Decl_0= ruleDecl | this_Assign_1= ruleAssign | this_Meth_2= ruleMeth | this_FqnObj_3= ruleFqnObj | this_FqnRef_4= ruleFqnRef | this_Enumeration_5= ruleEnumeration | (this_SuppressedHidden_6= ruleSuppressedHidden otherlv_7= 'post' ) | this_Space_8= ruleSpace | this_Datatypes_9= ruleDatatypes )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000010007000000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040020L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000220000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000023A0880012L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000023B4880010L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00000E0000000000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00000E0000020002L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000A00000010L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000600000000L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000800000010L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000012L});
    }


}