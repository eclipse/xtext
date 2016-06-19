package org.eclipse.xtext.testlanguages.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalReferenceGrammarTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'spielplatz'", "'{'", "'}'", "'kind'", "'('", "')'", "'erwachsener'", "'spielzeug'", "'ROT'", "'BLAU'", "'GELB'", "'GR\\u00DCN'", "'familie'", "'keyword'", "','"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=6;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=4;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalReferenceGrammarTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalReferenceGrammarTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalReferenceGrammarTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalReferenceGrammarTestLanguage.g"; }



     	private ReferenceGrammarTestLanguageGrammarAccess grammarAccess;
     	
        public InternalReferenceGrammarTestLanguageParser(TokenStream input, ReferenceGrammarTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Spielplatz";	
       	}
       	
       	@Override
       	protected ReferenceGrammarTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleSpielplatz"
    // InternalReferenceGrammarTestLanguage.g:67:1: entryRuleSpielplatz returns [EObject current=null] : iv_ruleSpielplatz= ruleSpielplatz EOF ;
    public final EObject entryRuleSpielplatz() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielplatz = null;


        try {
            // InternalReferenceGrammarTestLanguage.g:68:2: (iv_ruleSpielplatz= ruleSpielplatz EOF )
            // InternalReferenceGrammarTestLanguage.g:69:2: iv_ruleSpielplatz= ruleSpielplatz EOF
            {
             newCompositeNode(grammarAccess.getSpielplatzRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSpielplatz=ruleSpielplatz();

            state._fsp--;

             current =iv_ruleSpielplatz; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpielplatz"


    // $ANTLR start "ruleSpielplatz"
    // InternalReferenceGrammarTestLanguage.g:76:1: ruleSpielplatz returns [EObject current=null] : (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )? ;
    public final EObject ruleSpielplatz() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_groesse_1_0=null;
        Token lv_beschreibung_2_0=null;
        Token otherlv_3=null;
        Token otherlv_8=null;
        EObject lv_kinder_4_0 = null;

        EObject lv_erzieher_5_0 = null;

        EObject lv_spielzeuge_6_0 = null;

        EObject lv_familie_7_0 = null;


         enterRule(); 
            
        try {
            // InternalReferenceGrammarTestLanguage.g:79:28: ( (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )? )
            // InternalReferenceGrammarTestLanguage.g:80:1: (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )?
            {
            // InternalReferenceGrammarTestLanguage.g:80:1: (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalReferenceGrammarTestLanguage.g:80:3: otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}'
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_0, grammarAccess.getSpielplatzAccess().getSpielplatzKeyword_0());
                        
                    // InternalReferenceGrammarTestLanguage.g:84:1: ( (lv_groesse_1_0= RULE_INT ) )
                    // InternalReferenceGrammarTestLanguage.g:85:1: (lv_groesse_1_0= RULE_INT )
                    {
                    // InternalReferenceGrammarTestLanguage.g:85:1: (lv_groesse_1_0= RULE_INT )
                    // InternalReferenceGrammarTestLanguage.g:86:3: lv_groesse_1_0= RULE_INT
                    {
                    lv_groesse_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_4); 

                    			newLeafNode(lv_groesse_1_0, grammarAccess.getSpielplatzAccess().getGroesseINTTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSpielplatzRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"groesse",
                            		lv_groesse_1_0, 
                            		"org.eclipse.xtext.common.Terminals.INT");
                    	    

                    }


                    }

                    // InternalReferenceGrammarTestLanguage.g:102:2: ( (lv_beschreibung_2_0= RULE_STRING ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_STRING) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // InternalReferenceGrammarTestLanguage.g:103:1: (lv_beschreibung_2_0= RULE_STRING )
                            {
                            // InternalReferenceGrammarTestLanguage.g:103:1: (lv_beschreibung_2_0= RULE_STRING )
                            // InternalReferenceGrammarTestLanguage.g:104:3: lv_beschreibung_2_0= RULE_STRING
                            {
                            lv_beschreibung_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_5); 

                            			newLeafNode(lv_beschreibung_2_0, grammarAccess.getSpielplatzAccess().getBeschreibungSTRINGTerminalRuleCall_2_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getSpielplatzRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"beschreibung",
                                    		lv_beschreibung_2_0, 
                                    		"org.eclipse.xtext.common.Terminals.STRING");
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_6); 

                        	newLeafNode(otherlv_3, grammarAccess.getSpielplatzAccess().getLeftCurlyBracketKeyword_3());
                        
                    // InternalReferenceGrammarTestLanguage.g:124:1: ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )*
                    loop2:
                    do {
                        int alt2=5;
                        switch ( input.LA(1) ) {
                        case 14:
                            {
                            alt2=1;
                            }
                            break;
                        case 17:
                            {
                            alt2=2;
                            }
                            break;
                        case 18:
                            {
                            alt2=3;
                            }
                            break;
                        case 23:
                            {
                            alt2=4;
                            }
                            break;

                        }

                        switch (alt2) {
                    	case 1 :
                    	    // InternalReferenceGrammarTestLanguage.g:124:2: ( (lv_kinder_4_0= ruleKind ) )
                    	    {
                    	    // InternalReferenceGrammarTestLanguage.g:124:2: ( (lv_kinder_4_0= ruleKind ) )
                    	    // InternalReferenceGrammarTestLanguage.g:125:1: (lv_kinder_4_0= ruleKind )
                    	    {
                    	    // InternalReferenceGrammarTestLanguage.g:125:1: (lv_kinder_4_0= ruleKind )
                    	    // InternalReferenceGrammarTestLanguage.g:126:3: lv_kinder_4_0= ruleKind
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSpielplatzAccess().getKinderKindParserRuleCall_4_0_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_kinder_4_0=ruleKind();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSpielplatzRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"kinder",
                    	            		lv_kinder_4_0, 
                    	            		"org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguage.Kind");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalReferenceGrammarTestLanguage.g:143:6: ( (lv_erzieher_5_0= ruleErwachsener ) )
                    	    {
                    	    // InternalReferenceGrammarTestLanguage.g:143:6: ( (lv_erzieher_5_0= ruleErwachsener ) )
                    	    // InternalReferenceGrammarTestLanguage.g:144:1: (lv_erzieher_5_0= ruleErwachsener )
                    	    {
                    	    // InternalReferenceGrammarTestLanguage.g:144:1: (lv_erzieher_5_0= ruleErwachsener )
                    	    // InternalReferenceGrammarTestLanguage.g:145:3: lv_erzieher_5_0= ruleErwachsener
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSpielplatzAccess().getErzieherErwachsenerParserRuleCall_4_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_erzieher_5_0=ruleErwachsener();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSpielplatzRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"erzieher",
                    	            		lv_erzieher_5_0, 
                    	            		"org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguage.Erwachsener");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // InternalReferenceGrammarTestLanguage.g:162:6: ( (lv_spielzeuge_6_0= ruleSpielzeug ) )
                    	    {
                    	    // InternalReferenceGrammarTestLanguage.g:162:6: ( (lv_spielzeuge_6_0= ruleSpielzeug ) )
                    	    // InternalReferenceGrammarTestLanguage.g:163:1: (lv_spielzeuge_6_0= ruleSpielzeug )
                    	    {
                    	    // InternalReferenceGrammarTestLanguage.g:163:1: (lv_spielzeuge_6_0= ruleSpielzeug )
                    	    // InternalReferenceGrammarTestLanguage.g:164:3: lv_spielzeuge_6_0= ruleSpielzeug
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSpielplatzAccess().getSpielzeugeSpielzeugParserRuleCall_4_2_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_spielzeuge_6_0=ruleSpielzeug();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSpielplatzRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"spielzeuge",
                    	            		lv_spielzeuge_6_0, 
                    	            		"org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguage.Spielzeug");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // InternalReferenceGrammarTestLanguage.g:181:6: ( (lv_familie_7_0= ruleFamilie ) )
                    	    {
                    	    // InternalReferenceGrammarTestLanguage.g:181:6: ( (lv_familie_7_0= ruleFamilie ) )
                    	    // InternalReferenceGrammarTestLanguage.g:182:1: (lv_familie_7_0= ruleFamilie )
                    	    {
                    	    // InternalReferenceGrammarTestLanguage.g:182:1: (lv_familie_7_0= ruleFamilie )
                    	    // InternalReferenceGrammarTestLanguage.g:183:3: lv_familie_7_0= ruleFamilie
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSpielplatzAccess().getFamilieFamilieParserRuleCall_4_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_familie_7_0=ruleFamilie();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSpielplatzRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"familie",
                    	            		lv_familie_7_0, 
                    	            		"org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguage.Familie");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_8, grammarAccess.getSpielplatzAccess().getRightCurlyBracketKeyword_5());
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpielplatz"


    // $ANTLR start "entryRuleKind"
    // InternalReferenceGrammarTestLanguage.g:213:1: entryRuleKind returns [EObject current=null] : iv_ruleKind= ruleKind EOF ;
    public final EObject entryRuleKind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKind = null;


        try {
            // InternalReferenceGrammarTestLanguage.g:214:2: (iv_ruleKind= ruleKind EOF )
            // InternalReferenceGrammarTestLanguage.g:215:2: iv_ruleKind= ruleKind EOF
            {
             newCompositeNode(grammarAccess.getKindRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleKind=ruleKind();

            state._fsp--;

             current =iv_ruleKind; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKind"


    // $ANTLR start "ruleKind"
    // InternalReferenceGrammarTestLanguage.g:222:1: ruleKind returns [EObject current=null] : (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) ;
    public final EObject ruleKind() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token lv_age_3_0=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalReferenceGrammarTestLanguage.g:225:28: ( (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) )
            // InternalReferenceGrammarTestLanguage.g:226:1: (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            {
            // InternalReferenceGrammarTestLanguage.g:226:1: (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            // InternalReferenceGrammarTestLanguage.g:226:3: otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_7); 

                	newLeafNode(otherlv_0, grammarAccess.getKindAccess().getKindKeyword_0());
                
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_8); 

                	newLeafNode(otherlv_1, grammarAccess.getKindAccess().getLeftParenthesisKeyword_1());
                
            // InternalReferenceGrammarTestLanguage.g:234:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalReferenceGrammarTestLanguage.g:235:1: (lv_name_2_0= RULE_ID )
            {
            // InternalReferenceGrammarTestLanguage.g:235:1: (lv_name_2_0= RULE_ID )
            // InternalReferenceGrammarTestLanguage.g:236:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            			newLeafNode(lv_name_2_0, grammarAccess.getKindAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getKindRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalReferenceGrammarTestLanguage.g:252:2: ( (lv_age_3_0= RULE_INT ) )
            // InternalReferenceGrammarTestLanguage.g:253:1: (lv_age_3_0= RULE_INT )
            {
            // InternalReferenceGrammarTestLanguage.g:253:1: (lv_age_3_0= RULE_INT )
            // InternalReferenceGrammarTestLanguage.g:254:3: lv_age_3_0= RULE_INT
            {
            lv_age_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_9); 

            			newLeafNode(lv_age_3_0, grammarAccess.getKindAccess().getAgeINTTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getKindRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"age",
                    		lv_age_3_0, 
                    		"org.eclipse.xtext.common.Terminals.INT");
            	    

            }


            }

            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getKindAccess().getRightParenthesisKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKind"


    // $ANTLR start "entryRuleErwachsener"
    // InternalReferenceGrammarTestLanguage.g:282:1: entryRuleErwachsener returns [EObject current=null] : iv_ruleErwachsener= ruleErwachsener EOF ;
    public final EObject entryRuleErwachsener() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErwachsener = null;


        try {
            // InternalReferenceGrammarTestLanguage.g:283:2: (iv_ruleErwachsener= ruleErwachsener EOF )
            // InternalReferenceGrammarTestLanguage.g:284:2: iv_ruleErwachsener= ruleErwachsener EOF
            {
             newCompositeNode(grammarAccess.getErwachsenerRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleErwachsener=ruleErwachsener();

            state._fsp--;

             current =iv_ruleErwachsener; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErwachsener"


    // $ANTLR start "ruleErwachsener"
    // InternalReferenceGrammarTestLanguage.g:291:1: ruleErwachsener returns [EObject current=null] : (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) ;
    public final EObject ruleErwachsener() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token lv_age_3_0=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // InternalReferenceGrammarTestLanguage.g:294:28: ( (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) )
            // InternalReferenceGrammarTestLanguage.g:295:1: (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            {
            // InternalReferenceGrammarTestLanguage.g:295:1: (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            // InternalReferenceGrammarTestLanguage.g:295:3: otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_7); 

                	newLeafNode(otherlv_0, grammarAccess.getErwachsenerAccess().getErwachsenerKeyword_0());
                
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_8); 

                	newLeafNode(otherlv_1, grammarAccess.getErwachsenerAccess().getLeftParenthesisKeyword_1());
                
            // InternalReferenceGrammarTestLanguage.g:303:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalReferenceGrammarTestLanguage.g:304:1: (lv_name_2_0= RULE_ID )
            {
            // InternalReferenceGrammarTestLanguage.g:304:1: (lv_name_2_0= RULE_ID )
            // InternalReferenceGrammarTestLanguage.g:305:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            			newLeafNode(lv_name_2_0, grammarAccess.getErwachsenerAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getErwachsenerRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalReferenceGrammarTestLanguage.g:321:2: ( (lv_age_3_0= RULE_INT ) )
            // InternalReferenceGrammarTestLanguage.g:322:1: (lv_age_3_0= RULE_INT )
            {
            // InternalReferenceGrammarTestLanguage.g:322:1: (lv_age_3_0= RULE_INT )
            // InternalReferenceGrammarTestLanguage.g:323:3: lv_age_3_0= RULE_INT
            {
            lv_age_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_9); 

            			newLeafNode(lv_age_3_0, grammarAccess.getErwachsenerAccess().getAgeINTTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getErwachsenerRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"age",
                    		lv_age_3_0, 
                    		"org.eclipse.xtext.common.Terminals.INT");
            	    

            }


            }

            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getErwachsenerAccess().getRightParenthesisKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleErwachsener"


    // $ANTLR start "entryRuleSpielzeug"
    // InternalReferenceGrammarTestLanguage.g:351:1: entryRuleSpielzeug returns [EObject current=null] : iv_ruleSpielzeug= ruleSpielzeug EOF ;
    public final EObject entryRuleSpielzeug() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielzeug = null;


        try {
            // InternalReferenceGrammarTestLanguage.g:352:2: (iv_ruleSpielzeug= ruleSpielzeug EOF )
            // InternalReferenceGrammarTestLanguage.g:353:2: iv_ruleSpielzeug= ruleSpielzeug EOF
            {
             newCompositeNode(grammarAccess.getSpielzeugRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSpielzeug=ruleSpielzeug();

            state._fsp--;

             current =iv_ruleSpielzeug; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpielzeug"


    // $ANTLR start "ruleSpielzeug"
    // InternalReferenceGrammarTestLanguage.g:360:1: ruleSpielzeug returns [EObject current=null] : (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' ) ;
    public final EObject ruleSpielzeug() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_4=null;
        EObject lv_farbe_3_0 = null;


         enterRule(); 
            
        try {
            // InternalReferenceGrammarTestLanguage.g:363:28: ( (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' ) )
            // InternalReferenceGrammarTestLanguage.g:364:1: (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' )
            {
            // InternalReferenceGrammarTestLanguage.g:364:1: (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' )
            // InternalReferenceGrammarTestLanguage.g:364:3: otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_7); 

                	newLeafNode(otherlv_0, grammarAccess.getSpielzeugAccess().getSpielzeugKeyword_0());
                
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_8); 

                	newLeafNode(otherlv_1, grammarAccess.getSpielzeugAccess().getLeftParenthesisKeyword_1());
                
            // InternalReferenceGrammarTestLanguage.g:372:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalReferenceGrammarTestLanguage.g:373:1: (lv_name_2_0= RULE_ID )
            {
            // InternalReferenceGrammarTestLanguage.g:373:1: (lv_name_2_0= RULE_ID )
            // InternalReferenceGrammarTestLanguage.g:374:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

            			newLeafNode(lv_name_2_0, grammarAccess.getSpielzeugAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSpielzeugRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalReferenceGrammarTestLanguage.g:390:2: ( (lv_farbe_3_0= ruleFarbe ) )
            // InternalReferenceGrammarTestLanguage.g:391:1: (lv_farbe_3_0= ruleFarbe )
            {
            // InternalReferenceGrammarTestLanguage.g:391:1: (lv_farbe_3_0= ruleFarbe )
            // InternalReferenceGrammarTestLanguage.g:392:3: lv_farbe_3_0= ruleFarbe
            {
             
            	        newCompositeNode(grammarAccess.getSpielzeugAccess().getFarbeFarbeParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_9);
            lv_farbe_3_0=ruleFarbe();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSpielzeugRule());
            	        }
                   		set(
                   			current, 
                   			"farbe",
                    		lv_farbe_3_0, 
                    		"org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguage.Farbe");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getSpielzeugAccess().getRightParenthesisKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpielzeug"


    // $ANTLR start "entryRuleFarbe"
    // InternalReferenceGrammarTestLanguage.g:420:1: entryRuleFarbe returns [EObject current=null] : iv_ruleFarbe= ruleFarbe EOF ;
    public final EObject entryRuleFarbe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFarbe = null;


        try {
            // InternalReferenceGrammarTestLanguage.g:421:2: (iv_ruleFarbe= ruleFarbe EOF )
            // InternalReferenceGrammarTestLanguage.g:422:2: iv_ruleFarbe= ruleFarbe EOF
            {
             newCompositeNode(grammarAccess.getFarbeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFarbe=ruleFarbe();

            state._fsp--;

             current =iv_ruleFarbe; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFarbe"


    // $ANTLR start "ruleFarbe"
    // InternalReferenceGrammarTestLanguage.g:429:1: ruleFarbe returns [EObject current=null] : ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) ) ;
    public final EObject ruleFarbe() throws RecognitionException {
        EObject current = null;

        Token lv_wert_0_1=null;
        Token lv_wert_0_2=null;
        Token lv_wert_0_3=null;
        Token lv_wert_0_4=null;

         enterRule(); 
            
        try {
            // InternalReferenceGrammarTestLanguage.g:432:28: ( ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) ) )
            // InternalReferenceGrammarTestLanguage.g:433:1: ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) )
            {
            // InternalReferenceGrammarTestLanguage.g:433:1: ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) )
            // InternalReferenceGrammarTestLanguage.g:434:1: ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) )
            {
            // InternalReferenceGrammarTestLanguage.g:434:1: ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) )
            // InternalReferenceGrammarTestLanguage.g:435:1: (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' )
            {
            // InternalReferenceGrammarTestLanguage.g:435:1: (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt4=1;
                }
                break;
            case 20:
                {
                alt4=2;
                }
                break;
            case 21:
                {
                alt4=3;
                }
                break;
            case 22:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalReferenceGrammarTestLanguage.g:436:3: lv_wert_0_1= 'ROT'
                    {
                    lv_wert_0_1=(Token)match(input,19,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_wert_0_1, grammarAccess.getFarbeAccess().getWertROTKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFarbeRule());
                    	        }
                           		setWithLastConsumed(current, "wert", lv_wert_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalReferenceGrammarTestLanguage.g:448:8: lv_wert_0_2= 'BLAU'
                    {
                    lv_wert_0_2=(Token)match(input,20,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_wert_0_2, grammarAccess.getFarbeAccess().getWertBLAUKeyword_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFarbeRule());
                    	        }
                           		setWithLastConsumed(current, "wert", lv_wert_0_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // InternalReferenceGrammarTestLanguage.g:460:8: lv_wert_0_3= 'GELB'
                    {
                    lv_wert_0_3=(Token)match(input,21,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_wert_0_3, grammarAccess.getFarbeAccess().getWertGELBKeyword_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFarbeRule());
                    	        }
                           		setWithLastConsumed(current, "wert", lv_wert_0_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // InternalReferenceGrammarTestLanguage.g:472:8: lv_wert_0_4= 'GR\\u00DCN'
                    {
                    lv_wert_0_4=(Token)match(input,22,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_wert_0_4, grammarAccess.getFarbeAccess().getWertGRÜNKeyword_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFarbeRule());
                    	        }
                           		setWithLastConsumed(current, "wert", lv_wert_0_4, null);
                    	    

                    }
                    break;

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFarbe"


    // $ANTLR start "entryRuleFamilie"
    // InternalReferenceGrammarTestLanguage.g:495:1: entryRuleFamilie returns [EObject current=null] : iv_ruleFamilie= ruleFamilie EOF ;
    public final EObject entryRuleFamilie() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFamilie = null;


        try {
            // InternalReferenceGrammarTestLanguage.g:496:2: (iv_ruleFamilie= ruleFamilie EOF )
            // InternalReferenceGrammarTestLanguage.g:497:2: iv_ruleFamilie= ruleFamilie EOF
            {
             newCompositeNode(grammarAccess.getFamilieRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFamilie=ruleFamilie();

            state._fsp--;

             current =iv_ruleFamilie; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFamilie"


    // $ANTLR start "ruleFamilie"
    // InternalReferenceGrammarTestLanguage.g:504:1: ruleFamilie returns [EObject current=null] : (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' ) ;
    public final EObject ruleFamilie() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_1=null;
        Token lv_name_2_2=null;
        Token lv_name_2_3=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;

         enterRule(); 
            
        try {
            // InternalReferenceGrammarTestLanguage.g:507:28: ( (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' ) )
            // InternalReferenceGrammarTestLanguage.g:508:1: (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' )
            {
            // InternalReferenceGrammarTestLanguage.g:508:1: (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' )
            // InternalReferenceGrammarTestLanguage.g:508:3: otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_7); 

                	newLeafNode(otherlv_0, grammarAccess.getFamilieAccess().getFamilieKeyword_0());
                
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_11); 

                	newLeafNode(otherlv_1, grammarAccess.getFamilieAccess().getLeftParenthesisKeyword_1());
                
            // InternalReferenceGrammarTestLanguage.g:516:1: ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) )
            // InternalReferenceGrammarTestLanguage.g:517:1: ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) )
            {
            // InternalReferenceGrammarTestLanguage.g:517:1: ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) )
            // InternalReferenceGrammarTestLanguage.g:518:1: (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID )
            {
            // InternalReferenceGrammarTestLanguage.g:518:1: (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt5=1;
                }
                break;
            case RULE_STRING:
                {
                alt5=2;
                }
                break;
            case RULE_ID:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalReferenceGrammarTestLanguage.g:519:3: lv_name_2_1= 'keyword'
                    {
                    lv_name_2_1=(Token)match(input,24,FollowSets000.FOLLOW_8); 

                            newLeafNode(lv_name_2_1, grammarAccess.getFamilieAccess().getNameKeywordKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFamilieRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_2_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalReferenceGrammarTestLanguage.g:531:8: lv_name_2_2= RULE_STRING
                    {
                    lv_name_2_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_8); 

                    			newLeafNode(lv_name_2_2, grammarAccess.getFamilieAccess().getNameSTRINGTerminalRuleCall_2_0_1()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFamilieRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_2_2, 
                            		"org.eclipse.xtext.common.Terminals.STRING");
                    	    

                    }
                    break;
                case 3 :
                    // InternalReferenceGrammarTestLanguage.g:546:8: lv_name_2_3= RULE_ID
                    {
                    lv_name_2_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    			newLeafNode(lv_name_2_3, grammarAccess.getFamilieAccess().getNameIDTerminalRuleCall_2_0_2()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFamilieRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_2_3, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }
                    break;

            }


            }


            }

            // InternalReferenceGrammarTestLanguage.g:564:2: ( (otherlv_3= RULE_ID ) )
            // InternalReferenceGrammarTestLanguage.g:565:1: (otherlv_3= RULE_ID )
            {
            // InternalReferenceGrammarTestLanguage.g:565:1: (otherlv_3= RULE_ID )
            // InternalReferenceGrammarTestLanguage.g:566:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFamilieRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            		newLeafNode(otherlv_3, grammarAccess.getFamilieAccess().getMutterErwachsenerCrossReference_3_0()); 
            	

            }


            }

            // InternalReferenceGrammarTestLanguage.g:577:2: ( (otherlv_4= RULE_ID ) )
            // InternalReferenceGrammarTestLanguage.g:578:1: (otherlv_4= RULE_ID )
            {
            // InternalReferenceGrammarTestLanguage.g:578:1: (otherlv_4= RULE_ID )
            // InternalReferenceGrammarTestLanguage.g:579:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFamilieRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            		newLeafNode(otherlv_4, grammarAccess.getFamilieAccess().getVaterErwachsenerCrossReference_4_0()); 
            	

            }


            }

            // InternalReferenceGrammarTestLanguage.g:590:2: ( (otherlv_5= RULE_ID ) )
            // InternalReferenceGrammarTestLanguage.g:591:1: (otherlv_5= RULE_ID )
            {
            // InternalReferenceGrammarTestLanguage.g:591:1: (otherlv_5= RULE_ID )
            // InternalReferenceGrammarTestLanguage.g:592:3: otherlv_5= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFamilieRule());
            	        }
                    
            otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            		newLeafNode(otherlv_5, grammarAccess.getFamilieAccess().getKinderKindCrossReference_5_0()); 
            	

            }


            }

            // InternalReferenceGrammarTestLanguage.g:603:2: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==25) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalReferenceGrammarTestLanguage.g:603:4: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
            	    {
            	    otherlv_6=(Token)match(input,25,FollowSets000.FOLLOW_8); 

            	        	newLeafNode(otherlv_6, grammarAccess.getFamilieAccess().getCommaKeyword_6_0());
            	        
            	    // InternalReferenceGrammarTestLanguage.g:607:1: ( (otherlv_7= RULE_ID ) )
            	    // InternalReferenceGrammarTestLanguage.g:608:1: (otherlv_7= RULE_ID )
            	    {
            	    // InternalReferenceGrammarTestLanguage.g:608:1: (otherlv_7= RULE_ID )
            	    // InternalReferenceGrammarTestLanguage.g:609:3: otherlv_7= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getFamilieRule());
            	    	        }
            	            
            	    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            	    		newLeafNode(otherlv_7, grammarAccess.getFamilieAccess().getKinderKindCrossReference_6_1_0()); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_8, grammarAccess.getFamilieAccess().getRightParenthesisKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFamilie"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001020L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000866000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000780000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001000060L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000002010000L});
    }


}