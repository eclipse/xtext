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
    public String getGrammarFileName() { return "../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g"; }


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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:44:1: entryRuleJvmTypeReference : ruleJvmTypeReference EOF ;
    public final void entryRuleJvmTypeReference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:44:26: ( ruleJvmTypeReference EOF )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:45:2: ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference54);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(elementTypeProvider.getJvmTypeReferenceElementType()); 
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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:53:1: ruleJvmTypeReference : ( ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | ruleXFunctionTypeRef ) ;
    public final void ruleJvmTypeReference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:53:21: ( ( ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | ruleXFunctionTypeRef ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:54:2: ( ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | ruleXFunctionTypeRef )
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:54:2: ( ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | ruleXFunctionTypeRef )
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
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:55:3: ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    {
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:55:3: ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:56:4: ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite();
                      			
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference87);
                    ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneComposite(elementTypeProvider.getJvmTypeReference_JvmParameterizedTypeReferenceParserRuleCall_0_0ElementType());
                      			
                    }
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:63:4: ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==10) && (synpred1_PsiInternalXtype())) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:64:5: ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets )
                    	    {
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:70:5: ( () ruleArrayBrackets )
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:71:6: () ruleArrayBrackets
                    	    {
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:71:6: ()
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:72:6: 
                    	    {
                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						markComposite();
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_ruleArrayBrackets_in_ruleJvmTypeReference172);
                    	    ruleArrayBrackets();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      						doneComposite(elementTypeProvider.getJvmTypeReference_ArrayBracketsParserRuleCall_0_1_0_1ElementType());
                    	      					
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
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:84:3: ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite();
                      		
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference211);
                    ruleXFunctionTypeRef();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite(elementTypeProvider.getJvmTypeReference_XFunctionTypeRefParserRuleCall_1ElementType());
                      		
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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:95:1: entryRuleArrayBrackets : ruleArrayBrackets EOF ;
    public final void entryRuleArrayBrackets() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:95:23: ( ruleArrayBrackets EOF )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:96:2: ruleArrayBrackets EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(); 
            }
            pushFollow(FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets231);
            ruleArrayBrackets();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(elementTypeProvider.getArrayBracketsElementType()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayBrackets237); if (state.failed) return ;

            }

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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:104:1: ruleArrayBrackets : (kw= '[' kw= ']' ) ;
    public final void ruleArrayBrackets() throws RecognitionException {
        Token kw=null;

        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:104:18: ( (kw= '[' kw= ']' ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:105:2: (kw= '[' kw= ']' )
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:105:2: (kw= '[' kw= ']' )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:106:3: kw= '[' kw= ']'
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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:124:1: entryRuleXFunctionTypeRef : ruleXFunctionTypeRef EOF ;
    public final void entryRuleXFunctionTypeRef() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:124:26: ( ruleXFunctionTypeRef EOF )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:125:2: ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef294);
            ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(elementTypeProvider.getXFunctionTypeRefElementType()); 
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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:133:1: ruleXFunctionTypeRef : ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleXFunctionTypeRef() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:133:21: ( ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:134:2: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:134:2: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:135:3: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:135:3: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:136:4: otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf();
                      			
                    }
                    otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleXFunctionTypeRef329); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_0, elementTypeProvider.getXFunctionTypeRef_LeftParenthesisKeyword_0_0ElementType());
                      			
                    }
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:143:4: ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID||LA4_0==12||LA4_0==15) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:144:5: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            {
                            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:144:5: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:145:6: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            {
                            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:145:6: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:146:7: lv_paramTypes_1_0= ruleJvmTypeReference
                            {
                            if ( state.backtracking==0 ) {

                              							markComposite();
                              						
                            }
                            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef370);
                            ruleJvmTypeReference();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneComposite(elementTypeProvider.getXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0ElementType());
                              						
                            }

                            }


                            }

                            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:155:5: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==13) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:156:6: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      						markLeaf();
                            	      					
                            	    }
                            	    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleXFunctionTypeRef413); if (state.failed) return ;
                            	    if ( state.backtracking==0 ) {

                            	      						doneLeaf(otherlv_2, elementTypeProvider.getXFunctionTypeRef_CommaKeyword_0_1_1_0ElementType());
                            	      					
                            	    }
                            	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:163:6: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:164:7: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    {
                            	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:164:7: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:165:8: lv_paramTypes_3_0= ruleJvmTypeReference
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								markComposite();
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef455);
                            	    ruleJvmTypeReference();

                            	    state._fsp--;
                            	    if (state.failed) return ;
                            	    if ( state.backtracking==0 ) {

                            	      								doneComposite(elementTypeProvider.getXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0ElementType());
                            	      							
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
                    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleXFunctionTypeRef504); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_4, elementTypeProvider.getXFunctionTypeRef_RightParenthesisKeyword_0_2ElementType());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleXFunctionTypeRef524); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_5, elementTypeProvider.getXFunctionTypeRef_EqualsSignGreaterThanSignKeyword_1ElementType());
              		
            }
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:191:3: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:192:4: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:192:4: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:193:5: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite();
              				
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef551);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite(elementTypeProvider.getXFunctionTypeRef_ReturnTypeJvmTypeReferenceParserRuleCall_2_0ElementType());
              				
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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:206:1: entryRuleJvmParameterizedTypeReference : ruleJvmParameterizedTypeReference EOF ;
    public final void entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:206:39: ( ruleJvmParameterizedTypeReference EOF )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:207:2: ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference582);
            ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(elementTypeProvider.getJvmParameterizedTypeReferenceElementType()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference588); if (state.failed) return ;

            }

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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:215:1: ruleJvmParameterizedTypeReference : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) ;
    public final void ruleJvmParameterizedTypeReference() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;

        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:215:34: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:216:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:216:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:217:3: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:217:3: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:218:4: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:218:4: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:219:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					markComposite();
              				
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference622);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite(elementTypeProvider.getJvmParameterizedTypeReference_TypeJvmTypeCrossReference_0_0ElementType());
              				
            }

            }


            }

            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:228:3: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==16) && (synpred2_PsiInternalXtype())) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:229:4: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
                    {
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:229:4: ( ( '<' )=>otherlv_1= '<' )
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:230:5: ( '<' )=>otherlv_1= '<'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf();
                      				
                    }
                    otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleJvmParameterizedTypeReference669); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1, elementTypeProvider.getJvmParameterizedTypeReference_LessThanSignKeyword_1_0ElementType());
                      				
                    }

                    }

                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:239:4: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:240:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:240:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:241:6: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite();
                      					
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference707);
                    ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType());
                      					
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:250:4: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==13) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:251:5: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf();
                    	      				
                    	    }
                    	    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleJvmParameterizedTypeReference744); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_3, elementTypeProvider.getJvmParameterizedTypeReference_CommaKeyword_1_2_0ElementType());
                    	      				
                    	    }
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:258:5: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:259:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:259:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:260:7: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite();
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference781);
                    	    ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType());
                    	      						
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
                    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleJvmParameterizedTypeReference820); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_5, elementTypeProvider.getJvmParameterizedTypeReference_GreaterThanSignKeyword_1_3ElementType());
                      			
                    }
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:277:4: ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==18) && (synpred3_PsiInternalXtype())) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:278:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
                    	    {
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:278:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) )
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:279:6: ( ( () '.' ) )=> ( () otherlv_7= '.' )
                    	    {
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:285:6: ( () otherlv_7= '.' )
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:286:7: () otherlv_7= '.'
                    	    {
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:286:7: ()
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:287:7: 
                    	    {
                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      							markLeaf();
                    	      						
                    	    }
                    	    otherlv_7=(Token)match(input,18,FOLLOW_18_in_ruleJvmParameterizedTypeReference924); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneLeaf(otherlv_7, elementTypeProvider.getJvmParameterizedTypeReference_FullStopKeyword_1_4_0_0_1ElementType());
                    	      						
                    	    }

                    	    }


                    	    }

                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:297:5: ( ( ruleValidID ) )
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:298:6: ( ruleValidID )
                    	    {
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:298:6: ( ruleValidID )
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:299:7: ruleValidID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite();
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_ruleValidID_in_ruleJvmParameterizedTypeReference974);
                    	    ruleValidID();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite(elementTypeProvider.getJvmParameterizedTypeReference_TypeJvmTypeCrossReference_1_4_1_0ElementType());
                    	      						
                    	    }

                    	    }


                    	    }

                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:308:5: ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
                    	    int alt8=2;
                    	    int LA8_0 = input.LA(1);

                    	    if ( (LA8_0==16) && (synpred4_PsiInternalXtype())) {
                    	        alt8=1;
                    	    }
                    	    switch (alt8) {
                    	        case 1 :
                    	            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:309:6: ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>'
                    	            {
                    	            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:309:6: ( ( '<' )=>otherlv_9= '<' )
                    	            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:310:7: ( '<' )=>otherlv_9= '<'
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              							markLeaf();
                    	              						
                    	            }
                    	            otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleJvmParameterizedTypeReference1037); if (state.failed) return ;
                    	            if ( state.backtracking==0 ) {

                    	              							doneLeaf(otherlv_9, elementTypeProvider.getJvmParameterizedTypeReference_LessThanSignKeyword_1_4_2_0ElementType());
                    	              						
                    	            }

                    	            }

                    	            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:319:6: ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) )
                    	            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:320:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
                    	            {
                    	            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:320:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
                    	            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:321:8: lv_arguments_10_0= ruleJvmArgumentTypeReference
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								markComposite();
                    	              							
                    	            }
                    	            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference1087);
                    	            ruleJvmArgumentTypeReference();

                    	            state._fsp--;
                    	            if (state.failed) return ;
                    	            if ( state.backtracking==0 ) {

                    	              								doneComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0ElementType());
                    	              							
                    	            }

                    	            }


                    	            }

                    	            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:330:6: (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )*
                    	            loop7:
                    	            do {
                    	                int alt7=2;
                    	                int LA7_0 = input.LA(1);

                    	                if ( (LA7_0==13) ) {
                    	                    alt7=1;
                    	                }


                    	                switch (alt7) {
                    	            	case 1 :
                    	            	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:331:7: otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
                    	            	    {
                    	            	    if ( state.backtracking==0 ) {

                    	            	      							markLeaf();
                    	            	      						
                    	            	    }
                    	            	    otherlv_11=(Token)match(input,13,FOLLOW_13_in_ruleJvmParameterizedTypeReference1136); if (state.failed) return ;
                    	            	    if ( state.backtracking==0 ) {

                    	            	      							doneLeaf(otherlv_11, elementTypeProvider.getJvmParameterizedTypeReference_CommaKeyword_1_4_2_2_0ElementType());
                    	            	      						
                    	            	    }
                    	            	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:338:7: ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
                    	            	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:339:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
                    	            	    {
                    	            	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:339:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
                    	            	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:340:9: lv_arguments_12_0= ruleJvmArgumentTypeReference
                    	            	    {
                    	            	    if ( state.backtracking==0 ) {

                    	            	      									markComposite();
                    	            	      								
                    	            	    }
                    	            	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference1183);
                    	            	    ruleJvmArgumentTypeReference();

                    	            	    state._fsp--;
                    	            	    if (state.failed) return ;
                    	            	    if ( state.backtracking==0 ) {

                    	            	      									doneComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0ElementType());
                    	            	      								
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
                    	            otherlv_13=(Token)match(input,17,FOLLOW_17_in_ruleJvmParameterizedTypeReference1234); if (state.failed) return ;
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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:364:1: entryRuleJvmArgumentTypeReference : ruleJvmArgumentTypeReference EOF ;
    public final void entryRuleJvmArgumentTypeReference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:364:34: ( ruleJvmArgumentTypeReference EOF )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:365:2: ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference1275);
            ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(elementTypeProvider.getJvmArgumentTypeReferenceElementType()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference1281); if (state.failed) return ;

            }

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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:373:1: ruleJvmArgumentTypeReference : ( ruleJvmTypeReference | ruleJvmWildcardTypeReference ) ;
    public final void ruleJvmArgumentTypeReference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:373:29: ( ( ruleJvmTypeReference | ruleJvmWildcardTypeReference ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:374:2: ( ruleJvmTypeReference | ruleJvmWildcardTypeReference )
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:374:2: ( ruleJvmTypeReference | ruleJvmWildcardTypeReference )
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
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:375:3: ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite();
                      		
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference1302);
                    ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite(elementTypeProvider.getJvmArgumentTypeReference_JvmTypeReferenceParserRuleCall_0ElementType());
                      		
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:383:3: ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite();
                      		
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference1322);
                    ruleJvmWildcardTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite(elementTypeProvider.getJvmArgumentTypeReference_JvmWildcardTypeReferenceParserRuleCall_1ElementType());
                      		
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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:394:1: entryRuleJvmWildcardTypeReference : ruleJvmWildcardTypeReference EOF ;
    public final void entryRuleJvmWildcardTypeReference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:394:34: ( ruleJvmWildcardTypeReference EOF )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:395:2: ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference1342);
            ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(elementTypeProvider.getJvmWildcardTypeReferenceElementType()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference1348); if (state.failed) return ;

            }

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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:403:1: ruleJvmWildcardTypeReference : ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) ;
    public final void ruleJvmWildcardTypeReference() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:403:29: ( ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:404:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:404:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:405:3: () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:405:3: ()
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:406:3: 
            {
            }

            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleJvmWildcardTypeReference1379); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1, elementTypeProvider.getJvmWildcardTypeReference_QuestionMarkKeyword_1ElementType());
              		
            }
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:414:3: ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
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
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:415:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
                    {
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:415:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:416:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
                    {
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:416:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:417:6: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:417:6: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:418:7: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite();
                      						
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference1423);
                    ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmUpperBoundParserRuleCall_2_0_0_0ElementType());
                      						
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:427:5: ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==21) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:428:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
                    	    {
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:428:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:429:7: lv_constraints_3_0= ruleJvmUpperBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite();
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmWildcardTypeReference1475);
                    	    ruleJvmUpperBoundAnded();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0ElementType());
                    	      						
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
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:440:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
                    {
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:440:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:441:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
                    {
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:441:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:442:6: (lv_constraints_4_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:442:6: (lv_constraints_4_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:443:7: lv_constraints_4_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite();
                      						
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference1547);
                    ruleJvmLowerBound();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmLowerBoundParserRuleCall_2_1_0_0ElementType());
                      						
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:452:5: ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==21) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:453:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
                    	    {
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:453:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:454:7: lv_constraints_5_0= ruleJvmLowerBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite();
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmLowerBoundAnded_in_ruleJvmWildcardTypeReference1599);
                    	    ruleJvmLowerBoundAnded();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0ElementType());
                    	      						
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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:469:1: entryRuleJvmUpperBound : ruleJvmUpperBound EOF ;
    public final void entryRuleJvmUpperBound() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:469:23: ( ruleJvmUpperBound EOF )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:470:2: ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound1647);
            ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(elementTypeProvider.getJvmUpperBoundElementType()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound1653); if (state.failed) return ;

            }

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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:478:1: ruleJvmUpperBound : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleJvmUpperBound() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:478:18: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:479:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:479:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:480:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleJvmUpperBound1676); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0, elementTypeProvider.getJvmUpperBound_ExtendsKeyword_0ElementType());
              		
            }
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:487:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:488:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:488:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:489:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite();
              				
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound1703);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite(elementTypeProvider.getJvmUpperBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:502:1: entryRuleJvmUpperBoundAnded : ruleJvmUpperBoundAnded EOF ;
    public final void entryRuleJvmUpperBoundAnded() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:502:28: ( ruleJvmUpperBoundAnded EOF )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:503:2: ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded1734);
            ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(elementTypeProvider.getJvmUpperBoundAndedElementType()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded1740); if (state.failed) return ;

            }

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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:511:1: ruleJvmUpperBoundAnded : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleJvmUpperBoundAnded() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:511:23: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:512:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:512:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:513:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleJvmUpperBoundAnded1763); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0, elementTypeProvider.getJvmUpperBoundAnded_AmpersandKeyword_0ElementType());
              		
            }
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:520:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:521:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:521:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:522:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite();
              				
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded1790);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite(elementTypeProvider.getJvmUpperBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:535:1: entryRuleJvmLowerBound : ruleJvmLowerBound EOF ;
    public final void entryRuleJvmLowerBound() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:535:23: ( ruleJvmLowerBound EOF )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:536:2: ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound1821);
            ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(elementTypeProvider.getJvmLowerBoundElementType()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound1827); if (state.failed) return ;

            }

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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:544:1: ruleJvmLowerBound : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleJvmLowerBound() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:544:18: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:545:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:545:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:546:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleJvmLowerBound1850); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0, elementTypeProvider.getJvmLowerBound_SuperKeyword_0ElementType());
              		
            }
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:553:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:554:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:554:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:555:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite();
              				
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound1877);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite(elementTypeProvider.getJvmLowerBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:568:1: entryRuleJvmLowerBoundAnded : ruleJvmLowerBoundAnded EOF ;
    public final void entryRuleJvmLowerBoundAnded() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:568:28: ( ruleJvmLowerBoundAnded EOF )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:569:2: ruleJvmLowerBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBoundAnded_in_entryRuleJvmLowerBoundAnded1908);
            ruleJvmLowerBoundAnded();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(elementTypeProvider.getJvmLowerBoundAndedElementType()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBoundAnded1914); if (state.failed) return ;

            }

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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:577:1: ruleJvmLowerBoundAnded : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleJvmLowerBoundAnded() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:577:23: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:578:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:578:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:579:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleJvmLowerBoundAnded1937); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0, elementTypeProvider.getJvmLowerBoundAnded_AmpersandKeyword_0ElementType());
              		
            }
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:586:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:587:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:587:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:588:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite();
              				
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBoundAnded1964);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite(elementTypeProvider.getJvmLowerBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:601:1: entryRuleJvmTypeParameter : ruleJvmTypeParameter EOF ;
    public final void entryRuleJvmTypeParameter() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:601:26: ( ruleJvmTypeParameter EOF )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:602:2: ruleJvmTypeParameter EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(); 
            }
            pushFollow(FOLLOW_ruleJvmTypeParameter_in_entryRuleJvmTypeParameter1995);
            ruleJvmTypeParameter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(elementTypeProvider.getJvmTypeParameterElementType()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeParameter2001); if (state.failed) return ;

            }

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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:610:1: ruleJvmTypeParameter : ( ( (lv_name_0_0= ruleValidID ) ) ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )? ) ;
    public final void ruleJvmTypeParameter() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:610:21: ( ( ( (lv_name_0_0= ruleValidID ) ) ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )? ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:611:2: ( ( (lv_name_0_0= ruleValidID ) ) ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )? )
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:611:2: ( ( (lv_name_0_0= ruleValidID ) ) ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )? )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:612:3: ( (lv_name_0_0= ruleValidID ) ) ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )?
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:612:3: ( (lv_name_0_0= ruleValidID ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:613:4: (lv_name_0_0= ruleValidID )
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:613:4: (lv_name_0_0= ruleValidID )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:614:5: lv_name_0_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					markComposite();
              				
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleJvmTypeParameter2037);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite(elementTypeProvider.getJvmTypeParameter_NameValidIDParserRuleCall_0_0ElementType());
              				
            }

            }


            }

            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:623:3: ( ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==20) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:624:4: ( (lv_constraints_1_0= ruleJvmUpperBound ) ) ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )*
                    {
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:624:4: ( (lv_constraints_1_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:625:5: (lv_constraints_1_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:625:5: (lv_constraints_1_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:626:6: lv_constraints_1_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite();
                      					
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmTypeParameter2083);
                    ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite(elementTypeProvider.getJvmTypeParameter_ConstraintsJvmUpperBoundParserRuleCall_1_0_0ElementType());
                      					
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:635:4: ( (lv_constraints_2_0= ruleJvmUpperBoundAnded ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==21) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:636:5: (lv_constraints_2_0= ruleJvmUpperBoundAnded )
                    	    {
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:636:5: (lv_constraints_2_0= ruleJvmUpperBoundAnded )
                    	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:637:6: lv_constraints_2_0= ruleJvmUpperBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						markComposite();
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmTypeParameter2128);
                    	    ruleJvmUpperBoundAnded();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      						doneComposite(elementTypeProvider.getJvmTypeParameter_ConstraintsJvmUpperBoundAndedParserRuleCall_1_1_0ElementType());
                    	      					
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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:651:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:651:23: ( ruleQualifiedName EOF )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:652:2: ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2168);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(elementTypeProvider.getQualifiedNameElementType()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName2174); if (state.failed) return ;

            }

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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:660:1: ruleQualifiedName : ( ruleValidID (kw= '.' ruleValidID )* ) ;
    public final void ruleQualifiedName() throws RecognitionException {
        Token kw=null;

        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:660:18: ( ( ruleValidID (kw= '.' ruleValidID )* ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:661:2: ( ruleValidID (kw= '.' ruleValidID )* )
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:661:2: ( ruleValidID (kw= '.' ruleValidID )* )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:662:3: ruleValidID (kw= '.' ruleValidID )*
            {
            if ( state.backtracking==0 ) {

              			markComposite();
              		
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName2195);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite(elementTypeProvider.getQualifiedName_ValidIDParserRuleCall_0ElementType());
              		
            }
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:669:3: (kw= '.' ruleValidID )*
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
            	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:670:4: kw= '.' ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markLeaf();
            	      			
            	    }
            	    kw=(Token)match(input,18,FOLLOW_18_in_ruleQualifiedName2215); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(kw, elementTypeProvider.getQualifiedName_FullStopKeyword_1_0ElementType());
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				markComposite();
            	      			
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName2230);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneComposite(elementTypeProvider.getQualifiedName_ValidIDParserRuleCall_1_1ElementType());
            	      			
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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:689:1: entryRuleQualifiedNameWithWildcard : ruleQualifiedNameWithWildcard EOF ;
    public final void entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:689:35: ( ruleQualifiedNameWithWildcard EOF )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:690:2: ruleQualifiedNameWithWildcard EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard2256);
            ruleQualifiedNameWithWildcard();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(elementTypeProvider.getQualifiedNameWithWildcardElementType()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard2262); if (state.failed) return ;

            }

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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:698:1: ruleQualifiedNameWithWildcard : ( ruleQualifiedName kw= '.' kw= '*' ) ;
    public final void ruleQualifiedNameWithWildcard() throws RecognitionException {
        Token kw=null;

        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:698:30: ( ( ruleQualifiedName kw= '.' kw= '*' ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:699:2: ( ruleQualifiedName kw= '.' kw= '*' )
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:699:2: ( ruleQualifiedName kw= '.' kw= '*' )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:700:3: ruleQualifiedName kw= '.' kw= '*'
            {
            if ( state.backtracking==0 ) {

              			markComposite();
              		
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard2283);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite(elementTypeProvider.getQualifiedNameWithWildcard_QualifiedNameParserRuleCall_0ElementType());
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            kw=(Token)match(input,18,FOLLOW_18_in_ruleQualifiedNameWithWildcard2297); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw, elementTypeProvider.getQualifiedNameWithWildcard_FullStopKeyword_1ElementType());
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            kw=(Token)match(input,23,FOLLOW_23_in_ruleQualifiedNameWithWildcard2311); if (state.failed) return ;
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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:725:1: entryRuleValidID : ruleValidID EOF ;
    public final void entryRuleValidID() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:725:17: ( ruleValidID EOF )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:726:2: ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID2331);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(elementTypeProvider.getValidIDElementType()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID2337); if (state.failed) return ;

            }

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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:734:1: ruleValidID : this_ID_0= RULE_ID ;
    public final void ruleValidID() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:734:12: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:735:2: this_ID_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              		markLeaf();
              	
            }
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID2355); if (state.failed) return ;
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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:745:1: entryRuleXImportSection : ruleXImportSection EOF ;
    public final void entryRuleXImportSection() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:745:24: ( ruleXImportSection EOF )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:746:2: ruleXImportSection EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(); 
            }
            pushFollow(FOLLOW_ruleXImportSection_in_entryRuleXImportSection2371);
            ruleXImportSection();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(elementTypeProvider.getXImportSectionElementType()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXImportSection2377); if (state.failed) return ;

            }

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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:754:1: ruleXImportSection : ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+ ;
    public final void ruleXImportSection() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:754:19: ( ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+ )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:755:2: ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:755:2: ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+
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
            	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:756:3: (lv_importDeclarations_0_0= ruleXImportDeclaration )
            	    {
            	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:756:3: (lv_importDeclarations_0_0= ruleXImportDeclaration )
            	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:757:4: lv_importDeclarations_0_0= ruleXImportDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markComposite();
            	      			
            	    }
            	    pushFollow(FOLLOW_ruleXImportDeclaration_in_ruleXImportSection2406);
            	    ruleXImportDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneComposite(elementTypeProvider.getXImportSection_ImportDeclarationsXImportDeclarationParserRuleCall_0ElementType());
            	      			
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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:769:1: entryRuleXImportDeclaration : ruleXImportDeclaration EOF ;
    public final void entryRuleXImportDeclaration() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:769:28: ( ruleXImportDeclaration EOF )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:770:2: ruleXImportDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(); 
            }
            pushFollow(FOLLOW_ruleXImportDeclaration_in_entryRuleXImportDeclaration2432);
            ruleXImportDeclaration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(elementTypeProvider.getXImportDeclarationElementType()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXImportDeclaration2438); if (state.failed) return ;

            }

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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:778:1: ruleXImportDeclaration : (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) ;
    public final void ruleXImportDeclaration() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_static_1_0=null;
        Token lv_extension_2_0=null;
        Token lv_wildcard_4_0=null;
        Token otherlv_8=null;

        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:778:23: ( (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:779:2: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:779:2: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:780:3: otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )?
            {
            if ( state.backtracking==0 ) {

              			markLeaf();
              		
            }
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleXImportDeclaration2461); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0, elementTypeProvider.getXImportDeclaration_ImportKeyword_0ElementType());
              		
            }
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:787:3: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )
            int alt21=3;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:788:4: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
                    {
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:788:4: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:789:5: ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
                    {
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:789:5: ( (lv_static_1_0= 'static' ) )
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:790:6: (lv_static_1_0= 'static' )
                    {
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:790:6: (lv_static_1_0= 'static' )
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:791:7: lv_static_1_0= 'static'
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf();
                      						
                    }
                    lv_static_1_0=(Token)match(input,25,FOLLOW_25_in_ruleXImportDeclaration2505); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(lv_static_1_0, elementTypeProvider.getXImportDeclaration_StaticStaticKeyword_1_0_0_0ElementType());
                      						
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:800:5: ( (lv_extension_2_0= 'extension' ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==26) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:801:6: (lv_extension_2_0= 'extension' )
                            {
                            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:801:6: (lv_extension_2_0= 'extension' )
                            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:802:7: lv_extension_2_0= 'extension'
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf();
                              						
                            }
                            lv_extension_2_0=(Token)match(input,26,FOLLOW_26_in_ruleXImportDeclaration2557); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(lv_extension_2_0, elementTypeProvider.getXImportDeclaration_ExtensionExtensionKeyword_1_0_1_0ElementType());
                              						
                            }

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:811:5: ( ( ruleQualifiedNameInStaticImport ) )
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:812:6: ( ruleQualifiedNameInStaticImport )
                    {
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:812:6: ( ruleQualifiedNameInStaticImport )
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:813:7: ruleQualifiedNameInStaticImport
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite();
                      						
                    }
                    pushFollow(FOLLOW_ruleQualifiedNameInStaticImport_in_ruleXImportDeclaration2608);
                    ruleQualifiedNameInStaticImport();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite(elementTypeProvider.getXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0ElementType());
                      						
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:822:5: ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
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
                            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:823:6: ( (lv_wildcard_4_0= '*' ) )
                            {
                            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:823:6: ( (lv_wildcard_4_0= '*' ) )
                            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:824:7: (lv_wildcard_4_0= '*' )
                            {
                            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:824:7: (lv_wildcard_4_0= '*' )
                            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:825:8: lv_wildcard_4_0= '*'
                            {
                            if ( state.backtracking==0 ) {

                              								markLeaf();
                              							
                            }
                            lv_wildcard_4_0=(Token)match(input,23,FOLLOW_23_in_ruleXImportDeclaration2670); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              								doneLeaf(lv_wildcard_4_0, elementTypeProvider.getXImportDeclaration_WildcardAsteriskKeyword_1_0_3_0_0ElementType());
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:835:6: ( (lv_memberName_5_0= ruleValidID ) )
                            {
                            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:835:6: ( (lv_memberName_5_0= ruleValidID ) )
                            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:836:7: (lv_memberName_5_0= ruleValidID )
                            {
                            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:836:7: (lv_memberName_5_0= ruleValidID )
                            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:837:8: lv_memberName_5_0= ruleValidID
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite();
                              							
                            }
                            pushFollow(FOLLOW_ruleValidID_in_ruleXImportDeclaration2740);
                            ruleValidID();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              								doneComposite(elementTypeProvider.getXImportDeclaration_MemberNameValidIDParserRuleCall_1_0_3_1_0ElementType());
                              							
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
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:849:4: ( ( ruleQualifiedName ) )
                    {
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:849:4: ( ( ruleQualifiedName ) )
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:850:5: ( ruleQualifiedName )
                    {
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:850:5: ( ruleQualifiedName )
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:851:6: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite();
                      					
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration2809);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite(elementTypeProvider.getXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_1_0ElementType());
                      					
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:861:4: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
                    {
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:861:4: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:862:5: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
                    {
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:862:5: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:863:6: lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite();
                      					
                    }
                    pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_ruleXImportDeclaration2863);
                    ruleQualifiedNameWithWildcard();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite(elementTypeProvider.getXImportDeclaration_ImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0ElementType());
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:873:3: (otherlv_8= ';' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==27) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:874:4: otherlv_8= ';'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf();
                      			
                    }
                    otherlv_8=(Token)match(input,27,FOLLOW_27_in_ruleXImportDeclaration2901); if (state.failed) return ;
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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:886:1: entryRuleQualifiedNameInStaticImport : ruleQualifiedNameInStaticImport EOF ;
    public final void entryRuleQualifiedNameInStaticImport() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:886:37: ( ruleQualifiedNameInStaticImport EOF )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:887:2: ruleQualifiedNameInStaticImport EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameInStaticImport_in_entryRuleQualifiedNameInStaticImport2927);
            ruleQualifiedNameInStaticImport();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               doneComposite(elementTypeProvider.getQualifiedNameInStaticImportElementType()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameInStaticImport2933); if (state.failed) return ;

            }

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
    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:895:1: ruleQualifiedNameInStaticImport : ( ruleValidID kw= '.' )+ ;
    public final void ruleQualifiedNameInStaticImport() throws RecognitionException {
        Token kw=null;

        try {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:895:32: ( ( ruleValidID kw= '.' )+ )
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:896:2: ( ruleValidID kw= '.' )+
            {
            // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:896:2: ( ruleValidID kw= '.' )+
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
            	    // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:897:3: ruleValidID kw= '.'
            	    {
            	    if ( state.backtracking==0 ) {

            	      			markComposite();
            	      		
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedNameInStaticImport2954);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      			doneComposite(elementTypeProvider.getQualifiedNameInStaticImport_ValidIDParserRuleCall_0ElementType());
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			markLeaf();
            	      		
            	    }
            	    kw=(Token)match(input,18,FOLLOW_18_in_ruleQualifiedNameInStaticImport2968); if (state.failed) return ;
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
        // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:64:5: ( ( () ruleArrayBrackets ) )
        // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:64:6: ( () ruleArrayBrackets )
        {
        // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:64:6: ( () ruleArrayBrackets )
        // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:65:6: () ruleArrayBrackets
        {
        // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:65:6: ()
        // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:66:6: 
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
        // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:230:5: ( '<' )
        // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:230:6: '<'
        {
        match(input,16,FOLLOW_16_in_synpred2_PsiInternalXtype653); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_PsiInternalXtype

    // $ANTLR start synpred3_PsiInternalXtype
    public final void synpred3_PsiInternalXtype_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:279:6: ( ( () '.' ) )
        // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:279:7: ( () '.' )
        {
        // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:279:7: ( () '.' )
        // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:280:7: () '.'
        {
        // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:280:7: ()
        // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:281:7: 
        {
        }

        match(input,18,FOLLOW_18_in_synpred3_PsiInternalXtype868); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_PsiInternalXtype

    // $ANTLR start synpred4_PsiInternalXtype
    public final void synpred4_PsiInternalXtype_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:310:7: ( '<' )
        // ../org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:310:8: '<'
        {
        match(input,16,FOLLOW_16_in_synpred4_PsiInternalXtype1017); if (state.failed) return ;

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
            return "787:3: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference60 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference87 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_ruleJvmTypeReference172 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets231 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayBrackets237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_ruleArrayBrackets260 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleArrayBrackets274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef294 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleXFunctionTypeRef329 = new BitSet(new long[]{0x000000000000D010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef370 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleXFunctionTypeRef413 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef455 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_ruleXFunctionTypeRef504 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleXFunctionTypeRef524 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference582 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference622 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleJvmParameterizedTypeReference669 = new BitSet(new long[]{0x0000000000089010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference707 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_13_in_ruleJvmParameterizedTypeReference744 = new BitSet(new long[]{0x0000000000089010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference781 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_17_in_ruleJvmParameterizedTypeReference820 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleJvmParameterizedTypeReference924 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmParameterizedTypeReference974 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_16_in_ruleJvmParameterizedTypeReference1037 = new BitSet(new long[]{0x0000000000089010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference1087 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_13_in_ruleJvmParameterizedTypeReference1136 = new BitSet(new long[]{0x0000000000089010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference1183 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_17_in_ruleJvmParameterizedTypeReference1234 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference1275 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference1281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference1302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference1322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference1342 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleJvmWildcardTypeReference1379 = new BitSet(new long[]{0x0000000000500002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference1423 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmWildcardTypeReference1475 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference1547 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJvmLowerBoundAnded_in_ruleJvmWildcardTypeReference1599 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound1647 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound1653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleJvmUpperBound1676 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded1734 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded1740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleJvmUpperBoundAnded1763 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded1790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound1821 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound1827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleJvmLowerBound1850 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound1877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBoundAnded_in_entryRuleJvmLowerBoundAnded1908 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBoundAnded1914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleJvmLowerBoundAnded1937 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBoundAnded1964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_entryRuleJvmTypeParameter1995 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeParameter2001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmTypeParameter2037 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmTypeParameter2083 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmTypeParameter2128 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2168 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName2174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName2195 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleQualifiedName2215 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName2230 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard2256 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard2262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard2283 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleQualifiedNameWithWildcard2297 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleQualifiedNameWithWildcard2311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID2331 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID2337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID2355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportSection_in_entryRuleXImportSection2371 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXImportSection2377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportDeclaration_in_ruleXImportSection2406 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleXImportDeclaration_in_entryRuleXImportDeclaration2432 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXImportDeclaration2438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleXImportDeclaration2461 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_25_in_ruleXImportDeclaration2505 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_26_in_ruleXImportDeclaration2557 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_ruleQualifiedNameInStaticImport_in_ruleXImportDeclaration2608 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_23_in_ruleXImportDeclaration2670 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXImportDeclaration2740 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration2809 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_ruleXImportDeclaration2863 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleXImportDeclaration2901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameInStaticImport_in_entryRuleQualifiedNameInStaticImport2927 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameInStaticImport2933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedNameInStaticImport2954 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleQualifiedNameInStaticImport2968 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_synpred1_PsiInternalXtype125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_synpred2_PsiInternalXtype653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_synpred3_PsiInternalXtype868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_synpred4_PsiInternalXtype1017 = new BitSet(new long[]{0x0000000000000002L});

}