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
    public String getGrammarFileName() { return "PsiInternalEObjectAtOffsetTestLanguage.g"; }



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
    // PsiInternalEObjectAtOffsetTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalEObjectAtOffsetTestLanguage.g:52:15: ( ruleModel EOF )
            // PsiInternalEObjectAtOffsetTestLanguage.g:53:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalEObjectAtOffsetTestLanguage.g:58:1: ruleModel : ( ( (lv_foos_0_0= ruleFoo ) ) | ( (lv_bars_1_0= ruleAbstractBar ) ) )* ;
    public final void ruleModel() throws RecognitionException {
        try {
            // PsiInternalEObjectAtOffsetTestLanguage.g:58:10: ( ( ( (lv_foos_0_0= ruleFoo ) ) | ( (lv_bars_1_0= ruleAbstractBar ) ) )* )
            // PsiInternalEObjectAtOffsetTestLanguage.g:59:2: ( ( (lv_foos_0_0= ruleFoo ) ) | ( (lv_bars_1_0= ruleAbstractBar ) ) )*
            {
            // PsiInternalEObjectAtOffsetTestLanguage.g:59:2: ( ( (lv_foos_0_0= ruleFoo ) ) | ( (lv_bars_1_0= ruleAbstractBar ) ) )*
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
            	    // PsiInternalEObjectAtOffsetTestLanguage.g:60:3: ( (lv_foos_0_0= ruleFoo ) )
            	    {
            	    // PsiInternalEObjectAtOffsetTestLanguage.g:60:3: ( (lv_foos_0_0= ruleFoo ) )
            	    // PsiInternalEObjectAtOffsetTestLanguage.g:61:4: (lv_foos_0_0= ruleFoo )
            	    {
            	    // PsiInternalEObjectAtOffsetTestLanguage.g:61:4: (lv_foos_0_0= ruleFoo )
            	    // PsiInternalEObjectAtOffsetTestLanguage.g:62:5: lv_foos_0_0= ruleFoo
            	    {

            	    					markComposite(elementTypeProvider.getModel_FoosFooParserRuleCall_0_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    ruleFoo();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalEObjectAtOffsetTestLanguage.g:72:3: ( (lv_bars_1_0= ruleAbstractBar ) )
            	    {
            	    // PsiInternalEObjectAtOffsetTestLanguage.g:72:3: ( (lv_bars_1_0= ruleAbstractBar ) )
            	    // PsiInternalEObjectAtOffsetTestLanguage.g:73:4: (lv_bars_1_0= ruleAbstractBar )
            	    {
            	    // PsiInternalEObjectAtOffsetTestLanguage.g:73:4: (lv_bars_1_0= ruleAbstractBar )
            	    // PsiInternalEObjectAtOffsetTestLanguage.g:74:5: lv_bars_1_0= ruleAbstractBar
            	    {

            	    					markComposite(elementTypeProvider.getModel_BarsAbstractBarParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_3);
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
    // PsiInternalEObjectAtOffsetTestLanguage.g:87:1: entryRuleAbstractBar : ruleAbstractBar EOF ;
    public final void entryRuleAbstractBar() throws RecognitionException {
        try {
            // PsiInternalEObjectAtOffsetTestLanguage.g:87:21: ( ruleAbstractBar EOF )
            // PsiInternalEObjectAtOffsetTestLanguage.g:88:2: ruleAbstractBar EOF
            {
             markComposite(elementTypeProvider.getAbstractBarElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractBar();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalEObjectAtOffsetTestLanguage.g:93:1: ruleAbstractBar : ( (otherlv_0= 'zonk' )? (this_INT_1= RULE_INT )? ruleBar ( () otherlv_4= 'foobar' ( ( ruleQualifiedNameWithOtherDelim ) ) )? ( ( ruleQualifiedNameWithOtherDelim ) )? ) ;
    public final void ruleAbstractBar() throws RecognitionException {
        Token otherlv_0=null;
        Token this_INT_1=null;
        Token otherlv_4=null;

        try {
            // PsiInternalEObjectAtOffsetTestLanguage.g:93:16: ( ( (otherlv_0= 'zonk' )? (this_INT_1= RULE_INT )? ruleBar ( () otherlv_4= 'foobar' ( ( ruleQualifiedNameWithOtherDelim ) ) )? ( ( ruleQualifiedNameWithOtherDelim ) )? ) )
            // PsiInternalEObjectAtOffsetTestLanguage.g:94:2: ( (otherlv_0= 'zonk' )? (this_INT_1= RULE_INT )? ruleBar ( () otherlv_4= 'foobar' ( ( ruleQualifiedNameWithOtherDelim ) ) )? ( ( ruleQualifiedNameWithOtherDelim ) )? )
            {
            // PsiInternalEObjectAtOffsetTestLanguage.g:94:2: ( (otherlv_0= 'zonk' )? (this_INT_1= RULE_INT )? ruleBar ( () otherlv_4= 'foobar' ( ( ruleQualifiedNameWithOtherDelim ) ) )? ( ( ruleQualifiedNameWithOtherDelim ) )? )
            // PsiInternalEObjectAtOffsetTestLanguage.g:95:3: (otherlv_0= 'zonk' )? (this_INT_1= RULE_INT )? ruleBar ( () otherlv_4= 'foobar' ( ( ruleQualifiedNameWithOtherDelim ) ) )? ( ( ruleQualifiedNameWithOtherDelim ) )?
            {
            // PsiInternalEObjectAtOffsetTestLanguage.g:95:3: (otherlv_0= 'zonk' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalEObjectAtOffsetTestLanguage.g:96:4: otherlv_0= 'zonk'
                    {

                    				markLeaf(elementTypeProvider.getAbstractBar_ZonkKeyword_0ElementType());
                    			
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_0);
                    			

                    }
                    break;

            }

            // PsiInternalEObjectAtOffsetTestLanguage.g:104:3: (this_INT_1= RULE_INT )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INT) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalEObjectAtOffsetTestLanguage.g:105:4: this_INT_1= RULE_INT
                    {

                    				markLeaf(elementTypeProvider.getAbstractBar_INTTerminalRuleCall_1ElementType());
                    			
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_4); 

                    				doneLeaf(this_INT_1);
                    			

                    }
                    break;

            }


            			markComposite(elementTypeProvider.getAbstractBar_BarParserRuleCall_2ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_5);
            ruleBar();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalEObjectAtOffsetTestLanguage.g:120:3: ( () otherlv_4= 'foobar' ( ( ruleQualifiedNameWithOtherDelim ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalEObjectAtOffsetTestLanguage.g:121:4: () otherlv_4= 'foobar' ( ( ruleQualifiedNameWithOtherDelim ) )
                    {
                    // PsiInternalEObjectAtOffsetTestLanguage.g:121:4: ()
                    // PsiInternalEObjectAtOffsetTestLanguage.g:122:5: 
                    {

                    					precedeComposite(elementTypeProvider.getAbstractBar_FooBarBarAction_3_0ElementType());
                    					doneComposite();
                    				

                    }


                    				markLeaf(elementTypeProvider.getAbstractBar_FoobarKeyword_3_1ElementType());
                    			
                    otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_6); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalEObjectAtOffsetTestLanguage.g:134:4: ( ( ruleQualifiedNameWithOtherDelim ) )
                    // PsiInternalEObjectAtOffsetTestLanguage.g:135:5: ( ruleQualifiedNameWithOtherDelim )
                    {
                    // PsiInternalEObjectAtOffsetTestLanguage.g:135:5: ( ruleQualifiedNameWithOtherDelim )
                    // PsiInternalEObjectAtOffsetTestLanguage.g:136:6: ruleQualifiedNameWithOtherDelim
                    {

                    						markComposite(elementTypeProvider.getAbstractBar_FooFooCrossReference_3_2_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_7);
                    ruleQualifiedNameWithOtherDelim();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalEObjectAtOffsetTestLanguage.g:146:3: ( ( ruleQualifiedNameWithOtherDelim ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalEObjectAtOffsetTestLanguage.g:147:4: ( ruleQualifiedNameWithOtherDelim )
                    {
                    // PsiInternalEObjectAtOffsetTestLanguage.g:147:4: ( ruleQualifiedNameWithOtherDelim )
                    // PsiInternalEObjectAtOffsetTestLanguage.g:148:5: ruleQualifiedNameWithOtherDelim
                    {

                    					markComposite(elementTypeProvider.getAbstractBar_FooFooCrossReference_4_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalEObjectAtOffsetTestLanguage.g:161:1: entryRuleBar : ruleBar EOF ;
    public final void entryRuleBar() throws RecognitionException {
        try {
            // PsiInternalEObjectAtOffsetTestLanguage.g:161:13: ( ruleBar EOF )
            // PsiInternalEObjectAtOffsetTestLanguage.g:162:2: ruleBar EOF
            {
             markComposite(elementTypeProvider.getBarElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleBar();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalEObjectAtOffsetTestLanguage.g:167:1: ruleBar : (otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( ( ruleQualifiedNameWithOtherDelim ) ) (otherlv_3= ',' ( ( ruleQualifiedNameWithOtherDelim ) ) )* ) ;
    public final void ruleBar() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalEObjectAtOffsetTestLanguage.g:167:8: ( (otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( ( ruleQualifiedNameWithOtherDelim ) ) (otherlv_3= ',' ( ( ruleQualifiedNameWithOtherDelim ) ) )* ) )
            // PsiInternalEObjectAtOffsetTestLanguage.g:168:2: (otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( ( ruleQualifiedNameWithOtherDelim ) ) (otherlv_3= ',' ( ( ruleQualifiedNameWithOtherDelim ) ) )* )
            {
            // PsiInternalEObjectAtOffsetTestLanguage.g:168:2: (otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( ( ruleQualifiedNameWithOtherDelim ) ) (otherlv_3= ',' ( ( ruleQualifiedNameWithOtherDelim ) ) )* )
            // PsiInternalEObjectAtOffsetTestLanguage.g:169:3: otherlv_0= 'bar' ( (lv_name_1_0= RULE_ID ) ) ( ( ruleQualifiedNameWithOtherDelim ) ) (otherlv_3= ',' ( ( ruleQualifiedNameWithOtherDelim ) ) )*
            {

            			markLeaf(elementTypeProvider.getBar_BarKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalEObjectAtOffsetTestLanguage.g:176:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalEObjectAtOffsetTestLanguage.g:177:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalEObjectAtOffsetTestLanguage.g:177:4: (lv_name_1_0= RULE_ID )
            // PsiInternalEObjectAtOffsetTestLanguage.g:178:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getBar_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalEObjectAtOffsetTestLanguage.g:187:3: ( ( ruleQualifiedNameWithOtherDelim ) )
            // PsiInternalEObjectAtOffsetTestLanguage.g:188:4: ( ruleQualifiedNameWithOtherDelim )
            {
            // PsiInternalEObjectAtOffsetTestLanguage.g:188:4: ( ruleQualifiedNameWithOtherDelim )
            // PsiInternalEObjectAtOffsetTestLanguage.g:189:5: ruleQualifiedNameWithOtherDelim
            {

            					markComposite(elementTypeProvider.getBar_FooFooCrossReference_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_8);
            ruleQualifiedNameWithOtherDelim();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalEObjectAtOffsetTestLanguage.g:198:3: (otherlv_3= ',' ( ( ruleQualifiedNameWithOtherDelim ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==14) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // PsiInternalEObjectAtOffsetTestLanguage.g:199:4: otherlv_3= ',' ( ( ruleQualifiedNameWithOtherDelim ) )
            	    {

            	    				markLeaf(elementTypeProvider.getBar_CommaKeyword_3_0ElementType());
            	    			
            	    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_6); 

            	    				doneLeaf(otherlv_3);
            	    			
            	    // PsiInternalEObjectAtOffsetTestLanguage.g:206:4: ( ( ruleQualifiedNameWithOtherDelim ) )
            	    // PsiInternalEObjectAtOffsetTestLanguage.g:207:5: ( ruleQualifiedNameWithOtherDelim )
            	    {
            	    // PsiInternalEObjectAtOffsetTestLanguage.g:207:5: ( ruleQualifiedNameWithOtherDelim )
            	    // PsiInternalEObjectAtOffsetTestLanguage.g:208:6: ruleQualifiedNameWithOtherDelim
            	    {

            	    						markComposite(elementTypeProvider.getBar_FooFooCrossReference_3_1_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_8);
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
    // PsiInternalEObjectAtOffsetTestLanguage.g:222:1: entryRuleFoo : ruleFoo EOF ;
    public final void entryRuleFoo() throws RecognitionException {
        try {
            // PsiInternalEObjectAtOffsetTestLanguage.g:222:13: ( ruleFoo EOF )
            // PsiInternalEObjectAtOffsetTestLanguage.g:223:2: ruleFoo EOF
            {
             markComposite(elementTypeProvider.getFooElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFoo();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalEObjectAtOffsetTestLanguage.g:228:1: ruleFoo : (otherlv_0= 'foo' ( (lv_name_1_0= ruleQualifiedNameWithOtherDelim ) ) ) ;
    public final void ruleFoo() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalEObjectAtOffsetTestLanguage.g:228:8: ( (otherlv_0= 'foo' ( (lv_name_1_0= ruleQualifiedNameWithOtherDelim ) ) ) )
            // PsiInternalEObjectAtOffsetTestLanguage.g:229:2: (otherlv_0= 'foo' ( (lv_name_1_0= ruleQualifiedNameWithOtherDelim ) ) )
            {
            // PsiInternalEObjectAtOffsetTestLanguage.g:229:2: (otherlv_0= 'foo' ( (lv_name_1_0= ruleQualifiedNameWithOtherDelim ) ) )
            // PsiInternalEObjectAtOffsetTestLanguage.g:230:3: otherlv_0= 'foo' ( (lv_name_1_0= ruleQualifiedNameWithOtherDelim ) )
            {

            			markLeaf(elementTypeProvider.getFoo_FooKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalEObjectAtOffsetTestLanguage.g:237:3: ( (lv_name_1_0= ruleQualifiedNameWithOtherDelim ) )
            // PsiInternalEObjectAtOffsetTestLanguage.g:238:4: (lv_name_1_0= ruleQualifiedNameWithOtherDelim )
            {
            // PsiInternalEObjectAtOffsetTestLanguage.g:238:4: (lv_name_1_0= ruleQualifiedNameWithOtherDelim )
            // PsiInternalEObjectAtOffsetTestLanguage.g:239:5: lv_name_1_0= ruleQualifiedNameWithOtherDelim
            {

            					markComposite(elementTypeProvider.getFoo_NameQualifiedNameWithOtherDelimParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalEObjectAtOffsetTestLanguage.g:252:1: entryRuleQualifiedNameWithOtherDelim : ruleQualifiedNameWithOtherDelim EOF ;
    public final void entryRuleQualifiedNameWithOtherDelim() throws RecognitionException {
        try {
            // PsiInternalEObjectAtOffsetTestLanguage.g:252:37: ( ruleQualifiedNameWithOtherDelim EOF )
            // PsiInternalEObjectAtOffsetTestLanguage.g:253:2: ruleQualifiedNameWithOtherDelim EOF
            {
             markComposite(elementTypeProvider.getQualifiedNameWithOtherDelimElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleQualifiedNameWithOtherDelim();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalEObjectAtOffsetTestLanguage.g:258:1: ruleQualifiedNameWithOtherDelim : ( ruleQualifiedName (kw= '=' ruleQualifiedName )* ) ;
    public final void ruleQualifiedNameWithOtherDelim() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalEObjectAtOffsetTestLanguage.g:258:32: ( ( ruleQualifiedName (kw= '=' ruleQualifiedName )* ) )
            // PsiInternalEObjectAtOffsetTestLanguage.g:259:2: ( ruleQualifiedName (kw= '=' ruleQualifiedName )* )
            {
            // PsiInternalEObjectAtOffsetTestLanguage.g:259:2: ( ruleQualifiedName (kw= '=' ruleQualifiedName )* )
            // PsiInternalEObjectAtOffsetTestLanguage.g:260:3: ruleQualifiedName (kw= '=' ruleQualifiedName )*
            {

            			markComposite(elementTypeProvider.getQualifiedNameWithOtherDelim_QualifiedNameParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_9);
            ruleQualifiedName();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalEObjectAtOffsetTestLanguage.g:267:3: (kw= '=' ruleQualifiedName )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==16) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // PsiInternalEObjectAtOffsetTestLanguage.g:268:4: kw= '=' ruleQualifiedName
            	    {

            	    				markLeaf(elementTypeProvider.getQualifiedNameWithOtherDelim_EqualsSignKeyword_1_0ElementType());
            	    			
            	    kw=(Token)match(input,16,FollowSets000.FOLLOW_6); 

            	    				doneLeaf(kw);
            	    			

            	    				markComposite(elementTypeProvider.getQualifiedNameWithOtherDelim_QualifiedNameParserRuleCall_1_1ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_9);
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
    // PsiInternalEObjectAtOffsetTestLanguage.g:287:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // PsiInternalEObjectAtOffsetTestLanguage.g:287:23: ( ruleQualifiedName EOF )
            // PsiInternalEObjectAtOffsetTestLanguage.g:288:2: ruleQualifiedName EOF
            {
             markComposite(elementTypeProvider.getQualifiedNameElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalEObjectAtOffsetTestLanguage.g:293:1: ruleQualifiedName : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final void ruleQualifiedName() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // PsiInternalEObjectAtOffsetTestLanguage.g:293:18: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // PsiInternalEObjectAtOffsetTestLanguage.g:294:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // PsiInternalEObjectAtOffsetTestLanguage.g:294:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // PsiInternalEObjectAtOffsetTestLanguage.g:295:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf(elementTypeProvider.getQualifiedName_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

            			doneLeaf(this_ID_0);
            		
            // PsiInternalEObjectAtOffsetTestLanguage.g:302:3: (kw= '.' this_ID_2= RULE_ID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // PsiInternalEObjectAtOffsetTestLanguage.g:303:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf(elementTypeProvider.getQualifiedName_FullStopKeyword_1_0ElementType());
            	    			
            	    kw=(Token)match(input,17,FollowSets000.FOLLOW_6); 

            	    				doneLeaf(kw);
            	    			

            	    				markLeaf(elementTypeProvider.getQualifiedName_IDTerminalRuleCall_1_1ElementType());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

            	    				doneLeaf(this_ID_2);
            	    			

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
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000000000A812L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000000B830L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001022L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020002L});
    }


}