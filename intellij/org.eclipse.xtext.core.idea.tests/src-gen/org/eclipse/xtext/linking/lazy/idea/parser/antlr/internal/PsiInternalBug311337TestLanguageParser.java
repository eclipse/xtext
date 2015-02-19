package org.eclipse.xtext.linking.lazy.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.linking.lazy.idea.lang.Bug311337TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.linking.lazy.services.Bug311337TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBug311337TestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'(def)'", "':'", "'(child)'", "'(ref)'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
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


        public PsiInternalBug311337TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug311337TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug311337TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g"; }



    	protected Bug311337TestLanguageGrammarAccess grammarAccess;

    	protected Bug311337TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBug311337TestLanguageParser(PsiBuilder builder, TokenStream input, Bug311337TestLanguageElementTypeProvider elementTypeProvider, Bug311337TestLanguageGrammarAccess grammarAccess) {
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:52:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:53:2: ruleModel EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:59:1: ruleModel : ( (lv_def_0_0= ruleDefinition ) )+ ;
    public final void ruleModel() throws RecognitionException {


        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:62:2: ( ( (lv_def_0_0= ruleDefinition ) )+ )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:63:2: ( (lv_def_0_0= ruleDefinition ) )+
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:63:2: ( (lv_def_0_0= ruleDefinition ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:64:3: (lv_def_0_0= ruleDefinition )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:64:3: (lv_def_0_0= ruleDefinition )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:65:4: lv_def_0_0= ruleDefinition
            	    {

            	    				markComposite(elementTypeProvider.getModel_DefDefinitionParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_ruleDefinition_in_ruleModel94);
            	    ruleDefinition();

            	    state._fsp--;


            	    				doneComposite();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
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


    // $ANTLR start "entryRuleDefinition"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:77:1: entryRuleDefinition : ruleDefinition EOF ;
    public final void entryRuleDefinition() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:77:20: ( ruleDefinition EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:78:2: ruleDefinition EOF
            {
             markComposite(elementTypeProvider.getDefinitionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDefinition_in_entryRuleDefinition120);
            ruleDefinition();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDefinition126); 

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
    // $ANTLR end "entryRuleDefinition"


    // $ANTLR start "ruleDefinition"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:84:1: ruleDefinition : (otherlv_0= '(def)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_child_3_0= ruleChild ) ) ( (lv_ref_4_0= ruleReference ) )? ) ;
    public final void ruleDefinition() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:87:2: ( (otherlv_0= '(def)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_child_3_0= ruleChild ) ) ( (lv_ref_4_0= ruleReference ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:88:2: (otherlv_0= '(def)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_child_3_0= ruleChild ) ) ( (lv_ref_4_0= ruleReference ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:88:2: (otherlv_0= '(def)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_child_3_0= ruleChild ) ) ( (lv_ref_4_0= ruleReference ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:89:3: otherlv_0= '(def)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_child_3_0= ruleChild ) ) ( (lv_ref_4_0= ruleReference ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleDefinition154); 

            			doneLeaf(otherlv_0, elementTypeProvider.getDefinition_DefKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:96:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:97:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:97:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:98:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDefinition181); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getDefinition_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleDefinition206); 

            			doneLeaf(otherlv_2, elementTypeProvider.getDefinition_ColonKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:114:3: ( (lv_child_3_0= ruleChild ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:115:4: (lv_child_3_0= ruleChild )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:115:4: (lv_child_3_0= ruleChild )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:116:5: lv_child_3_0= ruleChild
            {

            					markComposite(elementTypeProvider.getDefinition_ChildChildParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleChild_in_ruleDefinition233);
            ruleChild();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:125:3: ( (lv_ref_4_0= ruleReference ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==14) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:126:4: (lv_ref_4_0= ruleReference )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:126:4: (lv_ref_4_0= ruleReference )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:127:5: lv_ref_4_0= ruleReference
                    {

                    					markComposite(elementTypeProvider.getDefinition_RefReferenceParserRuleCall_4_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleReference_in_ruleDefinition271);
                    ruleReference();

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
    // $ANTLR end "ruleDefinition"


    // $ANTLR start "entryRuleChild"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:140:1: entryRuleChild : ruleChild EOF ;
    public final void entryRuleChild() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:140:15: ( ruleChild EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:141:2: ruleChild EOF
            {
             markComposite(elementTypeProvider.getChildElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild_in_entryRuleChild303);
            ruleChild();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild309); 

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
    // $ANTLR end "entryRuleChild"


    // $ANTLR start "ruleChild"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:147:1: ruleChild : (otherlv_0= '(child)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) )? ) ;
    public final void ruleChild() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:150:2: ( (otherlv_0= '(child)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:151:2: (otherlv_0= '(child)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:151:2: (otherlv_0= '(child)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:152:3: otherlv_0= '(child)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleChild337); 

            			doneLeaf(otherlv_0, elementTypeProvider.getChild_ChildKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:159:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:160:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:160:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:161:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleChild364); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getChild_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleChild389); 

            			doneLeaf(otherlv_2, elementTypeProvider.getChild_ColonKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:177:3: ( (otherlv_3= RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:178:4: (otherlv_3= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:178:4: (otherlv_3= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:179:5: otherlv_3= RULE_ID
                    {

                    					markLeaf();
                    				
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleChild416); 

                    					doneLeaf(otherlv_3, elementTypeProvider.getChild_LinkDefinitionCrossReference_3_0ElementType());
                    				

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
    // $ANTLR end "ruleChild"


    // $ANTLR start "entryRuleReference"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:192:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:192:19: ( ruleReference EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:193:2: ruleReference EOF
            {
             markComposite(elementTypeProvider.getReferenceElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleReference_in_entryRuleReference448);
            ruleReference();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReference454); 

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
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:199:1: ruleReference : (otherlv_0= '(ref)' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' () ( (otherlv_4= RULE_ID ) ) )* ) ;
    public final void ruleReference() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:202:2: ( (otherlv_0= '(ref)' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' () ( (otherlv_4= RULE_ID ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:203:2: (otherlv_0= '(ref)' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' () ( (otherlv_4= RULE_ID ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:203:2: (otherlv_0= '(ref)' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' () ( (otherlv_4= RULE_ID ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:204:3: otherlv_0= '(ref)' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' () ( (otherlv_4= RULE_ID ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleReference482); 

            			doneLeaf(otherlv_0, elementTypeProvider.getReference_RefKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:211:3: ( (otherlv_1= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:212:4: (otherlv_1= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:212:4: (otherlv_1= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:213:5: otherlv_1= RULE_ID
            {

            					markLeaf();
            				
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReference509); 

            					doneLeaf(otherlv_1, elementTypeProvider.getReference_RefChildChildCrossReference_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:222:3: (otherlv_2= ':' () ( (otherlv_4= RULE_ID ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:223:4: otherlv_2= ':' () ( (otherlv_4= RULE_ID ) )
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleReference540); 

            	    				doneLeaf(otherlv_2, elementTypeProvider.getReference_ColonKeyword_2_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:230:4: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:231:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getReference_NestedRefLeftAction_2_1ElementType());
            	    					doneComposite();
            	    				

            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:236:4: ( (otherlv_4= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:237:5: (otherlv_4= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:237:5: (otherlv_4= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/lazy/idea/parser/antlr/internal/PsiInternalBug311337TestLanguage.g:238:6: otherlv_4= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReference588); 

            	    						doneLeaf(otherlv_4, elementTypeProvider.getReference_RefChildChildCrossReference_2_2_0ElementType());
            	    					

            	    }


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
    // $ANTLR end "ruleReference"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDefinition_in_ruleModel94 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition120 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDefinition126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleDefinition154 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition181 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleDefinition206 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleChild_in_ruleDefinition233 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_ruleReference_in_ruleDefinition271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild_in_entryRuleChild303 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleChild337 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleChild364 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleChild389 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleChild416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference_in_entryRuleReference448 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReference454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleReference482 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReference509 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_12_in_ruleReference540 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReference588 = new BitSet(new long[]{0x0000000000001002L});
    }


}