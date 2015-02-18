package org.eclipse.xtext.grammarinheritance.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.grammarinheritance.idea.lang.ConcreteTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:50:1: entryRuleRootRule : ruleRootRule EOF ;
    public final void entryRuleRootRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:50:18: ( ruleRootRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:51:2: ruleRootRule EOF
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:59:13: ( ( ruleConcreteParserRule | ruleCallOverridenParserRule | ruleCallExtendedParserRule | ruleOverridableParserRule2 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:60:2: ( ruleConcreteParserRule | ruleCallOverridenParserRule | ruleCallExtendedParserRule | ruleOverridableParserRule2 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:60:2: ( ruleConcreteParserRule | ruleCallOverridenParserRule | ruleCallExtendedParserRule | ruleOverridableParserRule2 )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:61:3: ruleConcreteParserRule
                    {

                    			markComposite(elementTypeProvider.getRootRule_ConcreteParserRuleParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleConcreteParserRule_in_ruleRootRule81);
                    ruleConcreteParserRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:69:3: ruleCallOverridenParserRule
                    {

                    			markComposite(elementTypeProvider.getRootRule_CallOverridenParserRuleParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleCallOverridenParserRule_in_ruleRootRule101);
                    ruleCallOverridenParserRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:77:3: ruleCallExtendedParserRule
                    {

                    			markComposite(elementTypeProvider.getRootRule_CallExtendedParserRuleParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleCallExtendedParserRule_in_ruleRootRule121);
                    ruleCallExtendedParserRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:85:3: ruleOverridableParserRule2
                    {

                    			markComposite(elementTypeProvider.getRootRule_OverridableParserRule2ParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleOverridableParserRule2_in_ruleRootRule141);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:96:1: entryRuleConcreteParserRule : ruleConcreteParserRule EOF ;
    public final void entryRuleConcreteParserRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:96:28: ( ruleConcreteParserRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:97:2: ruleConcreteParserRule EOF
            {
             markComposite(elementTypeProvider.getConcreteParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleConcreteParserRule_in_entryRuleConcreteParserRule161);
            ruleConcreteParserRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcreteParserRule167); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:105:1: ruleConcreteParserRule : (otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )* ) ;
    public final void ruleConcreteParserRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_magicNumber_1_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:105:23: ( (otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:106:2: (otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:106:2: (otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:107:3: otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleConcreteParserRule190); 

            			doneLeaf(otherlv_0, elementTypeProvider.getConcreteParserRule_ModelKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:114:3: ( (lv_magicNumber_1_0= RULE_REAL ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:115:4: (lv_magicNumber_1_0= RULE_REAL )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:115:4: (lv_magicNumber_1_0= RULE_REAL )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:116:5: lv_magicNumber_1_0= RULE_REAL
            {

            					markLeaf();
            				
            lv_magicNumber_1_0=(Token)match(input,RULE_REAL,FollowSets000.FOLLOW_RULE_REAL_in_ruleConcreteParserRule217); 

            					doneLeaf(lv_magicNumber_1_0, elementTypeProvider.getConcreteParserRule_MagicNumberREALTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleConcreteParserRule242); 

            			doneLeaf(otherlv_2, elementTypeProvider.getConcreteParserRule_ColonKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:132:3: ( (lv_elements_3_0= ruleInheritedParserRule ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==19) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:133:4: (lv_elements_3_0= ruleInheritedParserRule )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:133:4: (lv_elements_3_0= ruleInheritedParserRule )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:134:5: lv_elements_3_0= ruleInheritedParserRule
            	    {

            	    					markComposite(elementTypeProvider.getConcreteParserRule_ElementsInheritedParserRuleParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleInheritedParserRule_in_ruleConcreteParserRule269);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:147:1: entryRuleOverridableParserRule : ruleOverridableParserRule EOF ;
    public final void entryRuleOverridableParserRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:147:31: ( ruleOverridableParserRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:148:2: ruleOverridableParserRule EOF
            {
             markComposite(elementTypeProvider.getOverridableParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleOverridableParserRule_in_entryRuleOverridableParserRule301);
            ruleOverridableParserRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOverridableParserRule307); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:156:1: ruleOverridableParserRule : (otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleOverridableParserRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:156:26: ( (otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:157:2: (otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:157:2: (otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:158:3: otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleOverridableParserRule330); 

            			doneLeaf(otherlv_0, elementTypeProvider.getOverridableParserRule_OverriddenelementKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:165:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:166:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:166:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:167:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOverridableParserRule357); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:180:1: entryRuleCallOverridenParserRule : ruleCallOverridenParserRule EOF ;
    public final void entryRuleCallOverridenParserRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:180:33: ( ruleCallOverridenParserRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:181:2: ruleCallOverridenParserRule EOF
            {
             markComposite(elementTypeProvider.getCallOverridenParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCallOverridenParserRule_in_entryRuleCallOverridenParserRule388);
            ruleCallOverridenParserRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCallOverridenParserRule394); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:189:1: ruleCallOverridenParserRule : ( (lv_call_0_0= ruleAbstractCallOverridenParserRule ) ) ;
    public final void ruleCallOverridenParserRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:189:28: ( ( (lv_call_0_0= ruleAbstractCallOverridenParserRule ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:190:2: ( (lv_call_0_0= ruleAbstractCallOverridenParserRule ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:190:2: ( (lv_call_0_0= ruleAbstractCallOverridenParserRule ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:191:3: (lv_call_0_0= ruleAbstractCallOverridenParserRule )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:191:3: (lv_call_0_0= ruleAbstractCallOverridenParserRule )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:192:4: lv_call_0_0= ruleAbstractCallOverridenParserRule
            {

            				markComposite(elementTypeProvider.getCallOverridenParserRule_CallAbstractCallOverridenParserRuleParserRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_ruleAbstractCallOverridenParserRule_in_ruleCallOverridenParserRule423);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:204:1: entryRuleOverridableParserRule2 : ruleOverridableParserRule2 EOF ;
    public final void entryRuleOverridableParserRule2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:204:32: ( ruleOverridableParserRule2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:205:2: ruleOverridableParserRule2 EOF
            {
             markComposite(elementTypeProvider.getOverridableParserRule2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleOverridableParserRule2_in_entryRuleOverridableParserRule2448);
            ruleOverridableParserRule2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOverridableParserRule2454); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:213:1: ruleOverridableParserRule2 : (otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) ) ) ;
    public final void ruleOverridableParserRule2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_age_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:213:27: ( (otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:214:2: (otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:214:2: (otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:215:3: otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOverridableParserRule2477); 

            			doneLeaf(otherlv_0, elementTypeProvider.getOverridableParserRule2_OverriddenOtherElementKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:222:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:223:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:223:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:224:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOverridableParserRule2504); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getOverridableParserRule2_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleOverridableParserRule2529); 

            			doneLeaf(otherlv_2, elementTypeProvider.getOverridableParserRule2_HyphenMinusKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:240:3: ( (lv_age_3_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:241:4: (lv_age_3_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:241:4: (lv_age_3_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:242:5: lv_age_3_0= RULE_INT
            {

            					markLeaf();
            				
            lv_age_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleOverridableParserRule2556); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:255:1: entryRuleExtendableParserRule : ruleExtendableParserRule EOF ;
    public final void entryRuleExtendableParserRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:255:30: ( ruleExtendableParserRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:256:2: ruleExtendableParserRule EOF
            {
             markComposite(elementTypeProvider.getExtendableParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleExtendableParserRule_in_entryRuleExtendableParserRule587);
            ruleExtendableParserRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExtendableParserRule593); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:264:1: ruleExtendableParserRule : ( ruleSubrule1 | ruleSubrule2 | ruleSubrule3 ) ;
    public final void ruleExtendableParserRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:264:25: ( ( ruleSubrule1 | ruleSubrule2 | ruleSubrule3 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:265:2: ( ruleSubrule1 | ruleSubrule2 | ruleSubrule3 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:265:2: ( ruleSubrule1 | ruleSubrule2 | ruleSubrule3 )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:266:3: ruleSubrule1
                    {

                    			markComposite(elementTypeProvider.getExtendableParserRule_Subrule1ParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleSubrule1_in_ruleExtendableParserRule614);
                    ruleSubrule1();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:274:3: ruleSubrule2
                    {

                    			markComposite(elementTypeProvider.getExtendableParserRule_Subrule2ParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleSubrule2_in_ruleExtendableParserRule634);
                    ruleSubrule2();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:282:3: ruleSubrule3
                    {

                    			markComposite(elementTypeProvider.getExtendableParserRule_Subrule3ParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleSubrule3_in_ruleExtendableParserRule654);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:293:1: entryRuleSubrule1 : ruleSubrule1 EOF ;
    public final void entryRuleSubrule1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:293:18: ( ruleSubrule1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:294:2: ruleSubrule1 EOF
            {
             markComposite(elementTypeProvider.getSubrule1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubrule1_in_entryRuleSubrule1674);
            ruleSubrule1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubrule1680); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:302:1: ruleSubrule1 : (otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) ) ) ;
    public final void ruleSubrule1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_sub1_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:302:13: ( (otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:303:2: (otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:303:2: (otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:304:3: otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSubrule1703); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSubrule1_Subrule1Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:311:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:312:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:312:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:313:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSubrule1730); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getSubrule1_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:322:3: ( (lv_sub1_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:323:4: (lv_sub1_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:323:4: (lv_sub1_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:324:5: lv_sub1_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_sub1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSubrule1768); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:337:1: entryRuleSubrule2 : ruleSubrule2 EOF ;
    public final void entryRuleSubrule2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:337:18: ( ruleSubrule2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:338:2: ruleSubrule2 EOF
            {
             markComposite(elementTypeProvider.getSubrule2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubrule2_in_entryRuleSubrule2799);
            ruleSubrule2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubrule2805); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:346:1: ruleSubrule2 : (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) ) ) ;
    public final void ruleSubrule2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_sub2_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:346:13: ( (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:347:2: (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:347:2: (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:348:3: otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSubrule2828); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSubrule2_Subrule3Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:355:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:356:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:356:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:357:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSubrule2855); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getSubrule2_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:366:3: ( (lv_sub2_2_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:367:4: (lv_sub2_2_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:367:4: (lv_sub2_2_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:368:5: lv_sub2_2_0= RULE_STRING
            {

            					markLeaf();
            				
            lv_sub2_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSubrule2893); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:381:1: entryRuleSubrule3 : ruleSubrule3 EOF ;
    public final void entryRuleSubrule3() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:381:18: ( ruleSubrule3 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:382:2: ruleSubrule3 EOF
            {
             markComposite(elementTypeProvider.getSubrule3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubrule3_in_entryRuleSubrule3924);
            ruleSubrule3();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubrule3930); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:390:1: ruleSubrule3 : (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) ) ) ;
    public final void ruleSubrule3() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_sub1_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:390:13: ( (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:391:2: (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:391:2: (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:392:3: otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSubrule3953); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSubrule3_Subrule3Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:399:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:400:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:400:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:401:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSubrule3980); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getSubrule3_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:410:3: ( (lv_sub1_2_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:411:4: (lv_sub1_2_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:411:4: (lv_sub1_2_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:412:5: lv_sub1_2_0= RULE_INT
            {

            					markLeaf();
            				
            lv_sub1_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleSubrule31018); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:425:1: entryRuleCallExtendedParserRule : ruleCallExtendedParserRule EOF ;
    public final void entryRuleCallExtendedParserRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:425:32: ( ruleCallExtendedParserRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:426:2: ruleCallExtendedParserRule EOF
            {
             markComposite(elementTypeProvider.getCallExtendedParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCallExtendedParserRule_in_entryRuleCallExtendedParserRule1049);
            ruleCallExtendedParserRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCallExtendedParserRule1055); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:434:1: ruleCallExtendedParserRule : ( (lv_call_0_0= ruleAbstractCallExtendedParserRule ) ) ;
    public final void ruleCallExtendedParserRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:434:27: ( ( (lv_call_0_0= ruleAbstractCallExtendedParserRule ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:435:2: ( (lv_call_0_0= ruleAbstractCallExtendedParserRule ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:435:2: ( (lv_call_0_0= ruleAbstractCallExtendedParserRule ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:436:3: (lv_call_0_0= ruleAbstractCallExtendedParserRule )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:436:3: (lv_call_0_0= ruleAbstractCallExtendedParserRule )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:437:4: lv_call_0_0= ruleAbstractCallExtendedParserRule
            {

            				markComposite(elementTypeProvider.getCallExtendedParserRule_CallAbstractCallExtendedParserRuleParserRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_ruleAbstractCallExtendedParserRule_in_ruleCallExtendedParserRule1084);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:449:1: entryRuleInheritedParserRule : ruleInheritedParserRule EOF ;
    public final void entryRuleInheritedParserRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:449:29: ( ruleInheritedParserRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:450:2: ruleInheritedParserRule EOF
            {
             markComposite(elementTypeProvider.getInheritedParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule1109);
            ruleInheritedParserRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInheritedParserRule1115); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:458:1: ruleInheritedParserRule : (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleInheritedParserRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:458:24: ( (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:459:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:459:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:460:3: otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleInheritedParserRule1138); 

            			doneLeaf(otherlv_0, elementTypeProvider.getInheritedParserRule_ElementKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:467:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:468:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:468:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:469:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleInheritedParserRule1165); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:482:1: entryRuleAbstractCallOverridenParserRule : ruleAbstractCallOverridenParserRule EOF ;
    public final void entryRuleAbstractCallOverridenParserRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:482:41: ( ruleAbstractCallOverridenParserRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:483:2: ruleAbstractCallOverridenParserRule EOF
            {
             markComposite(elementTypeProvider.getAbstractCallOverridenParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractCallOverridenParserRule_in_entryRuleAbstractCallOverridenParserRule1196);
            ruleAbstractCallOverridenParserRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractCallOverridenParserRule1202); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:491:1: ruleAbstractCallOverridenParserRule : (otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )* ) ;
    public final void ruleAbstractCallOverridenParserRule() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:491:36: ( (otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:492:2: (otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:492:2: (otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:493:3: otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAbstractCallOverridenParserRule1225); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAbstractCallOverridenParserRule_OverridemodelKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:500:3: ( (lv_elements_1_0= ruleOverridableParserRule ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:501:4: (lv_elements_1_0= ruleOverridableParserRule )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:501:4: (lv_elements_1_0= ruleOverridableParserRule )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:502:5: lv_elements_1_0= ruleOverridableParserRule
            	    {

            	    					markComposite(elementTypeProvider.getAbstractCallOverridenParserRule_ElementsOverridableParserRuleParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleOverridableParserRule_in_ruleAbstractCallOverridenParserRule1252);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:515:1: entryRuleAbstractCallExtendedParserRule : ruleAbstractCallExtendedParserRule EOF ;
    public final void entryRuleAbstractCallExtendedParserRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:515:40: ( ruleAbstractCallExtendedParserRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:516:2: ruleAbstractCallExtendedParserRule EOF
            {
             markComposite(elementTypeProvider.getAbstractCallExtendedParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractCallExtendedParserRule_in_entryRuleAbstractCallExtendedParserRule1284);
            ruleAbstractCallExtendedParserRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractCallExtendedParserRule1290); 

            }

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:524:1: ruleAbstractCallExtendedParserRule : (otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )* ) ;
    public final void ruleAbstractCallExtendedParserRule() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:524:35: ( (otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:525:2: (otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:525:2: (otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:526:3: otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAbstractCallExtendedParserRule1313); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAbstractCallExtendedParserRule_ExtendedmodelKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:533:3: ( (lv_elements_1_0= ruleExtendableParserRule ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=17 && LA5_0<=18)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:534:4: (lv_elements_1_0= ruleExtendableParserRule )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:534:4: (lv_elements_1_0= ruleExtendableParserRule )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/grammarinheritance/idea/parser/antlr/internal/PsiInternalConcreteTestLanguage.g:535:5: lv_elements_1_0= ruleExtendableParserRule
            	    {

            	    					markComposite(elementTypeProvider.getAbstractCallExtendedParserRule_ElementsExtendableParserRuleParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleExtendableParserRule_in_ruleAbstractCallExtendedParserRule1340);
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
        public static final BitSet FOLLOW_ruleConcreteParserRule_in_ruleRootRule81 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallOverridenParserRule_in_ruleRootRule101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallExtendedParserRule_in_ruleRootRule121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOverridableParserRule2_in_ruleRootRule141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcreteParserRule_in_entryRuleConcreteParserRule161 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcreteParserRule167 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleConcreteParserRule190 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_REAL_in_ruleConcreteParserRule217 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleConcreteParserRule242 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_ruleInheritedParserRule_in_ruleConcreteParserRule269 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_ruleOverridableParserRule_in_entryRuleOverridableParserRule301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOverridableParserRule307 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleOverridableParserRule330 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOverridableParserRule357 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallOverridenParserRule_in_entryRuleCallOverridenParserRule388 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCallOverridenParserRule394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractCallOverridenParserRule_in_ruleCallOverridenParserRule423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOverridableParserRule2_in_entryRuleOverridableParserRule2448 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOverridableParserRule2454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleOverridableParserRule2477 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOverridableParserRule2504 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleOverridableParserRule2529 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleOverridableParserRule2556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExtendableParserRule_in_entryRuleExtendableParserRule587 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExtendableParserRule593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubrule1_in_ruleExtendableParserRule614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubrule2_in_ruleExtendableParserRule634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubrule3_in_ruleExtendableParserRule654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubrule1_in_entryRuleSubrule1674 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubrule1680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleSubrule1703 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule1730 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule1768 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubrule2_in_entryRuleSubrule2799 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubrule2805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleSubrule2828 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule2855 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSubrule2893 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubrule3_in_entryRuleSubrule3924 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubrule3930 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleSubrule3953 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule3980 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleSubrule31018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallExtendedParserRule_in_entryRuleCallExtendedParserRule1049 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCallExtendedParserRule1055 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractCallExtendedParserRule_in_ruleCallExtendedParserRule1084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule1109 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInheritedParserRule1115 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleInheritedParserRule1138 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleInheritedParserRule1165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractCallOverridenParserRule_in_entryRuleAbstractCallOverridenParserRule1196 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractCallOverridenParserRule1202 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleAbstractCallOverridenParserRule1225 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_ruleOverridableParserRule_in_ruleAbstractCallOverridenParserRule1252 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_ruleAbstractCallExtendedParserRule_in_entryRuleAbstractCallExtendedParserRule1284 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractCallExtendedParserRule1290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleAbstractCallExtendedParserRule1313 = new BitSet(new long[]{0x0000000000060002L});
        public static final BitSet FOLLOW_ruleExtendableParserRule_in_ruleAbstractCallExtendedParserRule1340 = new BitSet(new long[]{0x0000000000060002L});
    }


}