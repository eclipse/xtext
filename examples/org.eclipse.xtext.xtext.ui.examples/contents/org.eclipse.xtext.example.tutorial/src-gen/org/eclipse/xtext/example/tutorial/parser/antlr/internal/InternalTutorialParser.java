package org.eclipse.xtext.example.tutorial.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.example.tutorial.services.TutorialGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalTutorialParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_HEX", "RULE_INT", "RULE_DECIMAL", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'{'", "'}'", "'import'", "'.*'", "'datatype'", "'entity'", "'extends'", "':'", "'='", "'+='", "'||'", "'&&'", "'=='", "'!='", "'instanceof'", "'>='", "'<='", "'>'", "'<'", "'->'", "'..'", "'+'", "'-'", "'*'", "'**'", "'/'", "'%'", "'!'", "'as'", "'.'", "'?.'", "'*.'", "','", "'('", "')'", "'['", "'|'", "']'", "';'", "'if'", "'else'", "'switch'", "'default'", "'case'", "'for'", "'while'", "'do'", "'var'", "'val'", "'super'", "'::'", "'new'", "'false'", "'true'", "'null'", "'typeof'", "'throw'", "'return'", "'try'", "'finally'", "'catch'", "'=>'", "'?'", "'&'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=8;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int RULE_HEX=5;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__15=15;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int RULE_INT=6;
    public static final int RULE_DECIMAL=7;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=4;
    public static final int T__32=32;
    public static final int T__71=71;
    public static final int T__33=33;
    public static final int T__72=72;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=11;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__77=77;

    // delegates
    // delegators


        public InternalTutorialParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTutorialParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTutorialParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g"; }



     	private TutorialGrammarAccess grammarAccess;
     	
        public InternalTutorialParser(TokenStream input, TutorialGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "DomainModelTutorial";	
       	}
       	
       	@Override
       	protected TutorialGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleDomainModelTutorial"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:67:1: entryRuleDomainModelTutorial returns [EObject current=null] : iv_ruleDomainModelTutorial= ruleDomainModelTutorial EOF ;
    public final EObject entryRuleDomainModelTutorial() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomainModelTutorial = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:68:2: (iv_ruleDomainModelTutorial= ruleDomainModelTutorial EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:69:2: iv_ruleDomainModelTutorial= ruleDomainModelTutorial EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDomainModelTutorialRule()); 
            }
            pushFollow(FOLLOW_ruleDomainModelTutorial_in_entryRuleDomainModelTutorial75);
            iv_ruleDomainModelTutorial=ruleDomainModelTutorial();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDomainModelTutorial; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDomainModelTutorial85); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDomainModelTutorial"


    // $ANTLR start "ruleDomainModelTutorial"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:76:1: ruleDomainModelTutorial returns [EObject current=null] : ( (lv_elements_0_0= ruleAbstractElement ) )* ;
    public final EObject ruleDomainModelTutorial() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:79:28: ( ( (lv_elements_0_0= ruleAbstractElement ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:80:1: ( (lv_elements_0_0= ruleAbstractElement ) )*
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:80:1: ( (lv_elements_0_0= ruleAbstractElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13||LA1_0==16||(LA1_0>=18 && LA1_0<=19)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:81:1: (lv_elements_0_0= ruleAbstractElement )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:81:1: (lv_elements_0_0= ruleAbstractElement )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:82:3: lv_elements_0_0= ruleAbstractElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDomainModelTutorialAccess().getElementsAbstractElementParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAbstractElement_in_ruleDomainModelTutorial130);
            	    lv_elements_0_0=ruleAbstractElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getDomainModelTutorialRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_0_0, 
            	              		"AbstractElement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleDomainModelTutorial"


    // $ANTLR start "entryRulePackageDeclaration"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:106:1: entryRulePackageDeclaration returns [EObject current=null] : iv_rulePackageDeclaration= rulePackageDeclaration EOF ;
    public final EObject entryRulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDeclaration = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:107:2: (iv_rulePackageDeclaration= rulePackageDeclaration EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:108:2: iv_rulePackageDeclaration= rulePackageDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPackageDeclarationRule()); 
            }
            pushFollow(FOLLOW_rulePackageDeclaration_in_entryRulePackageDeclaration166);
            iv_rulePackageDeclaration=rulePackageDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePackageDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageDeclaration176); if (state.failed) return current;

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
    // $ANTLR end "entryRulePackageDeclaration"


    // $ANTLR start "rulePackageDeclaration"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:115:1: rulePackageDeclaration returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' ) ;
    public final EObject rulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:118:28: ( (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:119:1: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:119:1: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:119:3: otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_rulePackageDeclaration213); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:123:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:124:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:124:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:125:3: lv_name_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_rulePackageDeclaration234);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"QualifiedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_rulePackageDeclaration246); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getPackageDeclarationAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:145:1: ( (lv_elements_3_0= ruleAbstractElement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13||LA2_0==16||(LA2_0>=18 && LA2_0<=19)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:146:1: (lv_elements_3_0= ruleAbstractElement )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:146:1: (lv_elements_3_0= ruleAbstractElement )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:147:3: lv_elements_3_0= ruleAbstractElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPackageDeclarationAccess().getElementsAbstractElementParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAbstractElement_in_rulePackageDeclaration267);
            	    lv_elements_3_0=ruleAbstractElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_3_0, 
            	              		"AbstractElement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_rulePackageDeclaration280); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getPackageDeclarationAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "rulePackageDeclaration"


    // $ANTLR start "entryRuleAbstractElement"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:175:1: entryRuleAbstractElement returns [EObject current=null] : iv_ruleAbstractElement= ruleAbstractElement EOF ;
    public final EObject entryRuleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractElement = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:176:2: (iv_ruleAbstractElement= ruleAbstractElement EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:177:2: iv_ruleAbstractElement= ruleAbstractElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAbstractElementRule()); 
            }
            pushFollow(FOLLOW_ruleAbstractElement_in_entryRuleAbstractElement316);
            iv_ruleAbstractElement=ruleAbstractElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAbstractElement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractElement326); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAbstractElement"


    // $ANTLR start "ruleAbstractElement"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:184:1: ruleAbstractElement returns [EObject current=null] : (this_PackageDeclaration_0= rulePackageDeclaration | this_Type_1= ruleType | this_Import_2= ruleImport ) ;
    public final EObject ruleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject this_PackageDeclaration_0 = null;

        EObject this_Type_1 = null;

        EObject this_Import_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:187:28: ( (this_PackageDeclaration_0= rulePackageDeclaration | this_Type_1= ruleType | this_Import_2= ruleImport ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:188:1: (this_PackageDeclaration_0= rulePackageDeclaration | this_Type_1= ruleType | this_Import_2= ruleImport )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:188:1: (this_PackageDeclaration_0= rulePackageDeclaration | this_Type_1= ruleType | this_Import_2= ruleImport )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt3=1;
                }
                break;
            case 18:
            case 19:
                {
                alt3=2;
                }
                break;
            case 16:
                {
                alt3=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:189:5: this_PackageDeclaration_0= rulePackageDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAbstractElementAccess().getPackageDeclarationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePackageDeclaration_in_ruleAbstractElement373);
                    this_PackageDeclaration_0=rulePackageDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PackageDeclaration_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:199:5: this_Type_1= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAbstractElementAccess().getTypeParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleAbstractElement400);
                    this_Type_1=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Type_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:209:5: this_Import_2= ruleImport
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAbstractElementAccess().getImportParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleImport_in_ruleAbstractElement427);
                    this_Import_2=ruleImport();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Import_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAbstractElement"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:225:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:226:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:227:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport462);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport472); if (state.failed) return current;

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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:234:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:237:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:238:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:238:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:238:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleImport509); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:242:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:243:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:243:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:244:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_ruleImport530);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildcard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getImportRule());
              	        }
                     		set(
                     			current, 
                     			"importedNamespace",
                      		lv_importedNamespace_1_0, 
                      		"QualifiedNameWithWildcard");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:268:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:269:2: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:270:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard567);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildcard.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard578); if (state.failed) return current;

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
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:277:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:280:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:281:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:281:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:282:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard625);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:292:1: (kw= '.*' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:293:2: kw= '.*'
                    {
                    kw=(Token)match(input,17,FOLLOW_17_in_ruleQualifiedNameWithWildcard644); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "entryRuleType"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:306:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:307:2: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:308:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType686);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType696); if (state.failed) return current;

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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:315:1: ruleType returns [EObject current=null] : (this_DataType_0= ruleDataType | this_Entity_1= ruleEntity ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_DataType_0 = null;

        EObject this_Entity_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:318:28: ( (this_DataType_0= ruleDataType | this_Entity_1= ruleEntity ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:319:1: (this_DataType_0= ruleDataType | this_Entity_1= ruleEntity )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:319:1: (this_DataType_0= ruleDataType | this_Entity_1= ruleEntity )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            else if ( (LA5_0==19) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:320:5: this_DataType_0= ruleDataType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAccess().getDataTypeParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDataType_in_ruleType743);
                    this_DataType_0=ruleDataType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_DataType_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:330:5: this_Entity_1= ruleEntity
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAccess().getEntityParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEntity_in_ruleType770);
                    this_Entity_1=ruleEntity();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Entity_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleDataType"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:346:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:347:2: (iv_ruleDataType= ruleDataType EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:348:2: iv_ruleDataType= ruleDataType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataTypeRule()); 
            }
            pushFollow(FOLLOW_ruleDataType_in_entryRuleDataType805);
            iv_ruleDataType=ruleDataType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataType815); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDataType"


    // $ANTLR start "ruleDataType"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:355:1: ruleDataType returns [EObject current=null] : (otherlv_0= 'datatype' ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:358:28: ( (otherlv_0= 'datatype' ( (lv_name_1_0= ruleValidID ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:359:1: (otherlv_0= 'datatype' ( (lv_name_1_0= ruleValidID ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:359:1: (otherlv_0= 'datatype' ( (lv_name_1_0= ruleValidID ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:359:3: otherlv_0= 'datatype' ( (lv_name_1_0= ruleValidID ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleDataType852); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDataTypeAccess().getDatatypeKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:363:1: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:364:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:364:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:365:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDataTypeAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleDataType873);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDataTypeRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ValidID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleDataType"


    // $ANTLR start "entryRuleEntity"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:389:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:390:2: (iv_ruleEntity= ruleEntity EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:391:2: iv_ruleEntity= ruleEntity EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEntityRule()); 
            }
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity909);
            iv_ruleEntity=ruleEntity();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEntity; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity919); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:398:1: ruleEntity returns [EObject current=null] : (otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleProperty ) )* otherlv_6= '}' ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_features_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:401:28: ( (otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleProperty ) )* otherlv_6= '}' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:402:1: (otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleProperty ) )* otherlv_6= '}' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:402:1: (otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleProperty ) )* otherlv_6= '}' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:402:3: otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleProperty ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleEntity956); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEntityAccess().getEntityKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:406:1: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:407:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:407:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:408:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEntityAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleEntity977);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getEntityRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ValidID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:424:2: (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:424:4: otherlv_2= 'extends' ( ( ruleQualifiedName ) )
                    {
                    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleEntity990); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getEntityAccess().getExtendsKeyword_2_0());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:428:1: ( ( ruleQualifiedName ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:429:1: ( ruleQualifiedName )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:429:1: ( ruleQualifiedName )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:430:3: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getEntityRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEntityAccess().getSuperTypeEntityCrossReference_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleEntity1013);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleEntity1027); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:447:1: ( (lv_features_5_0= ruleProperty ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:448:1: (lv_features_5_0= ruleProperty )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:448:1: (lv_features_5_0= ruleProperty )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:449:3: lv_features_5_0= ruleProperty
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEntityAccess().getFeaturesPropertyParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleProperty_in_ruleEntity1048);
            	    lv_features_5_0=ruleProperty();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEntityRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"features",
            	              		lv_features_5_0, 
            	              		"Property");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleEntity1061); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleProperty"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:477:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:478:2: (iv_ruleProperty= ruleProperty EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:479:2: iv_ruleProperty= ruleProperty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyRule()); 
            }
            pushFollow(FOLLOW_ruleProperty_in_entryRuleProperty1097);
            iv_ruleProperty=ruleProperty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProperty; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProperty1107); if (state.failed) return current;

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
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:486:1: ruleProperty returns [EObject current=null] : ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:489:28: ( ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( ( ruleQualifiedName ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:490:1: ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( ( ruleQualifiedName ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:490:1: ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( ( ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:490:2: ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( ( ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:490:2: ( (lv_name_0_0= ruleValidID ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:491:1: (lv_name_0_0= ruleValidID )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:491:1: (lv_name_0_0= ruleValidID )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:492:3: lv_name_0_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropertyAccess().getNameValidIDParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleProperty1153);
            lv_name_0_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPropertyRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ValidID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleProperty1165); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPropertyAccess().getColonKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:512:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:513:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:513:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:514:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPropertyRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropertyAccess().getTypeTypeCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleProperty1188);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleProperty"


    // $ANTLR start "entryRuleXExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:535:1: entryRuleXExpression returns [EObject current=null] : iv_ruleXExpression= ruleXExpression EOF ;
    public final EObject entryRuleXExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:536:2: (iv_ruleXExpression= ruleXExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:537:2: iv_ruleXExpression= ruleXExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXExpression_in_entryRuleXExpression1224);
            iv_ruleXExpression=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpression1234); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXExpression"


    // $ANTLR start "ruleXExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:544:1: ruleXExpression returns [EObject current=null] : this_XAssignment_0= ruleXAssignment ;
    public final EObject ruleXExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAssignment_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:547:28: (this_XAssignment_0= ruleXAssignment )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:549:5: this_XAssignment_0= ruleXAssignment
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleXAssignment_in_ruleXExpression1280);
            this_XAssignment_0=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAssignment_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXExpression"


    // $ANTLR start "entryRuleXAssignment"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:565:1: entryRuleXAssignment returns [EObject current=null] : iv_ruleXAssignment= ruleXAssignment EOF ;
    public final EObject entryRuleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAssignment = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:566:2: (iv_ruleXAssignment= ruleXAssignment EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:567:2: iv_ruleXAssignment= ruleXAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleXAssignment_in_entryRuleXAssignment1314);
            iv_ruleXAssignment=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAssignment1324); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXAssignment"


    // $ANTLR start "ruleXAssignment"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:574:1: ruleXAssignment returns [EObject current=null] : ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) ;
    public final EObject ruleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject lv_value_3_0 = null;

        EObject this_XOrExpression_4 = null;

        EObject lv_rightOperand_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:577:28: ( ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:578:1: ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:578:1: ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==22) ) {
                    alt9=1;
                }
                else if ( (LA9_1==EOF||(LA9_1>=RULE_STRING && LA9_1<=RULE_ID)||(LA9_1>=14 && LA9_1<=15)||LA9_1==21||(LA9_1>=23 && LA9_1<=49)||(LA9_1>=51 && LA9_1<=75)) ) {
                    alt9=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA9_0>=RULE_STRING && LA9_0<=RULE_DECIMAL)||LA9_0==14||LA9_0==32||(LA9_0>=35 && LA9_0<=36)||LA9_0==41||LA9_0==47||LA9_0==49||LA9_0==53||LA9_0==55||(LA9_0>=58 && LA9_0<=60)||LA9_0==63||(LA9_0>=65 && LA9_0<=72)) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:578:2: ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:578:2: ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:578:3: () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:578:3: ()
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:579:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXAssignmentAccess().getXAssignmentAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:584:2: ( ( ruleValidID ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:585:1: ( ruleValidID )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:585:1: ( ruleValidID )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:586:3: ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXAssignmentRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXAssignment1382);
                    ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAssignmentAccess().getOpSingleAssignParserRuleCall_0_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXAssignment1398);
                    ruleOpSingleAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:607:1: ( (lv_value_3_0= ruleXAssignment ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:608:1: (lv_value_3_0= ruleXAssignment )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:608:1: (lv_value_3_0= ruleXAssignment )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:609:3: lv_value_3_0= ruleXAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_0_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment1418);
                    lv_value_3_0=ruleXAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXAssignmentRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_3_0, 
                              		"XAssignment");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:626:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:626:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:627:5: this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXOrExpression_in_ruleXAssignment1448);
                    this_XOrExpression_4=ruleXOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XOrExpression_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:635:1: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==23) ) {
                        int LA8_1 = input.LA(2);

                        if ( (synpred1_InternalTutorial()) ) {
                            alt8=1;
                        }
                    }
                    switch (alt8) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:635:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:635:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:635:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:640:6: ( () ( ( ruleOpMultiAssign ) ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:640:7: () ( ( ruleOpMultiAssign ) )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:640:7: ()
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:641:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
                                          current);
                                  
                            }

                            }

                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:646:2: ( ( ruleOpMultiAssign ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:647:1: ( ruleOpMultiAssign )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:647:1: ( ruleOpMultiAssign )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:648:3: ruleOpMultiAssign
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getXAssignmentRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleOpMultiAssign_in_ruleXAssignment1501);
                            ruleOpMultiAssign();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }


                            }

                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:661:4: ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:662:1: (lv_rightOperand_7_0= ruleXAssignment )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:662:1: (lv_rightOperand_7_0= ruleXAssignment )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:663:3: lv_rightOperand_7_0= ruleXAssignment
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getRightOperandXAssignmentParserRuleCall_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment1524);
                            lv_rightOperand_7_0=ruleXAssignment();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXAssignmentRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"rightOperand",
                                      		lv_rightOperand_7_0, 
                                      		"XAssignment");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXAssignment"


    // $ANTLR start "entryRuleOpSingleAssign"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:687:1: entryRuleOpSingleAssign returns [String current=null] : iv_ruleOpSingleAssign= ruleOpSingleAssign EOF ;
    public final String entryRuleOpSingleAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpSingleAssign = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:688:2: (iv_ruleOpSingleAssign= ruleOpSingleAssign EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:689:2: iv_ruleOpSingleAssign= ruleOpSingleAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpSingleAssignRule()); 
            }
            pushFollow(FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign1564);
            iv_ruleOpSingleAssign=ruleOpSingleAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpSingleAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpSingleAssign1575); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpSingleAssign"


    // $ANTLR start "ruleOpSingleAssign"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:696:1: ruleOpSingleAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleOpSingleAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:699:28: (kw= '=' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:701:2: kw= '='
            {
            kw=(Token)match(input,22,FOLLOW_22_in_ruleOpSingleAssign1612); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpSingleAssignAccess().getEqualsSignKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpSingleAssign"


    // $ANTLR start "entryRuleOpMultiAssign"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:714:1: entryRuleOpMultiAssign returns [String current=null] : iv_ruleOpMultiAssign= ruleOpMultiAssign EOF ;
    public final String entryRuleOpMultiAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMultiAssign = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:715:2: (iv_ruleOpMultiAssign= ruleOpMultiAssign EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:716:2: iv_ruleOpMultiAssign= ruleOpMultiAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiAssignRule()); 
            }
            pushFollow(FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign1652);
            iv_ruleOpMultiAssign=ruleOpMultiAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMultiAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMultiAssign1663); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpMultiAssign"


    // $ANTLR start "ruleOpMultiAssign"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:723:1: ruleOpMultiAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '+=' ;
    public final AntlrDatatypeRuleToken ruleOpMultiAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:726:28: (kw= '+=' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:728:2: kw= '+='
            {
            kw=(Token)match(input,23,FOLLOW_23_in_ruleOpMultiAssign1700); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpMultiAssign"


    // $ANTLR start "entryRuleXOrExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:741:1: entryRuleXOrExpression returns [EObject current=null] : iv_ruleXOrExpression= ruleXOrExpression EOF ;
    public final EObject entryRuleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOrExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:742:2: (iv_ruleXOrExpression= ruleXOrExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:743:2: iv_ruleXOrExpression= ruleXOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression1739);
            iv_ruleXOrExpression=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOrExpression1749); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXOrExpression"


    // $ANTLR start "ruleXOrExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:750:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
    public final EObject ruleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:753:28: ( (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:754:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:754:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:755:5: this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression1796);
            this_XAndExpression_0=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:763:1: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==24) ) {
                    int LA10_2 = input.LA(2);

                    if ( (synpred2_InternalTutorial()) ) {
                        alt10=1;
                    }


                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:763:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:763:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:763:3: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:768:6: ( () ( ( ruleOpOr ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:768:7: () ( ( ruleOpOr ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:768:7: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:769:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:774:2: ( ( ruleOpOr ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:775:1: ( ruleOpOr )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:775:1: ( ruleOpOr )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:776:3: ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOrExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOr_in_ruleXOrExpression1849);
            	    ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:789:4: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:790:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:790:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:791:3: lv_rightOperand_3_0= ruleXAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression1872);
            	    lv_rightOperand_3_0=ruleXAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XAndExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:815:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:816:2: (iv_ruleOpOr= ruleOpOr EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:817:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr1911);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr1922); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpOr"


    // $ANTLR start "ruleOpOr"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:824:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:827:28: (kw= '||' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:829:2: kw= '||'
            {
            kw=(Token)match(input,24,FOLLOW_24_in_ruleOpOr1959); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRuleXAndExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:842:1: entryRuleXAndExpression returns [EObject current=null] : iv_ruleXAndExpression= ruleXAndExpression EOF ;
    public final EObject entryRuleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAndExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:843:2: (iv_ruleXAndExpression= ruleXAndExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:844:2: iv_ruleXAndExpression= ruleXAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression1998);
            iv_ruleXAndExpression=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAndExpression2008); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXAndExpression"


    // $ANTLR start "ruleXAndExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:851:1: ruleXAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final EObject ruleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XEqualityExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:854:28: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:855:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:855:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:856:5: this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression2055);
            this_XEqualityExpression_0=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XEqualityExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:864:1: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==25) ) {
                    int LA11_2 = input.LA(2);

                    if ( (synpred3_InternalTutorial()) ) {
                        alt11=1;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:864:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:864:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:864:3: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:869:6: ( () ( ( ruleOpAnd ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:869:7: () ( ( ruleOpAnd ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:869:7: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:870:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:875:2: ( ( ruleOpAnd ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:876:1: ( ruleOpAnd )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:876:1: ( ruleOpAnd )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:877:3: ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAndExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAnd_in_ruleXAndExpression2108);
            	    ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:890:4: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:891:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:891:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:892:3: lv_rightOperand_3_0= ruleXEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression2131);
            	    lv_rightOperand_3_0=ruleXEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XEqualityExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:916:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:917:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:918:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd2170);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd2181); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpAnd"


    // $ANTLR start "ruleOpAnd"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:925:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:928:28: (kw= '&&' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:930:2: kw= '&&'
            {
            kw=(Token)match(input,25,FOLLOW_25_in_ruleOpAnd2218); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRuleXEqualityExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:943:1: entryRuleXEqualityExpression returns [EObject current=null] : iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
    public final EObject entryRuleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEqualityExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:944:2: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:945:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression2257);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXEqualityExpression2267); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXEqualityExpression"


    // $ANTLR start "ruleXEqualityExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:952:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final EObject ruleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XRelationalExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:955:28: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:956:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:956:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:957:5: this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2314);
            this_XRelationalExpression_0=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XRelationalExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:965:1: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==26) ) {
                    int LA12_2 = input.LA(2);

                    if ( (synpred4_InternalTutorial()) ) {
                        alt12=1;
                    }


                }
                else if ( (LA12_0==27) ) {
                    int LA12_3 = input.LA(2);

                    if ( (synpred4_InternalTutorial()) ) {
                        alt12=1;
                    }


                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:965:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:965:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:965:3: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:970:6: ( () ( ( ruleOpEquality ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:970:7: () ( ( ruleOpEquality ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:970:7: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:971:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:976:2: ( ( ruleOpEquality ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:977:1: ( ruleOpEquality )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:977:1: ( ruleOpEquality )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:978:3: ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXEqualityExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpEquality_in_ruleXEqualityExpression2367);
            	    ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:991:4: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:992:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:992:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:993:3: lv_rightOperand_3_0= ruleXRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2390);
            	    lv_rightOperand_3_0=ruleXRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXEqualityExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XRelationalExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1017:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1018:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1019:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality2429);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality2440); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpEquality"


    // $ANTLR start "ruleOpEquality"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1026:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1029:28: ( (kw= '==' | kw= '!=' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1030:1: (kw= '==' | kw= '!=' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1030:1: (kw= '==' | kw= '!=' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==26) ) {
                alt13=1;
            }
            else if ( (LA13_0==27) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1031:2: kw= '=='
                    {
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleOpEquality2478); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1038:2: kw= '!='
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleOpEquality2497); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRuleXRelationalExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1051:1: entryRuleXRelationalExpression returns [EObject current=null] : iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
    public final EObject entryRuleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRelationalExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1052:2: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1053:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression2537);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXRelationalExpression2547); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXRelationalExpression"


    // $ANTLR start "ruleXRelationalExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1060:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final EObject ruleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XOtherOperatorExpression_0 = null;

        EObject lv_type_3_0 = null;

        EObject lv_rightOperand_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1063:28: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1064:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1064:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1065:5: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2594);
            this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XOtherOperatorExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1073:1: ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            loop14:
            do {
                int alt14=3;
                switch ( input.LA(1) ) {
                case 28:
                    {
                    int LA14_2 = input.LA(2);

                    if ( (synpred5_InternalTutorial()) ) {
                        alt14=1;
                    }


                    }
                    break;
                case 29:
                    {
                    int LA14_3 = input.LA(2);

                    if ( (synpred6_InternalTutorial()) ) {
                        alt14=2;
                    }


                    }
                    break;
                case 30:
                    {
                    int LA14_4 = input.LA(2);

                    if ( (synpred6_InternalTutorial()) ) {
                        alt14=2;
                    }


                    }
                    break;
                case 31:
                    {
                    int LA14_5 = input.LA(2);

                    if ( (synpred6_InternalTutorial()) ) {
                        alt14=2;
                    }


                    }
                    break;
                case 32:
                    {
                    int LA14_6 = input.LA(2);

                    if ( (synpred6_InternalTutorial()) ) {
                        alt14=2;
                    }


                    }
                    break;

                }

                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1073:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1073:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1073:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1073:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1073:4: ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1075:5: ( () otherlv_2= 'instanceof' )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1075:6: () otherlv_2= 'instanceof'
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1075:6: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1076:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleXRelationalExpression2630); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1085:3: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1086:1: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1086:1: (lv_type_3_0= ruleJvmTypeReference )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1087:3: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXRelationalExpression2653);
            	    lv_type_3_0=ruleJvmTypeReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"type",
            	              		lv_type_3_0, 
            	              		"JvmTypeReference");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1104:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1104:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1104:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1104:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1104:8: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1109:6: ( () ( ( ruleOpCompare ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1109:7: () ( ( ruleOpCompare ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1109:7: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1110:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1115:2: ( ( ruleOpCompare ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1116:1: ( ruleOpCompare )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1116:1: ( ruleOpCompare )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1117:3: ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2714);
            	    ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1130:4: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1131:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1131:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1132:3: lv_rightOperand_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2737);
            	    lv_rightOperand_6_0=ruleXOtherOperatorExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_6_0, 
            	              		"XOtherOperatorExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1156:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1157:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1158:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare2777);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare2788); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpCompare"


    // $ANTLR start "ruleOpCompare"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1165:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1168:28: ( (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1169:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1169:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            int alt15=4;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt15=1;
                }
                break;
            case 30:
                {
                alt15=2;
                }
                break;
            case 31:
                {
                alt15=3;
                }
                break;
            case 32:
                {
                alt15=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1170:2: kw= '>='
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleOpCompare2826); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1177:2: kw= '<='
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleOpCompare2845); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1184:2: kw= '>'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleOpCompare2864); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1191:2: kw= '<'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleOpCompare2883); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpCompare"


    // $ANTLR start "entryRuleXOtherOperatorExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1204:1: entryRuleXOtherOperatorExpression returns [EObject current=null] : iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
    public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOtherOperatorExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1205:2: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1206:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOtherOperatorExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression2923);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOtherOperatorExpression2933); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXOtherOperatorExpression"


    // $ANTLR start "ruleXOtherOperatorExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1213:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAdditiveExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1216:28: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1217:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1217:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1218:5: this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2980);
            this_XAdditiveExpression_0=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAdditiveExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1226:1: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==33) ) {
                    int LA16_2 = input.LA(2);

                    if ( (synpred7_InternalTutorial()) ) {
                        alt16=1;
                    }


                }
                else if ( (LA16_0==34) ) {
                    int LA16_3 = input.LA(2);

                    if ( (synpred7_InternalTutorial()) ) {
                        alt16=1;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1226:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1226:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1226:3: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1231:6: ( () ( ( ruleOpOther ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1231:7: () ( ( ruleOpOther ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1231:7: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1232:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1237:2: ( ( ruleOpOther ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1238:1: ( ruleOpOther )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1238:1: ( ruleOpOther )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1239:3: ruleOpOther
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOtherOperatorExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression3033);
            	    ruleOpOther();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1252:4: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1253:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1253:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1254:3: lv_rightOperand_3_0= ruleXAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression3056);
            	    lv_rightOperand_3_0=ruleXAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXOtherOperatorExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XAdditiveExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXOtherOperatorExpression"


    // $ANTLR start "entryRuleOpOther"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1278:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1279:2: (iv_ruleOpOther= ruleOpOther EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1280:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOtherRule()); 
            }
            pushFollow(FOLLOW_ruleOpOther_in_entryRuleOpOther3095);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOther3106); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpOther"


    // $ANTLR start "ruleOpOther"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1287:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1290:28: ( (kw= '->' | kw= '..' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1291:1: (kw= '->' | kw= '..' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1291:1: (kw= '->' | kw= '..' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==33) ) {
                alt17=1;
            }
            else if ( (LA17_0==34) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1292:2: kw= '->'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleOpOther3144); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1299:2: kw= '..'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleOpOther3163); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpOther"


    // $ANTLR start "entryRuleXAdditiveExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1312:1: entryRuleXAdditiveExpression returns [EObject current=null] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAdditiveExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1313:2: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1314:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression3203);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAdditiveExpression3213); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXAdditiveExpression"


    // $ANTLR start "ruleXAdditiveExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1321:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XMultiplicativeExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1324:28: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1325:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1325:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1326:5: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3260);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMultiplicativeExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1334:1: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==35) ) {
                    int LA18_2 = input.LA(2);

                    if ( (synpred8_InternalTutorial()) ) {
                        alt18=1;
                    }


                }
                else if ( (LA18_0==36) ) {
                    int LA18_3 = input.LA(2);

                    if ( (synpred8_InternalTutorial()) ) {
                        alt18=1;
                    }


                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1334:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1334:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1334:3: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1339:6: ( () ( ( ruleOpAdd ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1339:7: () ( ( ruleOpAdd ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1339:7: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1340:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1345:2: ( ( ruleOpAdd ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1346:1: ( ruleOpAdd )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1346:1: ( ruleOpAdd )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1347:3: ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAdditiveExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression3313);
            	    ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1360:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1361:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1361:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1362:3: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3336);
            	    lv_rightOperand_3_0=ruleXMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXAdditiveExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XMultiplicativeExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1386:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1387:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1388:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd3375);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd3386); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpAdd"


    // $ANTLR start "ruleOpAdd"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1395:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1398:28: ( (kw= '+' | kw= '-' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1399:1: (kw= '+' | kw= '-' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1399:1: (kw= '+' | kw= '-' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==35) ) {
                alt19=1;
            }
            else if ( (LA19_0==36) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1400:2: kw= '+'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleOpAdd3424); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1407:2: kw= '-'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleOpAdd3443); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpAdd"


    // $ANTLR start "entryRuleXMultiplicativeExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1420:1: entryRuleXMultiplicativeExpression returns [EObject current=null] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMultiplicativeExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1421:2: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1422:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression3483);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMultiplicativeExpression3493); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXMultiplicativeExpression"


    // $ANTLR start "ruleXMultiplicativeExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1429:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XUnaryOperation_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1432:28: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1433:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1433:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1434:5: this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3540);
            this_XUnaryOperation_0=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XUnaryOperation_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1442:1: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            loop20:
            do {
                int alt20=2;
                switch ( input.LA(1) ) {
                case 37:
                    {
                    int LA20_2 = input.LA(2);

                    if ( (synpred9_InternalTutorial()) ) {
                        alt20=1;
                    }


                    }
                    break;
                case 38:
                    {
                    int LA20_3 = input.LA(2);

                    if ( (synpred9_InternalTutorial()) ) {
                        alt20=1;
                    }


                    }
                    break;
                case 39:
                    {
                    int LA20_4 = input.LA(2);

                    if ( (synpred9_InternalTutorial()) ) {
                        alt20=1;
                    }


                    }
                    break;
                case 40:
                    {
                    int LA20_5 = input.LA(2);

                    if ( (synpred9_InternalTutorial()) ) {
                        alt20=1;
                    }


                    }
                    break;

                }

                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1442:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1442:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1442:3: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1447:6: ( () ( ( ruleOpMulti ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1447:7: () ( ( ruleOpMulti ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1447:7: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1448:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1453:2: ( ( ruleOpMulti ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1454:1: ( ruleOpMulti )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1454:1: ( ruleOpMulti )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1455:3: ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMultiplicativeExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression3593);
            	    ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1468:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1469:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1469:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1470:3: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3616);
            	    lv_rightOperand_3_0=ruleXUnaryOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXMultiplicativeExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XUnaryOperation");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1494:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1495:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1496:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti3655);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti3666); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpMulti"


    // $ANTLR start "ruleOpMulti"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1503:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1506:28: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1507:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1507:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt21=4;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt21=1;
                }
                break;
            case 38:
                {
                alt21=2;
                }
                break;
            case 39:
                {
                alt21=3;
                }
                break;
            case 40:
                {
                alt21=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1508:2: kw= '*'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleOpMulti3704); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1515:2: kw= '**'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleOpMulti3723); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1522:2: kw= '/'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleOpMulti3742); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1529:2: kw= '%'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleOpMulti3761); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getPercentSignKeyword_3()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpMulti"


    // $ANTLR start "entryRuleXUnaryOperation"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1542:1: entryRuleXUnaryOperation returns [EObject current=null] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnaryOperation = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1543:2: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1544:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3801);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXUnaryOperation3811); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXUnaryOperation"


    // $ANTLR start "ruleXUnaryOperation"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1551:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) ;
    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_2_0 = null;

        EObject this_XCastedExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1554:28: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1555:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1555:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=35 && LA22_0<=36)||LA22_0==41) ) {
                alt22=1;
            }
            else if ( ((LA22_0>=RULE_STRING && LA22_0<=RULE_ID)||LA22_0==14||LA22_0==32||LA22_0==47||LA22_0==49||LA22_0==53||LA22_0==55||(LA22_0>=58 && LA22_0<=60)||LA22_0==63||(LA22_0>=65 && LA22_0<=72)) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1555:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1555:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1555:3: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1555:3: ()
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1556:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1561:2: ( ( ruleOpUnary ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1562:1: ( ruleOpUnary )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1562:1: ( ruleOpUnary )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1563:3: ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXUnaryOperationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleXUnaryOperation3869);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1576:2: ( (lv_operand_2_0= ruleXCastedExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1577:1: (lv_operand_2_0= ruleXCastedExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1577:1: (lv_operand_2_0= ruleXCastedExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1578:3: lv_operand_2_0= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXCastedExpressionParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3890);
                    lv_operand_2_0=ruleXCastedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXUnaryOperationRule());
                      	        }
                             		set(
                             			current, 
                             			"operand",
                              		lv_operand_2_0, 
                              		"XCastedExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1596:5: this_XCastedExpression_3= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3919);
                    this_XCastedExpression_3=ruleXCastedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XCastedExpression_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1612:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1613:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1614:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary3955);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary3966); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpUnary"


    // $ANTLR start "ruleOpUnary"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1621:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1624:28: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1625:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1625:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt23=3;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt23=1;
                }
                break;
            case 36:
                {
                alt23=2;
                }
                break;
            case 35:
                {
                alt23=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1626:2: kw= '!'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleOpUnary4004); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1633:2: kw= '-'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleOpUnary4023); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1640:2: kw= '+'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleOpUnary4042); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpUnary"


    // $ANTLR start "entryRuleXCastedExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1653:1: entryRuleXCastedExpression returns [EObject current=null] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final EObject entryRuleXCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCastedExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1654:2: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1655:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCastedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression4082);
            iv_ruleXCastedExpression=ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCastedExpression4092); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXCastedExpression"


    // $ANTLR start "ruleXCastedExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1662:1: ruleXCastedExpression returns [EObject current=null] : (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) ;
    public final EObject ruleXCastedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XMemberFeatureCall_0 = null;

        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1665:28: ( (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1666:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1666:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1667:5: this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXCastedExpressionAccess().getXMemberFeatureCallParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression4139);
            this_XMemberFeatureCall_0=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMemberFeatureCall_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1675:1: ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==42) ) {
                    int LA24_2 = input.LA(2);

                    if ( (synpred10_InternalTutorial()) ) {
                        alt24=1;
                    }


                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1675:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1675:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1675:3: ( ( () 'as' ) )=> ( () otherlv_2= 'as' )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1677:5: ( () otherlv_2= 'as' )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1677:6: () otherlv_2= 'as'
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1677:6: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1678:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,42,FOLLOW_42_in_ruleXCastedExpression4174); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getAsKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1687:3: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1688:1: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1688:1: (lv_type_3_0= ruleJvmTypeReference )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1689:3: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression4197);
            	    lv_type_3_0=ruleJvmTypeReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXCastedExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"type",
            	              		lv_type_3_0, 
            	              		"JvmTypeReference");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXCastedExpression"


    // $ANTLR start "entryRuleXMemberFeatureCall"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1713:1: entryRuleXMemberFeatureCall returns [EObject current=null] : iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
    public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMemberFeatureCall = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1714:2: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1715:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMemberFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall4235);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMemberFeatureCall4245); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXMemberFeatureCall"


    // $ANTLR start "ruleXMemberFeatureCall"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1722:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* ) ;
    public final EObject ruleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_7=null;
        Token lv_nullSafe_8_0=null;
        Token lv_spreading_9_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token lv_explicitOperationCall_16_0=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        EObject this_XPrimaryExpression_0 = null;

        EObject lv_value_5_0 = null;

        EObject lv_typeArguments_11_0 = null;

        EObject lv_typeArguments_13_0 = null;

        EObject lv_memberCallArguments_17_0 = null;

        EObject lv_memberCallArguments_18_0 = null;

        EObject lv_memberCallArguments_20_0 = null;

        EObject lv_memberCallArguments_22_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1725:28: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1726:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1726:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1727:5: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall4292);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XPrimaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1735:1: ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? ) )*
            loop32:
            do {
                int alt32=3;
                switch ( input.LA(1) ) {
                case 43:
                    {
                    int LA32_2 = input.LA(2);

                    if ( (synpred11_InternalTutorial()) ) {
                        alt32=1;
                    }
                    else if ( (synpred12_InternalTutorial()) ) {
                        alt32=2;
                    }


                    }
                    break;
                case 44:
                    {
                    int LA32_3 = input.LA(2);

                    if ( (synpred12_InternalTutorial()) ) {
                        alt32=2;
                    }


                    }
                    break;
                case 45:
                    {
                    int LA32_4 = input.LA(2);

                    if ( (synpred12_InternalTutorial()) ) {
                        alt32=2;
                    }


                    }
                    break;

                }

                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1735:2: ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1735:2: ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1735:3: ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1735:3: ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1735:4: ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1741:25: ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1741:26: () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1741:26: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1742:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,43,FOLLOW_43_in_ruleXMemberFeatureCall4341); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_0_1());
            	          
            	    }
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1751:1: ( ( ruleValidID ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1752:1: ( ruleValidID )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1752:1: ( ruleValidID )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1753:3: ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4364);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getOpSingleAssignParserRuleCall_1_0_0_0_3()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall4380);
            	    ruleOpSingleAssign();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1774:3: ( (lv_value_5_0= ruleXAssignment ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1775:1: (lv_value_5_0= ruleXAssignment )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1775:1: (lv_value_5_0= ruleXAssignment )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1776:3: lv_value_5_0= ruleXAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall4402);
            	    lv_value_5_0=ruleXAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"value",
            	              		lv_value_5_0, 
            	              		"XAssignment");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1793:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1793:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )? )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1793:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1793:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1793:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1809:7: ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1809:8: () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1809:8: ()
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1810:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1815:2: (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    int alt25=3;
            	    switch ( input.LA(1) ) {
            	    case 43:
            	        {
            	        alt25=1;
            	        }
            	        break;
            	    case 44:
            	        {
            	        alt25=2;
            	        }
            	        break;
            	    case 45:
            	        {
            	        alt25=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 25, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt25) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1815:4: otherlv_7= '.'
            	            {
            	            otherlv_7=(Token)match(input,43,FOLLOW_43_in_ruleXMemberFeatureCall4488); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_7, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0());
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1820:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1820:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1821:1: (lv_nullSafe_8_0= '?.' )
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1821:1: (lv_nullSafe_8_0= '?.' )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1822:3: lv_nullSafe_8_0= '?.'
            	            {
            	            lv_nullSafe_8_0=(Token)match(input,44,FOLLOW_44_in_ruleXMemberFeatureCall4512); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_nullSafe_8_0, grammarAccess.getXMemberFeatureCallAccess().getNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		setWithLastConsumed(current, "nullSafe", true, "?.");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1836:6: ( (lv_spreading_9_0= '*.' ) )
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1836:6: ( (lv_spreading_9_0= '*.' ) )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1837:1: (lv_spreading_9_0= '*.' )
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1837:1: (lv_spreading_9_0= '*.' )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1838:3: lv_spreading_9_0= '*.'
            	            {
            	            lv_spreading_9_0=(Token)match(input,45,FOLLOW_45_in_ruleXMemberFeatureCall4549); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_spreading_9_0, grammarAccess.getXMemberFeatureCallAccess().getSpreadingAsteriskFullStopKeyword_1_1_0_0_1_2_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		setWithLastConsumed(current, "spreading", true, "*.");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1851:5: (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )?
            	    int alt27=2;
            	    int LA27_0 = input.LA(1);

            	    if ( (LA27_0==32) ) {
            	        alt27=1;
            	    }
            	    switch (alt27) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1851:7: otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>'
            	            {
            	            otherlv_10=(Token)match(input,32,FOLLOW_32_in_ruleXMemberFeatureCall4578); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_10, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_1_1_0());
            	                  
            	            }
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1855:1: ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1856:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1856:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1857:3: lv_typeArguments_11_0= ruleJvmArgumentTypeReference
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4599);
            	            lv_typeArguments_11_0=ruleJvmArgumentTypeReference();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"typeArguments",
            	                      		lv_typeArguments_11_0, 
            	                      		"JvmArgumentTypeReference");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }


            	            }

            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1873:2: (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )*
            	            loop26:
            	            do {
            	                int alt26=2;
            	                int LA26_0 = input.LA(1);

            	                if ( (LA26_0==46) ) {
            	                    alt26=1;
            	                }


            	                switch (alt26) {
            	            	case 1 :
            	            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1873:4: otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    {
            	            	    otherlv_12=(Token)match(input,46,FOLLOW_46_in_ruleXMemberFeatureCall4612); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	          	newLeafNode(otherlv_12, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_1_2_0());
            	            	          
            	            	    }
            	            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1877:1: ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1878:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    {
            	            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1878:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1879:3: lv_typeArguments_13_0= ruleJvmArgumentTypeReference
            	            	    {
            	            	    if ( state.backtracking==0 ) {
            	            	       
            	            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0()); 
            	            	      	    
            	            	    }
            	            	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4633);
            	            	    lv_typeArguments_13_0=ruleJvmArgumentTypeReference();

            	            	    state._fsp--;
            	            	    if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      	        if (current==null) {
            	            	      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	            	      	        }
            	            	             		add(
            	            	             			current, 
            	            	             			"typeArguments",
            	            	              		lv_typeArguments_13_0, 
            	            	              		"JvmArgumentTypeReference");
            	            	      	        afterParserOrEnumRuleCall();
            	            	      	    
            	            	    }

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop26;
            	                }
            	            } while (true);

            	            otherlv_14=(Token)match(input,31,FOLLOW_31_in_ruleXMemberFeatureCall4647); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_14, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_1_1_3());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1899:3: ( ( ruleValidID ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1900:1: ( ruleValidID )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1900:1: ( ruleValidID )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1901:3: ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4672);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1914:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?
            	    int alt30=2;
            	    alt30 = dfa30.predict(input);
            	    switch (alt30) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1914:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')'
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1914:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1914:4: ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' )
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1921:1: (lv_explicitOperationCall_16_0= '(' )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1922:3: lv_explicitOperationCall_16_0= '('
            	            {
            	            lv_explicitOperationCall_16_0=(Token)match(input,47,FOLLOW_47_in_ruleXMemberFeatureCall4706); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_explicitOperationCall_16_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		setWithLastConsumed(current, "explicitOperationCall", true, "(");
            	              	    
            	            }

            	            }


            	            }

            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1935:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?
            	            int alt29=3;
            	            alt29 = dfa29.predict(input);
            	            switch (alt29) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1935:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    {
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1935:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1935:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    {
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1952:1: (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1953:3: lv_memberCallArguments_17_0= ruleXShortClosure
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4791);
            	                    lv_memberCallArguments_17_0=ruleXShortClosure();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      	        if (current==null) {
            	                      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                      	        }
            	                             		add(
            	                             			current, 
            	                             			"memberCallArguments",
            	                              		lv_memberCallArguments_17_0, 
            	                              		"XShortClosure");
            	                      	        afterParserOrEnumRuleCall();
            	                      	    
            	                    }

            	                    }


            	                    }


            	                    }
            	                    break;
            	                case 2 :
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1970:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    {
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1970:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1970:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    {
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1970:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) )
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1971:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    {
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1971:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1972:3: lv_memberCallArguments_18_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4819);
            	                    lv_memberCallArguments_18_0=ruleXExpression();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      	        if (current==null) {
            	                      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                      	        }
            	                             		add(
            	                             			current, 
            	                             			"memberCallArguments",
            	                              		lv_memberCallArguments_18_0, 
            	                              		"XExpression");
            	                      	        afterParserOrEnumRuleCall();
            	                      	    
            	                    }

            	                    }


            	                    }

            	                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1988:2: (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    loop28:
            	                    do {
            	                        int alt28=2;
            	                        int LA28_0 = input.LA(1);

            	                        if ( (LA28_0==46) ) {
            	                            alt28=1;
            	                        }


            	                        switch (alt28) {
            	                    	case 1 :
            	                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1988:4: otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    {
            	                    	    otherlv_19=(Token)match(input,46,FOLLOW_46_in_ruleXMemberFeatureCall4832); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	          	newLeafNode(otherlv_19, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0());
            	                    	          
            	                    	    }
            	                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1992:1: ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1993:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    {
            	                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1993:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1994:3: lv_memberCallArguments_20_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {
            	                    	       
            	                    	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0()); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4853);
            	                    	    lv_memberCallArguments_20_0=ruleXExpression();

            	                    	    state._fsp--;
            	                    	    if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      	        if (current==null) {
            	                    	      	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                    	      	        }
            	                    	             		add(
            	                    	             			current, 
            	                    	             			"memberCallArguments",
            	                    	              		lv_memberCallArguments_20_0, 
            	                    	              		"XExpression");
            	                    	      	        afterParserOrEnumRuleCall();
            	                    	      	    
            	                    	    }

            	                    	    }


            	                    	    }


            	                    	    }
            	                    	    break;

            	                    	default :
            	                    	    break loop28;
            	                        }
            	                    } while (true);


            	                    }


            	                    }
            	                    break;

            	            }

            	            otherlv_21=(Token)match(input,48,FOLLOW_48_in_ruleXMemberFeatureCall4870); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_21, grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_1_3_2());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2014:3: ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?
            	    int alt31=2;
            	    alt31 = dfa31.predict(input);
            	    switch (alt31) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2014:4: ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure )
            	            {
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2019:1: (lv_memberCallArguments_22_0= ruleXClosure )
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2020:3: lv_memberCallArguments_22_0= ruleXClosure
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleXClosure_in_ruleXMemberFeatureCall4903);
            	            lv_memberCallArguments_22_0=ruleXClosure();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"memberCallArguments",
            	                      		lv_memberCallArguments_22_0, 
            	                      		"XClosure");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXMemberFeatureCall"


    // $ANTLR start "entryRuleXPrimaryExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2044:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPrimaryExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2045:2: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2046:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression4943);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression4953); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXPrimaryExpression"


    // $ANTLR start "ruleXPrimaryExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2053:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression ) ;
    public final EObject ruleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XConstructorCall_0 = null;

        EObject this_XBlockExpression_1 = null;

        EObject this_XSwitchExpression_2 = null;

        EObject this_XFeatureCall_3 = null;

        EObject this_XLiteral_4 = null;

        EObject this_XIfExpression_5 = null;

        EObject this_XForLoopExpression_6 = null;

        EObject this_XWhileExpression_7 = null;

        EObject this_XDoWhileExpression_8 = null;

        EObject this_XThrowExpression_9 = null;

        EObject this_XReturnExpression_10 = null;

        EObject this_XTryCatchFinallyExpression_11 = null;

        EObject this_XParenthesizedExpression_12 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2056:28: ( (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2057:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2057:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XFeatureCall_3= ruleXFeatureCall | this_XLiteral_4= ruleXLiteral | this_XIfExpression_5= ruleXIfExpression | this_XForLoopExpression_6= ruleXForLoopExpression | this_XWhileExpression_7= ruleXWhileExpression | this_XDoWhileExpression_8= ruleXDoWhileExpression | this_XThrowExpression_9= ruleXThrowExpression | this_XReturnExpression_10= ruleXReturnExpression | this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_12= ruleXParenthesizedExpression )
            int alt33=13;
            switch ( input.LA(1) ) {
            case 65:
                {
                alt33=1;
                }
                break;
            case 14:
                {
                alt33=2;
                }
                break;
            case 55:
                {
                alt33=3;
                }
                break;
            case RULE_ID:
            case 32:
            case 63:
                {
                alt33=4;
                }
                break;
            case RULE_STRING:
            case RULE_HEX:
            case RULE_INT:
            case RULE_DECIMAL:
            case 49:
            case 66:
            case 67:
            case 68:
            case 69:
                {
                alt33=5;
                }
                break;
            case 53:
                {
                alt33=6;
                }
                break;
            case 58:
                {
                alt33=7;
                }
                break;
            case 59:
                {
                alt33=8;
                }
                break;
            case 60:
                {
                alt33=9;
                }
                break;
            case 70:
                {
                alt33=10;
                }
                break;
            case 71:
                {
                alt33=11;
                }
                break;
            case 72:
                {
                alt33=12;
                }
                break;
            case 47:
                {
                alt33=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2058:5: this_XConstructorCall_0= ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression5000);
                    this_XConstructorCall_0=ruleXConstructorCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XConstructorCall_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2068:5: this_XBlockExpression_1= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression5027);
                    this_XBlockExpression_1=ruleXBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XBlockExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2078:5: this_XSwitchExpression_2= ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression5054);
                    this_XSwitchExpression_2=ruleXSwitchExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XSwitchExpression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2088:5: this_XFeatureCall_3= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression5081);
                    this_XFeatureCall_3=ruleXFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XFeatureCall_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2098:5: this_XLiteral_4= ruleXLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression5108);
                    this_XLiteral_4=ruleXLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XLiteral_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2108:5: this_XIfExpression_5= ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression5135);
                    this_XIfExpression_5=ruleXIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XIfExpression_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2118:5: this_XForLoopExpression_6= ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression5162);
                    this_XForLoopExpression_6=ruleXForLoopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XForLoopExpression_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2128:5: this_XWhileExpression_7= ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression5189);
                    this_XWhileExpression_7=ruleXWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XWhileExpression_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2138:5: this_XDoWhileExpression_8= ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression5216);
                    this_XDoWhileExpression_8=ruleXDoWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XDoWhileExpression_8; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2148:5: this_XThrowExpression_9= ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression5243);
                    this_XThrowExpression_9=ruleXThrowExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XThrowExpression_9; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 11 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2158:5: this_XReturnExpression_10= ruleXReturnExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXReturnExpressionParserRuleCall_10()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression5270);
                    this_XReturnExpression_10=ruleXReturnExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XReturnExpression_10; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 12 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2168:5: this_XTryCatchFinallyExpression_11= ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_11()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression5297);
                    this_XTryCatchFinallyExpression_11=ruleXTryCatchFinallyExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XTryCatchFinallyExpression_11; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 13 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2178:5: this_XParenthesizedExpression_12= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_12()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression5324);
                    this_XParenthesizedExpression_12=ruleXParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XParenthesizedExpression_12; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXPrimaryExpression"


    // $ANTLR start "entryRuleXLiteral"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2194:1: entryRuleXLiteral returns [EObject current=null] : iv_ruleXLiteral= ruleXLiteral EOF ;
    public final EObject entryRuleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXLiteral = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2195:2: (iv_ruleXLiteral= ruleXLiteral EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2196:2: iv_ruleXLiteral= ruleXLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXLiteral_in_entryRuleXLiteral5359);
            iv_ruleXLiteral=ruleXLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXLiteral5369); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXLiteral"


    // $ANTLR start "ruleXLiteral"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2203:1: ruleXLiteral returns [EObject current=null] : (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XNumberLiteral_2= ruleXNumberLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) ;
    public final EObject ruleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_XClosure_0 = null;

        EObject this_XBooleanLiteral_1 = null;

        EObject this_XNumberLiteral_2 = null;

        EObject this_XNullLiteral_3 = null;

        EObject this_XStringLiteral_4 = null;

        EObject this_XTypeLiteral_5 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2206:28: ( (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XNumberLiteral_2= ruleXNumberLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2207:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XNumberLiteral_2= ruleXNumberLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2207:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XNumberLiteral_2= ruleXNumberLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            int alt34=6;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt34=1;
                }
                break;
            case 66:
            case 67:
                {
                alt34=2;
                }
                break;
            case RULE_HEX:
            case RULE_INT:
            case RULE_DECIMAL:
                {
                alt34=3;
                }
                break;
            case 68:
                {
                alt34=4;
                }
                break;
            case RULE_STRING:
                {
                alt34=5;
                }
                break;
            case 69:
                {
                alt34=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2208:5: this_XClosure_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXClosureParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXLiteral5416);
                    this_XClosure_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XClosure_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2218:5: this_XBooleanLiteral_1= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral5443);
                    this_XBooleanLiteral_1=ruleXBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XBooleanLiteral_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2228:5: this_XNumberLiteral_2= ruleXNumberLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXNumberLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNumberLiteral_in_ruleXLiteral5470);
                    this_XNumberLiteral_2=ruleXNumberLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XNumberLiteral_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2238:5: this_XNullLiteral_3= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNullLiteral_in_ruleXLiteral5497);
                    this_XNullLiteral_3=ruleXNullLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XNullLiteral_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2248:5: this_XStringLiteral_4= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXStringLiteral_in_ruleXLiteral5524);
                    this_XStringLiteral_4=ruleXStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XStringLiteral_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2258:5: this_XTypeLiteral_5= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXTypeLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTypeLiteral_in_ruleXLiteral5551);
                    this_XTypeLiteral_5=ruleXTypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XTypeLiteral_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXLiteral"


    // $ANTLR start "entryRuleXClosure"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2274:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXClosure = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2275:2: (iv_ruleXClosure= ruleXClosure EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2276:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure5586);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure5596); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXClosure"


    // $ANTLR start "ruleXClosure"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2283:1: ruleXClosure returns [EObject current=null] : ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) ;
    public final EObject ruleXClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_explicitSyntax_5_0=null;
        Token otherlv_7=null;
        EObject lv_declaredFormalParameters_2_0 = null;

        EObject lv_declaredFormalParameters_4_0 = null;

        EObject lv_expression_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2286:28: ( ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2287:1: ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2287:1: ( () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2287:2: () otherlv_1= '[' ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']'
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2287:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2288:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXClosureAccess().getXClosureAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,49,FOLLOW_49_in_ruleXClosure5642); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXClosureAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2297:1: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?
            int alt37=2;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2297:2: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2312:6: ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2312:7: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2312:7: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==RULE_ID||LA36_0==47||LA36_0==75) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2312:8: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2312:8: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2313:1: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2313:1: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2314:3: lv_declaredFormalParameters_2_0= ruleJvmFormalParameter
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_2_0_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5713);
                            lv_declaredFormalParameters_2_0=ruleJvmFormalParameter();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXClosureRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"declaredFormalParameters",
                                      		lv_declaredFormalParameters_2_0, 
                                      		"JvmFormalParameter");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2330:2: (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            loop35:
                            do {
                                int alt35=2;
                                int LA35_0 = input.LA(1);

                                if ( (LA35_0==46) ) {
                                    alt35=1;
                                }


                                switch (alt35) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2330:4: otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    {
                            	    otherlv_3=(Token)match(input,46,FOLLOW_46_in_ruleXClosure5726); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getXClosureAccess().getCommaKeyword_2_0_0_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2334:1: ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2335:1: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    {
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2335:1: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2336:3: lv_declaredFormalParameters_4_0= ruleJvmFormalParameter
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_2_0_0_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5747);
                            	    lv_declaredFormalParameters_4_0=ruleJvmFormalParameter();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getXClosureRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"declaredFormalParameters",
                            	              		lv_declaredFormalParameters_4_0, 
                            	              		"JvmFormalParameter");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop35;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2352:6: ( (lv_explicitSyntax_5_0= '|' ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2353:1: (lv_explicitSyntax_5_0= '|' )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2353:1: (lv_explicitSyntax_5_0= '|' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2354:3: lv_explicitSyntax_5_0= '|'
                    {
                    lv_explicitSyntax_5_0=(Token)match(input,50,FOLLOW_50_in_ruleXClosure5769); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_explicitSyntax_5_0, grammarAccess.getXClosureAccess().getExplicitSyntaxVerticalLineKeyword_2_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXClosureRule());
                      	        }
                             		setWithLastConsumed(current, "explicitSyntax", true, "|");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2367:5: ( (lv_expression_6_0= ruleXExpressionInClosure ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2368:1: (lv_expression_6_0= ruleXExpressionInClosure )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2368:1: (lv_expression_6_0= ruleXExpressionInClosure )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2369:3: lv_expression_6_0= ruleXExpressionInClosure
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionInClosureParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpressionInClosure_in_ruleXClosure5806);
            lv_expression_6_0=ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXClosureRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_6_0, 
                      		"XExpressionInClosure");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,51,FOLLOW_51_in_ruleXClosure5818); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getXClosureAccess().getRightSquareBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXClosure"


    // $ANTLR start "entryRuleXExpressionInClosure"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2397:1: entryRuleXExpressionInClosure returns [EObject current=null] : iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF ;
    public final EObject entryRuleXExpressionInClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInClosure = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2398:2: (iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2399:2: iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInClosure_in_entryRuleXExpressionInClosure5854);
            iv_ruleXExpressionInClosure=ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInClosure5864); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXExpressionInClosure"


    // $ANTLR start "ruleXExpressionInClosure"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2406:1: ruleXExpressionInClosure returns [EObject current=null] : ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* ) ;
    public final EObject ruleXExpressionInClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_expressions_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2409:28: ( ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2410:1: ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2410:1: ( () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2410:2: () ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )*
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2410:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2411:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXExpressionInClosureAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2416:2: ( ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )? )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>=RULE_STRING && LA39_0<=RULE_ID)||LA39_0==14||LA39_0==32||(LA39_0>=35 && LA39_0<=36)||LA39_0==41||LA39_0==47||LA39_0==49||LA39_0==53||LA39_0==55||(LA39_0>=58 && LA39_0<=63)||(LA39_0>=65 && LA39_0<=72)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2416:3: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) ) (otherlv_2= ';' )?
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2416:3: ( (lv_expressions_1_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2417:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2417:1: (lv_expressions_1_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2418:3: lv_expressions_1_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXExpressionInClosureAccess().getExpressionsXExpressionInsideBlockParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXExpressionInClosure5920);
            	    lv_expressions_1_0=ruleXExpressionInsideBlock();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXExpressionInClosureRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expressions",
            	              		lv_expressions_1_0, 
            	              		"XExpressionInsideBlock");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2434:2: (otherlv_2= ';' )?
            	    int alt38=2;
            	    int LA38_0 = input.LA(1);

            	    if ( (LA38_0==52) ) {
            	        alt38=1;
            	    }
            	    switch (alt38) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2434:4: otherlv_2= ';'
            	            {
            	            otherlv_2=(Token)match(input,52,FOLLOW_52_in_ruleXExpressionInClosure5933); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXExpressionInClosure"


    // $ANTLR start "entryRuleXShortClosure"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2446:1: entryRuleXShortClosure returns [EObject current=null] : iv_ruleXShortClosure= ruleXShortClosure EOF ;
    public final EObject entryRuleXShortClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXShortClosure = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2447:2: (iv_ruleXShortClosure= ruleXShortClosure EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2448:2: iv_ruleXShortClosure= ruleXShortClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXShortClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure5973);
            iv_ruleXShortClosure=ruleXShortClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXShortClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXShortClosure5983); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXShortClosure"


    // $ANTLR start "ruleXShortClosure"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2455:1: ruleXShortClosure returns [EObject current=null] : ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXShortClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_explicitSyntax_4_0=null;
        EObject lv_declaredFormalParameters_1_0 = null;

        EObject lv_declaredFormalParameters_3_0 = null;

        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2458:28: ( ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2459:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2459:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2459:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2459:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2459:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2475:6: ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2475:7: () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2475:7: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2476:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXShortClosureAccess().getXClosureAction_0_0_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2481:2: ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID||LA41_0==47||LA41_0==75) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2481:3: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2481:3: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2482:1: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2482:1: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2483:3: lv_declaredFormalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure6091);
                    lv_declaredFormalParameters_1_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXShortClosureRule());
                      	        }
                             		add(
                             			current, 
                             			"declaredFormalParameters",
                              		lv_declaredFormalParameters_1_0, 
                              		"JvmFormalParameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2499:2: (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==46) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2499:4: otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,46,FOLLOW_46_in_ruleXShortClosure6104); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getXShortClosureAccess().getCommaKeyword_0_0_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2503:1: ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2504:1: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2504:1: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2505:3: lv_declaredFormalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure6125);
                    	    lv_declaredFormalParameters_3_0=ruleJvmFormalParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXShortClosureRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"declaredFormalParameters",
                    	              		lv_declaredFormalParameters_3_0, 
                    	              		"JvmFormalParameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2521:6: ( (lv_explicitSyntax_4_0= '|' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2522:1: (lv_explicitSyntax_4_0= '|' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2522:1: (lv_explicitSyntax_4_0= '|' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2523:3: lv_explicitSyntax_4_0= '|'
            {
            lv_explicitSyntax_4_0=(Token)match(input,50,FOLLOW_50_in_ruleXShortClosure6147); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_explicitSyntax_4_0, grammarAccess.getXShortClosureAccess().getExplicitSyntaxVerticalLineKeyword_0_0_2_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getXShortClosureRule());
              	        }
                     		setWithLastConsumed(current, "explicitSyntax", true, "|");
              	    
            }

            }


            }


            }


            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2536:4: ( (lv_expression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2537:1: (lv_expression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2537:1: (lv_expression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2538:3: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXShortClosureAccess().getExpressionXExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXShortClosure6183);
            lv_expression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXShortClosureRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_5_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXShortClosure"


    // $ANTLR start "entryRuleXParenthesizedExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2562:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXParenthesizedExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2563:2: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2564:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression6219);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression6229); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXParenthesizedExpression"


    // $ANTLR start "ruleXParenthesizedExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2571:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2574:28: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2575:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2575:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2575:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_47_in_ruleXParenthesizedExpression6266); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression6288);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XExpression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,48,FOLLOW_48_in_ruleXParenthesizedExpression6299); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXParenthesizedExpression"


    // $ANTLR start "entryRuleXIfExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2600:1: entryRuleXIfExpression returns [EObject current=null] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIfExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2601:2: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2602:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIfExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression6335);
            iv_ruleXIfExpression=ruleXIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIfExpression6345); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXIfExpression"


    // $ANTLR start "ruleXIfExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2609:1: ruleXIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) ;
    public final EObject ruleXIfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_if_3_0 = null;

        EObject lv_then_5_0 = null;

        EObject lv_else_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2612:28: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2613:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2613:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2613:2: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2613:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2614:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,53,FOLLOW_53_in_ruleXIfExpression6391); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getIfKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,47,FOLLOW_47_in_ruleXIfExpression6403); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2627:1: ( (lv_if_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2628:1: (lv_if_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2628:1: (lv_if_3_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2629:3: lv_if_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6424);
            lv_if_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"if",
                      		lv_if_3_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,48,FOLLOW_48_in_ruleXIfExpression6436); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2649:1: ( (lv_then_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2650:1: (lv_then_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2650:1: (lv_then_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2651:3: lv_then_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6457);
            lv_then_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"then",
                      		lv_then_5_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2667:2: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==54) ) {
                int LA42_1 = input.LA(2);

                if ( (synpred18_InternalTutorial()) ) {
                    alt42=1;
                }
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2667:3: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2667:3: ( ( 'else' )=>otherlv_6= 'else' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2667:4: ( 'else' )=>otherlv_6= 'else'
                    {
                    otherlv_6=(Token)match(input,54,FOLLOW_54_in_ruleXIfExpression6478); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2672:2: ( (lv_else_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2673:1: (lv_else_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2673:1: (lv_else_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2674:3: lv_else_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6500);
                    lv_else_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"else",
                              		lv_else_7_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXIfExpression"


    // $ANTLR start "entryRuleXSwitchExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2698:1: entryRuleXSwitchExpression returns [EObject current=null] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSwitchExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2699:2: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2700:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXSwitchExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression6538);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSwitchExpression6548); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXSwitchExpression"


    // $ANTLR start "ruleXSwitchExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2707:1: ruleXSwitchExpression returns [EObject current=null] : ( () otherlv_1= 'switch' ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )+ (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' ) ;
    public final EObject ruleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        AntlrDatatypeRuleToken lv_localVarName_2_0 = null;

        EObject lv_switch_4_0 = null;

        AntlrDatatypeRuleToken lv_localVarName_6_0 = null;

        EObject lv_switch_8_0 = null;

        EObject lv_cases_11_0 = null;

        EObject lv_default_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2710:28: ( ( () otherlv_1= 'switch' ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )+ (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2711:1: ( () otherlv_1= 'switch' ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )+ (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2711:1: ( () otherlv_1= 'switch' ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )+ (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2711:2: () otherlv_1= 'switch' ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )+ (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}'
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2711:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2712:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,55,FOLLOW_55_in_ruleXSwitchExpression6594); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2721:1: ( ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) ) | ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=RULE_STRING && LA44_0<=RULE_ID)||LA44_0==14||LA44_0==32||(LA44_0>=35 && LA44_0<=36)||LA44_0==41||LA44_0==49||LA44_0==53||LA44_0==55||(LA44_0>=58 && LA44_0<=60)||LA44_0==63||(LA44_0>=65 && LA44_0<=72)) ) {
                alt44=1;
            }
            else if ( (LA44_0==47) ) {
                int LA44_2 = input.LA(2);

                if ( (LA44_2==RULE_ID) ) {
                    int LA44_3 = input.LA(3);

                    if ( ((LA44_3>=22 && LA44_3<=40)||(LA44_3>=42 && LA44_3<=45)||(LA44_3>=47 && LA44_3<=49)||LA44_3==64) ) {
                        alt44=1;
                    }
                    else if ( (LA44_3==21) && (synpred20_InternalTutorial())) {
                        alt44=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 3, input);

                        throw nvae;
                    }
                }
                else if ( ((LA44_2>=RULE_STRING && LA44_2<=RULE_DECIMAL)||LA44_2==14||LA44_2==32||(LA44_2>=35 && LA44_2<=36)||LA44_2==41||LA44_2==47||LA44_2==49||LA44_2==53||LA44_2==55||(LA44_2>=58 && LA44_2<=60)||LA44_2==63||(LA44_2>=65 && LA44_2<=72)) ) {
                    alt44=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2721:2: ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2721:2: ( ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2721:3: ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2721:3: ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==RULE_ID) ) {
                        int LA43_1 = input.LA(2);

                        if ( (LA43_1==21) && (synpred19_InternalTutorial())) {
                            alt43=1;
                        }
                    }
                    switch (alt43) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2721:4: ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2726:5: ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2726:6: ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':'
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2726:6: ( (lv_localVarName_2_0= ruleValidID ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2727:1: (lv_localVarName_2_0= ruleValidID )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2727:1: (lv_localVarName_2_0= ruleValidID )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2728:3: lv_localVarName_2_0= ruleValidID
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getLocalVarNameValidIDParserRuleCall_2_0_0_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleValidID_in_ruleXSwitchExpression6637);
                            lv_localVarName_2_0=ruleValidID();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"localVarName",
                                      		lv_localVarName_2_0, 
                                      		"ValidID");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleXSwitchExpression6649); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_0_0_0_1());
                                  
                            }

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2748:4: ( (lv_switch_4_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2749:1: (lv_switch_4_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2749:1: (lv_switch_4_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2750:3: lv_switch_4_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6673);
                    lv_switch_4_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"switch",
                              		lv_switch_4_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2767:6: ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2767:6: ( ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2767:7: ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) ) ( (lv_switch_8_0= ruleXExpression ) ) otherlv_9= ')'
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2767:7: ( ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2767:8: ( ( '(' ( ( ruleValidID ) ) ':' ) )=> (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2773:5: (otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2773:7: otherlv_5= '(' ( (lv_localVarName_6_0= ruleValidID ) ) otherlv_7= ':'
                    {
                    otherlv_5=(Token)match(input,47,FOLLOW_47_in_ruleXSwitchExpression6717); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getXSwitchExpressionAccess().getLeftParenthesisKeyword_2_1_0_0_0());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2777:1: ( (lv_localVarName_6_0= ruleValidID ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2778:1: (lv_localVarName_6_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2778:1: (lv_localVarName_6_0= ruleValidID )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2779:3: lv_localVarName_6_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getLocalVarNameValidIDParserRuleCall_2_1_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXSwitchExpression6738);
                    lv_localVarName_6_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"localVarName",
                              		lv_localVarName_6_0, 
                              		"ValidID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_7=(Token)match(input,21,FOLLOW_21_in_ruleXSwitchExpression6750); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_1_0_0_2());
                          
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2799:3: ( (lv_switch_8_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2800:1: (lv_switch_8_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2800:1: (lv_switch_8_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2801:3: lv_switch_8_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6773);
                    lv_switch_8_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"switch",
                              		lv_switch_8_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_9=(Token)match(input,48,FOLLOW_48_in_ruleXSwitchExpression6785); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getXSwitchExpressionAccess().getRightParenthesisKeyword_2_1_2());
                          
                    }

                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,14,FOLLOW_14_in_ruleXSwitchExpression6799); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2825:1: ( (lv_cases_11_0= ruleXCasePart ) )+
            int cnt45=0;
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==RULE_ID||LA45_0==21||LA45_0==47||LA45_0==57||LA45_0==75) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2826:1: (lv_cases_11_0= ruleXCasePart )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2826:1: (lv_cases_11_0= ruleXCasePart )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2827:3: lv_cases_11_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6820);
            	    lv_cases_11_0=ruleXCasePart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"cases",
            	              		lv_cases_11_0, 
            	              		"XCasePart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt45 >= 1 ) break loop45;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(45, input);
                        throw eee;
                }
                cnt45++;
            } while (true);

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2843:3: (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==56) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2843:5: otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) )
                    {
                    otherlv_12=(Token)match(input,56,FOLLOW_56_in_ruleXSwitchExpression6834); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_5_0());
                          
                    }
                    otherlv_13=(Token)match(input,21,FOLLOW_21_in_ruleXSwitchExpression6846); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_5_1());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2851:1: ( (lv_default_14_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2852:1: (lv_default_14_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2852:1: (lv_default_14_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2853:3: lv_default_14_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_5_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6867);
                    lv_default_14_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"default",
                              		lv_default_14_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_15=(Token)match(input,15,FOLLOW_15_in_ruleXSwitchExpression6881); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getXSwitchExpressionAccess().getRightCurlyBracketKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXSwitchExpression"


    // $ANTLR start "entryRuleXCasePart"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2881:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCasePart = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2882:2: (iv_ruleXCasePart= ruleXCasePart EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2883:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCasePartRule()); 
            }
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart6917);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart6927); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXCasePart"


    // $ANTLR start "ruleXCasePart"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2890:1: ruleXCasePart returns [EObject current=null] : ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCasePart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_typeGuard_0_0 = null;

        EObject lv_case_2_0 = null;

        EObject lv_then_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2893:28: ( ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2894:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2894:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2894:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2894:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_ID||LA47_0==47||LA47_0==75) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2895:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2895:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2896:3: lv_typeGuard_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6973);
                    lv_typeGuard_0_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXCasePartRule());
                      	        }
                             		set(
                             			current, 
                             			"typeGuard",
                              		lv_typeGuard_0_0, 
                              		"JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2912:3: (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==57) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2912:5: otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) )
                    {
                    otherlv_1=(Token)match(input,57,FOLLOW_57_in_ruleXCasePart6987); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXCasePartAccess().getCaseKeyword_1_0());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2916:1: ( (lv_case_2_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2917:1: (lv_case_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2917:1: (lv_case_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2918:3: lv_case_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart7008);
                    lv_case_2_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXCasePartRule());
                      	        }
                             		set(
                             			current, 
                             			"case",
                              		lv_case_2_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleXCasePart7022); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCasePartAccess().getColonKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2938:1: ( (lv_then_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2939:1: (lv_then_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2939:1: (lv_then_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2940:3: lv_then_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart7043);
            lv_then_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXCasePartRule());
              	        }
                     		set(
                     			current, 
                     			"then",
                      		lv_then_4_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXCasePart"


    // $ANTLR start "entryRuleXForLoopExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2964:1: entryRuleXForLoopExpression returns [EObject current=null] : iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
    public final EObject entryRuleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXForLoopExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2965:2: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2966:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXForLoopExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression7079);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXForLoopExpression7089); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXForLoopExpression"


    // $ANTLR start "ruleXForLoopExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2973:1: ruleXForLoopExpression returns [EObject current=null] : ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) ;
    public final EObject ruleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_declaredParam_3_0 = null;

        EObject lv_forExpression_5_0 = null;

        EObject lv_eachExpression_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2976:28: ( ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2977:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2977:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2977:2: () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2977:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2978:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,58,FOLLOW_58_in_ruleXForLoopExpression7135); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getForKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,47,FOLLOW_47_in_ruleXForLoopExpression7147); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2991:1: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2992:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2992:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2993:3: lv_declaredParam_3_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression7168);
            lv_declaredParam_3_0=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"declaredParam",
                      		lv_declaredParam_3_0, 
                      		"JvmFormalParameter");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,21,FOLLOW_21_in_ruleXForLoopExpression7180); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3013:1: ( (lv_forExpression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3014:1: (lv_forExpression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3014:1: (lv_forExpression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3015:3: lv_forExpression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression7201);
            lv_forExpression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"forExpression",
                      		lv_forExpression_5_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,48,FOLLOW_48_in_ruleXForLoopExpression7213); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_6());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3035:1: ( (lv_eachExpression_7_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3036:1: (lv_eachExpression_7_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3036:1: (lv_eachExpression_7_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3037:3: lv_eachExpression_7_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression7234);
            lv_eachExpression_7_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"eachExpression",
                      		lv_eachExpression_7_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXForLoopExpression"


    // $ANTLR start "entryRuleXWhileExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3061:1: entryRuleXWhileExpression returns [EObject current=null] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWhileExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3062:2: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3063:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression7270);
            iv_ruleXWhileExpression=ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWhileExpression7280); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXWhileExpression"


    // $ANTLR start "ruleXWhileExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3070:1: ruleXWhileExpression returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_predicate_3_0 = null;

        EObject lv_body_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3073:28: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3074:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3074:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3074:2: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3074:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3075:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,59,FOLLOW_59_in_ruleXWhileExpression7326); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,47,FOLLOW_47_in_ruleXWhileExpression7338); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3088:1: ( (lv_predicate_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3089:1: (lv_predicate_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3089:1: (lv_predicate_3_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3090:3: lv_predicate_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression7359);
            lv_predicate_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"predicate",
                      		lv_predicate_3_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,48,FOLLOW_48_in_ruleXWhileExpression7371); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3110:1: ( (lv_body_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3111:1: (lv_body_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3111:1: (lv_body_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3112:3: lv_body_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression7392);
            lv_body_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_5_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXWhileExpression"


    // $ANTLR start "entryRuleXDoWhileExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3136:1: entryRuleXDoWhileExpression returns [EObject current=null] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDoWhileExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3137:2: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3138:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXDoWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression7428);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXDoWhileExpression7438); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXDoWhileExpression"


    // $ANTLR start "ruleXDoWhileExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3145:1: ruleXDoWhileExpression returns [EObject current=null] : ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) ;
    public final EObject ruleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_body_2_0 = null;

        EObject lv_predicate_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3148:28: ( ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3149:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3149:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3149:2: () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')'
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3149:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3150:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,60,FOLLOW_60_in_ruleXDoWhileExpression7484); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3159:1: ( (lv_body_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3160:1: (lv_body_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3160:1: (lv_body_2_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3161:3: lv_body_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7505);
            lv_body_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXDoWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_2_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,59,FOLLOW_59_in_ruleXDoWhileExpression7517); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,47,FOLLOW_47_in_ruleXDoWhileExpression7529); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3185:1: ( (lv_predicate_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3186:1: (lv_predicate_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3186:1: (lv_predicate_5_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3187:3: lv_predicate_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7550);
            lv_predicate_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXDoWhileExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"predicate",
                      		lv_predicate_5_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,48,FOLLOW_48_in_ruleXDoWhileExpression7562); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXDoWhileExpressionAccess().getRightParenthesisKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXDoWhileExpression"


    // $ANTLR start "entryRuleXBlockExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3215:1: entryRuleXBlockExpression returns [EObject current=null] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBlockExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3216:2: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3217:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression7598);
            iv_ruleXBlockExpression=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBlockExpression7608); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXBlockExpression"


    // $ANTLR start "ruleXBlockExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3224:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3227:28: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3228:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3228:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3228:2: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3228:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3229:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleXBlockExpression7654); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3238:1: ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>=RULE_STRING && LA50_0<=RULE_ID)||LA50_0==14||LA50_0==32||(LA50_0>=35 && LA50_0<=36)||LA50_0==41||LA50_0==47||LA50_0==49||LA50_0==53||LA50_0==55||(LA50_0>=58 && LA50_0<=63)||(LA50_0>=65 && LA50_0<=72)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3238:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )?
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3238:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3239:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3239:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3240:3: lv_expressions_2_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression7676);
            	    lv_expressions_2_0=ruleXExpressionInsideBlock();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXBlockExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expressions",
            	              		lv_expressions_2_0, 
            	              		"XExpressionInsideBlock");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3256:2: (otherlv_3= ';' )?
            	    int alt49=2;
            	    int LA49_0 = input.LA(1);

            	    if ( (LA49_0==52) ) {
            	        alt49=1;
            	    }
            	    switch (alt49) {
            	        case 1 :
            	            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3256:4: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,52,FOLLOW_52_in_ruleXBlockExpression7689); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleXBlockExpression7705); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXBlockExpressionAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXBlockExpression"


    // $ANTLR start "entryRuleXExpressionInsideBlock"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3272:1: entryRuleXExpressionInsideBlock returns [EObject current=null] : iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF ;
    public final EObject entryRuleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInsideBlock = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3273:2: (iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3274:2: iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInsideBlockRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock7741);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock7751); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXExpressionInsideBlock"


    // $ANTLR start "ruleXExpressionInsideBlock"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3281:1: ruleXExpressionInsideBlock returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3284:28: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3285:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3285:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=61 && LA51_0<=62)) ) {
                alt51=1;
            }
            else if ( ((LA51_0>=RULE_STRING && LA51_0<=RULE_ID)||LA51_0==14||LA51_0==32||(LA51_0>=35 && LA51_0<=36)||LA51_0==41||LA51_0==47||LA51_0==49||LA51_0==53||LA51_0==55||(LA51_0>=58 && LA51_0<=60)||LA51_0==63||(LA51_0>=65 && LA51_0<=72)) ) {
                alt51=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3286:5: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXVariableDeclarationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7798);
                    this_XVariableDeclaration_0=ruleXVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XVariableDeclaration_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3296:5: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7825);
                    this_XExpression_1=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXExpressionInsideBlock"


    // $ANTLR start "entryRuleXVariableDeclaration"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3312:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXVariableDeclaration = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3313:2: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3314:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7860);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXVariableDeclaration7870); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXVariableDeclaration"


    // $ANTLR start "ruleXVariableDeclaration"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3321:1: ruleXVariableDeclaration returns [EObject current=null] : ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) ;
    public final EObject ruleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_writeable_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_type_3_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        AntlrDatatypeRuleToken lv_name_5_0 = null;

        EObject lv_right_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3324:28: ( ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3325:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3325:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3325:2: () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3325:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3326:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXVariableDeclarationAccess().getXVariableDeclarationAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3331:2: ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==61) ) {
                alt52=1;
            }
            else if ( (LA52_0==62) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3331:3: ( (lv_writeable_1_0= 'var' ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3331:3: ( (lv_writeable_1_0= 'var' ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3332:1: (lv_writeable_1_0= 'var' )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3332:1: (lv_writeable_1_0= 'var' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3333:3: lv_writeable_1_0= 'var'
                    {
                    lv_writeable_1_0=(Token)match(input,61,FOLLOW_61_in_ruleXVariableDeclaration7923); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_writeable_1_0, grammarAccess.getXVariableDeclarationAccess().getWriteableVarKeyword_1_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		setWithLastConsumed(current, "writeable", true, "var");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3347:7: otherlv_2= 'val'
                    {
                    otherlv_2=(Token)match(input,62,FOLLOW_62_in_ruleXVariableDeclaration7954); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXVariableDeclarationAccess().getValKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3351:2: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_ID) ) {
                int LA53_1 = input.LA(2);

                if ( (synpred21_InternalTutorial()) ) {
                    alt53=1;
                }
                else if ( (true) ) {
                    alt53=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA53_0==47) && (synpred21_InternalTutorial())) {
                alt53=1;
            }
            else if ( (LA53_0==75) && (synpred21_InternalTutorial())) {
                alt53=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3351:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3351:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3351:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3359:6: ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3359:7: ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3359:7: ( (lv_type_3_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3360:1: (lv_type_3_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3360:1: (lv_type_3_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3361:3: lv_type_3_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration8002);
                    lv_type_3_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_3_0, 
                              		"JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3377:2: ( (lv_name_4_0= ruleValidID ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3378:1: (lv_name_4_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3378:1: (lv_name_4_0= ruleValidID )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3379:3: lv_name_4_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration8023);
                    lv_name_4_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_4_0, 
                              		"ValidID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3396:6: ( (lv_name_5_0= ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3396:6: ( (lv_name_5_0= ruleValidID ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3397:1: (lv_name_5_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3397:1: (lv_name_5_0= ruleValidID )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3398:3: lv_name_5_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration8052);
                    lv_name_5_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_5_0, 
                              		"ValidID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3414:3: (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==22) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3414:5: otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,22,FOLLOW_22_in_ruleXVariableDeclaration8066); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3418:1: ( (lv_right_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3419:1: (lv_right_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3419:1: (lv_right_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3420:3: lv_right_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXVariableDeclaration8087);
                    lv_right_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_7_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXVariableDeclaration"


    // $ANTLR start "entryRuleJvmFormalParameter"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3444:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3445:2: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3446:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter8125);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameter8135); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmFormalParameter"


    // $ANTLR start "ruleJvmFormalParameter"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3453:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3456:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3457:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3457:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3457:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3457:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==RULE_ID) ) {
                int LA55_1 = input.LA(2);

                if ( (LA55_1==RULE_ID||LA55_1==32||LA55_1==43||LA55_1==49) ) {
                    alt55=1;
                }
            }
            else if ( (LA55_0==47||LA55_0==75) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3458:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3458:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3459:3: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter8181);
                    lv_parameterType_0_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmFormalParameterRule());
                      	        }
                             		set(
                             			current, 
                             			"parameterType",
                              		lv_parameterType_0_0, 
                              		"JvmTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3475:3: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3476:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3476:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3477:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleJvmFormalParameter8203);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmFormalParameterRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ValidID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmFormalParameter"


    // $ANTLR start "entryRuleFullJvmFormalParameter"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3501:1: entryRuleFullJvmFormalParameter returns [EObject current=null] : iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF ;
    public final EObject entryRuleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFullJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3502:2: (iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3503:2: iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFullJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_ruleFullJvmFormalParameter_in_entryRuleFullJvmFormalParameter8239);
            iv_ruleFullJvmFormalParameter=ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFullJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFullJvmFormalParameter8249); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFullJvmFormalParameter"


    // $ANTLR start "ruleFullJvmFormalParameter"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3510:1: ruleFullJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3513:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3514:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3514:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3514:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3514:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3515:1: (lv_parameterType_0_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3515:1: (lv_parameterType_0_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3516:3: lv_parameterType_0_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleFullJvmFormalParameter8295);
            lv_parameterType_0_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFullJvmFormalParameterRule());
              	        }
                     		set(
                     			current, 
                     			"parameterType",
                      		lv_parameterType_0_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3532:2: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3533:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3533:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3534:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleFullJvmFormalParameter8316);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFullJvmFormalParameterRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ValidID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleFullJvmFormalParameter"


    // $ANTLR start "entryRuleXFeatureCall"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3558:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFeatureCall = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3559:2: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3560:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall8352);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall8362); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXFeatureCall"


    // $ANTLR start "ruleXFeatureCall"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3567:1: ruleXFeatureCall returns [EObject current=null] : ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? ) ;
    public final EObject ruleXFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_explicitOperationCall_8_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_typeArguments_3_0 = null;

        EObject lv_typeArguments_5_0 = null;

        EObject lv_featureCallArguments_9_0 = null;

        EObject lv_featureCallArguments_10_0 = null;

        EObject lv_featureCallArguments_12_0 = null;

        EObject lv_featureCallArguments_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3570:28: ( ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3571:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3571:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )? )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3571:2: () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3571:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3572:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3577:2: ( ( ruleStaticQualifier ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_ID) ) {
                int LA56_1 = input.LA(2);

                if ( (LA56_1==64) ) {
                    alt56=1;
                }
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3578:1: ( ruleStaticQualifier )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3578:1: ( ruleStaticQualifier )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3579:3: ruleStaticQualifier
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXFeatureCallRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getDeclaringTypeJvmDeclaredTypeCrossReference_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall8419);
                    ruleStaticQualifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3592:3: (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==32) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3592:5: otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleXFeatureCall8433); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_2_0());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3596:1: ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3597:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3597:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3598:3: lv_typeArguments_3_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8454);
                    lv_typeArguments_3_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                      	        }
                             		add(
                             			current, 
                             			"typeArguments",
                              		lv_typeArguments_3_0, 
                              		"JvmArgumentTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3614:2: (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==46) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3614:4: otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_4=(Token)match(input,46,FOLLOW_46_in_ruleXFeatureCall8467); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getXFeatureCallAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3618:1: ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3619:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3619:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3620:3: lv_typeArguments_5_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8488);
                    	    lv_typeArguments_5_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"typeArguments",
                    	              		lv_typeArguments_5_0, 
                    	              		"JvmArgumentTypeReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop57;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,31,FOLLOW_31_in_ruleXFeatureCall8502); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_2_3());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3640:3: ( ( ruleIdOrSuper ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3641:1: ( ruleIdOrSuper )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3641:1: ( ruleIdOrSuper )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3642:3: ruleIdOrSuper
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXFeatureCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall8527);
            ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3655:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            int alt61=2;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3655:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3655:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3655:4: ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3662:1: (lv_explicitOperationCall_8_0= '(' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3663:3: lv_explicitOperationCall_8_0= '('
                    {
                    lv_explicitOperationCall_8_0=(Token)match(input,47,FOLLOW_47_in_ruleXFeatureCall8561); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_explicitOperationCall_8_0, grammarAccess.getXFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_4_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXFeatureCallRule());
                      	        }
                             		setWithLastConsumed(current, "explicitOperationCall", true, "(");
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3676:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?
                    int alt60=3;
                    alt60 = dfa60.predict(input);
                    switch (alt60) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3676:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3676:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3676:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3693:1: (lv_featureCallArguments_9_0= ruleXShortClosure )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3694:3: lv_featureCallArguments_9_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_4_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXShortClosure_in_ruleXFeatureCall8646);
                            lv_featureCallArguments_9_0=ruleXShortClosure();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"featureCallArguments",
                                      		lv_featureCallArguments_9_0, 
                                      		"XShortClosure");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3711:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3711:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3711:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3711:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3712:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3712:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3713:3: lv_featureCallArguments_10_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall8674);
                            lv_featureCallArguments_10_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"featureCallArguments",
                                      		lv_featureCallArguments_10_0, 
                                      		"XExpression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3729:2: (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            loop59:
                            do {
                                int alt59=2;
                                int LA59_0 = input.LA(1);

                                if ( (LA59_0==46) ) {
                                    alt59=1;
                                }


                                switch (alt59) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3729:4: otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    {
                            	    otherlv_11=(Token)match(input,46,FOLLOW_46_in_ruleXFeatureCall8687); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_11, grammarAccess.getXFeatureCallAccess().getCommaKeyword_4_1_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3733:1: ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3734:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3734:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3735:3: lv_featureCallArguments_12_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall8708);
                            	    lv_featureCallArguments_12_0=ruleXExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"featureCallArguments",
                            	              		lv_featureCallArguments_12_0, 
                            	              		"XExpression");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop59;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,48,FOLLOW_48_in_ruleXFeatureCall8725); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_4_2());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3755:3: ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?
            int alt62=2;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3755:4: ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3760:1: (lv_featureCallArguments_14_0= ruleXClosure )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3761:3: lv_featureCallArguments_14_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXClosureParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXFeatureCall8758);
                    lv_featureCallArguments_14_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                      	        }
                             		add(
                             			current, 
                             			"featureCallArguments",
                              		lv_featureCallArguments_14_0, 
                              		"XClosure");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXFeatureCall"


    // $ANTLR start "entryRuleIdOrSuper"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3785:1: entryRuleIdOrSuper returns [String current=null] : iv_ruleIdOrSuper= ruleIdOrSuper EOF ;
    public final String entryRuleIdOrSuper() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrSuper = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3786:2: (iv_ruleIdOrSuper= ruleIdOrSuper EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3787:2: iv_ruleIdOrSuper= ruleIdOrSuper EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrSuperRule()); 
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper8796);
            iv_ruleIdOrSuper=ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrSuper.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdOrSuper8807); if (state.failed) return current;

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
    // $ANTLR end "entryRuleIdOrSuper"


    // $ANTLR start "ruleIdOrSuper"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3794:1: ruleIdOrSuper returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID | kw= 'super' ) ;
    public final AntlrDatatypeRuleToken ruleIdOrSuper() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3797:28: ( (this_ValidID_0= ruleValidID | kw= 'super' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3798:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3798:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==RULE_ID) ) {
                alt63=1;
            }
            else if ( (LA63_0==63) ) {
                alt63=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3799:5: this_ValidID_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIdOrSuperAccess().getValidIDParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleIdOrSuper8854);
                    this_ValidID_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ValidID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3811:2: kw= 'super'
                    {
                    kw=(Token)match(input,63,FOLLOW_63_in_ruleIdOrSuper8878); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIdOrSuperAccess().getSuperKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleIdOrSuper"


    // $ANTLR start "entryRuleStaticQualifier"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3824:1: entryRuleStaticQualifier returns [String current=null] : iv_ruleStaticQualifier= ruleStaticQualifier EOF ;
    public final String entryRuleStaticQualifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStaticQualifier = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3825:2: (iv_ruleStaticQualifier= ruleStaticQualifier EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3826:2: iv_ruleStaticQualifier= ruleStaticQualifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStaticQualifierRule()); 
            }
            pushFollow(FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier8919);
            iv_ruleStaticQualifier=ruleStaticQualifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStaticQualifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStaticQualifier8930); if (state.failed) return current;

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
    // $ANTLR end "entryRuleStaticQualifier"


    // $ANTLR start "ruleStaticQualifier"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3833:1: ruleStaticQualifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID kw= '::' )+ ;
    public final AntlrDatatypeRuleToken ruleStaticQualifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3836:28: ( (this_ValidID_0= ruleValidID kw= '::' )+ )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3837:1: (this_ValidID_0= ruleValidID kw= '::' )+
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3837:1: (this_ValidID_0= ruleValidID kw= '::' )+
            int cnt64=0;
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==RULE_ID) ) {
                    int LA64_2 = input.LA(2);

                    if ( (LA64_2==64) ) {
                        alt64=1;
                    }


                }


                switch (alt64) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3838:5: this_ValidID_0= ruleValidID kw= '::'
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getStaticQualifierAccess().getValidIDParserRuleCall_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleStaticQualifier8977);
            	    this_ValidID_0=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }
            	    kw=(Token)match(input,64,FOLLOW_64_in_ruleStaticQualifier8995); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getStaticQualifierAccess().getColonColonKeyword_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt64 >= 1 ) break loop64;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(64, input);
                        throw eee;
                }
                cnt64++;
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleStaticQualifier"


    // $ANTLR start "entryRuleXConstructorCall"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3862:1: entryRuleXConstructorCall returns [EObject current=null] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstructorCall = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3863:2: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3864:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXConstructorCallRule()); 
            }
            pushFollow(FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall9036);
            iv_ruleXConstructorCall=ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXConstructorCall9046); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXConstructorCall"


    // $ANTLR start "ruleXConstructorCall"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3871:1: ruleXConstructorCall returns [EObject current=null] : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) ;
    public final EObject ruleXConstructorCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_typeArguments_4_0 = null;

        EObject lv_typeArguments_6_0 = null;

        EObject lv_arguments_9_0 = null;

        EObject lv_arguments_10_0 = null;

        EObject lv_arguments_12_0 = null;

        EObject lv_arguments_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3874:28: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3875:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3875:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3875:2: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3875:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3876:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXConstructorCallAccess().getXConstructorCallAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,65,FOLLOW_65_in_ruleXConstructorCall9092); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXConstructorCallAccess().getNewKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3885:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3886:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3886:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3887:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXConstructorCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXConstructorCall9115);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3900:2: ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
            int alt66=2;
            alt66 = dfa66.predict(input);
            switch (alt66) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3900:3: ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3900:3: ( ( '<' )=>otherlv_3= '<' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3900:4: ( '<' )=>otherlv_3= '<'
                    {
                    otherlv_3=(Token)match(input,32,FOLLOW_32_in_ruleXConstructorCall9136); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXConstructorCallAccess().getLessThanSignKeyword_3_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3905:2: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3906:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3906:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3907:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall9158);
                    lv_typeArguments_4_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                      	        }
                             		add(
                             			current, 
                             			"typeArguments",
                              		lv_typeArguments_4_0, 
                              		"JvmArgumentTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3923:2: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==46) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3923:4: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_5=(Token)match(input,46,FOLLOW_46_in_ruleXConstructorCall9171); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getXConstructorCallAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3927:1: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3928:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3928:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3929:3: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall9192);
                    	    lv_typeArguments_6_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"typeArguments",
                    	              		lv_typeArguments_6_0, 
                    	              		"JvmArgumentTypeReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop65;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,31,FOLLOW_31_in_ruleXConstructorCall9206); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXConstructorCallAccess().getGreaterThanSignKeyword_3_3());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3949:3: ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            int alt69=2;
            alt69 = dfa69.predict(input);
            switch (alt69) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3949:4: ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3949:4: ( ( '(' )=>otherlv_8= '(' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3949:5: ( '(' )=>otherlv_8= '('
                    {
                    otherlv_8=(Token)match(input,47,FOLLOW_47_in_ruleXConstructorCall9229); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_4_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3954:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?
                    int alt68=3;
                    alt68 = dfa68.predict(input);
                    switch (alt68) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3954:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3954:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3954:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3971:1: (lv_arguments_9_0= ruleXShortClosure )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3972:3: lv_arguments_9_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXShortClosureParserRuleCall_4_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXShortClosure_in_ruleXConstructorCall9302);
                            lv_arguments_9_0=ruleXShortClosure();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"arguments",
                                      		lv_arguments_9_0, 
                                      		"XShortClosure");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3989:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3989:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3989:7: ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3989:7: ( (lv_arguments_10_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3990:1: (lv_arguments_10_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3990:1: (lv_arguments_10_0= ruleXExpression )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3991:3: lv_arguments_10_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall9330);
                            lv_arguments_10_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"arguments",
                                      		lv_arguments_10_0, 
                                      		"XExpression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4007:2: (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                            loop67:
                            do {
                                int alt67=2;
                                int LA67_0 = input.LA(1);

                                if ( (LA67_0==46) ) {
                                    alt67=1;
                                }


                                switch (alt67) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4007:4: otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) )
                            	    {
                            	    otherlv_11=(Token)match(input,46,FOLLOW_46_in_ruleXConstructorCall9343); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_11, grammarAccess.getXConstructorCallAccess().getCommaKeyword_4_1_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4011:1: ( (lv_arguments_12_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4012:1: (lv_arguments_12_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4012:1: (lv_arguments_12_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4013:3: lv_arguments_12_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall9364);
                            	    lv_arguments_12_0=ruleXExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"arguments",
                            	              		lv_arguments_12_0, 
                            	              		"XExpression");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop67;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,48,FOLLOW_48_in_ruleXConstructorCall9381); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_4_2());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4033:3: ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            int alt70=2;
            alt70 = dfa70.predict(input);
            switch (alt70) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4033:4: ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4038:1: (lv_arguments_14_0= ruleXClosure )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4039:3: lv_arguments_14_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXClosureParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXConstructorCall9414);
                    lv_arguments_14_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_14_0, 
                              		"XClosure");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXConstructorCall"


    // $ANTLR start "entryRuleXBooleanLiteral"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4063:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBooleanLiteral = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4064:2: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4065:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral9451);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral9461); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXBooleanLiteral"


    // $ANTLR start "ruleXBooleanLiteral"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4072:1: ruleXBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4075:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4076:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4076:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4076:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4076:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4077:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4082:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==66) ) {
                alt71=1;
            }
            else if ( (LA71_0==67) ) {
                alt71=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4082:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,66,FOLLOW_66_in_ruleXBooleanLiteral9508); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4087:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4087:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4088:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4088:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4089:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,67,FOLLOW_67_in_ruleXBooleanLiteral9532); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isTrue_2_0, grammarAccess.getXBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXBooleanLiteralRule());
                      	        }
                             		setWithLastConsumed(current, "isTrue", true, "true");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXBooleanLiteral"


    // $ANTLR start "entryRuleXNullLiteral"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4110:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNullLiteral = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4111:2: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4112:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNullLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral9582);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral9592); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXNullLiteral"


    // $ANTLR start "ruleXNullLiteral"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4119:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4122:28: ( ( () otherlv_1= 'null' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4123:1: ( () otherlv_1= 'null' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4123:1: ( () otherlv_1= 'null' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4123:2: () otherlv_1= 'null'
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4123:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4124:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,68,FOLLOW_68_in_ruleXNullLiteral9638); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXNullLiteralAccess().getNullKeyword_1());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXNullLiteral"


    // $ANTLR start "entryRuleXNumberLiteral"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4141:1: entryRuleXNumberLiteral returns [EObject current=null] : iv_ruleXNumberLiteral= ruleXNumberLiteral EOF ;
    public final EObject entryRuleXNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNumberLiteral = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4142:2: (iv_ruleXNumberLiteral= ruleXNumberLiteral EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4143:2: iv_ruleXNumberLiteral= ruleXNumberLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNumberLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXNumberLiteral_in_entryRuleXNumberLiteral9674);
            iv_ruleXNumberLiteral=ruleXNumberLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNumberLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNumberLiteral9684); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXNumberLiteral"


    // $ANTLR start "ruleXNumberLiteral"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4150:1: ruleXNumberLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleNumber ) ) ) ;
    public final EObject ruleXNumberLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4153:28: ( ( () ( (lv_value_1_0= ruleNumber ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4154:1: ( () ( (lv_value_1_0= ruleNumber ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4154:1: ( () ( (lv_value_1_0= ruleNumber ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4154:2: () ( (lv_value_1_0= ruleNumber ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4154:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4155:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXNumberLiteralAccess().getXNumberLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4160:2: ( (lv_value_1_0= ruleNumber ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4161:1: (lv_value_1_0= ruleNumber )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4161:1: (lv_value_1_0= ruleNumber )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4162:3: lv_value_1_0= ruleNumber
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXNumberLiteralAccess().getValueNumberParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNumber_in_ruleXNumberLiteral9739);
            lv_value_1_0=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXNumberLiteralRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"Number");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXNumberLiteral"


    // $ANTLR start "entryRuleXStringLiteral"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4186:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXStringLiteral = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4187:2: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4188:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXStringLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral9775);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXStringLiteral9785); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXStringLiteral"


    // $ANTLR start "ruleXStringLiteral"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4195:1: ruleXStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4198:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4199:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4199:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4199:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4199:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4200:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXStringLiteralAccess().getXStringLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4205:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4206:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4206:1: (lv_value_1_0= RULE_STRING )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4207:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXStringLiteral9836); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getXStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getXStringLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXStringLiteral"


    // $ANTLR start "entryRuleXTypeLiteral"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4231:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeLiteral = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4232:2: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4233:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTypeLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral9877);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral9887); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXTypeLiteral"


    // $ANTLR start "ruleXTypeLiteral"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4240:1: ruleXTypeLiteral returns [EObject current=null] : ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4243:28: ( ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4244:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4244:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4244:2: () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')'
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4244:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4245:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTypeLiteralAccess().getXTypeLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,69,FOLLOW_69_in_ruleXTypeLiteral9933); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getTypeofKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,47,FOLLOW_47_in_ruleXTypeLiteral9945); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXTypeLiteralAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4258:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4259:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4259:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4260:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXTypeLiteralRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral9968);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,48,FOLLOW_48_in_ruleXTypeLiteral9980); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXTypeLiteralAccess().getRightParenthesisKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXTypeLiteral"


    // $ANTLR start "entryRuleXThrowExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4285:1: entryRuleXThrowExpression returns [EObject current=null] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final EObject entryRuleXThrowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXThrowExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4286:2: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4287:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXThrowExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression10016);
            iv_ruleXThrowExpression=ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXThrowExpression10026); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXThrowExpression"


    // $ANTLR start "ruleXThrowExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4294:1: ruleXThrowExpression returns [EObject current=null] : ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) ;
    public final EObject ruleXThrowExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4297:28: ( ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4298:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4298:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4298:2: () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4298:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4299:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,70,FOLLOW_70_in_ruleXThrowExpression10072); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4308:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4309:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4309:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4310:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXThrowExpression10093);
            lv_expression_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXThrowExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXThrowExpression"


    // $ANTLR start "entryRuleXReturnExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4334:1: entryRuleXReturnExpression returns [EObject current=null] : iv_ruleXReturnExpression= ruleXReturnExpression EOF ;
    public final EObject entryRuleXReturnExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXReturnExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4335:2: (iv_ruleXReturnExpression= ruleXReturnExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4336:2: iv_ruleXReturnExpression= ruleXReturnExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXReturnExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression10129);
            iv_ruleXReturnExpression=ruleXReturnExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXReturnExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXReturnExpression10139); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXReturnExpression"


    // $ANTLR start "ruleXReturnExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4343:1: ruleXReturnExpression returns [EObject current=null] : ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? ) ;
    public final EObject ruleXReturnExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4346:28: ( ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4347:1: ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4347:1: ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4347:2: () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4347:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4348:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXReturnExpressionAccess().getXReturnExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,71,FOLLOW_71_in_ruleXReturnExpression10185); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4357:1: ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?
            int alt72=2;
            alt72 = dfa72.predict(input);
            switch (alt72) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4357:2: ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4362:1: (lv_expression_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4363:3: lv_expression_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXReturnExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXReturnExpression10216);
                    lv_expression_2_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXReturnExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_2_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXReturnExpression"


    // $ANTLR start "entryRuleXTryCatchFinallyExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4387:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTryCatchFinallyExpression = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4388:2: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4389:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression10253);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression10263); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXTryCatchFinallyExpression"


    // $ANTLR start "ruleXTryCatchFinallyExpression"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4396:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) ;
    public final EObject ruleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expression_2_0 = null;

        EObject lv_catchClauses_3_0 = null;

        EObject lv_finallyExpression_5_0 = null;

        EObject lv_finallyExpression_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4399:28: ( ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4400:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4400:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4400:2: () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4400:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4401:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,72,FOLLOW_72_in_ruleXTryCatchFinallyExpression10309); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4410:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4411:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4411:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4412:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10330);
            lv_expression_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4428:2: ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==74) ) {
                alt75=1;
            }
            else if ( (LA75_0==73) ) {
                alt75=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4428:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4428:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4428:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4428:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+
                    int cnt73=0;
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==74) ) {
                            int LA73_2 = input.LA(2);

                            if ( (synpred30_InternalTutorial()) ) {
                                alt73=1;
                            }


                        }


                        switch (alt73) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4428:5: ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause )
                    	    {
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4430:1: (lv_catchClauses_3_0= ruleXCatchClause )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4431:3: lv_catchClauses_3_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_3_0_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression10360);
                    	    lv_catchClauses_3_0=ruleXCatchClause();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"catchClauses",
                    	              		lv_catchClauses_3_0, 
                    	              		"XCatchClause");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt73 >= 1 ) break loop73;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(73, input);
                                throw eee;
                        }
                        cnt73++;
                    } while (true);

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4447:3: ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==73) ) {
                        int LA74_1 = input.LA(2);

                        if ( (synpred31_InternalTutorial()) ) {
                            alt74=1;
                        }
                    }
                    switch (alt74) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4447:4: ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4447:4: ( ( 'finally' )=>otherlv_4= 'finally' )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4447:5: ( 'finally' )=>otherlv_4= 'finally'
                            {
                            otherlv_4=(Token)match(input,73,FOLLOW_73_in_ruleXTryCatchFinallyExpression10382); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_0_1_0());
                                  
                            }

                            }

                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4452:2: ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4453:1: (lv_finallyExpression_5_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4453:1: (lv_finallyExpression_5_0= ruleXExpression )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4454:3: lv_finallyExpression_5_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10404);
                            lv_finallyExpression_5_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"finallyExpression",
                                      		lv_finallyExpression_5_0, 
                                      		"XExpression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4471:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4471:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4471:8: otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,73,FOLLOW_73_in_ruleXTryCatchFinallyExpression10426); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_1_0());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4475:1: ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4476:1: (lv_finallyExpression_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4476:1: (lv_finallyExpression_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4477:3: lv_finallyExpression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10447);
                    lv_finallyExpression_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"finallyExpression",
                              		lv_finallyExpression_7_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXTryCatchFinallyExpression"


    // $ANTLR start "entryRuleXCatchClause"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4501:1: entryRuleXCatchClause returns [EObject current=null] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCatchClause = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4502:2: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4503:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCatchClauseRule()); 
            }
            pushFollow(FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause10485);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCatchClause10495); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXCatchClause"


    // $ANTLR start "ruleXCatchClause"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4510:1: ruleXCatchClause returns [EObject current=null] : ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4513:28: ( ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4514:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4514:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4514:2: ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4514:2: ( ( 'catch' )=>otherlv_0= 'catch' )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4514:3: ( 'catch' )=>otherlv_0= 'catch'
            {
            otherlv_0=(Token)match(input,74,FOLLOW_74_in_ruleXCatchClause10540); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0());
                  
            }

            }

            otherlv_1=(Token)match(input,47,FOLLOW_47_in_ruleXCatchClause10553); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4523:1: ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4524:1: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4524:1: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4525:3: lv_declaredParam_2_0= ruleFullJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamFullJvmFormalParameterParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFullJvmFormalParameter_in_ruleXCatchClause10574);
            lv_declaredParam_2_0=ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXCatchClauseRule());
              	        }
                     		set(
                     			current, 
                     			"declaredParam",
                      		lv_declaredParam_2_0, 
                      		"FullJvmFormalParameter");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,48,FOLLOW_48_in_ruleXCatchClause10586); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4545:1: ( (lv_expression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4546:1: (lv_expression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4546:1: (lv_expression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4547:3: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCatchClause10607);
            lv_expression_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXCatchClauseRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_4_0, 
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXCatchClause"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4571:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4572:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4573:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10644);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName10655); if (state.failed) return current;

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4580:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4583:28: ( (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4584:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4584:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4585:5: this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName10702);
            this_ValidID_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ValidID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4595:1: ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==43) ) {
                    int LA76_2 = input.LA(2);

                    if ( (LA76_2==RULE_ID) ) {
                        int LA76_3 = input.LA(3);

                        if ( (synpred33_InternalTutorial()) ) {
                            alt76=1;
                        }


                    }


                }


                switch (alt76) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4595:2: ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID
            	    {
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4595:2: ( ( '.' )=>kw= '.' )
            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4595:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,43,FOLLOW_43_in_ruleQualifiedName10730); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName10753);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleNumber"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4622:1: entryRuleNumber returns [String current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final String entryRuleNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumber = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4626:2: (iv_ruleNumber= ruleNumber EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4627:2: iv_ruleNumber= ruleNumber EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberRule()); 
            }
            pushFollow(FOLLOW_ruleNumber_in_entryRuleNumber10807);
            iv_ruleNumber=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumber.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumber10818); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4637:1: ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) ) ;
    public final AntlrDatatypeRuleToken ruleNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEX_0=null;
        Token this_INT_1=null;
        Token this_DECIMAL_2=null;
        Token kw=null;
        Token this_INT_4=null;
        Token this_DECIMAL_5=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4641:28: ( (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4642:1: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4642:1: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_HEX) ) {
                alt80=1;
            }
            else if ( ((LA80_0>=RULE_INT && LA80_0<=RULE_DECIMAL)) ) {
                alt80=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4642:6: this_HEX_0= RULE_HEX
                    {
                    this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleNumber10862); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_HEX_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_HEX_0, grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4650:6: ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4650:6: ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4650:7: (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )?
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4650:7: (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL )
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==RULE_INT) ) {
                        alt77=1;
                    }
                    else if ( (LA77_0==RULE_DECIMAL) ) {
                        alt77=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 77, 0, input);

                        throw nvae;
                    }
                    switch (alt77) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4650:12: this_INT_1= RULE_INT
                            {
                            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNumber10890); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_INT_1);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_INT_1, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_0_0()); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4658:10: this_DECIMAL_2= RULE_DECIMAL
                            {
                            this_DECIMAL_2=(Token)match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_ruleNumber10916); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_DECIMAL_2);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_DECIMAL_2, grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_0_1()); 
                                  
                            }

                            }
                            break;

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4665:2: (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )?
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==43) ) {
                        int LA79_1 = input.LA(2);

                        if ( ((LA79_1>=RULE_INT && LA79_1<=RULE_DECIMAL)) ) {
                            alt79=1;
                        }
                    }
                    switch (alt79) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4666:2: kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL )
                            {
                            kw=(Token)match(input,43,FOLLOW_43_in_ruleNumber10936); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getNumberAccess().getFullStopKeyword_1_1_0()); 
                                  
                            }
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4671:1: (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL )
                            int alt78=2;
                            int LA78_0 = input.LA(1);

                            if ( (LA78_0==RULE_INT) ) {
                                alt78=1;
                            }
                            else if ( (LA78_0==RULE_DECIMAL) ) {
                                alt78=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 78, 0, input);

                                throw nvae;
                            }
                            switch (alt78) {
                                case 1 :
                                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4671:6: this_INT_4= RULE_INT
                                    {
                                    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNumber10952); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      		current.merge(this_INT_4);
                                          
                                    }
                                    if ( state.backtracking==0 ) {
                                       
                                          newLeafNode(this_INT_4, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1_1_0()); 
                                          
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4679:10: this_DECIMAL_5= RULE_DECIMAL
                                    {
                                    this_DECIMAL_5=(Token)match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_ruleNumber10978); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      		current.merge(this_DECIMAL_5);
                                          
                                    }
                                    if ( state.backtracking==0 ) {
                                       
                                          newLeafNode(this_DECIMAL_5, grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_1_1_1()); 
                                          
                                    }

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleNumber"


    // $ANTLR start "entryRuleJvmTypeReference"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4697:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4698:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4699:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference11031);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference11041); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmTypeReference"


    // $ANTLR start "ruleJvmTypeReference"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4706:1: ruleJvmTypeReference returns [EObject current=null] : ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4709:28: ( ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4710:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4710:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==RULE_ID) ) {
                alt82=1;
            }
            else if ( (LA82_0==47||LA82_0==75) ) {
                alt82=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4710:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4710:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )* )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4711:5: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )*
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference11089);
                    this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmParameterizedTypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4719:1: ( ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' ) )*
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==49) ) {
                            int LA81_2 = input.LA(2);

                            if ( (LA81_2==51) ) {
                                int LA81_3 = input.LA(3);

                                if ( (synpred34_InternalTutorial()) ) {
                                    alt81=1;
                                }


                            }


                        }


                        switch (alt81) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4719:2: ( ( () '[' ']' ) )=> ( () otherlv_2= '[' otherlv_3= ']' )
                    	    {
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4722:5: ( () otherlv_2= '[' otherlv_3= ']' )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4722:6: () otherlv_2= '[' otherlv_3= ']'
                    	    {
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4722:6: ()
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4723:5: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	              current = forceCreateModelElementAndSet(
                    	                  grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0(),
                    	                  current);
                    	          
                    	    }

                    	    }

                    	    otherlv_2=(Token)match(input,49,FOLLOW_49_in_ruleJvmTypeReference11127); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getJvmTypeReferenceAccess().getLeftSquareBracketKeyword_0_1_0_1());
                    	          
                    	    }
                    	    otherlv_3=(Token)match(input,51,FOLLOW_51_in_ruleJvmTypeReference11139); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmTypeReferenceAccess().getRightSquareBracketKeyword_0_1_0_2());
                    	          
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop81;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4738:5: this_XFunctionTypeRef_4= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference11171);
                    this_XFunctionTypeRef_4=ruleXFunctionTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XFunctionTypeRef_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmTypeReference"


    // $ANTLR start "entryRuleXFunctionTypeRef"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4754:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4755:2: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4756:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFunctionTypeRefRule()); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef11206);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef11216); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXFunctionTypeRef"


    // $ANTLR start "ruleXFunctionTypeRef"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4763:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_paramTypes_1_0 = null;

        EObject lv_paramTypes_3_0 = null;

        EObject lv_returnType_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4766:28: ( ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4767:1: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4767:1: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4767:2: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4767:2: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==47) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4767:4: otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,47,FOLLOW_47_in_ruleXFunctionTypeRef11254); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4771:1: ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )?
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==RULE_ID||LA84_0==47||LA84_0==75) ) {
                        alt84=1;
                    }
                    switch (alt84) {
                        case 1 :
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4771:2: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4771:2: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4772:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            {
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4772:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4773:3: lv_paramTypes_1_0= ruleJvmTypeReference
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11276);
                            lv_paramTypes_1_0=ruleJvmTypeReference();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"paramTypes",
                                      		lv_paramTypes_1_0, 
                                      		"JvmTypeReference");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4789:2: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            loop83:
                            do {
                                int alt83=2;
                                int LA83_0 = input.LA(1);

                                if ( (LA83_0==46) ) {
                                    alt83=1;
                                }


                                switch (alt83) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4789:4: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    {
                            	    otherlv_2=(Token)match(input,46,FOLLOW_46_in_ruleXFunctionTypeRef11289); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4793:1: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4794:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    {
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4794:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4795:3: lv_paramTypes_3_0= ruleJvmTypeReference
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11310);
                            	    lv_paramTypes_3_0=ruleJvmTypeReference();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"paramTypes",
                            	              		lv_paramTypes_3_0, 
                            	              		"JvmTypeReference");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop83;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,48,FOLLOW_48_in_ruleXFunctionTypeRef11326); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,75,FOLLOW_75_in_ruleXFunctionTypeRef11340); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4819:1: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4820:1: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4820:1: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4821:3: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11361);
            lv_returnType_6_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
              	        }
                     		set(
                     			current, 
                     			"returnType",
                      		lv_returnType_6_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXFunctionTypeRef"


    // $ANTLR start "entryRuleJvmParameterizedTypeReference"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4845:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4846:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4847:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference11397);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference11407); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmParameterizedTypeReference"


    // $ANTLR start "ruleJvmParameterizedTypeReference"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4854:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4857:28: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4858:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4858:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4858:2: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4858:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4859:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4859:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4860:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference11455);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4873:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt87=2;
            alt87 = dfa87.predict(input);
            switch (alt87) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4873:3: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4873:3: ( ( '<' )=>otherlv_1= '<' )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4873:4: ( '<' )=>otherlv_1= '<'
                    {
                    otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleJvmParameterizedTypeReference11476); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4878:2: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4879:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4879:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4880:3: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11498);
                    lv_arguments_2_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_2_0, 
                              		"JvmArgumentTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4896:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop86:
                    do {
                        int alt86=2;
                        int LA86_0 = input.LA(1);

                        if ( (LA86_0==46) ) {
                            alt86=1;
                        }


                        switch (alt86) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4896:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,46,FOLLOW_46_in_ruleJvmParameterizedTypeReference11511); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4900:1: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4901:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4901:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4902:3: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11532);
                    	    lv_arguments_4_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"arguments",
                    	              		lv_arguments_4_0, 
                    	              		"JvmArgumentTypeReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop86;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,31,FOLLOW_31_in_ruleJvmParameterizedTypeReference11546); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmParameterizedTypeReference"


    // $ANTLR start "entryRuleJvmArgumentTypeReference"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4930:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4931:2: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4932:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference11584);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference11594); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmArgumentTypeReference"


    // $ANTLR start "ruleJvmArgumentTypeReference"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4939:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4942:28: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4943:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4943:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==RULE_ID||LA88_0==47||LA88_0==75) ) {
                alt88=1;
            }
            else if ( (LA88_0==76) ) {
                alt88=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4944:5: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference11641);
                    this_JvmTypeReference_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmTypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4954:5: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference11668);
                    this_JvmWildcardTypeReference_1=ruleJvmWildcardTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmWildcardTypeReference_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmArgumentTypeReference"


    // $ANTLR start "entryRuleJvmWildcardTypeReference"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4970:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4971:2: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4972:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference11703);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference11713); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmWildcardTypeReference"


    // $ANTLR start "ruleJvmWildcardTypeReference"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4979:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4982:28: ( ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4983:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4983:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4983:2: () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4983:2: ()
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4984:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,76,FOLLOW_76_in_ruleJvmWildcardTypeReference11759); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4993:1: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt89=3;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==20) ) {
                alt89=1;
            }
            else if ( (LA89_0==63) ) {
                alt89=2;
            }
            switch (alt89) {
                case 1 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4993:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4993:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4994:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4994:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4995:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference11781);
                    lv_constraints_2_0=ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"constraints",
                              		lv_constraints_2_0, 
                              		"JvmUpperBound");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5012:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5012:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5013:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5013:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5014:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference11808);
                    lv_constraints_3_0=ruleJvmLowerBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"constraints",
                              		lv_constraints_3_0, 
                              		"JvmLowerBound");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmWildcardTypeReference"


    // $ANTLR start "entryRuleJvmUpperBound"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5038:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5039:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5040:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound11846);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound11856); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmUpperBound"


    // $ANTLR start "ruleJvmUpperBound"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5047:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5050:28: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5051:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5051:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5051:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleJvmUpperBound11893); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5055:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5056:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5056:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5057:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound11914);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmUpperBoundRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmUpperBound"


    // $ANTLR start "entryRuleJvmUpperBoundAnded"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5081:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5082:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5083:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded11950);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded11960); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmUpperBoundAnded"


    // $ANTLR start "ruleJvmUpperBoundAnded"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5090:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5093:28: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5094:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5094:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5094:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,77,FOLLOW_77_in_ruleJvmUpperBoundAnded11997); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5098:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5099:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5099:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5100:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded12018);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmUpperBoundAndedRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmUpperBoundAnded"


    // $ANTLR start "entryRuleJvmLowerBound"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5124:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5125:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5126:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound12054);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound12064); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmLowerBound"


    // $ANTLR start "ruleJvmLowerBound"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5133:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5136:28: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5137:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5137:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5137:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,63,FOLLOW_63_in_ruleJvmLowerBound12101); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
                  
            }
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5141:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5142:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5142:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5143:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound12122);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmLowerBoundRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmLowerBound"


    // $ANTLR start "entryRuleValidID"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5169:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5170:2: (iv_ruleValidID= ruleValidID EOF )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5171:2: iv_ruleValidID= ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID12161);
            iv_ruleValidID=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID12172); if (state.failed) return current;

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
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5178:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5181:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:5182:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID12211); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleValidID"

    // $ANTLR start synpred1_InternalTutorial
    public final void synpred1_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:635:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:635:4: ( () ( ( ruleOpMultiAssign ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:635:4: ( () ( ( ruleOpMultiAssign ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:635:5: () ( ( ruleOpMultiAssign ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:635:5: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:636:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:636:2: ( ( ruleOpMultiAssign ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:637:1: ( ruleOpMultiAssign )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:637:1: ( ruleOpMultiAssign )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:638:3: ruleOpMultiAssign
        {
        pushFollow(FOLLOW_ruleOpMultiAssign_in_synpred1_InternalTutorial1469);
        ruleOpMultiAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalTutorial

    // $ANTLR start synpred2_InternalTutorial
    public final void synpred2_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:763:3: ( ( () ( ( ruleOpOr ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:763:4: ( () ( ( ruleOpOr ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:763:4: ( () ( ( ruleOpOr ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:763:5: () ( ( ruleOpOr ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:763:5: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:764:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:764:2: ( ( ruleOpOr ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:765:1: ( ruleOpOr )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:765:1: ( ruleOpOr )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:766:3: ruleOpOr
        {
        pushFollow(FOLLOW_ruleOpOr_in_synpred2_InternalTutorial1817);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalTutorial

    // $ANTLR start synpred3_InternalTutorial
    public final void synpred3_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:864:3: ( ( () ( ( ruleOpAnd ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:864:4: ( () ( ( ruleOpAnd ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:864:4: ( () ( ( ruleOpAnd ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:864:5: () ( ( ruleOpAnd ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:864:5: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:865:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:865:2: ( ( ruleOpAnd ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:866:1: ( ruleOpAnd )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:866:1: ( ruleOpAnd )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:867:3: ruleOpAnd
        {
        pushFollow(FOLLOW_ruleOpAnd_in_synpred3_InternalTutorial2076);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalTutorial

    // $ANTLR start synpred4_InternalTutorial
    public final void synpred4_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:965:3: ( ( () ( ( ruleOpEquality ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:965:4: ( () ( ( ruleOpEquality ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:965:4: ( () ( ( ruleOpEquality ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:965:5: () ( ( ruleOpEquality ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:965:5: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:966:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:966:2: ( ( ruleOpEquality ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:967:1: ( ruleOpEquality )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:967:1: ( ruleOpEquality )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:968:3: ruleOpEquality
        {
        pushFollow(FOLLOW_ruleOpEquality_in_synpred4_InternalTutorial2335);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalTutorial

    // $ANTLR start synpred5_InternalTutorial
    public final void synpred5_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1073:4: ( ( () 'instanceof' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1073:5: ( () 'instanceof' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1073:5: ( () 'instanceof' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1073:6: () 'instanceof'
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1073:6: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1074:1: 
        {
        }

        match(input,28,FOLLOW_28_in_synpred5_InternalTutorial2611); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalTutorial

    // $ANTLR start synpred6_InternalTutorial
    public final void synpred6_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1104:8: ( ( () ( ( ruleOpCompare ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1104:9: ( () ( ( ruleOpCompare ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1104:9: ( () ( ( ruleOpCompare ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1104:10: () ( ( ruleOpCompare ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1104:10: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1105:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1105:2: ( ( ruleOpCompare ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1106:1: ( ruleOpCompare )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1106:1: ( ruleOpCompare )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1107:3: ruleOpCompare
        {
        pushFollow(FOLLOW_ruleOpCompare_in_synpred6_InternalTutorial2682);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred6_InternalTutorial

    // $ANTLR start synpred7_InternalTutorial
    public final void synpred7_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1226:3: ( ( () ( ( ruleOpOther ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1226:4: ( () ( ( ruleOpOther ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1226:4: ( () ( ( ruleOpOther ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1226:5: () ( ( ruleOpOther ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1226:5: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1227:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1227:2: ( ( ruleOpOther ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1228:1: ( ruleOpOther )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1228:1: ( ruleOpOther )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1229:3: ruleOpOther
        {
        pushFollow(FOLLOW_ruleOpOther_in_synpred7_InternalTutorial3001);
        ruleOpOther();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalTutorial

    // $ANTLR start synpred8_InternalTutorial
    public final void synpred8_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1334:3: ( ( () ( ( ruleOpAdd ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1334:4: ( () ( ( ruleOpAdd ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1334:4: ( () ( ( ruleOpAdd ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1334:5: () ( ( ruleOpAdd ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1334:5: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1335:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1335:2: ( ( ruleOpAdd ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1336:1: ( ruleOpAdd )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1336:1: ( ruleOpAdd )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1337:3: ruleOpAdd
        {
        pushFollow(FOLLOW_ruleOpAdd_in_synpred8_InternalTutorial3281);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred8_InternalTutorial

    // $ANTLR start synpred9_InternalTutorial
    public final void synpred9_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1442:3: ( ( () ( ( ruleOpMulti ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1442:4: ( () ( ( ruleOpMulti ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1442:4: ( () ( ( ruleOpMulti ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1442:5: () ( ( ruleOpMulti ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1442:5: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1443:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1443:2: ( ( ruleOpMulti ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1444:1: ( ruleOpMulti )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1444:1: ( ruleOpMulti )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1445:3: ruleOpMulti
        {
        pushFollow(FOLLOW_ruleOpMulti_in_synpred9_InternalTutorial3561);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalTutorial

    // $ANTLR start synpred10_InternalTutorial
    public final void synpred10_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1675:3: ( ( () 'as' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1675:4: ( () 'as' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1675:4: ( () 'as' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1675:5: () 'as'
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1675:5: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1676:1: 
        {
        }

        match(input,42,FOLLOW_42_in_synpred10_InternalTutorial4155); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred10_InternalTutorial

    // $ANTLR start synpred11_InternalTutorial
    public final void synpred11_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1735:4: ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1735:5: ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1735:5: ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1735:6: () '.' ( ( ruleValidID ) ) ruleOpSingleAssign
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1735:6: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1736:1: 
        {
        }

        match(input,43,FOLLOW_43_in_synpred11_InternalTutorial4309); if (state.failed) return ;
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1737:1: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1738:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1738:1: ( ruleValidID )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1739:3: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred11_InternalTutorial4318);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        pushFollow(FOLLOW_ruleOpSingleAssign_in_synpred11_InternalTutorial4324);
        ruleOpSingleAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred11_InternalTutorial

    // $ANTLR start synpred12_InternalTutorial
    public final void synpred12_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1793:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1793:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1793:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1793:10: () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1793:10: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1794:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1794:2: ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        int alt90=3;
        switch ( input.LA(1) ) {
        case 43:
            {
            alt90=1;
            }
            break;
        case 44:
            {
            alt90=2;
            }
            break;
        case 45:
            {
            alt90=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 90, 0, input);

            throw nvae;
        }

        switch (alt90) {
            case 1 :
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1794:4: '.'
                {
                match(input,43,FOLLOW_43_in_synpred12_InternalTutorial4427); if (state.failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1796:6: ( ( '?.' ) )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1796:6: ( ( '?.' ) )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1797:1: ( '?.' )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1797:1: ( '?.' )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1798:2: '?.'
                {
                match(input,44,FOLLOW_44_in_synpred12_InternalTutorial4441); if (state.failed) return ;

                }


                }


                }
                break;
            case 3 :
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1803:6: ( ( '*.' ) )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1803:6: ( ( '*.' ) )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1804:1: ( '*.' )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1804:1: ( '*.' )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1805:2: '*.'
                {
                match(input,45,FOLLOW_45_in_synpred12_InternalTutorial4461); if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred12_InternalTutorial

    // $ANTLR start synpred13_InternalTutorial
    public final void synpred13_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1914:4: ( ( '(' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1915:1: ( '(' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1915:1: ( '(' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1916:2: '('
        {
        match(input,47,FOLLOW_47_in_synpred13_InternalTutorial4688); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_InternalTutorial

    // $ANTLR start synpred14_InternalTutorial
    public final void synpred14_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1935:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1935:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1935:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1935:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1935:6: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1936:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1936:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt92=2;
        int LA92_0 = input.LA(1);

        if ( (LA92_0==RULE_ID||LA92_0==47||LA92_0==75) ) {
            alt92=1;
        }
        switch (alt92) {
            case 1 :
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1936:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1936:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1937:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1937:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1938:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalTutorial4740);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1940:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop91:
                do {
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==46) ) {
                        alt91=1;
                    }


                    switch (alt91) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1940:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,46,FOLLOW_46_in_synpred14_InternalTutorial4747); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1941:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1942:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1942:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1943:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalTutorial4754);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop91;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1945:6: ( ( '|' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1946:1: ( '|' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1946:1: ( '|' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:1947:2: '|'
        {
        match(input,50,FOLLOW_50_in_synpred14_InternalTutorial4768); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred14_InternalTutorial

    // $ANTLR start synpred15_InternalTutorial
    public final void synpred15_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2014:4: ( ( ruleXClosure ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2015:1: ( ruleXClosure )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2015:1: ( ruleXClosure )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2016:1: ruleXClosure
        {
        pushFollow(FOLLOW_ruleXClosure_in_synpred15_InternalTutorial4886);
        ruleXClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred15_InternalTutorial

    // $ANTLR start synpred16_InternalTutorial
    public final void synpred16_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2297:2: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2297:3: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2297:3: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2297:4: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2297:4: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt94=2;
        int LA94_0 = input.LA(1);

        if ( (LA94_0==RULE_ID||LA94_0==47||LA94_0==75) ) {
            alt94=1;
        }
        switch (alt94) {
            case 1 :
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2297:5: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2297:5: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2298:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2298:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2299:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalTutorial5659);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2301:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop93:
                do {
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==46) ) {
                        alt93=1;
                    }


                    switch (alt93) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2301:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,46,FOLLOW_46_in_synpred16_InternalTutorial5666); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2302:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2303:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2303:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2304:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalTutorial5673);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop93;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2306:6: ( ( '|' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2307:1: ( '|' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2307:1: ( '|' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2308:2: '|'
        {
        match(input,50,FOLLOW_50_in_synpred16_InternalTutorial5687); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred16_InternalTutorial

    // $ANTLR start synpred18_InternalTutorial
    public final void synpred18_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2667:4: ( 'else' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2667:6: 'else'
        {
        match(input,54,FOLLOW_54_in_synpred18_InternalTutorial6470); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_InternalTutorial

    // $ANTLR start synpred19_InternalTutorial
    public final void synpred19_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2721:4: ( ( ( ( ruleValidID ) ) ':' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2721:5: ( ( ( ruleValidID ) ) ':' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2721:5: ( ( ( ruleValidID ) ) ':' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2721:6: ( ( ruleValidID ) ) ':'
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2721:6: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2722:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2722:1: ( ruleValidID )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2723:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred19_InternalTutorial6612);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,21,FOLLOW_21_in_synpred19_InternalTutorial6618); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred19_InternalTutorial

    // $ANTLR start synpred20_InternalTutorial
    public final void synpred20_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2767:8: ( ( '(' ( ( ruleValidID ) ) ':' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2767:9: ( '(' ( ( ruleValidID ) ) ':' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2767:9: ( '(' ( ( ruleValidID ) ) ':' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2767:11: '(' ( ( ruleValidID ) ) ':'
        {
        match(input,47,FOLLOW_47_in_synpred20_InternalTutorial6694); if (state.failed) return ;
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2768:1: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2769:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2769:1: ( ruleValidID )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:2770:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred20_InternalTutorial6701);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,21,FOLLOW_21_in_synpred20_InternalTutorial6707); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred20_InternalTutorial

    // $ANTLR start synpred21_InternalTutorial
    public final void synpred21_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3351:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3351:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3351:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3351:6: ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3351:6: ( ( ruleJvmTypeReference ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3352:1: ( ruleJvmTypeReference )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3352:1: ( ruleJvmTypeReference )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3353:1: ruleJvmTypeReference
        {
        pushFollow(FOLLOW_ruleJvmTypeReference_in_synpred21_InternalTutorial7972);
        ruleJvmTypeReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3355:2: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3356:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3356:1: ( ruleValidID )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3357:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred21_InternalTutorial7981);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred21_InternalTutorial

    // $ANTLR start synpred22_InternalTutorial
    public final void synpred22_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3655:4: ( ( '(' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3656:1: ( '(' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3656:1: ( '(' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3657:2: '('
        {
        match(input,47,FOLLOW_47_in_synpred22_InternalTutorial8543); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred22_InternalTutorial

    // $ANTLR start synpred23_InternalTutorial
    public final void synpred23_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3676:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3676:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3676:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3676:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3676:6: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3677:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3677:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt98=2;
        int LA98_0 = input.LA(1);

        if ( (LA98_0==RULE_ID||LA98_0==47||LA98_0==75) ) {
            alt98=1;
        }
        switch (alt98) {
            case 1 :
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3677:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3677:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3678:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3678:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3679:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred23_InternalTutorial8595);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3681:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop97:
                do {
                    int alt97=2;
                    int LA97_0 = input.LA(1);

                    if ( (LA97_0==46) ) {
                        alt97=1;
                    }


                    switch (alt97) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3681:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,46,FOLLOW_46_in_synpred23_InternalTutorial8602); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3682:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3683:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3683:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3684:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred23_InternalTutorial8609);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop97;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3686:6: ( ( '|' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3687:1: ( '|' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3687:1: ( '|' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3688:2: '|'
        {
        match(input,50,FOLLOW_50_in_synpred23_InternalTutorial8623); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred23_InternalTutorial

    // $ANTLR start synpred24_InternalTutorial
    public final void synpred24_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3755:4: ( ( ruleXClosure ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3756:1: ( ruleXClosure )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3756:1: ( ruleXClosure )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3757:1: ruleXClosure
        {
        pushFollow(FOLLOW_ruleXClosure_in_synpred24_InternalTutorial8741);
        ruleXClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred24_InternalTutorial

    // $ANTLR start synpred25_InternalTutorial
    public final void synpred25_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3900:4: ( '<' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3900:6: '<'
        {
        match(input,32,FOLLOW_32_in_synpred25_InternalTutorial9128); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_InternalTutorial

    // $ANTLR start synpred26_InternalTutorial
    public final void synpred26_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3949:5: ( '(' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3949:7: '('
        {
        match(input,47,FOLLOW_47_in_synpred26_InternalTutorial9221); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_InternalTutorial

    // $ANTLR start synpred27_InternalTutorial
    public final void synpred27_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3954:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3954:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3954:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3954:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3954:6: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3955:1: 
        {
        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3955:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt100=2;
        int LA100_0 = input.LA(1);

        if ( (LA100_0==RULE_ID||LA100_0==47||LA100_0==75) ) {
            alt100=1;
        }
        switch (alt100) {
            case 1 :
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3955:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3955:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3956:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3956:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3957:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred27_InternalTutorial9251);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3959:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop99:
                do {
                    int alt99=2;
                    int LA99_0 = input.LA(1);

                    if ( (LA99_0==46) ) {
                        alt99=1;
                    }


                    switch (alt99) {
                	case 1 :
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3959:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,46,FOLLOW_46_in_synpred27_InternalTutorial9258); if (state.failed) return ;
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3960:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3961:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3961:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3962:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred27_InternalTutorial9265);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop99;
                    }
                } while (true);


                }
                break;

        }

        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3964:6: ( ( '|' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3965:1: ( '|' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3965:1: ( '|' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:3966:2: '|'
        {
        match(input,50,FOLLOW_50_in_synpred27_InternalTutorial9279); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred27_InternalTutorial

    // $ANTLR start synpred28_InternalTutorial
    public final void synpred28_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4033:4: ( ( ruleXClosure ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4034:1: ( ruleXClosure )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4034:1: ( ruleXClosure )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4035:1: ruleXClosure
        {
        pushFollow(FOLLOW_ruleXClosure_in_synpred28_InternalTutorial9397);
        ruleXClosure();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred28_InternalTutorial

    // $ANTLR start synpred29_InternalTutorial
    public final void synpred29_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4357:2: ( ( ruleXExpression ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4358:1: ( ruleXExpression )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4358:1: ( ruleXExpression )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4359:1: ruleXExpression
        {
        pushFollow(FOLLOW_ruleXExpression_in_synpred29_InternalTutorial10199);
        ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred29_InternalTutorial

    // $ANTLR start synpred30_InternalTutorial
    public final void synpred30_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4428:5: ( 'catch' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4428:7: 'catch'
        {
        match(input,74,FOLLOW_74_in_synpred30_InternalTutorial10344); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_InternalTutorial

    // $ANTLR start synpred31_InternalTutorial
    public final void synpred31_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4447:5: ( 'finally' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4447:7: 'finally'
        {
        match(input,73,FOLLOW_73_in_synpred31_InternalTutorial10374); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_InternalTutorial

    // $ANTLR start synpred33_InternalTutorial
    public final void synpred33_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4595:3: ( '.' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4596:2: '.'
        {
        match(input,43,FOLLOW_43_in_synpred33_InternalTutorial10721); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_InternalTutorial

    // $ANTLR start synpred34_InternalTutorial
    public final void synpred34_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4719:2: ( ( () '[' ']' ) )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4719:3: ( () '[' ']' )
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4719:3: ( () '[' ']' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4719:4: () '[' ']'
        {
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4719:4: ()
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4720:1: 
        {
        }

        match(input,49,FOLLOW_49_in_synpred34_InternalTutorial11104); if (state.failed) return ;
        match(input,51,FOLLOW_51_in_synpred34_InternalTutorial11108); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred34_InternalTutorial

    // $ANTLR start synpred35_InternalTutorial
    public final void synpred35_InternalTutorial_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4873:4: ( '<' )
        // ../org.eclipse.xtext.example.tutorial/src-gen/org/eclipse/xtext/example/tutorial/parser/antlr/internal/InternalTutorial.g:4873:6: '<'
        {
        match(input,32,FOLLOW_32_in_synpred35_InternalTutorial11468); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_InternalTutorial

    // Delegated rules

    public final boolean synpred28_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalTutorial() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalTutorial_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA30 dfa30 = new DFA30(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA60 dfa60 = new DFA60(this);
    protected DFA62 dfa62 = new DFA62(this);
    protected DFA66 dfa66 = new DFA66(this);
    protected DFA69 dfa69 = new DFA69(this);
    protected DFA68 dfa68 = new DFA68(this);
    protected DFA70 dfa70 = new DFA70(this);
    protected DFA72 dfa72 = new DFA72(this);
    protected DFA87 dfa87 = new DFA87(this);
    static final String DFA30_eotS =
        "\76\uffff";
    static final String DFA30_eofS =
        "\1\2\75\uffff";
    static final String DFA30_minS =
        "\1\4\1\0\74\uffff";
    static final String DFA30_maxS =
        "\1\113\1\0\74\uffff";
    static final String DFA30_acceptS =
        "\2\uffff\1\2\72\uffff\1\1";
    static final String DFA30_specialS =
        "\1\uffff\1\0\74\uffff}>";
    static final String[] DFA30_transitionS = {
            "\5\2\5\uffff\2\2\5\uffff\1\2\1\uffff\30\2\1\1\2\2\1\uffff\15"+
            "\2\1\uffff\13\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "1914:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA30_1 = input.LA(1);

                         
                        int index30_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index30_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 30, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA29_eotS =
        "\36\uffff";
    static final String DFA29_eofS =
        "\36\uffff";
    static final String DFA29_minS =
        "\1\4\2\0\33\uffff";
    static final String DFA29_maxS =
        "\1\113\2\0\33\uffff";
    static final String DFA29_acceptS =
        "\3\uffff\2\1\1\2\27\uffff\1\3";
    static final String DFA29_specialS =
        "\1\0\1\1\1\2\33\uffff}>";
    static final String[] DFA29_transitionS = {
            "\4\5\1\1\5\uffff\1\5\21\uffff\1\5\2\uffff\2\5\4\uffff\1\5\5"+
            "\uffff\1\2\1\35\1\5\1\4\2\uffff\1\5\1\uffff\1\5\2\uffff\3\5"+
            "\2\uffff\1\5\1\uffff\10\5\2\uffff\1\3",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "1935:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA29_0 = input.LA(1);

                         
                        int index29_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA29_0==RULE_ID) ) {s = 1;}

                        else if ( (LA29_0==47) ) {s = 2;}

                        else if ( (LA29_0==75) && (synpred14_InternalTutorial())) {s = 3;}

                        else if ( (LA29_0==50) && (synpred14_InternalTutorial())) {s = 4;}

                        else if ( ((LA29_0>=RULE_STRING && LA29_0<=RULE_DECIMAL)||LA29_0==14||LA29_0==32||(LA29_0>=35 && LA29_0<=36)||LA29_0==41||LA29_0==49||LA29_0==53||LA29_0==55||(LA29_0>=58 && LA29_0<=60)||LA29_0==63||(LA29_0>=65 && LA29_0<=72)) ) {s = 5;}

                        else if ( (LA29_0==48) ) {s = 29;}

                         
                        input.seek(index29_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA29_1 = input.LA(1);

                         
                        int index29_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index29_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA29_2 = input.LA(1);

                         
                        int index29_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index29_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 29, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA31_eotS =
        "\76\uffff";
    static final String DFA31_eofS =
        "\1\2\75\uffff";
    static final String DFA31_minS =
        "\1\4\1\0\74\uffff";
    static final String DFA31_maxS =
        "\1\113\1\0\74\uffff";
    static final String DFA31_acceptS =
        "\2\uffff\1\2\72\uffff\1\1";
    static final String DFA31_specialS =
        "\1\uffff\1\0\74\uffff}>";
    static final String[] DFA31_transitionS = {
            "\5\2\5\uffff\2\2\5\uffff\1\2\1\uffff\32\2\1\1\1\uffff\15\2\1"+
            "\uffff\13\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
    static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
    static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
    static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
    static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
    static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
    static final short[][] DFA31_transition;

    static {
        int numStates = DFA31_transitionS.length;
        DFA31_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = DFA31_eot;
            this.eof = DFA31_eof;
            this.min = DFA31_min;
            this.max = DFA31_max;
            this.accept = DFA31_accept;
            this.special = DFA31_special;
            this.transition = DFA31_transition;
        }
        public String getDescription() {
            return "2014:3: ( ( ( ruleXClosure ) )=> (lv_memberCallArguments_22_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA31_1 = input.LA(1);

                         
                        int index31_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index31_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 31, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA37_eotS =
        "\40\uffff";
    static final String DFA37_eofS =
        "\40\uffff";
    static final String DFA37_minS =
        "\1\4\2\0\35\uffff";
    static final String DFA37_maxS =
        "\1\113\2\0\35\uffff";
    static final String DFA37_acceptS =
        "\3\uffff\2\1\1\2\32\uffff";
    static final String DFA37_specialS =
        "\1\0\1\1\1\2\35\uffff}>";
    static final String[] DFA37_transitionS = {
            "\4\5\1\1\5\uffff\1\5\21\uffff\1\5\2\uffff\2\5\4\uffff\1\5\5"+
            "\uffff\1\2\1\uffff\1\5\1\4\1\5\1\uffff\1\5\1\uffff\1\5\2\uffff"+
            "\6\5\1\uffff\10\5\2\uffff\1\3",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "2297:1: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA37_0 = input.LA(1);

                         
                        int index37_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA37_0==RULE_ID) ) {s = 1;}

                        else if ( (LA37_0==47) ) {s = 2;}

                        else if ( (LA37_0==75) && (synpred16_InternalTutorial())) {s = 3;}

                        else if ( (LA37_0==50) && (synpred16_InternalTutorial())) {s = 4;}

                        else if ( ((LA37_0>=RULE_STRING && LA37_0<=RULE_DECIMAL)||LA37_0==14||LA37_0==32||(LA37_0>=35 && LA37_0<=36)||LA37_0==41||LA37_0==49||LA37_0==51||LA37_0==53||LA37_0==55||(LA37_0>=58 && LA37_0<=63)||(LA37_0>=65 && LA37_0<=72)) ) {s = 5;}

                         
                        input.seek(index37_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA37_1 = input.LA(1);

                         
                        int index37_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index37_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA37_2 = input.LA(1);

                         
                        int index37_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index37_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 37, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA61_eotS =
        "\76\uffff";
    static final String DFA61_eofS =
        "\1\2\75\uffff";
    static final String DFA61_minS =
        "\1\4\1\0\74\uffff";
    static final String DFA61_maxS =
        "\1\113\1\0\74\uffff";
    static final String DFA61_acceptS =
        "\2\uffff\1\2\72\uffff\1\1";
    static final String DFA61_specialS =
        "\1\uffff\1\0\74\uffff}>";
    static final String[] DFA61_transitionS = {
            "\5\2\5\uffff\2\2\5\uffff\1\2\1\uffff\30\2\1\1\2\2\1\uffff\15"+
            "\2\1\uffff\13\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA61_eot = DFA.unpackEncodedString(DFA61_eotS);
    static final short[] DFA61_eof = DFA.unpackEncodedString(DFA61_eofS);
    static final char[] DFA61_min = DFA.unpackEncodedStringToUnsignedChars(DFA61_minS);
    static final char[] DFA61_max = DFA.unpackEncodedStringToUnsignedChars(DFA61_maxS);
    static final short[] DFA61_accept = DFA.unpackEncodedString(DFA61_acceptS);
    static final short[] DFA61_special = DFA.unpackEncodedString(DFA61_specialS);
    static final short[][] DFA61_transition;

    static {
        int numStates = DFA61_transitionS.length;
        DFA61_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA61_transition[i] = DFA.unpackEncodedString(DFA61_transitionS[i]);
        }
    }

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = DFA61_eot;
            this.eof = DFA61_eof;
            this.min = DFA61_min;
            this.max = DFA61_max;
            this.accept = DFA61_accept;
            this.special = DFA61_special;
            this.transition = DFA61_transition;
        }
        public String getDescription() {
            return "3655:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA61_1 = input.LA(1);

                         
                        int index61_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 61, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA60_eotS =
        "\36\uffff";
    static final String DFA60_eofS =
        "\36\uffff";
    static final String DFA60_minS =
        "\1\4\2\0\33\uffff";
    static final String DFA60_maxS =
        "\1\113\2\0\33\uffff";
    static final String DFA60_acceptS =
        "\3\uffff\2\1\1\2\27\uffff\1\3";
    static final String DFA60_specialS =
        "\1\0\1\1\1\2\33\uffff}>";
    static final String[] DFA60_transitionS = {
            "\4\5\1\1\5\uffff\1\5\21\uffff\1\5\2\uffff\2\5\4\uffff\1\5\5"+
            "\uffff\1\2\1\35\1\5\1\4\2\uffff\1\5\1\uffff\1\5\2\uffff\3\5"+
            "\2\uffff\1\5\1\uffff\10\5\2\uffff\1\3",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA60_eot = DFA.unpackEncodedString(DFA60_eotS);
    static final short[] DFA60_eof = DFA.unpackEncodedString(DFA60_eofS);
    static final char[] DFA60_min = DFA.unpackEncodedStringToUnsignedChars(DFA60_minS);
    static final char[] DFA60_max = DFA.unpackEncodedStringToUnsignedChars(DFA60_maxS);
    static final short[] DFA60_accept = DFA.unpackEncodedString(DFA60_acceptS);
    static final short[] DFA60_special = DFA.unpackEncodedString(DFA60_specialS);
    static final short[][] DFA60_transition;

    static {
        int numStates = DFA60_transitionS.length;
        DFA60_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA60_transition[i] = DFA.unpackEncodedString(DFA60_transitionS[i]);
        }
    }

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = DFA60_eot;
            this.eof = DFA60_eof;
            this.min = DFA60_min;
            this.max = DFA60_max;
            this.accept = DFA60_accept;
            this.special = DFA60_special;
            this.transition = DFA60_transition;
        }
        public String getDescription() {
            return "3676:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA60_0 = input.LA(1);

                         
                        int index60_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA60_0==RULE_ID) ) {s = 1;}

                        else if ( (LA60_0==47) ) {s = 2;}

                        else if ( (LA60_0==75) && (synpred23_InternalTutorial())) {s = 3;}

                        else if ( (LA60_0==50) && (synpred23_InternalTutorial())) {s = 4;}

                        else if ( ((LA60_0>=RULE_STRING && LA60_0<=RULE_DECIMAL)||LA60_0==14||LA60_0==32||(LA60_0>=35 && LA60_0<=36)||LA60_0==41||LA60_0==49||LA60_0==53||LA60_0==55||(LA60_0>=58 && LA60_0<=60)||LA60_0==63||(LA60_0>=65 && LA60_0<=72)) ) {s = 5;}

                        else if ( (LA60_0==48) ) {s = 29;}

                         
                        input.seek(index60_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA60_1 = input.LA(1);

                         
                        int index60_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index60_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA60_2 = input.LA(1);

                         
                        int index60_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index60_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 60, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA62_eotS =
        "\76\uffff";
    static final String DFA62_eofS =
        "\1\2\75\uffff";
    static final String DFA62_minS =
        "\1\4\1\0\74\uffff";
    static final String DFA62_maxS =
        "\1\113\1\0\74\uffff";
    static final String DFA62_acceptS =
        "\2\uffff\1\2\72\uffff\1\1";
    static final String DFA62_specialS =
        "\1\uffff\1\0\74\uffff}>";
    static final String[] DFA62_transitionS = {
            "\5\2\5\uffff\2\2\5\uffff\1\2\1\uffff\32\2\1\1\1\uffff\15\2\1"+
            "\uffff\13\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA62_eot = DFA.unpackEncodedString(DFA62_eotS);
    static final short[] DFA62_eof = DFA.unpackEncodedString(DFA62_eofS);
    static final char[] DFA62_min = DFA.unpackEncodedStringToUnsignedChars(DFA62_minS);
    static final char[] DFA62_max = DFA.unpackEncodedStringToUnsignedChars(DFA62_maxS);
    static final short[] DFA62_accept = DFA.unpackEncodedString(DFA62_acceptS);
    static final short[] DFA62_special = DFA.unpackEncodedString(DFA62_specialS);
    static final short[][] DFA62_transition;

    static {
        int numStates = DFA62_transitionS.length;
        DFA62_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA62_transition[i] = DFA.unpackEncodedString(DFA62_transitionS[i]);
        }
    }

    class DFA62 extends DFA {

        public DFA62(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 62;
            this.eot = DFA62_eot;
            this.eof = DFA62_eof;
            this.min = DFA62_min;
            this.max = DFA62_max;
            this.accept = DFA62_accept;
            this.special = DFA62_special;
            this.transition = DFA62_transition;
        }
        public String getDescription() {
            return "3755:3: ( ( ( ruleXClosure ) )=> (lv_featureCallArguments_14_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA62_1 = input.LA(1);

                         
                        int index62_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index62_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 62, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA66_eotS =
        "\76\uffff";
    static final String DFA66_eofS =
        "\1\2\75\uffff";
    static final String DFA66_minS =
        "\1\4\1\0\74\uffff";
    static final String DFA66_maxS =
        "\1\113\1\0\74\uffff";
    static final String DFA66_acceptS =
        "\2\uffff\1\2\72\uffff\1\1";
    static final String DFA66_specialS =
        "\1\uffff\1\0\74\uffff}>";
    static final String[] DFA66_transitionS = {
            "\5\2\5\uffff\2\2\5\uffff\1\2\1\uffff\11\2\1\1\21\2\1\uffff\15"+
            "\2\1\uffff\13\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA66_eot = DFA.unpackEncodedString(DFA66_eotS);
    static final short[] DFA66_eof = DFA.unpackEncodedString(DFA66_eofS);
    static final char[] DFA66_min = DFA.unpackEncodedStringToUnsignedChars(DFA66_minS);
    static final char[] DFA66_max = DFA.unpackEncodedStringToUnsignedChars(DFA66_maxS);
    static final short[] DFA66_accept = DFA.unpackEncodedString(DFA66_acceptS);
    static final short[] DFA66_special = DFA.unpackEncodedString(DFA66_specialS);
    static final short[][] DFA66_transition;

    static {
        int numStates = DFA66_transitionS.length;
        DFA66_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA66_transition[i] = DFA.unpackEncodedString(DFA66_transitionS[i]);
        }
    }

    class DFA66 extends DFA {

        public DFA66(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 66;
            this.eot = DFA66_eot;
            this.eof = DFA66_eof;
            this.min = DFA66_min;
            this.max = DFA66_max;
            this.accept = DFA66_accept;
            this.special = DFA66_special;
            this.transition = DFA66_transition;
        }
        public String getDescription() {
            return "3900:2: ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA66_1 = input.LA(1);

                         
                        int index66_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index66_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 66, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA69_eotS =
        "\76\uffff";
    static final String DFA69_eofS =
        "\1\2\75\uffff";
    static final String DFA69_minS =
        "\1\4\1\0\74\uffff";
    static final String DFA69_maxS =
        "\1\113\1\0\74\uffff";
    static final String DFA69_acceptS =
        "\2\uffff\1\2\72\uffff\1\1";
    static final String DFA69_specialS =
        "\1\uffff\1\0\74\uffff}>";
    static final String[] DFA69_transitionS = {
            "\5\2\5\uffff\2\2\5\uffff\1\2\1\uffff\30\2\1\1\2\2\1\uffff\15"+
            "\2\1\uffff\13\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA69_eot = DFA.unpackEncodedString(DFA69_eotS);
    static final short[] DFA69_eof = DFA.unpackEncodedString(DFA69_eofS);
    static final char[] DFA69_min = DFA.unpackEncodedStringToUnsignedChars(DFA69_minS);
    static final char[] DFA69_max = DFA.unpackEncodedStringToUnsignedChars(DFA69_maxS);
    static final short[] DFA69_accept = DFA.unpackEncodedString(DFA69_acceptS);
    static final short[] DFA69_special = DFA.unpackEncodedString(DFA69_specialS);
    static final short[][] DFA69_transition;

    static {
        int numStates = DFA69_transitionS.length;
        DFA69_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA69_transition[i] = DFA.unpackEncodedString(DFA69_transitionS[i]);
        }
    }

    class DFA69 extends DFA {

        public DFA69(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 69;
            this.eot = DFA69_eot;
            this.eof = DFA69_eof;
            this.min = DFA69_min;
            this.max = DFA69_max;
            this.accept = DFA69_accept;
            this.special = DFA69_special;
            this.transition = DFA69_transition;
        }
        public String getDescription() {
            return "3949:3: ( ( ( '(' )=>otherlv_8= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA69_1 = input.LA(1);

                         
                        int index69_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index69_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 69, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA68_eotS =
        "\36\uffff";
    static final String DFA68_eofS =
        "\36\uffff";
    static final String DFA68_minS =
        "\1\4\2\0\33\uffff";
    static final String DFA68_maxS =
        "\1\113\2\0\33\uffff";
    static final String DFA68_acceptS =
        "\3\uffff\2\1\1\2\27\uffff\1\3";
    static final String DFA68_specialS =
        "\1\0\1\1\1\2\33\uffff}>";
    static final String[] DFA68_transitionS = {
            "\4\5\1\1\5\uffff\1\5\21\uffff\1\5\2\uffff\2\5\4\uffff\1\5\5"+
            "\uffff\1\2\1\35\1\5\1\4\2\uffff\1\5\1\uffff\1\5\2\uffff\3\5"+
            "\2\uffff\1\5\1\uffff\10\5\2\uffff\1\3",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA68_eot = DFA.unpackEncodedString(DFA68_eotS);
    static final short[] DFA68_eof = DFA.unpackEncodedString(DFA68_eofS);
    static final char[] DFA68_min = DFA.unpackEncodedStringToUnsignedChars(DFA68_minS);
    static final char[] DFA68_max = DFA.unpackEncodedStringToUnsignedChars(DFA68_maxS);
    static final short[] DFA68_accept = DFA.unpackEncodedString(DFA68_acceptS);
    static final short[] DFA68_special = DFA.unpackEncodedString(DFA68_specialS);
    static final short[][] DFA68_transition;

    static {
        int numStates = DFA68_transitionS.length;
        DFA68_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA68_transition[i] = DFA.unpackEncodedString(DFA68_transitionS[i]);
        }
    }

    class DFA68 extends DFA {

        public DFA68(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 68;
            this.eot = DFA68_eot;
            this.eof = DFA68_eof;
            this.min = DFA68_min;
            this.max = DFA68_max;
            this.accept = DFA68_accept;
            this.special = DFA68_special;
            this.transition = DFA68_transition;
        }
        public String getDescription() {
            return "3954:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA68_0 = input.LA(1);

                         
                        int index68_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA68_0==RULE_ID) ) {s = 1;}

                        else if ( (LA68_0==47) ) {s = 2;}

                        else if ( (LA68_0==75) && (synpred27_InternalTutorial())) {s = 3;}

                        else if ( (LA68_0==50) && (synpred27_InternalTutorial())) {s = 4;}

                        else if ( ((LA68_0>=RULE_STRING && LA68_0<=RULE_DECIMAL)||LA68_0==14||LA68_0==32||(LA68_0>=35 && LA68_0<=36)||LA68_0==41||LA68_0==49||LA68_0==53||LA68_0==55||(LA68_0>=58 && LA68_0<=60)||LA68_0==63||(LA68_0>=65 && LA68_0<=72)) ) {s = 5;}

                        else if ( (LA68_0==48) ) {s = 29;}

                         
                        input.seek(index68_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA68_1 = input.LA(1);

                         
                        int index68_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index68_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA68_2 = input.LA(1);

                         
                        int index68_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalTutorial()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index68_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 68, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA70_eotS =
        "\76\uffff";
    static final String DFA70_eofS =
        "\1\2\75\uffff";
    static final String DFA70_minS =
        "\1\4\1\0\74\uffff";
    static final String DFA70_maxS =
        "\1\113\1\0\74\uffff";
    static final String DFA70_acceptS =
        "\2\uffff\1\2\72\uffff\1\1";
    static final String DFA70_specialS =
        "\1\uffff\1\0\74\uffff}>";
    static final String[] DFA70_transitionS = {
            "\5\2\5\uffff\2\2\5\uffff\1\2\1\uffff\32\2\1\1\1\uffff\15\2\1"+
            "\uffff\13\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA70_eot = DFA.unpackEncodedString(DFA70_eotS);
    static final short[] DFA70_eof = DFA.unpackEncodedString(DFA70_eofS);
    static final char[] DFA70_min = DFA.unpackEncodedStringToUnsignedChars(DFA70_minS);
    static final char[] DFA70_max = DFA.unpackEncodedStringToUnsignedChars(DFA70_maxS);
    static final short[] DFA70_accept = DFA.unpackEncodedString(DFA70_acceptS);
    static final short[] DFA70_special = DFA.unpackEncodedString(DFA70_specialS);
    static final short[][] DFA70_transition;

    static {
        int numStates = DFA70_transitionS.length;
        DFA70_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA70_transition[i] = DFA.unpackEncodedString(DFA70_transitionS[i]);
        }
    }

    class DFA70 extends DFA {

        public DFA70(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 70;
            this.eot = DFA70_eot;
            this.eof = DFA70_eof;
            this.min = DFA70_min;
            this.max = DFA70_max;
            this.accept = DFA70_accept;
            this.special = DFA70_special;
            this.transition = DFA70_transition;
        }
        public String getDescription() {
            return "4033:3: ( ( ( ruleXClosure ) )=> (lv_arguments_14_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA70_1 = input.LA(1);

                         
                        int index70_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index70_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 70, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA72_eotS =
        "\76\uffff";
    static final String DFA72_eofS =
        "\1\33\75\uffff";
    static final String DFA72_minS =
        "\1\4\32\0\43\uffff";
    static final String DFA72_maxS =
        "\1\113\32\0\43\uffff";
    static final String DFA72_acceptS =
        "\33\uffff\1\2\41\uffff\1\1";
    static final String DFA72_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31"+
        "\43\uffff}>";
    static final String[] DFA72_transitionS = {
            "\1\21\1\15\1\16\1\17\1\1\5\uffff\1\6\1\33\5\uffff\1\33\1\uffff"+
            "\11\33\1\10\2\33\1\4\1\3\4\33\1\2\5\33\1\32\1\33\1\12\1\uffff"+
            "\2\33\1\23\1\33\1\7\2\33\1\24\1\25\1\26\2\33\1\11\1\uffff\1"+
            "\5\1\13\1\14\1\20\1\22\1\27\1\30\1\31\3\33",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA72_eot = DFA.unpackEncodedString(DFA72_eotS);
    static final short[] DFA72_eof = DFA.unpackEncodedString(DFA72_eofS);
    static final char[] DFA72_min = DFA.unpackEncodedStringToUnsignedChars(DFA72_minS);
    static final char[] DFA72_max = DFA.unpackEncodedStringToUnsignedChars(DFA72_maxS);
    static final short[] DFA72_accept = DFA.unpackEncodedString(DFA72_acceptS);
    static final short[] DFA72_special = DFA.unpackEncodedString(DFA72_specialS);
    static final short[][] DFA72_transition;

    static {
        int numStates = DFA72_transitionS.length;
        DFA72_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA72_transition[i] = DFA.unpackEncodedString(DFA72_transitionS[i]);
        }
    }

    class DFA72 extends DFA {

        public DFA72(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 72;
            this.eot = DFA72_eot;
            this.eof = DFA72_eof;
            this.min = DFA72_min;
            this.max = DFA72_max;
            this.accept = DFA72_accept;
            this.special = DFA72_special;
            this.transition = DFA72_transition;
        }
        public String getDescription() {
            return "4357:1: ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA72_1 = input.LA(1);

                         
                        int index72_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA72_2 = input.LA(1);

                         
                        int index72_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA72_3 = input.LA(1);

                         
                        int index72_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA72_4 = input.LA(1);

                         
                        int index72_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA72_5 = input.LA(1);

                         
                        int index72_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA72_6 = input.LA(1);

                         
                        int index72_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA72_7 = input.LA(1);

                         
                        int index72_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA72_8 = input.LA(1);

                         
                        int index72_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA72_9 = input.LA(1);

                         
                        int index72_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA72_10 = input.LA(1);

                         
                        int index72_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA72_11 = input.LA(1);

                         
                        int index72_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA72_12 = input.LA(1);

                         
                        int index72_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA72_13 = input.LA(1);

                         
                        int index72_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA72_14 = input.LA(1);

                         
                        int index72_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA72_15 = input.LA(1);

                         
                        int index72_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA72_16 = input.LA(1);

                         
                        int index72_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA72_17 = input.LA(1);

                         
                        int index72_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA72_18 = input.LA(1);

                         
                        int index72_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA72_19 = input.LA(1);

                         
                        int index72_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA72_20 = input.LA(1);

                         
                        int index72_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA72_21 = input.LA(1);

                         
                        int index72_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA72_22 = input.LA(1);

                         
                        int index72_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA72_23 = input.LA(1);

                         
                        int index72_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA72_24 = input.LA(1);

                         
                        int index72_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA72_25 = input.LA(1);

                         
                        int index72_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA72_26 = input.LA(1);

                         
                        int index72_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index72_26);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 72, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA87_eotS =
        "\76\uffff";
    static final String DFA87_eofS =
        "\1\2\75\uffff";
    static final String DFA87_minS =
        "\1\4\1\0\74\uffff";
    static final String DFA87_maxS =
        "\1\113\1\0\74\uffff";
    static final String DFA87_acceptS =
        "\2\uffff\1\2\72\uffff\1\1";
    static final String DFA87_specialS =
        "\1\uffff\1\0\74\uffff}>";
    static final String[] DFA87_transitionS = {
            "\5\2\5\uffff\2\2\5\uffff\1\2\1\uffff\11\2\1\1\21\2\1\uffff\15"+
            "\2\1\uffff\13\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA87_eot = DFA.unpackEncodedString(DFA87_eotS);
    static final short[] DFA87_eof = DFA.unpackEncodedString(DFA87_eofS);
    static final char[] DFA87_min = DFA.unpackEncodedStringToUnsignedChars(DFA87_minS);
    static final char[] DFA87_max = DFA.unpackEncodedStringToUnsignedChars(DFA87_maxS);
    static final short[] DFA87_accept = DFA.unpackEncodedString(DFA87_acceptS);
    static final short[] DFA87_special = DFA.unpackEncodedString(DFA87_specialS);
    static final short[][] DFA87_transition;

    static {
        int numStates = DFA87_transitionS.length;
        DFA87_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA87_transition[i] = DFA.unpackEncodedString(DFA87_transitionS[i]);
        }
    }

    class DFA87 extends DFA {

        public DFA87(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 87;
            this.eot = DFA87_eot;
            this.eof = DFA87_eof;
            this.min = DFA87_min;
            this.max = DFA87_max;
            this.accept = DFA87_accept;
            this.special = DFA87_special;
            this.transition = DFA87_transition;
        }
        public String getDescription() {
            return "4873:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA87_1 = input.LA(1);

                         
                        int index87_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalTutorial()) ) {s = 61;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index87_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 87, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleDomainModelTutorial_in_entryRuleDomainModelTutorial75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDomainModelTutorial85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractElement_in_ruleDomainModelTutorial130 = new BitSet(new long[]{0x00000000000D2002L});
    public static final BitSet FOLLOW_rulePackageDeclaration_in_entryRulePackageDeclaration166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageDeclaration176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rulePackageDeclaration213 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rulePackageDeclaration234 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_rulePackageDeclaration246 = new BitSet(new long[]{0x00000000000DA000L});
    public static final BitSet FOLLOW_ruleAbstractElement_in_rulePackageDeclaration267 = new BitSet(new long[]{0x00000000000DA000L});
    public static final BitSet FOLLOW_15_in_rulePackageDeclaration280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractElement_in_entryRuleAbstractElement316 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractElement326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDeclaration_in_ruleAbstractElement373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleAbstractElement400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleAbstractElement427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport462 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleImport509 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_ruleImport530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard625 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleQualifiedNameWithWildcard644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType686 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_ruleType743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_ruleType770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_entryRuleDataType805 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataType815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleDataType852 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleDataType873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity909 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleEntity956 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleEntity977 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_20_in_ruleEntity990 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleEntity1013 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleEntity1027 = new BitSet(new long[]{0x0000000000008100L});
    public static final BitSet FOLLOW_ruleProperty_in_ruleEntity1048 = new BitSet(new long[]{0x0000000000008100L});
    public static final BitSet FOLLOW_15_in_ruleEntity1061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty1097 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProperty1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleProperty1153 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleProperty1165 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleProperty1188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_entryRuleXExpression1224 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpression1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXExpression1280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_entryRuleXAssignment1314 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAssignment1324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXAssignment1382 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXAssignment1398 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment1418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment1448 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_ruleXAssignment1501 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment1524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign1564 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpSingleAssign1575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleOpSingleAssign1612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign1652 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMultiAssign1663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOpMultiAssign1700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression1739 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOrExpression1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression1796 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression1849 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression1872 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr1911 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr1922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleOpOr1959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression1998 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression2008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression2055 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression2108 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression2131 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd2170 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd2181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOpAnd2218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression2257 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression2267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2314 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression2367 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2390 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality2429 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality2440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleOpEquality2478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleOpEquality2497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression2537 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRelationalExpression2547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2594 = new BitSet(new long[]{0x00000001F0000002L});
    public static final BitSet FOLLOW_28_in_ruleXRelationalExpression2630 = new BitSet(new long[]{0x0000800000000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXRelationalExpression2653 = new BitSet(new long[]{0x00000001F0000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2714 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2737 = new BitSet(new long[]{0x00000001F0000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare2777 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare2788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOpCompare2826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpCompare2845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOpCompare2864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOpCompare2883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression2923 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOtherOperatorExpression2933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2980 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression3033 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression3056 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther3095 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther3106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOpOther3144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOpOther3163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression3203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression3213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3260 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression3313 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3336 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd3375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd3386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleOpAdd3424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleOpAdd3443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression3483 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression3493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3540 = new BitSet(new long[]{0x000001E000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression3593 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3616 = new BitSet(new long[]{0x000001E000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti3655 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti3666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleOpMulti3704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpMulti3723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOpMulti3742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleOpMulti3761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3801 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation3811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation3869 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary3955 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary3966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleOpUnary4004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleOpUnary4023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleOpUnary4042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression4082 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCastedExpression4092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression4139 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_ruleXCastedExpression4174 = new BitSet(new long[]{0x0000800000000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression4197 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall4235 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMemberFeatureCall4245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall4292 = new BitSet(new long[]{0x0000380000000002L});
    public static final BitSet FOLLOW_43_in_ruleXMemberFeatureCall4341 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4364 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall4380 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall4402 = new BitSet(new long[]{0x0000380000000002L});
    public static final BitSet FOLLOW_43_in_ruleXMemberFeatureCall4488 = new BitSet(new long[]{0x0000000100000100L});
    public static final BitSet FOLLOW_44_in_ruleXMemberFeatureCall4512 = new BitSet(new long[]{0x0000000100000100L});
    public static final BitSet FOLLOW_45_in_ruleXMemberFeatureCall4549 = new BitSet(new long[]{0x0000000100000100L});
    public static final BitSet FOLLOW_32_in_ruleXMemberFeatureCall4578 = new BitSet(new long[]{0x0000800000000100L,0x0000000000001800L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4599 = new BitSet(new long[]{0x0000400080000000L});
    public static final BitSet FOLLOW_46_in_ruleXMemberFeatureCall4612 = new BitSet(new long[]{0x0000800000000100L,0x0000000000001800L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4633 = new BitSet(new long[]{0x0000400080000000L});
    public static final BitSet FOLLOW_31_in_ruleXMemberFeatureCall4647 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4672 = new BitSet(new long[]{0x0002B80000000002L});
    public static final BitSet FOLLOW_47_in_ruleXMemberFeatureCall4706 = new BitSet(new long[]{0x9CA78219000041F0L,0x00000000000009FEL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4791 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4819 = new BitSet(new long[]{0x0001400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXMemberFeatureCall4832 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4853 = new BitSet(new long[]{0x0001400000000000L});
    public static final BitSet FOLLOW_48_in_ruleXMemberFeatureCall4870 = new BitSet(new long[]{0x0002380000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXMemberFeatureCall4903 = new BitSet(new long[]{0x0000380000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression4943 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression4953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression5000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression5027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression5054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression5081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression5108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression5135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression5162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression5189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression5216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression5243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression5270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression5297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression5324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_entryRuleXLiteral5359 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXLiteral5369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXLiteral5416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral5443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNumberLiteral_in_ruleXLiteral5470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXLiteral5497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXLiteral5524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXLiteral5551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure5586 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure5596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleXClosure5642 = new BitSet(new long[]{0xFCAE8219000041F0L,0x00000000000009FEL});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5713 = new BitSet(new long[]{0x0004400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXClosure5726 = new BitSet(new long[]{0x0000800000000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5747 = new BitSet(new long[]{0x0004400000000000L});
    public static final BitSet FOLLOW_50_in_ruleXClosure5769 = new BitSet(new long[]{0xFCAA8219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpressionInClosure_in_ruleXClosure5806 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleXClosure5818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInClosure_in_entryRuleXExpressionInClosure5854 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInClosure5864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXExpressionInClosure5920 = new BitSet(new long[]{0xFCB28219000041F2L,0x00000000000001FEL});
    public static final BitSet FOLLOW_52_in_ruleXExpressionInClosure5933 = new BitSet(new long[]{0xFCA28219000041F2L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure5973 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXShortClosure5983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure6091 = new BitSet(new long[]{0x0004400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXShortClosure6104 = new BitSet(new long[]{0x0000800000000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure6125 = new BitSet(new long[]{0x0004400000000000L});
    public static final BitSet FOLLOW_50_in_ruleXShortClosure6147 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXShortClosure6183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression6219 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression6229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleXParenthesizedExpression6266 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression6288 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXParenthesizedExpression6299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression6335 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIfExpression6345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleXIfExpression6391 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXIfExpression6403 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6424 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXIfExpression6436 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6457 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_54_in_ruleXIfExpression6478 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression6538 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSwitchExpression6548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleXSwitchExpression6594 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXSwitchExpression6637 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXSwitchExpression6649 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6673 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_47_in_ruleXSwitchExpression6717 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXSwitchExpression6738 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXSwitchExpression6750 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6773 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXSwitchExpression6785 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleXSwitchExpression6799 = new BitSet(new long[]{0x0200800000200100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6820 = new BitSet(new long[]{0x0300800000208100L,0x0000000000000800L});
    public static final BitSet FOLLOW_56_in_ruleXSwitchExpression6834 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXSwitchExpression6846 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6867 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleXSwitchExpression6881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart6917 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart6927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6973 = new BitSet(new long[]{0x0200000000200000L});
    public static final BitSet FOLLOW_57_in_ruleXCasePart6987 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart7008 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXCasePart7022 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart7043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression7079 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXForLoopExpression7089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleXForLoopExpression7135 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXForLoopExpression7147 = new BitSet(new long[]{0x0000800000000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression7168 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXForLoopExpression7180 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression7201 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXForLoopExpression7213 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression7234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression7270 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWhileExpression7280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleXWhileExpression7326 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXWhileExpression7338 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression7359 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXWhileExpression7371 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression7392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression7428 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXDoWhileExpression7438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleXDoWhileExpression7484 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7505 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_ruleXDoWhileExpression7517 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXDoWhileExpression7529 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7550 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXDoWhileExpression7562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression7598 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBlockExpression7608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleXBlockExpression7654 = new BitSet(new long[]{0xFCA282190000C1F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression7676 = new BitSet(new long[]{0xFCB282190000C1F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_52_in_ruleXBlockExpression7689 = new BitSet(new long[]{0xFCA282190000C1F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_15_in_ruleXBlockExpression7705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock7741 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock7751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7860 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXVariableDeclaration7870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleXVariableDeclaration7923 = new BitSet(new long[]{0x0000800000000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_62_in_ruleXVariableDeclaration7954 = new BitSet(new long[]{0x0000800000000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration8002 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration8023 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration8052 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleXVariableDeclaration8066 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXVariableDeclaration8087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter8125 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameter8135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter8181 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmFormalParameter8203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_entryRuleFullJvmFormalParameter8239 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFullJvmFormalParameter8249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleFullJvmFormalParameter8295 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleFullJvmFormalParameter8316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall8352 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall8362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall8419 = new BitSet(new long[]{0x8000000100000100L});
    public static final BitSet FOLLOW_32_in_ruleXFeatureCall8433 = new BitSet(new long[]{0x0000800000000100L,0x0000000000001800L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8454 = new BitSet(new long[]{0x0000400080000000L});
    public static final BitSet FOLLOW_46_in_ruleXFeatureCall8467 = new BitSet(new long[]{0x0000800000000100L,0x0000000000001800L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8488 = new BitSet(new long[]{0x0000400080000000L});
    public static final BitSet FOLLOW_31_in_ruleXFeatureCall8502 = new BitSet(new long[]{0x8000000100000100L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall8527 = new BitSet(new long[]{0x0002800000000002L});
    public static final BitSet FOLLOW_47_in_ruleXFeatureCall8561 = new BitSet(new long[]{0x9CA78219000041F0L,0x00000000000009FEL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXFeatureCall8646 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall8674 = new BitSet(new long[]{0x0001400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXFeatureCall8687 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall8708 = new BitSet(new long[]{0x0001400000000000L});
    public static final BitSet FOLLOW_48_in_ruleXFeatureCall8725 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXFeatureCall8758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper8796 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdOrSuper8807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleIdOrSuper8854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleIdOrSuper8878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier8919 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStaticQualifier8930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleStaticQualifier8977 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleStaticQualifier8995 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall9036 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXConstructorCall9046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleXConstructorCall9092 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXConstructorCall9115 = new BitSet(new long[]{0x0002800100000002L});
    public static final BitSet FOLLOW_32_in_ruleXConstructorCall9136 = new BitSet(new long[]{0x0000800000000100L,0x0000000000001800L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall9158 = new BitSet(new long[]{0x0000400080000000L});
    public static final BitSet FOLLOW_46_in_ruleXConstructorCall9171 = new BitSet(new long[]{0x0000800000000100L,0x0000000000001800L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall9192 = new BitSet(new long[]{0x0000400080000000L});
    public static final BitSet FOLLOW_31_in_ruleXConstructorCall9206 = new BitSet(new long[]{0x0002800000000002L});
    public static final BitSet FOLLOW_47_in_ruleXConstructorCall9229 = new BitSet(new long[]{0x9CA78219000041F0L,0x00000000000009FEL});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXConstructorCall9302 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall9330 = new BitSet(new long[]{0x0001400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXConstructorCall9343 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall9364 = new BitSet(new long[]{0x0001400000000000L});
    public static final BitSet FOLLOW_48_in_ruleXConstructorCall9381 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXConstructorCall9414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral9451 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral9461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleXBooleanLiteral9508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleXBooleanLiteral9532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral9582 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral9592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleXNullLiteral9638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNumberLiteral_in_entryRuleXNumberLiteral9674 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNumberLiteral9684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_ruleXNumberLiteral9739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral9775 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXStringLiteral9785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXStringLiteral9836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral9877 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral9887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleXTypeLiteral9933 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXTypeLiteral9945 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral9968 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXTypeLiteral9980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression10016 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXThrowExpression10026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleXThrowExpression10072 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXThrowExpression10093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression10129 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXReturnExpression10139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleXReturnExpression10185 = new BitSet(new long[]{0x9CA28219000041F2L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXReturnExpression10216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression10253 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression10263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleXTryCatchFinallyExpression10309 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10330 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000600L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression10360 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000600L});
    public static final BitSet FOLLOW_73_in_ruleXTryCatchFinallyExpression10382 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleXTryCatchFinallyExpression10426 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression10447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause10485 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCatchClause10495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleXCatchClause10540 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXCatchClause10553 = new BitSet(new long[]{0x0000800000000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_ruleXCatchClause10574 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleXCatchClause10586 = new BitSet(new long[]{0x9CA28219000041F0L,0x00000000000001FEL});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCatchClause10607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10644 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName10655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName10702 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleQualifiedName10730 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName10753 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_entryRuleNumber10807 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumber10818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleNumber10862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNumber10890 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_ruleNumber10916 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleNumber10936 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNumber10952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_ruleNumber10978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference11031 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference11041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference11089 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_ruleJvmTypeReference11127 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleJvmTypeReference11139 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference11171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef11206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef11216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleXFunctionTypeRef11254 = new BitSet(new long[]{0x0001800000000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11276 = new BitSet(new long[]{0x0001400000000000L});
    public static final BitSet FOLLOW_46_in_ruleXFunctionTypeRef11289 = new BitSet(new long[]{0x0000800000000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11310 = new BitSet(new long[]{0x0001400000000000L});
    public static final BitSet FOLLOW_48_in_ruleXFunctionTypeRef11326 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_ruleXFunctionTypeRef11340 = new BitSet(new long[]{0x0000800000000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef11361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference11397 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference11407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference11455 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleJvmParameterizedTypeReference11476 = new BitSet(new long[]{0x0000800000000100L,0x0000000000001800L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11498 = new BitSet(new long[]{0x0000400080000000L});
    public static final BitSet FOLLOW_46_in_ruleJvmParameterizedTypeReference11511 = new BitSet(new long[]{0x0000800000000100L,0x0000000000001800L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11532 = new BitSet(new long[]{0x0000400080000000L});
    public static final BitSet FOLLOW_31_in_ruleJvmParameterizedTypeReference11546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference11584 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference11594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference11641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference11668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference11703 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference11713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleJvmWildcardTypeReference11759 = new BitSet(new long[]{0x8000000000100002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference11781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference11808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound11846 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound11856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleJvmUpperBound11893 = new BitSet(new long[]{0x0000800000000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound11914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded11950 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded11960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleJvmUpperBoundAnded11997 = new BitSet(new long[]{0x0000800000000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded12018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound12054 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound12064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleJvmLowerBound12101 = new BitSet(new long[]{0x0000800000000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound12122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID12161 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID12172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID12211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_synpred1_InternalTutorial1469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred2_InternalTutorial1817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred3_InternalTutorial2076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred4_InternalTutorial2335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_synpred5_InternalTutorial2611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred6_InternalTutorial2682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred7_InternalTutorial3001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred8_InternalTutorial3281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred9_InternalTutorial3561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_synpred10_InternalTutorial4155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_synpred11_InternalTutorial4309 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred11_InternalTutorial4318 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_synpred11_InternalTutorial4324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_synpred12_InternalTutorial4427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_synpred12_InternalTutorial4441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred12_InternalTutorial4461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_synpred13_InternalTutorial4688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalTutorial4740 = new BitSet(new long[]{0x0004400000000000L});
    public static final BitSet FOLLOW_46_in_synpred14_InternalTutorial4747 = new BitSet(new long[]{0x0000800000000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred14_InternalTutorial4754 = new BitSet(new long[]{0x0004400000000000L});
    public static final BitSet FOLLOW_50_in_synpred14_InternalTutorial4768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred15_InternalTutorial4886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalTutorial5659 = new BitSet(new long[]{0x0004400000000000L});
    public static final BitSet FOLLOW_46_in_synpred16_InternalTutorial5666 = new BitSet(new long[]{0x0000800000000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred16_InternalTutorial5673 = new BitSet(new long[]{0x0004400000000000L});
    public static final BitSet FOLLOW_50_in_synpred16_InternalTutorial5687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_synpred18_InternalTutorial6470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred19_InternalTutorial6612 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_synpred19_InternalTutorial6618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_synpred20_InternalTutorial6694 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred20_InternalTutorial6701 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_synpred20_InternalTutorial6707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_synpred21_InternalTutorial7972 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred21_InternalTutorial7981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_synpred22_InternalTutorial8543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred23_InternalTutorial8595 = new BitSet(new long[]{0x0004400000000000L});
    public static final BitSet FOLLOW_46_in_synpred23_InternalTutorial8602 = new BitSet(new long[]{0x0000800000000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred23_InternalTutorial8609 = new BitSet(new long[]{0x0004400000000000L});
    public static final BitSet FOLLOW_50_in_synpred23_InternalTutorial8623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred24_InternalTutorial8741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_synpred25_InternalTutorial9128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_synpred26_InternalTutorial9221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred27_InternalTutorial9251 = new BitSet(new long[]{0x0004400000000000L});
    public static final BitSet FOLLOW_46_in_synpred27_InternalTutorial9258 = new BitSet(new long[]{0x0000800000000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred27_InternalTutorial9265 = new BitSet(new long[]{0x0004400000000000L});
    public static final BitSet FOLLOW_50_in_synpred27_InternalTutorial9279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_synpred28_InternalTutorial9397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred29_InternalTutorial10199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_synpred30_InternalTutorial10344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_synpred31_InternalTutorial10374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_synpred33_InternalTutorial10721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_synpred34_InternalTutorial11104 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_synpred34_InternalTutorial11108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_synpred35_InternalTutorial11468 = new BitSet(new long[]{0x0000000000000002L});

}