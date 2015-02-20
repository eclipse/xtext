package org.eclipse.xtext.resource.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.resource.idea.lang.EObjectAtOffsetTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.resource.services.EObjectAtOffsetTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalEObjectAtOffsetTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'zonk'", "'foobar'", "'bar'", "','", "'foo'", "'='", "'.'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__17=17;
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


        public PsiInternalEObjectAtOffsetTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalEObjectAtOffsetTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalEObjectAtOffsetTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g"; }



    	protected EObjectAtOffsetTestLanguageGrammarAccess grammarAccess;

    	protected EObjectAtOffsetTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalEObjectAtOffsetTestLanguageParser(PsiBuilder builder, TokenStream input, EObjectAtOffsetTestLanguageElementTypeProvider elementTypeProvider, EObjectAtOffsetTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Model";
    	}




    // $ANTLR start "entryRuleModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:52:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:53:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel54);
            ruleModel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel60); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:59:1: ruleModel : ( ( (lv_foos_0_0= ruleFoo ) ) | ( (lv_bars_1_0= ruleAbstractBar ) ) )* ;
    public final void ruleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:59:10: ( ( ( (lv_foos_0_0= ruleFoo ) ) | ( (lv_bars_1_0= ruleAbstractBar ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:60:2: ( ( (lv_foos_0_0= ruleFoo ) ) | ( (lv_bars_1_0= ruleAbstractBar ) ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:60:2: ( ( (lv_foos_0_0= ruleFoo ) ) | ( (lv_bars_1_0= ruleAbstractBar ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }
                else if ( (LA1_0==RULE_INT||LA1_0==11||LA1_0==13) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:61:3: ( (lv_foos_0_0= ruleFoo ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:61:3: ( (lv_foos_0_0= ruleFoo ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:62:4: (lv_foos_0_0= ruleFoo )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:62:4: (lv_foos_0_0= ruleFoo )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:63:5: lv_foos_0_0= ruleFoo
            	    {

            	    					markComposite(elementTypeProvider.getModel_FoosFooParserRuleCall_0_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleFoo_in_ruleModel92);
            	    ruleFoo();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:73:3: ( (lv_bars_1_0= ruleAbstractBar ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:73:3: ( (lv_bars_1_0= ruleAbstractBar ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:74:4: (lv_bars_1_0= ruleAbstractBar )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:74:4: (lv_bars_1_0= ruleAbstractBar )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:75:5: lv_bars_1_0= ruleAbstractBar
            	    {

            	    					markComposite(elementTypeProvider.getModel_BarsAbstractBarParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractBar_in_ruleModel138);
            	    ruleAbstractBar();

            	    state._fsp--;


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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleAbstractBar"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:88:1: entryRuleAbstractBar : ruleAbstractBar EOF ;
    public final void entryRuleAbstractBar() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:88:21: ( ruleAbstractBar EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:89:2: ruleAbstractBar EOF
            {
             markComposite(elementTypeProvider.getAbstractBarElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractBar_in_entryRuleAbstractBar170);
            ruleAbstractBar();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractBar176); 

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
    // $ANTLR end "entryRuleAbstractBar"


    // $ANTLR start "ruleAbstractBar"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:95:1: ruleAbstractBar : ( (otherlv_0= 'zonk' )? (this_INT_1= RULE_INT )? ruleBar ( () otherlv_4= 'foobar' ( ( ruleQualifiedNameWithOtherDelim ) ) )? ( ( ruleQualifiedNameWithOtherDelim ) )? ) ;
    public final void ruleAbstractBar() throws RecognitionException {
        Token otherlv_0=null;
        Token this_INT_1=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:95:16: ( ( (otherlv_0= 'zonk' )? (this_INT_1= RULE_INT )? ruleBar ( () otherlv_4= 'foobar' ( ( ruleQualifiedNameWithOtherDelim ) ) )? ( ( ruleQualifiedNameWithOtherDelim ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:96:2: ( (otherlv_0= 'zonk' )? (this_INT_1= RULE_INT )? ruleBar ( () otherlv_4= 'foobar' ( ( ruleQualifiedNameWithOtherDelim ) ) )? ( ( ruleQualifiedNameWithOtherDelim ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:96:2: ( (otherlv_0= 'zonk' )? (this_INT_1= RULE_INT )? ruleBar ( () otherlv_4= 'foobar' ( ( ruleQualifiedNameWithOtherDelim ) ) )? ( ( ruleQualifiedNameWithOtherDelim ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:97:3: (otherlv_0= 'zonk' )? (this_INT_1= RULE_INT )? ruleBar ( () otherlv_4= 'foobar' ( ( ruleQualifiedNameWithOtherDelim ) ) )? ( ( ruleQualifiedNameWithOtherDelim ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:97:3: (otherlv_0= 'zonk' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:98:4: otherlv_0= 'zonk'
                    {

                    				markLeaf();
                    			
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleAbstractBar201); 

                    				doneLeaf(otherlv_0, elementTypeProvider.getAbstractBar_ZonkKeyword_0ElementType());
                    			

                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:106:3: (this_INT_1= RULE_INT )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INT) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:107:4: this_INT_1= RULE_INT
                    {

                    				markLeaf();
                    			
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleAbstractBar227); 

                    				doneLeaf(this_INT_1, elementTypeProvider.getAbstractBar_INTTerminalRuleCall_1ElementType());
                    			

                    }
                    break;

            }


            			markComposite(elementTypeProvider.getAbstractBar_BarParserRuleCall_2ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleBar_in_ruleAbstractBar245);
            ruleBar();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:122:3: ( () otherlv_4= 'foobar' ( ( ruleQualifiedNameWithOtherDelim ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:123:4: () otherlv_4= 'foobar' ( ( ruleQualifiedNameWithOtherDelim ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:123:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:124:5: 
                    {

                    					precedeComposite(elementTypeProvider.getAbstractBar_FooBarBarAction_3_0ElementType());
                    					doneComposite();
                    				

                    }


                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAbstractBar281); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getAbstractBar_FoobarKeyword_3_1ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:136:4: ( ( ruleQualifiedNameWithOtherDelim ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:137:5: ( ruleQualifiedNameWithOtherDelim )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:137:5: ( ruleQualifiedNameWithOtherDelim )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:138:6: ruleQualifiedNameWithOtherDelim
                    {

                    						markComposite(elementTypeProvider.getAbstractBar_FooFooCrossReference_3_2_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithOtherDelim_in_ruleAbstractBar311);
                    ruleQualifiedNameWithOtherDelim();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:148:3: ( ( ruleQualifiedNameWithOtherDelim ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:149:4: ( ruleQualifiedNameWithOtherDelim )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:149:4: ( ruleQualifiedNameWithOtherDelim )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:150:5: ruleQualifiedNameWithOtherDelim
                    {

                    					markComposite(elementTypeProvider.getAbstractBar_FooFooCrossReference_4_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithOtherDelim_in_ruleAbstractBar355);
                    ruleQualifiedNameWithOtherDelim();

                    state._fsp--;


                    					doneComposite();
                    				

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
    // $ANTLR end "ruleAbstractBar"


    // $ANTLR start "entryRuleBar"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:163:1: entryRuleBar : ruleBar EOF ;
    public final void entryRuleBar() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:163:13: ( ruleBar EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:164:2: ruleBar EOF
            {
             markComposite(elementTypeProvider.getBarElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleBar_in_entryRuleBar387);
            ruleBar();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBar393); 

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
    // $ANTLR end "entryRuleBar"


    // $ANTLR start "ruleBar"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:170:1: ruleBar : (otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( ( ruleQualifiedNameWithOtherDelim ) ) (otherlv_3= ',' ( ( ruleQualifiedNameWithOtherDelim ) ) )* ) ;
    public final void ruleBar() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:170:8: ( (otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( ( ruleQualifiedNameWithOtherDelim ) ) (otherlv_3= ',' ( ( ruleQualifiedNameWithOtherDelim ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:171:2: (otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( ( ruleQualifiedNameWithOtherDelim ) ) (otherlv_3= ',' ( ( ruleQualifiedNameWithOtherDelim ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:171:2: (otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( ( ruleQualifiedNameWithOtherDelim ) ) (otherlv_3= ',' ( ( ruleQualifiedNameWithOtherDelim ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:172:3: otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( ( ruleQualifiedNameWithOtherDelim ) ) (otherlv_3= ',' ( ( ruleQualifiedNameWithOtherDelim ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleBar412); 

            			doneLeaf(otherlv_0, elementTypeProvider.getBar_BarKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:179:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:180:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:180:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:181:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBar439); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getBar_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:190:3: ( ( ruleQualifiedNameWithOtherDelim ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:191:4: ( ruleQualifiedNameWithOtherDelim )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:191:4: ( ruleQualifiedNameWithOtherDelim )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:192:5: ruleQualifiedNameWithOtherDelim
            {

            					markComposite(elementTypeProvider.getBar_FooFooCrossReference_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithOtherDelim_in_ruleBar475);
            ruleQualifiedNameWithOtherDelim();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:201:3: (otherlv_3= ',' ( ( ruleQualifiedNameWithOtherDelim ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==14) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:202:4: otherlv_3= ',' ( ( ruleQualifiedNameWithOtherDelim ) )
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleBar506); 

            	    				doneLeaf(otherlv_3, elementTypeProvider.getBar_CommaKeyword_3_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:209:4: ( ( ruleQualifiedNameWithOtherDelim ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:210:5: ( ruleQualifiedNameWithOtherDelim )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:210:5: ( ruleQualifiedNameWithOtherDelim )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:211:6: ruleQualifiedNameWithOtherDelim
            	    {

            	    						markComposite(elementTypeProvider.getBar_FooFooCrossReference_3_1_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithOtherDelim_in_ruleBar536);
            	    ruleQualifiedNameWithOtherDelim();

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
    // $ANTLR end "ruleBar"


    // $ANTLR start "entryRuleFoo"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:225:1: entryRuleFoo : ruleFoo EOF ;
    public final void entryRuleFoo() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:225:13: ( ruleFoo EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:226:2: ruleFoo EOF
            {
             markComposite(elementTypeProvider.getFooElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleFoo_in_entryRuleFoo575);
            ruleFoo();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFoo581); 

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
    // $ANTLR end "entryRuleFoo"


    // $ANTLR start "ruleFoo"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:232:1: ruleFoo : (otherlv_0= 'foo' ( (lv_name_1_0= ruleQualifiedNameWithOtherDelim ) ) ) ;
    public final void ruleFoo() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:232:8: ( (otherlv_0= 'foo' ( (lv_name_1_0= ruleQualifiedNameWithOtherDelim ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:233:2: (otherlv_0= 'foo' ( (lv_name_1_0= ruleQualifiedNameWithOtherDelim ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:233:2: (otherlv_0= 'foo' ( (lv_name_1_0= ruleQualifiedNameWithOtherDelim ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:234:3: otherlv_0= 'foo' ( (lv_name_1_0= ruleQualifiedNameWithOtherDelim ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleFoo600); 

            			doneLeaf(otherlv_0, elementTypeProvider.getFoo_FooKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:241:3: ( (lv_name_1_0= ruleQualifiedNameWithOtherDelim ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:242:4: (lv_name_1_0= ruleQualifiedNameWithOtherDelim )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:242:4: (lv_name_1_0= ruleQualifiedNameWithOtherDelim )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:243:5: lv_name_1_0= ruleQualifiedNameWithOtherDelim
            {

            					markComposite(elementTypeProvider.getFoo_NameQualifiedNameWithOtherDelimParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithOtherDelim_in_ruleFoo627);
            ruleQualifiedNameWithOtherDelim();

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
    // $ANTLR end "ruleFoo"


    // $ANTLR start "entryRuleQualifiedNameWithOtherDelim"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:256:1: entryRuleQualifiedNameWithOtherDelim : ruleQualifiedNameWithOtherDelim EOF ;
    public final void entryRuleQualifiedNameWithOtherDelim() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:256:37: ( ruleQualifiedNameWithOtherDelim EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:257:2: ruleQualifiedNameWithOtherDelim EOF
            {
             markComposite(elementTypeProvider.getQualifiedNameWithOtherDelimElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithOtherDelim_in_entryRuleQualifiedNameWithOtherDelim658);
            ruleQualifiedNameWithOtherDelim();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedNameWithOtherDelim664); 

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
    // $ANTLR end "entryRuleQualifiedNameWithOtherDelim"


    // $ANTLR start "ruleQualifiedNameWithOtherDelim"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:263:1: ruleQualifiedNameWithOtherDelim : ( ruleQualifiedName (kw= '=' ruleQualifiedName )* ) ;
    public final void ruleQualifiedNameWithOtherDelim() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:263:32: ( ( ruleQualifiedName (kw= '=' ruleQualifiedName )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:264:2: ( ruleQualifiedName (kw= '=' ruleQualifiedName )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:264:2: ( ruleQualifiedName (kw= '=' ruleQualifiedName )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:265:3: ruleQualifiedName (kw= '=' ruleQualifiedName )*
            {

            			markComposite(elementTypeProvider.getQualifiedNameWithOtherDelim_QualifiedNameParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithOtherDelim681);
            ruleQualifiedName();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:272:3: (kw= '=' ruleQualifiedName )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==16) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:273:4: kw= '=' ruleQualifiedName
            	    {

            	    				markLeaf();
            	    			
            	    kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleQualifiedNameWithOtherDelim701); 

            	    				doneLeaf(kw, elementTypeProvider.getQualifiedNameWithOtherDelim_EqualsSignKeyword_1_0ElementType());
            	    			

            	    				markComposite(elementTypeProvider.getQualifiedNameWithOtherDelim_QualifiedNameParserRuleCall_1_1ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithOtherDelim716);
            	    ruleQualifiedName();

            	    state._fsp--;


            	    				doneComposite();
            	    			

            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end "ruleQualifiedNameWithOtherDelim"


    // $ANTLR start "entryRuleQualifiedName"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:292:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:292:23: ( ruleQualifiedName EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:293:2: ruleQualifiedName EOF
            {
             markComposite(elementTypeProvider.getQualifiedNameElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName742);
            ruleQualifiedName();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedName748); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:299:1: ruleQualifiedName : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final void ruleQualifiedName() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:299:18: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:300:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:300:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:301:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf();
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName767); 

            			doneLeaf(this_ID_0, elementTypeProvider.getQualifiedName_IDTerminalRuleCall_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:308:3: (kw= '.' this_ID_2= RULE_ID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalEObjectAtOffsetTestLanguage.g:309:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf();
            	    			
            	    kw=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleQualifiedName787); 

            	    				doneLeaf(kw, elementTypeProvider.getQualifiedName_FullStopKeyword_1_0ElementType());
            	    			

            	    				markLeaf();
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName804); 

            	    				doneLeaf(this_ID_2, elementTypeProvider.getQualifiedName_IDTerminalRuleCall_1_1ElementType());
            	    			

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
    // $ANTLR end "ruleQualifiedName"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFoo_in_ruleModel92 = new BitSet(new long[]{0x000000000000A812L});
        public static final BitSet FOLLOW_ruleAbstractBar_in_ruleModel138 = new BitSet(new long[]{0x000000000000A812L});
        public static final BitSet FOLLOW_ruleAbstractBar_in_entryRuleAbstractBar170 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractBar176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleAbstractBar201 = new BitSet(new long[]{0x000000000000B830L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleAbstractBar227 = new BitSet(new long[]{0x000000000000B830L});
        public static final BitSet FOLLOW_ruleBar_in_ruleAbstractBar245 = new BitSet(new long[]{0x0000000000001022L});
        public static final BitSet FOLLOW_12_in_ruleAbstractBar281 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithOtherDelim_in_ruleAbstractBar311 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithOtherDelim_in_ruleAbstractBar355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBar_in_entryRuleBar387 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBar393 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleBar412 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBar439 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithOtherDelim_in_ruleBar475 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleBar506 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithOtherDelim_in_ruleBar536 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_ruleFoo_in_entryRuleFoo575 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFoo581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleFoo600 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithOtherDelim_in_ruleFoo627 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithOtherDelim_in_entryRuleQualifiedNameWithOtherDelim658 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithOtherDelim664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithOtherDelim681 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_16_in_ruleQualifiedNameWithOtherDelim701 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithOtherDelim716 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName742 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName767 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_17_in_ruleQualifiedName787 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName804 = new BitSet(new long[]{0x0000000000020002L});
    }


}