package org.eclipse.xtext.xbase.annotations.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.xbase.annotations.services.XbaseWithAnnotationsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalXbaseWithAnnotationsParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'@'", "'('", "','", "')'", "'='", "'+'", "'{'", "'}'", "'+='", "'||'", "'&&'", "'=='", "'!='", "'instanceof'", "'>='", "'<='", "'>'", "'<'", "'->'", "'..'", "'-'", "'*'", "'**'", "'/'", "'%'", "'!'", "'as'", "'.'", "'?.'", "'*.'", "'['", "'|'", "']'", "'if'", "'else'", "'switch'", "':'", "'default'", "'case'", "'for'", "'while'", "'do'", "';'", "'var'", "'val'", "'super'", "'::'", "'new'", "'false'", "'true'", "'null'", "'typeof'", "'throw'", "'return'", "'try'", "'finally'", "'catch'", "':{'", "'=>'", "'?'", "'extends'", "'&'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=6;
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
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__16=16;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int RULE_INT=4;
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
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
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
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalXbaseWithAnnotationsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXbaseWithAnnotationsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalXbaseWithAnnotationsParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g"; }



     	private XbaseWithAnnotationsGrammarAccess grammarAccess;
     	
        public InternalXbaseWithAnnotationsParser(TokenStream input, XbaseWithAnnotationsGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "XAnnotation";	
       	}
       	
       	@Override
       	protected XbaseWithAnnotationsGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleXAnnotation"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:67:1: entryRuleXAnnotation returns [EObject current=null] : iv_ruleXAnnotation= ruleXAnnotation EOF ;
    public final EObject entryRuleXAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAnnotation = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:68:2: (iv_ruleXAnnotation= ruleXAnnotation EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:69:2: iv_ruleXAnnotation= ruleXAnnotation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAnnotationRule()); 
            }
            pushFollow(FOLLOW_ruleXAnnotation_in_entryRuleXAnnotation75);
            iv_ruleXAnnotation=ruleXAnnotation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAnnotation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAnnotation85); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXAnnotation"


    // $ANTLR start "ruleXAnnotation"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:76:1: ruleXAnnotation returns [EObject current=null] : ( () otherlv_1= '@' ( ( ruleQualifiedName ) ) ( ( ( '(' )=>otherlv_3= '(' ) ( ( ( (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValue ) ) )? otherlv_8= ')' )? ) ;
    public final EObject ruleXAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        EObject lv_elementValuePairs_4_0 = null;

        EObject lv_elementValuePairs_6_0 = null;

        EObject lv_value_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:79:28: ( ( () otherlv_1= '@' ( ( ruleQualifiedName ) ) ( ( ( '(' )=>otherlv_3= '(' ) ( ( ( (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValue ) ) )? otherlv_8= ')' )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:80:1: ( () otherlv_1= '@' ( ( ruleQualifiedName ) ) ( ( ( '(' )=>otherlv_3= '(' ) ( ( ( (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValue ) ) )? otherlv_8= ')' )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:80:1: ( () otherlv_1= '@' ( ( ruleQualifiedName ) ) ( ( ( '(' )=>otherlv_3= '(' ) ( ( ( (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValue ) ) )? otherlv_8= ')' )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:80:2: () otherlv_1= '@' ( ( ruleQualifiedName ) ) ( ( ( '(' )=>otherlv_3= '(' ) ( ( ( (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValue ) ) )? otherlv_8= ')' )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:80:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:81:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXAnnotationAccess().getXAnnotationAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleXAnnotation131); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXAnnotationAccess().getCommercialAtKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:90:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:91:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:91:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:92:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXAnnotationRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXAnnotationAccess().getAnnotationTypeJvmAnnotationTypeCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXAnnotation154);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:105:2: ( ( ( '(' )=>otherlv_3= '(' ) ( ( ( (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValue ) ) )? otherlv_8= ')' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) && (synpred1_InternalXbaseWithAnnotations())) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:105:3: ( ( '(' )=>otherlv_3= '(' ) ( ( ( (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValue ) ) )? otherlv_8= ')'
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:105:3: ( ( '(' )=>otherlv_3= '(' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:105:4: ( '(' )=>otherlv_3= '('
                    {
                    otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleXAnnotation175); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXAnnotationAccess().getLeftParenthesisKeyword_3_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:110:2: ( ( ( (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* ) | ( (lv_value_7_0= ruleXAnnotationElementValue ) ) )?
                    int alt2=3;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==RULE_ID) ) {
                        int LA2_1 = input.LA(2);

                        if ( (LA2_1==15) ) {
                            alt2=1;
                        }
                        else if ( (LA2_1==14||LA2_1==57) ) {
                            alt2=2;
                        }
                    }
                    else if ( ((LA2_0>=RULE_INT && LA2_0<=RULE_STRING)||(LA2_0>=11 && LA2_0<=12)||LA2_0==17||LA2_0==56||(LA2_0>=59 && LA2_0<=60)||LA2_0==62) ) {
                        alt2=2;
                    }
                    switch (alt2) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:110:3: ( ( (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:110:3: ( ( (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )* )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:110:4: ( (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) ) (otherlv_5= ',' ( (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )*
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:110:4: ( (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:111:1: (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:111:1: (lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:112:3: lv_elementValuePairs_4_0= ruleXAnnotationElementValuePair
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAnnotationAccess().getElementValuePairsXAnnotationElementValuePairParserRuleCall_3_1_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXAnnotationElementValuePair_in_ruleXAnnotation199);
                            lv_elementValuePairs_4_0=ruleXAnnotationElementValuePair();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXAnnotationRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"elementValuePairs",
                                      		lv_elementValuePairs_4_0, 
                                      		"XAnnotationElementValuePair");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:128:2: (otherlv_5= ',' ( (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) ) )*
                            loop1:
                            do {
                                int alt1=2;
                                int LA1_0 = input.LA(1);

                                if ( (LA1_0==13) ) {
                                    alt1=1;
                                }


                                switch (alt1) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:128:4: otherlv_5= ',' ( (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) )
                            	    {
                            	    otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleXAnnotation212); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_5, grammarAccess.getXAnnotationAccess().getCommaKeyword_3_1_0_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:132:1: ( (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair ) )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:133:1: (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair )
                            	    {
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:133:1: (lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:134:3: lv_elementValuePairs_6_0= ruleXAnnotationElementValuePair
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXAnnotationAccess().getElementValuePairsXAnnotationElementValuePairParserRuleCall_3_1_0_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXAnnotationElementValuePair_in_ruleXAnnotation233);
                            	    lv_elementValuePairs_6_0=ruleXAnnotationElementValuePair();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getXAnnotationRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"elementValuePairs",
                            	              		lv_elementValuePairs_6_0, 
                            	              		"XAnnotationElementValuePair");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

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
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:151:6: ( (lv_value_7_0= ruleXAnnotationElementValue ) )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:151:6: ( (lv_value_7_0= ruleXAnnotationElementValue ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:152:1: (lv_value_7_0= ruleXAnnotationElementValue )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:152:1: (lv_value_7_0= ruleXAnnotationElementValue )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:153:3: lv_value_7_0= ruleXAnnotationElementValue
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAnnotationAccess().getValueXAnnotationElementValueParserRuleCall_3_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotation263);
                            lv_value_7_0=ruleXAnnotationElementValue();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXAnnotationRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"value",
                                      		lv_value_7_0, 
                                      		"XAnnotationElementValue");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    otherlv_8=(Token)match(input,14,FOLLOW_14_in_ruleXAnnotation277); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getXAnnotationAccess().getRightParenthesisKeyword_3_2());
                          
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
    // $ANTLR end "ruleXAnnotation"


    // $ANTLR start "entryRuleXAnnotationElementValuePair"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:181:1: entryRuleXAnnotationElementValuePair returns [EObject current=null] : iv_ruleXAnnotationElementValuePair= ruleXAnnotationElementValuePair EOF ;
    public final EObject entryRuleXAnnotationElementValuePair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAnnotationElementValuePair = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:182:2: (iv_ruleXAnnotationElementValuePair= ruleXAnnotationElementValuePair EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:183:2: iv_ruleXAnnotationElementValuePair= ruleXAnnotationElementValuePair EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAnnotationElementValuePairRule()); 
            }
            pushFollow(FOLLOW_ruleXAnnotationElementValuePair_in_entryRuleXAnnotationElementValuePair315);
            iv_ruleXAnnotationElementValuePair=ruleXAnnotationElementValuePair();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAnnotationElementValuePair; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAnnotationElementValuePair325); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXAnnotationElementValuePair"


    // $ANTLR start "ruleXAnnotationElementValuePair"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:190:1: ruleXAnnotationElementValuePair returns [EObject current=null] : ( ( ( ruleValidID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleXAnnotationElementValue ) ) ) ;
    public final EObject ruleXAnnotationElementValuePair() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:193:28: ( ( ( ( ruleValidID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleXAnnotationElementValue ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:194:1: ( ( ( ruleValidID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleXAnnotationElementValue ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:194:1: ( ( ( ruleValidID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleXAnnotationElementValue ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:194:2: ( ( ruleValidID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleXAnnotationElementValue ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:194:2: ( ( ruleValidID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:195:1: ( ruleValidID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:195:1: ( ruleValidID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:196:3: ruleValidID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXAnnotationElementValuePairRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXAnnotationElementValuePairAccess().getElementJvmOperationCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleXAnnotationElementValuePair373);
            ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleXAnnotationElementValuePair385); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXAnnotationElementValuePairAccess().getEqualsSignKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:213:1: ( (lv_value_2_0= ruleXAnnotationElementValue ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:214:1: (lv_value_2_0= ruleXAnnotationElementValue )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:214:1: (lv_value_2_0= ruleXAnnotationElementValue )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:215:3: lv_value_2_0= ruleXAnnotationElementValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXAnnotationElementValuePairAccess().getValueXAnnotationElementValueParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotationElementValuePair406);
            lv_value_2_0=ruleXAnnotationElementValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXAnnotationElementValuePairRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_2_0, 
                      		"XAnnotationElementValue");
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
    // $ANTLR end "ruleXAnnotationElementValuePair"


    // $ANTLR start "entryRuleXAnnotationElementValueStringConcatenation"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:239:1: entryRuleXAnnotationElementValueStringConcatenation returns [EObject current=null] : iv_ruleXAnnotationElementValueStringConcatenation= ruleXAnnotationElementValueStringConcatenation EOF ;
    public final EObject entryRuleXAnnotationElementValueStringConcatenation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAnnotationElementValueStringConcatenation = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:240:2: (iv_ruleXAnnotationElementValueStringConcatenation= ruleXAnnotationElementValueStringConcatenation EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:241:2: iv_ruleXAnnotationElementValueStringConcatenation= ruleXAnnotationElementValueStringConcatenation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAnnotationElementValueStringConcatenationRule()); 
            }
            pushFollow(FOLLOW_ruleXAnnotationElementValueStringConcatenation_in_entryRuleXAnnotationElementValueStringConcatenation442);
            iv_ruleXAnnotationElementValueStringConcatenation=ruleXAnnotationElementValueStringConcatenation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAnnotationElementValueStringConcatenation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAnnotationElementValueStringConcatenation452); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXAnnotationElementValueStringConcatenation"


    // $ANTLR start "ruleXAnnotationElementValueStringConcatenation"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:248:1: ruleXAnnotationElementValueStringConcatenation returns [EObject current=null] : (this_XAnnotationElementValue_0= ruleXAnnotationElementValue ( () ( (lv_operator_2_0= '+' ) ) ( (lv_rightOperand_3_0= ruleXAnnotationElementValue ) ) )* ) ;
    public final EObject ruleXAnnotationElementValueStringConcatenation() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_XAnnotationElementValue_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:251:28: ( (this_XAnnotationElementValue_0= ruleXAnnotationElementValue ( () ( (lv_operator_2_0= '+' ) ) ( (lv_rightOperand_3_0= ruleXAnnotationElementValue ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:252:1: (this_XAnnotationElementValue_0= ruleXAnnotationElementValue ( () ( (lv_operator_2_0= '+' ) ) ( (lv_rightOperand_3_0= ruleXAnnotationElementValue ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:252:1: (this_XAnnotationElementValue_0= ruleXAnnotationElementValue ( () ( (lv_operator_2_0= '+' ) ) ( (lv_rightOperand_3_0= ruleXAnnotationElementValue ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:253:5: this_XAnnotationElementValue_0= ruleXAnnotationElementValue ( () ( (lv_operator_2_0= '+' ) ) ( (lv_rightOperand_3_0= ruleXAnnotationElementValue ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAnnotationElementValueStringConcatenationAccess().getXAnnotationElementValueParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotationElementValueStringConcatenation499);
            this_XAnnotationElementValue_0=ruleXAnnotationElementValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAnnotationElementValue_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:261:1: ( () ( (lv_operator_2_0= '+' ) ) ( (lv_rightOperand_3_0= ruleXAnnotationElementValue ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:261:2: () ( (lv_operator_2_0= '+' ) ) ( (lv_rightOperand_3_0= ruleXAnnotationElementValue ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:261:2: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:262:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAnnotationElementValueStringConcatenationAccess().getXAnnotationElementValueBinaryOperationLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:267:2: ( (lv_operator_2_0= '+' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:268:1: (lv_operator_2_0= '+' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:268:1: (lv_operator_2_0= '+' )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:269:3: lv_operator_2_0= '+'
            	    {
            	    lv_operator_2_0=(Token)match(input,16,FOLLOW_16_in_ruleXAnnotationElementValueStringConcatenation526); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_operator_2_0, grammarAccess.getXAnnotationElementValueStringConcatenationAccess().getOperatorPlusSignKeyword_1_1_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAnnotationElementValueStringConcatenationRule());
            	      	        }
            	             		setWithLastConsumed(current, "operator", lv_operator_2_0, "+");
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:282:2: ( (lv_rightOperand_3_0= ruleXAnnotationElementValue ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:283:1: (lv_rightOperand_3_0= ruleXAnnotationElementValue )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:283:1: (lv_rightOperand_3_0= ruleXAnnotationElementValue )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:284:3: lv_rightOperand_3_0= ruleXAnnotationElementValue
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAnnotationElementValueStringConcatenationAccess().getRightOperandXAnnotationElementValueParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotationElementValueStringConcatenation560);
            	    lv_rightOperand_3_0=ruleXAnnotationElementValue();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXAnnotationElementValueStringConcatenationRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"XAnnotationElementValue");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

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
    // $ANTLR end "ruleXAnnotationElementValueStringConcatenation"


    // $ANTLR start "entryRuleXAnnotationElementValue"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:308:1: entryRuleXAnnotationElementValue returns [EObject current=null] : iv_ruleXAnnotationElementValue= ruleXAnnotationElementValue EOF ;
    public final EObject entryRuleXAnnotationElementValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAnnotationElementValue = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:309:2: (iv_ruleXAnnotationElementValue= ruleXAnnotationElementValue EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:310:2: iv_ruleXAnnotationElementValue= ruleXAnnotationElementValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAnnotationElementValueRule()); 
            }
            pushFollow(FOLLOW_ruleXAnnotationElementValue_in_entryRuleXAnnotationElementValue598);
            iv_ruleXAnnotationElementValue=ruleXAnnotationElementValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAnnotationElementValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAnnotationElementValue608); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXAnnotationElementValue"


    // $ANTLR start "ruleXAnnotationElementValue"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:317:1: ruleXAnnotationElementValue returns [EObject current=null] : (this_XAnnotation_0= ruleXAnnotation | this_XAnnotationValueArray_1= ruleXAnnotationValueArray | this_XStringLiteral_2= ruleXStringLiteral | this_XBooleanLiteral_3= ruleXBooleanLiteral | this_XIntLiteral_4= ruleXIntLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XAnnotationValueFieldReference_6= ruleXAnnotationValueFieldReference | (otherlv_7= '(' this_XAnnotationElementValueStringConcatenation_8= ruleXAnnotationElementValueStringConcatenation otherlv_9= ')' ) ) ;
    public final EObject ruleXAnnotationElementValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject this_XAnnotation_0 = null;

        EObject this_XAnnotationValueArray_1 = null;

        EObject this_XStringLiteral_2 = null;

        EObject this_XBooleanLiteral_3 = null;

        EObject this_XIntLiteral_4 = null;

        EObject this_XTypeLiteral_5 = null;

        EObject this_XAnnotationValueFieldReference_6 = null;

        EObject this_XAnnotationElementValueStringConcatenation_8 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:320:28: ( (this_XAnnotation_0= ruleXAnnotation | this_XAnnotationValueArray_1= ruleXAnnotationValueArray | this_XStringLiteral_2= ruleXStringLiteral | this_XBooleanLiteral_3= ruleXBooleanLiteral | this_XIntLiteral_4= ruleXIntLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XAnnotationValueFieldReference_6= ruleXAnnotationValueFieldReference | (otherlv_7= '(' this_XAnnotationElementValueStringConcatenation_8= ruleXAnnotationElementValueStringConcatenation otherlv_9= ')' ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:321:1: (this_XAnnotation_0= ruleXAnnotation | this_XAnnotationValueArray_1= ruleXAnnotationValueArray | this_XStringLiteral_2= ruleXStringLiteral | this_XBooleanLiteral_3= ruleXBooleanLiteral | this_XIntLiteral_4= ruleXIntLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XAnnotationValueFieldReference_6= ruleXAnnotationValueFieldReference | (otherlv_7= '(' this_XAnnotationElementValueStringConcatenation_8= ruleXAnnotationElementValueStringConcatenation otherlv_9= ')' ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:321:1: (this_XAnnotation_0= ruleXAnnotation | this_XAnnotationValueArray_1= ruleXAnnotationValueArray | this_XStringLiteral_2= ruleXStringLiteral | this_XBooleanLiteral_3= ruleXBooleanLiteral | this_XIntLiteral_4= ruleXIntLiteral | this_XTypeLiteral_5= ruleXTypeLiteral | this_XAnnotationValueFieldReference_6= ruleXAnnotationValueFieldReference | (otherlv_7= '(' this_XAnnotationElementValueStringConcatenation_8= ruleXAnnotationElementValueStringConcatenation otherlv_9= ')' ) )
            int alt5=8;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt5=1;
                }
                break;
            case 17:
                {
                alt5=2;
                }
                break;
            case RULE_STRING:
                {
                alt5=3;
                }
                break;
            case 59:
            case 60:
                {
                alt5=4;
                }
                break;
            case RULE_INT:
                {
                alt5=5;
                }
                break;
            case 62:
                {
                alt5=6;
                }
                break;
            case RULE_ID:
            case 56:
                {
                alt5=7;
                }
                break;
            case 12:
                {
                alt5=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:322:5: this_XAnnotation_0= ruleXAnnotation
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAnnotationElementValueAccess().getXAnnotationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXAnnotation_in_ruleXAnnotationElementValue655);
                    this_XAnnotation_0=ruleXAnnotation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XAnnotation_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:332:5: this_XAnnotationValueArray_1= ruleXAnnotationValueArray
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAnnotationElementValueAccess().getXAnnotationValueArrayParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXAnnotationValueArray_in_ruleXAnnotationElementValue682);
                    this_XAnnotationValueArray_1=ruleXAnnotationValueArray();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XAnnotationValueArray_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:342:5: this_XStringLiteral_2= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAnnotationElementValueAccess().getXStringLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXStringLiteral_in_ruleXAnnotationElementValue709);
                    this_XStringLiteral_2=ruleXStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XStringLiteral_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:352:5: this_XBooleanLiteral_3= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAnnotationElementValueAccess().getXBooleanLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBooleanLiteral_in_ruleXAnnotationElementValue736);
                    this_XBooleanLiteral_3=ruleXBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XBooleanLiteral_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:362:5: this_XIntLiteral_4= ruleXIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAnnotationElementValueAccess().getXIntLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIntLiteral_in_ruleXAnnotationElementValue763);
                    this_XIntLiteral_4=ruleXIntLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XIntLiteral_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:372:5: this_XTypeLiteral_5= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAnnotationElementValueAccess().getXTypeLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTypeLiteral_in_ruleXAnnotationElementValue790);
                    this_XTypeLiteral_5=ruleXTypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XTypeLiteral_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:382:5: this_XAnnotationValueFieldReference_6= ruleXAnnotationValueFieldReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAnnotationElementValueAccess().getXAnnotationValueFieldReferenceParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXAnnotationValueFieldReference_in_ruleXAnnotationElementValue817);
                    this_XAnnotationValueFieldReference_6=ruleXAnnotationValueFieldReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XAnnotationValueFieldReference_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:391:6: (otherlv_7= '(' this_XAnnotationElementValueStringConcatenation_8= ruleXAnnotationElementValueStringConcatenation otherlv_9= ')' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:391:6: (otherlv_7= '(' this_XAnnotationElementValueStringConcatenation_8= ruleXAnnotationElementValueStringConcatenation otherlv_9= ')' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:391:8: otherlv_7= '(' this_XAnnotationElementValueStringConcatenation_8= ruleXAnnotationElementValueStringConcatenation otherlv_9= ')'
                    {
                    otherlv_7=(Token)match(input,12,FOLLOW_12_in_ruleXAnnotationElementValue835); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXAnnotationElementValueAccess().getLeftParenthesisKeyword_7_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAnnotationElementValueAccess().getXAnnotationElementValueStringConcatenationParserRuleCall_7_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXAnnotationElementValueStringConcatenation_in_ruleXAnnotationElementValue857);
                    this_XAnnotationElementValueStringConcatenation_8=ruleXAnnotationElementValueStringConcatenation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XAnnotationElementValueStringConcatenation_8; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_9=(Token)match(input,14,FOLLOW_14_in_ruleXAnnotationElementValue868); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getXAnnotationElementValueAccess().getRightParenthesisKeyword_7_2());
                          
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
    // $ANTLR end "ruleXAnnotationElementValue"


    // $ANTLR start "entryRuleXAnnotationValueFieldReference"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:416:1: entryRuleXAnnotationValueFieldReference returns [EObject current=null] : iv_ruleXAnnotationValueFieldReference= ruleXAnnotationValueFieldReference EOF ;
    public final EObject entryRuleXAnnotationValueFieldReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAnnotationValueFieldReference = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:417:2: (iv_ruleXAnnotationValueFieldReference= ruleXAnnotationValueFieldReference EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:418:2: iv_ruleXAnnotationValueFieldReference= ruleXAnnotationValueFieldReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAnnotationValueFieldReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleXAnnotationValueFieldReference_in_entryRuleXAnnotationValueFieldReference905);
            iv_ruleXAnnotationValueFieldReference=ruleXAnnotationValueFieldReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAnnotationValueFieldReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAnnotationValueFieldReference915); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXAnnotationValueFieldReference"


    // $ANTLR start "ruleXAnnotationValueFieldReference"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:425:1: ruleXAnnotationValueFieldReference returns [EObject current=null] : ( () ( ( ruleStaticQualifier ) )? ( ( ruleIdOrSuper ) ) ) ;
    public final EObject ruleXAnnotationValueFieldReference() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:428:28: ( ( () ( ( ruleStaticQualifier ) )? ( ( ruleIdOrSuper ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:429:1: ( () ( ( ruleStaticQualifier ) )? ( ( ruleIdOrSuper ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:429:1: ( () ( ( ruleStaticQualifier ) )? ( ( ruleIdOrSuper ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:429:2: () ( ( ruleStaticQualifier ) )? ( ( ruleIdOrSuper ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:429:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:430:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXAnnotationValueFieldReferenceAccess().getXFeatureCallAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:435:2: ( ( ruleStaticQualifier ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==57) ) {
                    alt6=1;
                }
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:436:1: ( ruleStaticQualifier )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:436:1: ( ruleStaticQualifier )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:437:3: ruleStaticQualifier
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXAnnotationValueFieldReferenceRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAnnotationValueFieldReferenceAccess().getDeclaringTypeJvmDeclaredTypeCrossReference_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStaticQualifier_in_ruleXAnnotationValueFieldReference972);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:450:3: ( ( ruleIdOrSuper ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:451:1: ( ruleIdOrSuper )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:451:1: ( ruleIdOrSuper )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:452:3: ruleIdOrSuper
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXAnnotationValueFieldReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXAnnotationValueFieldReferenceAccess().getFeatureJvmIdentifiableElementCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_ruleXAnnotationValueFieldReference996);
            ruleIdOrSuper();

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
    // $ANTLR end "ruleXAnnotationValueFieldReference"


    // $ANTLR start "entryRuleXAnnotationValueArray"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:473:1: entryRuleXAnnotationValueArray returns [EObject current=null] : iv_ruleXAnnotationValueArray= ruleXAnnotationValueArray EOF ;
    public final EObject entryRuleXAnnotationValueArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAnnotationValueArray = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:474:2: (iv_ruleXAnnotationValueArray= ruleXAnnotationValueArray EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:475:2: iv_ruleXAnnotationValueArray= ruleXAnnotationValueArray EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAnnotationValueArrayRule()); 
            }
            pushFollow(FOLLOW_ruleXAnnotationValueArray_in_entryRuleXAnnotationValueArray1032);
            iv_ruleXAnnotationValueArray=ruleXAnnotationValueArray();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAnnotationValueArray; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAnnotationValueArray1042); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXAnnotationValueArray"


    // $ANTLR start "ruleXAnnotationValueArray"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:482:1: ruleXAnnotationValueArray returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_values_2_0= ruleXAnnotationElementValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleXAnnotationElementValue ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleXAnnotationValueArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:485:28: ( ( () otherlv_1= '{' ( (lv_values_2_0= ruleXAnnotationElementValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleXAnnotationElementValue ) ) )* otherlv_5= '}' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:486:1: ( () otherlv_1= '{' ( (lv_values_2_0= ruleXAnnotationElementValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleXAnnotationElementValue ) ) )* otherlv_5= '}' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:486:1: ( () otherlv_1= '{' ( (lv_values_2_0= ruleXAnnotationElementValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleXAnnotationElementValue ) ) )* otherlv_5= '}' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:486:2: () otherlv_1= '{' ( (lv_values_2_0= ruleXAnnotationElementValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleXAnnotationElementValue ) ) )* otherlv_5= '}'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:486:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:487:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXAnnotationValueArrayAccess().getXAnnotationValueArrayAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleXAnnotationValueArray1088); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXAnnotationValueArrayAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:496:1: ( (lv_values_2_0= ruleXAnnotationElementValue ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:497:1: (lv_values_2_0= ruleXAnnotationElementValue )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:497:1: (lv_values_2_0= ruleXAnnotationElementValue )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:498:3: lv_values_2_0= ruleXAnnotationElementValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXAnnotationValueArrayAccess().getValuesXAnnotationElementValueParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotationValueArray1109);
            lv_values_2_0=ruleXAnnotationElementValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXAnnotationValueArrayRule());
              	        }
                     		add(
                     			current, 
                     			"values",
                      		lv_values_2_0, 
                      		"XAnnotationElementValue");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:514:2: (otherlv_3= ',' ( (lv_values_4_0= ruleXAnnotationElementValue ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==13) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:514:4: otherlv_3= ',' ( (lv_values_4_0= ruleXAnnotationElementValue ) )
            	    {
            	    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleXAnnotationValueArray1122); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getXAnnotationValueArrayAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:518:1: ( (lv_values_4_0= ruleXAnnotationElementValue ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:519:1: (lv_values_4_0= ruleXAnnotationElementValue )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:519:1: (lv_values_4_0= ruleXAnnotationElementValue )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:520:3: lv_values_4_0= ruleXAnnotationElementValue
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAnnotationValueArrayAccess().getValuesXAnnotationElementValueParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotationValueArray1143);
            	    lv_values_4_0=ruleXAnnotationElementValue();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXAnnotationValueArrayRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"values",
            	              		lv_values_4_0, 
            	              		"XAnnotationElementValue");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleXAnnotationValueArray1157); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXAnnotationValueArrayAccess().getRightCurlyBracketKeyword_4());
                  
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
    // $ANTLR end "ruleXAnnotationValueArray"


    // $ANTLR start "entryRuleXExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:548:1: entryRuleXExpression returns [EObject current=null] : iv_ruleXExpression= ruleXExpression EOF ;
    public final EObject entryRuleXExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:549:2: (iv_ruleXExpression= ruleXExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:550:2: iv_ruleXExpression= ruleXExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXExpression_in_entryRuleXExpression1193);
            iv_ruleXExpression=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpression1203); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:557:1: ruleXExpression returns [EObject current=null] : this_XAssignment_0= ruleXAssignment ;
    public final EObject ruleXExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAssignment_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:560:28: (this_XAssignment_0= ruleXAssignment )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:562:5: this_XAssignment_0= ruleXAssignment
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleXAssignment_in_ruleXExpression1249);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:578:1: entryRuleXAssignment returns [EObject current=null] : iv_ruleXAssignment= ruleXAssignment EOF ;
    public final EObject entryRuleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAssignment = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:579:2: (iv_ruleXAssignment= ruleXAssignment EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:580:2: iv_ruleXAssignment= ruleXAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleXAssignment_in_entryRuleXAssignment1283);
            iv_ruleXAssignment=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAssignment1293); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:587:1: ruleXAssignment returns [EObject current=null] : ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) ;
    public final EObject ruleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject lv_value_3_0 = null;

        EObject this_XOrExpression_4 = null;

        EObject lv_rightOperand_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:590:28: ( ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:591:1: ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:591:1: ( ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==15) ) {
                    alt9=1;
                }
                else if ( (LA9_1==EOF||(LA9_1>=RULE_INT && LA9_1<=RULE_ID)||(LA9_1>=12 && LA9_1<=14)||(LA9_1>=16 && LA9_1<=41)||(LA9_1>=43 && LA9_1<=69)) ) {
                    alt9=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA9_0>=RULE_INT && LA9_0<=RULE_STRING)||LA9_0==12||(LA9_0>=16 && LA9_0<=17)||LA9_0==28||LA9_0==31||LA9_0==36||LA9_0==41||LA9_0==44||(LA9_0>=46 && LA9_0<=47)||(LA9_0>=50 && LA9_0<=52)||LA9_0==56||(LA9_0>=58 && LA9_0<=65)||LA9_0==68) ) {
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:591:2: ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:591:2: ( () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:591:3: () ( ( ruleValidID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:591:3: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:592:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXAssignmentAccess().getXAssignmentAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:597:2: ( ( ruleValidID ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:598:1: ( ruleValidID )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:598:1: ( ruleValidID )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:599:3: ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXAssignmentRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXAssignment1351);
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
                    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXAssignment1367);
                    ruleOpSingleAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:620:1: ( (lv_value_3_0= ruleXAssignment ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:621:1: (lv_value_3_0= ruleXAssignment )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:621:1: (lv_value_3_0= ruleXAssignment )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:622:3: lv_value_3_0= ruleXAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_0_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment1387);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:639:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:639:6: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:640:5: this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXOrExpression_in_ruleXAssignment1417);
                    this_XOrExpression_4=ruleXOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XOrExpression_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:648:1: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==19) ) {
                        int LA8_1 = input.LA(2);

                        if ( (synpred2_InternalXbaseWithAnnotations()) ) {
                            alt8=1;
                        }
                    }
                    switch (alt8) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:648:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:648:2: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:648:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:653:6: ( () ( ( ruleOpMultiAssign ) ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:653:7: () ( ( ruleOpMultiAssign ) )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:653:7: ()
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:654:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
                                          current);
                                  
                            }

                            }

                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:659:2: ( ( ruleOpMultiAssign ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:660:1: ( ruleOpMultiAssign )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:660:1: ( ruleOpMultiAssign )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:661:3: ruleOpMultiAssign
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getXAssignmentRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleOpMultiAssign_in_ruleXAssignment1470);
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

                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:674:4: ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:675:1: (lv_rightOperand_7_0= ruleXAssignment )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:675:1: (lv_rightOperand_7_0= ruleXAssignment )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:676:3: lv_rightOperand_7_0= ruleXAssignment
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXAssignmentAccess().getRightOperandXAssignmentParserRuleCall_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXAssignment_in_ruleXAssignment1493);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:700:1: entryRuleOpSingleAssign returns [String current=null] : iv_ruleOpSingleAssign= ruleOpSingleAssign EOF ;
    public final String entryRuleOpSingleAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpSingleAssign = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:701:2: (iv_ruleOpSingleAssign= ruleOpSingleAssign EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:702:2: iv_ruleOpSingleAssign= ruleOpSingleAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpSingleAssignRule()); 
            }
            pushFollow(FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign1533);
            iv_ruleOpSingleAssign=ruleOpSingleAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpSingleAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpSingleAssign1544); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:709:1: ruleOpSingleAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleOpSingleAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:712:28: (kw= '=' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:714:2: kw= '='
            {
            kw=(Token)match(input,15,FOLLOW_15_in_ruleOpSingleAssign1581); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:727:1: entryRuleOpMultiAssign returns [String current=null] : iv_ruleOpMultiAssign= ruleOpMultiAssign EOF ;
    public final String entryRuleOpMultiAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMultiAssign = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:728:2: (iv_ruleOpMultiAssign= ruleOpMultiAssign EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:729:2: iv_ruleOpMultiAssign= ruleOpMultiAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiAssignRule()); 
            }
            pushFollow(FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign1621);
            iv_ruleOpMultiAssign=ruleOpMultiAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMultiAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMultiAssign1632); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:736:1: ruleOpMultiAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '+=' ;
    public final AntlrDatatypeRuleToken ruleOpMultiAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:739:28: (kw= '+=' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:741:2: kw= '+='
            {
            kw=(Token)match(input,19,FOLLOW_19_in_ruleOpMultiAssign1669); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:754:1: entryRuleXOrExpression returns [EObject current=null] : iv_ruleXOrExpression= ruleXOrExpression EOF ;
    public final EObject entryRuleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOrExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:755:2: (iv_ruleXOrExpression= ruleXOrExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:756:2: iv_ruleXOrExpression= ruleXOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression1708);
            iv_ruleXOrExpression=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOrExpression1718); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:763:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
    public final EObject ruleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:766:28: ( (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:767:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:767:1: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:768:5: this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression1765);
            this_XAndExpression_0=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:776:1: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==20) ) {
                    int LA10_2 = input.LA(2);

                    if ( (synpred3_InternalXbaseWithAnnotations()) ) {
                        alt10=1;
                    }


                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:776:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:776:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:776:3: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:781:6: ( () ( ( ruleOpOr ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:781:7: () ( ( ruleOpOr ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:781:7: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:782:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:787:2: ( ( ruleOpOr ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:788:1: ( ruleOpOr )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:788:1: ( ruleOpOr )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:789:3: ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOrExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOr_in_ruleXOrExpression1818);
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:802:4: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:803:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:803:1: (lv_rightOperand_3_0= ruleXAndExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:804:3: lv_rightOperand_3_0= ruleXAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAndExpression_in_ruleXOrExpression1841);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:828:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:829:2: (iv_ruleOpOr= ruleOpOr EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:830:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr1880);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr1891); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:837:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:840:28: (kw= '||' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:842:2: kw= '||'
            {
            kw=(Token)match(input,20,FOLLOW_20_in_ruleOpOr1928); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:855:1: entryRuleXAndExpression returns [EObject current=null] : iv_ruleXAndExpression= ruleXAndExpression EOF ;
    public final EObject entryRuleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAndExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:856:2: (iv_ruleXAndExpression= ruleXAndExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:857:2: iv_ruleXAndExpression= ruleXAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression1967);
            iv_ruleXAndExpression=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAndExpression1977); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:864:1: ruleXAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final EObject ruleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XEqualityExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:867:28: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:868:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:868:1: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:869:5: this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression2024);
            this_XEqualityExpression_0=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XEqualityExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:877:1: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==21) ) {
                    int LA11_2 = input.LA(2);

                    if ( (synpred4_InternalXbaseWithAnnotations()) ) {
                        alt11=1;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:877:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:877:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:877:3: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:882:6: ( () ( ( ruleOpAnd ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:882:7: () ( ( ruleOpAnd ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:882:7: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:883:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:888:2: ( ( ruleOpAnd ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:889:1: ( ruleOpAnd )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:889:1: ( ruleOpAnd )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:890:3: ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAndExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAnd_in_ruleXAndExpression2077);
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:903:4: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:904:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:904:1: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:905:3: lv_rightOperand_3_0= ruleXEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression2100);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:929:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:930:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:931:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd2139);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd2150); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:938:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:941:28: (kw= '&&' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:943:2: kw= '&&'
            {
            kw=(Token)match(input,21,FOLLOW_21_in_ruleOpAnd2187); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:956:1: entryRuleXEqualityExpression returns [EObject current=null] : iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
    public final EObject entryRuleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEqualityExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:957:2: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:958:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression2226);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXEqualityExpression2236); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:965:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final EObject ruleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XRelationalExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:968:28: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:969:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:969:1: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:970:5: this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2283);
            this_XRelationalExpression_0=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XRelationalExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:978:1: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==22) ) {
                    int LA12_2 = input.LA(2);

                    if ( (synpred5_InternalXbaseWithAnnotations()) ) {
                        alt12=1;
                    }


                }
                else if ( (LA12_0==23) ) {
                    int LA12_3 = input.LA(2);

                    if ( (synpred5_InternalXbaseWithAnnotations()) ) {
                        alt12=1;
                    }


                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:978:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:978:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:978:3: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:983:6: ( () ( ( ruleOpEquality ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:983:7: () ( ( ruleOpEquality ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:983:7: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:984:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:989:2: ( ( ruleOpEquality ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:990:1: ( ruleOpEquality )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:990:1: ( ruleOpEquality )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:991:3: ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXEqualityExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpEquality_in_ruleXEqualityExpression2336);
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1004:4: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1005:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1005:1: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1006:3: lv_rightOperand_3_0= ruleXRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2359);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1030:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1031:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1032:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality2398);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality2409); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1039:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1042:28: ( (kw= '==' | kw= '!=' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1043:1: (kw= '==' | kw= '!=' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1043:1: (kw= '==' | kw= '!=' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==22) ) {
                alt13=1;
            }
            else if ( (LA13_0==23) ) {
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1044:2: kw= '=='
                    {
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleOpEquality2447); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1051:2: kw= '!='
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleOpEquality2466); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1064:1: entryRuleXRelationalExpression returns [EObject current=null] : iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
    public final EObject entryRuleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRelationalExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1065:2: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1066:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression2506);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXRelationalExpression2516); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1073:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final EObject ruleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XOtherOperatorExpression_0 = null;

        EObject lv_rightOperand_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1076:28: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1077:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1077:1: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1078:5: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2563);
            this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XOtherOperatorExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1086:1: ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            loop14:
            do {
                int alt14=3;
                switch ( input.LA(1) ) {
                case 24:
                    {
                    int LA14_2 = input.LA(2);

                    if ( (synpred6_InternalXbaseWithAnnotations()) ) {
                        alt14=1;
                    }


                    }
                    break;
                case 25:
                    {
                    int LA14_3 = input.LA(2);

                    if ( (synpred7_InternalXbaseWithAnnotations()) ) {
                        alt14=2;
                    }


                    }
                    break;
                case 26:
                    {
                    int LA14_4 = input.LA(2);

                    if ( (synpred7_InternalXbaseWithAnnotations()) ) {
                        alt14=2;
                    }


                    }
                    break;
                case 27:
                    {
                    int LA14_5 = input.LA(2);

                    if ( (synpred7_InternalXbaseWithAnnotations()) ) {
                        alt14=2;
                    }


                    }
                    break;
                case 28:
                    {
                    int LA14_6 = input.LA(2);

                    if ( (synpred7_InternalXbaseWithAnnotations()) ) {
                        alt14=2;
                    }


                    }
                    break;

                }

                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1086:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1086:2: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1086:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( ( ruleQualifiedName ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1086:3: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1086:4: ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1088:5: ( () otherlv_2= 'instanceof' )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1088:6: () otherlv_2= 'instanceof'
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1088:6: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1089:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleXRelationalExpression2599); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1098:3: ( ( ruleQualifiedName ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1099:1: ( ruleQualifiedName )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1099:1: ( ruleQualifiedName )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1100:3: ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeCrossReference_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression2624);
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
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1114:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1114:6: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1114:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1114:7: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1114:8: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1119:6: ( () ( ( ruleOpCompare ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1119:7: () ( ( ruleOpCompare ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1119:7: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1120:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1125:2: ( ( ruleOpCompare ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1126:1: ( ruleOpCompare )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1126:1: ( ruleOpCompare )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1127:3: ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXRelationalExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2685);
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1140:4: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1141:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1141:1: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1142:3: lv_rightOperand_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2708);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1166:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1167:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1168:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare2748);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare2759); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1175:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1178:28: ( (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1179:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1179:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            int alt15=4;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt15=1;
                }
                break;
            case 26:
                {
                alt15=2;
                }
                break;
            case 27:
                {
                alt15=3;
                }
                break;
            case 28:
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1180:2: kw= '>='
                    {
                    kw=(Token)match(input,25,FOLLOW_25_in_ruleOpCompare2797); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1187:2: kw= '<='
                    {
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleOpCompare2816); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1194:2: kw= '>'
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleOpCompare2835); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1201:2: kw= '<'
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleOpCompare2854); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1214:1: entryRuleXOtherOperatorExpression returns [EObject current=null] : iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
    public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOtherOperatorExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1215:2: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1216:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOtherOperatorExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression2894);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOtherOperatorExpression2904); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1223:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAdditiveExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1226:28: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1227:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1227:1: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1228:5: this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2951);
            this_XAdditiveExpression_0=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XAdditiveExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1236:1: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==29) ) {
                    int LA16_2 = input.LA(2);

                    if ( (synpred8_InternalXbaseWithAnnotations()) ) {
                        alt16=1;
                    }


                }
                else if ( (LA16_0==30) ) {
                    int LA16_3 = input.LA(2);

                    if ( (synpred8_InternalXbaseWithAnnotations()) ) {
                        alt16=1;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1236:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1236:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1236:3: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1241:6: ( () ( ( ruleOpOther ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1241:7: () ( ( ruleOpOther ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1241:7: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1242:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1247:2: ( ( ruleOpOther ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1248:1: ( ruleOpOther )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1248:1: ( ruleOpOther )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1249:3: ruleOpOther
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXOtherOperatorExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression3004);
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1262:4: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1263:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1263:1: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1264:3: lv_rightOperand_3_0= ruleXAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression3027);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1288:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1289:2: (iv_ruleOpOther= ruleOpOther EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1290:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOtherRule()); 
            }
            pushFollow(FOLLOW_ruleOpOther_in_entryRuleOpOther3066);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOther3077); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1297:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1300:28: ( (kw= '->' | kw= '..' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1301:1: (kw= '->' | kw= '..' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1301:1: (kw= '->' | kw= '..' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            else if ( (LA17_0==30) ) {
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1302:2: kw= '->'
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleOpOther3115); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1309:2: kw= '..'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleOpOther3134); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1322:1: entryRuleXAdditiveExpression returns [EObject current=null] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAdditiveExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1323:2: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1324:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression3174);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAdditiveExpression3184); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1331:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XMultiplicativeExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1334:28: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1335:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1335:1: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1336:5: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3231);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMultiplicativeExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1344:1: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==16) ) {
                    int LA18_2 = input.LA(2);

                    if ( (synpred9_InternalXbaseWithAnnotations()) ) {
                        alt18=1;
                    }


                }
                else if ( (LA18_0==31) ) {
                    int LA18_3 = input.LA(2);

                    if ( (synpred9_InternalXbaseWithAnnotations()) ) {
                        alt18=1;
                    }


                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1344:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1344:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1344:3: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1349:6: ( () ( ( ruleOpAdd ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1349:7: () ( ( ruleOpAdd ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1349:7: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1350:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1355:2: ( ( ruleOpAdd ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1356:1: ( ruleOpAdd )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1356:1: ( ruleOpAdd )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1357:3: ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXAdditiveExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression3284);
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1370:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1371:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1371:1: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1372:3: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3307);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1396:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1397:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1398:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd3346);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd3357); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1405:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1408:28: ( (kw= '+' | kw= '-' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1409:1: (kw= '+' | kw= '-' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1409:1: (kw= '+' | kw= '-' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==16) ) {
                alt19=1;
            }
            else if ( (LA19_0==31) ) {
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1410:2: kw= '+'
                    {
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleOpAdd3395); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1417:2: kw= '-'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleOpAdd3414); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1430:1: entryRuleXMultiplicativeExpression returns [EObject current=null] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMultiplicativeExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1431:2: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1432:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression3454);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMultiplicativeExpression3464); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1439:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XUnaryOperation_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1442:28: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1443:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1443:1: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1444:5: this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3511);
            this_XUnaryOperation_0=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XUnaryOperation_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1452:1: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            loop20:
            do {
                int alt20=2;
                switch ( input.LA(1) ) {
                case 32:
                    {
                    int LA20_2 = input.LA(2);

                    if ( (synpred10_InternalXbaseWithAnnotations()) ) {
                        alt20=1;
                    }


                    }
                    break;
                case 33:
                    {
                    int LA20_3 = input.LA(2);

                    if ( (synpred10_InternalXbaseWithAnnotations()) ) {
                        alt20=1;
                    }


                    }
                    break;
                case 34:
                    {
                    int LA20_4 = input.LA(2);

                    if ( (synpred10_InternalXbaseWithAnnotations()) ) {
                        alt20=1;
                    }


                    }
                    break;
                case 35:
                    {
                    int LA20_5 = input.LA(2);

                    if ( (synpred10_InternalXbaseWithAnnotations()) ) {
                        alt20=1;
                    }


                    }
                    break;

                }

                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1452:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1452:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1452:3: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1457:6: ( () ( ( ruleOpMulti ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1457:7: () ( ( ruleOpMulti ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1457:7: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1458:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1463:2: ( ( ruleOpMulti ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1464:1: ( ruleOpMulti )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1464:1: ( ruleOpMulti )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1465:3: ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMultiplicativeExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression3564);
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1478:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1479:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1479:1: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1480:3: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3587);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1504:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1505:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1506:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti3626);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti3637); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1513:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1516:28: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1517:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1517:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt21=4;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt21=1;
                }
                break;
            case 33:
                {
                alt21=2;
                }
                break;
            case 34:
                {
                alt21=3;
                }
                break;
            case 35:
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1518:2: kw= '*'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleOpMulti3675); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1525:2: kw= '**'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleOpMulti3694); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1532:2: kw= '/'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleOpMulti3713); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1539:2: kw= '%'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleOpMulti3732); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1552:1: entryRuleXUnaryOperation returns [EObject current=null] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnaryOperation = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1553:2: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1554:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3772);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXUnaryOperation3782); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1561:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) ;
    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_2_0 = null;

        EObject this_XCastedExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1564:28: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1565:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1565:1: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==16||LA22_0==31||LA22_0==36) ) {
                alt22=1;
            }
            else if ( ((LA22_0>=RULE_INT && LA22_0<=RULE_ID)||LA22_0==12||LA22_0==17||LA22_0==28||LA22_0==41||LA22_0==44||(LA22_0>=46 && LA22_0<=47)||(LA22_0>=50 && LA22_0<=52)||LA22_0==56||(LA22_0>=58 && LA22_0<=65)||LA22_0==68) ) {
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1565:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1565:2: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1565:3: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXCastedExpression ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1565:3: ()
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1566:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1571:2: ( ( ruleOpUnary ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1572:1: ( ruleOpUnary )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1572:1: ( ruleOpUnary )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1573:3: ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXUnaryOperationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleXUnaryOperation3840);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1586:2: ( (lv_operand_2_0= ruleXCastedExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1587:1: (lv_operand_2_0= ruleXCastedExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1587:1: (lv_operand_2_0= ruleXCastedExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1588:3: lv_operand_2_0= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXCastedExpressionParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3861);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1606:5: this_XCastedExpression_3= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3890);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1622:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1623:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1624:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary3926);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary3937); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1631:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1634:28: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1635:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1635:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt23=3;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt23=1;
                }
                break;
            case 31:
                {
                alt23=2;
                }
                break;
            case 16:
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1636:2: kw= '!'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleOpUnary3975); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1643:2: kw= '-'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleOpUnary3994); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1650:2: kw= '+'
                    {
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleOpUnary4013); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1663:1: entryRuleXCastedExpression returns [EObject current=null] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final EObject entryRuleXCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCastedExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1664:2: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1665:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCastedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression4053);
            iv_ruleXCastedExpression=ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCastedExpression4063); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1672:1: ruleXCastedExpression returns [EObject current=null] : (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) ;
    public final EObject ruleXCastedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XMemberFeatureCall_0 = null;

        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1675:28: ( (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1676:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1676:1: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1677:5: this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXCastedExpressionAccess().getXMemberFeatureCallParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression4110);
            this_XMemberFeatureCall_0=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XMemberFeatureCall_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1685:1: ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==37) ) {
                    int LA24_2 = input.LA(2);

                    if ( (synpred11_InternalXbaseWithAnnotations()) ) {
                        alt24=1;
                    }


                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1685:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1685:2: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1685:3: ( ( () 'as' ) )=> ( () otherlv_2= 'as' )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1687:5: ( () otherlv_2= 'as' )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1687:6: () otherlv_2= 'as'
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1687:6: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1688:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,37,FOLLOW_37_in_ruleXCastedExpression4145); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getAsKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1697:3: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1698:1: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1698:1: (lv_type_3_0= ruleJvmTypeReference )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1699:3: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression4168);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1723:1: entryRuleXMemberFeatureCall returns [EObject current=null] : iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
    public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMemberFeatureCall = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1724:2: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1725:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMemberFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall4206);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMemberFeatureCall4216); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1732:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* ) ;
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


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1735:28: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1736:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1736:1: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1737:5: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall4263);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XPrimaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1745:1: ( ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? ) )*
            loop31:
            do {
                int alt31=3;
                switch ( input.LA(1) ) {
                case 38:
                    {
                    int LA31_2 = input.LA(2);

                    if ( (synpred12_InternalXbaseWithAnnotations()) ) {
                        alt31=1;
                    }
                    else if ( (synpred13_InternalXbaseWithAnnotations()) ) {
                        alt31=2;
                    }


                    }
                    break;
                case 39:
                    {
                    int LA31_3 = input.LA(2);

                    if ( (synpred13_InternalXbaseWithAnnotations()) ) {
                        alt31=2;
                    }


                    }
                    break;
                case 40:
                    {
                    int LA31_4 = input.LA(2);

                    if ( (synpred13_InternalXbaseWithAnnotations()) ) {
                        alt31=2;
                    }


                    }
                    break;

                }

                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1745:2: ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1745:2: ( ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1745:3: ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) ) ( (lv_value_5_0= ruleXAssignment ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1745:3: ( ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1745:4: ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )=> ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1751:25: ( () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1751:26: () otherlv_2= '.' ( ( ruleValidID ) ) ruleOpSingleAssign
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1751:26: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1752:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleXMemberFeatureCall4312); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_0_1());
            	          
            	    }
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1761:1: ( ( ruleValidID ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1762:1: ( ruleValidID )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1762:1: ( ruleValidID )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1763:3: ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4335);
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
            	    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall4351);
            	    ruleOpSingleAssign();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1784:3: ( (lv_value_5_0= ruleXAssignment ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1785:1: (lv_value_5_0= ruleXAssignment )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1785:1: (lv_value_5_0= ruleXAssignment )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1786:3: lv_value_5_0= ruleXAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall4373);
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
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1803:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1803:6: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )? )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1803:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) ) (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )? ( ( ruleValidID ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1803:7: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1803:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )=> ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1819:7: ( () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1819:8: () (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1819:8: ()
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1820:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1825:2: (otherlv_7= '.' | ( (lv_nullSafe_8_0= '?.' ) ) | ( (lv_spreading_9_0= '*.' ) ) )
            	    int alt25=3;
            	    switch ( input.LA(1) ) {
            	    case 38:
            	        {
            	        alt25=1;
            	        }
            	        break;
            	    case 39:
            	        {
            	        alt25=2;
            	        }
            	        break;
            	    case 40:
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
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1825:4: otherlv_7= '.'
            	            {
            	            otherlv_7=(Token)match(input,38,FOLLOW_38_in_ruleXMemberFeatureCall4459); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_7, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0());
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1830:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            {
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1830:6: ( (lv_nullSafe_8_0= '?.' ) )
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1831:1: (lv_nullSafe_8_0= '?.' )
            	            {
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1831:1: (lv_nullSafe_8_0= '?.' )
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1832:3: lv_nullSafe_8_0= '?.'
            	            {
            	            lv_nullSafe_8_0=(Token)match(input,39,FOLLOW_39_in_ruleXMemberFeatureCall4483); if (state.failed) return current;
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
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1846:6: ( (lv_spreading_9_0= '*.' ) )
            	            {
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1846:6: ( (lv_spreading_9_0= '*.' ) )
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1847:1: (lv_spreading_9_0= '*.' )
            	            {
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1847:1: (lv_spreading_9_0= '*.' )
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1848:3: lv_spreading_9_0= '*.'
            	            {
            	            lv_spreading_9_0=(Token)match(input,40,FOLLOW_40_in_ruleXMemberFeatureCall4520); if (state.failed) return current;
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1861:5: (otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>' )?
            	    int alt27=2;
            	    int LA27_0 = input.LA(1);

            	    if ( (LA27_0==28) ) {
            	        alt27=1;
            	    }
            	    switch (alt27) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1861:7: otherlv_10= '<' ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) ) (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )* otherlv_14= '>'
            	            {
            	            otherlv_10=(Token)match(input,28,FOLLOW_28_in_ruleXMemberFeatureCall4549); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_10, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_1_1_0());
            	                  
            	            }
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1865:1: ( (lv_typeArguments_11_0= ruleJvmArgumentTypeReference ) )
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1866:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            {
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1866:1: (lv_typeArguments_11_0= ruleJvmArgumentTypeReference )
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1867:3: lv_typeArguments_11_0= ruleJvmArgumentTypeReference
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4570);
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

            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1883:2: (otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) ) )*
            	            loop26:
            	            do {
            	                int alt26=2;
            	                int LA26_0 = input.LA(1);

            	                if ( (LA26_0==13) ) {
            	                    alt26=1;
            	                }


            	                switch (alt26) {
            	            	case 1 :
            	            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1883:4: otherlv_12= ',' ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    {
            	            	    otherlv_12=(Token)match(input,13,FOLLOW_13_in_ruleXMemberFeatureCall4583); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	          	newLeafNode(otherlv_12, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_1_2_0());
            	            	          
            	            	    }
            	            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1887:1: ( (lv_typeArguments_13_0= ruleJvmArgumentTypeReference ) )
            	            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1888:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    {
            	            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1888:1: (lv_typeArguments_13_0= ruleJvmArgumentTypeReference )
            	            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1889:3: lv_typeArguments_13_0= ruleJvmArgumentTypeReference
            	            	    {
            	            	    if ( state.backtracking==0 ) {
            	            	       
            	            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0()); 
            	            	      	    
            	            	    }
            	            	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4604);
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

            	            otherlv_14=(Token)match(input,27,FOLLOW_27_in_ruleXMemberFeatureCall4618); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_14, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_1_1_3());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1909:3: ( ( ruleValidID ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1910:1: ( ruleValidID )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1910:1: ( ruleValidID )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1911:3: ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4643);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1924:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?
            	    int alt30=2;
            	    alt30 = dfa30.predict(input);
            	    switch (alt30) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1924:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')'
            	            {
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1924:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) )
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1924:4: ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' )
            	            {
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1931:1: (lv_explicitOperationCall_16_0= '(' )
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1932:3: lv_explicitOperationCall_16_0= '('
            	            {
            	            lv_explicitOperationCall_16_0=(Token)match(input,12,FOLLOW_12_in_ruleXMemberFeatureCall4677); if (state.failed) return current;
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

            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1945:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?
            	            int alt29=3;
            	            alt29 = dfa29.predict(input);
            	            switch (alt29) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1945:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    {
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1945:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) )
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1945:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    {
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1957:1: (lv_memberCallArguments_17_0= ruleXShortClosure )
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1958:3: lv_memberCallArguments_17_0= ruleXShortClosure
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4752);
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
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1975:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    {
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1975:6: ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* )
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1975:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    {
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1975:7: ( (lv_memberCallArguments_18_0= ruleXExpression ) )
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1976:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    {
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1976:1: (lv_memberCallArguments_18_0= ruleXExpression )
            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1977:3: lv_memberCallArguments_18_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4780);
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

            	                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1993:2: (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )*
            	                    loop28:
            	                    do {
            	                        int alt28=2;
            	                        int LA28_0 = input.LA(1);

            	                        if ( (LA28_0==13) ) {
            	                            alt28=1;
            	                        }


            	                        switch (alt28) {
            	                    	case 1 :
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1993:4: otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    {
            	                    	    otherlv_19=(Token)match(input,13,FOLLOW_13_in_ruleXMemberFeatureCall4793); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	          	newLeafNode(otherlv_19, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0());
            	                    	          
            	                    	    }
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1997:1: ( (lv_memberCallArguments_20_0= ruleXExpression ) )
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1998:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    {
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1998:1: (lv_memberCallArguments_20_0= ruleXExpression )
            	                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1999:3: lv_memberCallArguments_20_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {
            	                    	       
            	                    	      	        newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0()); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4814);
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

            	            otherlv_21=(Token)match(input,14,FOLLOW_14_in_ruleXMemberFeatureCall4831); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_21, grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_1_3_2());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2027:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPrimaryExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2028:2: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2029:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression4872);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression4882); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2036:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XWithExpression_3= ruleXWithExpression | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | this_XForLoopExpression_7= ruleXForLoopExpression | this_XWhileExpression_8= ruleXWhileExpression | this_XDoWhileExpression_9= ruleXDoWhileExpression | this_XThrowExpression_10= ruleXThrowExpression | this_XReturnExpression_11= ruleXReturnExpression | this_XTryCatchFinallyExpression_12= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_13= ruleXParenthesizedExpression ) ;
    public final EObject ruleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XConstructorCall_0 = null;

        EObject this_XBlockExpression_1 = null;

        EObject this_XSwitchExpression_2 = null;

        EObject this_XWithExpression_3 = null;

        EObject this_XFeatureCall_4 = null;

        EObject this_XLiteral_5 = null;

        EObject this_XIfExpression_6 = null;

        EObject this_XForLoopExpression_7 = null;

        EObject this_XWhileExpression_8 = null;

        EObject this_XDoWhileExpression_9 = null;

        EObject this_XThrowExpression_10 = null;

        EObject this_XReturnExpression_11 = null;

        EObject this_XTryCatchFinallyExpression_12 = null;

        EObject this_XParenthesizedExpression_13 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2039:28: ( (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XWithExpression_3= ruleXWithExpression | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | this_XForLoopExpression_7= ruleXForLoopExpression | this_XWhileExpression_8= ruleXWhileExpression | this_XDoWhileExpression_9= ruleXDoWhileExpression | this_XThrowExpression_10= ruleXThrowExpression | this_XReturnExpression_11= ruleXReturnExpression | this_XTryCatchFinallyExpression_12= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_13= ruleXParenthesizedExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2040:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XWithExpression_3= ruleXWithExpression | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | this_XForLoopExpression_7= ruleXForLoopExpression | this_XWhileExpression_8= ruleXWhileExpression | this_XDoWhileExpression_9= ruleXDoWhileExpression | this_XThrowExpression_10= ruleXThrowExpression | this_XReturnExpression_11= ruleXReturnExpression | this_XTryCatchFinallyExpression_12= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_13= ruleXParenthesizedExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2040:1: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | this_XWithExpression_3= ruleXWithExpression | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | this_XForLoopExpression_7= ruleXForLoopExpression | this_XWhileExpression_8= ruleXWhileExpression | this_XDoWhileExpression_9= ruleXDoWhileExpression | this_XThrowExpression_10= ruleXThrowExpression | this_XReturnExpression_11= ruleXReturnExpression | this_XTryCatchFinallyExpression_12= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_13= ruleXParenthesizedExpression )
            int alt32=14;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt32=1;
                }
                break;
            case 17:
                {
                alt32=2;
                }
                break;
            case 46:
                {
                alt32=3;
                }
                break;
            case 47:
            case 68:
                {
                alt32=4;
                }
                break;
            case RULE_ID:
            case 28:
            case 56:
                {
                alt32=5;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case 41:
            case 59:
            case 60:
            case 61:
            case 62:
                {
                alt32=6;
                }
                break;
            case 44:
                {
                alt32=7;
                }
                break;
            case 50:
                {
                alt32=8;
                }
                break;
            case 51:
                {
                alt32=9;
                }
                break;
            case 52:
                {
                alt32=10;
                }
                break;
            case 63:
                {
                alt32=11;
                }
                break;
            case 64:
                {
                alt32=12;
                }
                break;
            case 65:
                {
                alt32=13;
                }
                break;
            case 12:
                {
                alt32=14;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2041:5: this_XConstructorCall_0= ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression4929);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2051:5: this_XBlockExpression_1= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression4956);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2061:5: this_XSwitchExpression_2= ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression4983);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2071:5: this_XWithExpression_3= ruleXWithExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWithExpressionParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXWithExpression_in_ruleXPrimaryExpression5010);
                    this_XWithExpression_3=ruleXWithExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XWithExpression_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2081:5: this_XFeatureCall_4= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression5037);
                    this_XFeatureCall_4=ruleXFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XFeatureCall_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2091:5: this_XLiteral_5= ruleXLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression5064);
                    this_XLiteral_5=ruleXLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XLiteral_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2101:5: this_XIfExpression_6= ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression5091);
                    this_XIfExpression_6=ruleXIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XIfExpression_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2111:5: this_XForLoopExpression_7= ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression5118);
                    this_XForLoopExpression_7=ruleXForLoopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XForLoopExpression_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2121:5: this_XWhileExpression_8= ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression5145);
                    this_XWhileExpression_8=ruleXWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XWhileExpression_8; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2131:5: this_XDoWhileExpression_9= ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression5172);
                    this_XDoWhileExpression_9=ruleXDoWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XDoWhileExpression_9; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 11 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2141:5: this_XThrowExpression_10= ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_10()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression5199);
                    this_XThrowExpression_10=ruleXThrowExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XThrowExpression_10; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 12 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2151:5: this_XReturnExpression_11= ruleXReturnExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXReturnExpressionParserRuleCall_11()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression5226);
                    this_XReturnExpression_11=ruleXReturnExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XReturnExpression_11; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 13 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2161:5: this_XTryCatchFinallyExpression_12= ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_12()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression5253);
                    this_XTryCatchFinallyExpression_12=ruleXTryCatchFinallyExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XTryCatchFinallyExpression_12; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 14 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2171:5: this_XParenthesizedExpression_13= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_13()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression5280);
                    this_XParenthesizedExpression_13=ruleXParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XParenthesizedExpression_13; 
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2187:1: entryRuleXLiteral returns [EObject current=null] : iv_ruleXLiteral= ruleXLiteral EOF ;
    public final EObject entryRuleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2188:2: (iv_ruleXLiteral= ruleXLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2189:2: iv_ruleXLiteral= ruleXLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXLiteral_in_entryRuleXLiteral5315);
            iv_ruleXLiteral=ruleXLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXLiteral5325); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2196:1: ruleXLiteral returns [EObject current=null] : (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) ;
    public final EObject ruleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_XClosure_0 = null;

        EObject this_XBooleanLiteral_1 = null;

        EObject this_XIntLiteral_2 = null;

        EObject this_XNullLiteral_3 = null;

        EObject this_XStringLiteral_4 = null;

        EObject this_XTypeLiteral_5 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2199:28: ( (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2200:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2200:1: (this_XClosure_0= ruleXClosure | this_XBooleanLiteral_1= ruleXBooleanLiteral | this_XIntLiteral_2= ruleXIntLiteral | this_XNullLiteral_3= ruleXNullLiteral | this_XStringLiteral_4= ruleXStringLiteral | this_XTypeLiteral_5= ruleXTypeLiteral )
            int alt33=6;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt33=1;
                }
                break;
            case 59:
            case 60:
                {
                alt33=2;
                }
                break;
            case RULE_INT:
                {
                alt33=3;
                }
                break;
            case 61:
                {
                alt33=4;
                }
                break;
            case RULE_STRING:
                {
                alt33=5;
                }
                break;
            case 62:
                {
                alt33=6;
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2201:5: this_XClosure_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXClosureParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXClosure_in_ruleXLiteral5372);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2211:5: this_XBooleanLiteral_1= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral5399);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2221:5: this_XIntLiteral_2= ruleXIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXIntLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXIntLiteral_in_ruleXLiteral5426);
                    this_XIntLiteral_2=ruleXIntLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XIntLiteral_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2231:5: this_XNullLiteral_3= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXNullLiteral_in_ruleXLiteral5453);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2241:5: this_XStringLiteral_4= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXStringLiteral_in_ruleXLiteral5480);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2251:5: this_XTypeLiteral_5= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXLiteralAccess().getXTypeLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXTypeLiteral_in_ruleXLiteral5507);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2267:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXClosure = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2268:2: (iv_ruleXClosure= ruleXClosure EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2269:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure5542);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure5552); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2276:1: ruleXClosure returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' ) ;
    public final EObject ruleXClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_formalParameters_2_0 = null;

        EObject lv_formalParameters_4_0 = null;

        EObject lv_expression_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2279:28: ( ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2280:1: ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2280:1: ( () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2280:2: () otherlv_1= '[' ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )? otherlv_5= '|' ( (lv_expression_6_0= ruleXExpression ) ) otherlv_7= ']'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2280:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2281:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXClosureAccess().getXClosureAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleXClosure5598); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXClosureAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2290:1: ( ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )* )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID||LA35_0==12||LA35_0==69) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2290:2: ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2290:2: ( (lv_formalParameters_2_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2291:1: (lv_formalParameters_2_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2291:1: (lv_formalParameters_2_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2292:3: lv_formalParameters_2_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5620);
                    lv_formalParameters_2_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXClosureRule());
                      	        }
                             		add(
                             			current, 
                             			"formalParameters",
                              		lv_formalParameters_2_0, 
                              		"JvmFormalParameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2308:2: (otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==13) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2308:4: otherlv_3= ',' ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleXClosure5633); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getXClosureAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2312:1: ( (lv_formalParameters_4_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2313:1: (lv_formalParameters_4_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2313:1: (lv_formalParameters_4_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2314:3: lv_formalParameters_4_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5654);
                    	    lv_formalParameters_4_0=ruleJvmFormalParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXClosureRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"formalParameters",
                    	              		lv_formalParameters_4_0, 
                    	              		"JvmFormalParameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,42,FOLLOW_42_in_ruleXClosure5670); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXClosureAccess().getVerticalLineKeyword_3());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2334:1: ( (lv_expression_6_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2335:1: (lv_expression_6_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2335:1: (lv_expression_6_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2336:3: lv_expression_6_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXClosure5691);
            lv_expression_6_0=ruleXExpression();

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
                      		"XExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,43,FOLLOW_43_in_ruleXClosure5703); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getXClosureAccess().getRightSquareBracketKeyword_5());
                  
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


    // $ANTLR start "entryRuleXShortClosure"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2364:1: entryRuleXShortClosure returns [EObject current=null] : iv_ruleXShortClosure= ruleXShortClosure EOF ;
    public final EObject entryRuleXShortClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXShortClosure = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2365:2: (iv_ruleXShortClosure= ruleXShortClosure EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2366:2: iv_ruleXShortClosure= ruleXShortClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXShortClosureRule()); 
            }
            pushFollow(FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure5739);
            iv_ruleXShortClosure=ruleXShortClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXShortClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXShortClosure5749); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2373:1: ruleXShortClosure returns [EObject current=null] : ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXShortClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_formalParameters_1_0 = null;

        EObject lv_formalParameters_3_0 = null;

        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2376:28: ( ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2377:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2377:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2377:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) ) ( (lv_expression_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2377:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2377:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2388:5: ( () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2388:6: () ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )? otherlv_4= '|'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2388:6: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2389:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXShortClosureAccess().getXClosureAction_0_0_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2394:2: ( ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID||LA37_0==12||LA37_0==69) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2394:3: ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2394:3: ( (lv_formalParameters_1_0= ruleJvmFormalParameter ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2395:1: (lv_formalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2395:1: (lv_formalParameters_1_0= ruleJvmFormalParameter )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2396:3: lv_formalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5847);
                    lv_formalParameters_1_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXShortClosureRule());
                      	        }
                             		add(
                             			current, 
                             			"formalParameters",
                              		lv_formalParameters_1_0, 
                              		"JvmFormalParameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2412:2: (otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==13) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2412:4: otherlv_2= ',' ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleXShortClosure5860); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getXShortClosureAccess().getCommaKeyword_0_0_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2416:1: ( (lv_formalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2417:1: (lv_formalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2417:1: (lv_formalParameters_3_0= ruleJvmFormalParameter )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2418:3: lv_formalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXShortClosureAccess().getFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5881);
                    	    lv_formalParameters_3_0=ruleJvmFormalParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXShortClosureRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"formalParameters",
                    	              		lv_formalParameters_3_0, 
                    	              		"JvmFormalParameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,42,FOLLOW_42_in_ruleXShortClosure5897); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXShortClosureAccess().getVerticalLineKeyword_0_0_2());
                  
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2438:3: ( (lv_expression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2439:1: (lv_expression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2439:1: (lv_expression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2440:3: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXShortClosureAccess().getExpressionXExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXShortClosure5920);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2464:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXParenthesizedExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2465:2: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2466:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression5956);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression5966); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2473:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2476:28: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2477:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2477:1: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2477:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleXParenthesizedExpression6003); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression6025);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XExpression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleXParenthesizedExpression6036); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2502:1: entryRuleXIfExpression returns [EObject current=null] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIfExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2503:2: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2504:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIfExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression6072);
            iv_ruleXIfExpression=ruleXIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIfExpression6082); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2511:1: ruleXIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) ;
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2514:28: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2515:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2515:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2515:2: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2515:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2516:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,44,FOLLOW_44_in_ruleXIfExpression6128); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getIfKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleXIfExpression6140); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2529:1: ( (lv_if_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2530:1: (lv_if_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2530:1: (lv_if_3_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2531:3: lv_if_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6161);
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

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleXIfExpression6173); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2551:1: ( (lv_then_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2552:1: (lv_then_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2552:1: (lv_then_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2553:3: lv_then_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6194);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2569:2: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==45) ) {
                int LA38_1 = input.LA(2);

                if ( (synpred17_InternalXbaseWithAnnotations()) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2569:3: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2569:3: ( ( 'else' )=>otherlv_6= 'else' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2569:4: ( 'else' )=>otherlv_6= 'else'
                    {
                    otherlv_6=(Token)match(input,45,FOLLOW_45_in_ruleXIfExpression6215); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2574:2: ( (lv_else_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2575:1: (lv_else_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2575:1: (lv_else_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2576:3: lv_else_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXIfExpression6237);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2600:1: entryRuleXSwitchExpression returns [EObject current=null] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSwitchExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2601:2: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2602:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXSwitchExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression6275);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSwitchExpression6285); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2609:1: ruleXSwitchExpression returns [EObject current=null] : ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' ( (otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) ) | ( (lv_default_10_0= ruleXMustacheExpression ) ) ) )? otherlv_11= '}' ) ;
    public final EObject ruleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_localVarName_2_0 = null;

        EObject lv_switch_4_0 = null;

        EObject lv_cases_6_0 = null;

        EObject lv_default_9_0 = null;

        EObject lv_default_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2612:28: ( ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' ( (otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) ) | ( (lv_default_10_0= ruleXMustacheExpression ) ) ) )? otherlv_11= '}' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2613:1: ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' ( (otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) ) | ( (lv_default_10_0= ruleXMustacheExpression ) ) ) )? otherlv_11= '}' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2613:1: ( () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' ( (otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) ) | ( (lv_default_10_0= ruleXMustacheExpression ) ) ) )? otherlv_11= '}' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2613:2: () otherlv_1= 'switch' ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )? ( (lv_switch_4_0= ruleXExpression ) ) otherlv_5= '{' ( (lv_cases_6_0= ruleXCasePart ) )+ (otherlv_7= 'default' ( (otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) ) | ( (lv_default_10_0= ruleXMustacheExpression ) ) ) )? otherlv_11= '}'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2613:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2614:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,46,FOLLOW_46_in_ruleXSwitchExpression6331); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2623:1: ( ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_ID) ) {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==47) && (synpred18_InternalXbaseWithAnnotations())) {
                    alt39=1;
                }
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2623:2: ( ( ( ( ruleValidID ) ) ':' ) )=> ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2628:5: ( ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2628:6: ( (lv_localVarName_2_0= ruleValidID ) ) otherlv_3= ':'
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2628:6: ( (lv_localVarName_2_0= ruleValidID ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2629:1: (lv_localVarName_2_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2629:1: (lv_localVarName_2_0= ruleValidID )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2630:3: lv_localVarName_2_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getLocalVarNameValidIDParserRuleCall_2_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXSwitchExpression6372);
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

                    otherlv_3=(Token)match(input,47,FOLLOW_47_in_ruleXSwitchExpression6384); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_0_1());
                          
                    }

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2650:4: ( (lv_switch_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2651:1: (lv_switch_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2651:1: (lv_switch_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2652:3: lv_switch_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6408);
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

            otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleXSwitchExpression6420); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2672:1: ( (lv_cases_6_0= ruleXCasePart ) )+
            int cnt40=0;
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==RULE_ID||LA40_0==12||LA40_0==47||LA40_0==49||(LA40_0>=68 && LA40_0<=69)) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2673:1: (lv_cases_6_0= ruleXCasePart )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2673:1: (lv_cases_6_0= ruleXCasePart )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2674:3: lv_cases_6_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6441);
            	    lv_cases_6_0=ruleXCasePart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"cases",
            	              		lv_cases_6_0, 
            	              		"XCasePart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt40 >= 1 ) break loop40;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(40, input);
                        throw eee;
                }
                cnt40++;
            } while (true);

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2690:3: (otherlv_7= 'default' ( (otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) ) | ( (lv_default_10_0= ruleXMustacheExpression ) ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==48) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2690:5: otherlv_7= 'default' ( (otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) ) | ( (lv_default_10_0= ruleXMustacheExpression ) ) )
                    {
                    otherlv_7=(Token)match(input,48,FOLLOW_48_in_ruleXSwitchExpression6455); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_6_0());
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2694:1: ( (otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) ) | ( (lv_default_10_0= ruleXMustacheExpression ) ) )
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==47) ) {
                        alt41=1;
                    }
                    else if ( (LA41_0==68) ) {
                        alt41=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 41, 0, input);

                        throw nvae;
                    }
                    switch (alt41) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2694:2: (otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2694:2: (otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2694:4: otherlv_8= ':' ( (lv_default_9_0= ruleXExpression ) )
                            {
                            otherlv_8=(Token)match(input,47,FOLLOW_47_in_ruleXSwitchExpression6469); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_8, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_6_1_0_0());
                                  
                            }
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2698:1: ( (lv_default_9_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2699:1: (lv_default_9_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2699:1: (lv_default_9_0= ruleXExpression )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2700:3: lv_default_9_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_6_1_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXSwitchExpression6490);
                            lv_default_9_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"default",
                                      		lv_default_9_0, 
                                      		"XExpression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2717:6: ( (lv_default_10_0= ruleXMustacheExpression ) )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2717:6: ( (lv_default_10_0= ruleXMustacheExpression ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2718:1: (lv_default_10_0= ruleXMustacheExpression )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2718:1: (lv_default_10_0= ruleXMustacheExpression )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2719:3: lv_default_10_0= ruleXMustacheExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXMustacheExpressionParserRuleCall_6_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXMustacheExpression_in_ruleXSwitchExpression6518);
                            lv_default_10_0=ruleXMustacheExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"default",
                                      		lv_default_10_0, 
                                      		"XMustacheExpression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,18,FOLLOW_18_in_ruleXSwitchExpression6533); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getXSwitchExpressionAccess().getRightCurlyBracketKeyword_7());
                  
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2747:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCasePart = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2748:2: (iv_ruleXCasePart= ruleXCasePart EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2749:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCasePartRule()); 
            }
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart6569);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart6579); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2756:1: ruleXCasePart returns [EObject current=null] : ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? ( (otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) | ( (lv_then_5_0= ruleXMustacheExpression ) ) ) ) ;
    public final EObject ruleXCasePart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_typeGuard_0_0 = null;

        EObject lv_case_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject lv_then_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2759:28: ( ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? ( (otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) | ( (lv_then_5_0= ruleXMustacheExpression ) ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2760:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? ( (otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) | ( (lv_then_5_0= ruleXMustacheExpression ) ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2760:1: ( ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? ( (otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) | ( (lv_then_5_0= ruleXMustacheExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2760:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )? (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )? ( (otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) | ( (lv_then_5_0= ruleXMustacheExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2760:2: ( (lv_typeGuard_0_0= ruleJvmTypeReference ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_ID||LA43_0==12||LA43_0==69) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2761:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2761:1: (lv_typeGuard_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2762:3: lv_typeGuard_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6625);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2778:3: (otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==49) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2778:5: otherlv_1= 'case' ( (lv_case_2_0= ruleXExpression ) )
                    {
                    otherlv_1=(Token)match(input,49,FOLLOW_49_in_ruleXCasePart6639); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXCasePartAccess().getCaseKeyword_1_0());
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2782:1: ( (lv_case_2_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2783:1: (lv_case_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2783:1: (lv_case_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2784:3: lv_case_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6660);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2800:4: ( (otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) ) | ( (lv_then_5_0= ruleXMustacheExpression ) ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==47) ) {
                alt45=1;
            }
            else if ( (LA45_0==68) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2800:5: (otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2800:5: (otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2800:7: otherlv_3= ':' ( (lv_then_4_0= ruleXExpression ) )
                    {
                    otherlv_3=(Token)match(input,47,FOLLOW_47_in_ruleXCasePart6676); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXCasePartAccess().getColonKeyword_2_0_0());
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2804:1: ( (lv_then_4_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2805:1: (lv_then_4_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2805:1: (lv_then_4_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2806:3: lv_then_4_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_2_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXCasePart6697);
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
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2823:6: ( (lv_then_5_0= ruleXMustacheExpression ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2823:6: ( (lv_then_5_0= ruleXMustacheExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2824:1: (lv_then_5_0= ruleXMustacheExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2824:1: (lv_then_5_0= ruleXMustacheExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2825:3: lv_then_5_0= ruleXMustacheExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXCasePartAccess().getThenXMustacheExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXMustacheExpression_in_ruleXCasePart6725);
                    lv_then_5_0=ruleXMustacheExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXCasePartRule());
                      	        }
                             		set(
                             			current, 
                             			"then",
                              		lv_then_5_0, 
                              		"XMustacheExpression");
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
    // $ANTLR end "ruleXCasePart"


    // $ANTLR start "entryRuleXForLoopExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2849:1: entryRuleXForLoopExpression returns [EObject current=null] : iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
    public final EObject entryRuleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXForLoopExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2850:2: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2851:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXForLoopExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6762);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXForLoopExpression6772); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2858:1: ruleXForLoopExpression returns [EObject current=null] : ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) ;
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2861:28: ( ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2862:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2862:1: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2862:2: () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2862:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2863:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,50,FOLLOW_50_in_ruleXForLoopExpression6818); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getForKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleXForLoopExpression6830); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2876:1: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2877:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2877:1: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2878:3: lv_declaredParam_3_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression6851);
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

            otherlv_4=(Token)match(input,47,FOLLOW_47_in_ruleXForLoopExpression6863); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2898:1: ( (lv_forExpression_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2899:1: (lv_forExpression_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2899:1: (lv_forExpression_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2900:3: lv_forExpression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression6884);
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

            otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleXForLoopExpression6896); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_6());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2920:1: ( (lv_eachExpression_7_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2921:1: (lv_eachExpression_7_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2921:1: (lv_eachExpression_7_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2922:3: lv_eachExpression_7_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXForLoopExpression6917);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2946:1: entryRuleXWhileExpression returns [EObject current=null] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWhileExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2947:2: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2948:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression6953);
            iv_ruleXWhileExpression=ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWhileExpression6963); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2955:1: ruleXWhileExpression returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_predicate_3_0 = null;

        EObject lv_body_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2958:28: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2959:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2959:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2959:2: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2959:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2960:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,51,FOLLOW_51_in_ruleXWhileExpression7009); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleXWhileExpression7021); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2973:1: ( (lv_predicate_3_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2974:1: (lv_predicate_3_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2974:1: (lv_predicate_3_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2975:3: lv_predicate_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression7042);
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

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleXWhileExpression7054); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2995:1: ( (lv_body_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2996:1: (lv_body_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2996:1: (lv_body_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2997:3: lv_body_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXWhileExpression7075);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3021:1: entryRuleXDoWhileExpression returns [EObject current=null] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDoWhileExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3022:2: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3023:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXDoWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression7111);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXDoWhileExpression7121); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3030:1: ruleXDoWhileExpression returns [EObject current=null] : ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) ;
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3033:28: ( ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3034:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3034:1: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3034:2: () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3034:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3035:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,52,FOLLOW_52_in_ruleXDoWhileExpression7167); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3044:1: ( (lv_body_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3045:1: (lv_body_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3045:1: (lv_body_2_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3046:3: lv_body_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7188);
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

            otherlv_3=(Token)match(input,51,FOLLOW_51_in_ruleXDoWhileExpression7200); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,12,FOLLOW_12_in_ruleXDoWhileExpression7212); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3070:1: ( (lv_predicate_5_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3071:1: (lv_predicate_5_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3071:1: (lv_predicate_5_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3072:3: lv_predicate_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7233);
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

            otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleXDoWhileExpression7245); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3100:1: entryRuleXBlockExpression returns [EObject current=null] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBlockExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3101:2: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3102:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression7281);
            iv_ruleXBlockExpression=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBlockExpression7291); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3109:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3112:28: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3113:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3113:1: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3113:2: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3113:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3114:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleXBlockExpression7337); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3123:1: ( ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )? )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( ((LA47_0>=RULE_INT && LA47_0<=RULE_ID)||LA47_0==12||(LA47_0>=16 && LA47_0<=17)||LA47_0==28||LA47_0==31||LA47_0==36||LA47_0==41||LA47_0==44||(LA47_0>=46 && LA47_0<=47)||(LA47_0>=50 && LA47_0<=52)||(LA47_0>=54 && LA47_0<=56)||(LA47_0>=58 && LA47_0<=65)||LA47_0==68) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3123:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) ) (otherlv_3= ';' )?
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3123:2: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3124:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3124:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3125:3: lv_expressions_2_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression7359);
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

            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3141:2: (otherlv_3= ';' )?
            	    int alt46=2;
            	    int LA46_0 = input.LA(1);

            	    if ( (LA46_0==53) ) {
            	        alt46=1;
            	    }
            	    switch (alt46) {
            	        case 1 :
            	            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3141:4: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,53,FOLLOW_53_in_ruleXBlockExpression7372); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleXBlockExpression7388); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3157:1: entryRuleXExpressionInsideBlock returns [EObject current=null] : iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF ;
    public final EObject entryRuleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInsideBlock = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3158:2: (iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3159:2: iv_ruleXExpressionInsideBlock= ruleXExpressionInsideBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInsideBlockRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock7424);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock7434); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3166:1: ruleXExpressionInsideBlock returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;

        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3169:28: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3170:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3170:1: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( ((LA48_0>=54 && LA48_0<=55)) ) {
                alt48=1;
            }
            else if ( ((LA48_0>=RULE_INT && LA48_0<=RULE_ID)||LA48_0==12||(LA48_0>=16 && LA48_0<=17)||LA48_0==28||LA48_0==31||LA48_0==36||LA48_0==41||LA48_0==44||(LA48_0>=46 && LA48_0<=47)||(LA48_0>=50 && LA48_0<=52)||LA48_0==56||(LA48_0>=58 && LA48_0<=65)||LA48_0==68) ) {
                alt48=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3171:5: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXVariableDeclarationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7481);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3181:5: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getXExpressionInsideBlockAccess().getXExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7508);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3197:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXVariableDeclaration = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3198:2: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3199:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7543);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXVariableDeclaration7553); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3206:1: ruleXVariableDeclaration returns [EObject current=null] : ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) ;
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3209:28: ( ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3210:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3210:1: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3210:2: () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3210:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3211:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXVariableDeclarationAccess().getXVariableDeclarationAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3216:2: ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==54) ) {
                alt49=1;
            }
            else if ( (LA49_0==55) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3216:3: ( (lv_writeable_1_0= 'var' ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3216:3: ( (lv_writeable_1_0= 'var' ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3217:1: (lv_writeable_1_0= 'var' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3217:1: (lv_writeable_1_0= 'var' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3218:3: lv_writeable_1_0= 'var'
                    {
                    lv_writeable_1_0=(Token)match(input,54,FOLLOW_54_in_ruleXVariableDeclaration7606); if (state.failed) return current;
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3232:7: otherlv_2= 'val'
                    {
                    otherlv_2=(Token)match(input,55,FOLLOW_55_in_ruleXVariableDeclaration7637); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXVariableDeclarationAccess().getValKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3236:2: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_ID) ) {
                int LA50_1 = input.LA(2);

                if ( (synpred19_InternalXbaseWithAnnotations()) ) {
                    alt50=1;
                }
                else if ( (true) ) {
                    alt50=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 50, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA50_0==12) && (synpred19_InternalXbaseWithAnnotations())) {
                alt50=1;
            }
            else if ( (LA50_0==69) && (synpred19_InternalXbaseWithAnnotations())) {
                alt50=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3236:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3236:3: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3236:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3244:6: ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3244:7: ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3244:7: ( (lv_type_3_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3245:1: (lv_type_3_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3245:1: (lv_type_3_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3246:3: lv_type_3_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7685);
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

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3262:2: ( (lv_name_4_0= ruleValidID ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3263:1: (lv_name_4_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3263:1: (lv_name_4_0= ruleValidID )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3264:3: lv_name_4_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration7706);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3281:6: ( (lv_name_5_0= ruleValidID ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3281:6: ( (lv_name_5_0= ruleValidID ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3282:1: (lv_name_5_0= ruleValidID )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3282:1: (lv_name_5_0= ruleValidID )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3283:3: lv_name_5_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleXVariableDeclaration7735);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3299:3: (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==15) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3299:5: otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleXVariableDeclaration7749); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3303:1: ( (lv_right_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3304:1: (lv_right_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3304:1: (lv_right_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3305:3: lv_right_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7770);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3329:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameter = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3330:2: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3331:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7808);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameter7818); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3338:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3341:28: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3342:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3342:1: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3342:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3342:2: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_ID) ) {
                int LA52_1 = input.LA(2);

                if ( (LA52_1==RULE_ID||LA52_1==28||LA52_1==38||LA52_1==41) ) {
                    alt52=1;
                }
            }
            else if ( (LA52_0==12||LA52_0==69) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3343:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3343:1: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3344:3: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter7864);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3360:3: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3361:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3361:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3362:3: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleJvmFormalParameter7886);
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


    // $ANTLR start "entryRuleXFeatureCall"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3386:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFeatureCall = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3387:2: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3388:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall7922);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall7932); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3395:1: ruleXFeatureCall returns [EObject current=null] : ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ) ;
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


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3398:28: ( ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3399:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3399:1: ( () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3399:2: () ( ( ruleStaticQualifier ) )? (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3399:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3400:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3405:2: ( ( ruleStaticQualifier ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_ID) ) {
                int LA53_1 = input.LA(2);

                if ( (LA53_1==57) ) {
                    alt53=1;
                }
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3406:1: ( ruleStaticQualifier )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3406:1: ( ruleStaticQualifier )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3407:3: ruleStaticQualifier
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getXFeatureCallRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getDeclaringTypeJvmDeclaredTypeCrossReference_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall7989);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3420:3: (otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==28) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3420:5: otherlv_2= '<' ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) ) (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleXFeatureCall8003); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_2_0());
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3424:1: ( (lv_typeArguments_3_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3425:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3425:1: (lv_typeArguments_3_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3426:3: lv_typeArguments_3_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8024);
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

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3442:2: (otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) ) )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==13) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3442:4: otherlv_4= ',' ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleXFeatureCall8037); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getXFeatureCallAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3446:1: ( (lv_typeArguments_5_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3447:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3447:1: (lv_typeArguments_5_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3448:3: lv_typeArguments_5_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8058);
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
                    	    break loop54;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,27,FOLLOW_27_in_ruleXFeatureCall8072); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_2_3());
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3468:3: ( ( ruleIdOrSuper ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3469:1: ( ruleIdOrSuper )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3469:1: ( ruleIdOrSuper )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3470:3: ruleIdOrSuper
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXFeatureCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall8097);
            ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3483:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            int alt58=2;
            alt58 = dfa58.predict(input);
            switch (alt58) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3483:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3483:3: ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3483:4: ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3490:1: (lv_explicitOperationCall_8_0= '(' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3491:3: lv_explicitOperationCall_8_0= '('
                    {
                    lv_explicitOperationCall_8_0=(Token)match(input,12,FOLLOW_12_in_ruleXFeatureCall8131); if (state.failed) return current;
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

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3504:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?
                    int alt57=3;
                    alt57 = dfa57.predict(input);
                    switch (alt57) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3504:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3504:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3504:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3516:1: (lv_featureCallArguments_9_0= ruleXShortClosure )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3517:3: lv_featureCallArguments_9_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_4_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXShortClosure_in_ruleXFeatureCall8206);
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
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3534:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3534:6: ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3534:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3534:7: ( (lv_featureCallArguments_10_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3535:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3535:1: (lv_featureCallArguments_10_0= ruleXExpression )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3536:3: lv_featureCallArguments_10_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall8234);
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

                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3552:2: (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )*
                            loop56:
                            do {
                                int alt56=2;
                                int LA56_0 = input.LA(1);

                                if ( (LA56_0==13) ) {
                                    alt56=1;
                                }


                                switch (alt56) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3552:4: otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    {
                            	    otherlv_11=(Token)match(input,13,FOLLOW_13_in_ruleXFeatureCall8247); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_11, grammarAccess.getXFeatureCallAccess().getCommaKeyword_4_1_1_1_0());
                            	          
                            	    }
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3556:1: ( (lv_featureCallArguments_12_0= ruleXExpression ) )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3557:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    {
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3557:1: (lv_featureCallArguments_12_0= ruleXExpression )
                            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3558:3: lv_featureCallArguments_12_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXExpression_in_ruleXFeatureCall8268);
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
                            	    break loop56;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,14,FOLLOW_14_in_ruleXFeatureCall8285); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_4_2());
                          
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3586:1: entryRuleIdOrSuper returns [String current=null] : iv_ruleIdOrSuper= ruleIdOrSuper EOF ;
    public final String entryRuleIdOrSuper() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrSuper = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3587:2: (iv_ruleIdOrSuper= ruleIdOrSuper EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3588:2: iv_ruleIdOrSuper= ruleIdOrSuper EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrSuperRule()); 
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper8324);
            iv_ruleIdOrSuper=ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrSuper.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdOrSuper8335); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3595:1: ruleIdOrSuper returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID | kw= 'super' ) ;
    public final AntlrDatatypeRuleToken ruleIdOrSuper() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3598:28: ( (this_ValidID_0= ruleValidID | kw= 'super' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3599:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3599:1: (this_ValidID_0= ruleValidID | kw= 'super' )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_ID) ) {
                alt59=1;
            }
            else if ( (LA59_0==56) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3600:5: this_ValidID_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIdOrSuperAccess().getValidIDParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleValidID_in_ruleIdOrSuper8382);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3612:2: kw= 'super'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleIdOrSuper8406); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3625:1: entryRuleStaticQualifier returns [String current=null] : iv_ruleStaticQualifier= ruleStaticQualifier EOF ;
    public final String entryRuleStaticQualifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStaticQualifier = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3626:2: (iv_ruleStaticQualifier= ruleStaticQualifier EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3627:2: iv_ruleStaticQualifier= ruleStaticQualifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStaticQualifierRule()); 
            }
            pushFollow(FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier8447);
            iv_ruleStaticQualifier=ruleStaticQualifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStaticQualifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStaticQualifier8458); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3634:1: ruleStaticQualifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID kw= '::' )+ ;
    public final AntlrDatatypeRuleToken ruleStaticQualifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3637:28: ( (this_ValidID_0= ruleValidID kw= '::' )+ )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3638:1: (this_ValidID_0= ruleValidID kw= '::' )+
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3638:1: (this_ValidID_0= ruleValidID kw= '::' )+
            int cnt60=0;
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==RULE_ID) ) {
                    int LA60_1 = input.LA(2);

                    if ( (LA60_1==57) ) {
                        alt60=1;
                    }


                }


                switch (alt60) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3639:5: this_ValidID_0= ruleValidID kw= '::'
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getStaticQualifierAccess().getValidIDParserRuleCall_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleStaticQualifier8505);
            	    this_ValidID_0=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }
            	    kw=(Token)match(input,57,FOLLOW_57_in_ruleStaticQualifier8523); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getStaticQualifierAccess().getColonColonKeyword_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt60 >= 1 ) break loop60;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(60, input);
                        throw eee;
                }
                cnt60++;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3663:1: entryRuleXConstructorCall returns [EObject current=null] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstructorCall = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3664:2: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3665:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXConstructorCallRule()); 
            }
            pushFollow(FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8564);
            iv_ruleXConstructorCall=ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXConstructorCall8574); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3672:1: ruleXConstructorCall returns [EObject current=null] : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ) ;
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


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3675:28: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3676:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3676:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3676:2: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3676:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3677:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXConstructorCallAccess().getXConstructorCallAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,58,FOLLOW_58_in_ruleXConstructorCall8620); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXConstructorCallAccess().getNewKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3686:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3687:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3687:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3688:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXConstructorCallRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8643);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3701:2: (otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==28) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3701:4: otherlv_3= '<' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
                    {
                    otherlv_3=(Token)match(input,28,FOLLOW_28_in_ruleXConstructorCall8656); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXConstructorCallAccess().getLessThanSignKeyword_3_0());
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3705:1: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3706:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3706:1: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3707:3: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8677);
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

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3723:2: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==13) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3723:4: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleXConstructorCall8690); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getXConstructorCallAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3727:1: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3728:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3728:1: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3729:3: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8711);
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
                    	    break loop61;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,27,FOLLOW_27_in_ruleXConstructorCall8725); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXConstructorCallAccess().getGreaterThanSignKeyword_3_3());
                          
                    }

                    }
                    break;

            }

            otherlv_8=(Token)match(input,12,FOLLOW_12_in_ruleXConstructorCall8739); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3753:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?
            int alt64=3;
            alt64 = dfa64.predict(input);
            switch (alt64) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3753:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3753:2: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3753:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3765:1: (lv_arguments_9_0= ruleXShortClosure )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3766:3: lv_arguments_9_0= ruleXShortClosure
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXShortClosureParserRuleCall_5_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXShortClosure_in_ruleXConstructorCall8801);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3783:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3783:6: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3783:7: ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3783:7: ( (lv_arguments_10_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3784:1: (lv_arguments_10_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3784:1: (lv_arguments_10_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3785:3: lv_arguments_10_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_5_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall8829);
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

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3801:2: (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==13) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3801:4: otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) )
                    	    {
                    	    otherlv_11=(Token)match(input,13,FOLLOW_13_in_ruleXConstructorCall8842); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_11, grammarAccess.getXConstructorCallAccess().getCommaKeyword_5_1_1_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3805:1: ( (lv_arguments_12_0= ruleXExpression ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3806:1: (lv_arguments_12_0= ruleXExpression )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3806:1: (lv_arguments_12_0= ruleXExpression )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3807:3: lv_arguments_12_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_5_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXExpression_in_ruleXConstructorCall8863);
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
                    	    break loop63;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,14,FOLLOW_14_in_ruleXConstructorCall8880); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_6());
                  
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3835:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBooleanLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3836:2: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3837:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral8916);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral8926); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3844:1: ruleXBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3847:28: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3848:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3848:1: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3848:2: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3848:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3849:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3854:2: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==59) ) {
                alt65=1;
            }
            else if ( (LA65_0==60) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3854:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,59,FOLLOW_59_in_ruleXBooleanLiteral8973); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3859:6: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3859:6: ( (lv_isTrue_2_0= 'true' ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3860:1: (lv_isTrue_2_0= 'true' )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3860:1: (lv_isTrue_2_0= 'true' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3861:3: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,60,FOLLOW_60_in_ruleXBooleanLiteral8997); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3882:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNullLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3883:2: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3884:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNullLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral9047);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral9057); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3891:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3894:28: ( ( () otherlv_1= 'null' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3895:1: ( () otherlv_1= 'null' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3895:1: ( () otherlv_1= 'null' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3895:2: () otherlv_1= 'null'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3895:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3896:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,61,FOLLOW_61_in_ruleXNullLiteral9103); if (state.failed) return current;
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


    // $ANTLR start "entryRuleXIntLiteral"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3913:1: entryRuleXIntLiteral returns [EObject current=null] : iv_ruleXIntLiteral= ruleXIntLiteral EOF ;
    public final EObject entryRuleXIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIntLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3914:2: (iv_ruleXIntLiteral= ruleXIntLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3915:2: iv_ruleXIntLiteral= ruleXIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIntLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral9139);
            iv_ruleXIntLiteral=ruleXIntLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIntLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIntLiteral9149); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXIntLiteral"


    // $ANTLR start "ruleXIntLiteral"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3922:1: ruleXIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleXIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3925:28: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3926:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3926:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3926:2: () ( (lv_value_1_0= RULE_INT ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3926:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3927:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXIntLiteralAccess().getXIntLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3932:2: ( (lv_value_1_0= RULE_INT ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3933:1: (lv_value_1_0= RULE_INT )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3933:1: (lv_value_1_0= RULE_INT )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3934:3: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleXIntLiteral9200); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getXIntLiteralAccess().getValueINTTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getXIntLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"INT");
              	    
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
    // $ANTLR end "ruleXIntLiteral"


    // $ANTLR start "entryRuleXStringLiteral"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3958:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXStringLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3959:2: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3960:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXStringLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral9241);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXStringLiteral9251); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3967:1: ruleXStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3970:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3971:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3971:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3971:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3971:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3972:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXStringLiteralAccess().getXStringLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3977:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3978:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3978:1: (lv_value_1_0= RULE_STRING )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3979:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXStringLiteral9302); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4003:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeLiteral = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4004:2: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4005:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTypeLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral9343);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral9353); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4012:1: ruleXTypeLiteral returns [EObject current=null] : ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4015:28: ( ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4016:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4016:1: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4016:2: () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) otherlv_4= ')'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4016:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4017:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTypeLiteralAccess().getXTypeLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,62,FOLLOW_62_in_ruleXTypeLiteral9399); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getTypeofKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleXTypeLiteral9411); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXTypeLiteralAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4030:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4031:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4031:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4032:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXTypeLiteralRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral9434);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleXTypeLiteral9446); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4057:1: entryRuleXThrowExpression returns [EObject current=null] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final EObject entryRuleXThrowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXThrowExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4058:2: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4059:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXThrowExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression9482);
            iv_ruleXThrowExpression=ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXThrowExpression9492); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4066:1: ruleXThrowExpression returns [EObject current=null] : ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) ;
    public final EObject ruleXThrowExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4069:28: ( ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4070:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4070:1: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4070:2: () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4070:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4071:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,63,FOLLOW_63_in_ruleXThrowExpression9538); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4080:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4081:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4081:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4082:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXThrowExpression9559);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4106:1: entryRuleXReturnExpression returns [EObject current=null] : iv_ruleXReturnExpression= ruleXReturnExpression EOF ;
    public final EObject entryRuleXReturnExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXReturnExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4107:2: (iv_ruleXReturnExpression= ruleXReturnExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4108:2: iv_ruleXReturnExpression= ruleXReturnExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXReturnExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression9595);
            iv_ruleXReturnExpression=ruleXReturnExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXReturnExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXReturnExpression9605); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4115:1: ruleXReturnExpression returns [EObject current=null] : ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? ) ;
    public final EObject ruleXReturnExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4118:28: ( ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4119:1: ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4119:1: ( () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4119:2: () otherlv_1= 'return' ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4119:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4120:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXReturnExpressionAccess().getXReturnExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,64,FOLLOW_64_in_ruleXReturnExpression9651); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4129:1: ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?
            int alt66=2;
            alt66 = dfa66.predict(input);
            switch (alt66) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4129:2: ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4134:1: (lv_expression_2_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4135:3: lv_expression_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXReturnExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXReturnExpression9682);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4159:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTryCatchFinallyExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4160:2: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4161:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression9719);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression9729); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4168:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) ;
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4171:28: ( ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4172:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4172:1: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4172:2: () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4172:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4173:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,65,FOLLOW_65_in_ruleXTryCatchFinallyExpression9775); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4182:1: ( (lv_expression_2_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4183:1: (lv_expression_2_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4183:1: (lv_expression_2_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4184:3: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9796);
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

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4200:2: ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==67) ) {
                alt69=1;
            }
            else if ( (LA69_0==66) ) {
                alt69=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4200:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4200:3: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4200:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4200:4: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+
                    int cnt67=0;
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==67) ) {
                            int LA67_2 = input.LA(2);

                            if ( (synpred24_InternalXbaseWithAnnotations()) ) {
                                alt67=1;
                            }


                        }


                        switch (alt67) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4200:5: ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4202:1: (lv_catchClauses_3_0= ruleXCatchClause )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4203:3: lv_catchClauses_3_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_3_0_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression9826);
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
                    	    if ( cnt67 >= 1 ) break loop67;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(67, input);
                                throw eee;
                        }
                        cnt67++;
                    } while (true);

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4219:3: ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==66) ) {
                        int LA68_1 = input.LA(2);

                        if ( (synpred25_InternalXbaseWithAnnotations()) ) {
                            alt68=1;
                        }
                    }
                    switch (alt68) {
                        case 1 :
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4219:4: ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4219:4: ( ( 'finally' )=>otherlv_4= 'finally' )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4219:5: ( 'finally' )=>otherlv_4= 'finally'
                            {
                            otherlv_4=(Token)match(input,66,FOLLOW_66_in_ruleXTryCatchFinallyExpression9848); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_0_1_0());
                                  
                            }

                            }

                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4224:2: ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4225:1: (lv_finallyExpression_5_0= ruleXExpression )
                            {
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4225:1: (lv_finallyExpression_5_0= ruleXExpression )
                            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4226:3: lv_finallyExpression_5_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9870);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4243:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4243:6: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4243:8: otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,66,FOLLOW_66_in_ruleXTryCatchFinallyExpression9892); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_1_0());
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4247:1: ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4248:1: (lv_finallyExpression_7_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4248:1: (lv_finallyExpression_7_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4249:3: lv_finallyExpression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9913);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4273:1: entryRuleXCatchClause returns [EObject current=null] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCatchClause = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4274:2: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4275:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCatchClauseRule()); 
            }
            pushFollow(FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause9951);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCatchClause9961); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4282:1: ruleXCatchClause returns [EObject current=null] : ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4285:28: ( ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4286:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4286:1: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4286:2: ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4286:2: ( ( 'catch' )=>otherlv_0= 'catch' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4286:3: ( 'catch' )=>otherlv_0= 'catch'
            {
            otherlv_0=(Token)match(input,67,FOLLOW_67_in_ruleXCatchClause10006); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0());
                  
            }

            }

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleXCatchClause10019); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4295:1: ( (lv_declaredParam_2_0= ruleJvmFormalParameter ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4296:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4296:1: (lv_declaredParam_2_0= ruleJvmFormalParameter )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4297:3: lv_declaredParam_2_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_ruleXCatchClause10040);
            lv_declaredParam_2_0=ruleJvmFormalParameter();

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
                      		"JvmFormalParameter");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleXCatchClause10052); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4317:1: ( (lv_expression_4_0= ruleXExpression ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4318:1: (lv_expression_4_0= ruleXExpression )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4318:1: (lv_expression_4_0= ruleXExpression )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4319:3: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleXExpression_in_ruleXCatchClause10073);
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


    // $ANTLR start "entryRuleXWithExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4343:1: entryRuleXWithExpression returns [EObject current=null] : iv_ruleXWithExpression= ruleXWithExpression EOF ;
    public final EObject entryRuleXWithExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWithExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4344:2: (iv_ruleXWithExpression= ruleXWithExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4345:2: iv_ruleXWithExpression= ruleXWithExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXWithExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXWithExpression_in_entryRuleXWithExpression10109);
            iv_ruleXWithExpression=ruleXWithExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWithExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWithExpression10119); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXWithExpression"


    // $ANTLR start "ruleXWithExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4352:1: ruleXWithExpression returns [EObject current=null] : ( () (otherlv_1= ':' ( (lv_variable_2_0= ruleJvmFormalParameterWithoutType ) ) )? ( (otherlv_3= ':' ( (lv_mainExpression_4_0= ruleXExpression ) ) ( (lv_blockExpression_5_0= ruleXBlockExpression ) ) ) | ( (lv_blockExpression_6_0= ruleXMustacheExpression ) ) ) ) ;
    public final EObject ruleXWithExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_variable_2_0 = null;

        EObject lv_mainExpression_4_0 = null;

        EObject lv_blockExpression_5_0 = null;

        EObject lv_blockExpression_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4355:28: ( ( () (otherlv_1= ':' ( (lv_variable_2_0= ruleJvmFormalParameterWithoutType ) ) )? ( (otherlv_3= ':' ( (lv_mainExpression_4_0= ruleXExpression ) ) ( (lv_blockExpression_5_0= ruleXBlockExpression ) ) ) | ( (lv_blockExpression_6_0= ruleXMustacheExpression ) ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4356:1: ( () (otherlv_1= ':' ( (lv_variable_2_0= ruleJvmFormalParameterWithoutType ) ) )? ( (otherlv_3= ':' ( (lv_mainExpression_4_0= ruleXExpression ) ) ( (lv_blockExpression_5_0= ruleXBlockExpression ) ) ) | ( (lv_blockExpression_6_0= ruleXMustacheExpression ) ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4356:1: ( () (otherlv_1= ':' ( (lv_variable_2_0= ruleJvmFormalParameterWithoutType ) ) )? ( (otherlv_3= ':' ( (lv_mainExpression_4_0= ruleXExpression ) ) ( (lv_blockExpression_5_0= ruleXBlockExpression ) ) ) | ( (lv_blockExpression_6_0= ruleXMustacheExpression ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4356:2: () (otherlv_1= ':' ( (lv_variable_2_0= ruleJvmFormalParameterWithoutType ) ) )? ( (otherlv_3= ':' ( (lv_mainExpression_4_0= ruleXExpression ) ) ( (lv_blockExpression_5_0= ruleXBlockExpression ) ) ) | ( (lv_blockExpression_6_0= ruleXMustacheExpression ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4356:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4357:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXWithExpressionAccess().getXWithExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4362:2: (otherlv_1= ':' ( (lv_variable_2_0= ruleJvmFormalParameterWithoutType ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==47) ) {
                int LA70_1 = input.LA(2);

                if ( (LA70_1==RULE_ID) ) {
                    int LA70_3 = input.LA(3);

                    if ( (LA70_3==47||LA70_3==68) ) {
                        alt70=1;
                    }
                }
            }
            switch (alt70) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4362:4: otherlv_1= ':' ( (lv_variable_2_0= ruleJvmFormalParameterWithoutType ) )
                    {
                    otherlv_1=(Token)match(input,47,FOLLOW_47_in_ruleXWithExpression10166); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXWithExpressionAccess().getColonKeyword_1_0());
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4366:1: ( (lv_variable_2_0= ruleJvmFormalParameterWithoutType ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4367:1: (lv_variable_2_0= ruleJvmFormalParameterWithoutType )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4367:1: (lv_variable_2_0= ruleJvmFormalParameterWithoutType )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4368:3: lv_variable_2_0= ruleJvmFormalParameterWithoutType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXWithExpressionAccess().getVariableJvmFormalParameterWithoutTypeParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmFormalParameterWithoutType_in_ruleXWithExpression10187);
                    lv_variable_2_0=ruleJvmFormalParameterWithoutType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXWithExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"variable",
                              		lv_variable_2_0, 
                              		"JvmFormalParameterWithoutType");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4384:4: ( (otherlv_3= ':' ( (lv_mainExpression_4_0= ruleXExpression ) ) ( (lv_blockExpression_5_0= ruleXBlockExpression ) ) ) | ( (lv_blockExpression_6_0= ruleXMustacheExpression ) ) )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==47) ) {
                alt71=1;
            }
            else if ( (LA71_0==68) ) {
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4384:5: (otherlv_3= ':' ( (lv_mainExpression_4_0= ruleXExpression ) ) ( (lv_blockExpression_5_0= ruleXBlockExpression ) ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4384:5: (otherlv_3= ':' ( (lv_mainExpression_4_0= ruleXExpression ) ) ( (lv_blockExpression_5_0= ruleXBlockExpression ) ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4384:7: otherlv_3= ':' ( (lv_mainExpression_4_0= ruleXExpression ) ) ( (lv_blockExpression_5_0= ruleXBlockExpression ) )
                    {
                    otherlv_3=(Token)match(input,47,FOLLOW_47_in_ruleXWithExpression10203); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getXWithExpressionAccess().getColonKeyword_2_0_0());
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4388:1: ( (lv_mainExpression_4_0= ruleXExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4389:1: (lv_mainExpression_4_0= ruleXExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4389:1: (lv_mainExpression_4_0= ruleXExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4390:3: lv_mainExpression_4_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXWithExpressionAccess().getMainExpressionXExpressionParserRuleCall_2_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExpression_in_ruleXWithExpression10224);
                    lv_mainExpression_4_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXWithExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"mainExpression",
                              		lv_mainExpression_4_0, 
                              		"XExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4406:2: ( (lv_blockExpression_5_0= ruleXBlockExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4407:1: (lv_blockExpression_5_0= ruleXBlockExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4407:1: (lv_blockExpression_5_0= ruleXBlockExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4408:3: lv_blockExpression_5_0= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXWithExpressionAccess().getBlockExpressionXBlockExpressionParserRuleCall_2_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXBlockExpression_in_ruleXWithExpression10245);
                    lv_blockExpression_5_0=ruleXBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXWithExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"blockExpression",
                              		lv_blockExpression_5_0, 
                              		"XBlockExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4425:6: ( (lv_blockExpression_6_0= ruleXMustacheExpression ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4425:6: ( (lv_blockExpression_6_0= ruleXMustacheExpression ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4426:1: (lv_blockExpression_6_0= ruleXMustacheExpression )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4426:1: (lv_blockExpression_6_0= ruleXMustacheExpression )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4427:3: lv_blockExpression_6_0= ruleXMustacheExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXWithExpressionAccess().getBlockExpressionXMustacheExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXMustacheExpression_in_ruleXWithExpression10273);
                    lv_blockExpression_6_0=ruleXMustacheExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXWithExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"blockExpression",
                              		lv_blockExpression_6_0, 
                              		"XMustacheExpression");
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
    // $ANTLR end "ruleXWithExpression"


    // $ANTLR start "entryRuleJvmFormalParameterWithoutType"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4451:1: entryRuleJvmFormalParameterWithoutType returns [EObject current=null] : iv_ruleJvmFormalParameterWithoutType= ruleJvmFormalParameterWithoutType EOF ;
    public final EObject entryRuleJvmFormalParameterWithoutType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameterWithoutType = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4452:2: (iv_ruleJvmFormalParameterWithoutType= ruleJvmFormalParameterWithoutType EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4453:2: iv_ruleJvmFormalParameterWithoutType= ruleJvmFormalParameterWithoutType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmFormalParameterWithoutTypeRule()); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameterWithoutType_in_entryRuleJvmFormalParameterWithoutType10310);
            iv_ruleJvmFormalParameterWithoutType=ruleJvmFormalParameterWithoutType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameterWithoutType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameterWithoutType10320); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmFormalParameterWithoutType"


    // $ANTLR start "ruleJvmFormalParameterWithoutType"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4460:1: ruleJvmFormalParameterWithoutType returns [EObject current=null] : ( (lv_name_0_0= ruleValidID ) ) ;
    public final EObject ruleJvmFormalParameterWithoutType() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4463:28: ( ( (lv_name_0_0= ruleValidID ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4464:1: ( (lv_name_0_0= ruleValidID ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4464:1: ( (lv_name_0_0= ruleValidID ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4465:1: (lv_name_0_0= ruleValidID )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4465:1: (lv_name_0_0= ruleValidID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4466:3: lv_name_0_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmFormalParameterWithoutTypeAccess().getNameValidIDParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleJvmFormalParameterWithoutType10365);
            lv_name_0_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmFormalParameterWithoutTypeRule());
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
    // $ANTLR end "ruleJvmFormalParameterWithoutType"


    // $ANTLR start "entryRuleXMustacheExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4490:1: entryRuleXMustacheExpression returns [EObject current=null] : iv_ruleXMustacheExpression= ruleXMustacheExpression EOF ;
    public final EObject entryRuleXMustacheExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMustacheExpression = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4491:2: (iv_ruleXMustacheExpression= ruleXMustacheExpression EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4492:2: iv_ruleXMustacheExpression= ruleXMustacheExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMustacheExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleXMustacheExpression_in_entryRuleXMustacheExpression10400);
            iv_ruleXMustacheExpression=ruleXMustacheExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMustacheExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMustacheExpression10410); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXMustacheExpression"


    // $ANTLR start "ruleXMustacheExpression"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4499:1: ruleXMustacheExpression returns [EObject current=null] : ( () otherlv_1= ':{' ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )* otherlv_3= '}' ) ;
    public final EObject ruleXMustacheExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4502:28: ( ( () otherlv_1= ':{' ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )* otherlv_3= '}' ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4503:1: ( () otherlv_1= ':{' ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )* otherlv_3= '}' )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4503:1: ( () otherlv_1= ':{' ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )* otherlv_3= '}' )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4503:2: () otherlv_1= ':{' ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )* otherlv_3= '}'
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4503:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4504:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXMustacheExpressionAccess().getXBlockExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,68,FOLLOW_68_in_ruleXMustacheExpression10456); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXMustacheExpressionAccess().getColonLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4513:1: ( (lv_expressions_2_0= ruleXExpressionInsideBlock ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( ((LA72_0>=RULE_INT && LA72_0<=RULE_ID)||LA72_0==12||(LA72_0>=16 && LA72_0<=17)||LA72_0==28||LA72_0==31||LA72_0==36||LA72_0==41||LA72_0==44||(LA72_0>=46 && LA72_0<=47)||(LA72_0>=50 && LA72_0<=52)||(LA72_0>=54 && LA72_0<=56)||(LA72_0>=58 && LA72_0<=65)||LA72_0==68) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4514:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4514:1: (lv_expressions_2_0= ruleXExpressionInsideBlock )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4515:3: lv_expressions_2_0= ruleXExpressionInsideBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXMustacheExpressionAccess().getExpressionsXExpressionInsideBlockParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_ruleXMustacheExpression10477);
            	    lv_expressions_2_0=ruleXExpressionInsideBlock();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXMustacheExpressionRule());
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
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleXMustacheExpression10490); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getXMustacheExpressionAccess().getRightCurlyBracketKeyword_3());
                  
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
    // $ANTLR end "ruleXMustacheExpression"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4543:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4544:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4545:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10527);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName10538); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4552:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4555:28: ( (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4556:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4556:1: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4557:5: this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName10585);
            this_ValidID_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ValidID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4567:1: ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==38) ) {
                    int LA73_2 = input.LA(2);

                    if ( (LA73_2==RULE_ID) ) {
                        int LA73_3 = input.LA(3);

                        if ( (synpred27_InternalXbaseWithAnnotations()) ) {
                            alt73=1;
                        }


                    }


                }


                switch (alt73) {
            	case 1 :
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4567:2: ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID
            	    {
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4567:2: ( ( '.' )=>kw= '.' )
            	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4567:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,38,FOLLOW_38_in_ruleQualifiedName10613); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName10636);
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
            	    break loop73;
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


    // $ANTLR start "entryRuleJvmTypeReference"
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4594:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4595:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4596:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference10683);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference10693); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4603:1: ruleJvmTypeReference returns [EObject current=null] : ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( () otherlv_2= '[' otherlv_3= ']' )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4606:28: ( ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( () otherlv_2= '[' otherlv_3= ']' )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4607:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( () otherlv_2= '[' otherlv_3= ']' )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4607:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( () otherlv_2= '[' otherlv_3= ']' )* ) | this_XFunctionTypeRef_4= ruleXFunctionTypeRef )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RULE_ID) ) {
                alt75=1;
            }
            else if ( (LA75_0==12||LA75_0==69) ) {
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4607:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( () otherlv_2= '[' otherlv_3= ']' )* )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4607:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( () otherlv_2= '[' otherlv_3= ']' )* )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4608:5: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( () otherlv_2= '[' otherlv_3= ']' )*
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference10741);
                    this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmParameterizedTypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4616:1: ( () otherlv_2= '[' otherlv_3= ']' )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==41) ) {
                            int LA74_2 = input.LA(2);

                            if ( (LA74_2==43) ) {
                                alt74=1;
                            }


                        }


                        switch (alt74) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4616:2: () otherlv_2= '[' otherlv_3= ']'
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4616:2: ()
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4617:5: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	              current = forceCreateModelElementAndSet(
                    	                  grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0(),
                    	                  current);
                    	          
                    	    }

                    	    }

                    	    otherlv_2=(Token)match(input,41,FOLLOW_41_in_ruleJvmTypeReference10762); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getJvmTypeReferenceAccess().getLeftSquareBracketKeyword_0_1_1());
                    	          
                    	    }
                    	    otherlv_3=(Token)match(input,43,FOLLOW_43_in_ruleJvmTypeReference10774); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmTypeReferenceAccess().getRightSquareBracketKeyword_0_1_2());
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop74;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4632:5: this_XFunctionTypeRef_4= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference10805);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4648:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4649:2: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4650:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFunctionTypeRefRule()); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef10840);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef10850); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4657:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
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
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4660:28: ( ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4661:1: ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4661:1: ( (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4661:2: (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4661:2: (otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')' )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==12) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4661:4: otherlv_0= '(' ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleXFunctionTypeRef10888); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4665:1: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4666:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4666:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4667:3: lv_paramTypes_1_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10909);
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

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4683:2: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==13) ) {
                            alt76=1;
                        }


                        switch (alt76) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4683:4: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                    	    {
                    	    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleXFunctionTypeRef10922); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4687:1: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4688:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4688:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4689:3: lv_paramTypes_3_0= ruleJvmTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10943);
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
                    	    break loop76;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleXFunctionTypeRef10957); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_3());
                          
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,69,FOLLOW_69_in_ruleXFunctionTypeRef10971); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4713:1: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4714:1: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4714:1: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4715:3: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10992);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4739:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4740:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4741:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference11028);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference11038); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4748:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4751:28: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4752:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4752:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4752:2: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4752:2: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4753:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4753:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4754:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference11086);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4767:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt79=2;
            alt79 = dfa79.predict(input);
            switch (alt79) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4767:3: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4767:3: ( ( '<' )=>otherlv_1= '<' )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4767:4: ( '<' )=>otherlv_1= '<'
                    {
                    otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleJvmParameterizedTypeReference11107); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
                          
                    }

                    }

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4772:2: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4773:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4773:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4774:3: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11129);
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

                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4790:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==13) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4790:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleJvmParameterizedTypeReference11142); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4794:1: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4795:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4795:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4796:3: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11163);
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
                    	    break loop78;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleJvmParameterizedTypeReference11177); if (state.failed) return current;
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4824:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4825:2: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4826:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference11215);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference11225); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4833:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4836:28: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4837:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4837:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_ID||LA80_0==12||LA80_0==69) ) {
                alt80=1;
            }
            else if ( (LA80_0==70) ) {
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4838:5: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference11272);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4848:5: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference11299);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4864:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4865:2: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4866:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference11334);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference11344); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4873:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4876:28: ( ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4877:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4877:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4877:2: () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4877:2: ()
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4878:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,70,FOLLOW_70_in_ruleJvmWildcardTypeReference11390); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4887:1: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt81=3;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==71) ) {
                alt81=1;
            }
            else if ( (LA81_0==56) ) {
                alt81=2;
            }
            switch (alt81) {
                case 1 :
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4887:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4887:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4888:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4888:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4889:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference11412);
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
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4906:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4906:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4907:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4907:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4908:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference11439);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4932:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4933:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4934:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound11477);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound11487); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4941:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4944:28: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4945:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4945:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4945:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,71,FOLLOW_71_in_ruleJvmUpperBound11524); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4949:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4950:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4950:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4951:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound11545);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4975:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4976:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4977:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded11581);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded11591); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4984:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4987:28: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4988:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4988:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4988:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,72,FOLLOW_72_in_ruleJvmUpperBoundAnded11628); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4992:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4993:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4993:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4994:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded11649);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5018:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5019:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5020:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound11685);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound11695); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5027:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5030:28: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5031:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5031:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5031:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,56,FOLLOW_56_in_ruleJvmLowerBound11732); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
                  
            }
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5035:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5036:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5036:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5037:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound11753);
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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5063:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5064:2: (iv_ruleValidID= ruleValidID EOF )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5065:2: iv_ruleValidID= ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID11792);
            iv_ruleValidID=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID11803); if (state.failed) return current;

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
    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5072:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5075:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:5076:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID11842); if (state.failed) return current;
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

    // $ANTLR start synpred1_InternalXbaseWithAnnotations
    public final void synpred1_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:105:4: ( '(' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:105:6: '('
        {
        match(input,12,FOLLOW_12_in_synpred1_InternalXbaseWithAnnotations167); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalXbaseWithAnnotations

    // $ANTLR start synpred2_InternalXbaseWithAnnotations
    public final void synpred2_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:648:3: ( ( () ( ( ruleOpMultiAssign ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:648:4: ( () ( ( ruleOpMultiAssign ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:648:4: ( () ( ( ruleOpMultiAssign ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:648:5: () ( ( ruleOpMultiAssign ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:648:5: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:649:1: 
        {
        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:649:2: ( ( ruleOpMultiAssign ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:650:1: ( ruleOpMultiAssign )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:650:1: ( ruleOpMultiAssign )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:651:3: ruleOpMultiAssign
        {
        pushFollow(FOLLOW_ruleOpMultiAssign_in_synpred2_InternalXbaseWithAnnotations1438);
        ruleOpMultiAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalXbaseWithAnnotations

    // $ANTLR start synpred3_InternalXbaseWithAnnotations
    public final void synpred3_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:776:3: ( ( () ( ( ruleOpOr ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:776:4: ( () ( ( ruleOpOr ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:776:4: ( () ( ( ruleOpOr ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:776:5: () ( ( ruleOpOr ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:776:5: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:777:1: 
        {
        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:777:2: ( ( ruleOpOr ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:778:1: ( ruleOpOr )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:778:1: ( ruleOpOr )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:779:3: ruleOpOr
        {
        pushFollow(FOLLOW_ruleOpOr_in_synpred3_InternalXbaseWithAnnotations1786);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalXbaseWithAnnotations

    // $ANTLR start synpred4_InternalXbaseWithAnnotations
    public final void synpred4_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:877:3: ( ( () ( ( ruleOpAnd ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:877:4: ( () ( ( ruleOpAnd ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:877:4: ( () ( ( ruleOpAnd ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:877:5: () ( ( ruleOpAnd ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:877:5: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:878:1: 
        {
        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:878:2: ( ( ruleOpAnd ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:879:1: ( ruleOpAnd )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:879:1: ( ruleOpAnd )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:880:3: ruleOpAnd
        {
        pushFollow(FOLLOW_ruleOpAnd_in_synpred4_InternalXbaseWithAnnotations2045);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalXbaseWithAnnotations

    // $ANTLR start synpred5_InternalXbaseWithAnnotations
    public final void synpred5_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:978:3: ( ( () ( ( ruleOpEquality ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:978:4: ( () ( ( ruleOpEquality ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:978:4: ( () ( ( ruleOpEquality ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:978:5: () ( ( ruleOpEquality ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:978:5: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:979:1: 
        {
        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:979:2: ( ( ruleOpEquality ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:980:1: ( ruleOpEquality )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:980:1: ( ruleOpEquality )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:981:3: ruleOpEquality
        {
        pushFollow(FOLLOW_ruleOpEquality_in_synpred5_InternalXbaseWithAnnotations2304);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred5_InternalXbaseWithAnnotations

    // $ANTLR start synpred6_InternalXbaseWithAnnotations
    public final void synpred6_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1086:4: ( ( () 'instanceof' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1086:5: ( () 'instanceof' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1086:5: ( () 'instanceof' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1086:6: () 'instanceof'
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1086:6: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1087:1: 
        {
        }

        match(input,24,FOLLOW_24_in_synpred6_InternalXbaseWithAnnotations2580); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalXbaseWithAnnotations

    // $ANTLR start synpred7_InternalXbaseWithAnnotations
    public final void synpred7_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1114:8: ( ( () ( ( ruleOpCompare ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1114:9: ( () ( ( ruleOpCompare ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1114:9: ( () ( ( ruleOpCompare ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1114:10: () ( ( ruleOpCompare ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1114:10: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1115:1: 
        {
        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1115:2: ( ( ruleOpCompare ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1116:1: ( ruleOpCompare )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1116:1: ( ruleOpCompare )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1117:3: ruleOpCompare
        {
        pushFollow(FOLLOW_ruleOpCompare_in_synpred7_InternalXbaseWithAnnotations2653);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalXbaseWithAnnotations

    // $ANTLR start synpred8_InternalXbaseWithAnnotations
    public final void synpred8_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1236:3: ( ( () ( ( ruleOpOther ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1236:4: ( () ( ( ruleOpOther ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1236:4: ( () ( ( ruleOpOther ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1236:5: () ( ( ruleOpOther ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1236:5: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1237:1: 
        {
        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1237:2: ( ( ruleOpOther ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1238:1: ( ruleOpOther )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1238:1: ( ruleOpOther )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1239:3: ruleOpOther
        {
        pushFollow(FOLLOW_ruleOpOther_in_synpred8_InternalXbaseWithAnnotations2972);
        ruleOpOther();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred8_InternalXbaseWithAnnotations

    // $ANTLR start synpred9_InternalXbaseWithAnnotations
    public final void synpred9_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1344:3: ( ( () ( ( ruleOpAdd ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1344:4: ( () ( ( ruleOpAdd ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1344:4: ( () ( ( ruleOpAdd ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1344:5: () ( ( ruleOpAdd ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1344:5: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1345:1: 
        {
        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1345:2: ( ( ruleOpAdd ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1346:1: ( ruleOpAdd )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1346:1: ( ruleOpAdd )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1347:3: ruleOpAdd
        {
        pushFollow(FOLLOW_ruleOpAdd_in_synpred9_InternalXbaseWithAnnotations3252);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalXbaseWithAnnotations

    // $ANTLR start synpred10_InternalXbaseWithAnnotations
    public final void synpred10_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1452:3: ( ( () ( ( ruleOpMulti ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1452:4: ( () ( ( ruleOpMulti ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1452:4: ( () ( ( ruleOpMulti ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1452:5: () ( ( ruleOpMulti ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1452:5: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1453:1: 
        {
        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1453:2: ( ( ruleOpMulti ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1454:1: ( ruleOpMulti )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1454:1: ( ruleOpMulti )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1455:3: ruleOpMulti
        {
        pushFollow(FOLLOW_ruleOpMulti_in_synpred10_InternalXbaseWithAnnotations3532);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred10_InternalXbaseWithAnnotations

    // $ANTLR start synpred11_InternalXbaseWithAnnotations
    public final void synpred11_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1685:3: ( ( () 'as' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1685:4: ( () 'as' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1685:4: ( () 'as' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1685:5: () 'as'
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1685:5: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1686:1: 
        {
        }

        match(input,37,FOLLOW_37_in_synpred11_InternalXbaseWithAnnotations4126); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred11_InternalXbaseWithAnnotations

    // $ANTLR start synpred12_InternalXbaseWithAnnotations
    public final void synpred12_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1745:4: ( ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1745:5: ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1745:5: ( () '.' ( ( ruleValidID ) ) ruleOpSingleAssign )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1745:6: () '.' ( ( ruleValidID ) ) ruleOpSingleAssign
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1745:6: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1746:1: 
        {
        }

        match(input,38,FOLLOW_38_in_synpred12_InternalXbaseWithAnnotations4280); if (state.failed) return ;
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1747:1: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1748:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1748:1: ( ruleValidID )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1749:3: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred12_InternalXbaseWithAnnotations4289);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        pushFollow(FOLLOW_ruleOpSingleAssign_in_synpred12_InternalXbaseWithAnnotations4295);
        ruleOpSingleAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred12_InternalXbaseWithAnnotations

    // $ANTLR start synpred13_InternalXbaseWithAnnotations
    public final void synpred13_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1803:8: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1803:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1803:9: ( () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1803:10: () ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1803:10: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1804:1: 
        {
        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1804:2: ( '.' | ( ( '?.' ) ) | ( ( '*.' ) ) )
        int alt82=3;
        switch ( input.LA(1) ) {
        case 38:
            {
            alt82=1;
            }
            break;
        case 39:
            {
            alt82=2;
            }
            break;
        case 40:
            {
            alt82=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 82, 0, input);

            throw nvae;
        }

        switch (alt82) {
            case 1 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1804:4: '.'
                {
                match(input,38,FOLLOW_38_in_synpred13_InternalXbaseWithAnnotations4398); if (state.failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1806:6: ( ( '?.' ) )
                {
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1806:6: ( ( '?.' ) )
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1807:1: ( '?.' )
                {
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1807:1: ( '?.' )
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1808:2: '?.'
                {
                match(input,39,FOLLOW_39_in_synpred13_InternalXbaseWithAnnotations4412); if (state.failed) return ;

                }


                }


                }
                break;
            case 3 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1813:6: ( ( '*.' ) )
                {
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1813:6: ( ( '*.' ) )
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1814:1: ( '*.' )
                {
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1814:1: ( '*.' )
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1815:2: '*.'
                {
                match(input,40,FOLLOW_40_in_synpred13_InternalXbaseWithAnnotations4432); if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred13_InternalXbaseWithAnnotations

    // $ANTLR start synpred14_InternalXbaseWithAnnotations
    public final void synpred14_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1924:4: ( ( '(' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1925:1: ( '(' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1925:1: ( '(' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1926:2: '('
        {
        match(input,12,FOLLOW_12_in_synpred14_InternalXbaseWithAnnotations4659); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred14_InternalXbaseWithAnnotations

    // $ANTLR start synpred15_InternalXbaseWithAnnotations
    public final void synpred15_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1945:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1945:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1945:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1945:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|'
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1945:6: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1946:1: 
        {
        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1946:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt84=2;
        int LA84_0 = input.LA(1);

        if ( (LA84_0==RULE_ID||LA84_0==12||LA84_0==69) ) {
            alt84=1;
        }
        switch (alt84) {
            case 1 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1946:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1946:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1947:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1947:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1948:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred15_InternalXbaseWithAnnotations4711);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1950:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop83:
                do {
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==13) ) {
                        alt83=1;
                    }


                    switch (alt83) {
                	case 1 :
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1950:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,13,FOLLOW_13_in_synpred15_InternalXbaseWithAnnotations4718); if (state.failed) return ;
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1951:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1952:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1952:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:1953:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred15_InternalXbaseWithAnnotations4725);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

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

        match(input,42,FOLLOW_42_in_synpred15_InternalXbaseWithAnnotations4735); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred15_InternalXbaseWithAnnotations

    // $ANTLR start synpred17_InternalXbaseWithAnnotations
    public final void synpred17_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2569:4: ( 'else' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2569:6: 'else'
        {
        match(input,45,FOLLOW_45_in_synpred17_InternalXbaseWithAnnotations6207); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_InternalXbaseWithAnnotations

    // $ANTLR start synpred18_InternalXbaseWithAnnotations
    public final void synpred18_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2623:2: ( ( ( ( ruleValidID ) ) ':' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2623:3: ( ( ( ruleValidID ) ) ':' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2623:3: ( ( ( ruleValidID ) ) ':' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2623:4: ( ( ruleValidID ) ) ':'
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2623:4: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2624:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2624:1: ( ruleValidID )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:2625:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred18_InternalXbaseWithAnnotations6347);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,47,FOLLOW_47_in_synpred18_InternalXbaseWithAnnotations6353); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred18_InternalXbaseWithAnnotations

    // $ANTLR start synpred19_InternalXbaseWithAnnotations
    public final void synpred19_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3236:4: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3236:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3236:5: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3236:6: ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3236:6: ( ( ruleJvmTypeReference ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3237:1: ( ruleJvmTypeReference )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3237:1: ( ruleJvmTypeReference )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3238:1: ruleJvmTypeReference
        {
        pushFollow(FOLLOW_ruleJvmTypeReference_in_synpred19_InternalXbaseWithAnnotations7655);
        ruleJvmTypeReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3240:2: ( ( ruleValidID ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3241:1: ( ruleValidID )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3241:1: ( ruleValidID )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3242:1: ruleValidID
        {
        pushFollow(FOLLOW_ruleValidID_in_synpred19_InternalXbaseWithAnnotations7664);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred19_InternalXbaseWithAnnotations

    // $ANTLR start synpred20_InternalXbaseWithAnnotations
    public final void synpred20_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3483:4: ( ( '(' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3484:1: ( '(' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3484:1: ( '(' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3485:2: '('
        {
        match(input,12,FOLLOW_12_in_synpred20_InternalXbaseWithAnnotations8113); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred20_InternalXbaseWithAnnotations

    // $ANTLR start synpred21_InternalXbaseWithAnnotations
    public final void synpred21_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3504:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3504:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3504:5: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3504:6: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|'
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3504:6: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3505:1: 
        {
        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3505:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt88=2;
        int LA88_0 = input.LA(1);

        if ( (LA88_0==RULE_ID||LA88_0==12||LA88_0==69) ) {
            alt88=1;
        }
        switch (alt88) {
            case 1 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3505:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3505:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3506:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3506:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3507:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred21_InternalXbaseWithAnnotations8165);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3509:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop87:
                do {
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==13) ) {
                        alt87=1;
                    }


                    switch (alt87) {
                	case 1 :
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3509:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,13,FOLLOW_13_in_synpred21_InternalXbaseWithAnnotations8172); if (state.failed) return ;
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3510:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3511:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3511:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3512:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred21_InternalXbaseWithAnnotations8179);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop87;
                    }
                } while (true);


                }
                break;

        }

        match(input,42,FOLLOW_42_in_synpred21_InternalXbaseWithAnnotations8189); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred21_InternalXbaseWithAnnotations

    // $ANTLR start synpred22_InternalXbaseWithAnnotations
    public final void synpred22_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3753:3: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3753:4: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3753:4: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3753:5: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|'
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3753:5: ()
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3754:1: 
        {
        }

        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3754:2: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt90=2;
        int LA90_0 = input.LA(1);

        if ( (LA90_0==RULE_ID||LA90_0==12||LA90_0==69) ) {
            alt90=1;
        }
        switch (alt90) {
            case 1 :
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3754:3: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3754:3: ( ( ruleJvmFormalParameter ) )
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3755:1: ( ruleJvmFormalParameter )
                {
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3755:1: ( ruleJvmFormalParameter )
                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3756:1: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred22_InternalXbaseWithAnnotations8760);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3758:2: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop89:
                do {
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==13) ) {
                        alt89=1;
                    }


                    switch (alt89) {
                	case 1 :
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3758:4: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,13,FOLLOW_13_in_synpred22_InternalXbaseWithAnnotations8767); if (state.failed) return ;
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3759:1: ( ( ruleJvmFormalParameter ) )
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3760:1: ( ruleJvmFormalParameter )
                	    {
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3760:1: ( ruleJvmFormalParameter )
                	    // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:3761:1: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred22_InternalXbaseWithAnnotations8774);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop89;
                    }
                } while (true);


                }
                break;

        }

        match(input,42,FOLLOW_42_in_synpred22_InternalXbaseWithAnnotations8784); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred22_InternalXbaseWithAnnotations

    // $ANTLR start synpred23_InternalXbaseWithAnnotations
    public final void synpred23_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4129:2: ( ( ruleXExpression ) )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4130:1: ( ruleXExpression )
        {
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4130:1: ( ruleXExpression )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4131:1: ruleXExpression
        {
        pushFollow(FOLLOW_ruleXExpression_in_synpred23_InternalXbaseWithAnnotations9665);
        ruleXExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred23_InternalXbaseWithAnnotations

    // $ANTLR start synpred24_InternalXbaseWithAnnotations
    public final void synpred24_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4200:5: ( 'catch' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4200:7: 'catch'
        {
        match(input,67,FOLLOW_67_in_synpred24_InternalXbaseWithAnnotations9810); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_InternalXbaseWithAnnotations

    // $ANTLR start synpred25_InternalXbaseWithAnnotations
    public final void synpred25_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4219:5: ( 'finally' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4219:7: 'finally'
        {
        match(input,66,FOLLOW_66_in_synpred25_InternalXbaseWithAnnotations9840); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_InternalXbaseWithAnnotations

    // $ANTLR start synpred27_InternalXbaseWithAnnotations
    public final void synpred27_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4567:3: ( '.' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4568:2: '.'
        {
        match(input,38,FOLLOW_38_in_synpred27_InternalXbaseWithAnnotations10604); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_InternalXbaseWithAnnotations

    // $ANTLR start synpred28_InternalXbaseWithAnnotations
    public final void synpred28_InternalXbaseWithAnnotations_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4767:4: ( '<' )
        // ../org.eclipse.xtext.xbase/src-gen/org/eclipse/xtext/xbase/annotations/parser/antlr/internal/InternalXbaseWithAnnotations.g:4767:6: '<'
        {
        match(input,28,FOLLOW_28_in_synpred28_InternalXbaseWithAnnotations11099); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_InternalXbaseWithAnnotations

    // Delegated rules

    public final boolean synpred21_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalXbaseWithAnnotations_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalXbaseWithAnnotations() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalXbaseWithAnnotations_fragment(); // can never throw exception
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
    protected DFA58 dfa58 = new DFA58(this);
    protected DFA57 dfa57 = new DFA57(this);
    protected DFA64 dfa64 = new DFA64(this);
    protected DFA66 dfa66 = new DFA66(this);
    protected DFA79 dfa79 = new DFA79(this);
    static final String DFA30_eotS =
        "\75\uffff";
    static final String DFA30_eofS =
        "\1\2\74\uffff";
    static final String DFA30_minS =
        "\1\4\1\0\73\uffff";
    static final String DFA30_maxS =
        "\1\105\1\0\73\uffff";
    static final String DFA30_acceptS =
        "\2\uffff\1\2\71\uffff\1\1";
    static final String DFA30_specialS =
        "\1\uffff\1\0\73\uffff}>";
    static final String[] DFA30_transitionS = {
            "\3\2\5\uffff\1\1\2\2\1\uffff\32\2\1\uffff\16\2\1\uffff\14\2",
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
            return "1924:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_16_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )? otherlv_21= ')' )?";
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
                        if ( (synpred14_InternalXbaseWithAnnotations()) ) {s = 60;}

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
        "\1\105\2\0\33\uffff";
    static final String DFA29_acceptS =
        "\3\uffff\2\1\1\2\27\uffff\1\3";
    static final String DFA29_specialS =
        "\1\0\1\1\1\2\33\uffff}>";
    static final String[] DFA29_transitionS = {
            "\2\5\1\1\5\uffff\1\2\1\uffff\1\35\1\uffff\2\5\12\uffff\1\5\2"+
            "\uffff\1\5\4\uffff\1\5\4\uffff\1\5\1\4\1\uffff\1\5\1\uffff\2"+
            "\5\2\uffff\3\5\3\uffff\1\5\1\uffff\10\5\2\uffff\1\5\1\3",
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
            return "1945:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_memberCallArguments_17_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_18_0= ruleXExpression ) ) (otherlv_19= ',' ( (lv_memberCallArguments_20_0= ruleXExpression ) ) )* ) )?";
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

                        else if ( (LA29_0==12) ) {s = 2;}

                        else if ( (LA29_0==69) && (synpred15_InternalXbaseWithAnnotations())) {s = 3;}

                        else if ( (LA29_0==42) && (synpred15_InternalXbaseWithAnnotations())) {s = 4;}

                        else if ( ((LA29_0>=RULE_INT && LA29_0<=RULE_STRING)||(LA29_0>=16 && LA29_0<=17)||LA29_0==28||LA29_0==31||LA29_0==36||LA29_0==41||LA29_0==44||(LA29_0>=46 && LA29_0<=47)||(LA29_0>=50 && LA29_0<=52)||LA29_0==56||(LA29_0>=58 && LA29_0<=65)||LA29_0==68) ) {s = 5;}

                        else if ( (LA29_0==14) ) {s = 29;}

                         
                        input.seek(index29_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA29_1 = input.LA(1);

                         
                        int index29_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalXbaseWithAnnotations()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index29_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA29_2 = input.LA(1);

                         
                        int index29_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalXbaseWithAnnotations()) ) {s = 4;}

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
    static final String DFA58_eotS =
        "\75\uffff";
    static final String DFA58_eofS =
        "\1\2\74\uffff";
    static final String DFA58_minS =
        "\1\4\1\0\73\uffff";
    static final String DFA58_maxS =
        "\1\105\1\0\73\uffff";
    static final String DFA58_acceptS =
        "\2\uffff\1\2\71\uffff\1\1";
    static final String DFA58_specialS =
        "\1\uffff\1\0\73\uffff}>";
    static final String[] DFA58_transitionS = {
            "\3\2\5\uffff\1\1\2\2\1\uffff\32\2\1\uffff\16\2\1\uffff\14\2",
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
            ""
    };

    static final short[] DFA58_eot = DFA.unpackEncodedString(DFA58_eotS);
    static final short[] DFA58_eof = DFA.unpackEncodedString(DFA58_eofS);
    static final char[] DFA58_min = DFA.unpackEncodedStringToUnsignedChars(DFA58_minS);
    static final char[] DFA58_max = DFA.unpackEncodedStringToUnsignedChars(DFA58_maxS);
    static final short[] DFA58_accept = DFA.unpackEncodedString(DFA58_acceptS);
    static final short[] DFA58_special = DFA.unpackEncodedString(DFA58_specialS);
    static final short[][] DFA58_transition;

    static {
        int numStates = DFA58_transitionS.length;
        DFA58_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA58_transition[i] = DFA.unpackEncodedString(DFA58_transitionS[i]);
        }
    }

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = DFA58_eot;
            this.eof = DFA58_eof;
            this.min = DFA58_min;
            this.max = DFA58_max;
            this.accept = DFA58_accept;
            this.special = DFA58_special;
            this.transition = DFA58_transition;
        }
        public String getDescription() {
            return "3483:2: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA58_1 = input.LA(1);

                         
                        int index58_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index58_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 58, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA57_eotS =
        "\36\uffff";
    static final String DFA57_eofS =
        "\36\uffff";
    static final String DFA57_minS =
        "\1\4\2\0\33\uffff";
    static final String DFA57_maxS =
        "\1\105\2\0\33\uffff";
    static final String DFA57_acceptS =
        "\3\uffff\2\1\1\2\27\uffff\1\3";
    static final String DFA57_specialS =
        "\1\0\1\1\1\2\33\uffff}>";
    static final String[] DFA57_transitionS = {
            "\2\5\1\1\5\uffff\1\2\1\uffff\1\35\1\uffff\2\5\12\uffff\1\5\2"+
            "\uffff\1\5\4\uffff\1\5\4\uffff\1\5\1\4\1\uffff\1\5\1\uffff\2"+
            "\5\2\uffff\3\5\3\uffff\1\5\1\uffff\10\5\2\uffff\1\5\1\3",
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

    static final short[] DFA57_eot = DFA.unpackEncodedString(DFA57_eotS);
    static final short[] DFA57_eof = DFA.unpackEncodedString(DFA57_eofS);
    static final char[] DFA57_min = DFA.unpackEncodedStringToUnsignedChars(DFA57_minS);
    static final char[] DFA57_max = DFA.unpackEncodedStringToUnsignedChars(DFA57_maxS);
    static final short[] DFA57_accept = DFA.unpackEncodedString(DFA57_acceptS);
    static final short[] DFA57_special = DFA.unpackEncodedString(DFA57_specialS);
    static final short[][] DFA57_transition;

    static {
        int numStates = DFA57_transitionS.length;
        DFA57_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA57_transition[i] = DFA.unpackEncodedString(DFA57_transitionS[i]);
        }
    }

    class DFA57 extends DFA {

        public DFA57(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 57;
            this.eot = DFA57_eot;
            this.eof = DFA57_eof;
            this.min = DFA57_min;
            this.max = DFA57_max;
            this.accept = DFA57_accept;
            this.special = DFA57_special;
            this.transition = DFA57_transition;
        }
        public String getDescription() {
            return "3504:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_featureCallArguments_9_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_featureCallArguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA57_0 = input.LA(1);

                         
                        int index57_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA57_0==RULE_ID) ) {s = 1;}

                        else if ( (LA57_0==12) ) {s = 2;}

                        else if ( (LA57_0==69) && (synpred21_InternalXbaseWithAnnotations())) {s = 3;}

                        else if ( (LA57_0==42) && (synpred21_InternalXbaseWithAnnotations())) {s = 4;}

                        else if ( ((LA57_0>=RULE_INT && LA57_0<=RULE_STRING)||(LA57_0>=16 && LA57_0<=17)||LA57_0==28||LA57_0==31||LA57_0==36||LA57_0==41||LA57_0==44||(LA57_0>=46 && LA57_0<=47)||(LA57_0>=50 && LA57_0<=52)||LA57_0==56||(LA57_0>=58 && LA57_0<=65)||LA57_0==68) ) {s = 5;}

                        else if ( (LA57_0==14) ) {s = 29;}

                         
                        input.seek(index57_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA57_1 = input.LA(1);

                         
                        int index57_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalXbaseWithAnnotations()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index57_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA57_2 = input.LA(1);

                         
                        int index57_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalXbaseWithAnnotations()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index57_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 57, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA64_eotS =
        "\36\uffff";
    static final String DFA64_eofS =
        "\36\uffff";
    static final String DFA64_minS =
        "\1\4\2\0\33\uffff";
    static final String DFA64_maxS =
        "\1\105\2\0\33\uffff";
    static final String DFA64_acceptS =
        "\3\uffff\2\1\1\2\27\uffff\1\3";
    static final String DFA64_specialS =
        "\1\0\1\1\1\2\33\uffff}>";
    static final String[] DFA64_transitionS = {
            "\2\5\1\1\5\uffff\1\2\1\uffff\1\35\1\uffff\2\5\12\uffff\1\5\2"+
            "\uffff\1\5\4\uffff\1\5\4\uffff\1\5\1\4\1\uffff\1\5\1\uffff\2"+
            "\5\2\uffff\3\5\3\uffff\1\5\1\uffff\10\5\2\uffff\1\5\1\3",
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

    static final short[] DFA64_eot = DFA.unpackEncodedString(DFA64_eotS);
    static final short[] DFA64_eof = DFA.unpackEncodedString(DFA64_eofS);
    static final char[] DFA64_min = DFA.unpackEncodedStringToUnsignedChars(DFA64_minS);
    static final char[] DFA64_max = DFA.unpackEncodedStringToUnsignedChars(DFA64_maxS);
    static final short[] DFA64_accept = DFA.unpackEncodedString(DFA64_acceptS);
    static final short[] DFA64_special = DFA.unpackEncodedString(DFA64_specialS);
    static final short[][] DFA64_transition;

    static {
        int numStates = DFA64_transitionS.length;
        DFA64_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA64_transition[i] = DFA.unpackEncodedString(DFA64_transitionS[i]);
        }
    }

    class DFA64 extends DFA {

        public DFA64(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 64;
            this.eot = DFA64_eot;
            this.eof = DFA64_eof;
            this.min = DFA64_min;
            this.max = DFA64_max;
            this.accept = DFA64_accept;
            this.special = DFA64_special;
            this.transition = DFA64_transition;
        }
        public String getDescription() {
            return "3753:1: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? '|' ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA64_0 = input.LA(1);

                         
                        int index64_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA64_0==RULE_ID) ) {s = 1;}

                        else if ( (LA64_0==12) ) {s = 2;}

                        else if ( (LA64_0==69) && (synpred22_InternalXbaseWithAnnotations())) {s = 3;}

                        else if ( (LA64_0==42) && (synpred22_InternalXbaseWithAnnotations())) {s = 4;}

                        else if ( ((LA64_0>=RULE_INT && LA64_0<=RULE_STRING)||(LA64_0>=16 && LA64_0<=17)||LA64_0==28||LA64_0==31||LA64_0==36||LA64_0==41||LA64_0==44||(LA64_0>=46 && LA64_0<=47)||(LA64_0>=50 && LA64_0<=52)||LA64_0==56||(LA64_0>=58 && LA64_0<=65)||LA64_0==68) ) {s = 5;}

                        else if ( (LA64_0==14) ) {s = 29;}

                         
                        input.seek(index64_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA64_1 = input.LA(1);

                         
                        int index64_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalXbaseWithAnnotations()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index64_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA64_2 = input.LA(1);

                         
                        int index64_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalXbaseWithAnnotations()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index64_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 64, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA66_eotS =
        "\75\uffff";
    static final String DFA66_eofS =
        "\1\33\74\uffff";
    static final String DFA66_minS =
        "\1\4\32\0\42\uffff";
    static final String DFA66_maxS =
        "\1\105\32\0\42\uffff";
    static final String DFA66_acceptS =
        "\33\uffff\1\2\40\uffff\1\1";
    static final String DFA66_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31"+
        "\42\uffff}>";
    static final String[] DFA66_transitionS = {
            "\1\17\1\21\1\1\5\uffff\1\32\2\33\1\uffff\1\4\1\6\12\33\1\12"+
            "\2\33\1\3\4\33\1\2\4\33\1\14\1\uffff\1\33\1\23\1\33\1\7\1\10"+
            "\2\33\1\24\1\25\1\26\3\33\1\13\1\uffff\1\5\1\15\1\16\1\20\1"+
            "\22\1\27\1\30\1\31\2\33\1\11\1\33",
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
            return "4129:1: ( ( ( ruleXExpression ) )=> (lv_expression_2_0= ruleXExpression ) )?";
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
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA66_2 = input.LA(1);

                         
                        int index66_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA66_3 = input.LA(1);

                         
                        int index66_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA66_4 = input.LA(1);

                         
                        int index66_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA66_5 = input.LA(1);

                         
                        int index66_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA66_6 = input.LA(1);

                         
                        int index66_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA66_7 = input.LA(1);

                         
                        int index66_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA66_8 = input.LA(1);

                         
                        int index66_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA66_9 = input.LA(1);

                         
                        int index66_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA66_10 = input.LA(1);

                         
                        int index66_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA66_11 = input.LA(1);

                         
                        int index66_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA66_12 = input.LA(1);

                         
                        int index66_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA66_13 = input.LA(1);

                         
                        int index66_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA66_14 = input.LA(1);

                         
                        int index66_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA66_15 = input.LA(1);

                         
                        int index66_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA66_16 = input.LA(1);

                         
                        int index66_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA66_17 = input.LA(1);

                         
                        int index66_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA66_18 = input.LA(1);

                         
                        int index66_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA66_19 = input.LA(1);

                         
                        int index66_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA66_20 = input.LA(1);

                         
                        int index66_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA66_21 = input.LA(1);

                         
                        int index66_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA66_22 = input.LA(1);

                         
                        int index66_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA66_23 = input.LA(1);

                         
                        int index66_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA66_24 = input.LA(1);

                         
                        int index66_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA66_25 = input.LA(1);

                         
                        int index66_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA66_26 = input.LA(1);

                         
                        int index66_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index66_26);
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
    static final String DFA79_eotS =
        "\75\uffff";
    static final String DFA79_eofS =
        "\1\2\74\uffff";
    static final String DFA79_minS =
        "\1\4\1\0\73\uffff";
    static final String DFA79_maxS =
        "\1\105\1\0\73\uffff";
    static final String DFA79_acceptS =
        "\2\uffff\1\2\71\uffff\1\1";
    static final String DFA79_specialS =
        "\1\uffff\1\0\73\uffff}>";
    static final String[] DFA79_transitionS = {
            "\3\2\5\uffff\3\2\1\uffff\14\2\1\1\15\2\1\uffff\16\2\1\uffff"+
            "\14\2",
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
            ""
    };

    static final short[] DFA79_eot = DFA.unpackEncodedString(DFA79_eotS);
    static final short[] DFA79_eof = DFA.unpackEncodedString(DFA79_eofS);
    static final char[] DFA79_min = DFA.unpackEncodedStringToUnsignedChars(DFA79_minS);
    static final char[] DFA79_max = DFA.unpackEncodedStringToUnsignedChars(DFA79_maxS);
    static final short[] DFA79_accept = DFA.unpackEncodedString(DFA79_acceptS);
    static final short[] DFA79_special = DFA.unpackEncodedString(DFA79_specialS);
    static final short[][] DFA79_transition;

    static {
        int numStates = DFA79_transitionS.length;
        DFA79_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA79_transition[i] = DFA.unpackEncodedString(DFA79_transitionS[i]);
        }
    }

    class DFA79 extends DFA {

        public DFA79(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 79;
            this.eot = DFA79_eot;
            this.eof = DFA79_eof;
            this.min = DFA79_min;
            this.max = DFA79_max;
            this.accept = DFA79_accept;
            this.special = DFA79_special;
            this.transition = DFA79_transition;
        }
        public String getDescription() {
            return "4767:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA79_1 = input.LA(1);

                         
                        int index79_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_InternalXbaseWithAnnotations()) ) {s = 60;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index79_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 79, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleXAnnotation_in_entryRuleXAnnotation75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAnnotation85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleXAnnotation131 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXAnnotation154 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleXAnnotation175 = new BitSet(new long[]{0x5900000000025870L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValuePair_in_ruleXAnnotation199 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleXAnnotation212 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValuePair_in_ruleXAnnotation233 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotation263 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleXAnnotation277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValuePair_in_entryRuleXAnnotationElementValuePair315 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAnnotationElementValuePair325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXAnnotationElementValuePair373 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleXAnnotationElementValuePair385 = new BitSet(new long[]{0x5900000000021870L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotationElementValuePair406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValueStringConcatenation_in_entryRuleXAnnotationElementValueStringConcatenation442 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAnnotationElementValueStringConcatenation452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotationElementValueStringConcatenation499 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleXAnnotationElementValueStringConcatenation526 = new BitSet(new long[]{0x5900000000021870L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotationElementValueStringConcatenation560 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValue_in_entryRuleXAnnotationElementValue598 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAnnotationElementValue608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotation_in_ruleXAnnotationElementValue655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotationValueArray_in_ruleXAnnotationElementValue682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXAnnotationElementValue709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXAnnotationElementValue736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_ruleXAnnotationElementValue763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXAnnotationElementValue790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotationValueFieldReference_in_ruleXAnnotationElementValue817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleXAnnotationElementValue835 = new BitSet(new long[]{0x5900000000021870L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValueStringConcatenation_in_ruleXAnnotationElementValue857 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleXAnnotationElementValue868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotationValueFieldReference_in_entryRuleXAnnotationValueFieldReference905 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAnnotationValueFieldReference915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_ruleXAnnotationValueFieldReference972 = new BitSet(new long[]{0x0100000000000040L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_ruleXAnnotationValueFieldReference996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotationValueArray_in_entryRuleXAnnotationValueArray1032 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAnnotationValueArray1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleXAnnotationValueArray1088 = new BitSet(new long[]{0x5900000000021870L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotationValueArray1109 = new BitSet(new long[]{0x0000000000042000L});
    public static final BitSet FOLLOW_13_in_ruleXAnnotationValueArray1122 = new BitSet(new long[]{0x5900000000021870L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotationValueArray1143 = new BitSet(new long[]{0x0000000000042000L});
    public static final BitSet FOLLOW_18_in_ruleXAnnotationValueArray1157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_entryRuleXExpression1193 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpression1203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXExpression1249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_entryRuleXAssignment1283 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAssignment1293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXAssignment1351 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXAssignment1367 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment1417 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_ruleXAssignment1470 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment1493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign1533 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpSingleAssign1544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleOpSingleAssign1581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign1621 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMultiAssign1632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleOpMultiAssign1669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression1708 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOrExpression1718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression1765 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression1818 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression1841 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr1880 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr1891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleOpOr1928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression1967 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression1977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression2024 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression2077 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression2100 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd2139 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd2150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleOpAnd2187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression2226 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression2236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2283 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression2336 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression2359 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality2398 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality2409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleOpEquality2447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOpEquality2466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression2506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRelationalExpression2516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2563 = new BitSet(new long[]{0x000000001F000002L});
    public static final BitSet FOLLOW_24_in_ruleXRelationalExpression2599 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXRelationalExpression2624 = new BitSet(new long[]{0x000000001F000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression2685 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression2708 = new BitSet(new long[]{0x000000001F000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare2748 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare2759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOpCompare2797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleOpCompare2816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleOpCompare2835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpCompare2854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression2894 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOtherOperatorExpression2904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression2951 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression3004 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression3027 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther3066 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther3077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleOpOther3115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpOther3134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression3174 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression3184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3231 = new BitSet(new long[]{0x0000000080010002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression3284 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression3307 = new BitSet(new long[]{0x0000000080010002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd3346 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd3357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleOpAdd3395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOpAdd3414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression3454 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression3464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3511 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression3564 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression3587 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti3626 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti3637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOpMulti3675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOpMulti3694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOpMulti3713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleOpMulti3732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation3772 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation3782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation3840 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation3890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary3926 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary3937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleOpUnary3975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOpUnary3994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleOpUnary4013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression4053 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCastedExpression4063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression4110 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleXCastedExpression4145 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression4168 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall4206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMemberFeatureCall4216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall4263 = new BitSet(new long[]{0x000001C000000002L});
    public static final BitSet FOLLOW_38_in_ruleXMemberFeatureCall4312 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4335 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall4351 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall4373 = new BitSet(new long[]{0x000001C000000002L});
    public static final BitSet FOLLOW_38_in_ruleXMemberFeatureCall4459 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_39_in_ruleXMemberFeatureCall4483 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_40_in_ruleXMemberFeatureCall4520 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_28_in_ruleXMemberFeatureCall4549 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4570 = new BitSet(new long[]{0x0000000008002000L});
    public static final BitSet FOLLOW_13_in_ruleXMemberFeatureCall4583 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall4604 = new BitSet(new long[]{0x0000000008002000L});
    public static final BitSet FOLLOW_27_in_ruleXMemberFeatureCall4618 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXMemberFeatureCall4643 = new BitSet(new long[]{0x000001C000001002L});
    public static final BitSet FOLLOW_12_in_ruleXMemberFeatureCall4677 = new BitSet(new long[]{0xFD1CD61090035070L,0x0000000000000033L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall4752 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4780 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleXMemberFeatureCall4793 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall4814 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_ruleXMemberFeatureCall4831 = new BitSet(new long[]{0x000001C000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression4872 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression4882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression4929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression4956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression4983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWithExpression_in_ruleXPrimaryExpression5010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression5037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression5064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression5091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression5118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression5145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression5172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression5199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression5226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression5253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression5280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_entryRuleXLiteral5315 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXLiteral5325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXLiteral5372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral5399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_ruleXLiteral5426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXLiteral5453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXLiteral5480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXLiteral5507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure5542 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure5552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleXClosure5598 = new BitSet(new long[]{0x0000040000001040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5620 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_13_in_ruleXClosure5633 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure5654 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_42_in_ruleXClosure5670 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXClosure5691 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleXClosure5703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure5739 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXShortClosure5749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5847 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_13_in_ruleXShortClosure5860 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure5881 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_42_in_ruleXShortClosure5897 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXShortClosure5920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression5956 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression5966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleXParenthesizedExpression6003 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression6025 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleXParenthesizedExpression6036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression6072 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIfExpression6082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleXIfExpression6128 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleXIfExpression6140 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6161 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleXIfExpression6173 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6194 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleXIfExpression6215 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression6237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression6275 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSwitchExpression6285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleXSwitchExpression6331 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXSwitchExpression6372 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXSwitchExpression6384 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6408 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleXSwitchExpression6420 = new BitSet(new long[]{0x0002800000001040L,0x0000000000000030L});
    public static final BitSet FOLLOW_ruleXCasePart_in_ruleXSwitchExpression6441 = new BitSet(new long[]{0x0003800000041040L,0x0000000000000030L});
    public static final BitSet FOLLOW_48_in_ruleXSwitchExpression6455 = new BitSet(new long[]{0x0000800000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_47_in_ruleXSwitchExpression6469 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression6490 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ruleXMustacheExpression_in_ruleXSwitchExpression6518 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleXSwitchExpression6533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart6569 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart6579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCasePart6625 = new BitSet(new long[]{0x0002800000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_49_in_ruleXCasePart6639 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6660 = new BitSet(new long[]{0x0000800000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_47_in_ruleXCasePart6676 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart6697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMustacheExpression_in_ruleXCasePart6725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression6762 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXForLoopExpression6772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleXForLoopExpression6818 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleXForLoopExpression6830 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression6851 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleXForLoopExpression6863 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression6884 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleXForLoopExpression6896 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression6917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression6953 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWhileExpression6963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleXWhileExpression7009 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleXWhileExpression7021 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression7042 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleXWhileExpression7054 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression7075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression7111 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXDoWhileExpression7121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleXDoWhileExpression7167 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7188 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleXDoWhileExpression7200 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleXDoWhileExpression7212 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression7233 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleXDoWhileExpression7245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression7281 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBlockExpression7291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleXBlockExpression7337 = new BitSet(new long[]{0xFDDCD21090071070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression7359 = new BitSet(new long[]{0xFDFCD21090071070L,0x0000000000000013L});
    public static final BitSet FOLLOW_53_in_ruleXBlockExpression7372 = new BitSet(new long[]{0xFDDCD21090071070L,0x0000000000000013L});
    public static final BitSet FOLLOW_18_in_ruleXBlockExpression7388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock7424 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock7434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock7481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock7508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration7543 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXVariableDeclaration7553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleXVariableDeclaration7606 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000020L});
    public static final BitSet FOLLOW_55_in_ruleXVariableDeclaration7637 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration7685 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration7706 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration7735 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleXVariableDeclaration7749 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXVariableDeclaration7770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter7808 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameter7818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter7864 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmFormalParameter7886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall7922 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall7932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall7989 = new BitSet(new long[]{0x0100000010000040L});
    public static final BitSet FOLLOW_28_in_ruleXFeatureCall8003 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8024 = new BitSet(new long[]{0x0000000008002000L});
    public static final BitSet FOLLOW_13_in_ruleXFeatureCall8037 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall8058 = new BitSet(new long[]{0x0000000008002000L});
    public static final BitSet FOLLOW_27_in_ruleXFeatureCall8072 = new BitSet(new long[]{0x0100000000000040L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall8097 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleXFeatureCall8131 = new BitSet(new long[]{0xFD1CD61090035070L,0x0000000000000033L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXFeatureCall8206 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall8234 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleXFeatureCall8247 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall8268 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_ruleXFeatureCall8285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper8324 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdOrSuper8335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleIdOrSuper8382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleIdOrSuper8406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier8447 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStaticQualifier8458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleStaticQualifier8505 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ruleStaticQualifier8523 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall8564 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXConstructorCall8574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleXConstructorCall8620 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXConstructorCall8643 = new BitSet(new long[]{0x0000000010001000L});
    public static final BitSet FOLLOW_28_in_ruleXConstructorCall8656 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8677 = new BitSet(new long[]{0x0000000008002000L});
    public static final BitSet FOLLOW_13_in_ruleXConstructorCall8690 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall8711 = new BitSet(new long[]{0x0000000008002000L});
    public static final BitSet FOLLOW_27_in_ruleXConstructorCall8725 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleXConstructorCall8739 = new BitSet(new long[]{0xFD1CD61090035070L,0x0000000000000033L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXConstructorCall8801 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall8829 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleXConstructorCall8842 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall8863 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_ruleXConstructorCall8880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral8916 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral8926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleXBooleanLiteral8973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleXBooleanLiteral8997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral9047 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral9057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleXNullLiteral9103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIntLiteral_in_entryRuleXIntLiteral9139 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIntLiteral9149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleXIntLiteral9200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral9241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXStringLiteral9251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXStringLiteral9302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral9343 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral9353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleXTypeLiteral9399 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleXTypeLiteral9411 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral9434 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleXTypeLiteral9446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression9482 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXThrowExpression9492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleXThrowExpression9538 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXThrowExpression9559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression9595 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXReturnExpression9605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleXReturnExpression9651 = new BitSet(new long[]{0xFD1CD21090031072L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXReturnExpression9682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression9719 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression9729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleXTryCatchFinallyExpression9775 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9796 = new BitSet(new long[]{0x0000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression9826 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_66_in_ruleXTryCatchFinallyExpression9848 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleXTryCatchFinallyExpression9892 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression9913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause9951 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCatchClause9961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleXCatchClause10006 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleXCatchClause10019 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXCatchClause10040 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleXCatchClause10052 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCatchClause10073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWithExpression_in_entryRuleXWithExpression10109 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWithExpression10119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleXWithExpression10166 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleJvmFormalParameterWithoutType_in_ruleXWithExpression10187 = new BitSet(new long[]{0x0000800000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_47_in_ruleXWithExpression10203 = new BitSet(new long[]{0xFD1CD21090031070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWithExpression10224 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXWithExpression10245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMustacheExpression_in_ruleXWithExpression10273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameterWithoutType_in_entryRuleJvmFormalParameterWithoutType10310 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameterWithoutType10320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmFormalParameterWithoutType10365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMustacheExpression_in_entryRuleXMustacheExpression10400 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMustacheExpression10410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleXMustacheExpression10456 = new BitSet(new long[]{0xFDDCD21090071070L,0x0000000000000013L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXMustacheExpression10477 = new BitSet(new long[]{0xFDDCD21090071070L,0x0000000000000013L});
    public static final BitSet FOLLOW_18_in_ruleXMustacheExpression10490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10527 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName10538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName10585 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleQualifiedName10613 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName10636 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference10683 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference10693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference10741 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleJvmTypeReference10762 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleJvmTypeReference10774 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference10805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef10840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef10850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleXFunctionTypeRef10888 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10909 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleXFunctionTypeRef10922 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10943 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_ruleXFunctionTypeRef10957 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_ruleXFunctionTypeRef10971 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef10992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference11028 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference11038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference11086 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleJvmParameterizedTypeReference11107 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11129 = new BitSet(new long[]{0x0000000008002000L});
    public static final BitSet FOLLOW_13_in_ruleJvmParameterizedTypeReference11142 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000060L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference11163 = new BitSet(new long[]{0x0000000008002000L});
    public static final BitSet FOLLOW_27_in_ruleJvmParameterizedTypeReference11177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference11215 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference11225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference11272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference11299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference11334 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference11344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleJvmWildcardTypeReference11390 = new BitSet(new long[]{0x0100000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference11412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference11439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound11477 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound11487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleJvmUpperBound11524 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound11545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded11581 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded11591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleJvmUpperBoundAnded11628 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded11649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound11685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound11695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleJvmLowerBound11732 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound11753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID11792 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID11803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID11842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_synpred1_InternalXbaseWithAnnotations167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_synpred2_InternalXbaseWithAnnotations1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred3_InternalXbaseWithAnnotations1786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred4_InternalXbaseWithAnnotations2045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred5_InternalXbaseWithAnnotations2304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_synpred6_InternalXbaseWithAnnotations2580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred7_InternalXbaseWithAnnotations2653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred8_InternalXbaseWithAnnotations2972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred9_InternalXbaseWithAnnotations3252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred10_InternalXbaseWithAnnotations3532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_synpred11_InternalXbaseWithAnnotations4126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_synpred12_InternalXbaseWithAnnotations4280 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred12_InternalXbaseWithAnnotations4289 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_synpred12_InternalXbaseWithAnnotations4295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_synpred13_InternalXbaseWithAnnotations4398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_synpred13_InternalXbaseWithAnnotations4412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_synpred13_InternalXbaseWithAnnotations4432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_synpred14_InternalXbaseWithAnnotations4659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred15_InternalXbaseWithAnnotations4711 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_13_in_synpred15_InternalXbaseWithAnnotations4718 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred15_InternalXbaseWithAnnotations4725 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_42_in_synpred15_InternalXbaseWithAnnotations4735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred17_InternalXbaseWithAnnotations6207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred18_InternalXbaseWithAnnotations6347 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_synpred18_InternalXbaseWithAnnotations6353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_synpred19_InternalXbaseWithAnnotations7655 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred19_InternalXbaseWithAnnotations7664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_synpred20_InternalXbaseWithAnnotations8113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred21_InternalXbaseWithAnnotations8165 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_13_in_synpred21_InternalXbaseWithAnnotations8172 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred21_InternalXbaseWithAnnotations8179 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_42_in_synpred21_InternalXbaseWithAnnotations8189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred22_InternalXbaseWithAnnotations8760 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_13_in_synpred22_InternalXbaseWithAnnotations8767 = new BitSet(new long[]{0x0000000000001040L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred22_InternalXbaseWithAnnotations8774 = new BitSet(new long[]{0x0000040000002000L});
    public static final BitSet FOLLOW_42_in_synpred22_InternalXbaseWithAnnotations8784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred23_InternalXbaseWithAnnotations9665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_synpred24_InternalXbaseWithAnnotations9810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_synpred25_InternalXbaseWithAnnotations9840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_synpred27_InternalXbaseWithAnnotations10604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_synpred28_InternalXbaseWithAnnotations11099 = new BitSet(new long[]{0x0000000000000002L});

}