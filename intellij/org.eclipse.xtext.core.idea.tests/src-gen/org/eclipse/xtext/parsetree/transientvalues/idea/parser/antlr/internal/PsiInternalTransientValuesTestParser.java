package org.eclipse.xtext.parsetree.transientvalues.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.transientvalues.idea.lang.TransientValuesTestElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:50:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:50:14: ( ruleRoot EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:51:2: ruleRoot EOF
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:59:9: ( (otherlv_0= 'test' ( ruleTestRequired | ruleTestOptional | ruleTestList ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:60:2: (otherlv_0= 'test' ( ruleTestRequired | ruleTestOptional | ruleTestList ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:60:2: (otherlv_0= 'test' ( ruleTestRequired | ruleTestOptional | ruleTestList ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:61:3: otherlv_0= 'test' ( ruleTestRequired | ruleTestOptional | ruleTestList )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleRoot83); 

            			doneLeaf(otherlv_0, elementTypeProvider.getRoot_TestKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:68:3: ( ruleTestRequired | ruleTestOptional | ruleTestList )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:69:4: ruleTestRequired
                    {

                    				markComposite(elementTypeProvider.getRoot_TestRequiredParserRuleCall_1_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleTestRequired_in_ruleRoot101);
                    ruleTestRequired();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:77:4: ruleTestOptional
                    {

                    				markComposite(elementTypeProvider.getRoot_TestOptionalParserRuleCall_1_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleTestOptional_in_ruleRoot125);
                    ruleTestOptional();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:85:4: ruleTestList
                    {

                    				markComposite(elementTypeProvider.getRoot_TestListParserRuleCall_1_2ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleTestList_in_ruleRoot149);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:97:1: entryRuleTestRequired : ruleTestRequired EOF ;
    public final void entryRuleTestRequired() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:97:22: ( ruleTestRequired EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:98:2: ruleTestRequired EOF
            {
             markComposite(elementTypeProvider.getTestRequiredElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTestRequired_in_entryRuleTestRequired174);
            ruleTestRequired();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestRequired180); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:106:1: ruleTestRequired : ( () otherlv_1= 'required' ( (lv_required1_2_0= RULE_INT ) ) ( (lv_required2_3_0= RULE_INT ) ) ) ;
    public final void ruleTestRequired() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_required1_2_0=null;
        Token lv_required2_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:106:17: ( ( () otherlv_1= 'required' ( (lv_required1_2_0= RULE_INT ) ) ( (lv_required2_3_0= RULE_INT ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:107:2: ( () otherlv_1= 'required' ( (lv_required1_2_0= RULE_INT ) ) ( (lv_required2_3_0= RULE_INT ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:107:2: ( () otherlv_1= 'required' ( (lv_required1_2_0= RULE_INT ) ) ( (lv_required2_3_0= RULE_INT ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:108:3: () otherlv_1= 'required' ( (lv_required1_2_0= RULE_INT ) ) ( (lv_required2_3_0= RULE_INT ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:108:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:109:4: 
            {

            				precedeComposite(elementTypeProvider.getTestRequired_TestRequiredAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleTestRequired216); 

            			doneLeaf(otherlv_1, elementTypeProvider.getTestRequired_RequiredKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:121:3: ( (lv_required1_2_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:122:4: (lv_required1_2_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:122:4: (lv_required1_2_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:123:5: lv_required1_2_0= RULE_INT
            {

            					markLeaf();
            				
            lv_required1_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTestRequired243); 

            					doneLeaf(lv_required1_2_0, elementTypeProvider.getTestRequired_Required1INTTerminalRuleCall_2_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:132:3: ( (lv_required2_3_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:133:4: (lv_required2_3_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:133:4: (lv_required2_3_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:134:5: lv_required2_3_0= RULE_INT
            {

            					markLeaf();
            				
            lv_required2_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTestRequired281); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:147:1: entryRuleTestOptional : ruleTestOptional EOF ;
    public final void entryRuleTestOptional() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:147:22: ( ruleTestOptional EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:148:2: ruleTestOptional EOF
            {
             markComposite(elementTypeProvider.getTestOptionalElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTestOptional_in_entryRuleTestOptional312);
            ruleTestOptional();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestOptional318); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:156:1: ruleTestOptional : ( () otherlv_1= 'optional' ( (lv_opt1_2_0= RULE_INT ) )? (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )? ) ;
    public final void ruleTestOptional() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_opt1_2_0=null;
        Token otherlv_3=null;
        Token lv_opt2_4_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:156:17: ( ( () otherlv_1= 'optional' ( (lv_opt1_2_0= RULE_INT ) )? (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:157:2: ( () otherlv_1= 'optional' ( (lv_opt1_2_0= RULE_INT ) )? (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:157:2: ( () otherlv_1= 'optional' ( (lv_opt1_2_0= RULE_INT ) )? (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:158:3: () otherlv_1= 'optional' ( (lv_opt1_2_0= RULE_INT ) )? (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:158:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:159:4: 
            {

            				precedeComposite(elementTypeProvider.getTestOptional_TestOptionalAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleTestOptional354); 

            			doneLeaf(otherlv_1, elementTypeProvider.getTestOptional_OptionalKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:171:3: ( (lv_opt1_2_0= RULE_INT ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_INT) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:172:4: (lv_opt1_2_0= RULE_INT )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:172:4: (lv_opt1_2_0= RULE_INT )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:173:5: lv_opt1_2_0= RULE_INT
                    {

                    					markLeaf();
                    				
                    lv_opt1_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTestOptional381); 

                    					doneLeaf(lv_opt1_2_0, elementTypeProvider.getTestOptional_Opt1INTTerminalRuleCall_2_0ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:182:3: (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:183:4: otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) )
                    {

                    				markLeaf();
                    			
                    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleTestOptional413); 

                    				doneLeaf(otherlv_3, elementTypeProvider.getTestOptional_ColonKeyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:190:4: ( (lv_opt2_4_0= RULE_INT ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:191:5: (lv_opt2_4_0= RULE_INT )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:191:5: (lv_opt2_4_0= RULE_INT )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:192:6: lv_opt2_4_0= RULE_INT
                    {

                    						markLeaf();
                    					
                    lv_opt2_4_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTestOptional445); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:206:1: entryRuleTestList : ruleTestList EOF ;
    public final void entryRuleTestList() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:206:18: ( ruleTestList EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:207:2: ruleTestList EOF
            {
             markComposite(elementTypeProvider.getTestListElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTestList_in_entryRuleTestList484);
            ruleTestList();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestList490); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:215:1: ruleTestList : ( () otherlv_1= 'list' ( (lv_item_2_0= RULE_INT ) )* ) ;
    public final void ruleTestList() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_item_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:215:13: ( ( () otherlv_1= 'list' ( (lv_item_2_0= RULE_INT ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:216:2: ( () otherlv_1= 'list' ( (lv_item_2_0= RULE_INT ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:216:2: ( () otherlv_1= 'list' ( (lv_item_2_0= RULE_INT ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:217:3: () otherlv_1= 'list' ( (lv_item_2_0= RULE_INT ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:217:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:218:4: 
            {

            				precedeComposite(elementTypeProvider.getTestList_TestListAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleTestList526); 

            			doneLeaf(otherlv_1, elementTypeProvider.getTestList_ListKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:230:3: ( (lv_item_2_0= RULE_INT ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_INT) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:231:4: (lv_item_2_0= RULE_INT )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:231:4: (lv_item_2_0= RULE_INT )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/idea/parser/antlr/internal/PsiInternalTransientValuesTest.g:232:5: lv_item_2_0= RULE_INT
            	    {

            	    					markLeaf();
            	    				
            	    lv_item_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTestList553); 

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
        public static final BitSet FOLLOW_11_in_ruleRoot83 = new BitSet(new long[]{0x000000000000B000L});
        public static final BitSet FOLLOW_ruleTestRequired_in_ruleRoot101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestOptional_in_ruleRoot125 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestList_in_ruleRoot149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestRequired_in_entryRuleTestRequired174 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestRequired180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleTestRequired216 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTestRequired243 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTestRequired281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestOptional_in_entryRuleTestOptional312 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestOptional318 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleTestOptional354 = new BitSet(new long[]{0x0000000000004012L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTestOptional381 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleTestOptional413 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTestOptional445 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestList_in_entryRuleTestList484 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestList490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleTestList526 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTestList553 = new BitSet(new long[]{0x0000000000000012L});
    }


}