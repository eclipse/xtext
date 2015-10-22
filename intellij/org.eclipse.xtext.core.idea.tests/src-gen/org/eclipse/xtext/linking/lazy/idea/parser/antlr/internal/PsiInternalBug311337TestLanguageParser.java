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
    public String getGrammarFileName() { return "PsiInternalBug311337TestLanguage.g"; }



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
    // PsiInternalBug311337TestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalBug311337TestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalBug311337TestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalBug311337TestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( (lv_def_0_0= ruleDefinition ) )+ ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_def_0_0 = null;


        try {
            // PsiInternalBug311337TestLanguage.g:60:1: ( ( (lv_def_0_0= ruleDefinition ) )+ )
            // PsiInternalBug311337TestLanguage.g:61:2: ( (lv_def_0_0= ruleDefinition ) )+
            {
            // PsiInternalBug311337TestLanguage.g:61:2: ( (lv_def_0_0= ruleDefinition ) )+
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
            	    // PsiInternalBug311337TestLanguage.g:62:3: (lv_def_0_0= ruleDefinition )
            	    {
            	    // PsiInternalBug311337TestLanguage.g:62:3: (lv_def_0_0= ruleDefinition )
            	    // PsiInternalBug311337TestLanguage.g:63:4: lv_def_0_0= ruleDefinition
            	    {

            	    				markComposite(elementTypeProvider.getModel_DefDefinitionParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_def_0_0=ruleDefinition();

            	    state._fsp--;


            	    				doneComposite();
            	    				if(!current) {
            	    					associateWithSemanticElement();
            	    					current = true;
            	    				}
            	    			

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
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDefinition"
    // PsiInternalBug311337TestLanguage.g:79:1: entryRuleDefinition returns [Boolean current=false] : iv_ruleDefinition= ruleDefinition EOF ;
    public final Boolean entryRuleDefinition() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDefinition = null;


        try {
            // PsiInternalBug311337TestLanguage.g:79:52: (iv_ruleDefinition= ruleDefinition EOF )
            // PsiInternalBug311337TestLanguage.g:80:2: iv_ruleDefinition= ruleDefinition EOF
            {
             markComposite(elementTypeProvider.getDefinitionElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDefinition=ruleDefinition();

            state._fsp--;

             current =iv_ruleDefinition; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefinition"


    // $ANTLR start "ruleDefinition"
    // PsiInternalBug311337TestLanguage.g:86:1: ruleDefinition returns [Boolean current=false] : (otherlv_0= '(def)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_child_3_0= ruleChild ) ) ( (lv_ref_4_0= ruleReference ) )? ) ;
    public final Boolean ruleDefinition() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Boolean lv_child_3_0 = null;

        Boolean lv_ref_4_0 = null;


        try {
            // PsiInternalBug311337TestLanguage.g:87:1: ( (otherlv_0= '(def)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_child_3_0= ruleChild ) ) ( (lv_ref_4_0= ruleReference ) )? ) )
            // PsiInternalBug311337TestLanguage.g:88:2: (otherlv_0= '(def)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_child_3_0= ruleChild ) ) ( (lv_ref_4_0= ruleReference ) )? )
            {
            // PsiInternalBug311337TestLanguage.g:88:2: (otherlv_0= '(def)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_child_3_0= ruleChild ) ) ( (lv_ref_4_0= ruleReference ) )? )
            // PsiInternalBug311337TestLanguage.g:89:3: otherlv_0= '(def)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_child_3_0= ruleChild ) ) ( (lv_ref_4_0= ruleReference ) )?
            {

            			markLeaf(elementTypeProvider.getDefinition_DefKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalBug311337TestLanguage.g:96:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalBug311337TestLanguage.g:97:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalBug311337TestLanguage.g:97:4: (lv_name_1_0= RULE_ID )
            // PsiInternalBug311337TestLanguage.g:98:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getDefinition_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getDefinition_ColonKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalBug311337TestLanguage.g:120:3: ( (lv_child_3_0= ruleChild ) )
            // PsiInternalBug311337TestLanguage.g:121:4: (lv_child_3_0= ruleChild )
            {
            // PsiInternalBug311337TestLanguage.g:121:4: (lv_child_3_0= ruleChild )
            // PsiInternalBug311337TestLanguage.g:122:5: lv_child_3_0= ruleChild
            {

            					markComposite(elementTypeProvider.getDefinition_ChildChildParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_7);
            lv_child_3_0=ruleChild();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalBug311337TestLanguage.g:135:3: ( (lv_ref_4_0= ruleReference ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==14) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalBug311337TestLanguage.g:136:4: (lv_ref_4_0= ruleReference )
                    {
                    // PsiInternalBug311337TestLanguage.g:136:4: (lv_ref_4_0= ruleReference )
                    // PsiInternalBug311337TestLanguage.g:137:5: lv_ref_4_0= ruleReference
                    {

                    					markComposite(elementTypeProvider.getDefinition_RefReferenceParserRuleCall_4_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ref_4_0=ruleReference();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
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
        return current;
    }
    // $ANTLR end "ruleDefinition"


    // $ANTLR start "entryRuleChild"
    // PsiInternalBug311337TestLanguage.g:154:1: entryRuleChild returns [Boolean current=false] : iv_ruleChild= ruleChild EOF ;
    public final Boolean entryRuleChild() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleChild = null;


        try {
            // PsiInternalBug311337TestLanguage.g:154:47: (iv_ruleChild= ruleChild EOF )
            // PsiInternalBug311337TestLanguage.g:155:2: iv_ruleChild= ruleChild EOF
            {
             markComposite(elementTypeProvider.getChildElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleChild=ruleChild();

            state._fsp--;

             current =iv_ruleChild; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleChild"


    // $ANTLR start "ruleChild"
    // PsiInternalBug311337TestLanguage.g:161:1: ruleChild returns [Boolean current=false] : (otherlv_0= '(child)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) )? ) ;
    public final Boolean ruleChild() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

        try {
            // PsiInternalBug311337TestLanguage.g:162:1: ( (otherlv_0= '(child)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) )? ) )
            // PsiInternalBug311337TestLanguage.g:163:2: (otherlv_0= '(child)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) )? )
            {
            // PsiInternalBug311337TestLanguage.g:163:2: (otherlv_0= '(child)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) )? )
            // PsiInternalBug311337TestLanguage.g:164:3: otherlv_0= '(child)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) )?
            {

            			markLeaf(elementTypeProvider.getChild_ChildKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalBug311337TestLanguage.g:171:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalBug311337TestLanguage.g:172:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalBug311337TestLanguage.g:172:4: (lv_name_1_0= RULE_ID )
            // PsiInternalBug311337TestLanguage.g:173:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getChild_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getChild_ColonKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalBug311337TestLanguage.g:195:3: ( (otherlv_3= RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalBug311337TestLanguage.g:196:4: (otherlv_3= RULE_ID )
                    {
                    // PsiInternalBug311337TestLanguage.g:196:4: (otherlv_3= RULE_ID )
                    // PsiInternalBug311337TestLanguage.g:197:5: otherlv_3= RULE_ID
                    {

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					markLeaf(elementTypeProvider.getChild_LinkDefinitionCrossReference_3_0ElementType());
                    				
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					doneLeaf(otherlv_3);
                    				

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
        return current;
    }
    // $ANTLR end "ruleChild"


    // $ANTLR start "entryRuleReference"
    // PsiInternalBug311337TestLanguage.g:216:1: entryRuleReference returns [Boolean current=false] : iv_ruleReference= ruleReference EOF ;
    public final Boolean entryRuleReference() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleReference = null;


        try {
            // PsiInternalBug311337TestLanguage.g:216:51: (iv_ruleReference= ruleReference EOF )
            // PsiInternalBug311337TestLanguage.g:217:2: iv_ruleReference= ruleReference EOF
            {
             markComposite(elementTypeProvider.getReferenceElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleReference=ruleReference();

            state._fsp--;

             current =iv_ruleReference; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // PsiInternalBug311337TestLanguage.g:223:1: ruleReference returns [Boolean current=false] : (otherlv_0= '(ref)' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' () ( (otherlv_4= RULE_ID ) ) )* ) ;
    public final Boolean ruleReference() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // PsiInternalBug311337TestLanguage.g:224:1: ( (otherlv_0= '(ref)' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' () ( (otherlv_4= RULE_ID ) ) )* ) )
            // PsiInternalBug311337TestLanguage.g:225:2: (otherlv_0= '(ref)' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' () ( (otherlv_4= RULE_ID ) ) )* )
            {
            // PsiInternalBug311337TestLanguage.g:225:2: (otherlv_0= '(ref)' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' () ( (otherlv_4= RULE_ID ) ) )* )
            // PsiInternalBug311337TestLanguage.g:226:3: otherlv_0= '(ref)' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' () ( (otherlv_4= RULE_ID ) ) )*
            {

            			markLeaf(elementTypeProvider.getReference_RefKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalBug311337TestLanguage.g:233:3: ( (otherlv_1= RULE_ID ) )
            // PsiInternalBug311337TestLanguage.g:234:4: (otherlv_1= RULE_ID )
            {
            // PsiInternalBug311337TestLanguage.g:234:4: (otherlv_1= RULE_ID )
            // PsiInternalBug311337TestLanguage.g:235:5: otherlv_1= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getReference_RefChildChildCrossReference_1_0ElementType());
            				
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					doneLeaf(otherlv_1);
            				

            }


            }

            // PsiInternalBug311337TestLanguage.g:250:3: (otherlv_2= ':' () ( (otherlv_4= RULE_ID ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalBug311337TestLanguage.g:251:4: otherlv_2= ':' () ( (otherlv_4= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getReference_ColonKeyword_2_0ElementType());
            	    			
            	    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalBug311337TestLanguage.g:258:4: ()
            	    // PsiInternalBug311337TestLanguage.g:259:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getReference_NestedRefLeftAction_2_1ElementType());
            	    					doneComposite();
            	    					associateWithSemanticElement();
            	    				

            	    }

            	    // PsiInternalBug311337TestLanguage.g:265:4: ( (otherlv_4= RULE_ID ) )
            	    // PsiInternalBug311337TestLanguage.g:266:5: (otherlv_4= RULE_ID )
            	    {
            	    // PsiInternalBug311337TestLanguage.g:266:5: (otherlv_4= RULE_ID )
            	    // PsiInternalBug311337TestLanguage.g:267:6: otherlv_4= RULE_ID
            	    {

            	    						if (!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						markLeaf(elementTypeProvider.getReference_RefChildChildCrossReference_2_2_0ElementType());
            	    					
            	    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            	    						doneLeaf(otherlv_4);
            	    					

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
        return current;
    }
    // $ANTLR end "ruleReference"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000001002L});
    }


}