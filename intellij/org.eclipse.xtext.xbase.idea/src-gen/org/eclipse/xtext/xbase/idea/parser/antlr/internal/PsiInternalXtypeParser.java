package org.eclipse.xtext.xbase.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.xbase.idea.lang.XtypeElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;

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



    public XtypeElementTypeProvider elementTypeProvider;

    public PsiInternalXtypeParser(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider, XtypeElementTypeProvider elementTypeProvider) {
    	super(builder, input, tokenTypeProvider);
    	this.elementTypeProvider = elementTypeProvider;
    }

    @Override
    protected String getFirstRuleName() {
    	return "JvmTypeReference";
    }




    // $ANTLR start "entryRuleJvmTypeReference"
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:45:1: entryRuleJvmTypeReference : ruleJvmTypeReference EOF ;
    public final void entryRuleJvmTypeReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:45:26: ( ruleJvmTypeReference EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:46:2: ruleJvmTypeReference EOF
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:54:1: ruleJvmTypeReference : ( ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | ruleXFunctionTypeRef ) ;
    public final void ruleJvmTypeReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:54:21: ( ( ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | ruleXFunctionTypeRef ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:55:2: ( ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | ruleXFunctionTypeRef )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:55:2: ( ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | ruleXFunctionTypeRef )
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
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:56:3: ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:56:3: ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:57:4: ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getJvmTypeReference_JvmParameterizedTypeReferenceParserRuleCall_0_0ElementType());
                      			
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference87);
                    ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneComposite();
                      			
                    }
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:64:4: ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==10) && (synpred1_PsiInternalXtype())) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:65:5: ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:71:5: ( () ruleArrayBrackets )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:72:6: () ruleArrayBrackets
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:72:6: ()
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:73:7: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							precedeComposite(elementTypeProvider.getJvmTypeReference_JvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0ElementType());
                    	      							doneComposite();
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						markComposite(elementTypeProvider.getJvmTypeReference_ArrayBracketsParserRuleCall_0_1_0_1ElementType());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_ruleArrayBrackets_in_ruleJvmTypeReference180);
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
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:89:3: ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getJvmTypeReference_XFunctionTypeRefParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference219);
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:100:1: entryRuleArrayBrackets : ruleArrayBrackets EOF ;
    public final void entryRuleArrayBrackets() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:100:23: ( ruleArrayBrackets EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:101:2: ruleArrayBrackets EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getArrayBracketsElementType()); 
            }
            pushFollow(FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets239);
            ruleArrayBrackets();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayBrackets245); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:109:1: ruleArrayBrackets : (kw= '[' kw= ']' ) ;
    public final void ruleArrayBrackets() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:109:18: ( (kw= '[' kw= ']' ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:110:2: (kw= '[' kw= ']' )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:110:2: (kw= '[' kw= ']' )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:111:3: kw= '[' kw= ']'
            {
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            kw=(Token)match(input,10,FOLLOW_10_in_ruleArrayBrackets268); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw, elementTypeProvider.getArrayBrackets_LeftSquareBracketKeyword_0ElementType());
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            kw=(Token)match(input,11,FOLLOW_11_in_ruleArrayBrackets282); if (state.failed) return ;
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:129:1: entryRuleXFunctionTypeRef : ruleXFunctionTypeRef EOF ;
    public final void entryRuleXFunctionTypeRef() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:129:26: ( ruleXFunctionTypeRef EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:130:2: ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXFunctionTypeRefElementType()); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef302);
            ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef308); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:138:1: ruleXFunctionTypeRef : ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleXFunctionTypeRef() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:138:21: ( ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:139:2: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:139:2: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:140:3: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:140:3: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:141:4: otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf();
                      			
                    }
                    otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleXFunctionTypeRef337); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_0, elementTypeProvider.getXFunctionTypeRef_LeftParenthesisKeyword_0_0ElementType());
                      			
                    }
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:148:4: ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID||LA4_0==12||LA4_0==15) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:149:5: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            {
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:149:5: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:150:6: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            {
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:150:6: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:151:7: lv_paramTypes_1_0= ruleJvmTypeReference
                            {
                            if ( state.backtracking==0 ) {

                              							markComposite(elementTypeProvider.getXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0ElementType());
                              						
                            }
                            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef378);
                            ruleJvmTypeReference();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneComposite();
                              						
                            }

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:160:5: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==13) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:161:6: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      						markLeaf();
                            	      					
                            	    }
                            	    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleXFunctionTypeRef421); if (state.failed) return ;
                            	    if ( state.backtracking==0 ) {

                            	      						doneLeaf(otherlv_2, elementTypeProvider.getXFunctionTypeRef_CommaKeyword_0_1_1_0ElementType());
                            	      					
                            	    }
                            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:168:6: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:169:7: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    {
                            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:169:7: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:170:8: lv_paramTypes_3_0= ruleJvmTypeReference
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								markComposite(elementTypeProvider.getXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0ElementType());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef463);
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
                    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleXFunctionTypeRef512); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_4, elementTypeProvider.getXFunctionTypeRef_RightParenthesisKeyword_0_2ElementType());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleXFunctionTypeRef532); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_5, elementTypeProvider.getXFunctionTypeRef_EqualsSignGreaterThanSignKeyword_1ElementType());
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:196:3: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:197:4: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:197:4: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:198:5: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXFunctionTypeRef_ReturnTypeJvmTypeReferenceParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef559);
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:211:1: entryRuleJvmParameterizedTypeReference : ruleJvmParameterizedTypeReference EOF ;
    public final void entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:211:39: ( ruleJvmParameterizedTypeReference EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:212:2: ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmParameterizedTypeReferenceElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference590);
            ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference596); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:220:1: ruleJvmParameterizedTypeReference : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) ;
    public final void ruleJvmParameterizedTypeReference() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:220:34: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:221:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:221:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:222:3: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:222:3: ( ( ruleQualifiedName ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:223:4: ( ruleQualifiedName )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:223:4: ( ruleQualifiedName )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:224:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmParameterizedTypeReference_TypeJvmTypeCrossReference_0_0ElementType());
              				
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference630);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:233:3: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==16) && (synpred2_PsiInternalXtype())) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:234:4: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:234:4: ( ( '<' )=>otherlv_1= '<' )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:235:5: ( '<' )=>otherlv_1= '<'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf();
                      				
                    }
                    otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleJvmParameterizedTypeReference677); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1, elementTypeProvider.getJvmParameterizedTypeReference_LessThanSignKeyword_1_0ElementType());
                      				
                    }

                    }

                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:244:4: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:245:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:245:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:246:6: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference715);
                    ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:255:4: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==13) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:256:5: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf();
                    	      				
                    	    }
                    	    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleJvmParameterizedTypeReference752); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_3, elementTypeProvider.getJvmParameterizedTypeReference_CommaKeyword_1_2_0ElementType());
                    	      				
                    	    }
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:263:5: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:264:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:264:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:265:7: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference789);
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
                    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleJvmParameterizedTypeReference828); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_5, elementTypeProvider.getJvmParameterizedTypeReference_GreaterThanSignKeyword_1_3ElementType());
                      			
                    }
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:282:4: ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==18) && (synpred3_PsiInternalXtype())) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:283:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:283:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:284:6: ( ( () '.' ) )=> ( () otherlv_7= '.' )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:290:6: ( () otherlv_7= '.' )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:291:7: () otherlv_7= '.'
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:291:7: ()
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:292:8: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								precedeComposite(elementTypeProvider.getJvmParameterizedTypeReference_JvmInnerTypeReferenceOuterAction_1_4_0_0_0ElementType());
                    	      								doneComposite();
                    	      							
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      							markLeaf();
                    	      						
                    	    }
                    	    otherlv_7=(Token)match(input,18,FOLLOW_18_in_ruleJvmParameterizedTypeReference941); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneLeaf(otherlv_7, elementTypeProvider.getJvmParameterizedTypeReference_FullStopKeyword_1_4_0_0_1ElementType());
                    	      						
                    	    }

                    	    }


                    	    }

                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:306:5: ( ( ruleValidID ) )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:307:6: ( ruleValidID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:307:6: ( ruleValidID )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:308:7: ruleValidID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmParameterizedTypeReference_TypeJvmTypeCrossReference_1_4_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_ruleValidID_in_ruleJvmParameterizedTypeReference991);
                    	    ruleValidID();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      						
                    	    }

                    	    }


                    	    }

                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:317:5: ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
                    	    int alt8=2;
                    	    int LA8_0 = input.LA(1);

                    	    if ( (LA8_0==16) && (synpred4_PsiInternalXtype())) {
                    	        alt8=1;
                    	    }
                    	    switch (alt8) {
                    	        case 1 :
                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:318:6: ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>'
                    	            {
                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:318:6: ( ( '<' )=>otherlv_9= '<' )
                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:319:7: ( '<' )=>otherlv_9= '<'
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              							markLeaf();
                    	              						
                    	            }
                    	            otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleJvmParameterizedTypeReference1054); if (state.failed) return ;
                    	            if ( state.backtracking==0 ) {

                    	              							doneLeaf(otherlv_9, elementTypeProvider.getJvmParameterizedTypeReference_LessThanSignKeyword_1_4_2_0ElementType());
                    	              						
                    	            }

                    	            }

                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:328:6: ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) )
                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:329:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
                    	            {
                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:329:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:330:8: lv_arguments_10_0= ruleJvmArgumentTypeReference
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0ElementType());
                    	              							
                    	            }
                    	            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference1104);
                    	            ruleJvmArgumentTypeReference();

                    	            state._fsp--;
                    	            if (state.failed) return ;
                    	            if ( state.backtracking==0 ) {

                    	              								doneComposite();
                    	              							
                    	            }

                    	            }


                    	            }

                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:339:6: (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )*
                    	            loop7:
                    	            do {
                    	                int alt7=2;
                    	                int LA7_0 = input.LA(1);

                    	                if ( (LA7_0==13) ) {
                    	                    alt7=1;
                    	                }


                    	                switch (alt7) {
                    	            	case 1 :
                    	            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:340:7: otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
                    	            	    {
                    	            	    if ( state.backtracking==0 ) {

                    	            	      							markLeaf();
                    	            	      						
                    	            	    }
                    	            	    otherlv_11=(Token)match(input,13,FOLLOW_13_in_ruleJvmParameterizedTypeReference1153); if (state.failed) return ;
                    	            	    if ( state.backtracking==0 ) {

                    	            	      							doneLeaf(otherlv_11, elementTypeProvider.getJvmParameterizedTypeReference_CommaKeyword_1_4_2_2_0ElementType());
                    	            	      						
                    	            	    }
                    	            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:347:7: ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
                    	            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:348:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
                    	            	    {
                    	            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:348:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
                    	            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:349:9: lv_arguments_12_0= ruleJvmArgumentTypeReference
                    	            	    {
                    	            	    if ( state.backtracking==0 ) {

                    	            	      									markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0ElementType());
                    	            	      								
                    	            	    }
                    	            	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference1200);
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
                    	            otherlv_13=(Token)match(input,17,FOLLOW_17_in_ruleJvmParameterizedTypeReference1251); if (state.failed) return ;
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:373:1: entryRuleJvmArgumentTypeReference : ruleJvmArgumentTypeReference EOF ;
    public final void entryRuleJvmArgumentTypeReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:373:34: ( ruleJvmArgumentTypeReference EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:374:2: ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmArgumentTypeReferenceElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference1292);
            ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference1298); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:382:1: ruleJvmArgumentTypeReference : ( ruleJvmTypeReference | ruleJvmWildcardTypeReference ) ;
    public final void ruleJvmArgumentTypeReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:382:29: ( ( ruleJvmTypeReference | ruleJvmWildcardTypeReference ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:383:2: ( ruleJvmTypeReference | ruleJvmWildcardTypeReference )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:383:2: ( ruleJvmTypeReference | ruleJvmWildcardTypeReference )
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
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:384:3: ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getJvmArgumentTypeReference_JvmTypeReferenceParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference1319);
                    ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:392:3: ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getJvmArgumentTypeReference_JvmWildcardTypeReferenceParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference1339);
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:403:1: entryRuleJvmWildcardTypeReference : ruleJvmWildcardTypeReference EOF ;
    public final void entryRuleJvmWildcardTypeReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:403:34: ( ruleJvmWildcardTypeReference EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:404:2: ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmWildcardTypeReferenceElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference1359);
            ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference1365); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:412:1: ruleJvmWildcardTypeReference : ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) ;
    public final void ruleJvmWildcardTypeReference() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:412:29: ( ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:413:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:413:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:414:3: () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:414:3: ()
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:415:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getJvmWildcardTypeReference_JvmWildcardTypeReferenceAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleJvmWildcardTypeReference1401); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1, elementTypeProvider.getJvmWildcardTypeReference_QuestionMarkKeyword_1ElementType());
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:427:3: ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
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
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:428:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:428:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:429:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:429:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:430:6: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:430:6: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:431:7: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmUpperBoundParserRuleCall_2_0_0_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference1445);
                    ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:440:5: ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==21) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:441:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:441:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:442:7: lv_constraints_3_0= ruleJvmUpperBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmWildcardTypeReference1497);
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
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:453:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:453:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:454:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:454:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:455:6: (lv_constraints_4_0= ruleJvmLowerBound )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:455:6: (lv_constraints_4_0= ruleJvmLowerBound )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:456:7: lv_constraints_4_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmLowerBoundParserRuleCall_2_1_0_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference1569);
                    ruleJvmLowerBound();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:465:5: ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==21) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:466:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:466:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:467:7: lv_constraints_5_0= ruleJvmLowerBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmLowerBoundAnded_in_ruleJvmWildcardTypeReference1621);
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:482:1: entryRuleJvmUpperBound : ruleJvmUpperBound EOF ;
    public final void entryRuleJvmUpperBound() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:482:23: ( ruleJvmUpperBound EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:483:2: ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmUpperBoundElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound1669);
            ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound1675); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:491:1: ruleJvmUpperBound : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleJvmUpperBound() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:491:18: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:492:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:492:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:493:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleJvmUpperBound1698); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0, elementTypeProvider.getJvmUpperBound_ExtendsKeyword_0ElementType());
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:500:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:501:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:501:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:502:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmUpperBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound1725);
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:515:1: entryRuleJvmUpperBoundAnded : ruleJvmUpperBoundAnded EOF ;
    public final void entryRuleJvmUpperBoundAnded() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:515:28: ( ruleJvmUpperBoundAnded EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:516:2: ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmUpperBoundAndedElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded1756);
            ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded1762); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:524:1: ruleJvmUpperBoundAnded : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleJvmUpperBoundAnded() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:524:23: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:525:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:525:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:526:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleJvmUpperBoundAnded1785); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0, elementTypeProvider.getJvmUpperBoundAnded_AmpersandKeyword_0ElementType());
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:533:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:534:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:534:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:535:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmUpperBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded1812);
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:548:1: entryRuleJvmLowerBound : ruleJvmLowerBound EOF ;
    public final void entryRuleJvmLowerBound() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:548:23: ( ruleJvmLowerBound EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:549:2: ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmLowerBoundElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound1843);
            ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound1849); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:557:1: ruleJvmLowerBound : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleJvmLowerBound() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:557:18: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:558:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:558:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:559:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleJvmLowerBound1872); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0, elementTypeProvider.getJvmLowerBound_SuperKeyword_0ElementType());
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:566:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:567:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:567:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:568:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmLowerBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound1899);
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:581:1: entryRuleJvmLowerBoundAnded : ruleJvmLowerBoundAnded EOF ;
    public final void entryRuleJvmLowerBoundAnded() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:581:28: ( ruleJvmLowerBoundAnded EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:582:2: ruleJvmLowerBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmLowerBoundAndedElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBoundAnded_in_entryRuleJvmLowerBoundAnded1930);
            ruleJvmLowerBoundAnded();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBoundAnded1936); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:590:1: ruleJvmLowerBoundAnded : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleJvmLowerBoundAnded() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:590:23: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:591:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:591:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:592:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleJvmLowerBoundAnded1959); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0, elementTypeProvider.getJvmLowerBoundAnded_AmpersandKeyword_0ElementType());
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:599:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:600:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:600:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:601:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmLowerBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBoundAnded1986);
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


    // $ANTLR start "entryRuleJvmTypeParameter"
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:614:1: entryRuleJvmTypeParameter : ruleJvmTypeParameter EOF ;
    public final void entryRuleJvmTypeParameter() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:614:26: ( ruleJvmTypeParameter EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:615:2: ruleJvmTypeParameter EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmTypeParameterElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeParameter_in_entryRuleJvmTypeParameter2017);
            ruleJvmTypeParameter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeParameter2023); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleJvmTypeParameter"


    // $ANTLR start "ruleJvmTypeParameter"
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:623:1: ruleJvmTypeParameter : ( ( (lv_name_0_0= ruleValidID ) ) ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )? ) ;
    public final void ruleJvmTypeParameter() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:623:21: ( ( ( (lv_name_0_0= ruleValidID ) ) ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )? ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:624:2: ( ( (lv_name_0_0= ruleValidID ) ) ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )? )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:624:2: ( ( (lv_name_0_0= ruleValidID ) ) ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )? )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:625:3: ( (lv_name_0_0= ruleValidID ) ) ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )?
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:625:3: ( (lv_name_0_0= ruleValidID ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:626:4: (lv_name_0_0= ruleValidID )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:626:4: (lv_name_0_0= ruleValidID )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:627:5: lv_name_0_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleJvmTypeParameter2059);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:636:3: ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==20) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:637:4: ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:637:4: ( (lv_constraints_1_0= ruleJvmUpperBound ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:638:5: (lv_constraints_1_0= ruleJvmUpperBound )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:638:5: (lv_constraints_1_0= ruleJvmUpperBound )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:639:6: lv_constraints_1_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getJvmTypeParameter_ConstraintsJvmUpperBoundParserRuleCall_1_0_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmTypeParameter2105);
                    ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:648:4: ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==21) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:649:5: (lv_constraints_2_0= ruleJvmUpperBoundAnded )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:649:5: (lv_constraints_2_0= ruleJvmUpperBoundAnded )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:650:6: lv_constraints_2_0= ruleJvmUpperBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						markComposite(elementTypeProvider.getJvmTypeParameter_ConstraintsJvmUpperBoundAndedParserRuleCall_1_1_0ElementType());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmTypeParameter2150);
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
                    	    break loop15;
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
    // $ANTLR end "ruleJvmTypeParameter"


    // $ANTLR start "entryRuleQualifiedName"
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:664:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:664:23: ( ruleQualifiedName EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:665:2: ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getQualifiedNameElementType()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2190);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName2196); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:673:1: ruleQualifiedName : ( ruleValidID (kw= '.' ruleValidID )* ) ;
    public final void ruleQualifiedName() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:673:18: ( ( ruleValidID (kw= '.' ruleValidID )* ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:674:2: ( ruleValidID (kw= '.' ruleValidID )* )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:674:2: ( ruleValidID (kw= '.' ruleValidID )* )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:675:3: ruleValidID (kw= '.' ruleValidID )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getQualifiedName_ValidIDParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName2217);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:682:3: (kw= '.' ruleValidID )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==18) ) {
                    int LA17_2 = input.LA(2);

                    if ( (LA17_2==RULE_ID) ) {
                        alt17=1;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:683:4: kw= '.' ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markLeaf();
            	      			
            	    }
            	    kw=(Token)match(input,18,FOLLOW_18_in_ruleQualifiedName2237); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(kw, elementTypeProvider.getQualifiedName_FullStopKeyword_1_0ElementType());
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				markComposite(elementTypeProvider.getQualifiedName_ValidIDParserRuleCall_1_1ElementType());
            	      			
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName2252);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneComposite();
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop17;
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:702:1: entryRuleQualifiedNameWithWildcard : ruleQualifiedNameWithWildcard EOF ;
    public final void entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:702:35: ( ruleQualifiedNameWithWildcard EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:703:2: ruleQualifiedNameWithWildcard EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getQualifiedNameWithWildcardElementType()); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard2278);
            ruleQualifiedNameWithWildcard();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard2284); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:711:1: ruleQualifiedNameWithWildcard : ( ruleQualifiedName kw= '.' kw= '*' ) ;
    public final void ruleQualifiedNameWithWildcard() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:711:30: ( ( ruleQualifiedName kw= '.' kw= '*' ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:712:2: ( ruleQualifiedName kw= '.' kw= '*' )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:712:2: ( ruleQualifiedName kw= '.' kw= '*' )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:713:3: ruleQualifiedName kw= '.' kw= '*'
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getQualifiedNameWithWildcard_QualifiedNameParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard2305);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            kw=(Token)match(input,18,FOLLOW_18_in_ruleQualifiedNameWithWildcard2319); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw, elementTypeProvider.getQualifiedNameWithWildcard_FullStopKeyword_1ElementType());
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            kw=(Token)match(input,23,FOLLOW_23_in_ruleQualifiedNameWithWildcard2333); if (state.failed) return ;
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:738:1: entryRuleValidID : ruleValidID EOF ;
    public final void entryRuleValidID() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:738:17: ( ruleValidID EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:739:2: ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getValidIDElementType()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID2353);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID2359); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:747:1: ruleValidID : this_ID_0= RULE_ID ;
    public final void ruleValidID() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:747:12: (this_ID_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:748:2: this_ID_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              		markLeaf();
              	
            }
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID2377); if (state.failed) return ;
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


    // $ANTLR start "entryRuleXImportSection"
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:758:1: entryRuleXImportSection : ruleXImportSection EOF ;
    public final void entryRuleXImportSection() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:758:24: ( ruleXImportSection EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:759:2: ruleXImportSection EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXImportSectionElementType()); 
            }
            pushFollow(FOLLOW_ruleXImportSection_in_entryRuleXImportSection2393);
            ruleXImportSection();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXImportSection2399); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:767:1: ruleXImportSection : ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+ ;
    public final void ruleXImportSection() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:767:19: ( ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+ )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:768:2: ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:768:2: ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==24) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:769:3: (lv_importDeclarations_0_0= ruleXImportDeclaration )
            	    {
            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:769:3: (lv_importDeclarations_0_0= ruleXImportDeclaration )
            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:770:4: lv_importDeclarations_0_0= ruleXImportDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markComposite(elementTypeProvider.getXImportSection_ImportDeclarationsXImportDeclarationParserRuleCall_0ElementType());
            	      			
            	    }
            	    pushFollow(FOLLOW_ruleXImportDeclaration_in_ruleXImportSection2428);
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
            	    if ( cnt18 >= 1 ) break loop18;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:782:1: entryRuleXImportDeclaration : ruleXImportDeclaration EOF ;
    public final void entryRuleXImportDeclaration() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:782:28: ( ruleXImportDeclaration EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:783:2: ruleXImportDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXImportDeclarationElementType()); 
            }
            pushFollow(FOLLOW_ruleXImportDeclaration_in_entryRuleXImportDeclaration2454);
            ruleXImportDeclaration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXImportDeclaration2460); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:791:1: ruleXImportDeclaration : (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) ;
    public final void ruleXImportDeclaration() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_static_1_0=null;
        Token lv_extension_2_0=null;
        Token lv_wildcard_4_0=null;
        Token otherlv_8=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:791:23: ( (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:792:2: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:792:2: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:793:3: otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )?
            {
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleXImportDeclaration2483); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0, elementTypeProvider.getXImportDeclaration_ImportKeyword_0ElementType());
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:800:3: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )
            int alt21=3;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:801:4: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:801:4: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:802:5: ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:802:5: ( (lv_static_1_0= 'static' ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:803:6: (lv_static_1_0= 'static' )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:803:6: (lv_static_1_0= 'static' )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:804:7: lv_static_1_0= 'static'
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf();
                      						
                    }
                    lv_static_1_0=(Token)match(input,25,FOLLOW_25_in_ruleXImportDeclaration2527); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(lv_static_1_0, elementTypeProvider.getXImportDeclaration_StaticStaticKeyword_1_0_0_0ElementType());
                      						
                    }

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:813:5: ( (lv_extension_2_0= 'extension' ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==26) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:814:6: (lv_extension_2_0= 'extension' )
                            {
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:814:6: (lv_extension_2_0= 'extension' )
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:815:7: lv_extension_2_0= 'extension'
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf();
                              						
                            }
                            lv_extension_2_0=(Token)match(input,26,FOLLOW_26_in_ruleXImportDeclaration2579); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(lv_extension_2_0, elementTypeProvider.getXImportDeclaration_ExtensionExtensionKeyword_1_0_1_0ElementType());
                              						
                            }

                            }


                            }
                            break;

                    }

                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:824:5: ( ( ruleQualifiedNameInStaticImport ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:825:6: ( ruleQualifiedNameInStaticImport )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:825:6: ( ruleQualifiedNameInStaticImport )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:826:7: ruleQualifiedNameInStaticImport
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_ruleQualifiedNameInStaticImport_in_ruleXImportDeclaration2630);
                    ruleQualifiedNameInStaticImport();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:835:5: ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==23) ) {
                        alt20=1;
                    }
                    else if ( (LA20_0==RULE_ID) ) {
                        alt20=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 0, input);

                        throw nvae;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:836:6: ( (lv_wildcard_4_0= '*' ) )
                            {
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:836:6: ( (lv_wildcard_4_0= '*' ) )
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:837:7: (lv_wildcard_4_0= '*' )
                            {
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:837:7: (lv_wildcard_4_0= '*' )
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:838:8: lv_wildcard_4_0= '*'
                            {
                            if ( state.backtracking==0 ) {

                              								markLeaf();
                              							
                            }
                            lv_wildcard_4_0=(Token)match(input,23,FOLLOW_23_in_ruleXImportDeclaration2692); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              								doneLeaf(lv_wildcard_4_0, elementTypeProvider.getXImportDeclaration_WildcardAsteriskKeyword_1_0_3_0_0ElementType());
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:848:6: ( (lv_memberName_5_0= ruleValidID ) )
                            {
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:848:6: ( (lv_memberName_5_0= ruleValidID ) )
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:849:7: (lv_memberName_5_0= ruleValidID )
                            {
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:849:7: (lv_memberName_5_0= ruleValidID )
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:850:8: lv_memberName_5_0= ruleValidID
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getXImportDeclaration_MemberNameValidIDParserRuleCall_1_0_3_1_0ElementType());
                              							
                            }
                            pushFollow(FOLLOW_ruleValidID_in_ruleXImportDeclaration2762);
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
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:862:4: ( ( ruleQualifiedName ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:862:4: ( ( ruleQualifiedName ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:863:5: ( ruleQualifiedName )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:863:5: ( ruleQualifiedName )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:864:6: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration2831);
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
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:874:4: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:874:4: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:875:5: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:875:5: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:876:6: lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXImportDeclaration_ImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_ruleXImportDeclaration2885);
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

            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:886:3: (otherlv_8= ';' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==27) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:887:4: otherlv_8= ';'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf();
                      			
                    }
                    otherlv_8=(Token)match(input,27,FOLLOW_27_in_ruleXImportDeclaration2923); if (state.failed) return ;
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:899:1: entryRuleQualifiedNameInStaticImport : ruleQualifiedNameInStaticImport EOF ;
    public final void entryRuleQualifiedNameInStaticImport() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:899:37: ( ruleQualifiedNameInStaticImport EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:900:2: ruleQualifiedNameInStaticImport EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getQualifiedNameInStaticImportElementType()); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameInStaticImport_in_entryRuleQualifiedNameInStaticImport2949);
            ruleQualifiedNameInStaticImport();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameInStaticImport2955); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:908:1: ruleQualifiedNameInStaticImport : ( ruleValidID kw= '.' )+ ;
    public final void ruleQualifiedNameInStaticImport() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:908:32: ( ( ruleValidID kw= '.' )+ )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:909:2: ( ruleValidID kw= '.' )+
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:909:2: ( ruleValidID kw= '.' )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_ID) ) {
                    int LA23_2 = input.LA(2);

                    if ( (LA23_2==18) ) {
                        alt23=1;
                    }


                }


                switch (alt23) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:910:3: ruleValidID kw= '.'
            	    {
            	    if ( state.backtracking==0 ) {

            	      			markComposite(elementTypeProvider.getQualifiedNameInStaticImport_ValidIDParserRuleCall_0ElementType());
            	      		
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedNameInStaticImport2976);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      			doneComposite();
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			markLeaf();
            	      		
            	    }
            	    kw=(Token)match(input,18,FOLLOW_18_in_ruleQualifiedNameInStaticImport2990); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      			doneLeaf(kw, elementTypeProvider.getQualifiedNameInStaticImport_FullStopKeyword_1ElementType());
            	      		
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
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
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:65:5: ( ( () ruleArrayBrackets ) )
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:65:6: ( () ruleArrayBrackets )
        {
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:65:6: ( () ruleArrayBrackets )
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:66:6: () ruleArrayBrackets
        {
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:66:6: ()
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:67:6: 
        {
        }

        pushFollow(FOLLOW_ruleArrayBrackets_in_synpred1_PsiInternalXtype125);
        ruleArrayBrackets();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_PsiInternalXtype

    // $ANTLR start synpred2_PsiInternalXtype
    public final void synpred2_PsiInternalXtype_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:235:5: ( '<' )
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:235:6: '<'
        {
        match(input,16,FOLLOW_16_in_synpred2_PsiInternalXtype661); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_PsiInternalXtype

    // $ANTLR start synpred3_PsiInternalXtype
    public final void synpred3_PsiInternalXtype_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:284:6: ( ( () '.' ) )
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:284:7: ( () '.' )
        {
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:284:7: ( () '.' )
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:285:7: () '.'
        {
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:285:7: ()
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:286:7: 
        {
        }

        match(input,18,FOLLOW_18_in_synpred3_PsiInternalXtype876); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_PsiInternalXtype

    // $ANTLR start synpred4_PsiInternalXtype
    public final void synpred4_PsiInternalXtype_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:319:7: ( '<' )
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:319:8: '<'
        {
        match(input,16,FOLLOW_16_in_synpred4_PsiInternalXtype1034); if (state.failed) return ;

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


    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA21_eotS =
        "\7\uffff";
    static final String DFA21_eofS =
        "\2\uffff\1\4\3\uffff\1\4";
    static final String DFA21_minS =
        "\1\4\1\uffff\1\22\1\4\2\uffff\1\22";
    static final String DFA21_maxS =
        "\1\31\1\uffff\1\33\1\27\2\uffff\1\33";
    static final String DFA21_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\1\3\1\uffff";
    static final String DFA21_specialS =
        "\7\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\2\24\uffff\1\1",
            "",
            "\1\3\5\uffff\1\4\2\uffff\1\4",
            "\1\6\22\uffff\1\5",
            "",
            "",
            "\1\3\5\uffff\1\4\2\uffff\1\4"
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "800:3: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference60 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference87 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_ruleJvmTypeReference180 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets239 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayBrackets245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_ruleArrayBrackets268 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleArrayBrackets282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleXFunctionTypeRef337 = new BitSet(new long[]{0x000000000000D010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef378 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleXFunctionTypeRef421 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef463 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_ruleXFunctionTypeRef512 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleXFunctionTypeRef532 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference590 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference630 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleJvmParameterizedTypeReference677 = new BitSet(new long[]{0x0000000000089010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference715 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_13_in_ruleJvmParameterizedTypeReference752 = new BitSet(new long[]{0x0000000000089010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference789 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_17_in_ruleJvmParameterizedTypeReference828 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleJvmParameterizedTypeReference941 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmParameterizedTypeReference991 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_16_in_ruleJvmParameterizedTypeReference1054 = new BitSet(new long[]{0x0000000000089010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference1104 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_13_in_ruleJvmParameterizedTypeReference1153 = new BitSet(new long[]{0x0000000000089010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference1200 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_17_in_ruleJvmParameterizedTypeReference1251 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference1292 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference1298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference1319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference1339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference1359 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference1365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleJvmWildcardTypeReference1401 = new BitSet(new long[]{0x0000000000500002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference1445 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmWildcardTypeReference1497 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference1569 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJvmLowerBoundAnded_in_ruleJvmWildcardTypeReference1621 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound1669 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound1675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleJvmUpperBound1698 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound1725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded1756 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded1762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleJvmUpperBoundAnded1785 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded1812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound1843 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound1849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleJvmLowerBound1872 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound1899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBoundAnded_in_entryRuleJvmLowerBoundAnded1930 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBoundAnded1936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleJvmLowerBoundAnded1959 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBoundAnded1986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_entryRuleJvmTypeParameter2017 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeParameter2023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmTypeParameter2059 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmTypeParameter2105 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmTypeParameter2150 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName2196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName2217 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleQualifiedName2237 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName2252 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard2278 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard2284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard2305 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleQualifiedNameWithWildcard2319 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleQualifiedNameWithWildcard2333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID2353 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID2359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID2377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportSection_in_entryRuleXImportSection2393 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXImportSection2399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportDeclaration_in_ruleXImportSection2428 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleXImportDeclaration_in_entryRuleXImportDeclaration2454 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXImportDeclaration2460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleXImportDeclaration2483 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_25_in_ruleXImportDeclaration2527 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_26_in_ruleXImportDeclaration2579 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_ruleQualifiedNameInStaticImport_in_ruleXImportDeclaration2630 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_23_in_ruleXImportDeclaration2692 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXImportDeclaration2762 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration2831 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_ruleXImportDeclaration2885 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleXImportDeclaration2923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameInStaticImport_in_entryRuleQualifiedNameInStaticImport2949 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameInStaticImport2955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedNameInStaticImport2976 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleQualifiedNameInStaticImport2990 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_synpred1_PsiInternalXtype125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_synpred2_PsiInternalXtype661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_synpred3_PsiInternalXtype876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_synpred4_PsiInternalXtype1034 = new BitSet(new long[]{0x0000000000000002L});

}