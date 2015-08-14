package org.eclipse.xtext.grammarinheritance.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest2LanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.grammarinheritance.services.InheritanceTest2LanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalInheritanceTest2LanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'model'", "'{'", "'}'", "'element'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalInheritanceTest2LanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalInheritanceTest2LanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalInheritanceTest2LanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalInheritanceTest2Language.g"; }



    	protected InheritanceTest2LanguageGrammarAccess grammarAccess;

    	protected InheritanceTest2LanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalInheritanceTest2LanguageParser(PsiBuilder builder, TokenStream input, InheritanceTest2LanguageElementTypeProvider elementTypeProvider, InheritanceTest2LanguageGrammarAccess grammarAccess) {
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
    // PsiInternalInheritanceTest2Language.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalInheritanceTest2Language.g:52:15: ( ruleModel EOF )
            // PsiInternalInheritanceTest2Language.g:53:2: ruleModel EOF
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
    // PsiInternalInheritanceTest2Language.g:58:1: ruleModel : (otherlv_0= 'model' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* ( (lv_ids_4_0= ruleFQN ) ) otherlv_5= '}' ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;

        try {
            // PsiInternalInheritanceTest2Language.g:58:10: ( (otherlv_0= 'model' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* ( (lv_ids_4_0= ruleFQN ) ) otherlv_5= '}' ) )
            // PsiInternalInheritanceTest2Language.g:59:2: (otherlv_0= 'model' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* ( (lv_ids_4_0= ruleFQN ) ) otherlv_5= '}' )
            {
            // PsiInternalInheritanceTest2Language.g:59:2: (otherlv_0= 'model' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* ( (lv_ids_4_0= ruleFQN ) ) otherlv_5= '}' )
            // PsiInternalInheritanceTest2Language.g:60:3: otherlv_0= 'model' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* ( (lv_ids_4_0= ruleFQN ) ) otherlv_5= '}'
            {

            			markLeaf(elementTypeProvider.getModel_ModelKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalInheritanceTest2Language.g:67:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalInheritanceTest2Language.g:68:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalInheritanceTest2Language.g:68:4: (lv_name_1_0= RULE_ID )
            // PsiInternalInheritanceTest2Language.g:69:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getModel_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getModel_LeftCurlyBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalInheritanceTest2Language.g:85:3: ( (lv_elements_3_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalInheritanceTest2Language.g:86:4: (lv_elements_3_0= ruleElement )
            	    {
            	    // PsiInternalInheritanceTest2Language.g:86:4: (lv_elements_3_0= ruleElement )
            	    // PsiInternalInheritanceTest2Language.g:87:5: lv_elements_3_0= ruleElement
            	    {

            	    					markComposite(elementTypeProvider.getModel_ElementsElementParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    ruleElement();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // PsiInternalInheritanceTest2Language.g:96:3: ( (lv_ids_4_0= ruleFQN ) )
            // PsiInternalInheritanceTest2Language.g:97:4: (lv_ids_4_0= ruleFQN )
            {
            // PsiInternalInheritanceTest2Language.g:97:4: (lv_ids_4_0= ruleFQN )
            // PsiInternalInheritanceTest2Language.g:98:5: lv_ids_4_0= ruleFQN
            {

            					markComposite(elementTypeProvider.getModel_IdsFQNParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_6);
            ruleFQN();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getModel_RightCurlyBracketKeyword_5ElementType());
            		
            otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_5);
            		

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleElement"
    // PsiInternalInheritanceTest2Language.g:118:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // PsiInternalInheritanceTest2Language.g:118:17: ( ruleElement EOF )
            // PsiInternalInheritanceTest2Language.g:119:2: ruleElement EOF
            {
             markComposite(elementTypeProvider.getElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleElement();

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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // PsiInternalInheritanceTest2Language.g:124:1: ruleElement : (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleElement() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalInheritanceTest2Language.g:124:12: ( (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalInheritanceTest2Language.g:125:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalInheritanceTest2Language.g:125:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalInheritanceTest2Language.g:126:3: otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getElement_ElementKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalInheritanceTest2Language.g:133:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalInheritanceTest2Language.g:134:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalInheritanceTest2Language.g:134:4: (lv_name_1_0= RULE_ID )
            // PsiInternalInheritanceTest2Language.g:135:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getElement_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_name_1_0);
            				

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
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleFQN"
    // PsiInternalInheritanceTest2Language.g:148:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // PsiInternalInheritanceTest2Language.g:148:13: ( ruleFQN EOF )
            // PsiInternalInheritanceTest2Language.g:149:2: ruleFQN EOF
            {
             markComposite(elementTypeProvider.getFQNElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFQN();

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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // PsiInternalInheritanceTest2Language.g:154:1: ruleFQN : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final void ruleFQN() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // PsiInternalInheritanceTest2Language.g:154:8: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // PsiInternalInheritanceTest2Language.g:155:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // PsiInternalInheritanceTest2Language.g:155:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // PsiInternalInheritanceTest2Language.g:156:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf(elementTypeProvider.getFQN_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            			doneLeaf(this_ID_0);
            		
            // PsiInternalInheritanceTest2Language.g:163:3: (kw= '.' this_ID_2= RULE_ID )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalInheritanceTest2Language.g:164:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf(elementTypeProvider.getFQN_FullStopKeyword_1_0ElementType());
            	    			
            	    kw=(Token)match(input,15,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(kw);
            	    			

            	    				markLeaf(elementTypeProvider.getFQN_IDTerminalRuleCall_1_1ElementType());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            	    				doneLeaf(this_ID_2);
            	    			

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
    // $ANTLR end "ruleFQN"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008002L});
    }


}