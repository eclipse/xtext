package org.eclipse.xtext.xbase.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.xbase.idea.lang.XtypeElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class PsiInternalXtypeParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'['", "']'", "'('", "','", "')'", "'=>'", "'<'", "'>'", "'.'", "'?'", "'extends'", "'&'", "'super'", "'*'", "'import'", "'static'", "'extension'", "';'"
    };
    public static final int RULE_ID=4;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=9;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=7;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=6;
    public static final int T__19=19;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__10=10;
    public static final int RULE_WS=8;

    // delegates
    // delegators


        public PsiInternalXtypeParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalXtypeParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalXtypeParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g"; }



    	protected XtypeGrammarAccess grammarAccess;

    	protected XtypeElementTypeProvider elementTypeProvider;

    	public PsiInternalXtypeParser(PsiBuilder builder, TokenStream input, XtypeElementTypeProvider elementTypeProvider, XtypeGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "JvmTypeReference";
    	}




    // $ANTLR start "entryRuleJvmTypeReference"
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:52:1: entryRuleJvmTypeReference : ruleJvmTypeReference EOF ;
    public final void entryRuleJvmTypeReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:52:26: ( ruleJvmTypeReference EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:53:2: ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmTypeReferenceElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference54);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference60); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:59:1: ruleJvmTypeReference : ( ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | ruleXFunctionTypeRef ) ;
    public final void ruleJvmTypeReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:59:21: ( ( ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | ruleXFunctionTypeRef ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:60:2: ( ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | ruleXFunctionTypeRef )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:60:2: ( ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | ruleXFunctionTypeRef )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==12||LA2_0==15) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:61:3: ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:61:3: ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:62:4: ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getJvmTypeReference_JvmParameterizedTypeReferenceParserRuleCall_0_0ElementType());
                      			
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference83);
                    ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneComposite();
                      			
                    }
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:69:4: ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==10) && (synpred1_PsiInternalXtype())) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:70:5: ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:76:5: ( () ruleArrayBrackets )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:77:6: () ruleArrayBrackets
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:77:6: ()
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:78:7: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							precedeComposite(elementTypeProvider.getJvmTypeReference_JvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0ElementType());
                    	      							doneComposite();
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						markComposite(elementTypeProvider.getJvmTypeReference_ArrayBracketsParserRuleCall_0_1_0_1ElementType());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_ruleArrayBrackets_in_ruleJvmTypeReference176);
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
                    	    break loop1;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:94:3: ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getJvmTypeReference_XFunctionTypeRefParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference215);
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:105:1: entryRuleArrayBrackets : ruleArrayBrackets EOF ;
    public final void entryRuleArrayBrackets() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:105:23: ( ruleArrayBrackets EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:106:2: ruleArrayBrackets EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getArrayBracketsElementType()); 
            }
            pushFollow(FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets235);
            ruleArrayBrackets();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayBrackets241); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:112:1: ruleArrayBrackets : (kw= '[' kw= ']' ) ;
    public final void ruleArrayBrackets() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:112:18: ( (kw= '[' kw= ']' ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:113:2: (kw= '[' kw= ']' )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:113:2: (kw= '[' kw= ']' )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:114:3: kw= '[' kw= ']'
            {
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            kw=(Token)match(input,10,FOLLOW_10_in_ruleArrayBrackets260); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw, elementTypeProvider.getArrayBrackets_LeftSquareBracketKeyword_0ElementType());
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            kw=(Token)match(input,11,FOLLOW_11_in_ruleArrayBrackets274); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw, elementTypeProvider.getArrayBrackets_RightSquareBracketKeyword_1ElementType());
              		
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:132:1: entryRuleXFunctionTypeRef : ruleXFunctionTypeRef EOF ;
    public final void entryRuleXFunctionTypeRef() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:132:26: ( ruleXFunctionTypeRef EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:133:2: ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXFunctionTypeRefElementType()); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef294);
            ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef300); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:139:1: ruleXFunctionTypeRef : ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleXFunctionTypeRef() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:139:21: ( ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:140:2: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:140:2: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:141:3: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:141:3: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:142:4: otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf();
                      			
                    }
                    otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleXFunctionTypeRef325); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_0, elementTypeProvider.getXFunctionTypeRef_LeftParenthesisKeyword_0_0ElementType());
                      			
                    }
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:149:4: ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID||LA4_0==12||LA4_0==15) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:150:5: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            {
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:150:5: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:151:6: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            {
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:151:6: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:152:7: lv_paramTypes_1_0= ruleJvmTypeReference
                            {
                            if ( state.backtracking==0 ) {

                              							markComposite(elementTypeProvider.getXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0ElementType());
                              						
                            }
                            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef366);
                            ruleJvmTypeReference();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneComposite();
                              						
                            }

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:161:5: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==13) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:162:6: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      						markLeaf();
                            	      					
                            	    }
                            	    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleXFunctionTypeRef409); if (state.failed) return ;
                            	    if ( state.backtracking==0 ) {

                            	      						doneLeaf(otherlv_2, elementTypeProvider.getXFunctionTypeRef_CommaKeyword_0_1_1_0ElementType());
                            	      					
                            	    }
                            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:169:6: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:170:7: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    {
                            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:170:7: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:171:8: lv_paramTypes_3_0= ruleJvmTypeReference
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								markComposite(elementTypeProvider.getXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0ElementType());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef451);
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
                            	    break loop3;
                                }
                            } while (true);


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf();
                      			
                    }
                    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleXFunctionTypeRef500); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_4, elementTypeProvider.getXFunctionTypeRef_RightParenthesisKeyword_0_2ElementType());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleXFunctionTypeRef520); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_5, elementTypeProvider.getXFunctionTypeRef_EqualsSignGreaterThanSignKeyword_1ElementType());
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:197:3: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:198:4: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:198:4: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:199:5: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXFunctionTypeRef_ReturnTypeJvmTypeReferenceParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef547);
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:212:1: entryRuleJvmParameterizedTypeReference : ruleJvmParameterizedTypeReference EOF ;
    public final void entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:212:39: ( ruleJvmParameterizedTypeReference EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:213:2: ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmParameterizedTypeReferenceElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference578);
            ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference584); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:219:1: ruleJvmParameterizedTypeReference : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) ;
    public final void ruleJvmParameterizedTypeReference() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:219:34: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:220:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:220:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:221:3: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:221:3: ( ( ruleQualifiedName ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:222:4: ( ruleQualifiedName )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:222:4: ( ruleQualifiedName )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:223:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmParameterizedTypeReference_TypeJvmTypeCrossReference_0_0ElementType());
              				
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference614);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:232:3: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==16) && (synpred2_PsiInternalXtype())) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:233:4: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:233:4: ( ( '<' )=>otherlv_1= '<' )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:234:5: ( '<' )=>otherlv_1= '<'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf();
                      				
                    }
                    otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleJvmParameterizedTypeReference661); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1, elementTypeProvider.getJvmParameterizedTypeReference_LessThanSignKeyword_1_0ElementType());
                      				
                    }

                    }

                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:243:4: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:244:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:244:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:245:6: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference699);
                    ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:254:4: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==13) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:255:5: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf();
                    	      				
                    	    }
                    	    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleJvmParameterizedTypeReference736); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_3, elementTypeProvider.getJvmParameterizedTypeReference_CommaKeyword_1_2_0ElementType());
                    	      				
                    	    }
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:262:5: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:263:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:263:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:264:7: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference773);
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
                    	    break loop6;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				markLeaf();
                      			
                    }
                    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleJvmParameterizedTypeReference812); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_5, elementTypeProvider.getJvmParameterizedTypeReference_GreaterThanSignKeyword_1_3ElementType());
                      			
                    }
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:281:4: ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==18) && (synpred3_PsiInternalXtype())) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:282:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:282:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:283:6: ( ( () '.' ) )=> ( () otherlv_7= '.' )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:289:6: ( () otherlv_7= '.' )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:290:7: () otherlv_7= '.'
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:290:7: ()
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:291:8: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								precedeComposite(elementTypeProvider.getJvmParameterizedTypeReference_JvmInnerTypeReferenceOuterAction_1_4_0_0_0ElementType());
                    	      								doneComposite();
                    	      							
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      							markLeaf();
                    	      						
                    	    }
                    	    otherlv_7=(Token)match(input,18,FOLLOW_18_in_ruleJvmParameterizedTypeReference925); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneLeaf(otherlv_7, elementTypeProvider.getJvmParameterizedTypeReference_FullStopKeyword_1_4_0_0_1ElementType());
                    	      						
                    	    }

                    	    }


                    	    }

                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:305:5: ( ( ruleValidID ) )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:306:6: ( ruleValidID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:306:6: ( ruleValidID )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:307:7: ruleValidID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmParameterizedTypeReference_TypeJvmTypeCrossReference_1_4_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_ruleValidID_in_ruleJvmParameterizedTypeReference975);
                    	    ruleValidID();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      						
                    	    }

                    	    }


                    	    }

                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:316:5: ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
                    	    int alt8=2;
                    	    int LA8_0 = input.LA(1);

                    	    if ( (LA8_0==16) && (synpred4_PsiInternalXtype())) {
                    	        alt8=1;
                    	    }
                    	    switch (alt8) {
                    	        case 1 :
                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:317:6: ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>'
                    	            {
                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:317:6: ( ( '<' )=>otherlv_9= '<' )
                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:318:7: ( '<' )=>otherlv_9= '<'
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              							markLeaf();
                    	              						
                    	            }
                    	            otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleJvmParameterizedTypeReference1038); if (state.failed) return ;
                    	            if ( state.backtracking==0 ) {

                    	              							doneLeaf(otherlv_9, elementTypeProvider.getJvmParameterizedTypeReference_LessThanSignKeyword_1_4_2_0ElementType());
                    	              						
                    	            }

                    	            }

                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:327:6: ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) )
                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:328:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
                    	            {
                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:328:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:329:8: lv_arguments_10_0= ruleJvmArgumentTypeReference
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0ElementType());
                    	              							
                    	            }
                    	            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference1088);
                    	            ruleJvmArgumentTypeReference();

                    	            state._fsp--;
                    	            if (state.failed) return ;
                    	            if ( state.backtracking==0 ) {

                    	              								doneComposite();
                    	              							
                    	            }

                    	            }


                    	            }

                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:338:6: (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )*
                    	            loop7:
                    	            do {
                    	                int alt7=2;
                    	                int LA7_0 = input.LA(1);

                    	                if ( (LA7_0==13) ) {
                    	                    alt7=1;
                    	                }


                    	                switch (alt7) {
                    	            	case 1 :
                    	            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:339:7: otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
                    	            	    {
                    	            	    if ( state.backtracking==0 ) {

                    	            	      							markLeaf();
                    	            	      						
                    	            	    }
                    	            	    otherlv_11=(Token)match(input,13,FOLLOW_13_in_ruleJvmParameterizedTypeReference1137); if (state.failed) return ;
                    	            	    if ( state.backtracking==0 ) {

                    	            	      							doneLeaf(otherlv_11, elementTypeProvider.getJvmParameterizedTypeReference_CommaKeyword_1_4_2_2_0ElementType());
                    	            	      						
                    	            	    }
                    	            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:346:7: ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
                    	            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:347:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
                    	            	    {
                    	            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:347:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
                    	            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:348:9: lv_arguments_12_0= ruleJvmArgumentTypeReference
                    	            	    {
                    	            	    if ( state.backtracking==0 ) {

                    	            	      									markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0ElementType());
                    	            	      								
                    	            	    }
                    	            	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference1184);
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
                    	            	    break loop7;
                    	                }
                    	            } while (true);

                    	            if ( state.backtracking==0 ) {

                    	              						markLeaf();
                    	              					
                    	            }
                    	            otherlv_13=(Token)match(input,17,FOLLOW_17_in_ruleJvmParameterizedTypeReference1235); if (state.failed) return ;
                    	            if ( state.backtracking==0 ) {

                    	              						doneLeaf(otherlv_13, elementTypeProvider.getJvmParameterizedTypeReference_GreaterThanSignKeyword_1_4_2_3ElementType());
                    	              					
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:372:1: entryRuleJvmArgumentTypeReference : ruleJvmArgumentTypeReference EOF ;
    public final void entryRuleJvmArgumentTypeReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:372:34: ( ruleJvmArgumentTypeReference EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:373:2: ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmArgumentTypeReferenceElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference1276);
            ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference1282); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:379:1: ruleJvmArgumentTypeReference : ( ruleJvmTypeReference | ruleJvmWildcardTypeReference ) ;
    public final void ruleJvmArgumentTypeReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:379:29: ( ( ruleJvmTypeReference | ruleJvmWildcardTypeReference ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:380:2: ( ruleJvmTypeReference | ruleJvmWildcardTypeReference )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:380:2: ( ruleJvmTypeReference | ruleJvmWildcardTypeReference )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID||LA11_0==12||LA11_0==15) ) {
                alt11=1;
            }
            else if ( (LA11_0==19) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:381:3: ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getJvmArgumentTypeReference_JvmTypeReferenceParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference1299);
                    ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:389:3: ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getJvmArgumentTypeReference_JvmWildcardTypeReferenceParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference1319);
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:400:1: entryRuleJvmWildcardTypeReference : ruleJvmWildcardTypeReference EOF ;
    public final void entryRuleJvmWildcardTypeReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:400:34: ( ruleJvmWildcardTypeReference EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:401:2: ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmWildcardTypeReferenceElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference1339);
            ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference1345); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:407:1: ruleJvmWildcardTypeReference : ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) ;
    public final void ruleJvmWildcardTypeReference() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:407:29: ( ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:408:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:408:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:409:3: () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:409:3: ()
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:410:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getJvmWildcardTypeReference_JvmWildcardTypeReferenceAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleJvmWildcardTypeReference1377); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1, elementTypeProvider.getJvmWildcardTypeReference_QuestionMarkKeyword_1ElementType());
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:422:3: ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
            int alt14=3;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==20) ) {
                alt14=1;
            }
            else if ( (LA14_0==22) ) {
                alt14=2;
            }
            switch (alt14) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:423:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:423:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:424:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:424:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:425:6: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:425:6: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:426:7: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmUpperBoundParserRuleCall_2_0_0_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference1421);
                    ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:435:5: ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==21) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:436:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:436:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:437:7: lv_constraints_3_0= ruleJvmUpperBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmWildcardTypeReference1473);
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
                    	    break loop12;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:448:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:448:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:449:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:449:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:450:6: (lv_constraints_4_0= ruleJvmLowerBound )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:450:6: (lv_constraints_4_0= ruleJvmLowerBound )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:451:7: lv_constraints_4_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmLowerBoundParserRuleCall_2_1_0_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference1545);
                    ruleJvmLowerBound();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:460:5: ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==21) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:461:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:461:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:462:7: lv_constraints_5_0= ruleJvmLowerBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmLowerBoundAnded_in_ruleJvmWildcardTypeReference1597);
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
                    	    break loop13;
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:477:1: entryRuleJvmUpperBound : ruleJvmUpperBound EOF ;
    public final void entryRuleJvmUpperBound() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:477:23: ( ruleJvmUpperBound EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:478:2: ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmUpperBoundElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound1645);
            ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound1651); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:484:1: ruleJvmUpperBound : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleJvmUpperBound() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:484:18: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:485:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:485:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:486:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleJvmUpperBound1670); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0, elementTypeProvider.getJvmUpperBound_ExtendsKeyword_0ElementType());
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:493:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:494:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:494:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:495:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmUpperBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound1697);
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:508:1: entryRuleJvmUpperBoundAnded : ruleJvmUpperBoundAnded EOF ;
    public final void entryRuleJvmUpperBoundAnded() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:508:28: ( ruleJvmUpperBoundAnded EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:509:2: ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmUpperBoundAndedElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded1728);
            ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded1734); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:515:1: ruleJvmUpperBoundAnded : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleJvmUpperBoundAnded() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:515:23: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:516:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:516:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:517:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleJvmUpperBoundAnded1753); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0, elementTypeProvider.getJvmUpperBoundAnded_AmpersandKeyword_0ElementType());
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:524:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:525:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:525:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:526:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmUpperBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded1780);
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:539:1: entryRuleJvmLowerBound : ruleJvmLowerBound EOF ;
    public final void entryRuleJvmLowerBound() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:539:23: ( ruleJvmLowerBound EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:540:2: ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmLowerBoundElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound1811);
            ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound1817); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:546:1: ruleJvmLowerBound : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleJvmLowerBound() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:546:18: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:547:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:547:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:548:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleJvmLowerBound1836); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0, elementTypeProvider.getJvmLowerBound_SuperKeyword_0ElementType());
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:555:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:556:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:556:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:557:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmLowerBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound1863);
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:570:1: entryRuleJvmLowerBoundAnded : ruleJvmLowerBoundAnded EOF ;
    public final void entryRuleJvmLowerBoundAnded() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:570:28: ( ruleJvmLowerBoundAnded EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:571:2: ruleJvmLowerBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmLowerBoundAndedElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBoundAnded_in_entryRuleJvmLowerBoundAnded1894);
            ruleJvmLowerBoundAnded();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBoundAnded1900); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:577:1: ruleJvmLowerBoundAnded : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleJvmLowerBoundAnded() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:577:23: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:578:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:578:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:579:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleJvmLowerBoundAnded1919); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0, elementTypeProvider.getJvmLowerBoundAnded_AmpersandKeyword_0ElementType());
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:586:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:587:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:587:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:588:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmLowerBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBoundAnded1946);
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


    // $ANTLR start "entryRuleQualifiedName"
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:601:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:601:23: ( ruleQualifiedName EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:602:2: ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getQualifiedNameElementType()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1977);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName1983); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:608:1: ruleQualifiedName : ( ruleValidID (kw= '.' ruleValidID )* ) ;
    public final void ruleQualifiedName() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:608:18: ( ( ruleValidID (kw= '.' ruleValidID )* ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:609:2: ( ruleValidID (kw= '.' ruleValidID )* )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:609:2: ( ruleValidID (kw= '.' ruleValidID )* )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:610:3: ruleValidID (kw= '.' ruleValidID )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getQualifiedName_ValidIDParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName2000);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:617:3: (kw= '.' ruleValidID )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==18) ) {
                    int LA15_2 = input.LA(2);

                    if ( (LA15_2==RULE_ID) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:618:4: kw= '.' ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markLeaf();
            	      			
            	    }
            	    kw=(Token)match(input,18,FOLLOW_18_in_ruleQualifiedName2020); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(kw, elementTypeProvider.getQualifiedName_FullStopKeyword_1_0ElementType());
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				markComposite(elementTypeProvider.getQualifiedName_ValidIDParserRuleCall_1_1ElementType());
            	      			
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName2035);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneComposite();
            	      			
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:637:1: entryRuleQualifiedNameWithWildcard : ruleQualifiedNameWithWildcard EOF ;
    public final void entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:637:35: ( ruleQualifiedNameWithWildcard EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:638:2: ruleQualifiedNameWithWildcard EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getQualifiedNameWithWildcardElementType()); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard2061);
            ruleQualifiedNameWithWildcard();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard2067); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:644:1: ruleQualifiedNameWithWildcard : ( ruleQualifiedName kw= '.' kw= '*' ) ;
    public final void ruleQualifiedNameWithWildcard() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:644:30: ( ( ruleQualifiedName kw= '.' kw= '*' ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:645:2: ( ruleQualifiedName kw= '.' kw= '*' )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:645:2: ( ruleQualifiedName kw= '.' kw= '*' )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:646:3: ruleQualifiedName kw= '.' kw= '*'
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getQualifiedNameWithWildcard_QualifiedNameParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard2084);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            kw=(Token)match(input,18,FOLLOW_18_in_ruleQualifiedNameWithWildcard2098); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw, elementTypeProvider.getQualifiedNameWithWildcard_FullStopKeyword_1ElementType());
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            kw=(Token)match(input,23,FOLLOW_23_in_ruleQualifiedNameWithWildcard2112); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw, elementTypeProvider.getQualifiedNameWithWildcard_AsteriskKeyword_2ElementType());
              		
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:671:1: entryRuleValidID : ruleValidID EOF ;
    public final void entryRuleValidID() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:671:17: ( ruleValidID EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:672:2: ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getValidIDElementType()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID2132);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID2138); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:678:1: ruleValidID : this_ID_0= RULE_ID ;
    public final void ruleValidID() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:678:12: (this_ID_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:679:2: this_ID_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              		markLeaf();
              	
            }
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID2152); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              		doneLeaf(this_ID_0, elementTypeProvider.getValidID_IDTerminalRuleCallElementType());
              	
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


    // $ANTLR start "entryRuleXImportDeclaration"
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:689:1: entryRuleXImportDeclaration : ruleXImportDeclaration EOF ;
    public final void entryRuleXImportDeclaration() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:689:28: ( ruleXImportDeclaration EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:690:2: ruleXImportDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXImportDeclarationElementType()); 
            }
            pushFollow(FOLLOW_ruleXImportDeclaration_in_entryRuleXImportDeclaration2168);
            ruleXImportDeclaration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXImportDeclaration2174); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:696:1: ruleXImportDeclaration : (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) ;
    public final void ruleXImportDeclaration() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_static_1_0=null;
        Token lv_extension_2_0=null;
        Token lv_wildcard_4_0=null;
        Token otherlv_8=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:696:23: ( (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:697:2: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:697:2: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:698:3: otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )?
            {
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleXImportDeclaration2193); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0, elementTypeProvider.getXImportDeclaration_ImportKeyword_0ElementType());
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:705:3: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )
            int alt18=3;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:706:4: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:706:4: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:707:5: ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:707:5: ( (lv_static_1_0= 'static' ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:708:6: (lv_static_1_0= 'static' )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:708:6: (lv_static_1_0= 'static' )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:709:7: lv_static_1_0= 'static'
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf();
                      						
                    }
                    lv_static_1_0=(Token)match(input,25,FOLLOW_25_in_ruleXImportDeclaration2237); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(lv_static_1_0, elementTypeProvider.getXImportDeclaration_StaticStaticKeyword_1_0_0_0ElementType());
                      						
                    }

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:718:5: ( (lv_extension_2_0= 'extension' ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==26) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:719:6: (lv_extension_2_0= 'extension' )
                            {
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:719:6: (lv_extension_2_0= 'extension' )
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:720:7: lv_extension_2_0= 'extension'
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf();
                              						
                            }
                            lv_extension_2_0=(Token)match(input,26,FOLLOW_26_in_ruleXImportDeclaration2289); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(lv_extension_2_0, elementTypeProvider.getXImportDeclaration_ExtensionExtensionKeyword_1_0_1_0ElementType());
                              						
                            }

                            }


                            }
                            break;

                    }

                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:729:5: ( ( ruleQualifiedNameInStaticImport ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:730:6: ( ruleQualifiedNameInStaticImport )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:730:6: ( ruleQualifiedNameInStaticImport )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:731:7: ruleQualifiedNameInStaticImport
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_ruleQualifiedNameInStaticImport_in_ruleXImportDeclaration2340);
                    ruleQualifiedNameInStaticImport();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:740:5: ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==23) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==RULE_ID) ) {
                        alt17=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:741:6: ( (lv_wildcard_4_0= '*' ) )
                            {
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:741:6: ( (lv_wildcard_4_0= '*' ) )
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:742:7: (lv_wildcard_4_0= '*' )
                            {
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:742:7: (lv_wildcard_4_0= '*' )
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:743:8: lv_wildcard_4_0= '*'
                            {
                            if ( state.backtracking==0 ) {

                              								markLeaf();
                              							
                            }
                            lv_wildcard_4_0=(Token)match(input,23,FOLLOW_23_in_ruleXImportDeclaration2402); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              								doneLeaf(lv_wildcard_4_0, elementTypeProvider.getXImportDeclaration_WildcardAsteriskKeyword_1_0_3_0_0ElementType());
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:753:6: ( (lv_memberName_5_0= ruleValidID ) )
                            {
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:753:6: ( (lv_memberName_5_0= ruleValidID ) )
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:754:7: (lv_memberName_5_0= ruleValidID )
                            {
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:754:7: (lv_memberName_5_0= ruleValidID )
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:755:8: lv_memberName_5_0= ruleValidID
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getXImportDeclaration_MemberNameValidIDParserRuleCall_1_0_3_1_0ElementType());
                              							
                            }
                            pushFollow(FOLLOW_ruleValidID_in_ruleXImportDeclaration2472);
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
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:767:4: ( ( ruleQualifiedName ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:767:4: ( ( ruleQualifiedName ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:768:5: ( ruleQualifiedName )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:768:5: ( ruleQualifiedName )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:769:6: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration2541);
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
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:779:4: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:779:4: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:780:5: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:780:5: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:781:6: lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXImportDeclaration_ImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_ruleXImportDeclaration2595);
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

            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:791:3: (otherlv_8= ';' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:792:4: otherlv_8= ';'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf();
                      			
                    }
                    otherlv_8=(Token)match(input,27,FOLLOW_27_in_ruleXImportDeclaration2633); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_8, elementTypeProvider.getXImportDeclaration_SemicolonKeyword_2ElementType());
                      			
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:804:1: entryRuleQualifiedNameInStaticImport : ruleQualifiedNameInStaticImport EOF ;
    public final void entryRuleQualifiedNameInStaticImport() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:804:37: ( ruleQualifiedNameInStaticImport EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:805:2: ruleQualifiedNameInStaticImport EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getQualifiedNameInStaticImportElementType()); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameInStaticImport_in_entryRuleQualifiedNameInStaticImport2659);
            ruleQualifiedNameInStaticImport();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameInStaticImport2665); if (state.failed) return ;

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:811:1: ruleQualifiedNameInStaticImport : ( ruleValidID kw= '.' )+ ;
    public final void ruleQualifiedNameInStaticImport() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:811:32: ( ( ruleValidID kw= '.' )+ )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:812:2: ( ruleValidID kw= '.' )+
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:812:2: ( ruleValidID kw= '.' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID) ) {
                    int LA20_2 = input.LA(2);

                    if ( (LA20_2==18) ) {
                        alt20=1;
                    }


                }


                switch (alt20) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:813:3: ruleValidID kw= '.'
            	    {
            	    if ( state.backtracking==0 ) {

            	      			markComposite(elementTypeProvider.getQualifiedNameInStaticImport_ValidIDParserRuleCall_0ElementType());
            	      		
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedNameInStaticImport2682);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      			doneComposite();
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			markLeaf();
            	      		
            	    }
            	    kw=(Token)match(input,18,FOLLOW_18_in_ruleQualifiedNameInStaticImport2696); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      			doneLeaf(kw, elementTypeProvider.getQualifiedNameInStaticImport_FullStopKeyword_1ElementType());
            	      		
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
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

    // $ANTLR start synpred1_PsiInternalXtype
    public final void synpred1_PsiInternalXtype_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:70:5: ( ( () ruleArrayBrackets ) )
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:70:6: ( () ruleArrayBrackets )
        {
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:70:6: ( () ruleArrayBrackets )
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:71:6: () ruleArrayBrackets
        {
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:71:6: ()
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:72:6: 
        {
        }

        pushFollow(FOLLOW_ruleArrayBrackets_in_synpred1_PsiInternalXtype121);
        ruleArrayBrackets();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_PsiInternalXtype

    // $ANTLR start synpred2_PsiInternalXtype
    public final void synpred2_PsiInternalXtype_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:234:5: ( '<' )
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:234:6: '<'
        {
        match(input,16,FOLLOW_16_in_synpred2_PsiInternalXtype645); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_PsiInternalXtype

    // $ANTLR start synpred3_PsiInternalXtype
    public final void synpred3_PsiInternalXtype_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:283:6: ( ( () '.' ) )
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:283:7: ( () '.' )
        {
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:283:7: ( () '.' )
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:284:7: () '.'
        {
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:284:7: ()
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:285:7: 
        {
        }

        match(input,18,FOLLOW_18_in_synpred3_PsiInternalXtype860); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_PsiInternalXtype

    // $ANTLR start synpred4_PsiInternalXtype
    public final void synpred4_PsiInternalXtype_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:318:7: ( '<' )
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:318:8: '<'
        {
        match(input,16,FOLLOW_16_in_synpred4_PsiInternalXtype1018); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_PsiInternalXtype

    // Delegated rules

    public final boolean synpred2_PsiInternalXtype() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_PsiInternalXtype_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_PsiInternalXtype() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_PsiInternalXtype_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_PsiInternalXtype() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_PsiInternalXtype_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_PsiInternalXtype() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_PsiInternalXtype_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA18_eotS =
        "\7\uffff";
    static final String DFA18_eofS =
        "\2\uffff\1\4\2\uffff\1\4\1\uffff";
    static final String DFA18_minS =
        "\1\4\1\uffff\1\22\1\4\1\uffff\1\22\1\uffff";
    static final String DFA18_maxS =
        "\1\31\1\uffff\1\33\1\27\1\uffff\1\33\1\uffff";
    static final String DFA18_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\1\uffff\1\3";
    static final String DFA18_specialS =
        "\7\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\2\24\uffff\1\1",
            "",
            "\1\3\10\uffff\1\4",
            "\1\5\22\uffff\1\6",
            "",
            "\1\3\10\uffff\1\4",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "705:3: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference60 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference83 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_ruleJvmTypeReference176 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets235 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayBrackets241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_ruleArrayBrackets260 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleArrayBrackets274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef294 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleXFunctionTypeRef325 = new BitSet(new long[]{0x000000000000D010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef366 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleXFunctionTypeRef409 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef451 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_ruleXFunctionTypeRef500 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleXFunctionTypeRef520 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference578 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference614 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleJvmParameterizedTypeReference661 = new BitSet(new long[]{0x0000000000089010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference699 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_13_in_ruleJvmParameterizedTypeReference736 = new BitSet(new long[]{0x0000000000089010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference773 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_17_in_ruleJvmParameterizedTypeReference812 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleJvmParameterizedTypeReference925 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmParameterizedTypeReference975 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_16_in_ruleJvmParameterizedTypeReference1038 = new BitSet(new long[]{0x0000000000089010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference1088 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_13_in_ruleJvmParameterizedTypeReference1137 = new BitSet(new long[]{0x0000000000089010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference1184 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_17_in_ruleJvmParameterizedTypeReference1235 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference1276 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference1282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference1319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference1339 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference1345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleJvmWildcardTypeReference1377 = new BitSet(new long[]{0x0000000000500002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference1421 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmWildcardTypeReference1473 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference1545 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJvmLowerBoundAnded_in_ruleJvmWildcardTypeReference1597 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound1645 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound1651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleJvmUpperBound1670 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound1697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded1728 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded1734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleJvmUpperBoundAnded1753 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded1780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound1811 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound1817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleJvmLowerBound1836 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound1863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBoundAnded_in_entryRuleJvmLowerBoundAnded1894 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBoundAnded1900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleJvmLowerBoundAnded1919 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBoundAnded1946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1977 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName1983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName2000 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleQualifiedName2020 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName2035 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard2061 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard2067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard2084 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleQualifiedNameWithWildcard2098 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleQualifiedNameWithWildcard2112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID2132 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID2138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID2152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportDeclaration_in_entryRuleXImportDeclaration2168 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXImportDeclaration2174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleXImportDeclaration2193 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_25_in_ruleXImportDeclaration2237 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_26_in_ruleXImportDeclaration2289 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_ruleQualifiedNameInStaticImport_in_ruleXImportDeclaration2340 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_23_in_ruleXImportDeclaration2402 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXImportDeclaration2472 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration2541 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_ruleXImportDeclaration2595 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleXImportDeclaration2633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameInStaticImport_in_entryRuleQualifiedNameInStaticImport2659 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameInStaticImport2665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedNameInStaticImport2682 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleQualifiedNameInStaticImport2696 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_synpred1_PsiInternalXtype121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_synpred2_PsiInternalXtype645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_synpred3_PsiInternalXtype860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_synpred4_PsiInternalXtype1018 = new BitSet(new long[]{0x0000000000000002L});

}