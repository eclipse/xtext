package org.eclipse.xtext.grammarinheritance.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.grammarinheritance.idea.lang.ConcreteTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalConcreteTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_REAL", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'model'", "':'", "'overriddenelement'", "'overridden other element'", "'-'", "'subrule1'", "'subrule3'", "'element'", "'overridemodel'", "'extendedmodel'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__19=19;
    public static final int RULE_STRING=7;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_REAL=4;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public PsiInternalConcreteTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalConcreteTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalConcreteTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g"; }



    	protected ConcreteTestLanguageGrammarAccess grammarAccess;

    	protected ConcreteTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalConcreteTestLanguageParser(PsiBuilder builder, TokenStream input, ConcreteTestLanguageElementTypeProvider elementTypeProvider, ConcreteTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "RootRule";
    	}




    // $ANTLR start "entryRuleRootRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:52:1: entryRuleRootRule : ruleRootRule EOF ;
    public final void entryRuleRootRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:52:18: ( ruleRootRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:53:2: ruleRootRule EOF
            {
             markComposite(elementTypeProvider.getRootRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRootRule_in_entryRuleRootRule54);
            ruleRootRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRootRule60); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRootRule"


    // $ANTLR start "ruleRootRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:59:1: ruleRootRule : ( ruleConcreteParserRule | ruleCallOverridenParserRule | ruleCallExtendedParserRule | ruleOverridableParserRule2 ) ;
    public final void ruleRootRule() throws RecognitionException {


        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:62:2: ( ( ruleConcreteParserRule | ruleCallOverridenParserRule | ruleCallExtendedParserRule | ruleOverridableParserRule2 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:63:2: ( ruleConcreteParserRule | ruleCallOverridenParserRule | ruleCallExtendedParserRule | ruleOverridableParserRule2 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:63:2: ( ruleConcreteParserRule | ruleCallOverridenParserRule | ruleCallExtendedParserRule | ruleOverridableParserRule2 )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt1=1;
                }
                break;
            case 20:
                {
                alt1=2;
                }
                break;
            case 21:
                {
                alt1=3;
                }
                break;
            case 15:
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:64:3: ruleConcreteParserRule
                    {

                    			markComposite(elementTypeProvider.getRootRule_ConcreteParserRuleParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleConcreteParserRule_in_ruleRootRule86);
                    ruleConcreteParserRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:72:3: ruleCallOverridenParserRule
                    {

                    			markComposite(elementTypeProvider.getRootRule_CallOverridenParserRuleParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleCallOverridenParserRule_in_ruleRootRule106);
                    ruleCallOverridenParserRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:80:3: ruleCallExtendedParserRule
                    {

                    			markComposite(elementTypeProvider.getRootRule_CallExtendedParserRuleParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleCallExtendedParserRule_in_ruleRootRule126);
                    ruleCallExtendedParserRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:88:3: ruleOverridableParserRule2
                    {

                    			markComposite(elementTypeProvider.getRootRule_OverridableParserRule2ParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleOverridableParserRule2_in_ruleRootRule146);
                    ruleOverridableParserRule2();

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
    // $ANTLR end "ruleRootRule"


    // $ANTLR start "entryRuleConcreteParserRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:99:1: entryRuleConcreteParserRule : ruleConcreteParserRule EOF ;
    public final void entryRuleConcreteParserRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:99:28: ( ruleConcreteParserRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:100:2: ruleConcreteParserRule EOF
            {
             markComposite(elementTypeProvider.getConcreteParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleConcreteParserRule_in_entryRuleConcreteParserRule166);
            ruleConcreteParserRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcreteParserRule172); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConcreteParserRule"


    // $ANTLR start "ruleConcreteParserRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:106:1: ruleConcreteParserRule : (otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )* ) ;
    public final void ruleConcreteParserRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_magicNumber_1_0=null;
        Token otherlv_2=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:109:2: ( (otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:110:2: (otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:110:2: (otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:111:3: otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleConcreteParserRule200); 

            			doneLeaf(otherlv_0, elementTypeProvider.getConcreteParserRule_ModelKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:118:3: ( (lv_magicNumber_1_0= RULE_REAL ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:119:4: (lv_magicNumber_1_0= RULE_REAL )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:119:4: (lv_magicNumber_1_0= RULE_REAL )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:120:5: lv_magicNumber_1_0= RULE_REAL
            {

            					markLeaf();
            				
            lv_magicNumber_1_0=(Token)match(input,RULE_REAL,FollowSets000.FOLLOW_RULE_REAL_in_ruleConcreteParserRule227); 

            					doneLeaf(lv_magicNumber_1_0, elementTypeProvider.getConcreteParserRule_MagicNumberREALTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleConcreteParserRule252); 

            			doneLeaf(otherlv_2, elementTypeProvider.getConcreteParserRule_ColonKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:136:3: ( (lv_elements_3_0= ruleInheritedParserRule ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==19) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:137:4: (lv_elements_3_0= ruleInheritedParserRule )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:137:4: (lv_elements_3_0= ruleInheritedParserRule )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:138:5: lv_elements_3_0= ruleInheritedParserRule
            	    {

            	    					markComposite(elementTypeProvider.getConcreteParserRule_ElementsInheritedParserRuleParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleInheritedParserRule_in_ruleConcreteParserRule279);
            	    ruleInheritedParserRule();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "ruleConcreteParserRule"


    // $ANTLR start "entryRuleOverridableParserRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:151:1: entryRuleOverridableParserRule : ruleOverridableParserRule EOF ;
    public final void entryRuleOverridableParserRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:151:31: ( ruleOverridableParserRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:152:2: ruleOverridableParserRule EOF
            {
             markComposite(elementTypeProvider.getOverridableParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleOverridableParserRule_in_entryRuleOverridableParserRule311);
            ruleOverridableParserRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOverridableParserRule317); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOverridableParserRule"


    // $ANTLR start "ruleOverridableParserRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:158:1: ruleOverridableParserRule : (otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleOverridableParserRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:161:2: ( (otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:162:2: (otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:162:2: (otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:163:3: otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleOverridableParserRule345); 

            			doneLeaf(otherlv_0, elementTypeProvider.getOverridableParserRule_OverriddenelementKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:170:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:171:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:171:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:172:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOverridableParserRule372); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getOverridableParserRule_NameIDTerminalRuleCall_1_0ElementType());
            				

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
    // $ANTLR end "ruleOverridableParserRule"


    // $ANTLR start "entryRuleCallOverridenParserRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:185:1: entryRuleCallOverridenParserRule : ruleCallOverridenParserRule EOF ;
    public final void entryRuleCallOverridenParserRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:185:33: ( ruleCallOverridenParserRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:186:2: ruleCallOverridenParserRule EOF
            {
             markComposite(elementTypeProvider.getCallOverridenParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCallOverridenParserRule_in_entryRuleCallOverridenParserRule403);
            ruleCallOverridenParserRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCallOverridenParserRule409); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCallOverridenParserRule"


    // $ANTLR start "ruleCallOverridenParserRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:192:1: ruleCallOverridenParserRule : ( (lv_call_0_0= ruleAbstractCallOverridenParserRule ) ) ;
    public final void ruleCallOverridenParserRule() throws RecognitionException {


        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:195:2: ( ( (lv_call_0_0= ruleAbstractCallOverridenParserRule ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:196:2: ( (lv_call_0_0= ruleAbstractCallOverridenParserRule ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:196:2: ( (lv_call_0_0= ruleAbstractCallOverridenParserRule ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:197:3: (lv_call_0_0= ruleAbstractCallOverridenParserRule )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:197:3: (lv_call_0_0= ruleAbstractCallOverridenParserRule )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:198:4: lv_call_0_0= ruleAbstractCallOverridenParserRule
            {

            				markComposite(elementTypeProvider.getCallOverridenParserRule_CallAbstractCallOverridenParserRuleParserRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_ruleAbstractCallOverridenParserRule_in_ruleCallOverridenParserRule443);
            ruleAbstractCallOverridenParserRule();

            state._fsp--;


            				doneComposite();
            			

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
    // $ANTLR end "ruleCallOverridenParserRule"


    // $ANTLR start "entryRuleOverridableParserRule2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:210:1: entryRuleOverridableParserRule2 : ruleOverridableParserRule2 EOF ;
    public final void entryRuleOverridableParserRule2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:210:32: ( ruleOverridableParserRule2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:211:2: ruleOverridableParserRule2 EOF
            {
             markComposite(elementTypeProvider.getOverridableParserRule2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleOverridableParserRule2_in_entryRuleOverridableParserRule2468);
            ruleOverridableParserRule2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOverridableParserRule2474); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOverridableParserRule2"


    // $ANTLR start "ruleOverridableParserRule2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:217:1: ruleOverridableParserRule2 : (otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) ) ) ;
    public final void ruleOverridableParserRule2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_age_3_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:220:2: ( (otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:221:2: (otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:221:2: (otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:222:3: otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOverridableParserRule2502); 

            			doneLeaf(otherlv_0, elementTypeProvider.getOverridableParserRule2_OverriddenOtherElementKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:229:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:230:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:230:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:231:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOverridableParserRule2529); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getOverridableParserRule2_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleOverridableParserRule2554); 

            			doneLeaf(otherlv_2, elementTypeProvider.getOverridableParserRule2_HyphenMinusKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:247:3: ( (lv_age_3_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:248:4: (lv_age_3_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:248:4: (lv_age_3_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:249:5: lv_age_3_0= RULE_INT
            {

            					markLeaf();
            				
            lv_age_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleOverridableParserRule2581); 

            					doneLeaf(lv_age_3_0, elementTypeProvider.getOverridableParserRule2_AgeINTTerminalRuleCall_3_0ElementType());
            				

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
    // $ANTLR end "ruleOverridableParserRule2"


    // $ANTLR start "entryRuleExtendableParserRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:262:1: entryRuleExtendableParserRule : ruleExtendableParserRule EOF ;
    public final void entryRuleExtendableParserRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:262:30: ( ruleExtendableParserRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:263:2: ruleExtendableParserRule EOF
            {
             markComposite(elementTypeProvider.getExtendableParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleExtendableParserRule_in_entryRuleExtendableParserRule612);
            ruleExtendableParserRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExtendableParserRule618); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExtendableParserRule"


    // $ANTLR start "ruleExtendableParserRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:269:1: ruleExtendableParserRule : ( ruleSubrule1 | ruleSubrule2 | ruleSubrule3 ) ;
    public final void ruleExtendableParserRule() throws RecognitionException {


        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:272:2: ( ( ruleSubrule1 | ruleSubrule2 | ruleSubrule3 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:273:2: ( ruleSubrule1 | ruleSubrule2 | ruleSubrule3 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:273:2: ( ruleSubrule1 | ruleSubrule2 | ruleSubrule3 )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==17) ) {
                alt3=1;
            }
            else if ( (LA3_0==18) ) {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==RULE_ID) ) {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==RULE_INT) ) {
                        alt3=3;
                    }
                    else if ( (LA3_3==RULE_STRING) ) {
                        alt3=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:274:3: ruleSubrule1
                    {

                    			markComposite(elementTypeProvider.getExtendableParserRule_Subrule1ParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleSubrule1_in_ruleExtendableParserRule644);
                    ruleSubrule1();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:282:3: ruleSubrule2
                    {

                    			markComposite(elementTypeProvider.getExtendableParserRule_Subrule2ParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleSubrule2_in_ruleExtendableParserRule664);
                    ruleSubrule2();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:290:3: ruleSubrule3
                    {

                    			markComposite(elementTypeProvider.getExtendableParserRule_Subrule3ParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleSubrule3_in_ruleExtendableParserRule684);
                    ruleSubrule3();

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
    // $ANTLR end "ruleExtendableParserRule"


    // $ANTLR start "entryRuleSubrule1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:301:1: entryRuleSubrule1 : ruleSubrule1 EOF ;
    public final void entryRuleSubrule1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:301:18: ( ruleSubrule1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:302:2: ruleSubrule1 EOF
            {
             markComposite(elementTypeProvider.getSubrule1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubrule1_in_entryRuleSubrule1704);
            ruleSubrule1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubrule1710); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSubrule1"


    // $ANTLR start "ruleSubrule1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:308:1: ruleSubrule1 : (otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) ) ) ;
    public final void ruleSubrule1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_sub1_2_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:311:2: ( (otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:312:2: (otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:312:2: (otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:313:3: otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSubrule1738); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSubrule1_Subrule1Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:320:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:321:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:321:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:322:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSubrule1765); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getSubrule1_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:331:3: ( (lv_sub1_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:332:4: (lv_sub1_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:332:4: (lv_sub1_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:333:5: lv_sub1_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_sub1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSubrule1803); 

            					doneLeaf(lv_sub1_2_0, elementTypeProvider.getSubrule1_Sub1IDTerminalRuleCall_2_0ElementType());
            				

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
    // $ANTLR end "ruleSubrule1"


    // $ANTLR start "entryRuleSubrule2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:346:1: entryRuleSubrule2 : ruleSubrule2 EOF ;
    public final void entryRuleSubrule2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:346:18: ( ruleSubrule2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:347:2: ruleSubrule2 EOF
            {
             markComposite(elementTypeProvider.getSubrule2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubrule2_in_entryRuleSubrule2834);
            ruleSubrule2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubrule2840); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSubrule2"


    // $ANTLR start "ruleSubrule2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:353:1: ruleSubrule2 : (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) ) ) ;
    public final void ruleSubrule2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_sub2_2_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:356:2: ( (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:357:2: (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:357:2: (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:358:3: otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSubrule2868); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSubrule2_Subrule3Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:365:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:366:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:366:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:367:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSubrule2895); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getSubrule2_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:376:3: ( (lv_sub2_2_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:377:4: (lv_sub2_2_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:377:4: (lv_sub2_2_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:378:5: lv_sub2_2_0= RULE_STRING
            {

            					markLeaf();
            				
            lv_sub2_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSubrule2933); 

            					doneLeaf(lv_sub2_2_0, elementTypeProvider.getSubrule2_Sub2STRINGTerminalRuleCall_2_0ElementType());
            				

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
    // $ANTLR end "ruleSubrule2"


    // $ANTLR start "entryRuleSubrule3"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:391:1: entryRuleSubrule3 : ruleSubrule3 EOF ;
    public final void entryRuleSubrule3() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:391:18: ( ruleSubrule3 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:392:2: ruleSubrule3 EOF
            {
             markComposite(elementTypeProvider.getSubrule3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubrule3_in_entryRuleSubrule3964);
            ruleSubrule3();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubrule3970); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSubrule3"


    // $ANTLR start "ruleSubrule3"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:398:1: ruleSubrule3 : (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) ) ) ;
    public final void ruleSubrule3() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_sub1_2_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:401:2: ( (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:402:2: (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:402:2: (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:403:3: otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSubrule3998); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSubrule3_Subrule3Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:410:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:411:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:411:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:412:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSubrule31025); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getSubrule3_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:421:3: ( (lv_sub1_2_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:422:4: (lv_sub1_2_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:422:4: (lv_sub1_2_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:423:5: lv_sub1_2_0= RULE_INT
            {

            					markLeaf();
            				
            lv_sub1_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleSubrule31063); 

            					doneLeaf(lv_sub1_2_0, elementTypeProvider.getSubrule3_Sub1INTTerminalRuleCall_2_0ElementType());
            				

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
    // $ANTLR end "ruleSubrule3"


    // $ANTLR start "entryRuleCallExtendedParserRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:436:1: entryRuleCallExtendedParserRule : ruleCallExtendedParserRule EOF ;
    public final void entryRuleCallExtendedParserRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:436:32: ( ruleCallExtendedParserRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:437:2: ruleCallExtendedParserRule EOF
            {
             markComposite(elementTypeProvider.getCallExtendedParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCallExtendedParserRule_in_entryRuleCallExtendedParserRule1094);
            ruleCallExtendedParserRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCallExtendedParserRule1100); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCallExtendedParserRule"


    // $ANTLR start "ruleCallExtendedParserRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:443:1: ruleCallExtendedParserRule : ( (lv_call_0_0= ruleAbstractCallExtendedParserRule ) ) ;
    public final void ruleCallExtendedParserRule() throws RecognitionException {


        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:446:2: ( ( (lv_call_0_0= ruleAbstractCallExtendedParserRule ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:447:2: ( (lv_call_0_0= ruleAbstractCallExtendedParserRule ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:447:2: ( (lv_call_0_0= ruleAbstractCallExtendedParserRule ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:448:3: (lv_call_0_0= ruleAbstractCallExtendedParserRule )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:448:3: (lv_call_0_0= ruleAbstractCallExtendedParserRule )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:449:4: lv_call_0_0= ruleAbstractCallExtendedParserRule
            {

            				markComposite(elementTypeProvider.getCallExtendedParserRule_CallAbstractCallExtendedParserRuleParserRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_ruleAbstractCallExtendedParserRule_in_ruleCallExtendedParserRule1134);
            ruleAbstractCallExtendedParserRule();

            state._fsp--;


            				doneComposite();
            			

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
    // $ANTLR end "ruleCallExtendedParserRule"


    // $ANTLR start "entryRuleInheritedParserRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:461:1: entryRuleInheritedParserRule : ruleInheritedParserRule EOF ;
    public final void entryRuleInheritedParserRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:461:29: ( ruleInheritedParserRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:462:2: ruleInheritedParserRule EOF
            {
             markComposite(elementTypeProvider.getInheritedParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule1159);
            ruleInheritedParserRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInheritedParserRule1165); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInheritedParserRule"


    // $ANTLR start "ruleInheritedParserRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:468:1: ruleInheritedParserRule : (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleInheritedParserRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:471:2: ( (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:472:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:472:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:473:3: otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleInheritedParserRule1193); 

            			doneLeaf(otherlv_0, elementTypeProvider.getInheritedParserRule_ElementKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:480:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:481:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:481:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:482:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleInheritedParserRule1220); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getInheritedParserRule_NameIDTerminalRuleCall_1_0ElementType());
            				

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
    // $ANTLR end "ruleInheritedParserRule"


    // $ANTLR start "entryRuleAbstractCallOverridenParserRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:495:1: entryRuleAbstractCallOverridenParserRule : ruleAbstractCallOverridenParserRule EOF ;
    public final void entryRuleAbstractCallOverridenParserRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:495:41: ( ruleAbstractCallOverridenParserRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:496:2: ruleAbstractCallOverridenParserRule EOF
            {
             markComposite(elementTypeProvider.getAbstractCallOverridenParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractCallOverridenParserRule_in_entryRuleAbstractCallOverridenParserRule1251);
            ruleAbstractCallOverridenParserRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractCallOverridenParserRule1257); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAbstractCallOverridenParserRule"


    // $ANTLR start "ruleAbstractCallOverridenParserRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:502:1: ruleAbstractCallOverridenParserRule : (otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )* ) ;
    public final void ruleAbstractCallOverridenParserRule() throws RecognitionException {
        Token otherlv_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:505:2: ( (otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:506:2: (otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:506:2: (otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:507:3: otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAbstractCallOverridenParserRule1285); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAbstractCallOverridenParserRule_OverridemodelKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:514:3: ( (lv_elements_1_0= ruleOverridableParserRule ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:515:4: (lv_elements_1_0= ruleOverridableParserRule )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:515:4: (lv_elements_1_0= ruleOverridableParserRule )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:516:5: lv_elements_1_0= ruleOverridableParserRule
            	    {

            	    					markComposite(elementTypeProvider.getAbstractCallOverridenParserRule_ElementsOverridableParserRuleParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleOverridableParserRule_in_ruleAbstractCallOverridenParserRule1312);
            	    ruleOverridableParserRule();

            	    state._fsp--;


            	    					doneComposite();
            	    				

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
    // $ANTLR end "ruleAbstractCallOverridenParserRule"


    // $ANTLR start "entryRuleAbstractCallExtendedParserRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:529:1: entryRuleAbstractCallExtendedParserRule : ruleAbstractCallExtendedParserRule EOF ;
    public final void entryRuleAbstractCallExtendedParserRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:529:40: ( ruleAbstractCallExtendedParserRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:530:2: ruleAbstractCallExtendedParserRule EOF
            {
             markComposite(elementTypeProvider.getAbstractCallExtendedParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractCallExtendedParserRule_in_entryRuleAbstractCallExtendedParserRule1344);
            ruleAbstractCallExtendedParserRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractCallExtendedParserRule1350); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAbstractCallExtendedParserRule"


    // $ANTLR start "ruleAbstractCallExtendedParserRule"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:536:1: ruleAbstractCallExtendedParserRule : (otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )* ) ;
    public final void ruleAbstractCallExtendedParserRule() throws RecognitionException {
        Token otherlv_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:539:2: ( (otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:540:2: (otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:540:2: (otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:541:3: otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAbstractCallExtendedParserRule1378); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAbstractCallExtendedParserRule_ExtendedmodelKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:548:3: ( (lv_elements_1_0= ruleExtendableParserRule ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=17 && LA5_0<=18)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:549:4: (lv_elements_1_0= ruleExtendableParserRule )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:549:4: (lv_elements_1_0= ruleExtendableParserRule )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:550:5: lv_elements_1_0= ruleExtendableParserRule
            	    {

            	    					markComposite(elementTypeProvider.getAbstractCallExtendedParserRule_ElementsExtendableParserRuleParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleExtendableParserRule_in_ruleAbstractCallExtendedParserRule1405);
            	    ruleExtendableParserRule();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // $ANTLR end "ruleAbstractCallExtendedParserRule"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRootRule_in_entryRuleRootRule54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRootRule60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcreteParserRule_in_ruleRootRule86 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallOverridenParserRule_in_ruleRootRule106 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallExtendedParserRule_in_ruleRootRule126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOverridableParserRule2_in_ruleRootRule146 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcreteParserRule_in_entryRuleConcreteParserRule166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcreteParserRule172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleConcreteParserRule200 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_REAL_in_ruleConcreteParserRule227 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleConcreteParserRule252 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_ruleInheritedParserRule_in_ruleConcreteParserRule279 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_ruleOverridableParserRule_in_entryRuleOverridableParserRule311 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOverridableParserRule317 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleOverridableParserRule345 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOverridableParserRule372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallOverridenParserRule_in_entryRuleCallOverridenParserRule403 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCallOverridenParserRule409 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractCallOverridenParserRule_in_ruleCallOverridenParserRule443 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOverridableParserRule2_in_entryRuleOverridableParserRule2468 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOverridableParserRule2474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleOverridableParserRule2502 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOverridableParserRule2529 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleOverridableParserRule2554 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleOverridableParserRule2581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExtendableParserRule_in_entryRuleExtendableParserRule612 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExtendableParserRule618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubrule1_in_ruleExtendableParserRule644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubrule2_in_ruleExtendableParserRule664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubrule3_in_ruleExtendableParserRule684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubrule1_in_entryRuleSubrule1704 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubrule1710 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleSubrule1738 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule1765 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule1803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubrule2_in_entryRuleSubrule2834 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubrule2840 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleSubrule2868 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule2895 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSubrule2933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubrule3_in_entryRuleSubrule3964 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubrule3970 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleSubrule3998 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule31025 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleSubrule31063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallExtendedParserRule_in_entryRuleCallExtendedParserRule1094 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCallExtendedParserRule1100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractCallExtendedParserRule_in_ruleCallExtendedParserRule1134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule1159 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInheritedParserRule1165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleInheritedParserRule1193 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleInheritedParserRule1220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractCallOverridenParserRule_in_entryRuleAbstractCallOverridenParserRule1251 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractCallOverridenParserRule1257 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleAbstractCallOverridenParserRule1285 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_ruleOverridableParserRule_in_ruleAbstractCallOverridenParserRule1312 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_ruleAbstractCallExtendedParserRule_in_entryRuleAbstractCallExtendedParserRule1344 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractCallExtendedParserRule1350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleAbstractCallExtendedParserRule1378 = new BitSet(new long[]{0x0000000000060002L});
        public static final BitSet FOLLOW_ruleExtendableParserRule_in_ruleAbstractCallExtendedParserRule1405 = new BitSet(new long[]{0x0000000000060002L});
    }


}