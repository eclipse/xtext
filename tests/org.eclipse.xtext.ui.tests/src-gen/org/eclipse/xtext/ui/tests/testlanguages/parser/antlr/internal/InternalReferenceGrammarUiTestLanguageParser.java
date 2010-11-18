package org.eclipse.xtext.ui.tests.testlanguages.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.ui.tests.testlanguages.services.ReferenceGrammarUiTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalReferenceGrammarUiTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'spielplatz'", "'{'", "'}'", "'kind'", "'('", "')'", "'erwachsener'", "'spielzeug'", "'ROT'", "'BLAU'", "'GELB'", "'GR\\u00DCN'", "'familie'", "'keyword'", "','"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=6;
    public static final int T__12=12;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=5;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__22=22;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int EOF=-1;
    public static final int RULE_INT=4;
    public static final int T__16=16;
    public static final int T__24=24;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalReferenceGrammarUiTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalReferenceGrammarUiTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalReferenceGrammarUiTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g"; }



     	private ReferenceGrammarUiTestLanguageGrammarAccess grammarAccess;
     	
        public InternalReferenceGrammarUiTestLanguageParser(TokenStream input, IAstFactory factory, ReferenceGrammarUiTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Spielplatz";	
       	}
       	
       	@Override
       	protected ReferenceGrammarUiTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleSpielplatz"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:71:1: entryRuleSpielplatz returns [EObject current=null] : iv_ruleSpielplatz= ruleSpielplatz EOF ;
    public final EObject entryRuleSpielplatz() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielplatz = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:72:2: (iv_ruleSpielplatz= ruleSpielplatz EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:73:2: iv_ruleSpielplatz= ruleSpielplatz EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSpielplatzRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz75);
            iv_ruleSpielplatz=ruleSpielplatz();

            state._fsp--;

             current =iv_ruleSpielplatz; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpielplatz85); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:80:1: ruleSpielplatz returns [EObject current=null] : (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )? ;
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


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:85:6: ( (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:86:1: (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:86:1: (otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:86:3: otherlv_0= 'spielplatz' ( (lv_groesse_1_0= RULE_INT ) ) ( (lv_beschreibung_2_0= RULE_STRING ) )? otherlv_3= '{' ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )* otherlv_8= '}'
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleSpielplatz122); 

                        	createLeafNode(otherlv_0, grammarAccess.getSpielplatzAccess().getSpielplatzKeyword_0(), null);
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:90:1: ( (lv_groesse_1_0= RULE_INT ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:91:1: (lv_groesse_1_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:91:1: (lv_groesse_1_0= RULE_INT )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:92:3: lv_groesse_1_0= RULE_INT
                    {
                    lv_groesse_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleSpielplatz139); 

                    			createLeafNode(lv_groesse_1_0, grammarAccess.getSpielplatzAccess().getGroesseINTTerminalRuleCall_1_0(), "groesse"); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSpielplatzRule());
                    	        }
                           		set(
                           			current, 
                           			"groesse",
                            		lv_groesse_1_0, 
                            		"INT", 
                            		lastConsumedNode);
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:109:2: ( (lv_beschreibung_2_0= RULE_STRING ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_STRING) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:110:1: (lv_beschreibung_2_0= RULE_STRING )
                            {
                            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:110:1: (lv_beschreibung_2_0= RULE_STRING )
                            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:111:3: lv_beschreibung_2_0= RULE_STRING
                            {
                            lv_beschreibung_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSpielplatz161); 

                            			createLeafNode(lv_beschreibung_2_0, grammarAccess.getSpielplatzAccess().getBeschreibungSTRINGTerminalRuleCall_2_0(), "beschreibung"); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getSpielplatzRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"beschreibung",
                                    		lv_beschreibung_2_0, 
                                    		"STRING", 
                                    		lastConsumedNode);
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSpielplatz179); 

                        	createLeafNode(otherlv_3, grammarAccess.getSpielplatzAccess().getLeftCurlyBracketKeyword_3(), null);
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:132:1: ( ( (lv_kinder_4_0= ruleKind ) ) | ( (lv_erzieher_5_0= ruleErwachsener ) ) | ( (lv_spielzeuge_6_0= ruleSpielzeug ) ) | ( (lv_familie_7_0= ruleFamilie ) ) )*
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:132:2: ( (lv_kinder_4_0= ruleKind ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:132:2: ( (lv_kinder_4_0= ruleKind ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:133:1: (lv_kinder_4_0= ruleKind )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:133:1: (lv_kinder_4_0= ruleKind )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:134:3: lv_kinder_4_0= ruleKind
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getSpielplatzAccess().getKinderKindParserRuleCall_4_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleKind_in_ruleSpielplatz201);
                    	    lv_kinder_4_0=ruleKind();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSpielplatzRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"kinder",
                    	            		lv_kinder_4_0, 
                    	            		"Kind", 
                    	            		currentNode);
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:152:6: ( (lv_erzieher_5_0= ruleErwachsener ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:152:6: ( (lv_erzieher_5_0= ruleErwachsener ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:153:1: (lv_erzieher_5_0= ruleErwachsener )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:153:1: (lv_erzieher_5_0= ruleErwachsener )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:154:3: lv_erzieher_5_0= ruleErwachsener
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getSpielplatzAccess().getErzieherErwachsenerParserRuleCall_4_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleErwachsener_in_ruleSpielplatz228);
                    	    lv_erzieher_5_0=ruleErwachsener();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSpielplatzRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"erzieher",
                    	            		lv_erzieher_5_0, 
                    	            		"Erwachsener", 
                    	            		currentNode);
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:172:6: ( (lv_spielzeuge_6_0= ruleSpielzeug ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:172:6: ( (lv_spielzeuge_6_0= ruleSpielzeug ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:173:1: (lv_spielzeuge_6_0= ruleSpielzeug )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:173:1: (lv_spielzeuge_6_0= ruleSpielzeug )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:174:3: lv_spielzeuge_6_0= ruleSpielzeug
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getSpielplatzAccess().getSpielzeugeSpielzeugParserRuleCall_4_2_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleSpielzeug_in_ruleSpielplatz255);
                    	    lv_spielzeuge_6_0=ruleSpielzeug();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSpielplatzRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"spielzeuge",
                    	            		lv_spielzeuge_6_0, 
                    	            		"Spielzeug", 
                    	            		currentNode);
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:192:6: ( (lv_familie_7_0= ruleFamilie ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:192:6: ( (lv_familie_7_0= ruleFamilie ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:193:1: (lv_familie_7_0= ruleFamilie )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:193:1: (lv_familie_7_0= ruleFamilie )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:194:3: lv_familie_7_0= ruleFamilie
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getSpielplatzAccess().getFamilieFamilieParserRuleCall_4_3_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleFamilie_in_ruleSpielplatz282);
                    	    lv_familie_7_0=ruleFamilie();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSpielplatzRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"familie",
                    	            		lv_familie_7_0, 
                    	            		"Familie", 
                    	            		currentNode);
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSpielplatz296); 

                        	createLeafNode(otherlv_8, grammarAccess.getSpielplatzAccess().getRightCurlyBracketKeyword_5(), null);
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:225:1: entryRuleKind returns [EObject current=null] : iv_ruleKind= ruleKind EOF ;
    public final EObject entryRuleKind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKind = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:226:2: (iv_ruleKind= ruleKind EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:227:2: iv_ruleKind= ruleKind EOF
            {
             currentNode = createCompositeNode(grammarAccess.getKindRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleKind_in_entryRuleKind335);
            iv_ruleKind=ruleKind();

            state._fsp--;

             current =iv_ruleKind; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleKind345); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:234:1: ruleKind returns [EObject current=null] : (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) ;
    public final EObject ruleKind() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token lv_age_3_0=null;
        Token otherlv_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:239:6: ( (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:240:1: (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:240:1: (otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:240:3: otherlv_0= 'kind' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleKind382); 

                	createLeafNode(otherlv_0, grammarAccess.getKindAccess().getKindKeyword_0(), null);
                
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleKind394); 

                	createLeafNode(otherlv_1, grammarAccess.getKindAccess().getLeftParenthesisKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:248:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:249:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:249:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:250:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleKind411); 

            			createLeafNode(lv_name_2_0, grammarAccess.getKindAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getKindRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID", 
                    		lastConsumedNode);
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:267:2: ( (lv_age_3_0= RULE_INT ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:268:1: (lv_age_3_0= RULE_INT )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:268:1: (lv_age_3_0= RULE_INT )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:269:3: lv_age_3_0= RULE_INT
            {
            lv_age_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleKind433); 

            			createLeafNode(lv_age_3_0, grammarAccess.getKindAccess().getAgeINTTerminalRuleCall_3_0(), "age"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getKindRule());
            	        }
                   		set(
                   			current, 
                   			"age",
                    		lv_age_3_0, 
                    		"INT", 
                    		lastConsumedNode);
            	    

            }


            }

            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleKind450); 

                	createLeafNode(otherlv_4, grammarAccess.getKindAccess().getRightParenthesisKeyword_4(), null);
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:298:1: entryRuleErwachsener returns [EObject current=null] : iv_ruleErwachsener= ruleErwachsener EOF ;
    public final EObject entryRuleErwachsener() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErwachsener = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:299:2: (iv_ruleErwachsener= ruleErwachsener EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:300:2: iv_ruleErwachsener= ruleErwachsener EOF
            {
             currentNode = createCompositeNode(grammarAccess.getErwachsenerRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleErwachsener_in_entryRuleErwachsener486);
            iv_ruleErwachsener=ruleErwachsener();

            state._fsp--;

             current =iv_ruleErwachsener; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleErwachsener496); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:307:1: ruleErwachsener returns [EObject current=null] : (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) ;
    public final EObject ruleErwachsener() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token lv_age_3_0=null;
        Token otherlv_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:312:6: ( (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:313:1: (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:313:1: (otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:313:3: otherlv_0= 'erwachsener' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_age_3_0= RULE_INT ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleErwachsener533); 

                	createLeafNode(otherlv_0, grammarAccess.getErwachsenerAccess().getErwachsenerKeyword_0(), null);
                
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleErwachsener545); 

                	createLeafNode(otherlv_1, grammarAccess.getErwachsenerAccess().getLeftParenthesisKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:321:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:322:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:322:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:323:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleErwachsener562); 

            			createLeafNode(lv_name_2_0, grammarAccess.getErwachsenerAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getErwachsenerRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID", 
                    		lastConsumedNode);
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:340:2: ( (lv_age_3_0= RULE_INT ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:341:1: (lv_age_3_0= RULE_INT )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:341:1: (lv_age_3_0= RULE_INT )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:342:3: lv_age_3_0= RULE_INT
            {
            lv_age_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleErwachsener584); 

            			createLeafNode(lv_age_3_0, grammarAccess.getErwachsenerAccess().getAgeINTTerminalRuleCall_3_0(), "age"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getErwachsenerRule());
            	        }
                   		set(
                   			current, 
                   			"age",
                    		lv_age_3_0, 
                    		"INT", 
                    		lastConsumedNode);
            	    

            }


            }

            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleErwachsener601); 

                	createLeafNode(otherlv_4, grammarAccess.getErwachsenerAccess().getRightParenthesisKeyword_4(), null);
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:371:1: entryRuleSpielzeug returns [EObject current=null] : iv_ruleSpielzeug= ruleSpielzeug EOF ;
    public final EObject entryRuleSpielzeug() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielzeug = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:372:2: (iv_ruleSpielzeug= ruleSpielzeug EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:373:2: iv_ruleSpielzeug= ruleSpielzeug EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSpielzeugRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug637);
            iv_ruleSpielzeug=ruleSpielzeug();

            state._fsp--;

             current =iv_ruleSpielzeug; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpielzeug647); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:380:1: ruleSpielzeug returns [EObject current=null] : (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' ) ;
    public final EObject ruleSpielzeug() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_4=null;
        EObject lv_farbe_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:385:6: ( (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:386:1: (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:386:1: (otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:386:3: otherlv_0= 'spielzeug' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) ( (lv_farbe_3_0= ruleFarbe ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSpielzeug684); 

                	createLeafNode(otherlv_0, grammarAccess.getSpielzeugAccess().getSpielzeugKeyword_0(), null);
                
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSpielzeug696); 

                	createLeafNode(otherlv_1, grammarAccess.getSpielzeugAccess().getLeftParenthesisKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:394:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:395:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:395:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:396:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSpielzeug713); 

            			createLeafNode(lv_name_2_0, grammarAccess.getSpielzeugAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSpielzeugRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID", 
                    		lastConsumedNode);
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:413:2: ( (lv_farbe_3_0= ruleFarbe ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:414:1: (lv_farbe_3_0= ruleFarbe )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:414:1: (lv_farbe_3_0= ruleFarbe )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:415:3: lv_farbe_3_0= ruleFarbe
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSpielzeugAccess().getFarbeFarbeParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFarbe_in_ruleSpielzeug739);
            lv_farbe_3_0=ruleFarbe();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSpielzeugRule());
            	        }
                   		set(
                   			current, 
                   			"farbe",
                    		lv_farbe_3_0, 
                    		"Farbe", 
                    		currentNode);
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSpielzeug751); 

                	createLeafNode(otherlv_4, grammarAccess.getSpielzeugAccess().getRightParenthesisKeyword_4(), null);
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:444:1: entryRuleFarbe returns [EObject current=null] : iv_ruleFarbe= ruleFarbe EOF ;
    public final EObject entryRuleFarbe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFarbe = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:445:2: (iv_ruleFarbe= ruleFarbe EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:446:2: iv_ruleFarbe= ruleFarbe EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFarbeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFarbe_in_entryRuleFarbe787);
            iv_ruleFarbe=ruleFarbe();

            state._fsp--;

             current =iv_ruleFarbe; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFarbe797); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:453:1: ruleFarbe returns [EObject current=null] : ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) ) ;
    public final EObject ruleFarbe() throws RecognitionException {
        EObject current = null;

        Token lv_wert_0_1=null;
        Token lv_wert_0_2=null;
        Token lv_wert_0_3=null;
        Token lv_wert_0_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:458:6: ( ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:459:1: ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:459:1: ( ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:460:1: ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:460:1: ( (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:461:1: (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:461:1: (lv_wert_0_1= 'ROT' | lv_wert_0_2= 'BLAU' | lv_wert_0_3= 'GELB' | lv_wert_0_4= 'GR\\u00DCN' )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:462:3: lv_wert_0_1= 'ROT'
                    {
                    lv_wert_0_1=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleFarbe841); 

                            createLeafNode(lv_wert_0_1, grammarAccess.getFarbeAccess().getWertROTKeyword_0_0(), "wert");
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFarbeRule());
                    	        }
                           		set(current, "wert", lv_wert_0_1, null, lastConsumedNode);
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:474:8: lv_wert_0_2= 'BLAU'
                    {
                    lv_wert_0_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleFarbe870); 

                            createLeafNode(lv_wert_0_2, grammarAccess.getFarbeAccess().getWertBLAUKeyword_0_1(), "wert");
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFarbeRule());
                    	        }
                           		set(current, "wert", lv_wert_0_2, null, lastConsumedNode);
                    	    

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:486:8: lv_wert_0_3= 'GELB'
                    {
                    lv_wert_0_3=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleFarbe899); 

                            createLeafNode(lv_wert_0_3, grammarAccess.getFarbeAccess().getWertGELBKeyword_0_2(), "wert");
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFarbeRule());
                    	        }
                           		set(current, "wert", lv_wert_0_3, null, lastConsumedNode);
                    	    

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:498:8: lv_wert_0_4= 'GR\\u00DCN'
                    {
                    lv_wert_0_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleFarbe928); 

                            createLeafNode(lv_wert_0_4, grammarAccess.getFarbeAccess().getWertGRÜNKeyword_0_3(), "wert");
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFarbeRule());
                    	        }
                           		set(current, "wert", lv_wert_0_4, null, lastConsumedNode);
                    	    

                    }
                    break;

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:521:1: entryRuleFamilie returns [EObject current=null] : iv_ruleFamilie= ruleFamilie EOF ;
    public final EObject entryRuleFamilie() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFamilie = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:522:2: (iv_ruleFamilie= ruleFamilie EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:523:2: iv_ruleFamilie= ruleFamilie EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFamilieRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFamilie_in_entryRuleFamilie979);
            iv_ruleFamilie=ruleFamilie();

            state._fsp--;

             current =iv_ruleFamilie; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFamilie989); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:530:1: ruleFamilie returns [EObject current=null] : (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' ) ;
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

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:535:6: ( (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:536:1: (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:536:1: (otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:536:3: otherlv_0= 'familie' otherlv_1= '(' ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) ) ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleFamilie1026); 

                	createLeafNode(otherlv_0, grammarAccess.getFamilieAccess().getFamilieKeyword_0(), null);
                
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleFamilie1038); 

                	createLeafNode(otherlv_1, grammarAccess.getFamilieAccess().getLeftParenthesisKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:544:1: ( ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:545:1: ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:545:1: ( (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:546:1: (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:546:1: (lv_name_2_1= 'keyword' | lv_name_2_2= RULE_STRING | lv_name_2_3= RULE_ID )
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:547:3: lv_name_2_1= 'keyword'
                    {
                    lv_name_2_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleFamilie1058); 

                            createLeafNode(lv_name_2_1, grammarAccess.getFamilieAccess().getNameKeywordKeyword_2_0_0(), "name");
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFamilieRule());
                    	        }
                           		set(current, "name", lv_name_2_1, null, lastConsumedNode);
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:559:8: lv_name_2_2= RULE_STRING
                    {
                    lv_name_2_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFamilie1086); 

                    			createLeafNode(lv_name_2_2, grammarAccess.getFamilieAccess().getNameSTRINGTerminalRuleCall_2_0_1(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFamilieRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_2_2, 
                            		"STRING", 
                            		lastConsumedNode);
                    	    

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:575:8: lv_name_2_3= RULE_ID
                    {
                    lv_name_2_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFamilie1106); 

                    			createLeafNode(lv_name_2_3, grammarAccess.getFamilieAccess().getNameIDTerminalRuleCall_2_0_2(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFamilieRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_2_3, 
                            		"ID", 
                            		lastConsumedNode);
                    	    

                    }
                    break;

            }


            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:594:2: ( (otherlv_3= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:595:1: (otherlv_3= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:595:1: (otherlv_3= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:596:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFamilieRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFamilie1134); 

            		createLeafNode(otherlv_3, grammarAccess.getFamilieAccess().getMutterErwachsenerCrossReference_3_0(), "mutter"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:607:2: ( (otherlv_4= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:608:1: (otherlv_4= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:608:1: (otherlv_4= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:609:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFamilieRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFamilie1154); 

            		createLeafNode(otherlv_4, grammarAccess.getFamilieAccess().getVaterErwachsenerCrossReference_4_0(), "vater"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:620:2: ( (otherlv_5= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:621:1: (otherlv_5= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:621:1: (otherlv_5= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:622:3: otherlv_5= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFamilieRule());
            	        }
                    
            otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFamilie1174); 

            		createLeafNode(otherlv_5, grammarAccess.getFamilieAccess().getKinderKindCrossReference_5_0(), "kinder"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:633:2: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==25) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:633:4: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
            	    {
            	    otherlv_6=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleFamilie1187); 

            	        	createLeafNode(otherlv_6, grammarAccess.getFamilieAccess().getCommaKeyword_6_0(), null);
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:637:1: ( (otherlv_7= RULE_ID ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:638:1: (otherlv_7= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:638:1: (otherlv_7= RULE_ID )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalReferenceGrammarUiTestLanguage.g:639:3: otherlv_7= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getFamilieRule());
            	    	        }
            	            
            	    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFamilie1207); 

            	    		createLeafNode(otherlv_7, grammarAccess.getFamilieAccess().getKinderKindCrossReference_6_1_0(), "kinder"); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleFamilie1221); 

                	createLeafNode(otherlv_8, grammarAccess.getFamilieAccess().getRightParenthesisKeyword_7(), null);
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
        public static final BitSet FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpielplatz85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleSpielplatz122 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleSpielplatz139 = new BitSet(new long[]{0x0000000000001020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSpielplatz161 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSpielplatz179 = new BitSet(new long[]{0x0000000000866000L});
        public static final BitSet FOLLOW_ruleKind_in_ruleSpielplatz201 = new BitSet(new long[]{0x0000000000866000L});
        public static final BitSet FOLLOW_ruleErwachsener_in_ruleSpielplatz228 = new BitSet(new long[]{0x0000000000866000L});
        public static final BitSet FOLLOW_ruleSpielzeug_in_ruleSpielplatz255 = new BitSet(new long[]{0x0000000000866000L});
        public static final BitSet FOLLOW_ruleFamilie_in_ruleSpielplatz282 = new BitSet(new long[]{0x0000000000866000L});
        public static final BitSet FOLLOW_13_in_ruleSpielplatz296 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKind_in_entryRuleKind335 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleKind345 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleKind382 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleKind394 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleKind411 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleKind433 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleKind450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleErwachsener_in_entryRuleErwachsener486 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleErwachsener496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleErwachsener533 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleErwachsener545 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleErwachsener562 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleErwachsener584 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleErwachsener601 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug637 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpielzeug647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleSpielzeug684 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleSpielzeug696 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSpielzeug713 = new BitSet(new long[]{0x0000000000780000L});
        public static final BitSet FOLLOW_ruleFarbe_in_ruleSpielzeug739 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleSpielzeug751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFarbe_in_entryRuleFarbe787 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFarbe797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleFarbe841 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleFarbe870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleFarbe899 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleFarbe928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFamilie_in_entryRuleFamilie979 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFamilie989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleFamilie1026 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleFamilie1038 = new BitSet(new long[]{0x0000000001000060L});
        public static final BitSet FOLLOW_24_in_ruleFamilie1058 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFamilie1086 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1106 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1134 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1154 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1174 = new BitSet(new long[]{0x0000000002010000L});
        public static final BitSet FOLLOW_25_in_ruleFamilie1187 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1207 = new BitSet(new long[]{0x0000000002010000L});
        public static final BitSet FOLLOW_16_in_ruleFamilie1221 = new BitSet(new long[]{0x0000000000000002L});
    }


}