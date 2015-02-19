package org.eclipse.xtext.parsetree.transientvalues.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.transientvalues.idea.lang.TransientValuesTestElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalTransientValuesTestParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'test'", "'required'", "'optional'", "':'", "'list'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=6;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=4;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalTransientValuesTestParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalTransientValuesTestParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalTransientValuesTestParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g"; }



    	protected TransientValuesTestGrammarAccess grammarAccess;

    	protected TransientValuesTestElementTypeProvider elementTypeProvider;

    	public PsiInternalTransientValuesTestParser(PsiBuilder builder, TokenStream input, TransientValuesTestElementTypeProvider elementTypeProvider, TransientValuesTestGrammarAccess grammarAccess) {
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:52:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:52:14: ( ruleRoot EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:53:2: ruleRoot EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:59:1: ruleRoot : (otherlv_0= 'test' ( ruleTestRequired | ruleTestOptional | ruleTestList ) ) ;
    public final void ruleRoot() throws RecognitionException {
        Token otherlv_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:62:2: ( (otherlv_0= 'test' ( ruleTestRequired | ruleTestOptional | ruleTestList ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:63:2: (otherlv_0= 'test' ( ruleTestRequired | ruleTestOptional | ruleTestList ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:63:2: (otherlv_0= 'test' ( ruleTestRequired | ruleTestOptional | ruleTestList ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:64:3: otherlv_0= 'test' ( ruleTestRequired | ruleTestOptional | ruleTestList )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleRoot88); 

            			doneLeaf(otherlv_0, elementTypeProvider.getRoot_TestKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:71:3: ( ruleTestRequired | ruleTestOptional | ruleTestList )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt1=1;
                }
                break;
            case 13:
                {
                alt1=2;
                }
                break;
            case 15:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:72:4: ruleTestRequired
                    {

                    				markComposite(elementTypeProvider.getRoot_TestRequiredParserRuleCall_1_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleTestRequired_in_ruleRoot106);
                    ruleTestRequired();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:80:4: ruleTestOptional
                    {

                    				markComposite(elementTypeProvider.getRoot_TestOptionalParserRuleCall_1_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleTestOptional_in_ruleRoot130);
                    ruleTestOptional();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:88:4: ruleTestList
                    {

                    				markComposite(elementTypeProvider.getRoot_TestListParserRuleCall_1_2ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleTestList_in_ruleRoot154);
                    ruleTestList();

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


    // $ANTLR start "entryRuleTestRequired"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:100:1: entryRuleTestRequired : ruleTestRequired EOF ;
    public final void entryRuleTestRequired() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:100:22: ( ruleTestRequired EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:101:2: ruleTestRequired EOF
            {
             markComposite(elementTypeProvider.getTestRequiredElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTestRequired_in_entryRuleTestRequired179);
            ruleTestRequired();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestRequired185); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTestRequired"


    // $ANTLR start "ruleTestRequired"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:107:1: ruleTestRequired : ( () otherlv_1= 'required' ( (lv_required1_2_0= RULE_INT ) ) ( (lv_required2_3_0= RULE_INT ) ) ) ;
    public final void ruleTestRequired() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_required1_2_0=null;
        Token lv_required2_3_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:110:2: ( ( () otherlv_1= 'required' ( (lv_required1_2_0= RULE_INT ) ) ( (lv_required2_3_0= RULE_INT ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:111:2: ( () otherlv_1= 'required' ( (lv_required1_2_0= RULE_INT ) ) ( (lv_required2_3_0= RULE_INT ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:111:2: ( () otherlv_1= 'required' ( (lv_required1_2_0= RULE_INT ) ) ( (lv_required2_3_0= RULE_INT ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:112:3: () otherlv_1= 'required' ( (lv_required1_2_0= RULE_INT ) ) ( (lv_required2_3_0= RULE_INT ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:112:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:113:4: 
            {

            				precedeComposite(elementTypeProvider.getTestRequired_TestRequiredAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleTestRequired226); 

            			doneLeaf(otherlv_1, elementTypeProvider.getTestRequired_RequiredKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:125:3: ( (lv_required1_2_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:126:4: (lv_required1_2_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:126:4: (lv_required1_2_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:127:5: lv_required1_2_0= RULE_INT
            {

            					markLeaf();
            				
            lv_required1_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTestRequired253); 

            					doneLeaf(lv_required1_2_0, elementTypeProvider.getTestRequired_Required1INTTerminalRuleCall_2_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:136:3: ( (lv_required2_3_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:137:4: (lv_required2_3_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:137:4: (lv_required2_3_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:138:5: lv_required2_3_0= RULE_INT
            {

            					markLeaf();
            				
            lv_required2_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTestRequired291); 

            					doneLeaf(lv_required2_3_0, elementTypeProvider.getTestRequired_Required2INTTerminalRuleCall_3_0ElementType());
            				

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
    // $ANTLR end "ruleTestRequired"


    // $ANTLR start "entryRuleTestOptional"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:151:1: entryRuleTestOptional : ruleTestOptional EOF ;
    public final void entryRuleTestOptional() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:151:22: ( ruleTestOptional EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:152:2: ruleTestOptional EOF
            {
             markComposite(elementTypeProvider.getTestOptionalElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTestOptional_in_entryRuleTestOptional322);
            ruleTestOptional();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestOptional328); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTestOptional"


    // $ANTLR start "ruleTestOptional"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:158:1: ruleTestOptional : ( () otherlv_1= 'optional' ( (lv_opt1_2_0= RULE_INT ) )? (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )? ) ;
    public final void ruleTestOptional() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_opt1_2_0=null;
        Token otherlv_3=null;
        Token lv_opt2_4_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:161:2: ( ( () otherlv_1= 'optional' ( (lv_opt1_2_0= RULE_INT ) )? (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:162:2: ( () otherlv_1= 'optional' ( (lv_opt1_2_0= RULE_INT ) )? (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:162:2: ( () otherlv_1= 'optional' ( (lv_opt1_2_0= RULE_INT ) )? (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:163:3: () otherlv_1= 'optional' ( (lv_opt1_2_0= RULE_INT ) )? (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:163:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:164:4: 
            {

            				precedeComposite(elementTypeProvider.getTestOptional_TestOptionalAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleTestOptional369); 

            			doneLeaf(otherlv_1, elementTypeProvider.getTestOptional_OptionalKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:176:3: ( (lv_opt1_2_0= RULE_INT ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_INT) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:177:4: (lv_opt1_2_0= RULE_INT )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:177:4: (lv_opt1_2_0= RULE_INT )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:178:5: lv_opt1_2_0= RULE_INT
                    {

                    					markLeaf();
                    				
                    lv_opt1_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTestOptional396); 

                    					doneLeaf(lv_opt1_2_0, elementTypeProvider.getTestOptional_Opt1INTTerminalRuleCall_2_0ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:187:3: (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:188:4: otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) )
                    {

                    				markLeaf();
                    			
                    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleTestOptional428); 

                    				doneLeaf(otherlv_3, elementTypeProvider.getTestOptional_ColonKeyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:195:4: ( (lv_opt2_4_0= RULE_INT ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:196:5: (lv_opt2_4_0= RULE_INT )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:196:5: (lv_opt2_4_0= RULE_INT )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:197:6: lv_opt2_4_0= RULE_INT
                    {

                    						markLeaf();
                    					
                    lv_opt2_4_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTestOptional460); 

                    						doneLeaf(lv_opt2_4_0, elementTypeProvider.getTestOptional_Opt2INTTerminalRuleCall_3_1_0ElementType());
                    					

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
    // $ANTLR end "ruleTestOptional"


    // $ANTLR start "entryRuleTestList"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:211:1: entryRuleTestList : ruleTestList EOF ;
    public final void entryRuleTestList() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:211:18: ( ruleTestList EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:212:2: ruleTestList EOF
            {
             markComposite(elementTypeProvider.getTestListElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTestList_in_entryRuleTestList499);
            ruleTestList();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestList505); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTestList"


    // $ANTLR start "ruleTestList"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:218:1: ruleTestList : ( () otherlv_1= 'list' ( (lv_item_2_0= RULE_INT ) )* ) ;
    public final void ruleTestList() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_item_2_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:221:2: ( ( () otherlv_1= 'list' ( (lv_item_2_0= RULE_INT ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:222:2: ( () otherlv_1= 'list' ( (lv_item_2_0= RULE_INT ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:222:2: ( () otherlv_1= 'list' ( (lv_item_2_0= RULE_INT ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:223:3: () otherlv_1= 'list' ( (lv_item_2_0= RULE_INT ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:223:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:224:4: 
            {

            				precedeComposite(elementTypeProvider.getTestList_TestListAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleTestList546); 

            			doneLeaf(otherlv_1, elementTypeProvider.getTestList_ListKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:236:3: ( (lv_item_2_0= RULE_INT ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_INT) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:237:4: (lv_item_2_0= RULE_INT )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:237:4: (lv_item_2_0= RULE_INT )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:238:5: lv_item_2_0= RULE_INT
            	    {

            	    					markLeaf();
            	    				
            	    lv_item_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTestList573); 

            	    					doneLeaf(lv_item_2_0, elementTypeProvider.getTestList_ItemINTTerminalRuleCall_2_0ElementType());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
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
    // $ANTLR end "ruleTestList"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleRoot88 = new BitSet(new long[]{0x000000000000B000L});
        public static final BitSet FOLLOW_ruleTestRequired_in_ruleRoot106 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestOptional_in_ruleRoot130 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestList_in_ruleRoot154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestRequired_in_entryRuleTestRequired179 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestRequired185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleTestRequired226 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTestRequired253 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTestRequired291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestOptional_in_entryRuleTestOptional322 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestOptional328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleTestOptional369 = new BitSet(new long[]{0x0000000000004012L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTestOptional396 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleTestOptional428 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTestOptional460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestList_in_entryRuleTestList499 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestList505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleTestList546 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTestList573 = new BitSet(new long[]{0x0000000000000012L});
    }


}