package org.eclipse.xtext.xbase.idea.parser.antlr.internal;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.xbase.idea.lang.XtypeElementTypeProvider;
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess;

import com.intellij.lang.PsiBuilder;
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
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference57); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:58:1: ruleJvmTypeReference : ( ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | ruleXFunctionTypeRef ) ;
    public final void ruleJvmTypeReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:58:21: ( ( ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | ruleXFunctionTypeRef ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:59:2: ( ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | ruleXFunctionTypeRef )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:59:2: ( ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | ruleXFunctionTypeRef )
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
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:60:3: ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:60:3: ( ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:61:4: ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getJvmTypeReference_JvmParameterizedTypeReferenceParserRuleCall_0_0ElementType());
                      			
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference80);
                    ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneComposite();
                      			
                    }
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:68:4: ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==10) && (synpred1_PsiInternalXtype())) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:69:5: ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:75:5: ( () ruleArrayBrackets )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:76:6: () ruleArrayBrackets
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:76:6: ()
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:77:7: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							precedeComposite(elementTypeProvider.getJvmTypeReference_JvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0ElementType());
                    	      							doneComposite();
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						markComposite(elementTypeProvider.getJvmTypeReference_ArrayBracketsParserRuleCall_0_1_0_1ElementType());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_ruleArrayBrackets_in_ruleJvmTypeReference173);
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
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:93:3: ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getJvmTypeReference_XFunctionTypeRefParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference212);
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:104:1: entryRuleArrayBrackets : ruleArrayBrackets EOF ;
    public final void entryRuleArrayBrackets() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:104:23: ( ruleArrayBrackets EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:105:2: ruleArrayBrackets EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getArrayBracketsElementType()); 
            }
            pushFollow(FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets232);
            ruleArrayBrackets();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayBrackets235); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:110:1: ruleArrayBrackets : (kw= '[' kw= ']' ) ;
    public final void ruleArrayBrackets() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:110:18: ( (kw= '[' kw= ']' ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:111:2: (kw= '[' kw= ']' )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:111:2: (kw= '[' kw= ']' )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:112:3: kw= '[' kw= ']'
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getArrayBrackets_LeftSquareBracketKeyword_0ElementType());
              		
            }
            kw=(Token)match(input,10,FOLLOW_10_in_ruleArrayBrackets254); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getArrayBrackets_RightSquareBracketKeyword_1ElementType());
              		
            }
            kw=(Token)match(input,11,FOLLOW_11_in_ruleArrayBrackets268); if (state.failed) return ;
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:130:1: entryRuleXFunctionTypeRef : ruleXFunctionTypeRef EOF ;
    public final void entryRuleXFunctionTypeRef() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:130:26: ( ruleXFunctionTypeRef EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:131:2: ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXFunctionTypeRefElementType()); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef288);
            ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef291); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:136:1: ruleXFunctionTypeRef : ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleXFunctionTypeRef() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:136:21: ( ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:137:2: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:137:2: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:138:3: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:138:3: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:139:4: otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXFunctionTypeRef_LeftParenthesisKeyword_0_0ElementType());
                      			
                    }
                    otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleXFunctionTypeRef316); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_0);
                      			
                    }
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:146:4: ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID||LA4_0==12||LA4_0==15) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:147:5: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            {
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:147:5: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:148:6: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            {
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:148:6: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:149:7: lv_paramTypes_1_0= ruleJvmTypeReference
                            {
                            if ( state.backtracking==0 ) {

                              							markComposite(elementTypeProvider.getXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0ElementType());
                              						
                            }
                            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef357);
                            ruleJvmTypeReference();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneComposite();
                              						
                            }

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:158:5: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==13) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:159:6: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      						markLeaf(elementTypeProvider.getXFunctionTypeRef_CommaKeyword_0_1_1_0ElementType());
                            	      					
                            	    }
                            	    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleXFunctionTypeRef400); if (state.failed) return ;
                            	    if ( state.backtracking==0 ) {

                            	      						doneLeaf(otherlv_2);
                            	      					
                            	    }
                            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:166:6: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:167:7: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    {
                            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:167:7: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:168:8: lv_paramTypes_3_0= ruleJvmTypeReference
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								markComposite(elementTypeProvider.getXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0ElementType());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef442);
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

                      				markLeaf(elementTypeProvider.getXFunctionTypeRef_RightParenthesisKeyword_0_2ElementType());
                      			
                    }
                    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleXFunctionTypeRef491); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_4);
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXFunctionTypeRef_EqualsSignGreaterThanSignKeyword_1ElementType());
              		
            }
            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleXFunctionTypeRef511); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_5);
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:194:3: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:195:4: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:195:4: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:196:5: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXFunctionTypeRef_ReturnTypeJvmTypeReferenceParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef538);
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:209:1: entryRuleJvmParameterizedTypeReference : ruleJvmParameterizedTypeReference EOF ;
    public final void entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:209:39: ( ruleJvmParameterizedTypeReference EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:210:2: ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmParameterizedTypeReferenceElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference569);
            ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference572); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:215:1: ruleJvmParameterizedTypeReference : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) ;
    public final void ruleJvmParameterizedTypeReference() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:215:34: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:216:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:216:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:217:3: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:217:3: ( ( ruleQualifiedName ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:218:4: ( ruleQualifiedName )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:218:4: ( ruleQualifiedName )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:219:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmParameterizedTypeReference_TypeJvmTypeCrossReference_0_0ElementType());
              				
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference602);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:228:3: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==16) && (synpred2_PsiInternalXtype())) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:229:4: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:229:4: ( ( '<' )=>otherlv_1= '<' )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:230:5: ( '<' )=>otherlv_1= '<'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_LessThanSignKeyword_1_0ElementType());
                      				
                    }
                    otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleJvmParameterizedTypeReference649); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1);
                      				
                    }

                    }

                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:239:4: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:240:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:240:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:241:6: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference687);
                    ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:250:4: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==13) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:251:5: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_CommaKeyword_1_2_0ElementType());
                    	      				
                    	    }
                    	    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleJvmParameterizedTypeReference724); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_3);
                    	      				
                    	    }
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:258:5: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:259:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:259:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:260:7: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference761);
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

                      				markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_GreaterThanSignKeyword_1_3ElementType());
                      			
                    }
                    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleJvmParameterizedTypeReference800); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_5);
                      			
                    }
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:277:4: ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==18) && (synpred3_PsiInternalXtype())) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:278:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:278:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:279:6: ( ( () '.' ) )=> ( () otherlv_7= '.' )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:285:6: ( () otherlv_7= '.' )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:286:7: () otherlv_7= '.'
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:286:7: ()
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:287:8: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								precedeComposite(elementTypeProvider.getJvmParameterizedTypeReference_JvmInnerTypeReferenceOuterAction_1_4_0_0_0ElementType());
                    	      								doneComposite();
                    	      							
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      							markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_FullStopKeyword_1_4_0_0_1ElementType());
                    	      						
                    	    }
                    	    otherlv_7=(Token)match(input,18,FOLLOW_18_in_ruleJvmParameterizedTypeReference913); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneLeaf(otherlv_7);
                    	      						
                    	    }

                    	    }


                    	    }

                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:301:5: ( ( ruleValidID ) )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:302:6: ( ruleValidID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:302:6: ( ruleValidID )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:303:7: ruleValidID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmParameterizedTypeReference_TypeJvmTypeCrossReference_1_4_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_ruleValidID_in_ruleJvmParameterizedTypeReference963);
                    	    ruleValidID();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      						
                    	    }

                    	    }


                    	    }

                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:312:5: ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
                    	    int alt8=2;
                    	    int LA8_0 = input.LA(1);

                    	    if ( (LA8_0==16) && (synpred4_PsiInternalXtype())) {
                    	        alt8=1;
                    	    }
                    	    switch (alt8) {
                    	        case 1 :
                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:313:6: ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>'
                    	            {
                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:313:6: ( ( '<' )=>otherlv_9= '<' )
                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:314:7: ( '<' )=>otherlv_9= '<'
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              							markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_LessThanSignKeyword_1_4_2_0ElementType());
                    	              						
                    	            }
                    	            otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleJvmParameterizedTypeReference1026); if (state.failed) return ;
                    	            if ( state.backtracking==0 ) {

                    	              							doneLeaf(otherlv_9);
                    	              						
                    	            }

                    	            }

                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:323:6: ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) )
                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:324:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
                    	            {
                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:324:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:325:8: lv_arguments_10_0= ruleJvmArgumentTypeReference
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0ElementType());
                    	              							
                    	            }
                    	            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference1076);
                    	            ruleJvmArgumentTypeReference();

                    	            state._fsp--;
                    	            if (state.failed) return ;
                    	            if ( state.backtracking==0 ) {

                    	              								doneComposite();
                    	              							
                    	            }

                    	            }


                    	            }

                    	            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:334:6: (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )*
                    	            loop7:
                    	            do {
                    	                int alt7=2;
                    	                int LA7_0 = input.LA(1);

                    	                if ( (LA7_0==13) ) {
                    	                    alt7=1;
                    	                }


                    	                switch (alt7) {
                    	            	case 1 :
                    	            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:335:7: otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
                    	            	    {
                    	            	    if ( state.backtracking==0 ) {

                    	            	      							markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_CommaKeyword_1_4_2_2_0ElementType());
                    	            	      						
                    	            	    }
                    	            	    otherlv_11=(Token)match(input,13,FOLLOW_13_in_ruleJvmParameterizedTypeReference1125); if (state.failed) return ;
                    	            	    if ( state.backtracking==0 ) {

                    	            	      							doneLeaf(otherlv_11);
                    	            	      						
                    	            	    }
                    	            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:342:7: ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
                    	            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:343:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
                    	            	    {
                    	            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:343:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
                    	            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:344:9: lv_arguments_12_0= ruleJvmArgumentTypeReference
                    	            	    {
                    	            	    if ( state.backtracking==0 ) {

                    	            	      									markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0ElementType());
                    	            	      								
                    	            	    }
                    	            	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference1172);
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

                    	              						markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_GreaterThanSignKeyword_1_4_2_3ElementType());
                    	              					
                    	            }
                    	            otherlv_13=(Token)match(input,17,FOLLOW_17_in_ruleJvmParameterizedTypeReference1223); if (state.failed) return ;
                    	            if ( state.backtracking==0 ) {

                    	              						doneLeaf(otherlv_13);
                    	              					
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:368:1: entryRuleJvmArgumentTypeReference : ruleJvmArgumentTypeReference EOF ;
    public final void entryRuleJvmArgumentTypeReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:368:34: ( ruleJvmArgumentTypeReference EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:369:2: ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmArgumentTypeReferenceElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference1264);
            ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference1267); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:374:1: ruleJvmArgumentTypeReference : ( ruleJvmTypeReference | ruleJvmWildcardTypeReference ) ;
    public final void ruleJvmArgumentTypeReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:374:29: ( ( ruleJvmTypeReference | ruleJvmWildcardTypeReference ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:375:2: ( ruleJvmTypeReference | ruleJvmWildcardTypeReference )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:375:2: ( ruleJvmTypeReference | ruleJvmWildcardTypeReference )
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
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:376:3: ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getJvmArgumentTypeReference_JvmTypeReferenceParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference1284);
                    ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:384:3: ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getJvmArgumentTypeReference_JvmWildcardTypeReferenceParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference1304);
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:395:1: entryRuleJvmWildcardTypeReference : ruleJvmWildcardTypeReference EOF ;
    public final void entryRuleJvmWildcardTypeReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:395:34: ( ruleJvmWildcardTypeReference EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:396:2: ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmWildcardTypeReferenceElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference1324);
            ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference1327); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:401:1: ruleJvmWildcardTypeReference : ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) ;
    public final void ruleJvmWildcardTypeReference() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:401:29: ( ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:402:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:402:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:403:3: () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:403:3: ()
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:404:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getJvmWildcardTypeReference_JvmWildcardTypeReferenceAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getJvmWildcardTypeReference_QuestionMarkKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleJvmWildcardTypeReference1359); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:416:3: ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
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
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:417:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:417:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:418:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:418:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:419:6: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:419:6: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:420:7: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmUpperBoundParserRuleCall_2_0_0_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference1403);
                    ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:429:5: ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==21) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:430:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:430:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:431:7: lv_constraints_3_0= ruleJvmUpperBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmWildcardTypeReference1455);
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
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:442:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:442:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:443:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:443:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:444:6: (lv_constraints_4_0= ruleJvmLowerBound )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:444:6: (lv_constraints_4_0= ruleJvmLowerBound )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:445:7: lv_constraints_4_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmLowerBoundParserRuleCall_2_1_0_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference1527);
                    ruleJvmLowerBound();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:454:5: ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==21) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:455:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:455:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
                    	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:456:7: lv_constraints_5_0= ruleJvmLowerBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmLowerBoundAnded_in_ruleJvmWildcardTypeReference1579);
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:471:1: entryRuleJvmUpperBound : ruleJvmUpperBound EOF ;
    public final void entryRuleJvmUpperBound() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:471:23: ( ruleJvmUpperBound EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:472:2: ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmUpperBoundElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound1627);
            ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound1630); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:477:1: ruleJvmUpperBound : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleJvmUpperBound() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:477:18: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:478:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:478:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:479:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getJvmUpperBound_ExtendsKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleJvmUpperBound1649); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:486:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:487:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:487:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:488:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmUpperBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound1676);
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:501:1: entryRuleJvmUpperBoundAnded : ruleJvmUpperBoundAnded EOF ;
    public final void entryRuleJvmUpperBoundAnded() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:501:28: ( ruleJvmUpperBoundAnded EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:502:2: ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmUpperBoundAndedElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded1707);
            ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded1710); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:507:1: ruleJvmUpperBoundAnded : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleJvmUpperBoundAnded() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:507:23: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:508:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:508:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:509:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getJvmUpperBoundAnded_AmpersandKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleJvmUpperBoundAnded1729); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:516:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:517:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:517:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:518:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmUpperBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded1756);
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:531:1: entryRuleJvmLowerBound : ruleJvmLowerBound EOF ;
    public final void entryRuleJvmLowerBound() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:531:23: ( ruleJvmLowerBound EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:532:2: ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmLowerBoundElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound1787);
            ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound1790); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:537:1: ruleJvmLowerBound : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleJvmLowerBound() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:537:18: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:538:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:538:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:539:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getJvmLowerBound_SuperKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleJvmLowerBound1809); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:546:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:547:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:547:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:548:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmLowerBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound1836);
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:561:1: entryRuleJvmLowerBoundAnded : ruleJvmLowerBoundAnded EOF ;
    public final void entryRuleJvmLowerBoundAnded() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:561:28: ( ruleJvmLowerBoundAnded EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:562:2: ruleJvmLowerBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmLowerBoundAndedElementType()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBoundAnded_in_entryRuleJvmLowerBoundAnded1867);
            ruleJvmLowerBoundAnded();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBoundAnded1870); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:567:1: ruleJvmLowerBoundAnded : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final void ruleJvmLowerBoundAnded() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:567:23: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:568:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:568:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:569:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getJvmLowerBoundAnded_AmpersandKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleJvmLowerBoundAnded1889); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:576:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:577:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:577:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:578:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmLowerBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBoundAnded1916);
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:591:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:591:23: ( ruleQualifiedName EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:592:2: ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getQualifiedNameElementType()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1947);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName1950); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:597:1: ruleQualifiedName : ( ruleValidID (kw= '.' ruleValidID )* ) ;
    public final void ruleQualifiedName() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:597:18: ( ( ruleValidID (kw= '.' ruleValidID )* ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:598:2: ( ruleValidID (kw= '.' ruleValidID )* )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:598:2: ( ruleValidID (kw= '.' ruleValidID )* )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:599:3: ruleValidID (kw= '.' ruleValidID )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getQualifiedName_ValidIDParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName1967);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:606:3: (kw= '.' ruleValidID )*
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
            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:607:4: kw= '.' ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getQualifiedName_FullStopKeyword_1_0ElementType());
            	      			
            	    }
            	    kw=(Token)match(input,18,FOLLOW_18_in_ruleQualifiedName1987); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(kw);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				markComposite(elementTypeProvider.getQualifiedName_ValidIDParserRuleCall_1_1ElementType());
            	      			
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName2002);
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:626:1: entryRuleQualifiedNameWithWildcard : ruleQualifiedNameWithWildcard EOF ;
    public final void entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:626:35: ( ruleQualifiedNameWithWildcard EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:627:2: ruleQualifiedNameWithWildcard EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getQualifiedNameWithWildcardElementType()); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard2028);
            ruleQualifiedNameWithWildcard();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard2031); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:632:1: ruleQualifiedNameWithWildcard : ( ruleQualifiedName kw= '.' kw= '*' ) ;
    public final void ruleQualifiedNameWithWildcard() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:632:30: ( ( ruleQualifiedName kw= '.' kw= '*' ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:633:2: ( ruleQualifiedName kw= '.' kw= '*' )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:633:2: ( ruleQualifiedName kw= '.' kw= '*' )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:634:3: ruleQualifiedName kw= '.' kw= '*'
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getQualifiedNameWithWildcard_QualifiedNameParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard2048);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getQualifiedNameWithWildcard_FullStopKeyword_1ElementType());
              		
            }
            kw=(Token)match(input,18,FOLLOW_18_in_ruleQualifiedNameWithWildcard2062); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getQualifiedNameWithWildcard_AsteriskKeyword_2ElementType());
              		
            }
            kw=(Token)match(input,23,FOLLOW_23_in_ruleQualifiedNameWithWildcard2076); if (state.failed) return ;
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:659:1: entryRuleValidID : ruleValidID EOF ;
    public final void entryRuleValidID() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:659:17: ( ruleValidID EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:660:2: ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getValidIDElementType()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID2096);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID2099); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:665:1: ruleValidID : this_ID_0= RULE_ID ;
    public final void ruleValidID() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:665:12: (this_ID_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:666:2: this_ID_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getValidID_IDTerminalRuleCallElementType());
              	
            }
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID2113); if (state.failed) return ;
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


    // $ANTLR start "entryRuleXImportDeclaration"
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:676:1: entryRuleXImportDeclaration : ruleXImportDeclaration EOF ;
    public final void entryRuleXImportDeclaration() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:676:28: ( ruleXImportDeclaration EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:677:2: ruleXImportDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXImportDeclarationElementType()); 
            }
            pushFollow(FOLLOW_ruleXImportDeclaration_in_entryRuleXImportDeclaration2129);
            ruleXImportDeclaration();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_EOF_in_entryRuleXImportDeclaration2132); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:682:1: ruleXImportDeclaration : (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) ;
    public final void ruleXImportDeclaration() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_static_1_0=null;
        Token lv_extension_2_0=null;
        Token lv_wildcard_4_0=null;
        Token otherlv_8=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:682:23: ( (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:683:2: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:683:2: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:684:3: otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )?
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXImportDeclaration_ImportKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleXImportDeclaration2151); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:691:3: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )
            int alt18=3;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:692:4: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:692:4: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:693:5: ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:693:5: ( (lv_static_1_0= 'static' ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:694:6: (lv_static_1_0= 'static' )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:694:6: (lv_static_1_0= 'static' )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:695:7: lv_static_1_0= 'static'
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getXImportDeclaration_StaticStaticKeyword_1_0_0_0ElementType());
                      						
                    }
                    lv_static_1_0=(Token)match(input,25,FOLLOW_25_in_ruleXImportDeclaration2195); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(lv_static_1_0);
                      						
                    }

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:704:5: ( (lv_extension_2_0= 'extension' ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==26) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:705:6: (lv_extension_2_0= 'extension' )
                            {
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:705:6: (lv_extension_2_0= 'extension' )
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:706:7: lv_extension_2_0= 'extension'
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getXImportDeclaration_ExtensionExtensionKeyword_1_0_1_0ElementType());
                              						
                            }
                            lv_extension_2_0=(Token)match(input,26,FOLLOW_26_in_ruleXImportDeclaration2247); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(lv_extension_2_0);
                              						
                            }

                            }


                            }
                            break;

                    }

                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:715:5: ( ( ruleQualifiedNameInStaticImport ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:716:6: ( ruleQualifiedNameInStaticImport )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:716:6: ( ruleQualifiedNameInStaticImport )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:717:7: ruleQualifiedNameInStaticImport
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_ruleQualifiedNameInStaticImport_in_ruleXImportDeclaration2298);
                    ruleQualifiedNameInStaticImport();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:726:5: ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
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
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:727:6: ( (lv_wildcard_4_0= '*' ) )
                            {
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:727:6: ( (lv_wildcard_4_0= '*' ) )
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:728:7: (lv_wildcard_4_0= '*' )
                            {
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:728:7: (lv_wildcard_4_0= '*' )
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:729:8: lv_wildcard_4_0= '*'
                            {
                            if ( state.backtracking==0 ) {

                              								markLeaf(elementTypeProvider.getXImportDeclaration_WildcardAsteriskKeyword_1_0_3_0_0ElementType());
                              							
                            }
                            lv_wildcard_4_0=(Token)match(input,23,FOLLOW_23_in_ruleXImportDeclaration2360); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              								doneLeaf(lv_wildcard_4_0);
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:739:6: ( (lv_memberName_5_0= ruleValidID ) )
                            {
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:739:6: ( (lv_memberName_5_0= ruleValidID ) )
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:740:7: (lv_memberName_5_0= ruleValidID )
                            {
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:740:7: (lv_memberName_5_0= ruleValidID )
                            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:741:8: lv_memberName_5_0= ruleValidID
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getXImportDeclaration_MemberNameValidIDParserRuleCall_1_0_3_1_0ElementType());
                              							
                            }
                            pushFollow(FOLLOW_ruleValidID_in_ruleXImportDeclaration2430);
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
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:753:4: ( ( ruleQualifiedName ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:753:4: ( ( ruleQualifiedName ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:754:5: ( ruleQualifiedName )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:754:5: ( ruleQualifiedName )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:755:6: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration2499);
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
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:765:4: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:765:4: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:766:5: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
                    {
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:766:5: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:767:6: lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXImportDeclaration_ImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_ruleXImportDeclaration2553);
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

            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:777:3: (otherlv_8= ';' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:778:4: otherlv_8= ';'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXImportDeclaration_SemicolonKeyword_2ElementType());
                      			
                    }
                    otherlv_8=(Token)match(input,27,FOLLOW_27_in_ruleXImportDeclaration2591); if (state.failed) return ;
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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:790:1: entryRuleQualifiedNameInStaticImport : ruleQualifiedNameInStaticImport EOF ;
    public final void entryRuleQualifiedNameInStaticImport() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:790:37: ( ruleQualifiedNameInStaticImport EOF )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:791:2: ruleQualifiedNameInStaticImport EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getQualifiedNameInStaticImportElementType()); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameInStaticImport_in_entryRuleQualifiedNameInStaticImport2617);
            ruleQualifiedNameInStaticImport();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameInStaticImport2620); if (state.failed) return ;

            }

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
    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:796:1: ruleQualifiedNameInStaticImport : ( ruleValidID kw= '.' )+ ;
    public final void ruleQualifiedNameInStaticImport() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:796:32: ( ( ruleValidID kw= '.' )+ )
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:797:2: ( ruleValidID kw= '.' )+
            {
            // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:797:2: ( ruleValidID kw= '.' )+
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
            	    // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:798:3: ruleValidID kw= '.'
            	    {
            	    if ( state.backtracking==0 ) {

            	      			markComposite(elementTypeProvider.getQualifiedNameInStaticImport_ValidIDParserRuleCall_0ElementType());
            	      		
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedNameInStaticImport2637);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      			doneComposite();
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			markLeaf(elementTypeProvider.getQualifiedNameInStaticImport_FullStopKeyword_1ElementType());
            	      		
            	    }
            	    kw=(Token)match(input,18,FOLLOW_18_in_ruleQualifiedNameInStaticImport2651); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      			doneLeaf(kw);
            	      		
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
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:69:5: ( ( () ruleArrayBrackets ) )
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:69:6: ( () ruleArrayBrackets )
        {
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:69:6: ( () ruleArrayBrackets )
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:70:6: () ruleArrayBrackets
        {
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:70:6: ()
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:71:6: 
        {
        }

        pushFollow(FOLLOW_ruleArrayBrackets_in_synpred1_PsiInternalXtype118);
        ruleArrayBrackets();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_PsiInternalXtype

    // $ANTLR start synpred2_PsiInternalXtype
    public final void synpred2_PsiInternalXtype_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:230:5: ( '<' )
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:230:6: '<'
        {
        match(input,16,FOLLOW_16_in_synpred2_PsiInternalXtype633); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_PsiInternalXtype

    // $ANTLR start synpred3_PsiInternalXtype
    public final void synpred3_PsiInternalXtype_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:279:6: ( ( () '.' ) )
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:279:7: ( () '.' )
        {
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:279:7: ( () '.' )
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:280:7: () '.'
        {
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:280:7: ()
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:281:7: 
        {
        }

        match(input,18,FOLLOW_18_in_synpred3_PsiInternalXtype848); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_PsiInternalXtype

    // $ANTLR start synpred4_PsiInternalXtype
    public final void synpred4_PsiInternalXtype_fragment() throws RecognitionException {   
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:314:7: ( '<' )
        // ../../intellij/org.eclipse.xtext.xbase.idea/src-gen/org/eclipse/xtext/xbase/idea/parser/antlr/internal/PsiInternalXtype.g:314:8: '<'
        {
        match(input,16,FOLLOW_16_in_synpred4_PsiInternalXtype1006); if (state.failed) return ;

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
            return "691:3: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference57 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference80 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_ruleJvmTypeReference173 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets232 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayBrackets235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_ruleArrayBrackets254 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleArrayBrackets268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef288 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleXFunctionTypeRef316 = new BitSet(new long[]{0x000000000000D010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef357 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleXFunctionTypeRef400 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef442 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_ruleXFunctionTypeRef491 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleXFunctionTypeRef511 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference569 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference602 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleJvmParameterizedTypeReference649 = new BitSet(new long[]{0x0000000000089010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference687 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_13_in_ruleJvmParameterizedTypeReference724 = new BitSet(new long[]{0x0000000000089010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference761 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_17_in_ruleJvmParameterizedTypeReference800 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleJvmParameterizedTypeReference913 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmParameterizedTypeReference963 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_16_in_ruleJvmParameterizedTypeReference1026 = new BitSet(new long[]{0x0000000000089010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference1076 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_13_in_ruleJvmParameterizedTypeReference1125 = new BitSet(new long[]{0x0000000000089010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference1172 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_17_in_ruleJvmParameterizedTypeReference1223 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference1264 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference1267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference1284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference1304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference1324 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference1327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleJvmWildcardTypeReference1359 = new BitSet(new long[]{0x0000000000500002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference1403 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmWildcardTypeReference1455 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference1527 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJvmLowerBoundAnded_in_ruleJvmWildcardTypeReference1579 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound1627 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleJvmUpperBound1649 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound1676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded1707 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded1710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleJvmUpperBoundAnded1729 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded1756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound1787 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound1790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleJvmLowerBound1809 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound1836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBoundAnded_in_entryRuleJvmLowerBoundAnded1867 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBoundAnded1870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleJvmLowerBoundAnded1889 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBoundAnded1916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1947 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName1950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName1967 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleQualifiedName1987 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName2002 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard2028 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard2031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard2048 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleQualifiedNameWithWildcard2062 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleQualifiedNameWithWildcard2076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID2096 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID2099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID2113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportDeclaration_in_entryRuleXImportDeclaration2129 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXImportDeclaration2132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleXImportDeclaration2151 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_25_in_ruleXImportDeclaration2195 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_26_in_ruleXImportDeclaration2247 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_ruleQualifiedNameInStaticImport_in_ruleXImportDeclaration2298 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_23_in_ruleXImportDeclaration2360 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXImportDeclaration2430 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration2499 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_ruleXImportDeclaration2553 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleXImportDeclaration2591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameInStaticImport_in_entryRuleQualifiedNameInStaticImport2617 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameInStaticImport2620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedNameInStaticImport2637 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleQualifiedNameInStaticImport2651 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_synpred1_PsiInternalXtype118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_synpred2_PsiInternalXtype633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_synpred3_PsiInternalXtype848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_synpred4_PsiInternalXtype1006 = new BitSet(new long[]{0x0000000000000002L});

}